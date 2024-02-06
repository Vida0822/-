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
    4. pageContext * :PageContext    				JSP 페이지 대한 정보를 저장하는 객체. (페이지의 '정보'를 저장하는 객체)
		1) pageContext.setAttribute("name", "admin") ;
			: '하나의 페이지'(scope)에서 사용할 수 있는 속성값을 저장 /읽기 작업을 할 수 있게함 
		2) jsp 기본 내장 객체를 얻어올 수 있다
			ㄴ 바로 내장객체를 호출할 수 있는데 이렇게 굳이 얻어오는 이유? 
				커스텀 태그를 구현할 때 사용 
</pre>
<%
	//request.getParameter("age"); 
	pageContext.getRequest().getParameter("age"); //이거 자체가 request 객체 
	
	pageContext.getResponse(); // response 객체
	pageContext.getOut(); // out 객체 
	pageContext.getServletContext(); // application 객체 
	pageContext.getServletConfig() ; // config (설정정보객체) 얻어옴 
	
%>
</body>
</html>