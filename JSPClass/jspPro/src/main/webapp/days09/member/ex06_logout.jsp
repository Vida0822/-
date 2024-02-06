<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String contextPath = request.getContextPath(); %>

<%
	// session.removeAttribute("auth"); 
	session.invalidate(); // 엥?? 아에 브라우저 접속을 끊는다는 얘긴가 이게맞나? 
			
	// 리다이렉트 
	String location ="/jspPro/days09/ex05.jsp"; 
	response.sendRedirect(location);
	
	
%>
