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

<h3> ex02_04.jsp </h3>
<!--  실행되고 있는 떠있는 브라우저 모두 닫기를 누르고 ex02_04.jsp 를 실행 --> 
<br>
	p name : <%= pageContext.getAttribute("name") %><br> <!--  null  -->
	r age : <%= request.getAttribute("age") %><br> <!--  null  -->
	
	s addr : <%= session.getAttribute("addr") %><br> <!--  null  -->
	<!--  한 사용자가 접속해 있는 동안 사용할 값 : 인정처리, 권한, 장바구니 등등 -->
	
	a tel : <%= application.getAttribute("tel") %><br> <!--  010-  -->
	<!--  모든 사용자가 공유할 값을 저장하는 기억공간을 application 이라고 부른다  -->


<br>


</body>
</html>