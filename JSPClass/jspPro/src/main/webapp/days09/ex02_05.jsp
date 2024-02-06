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

<h3> ex02_05.jsp </h3>

<form>
국어 : <input type="text"  name="kor"> <!--  form 안에 입력태그가 하나인 경우 enter 치면 자동으로 submit-->
</form>

<%-- <c:if test=" ${ (90 lt param.kor) and (param.kor le 100) }"> 수 </c:if> --%>
<%-- <c:if test=" ${ 90 < param.kor && param.kor <= 100 }"> 수 </c:if> --%>

kor = ${param.kor }<br> <!--  ""  -->
empty = ${empty param.kor }<br> <!--  true -->

<c:if test="${not empty param.kor }">
	<c:set var="score" value="${ Math.floor(param.kor /10) }"  />
	<c:choose>
		<c:when test="${score eq 10 or score eq 9 }">수</c:when>
	</c:choose>
</c:if>


</body>
</html>







