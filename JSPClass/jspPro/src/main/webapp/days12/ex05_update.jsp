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
<h3  style="text-align: center">ex05_update.jsp</h3>

<form 
  action="update_ok.ss" 
  method="post"
  enctype="multipart/form-data" >
 <table border="1" style="width: 500px;" align="center">
  <tr>
    <td> subject </td>
    <td> <input type="text" name="subject" value="${ dto.subject }" /></td>
  </tr>
  <tr>
     <td> attach file </td>
     <td>
         <input type="file" name="attachFile"  multiple="multiple" />
         <input type="text" name="filesystemname"  value="${ dto.filesystemname }" />
     </td>
  </tr>
  <tr>
   <td colspan="2">
      <input type="submit" />
      <input type="hidden" name="num" value="${ dto.num }" />
   </td>
  </tr>
 </table>
</form>
</body>
</html>