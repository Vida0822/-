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

<h3> ex02_03.jsp </h3>

<br>
	p name : <%= pageContext.getAttribute("name") %><br> <!--  null : 페이지가 바뀌었기 때문에 유지 x -->
	r age : <%= request.getAttribute("age") %><br> <!--  null : 새로운 요청이 발생한거기 때문에 유지 x  -->
	s addr : <%= session.getAttribute("addr") %><br> <!--  서울  -->
	a tel : <%= application.getAttribute("tel") %><br>  <!--  010-  -->
<br>


</body>
</html>