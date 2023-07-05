<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	// 아무 역할도 안하고 그냥 리다이렉트만 ex09_finish로  시켜주겠음~! (이동만)
// 	String location = "ex09_finish.jsp";

	String name = request.getParameter("name");
	String location = "ex09_finish.jsp?name="+name;
// 	=> 이렇게 하면 리다이렉트 돼도 name 값이 유지가 됨 ! 
	response.sendRedirect(location);  // 페이지 이동해라 명령~
%>