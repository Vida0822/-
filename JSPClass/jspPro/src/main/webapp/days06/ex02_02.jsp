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

<h3> ex02_02.jsp </h3>

<%
	// 4가지 영역(scope)에 각각 값을 저장 
	pageContext.setAttribute("name", "admin");// 페이지 영역
	request.setAttribute("age", 20);  //요청객체 
	session.setAttribute("addr", "서울"); // 세션영역 
	application.setAttribute("tel", "010- ") ;  // 브라우저 영역 
%>

<br>
p name : <%= pageContext.getAttribute("name") %><br>
r age : <%= request.getAttribute("age") %><br>
s addr : <%= session.getAttribute("addr") %><br>
a tel : <%= application.getAttribute("tel") %><br>
<br>

<a href="ex02_03.jsp">ex02_03.jsp </a>

<!--  
p name , r age , s addr , a tel
 -->


</body>
</html>