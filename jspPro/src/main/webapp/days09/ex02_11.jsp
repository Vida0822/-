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

<h3> ex02_11.jsp </h3>

<pre>
3) 국제화 
- 특정 지역에 따라 알맞은 메시지를 출력할 때 사용하는 태그 
	ㄴ 주로 사용 : 숫자, 날짜 포맷팅 
	formatNumber 
	formatDate 		: 숫자, 날짜 -> 특정 문자열?
	
	parseNumber 
	parseDate 		 : 특정 문자열 -> 숫자, 날짜 
</pre>

<%
	long price = 22345; 
%>

<fmt:formatNumber var="fmt_price" 
value="<%= price %>"
type="number" 
pattern="##,###.00"
/>
<!-- type : number(생략) , percent- % , curency - 통화형식  -->
<!--  pattern = "" :  DecimalFormat 사용되는 pattern  -->

price : ${fmt_price }<br> <!--  price : 22,345 --> 
<!--  세자리마다 콤마 출력  -->
price : <fmt:formatNumber  type="currency"  value="<%= price %>"/><br> <!-- ₩22,345 -->
<!-- currencySymbol="\\" -->
price : <fmt:formatNumber  type="percent"  value="<%= price %>"/><br> <!-- 2,234,500% -->

<%
	Date now = new Date();
%>
now : <%= now %><br> <!--  now : Thu May 25 12:40:48 KST 2023  -->
<!--  EL에서 now 변수명으로 사용하기 위해 c:set으로 변수 선언  -->
<c:set var="now" value="<%= now %>" />
<li><fmt:formatDate value="${now}"/></li> <!--  2023. 5. 25. -->
<!--  type : [date], time, both  -->
<li><fmt:formatDate type="time" value="${now}"/></li> <!-- 오후 12:43:49 -->
<li><fmt:formatDate type="both" value="${now}"/></li> <!-- 2023. 5. 25. 오후 12:43:49 -->

<li><fmt:formatDate pattern="yyyy년 MM월 dd일" value="${now }"/> </li> <!-- 2023년 05월 25일  -->

<li><fmt:formatDate dateStyle="full" value="${now }"/> </li> <!--2023년 5월 25일 목요일  -->
<li><fmt:formatDate dateStyle="short" value="${now }"/> </li> <!-- 23. 5. 25. -->
<li><fmt:formatDate dateStyle="long" value="${now }"/> </li> <!-- 2023년 5월 25일 -->
<li><fmt:formatDate dateStyle="medium" value="${now }"/> </li> <!-- 2023. 5. 25. -->

</body>
</html>













