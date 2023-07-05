package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import member.model.Member;
import project.model.DetailCategory;

public class MemberDAO {
	

	// insert (회원가입, 계정생성) 
	public void insert(Connection conn, Member mem) throws SQLException {
		try (PreparedStatement pstmt = 
				conn.prepareStatement("insert into member(M_CD, M_EMAIL, M_password, M_name, M_url, M_privacy, m_message, m_up, m_pro, m_liked, m_follow, m_mk) "
						+ " values('MEM'||SEQ_MEMBER.NEXTVAL,?,?,?, DBMS_RANDOM.STRING('L', 16), '1', '1', '1', '1', '1', '1', '0')")) {
			pstmt.setString(1, mem.getM_email());
			pstmt.setString(2, mem.getM_password());
			pstmt.setString(3, mem.getM_name());
			pstmt.executeUpdate();
		}
	} // insert
	
	
	// select (계정 정보조회) 
	public Member selectById(Connection conn, String email) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"select * from member where M_email = ?"); 
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			Member member = null;
			if (rs.next()) {
				member = new Member(
						rs.getString("m_cd"),
						rs.getString("m_email"), 
						rs.getString("m_password"), 
						rs.getString("m_tel"),
						rs.getString("m_name"),
						rs.getString("m_url"),
						rs.getString("m_intro"),
						rs.getString("idus_url"),
						rs.getString("web_url"),
						rs.getString("m_privacy"),
						rs.getString("m_message"),
						rs.getString("m_up"),
						rs.getString("m_pro"),
						rs.getString("m_liked"),
						rs.getString("m_follow"),
						rs.getString("m_mk")
						);
			}
			return member;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}//selectById

	
	public Member selectByCd(Connection conn, String m_cd) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
		String sql = "SELECT * "
				+ "FROM MEMBER "
				+ "WHERE m_cd = ? ";
		
		pstmt =  conn.prepareStatement(sql);
		pstmt.setString(1,m_cd);
		rs = pstmt.executeQuery();
		
		Member member = null;
		if (rs.next()) {
			member = new Member(						
					rs.getString("m_cd"), 
					rs.getString("m_email"), 
					rs.getString("m_password"),
					rs.getString("m_tel"), 
					rs.getString("m_name"), 
					rs.getString("m_url"), 
					rs.getString("m_intro"), 
					rs.getString("idus_url"), 
					rs.getString("web_url"), 
					rs.getString("m_privacy")
					);
		}
		return member;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		} // finally
	} // selectByCd
	
	// update (계정 정보 수정) 	
	public String modifyProfile(Connection conn, String pname, String parameter, String email) throws SQLException {
		String jsonResult = null;
		int rowCount = 0;
		
		String pnameReal = "";
		switch ( Integer.parseInt(pname) ) {
		case 1:
			pnameReal = "m_name";
			break;
		case 2:
			pnameReal = "m_url";
			break;
		case 3:
			pnameReal = "m_intro";
			break;
		case 4:
			pnameReal = "idus_url";
			break;
		case 5:
			pnameReal = "web_url";
			break;
		case 6:
			pnameReal = "m_privacy";
			break;
		case 7:
			pnameReal = "m_email";
			break;
		case 8:
			pnameReal = "m_password";
			break;
		case 9:
			pnameReal = "m_tel";
			break;
		case 10:
			pnameReal = "m_message";
			break;
		case 11:
			pnameReal = "m_up";
			break;
		case 12:
			pnameReal = "m_pro";
			break;
		case 13:
			pnameReal = "m_liked";
			break;
		case 14:
			pnameReal = "m_follow";
			break;
		case 15:
			pnameReal = "m_mk";
			break;
		}
		
		try(PreparedStatement pstmt = conn.prepareStatement("UPDATE member SET " + pnameReal + " = ? WHERE m_email = ? ")) {
			pstmt.setString(1, parameter);
			pstmt.setString(2, email);
						
			rowCount = pstmt.executeUpdate();
			
			jsonResult = String.format("{ \"result\":%d }", rowCount);
	        System.out.println("jsonResult" + jsonResult);
			
	        return jsonResult;
		}

	} // modifyProfile
	
	// delete (계정 삭제, 회원탈퇴)
	public void delete(Connection conn, String email) throws SQLException {
		try (PreparedStatement pstmt = conn.prepareStatement("DELETE member WHERE m_email = ?")) {
			pstmt.setString(1, email);
			pstmt.executeUpdate();
		}
	} // delete

}
	
	
	
	

