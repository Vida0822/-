package settings.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.NamingException;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import member.dao.MemberDAO;
import member.model.Member;

public class ModifyProfileService {

	private MemberDAO memberDao = new MemberDAO();
	
	public String updateProfile(String pname, String parameter, String email) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);

			String updateJson = memberDao.modifyProfile(conn, pname, parameter, email);				

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
	
	public String ChangePassword(String pname, String originalPW, String currentPW, String password, String confirmPW, String email) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);

			if ( !originalPW.equals(currentPW) ) {
				JdbcUtil.rollback(conn);
				throw new CurrentPasswordNotMatchedException();			
			}
			if ( !password.equals(confirmPW) ) {
				JdbcUtil.rollback(conn);
				throw new UpdatePasswordNotMatchedException();
			}
			
			String updateJson = memberDao.modifyProfile(conn, pname, password, email);		

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
	
} // class
