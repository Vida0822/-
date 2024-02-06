<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- JSP 주석처리 Ctrl + Shift + /
<%! %>
<% %>
--%>
<% 
// 스크립트릿 - 자바 코딩
Date now = new Date();
// 2023-05-15 00:00:00
String pattern = "yyyy-MM-dd hh:mm:ss";
SimpleDateFormat sdf = new SimpleDateFormat(pattern);
String strNow = sdf.format(now);
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
<h3>ex02.jsp - 표현식 : <%= strNow %></h3>
<!--  
JSP 구성 요소 9가지 중 "스크립트 요소 3가지" - 스크립트릿, 표현식, 선언문
%@ 지시자(directive) 3가지 page 지시자
-->
<script>
let now = '<%= strNow %>'; // 서버에서 실행 -> 응답 결과만 받아옴
alert(now);
</script>
</body>
</html>