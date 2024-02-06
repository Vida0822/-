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

<h3> ex02_10jsp </h3>

<%
	// 예외처리 
	try{
		// 예외가 발생할 수 있는 코딩 	
	}catch(Exception e ){
		
	}
%>
<!-- c:catch 태그 - 발생된 예외를 EL 변수에 저장할 때 사용되는 태그  -->

<c:catch var="exName" > <!--  이 변수(exName)에 여기서 발생한 예외 모든 정보가 다 담김  -->
	예외가 발생할 수 있는 코딩 
	예외가 발생할 수 있는 코딩 ** 
	예외가 발생할 수 있는 코딩 
</c:catch> 

<%-- <c:if test="${not empty exName}"></c:if> --%>
<c:if test="${exName ne null}">
	예외가 발생했습니다 : ${exName}
</c:if>


</body>
</html>