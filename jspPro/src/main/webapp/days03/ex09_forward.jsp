<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	// 스크립트릿
	
	String path = "ex09_finish.jsp";
	RequestDispatcher dispatcher =  request.getRequestDispatcher(path); 
	// request : 요청
	// RequestDispatcher : 담당자 (객체)
// 	=> getRequestDispatcher() : "요청을 발송하는 담당자를 얻어오겠다"
	// 그걸 얻어와서 , 어디에 발송할거야 ? String path ! 
	dispatcher.forward(request, response); 


	// 구조는 똑같은데(넘어가는 값도 똑같음 )! 그 방식을 redirect? forward?
%>