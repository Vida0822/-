package days13.replyboard.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.NamingException;

import com.util.ConnectionProvider;
import com.util.JdbcUtil;

import days13.replyboard.domain.ReplyBoardDTO;
import days13.replyboard.persistence.ReplyBoardDAO;

public class WriteService {

	// 1. 싱글톤
	private WriteService() {}
	private static WriteService instance = new WriteService();
	public static WriteService getInstance() {
		return instance;
	}

	public int write( ReplyBoardDTO dto ){
		//
		Connection con = null;
		int rowCount = 0;
		try {
			con = ConnectionProvider.getConnection();
			ReplyBoardDAO dao = ReplyBoardDAO.getInstance();

			con.setAutoCommit(false); // 트랜잭션 처리   커밋, 롤백 
			// 1. 먼저)  동일한 글그룹(REF)에서 부모순번(STEP) 보다 큰 것들의 STEP을 1증가
			// 답글 달때만 처리할 코딩.
			dao.updateRefStep( con, dto.getRef() , dto.getStep() -1 ); 
			// 두번째 매개변수로 부모의 step 값을 넣어줘야하기 때문에 1을 빼줌 

			// 2. 
			rowCount = dao.insert(con, dto);
			//
			con.commit();
		} catch (NamingException | SQLException e) {
			JdbcUtil.rollback(con);
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(con);
		}
		return rowCount;
	}

}
