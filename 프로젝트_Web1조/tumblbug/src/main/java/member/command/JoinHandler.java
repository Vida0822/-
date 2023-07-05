package member.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.service.DuplicateIdException;
import member.service.JoinRequest;
import member.service.JoinService;
import mvc.command.CommandHandler;

public class JoinHandler implements CommandHandler {

	private static final String FORM_VIEW = "/WEB-INF/view/joinForm.jsp";
	private JoinService joinService = new JoinService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) {
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
		return FORM_VIEW; // 파일명 직접 써주는거 대신 걍 상수 써준거임 
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) {
		JoinRequest joinReq = new JoinRequest();
		joinReq.setName(req.getParameter("name"));
		joinReq.setEmail(req.getParameter("email"));
		joinReq.setConfirmEmail(req.getParameter("confirmEmail"));
		joinReq.setPassword(req.getParameter("password"));
		joinReq.setConfirmPassword(req.getParameter("confirmPassword"));
		
		// errors HashMap 생성 -> 에러체크 (유효송 검사 체크_server'v) 
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors); 
		// 이 errors 를 request 객체에 넣어줌 -> 포워딩된 joinForm.jsp 에서 얻어올 수 있음 
		
		joinReq.validate(errors); // 입력 잘못됐으면 errors map에 추가 
		
		if (!errors.isEmpty()) {
			return FORM_VIEW;
		} //if 
		
		// 회원가입 처리 - DB 
		try {
			joinService.join(joinReq);
			return "/index.jsp"; // 이거 포워딩 지워주고 메인페이지로 포워딩 코딩으로 바꿔줘야함
		} catch (DuplicateIdException e) {
			errors.put("duplicateId", Boolean.TRUE);
			System.out.println("이미 존재하는 계정입니다!");
			return FORM_VIEW;
		}
	} // processSubmit

} // JoinHandler
