<%@page import="java.util.Iterator"%>
<%@page import="days01.DeptDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
// 지금 포워딩 받고 있음 
	String contextPath = request.getContextPath(); 

	ArrayList<DeptDTO> list =  (ArrayList<DeptDTO>)request.getAttribute("list"); 
	// getAttribute : object 객체로 돌림 -> 다운캐스팅  해서 arrayList 로 변환해줌 ! 
%>

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

<h3> ex10_dept.jsp </h3>

<select name="deptno" id="deptno">
   <option>선택하세요</option>
<%
	Iterator<DeptDTO> ir = list.iterator(); // 부서 리스트로 반복자를 만들어서 
	while(ir.hasNext()) {	// 반복자에 읽어올 부서 객체가 있으면 
		DeptDTO dto = ir.next(); // 다음으로 읽은 객체를 dto애 매번 초기화 
%>
		<option value="<%= dto.getDeptno() %>"><%= dto.getDname() %></option> <%-- 이렇게 만드는걸 x4반복  --%>
<%
	} // while 
%>
</select>
<script>

	$("#deptno")
		.wrap("<form></form>") // 명시적으로 form 태그 안쓰고 이렇게 써주는 이유 못들음?? 
		.change(function() {
			$(this)
				.parent() // <form> : 위에서 묶었으니까 
					.attr({
						action:"<%= contextPath%>/scott/emp",
						method:"get"
					}) // attr 
					.submit();  
					// 실행시 : http://localhost/jspPro/scott/emp?deptno=10  		
					// => 여기서 내가 선택한 부서의 부서번호(deptno) 가 다음 페이지 (emp)로 잘넘어가는걸 확인할 수 있음			
		})	 // change 

</script>
</body>
</html>