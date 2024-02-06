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

/*@WebServlet("/cstvsboard/view.htm")*/
public class View extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public View() {
		super(); 
	}

	// ?seq=1
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//  1. seq 조회수 1증가          DAO, DAoImple
		//  2. BoardDTO dto
		int pseq = Integer.parseInt(request.getParameter("seq"));
		
		Connection conn = DBConn.getConnection();
		BoardDAOImpl dao = new BoardDAOImpl(conn);
		BoardDTO dto = null;
		try {
			dao.increaseReaded(pseq);
			dto = dao.view(pseq);
		} catch (SQLException e) { 
			System.out.println("> View.doGet() Exception...");
			e.printStackTrace();
		}
		
		request.setAttribute("dto", dto);
		
		// 포워딩
		String path = "/days05/board/view.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
