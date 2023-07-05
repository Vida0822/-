package file.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import file.model.File;
import jdbc.JdbcUtil;
import member.model.Member;
import project.model.Project;

public class FileDAO {
	
	// 필드 
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	// 생성자 
	public FileDAO() {
		super();		
	}
	
	public FileDAO(Connection conn) { // 
		super();		
		this.conn = conn;
	}
	
	// 메서드 
		public File selectByProCd(Connection conn, String pro_cd) throws SQLException {
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
			String sql = "SELECT * "
					+ "FROM ATT_FILE "
					+ "WHERE pro_cd = ? AND af_rep = 1 ";
			
			pstmt =  conn.prepareStatement(sql);
			pstmt.setString(1,pro_cd);
			rs = pstmt.executeQuery();
			
			File file = null;
			if (rs.next()) {
				file = new File(						
						rs.getString("af_cd"), 
						rs.getString("AF_EX_NAME"), 
						rs.getString("af_sys_name"),
						rs.getString("af_path"), 
						rs.getString("af_type"), 
						rs.getString("af_rep"), 
						rs.getString("m_cd"), 
						rs.getString("cra_cd"), 
						rs.getString("tb_cd"), 
						rs.getString("cpst_cd"), 
						rs.getString("pro_cd"),
						rs.getString("review_cd")
						);
			}
			return file;
			} finally {
				JdbcUtil.close(rs);
				JdbcUtil.close(pstmt);
			} // finally
		}
		
		
		
		public ArrayList<File> selectAllByPro_cd(Connection conn, String pro_cd) throws SQLException {
			ArrayList<File> list = null;
			File dto = null;
			
			try {
				String sql = "SELECT * "
						+ "FROM ATT_FILE "
						+ "WHERE pro_cd = ? ";
				
				this.pstmt  =  conn.prepareStatement(sql);
				pstmt.setString(1,pro_cd);
				this.rs = pstmt.executeQuery();
				
				if (rs.next()) {
					list = new ArrayList<File>();
						do {
							dto = new File(						
								rs.getString("af_cd"), 
								rs.getString("AF_EX_NAME"), 
								rs.getString("af_sys_name"),
								rs.getString("af_path"), 
								rs.getString("af_type"), 
								rs.getString("af_rep"), 
								rs.getString("m_cd"), 
								rs.getString("cra_cd"), 
								rs.getString("tb_cd"), 
								rs.getString("cpst_cd"), 
								rs.getString("pro_cd"),
								rs.getString("review_cd")
								);
						list.add(dto) ; 
					}while(rs.next()) ; 
				} // if 
			} finally {
				JdbcUtil.close(rs);
				JdbcUtil.close(pstmt);
			} // finally
			return list;
		} // selectAllByPro_cd
		
		
	
	public File selectByMemCd(Connection conn, String m_cd) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT * "
					+ "FROM ATT_FILE "
					+ "WHERE m_cd = ? ";
			
			pstmt =  conn.prepareStatement(sql);
			pstmt.setString(1,m_cd);
			rs = pstmt.executeQuery();
			
			File file = null;
			if (rs.next()) {
				file = new File(						
						rs.getString("af_cd"), 
						rs.getString("af_ex_name"), 
						rs.getString("af_sys_name"),
						rs.getString("af_path"), 
						rs.getString("af_type"), 
						rs.getString("af_rep"), 
						rs.getString("m_cd"), 
						rs.getString("cra_cd"), 
						rs.getString("tb_cd"), 
						rs.getString("cpst_cd"), 
						rs.getString("pro_cd"),
						rs.getString("review_cd")
						);
			}
			return file;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		} // finally
	} // selectByProCd
	
	
	
}
