package days05.board;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.util.DBConn;
 
/*@WebServlet("/cstvsboard/list.htm")*/
public class List extends HttpServlet {
	private static final long serialVersionUID = 1L;
        
    public List() {
        super(); 
    }
 
    // http://localhost/jspPro/cstvsboard/list.htm?currentpage=3
	// searchCondition=2&searchWord=게시판
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 현재페이지 게시글 select -> ArrayList<BoardDTO> list 
		// BC/BS X   BoardDAO.select() 살펴보고
		int currentPage = 1 ;  // 현재 페이지 번호
		int numberPerPage = 10; // 한 페이지에 출력할 게시글 수
		int numberOfPageBlock = 10; 
		int total = 0;  
		
		// 검색 추가코딩 1 시작
		int searchCondition = 1; // 예외 처리 방지용 초기화 (null 들어오면 catch
		try {
			searchCondition  = Integer.parseInt(request.getParameter("searchCondition") );
		} catch (Exception e) {}
		String searchWord = request.getParameter("searchWord") ; 
		if(searchWord==null) searchWord =""; 
		
		
		// 검색 추가코딩 2 시작 
		
		
		
		
		try {
			currentPage  = Integer.parseInt(request.getParameter("currentpage") );
		} catch (Exception e) {}
		
		ArrayList<BoardDTO> list = null;
		
		Connection conn =  DBConn.getConnection();
		BoardDAOImpl dao = new BoardDAOImpl(conn);
		
		
		// DB 작업 
		try {
			if(searchWord.equals("") ) { // 검색을 안하고 있다 (그냥 조회) 
				list = dao.select(currentPage, numberPerPage);
				total = dao.getTotal();   
			}else { // 검색을 하고 있다 ! 
				list = dao.search(currentPage, numberPerPage
						, searchCondition, searchWord);
				total = dao.getSearchTotal(searchCondition, searchWord );   
			} 
		} catch (SQLException e) { 
			System.out.println("> List.doGet() Exception...");
		}
		DBConn.close();
		
		request.setAttribute("list", list);  // 요청저장객체1
		
		// pageDTO 	
		PageDTO pdto = new PageDTO(currentPage // 1 
				, numberPerPage // 10
				, numberOfPageBlock
				, total); 
		// 넣어준 값으로 이 객체를 만들면서 총페이지 수, 시작 페이지, 끝 페이지 , 이전, 이후 버튼 여부 도출됨
		request.setAttribute("pdto", pdto); // 요청저장객체2
		
		// 포워딩
		String path = "/days05/board/list.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}

	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
