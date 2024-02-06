<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<% String contextPath = request.getContextPath(); %>

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
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>


</head>
<body>

	<h3>프로젝트 기본정보</h3>
	<!-- 세부 카테고리 -->
	<div>
		<a> <span>${viewInfo.detailCategory.dtl_ctg_name}</span>
		</a>
	</div>
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
	
			$("div.hklIjO div a").on("click", function(event) {
				//      location.href = "/tumblbug/listProject.do?searchCondition=1&searchWord="+ $(this).text();
				pageGoPost({
					url : "/tumblbug/listProject.do", //이동할 페이지
					target : "_self",
					vals : [ //전달할 인수들
					[ "searchCondition", 2 ], [ "searchWord", $(this).text() ] ]
				}); // pageGoPost
			}); // click
		</script>

	<!-- 프로젝트 제목 -->
	<h1>${viewInfo.pro_long}</h1>

	<!-- 상세보기 이미지 -->
	<c:forEach var="image" items="${imageFiles}">
		<img src="${image.af_path}">
	</c:forEach>

	<!--  이미지 슬라이드 구현해보자  -->

	<div>
		<div>모인금액</div>
		<span> <fmt:formatNumber value="${viewInfo.paySum}"
				pattern="#,###" />원
		</span>

		<!--  달성률 -->
		<span>${viewInfo.ach_rate} % </span>

		<div>남은시간</div>
		<div>${viewInfo.left_days}일</div>

		<div>후원자</div>
		<div>${viewInfo.pro_sup}명</div>
	</div>
	<div>
		<dl>
			<dt>목표금액</dt>
			<dd>
				<fmt:formatNumber value="${viewInfo.pro_price}" pattern="#,###" /> 원
			</dd>
		</dl>
		<dl>
			<dt>펀딩기간</dt>
			<dd>
				<fmt:formatDate value="${viewInfo.pro_start}" pattern="yyyy.MM.dd" />
				~
				<fmt:formatDate value="${viewInfo.pro_end}" pattern="yyyy.MM.dd" />
				<span>${viewInfo.left_days}일 남음 </span>
			</dd>
		</dl>
		<dl>
			<dt>결제</dt>
			<dd>
				목표금액 달성 시
				<fmt:formatDate value="${viewInfo.pay_date}" pattern="yyyy.MM.dd" />
				에 결제 진행
			</dd>
		</dl>
	</div>

	<!-- 관심프로젝트(좋아한)버튼 (수정필요) -->
	<div id="likebutton"
		class="LikeButton__Wrapper-whittq-0 evFCpM DetailLikeButton__StyledLikeButton-sc-1s3ru7k-0 dUnHuV">
		♡</div>
	<script>
$("#likebutton")
	.on("click", function() {
		location.href ="관심 프로젝트.do?" ; // 예진언니 코딩따라 수정필요 (임의로 스크립트 처리)
})
</script>


	<button id="paybutton"
		class="Button-sc-1x93b2b-0 PledgeButton__StyledButton-arwur9-1 decXxS gexWqf">
		이 프로젝트 후원하기</button>

	<script>
	document.addEventListener("DOMContentLoaded", function() {
	  document.getElementById("paybutton").addEventListener('click', function() {
	    document.getElementById("giftSelect").scrollIntoView({behavior: "smooth"});
	  });
	});
</script>
	<div id="contentsNavigation"></div>
	<a> 프로젝트 계획 </a>
	<a> 업데이트 </a>
	<a> 커뮤니티 </a>
	<a> 추천 </a>
	<!--  이거 상단바 고정하는거 구현해보자  -->


	<h3>프로젝트 계획</h3>

<style>
.cgJIkg li a.isActive {
	border: none;
	color: rgb(255, 255, 255);
	background: rgb(61, 61, 61);
}
</style>

	<ul class="style__SectionTabs-qkz7cf-5 cgJIkg fixed">
		<li><a class="isActive">소개</a></li>
		<li><a>예산</a></li>
		<li><a>일정</a></li>
		<li><a>팀 소개</a></li>
		<li><a>선물 설명</a></li>
		<li><a>신뢰와 안전</a></li>
	</ul>


<script>
document.addEventListener("DOMContentLoaded", function() {
  var links = document.querySelectorAll(".style__SectionTabs-qkz7cf-5 a");

  links.forEach(function(link) {
    link.addEventListener("click", function(event) {
      event.preventDefault(); // 링크 클릭 시 기본 동작을 막습니다.

      // 현재 엑티브 클래스를 가진 요소가 있으면 제거합니다.
      var activeLink = document.querySelector(".style__SectionTabs-qkz7cf-5 a.isActive");
      if (activeLink) {
        activeLink.classList.remove("isActive");
      }

      // 현재 엑티브 클래스를 가진 요소에 엑티브 클래스를 추가합니다.
      link.classList.add("isActive");

      var linkText = link.textContent.trim(); // 클릭된 링크의 텍스트를 가져와 공백을 제거한 후 사용합니다.
      var targetDivId ; 
	  	if (linkText === "소개") {
	  		targetDivId = "purpose" ;
		} else if (linkText === "예산") {
			targetDivId = "budget";
		} else if (linkText=== "일정") {
			targetDivId = "schedule";
		} else if (linkText=== "팀 소개") {
			targetDivId = "introduction";
		} else if (linkText=== "선물 설명") {
			targetDivId = "rewardsDescription";
		} else if (linkText=== "신뢰와 안전") {
			targetDivId = "policyContent";
		} // if 
      
      var targetDiv = document.getElementById(targetDivId);
      // 스크롤 이동
      if (targetDiv) {
    	  var targetDivOffset = targetDiv.offsetTop;
          window.scrollTo({ top: targetDivOffset, behavior: "instant" });
      }
    });
  });
});
</script>


	<div class="style__ProjectContentsMainColumn-ky14bp-10 jXBJgk">
		<div class="style__StoryCardInner-qkz7cf-1 dqWXwp">
			<div class="style__StoryCardInner-qkz7cf-1 dqWXwp">
				<div id="purpose" class="style__StorySection-qkz7cf-7 eRgkPx">
					<div class="style__StorySectionTitle-qkz7cf-6 indCjw">프로젝트 소개</div>
					<div class="storyContent">${viewPlan.projectPlan.pp_intro}</div>
				</div>
				<div id="budget" class="style__StorySection-qkz7cf-7 eRgkPx">
					<div class="style__StorySectionTitle-qkz7cf-6 indCjw">프로젝트 예산</div>
					<div class="storyContent">${viewPlan.projectPlan.pp_budget}</div>
				</div>
				<div id="schedule" class="style__StorySection-qkz7cf-7 eRgkPx">
					<div class="style__StorySectionTitle-qkz7cf-6 indCjw">프로젝트 일정</div>
					<div class="storyContent">${viewPlan.projectPlan.pp_schd}</div>
				</div>
				<div id="introduction" class="style__StorySection-qkz7cf-7 eRgkPx">
					<div class="style__StorySectionTitle-qkz7cf-6 indCjw">프로젝트 팀
						소개</div>
					<div class="storyContent">${viewPlan.projectPlan.pp_tintro}</div>
				</div>
				<div id="rewardsDescription"
					class="style__StorySection-qkz7cf-7 eRgkPx">
					<div class="style__StorySectionTitle-qkz7cf-6 indCjw">선물 설명</div>
					<div class="storyContent">${viewPlan.projectPlan.pp_gift}</div>
				</div>

				<div id="policyContent" 
					class="style__PolicyWrap-qkz7cf-10 eMPiYz refundPolicy">
					<div class="style__SectionSubTitle-qkz7cf-9 kddiiI">프로젝트 정책</div>
					<div class="policyContents">${viewPlan.policy.tas_policy}</div>
				</div>
				<div class="style__PolicyWrap-qkz7cf-10 eMPiYz refundPolicy">
					<div class="style__SectionSubTitle-qkz7cf-9 kddiiI">예상되는 어려움
					</div>
					<div class="policyContents">${viewPlan.policy.tas_exc}</div>
				</div>
			</div>
		</div>
	</div>

	<h3>창작자 소개</h3>
	<div
		class="Card-sc-1sgtmvk-0 djWEMI style__StyledCreatorCard-ky14bp-13 ibtarK">
		<div
			style="width:300px; height:300px; background: url('${viewCreator.creatorPhoto.af_path}') center center/cover no-repeat;">
			<a href="창작자조회.do?m_cd=${viewCreator.member.m_cd}"> </a>
		</div>
		<div>
			<a href="창작자조회.do?m_cd=${viewCreator.member.m_cd}">창작자 이름:
				${viewCreator.member.m_name} </a>
		</div>
		<div>마지막 로그인 ${viewCreator.lastSession} 시간 전</div>
		<div>창작자 소개: ${viewCreator.pro_ct_intro}</div>

		<div>팔로우</div><!--  구현 x  -->
		<div>창작자문의</div><!--  구현 x  -->
	</div>




<div><h3>선물선택</h3> </div>

<!--  반복문 시작  -->
<div>
<c:forEach var="giftCard" items="${giftCards}" varStatus="status">
		<div <c:if test="${status.first}">style="display: none;"</c:if>> <!-- 수정한 부분 : 1000원일땐 x명이 선택, n개 남음 안ㅆ -->
		    <div>${giftCard.buyAmount}명이 선택</div> <!-- 후원자수 -->
		    <div>${giftCard.leftAmount}개 남음</div> <!-- 남은 개수 -->
		</div>
		<div>
			<div> <fmt:formatNumber value="${giftCard.gift_min}" pattern="#,###" />  원 +	</div>  <!-- 선물가격 -->
			<div>${giftCard.gift_desc}</div>	<!-- 선물 설명 (상품명) -->
		</div>

	<ul>
		<c:forEach var="item" items="${giftCard.items}">
				<li>${item.item_name}<span>( x ${item.item_cnt})</span></li> <!-- 아이템 목록(반복출력) -->
		</c:forEach>
	</ul>
			
			
	<!--  긇어온 부분  -->	
	<div class="RewardCard__DeliveryDate-sc-11jni8b-16 gRjZWy">
		<span <c:if test="${status.first}">style="display: none;"</c:if>>예상 전달일 &nbsp;<b>2023년 10월 25일</b></span> <!-- 추가한 부분  -->
			</div>
			<div class="ExtraPledge__Wrapper-sc-6m3rsu-0 ipAlaK">
				<div class="StyledTBB__FormWrapper-trchgn-6 hCtMzp ExtraPledge__StyledFormRenderChildren-sc-6m3rsu-1 eOMuk">
					<div class="StyledTBB__FormLabel-trchgn-4 keSzYC form-input-label"> 추가 후원금(선택)</div>
					<div class="StyledTBB__FormContent-trchgn-5 iBKDvR form-input-wrapper">
						<div class="InputWithGuideAndLengthCheck__Wrapper-sc-9nmfrw-0 eCSxwJ">
							<div class="InputWithGuideAndLengthCheck__InputWrapper-sc-9nmfrw-3 bBnjVq">
							
								<span	class="Input__InputWrapper-j7moqy-0 fOjsfs InputWithGuideAndLengthCheck__StyledInput-sc-9nmfrw-1 wmJOZ">
									<input type="text" inputmode="numeric" placeholder="0"
									autocomplete="off" autocapitalize="off"
									class="Input__InnerInput-j7moqy-1 bfmNPl" value="">
								</span>
							</div>
							<div class="InputWithGuideAndLengthCheck__NoticeArea-sc-9nmfrw-4 ciHGYP">
								<p class="InputWithGuideAndLengthCheck__GuideMessage-sc-9nmfrw-5 fduvas"></p>
							</div>
						</div>
					</div>
					<div class="StyledTBB__FormDescription-trchgn-7 dcierJ form-desc-wrapper">
						* 더 후원해주시면 프로젝트 성사가 앞당겨집니다.
					</div>
			</div>
		<div class="ExtraPledge__ButtonWrapper-sc-6m3rsu-2 xWAlK">
				<button class="LineButton__Button-sc-1ozfxit-0 hWwQDf fnt-p2" data-money="5000" color="gray10">+ 5천 원</button>
				<button class="LineButton__Button-sc-1ozfxit-0 hWwQDf fnt-p2" data-money="10000" color="gray10">+ 1만 원</button>
				<button class="LineButton__Button-sc-1ozfxit-0 hWwQDf fnt-p2" data-money="50000" color="gray10">+ 5만 원</button>
				<button class="LineButton__Button-sc-1ozfxit-0 hWwQDf fnt-p2" data-money="100000" color="gray10">+ 10만 원</button>
			</div>
		</div>
			<!-- 총 결제 예정금액  -->
		<button id="payButton" class="SolidButton__Button-sc-1gsinzz-0 llVOtQ Rewards__StyledSelectRewardDetailButton-kxhggz-6 etABXh fnt-p1"  color="main80">
			<span> ${giftCard.gift_min}원 후원하기 </span><!-- 추가한 부분 -->
		</button>
</c:forEach>
	<!--  반복문 끝  -->
</div>

<script>
$("#payButton").on("click", function() {
	location.href="/tumblbug/pay.do?pro_cd=''" ; 
})

</script>
	<script type="text/javascript">
		// 화면 넘어가는거 
		$(function() {
			$(".fjuLVq").eq(0).one("click", function() {
				$(this).find(".ehQhai").addClass("iVhtJj"); // 두번째 섹션 묶음 추가 
				$(this).find(".ehQhai").removeClass("ehQhai"); // 기존 섹션 삭제(안보이게)

				$(this).find(".gcTNai").addClass("ehQhai"); // 두번째 섹션 묶음 추가 
				$(this).find(".gcTNai").removeClass("gcTNai");// 기존 섹션 삭제(안보이게)

				$(this).find(".fjuLVq").removeClass("cfXECD"); // 기존 섹션 삭제(안보이게)
				$(this).find(".fjuLVq").addClass("eyDSsV"); // 두번째 섹션 묶음 추가 

				var secHeight = $(this).find(".ehQhai").height();
				$(this).find(".bzcMYO").css("height", secHeight);
			});

			// 1) 5000원, 10000원 클릭하면  
			$(".xWAlK button").on(
					"click",
					function() {
						$(".bfmNPl").val(
								Number($(".bfmNPl").val())
										+ Number($(this).data('money')));
						$('.wmJOZ button').show();
						$(".fnt-p1 span").html($(".bfmNPl").val() + "원 후원하기");
					});

			$(".wmJOZ button").hide();

			// 2) 텍스트박스에 가격 입력하면 
			$('.bfmNPl').on('input', function() {
				var inputValue = $(this).val();
				var numericValue = inputValue.replace(/\D/g, '');

				// 그 입력값 원래 적혀있던 총 예정금액 가격에 더함 
				$(this).val(numericValue);
				$(".fnt-p1 span").html(inputValue + "원 후원하기");

				// x버튼 보이고 사라지고
				if ($(this).val().trim() !== '') {
					$('.wmJOZ button').show();
				} else {
					$('.wmJOZ button').hide();
				}
			});
			// x 버튼 클릭 
			$('.wmJOZ button').on('click', function() {
				$('.bfmNPl').val('');
				$(".fnt-p1 span").html("원 후원하기");
				$(this).hide();
			});
		});
	</script>


</body>
</html>