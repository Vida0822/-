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

<h3> ex01_04.jsp </h3>

<pre>
ex01_02.jsp 에서 입력한 멤버정보로 
MemberInfo.java 객체를 생성해 그 객체를 사용해서 출력 ! 
</pre>

<%
	String id= request.getParameter("id"); 
	String name= request.getParameter("name"); 
	String passwd= request.getParameter("passwd"); 
	String email= request.getParameter("email"); 
	Date registerDate = new Date(); 
	
	// 객체 생성 + 저장 
	/* 
	MemberInfo mi = new MemberInfo(); // 객체를 생성하고
	mi.setId(id); // setter 함수를 이용해 private 변수들 값 넣어주기 
	mi.setName(name);
	mi.setPasswd(passwd);
	mi.setRegisterDate(registerDate);
	mi.setEmail(email);
	
	=> jsp:useBean  액션태그로 같은 작업해보기!  
	*/ 
%>
<!--  위에거랑 100% 똑같은 코딩 !  -->

<jsp:useBean id="mi" class="days07.MemberInfo" scope="page" ></jsp:useBean>
<!--  class명은 fullName을 줘야함!  -->
<%-- <jsp:setProperty property="setId" value="<%= id %>" name="mi"/> --%>
<!-- set 생략 + I는 소문자로  -->
<jsp:setProperty property="id" value="<%= id %>" name="mi"/>
<jsp:setProperty property="name" value="<%= name %>" name="mi"/>
<jsp:setProperty property="passwd" value="<%= passwd %>" name="mi"/>
<jsp:setProperty property="email" value="<%= email %>" name="mi"/>
<jsp:setProperty property="registerDate" value="<%= registerDate %>" name="mi"/>



<!--  출력도 자바빈 객체 이용해서  -->
아이디 : <%= mi.getId() %> <br>
이름 :<%= mi.getName() %> <br>
비밀번호 : <%= mi.getPasswd() %> <br>
등록일 :<%= mi.getRegisterDate() %> <br>
이메일 : <%= mi.getEmail() %> <br>

</body>
</html>











