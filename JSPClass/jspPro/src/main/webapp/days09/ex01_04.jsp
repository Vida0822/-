<%@page import="java.text.DecimalFormat"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
[	EL에서 객체의 메서드 호출 
	EL에서 static 메서드 호출 ] 
	days09.FormatUtil 클래스 추가 
</pre>

<%
	long price = 22345 ; 
%>
price(표현식) = <%= price %> <br> 
price(세자리마다 콤마 찍어서 출력) = <%= String.format("%,d", price) %> <br>
<%
	String pattern = "##,###" ; 
	DecimalFormat df = new DecimalFormat(pattern); 
%>
price(세자리마다 콤마 찍어서 출력) = <%=df.format(price) %> <br>

<%
	request.setAttribute("price",price); 
%>
price(EL) = ${price } <br>
price(EL) = ${request.price } <br>

<!--  line 4  -->
<%-- price(EL) = <fmt:formatNumber></fmt:formatNumber><br> --%>
price(EL) = <fmt:formatNumber value="${price }" pattern="#,###" /><br>



<hr>





</body>
</html>