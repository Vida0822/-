<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

	<h3>조건별 검색시 포워딩되는 페이지</h3>
	----- 검색쪽 프젝카드
	---------------------------------------------------------- 이미지, ->
	상세보기로 이동 (view.do) 세부카테고리, -> 카테고리별 검색 페이지 (list.do) 창작자, -> 창작자 프로필
	페이지 pro_long -> 상세보기로 이동 (view.do) , pro_sm, 달성률, 총결제예정금액(paysum), 남은기간
	-> x (출력만)
	-------------------------------------------------------------------------------
	<div class="style__Container-sc-7of8vt-0 gmYOwM">
		<div class="Discover__DiscoverWrapper-sc-16itaa3-0 djIxnq tbb">
			<div
				class="Container-gci8y7-0 InfinityList__InfinityContainer-sc-19jay7c-0 cXaiVs dykamL">
				<div class="InfinityList__ResultWrapper-sc-19jay7c-1 ffcngd">
					<div class="InfinityList__ResultCounter-sc-19jay7c-2 dsEGnR">
						<span>${projectCount}</span>개의 프로젝트가 있습니다.
					</div>
					<div class="InfinityList__ListWrapper-sc-19jay7c-3 fZWVhg">
						<c:if test="${not empty projectCardList}">
							<c:forEach var="projectCard" items="${projectCardList}">
								<div
									class="InfinityList__ProjectCardWrapper-sc-19jay7c-4 jfWeNA">
									<div class="ProjectCard__Wrapper-opxl0a-13 klQtEn project-card">
										<div class="ProjectCard__Card-opxl0a-7 dPhtaB link-wrapper">
											<div class="ProjectCard__StyledImageBox-opxl0a-2 fQKqMl">
												<div class="image-wrapper">
													<a href="/yummy_relationship?ref=GNB%2F%EC%9D%B8%EA%B8%B0"></a>
													<div
														class="LikeButton__Wrapper-whittq-0 kiaOkh ProjectCard__StyledLikeButton-opxl0a-8 hfSMxY">
														<button type="button"
															class="LikeButton__LikedBtn-whittq-1 gylNpn">
															<span>좋아요</span>
														</button>
													</div>
												</div>
											</div>

											<div class="ProjectCard__StyledInfoBox-opxl0a-3 kfeTrp">
												<dl>
													<dd class="project-sub-info">
														<span> <a>${projectCard.detailCategory.dtl_ctg_name}</a></span>
														<span> <a
															href="/창작자조회.do?${projectCard.member.m_cd}">${projectCard.member.m_name}</a></span>
													</dd>
													
														<script>
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
														
															$(".project-sub-info span a").on("click", function(event) {
																pageGoPost({
																	url : "/tumblbug/listProject.do", //이동할 페이지
																	target : "_self",
																	vals : [ //전달할 인수들
																	[ "searchCondition", 2 ], [ "searchWord", $(this).text() ] ]
																}); // pageGoPost
															}); // click
															
														</script>
	
													<dt>
														<a
															href="/tumblbug/view.do?pro_cd=${projectCard.project.pro_cd}">${projectCard.project.pro_long}</a>
													</dt>
													<dd class="project-desc">${projectCard.project.pro_sm}</dd>
												</dl>
												<div class="ProjectCard__FundingStatus-opxl0a-10 hjCxPX">
													<div>
														<span
															class="ProjectCard__StyledFundingProgressState-opxl0a-12 ivYcvj">${projectCard.ach_rate}%</span><span
															class="funding-amount"><em>${projectCard.paySum}</em>원</span>
													</div>
													<span class="rest-day">${projectCard.left_days}일 남음</span>
												</div>
												<div class="ProjectCard__PercentageBar-opxl0a-11 bEvISi"></div>
											</div>
										</div>
									</div>
								</div>
							</c:forEach>
						</c:if>
					</div>
				</div>
			</div>
		</div>

	</div>


</body>
</html>