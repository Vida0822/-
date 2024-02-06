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

<%
	String name = request.getParameter("name");
/* 	int age = Integer.parseInt( request.getParameter("age"));
	=> 이거 당연히 안됨 왜 ? redirect 시 요청값이 없는데(null) 이걸 parsing하려하니 오류  */
%>

> 이름 : <%= name %><br>
<%-- > 나이 : <%= age %><br> --%>
</body>
</html>