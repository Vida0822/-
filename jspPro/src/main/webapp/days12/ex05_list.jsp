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
<h3 style="text-align:center">FileList - ex05_list.jsp</h3>

<table style="width:600px" border="1" align="center">
  <tr>
    <td align="right" colspan="4">
       <a href="write.ss">WRITE</a>
    </td>
  </tr>
  <tr>
    <td align="center" width="50">글번호</td>
    <td align="left" >제목</td>
    <td align="center" width="200">첨부파일</td>
    <td align="center" width="50">삭제</td>
  </tr>  
  <c:if test="${ empty list }">
    <tr>
      <td  colspan="4">
           게시글이 존재 X
      </td>
    </tr>
  </c:if>
  <c:forEach items="${ list }" var="dto">
     <tr>
       <td align="center" width="50">${ dto.num }</td>
       <td align="left" >${ dto.subject }</td>
       <td align="center" width="200">          
         <a href="/jspPro/days12/upload/${ dto.filesystemname }"> ${ empty dto.originalfilename ? "없음" :  dto.originalfilename}</a>
         </td>
       <td align="center" width="50">
          <a href="delete.ss?num=${ dto.num }&filesystemname=${ dto.filesystemname}">삭제</a>
          <a href="update.ss?num=${ dto.num }&filesystemname=${ dto.filesystemname}">수정</a>
       </td>
     </tr>
  </c:forEach>
</table>
</body>
</html>