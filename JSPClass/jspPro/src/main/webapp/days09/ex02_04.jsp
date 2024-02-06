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

<h3> ex02_04.jsp </h3>

<pre>
	제어문 ! 
	c:if 문 
	ex02_04.jsp?num=30 - 홀수/ 짝수 
</pre>

<%-- 
<c:set var="pnum" value="${param.num }" ></c:set> 
<c:if test="${pnum mod 2 eq 0 }">짝수</c:if>
<c:if test="${pnum mod 2 eq 1 }">홀수</c:if> --%>
 <!--  param 입력 안했는데도 짝수 : parameter가 없으면 0으로 인식 -->
 
<c:choose>
	<c:when test="${param.num mod 2 eq 0 }">짝수</c:when>
	<c:otherwise> 홀수 </c:otherwise>
</c:choose> 

</body>
</html>