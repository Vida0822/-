<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec"  uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<style>
 span.material-symbols-outlined{
    vertical-align: text-bottom;
 }
</style>
</head>
<body>
<header>
  <h1>Sping Board</h1>
  <ul>
    <sec:authorize access="isAnonymous()">
    	<li><a href="#">로그인</a></li>
    </sec:authorize>
    <sec:authorize access="isAuthenticated()">
    	<li><a href="#">로그아웃</a></li>
    </sec:authorize>
    <li><a href="#">회원가입</a></li>
  </ul>
</header>
<div>
  <!-- Alt + Shift + Y 자동줄바꿈 -->
  <h3><span class="material-symbols-outlined" style="vertical-align: sub">stylus_note</span>Modify Page</h3>
  <div>
    <form action="/board/modify" method="post">
	  <table>  
	    <tbody>
	      <tr>
	        <th>글번호</th>
	        <td><input type="text" name="bno" class="full"  readonly="readonly"  value="${ board.bno }"></td>        
	      </tr> 
	      <tr>
	        <th>제목</th>
	        <td><input type="text" name="title" class="full"  autofocus="autofocus" value="${ board.title }"></td>        
	      </tr> 
	      <tr>
	        <th>내용</th>
	        <td><textarea  name="content" class="full" ><c:out value="${ board.content }"></c:out></textarea></td>        
	      </tr> 
	      <tr>
	        <th>작성자</th>
	        <td><input type="text" name="writer" class="short" readonly="readonly" value="${ board.writer }"></td>        
	      </tr>  
	    </tbody> 
	    <tfoot>
	      <tr>
	        <td colspan="2">
	          <button type="button"  data-oper="modify" class="edit">Modify</button>
	          <button type="button" data-oper="list"  class="list">List</button>
	        </td>
	      </tr>
	    </tfoot>
	  </table>
	  
	  <input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }">
	  
	  <input type="hidden" name="pageNum"  value="${ criteria.pageNum }">
	  <input type="hidden" name="amount"  value="${ criteria.amount }">
	    
  </form>
  </div> 
  
  <div class="message full" title="수정구현"  class="update">
    <ol>
      <li>수정할 입력값 + post </li>
      <li>/board/modify 요청</li>
    </ol>
  </div>
  
</div>

<script>
  $(function (){
	  
	  var formObj = $("form");
	  
	  $("tfoot button").on("click", function (event){		  
		  var operation = $(this).data("oper");
		  if(operation === 'modify'){
	         formObj.submit();
		  }else if(operation === 'remove'){
			  if( confirm("정말 삭제할거냐? ") ){
				  //location.href = "/board/remove?bno="+${ board.bno };
				  formObj.attr({
							  "action":"/board/remove",
							  "method":"get"
						  });
				  formObj.submit();
			  } // 
		  }else if( operation === 'list' ){
			  var pageNumTag = $("input[name=pageNum]").clone();
			  var amountTag = $("input[name=amount]").clone();			  
			  formObj
			     .attr({
		               "action":"/board/list",
		               "method":"get"
		            })
	            .empty()
	             .append( pageNumTag )
	            .append( amountTag )
	            .submit()
		  } // if
	  }); // click
  }); // ready
</script>
</body>
</html>







