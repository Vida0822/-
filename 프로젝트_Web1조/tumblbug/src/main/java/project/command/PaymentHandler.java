package project.command;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.connection.ConnectionProvider;
import mvc.command.CommandHandler;
import project.dao.PaymentDAO;
import project.dao.ProjectDAO;
import project.model.Payment;
import project.model.Project;

public class PaymentHandler implements CommandHandler {
	private static final String FORM_VIEW = "/WEB-INF/view/project_planning.jsp";
	
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if (req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, res); // 폼 띄우는함수 
		} else if (req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, res); // db에 submit 하는 함수 
		} else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED); // get, post 방식 외 요청방식이 있는데 (안배웠지만) 그걸로 들어왔다면 !
			return null;
		}
	}// process

	public String processForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ArrayList<Payment> paymentList = null; 
		Connection conn =  ConnectionProvider.getConnection(); 
		PaymentDAO dao = new PaymentDAO(conn);
		
		try {
			paymentList = dao.select(conn);
		}catch (Exception e) {
			System.out.println("> PaymentHandler() Exception...");
		}
		conn.close(); // 커넥션 풀 반환 
		request.setAttribute("paymentList", paymentList);  
		return FORM_VIEW;
	} // processForm

	private String processSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception, SQLException {
		// update 쿼리 구현해줘야함 
		String pro_cd = request.getParameter("pro_cd"); 
		String pay_cd = request.getParameter("pay_cd"); 
		
		Connection conn =  ConnectionProvider.getConnection(); 
		ProjectDAO dao = new ProjectDAO(conn); 
		
		int rowCount = 0;
		
		try {
			rowCount = dao.update(conn, pay_cd, pro_cd );
		} catch (SQLException e) { 
			System.out.println("> PaymentHandler() Exception...");
			e.printStackTrace();
		}
		conn.close();
		return "/WEB-INF/view/managementForm.jsp";
	//	String referer = null;
	//	if( ( referer = (String) request.getSession().getAttribute("referer") ) != null ) location = referer;

	} // processSubmit

}
