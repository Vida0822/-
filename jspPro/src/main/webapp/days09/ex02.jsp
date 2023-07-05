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

[JSTL (JSP Standard Tag Library)]
- JSP 표준 태그 라이브러리
- 개발자가 필요에 의해 태그 만들어 사용 ('커스텀 태그')
- 많은 개발자들이 공통적으로 커스텀 태그를 만들어서 사용하는 태그 -> 모아서 '표준화'한 태그

1. JSTL 태그의 5가지 종류 
1) 코어 (메인) - 접두어 : c => 변수지원, 제어문, url 처리 
	c:if  c:forEach c:choose  => ex02_03.jsp , ex02_04.jsp , ex02_05.jsp
2) xml - x => xml 처리  (x)  
3) 국제화 - fmt => 숫자, 날짜 형식 , 지역, 메시지 형식  
4) 데이터베이스 - sql => db연동, db작업			ex02_02.jsp
5) 함수 - fm  => 문자열 처리, 컬렉션 처리 







</body>
</html>