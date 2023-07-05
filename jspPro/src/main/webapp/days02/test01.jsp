<%@page import="java.sql.Date"%>
<%@page import="days01.EmpDTO"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.util.DBConn"%>
<%@page import="java.sql.SQLException"%>
<%@page import="days01.DeptDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
// db연동은 페이지 전에 보텅 하니까 여기에 위치 잡아줌 
// % : jsp 에서 사용되는 스크립트 요소 => 이 안에 java 코딩 할 수 있음 

// [문제1] 부서정보 DB연동해서 가져와 option 태그 작성해주세요! ! 

Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;
ArrayList<DeptDTO> list = null;

String sql = "SELECT * " + "FROM dept " + "ORDER BY deptno ASC ";

conn = DBConn.getConnection();

try {
	pstmt = conn.prepareStatement(sql);
	rs = pstmt.executeQuery();
	int deptno;
	String dname, loc;

	if (rs.next()) {
		list = new ArrayList<DeptDTO>();
		do {
	deptno = rs.getInt("deptno");
	dname = rs.getString("dname");
	loc = rs.getString("loc");
	DeptDTO dto = new DeptDTO(deptno, dname, loc);
	list.add(dto);
		} while (rs.next());
	} // if 
} catch (SQLException e) {
	e.printStackTrace();
} finally {
	try {
		rs.close();
		pstmt.close();
		// DBConn.close(); => 밑에서 해줘야해서 안닫아줌 
	} catch (SQLException e) {
		e.printStackTrace();
	}
} // finally

// <- dept option 만들기 코딩 







/*  [문제2]  : 페이지를 열면 자동으로 10번부서가 선택디어져 있고 
그 부서에 해당하는 사원정보를 문서가 실행돼었을때 자동으로 뿌려지게 만들어라 */  

// 일꾼객체, 컨넥션 객체는 만든거 써주고 

//int pdeptno = 10; // 나중에 수정 
//int pdeptno = Integer.parseInt(request.getParameter("deptno")); 
/* 
// java.lang.NumberFormatException: null
?deptno=30     -> 30
?deptno=         -> ""
					   -> null  
*/
int pdeptno=10;
try{
	// 굳이 if 주지말고 우린 발생할 예외의 원인과 처리방법을 명확히 알고 있기 때문에 try-catch로 묶어주기! 
	pdeptno = Integer.parseInt(request.getParameter("deptno")); 
}catch(Exception e){
	
}
					   
//Type mismatch: cannot convert from String to int
ArrayList<EmpDTO> elist = null; 
sql = "SELECT * " 
	+ "FROM emp " 
	+ "WHERE deptno =? " 
	// option에서 선택되는 애들에 따라 부서정보 뿌려짐 => parameter 로
	+ "ORDER BY empno ASC ";


	try {
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, pdeptno); 
		rs = pstmt.executeQuery();
		
		int empno, mgr, deptno;
		String ename, job;
		Date hiredate;
		double sal, comm;
		
		if (rs.next()) {
			elist = new ArrayList<EmpDTO>();
			do {
				empno = rs.getInt("empno");
				mgr = rs.getInt("mgr");
				deptno = rs.getInt("deptno");
				ename = rs.getString("ename");
				job = rs.getString("job");
				hiredate = rs.getDate("hiredate");
				sal = rs.getDouble("sal");
				comm = rs.getDouble("comm");
				EmpDTO dto = new EmpDTO(empno, ename, job, mgr, hiredate, sal, comm, deptno);
				elist.add(dto);
			} while (rs.next());
		} // if 
		
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		try {
			rs.close();
			pstmt.close();
			DBConn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} // finally
//emp table> tr 만들기 코딩 


%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>

<style>
	table{
		width: 100%;
		min-width: 700px;		
	}
	table, th,td{
		border: 1px solid gray; 
	}

</style>

</head>
<body>

	<h3>days02.ex01.jsp</h3>


<!-- [문제1] 부서정보 DB연동해서 가져와 option 태그 작성해주세요! !  -->
<!-- <form> -->
<select id="deptno" name="deptno ">
<%
Iterator<DeptDTO> ir = list.iterator();
while (ir.hasNext()) {
	DeptDTO dto = ir.next();
%> 
<!-- [문제3] 여기 보여지는데에는 지역명(loc)가 필요없지만 난 이걸 알아오길 원해 <-> 숨겨야함 !  -->
<option value="<%= dto.getDeptno() %>" data-loc="<%= dto.getLoc() %>"><%= dto.getDname() %></option>
<!-- 
Q1. data-loc 이게 대체 머에요? 
	option 태그에는 원래 value 값밖에 속성이 없음 근데 난 ! 이 option태그에 loc속성도 표시하고 싶음
	근데 만약 value값을 loc를 주면 Detpno를 못주잖아
	=> data-loc를 줘서 새로운 속성을 만들(듯이) 하고 속성값을 줘서 그 요소에 속성으로 포함시킬 수 있음  -->
<!--
Q2. 굳이 이렇게 DB연동해서 얻어오는 이유?  그냥 html 코드 작성해주면 안됨? 
만약 부서정보가 바뀐다면? 부서개 15000000개라면? 
DB연동해야 그 바뀐 정보값이 실시간으로 반영됨  
-->
<%
} // while
%>
</select>
<!-- </form> -->
<!-- <input type="sumbit"> 
<input type="reset">  -->
<br>
<br>
<!--  [문제2]  : 페이지를 열면 자동으로 10번부서가 선택디어져 있고 
그 부서에 해당하는 사원정보를 문서가 실행돼었을때 자동으로 뿌려지게 만들어라  -->
<table>
	<thead class="table-dark">
		<tr>
			<td><input type="checkbox" id="ckbAll" name = "ckbAll" ></td>
<%-- 			<td><input type="checkbox" id="ckbAll" name = "ckbAll" data-empno="<%=dt%>"></td> --%>
			<td>empno</td>
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
	<%
		if(elist == null){ // 사원이 존재하지 않는다 
	%>
		<tr>
			<td colspan ="9" style="text-align: center">사원이 존재하지 않는다</td> 
		</tr>
	<%		
		}else{  // 사원 존재 => interator로 반복해서 출력 
	%>
	<%
		Iterator<EmpDTO> eir = elist.iterator();
		while(eir.hasNext()) {
/* 		while(ir.hasNext()) { */
			EmpDTO dto = eir.next();
	%>
			<tr>
				<td><input type="checkbox" data-empno="<%= dto.getEmpno() %>"></td>
				<td><%= dto.getEmpno() %></td>
				<td><%= dto.getEname() %></td>
				<td><%= dto.getJob() %></td>
				<td><%= dto.getMgr() %></td>
				<td><%= dto.getHiredate() %></td>
				<td><%= dto.getSal() %></td>
				<td><%= dto.getComm() %></td>
				<td><%= dto.getDeptno() %></td>
			</tr>
	<%
			}			
		}
	%>
	</tbody>
	
	<tfoot>
	   	<tr>
	   		<td colspan ="9" style ="text-align: center;"> 
	   		<button> 선택확인버튼  </button>
	   	</tr>	
   	</tfoot>
</table>


<script>

$(function() {
/*  [문제3] 내가 option을 다른걸 고르면, 즉 change 이벤트가 발생하면 내가 고른 option의 value값(deptno)을 서버로 보내서 그 부서번호로 다시 서버에 사원정보를 요청 
	 -> 받아와서 table에 뿌려주기                            
	 1) 요청을 보내는 jquery(클라이언트 , 프론트 코딩 완성) 
	 	- form 태그 
	 	- location.href
	 2) 서버에서 DB로부터 데이터 얻어오는 과정에서 사용되는 부서번호를 10번 부서가 아닌 내가 얻어오는 입력 parameter 값으로 변경  */

	$("#deptno").on("change", function(event) {
		// alert("test"); => 이벤트 확인 중요!
		//1. form 태그 사용 -> submit ()
		// $("form").submit();
	
		// 2. location의 href 속성 이용 
		let pdeptno = $(this).val(); 
		location.href = "http://localhost:8080/jspPro/days02/test01.jsp?deptno="+pdeptno; 
	
	});
	 
	 
	/* [문제4] 옵션 고를때마다 서버로 요청가서 사원정보를 잘 가져오긴 하는데! select 태그 value값이 다시 accounting으로 초기화됨 
	=> 페이지 불러오면서 상태관리 안되는것! 
	=> 내가 고른 option값에 selected 속성값을 주는 코딩 필요 
	1) by jquery
	2) 서버에서 처리 
	넘어오는 deptno에 해당하는 value를 가진 option 태그에 selected option 추가해야함  => 나머지 3개의 opion  */
	//?deptno=30
	$("#deptno").val(<%= pdeptno %>);
	// EL
	/* $("#deptno").val(${empty param.deptno ? 10 : param.deptno}); */


	//[문제5] 모두 선택체크박스 & 하나라도 체크 풀리면 체크 풀림! 
	$("#ckbAll").on("click", function(event) { // 전체 체크박스 -> thead에 있음 
		// $(this).prop("checked") => 모든 선택 속성의 체크 여부를 나타냄 
		//$("tbody :checkbox")
		$("table tbody tr")
			.find("td:first-child :checkbox") // 개별 체크박스 -> tbody에 있음 (각각 첫번째 td -> 그중에 체크된애) 
			.prop("checked", $(this).prop("checked"));  // 전체 체크박스에 'checked' 속성 부여
	})
	$("table tbody tr")
		.find("td:first-child :checkbox").on("click", function() {
			let ck = $("tbody :checkbox").length == $("tbody :checkbox:checked").length;
			$("#ckbAll").prop("checked", ck);
		})
		
		
		
		
	// [문제6] '선택확인버튼'을 클릭하면 체크된 애의 사원번호를 text01_02.jsp에 출력 
<%-- 		<tr>
				<td><input type="checkbox"></td>
				<td><%= dto.getEmpno() %></td>
				<td><%= dto.getEname() %></td>
				<td><%= dto.getJob() %></td>
				<td><%= dto.getMgr() %></td>
				<td><%= dto.getHiredate() %></td>
				<td><%= dto.getSal() %></td>
				<td><%= dto.getComm() %></td>
				<td><%= dto.getDeptno() %></td>
			</tr> --%>
			
	$("tfoot button").on("click", function() {
			
		//여기안댐`~~!! 
		let empnos =[]; 
		// 체크된 체크박스만 가져와서 each문으로 반복처리 
		$("tbody :checkbox:checked").each(function(i, element) {
			// console.log(i+"/"+element);  // 0/[object HTMLInputElement]
			// element.parentElement.nextElementSibling.innerText
			// let empno = $(element).parent().next().text();
			// console.log(empno); // 7782 , 7934
			
			let empno = $(element).data("empno"); 
			empnos.push(empno); 
		})//for
			
		/* location.href = "test.jsp?empnos=7782/9999/8766"; */
/* 		location.href = "text01_02.jsp?empno=7782&empno=9999"; */
			location.href = "test01_02.jsp?empnos="+empnos.join("/"); 
			
	});  // click 
})// funciton 
	</script>
</body>
</html>








