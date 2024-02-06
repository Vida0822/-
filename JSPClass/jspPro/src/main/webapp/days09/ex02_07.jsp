<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
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

<c:set var="m" value="<%= new int[] {3,5,2,4,1} %>" ></c:set>

<c:forEach items="${m }" var="n" varStatus="s">
	<li>m[${s.index }] = ${n }
</c:forEach>

<hr>

<%
	Map<String, String> map = new HashMap<>(); 
	map.put("id","admin"); 
	map.put("age","20"); 
	map.put("name","홍길동"); 
%>

<c:set var="person"  value="<%= map %>"/>
${person.id }<br>
${person.age}<br>
<hr>

<c:forEach items="${person }" var="entry" >
	<li> ${entry.key } - ${entry.value }</li>
</c:forEach>

</body>
</html>










