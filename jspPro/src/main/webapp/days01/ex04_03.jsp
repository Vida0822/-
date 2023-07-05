<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
</head>
<body>
<h3>ex04_03.jsp</h3>
<p id="demo">
<%
for(int i = 1; i <= 10; i++) {
	// out.append( i ); // 매개변수 문자열만
	// out.print( i + "<br>" ); // 매개변수 모든 자료형 가능
%><%= i %><br><%
}
%>

<%-- 
<%
int sum = 0;
for(int i = 1; i <= 10; i++) {
%><%= i %>+<%
	sum += i;
}
%>=<%= sum %>
--%>
</p>
<script>
</script>
</body>
</html>