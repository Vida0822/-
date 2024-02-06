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

<h3> ex02_09.jsp  </h3>

<%
	String msg = "<h3>Hello world</h3><br>홍길동<br>" ;  
%>

<div>
	<%= msg %> <!-- html 로 '랜더링' 되어져서 뿌려짐  -->
</div>

<div>
	[c:out 태그] 
	JspWriter에 출력할 때 사용하는 태그 
	ㄴ value 속성 : 출력할 값 
	ㄴ escapeXml = "true" 기본값 
	< --> &lt; 변환  <!--  태그로 인식 못하게 문자열로 변환시켜주는거임 !  -->
	> --> &gt; 변환 
	& --> &amp; 변환 
	'  --> &#039; 변환 
	"  --> &#034; 변환 
	
	<c:out value="<%= msg %>"></c:out> <!-- <h3>Hello world</h3><br>홍길동<br> => 그대로 뿌려짐  -->
</div>
</body>
</html>