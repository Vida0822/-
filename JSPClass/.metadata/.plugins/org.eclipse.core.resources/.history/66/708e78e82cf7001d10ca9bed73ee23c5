<%@page import="days01.DeptDTO"%>
<%@page import="java.util.Iterator"%>
<%@page import="days01.EmpDTO"%>
<%@page import="java.sql.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.util.DBConn"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!--    1. 강사님이 주소 표시줄 뒤에 10,20,30 바꿔줄때마다 페이지 바꿔주는 작업을 
   여기 jsp페이지에서 option을 클릭하는걸로 구현 
	(이 페이지 -> 다른 jsp 파일로 db 연동)
	
   2. 부서 정보도 DB 연동해서 가져오기! 
   ex06_02의 db연동 코딩을 그대로 붙임 (import문 + 커넥션 연결 코딩 ) => 코딩수정 
   	=> option 태그 안에 반복해서 추가하는 작업 
   	(db -> 이 페이지로 데이터 가져오기 !)
   	
   	3. 40번 부서(operation) 선택시 오류 떨어지는 문제 해결!  -->
   	
 
 <!--  1. DB연동해서 얻어오기   -->
   	
<%
String sql = " SELECT * "
			+ " FROM dept ";
Connection conn = DBConn.getConnection();
PreparedStatement pstmt = null;
ResultSet rs = null;
ArrayList<DeptDTO> list = null;

pstmt = conn.prepareStatement(sql);
rs = pstmt.executeQuery();
/* 
10	ACCOUNTING	NEW YORK
20	RESEARCH		DALLAS
30	SALES	CHICAGO
40	OPERATIONS	BOSTON */

int deptno;
String dname, loc;

if(rs.next()) {
	// 하나라도 값이 없을 수 있으니 만들어준 코딩 => 하나라도 있어야 실행 
	list = new ArrayList<>();
	do {
		// 각각의 정보를 얻어와 변수에 넣고 
		deptno = rs.getInt("deptno");
		dname = rs.getString("dname");
		loc = rs.getString("loc");
		
		// 그 정보들로 부서객체를 각각 만들어서 
		DeptDTO dto = new DeptDTO(deptno, dname, loc);
		
		// list에 추가 
		list.add(dto);
	} while(rs.next());
}
rs.close();
pstmt.close();
DBConn.close();
// DB에서 정보 다 가져왔으니까 연결끊어주기 



%>

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
<h3>ex06.jsp</h3>

<!-- ex06_02.jsp?deptno=10 -->
<select name="deptno" id="deptno">
   <option>선택하세요</option>
   <!-- 
   <option value="10">ACCOUNTING</option>
   <option value="20">RESEARCH</option>
   <option value="30">SALES</option>
   <option value="40">OPERATIONS</option>
   -->
	<%
	Iterator<DeptDTO> ir = list.iterator();
	// 부서 리스트로 반복자를 만들어서 
	while(ir.hasNext()) {
		// 반복자에 읽어올 부서 객체가 있으면 
		DeptDTO dto = ir.next();
		// 다음으로 읽은 객체를 dto애 매번 초기화 
		%>
		<option value="<%= dto.getDeptno() %>"><%= dto.getDname() %></option> <%-- 이렇게 만드는걸 x4반복  --%>
		<%-- 그 객체에 담긴 부서정보와 부서이름을 option태그의 value 값으로 넣어줌 => option  태그를 db를 연동해서 넣어줌 --%>
		<%
	}
	%>
</select>

<hr>

<div class="container mt-3">
  <h2>Dropdowns</h2>
 
  <div class="dropdown">
    <button type="button" class="btn btn-primary dropdown-toggle" data-bs-toggle="dropdown">
      부서 선택 button
    </button>
    <ul class="dropdown-menu">
     <!-- 
      <li><a class="dropdown-item" href="#">Normal</a></li>
      <li><a class="dropdown-item active" href="#">Active</a></li>
      <li><a class="dropdown-item disabled" href="#">Disabled</a></li>
       -->
       <%
      ir =list.iterator();
	while( ir.hasNext() ){
		DeptDTO dto = ir.next();
	%>
	<li><a class="dropdown-item" href="#<%= dto.getDeptno() %>"><%= dto.getDname() %></a></li>
	<%
    } // while
%>
    </ul>
  </div>
</div>

<script>
$(function() {
	$("#deptno").on("change", function(event) {
		let pdeptno = $(this).val();
		// alert(pdeptno);
		
		location.href = "ex06_02.jsp?deptno=" + pdeptno;
	});
});
</script>
</body>
</html>