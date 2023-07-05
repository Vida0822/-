<%@page import="days09.FormatUtil"%>
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

<h3> ex01_05.jsp </h3>

<%
	long price = 22345; 
	request.setAttribute("price", price);
%>

<%-- price(EL) : ${price }<br> --%>

<!--  FormatUtil.number()  -> EL에서 사용 -->
<%
 	FormatUtil f = new FormatUtil(); 
	request.setAttribute("f", f);  
%>
	price(EL_instance) : ${f.number(price , "#,##0")  }<br> 

<!--  FormatUtil.staticNumber()  -> EL에서 사용 -->
 price(EL_static) : ${ FormatUtil.staticNumber(price,"#,##0") }<br> 


<%
/* 	FormatUtil f = new FormatUtil();
	f.number(number, pattern) ;  */
%>
</body>
</html>