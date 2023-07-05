package article.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import article.service.ArticleData;
import article.service.ArticleNotFoundException;
import article.service.ModifyArticleService;
import article.service.ModifyRequest;
import article.service.PermissionDeniedException;
import article.service.ReadArticleService;
import auth.service.User;
import mvc.command.CommandHandler;

public class ModifyArticleHandler implements CommandHandler {
	private static final String FORM_VIEW = "/WEB-INF/view/modifyForm.jsp";

	private ReadArticleService readService = new ReadArticleService();
	private ModifyArticleService modifyService = new ModifyArticleService();

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

	private String processForm(HttpServletRequest req, HttpServletResponse res)
			throws IOException {
		
		// 작성자 본인인지 확인 
		try {
			String noVal = req.getParameter("no");
			int no = Integer.parseInt(noVal);
			ArticleData articleData = readService.getArticle(no, false); // 조회수 증가 x : 수정시 ! 
			User authUser = (User) req.getSession().getAttribute("authUser");
			if (!canModify(authUser, articleData)) { // 유저, 게시글 객체 
				res.sendError(HttpServletResponse.SC_FORBIDDEN);
				return null;
				// 1. 로그인한 id,name 세션 User (authUser) 가 같은지 물어봄 
				// 근데! 작성자와 접속자가 다르면 버튼 자체를 구현못하게 했는데 굳이 여기서 한 이유? 
				// 2. url에 modify.do 입력 -> 접속자는 글쓴 사람이 아닌데도 그 수정 페이지로 들어갈 수 있음 (웹 보안) 
				// 
			}
			
			// 실제 수정작업 
			// 수정요청이라는 DTO 객체 : 수정하려는 자성자, 제목, 내용으로 수정된 게시글 DTO 생성 
			ModifyRequest modReq = new ModifyRequest(authUser.getId(), no,
					articleData.getArticle().getTitle(),
					articleData.getContent());

			req.setAttribute("modReq", modReq);
			return FORM_VIEW;
		} catch (ArticleNotFoundException e) {
			res.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
	}

	private boolean canModify(User authUser, ArticleData articleData) {
		String writerId = articleData.getArticle().getWriter().getId();
		return authUser.getId().equals(writerId);
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		User authUser = (User) req.getSession().getAttribute("authUser");
		String noVal = req.getParameter("no");
		int no = Integer.parseInt(noVal);

		ModifyRequest modReq = new ModifyRequest(authUser.getId(), no,
				req.getParameter("title"),
				req.getParameter("content"));
		req.setAttribute("modReq", modReq);

		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);
		modReq.validate(errors);
		if (!errors.isEmpty()) {
			return FORM_VIEW;
		}
		try {
			modifyService.modify(modReq);
			return "/WEB-INF/view/modifySuccess.jsp";
		} catch (ArticleNotFoundException e) {
			res.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		} catch (PermissionDeniedException e) {
			res.sendError(HttpServletResponse.SC_FORBIDDEN);
			return null;
		}
	}
}
