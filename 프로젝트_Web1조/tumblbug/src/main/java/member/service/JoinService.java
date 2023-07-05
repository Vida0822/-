package member.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import javax.naming.NamingException;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import member.dao.MemberDAO;
import member.model.Member;

public class JoinService {

	private MemberDAO memberDao = new MemberDAO();
	
	public void join(JoinRequest joinReq) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			// 중복체크용 member 객체  
			 Member member = memberDao.selectById(conn, joinReq.getEmail()); 
			 if (member != null) {
				 JdbcUtil.rollback(conn); 
				 throw new  DuplicateIdException(); 
				 }
			 
			
			// 존재하는 id가 아니면 INSET 
			memberDao.insert(conn, 
					new Member(
							joinReq.getEmail(), 
							joinReq.getPassword(), 
							joinReq.getName() 
					));
			conn.commit();
		} catch (SQLException | NamingException e) {
			JdbcUtil.rollback(conn); // service의 주기능 : 잘못되면 전체 롤백 
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn);
		}
	}
}
