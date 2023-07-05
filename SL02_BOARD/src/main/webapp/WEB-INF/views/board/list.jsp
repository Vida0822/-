<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
</head>
<body>
<header>
<h1>Spring Board</h1>
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
	<h3><span class="material-symbols-outlined" style="vertical-align: sub">view_list</span>List Page</h3>
	<div>
		<table>
			<caption style="text-align: right">
				<a href="/board/register">글쓰기</a>
			</caption>
			<thead>
				<th>#번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>수정일</th>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${ empty list }">
						<tr>
							<td colspan="5">no board</td>
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach items="${ list }" var="board">
							<tr>
								<td><c:out value="${ board.bno }"/></td>
								<td><a href="/board/get?bno=${ board.bno }"><c:out value="${ board.title }"/></a></td>
								<td><c:out value="${ board.writer }"/></td>
								<td><fmt:formatDate value="${ board.regdate }" pattern="yyyy-MM-dd"/></td>
								<td><fmt:formatDate value="${ board.updatedate }" pattern="yyyy-MM-dd"/></td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</tbody>
			<tfoot>
			</tfoot>
		</table>
	</div>
</div>
<script>
$(function() {
	// 글쓰기가 완료되면 글번호 list.jsp 전송 -> 5번 등록되었다(경고창, 모달창)
	var result = '<c:out value="${result}"/>';
	checkModal(result);
	
	// 1)등록 -> 2)목록 -> 3)조회 -> 뒤로가기 [문제점]
	history.replaceState({}, null, null);

	function checkModal(result) {
		if (result === "" || history.state) return;
		if (parseInt(result) > 0) alert(`\${result}번글이 등록되었습니다.`);
		if (result === "success") alert("삭제를 완료하였습니다.");
	}
	
}); // ready
</script>
</body>
</html>