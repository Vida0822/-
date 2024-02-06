package days02;

import java.sql.Connection;

import com.util.DBConn;

public class Ex02 {

	public static void main(String[] args) {
		// com.util.DBConn.java
		//	ㄴ getConnection() 메서드 구현
		Connection conn = DBConn.getConnection();
		System.out.println(conn);
		DBConn.close();
		
		// Ex01.java 복붙 -> Ex01_02

	}

}
