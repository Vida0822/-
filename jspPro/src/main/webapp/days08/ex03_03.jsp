<%@page import="com.util.Cookies"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>2023. 5. 24. - 오후 4:49:17</title>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
</head>
<body>
<h3>ex03_03.jsp</h3>
<pre>
   [ EL 쿠키 사용하는 방법 ]
</pre>
<%
    Cookie c = Cookies.createCookie("user", "admin");
    response.addCookie(c);
    c = Cookies.createCookie("id", "hong");
    response.addCookie(c);
    c = Cookies.createCookie("age", "20");
    response.addCookie(c);
%> 

<a href="ex03_03_ok.jsp">ex03_03_ok.jsp</a>
</body>
</html>








