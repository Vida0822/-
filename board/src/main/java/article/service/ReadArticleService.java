package article.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.NamingException;

import article.dao.ArticleContentDao;
import article.dao.ArticleDao;
import article.model.Article;
import article.model.ArticleContent;
import jdbc.connection.ConnectionProvider;

public class ReadArticleService {

	private ArticleDao articleDao = new ArticleDao();
	private ArticleContentDao contentDao = new ArticleContentDao();
	
	public ArticleData getArticle(int articleNum, boolean increaseReadCount) {
		try (Connection conn = ConnectionProvider.getConnection()){
			Article article = articleDao.selectById(conn, articleNum);
			if (article == null) { 
				// 화면엔 있어서 클릭해서 들어가려했는데 그 사이 게시글이 삭제되는 등 게시글이 없어질 수 도 있음 ex) 수정하려고 들어갔는데 조회수 up 이상함 -> 예외처리 
				throw new ArticleNotFoundException();
			}
			ArticleContent content = contentDao.selectById(conn, articleNum);
			if (content == null) {
				throw new ArticleContentNotFoundException();
			}
			if (increaseReadCount) {
				articleDao.increaseReadCount(conn, articleNum);
				// 왜 connection 객체를 조회수 증가시킬때마다 dao 함수안에 넣어줄까? 
				// 엥 이유 이해 못함
				// 서비스 딴에서 컨넥션 객체를 만들어줘서 트랜젝션 처리를 한번에 할 수 있음 -> 자동으로 try~resource 문에 의해 닫아줌
			}
			return new ArticleData(article, content);
		} catch (SQLException | NamingException e) {
			throw new RuntimeException(e);
		}
	}
}
