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

public class EditHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String requestMethod =  request.getMethod(); // 메서드 방식을 확인할 수 있는 메서드 
		// System.out.println(requestMethod); // GET

		if (requestMethod.equals("GET")) {
			int pseq = Integer.parseInt(request.getParameter("seq"));

			Connection conn = ConnectionProvider.getConnection();
			BoardDAOImpl dao = new BoardDAOImpl(conn);
			BoardDTO dto = null;
			try {
				dto = dao.view(pseq);
			} catch (SQLException e) { 
				System.out.println("> Edit.doGet() Exception...");
				e.printStackTrace();
			}
			conn.close();
			request.setAttribute("dto", dto);

			// 포워딩
			/*
			 * String path = "/days08/board/edit.jsp"; 
			 * RequestDispatcher dispatcher =request.getRequestDispatcher(path); 
			 * dispatcher.forward(request, response);
			 */
			return  "/days08/board/edit.jsp";
			
			
		}else if (requestMethod.equals("POST")) {
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
			Connection conn = ConnectionProvider.getConnection();
			BoardDAOImpl dao = new BoardDAOImpl(conn);
			int rowCount = 0;
			try {
				rowCount = dao.update(dto);
			} catch (SQLException e) { 
				System.out.println("> Edit.doPost() Exception...");
				e.printStackTrace();
			}
			conn.close();

			String location = "/jspPro/board/view.do?seq=" + seq ;
			location += rowCount == 1 ? "&edit=success": "&edit=fail";
			response.sendRedirect(location);
		}
		return null; // 원래 리턴에 주소가 오고 컨트롤러에서 처리해줘야하는데 여기서 바로 redirect하고 반환값은 null을 돌리겠음

	}
}
