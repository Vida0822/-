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

public class ViewHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {		
			int pseq = Integer.parseInt(request.getParameter("seq"));
			Connection conn = ConnectionProvider.getConnection();
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
			// 포워딩		l
			return "/days08/board/view.jsp"; 
			
		}

}
