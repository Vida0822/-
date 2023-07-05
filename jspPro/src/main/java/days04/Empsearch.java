package days04;

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

import days01.DeptDTO;
import days01.EmpDTO;


@WebServlet("/days04/empsearch.htm")
public class Empsearch extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public Empsearch() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// System.out.println("doGet() 함수 잘 요청됨");
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// 1. 부서정보 가져오는 코딩 
		ArrayList<DeptDTO> dlist = null;
		String sql = " SELECT * "
				+ " FROM dept "
				+ " ORDER BY deptno ASC";
		try {
			conn = DBConn.getConnection();

			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			int deptno;
			String dname, loc;

			if (rs.next()) {
				dlist = new ArrayList<DeptDTO>();     
				do {
					deptno = rs.getInt("deptno");
					dname = rs.getString("dname");
					loc = rs.getString("loc");
					DeptDTO dto = new DeptDTO(deptno, dname, loc);
					dlist.add(dto);
				} while (rs.next());
			} // if
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				// DBConn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} // finally (1번) 



		// 2. 직업 얻어오는 코딩 
		ArrayList<String> jlist = null; 

		sql = " SELECT DISTINCT job "
				+ " FROM emp "
				+ " WHERE job IS NOT NULL" 
				+ " ORDER BY job ASC";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			String job; 
			if (rs.next()) {
				jlist = new ArrayList<String>();	      
				do {
					job = rs.getString("job"); 
					jlist.add(job);
				} while (rs.next());
			} // if
		} catch (SQLException e) {
			e.printStackTrace();   	    
		}finally {
			try {
				rs.close();
				pstmt.close();
				//DBConn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		} // finally (2번) 


		// 3. 전체사원 얻어오는 코딩 
		String  pdeptno =   "";
		String pjob = "";
		try{
			String [] pdeptnos = request.getParameterValues("deptno");
			if(pdeptnos!=null) pdeptno = String.join(", ", pdeptnos);
			// 여기서 선택을 안해주니까 여기서 null 이 나와서 그걸 join 하겠다고 하니까 예외 발생 
			// => 밑에 코딩을 수행하지 않고 catch문으로 가서 job 매개변수를 가져오고 처리하는 과정을 하지 않는다 
			String [] pjobs = request.getParameterValues("job");
			if(pjobs!=null) pjob = String.format("\'%s\'",   String.join("', '", pjobs) ) ;
		}catch( Exception e ){ 
			System.out.println("catch블럭은 절대 비우면 안된다!" + e.toString() );
		}

		ArrayList<EmpDTO> elist = null;
		sql   = " SELECT * "
				+ " FROM emp " ;

		if(!pdeptno.equals("")) {  
			sql += " WHERE deptno IN ( "+ pdeptno +" ) ";
			if(!pjob.equals("")) {
				sql  += " AND job IN ("+ pjob +")";                  
			} 
		}else {
			if(!pjob.equals("")) {
				sql  += " WHERE job IN ("+ pjob +")";                  
			}
		}

		sql += " ORDER BY deptno ASC";


		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			int empno, mgr, deptno;
			String ename, job;
			Date hiredate;
			double sal, comm;

			if(rs.next()) {
				elist = new ArrayList<EmpDTO>();
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
					elist.add(dto);
				} while(rs.next());
			}// if 
		} catch (SQLException e) {
			e.printStackTrace();   	    
		} // catch
		finally {
			try {
				rs.close();
				pstmt.close();
				DBConn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		} // finally (3번)

		// elist 수정 




		// 포워딩 ! 
		request.setAttribute("dlist", dlist); 
		request.setAttribute("jlist", jlist); 
		request.setAttribute("elist", elist); 
		String path = "/days04/empSearch_jstl.jsp";
		RequestDispatcher dispatcher =  request.getRequestDispatcher(path); 
		dispatcher.forward(request, response); 
	} // doGet() 
}
