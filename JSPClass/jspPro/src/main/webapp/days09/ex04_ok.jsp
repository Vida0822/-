<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <% String contextPath = request.getContextPath(); %>
<% request.setCharacterEncoding("UTF-8");  %> --%>
<%-- <%@ include file="/WEB-INF/inc/include.jspf" %> 

=> 이 작업 '필터'로 해보자 

--%>
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

<h3> ex04_ok.jsp  </h3>

<%
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html; charset=UTF-8");
	String name = request.getParameter("name");
	String age = request.getParameter("age");
%>
전달된 이름 : <%= name %><br>
전달된 나이 : <%= age %><br>

</body>
</html>