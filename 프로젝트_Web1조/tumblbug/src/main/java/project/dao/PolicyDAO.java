package project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import project.model.Plan;
import project.model.Policy;

public class PolicyDAO {
		// 필드 
		private Connection conn;
		private PreparedStatement pstmt;
		private ResultSet rs;
		
		// 생성자 
		public PolicyDAO() {
			super();
		}
		
		public PolicyDAO(Connection conn) {
			this.conn=conn; 
		}
		
		// 메서드 
		public Policy selectByCd(Connection conn, String pro_cd) throws SQLException { 
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				String sql = "SELECT * "
						+ "FROM TAS "
						+  "WHERE pro_cd =? " ; 
				
				pstmt =  conn.prepareStatement(sql);
				pstmt.setString(1,pro_cd);
				rs = pstmt.executeQuery() ; 
				
				if(rs.next()) {
					Policy policy = new Policy(
							rs.getString("pro_cd"),
							rs.getString("tas_policy"), 
							rs.getString("tas_exc")
						) ; 
					return policy ; 
				} // if 
			}finally {
				JdbcUtil.close(rs);
				JdbcUtil.close(pstmt) ; 
			}// tryfinally 
			return null; 
		} // selectByCd
		
} // PolicyDAO
