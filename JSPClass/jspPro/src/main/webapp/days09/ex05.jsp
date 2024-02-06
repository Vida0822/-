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
[필터 사용하는 예제]
days09 폴더
	ㄴ admin 폴더 : 관리자 (인증o + 권한o )
		ㄴ 회원관리.jsp...  
	ㄴ board 폴더 
		ㄴ ex06_list.jsp (게시판 목록 - 인증x) 
		ㄴ ex06_write.jsp (게시판 쓰기 - 인증 o ) 
	ㄴ member 폴더 (인증 x)
		ㄴ ex06_logon.jsp  폼(form) 
		ㄴ ex06_logon_ok.jsp 
		ㄴ ex06_logout.jsp  -- 엥 얜 인증처리 되어야하는거 아님 ? 
		
		* 인증처리 : LoginCheckFilter.java 핉 
		(세션)
		=> write 를 누르면 로그인 됐는지 확인하고 인증 안되어있으면 보내버림
</pre>

<h3> main 페이지 </h3>
<a href ="<%= contextPath%>/days09/board/ex06_list.jsp">/days09/board/ex06_list.jsp 인증x, 권한 x </a><br>
<a href ="<%= contextPath%>/days09/board/ex06_write.jsp">/days09/board/ex06_write.jsp 인증o, 권한 x </a><br>
<a href ="<%= contextPath%>/days09/admin/회원관리.jsp">/days09/admin/회원관리.jsp 인증x, 권한 x </a><br>
<a href ="<%= contextPath%>/days09/member/ex06_logon.jsp">/days09/member/ex06_logon.jsp 인증x, 권한 x </a><br>


</body>
</html>