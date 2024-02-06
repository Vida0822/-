<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page session="true" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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

<h3> ex05.jsp </h3>

<pre>
[세션(session)]
쿠키 - 클라이언트에서! 상태관리하는 기술  (데이터가 저장되는 곳이 클라)
세션 - 서버에서! 상태관리하는 기술 (데이터가 저장되는곳이 서버)
('상태관리' : 인증처리, 장바구니 구현)
DB - 에서도 상태관리 가능 
=> 어디서 할지 생각 ! 

1. 세션은 언제 생성되는가? 
	ex) 교육원 상담 + 결재 + 교육과정 수강 
		[이름]캐비넷()  - 교육을 받는 6개월 동안 각자가 사용할 수 있는 저장공간 
						(-> 연결되어있는 동안 사용할 수 있는 저장공간)
						
			ㄴ> 수료/중도취소 (자의/강제) : 우리 캐비넷은 사라지고(더이상 우리 저장공간이 아님 ! ) 다른 사람들한테 배정  
			
	=> 세션은 언제 생성되는가? 처음 요청이 일어나면 세션 객체 생성 (객체 = 물건)
	ex01.jsp를 첫 요청 -> 그 접속자가 사용할 수 있는 케비넷 생성 [세션 객체] 
	자물쇠 - 세션 ID 쿠키로 생성해서 클라이언트에 저장  -> JSESSIONID: 세션의 아이디값을 담고 있음 
	-> 여기에 저장된 값(value)를 통해 요청을 보낸 웹 브라우저가 현재 연결되어있는지 (세션이 살아있는지) 확인 
	 (접속시 접속자마다 그 사람만 사용할 수 있는 케비넷이 만들어짐 -> 각자 '클라이언트'의 쿠키로 저장)
	
	* 그럼 그냥 브라우저만 켜도 ㄱㅊ? 
		ㄴㄴ 보통 세션타임아웃이 있음 -> 아무 요청도 하지 않았을 때 일정 시간이 지나면 세션 끊어짐 ('라운드 트립' 안하면 끊어짐)
		+ 브라우저 다 꺼도 끊어짐 
		
 	* 근데 또 바로 끊어지느냐 ? 
		ㄴㄴ 어느정도는 서버에 남아 있음 ex) 브라우저 나갔다가 바로 들어오면 아직 로그인 유지되는 경우 있음  
		-> 이건 서버에서 정할 수 있음 (강제로 끊을 수도 있고 일정시간 남겨둘 수도 있고! )
		
		ㄴ 며칠 안오더라도 케비넷은 남아있듯이 페이지 이동 -> 브라우저 켜있는동안 내 세션은 사라지지 않음 
		
		
	* JSEESSIONID  - /jspPro (path)  
	 - E1CFCE43C2D9C11A937F526DF65975A0 (days07/ex05.jsp)
	 ==  
	 	E1CFCE43C2D9C11A937F526DF65975A0 (days06/ex05.jsp)
	
	
2. 세션(session)은 언제 소멸되는가? 
	session.setAttribute()
	session.getAttribute()
	
	
</pre>

<%
	// getId()  == JSEESSIONID (쿠키값 )
	// long getCreationTime() - 1970.1.1~ 이후 ms 
	// long getLastAccessedTime() - 1970.1.1~ 이후 ms 
	String sid = session.getId(); 

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
	Date d = new Date(); 
	
	d.setTime(session.getCreationTime() ) ; 
	
	long lastms = session.getLastAccessedTime();
	d.setTime(lastms); 
%>
세션 ID : <%= sid %><br>  
세션 생성 날짜 : <%= sdf.format(d) %><br> 
세션의 마지막 접속 날짜 : <%= sdf.format(d) %><br>  

세션 ID :  E1CFCE43C2D9C11A937F526DF65975A0 <!--  == 쿠키에서 본거랑 똑같음 --> 
세션 생성 날짜 : 2023-05-23 15:09:02
세션의 마지막 접속 날짜 : 2023-05-23 15:49:27

<!--  브라우저 다 끄고 (톰캣도 재실행해서 ) 결과 확인 -->
세션 ID : 842C9ABE60F19444E24665732CF71F13 <!--  다른 세션  -->
세션 생성 날짜 : 2023-05-23 15:52:10
세션의 마지막 접속 날짜 : 2023-05-23 15:52:10


3. 실습 
[인증처리 - 쿠키] 복붙 
: 	ex06_default.jsp
	ex06_logon.jsp
	ex06_logout.jsp
</body>
</html>