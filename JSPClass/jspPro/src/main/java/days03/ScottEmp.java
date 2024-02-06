package days03;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
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

import days01.EmpDTO;


@WebServlet("/scott/emp")
public class ScottEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ScottEmp() {
		super();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("ScottEmp doGet() 함수 잘 요청됨 ! ");
		//ScottEmp doGet() 함수 잘 요청됨 ! 
		int pdeptno = Integer.parseInt( request.getParameter("deptno") );
		String sql = " SELECT * "
				+ " FROM emp "
				+ " WHERE deptno = ? ";
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<EmpDTO> list = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pdeptno);
			rs = pstmt.executeQuery();

			int empno, mgr, deptno;
			String ename, job;
			Date hiredate;
			double sal, comm;

			if(rs.next()) {
				list = new ArrayList<>();
				do {
					empno = rs.getInt("empno");
					mgr = rs.getInt("mgr");
					deptno = rs.getInt("deptno");
					ename = rs.getString("ename");
					job = rs.getString("job");
					hiredate = rs.getDate("hiredate");
					sal = rs.getDouble("sal");
					comm = rs.getDouble("comm");
					EmpDTO dto = new EmpDTO(empno, ename, job, mgr, hiredate, sal, comm, deptno);
					list.add(dto);
				} while(rs.next());
			} // if 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				DBConn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} // finally

		request.setAttribute("list", list); 

		//String path = "/days03/ex10_emp.jsp";
		String path = "/days03/ex10_emp_jstl.jsp";
		RequestDispatcher dispatcher =  request.getRequestDispatcher(path); 
		dispatcher.forward(request, response); 

	} // doGet() 

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
