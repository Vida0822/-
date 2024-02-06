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

<h3> ex02_ok.jsp </h3>

<%

String [] pdeptnos = request.getParameterValues("deptno");  // String[] 
String [] pjobs = request.getParameterValues("job");  // String[] 


String deptnos = "10, 20"; 
String jobs = " 'CLERK','MANAGER' ";

/* for(int i=0 ; i<pdeptnos.length ;i++){
	deptnos += pdeptnos[i]+",";
}
deptnos.substring(0, deptnos.length()-1 ) */

deptnos = String.join(",", pdeptnos);
jobs = String.join("','", pjobs);

String sql = "SELECT * "
				+"FROM emp "
				+"WHERE deptno IN("+deptnos +") AND job IN("+ jobs +")"
				+"ORDER BY deptno ASC "; 

%>
</body>
</html>