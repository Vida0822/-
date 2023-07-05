package settings.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.NamingException;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import settings.dao.FollowDAO;

public class FollowService {
	
	private FollowDAO followDao = new FollowDAO();
	
	public String followUpdate(String pname, String following, String follower) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);

			String updateJson = followDao.followModify(conn, pname, following, follower);

			conn.commit();
			
			return updateJson;
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} catch (NamingException e) {
			JdbcUtil.rollback(conn);
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn);
		}
		
		return null;
	} // addFollow
	
} // class
