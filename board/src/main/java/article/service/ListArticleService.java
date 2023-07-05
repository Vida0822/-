package article.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import article.dao.ArticleDao;
import article.model.Article;
import jdbc.connection.ConnectionProvider;

public class ListArticleService {

	private ArticleDao articleDao = new ArticleDao();
	private int size = 10;

	public ArticlePage getArticlePage(int pageNum) {
		try (Connection conn = ConnectionProvider.getConnection()) {
			int total = articleDao.selectCount(conn);
			int begin =  (pageNum -1)*size +1  ;
			int end   = begin+ size -1 ;
			List<Article> content = articleDao.select(conn, begin, end);
			return new ArticlePage(total, pageNum, size, content);
		} catch (SQLException | NamingException e) {
			throw new RuntimeException(e);
		}
	}
}
