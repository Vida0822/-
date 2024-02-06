<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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

<%
	// 컨텍스트 패스
		String contextPath = request.getContextPath(); 	
%>
<!-- http://localhost/jspPro : contextPath -> 모든 경로의 기준은 이 contextPath을 기준으로 해나간다?   -->
<!-- jspPro
src/main/webapp 폴더  => 이게 각각 뭐라고????????? -->
contextPath =<%= contextPath %> 

webPro 프로젝트 자체가 웹 어플리케이션이다....??
=> 웹 상에서 실행되는 프로그램 
-> 올라가면 웹 서버에 올락 ㅏ있어야함 
0< 웹 어플리케이션을 서비스 하기 위한 서가 웹 서버 
-> 웹 서버에서 실행되어지는 프로그램 : 웹 어플리케이션 

웹 사이트 == 웹 어플리케이션 
 이 웹사이트가 어디서 돌아가? 서비스 되는 서버 웹 어플리케이션 서버 (줄여서 웹 서버)
 ㄴ 그냥서버임...was말구.. 
 
 
</body>
</html>