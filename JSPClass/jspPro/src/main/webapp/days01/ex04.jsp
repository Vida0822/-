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
<h3>ex04.jsp</h3>
<p id="demo">
<%
// 스크립트릿( 자바코딩 )
int sum = 0;
for(int i = 1; i <= 10; i++) {
	// jsp 기본 내장 객체 : request, out
	// out.append(csq)
	// out.print(b)
	// out.println(b) = "\n"
	out.print( i + ( i==10 ? "" : "+" ) );
	sum += i;
}
out.print( "=" + sum );
%>
</p>
<script>
/*
var content = "";
var sum = 0;
for (var i = 1; i <= 10; i++) {
	content += i + "+";
	sum += i;
}
content += "=" + sum;
$("#demo").html( content );
*/
</script>
</body>
</html>