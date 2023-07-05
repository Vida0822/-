<%@page import="java.util.Enumeration"%>
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

<h3> ex06_03.jsp </h3>

<pre>
	
</pre>

<%
	Enumeration<String> en = application.getInitParameterNames();
// 웹 사이트 전체를 관리하는 객체의 초기화 파라미터를 얻어오겠다 (Enumeration<String>) 
	while(en.hasMoreElements()){
		String ParamName = en.nextElement(); //  password , logEnabled, 	user : web.xml에 설정된 context-param> param-name 속성값을 얻어와서 열거형으로 반환하는 메서드 
		String paramValue = application.getInitParameter(ParamName);
%>
<li> <%= ParamName %> </li> 
<%
	} 
	// 팀원 공통적으로 사용할 속성값이 있다면 xml에 선언해 파라미터 통일! 
	
	// 요청할때 넘어오는 parameter와 똑같은 속성인데! 그게 이 브라우저 자체에 저장된 공통적인 파라미터라는게 다름  
%>

</body>
</html>