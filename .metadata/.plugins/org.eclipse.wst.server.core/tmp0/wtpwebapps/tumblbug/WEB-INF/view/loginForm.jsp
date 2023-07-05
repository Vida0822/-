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
	<div class="style__NewMemberShipContainerInner-mir8lt-14 dZkmbm">
		<div class="style__LoginWrap-mir8lt-15 gUmeOb">
			<div class="style__LoginWrapInner-mir8lt-16 hYbgAu">
				<h3 class="style__EmailTitle-mir8lt-24 iWruWy">이메일로 로그인</h3>
				<form autocomplete="on" class="style__Form-mir8lt-4 cFNky"
					method="post">
					<div
						class="StyledTBB__FormWrapper-trchgn-6 hCtMzp style__FormComponent-mir8lt-5 jDGVtY">
						<div class="StyledTBB__FormLabel-trchgn-4 keSzYC form-input-label">이메일주소</div>
						<div
							class="StyledTBB__FormContent-trchgn-5 iBKDvR form-input-wrapper">
							<span
								class="Input__InputWrapper-j7moqy-0 dXKaPI style__MembershipInput-mir8lt-3 klRmKv">
								<input type="text" inputmode="email"
								placeholder="이메일 주소를 입력해주세요" autocomplete="email"
								autocapitalize="off" class="Input__InnerInput-j7moqy-1 bfmNPl"
								name="email" value="">
							</span>
						</div>
					</div>
					<div
						class="StyledTBB__FormWrapper-trchgn-6 hCtMzp style__FormComponent-mir8lt-5 jDGVtY">
						<div class="StyledTBB__FormLabel-trchgn-4 keSzYC form-input-label">비밀번호</div>
						<div
							class="StyledTBB__FormContent-trchgn-5 iBKDvR form-input-wrapper">
							<span
								class="Input__InputWrapper-j7moqy-0 dXKaPI style__MembershipInput-mir8lt-3 klRmKv">
								<input type="password" inputmode="password"
								placeholder="비밀번호를 입력해주세요" autocomplete="current-password"
								autocapitalize="off" class="Input__InnerInput-j7moqy-1 jGEGrw"
								name="password">
							</span>
						</div>
					</div>
					<button
						class="SolidButton__Button-sc-1gsinzz-0 lhJdDF style__LoginFormButton-mir8lt-6 jNxMKx fnt-p1"
						color="mainEditorP80" type="submit">
						<span>로그인</span>
					</button>
				</form>
				<div class="SocialMembershipMenu__Wrapper-sc-141itvp-0 lfmFQa">
					<div class="style__Divider-mir8lt-2 eiCjYy">
<!-- <a href="/tumblbug/join.do">/tumblbug/join.do </a><br> -->
						<div class="IsSignInOrSignUp__Wrapper-sc-12js6np-1 bQAztb">
							아직 텀블벅 계정이 없으신가요?<span color="sub0180" font-weight="500"
								class="PlainNavLink__Wrapper-sc-9qhsie-0 iZDwgf IsSignInOrSignUp__StyledPlainLink-sc-12js6np-0 bKXWde">
								<a href="/tumblbug/join.do">회원가입</a>
							</span>
						</div>
						<p class="style__ForgetPassword-mir8lt-26 iqBPPG">
							혹시 비밀번호를 잊으셨나요? <span title="비밀번호 재설정" color="sub0180"
								font-weight="500"
								class="PlainNavLink__Wrapper-sc-9qhsie-0 iZDwgf style__ForgetPasswordLink-mir8lt-27 nhosD">
								<a href="/forgot-password">비밀번호 재설정</a>
							</span>
						</p>
					</div>
				</div>
				<div class="style__BgWrap-mir8lt-25 bMKxkh"></div>
			</div>
</body>
</html>