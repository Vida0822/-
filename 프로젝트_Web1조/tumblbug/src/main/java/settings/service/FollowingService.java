package settings.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.JdbcUtil;
import settings.dao.FollowDAO;
import settings.model.FollowingList;

public class FollowingService {

	private FollowingService() {}   	
	private static FollowingService instance = null;  
	public static FollowingService getInstance() {   
		if( instance == null ) {
			instance = new FollowingService();
		}
		return instance;
	}
	
	public ArrayList<FollowingList> select(Connection conn, int currentPage, int numberPerPage, String follower){
		try {
			FollowDAO dao = new FollowDAO();
			ArrayList<FollowingList> list = null;
			list = dao.select(conn, currentPage, numberPerPage, follower);
			
			return list;
		} catch (SQLException e) { 
			//e.printStackTrace();  syso("ListService.select() 에러 : ")
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn);
		}
	}

	public int getTotal(Connection conn, String follower) {
		String sql = " SELECT COUNT(*) " 
  	   		   		   + " FROM follow "
  	   		   		   + " WHERE f_follower = ? "; 

		int total = 0;

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, follower);
			rs = pstmt.executeQuery();

			if( rs.next() ) {
				total = rs.getInt(1);
			}      
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				rs.close();			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
		return total;
	}
	
}
