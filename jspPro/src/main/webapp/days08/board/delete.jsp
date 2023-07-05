<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>2023. 5. 19. - 오후 4:15:07</title>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<style>
 table , td, th {
   border:solid 1px gray;
 }
 table{
     border-spacing: 3px;
     border-collapse: separate;
   }
   table,  tr, td {
    /* border-radius: 3px; */
    /* padding:3px;  */
   }
 table{
    width: 600px;
 }
</style>
</head>
<body>
<h3>delete.jsp</h3>

<div align="center">
  <h2>삭제하기</h2>
  <form method="post">
	<table>
	  <tr>
	    <td colspan="2" align="center"><b>글을 삭제합니다</b></td>
	  </tr>
	  <tr>
	    <td align="center">비밀번호</td>
	    <td>
	      <input type="password" name="pwd" size="15" autofocus="autofocus">
	    </td>
	  </tr>
	  <tr>
	    <td colspan="2" align="center">
	      <input type="submit" value="삭제">&nbsp;&nbsp;
	      <input type="button" id="cancel" value="취소">
	    </td>
	  </tr>
	</table>
  </form>
</div>

<script>
<%
    String error = (String) request.getAttribute("error");
    if( error != null ){
%>
     alert('<%= error %>');
<%
    }
%>
   $(function (){
	   request.setAttribute("error", "비밀번호가 틀립니다.");
	   
   });
</script>
</body>
</html>






