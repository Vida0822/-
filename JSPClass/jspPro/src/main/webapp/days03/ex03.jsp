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

<pre>

	[jsp 기본 내장 객체 - request 객체]

1. 요청할 때 사용되는 객체 (웹 브라우저 -> 요청 -> 웹 서버)
	ㄴ 이 요청할 때 발생하는 모든 정보가 담겨져 있는 객체 
2. 요청정보 객체
3. 클라이언트가 전송한 파라미터, 쿠키, 헤더 등 읽기 가능 
							ex04		따로	ex05
4. 서버와 관련된 정보 읽기 

</pre>

[request 객체에서 자주 쓰이는 메서드]
*** 1. contextPath(컨텍스트 루트) : <%= request.getContextPath() %> <br>  /jspPro
*** 2. 클라이언트 IP 주소 : <%= request.getRemoteAddr() %><br>  0:0:0:0:0:0:0:1 (로컬이라!)
*** 3. 요청 전송 방식  : <%= request.getMethod() %><br>  GET
*** 4. 요청 url : <%= request.getRequestURL() %><br> http://localhost/jspPro/days03/ex03.jsp
*** 5. 요청 uri : <%= request.getRequestURI() %><br> /jspPro/days03/ex03.jsp

</body>
</html>