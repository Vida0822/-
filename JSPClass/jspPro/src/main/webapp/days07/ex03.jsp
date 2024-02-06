<%@page import="com.util.Cookies"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% String contextPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

	<h3>ex03.jsp</h3>

	<!--  
	js 쿠키: document.cookie 속성 
	jsp 쿠키 : Cookie 클래스 객체 생성(c) + 응답 response.addCookie(c)
	-> 쿠키 얻어올 떈 request 객체 사용 : 요청 보낼때 parameter처럼 보내오기 때문에 get을 활용해 얻어온다 
												(Cookie[] = requset.getCookie() )
	-> 삭제 : c.setMaxAge(0) ; 
	
 -->

	<pre>
 [쿠키 사용해서 인증처리]
 1. cookie.js 처럼 
 	com.util.Cookies.java -> cookie 관련 작업할 수 있도록 정리해놓으넛 
 	
 2. ex03_default.jsp  로 요청 
 	-> 이 페이지는 반드시 로그인을 해야히자만 사용할 수 있는 페이지 
 	-> 로그인 하지 않고 요청하면 로그인 페이지로 이동시키자 
 	
 	로그인 부분 
 	로그아웃 부분
 	
 	 ex03_logon.jsp : 로그인 페이지
 	 
 	 ex03_logout.jsp  : 로그아웃 페이지 
 
 </pre>


	

</body>
</html>