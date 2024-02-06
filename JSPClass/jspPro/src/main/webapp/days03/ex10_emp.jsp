<%@page import="java.util.Iterator"%>
<%@page import="days01.EmpDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
// 지금 포워딩 받고 있음 
String contextPath = request.getContextPath();

ArrayList<EmpDTO> list = (ArrayList<EmpDTO>) request.getAttribute("list");
// getAttribute : object 객체로 돌림 -> 다운캐스팅  해서 arrayList 로 변환해줌 !
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div class="container mt-3">
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
				if (list == null) {
				%>
				<tr>
					<td colspan="8">사원이 존재하지 않습니다</td>
				</tr>
				<%
				} else {
				%>
				<%
				Iterator<EmpDTO> ir = list.iterator();
				while (ir.hasNext()) {
					EmpDTO dto = ir.next();
				%>
				<tr>
					<td><%=dto.getEmpno()%></td>
					<td><%=dto.getEname()%></td>
					<td><%=dto.getJob()%></td>
					<td><%=dto.getMgr()%></td>
					<td><%=dto.getHiredate()%></td>
					<td><%=dto.getSal()%></td>
					<td><%=dto.getComm()%></td>
					<td><%=dto.getDeptno()%></td>
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
	
	<a href ="<%= contextPath%>/scott/dept">다시하기</a>
	
</body>
</html>