<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- <%    String contextPath = request.getContextPath(); %> --%>
<%@ include file="/WEB-INF/inc/include.jspf" %>
 <!--  include 지시자 사용 -->
<!--  근데! 이것도 페이지가 너무 많다면 ? web.xml : <jsp-property-group>  -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>2023. 5. 19. - 오전 9:31:17</title>
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

tbody tr  td:nth-of-type(2) {
	text-align: left;
}

a {
	text-decoration: none;
	color: black;
}

a:hover {
	color: red;
}
</style>
<!-- 페이징 처리 style -->
<style>
.pagination {
	margin: 0 auto;
	display: flex;
	justify-content: center;
}

.pagination a {
	color: black;
	float: left;
	padding: 4px 8px;
	text-decoration: none;
	transition: background-color .3s;
}

.pagination a.active {
	background-color: dodgerblue;
	color: white;
}

.pagination a:hover:not (.active ) {
	background-color: #ddd;
}
</style>
<style>
.searchWord {
	background-color: yellow;
	color: red;
}
</style>
<style>
.title {
	display: inline-block;
	white-space: nowrap;
	width: 90%;
	overflow: hidden;
	text-overflow: ellipsis;
}
</style>
</head>
<body>
<h3>list.jsp</h3>
<div align="center">
  <h2>목록 보기</h2>  
  <a href="<%= contextPath %>/board/write.do">글쓰기</a>
  <table style="width:600px;">
    <thead>
	    <tr>
	        <th width="10%">번호</th>
	        <th width="45%">제목</th>
	        <th width="17%">작성자</th>
	        <th width="20%">등록일</th>
	        <th width="10%">조회</th>
	      </tr>
    </thead>
    <tbody>
    <%-- 
    <c:if test="${  empty list }"></c:if>
    <c:if test="${ not empty list }"></c:if>
     --%>
     <c:choose>
       <c:when test="${ not empty list }">
         <c:forEach items="${ list }"   var="dto">
	         <tr>
		        <td width="10%">${ dto.seq }</td>
		        <td width="45%"><a href="<%= contextPath %>/board/view.do?seq=${ dto.seq }">${ dto.title }</a></td>
		        <td width="17%">${dto.writer }</td>
		        <td width="20%">${ dto.writedate }</td>
		        <td width="10%">${ dto.readed }</td>
		      </tr>
         </c:forEach>
       </c:when>
       <c:otherwise>
          <tr>
            <td colspan="5">등록된 게시글이 없습니다.</td>
          </tr>
       </c:otherwise>
     </c:choose>
    </tbody>
    <tfoot>
    
    <!--  페이징 처리  -->
      <tr>
        <td colspan="5" align="center">
          <div class="pagination">             
          	<!--  이전 버튼  -->
          	<c:if test="${ pdto.prev }">
             	<a href="<%= contextPath %>/board/list.do?currentpage=${ pdto.start - 1 }"> &laquo; </a>
           </c:if> 
           <c:forEach begin="${ pdto.start}" end="${ pdto.end}" step="1" var="i">
              <!-- EL 연산자 : eq(==) , ne(!=) -->
              <c:if test="${ pdto.currentPage eq i }">
                 <a href="#" class="active"> ${ i } </a> 
              </c:if>
              <c:if test="${ pdto.currentPage ne i }">
                <a href="<%= contextPath %>/board/list.do?currentpage=${ i }"> ${ i } </a>
              </c:if>
           </c:forEach>
           
           
           <c:if test="${ pdto.next }">
             <a href="<%= contextPath %>/board/list.do?currentpage=${ pdto.end + 1 }"> &raquo; </a>
           </c:if>
          	<%-- <c:if test="${pdto.prev }">
          		<a href="<%= contextPath %>/cstvsboard/list.htm?currentpage=${ pdto.start -1} "> &laquo; </a> 
          	</c:if>
          	
          	<!-- 페이지 블럭들 만들기  -->
          	<c:forEach begin ="${ pdto.start }"  end="${ pdto.end} " step="1" var="i">
          		<c:if test = "${ pdto.currentPage eq i }">
          			   <a href="#" class="active"> ${i} </a> 
          		</c:if>
          		<c:if test = "${ pdto.currentPage ne i }">												여기 ! 
          			   <a href="<%= contextPath %>/cstvsboard/list.htm?currentpage=2"> ${i}</a>  
          		</c:if>
          	</c:forEach>
          	
          	<!--  다음 버튼  -->
          	<c:if test="${pdto.next }">																			여기!! 
          		<a href="<%= contextPath %>/cstvsboard/list.htm?currentpage=${ pdto.end -1} "> &raquo; </a> 
          	</c:if>
          	 --%>
          </div>
        </td>
      </tr>
      
      
      <!--  검색기능  -->
      <tr>
        <td colspan="5" align="center">
          <form method="get">
          <!--  1) param1 : searchCondition  -->
             <select name="searchCondition" id="searchCondition">
              <option value="1">title</option>
              <option value="2">content</option>
              <option value="3">writer</option>
              <option value="4">title+content</option>
            </select>

          <!--  2) param2 : searchWord  -->
            <input type="text" name="searchWord" id="searchWord" />
            
            <input type="submit" value="search" />
          </form>
        </td>
      </tr>
    </tfoot>
  </table>
</div>

<script>
   // list.htm?write=success/fail
   $(function (){
	   if(  '<%= request.getParameter("write") %>' == 'success'  ){
		   alert("글 쓰기 완료!!!")
	   }
	   if(  '<%= request.getParameter("delete") %>' == 'success'  ){
		   alert("글 삭제 완료!!!")
	   }
	   
	   // [문제1]  검색후 검색조건과 검색어 상태관리 (내가 검색한 조건과 검색어가 그대로 남아있어야함 ) 
	   // 상태유지 코딩!  
	   $("#searchCondition").val(${param.searchCondition }); 
	   $("#searchWord").val(${param.searchWord }); 
	   
	   // [문제2] 페이지 블럭을 클릭해도 그 블럭이 active가 안들어옴 이거해결
	   // list.htm?currendpage = 2 
		// &searchCondition=1&searchWord=13 => 이거 코딩으로 붙이고 싶음 
		$(".pagination a:not(.active)").attr("href", function(index,oldHref) {
			return oldHref + "&searchCondition=${param.searchCondition}&searchWord=${param.searchWord}"
		}) ; // attr
   		// 문제1,2 같이 해결! -> 상태관리 + search() 호출 
		
   });	 // function 	   
   
   // 남은 문제 
// [문제3] 글 쓰기 하고 다시 이전으로 가면 뒤로가기 , 앞으로가기를 하면 서버에 요청하러 가는게 아니라 그전데이터를 뿌린다
// => 글 조회수 0으로 복귀됨 (왔다갔다하니까)  (해설 x) 
// [문제4] 알림창 안뜸! 앞으로 다시오면 success는 그대로 넘어오니까 떠야하는거 아닌가? 새로고침하면 뜨긴 뜸 (해설 x) 
// [문제5]새로고침하면 조회수 계속 증가 하는 문제 해결  (해설 x) 
// [문제6] 글쓴지 얼마 안된 게시글 뒤에 아이콘(n) 붙임 & 답글 

   
</script>    
</body>
</html>








