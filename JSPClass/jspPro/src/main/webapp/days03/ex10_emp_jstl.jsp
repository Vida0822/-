<%@page import="java.util.Iterator"%>
<%@page import="days01.EmpDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
// 지금 포워딩 받고 있음 
String contextPath = request.getContextPath();
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
	<h3>ex10_emp_jstl.jsp</h3>
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

				<c:if test="${ empty list }">
					<tr>
						<td colspan="8">사원이 존재하지 않습니다</td>
					</tr>
				</c:if>
				<!-- not == ! : EL 연산자  -->
				<c:if test="${ not empty list }">
					<c:forEach items="${list }" var="dto">
						<tr>
							<td>${dto.empno }</td>
							<td>${dto.ename }</td>
							<td>${dto.job }</td>
							<td>${dto.mgr }</td>
							<td>${dto.hiredate }</td>
							<td>${dto.sal }</td>
							<td>${dto.comm }</td>
							<td>${dto.deptno }</td>
						</tr>
					</c:forEach>
				</c:if>
				
			</tbody>
		</table>
	</div>

	<a href="<%= contextPath%>/scott/dept">다시하기</a>

</body>
</html>