<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>2023. 5. 19. - 오후 3:05:25</title>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<style>
table, td, th {
	border: solid 1px gray;
}

table {
	border-spacing: 3px;
	border-collapse: separate;
}

table, tr, td {
	/* border-radius: 3px; */
	/* padding:3px;  */
	
}
</style>
</head>
<body>
<h3>edit.jsp</h3>
<div align="center">
  <h2>글 수정</h2>
  
  <form method="post">
  
  <table style="padding: 2px; width: 600px">
			<tr>
				<td colspan="2" align="center"><b>글을 수정합니다.</b></td>
			</tr>
			<tr>
				<td align="center">이름</td>
				<td><input type="text" name="writer" size="15"   value="${ dto.writer }"   disabled="disabled"></td>
			</tr>
			<tr>
				<td align="center">비밀번호</td>
				<td><input type="password" name="pwd" size="15" required="required"></td>
			</tr>
			<tr>
				<td align="center">Email</td>
				<td><input type="email" name="email" size="50"   value="${ dto.email }"></td>
			</tr>
			<tr>
				<td align="center">제목</td>
				<td><input type="text" name="title" size="50" required="required"  value="${ dto.title }"  autofocus="autofocus"></td>
			</tr>
			<tr>
				<td align="center">내용</td>
				<td><textarea name="content" cols="50" rows="10">${ dto.content }</textarea></td>
			</tr>
			<tr>
				<td align="center">HTML</td>
				<td>
			        <%-- dto.tag = ${  dto.tag } --%>
				    <input type="radio" name="tag" value="1" >적용
					<input type="radio" name="tag" value="0">비적용
					<script>
					    $(":radio[name=tag][value=${ dto.tag }]").attr("checked", "checked");
					</script>
			    </td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				  <input type="submit" value="작성 완료">
				  &nbsp;&nbsp;&nbsp;				  
				  <input type="button" onclick="history.back()" value="이전으로">
				</td>
			</tr>
		</table>
  
  </form>
</div>


<script>
    $(function (){
    	$("form").submit(function (){
    		  alert("유효성 검사 체크 한다. ");
    		  // event.preventDefault();
    		  // return false;
    	});
    });
</script>
</body>
</html>