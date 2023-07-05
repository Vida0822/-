package days05;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;

import com.util.DBConn;

/**
 * @author Inhyuk
 * @date 2023. 4. 14.
 * @subject 리플렉션( reflection )
 * @content - 반사, 반영, 상
 * 			- [ ResultSet ] 결과물에 대한 정보를 추출해서 사용할 수 있는 기술
 */
public class Ex03 {

	public static void main(String[] args) {
	
		String sql = "SELECT table_name "
				+ "FROM tabs "
				+ "ORDER BY table_name ASC ";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String tableName = null;

		conn = DBConn.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				tableName = rs.getString(1);
				System.out.printf("%s\n", tableName);
			}//while

		} catch (SQLException e) {
			e.printStackTrace(); // 에러 표시 필수
		} finally {
			try {
				rs.close();
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		// SCOTT이 소유한 테이블명의 목록을 조회 - 하나의 테이블명을 선정
		// 선택된 테이블을 조회
		Scanner scanner = new Scanner(System.in);
		System.out.print("> 테이블명을 입력하세요 : ");
		tableName = scanner.next(); // BONUS, CSTVSBOARD
		
		// java.sql.SQLSyntaxErrorException: ORA-00903: invalid table name
		// 테이블명 또는 컬럼명은 ?를 사용할 수 없다 ***
		sql = "SELECT * "
				+ "FROM " + tableName;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			// 출력
			// getMetaDate() : ResultSet으로부터 컬럼의 수, 자료형 등등 속성 정보를 얻어올 수 이쓴 객체를 반환하는 메서드
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			System.out.println("> 컬럼의 개수 : " + columnCount);
			// 컬럼 정보 출력 - ( 자료형, 컬럼명 )
			/*
			for (int i = 1; i <= columnCount; i++) {
				
				String columnName = rsmd.getColumnName(i);
				int columnType = rsmd.getColumnType(i);
				String columnTypeName = rsmd.getColumnTypeName(i);
				
				// NUMBER( p, s )
				int precision = rsmd.getPrecision(i);
				int scale = rsmd.getScale(i);
				
				System.out.printf("%s - %d - %s - %d,%d\n", columnName, columnType, columnTypeName, precision, scale);
			}//for
			*/
			System.out.println("-----------------------------------------");
			for (int i = 1; i <= columnCount; i++) {
			System.out.printf("%s\t", rsmd.getColumnName(i));	
			}
			System.out.println();
			System.out.println("-----------------------------------------");
			while (rs.next()) {
				for (int i = 1; i <= columnCount; i++) {
					int precision = rsmd.getPrecision(i);
					int scale = rsmd.getScale(i);
					int columnType = rsmd.getColumnType(i);
					if (columnType == 2 && scale == 0) { // 정수
						rs.getInt(i);	
						System.out.printf("%d\t", rs.getInt(i));
					} else if (columnType == 2 && scale != 0) { // 실수
						rs.getDouble(i);
						System.out.printf("%.2f\t", rs.getDouble(i));
					} else if (columnType == 12) { // 문자열
						rs.getString(i);
						System.out.printf("%s\t", rs.getString(i));
					} else if (columnType == 93) { // 날짜
						rs.getDate(i);
						System.out.printf("%tF\t", rs.getDate(i));
					}//if
				}//for
				System.out.println();
			}//while
			System.out.println("-----------------------------------------");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		DBConn.close();

		System.out.println("=end=");

	}//main

}//class
