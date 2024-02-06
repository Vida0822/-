<%@page import="java.net.URLDecoder"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String contextPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<h3> ex02_03.jsp - 쿠키 확인 </h3>

<form>
	<%
		// js - document.cookie 속성 
		Cookie [] cookies =  request.getCookies() ; 
		// 요청될 때 함께 건너오는 쿠키들을 가져오는 메서드  : 요청할때 parameter처럼 같이 넘어오므로 얻는 방식도 동일하게 ㅎ해주는거라ㅗ 생각 
		
		for(Cookie c : cookies){
			String cname =  c.getName();
			// String cvalue =  c.getValue();
			// ※ 주의사항 : 한글 -> 인코딩 -> 쿠키 저장   ==> 읽을땐 한글 -> 디코딩 -> 쿠키 읽기 
			String cvalue = URLDecoder.decode( c.getValue(), "UTF-8");
			System.out.printf("domain:%s, path: %s, maxAge : %d \n"
					, c.getDomain(), c.getPath(), c.getMaxAge() );  // 콘솔 출력 
	%>
	<input type="checkbox" name = "ckbCookie" 
		value="<%= cname %>"> <%= cname  %>-<%= cvalue  %><br>
	<%
		}
	%>
</form>

<a href="ex02.jsp" > 쿠키HOME </a><br>
<br>
<br>


수정할 쿠키를 '선택한 후' 쿠키 삭제, 수정 <br> 
<a href="ex02_04.jsp"> 쿠키삭제</a><br>
<a href="ex02_05.jsp"> 쿠키수정</a><br>

<!-- 페이지를 단순히 이동하는게 아니라 체크된 쿠키 값을 가지고 가야함 !!  
	=> 
-->

<script>
// a의 링크태그를 클릭했을 때 1) 그 링크로 요청을 보내지 않고 2) 폼값의 action 속성을 그 링크로 설정해 3) 그 폼을 서브밋한다   
	$(function() {
	/* $("a").on("click", function() {
			event.preventDefault() ; // link 태그의 기본기능 (이동) 을 막아준다 (클릭해도 이동하지 않음)
			let href = $(this).attr("href");
			$("form")
				.attr("action",href )
				.submit(); 
		}); */
		$("a").on("click", function() {
			event.preventDefault() ; // link 태그의 기본기능 (이동) 을 막아준다 (클릭해도 이동하지 않음)
			let href = $(this).attr("href");
			
			// location.href = href + "?ckbCookie=age&ckbCookie=name";  
			let queryString =  $("form").serialize();  // 폼태그의 요소들을 제출용 문자열로 바꿔준다 
			location.href = href+"?"+queryString; // ckbCookie=name&ckbCookie=age&ckbCookie=JSESSIONID
		}); // a click 
		
		
		
	}); //  function 
	
</script>
</body>
</html>