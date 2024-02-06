<%@page import="com.util.Cookies"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!--  auth 쿠키 삭제시 로그아웃 -->
<%@ include file="/WEB-INF/inc/auth.jspf" %>
<%-- <%
	String cname = "auth"; 
	String logonID = null; 
	
	Cookies cookies = new Cookies(request); // request -> 이 페이지에서 사용되는 모든 쿠키정보가 생성된거임 
	
	if(cookies.exists(cname) ){ // 로그인 o 
		logonID = cookies.getValue(cname); 
	}	
%> --%>

<%
	Cookie c=  cookies.createCookie("auth","","/",0);
	response.addCookie(c);
%>

<script>
	alert("<%= logonID%>님 로그아웃 하셨습니다 ")
	location.href = "ex03_default.jsp";
</script>