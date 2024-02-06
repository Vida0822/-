<%@page import="java.util.Enumeration"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String contextPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Insert title here</title>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
</head>
<body>

<h3> ex03_02.jsp </h3>

<%
	String name = request.getParameter("name");
	String age =request.getParameter("age")  ;
%>

<form action="ex03_03.jsp" method = "get">
	address : <input type="text" name="address" value = "서울 역삼동"><br>
	tel : <input type="text" name="tel" value = "010-1234-1234"><br>
	
	<input type="button" value ="Prev" onclick="history.back()">
	<input type="submit" value ="Next">

	<!--  얘도 입력태그 ! form 태그 넘어갈때 같이 넘어감 
		=> hidden 태그 : 상태관리 할떄 사용된다 ! 
	 -->
<%-- 	
	<input type="hidden" name ="name" value="<%= name%>">
	<input type="hidden" name ="age" value="<%= age%>"> 
	[문제2] 만약 100개의 입력값이 전달되어졌따면 hidden태그를 100개 만들거야? 
			=> 동적으로 hidden 태그를 생성하세요 
--%>
</form>

<script>
<%
	// ?name=xxx&age=yyy
	Enumeration<String> en =  request.getParameterNames(); 
	// 요청 객체로부터 넘어온 input 태그들의 name 속성값들을 열거자 en에 담고
	// [ name, age ]
	while(en.hasMoreElements()){
		// 그 열거자에 값이 남아있을 때까지 하나씩 가져오면서  
		String pn = en.nextElement(); // name 
		String pv = request.getParameter(pn);  // "name"이라는 이름의 요청parameter
%>
	$("form").append("<input type='hidden' name='<%=pn%>' value='홍길동'>")
	// 그 값을 받아와 
	// 소스보기 : 페이지에서 전달받아진 코드  vs element  : 스크립트 등이 실행되어 최종적으로 결정되는 태그들 !

	// 나중엔 쿠키, 세션을 사용해서 해볼거임
<%
	}
%>




</script>
</body>
</html>