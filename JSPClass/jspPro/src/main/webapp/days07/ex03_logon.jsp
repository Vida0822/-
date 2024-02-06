<%@page import="com.util.Cookies"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	// db연동하면 좋은데..안하겠음 DB member 테이블 ! select()
	String id = request.getParameter("id");
	String passwd = request.getParameter("passwd");
	Cookies cookies = new Cookies(request);
	
	if(id.equals("admin")&& passwd.equals("1234")){
		//원래는 () 값으로 db select() 결과 넣어줘야함 
		Cookie c = cookies.createCookie("auth",id,"/",-1);
		response.addCookie(c);
		
		String location="ex03_default.jsp";
		response.sendRedirect(location);
		
	}else if(id.equals("hong")&& passwd.equals("1234")){
		Cookie c = cookies.createCookie("auth",id,"/",-1);
		response.addCookie(c);
		
		String location="ex03_default.jsp";
		response.sendRedirect(location);
	}
	/*else if(id.equals("park")&& passwd.equals("1234"))		
	} */else{
		// 인증실패 
		String location = "ex03_default.jsp?logon=fail";
		response.sendRedirect(location);
	}
%>
