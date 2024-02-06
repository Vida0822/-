package days13.replyboard.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.util.ConnectionProvider;
import com.util.JdbcUtil;

import days13.replyboard.domain.ReplyBoardDTO;
import days13.replyboard.persistence.ReplyBoardDAO;

public class DeleteService {
	
	// 1. 싱글톤
	private DeleteService() {}
	private static DeleteService instance = new DeleteService();
	public static DeleteService getInstance() {
		return instance;
	}

	public int delete(int num, String pass){
		//
		Connection con = null;
		int rowCount = -1;
 		try {
			con = ConnectionProvider.getConnection();
			ReplyBoardDAO dao = ReplyBoardDAO.getInstance();
			
con.setAutoCommit(false);	
            // 입력받은 비밀번호와 원래 비밀번호가 맞으면 삭제를 함.
            String originalPass = dao.selectOne(con, num).getPass();
            if( originalPass.equals(pass) ) {
            	rowCount = dao.delete(con, num);
            }
con.commit();			
			return rowCount;
		} catch (NamingException | SQLException e) { 
JdbcUtil.rollback(con);			
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(con);
		}
	}
}

 

