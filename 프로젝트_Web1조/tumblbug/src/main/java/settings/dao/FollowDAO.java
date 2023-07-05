package settings.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import settings.model.FollowingList;

public class FollowDAO {
		
	public ArrayList<FollowingList> select(Connection conn, int currentPage, int numberPerPage, String follwer) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<FollowingList> list = null;
		FollowingList dto = null;
		
		String m_cd;
		String m_name;
		String m_intro;
		int followCount;
			
		// BETWEEN ? AND ?
		int begin = ( currentPage - 1 ) * numberPerPage + 1;
		int end = begin + numberPerPage - 1;
		String sql = "SELECT * "
					   + "FROM( "
					   + "        SELECT ROWNUM no, t.* "
					   + "        FROM( "
					   + "                SELECT m.m_cd, m_name, TO_CHAR(m_intro) m_intro, COUNT(f_follower) followCount "
					   + "                FROM member m JOIN follow f ON m.m_cd = f.f_following "
					   + "                WHERE f_follower = ? "
					   + "                GROUP BY m_cd, f_follower, m_name, TO_CHAR(m_intro); "
					   + "                ORDER BY f_cd DESC "
					   + "             ) t "
					   + "     ) m "
					   + "WHERE m.no BETWEEN ? AND ?";
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, follwer);
		pstmt.setInt(2, begin);
		pstmt.setInt(3, end);
		rs = pstmt.executeQuery();
			
		if( rs.next() ) {
			list = new ArrayList<FollowingList>();
				
			do {
				m_cd = rs.getString("m_cd");
				m_name = rs.getString("m_name");
				m_intro = rs.getString("m_intro");
				followCount = rs.getInt("followCount");
					
				dto = new FollowingList(m_cd, m_name, m_intro, followCount);
				list.add( dto );
			} while ( rs.next() );
		} // if
			
		pstmt.close();
		rs.close();
			
		return list;
	} // select
	
	public String followModify(Connection conn, String pname, String following, String follower) throws SQLException {
		String jsonResult = null;
		int rowCount = 0;
		
		if ( pname.equals("1") ) {
			try(PreparedStatement pstmt = conn.prepareStatement("INSERT INTO follow VALUES ('FLW' || SEQ_FOLLOW.NEXTVAL, ?, ?)")) {
				pstmt.setString(1, following);
				pstmt.setString(2, follower);
				
				rowCount = pstmt.executeUpdate();
				
				jsonResult = String.format("{ \"result\":%d }", rowCount);
				System.out.println("jsonResult" + jsonResult);
				
				return jsonResult;
			} // add	
		} else if ( pname.equals("2") ) {
			try(PreparedStatement pstmt = conn.prepareStatement("DELETE follow WHERE f_following = ? AND f_follower = ?")) {
				pstmt.setString(1, following);
				pstmt.setString(2, follower);
				
				rowCount = pstmt.executeUpdate();
				
				jsonResult = String.format("{ \"result\":%d }", rowCount);
		        System.out.println("jsonResult" + jsonResult);
				
		        return jsonResult;
			}
		} // delete
		
		return null;
		
	} // followModify
	
} // class
