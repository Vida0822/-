<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.lang.reflect.Array"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<h3>  ex04_02.jsp </h3>
<h3> 요청(request) 객체 사용법 </h3>

<%
	request.setCharacterEncoding("UTF-8");  // íê¸¸ë  => 홍길동
	String name = request.getParameter("name"); 	
	String gender = request.getParameter("gender"); 	
	/* [좋아하는 동물 중복체크 ==> 어떻게 넘어가? ]
	// http://localhost/jspPro/days03/ex04_02.jsp?name=%ED%99%8D%EA%B8%B8%EB%8F%99&
		gender=m&pet=dog&pet=pig 
	=> 그럼 이거 어떻게 받을거야? (한 속성에 여럭가 넘어올 때!)*/
	String [] pets = request.getParameterValues("pet"); // String[] 
%>

이름 : <%= name %> <br>
이름(EL) : ${param.name } <br>

<%-- 성별 : <%= gender%> <br> --%> <!--  m (value 값이 출력) -->
<%-- 성별 : <%= gender=="m"?"남자":"여자" %> <br>  --%>
<!--여자 : 이게 참ㅇ 아니라는 얘기
	java ' 에서 문자열 비교는 equals() 나옴! ==쓰면 무조건 false 가 나올거임 -->
<!--param : EL 객체 / eq = EL 연산자  -->	
성별 : <%= gender.equals("m")?"남자":"여자" %> <br>  <!--  남자 => ㅇㅋ -->
성별(EL) : ${param.gender == "m"?"남자":"여자"}<br>

좋아하는 동물 : <%= Arrays.toString(pets) %> 

<hr> 요청 파라미터의 이름값 조회 </hr>
<%
	Enumeration<String> en = request.getParameterNames(); 
	while(en.hasMoreElements() ){
		String pname = en.nextElement(); 
%>
	<li><%= pname %></li> <!--  name, gender, pet  -->
<%
	} // while 
%>


</body>
</html>