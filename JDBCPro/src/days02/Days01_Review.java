package days02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.util.Iterator;
import java.util.Scanner;

public class Days01_Review {

	public static void main(String[] args) {
		ArrayList<EmpDTO> list = searchEmp();
		
		if (list == null) {
			System.out.println("검색 결과가 없습니다");
			return;
		}
		
		dispEmp( list );

	}

	private static void dispEmp(ArrayList<EmpDTO> list) {
		Iterator<EmpDTO> ir = list.iterator();
		while (ir.hasNext()) {
			EmpDTO dto = ir.next();
			System.out.println(dto);
		}
	}

	private static ArrayList<EmpDTO> searchEmp() {
		ArrayList<EmpDTO> list = null;
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("> 검색조건과 검색어를 입력하세요 : ");
		int searchNum = scanner.nextInt();
		String searchWord = scanner.next();
		
		String sql = "SELECT * "
					+ "FROM emp ";
		if (searchNum == 1) {
			sql += "WHERE REGEXP_LIKE( ename, '"+searchWord+"', 'i') ";
		} else if (searchNum == 2) {
			sql += "WHERE REGEXP_LIKE( job, '"+searchWord+"', 'i') ";
		} else {
			sql += "WHERE REGEXP_LIKE( deptno, '"+searchWord+"', 'i') ";
		}
		sql += "ORDER BY empno ASC ";
		
		String className = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott";
		String password = "tiger";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName(className);
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if (rs.next()) {
				list = new ArrayList<EmpDTO>();
				int empno, mgr, deptno;
				double sal, comm;
				String  ename, job;
				Date hiredate;
				EmpDTO dto;
				do {
					empno = rs.getInt("empno");
					ename = rs.getString("ename");
					job = rs.getString("job");
					mgr = rs.getInt("mgr");
					hiredate = rs.getDate("hiredate");
					sal = rs.getInt("sal");
					comm = rs.getInt("comm");
					deptno = rs.getInt("deptno");
					
					dto = new EmpDTO(empno, ename, job, mgr, hiredate, sal, comm, deptno);
					list.add(dto);					
				} while (rs.next());
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		
		return list;
	}

}

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