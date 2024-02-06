<%@page import="java.util.Iterator"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.Set"%>
<%@page import="com.util.Cookies"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>2023. 5. 24. - 오후 4:54:12</title>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
</head>
<body>
<h3>ex03_03_ok.jsp</h3>
<%
   Cookies cookies = new Cookies(request);
   Set<Entry<String, Cookie>> set = cookies.cookieMap.entrySet();
   Iterator<Entry<String, Cookie>> ir = set.iterator();
   while( ir.hasNext() ){
	   Entry<String, Cookie>  en=   ir.next();
	   String cname = en.getKey();
	   Cookie c =  en.getValue(); 
%>
  <li><%= cname %> :  <%= c.getValue() %></li>
<%	   
   } // while
%>
<hr>
EL user : ${  cookie.user.value } <br>
EL id : ${  cookie.id.value } <br>
EL age : ${  cookie.age.value } <br>
<hr>
EL cookie  == Map(key 쿠키이름, value 쿠키객체)<br>

<c:forEach items="${  cookie }"  var="entry">
  <li> ${  entry.key } : ${ entry.value.value }  </li>
</c:forEach>

</body>
</html>


EL 
JSTL
Filter ***
ServletContextListener 
방명록~ + MVC

금 + 답변형게시판 / 설문자 + MVC






