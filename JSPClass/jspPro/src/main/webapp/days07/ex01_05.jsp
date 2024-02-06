<%@page import="days07.MemberInfo"%>
<%@page import="java.util.Date"%>
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

<h3> ex01_05.jsp </h3>

<pre>
ex01_02.jsp 에서 입력한 멤버정보로 
MemberInfo.java 객체를 생성해 그 객체를 사용해서 출력 ! 
</pre>

<%-- <%
	String id= request.getParameter("id"); 
	String name= request.getParameter("name"); 
	String passwd= request.getParameter("passwd"); 
	String email= request.getParameter("email"); 
	Date registerDate = new Date(); 
%> --%>
<!--  위에거랑 100% 똑같은 코딩 !  -->

<% 	Date registerDate = new Date();   %>
<jsp:useBean id="mi" class="days07.MemberInfo" scope="page" ></jsp:useBean>
<!--  days07.MemberInfo 클래스로 객체를 만들어서 id = "mi"에 담는다  -->

<%-- <jsp:setProperty property="id" value="<%= id %>" name="mi"/>
<jsp:setProperty property="name" value="<%= name %>" name="mi"/>
<jsp:setProperty property="passwd" value="<%= passwd %>" name="mi"/>
<jsp:setProperty property="email" value="<%= email %>" name="mi"/> --%>
<!--  객체 mi의 email 속성에 날라온 파라미터터인 email을 담는다  -->

<jsp:setProperty property="*" name="mi"/> <!--  정상적으로 출력 -> 생략 : parameter 받아서 객체 생성  -->
<!-- 객체 mi의 모든 속성에 날라온 파라미터들을 다 담는다 -->

 <jsp:setProperty property="registerDate" value="<%= registerDate %>" name="mi"/>
 <!-- 등록일은 입력받는게 아니라 서버에서 만들어주는 값이기 때문에 자바코딩으로 따로 생성해서 추가해줘야함  -->

<!--  출력도 자바빈 객체 이용해서  -->
<%-- 아이디 : <%= mi.getId() %> <br> --%>
아이디 :[<jsp:getProperty property="id" name="mi"/>] <br>
이름 :[<jsp:getProperty property="name" name="mi"/>]<br>
비밀번호 : [<jsp:getProperty property="passwd" name="mi"/>] <br>
이메일 : [<jsp:getProperty property="email" name="mi"/>] <br>
등록일 :[<jsp:getProperty property="registerDate" name="mi"/>] <br>

</body>
</html>











