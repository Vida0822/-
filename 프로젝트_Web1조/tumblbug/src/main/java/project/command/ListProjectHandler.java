package project.command;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.connection.ConnectionProvider;
import mvc.command.CommandHandler;
import project.dao.CategoryDAO;
import project.dao.ProjectDAO;
import project.model.Category;
import project.model.Project;
import project.service.ListProjectService;
import project.service.ProjectCard;


public class ListProjectHandler implements CommandHandler {
	private static String FORM_VIEW = "/publicWeb/main.jsp";
	private ListProjectService listProjectService = new ListProjectService();
	private ProjectDAO projectDao = new ProjectDAO();
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (request.getMethod().equalsIgnoreCase("GET")) {
			return processForm(request, response);
		} else if (request.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(request, response);
		} else {
			response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}
	
	// 메인페이지용 
	private String processForm(HttpServletRequest request, HttpServletResponse response) {
		FORM_VIEW = "/publicWeb/main.jsp";
		
		Map<String, Boolean> errors = new HashMap<>();
		request.setAttribute("errors", errors);
		
		try (Connection conn = ConnectionProvider.getConnection()) {
			
		// 주목할만한 프로젝트 
		ArrayList<Project> List = projectDao.selectList(conn,0,"");  
		ArrayList<ProjectCard> CardList = listProjectService.getProjectCardList(List) ; 
		request.setAttribute("CardList", CardList);
		if(List==null || CardList==null ) { 
			errors.put("noCardList", Boolean.TRUE);
		}		
		// 최근본 프로젝트 
		
		// 이런 프로젝트는 어때요? 
		
		// 기획전별 
		
		
		// 마감임박 (이거 남은 시간 ajax 처리해야함) 
		ArrayList<Project> endList = projectDao.selectList(conn,4,"end");  
		ArrayList<ProjectCard> endCardList = listProjectService.getProjectCardList(endList) ; 
		request.setAttribute("endCardList", endCardList);
		if(endList==null || endCardList==null ) { 
			errors.put("noendCardList", Boolean.TRUE);
		}
		
		// 공개예정 
		ArrayList<Project>  soonList = projectDao.selectList(conn,5,"공개예정");  
		ArrayList<ProjectCard> soonCardList = listProjectService.getProjectCardList(soonList) ; 
		request.setAttribute("soonCardList", soonCardList);
		if(soonCardList==null || soonCardList==null ) { 
			errors.put("noendCardList", Boolean.TRUE);
		}
		
		// 신규 
		ArrayList<Project>  newList = projectDao.selectList(conn,4,"new");  
		ArrayList<ProjectCard> newCardList = listProjectService.getProjectCardList(newList) ; 
		request.setAttribute("newCardList", newCardList);
		if(newList==null || newCardList==null ) { 
			errors.put("nonewCardList", Boolean.TRUE);
		}
		
		// 인기
		ArrayList<Project>  popList = projectDao.selectList(conn,3,"");  
		ArrayList<ProjectCard> popCardList = listProjectService.getProjectCardList(popList) ; 
		request.setAttribute("popCardList", popCardList);
		if(popList==null || popCardList==null ) { 
			errors.put("nopopCardList", Boolean.TRUE);
		}
		}catch (Exception e) {
			System.out.println("> ListProjectHandler() processForm() Exception...");
			e.printStackTrace();
		} // trycatch
		return FORM_VIEW;
	} // processForm

	
	
	
	
	// 검색용 
	public String processSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		FORM_VIEW = "/WEB-INF/view/search.jsp";
		
		Map<String, Boolean> errors = new HashMap<>();
		request.setAttribute("errors", errors);

		try (Connection conn = ConnectionProvider.getConnection()) {

			// 프로젝트 카드 조회 
			String searchWord ;  
			int searchCondition ;
			try {
				searchWord =  request.getParameter("searchWord"); 
				System.out.println("searchWord 파라미터 잘 받아옴");
				System.out.println(searchWord);
			} catch (Exception e) {
				searchWord="";
			} // try-catch 
			try {
				searchCondition  = Integer.parseInt(request.getParameter("searchCondition") );
				System.out.println("searchCondition 파라미터 잘 받아옴");
			}catch (Exception e) {
				searchCondition=0; 
			}		
			
			// 프로젝트 카드 만들기 
			ArrayList<Project> projectList = projectDao.selectList(conn,searchCondition,searchWord);  
			ArrayList<ProjectCard> projectCardList = listProjectService.getProjectCardList(projectList) ; 
			
			request.setAttribute("searchCondition", searchCondition);
			request.setAttribute("searchWord", searchWord);
			
			if(projectList==null || projectCardList==null ) { 
				errors.put("noProject", Boolean.TRUE);
				return FORM_VIEW; 
			}
			
			int projectCount = projectCardList.size() ; 
			
			request.setAttribute("projectCardList", projectCardList);
			request.setAttribute("projectCount", projectCount);
			
			return FORM_VIEW; 
		}catch (Exception e) {
			System.out.println("> ListProjectHandler() processSubmit() Exception...");
			e.printStackTrace();
			return null;
		} // try 
	}// processSubmit



}

















