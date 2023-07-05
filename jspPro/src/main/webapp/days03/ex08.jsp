<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String ok = request.getParameter("ok");  // 로그인 성공 (인증 o)
	String error = request.getParameter("error");  // 로그인 실패 (인증 x)
	// 이거 어디서 얻어오길래 여기다 써줘요? ex08_02! 에서 처리(이 url로 하여금 다시 redirect가 일어나도록) 해줄거라고 생각하고 미리 해준거
	String name = request.getParameter("name");  // 로그인 실패 (인증 x)
	// 이 페이지가 다시 요청하는 리다이렉스 대상 url이기 때문에 ! (요청 주체이자 요청 대상) parameter를 얻을 수 있다  

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
</head>
<body>

	<h3>ex08.jsp</h3>

	<div id="logon">
		<form action="ex08_02.jsp" method="get">
			아이디 : <input type="text" name="id" value="admin"><br>
			비밀번호 : <input type="password" name="passwd" value="1234"><br>
			<input type="submit" value="logon">
		</form>
		<!--  로그인 성공시 얘네 안보임!!  -->
	</div>
	
	
	<div id="logout">
		[<%= name %>]님 로그인 하셨습니다<br>
		<button> 로그아웃 </button>
 	</div>
 	
 	<script>
 		$("#logout").hide(); 
 	</script>
 	
 	
 	
 	
 	
	 <!--  로그인 안해도 누구나 사용가능  -->
	<a href="#"> 설문조사 </a><br> 
	
	<%
		if(ok != null){
	%>
			<!--  로그인 해야 사용가능 -->
			<!--  로그인 성공했을 때 보여지는 html  -->
			<a href="#"> 일정관리 </a><br> 
			<a href="#"> 게시판 </a><br> 
			
			<!--  로그인 성공했을 때 보여지는 <script> -->
	<script>
		$(function() {
			alert("로그인 성공!"); 
			$("#logon").hide(); 
			$("#logout").show(); 
		}) ; 	
	</script>
	<%		
		}
	%>


<!--  여기까진(12:28) 그냥 구별없이 다 보여지고 있음  -->
<!--  로그아웃은 안할거임!!! (12:43) -->	

</body>
</html>