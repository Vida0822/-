<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
JSTL은 EL에서 사용할 수 있는 함수를 제공하고 있따
</pre>

<%
	String msg = "<b>Message</b>입니다"; 
%>

<c:set value="<%= msg %>" var="msg"></c:set>
${msg }<br>
${fn:length(msg)}<br> 
${fn:toUpperCase(msg)}<br>
${fn:toLowerCase(msg)}<br>
${fn:substring(msg,1,4)}<br>
${fn:contains(msg,1,4)}<br>
${fn:indexOf(msg,"ssa")}<br>
${fn:trim(msg)}<br>

fn:replace(),
fn:startsWith(),
fn:endsWith(),
fn:split(),
fn:join(),
fn:escapeXml()

</body>
</html>


















