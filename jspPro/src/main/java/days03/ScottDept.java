package days03;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.util.DBConn;

import days01.DeptDTO;


@WebServlet("/scott/dept")
public class ScottDept extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ScottDept() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 	System.out.println("ScottDept.doGet() 호출됨");

		// ex06.jsp 부서정보 받아오는 쿼리 
		String sql = " SELECT * "
				+ " FROM dept ";
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<DeptDTO> list = null;

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			int deptno;
			String dname, loc;

			if(rs.next()) {
				// 하나라도 값이 없을 수 있으니 만들어준 코딩 => 하나라도 있어야 실행 
				list = new ArrayList<>();
				do {
					// 각각의 정보를 얻어와 변수에 넣고 
					deptno = rs.getInt("deptno");
					dname = rs.getString("dname");
					loc = rs.getString("loc");

					// 그 정보들로 부서객체를 각각 만들어서 
					DeptDTO dto = new DeptDTO(deptno, dname, loc);

					// list에 추가 
					list.add(dto);
				} while(rs.next());
			} // if 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// DB에서 정보 다 가져왔으니까 연결끊어주기
				rs.close();
				pstmt.close();
				DBConn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} // catch
		} // finally 
		// ex09_forward 포워딩 코딩 
		
		request.setAttribute("list", list); 
		// list라는 이름으로 arraylist인 list 저장! 
		
		// String path = "/days03/ex10_dept.jsp";
		String path = "/days03/ex10_dept_jstl.jsp";
		// 서버 내에서 페이지 이동하는 거기 대문에 contextPath 다음부터 설정해주면 됨
		
		// 404 뜨는 이유 
		// 1) servlet 을 못찾아서 !  (서블릿 실패) 
		// 2)  그 안에서 ex10_dept을 요청못해서 (포워딩 실패)
		RequestDispatcher dispatcher =  request.getRequestDispatcher(path); 
		dispatcher.forward(request, response); 
		// 결과물 list 를 request에 저장 
		// -> 이걸 넘겨주기 때문에 이 데이터 ex10_dept.jsp도 사용할 수 있음 
		
	} // doGet() 
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
