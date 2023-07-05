package days05.board;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.util.DBConn;

/*@WebServlet("/cstvsboard/write.htm")*/
public class Write extends HttpServlet {
	private static final long serialVersionUID = 1L; 
	public Write() {
		super(); 
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 포워딩
		String path = "/days05/board/write.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request -> BoardDTO dto 생성 -> rowCount dao.insert()
		// list.htm 리다이렉트 -> List.java서블릿 -> list.jsp 포워딩.
		// 12:05 수업 시작~
		request.setCharacterEncoding("UTF-8");
		
	    String writer = request.getParameter("writer");
	    String pwd = request.getParameter("pwd");
	    String email = request.getParameter("email");
	    String title = request.getParameter("title");
	    String content = request.getParameter("content");
	    int tag = Integer.parseInt( request.getParameter("tag") );
	    
	    BoardDTO dto = new BoardDTO(0, writer, pwd, email, title, null, 0, tag, content);
	    
	    Connection conn = DBConn.getConnection();
	    BoardDAOImpl dao = new BoardDAOImpl(conn);
	    int rowCount = 0;
	    try {
			rowCount = dao.insert(dto);
		} catch (SQLException e) { 
			System.out.println("> Wrie.doPost() Exception...");
			e.printStackTrace();
		}
	    DBConn.close();
	    
	    // 포워딩 X  list.jsp
	    // 리다이렉트      list.htm -> List.java -> list.jsp	    
	    String location = "/jspPro/cstvsboard/list.htm";
	    location += rowCount == 1 ? "?write=success": "?write=fail";
	    response.sendRedirect(location);
		
	}

}




