package settings.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.NamingException;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import settings.dao.FileAttachmentDAO;

public class ProfilePictureService {

	private FileAttachmentDAO fileDao = new FileAttachmentDAO();
	
	public String updateProfile(String pname, String parameter, String email) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);

			String updateJson = fileDao.insertProfilePicture(conn, pname, parameter, email);				

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
	}
	
} // Service
