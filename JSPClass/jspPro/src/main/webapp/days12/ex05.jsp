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

<a href ="/jspPro/days12/list.ss"> 자료실 목록보기 </a>
<br>

<pre>
1. 
게시판(제목) + 파일첨부 (1개만) => 자료실 
db에 올라갈 수 있는 폴더가 한개가 될 수 있고 여러개가될 수 있기때문에 이 테이블을 따로 빼는거 그거 안하려고 여기선 파일첨부 하나만 하는거임 

2. MVC x 
	days12 패키지
	ㄴ FileTestDAO
	ㄴ FileTestDTO
	ㄴ FileTestServlet

3. days12 폴더 
	ㄴ ex05_list.jsp 
	ㄴ ex05_write.jsp 
	ㄴ ex05_update.jsp 



</pre>
</body>
</html>