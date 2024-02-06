<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
String content = "";

int sum = 0;
for(int i=1; i<=10; i++){ 
	//out.print( i + ( i==10 ? "" : "+" ) );
	content += i + ( i==10 ? "" : "+" );
	sum += i;
} // for
// out.print( "=" + sum );
content +=   "=" + sum; 
%>

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
<h3>ex04_02.jsp</h3>
<p id="demo"></p>
<script>
var content = '<%= content %>';
$("#demo").html( content );
</script>
</body>
</html>