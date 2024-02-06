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

<h3> ex02_06.jsp </h3>
<pre>
	c:forEach 태그 
	1. 배열
	2. 컬렉션 ***ArrayList<BoardDTO> lit
	3. 맵 
		: 
	ㄴ 순차적으로 처리할 때 사용되는 반복문태그 
	- begin 속성
	- end 속성
	- items 속성
	- stap 속성
	- var 속성 
	- varStatus 속성
</pre>

<!-- 1+2+...10=55  -->

<c:set var="sum" value="0"></c:set>
<c:forEach begin="1" end="10" step="1" var="i" >
	${i} 
	<c:if test="${i ne 10 }">+</c:if>
	${ sum = sum+i;""}
</c:forEach>
= ${sum}

<!--${ i+= {i==10?"":"+")} 
	   ${ i+= {status.last? "":"+")} -->
	 
<hr>

<!--  프로젝트 자주사용 + 알아두면 편리 !  -->

<pre>
	[ varStatus 속성 ]
	status.index 루프 실행에서의 현재 인덱스값 
	status.count 루프의 실행횟수
	status.begin, end , step 
		status.first 첫 - true/ false 
		status.last 마지막?
	status.current 
</pre>

<c:forEach begin="5" end="12" var="i" varStatus="status" >
	${i}  - [${status.count }] - [${status.first }] - [${status.last }]<br> 
	<!--   [${status.index }] ->요거 걍 i값 나옴  -->
</c:forEach>

</body>
</html>

















