package days02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.util.DBConn;

/**
 * @author Inhyuk
 * @date 2023. 4. 11.
 * @subject PreparedStatement dept 테이블 삭제(DELETE)
 * @content
 */
public class Ex06_04 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("> 삭제할 부서번호 입력 : ");
		int pdeptno = scanner.nextInt();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "DELETE FROM dept "
				+ "WHERE deptno = ? ";
		
		conn = DBConn.getConnection();
		int rowCount = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pdeptno);
			rowCount = pstmt.executeUpdate();
			
			if (rowCount == 1) {
				System.out.println("부서 삭제 완료");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			DBConn.close();
		}

	}//main

}//class
