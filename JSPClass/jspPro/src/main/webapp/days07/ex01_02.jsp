<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String contextPath = request.getContextPath(); %>
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

<h3> ex01_02.jsp  </h3>

<!-- <form action = "ex01_03.jsp" method="get"> -->
<!-- <form action = "ex01_04.jsp" method="get"> -->
<form action = "ex01_05.jsp" method="get">
	<table border="1" style="width:400px">
		<tr>
				<td>아이디</td>
				<td><input type="text" name="id" value="admin"></td>
				<!--  주의! name 속성은 무조건 빈객체안의 필드명과 일치시켜주자 !  -->
		</tr>
		<tr>
				<td>이름</td>
				<td><input type="text" name="name" value="관리자"></td>
		</tr>
		<tr>
				<td>비밀번호</td>
				<td><input type="password" name="passwd" value="1234"></td>
		</tr>
		<tr>
				<td>이메일</td>
				<td><input type="text" name="email" value="admin@naver.com"></td>
		</tr>
		<tr>
				<td colspan="2">
					<input type="submit">
					<input type="reset">
				</td>
		</tr>
	</table>
</form>


</body>
</html>