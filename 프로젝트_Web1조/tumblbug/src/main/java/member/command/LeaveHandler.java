package member.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.Member;
import member.service.EmailPasswordNotMatchedException;
import member.service.LeaveRequest;
import member.service.LeaveService;
import mvc.command.CommandHandler;

public class LeaveHandler implements CommandHandler {

	private static final String FORM_VIEW = "/WEB-INF/view/leaveForm.jsp";
	private LeaveService leaveService = new LeaveService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if (req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, res); // 폼 띄우는함수 
		} else if (req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, res); // db에 submit 하는 함수 
		} else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED); // get, post 방식 외 요청방식이 있는데 (안배웠지만) 그걸로 들어왔다면 !
			return null;
		}
	}

	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		return FORM_VIEW;
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws IOException {
		Member member = (Member)req.getSession().getAttribute("authUser");
		String email = member.getM_email();
		String password = req.getParameter("password");

		LeaveRequest leaveReq = new LeaveRequest(email, password);
		
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors); 
		
		leaveReq.validate(errors);
		
		if (!errors.isEmpty()) {
			return FORM_VIEW;
		} //if 
		
		// 회원탈퇴 처리 - DB 
		try {
			leaveService.leave(leaveReq);
			
			HttpSession session = req.getSession(false);
			if (session != null) {
				session.invalidate();
			}
			res.sendRedirect(req.getContextPath() + "/index.jsp?delete=success"); // 아예 메인으로, 로그인 창이 아니라
			return null;			
		} catch (EmailPasswordNotMatchedException e) {
			return FORM_VIEW;
		}
	}
	
}
