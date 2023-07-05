package days01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author Inhyuk
 * @date 2023. 4. 10.
 * @subject // Ex03_03.java dept 테이블 수정( UPDATE )
 * @content
 * 			수정, 삭제하기 전에 검색 작업 선행 필요
 * 			지역명 or 부서명 선택하고 검색 작업 후 수정
 */
public class Ex03_03 {

	public static void main(String[] args) {
		// 1. 검색 ArrayList<DeptDTO> 저장
		ArrayList<DeptDTO> list = searchDept();
		if (list == null) {
			System.out.println("검색 결과가 없다");
			return; // 프로그램 종료
		}
		
		// 검색 결과 출력
		int 검색결과개수 = list.size();
		System.out.println("검색결과개수 : " + 검색결과개수);
		Iterator<DeptDTO> ir = list.iterator();
		while (ir.hasNext()) {
			DeptDTO dto = ir.next();
			System.out.println(dto);
		}
		
		// 수정
		// 1. 수정할 부서번호 선택(입력)
		Scanner scanner = new Scanner(System.in);
		System.out.print("> 수정할 부서번호 입력 : "); // 50
		int deptno = scanner.nextInt();
		// 2. 수정할 부서명, 지역명 입력
		System.out.print("> 수정할 부서명, 지역명 입력 : "); // X Y
		String dname = scanner.next();
		String loc = scanner.next();
		
		// Ex03.java 복붙
		String className = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott";
		String password = "tiger";
		Connection conn = null;
		Statement stmt = null;
		
		String sql = String.format("UPDATE dept "
									+ "SET dname = '%s', loc = '%s' "
									+ "WHERE deptno = %d "
									, dname, loc, deptno);
		
		System.out.println(sql); // 출력 확인
		
		try {
			// 1.
			Class.forName(className);
			// 2.
			conn = DriverManager.getConnection(url, user, password);
			// 3.
			stmt = conn.createStatement();
			
			// stmt.executeQuery(sql); // SELECT문
			int rowCount = stmt.executeUpdate(sql); // INSERT, UPDATE, DELETE문
			
			if (rowCount == 1) {
				System.out.println("부서 수정 완료");
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

	private static ArrayList<DeptDTO> searchDept() {
		ArrayList<DeptDTO> list = null;
		
		int searchCondition; // 검색 조건 : 1(부서명), 2(지역명)
		String searchWord; // 검색어
		Scanner scanner = new Scanner(System.in);
		
		System.out.printf("> 검색조건, 검색어 입력하세요 : ");
		searchCondition = scanner.nextInt(); // 2
		searchWord = scanner.next(); // EOU
		
		// Ex03.java 복붙
		String className = "oracle.jdbc.driver.OracleDriver"; // OracleDriver import구문 복붙
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; // jdbc:oracle:driver_type:[username/password]@//host_name:port_number:SID
		String user = "scott";
		String password = "tiger";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * "
					+ "FROM dept ";
		if (searchCondition == 1) {
			sql += "WHERE REGEXP_LIKE( dname, '"+searchWord+"', 'i' ) ";
		} else { // 2
			sql += String.format("WHERE REGEXP_LIKE( loc, '%s', 'i' ) ", searchWord);	
		}
		sql += "ORDER BY deptno ASC ";
		
		// System.out.println( sql );
		
		
		try {
			// 1.
			Class.forName(className);
			// 2.
			conn = DriverManager.getConnection(url, user, password);
			// 3.
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql); // SELECT 실행하는 메서드 : executeQuery()
//			10	ACCOUNTING	NEW YORK <---- true rs.next();
//			20	RESEARCH	DALLAS 	 <---- true rs.next();
//			30	SALES	CHICAGO 	 <---- true rs.next();
//			40	OPERATIONS	BOSTON 	 <---- true rs.next();
//						 			 <---- false rs.next();
			// boolean rs.next();
			
			// rs.next(); 다음 레코드(행)이 있니? false -> 레코드(행) 없다
			// 다음 레코드로 이동을 시킨 후 있으면 true, 없으면 false를 반환하는 메서드
			if (rs.next()) {
				list = new ArrayList<DeptDTO>();
				int deptno;
				String dname, loc;
				DeptDTO dto;
				do {
					deptno = rs.getInt("deptno");
					dname = rs.getString("dname");
					loc = rs.getString("loc");
					
					dto = new DeptDTO(deptno, dname, loc);
					list.add(dto);					
				} while (rs.next());
				
			}//if
			
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
		
		return list;
	}

}//class
