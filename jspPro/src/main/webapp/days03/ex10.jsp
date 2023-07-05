<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	String contextPath = request.getContextPath(); 
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

<h3> ex10.jsp </h3>

<a href="<%= contextPath%>/scott/dept"> 부서 정보 조회 </a>

<pre>
요청url : http://localhost/jspPro/scott/dept 
=> 이 요청에 의해 서블릿을 호출
	ㄴ 이 서블릿 생성 + 등록  : @어노테이션 사용해서! 
				ㄴ 어떤 함수 오버라이딩 해야함? doGet() 
					 왜 ? url로 요청하는건 get방식이니까! 
					 
		ScottDept.java
=>
	1) DB 연동 + ArrayList<DeptDTO> list 객체 만들고(출력할 부서목록)
	2) 포워딩 시킬거임 : ex10_dept.jsp   부서 출력	

=> 
	1) select -> 하나의 부서를 선택
	2) ScottEmp.java 서블릿 호출 -> doGet(){} 안에서! 10번 부서원들을 arraylist에 저장
	3) 포워딩 : ex10_emp.jsp로! => 이걸 받아와서 해당 부원들 받아오는 작업 
	
</pre>

<pre>
	ex10.jsp -> 부서정보조회 링크태그 클릭 -> /scott/dept 요청 
	-> ScottDept 서블릿 호출됨 : 정확히는 doGet() 메서드 호출됨 {부서 정보를 ArrayList<DeptDTO> list에 저장
	-> request.setAttribute ("list", list) 저장 : request 객체 (스코프) 에 저장
	-> 포워딩 : 원래 request, response 가 넘어가는애 (/days03/ex10_dept.jsp) 
	}
	-> ex10_dept.jsp
		ArrayList<DeptDTO> list =()  request.getAttribute ("list")
		ㄴ select & opion 반복적으로 만듬 
		<select>
			<option value = "10"> 부서명 </option>
		</select>
	-> g하나의 옵션 선택하면 
		change(function(){
			서브밋 /scott/emp 요청 -> ScottEmp 서블릿 doGet() { // deptno = 20 , ArrayList<EmpDTO> list 저장 
			-> 포워딩 : /days03/ex10_emp.jsp 에 출력 
		})
</pre>

<pre>

[JSTL]
	* MVN : 빌드 도구 ; 컴파일하고 실행하는애 ! 
	- jsp Standard Tag 'Libarary' 
	- '태그' : 개발자들이 필요에 의해 사용자가 정의하는 태그 => 표준화 : 아예 표준화해서 사용하자!
	- 종류 (5개)
		1) 변수, 제어문, url 처리 표준 태그 
		 끊어주기 힘드니까??
		제어문들을 표준화해서 사용하겠다??????????????????????????????????????????????????????
		 https://mvnrepository.com/artifact/javax.servlet/jstl/1.2
		 
		 

</pre>
</body>
</html>