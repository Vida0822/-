package days02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.util.DBConn;

/**
 * @author Inhyuk
 * @date 2023. 4. 11.
 * @subject [ PreparedStatement ]
 * @content
 */
public class Ex06 {

	public static void main(String[] args) {
		// Ex03.java 복붙

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * "
					+ "FROM dept "
					+ "ORDER BY deptno ASC ";
		
		try {
			// 1.
			// 2.
			conn = DBConn.getConnection();
			// 3.
			// stmt = conn.createStatement();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql); // SELECT 실행하는 메서드 : executeQuery()
//			10	ACCOUNTING	NEW YORK <---- true rs.next();
//			20	RESEARCH	DALLAS 	 <---- true rs.next();
//			30	SALES	CHICAGO 	 <---- true rs.next();
//			40	OPERATIONS	BOSTON 	 <---- true rs.next();
//						 			 <---- false rs.next();
			// boolean rs.next();
			while (rs.next()) {
				int deptno = rs.getInt("deptno");
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");
				System.out.printf("%d\t%s\t%s\n", deptno, dname, loc);
			}//while
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// 4.
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}//main

}//class
