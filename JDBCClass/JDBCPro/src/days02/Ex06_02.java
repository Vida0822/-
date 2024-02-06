package days02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.util.DBConn;

/**
 * @author Inhyuk
 * @date 2023. 4. 11.
 * @subject PreparedStatement 사용해서 dept 테이블에 컬럼 추가 INSERT
 * @content
 */
public class Ex06_02 {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO dept (deptno, dname, loc)"
				+ "VALUES (SEQ_DEPT.NEXTVAL, ?, ?)";
		// 1 + 2
		conn = DBConn.getConnection();
		// 3
		String pdname = "QC"; // ?
		String ploc = "SEOUL"; // ?
		
		try {
			pstmt = conn.prepareStatement(sql);
			// java.sql.SQLException: 인덱스에서 누락된 IN 또는 OUT 매개변수:: 1
			// ?, ? 파라미터 2개 실행 전에 설정
			pstmt.setString(1, pdname);
			pstmt.setString(2, ploc);
			int rowCount = pstmt.executeUpdate();
			if (rowCount == 1) {
				System.out.println("부서 추가 성공");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close();
		}
		System.out.println("=end=");

	}//main

}//class
