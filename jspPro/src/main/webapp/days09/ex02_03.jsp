<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="days01.DeptDTO"%>
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
<pre>
	[코어 라이브러리]
1. 변수 지원 : set, remove 
2. 제어문 : if, choose, forEach , forTokens 
3. url 처리 : import, redirect, url 

</pre>

<%
	String name = "홍길동"; 
%>
<!-- c:set 태그는 EL 변수의 값이나 EL 변수의 프로퍼티값을 지정할 때 사용하는 태그 
- var 속성 : EL에서 사용할 변수명 
- value 속성 : 값 지정 표현식, EL , 정적텍스트 
- scope 속성 : 
 -->

<c:set var="sname" scope="page" ><%= name %></c:set>
name(EL) : ${sname }<br>

<%
	DeptDTO dto = new DeptDTO(10,"QC", "SEOUL"); 
	// dto.setDname("XXX"); // 부서명을 XXX로 설정
%>
<!--  똑같은 코딩  -->
<c:set var="vo" value="<%= dto %>"/>

<!-- target 속성 : 프로퍼티를 설정할 대상 객체  - EL, 표현식, 자바빈 객체, 맵
property 속성 : 프로퍼티를 설정할 속성명 - DeptDTO 클래스 setter = dname 
	※ setter 가 없으면 이거 사용 불가 !  -->

<c:set target="${vo}" property="dname" value="XXX" ></c:set>

deptno : ${vo.deptno }<br>
dname : ${vo.dname }<br>
loc : ${vo.loc }<br>

<hr>
<!-- c:set 태그 
	1) var : EL 변수명	 (표현식 X , EL X , String  ㅇ ) 
	2) value : 값 		(표현식 o, EL o, String )
	3) scope 
	4) target : 속성값을 설정할 객체 대상  (표현식, EL, String o )
	5) property : 속성명 setDname => dname 
	-->
<%-- <c:remove var="vo"/> --%> <!-- 변수를 삭제할때 사용하는 태그 -->

<%
	Map<String, String> map = new HashMap<>(); 
	map.put("id", "admin"); 
	map.put("passwd", "1234"); 
%>

<c:set var="m" value="<%= map %>" />

id=${m.id }<br>  <!--  id=admin -->
passwd=${m.passwd }<br> <!-- passwd=1234 -->


</body>
</html>