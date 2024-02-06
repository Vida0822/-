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

<%
	String pempnos = request.getParameter("empnos"); 
	String [] empnos = pempnos.split("/"); 
%>
<p id = "demo"> 
	<ul>
	<%
		for(int i=0; i<empnos.length;i++){
	%><li> <%= empnos[i] %></li><%
	} // for 
	%>
	</ul>
</p>

<!-- <input type = "text"  data-속성명 = "속성값">   ????????????? -->
<!-- <input type = "text"  data-loc = "SEOUL">    -->

<script>
//	 alert($(":text").data("loc")); 
/* 	alert($(":text").data("dname","xxx"));  => 이건 이름알 얻어오는거 !  */
	
</script>

</body>
</html>