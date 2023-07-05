package days02;

import java.sql.SQLException;

import com.util.DataHandler;

/**
 * @author Inhyuk
 * @date 2023. 4. 11.
 * @subject
 * @content https://docs.oracle.com/cd/E17781_01/appdev.112/e18805/getconn.htm#TDPJD136
 */
public class Ex05 {

	public static void main(String[] args) {
		DataHandler datahandler = new DataHandler();
		datahandler.jdbcUrl = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		datahandler.userid = "scott";
		datahandler.password = "tiger";
		
		try {
			datahandler.getDBConnection();
			System.out.println(datahandler.conn);
			datahandler.conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}//main

}//class
