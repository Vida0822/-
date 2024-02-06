<%@page import="com.util.Cookies"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/inc/auth.jspf" %>
<%-- <%
	// 쿠키를 사용해 로그인(인증) 처리할 예정 
	// 로그인 성공(인증처리)하면 auth를 쿠키이름(cName) 으로, 로그인ID를 쿠키값(cValue)으로 저장
	// auth라는 이름이 쿠키목록에 있니? 있으면 로그인 상태 ! 
	
	String cname = "auth"; 
	String logonID = null; 
	
	Cookies cookies = new Cookies(request); // request -> 이 페이지에서 사용되는 모든 쿠키정보가 생성된거임 
	
	if(cookies.exists(cname) ){ // 로그인 o 
		logonID = cookies.getValue(cname); 
	}
%>
 --%>



<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% String contextPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<style>
div {
	border: 1px solid gray;
	width: 300px;
/*  	height: 100px;
	padding: 20px;   */
}
</style>

</head>
<body>

	<h3>ex03_default.jsp</h3>
	
<%
	if(logonID == null){ // 인증 x 
%>
	<div id="logon">
		<form action="ex03_logon.jsp">
			아이디 : <input type="text" name="id" value="admin" /><br>
			 비밀번호 : <input type="password" name="passwd" value="1234" /><br> 
			 <input type="submit" value="로그인" /> 
			<span style="color: red; display:none">로그인 실패했습니다.</span>
		</form>
	</div>
<%		
	}else{
%>
	<div id="logout">
		[<%= logonID %>]님 환영합니다<br> 
		<a href="ex03_logout.jsp">로그아웃</a>
	</div>
	<%		
	}
%>

<a href= "/jspPro/cstvsboard/list.htm">게시판</a><br>
<a href ="#"> 공지사항 </a><br>

<%
	if(logonID != null){
%>
	<a  href ="#"> 자료실 </a> <br>
	<a  href ="#"> 일정관리 </a><br> 
<%		
	} // if
%>

<%
	if(logonID != null && logonID.equals("admin")){
%>
	<a  href ="#"> 급여관리 </a><br> 
	<a  href ="#">  인사관리 </a><br> 
<%
	}
%>
<script>
// ex03_default.jsp?logon=fail 
		
	$(function() { // 실패 span 띄우기 
		if(${param.logon eq 'fail' }){
			$("#logon span")
				.fadeIn(3000)
				.fadeOut(3000);
		}//if
	});

</script>



</body>
</html>