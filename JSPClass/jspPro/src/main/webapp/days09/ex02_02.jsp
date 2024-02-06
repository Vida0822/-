<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String contextPath = request.getContextPath(); %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>


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

<pre> 
	scott.dept 테이블을 출력 
	
</pre>

<sql:query var="rs" dataSource="jdbc/myoracle"> 
--  그 조회결과를 이 변수(rs)에 담겠다  
-- 여기엔 쿼리 문법이 들어가야하기 때문에 오라클 주석이 들어가야한다 (태그 주석 적용시 오류)
SELECT deptno, dname, loc
FROM dept 
</sql:query>  



<c:forEach items="${rs.rows }" var="dto">
	<li> ${dto.deptno } - ${dto.dname } - ${dto.loc } </li>
</c:forEach>

</body>
</html>

<!--  이거 에러남  -->














