<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String contextPath = request.getContextPath();
%>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link href="style.css" rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="<%=contextPath%>/static/css/style.css">
<link rel="stylesheet" href="<%=contextPath%>/static/css/list.css">
</head>
<body>



	<div class="style__ProjectEditorButton-zxsodr-5 cfcgIZ">프로젝트 올리기</div>
	<script>
		$(".style__ProjectEditorButton-zxsodr-5")
				.on(
						"click",
						function() {
							location.href = "http://localhost/tumblbug/publicWeb/projectStart.jsp";
						});
	</script>

	<u:notLogin>
		<div class="style__UserText-zxsodr-11 fXtfpK" id="loginButton">로그인/회원가입</div>
	</u:notLogin>
	<u:isLogin>
		<a href="/tumblbug/logout.do">[로그아웃하기]</a>
		${session.auth }
	</u:isLogin>
	<script>
		document.getElementById('loginButton').addEventListener('click',
				function() {
					window.location.href = '/tumblbug/login.do';
				});
	</script>


	<div class="style__CategoryWrapper-zxsodr-18 ehJwom effect_hover">홈</div>
	<!-- searchCondition = 0(default) -->
	<div class="style__CategoryWrapper-zxsodr-18 ehJwom effect_hover">인기</div>
	<!-- searchCondition = 5 -->
	<div class="style__CategoryWrapper-zxsodr-18 ehJwom effect_hover">신규</div>
	<!-- searchCondition = 6 -->
	<div class="style__CategoryWrapper-zxsodr-18 ehJwom effect_hover">마감임박</div>
	<!-- searchCondition = 6 -->
	<div class="style__CategoryWrapper-zxsodr-18 ehJwom effect_hover">공개예정</div>
	<!-- searchCondition = 3 -->
	<div class="style__CategoryWrapper-zxsodr-18 ehJwom steadio_hover">스테디오</div>
	<!-- 링크 -->

	<script>
		$(".ehJwom")
				.on(
						"click",
						function(event) {
							var searchCondition;
							var searchWord;

							// 클릭한 요소에 따라 searchCondition과 searchWord 설정
							if ($(this).text() === "홈") {
								searchCondition = 0;
							} else if ($(this).text() === "인기") {
								searchCondition = 3;
							} else if ($(this).text() === "신규") {
								searchCondition = 4;
								searchWord = "new";
							} else if ($(this).text() === "마감임박") {
								searchCondition = 4;
								searchWord = "end";
							} else if ($(this).text() === "공개예정") {
								searchCondition = 5;
								searchWord = "공개예정";
							}

							// 스테디오인 경우 외부 링크로 이동
							if ($(this).hasClass("steadio_hover")) {
								location.href = "https://steadio.co/?utm_source=tumblbug&utm_medium=gnb&utm_campaign=ver1";
							} else {
								// 다른 요소들은 내부 페이지로 이동
								/*	location.href = "/tumblbug/listProject.do?searchCondition="
											+ searchCondition
											+ "&searchWord="
											+ searchWord;*/
								pageGoPost({
									url : "/tumblbug/listProject.do", //이동할 페이지
									target : "_self",
									vals : [ //전달할 인수들
									[ "searchCondition", searchCondition ],
											[ "searchWord", searchWord ] ]
								}); // pageGoPost
							} // else 
						}); // click

		function pageGoPost(d) {
			var insdoc = "";

			for (var i = 0; i < d.vals.length; i++) {
				insdoc += "<input type='hidden' name='"+ d.vals[i][0] +"' value='"+ d.vals[i][1] +"'>";
			}

			var goform = $("<form>", {
				method : "post",
				action : d.url,
				target : d.target,
				html : insdoc
			}).appendTo("body");

			goform.submit();
		} // pageGoPost
	</script>

	<!--  검색  -->
	<input placeholder="검색어를 입력해주세요."
		class="style__SearchInput-zxsodr-16 jPMsmJ">
	<script>
		$("input.jPMsmJ").on(
				"keydown",
				function() {
					if (event.which == 13) {
						pageGoPost({
							url : "/tumblbug/listProject.do", //이동할 페이지
							target : "_self",
							vals : [ //전달할 인수들
							[ "searchCondition", 6 ],
									[ "searchWord", $(this).text() ] ]
						}); // pageGoPost
					} //if
				}); // keydown
	</script>



	<div>
		<div class="style__Depth1CategoryText-zxsodr-27 dQhnSR">푸드</div>
		<div class="style__Depth1CategoryText-zxsodr-27 dQhnSR">향수 · 뷰티</div>
		<div class="style__Depth1CategoryText-zxsodr-27 dQhnSR">의류</div>
	</div>
	<div>
		<div class="style__Depth1CategoryText-zxsodr-27 dQhnSR">반려동물</div>
		<div class="style__Depth1CategoryText-zxsodr-27 dQhnSR">푸드</div>
		<div class="style__Depth1CategoryText-zxsodr-27 dQhnSR">디지털게임</div>
		<div class="style__Depth1CategoryText-zxsodr-27 dQhnSR">출판</div>
	</div>
	<div>
		<div class="style__Depth1CategoryText-zxsodr-27 dQhnSR">디자인</div>
		<div class="style__Depth1CategoryText-zxsodr-27 dQhnSR">예술</div>
	</div>

	<script>
					$("div.style__Depth1CategoryText-zxsodr-27.dQhnSR").on(
							"click",
							function(event) {
								//      location.href = "/tumblbug/listProject.do?searchCondition=1&searchWord="+ $(this).text();
								pageGoPost({
									url : "/tumblbug/listProject.do", //이동할 페이지
									target : "_self",
									vals : [ //전달할 인수들
									[ "searchCondition", 1 ],
											[ "searchWord", $(this).text() ] ]
								}); // pageGoPost
							}); // click   
	</script>
	
	
	<!--  배너  -->
	
	
	<div
		class="FrontProjectsSection__Wrapper-sc-1na1z58-1 kLmlvM tbb FrontPage__SpotlightContainer-sc-1ev69zc-10 goYsGO">
		<div class="FrontProjectsSection__ListTitle-sc-1na1z58-4 gRQZNs">신규 프로젝트 (수정전:주목할 만한 프로젝트)</div>
		<div
			class="ProjectListWithCard__ListWrapper-sc-80ruv-3 izZdZi FrontProjectsSection__StyledProjectListWithCard-sc-1na1z58-5 cbDFbB">
			<div
				class="FrontProjectsSection__WrapperComponent-sc-1na1z58-0 gArLlO ProjectListWithCard__StyledWrapperComponent-sc-80ruv-0 hpdqas">
				<!-- 신규 프로젝트 (ajax처리해줘야함) -->
				<c:if test="${!errors.nonewCardList}">
					<c:forEach var="projectCard" items="${newCardList}" end="7">
						<div class="card-wrapper">
							<div
								class="ProjectCardOnlyPercentage__Wrapper-sc-1qqprx-8 jctwLa">
								<div
									class="ProjectCardOnlyPercentage__Card-sc-1qqprx-7 hVNfHN link-wrapper">
									<div class="image-wrapper">
										<!--  이미지  -->
									<!-- 	<a style="background-image:  -->
										<a 
											href="/tumblbug/view.do?pro_cd=${projectCard.project.pro_cd}">${projectCard.file.af_cd}</a>
										

										<!--  좋아요  -->
										<div
											class="LikeButton__Wrapper-whittq-0 kiaOkh ProjectCardOnlyPercentage__StyledLikeButton-sc-1qqprx-9 iUMvsh">
											<button type="button">
												<span>좋아요</span>
											</button>
											
										</div>
									</div>
									<div class="info-wrapper">
										<dl>
											<dd class="project-sub-info">
												<!--  세부 카테고리 링크 -->
												<span> <a>${projectCard.detailCategory.dtl_ctg_name}</a></span>
												<!-- 창작자 이름  -->
												<span> <a href="/창작자조회.do?${projectCard.member.m_cd}">${projectCard.member.m_name}</a></span>
											</dd>
											<dt>
												<!--  프로젝트 제목 -->
												<a
													href="/tumblbug/view.do?pro_cd=${projectCard.project.pro_cd}">
													<strong>${projectCard.project.pro_long}</strong>
												</a>
											</dt>
										</dl>
										<!--  달성률  -->
										<div class="funding-status">
											<span class="percentage">${projectCard.ach_rate}% 달성</span>
										</div>
										<!-- 남은기간 -->
										<div class="funding-status">
											<span class="percentage">${projectCard.paySum}총결제예정금액</span>
											<span class="percentage">${projectCard.left_days}남은기간</span>
										</div>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</c:if>
				<c:if test="${errors.nonewCardList}">
					<h3>해당 조건으로 존재하는 프로젝트가 없습니다</h3>
				</c:if>
			</div>
		</div>
	</div>
	
	<script>
		$("div.info-wrapper dl dd span a").on("click", function(event) {
			//      location.href = "/tumblbug/listProject.do?searchCondition=1&searchWord="+ $(this).text();
			pageGoPost({
				url : "/tumblbug/listProject.do", //이동할 페이지
				target : "_self",
				vals : [ //전달할 인수들
				[ "searchCondition", 2 ], [ "searchWord", $(this).text() ] ]
			}); // pageGoPost
		}); // click
	</script>

	<!-- 인기 프로젝트  -->
	<div class="FrontPage__StyledPopularProjectsSection-sc-1ev69zc-1 ccGCBK">
	
	</div>

	<!--  마감임박 : ajax 처리 같이 -->
	<div class="Container__ContainerComponent-sc-1ey2h1l-0 kUAclQ FrontPageContentSection__StyledContainer-nkpafk-3 kfWoez has-bg">
	
	
	</div>

</body>
</html>