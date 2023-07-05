package project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.JdbcUtil;
import project.model.ItemSet;

public class ItemSetDAO {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
	public ItemSetDAO() {
		super();		
	}

	public ItemSetDAO(Connection conn) { // 
		super();		
		this.conn = conn;
	}
	
	// selectByGiftCd 
	public ArrayList<ItemSet> selectByGiftCd(Connection conn, String gift_cd) throws SQLException {
		
		ArrayList<ItemSet> list = null ; 
		ItemSet dto = null; 
		
		String sql ="SELECT item_set_cd, item_cnt, gift_cd, s.item_cd, item_name "
				+ "FROM item_set s "
				+ "LEFT JOIN item i ON s.item_cd = i.item_cd "
				+ "WHERE gift_cd = ? " ; 
		
		try {
			this.pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, gift_cd);
			this.rs =  this.pstmt.executeQuery();
			
			if(rs.next()) {
				list = new ArrayList<ItemSet>() ; 
				do {
					dto = new ItemSet(
							rs.getString("item_set_cd"),
							rs.getInt("item_cnt"),
							rs.getString("gift_cd"),
							rs.getString("item_cd"),
							rs.getString("item_name")
							) ; 
					list.add(dto); 
				} while (rs.next());
			} // if 
		}finally {
			 JdbcUtil.close(pstmt);
			 JdbcUtil.close(rs);
		}
		return list ; 
	} // selectByGiftCd
	
	

} // ItemSetDAO
