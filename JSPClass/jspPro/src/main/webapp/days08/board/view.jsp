<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String contextPath = request.getContextPath();
    String 이전페이지 = request.getHeader("referer");
%>
이전 페이지 = <%= 이전페이지 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>2023. 5. 19. - 오후 2:05:46</title>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>

<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="https://www.jquery.com/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script> 
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<style>
  table{
     border-spacing: 3px;
     border-collapse: separate; 
   }
   table,  tr, td {
      border:solid 1px gray;
      /* border-radius: 3px;  
      padding:3px;   */ 
   }
   
 #tblContent{
   width:600px;
 } 
</style>
</head>
<body>
<h3>view.jsp</h3>

<div align="center">
  <h2>내용보기</h2>
  <!-- <table id="tblContent" class="table"> -->
  <table id="tblContent">
   <tr> <!--  1행 : 이름, 등록일  -->
       <td>이름</td> 
       <td>${ dto.writer }</td> 
       <td>등록일</td>
       <td>${ dto.writedate }</td> <!--  4열  -->
   </tr>
   <tr> <!--  2행: 이메일, 조회수   -->
       <td>Email</td>
       <td><a href="mailto:${ dto.email }">${ dto.email }</a></td>
       <td>조회수</td>
       <td>${ dto.readed }</td> <!--  4열  -->
   </tr>
   <tr> <!--  3행 : 제목  -->
        <td>제목</td>
        <td colspan="3">${ dto.title }</td> <!--  3칸 합치기 + 4열  -->
   </tr>
   <tr> <!--  4행 : 내용  -->
       <td colspan="4" style="padding:15px;height: 200px;text-align: left;vertical-align: top">
       ${ dto.content }
       </td>
   </tr>
   
   <tr> <!--  5행 : 요청 a태그들 (수정, 삭제, home) -->
       <td colspan="4" align="center">
           <a class="btn btn-secondary"  href="<%= contextPath %>/board/edit.do?seq=${ dto.seq }" id="editLink">수정하기</a>
           <a class="btn btn-secondary"  href="<%= contextPath %>/board/delete.do?seq=${ dto.seq }" id="deleteLink">삭제하기</a>
          <a class="btn btn-secondary"  href="<%= contextPath %>/board/list.do" id="homeLink">HOme</a> 
          
          
          <input class="btn btn-secondary"  type="button"  id="btnModalDelete" value="모달창으로 글삭제">
       </td>
   </tr>
</table>
</div>


<!-- +) 삭제 모달창 div 태그 -->
<div id="dialog-form" align="center"  title="삭제">
  <h2>삭제하기</h2>
  <form method="post" 
  action="<%= contextPath %>/board/delete.do?seq=${ param.seq }">
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

<!-- +) 삭제 모달창 script 태그 -->
<script>
  // 1. 
  dialog = $("#dialog-form").dialog({
	  height: 400,
      width: 350,
      buttons:{},

      modal: true, 
      autoOpen: false,
      close: function (){
    	  form[0].reset(); // 모달폼 닫힐때마다 초기화 
      }
  });
  
  //2. 폼찾기 -> '모달폼' 하나밖에 없음 
  form = dialog.find("form"); 
  
 // 3. 모달창 열기
  $("#btnModalDelete").on("click", function(event) {
	  dialog.dialog("open" ); 
  })
  // 4. 모달창 닫기
  $("#cancel").on("click", function(event) {
	  dialog.dialog("close" ); 
  })
</script>

<script>
   // view.htm?edit=success/fail
   $(function (){
	   if(  '<%= request.getParameter("edit") %>' == 'success'  ){
		   alert("글 수정 완료!!!")
	   }
   });		   
</script>
</body>
</html>

