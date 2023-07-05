package project.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import member.model.Member;
import project.model.Category;
import project.model.DetailCategory;

public class DetailCategoryDAO {
	
	// 필드 
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	// 생성자 
	public DetailCategoryDAO() {
		super();		
	}
	
	public DetailCategoryDAO(Connection conn) { // 
		super();		
		this.conn = conn;
	}
	
	// 메서드 
	// select : 카테고리 전체 조회 
	public DetailCategory selectDefault(String ctg_code) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
		String sql = "SELECT * "
				+ "FROM DTL_CTG "
				+ "WHERE CTG_CODE = ? AND DTL_CTG_NAME='세부 카테고리를 선택해주세요'  ";
		
		pstmt =  conn.prepareStatement(sql);
		pstmt.setString(1,ctg_code);
		rs = pstmt.executeQuery();
		
		DetailCategory detailCategory = null;
		if (rs.next()) {
			detailCategory = new DetailCategory(						
					rs.getString("dtl_ctg_code"), 
					rs.getString("dtl_ctg_name"), 
					rs.getString("ctg_code")
					);
		}
		return detailCategory;
		
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		} // finally
	} // select()



	public DetailCategory selectByCd(Connection conn, String dtl_ctg_code) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
		String sql = "SELECT * "
				+ "FROM DTL_CTG "
				+ "WHERE DTL_CTG_CODE = ? ";
		
		pstmt =  conn.prepareStatement(sql);
		pstmt.setString(1,dtl_ctg_code);
		rs = pstmt.executeQuery();
		
		if (rs.next()) {
			DetailCategory detailCategory = new DetailCategory(						
					rs.getString("dtl_ctg_code"), 
					rs.getString("dtl_ctg_name"), 
					rs.getString("ctg_code")
					);
			return detailCategory;
		}// if
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		} // finally
		return null; // 만약 결과가 없는 경우 null을 반환
	} // selectByCd
	
	
	public DetailCategory selectByProCd(Connection conn, String pro_cd) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT d.* "
					+ "FROM PROJECT p JOIN DTL_CTG d ON p.dtl_ctg_code = d.dtl_ctg_code "
					+ "WHERE PRO_CD = ? ";
			
			pstmt =  conn.prepareStatement(sql);
			pstmt.setString(1,pro_cd);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				DetailCategory detailCategory = new DetailCategory(						
						rs.getString("dtl_ctg_code"), 
						rs.getString("dtl_ctg_name"), 
						rs.getString("ctg_code")
						);
				return detailCategory;
			}// if
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		} // finally
		return null; // 만약 결과가 없는 경우 null을 반환
	} // selectByCd
}
