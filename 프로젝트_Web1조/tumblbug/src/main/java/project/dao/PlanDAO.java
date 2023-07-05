package project.dao;

import java.io.BufferedReader;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import oracle.sql.CLOB;
import project.model.Plan;

public class PlanDAO {
	// 필드 
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	// 생성자 
	public PlanDAO() {
		super();
	}
	
	public PlanDAO(Connection conn) {
		super();
	}
	
	// 메서드 
	public Plan selectByCd(Connection conn, String pro_cd) throws Exception { 
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT * "
					+ "FROM PROJECT_PLAN "
					+  "WHERE pro_cd =? " ; 
			
			pstmt =  conn.prepareStatement(sql);
			pstmt.setString(1,pro_cd);
			rs = pstmt.executeQuery() ; 
			
			if(rs.next()) {
				Plan plan = new Plan(
						rs.getString("pro_cd"),
						clobToString(rs.getClob("pp_intro")), 
						clobToString(rs.getClob("pp_budget")),
						clobToString(rs.getClob("pp_schd")),
						clobToString(rs.getClob("pp_tintro")),
						clobToString(rs.getClob("pp_gift"))
					) ; 
				return plan ; 
			} // if 
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt) ; 
		}// tryfinally 
		return null; 
	} // selectByCd
	
	
	 public static String clobToString(Clob clob) throws Exception {
	        StringBuffer s = new StringBuffer();
	        BufferedReader br = new BufferedReader(clob.getCharacterStream());
	        String ts = "";
	        while((ts = br.readLine()) != null) {
	               s.append(ts + "\n");
	        }
	        br.close();
	        return s.toString();
	 }
	
	
}
