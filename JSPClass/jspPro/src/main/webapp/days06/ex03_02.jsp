<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String contextPath = request.getContextPath(); %>

<%@ page errorPage="/WEB-INF/jsp/viewErrorMessage.jsp" %>

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

<h3> ex03_02.jsp </h3>
<%-- name : <%= request.getParameter("name").toUpperCase() %>  --%>
<br>

<a href ="ex1000.jsp"> ex1000.jsp </a>
??????????????왜 얜 404로 처리되지?? 얘또 viewErrorMessage.jsp 로 처리돼야하는거 아님? 
우선순위도 높은데??
<!-- 
 응답 상태 코드 
- 404 : 요청 url을 처리하기 위한 자원이 존재하지 않음
- 500 : 서버 내부 에러가 발생 
- 200 : 요청을 정상적으로 처리했을때 
- 307 : 임시로 페이지를 리다이렉트함 
- 400 : 클라이언트의 요청이 잘못된 구문으로 구성됨 
- 401 : 접근을 허용하지 않음 
등등 
 -->
</body>
</html>