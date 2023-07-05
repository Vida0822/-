<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String contextPath = request.getContextPath();
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

	<div class="container mt-3">
		<form action="<%=contextPath%>/days04/empsearch.htm">
			<fieldset>
				<legend> 부서선택 </legend>
				<c:forEach items="${ dlist }" var="dto">
					<input type="checkbox" name="deptno" value="${dto.deptno}"> ${dto.dname }
			</c:forEach>
			</fieldset>

			<fieldset>
				<legend> 잡(job)선택 </legend>
				<c:forEach items="${ jlist }" var="job">
					<input type="checkbox" name="job" value="${job}"> ${ job }
			</c:forEach>
			</fieldset>
			<input type="submit" value="search">
	
	</form>
	<!--  전체 사원  -->
		<table class="table table-hover">
			<thead class="table-dark">
				<tr>
					<td><input type = "checkbox">empno</td>
					<td>ename</td>
					<td>job</td>
					<td>mgr</td>
					<td>hiredate</td>
					<td>sal</td>
					<td>comm</td>
					<td>deptno</td>
				</tr>
			</thead>
			<tbody>

				<c:if test="${ empty elist }">
					<tr>
						<td colspan="8">사원이 존재하지 않습니다</td>
					</tr>
				</c:if>
				<!-- not == ! : EL 연산자  -->
				<c:if test="${ not empty elist }">
					<c:forEach items="${elist }" var="dto" varStatus="vs" >
						<tr>
							<td>${dto.empno } </td>
							<td>${dto.ename }</td>
							<td>${dto.job }</td>
							<td>${dto.mgr }</td>
							<td>${dto.hiredate }</td>
							<td>${dto.sal }</td>
							<td>${dto.comm }</td>
							<td>${dto.deptno }</td>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</table>
	</div>
</body>

<script>
	// 상태관리 코딩 
$(function (){
     // ~?deptno=10&deptno=20&job=CLERK&job=MANAGER
     let url =  location.href ;
     $(":checkbox[name=deptno]").each(function(i, element) {
    	 // 부서
         if( url.indexOf("deptno="+$(element).val()) != -1 ){
        	 // indexOf()  : 문자열 안에서 찾을 단어와 처음 일치하는 문자열의 위치를 반환 
        	 // 없으면 -1 반환 ! 
        	 // 찾으려는 단어, 즉 deptno=10, 20, 30, 40 ->  
            $(element).prop("checked", true);
         }
     });
     $(":checkbox[name=job]").each(function(i, element) {
            if( url.indexOf("job="+$(element).val()) != -1 ){
               $(element).prop("checked", true);
            }
        });
  });
</script>
</html>