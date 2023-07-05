package project.command;

import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.connection.ConnectionProvider;
import member.model.Member;
import mvc.command.CommandHandler;
import project.dao.CategoryDAO;
import project.dao.DetailCategoryDAO;
import project.dao.ProjectDAO;
import project.model.Category;
import project.model.DetailCategory;
import project.model.Project;


public class MakeProjectHandler implements CommandHandler {
	private static final String FORM_VIEW = "/WEB-INF/view/projectForm.jsp";
	
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
		
		ArrayList<Category> list = null;
		Connection conn =  ConnectionProvider.getConnection(); 
		CategoryDAO dao = new CategoryDAO(conn);
		try {
			list = dao.select(); // 카테고리 
		}  catch (Exception e) { 
		System.out.println("> ProjectHandler() Exception...");
		}
		conn.close(); // 커넥션 풀 반환 
		request.setAttribute("list", list);  
		return FORM_VIEW;
	}
	
	
	// 글쓰기 로직 가져오기 
	private String processSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String summary = request.getParameter("summary"); 
		String category = request.getParameter("category"); 
		
		Connection conn =  ConnectionProvider.getConnection(); 
		
		DetailCategoryDAO dtdao = new DetailCategoryDAO(conn);
		DetailCategory detailCategory = dtdao.selectDefault(category); 
		String dtl_ctg_code = detailCategory.getDtl_ctg_code(); 
		
		Member member = (Member) request.getSession().getAttribute("authUser");
		String m_cd = member.getM_cd(); 
		
		Project project = new Project(summary, dtl_ctg_code, m_cd); 
		ProjectDAO prodao = new ProjectDAO(conn); 			
		project = prodao.insert(conn, project); // 새로운 프로젝트 객체를 반환 
		
		conn.close();
		// db에 저장되었다는 사실을 세션에 저장하면 안됨! 꼐정 자계정 자체에 저장해야 접 그 계정을 기억해서 요금제 폼 계속 띄움 
		// 관리 페이지에 들어오려는 사용자(창작자)의 요금제 칼럼이 null이면, 필터로 조인폼 요청 
		
		String location = "/tumblbug/payment.do?pro_cd=" + project.getPro_cd() ;
		/*
		 * String referer = null; if( ( referer = (String)
		 * request.getSession().getAttribute("referer") ) != null ) location = referer;
		 */
		response.sendRedirect(location);
		
		return null; 
	} // processSubmit
}

















