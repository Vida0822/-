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

public class DeleteHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String requestMethod =  request.getMethod(); // 메서드 방식을 확인할 수 있는 메서드 
		if (requestMethod.equals("GET")) {
			return "/days08/board/delete.jsp"; 

		}else if (requestMethod.equals("POST")) {
			request.setCharacterEncoding("UTF-8");
			int seq = Integer.parseInt(request.getParameter("seq"));
			String pwd = request.getParameter("pwd"); // 입력받은 비밀번호
			String originalPwd = null;
			
			Connection conn = ConnectionProvider.getConnection();
			BoardDAOImpl dao = new BoardDAOImpl(conn);
			
			int rowCount = 0;
			try {
				originalPwd = dao.getOriginalPwd(seq);
				if( pwd.equals(originalPwd)) {
					rowCount = dao.delete(seq);
				}else{
					// 비밀번호 일치하지 않는 경우에는  경고창 띄우고. 
					// 다시 삭제 페이지 이동... 
					request.setAttribute("error", "비밀번호가 틀립니다.");
					return null;
				}
			} catch (SQLException e) { 
				System.out.println("> DeleteHandler Exception...");
				e.printStackTrace();
			}
		    conn.close();
		    // 리다이렉트
		    String location = "/jspPro/board/list.do";
		    location += rowCount == 1 ? "?delete=success": "?delete=fail";
		    response.sendRedirect(location);
		} // post 
		return null; // 원래 리턴에 주소가 오고 컨트롤러에서 처리해줘야하는데 여기서 바로 redirect하고 반환값은 null을 돌리겠음
	} // process
} // DeleteHandler
