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

<h3> ex03_02.jsp </h3>

요청 URI (표현식) : <%= request.getRequestURI() %> <br><!--   /jspPro/days08/ex03_02.jsp -->
요청 URI (EL) : ${  pageContext.request.requestURI  }<br><!--   /jspPro/days08/ex03_02.jsp -->
<!--  pageContext -> jsp 의 모든 기본객체들 사용할 수 있음  --> 

<hr>
<%
// request scope 저장 
	request.setAttribute("name", "홍길동"); 
%>

이름(표현식) : <%= request.getAttribute("name") %><br> 
이름(EL) : ${requestScope.name }<br>  
이름(EL) : ${name }<br>  

 		pageScope  -> name?  
 			↓
		requestScope -> name?  
			↓
		sessionScope -> name?  
			↓
		applicationScope -> name?  
		
 		ㄴ 영역(scope) 생략하면 모든 영역을 검사한다 

<hr> 
<!--  ?age=20  -->
age(표현식) : <%= request.getParameter("age") %><br> 
age(EL) : ${param.age  } <br> 
				※ 위에거랑 헷갈 ㄴㄴ param 붙여줘야한다 
</body>
</html>