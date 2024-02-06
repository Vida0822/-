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

<h3> ex03.jsp / ex03_02.jsp/ ex03_03.jsp </h3>
<pre>
	이름 , 나이 입력받아서 -> 다음 페이지로 넘기고 (ex03_02.jsp) 
		-> 다시 주소와 연락처를 입력받아 -> 마지막 페이지로 넘겨서 정보출력 
			
	(이름, 나이 -> 주소, 연락처 -> 정보 출력)
	
	상태유지 (이전에 넘겨받은 데이터값을 상태유지하는게 이번 예제 목적이다? )
</pre>

<form action ="ex03_02.jsp">
	name : <input type ="text" name = "name" value="홍길동"><br>
	age : <input type ="text" name = "age" value="20"><br>
	
	<input type="submit" value ="Next"> 
</form>


</body>
</html>