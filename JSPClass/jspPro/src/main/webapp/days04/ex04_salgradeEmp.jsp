<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% String contextPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>

<link rel="stylesheet"
	href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<script>
	$(function() {
		$("#accordion").accordion();
		$("#tabs").tabs();
	});
</script>

</head>
<body>

	<h3>ex04_salgradeEmp.jsp</h3>

	<div id="accordion">
		<c:forEach items="${ map  }" var="entry">
			<h3>${entry.key }</h3>
			<div>
				<p>
					<c:forEach items="${entry.value }" var="dto">
						<li>${dto.deptno } ${dto.empno } ${dto.ename } ${dto.sal }</li>
					</c:forEach>
				</p>
			</div>
		</c:forEach>
	</div>

	<hr>
	<div id="tabs">
		<ul>
			<c:forEach items="${map }" var="entry" varStatus="vs">
				<li><a href="#tabs-${vs.count }">${entry.key }</a></li>
			</c:forEach>
		</ul>

		<c:forEach items="${map }" var="entry" varStatus="vs">
			<div id="tabs-${vs.count }">
				<p>
					<c:forEach items="${entry.value }" var="dto">
						<li>${dto.deptno } ${dto.empno } ${dto.ename } ${dto.sal }</li>
					</c:forEach>
				</p>
			</div>
		</c:forEach>
	</div>

</body>
</html>