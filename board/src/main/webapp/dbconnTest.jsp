<%@page import="jdbc.connection.ConnectionProvider"%>
<%@ page contentType="text/html; charset=utf-8"%> 
<%@ page import="java.sql.*" %>
<html>
<head><title>연결 테스트</title></head>
<body>
<%
	try (Connection conn = ConnectionProvider.getConnection()) { // close() 하는 거 생략하고 싶으면 이 괄호안에 넣어줘야함 : try-with-resource
		out.println("커넥션 연결 성공함");
	} catch(SQLException ex) {
		out.println("커넥션 연결 실패함 : " + ex.getMessage());
		application.log("커넥션 연결 실패", ex);
	}
%>
</body>
</html>
