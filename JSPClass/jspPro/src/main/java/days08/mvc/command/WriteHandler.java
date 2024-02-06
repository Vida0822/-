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

public class WriteHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String requestMethod =  request.getMethod(); // 메서드 방식을 확인할 수 있는 메서드 
		// System.out.println(requestMethod); // GET
		
		if (requestMethod.equals("GET")) {
			// 포워딩
			/*
			 * String path = "/days05/board/write.jsp"; RequestDispatcher dispatcher =
			 * request.getRequestDispatcher(path); dispatcher.forward(request, response);
			 */
			
			return "/days08/board/write.jsp"; 
			
		}else if (requestMethod.equals("POST")) {
			request.setCharacterEncoding("UTF-8");
			
		    String writer = request.getParameter("writer");
		    String pwd = request.getParameter("pwd");
		    String email = request.getParameter("email");
		    String title = request.getParameter("title");
		    String content = request.getParameter("content");
		    int tag = Integer.parseInt( request.getParameter("tag") );
		    
		    BoardDTO dto = new BoardDTO(0, writer, pwd, email, title, null, 0, tag, content);
		    
		    Connection conn = ConnectionProvider.getConnection();
		    BoardDAOImpl dao = new BoardDAOImpl(conn);
		    int rowCount = 0;
		    try {
				rowCount = dao.insert(dto); // 글쓰기 작업 
			} catch (SQLException e) { 
				System.out.println("> WrtieHandler.doPost() Exception...");
				e.printStackTrace();
			}
		    conn.close();
		    
		    // 포워딩 X  list.jsp
		    // 리다이렉트      list.htm -> List.java -> list.jsp	    
		    String location = "/jspPro/board/list.do";
		    location += rowCount == 1 ? "?write=success": "?write=fail";
		    response.sendRedirect(location);
		    // 원래 컨트롤러에 전달해서 redirect인지 포워드인지 알려줘서 컨트롤러가 해줘야하는데 편의상 여기서 바로 redirect 시키겠음
		} // if
		return null; // 원래 리턴에 주소가 오고 컨트롤러에서 처리해줘야하는데 여기서 바로 redirect하고 반환값은 null을 돌리겠음
	} // process() 
}
