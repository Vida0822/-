package days08.mvc.command;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.util.ConnectionProvider;
import com.util.DBConn;

import days05.board.BoardDAOImpl;
import days05.board.BoardDTO;
import days05.board.PageDTO;

public class ListHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {

		int currentPage = 1 ;  // 현재 페이지 번호
		int numberPerPage = 10; // 한 페이지에 출력할 게시글 수
		int numberOfPageBlock = 10; 
		int total = 0;   // 총 레코드수 

		int searchCondition = 1; // 예외 처리 방지용 초기화 (null 들어오면 catch
		try {
			searchCondition  = Integer.parseInt(request.getParameter("searchCondition") );
		} catch (Exception e) {}
		String searchWord = request.getParameter("searchWord") ; 
		if(searchWord==null) searchWord =""; 

		try {
			currentPage  = Integer.parseInt(request.getParameter("currentpage") );
		} catch (Exception e) {}

		ArrayList<BoardDTO> list = null;

		Connection conn =  ConnectionProvider.getConnection(); 
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
			System.out.println("> ListHandler() Exception...");
		}
		conn.close(); // 커넥션 풀 반환 

		request.setAttribute("list", list);  // 요청저장객체1

		// pageDTO 	
		PageDTO pdto = new PageDTO(currentPage // 1 
				, numberPerPage // 10
				, numberOfPageBlock
				, total); 
		// 넣어준 값으로 이 객체를 만들면서 총페이지 수, 시작 페이지, 끝 페이지 , 이전, 이후 버튼 여부 도출됨
		request.setAttribute("pdto", pdto); // 요청저장객체2

		return "/days08/board/list.jsp"; // 포워딩 -> 포워딩 시키기 위한 페이지 주소 
	} // process

}
