<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String contextPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Insert title here</title>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
</head>
<body>

<h3> ex03_03.jsp </h3>
<%
	String name = request.getParameter("name");
	String age =request.getParameter("age")  ;
	String address = request.getParameter("address");
	String tel = request.getParameter("tel"); 
%>
 >name: <%= name  %> <br>
>age: <%= age  %><br> 
>address: <%= address  %><br>
>tel: <%= tel  %><br>



</body>
</html>