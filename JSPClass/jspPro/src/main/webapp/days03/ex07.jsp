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

<h3> ex07.jsp </h3>

<form action = "ex07_ok.jsp" method="get">
	아이디 : <input type="text" name = "id" value ="admin"><br>
	비밀번호 : <input type="password" name = "passwd" value ="1234"><br>
	<input type="submit" value ="logon"> 
</form>

<%
	String ok = request.getParameter("ok"); 
	String error = request.getParameter("error"); 
	if(ok != null){ 	// <-> ex07.jsp?ok 로 넘어온다면!  <->  로그인 성공한 후에 ex07.jsp 다시 요청한다면 ! 
%>		
	<!-- [문제1] 경고창... 여기서 가능..? ㄴㄴ 클라이언트에서 띄울 수 밖에 없음 ! (서버에서 못띄움 )-->
	<script>
		alert("로그인 성공!! "); 
	</script>
<%	
	}else if(error != null){ 
	// 로그인 실패한 후에 ex07.jsp 를 다시 요청한다면 
%>		
	<script>
		alert("로그인 실패!! "); 
		$(function() {
			$(":text").eq(0).focus().select(); 
			// 실패하면 ㅡ그 위치에 다시 포커스! 
		}); 
	// 처음에 이 소스코드 안넘어옴!! 왜 ????????
	</script>
<%
	}
%>



<pre>
ex07.jsp					request.getParameter("ok") => null ** 
ex07.jsp?ok				request.getParameter("ok") => ""    ** 
ex07.jsp?error
</pre>

</body>
</html>