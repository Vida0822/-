package article.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.NamingException;

import article.dao.ArticleContentDao;
import article.dao.ArticleDao;
import article.model.Article;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;

public class ModifyArticleService {

	private ArticleDao articleDao = new ArticleDao();
	private ArticleContentDao contentDao = new ArticleContentDao();

	public void modify(ModifyRequest modReq) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			Article article = articleDao.selectById(conn, 
					modReq.getArticleNumber());
			if (article == null) {
				// 글번호로 글 조회했을 때 없으면! 예외발생 (수정할 글이 없는거니까) : 그 사이 삭제될 수 도 있고!
				throw new ArticleNotFoundException();
			}
			if (!canModify(modReq.getUserId(), article)) {
				// 작성자인지 체크 
				throw new PermissionDeniedException();
			}
			// 실제 수정 db 작업 
			// article 테이블 수정 
			articleDao.update(conn,  
					modReq.getArticleNumber(), modReq.getTitle());
			// article_content 테이블 수정 
			contentDao.update(conn, 
					modReq.getArticleNumber(), modReq.getContent());
			conn.commit();
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} catch (PermissionDeniedException e) {
			JdbcUtil.rollback(conn);
			throw e;
		} catch (NamingException e) { 
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn);
		}
	}

	private boolean canModify(String modfyingUserId, Article article) {
		return article.getWriter().getId().equals(modfyingUserId);
	}
}
