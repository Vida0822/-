package days05;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.util.DBConn;

/**
 * @author Inhyuk
 * @date 2023. 4. 14.
 * @subject ID 중복체크
 * @content
 */
public class Ex01 {

	public static void main(String[] args) {
		// https://docs.oracle.com/cd/E17781_01/appdev.112/e18805/addfunc.htm#TDPJD211
		/*
		 * [ jQuery 사용해서 Ajax 처리 ]
		 * 1. UP_IDCHECK 저장 프로시저 생성
		 * 	회원가입
		 * 	이름
		 * 	아이디 : [ kenik ] [ 중복체크버튼 ]
		 * 	 사용가능합니다
		 *   이미 사용 중 입니다
		 *    
		 * 	주민번호
		 * 	주소
		 * 	연락처
		 * 	등등
		 * 
		 * 2. emp(회원) 테이블의 empno(아이디)를 회원아이디라고 가정하고
		 * */
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("> 중복체크할 ID(empno)를 입력하세요 : ");
		
		int pid = scanner.nextInt();
		
		String sql = "{ call up_idcheck(?,?) }";
		Connection conn = null;
		CallableStatement cstmt = null;
		
		
		conn = DBConn.getConnection();
		
		try {
			cstmt = conn.prepareCall(sql);
			// ?(IN), ?(OUT)
			cstmt.setInt(1, pid);
			cstmt.registerOutParameter(2, oracle.jdbc.OracleTypes.INTEGER);
			cstmt.executeQuery();
			// Object -> Integer -> int
			int idcheck = (int) cstmt.getObject(2); // 0, 1
			
			if (idcheck == 0) {
				System.out.println("사용 가능한 ID(empno)입니다");
			} else {
				System.out.println("이미 사용 중인 ID(empno)입니다");
			}
			
		} catch (SQLException e) {
			e.printStackTrace(); // 에러 표시 필수
		} finally {
			try {
				cstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		DBConn.close();
		
		System.out.println("=end=");

	}//main

}//class

/*
CREATE OR REPLACE PROCEDURE up_idcheck
(
    pid IN emp.empno%TYPE
    , pidcheck OUT NUMBER
)
IS
BEGIN
    SELECT COUNT(*) INTO pidcheck
    FROM emp
    WHERE empno = pid;
--EXCEPTION
END;
-- Procedure UP_IDCHECK이(가) 컴파일되었습니다.
*/
