<%@page import="java.net.URLEncoder"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!--  ex02_02에서 쿠키 생성하라는 명령만 받고 로직 끝 -->

<%
	String cookieName  = request.getParameter("cookieName");
	String cookieValue  = request.getParameter("cookieValue");
	
	// 1. 쿠키 객체 생성 
	Cookie c = new Cookie(cookieName, URLEncoder.encode( cookieValue, "UTF-8") ); 
	//※ 쿠키의 값은 한글인 경우에는 반드시 인코딩이 필요하다
	
	// 2. response.addCookie(쿠키)
	c.setMaxAge(-1); // 브라우저가 닫힐 때 자동 쿠키 제거 
	// c.setDomain(domain);
	// c.setPath(uri);
	
	// 2. response.addCookie(쿠키)
	response.addCookie(c); //이렇게 응답에 담아주면 클라이언트에 도착했을 때 쿠키 생성됨 (클라이언트가 명령받아 생성)
	
	String location = "ex02.jsp"; 
	response.sendRedirect(location); // 쿠키가 생성된 그 클라이언트 보고 요청 다시하라함 -> 요청에는 쿠키가 같이 담겨져서옴
	// 확인 -> f12 > network 
	
	// path : days07 -> days07에서 어떤 요청이 일어날 때 마다 이 쿠키값을 같이 보낸다 
	// JSESSIONID (name) : D67E02DD34CD4A16F57FBB794708D7AE (value) 
	// -> 처음 요청하면 서버에 세션 객체 
	// : 고유 id 값을 클라이언트 쿠키에 저장하도로 was 서버가 자동으로 하고 있다 ???????????
	// expire : session ?? 
	// 브라우저 닫고 다시 실행하면 쿠키 없어짐 : 브라우저 닫힐때 자동으로 쿠키 제거하라고 명령했기 때문 
			
%>