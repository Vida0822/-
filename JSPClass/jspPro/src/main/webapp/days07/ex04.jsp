<%@page import="com.util.ConnectionProvider"%>
<%@page import="java.sql.Connection"%>
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

<pre>
우리는 지금까지 Connection 객체를 DBConn.getConnection() 메서드로 얻어왔습니다
Connection 객체 필요할때마다 생성 -> 사용 : 성능 떨어짐 -> 동시 접속자가 많은 경우 더 문제가 된다 
(전체 웹 사이트의 성능이 떨어진다)
-> 이런 문제를 해결하기 위해 '커넥션풀' 을 사용한다

풀(pool) = [Connection1 , Connection2...] 필요한 만큼 Connection 객체들 미리 생성해놓음 
ㄴ 접속자가 오면 Connection 을 생성하는게 아닌 그냥 미리 만들어 놓은 것중에 하나 건네주는거임 
  ㄴ 여기서의 close()  : Connection 객체를 소멸시키는게 아니라 다시 풀에 넣어주는거임 
  
 *커넥션 풀 사용방법 
 1) DBCP(Database Connection Pool)를 이용해서 커넥션 풀 사용하기 
 2) WAS(톰캣)을 이용한  커넥션 풀 사용하기 **** (근데 특별한 이유는 ㄴㄴ..)
 		ㄱ. tomcat_dbcp.jar 파일 추가 
 		ㄴ. 톰캣 시작될 때 커넥션풀을 초기화 
 		
 		https://tomcat.apache.org/tomcat-8.5-doc/jndi-datasource-examples-howto.html#Database_Connection_Pool_(DBCP_2)_Configurations 
 		Database Connection Pool (DBCP 2) Configurations 
 		Oracle 8i, 9i & 10g
 		
 		- META-INF 폴더 안에 content.xml 파일 생성 
  		- web.xml 에 코딩추가  <resource-ref>
  		
  		ㄷ. .com.util.ConnectionProvider.java      DBConn 
</pre>

<%
	Connection conn=	ConnectionProvider.getConnection();
	out.print(conn);  // 2059391177, URL=jdbc:oracle:thin:@127.0.0.1:1521:xe, Oracle JDBC driver
	conn.close(); // 커넥션풀에 커넥션 객체를 반환한다는 의미 !  
%>


</body>
</html>










