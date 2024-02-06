<%@page import="java.sql.Date"%>
<%@page import="days01.EmpDTO"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.util.Iterator"%>
<%@page import="days01.DeptDTO "%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.util.DBConn"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <%@ 지시자(directive) %> --%>
<% 
Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;
ArrayList<DeptDTO> list = null;

String sql = " SELECT * "
         + " FROM dept "
         + " ORDER BY deptno ASC";

conn = DBConn.getConnection();
try {
   pstmt = conn.prepareStatement(sql);
   rs = pstmt.executeQuery();
   
   int deptno;
   String dname, loc;
   
   if (rs.next()) {
      list = new ArrayList<DeptDTO>();
      
      do {
         deptno = rs.getInt("deptno");
         dname = rs.getString("dname");
         loc = rs.getString("loc");
         DeptDTO dto = new DeptDTO(deptno, dname, loc);
         list.add(dto);
      } while (rs.next());
   }
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
}

// dept option 코딩 완료 -------------------------------------------------------------
// emp table>tr 코딩 시작 ------------------------------------------------------------

int pdeptno = 10;
try {
   pdeptno = Integer.parseInt( request.getParameter("deptno") );
} catch(Exception e) {
}

ArrayList<EmpDTO> elist = null;
sql = " SELECT * "
      + " FROM emp "
      + " WHERE deptno = ? "
      + " ORDER BY empno ASC ";

try {
   pstmt = conn.prepareStatement(sql);
   pstmt.setInt(1, pdeptno);
   rs = pstmt.executeQuery();
   
   int empno, mgr, deptno;
   String ename, job;
   Date hiredate;
   double sal, comm;
   
   if (rs.next()) {
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
      } while (rs.next());
   }
} catch (SQLException e) {
   e.printStackTrace();
} finally {
   try {
      rs.close();
      pstmt.close();
      DBConn.close();
   } catch (SQLException e) {
      e.printStackTrace();
   }
}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="shortcut icon" type="image/x-icon" href="../../images/SiSt.ico">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<style>
table {
   width: 100%;
   min-width: 700px;
}

table, th, td {
   border: 1px solid gray;
}
</style>
</head>
<body>
<!-- <form> -->
<select name="deptno" id="deptno">
<%
Iterator<DeptDTO> ir = list.iterator();
while (ir.hasNext()) {
   DeptDTO dto = ir.next();
%>
<option value="<%= dto.getDeptno() %>" data-loc="<%= dto.getLoc() %>"><%= dto.getDname() %></option>
<%-- 
<%
// ?pdeptno      받아온 deptno
if( pdeptno == dto.getDeptno() ) {
%>
<option value="<%= dto.getDeptno() %>" data-loc="<%= dto.getLoc() %>" selected="selected"><%= dto.getDname() %></option>
<%   
} else {
%>
// <option value="<% out.print( dto.getDeptno() ); %>"><% out.print( dto.getDname() ); %></option>
<option value="<%= dto.getDeptno() %>" data-loc="<%= dto.getLoc() %>"><%= dto.getDname() %></option>
<%
}
%>
 --%>
<%
}
%>
</select>
<!-- </form> -->
<br>
<br>
<table>
   <thead class="table-dark">
      <tr>
         <td><input type="checkbox" id="ckbAll" name="ckbAll"></td>
         <td>empno</td>
         <td>ename</td>
         <td>job</td>
         <td>mgr</td>
         <td>hiredate</td>
         <td>sal</td>
         <td>comm</td>
         <td>deptno</td>
      </tr>
   </thead>
   <tbody>
   <%
      if( elist == null ) {
   %>   
      <tr>
         <td colspan="9" style="text-align: center">employee does not exist</td>
      </tr>
   <%
      } else {
   %>
   <%
      Iterator<EmpDTO> eir = elist.iterator();
      while(eir.hasNext()) {
         EmpDTO dto = eir.next();
   %>
      <tr>
         <td><input type="checkbox"></td>
         <td><%= dto.getEmpno() %></td>
         <td><%= dto.getEname() %></td>
         <td><%= dto.getJob() %></td>
         <td><%= dto.getMgr() %></td>
         <td><%= dto.getHiredate() %></td>
         <td><%= dto.getSal() %></td>
         <td><%= dto.getComm() %></td>
         <td><%= dto.getDeptno() %></td>
      </tr>
   <%
      }
   %>
   <%      
      }
   %>
   </tbody>
   
   
   <tfoot>
   
   	<tr>
   		<td colspan ="9" style ="text-align: center;"> 
   	
   	</tr>	
   	
   	</tfoot>
   
   
</table>

<script>
$(function() {
   $("#deptno").on("change", function(event) {
      // $("form").submit(); // 파라미터 많으면 form 태그 활용
      var pdeptno = $(this).val();
      location.href = "http://localhost/jspPro/days02/test/test01.jsp?deptno=" + pdeptno;
   });
   // ?deptno=xx
   <%-- $("#deptno").val(<%= pdeptno %>); --%>
   // EL
   $("#deptno").val(${empty param.deptno ? 10 : param.deptno});
});
</script>
</