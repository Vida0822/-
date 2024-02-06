<%@page import="java.util.Iterator"%>
<%@page import="days01.EmpDTO"%>
<%@page import="java.sql.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.util.DBConn"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
// ?deptno=40 에러발생( 사원 존재 X )
int pdeptno = Integer.parseInt( request.getParameter("deptno") );
String sql = " SELECT * "
			+ " FROM emp "
			+ " WHERE deptno = ? ";
Connection conn = DBConn.getConnection();
PreparedStatement pstmt = null;
ResultSet rs = null;
ArrayList<EmpDTO> list = null;

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
}

rs.close();
pstmt.close();
DBConn.close();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<h3>ex06_02.jsp</h3>

<div class="container mt-3">
<h2>emp list</h2>
<table class="table table-hover">
	<thead class="table-dark">
		<tr>
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
	if(list==null) {
	%>
	<tr>
		<td colspan="8">사원이 존재하지 않습니다</td>
	</tr>
	<%
	} else {
	%>
	<%
	Iterator<EmpDTO> ir = list.iterator();
	while(ir.hasNext()) {
		EmpDTO dto = ir.next();
		%>
		<tr>
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
</table>
</div>

<a href="javascript:history.back()">뒤로 가기</a>
</body>
</html>




















