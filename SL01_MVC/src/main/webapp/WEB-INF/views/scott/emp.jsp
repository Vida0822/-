<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script> 
<link rel="stylesheet" href="/resources/cdn-main/example.css">
<script src="/resources/cdn-main/example.js"></script>
</head>
<body class="wide">


<h3><span class="material-symbols-outlined">lists</span> Emp List</h3>

<form action="/scott/dept" method="post">
    <table id="tbl-emp">
      <caption></caption>
      <thead>
	      	<c:forEach items="${ list }" var="dto">
		      <tr>
		        <td><input type="checkbox" value="${ dto.empno }" name="empno"></td>
		        <td>${ dto.empno }</td>
		        <td>${ dto.ename }</td>
		        <td>${ dto.job }</td>
		        <td>${ dto.mgr }</td>
		        <td>${ dto.hiredate }</td>
		        <td>${ dto.sal }</td>
		        <td>${ dto.comm }</td>
		        <td>${ dto.deptno }</td> 
		      </tr>
	      </c:forEach>
	    </thead>
      <tbody>
      
      </tbody>
      <tfoot>
      <tr>
        <td colspan="9">
          <button id="home" class="home">HOme</button>
        </td>
      </tr>
    </tfoot>
    </table>
  </form>
  
  <script>
  $(function(){
  	$("#search").on("click", function(){
  		if(!$("tbody:checkbox:checked").length){
  			alert("부서를 체크하세요") ; 
  		} // if
  		$("form").submit() ; 
  	})// click 
  }) // ready 
  </script>
  
</body>
</html>