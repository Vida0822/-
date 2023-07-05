package auth.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.NamingException;

import jdbc.connection.ConnectionProvider;
import member.dao.MemberDAO;
import member.model.Member;

public class LoginService {

	private MemberDAO memberDao = new MemberDAO();

	public Member login(String email, String password) {
		try (Connection conn = ConnectionProvider.getConnection()) {
			Member member = memberDao.selectById(conn, email);
			if (member == null) { // 해당 이메일로 계정조회했는데 없을 때 발생하는 에러
				throw new LoginFailException();
			}
			else if (!member.matchPassword(password)) { //해당 비밀번호가 매치되지않았을때 애러발생
				throw new pwFailException();
			}
			
			return member;
	//		return new User(member.getId(), member.getName());
		} catch (SQLException | NamingException e) {
			throw new RuntimeException(e);
		}
	}  // login
	/*
	public String idCheck(String id) {
		try (Connection conn = ConnectionProvider.getConnection()) {
	         String idCheckJson = memberDao.idCheck(conn, id); 
	         System.out.println("> LoginService.idCheck : idCheckJson = " + idCheckJson);
	         return idCheckJson;
	      } catch (SQLException | NamingException e) {
	         throw new RuntimeException(e);
	      } 
	}//idCheck
	*/
} // loginService
