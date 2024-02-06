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

[EL 비교연산자]
==	eq  (둘다 사용가능)
!=		ne
<		lt
>		gt
<=	le
>= 	ge

[EL 논리연산자]
&&	and
||		or
!		not 

[EL연산자 - empty]
empty(값,"", 길이가 0인 배열, 엔트리가 없는 Map, 컬렉션 클래스 ) => true 
그외엔 false 값을 반환하는 연산자 

ArayList<boeardDTO list = null 
ㄴ empty list => true
 
 
 [EL 삼항 연산자]
	
	항1? 항2 : 항3 
 

</body>
</html>