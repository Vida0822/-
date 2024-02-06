<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String contextPath = request.getContextPath(); %>

<%
	String id = request.getParameter("id");
	String passwd = request.getParameter("passwd"); 
	// id+passwd -> DB 체크 , 로그인 인증...
	// 세션인증정보 저장 : id/등급/ 권한 -> 클래스 객체 저장 
	session.setAttribute("auth", id); // 입력값 상관없에 session 객체에 저장 후 
	
	// 로그인 되면 main page로 이동 : 포워딩? ㄴㄴ 리다이렉트!
	String location ="/jspPro/days09/ex05.jsp"; 
	String referer = (String)session.getAttribute("referer");
	
	if(referer != null){
		location = referer;
		session.removeAttribute(referer);
	}
	response.sendRedirect(location);
	
%>