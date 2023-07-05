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

<h3> ex02.jsp </h3>

<pre>
[JSP 쿠키]
1. cookie? 클라이언트 (웹 브라우저)에 텍스트 형식으로 저장된 파일 
2. [클 url]  --요청[쿠키]--> 서버에 함께 전송  
3. 상태관리 : 못들음 
4. js 쿠키 생성, 수정, 삭제 -> document.cookie 속성을 사용해 저장, 읽어오기 
	ㄴ 클라이언트인 웹 브라우저에서 
	ㄴ 쿠키 저장버튼을 클릭하면 클라이언트에 잘 생성 
	
5. 우린 서버에서 ! (jsp)
	ㄴ jsp 쿠키 생성 처리과정 
		1) [클] 	- 요청 -> [서버]
										jsp > 쿠키 생성 명령코딩
			[클]	<- 응답 -  
			ㄴ 쿠키생성 						=> 실제 쿠키는 클라이언트에서 생성되지만 그 쿠키를 생성하는 코딩은 서버에서 하는거임 ! 
			
			[클]   - 요청 ->  [서버]  
										jsp > 쿠키 삭제 명령코딩
			[클]	<-응답 -
			ㄴ 이 명령을 받아 쿠키 삭제가 클라이언트에서 일어남 ! 

6. 쿠키 구성 
	1) 쿠키 이름 (필수)
	2) 쿠키값 (필수)
	3) 만료시점 (유효시간)
			-1 (서버 명령)  :	브라우저 닫을 때 쿠키 자동 제거 (응답 받고, 일하고 브라우저 닫힐때)
 		 	 0 (서버 명령) : 응답받은 즉시 쿠키 제거 (응답 받자마자)
 			별도의 만료시점 설정 x : 웹 브라우저가 종료될 때 쿠키 자동 제거 
	4) 도메인 
	5) 경로 (path)
	6) 보안 (security) 
	
7. jsp 쿠키 생성 
	ㄴ Cookie 클래스 사용한다
	ㄴ Cookie 쿠키 객체를 생성 + 응답에쿠키추가 
		: response.addCookie(쿠키 객체) 
			(응답에, 쿠키 객체를 붙힌다)

8. ex02_02.jsp 
	ex02_03.jsp
</pre>

<a href="ex02_02.jsp" >jsp 쿠키 생성 </a> <br>
<a href="ex02_03.jsp" > jsp 쿠키 확인</a> <br>



</body>
</html>








