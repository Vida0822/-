package days02;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		ArrayList<EmpDTO> list = null;
		int searchCondition = 1;
		String searchWord = null;
		Scanner scanner = new Scanner(System.in);

		// 1. JDBC 드라이버 로딩 : Class.forName( String className )
		String className = "oracle.jdbc.driver.OracleDriver";
		Class.forName(className);

		// 2. Connection 객체 : DriverManager.getConnection()
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		// jdbc:oracle:driver_type:[username/password]@//host_name:port_number:SID
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott";
		String password = "tiger";
		conn = DriverManager.getConnection(url, user, password);

		// 3. CRUD
		System.out.print("> 검색조건, 검색어 입력 : ");
		searchCondition = scanner.nextInt();
		searchWord = scanner.next();
		String sql = "SELECT * "
				+ "FROM emp ";
		if (searchCondition == 1) {
//			sql += "WHERE ename LIKE '%UPPER("+ searchWord +")%'";		
			sql += "WHERE ename LIKE '%"+ searchWord.toUpperCase() +"%'";	
		} else if (searchCondition == 2) {
			sql += "WHERE job LIKE '%"+ searchWord.toUpperCase() +"%'";
		} else {
			sql += "WHERE deptno IN ("+ searchWord +")";
		}
		System.out.println(sql); // 쿼리 확인

		stmt = conn.createStatement(); // Statement 객체 생성
		rs = stmt.executeQuery(sql); // SELECT문

		if (rs.next()) {
			list = new ArrayList<EmpDTO>();
			
			do {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int mgr = rs.getInt("mgr");;
				Date hiredate = rs.getDate("hiredate"); // java.sql.Date
				double sal = rs.getDouble("sal");
				double comm = rs.getDouble("comm");
				int deptno = rs.getInt("deptno");
				EmpDTO dto = new EmpDTO(empno, ename, job, mgr, hiredate, sal, comm, deptno);
				list.add(dto);		
			} while (rs.next());

		}//if
		
		dispEmp( list );


		// 4.Connection 객체 닫기
		rs.close();
		stmt.close();
		conn.close();

	}//main

	private static void dispEmp(ArrayList<EmpDTO> list) {
		Iterator<EmpDTO> ir = list.iterator();
		while (ir.hasNext()) {
			EmpDTO dto = ir.next();
			System.out.println( dto );
		}
		
	}

}//class

/*
1-1. JDBC 설명하세요.                     

1-2. JDBC Driver 설명하세요. 

1-3. JDBC Driver [종류] 설명하세요. 

2. JDBC를 사용해서 DB에 연결( Connect ) 하는 순서에 대해 설명하세요.  

    1)  
    2)  
    3)  
    4)  

3. emp 테이블에서 
    사원을  이름(ename) 또는 잡(job) 또는 부서(deptno) 로 검색해서
    사원 정보를 출력하는 코딩을 하세요.
    조건 1 ) EmpDTO 선언
    조건 2 ) 검색 조건을 입력하세요 ? 
                   1 - 이름으로 검색
                   2 - 잡으로 검색
                   3 - 부서로 검색
   조건 3) ArrayList<EmpDTO> 를 사용해서 사원 결과를 저장.
   조건 4) 사원 정보를 출력하는 dispEmp(  ArrayList<EmpDTO> list ) 메서드를 
              선언해서 반복자(iterator)를 사용해서 출력.              
 */