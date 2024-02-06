<%@page import="java.util.Enumeration"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Insert title here</title>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
</head>
<body>

<!--  request 객체 => head 정보  -->

<pre>
	getHeader(String name) : 지정한 이름의 헤더값을 반환 
	getHeaders(String name) : 지정한 이름의 헤더들(목록)을 반환   => Enumeration (여러형)
	getHeaderNames() : 모든 헤더이름 반환  => Enumeration 
	
	getIntHeader(String name) : 지정한 이름의 정수형 헤더값을 반환 
	getDateHeader(String name) : 지정한 이름의 시간값을 반환 
	
</pre>

<h3> 요청 헤더 목록 조회 </h3>
헤더가 뭐야????????????????????????????????????????????????


<ol>

	<%
	Enumeration <String> en = request.getHeaderNames();
	while(en.hasMoreElements()){
		String headerName = en.nextElement();
		String headerValue = request.getHeader(headerName); 
	%> <li><%= headerName %> : <%= headerValue  %></li><%
	} // while 
	%>


</ol>





</body>
</html>