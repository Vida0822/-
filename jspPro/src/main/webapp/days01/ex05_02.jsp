<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
</head>
<body>
<h3>*** ex05_02.jsp ***</h3>
정수 : <input type="text" id="num" name="num"><br>

<p id="demo">
<%
// ex05_02.jsp 요청을 처음할 때 ?num 파라미터가 없기 때문에
// request.getParameter("num")의 값이 null이 되고
// Integer.parseInt( null ) 예외 발생

// [문제] input type=text value=5 입력받은 값을 유지
// 1+2+...+5=15

String pn = request.getParameter("num");
int sum = 0;
if(pn!=null) {	
	int n = Integer.parseInt( pn );
	for(int i = 1; i <= n; i++) {
		sum += i;
		%><%= i %><%
		if (i!=n) {
			%>+<%
		}
	}
	%>=<%= sum %><%
}
%>
</p>

<!--  
정수 : [ 5 ] 엔터 -> 서버 서브밋 -> 응답
1. 서브밋
	1) form 추가					ex05_03.jsp
	2) js의 location BOM 객체 사용 	ex05_02.jsp
-->

<script>
$(function() {
	$(":text[name=num]")
		.css("text-align","center")
		.val('<%= pn==null?"":pn %>')
		.keyup(function() {
			if (event.which == 13) {
				let n = $(this).val();
				// get 방식 요청
				// location.href = `ex05_02.jsp?num=${n}`;
				location.href = "ex05_02.jsp?num=" + n;
			}
		});
});
</script>
</body>
</html>