<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
// jsp 스크립트 요소 - 스크립트릿(자바코딩)
// http://localhost/jspPro/days01/ex03_ok.jsp
// ? 요청 파라미터( get 방식 )
// title=%ED%99%8D%EA%B8%B8%EB%8F%99%EC%A0%84
// &
// author=%EC%9D%B4%EC%9D%B8%EC%84%9D

// jsp 기본 내장 객체 9가지 중 : request 객체
String bookTitle = request.getParameter("title");
String author = request.getParameter("author");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
</head>
<body>
책 제목 : <%= bookTitle %><br>
저자 : <%= author %><br>
</body>
</html>