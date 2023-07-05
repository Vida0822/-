package days02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import com.util.DBConn;

import days01.DeptDTO;

public class Coding {

	public static void main(String[] args) {
		Connection conn = null; 
		PreparedStatement pstmt = null; 
		ResultSet rs= null; 
		ArrayList<DeptDTO> list = null; 

		String sql = "SELECT * "
				+ "FROM dept "
				+ "ORDER BY deptno ASC "; 

		conn = DBConn.getConnection();

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			int deptno; 
			String dname, loc; 

			if (rs.next()) {
				list = new ArrayList<DeptDTO>();
				do {
					deptno = rs.getInt("deptno"); 
					dname = rs.getString("dname"); 
					loc = rs.getString("loc"); 
					DeptDTO dto = new DeptDTO(deptno, dname, loc);
				} while (rs.next());
			} // if 
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
				DBConn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}// finally 

		
		Iterator<DeptDTO> ir = list.iterator();
		while (ir.hasNext()) {
			DeptDTO dto =  ir.next();
			// <option value = "10"> ACCOUNTING</option>
		} // while 
			
	} // main 
}
