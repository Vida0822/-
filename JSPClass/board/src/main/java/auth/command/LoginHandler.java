package auth.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.service.LoginFailException;
import auth.service.LoginService;
import auth.service.User;
import mvc.command.CommandHandler;

public class LoginHandler implements CommandHandler {

	private static final String FORM_VIEW = "/WEB-INF/view/loginForm.jsp";
	private LoginService loginService = new LoginService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) 
	throws Exception {
		if (req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, res);
		} else if (req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, res);
		} else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		return FORM_VIEW;
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) 
	throws Exception {
		// 입력값 얻어오기 
		String id = trim(req.getParameter("id"));
		String password = trim(req.getParameter("password"));
		
		// 입력값 유효성 검사 
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);

		if (id == null || id.isEmpty())
			errors.put("id", Boolean.TRUE);
		if (password == null || password.isEmpty())
			errors.put("password", Boolean.TRUE);

		if (!errors.isEmpty()) {
			return FORM_VIEW;
		}
		
		// db 작업 - login() -> select() /
		try {
			User user = loginService.login(id, password);
			req.getSession().setAttribute("authUser", user);
			
			String location = req.getContextPath() + "/index.jsp"; // 기본은 메인페이지 
			String referer = null;
			if( ( referer = (String) req.getSession().getAttribute("referer") ) != null ) location = referer;
			res.sendRedirect(location);
			return null;
		} catch (LoginFailException e) {
			errors.put("idOrPwNotMatch", Boolean.TRUE);
			return FORM_VIEW;
		}
	}

	// 입력했을 때 앞뒤 공백 들어가있는 경우도 있어서 잘라서 db 조회하고 비교해야함 
	private String trim(String str) { 
		return str == null ? null : str.trim();
	}
}
