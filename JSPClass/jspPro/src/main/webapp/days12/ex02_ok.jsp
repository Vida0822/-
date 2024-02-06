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
<h3> ex02_ok.jsp </h3>

<%
	String name = request.getParameter("name");
// 이름 입력해도 이거 왜 null값 나오지? 
//enctype을 multipart/form-data을 줬기 때문에 request 객체론 파라미터 정보를 얻어올 수 없음
	String upload = request.getParameter("upload");
%>

> 전달된 이름 : <%= name %>
> 전달된 파일 : <%= upload %>

</body>
</html>