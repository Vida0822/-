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

<pre>
ㄴ. 포워딩(forwarding) 

[ 리다이렉트 & 포워딩 구분 ]

1. ex09.jsp 
	a 링크 -> 클릭하면 이름/ 나이 파라미터를 가지고 페이지 이동 
	ㄴ 2개 만들거임 : 1개는 리다이렉트 설명용 - ex09_redirect.jsp -> ex09_finish.jsp  (리다이렉트로 이동)
				, 나머지 1개는 포워딩 설명용  - ex09_forward.jsp -> ex09_finish.jsp (포워딩으로 이동)
	
</pre>

<%
	String name ="admin";
	int age = 30; 
	// ex09_redirect.jsp?name=admin&age=30 -> 요러케 리다이렉트, 포워드 둘다 넘겨줌 
%>

<a href ="ex09_redirect.jsp">리다이렉트(redirect)</a>
<a href ="ex09_forward.jsp">포워드(forward)</a>

<script>
$(function() {
	$("a").on("click", function() {
		$(this).attr("href", function(i,oldHtml) { //oldHtml 맘대로 줘도 ㄱㅊ
			return oldHtml +"?name=<%=name%>&age=<%=age%>"; 
		}) // attr
	}) // onclick
})	 // function


</script>
</body>
</html>