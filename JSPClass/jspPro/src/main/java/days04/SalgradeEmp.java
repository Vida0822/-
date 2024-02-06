package days04;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.util.DBConn;

import days01.EmpDTO;

@WebServlet("/days04/salgradeEmp.htm")
public class SalgradeEmp extends HttpServlet {
   private static final long serialVersionUID = 1L;

   public SalgradeEmp() {
      super(); 
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // System.out.println("SalgradeEmp.doGet()...");
      // 
      String sql =   " SELECT grade  , losal,  hisal   , COUNT(*) cnt  "
            + " FROM salgrade s JOIN emp e ON e.sal BETWEEN s.losal AND s.hisal "
            + " GROUP BY grade  , losal,  hisal "
            + " ORDER BY grade ASC";

      String sql2 = "SELECT d.deptno, dname, empno, ename, sal , grade "
            + "FROM dept d FULL JOIN emp e ON d.deptno = e.deptno "
            + "            FULL JOIN salgrade s ON e.sal BETWEEN s.losal AND s.hisal "
            + "WHERE  grade = ?           "
            + "ORDER BY d.deptno ASC";
      
      Connection conn = null;
      PreparedStatement pstmt = null, pstmt2 = null;
      ResultSet rs = null, rs2 = null;
      // SalgradeDTO 선언
      ArrayList<EmpDTO> list = null;
      SalgradeDTO dto = null;
      
      LinkedHashMap<  SalgradeDTO , ArrayList<EmpDTO>>  map = null;

      conn =  DBConn.getConnection();
      try {
         pstmt = conn.prepareStatement(sql);
         rs =  pstmt.executeQuery();

         if ( rs.next()) {
            map = new LinkedHashMap<SalgradeDTO, ArrayList<EmpDTO>>();
            do {
               int grade  = rs.getInt("grade") ;
               int losal   = rs.getInt("losal");
               int hisal   = rs.getInt("hisal");
               int  cnt     = rs.getInt("cnt");
               dto = new SalgradeDTO(grade, losal, hisal, cnt);
               
               list = null; // 초기화
               
               // 시작
               pstmt2 = conn.prepareStatement(sql2);
               pstmt2.setInt(1, grade);
               rs2 =  pstmt2.executeQuery();
               if( rs2.next()) {
                  list = new ArrayList<EmpDTO>();
                  do {
                     // d.deptno, dname, empno, ename, sal , grade
                	 int deptno =  rs2.getInt("deptno");
                     String dname = rs2.getString("dname");  // X
                     int empno = rs2.getInt("empno");
                     String ename = rs2.getString("ename");
                     double sal = rs2.getDouble("sal");
                           EmpDTO vo = new  EmpDTO();
                           vo.setDeptno(deptno);
                           vo.setEmpno(empno);
                           vo.setEname(ename);
                           vo.setSal(sal);
                     list.add(vo);
                  } while (rs2.next());
               }
               
               // dto (key) list(value)
               map.put(dto, list);
               // 끝
            } while (rs.next());
         } // if

      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         try {
            pstmt.close();            rs.close();            
            pstmt2.close();            rs2.close();
         } catch (SQLException e) {
            e.printStackTrace();
         }
      }
      DBConn.close();

      request.setAttribute("map", map);
            // 포워딩~
            String path = "/days04/ex04_salgradeEmp.jsp";
            RequestDispatcher dispatcher =  request.getRequestDispatcher(path);
            dispatcher.forward(request, response);
   }
}