package settings.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FileAttachmentDAO {

	public String insertProfilePicture(Connection conn, String pname, String parameter, String email) throws SQLException {
		String jsonResult = null;
		int rowCount = 0;
		
		try(PreparedStatement pstmt = conn.prepareStatement("INSERT INTO att_file () VALUES ()")) {
			pstmt.setString(1, parameter);
			pstmt.setString(2, email);
			
			rowCount = pstmt.executeUpdate();
			
			jsonResult = String.format("{ \"result\":%d }", rowCount);
	        System.out.println("jsonResult" + jsonResult);
			
	        return jsonResult;
		}

	} // modifyProfile
	
} // DAO
