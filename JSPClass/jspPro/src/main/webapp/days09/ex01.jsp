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

<pre>
[EL 연산자]
<%-- 
${3+5 } <!--  8  -->
${3-5 } <!--  -2 -->
${3*5 } <!-- 15 -->
${3/5 } <!--0.6 -->
${3 div 5 } <!--  0.6   -->
${3%5 } <!--  3   -->
${3 mod 5 } <!-- 3   --> 
--%>

<%-- 
${"10" }<br> <!-- 10  -->
${"10" + 3}<br> <!-- 13  => 문자열 숫자는 자동으로 int로 변환시켜서 연산한다 -->
${"한글" + 3} <br> <!-- 에러발생  -->
${null + 3}<br> <!-- 3 => null은 0으로 처리   --> 
--%>




</pre>
</body>
</html>