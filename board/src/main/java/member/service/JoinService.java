package member.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import javax.naming.NamingException;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import member.dao.MemberDao;
import member.model.Member;

public class JoinService {

	private MemberDao memberDao = new MemberDao();
	
	public void join(JoinRequest joinReq) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			// db insert 용 DTO를 만든거 (우린 그냥 하나로 해도 됨) 
			Member member = memberDao.selectById(conn, joinReq.getId());
			if (member != null) {
				JdbcUtil.rollback(conn);
				throw new DuplicateIdException();
			}
			
			// 존재하는 id가 아니면 INSET 
			memberDao.insert(conn, 
					new Member(
							joinReq.getId(), 
							joinReq.getName(), 
							joinReq.getPassword(), 
							new Date())
					);
			conn.commit();
		} catch (SQLException | NamingException e) {
			JdbcUtil.rollback(conn); // service의 주기능 : 잘못되면 전체 롤백 
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn);
		}
	}
}
