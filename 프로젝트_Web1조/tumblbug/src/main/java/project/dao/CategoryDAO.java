package project.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.connection.ConnectionProvider;
import project.model.Category;

public class CategoryDAO {
	
	// 필드 
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	// 생성자 
	public CategoryDAO() {
		super();		
	}
	
	public CategoryDAO(Connection conn) { // 
		super();		
		this.conn = conn;
	}
	
	// select : 카테고리 전체 조회 
	public ArrayList<Category> select() throws SQLException {
		ArrayList<Category> list = null;
		Category dto = null;
		
		String ctg_code;
		String ctg_name;
		
		String sql = "SELECT * "
				+ "FROM ctg ";

		try {
			this.pstmt =  this.conn.prepareStatement(sql);
			this.rs =  this.pstmt.executeQuery();
	        
			if( rs.next() ) {
				list = new ArrayList<Category>();
				do {
					ctg_code =  rs.getString("ctg_code");
					ctg_name =  rs.getString("ctg_name");
					dto = new Category(ctg_code,ctg_name);
					list.add(dto);
				} while ( rs.next() );
			} // if
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		this.pstmt.close();
		this.rs.close();

		return list;
	} // select()


	// selectDefault : 
}
