<%@page import="java.util.Date"%>
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

<H3> ex02.jsp </H3>

서버요청시간 : <%= new Date().toLocaleString() %> <!--  기본생성자 -> 현재 날짜 + 시간  -->
<br>

<input type="button" value="jquery ajax">
<p id="demo"></p>


<script>
$("input").on("click", function() {
	// jquery 메서드 - load() 
	$("#demo").load("ex02_ajax_info.txt", function(responseText, textStatus, jqXHR) { 
		// jqXHR 에 자동적으로 비동기 처리하는 객체 가져와짐 (get-() 안해도) 
		// alert(responseText); // 시계 안 바뀐채로 이름 String 얻어옴
		
		if (textStatus=="success") {
			var msg = responseText;	 // 응답받는 데이터 (String으로)
			var names = msg.split(",");
			for (let name of names) {
				$("#demo").append($("<li></li>").text(name)); 
			}//for
		} else if(textStatus=="error") {
			// 
		} //ifelse
	}); // load 
})// onclick
</script>

</body>
</html>