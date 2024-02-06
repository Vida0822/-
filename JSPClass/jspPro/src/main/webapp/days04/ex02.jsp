<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String contextPath = request.getContextPath(); %>
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
<form action="ex02_ok.jsp">
<fieldset>
  <legend>부서 선택</legend>
   <input type="checkbox" name="deptno" value="10">ACCOUNTING
   <input type="checkbox" name="deptno" value="20">RESEARCH
   <input type="checkbox" name="deptno" value="30">SALES
   <input type="checkbox" name="deptno" value="40">OPERATIONS
</fieldset>

<fieldset>
  <legend>잡(job) 선택</legend>  
   <input type="checkbox" name="job" value="ANALYST">ANALYST
   <input type="checkbox" name="job" value="CLERK">CLERK
   <input type="checkbox" name="job" value="MANAGER">MANAGER
   <input type="checkbox" name="job" value="PRESIDENT">PRESIDENT
   <input type="checkbox" name="job" value="SALESMAN">SALESMAN
</fieldset>
<input type="submit" value="search"> 
</form>
</body>
</html>