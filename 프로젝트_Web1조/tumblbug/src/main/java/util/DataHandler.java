package util;

import java.sql.Connection;
import java.sql.SQLException;

import oracle.jdbc.pool.OracleDataSource;

public class DataHandler {
	
	public DataHandler() {
	
	}
	
	public String jdbcUrl = null;
	public String userid = null;
	public String password = null; 
	public Connection conn;
	
	public void getDBConnection() throws SQLException{
		// JDBC 4.0 - 우리 -> 버전따라 코드 달라질 수 있다
		// 데이터소스
		// DataSource ds 객체 생성 후
		// ds.getConnection() 메서드를 통해서 Connection 객체를 얻어올 수 있더라
		OracleDataSource ds;
		ds = new OracleDataSource();
		ds.setURL(jdbcUrl);
		conn=ds.getConnection(userid,password);

	}
	
} // class
