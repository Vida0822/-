package days01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * @author Inhyuk
 * @date 2023. 4. 10.
 * @subject // Ex03_04.java dept 테이블 삭제( DELETE )
 * @content
 */
public class Ex03_04 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("> 삭제할 부서번호 입력 : "); // 50
		int deptno = scanner.nextInt();
		
		// Ex03.java 복붙
		String className = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott";
		String password = "tiger";
		Connection conn = null;
		Statement stmt = null;
		
		String sql = "DELETE FROM dept "
					+ "WHERE deptno = " + deptno;
		
		System.out.println(sql); // 출력 확인
		
		try {
			// 1.
			Class.forName(className);
			// 2.
			conn = DriverManager.getConnection(url, user, password);
			// 3.
			stmt = conn.createStatement();
			int rowCount = stmt.executeUpdate(sql);
			
			if (rowCount == 1) {
				System.out.println("부서 삭제 완료");
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// 4.
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}//main

}//class

/*
JDBC
JDBC Driver
자바 + DB 연동 순서
1)
2)
3)
4)
dept : s, i, u, d, 검색
emp : 검색, 조회(s) + EmpDTO + ArrayList<EmpDTO> 처리 + iterator [ Ex03_03.java ]
검색메서드()
조회메서드()
*/
