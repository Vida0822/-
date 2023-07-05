package settings.command;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.connection.ConnectionProvider;
import member.model.Member;
import mvc.command.CommandHandler;
import settings.model.FollowingList;
import settings.model.PageDTO;
import settings.service.FollowingService;

public class FollowingHandler implements CommandHandler {

	private static final String FORM_VIEW = "/WEB-INF/view/settings/followingForm.jsp";
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if (req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, res);
		} else if (req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, res);
		} else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

	private String processForm(HttpServletRequest request, HttpServletResponse response) throws NamingException, SQLException {
		int currentPage = 1; // 현재 페이지 번호
		int numberPerPage = 20; // 한 페이지에 출력할 게시글 수
		int numberOfPageBlock = 50;
		int total = 0; // 총 레코드수
		
		Member member = (Member)request.getSession().getAttribute("authUser");
		
		try {
			currentPage = Integer.parseInt( request.getParameter("currentpage") );
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Connection conn = ConnectionProvider.getConnection();
		
		FollowingService followingService = FollowingService.getInstance();
		ArrayList<FollowingList> list = followingService.select(conn, currentPage, numberPerPage, member.getM_cd());
		
		total = followingService.getTotal(conn, member.getM_cd());
		PageDTO pdto = new PageDTO(currentPage, numberPerPage, numberOfPageBlock, total);
		
		conn.close();
		
		// MessageListView.java : 
		request.setAttribute("list", list);
		request.setAttribute("pdto", pdto);
		
		return FORM_VIEW;
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		return null;
	}

} // class
