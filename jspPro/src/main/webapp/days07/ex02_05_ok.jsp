<%@page import="java.net.URLEncoder"%>
<%@page import="java.util.Enumeration"%>
<%@page import="org.apache.taglibs.standard.lang.jstl.EnumeratedMap"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!--  ex02_05_ok.jsp  -->

<!-- http://localhost/jspPro/days07/ex02_05.jsp
	?ckbCookie=xxx&ckbCookie=xxx 
					ㄴ 			ㄴ 수정값
-->

<%
	Enumeration<String> en =  request.getParameterNames(); 
	while(en.hasMoreElements()){
		String cname = en.nextElement(); 
		String cvalue = request.getParameter(cname); 
		
		// 이 값으로 쿠키 새로 생성 
		Cookie c = new Cookie( cname, URLEncoder.encode( cvalue, "UTF-8") ); 
		c.setMaxAge(-1); // 브라우저가 닫힐 때 자동 쿠키 제거 
		response.addCookie(c);
		}// while
	String location = "ex02_03.jsp"; // 쿠키 확인 페이지 
	response.sendRedirect(location);
%>





















