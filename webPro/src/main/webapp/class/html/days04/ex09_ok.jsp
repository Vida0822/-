<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--
http://localhost/webPro/html/days04/ex09_ok.jsp
? Query String
input name="userid"
     value
userid=hong
&
input name="username"
홍길동 -> 변환 -> %16진수
username=[%ED%99%8D][%EA%B8%B8][%EB%8F%99]
-->
<%
 String userId = request.getParameter("userid");
 String userName = request.getParameter("username");
%>

아이디 : <%= userId %><br>
이름 : <%= userName %><br>
</body>
</html>