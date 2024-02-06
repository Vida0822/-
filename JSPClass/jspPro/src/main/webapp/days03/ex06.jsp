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

<h3> ex06.jsp </h3>

<pre>
	jsp 기본 내장 객체 (9가지) - requset, [response] 
	
	1. requset(요청) 의 반대기능. 즉, 응답 ! 
	2  웹 서버 -- 정보전달(응답) -> 웹브라우저 정보를 전달하는 역할 
	3. 기능 (2가지)
		1) 헤더 정보 설정  	
			addHeader(name, value) 
			addIntHeader(name , value)
			addDateHeader(name,long) 
			
			setHeader()
			setIntHeader()
			setDateHeader() 
			
			containsHeader(name) => t/f 
			
			
		2) 리다이레트(redirect) / 포워딩(forwarding) 	***
			ㄱ. 리다이렉트 ***
				- 페이지를 이동하는 기능 
				(사전적 의미 : 다른 방향으로 다시 보내다, 전송하다)
				=>  웹 브라우저가 웹 서버에 어떤 URL을 요청했을 때
					, 서버가 리다이렉트를 지시하는 특정 HTTP 응답을 통해 
					웹 브라우저로 하여금 지정된 다른 URL로 재요청하라고 지시하는 것
					
				  웹브라우저 --- a.jsp (url)로 요청 ---> 웹 서버 	 
		 							<---응답 ------ 
		 							: " 이 url(b.jsp)로 다시 요청하세요~""
		 							('리다이렉트' : 이 응답자체 !  ) 
		 							
				   웹브라우저 	--- b.jsp 요청 (로그인 성공화면/ 로그인 실패화면) 요청	----> 웹서버 
									<--- 응답 ---- 
									
					=> 클라이언트로 가서 다시 요청이 일어난게 리다이렉트 
						**  리다이렉트는 두번 요청이 발생한다!	**
		
				실습) 리다이렉트(redirect)
				 - ex07.jsp 			/ ex07_ok.jsp 			/ ex07_02.jsp 
				 	아이디, 비밀번호 ->		로그인 성공, 실패 		테스트
				 	[로그인 인증] 	-> 리다이렉트 

*로그인 성공했을 때 보내는 요청 url과 실패했을때 보내는 요청 url은 달라질거임 ! 


</pre>


</body>
</html>