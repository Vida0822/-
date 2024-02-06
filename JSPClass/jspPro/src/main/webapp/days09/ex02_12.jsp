<%@page import="java.time.LocalDate"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
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

<h3> ex02_12.jsp </h3>

<%
	String strPrice = "1,200.34"; 

//	String => double 형 변환 (parse 없이)
	strPrice =	strPrice.replaceAll(",", "");  // 1200.34
	double price = Double.parseDouble(strPrice);
	
	int qty = 14; 
%>
	<fmt:parseNumber value="<%= strPrice %>" pattern="0,000.00" var="price"/>
	<c:set var="qty" value="<%= qty %>" ></c:set>
	총 판매금액 : ${price * qty }<br>  <!--  총 판매금액 : 16804.76 -->
	<hr>
	
<%
 	String strNow = "2023년 12월 13일"; 
/*	Date now = new Date(2023-1900, 12-1, 13) ; */
	
/* 	String pattern = "yyyy년 mm월 dd일"; 
	SimpleDateFormat sdf = new SimpleDateFormat(pattern); 
	Date now = sdf.parse(strNow);  */
	
/* 	String pattern = "yyyy년 mm월 dd일" ;
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
	LocalDate now = LocalDate.parse(strNow, dtf); 
	 */
	
%>

<fmt:formatDate value="<%= strNow %>" pattern="yyyy년 mm월 dd일" var="now"/>
	
</body>
</html>











