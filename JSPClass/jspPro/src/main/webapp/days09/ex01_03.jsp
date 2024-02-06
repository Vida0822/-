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

<pre>
</pre>

<%
	String title = "JSP-EL 수업중"; 
	request.setAttribute("title", title);
%>

<%= "제목: "+ title %><br> <!-- JSP-EL 수업중 -->

${title }<br> 
<!--  안나옴! => page -> request -> sesson -> application 을 찾는데 못찾아서 안찍히는거임 
=> 출력하고 싶으면 4가지 영역 중 어딘가에 저장해줘야함 : 22 line  -->

<%-- ${"제목: "+ title }<br>  --%>
${"제목: "+= title }<br> 
<!--  에러! EL에서 문자열을 연결할 땐 += 연산자를 사용한다 -->

${1+1; 10+10 }<br>
<!--  20
1) 1+1 연산처리
2) 10+10 연산처리 
3) 뒤에것만 출력하겠다는 코딩
 -->
 
 ${n=10 }<br><!--  10  -->
 ${n } <br> <!--  10  -->
 <!-- n이라는 변수에 10을 할당하고 n이라는 변수를 출력한다  -->


* EL 연산자들도 우선순위가 있다 
<%-- ${ 표현식 }<br> --%> <!-- 에러 => EL 형식으로 인식하기 때문  -->
\${ 표현식 }<br> <!--${ 표현식 }  -->









</body>
</html>