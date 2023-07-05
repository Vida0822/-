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

<h3> ex03.jsp </h3>

<pre>
	[표현언어 (Expression Language == EL )]
	
	
1. EL 정의 
	1) 표현식 <%= %>보다 간결하고 편리  
	2) 표현식 = 출력용 스크립트 요소
	3) EL == 또 다른 형태의 출력용 스크립트 언어 
	4) JSP 2.3, EL 3.0 

2. EL 사용하는 곳 (EL 기능)
	1) EL도 JSP 4가지 영역의 속성을 사용할 수 있다
		ㄴ pageContext scope , request scope , session scope , application scope 
	2) == eq  		!= ne  		! 		not 	empty 
		ㄴ 수치연산, 관계연산, 논리연산자 제공 
	3) 자바 클래스의 메서드 호출가능 
	4) 람다식도 사용가능 (EL 3.0~)
	5) 쿠키, jsp 기본내장객체
	6) 스트림 API, 정적 메서드 실행 . 
	
	ex) ?age=10 
<%-- 	
	<%= request.getParameter("age") %>
	${param.age }	 
--%>

3. EL 형식 
	: ${ expression(표현식)  }

</pre>


<pre>
4. jsp 기본내장객체 9가지 : r,r,s,a,e,o, 등 
	+ EL 기본 내장 객체
	1) param = request.getParameter() 
		paramValues == request.getParameterValues() 
	2) pageContext == page 
	3) pageScope 
		requestScope 
		sessionScope
		applicationScope 
		=> EL '객체' 
	4) header == request.getHeader() 
		headeValues == request.getHeaders() 
	5) cookie 
	6) initParam == application.getInitParameter() 
	
	 

</pre>

</body>
</html>