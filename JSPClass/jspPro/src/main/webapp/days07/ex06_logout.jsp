<%@page import="com.util.Cookies"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/inc/session_auth.jspf" %>
<%
	// 세션 삭제 
	// 1) 자동 : 요청 약 20분 정도 하지 않으면 자동으로 세션 종료  
	// 2) 강제 : 
		session.invalidate(); // 즉시 강제종료 (세션 사라짐)
	//	session.removeAttribute("id");
		// 이거 el로 하는법?
%>

<script>
 	alert("<%= logonID%>님 로그아웃 하셨습니다 ") 
//	alert("<c:out value='${id}'/>"); 
	location.href = "ex06_default.jsp";
</script>