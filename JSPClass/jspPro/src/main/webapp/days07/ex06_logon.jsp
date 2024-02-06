<%@page import="com.util.Cookies"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	// db연동하면 좋은데..안하겠음 DB member 테이블 ! select()
	String id = request.getParameter("id");
	String passwd = request.getParameter("passwd");
	
	if(id.equals("admin")&& passwd.equals("1234")){
		session.setAttribute("auth", id); 
		String location="ex06_default.jsp";
		response.sendRedirect(location);
		
	}else if(id.equals("hong")&& passwd.equals("1234")){
		session.setAttribute("auth", id);  
		String location="ex06_default.jsp";
		response.sendRedirect(location);
	} else{
		// 인증실패 
		String location = "ex06_default.jsp?logon=fail";
		response.sendRedirect(location);
	}
%>
