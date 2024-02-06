package days05;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.util.DBConn;

/**
 * @author Inhyuk
 * @date 2023. 4. 14.
 * @subject 로그인 처리
 * @content
 */
public class Ex02 {

	public static void main(String[] args) {
		/*
		 * 1. 로그인 처리
		 * 	아이디 : [ kenik ]
		 * 	비밀번호 : [ 1234 ]
		 * 
		 * 	[로그인] [회원가입]
		 * 
		 * 2. up_logon
		 * 	회원테이블 = { 아이디(PK), 비밀번호 }
		 * 		emp    = {  empno(PK),  ename   }
		 * 
		 * 3. 로그인 성공 -> 0
		 * 	  로그인 실패
		 * 		ㄴ 아이디가 존재하지 않으면 -> 1
		 * 		ㄴ 비밀번호가 틀리면 		-> -1
		 * */

		Scanner scanner = new Scanner(System.in);
		System.out.print("> 로그인 ID, PWD 입력하세요 : ");

		int pid = scanner.nextInt(); // empno
		String ppwd = scanner.next(); // ename

		String sql = "{ call up_logon(?,?,?) }";
		Connection conn = null;
		CallableStatement cstmt = null;


		conn = DBConn.getConnection();
		
		// 7369 SMITH
		try {
			cstmt = conn.prepareCall(sql);
			// ?(IN), ?(IN), ?(OUT)
			cstmt.setInt(1, pid);
			cstmt.setString(2, ppwd);
			cstmt.registerOutParameter(3, oracle.jdbc.OracleTypes.INTEGER);
			cstmt.executeQuery();
			// Object -> Integer -> int
			int logoncheck = (int) cstmt.getObject(3); // 0, 1

			if (logoncheck == 0) {
				System.out.println("로그인 성공");
			} else if (logoncheck == 1) {
				System.out.println("로그인 실패 - ID가 존재하지 않습니다");
			} else { // logoncheck == -1
				System.out.println("로그인 실패 - PWD가 잘못되었습니다");
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
CREATE OR REPLACE PROCEDURE up_logon
(
    pid IN emp.empno%TYPE
    , ppassword IN emp.ename%TYPE
    , plogoncheck OUT NUMBER -- 0(성공), 1(ID X), -1(PWD X)
)
IS
    vpassword emp.ename%TYPE;
BEGIN
    SELECT COUNT(*) INTO plogoncheck
    FROM emp
    WHERE empno = pid;

    IF plogoncheck = 1 THEN -- ID 존재
        SELECT ename INTO vpassword
        FROM emp
        WHERE empno = pid;
        IF vpassword = ppassword THEN -- pwd 일치
            plogoncheck := 0;
        ELSE -- pwd 불일치
            plogoncheck := -1;
        END IF;
    ELSE -- ID 존재 X
        plogoncheck := 1; 
    END IF;
--EXCEPTION
END;
-- Procedure UP_LOGON이(가) 컴파일되었습니다.
 */