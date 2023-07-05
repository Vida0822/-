package project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.JdbcUtil;
import project.model.Gift;
import project.model.Project;

public class GiftDAO {
	
	// 필드 
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	// 생성자 
	public GiftDAO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GiftDAO(Connection conn) {
		super();
		this.conn = conn; 
	}
	
	
	// 메서드 
	public ArrayList<Gift> selectList(Connection conn, Project project ) throws SQLException {
		ArrayList<Gift> list = null;
		Gift dto = null;
		
		try {
		String sql = "SELECT * "
				+ "FROM GIFT "
				+ "WHERE pro_cd=? ";
		
		this.pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, project.getPro_cd());
		this.rs =  this.pstmt.executeQuery();
		
		if( rs.next() ) {
			list = new ArrayList<Gift>() ; 
			do {
				dto = new Gift(
						rs.getString("gift_cd"), 
						rs.getString("gift_desc"), 
						rs.getInt("gift_amount"), 
						rs.getDate("gift_dlv"), 
						rs.getString("gift_status"), 
						rs.getInt("gift_min"), 
						rs.getString("pro_cd")
						) ; 
				list.add(dto); 
			}  while (rs.next());
		} // if 
		}finally {
			 JdbcUtil.close(pstmt);
			 JdbcUtil.close(rs);
		} // try finally 
		return list ; 
	} // selectList
	
	
	
	//public Gift selectByProCd(Connection conn, Project project) throws SQLException {
		
//	} // selectByProCd
	
	
}
