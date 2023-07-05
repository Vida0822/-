<%@page import="java.net.URLEncoder"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<%
	String id= request.getParameter("id");
	String passwd = request.getParameter("passwd"); 
	String location ="ex08.jsp"; 
	
	if(id.equals("admin") && passwd.equals("1234")){
		String name = "관리자"; 
		// location +="?ok&name="+name; // 인증받은 name 속성을 같이 넘겨줌  
		// 리 다이렉트 할때 한글 파라미터가 포함된 경우에는 반드시 인코딩 해야한다 
		// (주소는 아스키코드??? 니까 한글 사용 못함 -> 16진수 %로 바꿔서 표현) : URLEncoder.encode()
		location +="?ok&name="+URLEncoder.encode(name, "UTF-8");   
	} else{
		location +="?error";  
	}	
	response.sendRedirect(location); 

 %>