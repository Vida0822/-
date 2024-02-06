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

/*@WebServlet("/cstvsboard/delete.htm")*/
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Delete() {
		super(); 
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 포워딩
		String path = "/days05/board/delete.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}

	// ?seq=22
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int seq = Integer.parseInt(request.getParameter("seq"));
		String pwd = request.getParameter("pwd"); // 입력받은 비밀번호
		String originalPwd = null;
		
		Connection conn = DBConn.getConnection();
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
				doGet(request, response);
				return ;
			}
		} catch (SQLException e) { 
			System.out.println("> Delete.doPost() Exception...");
			e.printStackTrace();
		}
	    DBConn.close();
	    // 리다이렉트
	    String location = "/jspPro/cstvsboard/list.htm";
	    location += rowCount == 1 ? "?delete=success": "?delete=fail";
	    response.sendRedirect(location);

	}

}
