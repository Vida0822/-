<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>2023. 6. 1. - 오전 7:37:01</title>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<style>
  a{
     text-decoration: none;
     color:black;
   }
   table,  tr, td {
    border-radius: 3px;
   }
</style>

</head>
<body>
<h3>write.jsp</h3>

<form  method="post">
 <table width="600px" style="margin:50px auto" border="1">
   <tr>
     <td colspan="2" align="right">
       <a href="list.do">글목록</a>
     </td>
   </tr>
   <tr>
     <td width="70" align="center">작성자</td>
     <td width="330">
       <input type="text" name="writer" size="12" >
     </td>
   </tr>
   <tr>
     <td width="70" align="center">이메일</td>
     <td width="330">
       <input type="text" name="email" size="30" >
     </td>
   </tr>
   <tr>
     <td width="70" align="center">제목</td>
     <td width="330">
       <!-- 만약에 답글 작성  write.do?num=2&ref=2&step=0&depth=0   부모글의 정보-->
       <input type="text" name="subject" size="50"   value='<c:if test="${ not empty param.ref }">[답글]</c:if>' > <!--  태그안에 태그가 사용가능하구나!  -->
     </td>
   </tr>
   <tr>
     <td width="70" align="center">내용</td>
     <td width="330">
       <textarea rows="13" cols="50" name="content"></textarea>
     </td>
   </tr>
   <tr>
     <td width="70" align="center">비밀번호</td>
     <td width="330">
       <input type="password" name="pass" size="10" >
     </td>
   </tr>
   <tr>
     <td colspan="2" align="center">
       <input type="submit" value="글쓰기">
       <input type="reset" value="다시작성">
       <input type="button" value="글목록" 
       onclick="location.href='list.do'">
     </td>
   </tr>
 </table>

</form>

<script>
</script>
</body>
</html>