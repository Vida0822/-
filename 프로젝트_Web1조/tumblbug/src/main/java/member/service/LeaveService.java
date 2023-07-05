package member.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.NamingException;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import member.dao.MemberDAO;
import member.model.Member;

public class LeaveService {

	private MemberDAO memberDao = new MemberDAO();
	
	public void leave(LeaveRequest leaveReq) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			 Member member = memberDao.selectById(conn, leaveReq.getEmail()); 
			 if ( !leaveReq.getPassword().equals( member.getM_password() ) ) {
				 JdbcUtil.rollback(conn);
				 throw new EmailPasswordNotMatchedException();
			 }
			 
			memberDao.delete(conn, leaveReq.getEmail());
			
			conn.commit();
		} catch (SQLException | NamingException e) {
			JdbcUtil.rollback(conn); // service의 주기능 : 잘못되면 전체 롤백 
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn);
		}
	}
	
}
