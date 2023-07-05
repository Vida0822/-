package days05.board;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.util.DBConn;

/*@WebServlet("/cstvsboard/edit.htm")*/
public class Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Edit() {
		super(); 
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
       int pseq = Integer.parseInt(request.getParameter("seq"));
		
		Connection conn = DBConn.getConnection();
		BoardDAOImpl dao = new BoardDAOImpl(conn);
		BoardDTO dto = null;
		try {
			dto = dao.view(pseq);
		} catch (SQLException e) { 
			System.out.println("> Edit.doGet() Exception...");
			e.printStackTrace();
		}
		
		request.setAttribute("dto", dto);
		
		// 포워딩
		String path = "/days05/board/edit.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}

	// edit.htm?seq=22
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int seq = Integer.parseInt(request.getParameter("seq") );
         // 글수정 DB 처리
		String  pwd = request.getParameter("pwd");
		String  email = request.getParameter("email");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int tag = Integer.parseInt(request.getParameter("tag") );		 
		BoardDTO dto =
				new BoardDTO(seq, null, pwd, email, title, null, 0, tag, content);
		// Write.java doPost() 복사 붙이기 
		Connection conn = DBConn.getConnection();
	    BoardDAOImpl dao = new BoardDAOImpl(conn);
	    int rowCount = 0;
	    try {
			rowCount = dao.update(dto);
		} catch (SQLException e) { 
			System.out.println("> Edit.doPost() Exception...");
			e.printStackTrace();
		}
	    DBConn.close();
	    
	    // 포워딩 X  list.jsp
	    // 리다이렉트      list.htm -> List.java -> list.jsp	    
	    String location = "/jspPro/cstvsboard/view.htm?seq=" + seq ;
	    location += rowCount == 1 ? "&edit=success": "&edit=fail";
	    response.sendRedirect(location);
	}

}







