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

<h3> ex03.jsp - 외부 라이브러리 사용(cos.jar) </h3>

<!--  요거 왜 안되지? 당연하지.. web.xml 지워줬잖아-->
<form
	action="/jspPro/days12/upload" 
	method="post"
	enctype="multipart/form-data">
	message = <input type="text" name="msg" value="hello world~"/><br>
	<button type="button"> 첨부파일추가 </button>
	<div id="demo">
		첨부파일 1 : <input type="file" name="file1"><br>
	</div>
	<input type="submit" name="전송"><br>
	
</form>

<script>
$(document).ready(function() {
	$("button").on("click", function() {
		var n = $("#demo :file").length +1;  // ??????????????
		$("#demo").append("첨부파일"+n+":<input type='file' name='file"+n+"'><br>");
	}) // click
})

</script>
</body>
</html>