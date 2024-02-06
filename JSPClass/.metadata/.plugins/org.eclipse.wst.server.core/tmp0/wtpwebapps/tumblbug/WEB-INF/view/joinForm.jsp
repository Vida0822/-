
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
<!-- <link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico"> -->
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
<c:if test="${errors.duplicateId}">
		<script>alert("이미 가입된 이메일입니다. 해당 계정으로 로그인해주세요."); </script>
</c:if>
	<div class="style__Wrapper-mir8lt-1 bUKxLC">
		<h1>이메일로 가입하기</h1>
		<form autocomplete="on" class="style__Form-mir8lt-4 cFNky" method="post">
			<div
				class="StyledTBB__FormWrapper-trchgn-6 hCtMzp style__FormComponent-mir8lt-5 jDGVtY">
				<div class="StyledTBB__FormLabel-trchgn-4 keSzYC form-input-label">
					이름</div>
				<div
					class="StyledTBB__FormContent-trchgn-5 iBKDvR form-input-wrapper">
					<span
						class="Input__InputWrapper-j7moqy-0 dXKaPI style__MembershipInput-mir8lt-3 klRmKv">
						<input type="text" inputmode="text" placeholder="사용하실 이름을 입력해주세요." 
						autocomplete="off" autocapitalize="off"
						class="Input__InnerInput-j7moqy-1 bfmNPl" name="name" value="">
					</span>
				</div>
			</div>
			<div
				class="StyledTBB__FormWrapper-trchgn-6 hCtMzp style__FormComponent-mir8lt-5 jDGVtY">
				<div class="StyledTBB__FormLabel-trchgn-4 keSzYC form-input-label">이메일 주소</div>
				<div
					class="StyledTBB__FormContent-trchgn-5 iBKDvR form-input-wrapper">
					<span
						class="Input__InputWrapper-j7moqy-0 dXKaPI style__MembershipInput-mir8lt-3 klRmKv">
						<input 	type="text" inputmode="text" placeholder="이메일 주소를 입력해주세요."
						autocomplete="off" autocapitalize="off"
						class="Input__InnerInput-j7moqy-1 bfmNPl" 
						id="email" name="email" value="${param.email}"></span>
				</div>
				<div class="result"></div>
				
				<div
					class="StyledTBB__FormContent-trchgn-5 iBKDvR form-input-wrapper">
					<span
						class="Input__InputWrapper-j7moqy-0 dXKaPI style__MembershipInput-mir8lt-3 klRmKv"><input
						type="text" inputmode="text" placeholder="이메일 주소를 확인합니다."
						autocomplete="off" autocapitalize="off"
						class="Input__InnerInput-j7moqy-1 bfmNPl" 
						id="confirmEmail" name="confirmEmail" value=""></span>
				</div>
				<div class="result"></div> <!-- 만들어준애! -->
			</div>
			
			<script>
				
					// 유효성 검사하는 함수 (호출될 애임 ) => 해결 x 
					$(function() {
	           			var confirmEmail = document.getElementById("confirmEmail"); 
	    			    var results = document.querySelectorAll(".result");
	    			       
	    			    	email.addEventListener("keydown",(e)=> { 
	    			            validEmail(e.target); 
	    			        }); // keydown
	    			        confirmEmail.addEventListener("keydown",(e)=> { 
	    			            validEmail(e.target); 
	    			        }); // keydown          
	    			        
				        function validEmail(obj){
	    			       	for (let result of results) {
	    			       		if(validEmailCheck(obj)==false){
					                result.textContent = '유효하지 않은 이메일 형식입니다' ;
					                result.style.color = "red";
					                // confirmEmail.style.border = "solid red 1px";
					                // obj.value='';
					                obj.focus();
					                return false;
					            }else{
					                result.textContent = '' ; 
					              } // if
							}// for
				        }// validEmail
				        
						function validEmailCheck(obj){
		           			 var pattern = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
		           			 return (obj.value.match(pattern)!=null);
	          			 } // validEmailCheck          			 
				}); // 	$(function) 
			   
			</script>
			
			
			<div
				class="StyledTBB__FormWrapper-trchgn-6 hCtMzp style__FormComponent-mir8lt-5 jDGVtY">
				<div class="StyledTBB__FormLabel-trchgn-4 keSzYC form-input-label">비밀번호</div>
				<div
					class="StyledTBB__FormContent-trchgn-5 iBKDvR form-input-wrapper">
					<span
						class="Input__InputWrapper-j7moqy-0 dXKaPI style__MembershipInput-mir8lt-3 klRmKv"><input
						type="password" inputmode="password" placeholder="비밀번호를 입력해주세요."
						autocomplete="off" autocapitalize="off"
						class="Input__InnerInput-j7moqy-1 jGEGrw" name="password" value="${param.password}"></span>
				</div>
				<div
					class="StyledTBB__FormContent-trchgn-5 iBKDvR form-input-wrapper">
					<span
						class="Input__InputWrapper-j7moqy-0 dXKaPI style__MembershipInput-mir8lt-3 klRmKv"><input
						type="password" inputmode="password" placeholder="비밀번호를 확인합니다."
						autocomplete="off" autocapitalize="off"
						class="Input__InnerInput-j7moqy-1 jGEGrw" name="confirmPassword" value="${param.confirmPassword}"></span>
				</div>
			</div>
			
			
			
			
			<!--  약관동의부분~!  -->
			<div
				class="StyledTBB__FormWrapper-trchgn-6 hCtMzp style__FormComponent-mir8lt-5 jDGVtY agreements">
				<div
					class="StyledTBB__FormContent-trchgn-5 iBKDvR form-input-wrapper">
					<div class="style__AgreeForm-mir8lt-10 dIoGvT">
						<label for="159b08fa-4bb4-442d-abfd-683a6c57700d"
							class="Checkbox__Wrapper-sc-1j98t5d-1 eQAnah style__CustomCheckbox-mir8lt-9 gLUMWl selectAll"><input
							id="159b08fa-4bb4-442d-abfd-683a6c57700d" type="checkbox"
							name="allAgreements" value="">전체동의</label>
						<div class="style__Divider-mir8lt-2 QULMu"></div>
						<ul>
							<li><label for="dc81660b-4325-4f68-94f4-b56825103b6b"
								class="Checkbox__Wrapper-sc-1j98t5d-1 eQAnah style__CustomCheckbox-mir8lt-9 gLUMWl"><input
									id="dc81660b-4325-4f68-94f4-b56825103b6b" type="checkbox"
									name="isMoreThan14" value="">만 14세 이상입니다. (필수)</label></li>
							<li><label for="46862330-1f6e-4608-a0e0-1fd2bd16d9dc"
								class="Checkbox__Wrapper-sc-1j98t5d-1 eQAnah style__CustomCheckbox-mir8lt-9 gLUMWl"><input
									id="46862330-1f6e-4608-a0e0-1fd2bd16d9dc" type="checkbox"
									name="termOfService" value="">텀블벅 이용 약관동의 (필수)</label>
							<button
									class="PlainLink__StyledLink-qbfirs-0 bcSgNr style__StyledLink-mir8lt-8 gaHuwH"
									color="sub0180" data-url="https://tum.bg/terms" type="button">내용보기</button></li>
							<li><label for="5bee606b-9e40-407c-9cff-dffa685fb363"
								class="Checkbox__Wrapper-sc-1j98t5d-1 eQAnah style__CustomCheckbox-mir8lt-9 gLUMWl"><input
									id="5bee606b-9e40-407c-9cff-dffa685fb363" type="checkbox"
									name="privacyService" value="">개인정보 수집 및 이용 동의 (필수)</label>
							<button
									class="PlainLink__StyledLink-qbfirs-0 bcSgNr style__StyledLink-mir8lt-8 gaHuwH"
									color="sub0180"
									data-url="https://help.tumblbug.com/hc/ko/articles/7766423598745"
									type="button">내용보기</button></li>
							<li><label for="3f96c430-5e90-42e0-8784-e50e56a2532d"
								class="Checkbox__Wrapper-sc-1j98t5d-1 eQAnah style__CustomCheckbox-mir8lt-9 gLUMWl"><input
									id="3f96c430-5e90-42e0-8784-e50e56a2532d" type="checkbox"
									name="privacyThirdParty" value="">개인정보 제 3자 제공 동의 (선택)</label>
							<button
									class="PlainLink__StyledLink-qbfirs-0 bcSgNr style__StyledLink-mir8lt-8 gaHuwH"
									color="sub0180"
									data-url="https://help.tumblbug.com/hc/ko/articles/7779446714521"
									type="button">내용보기</button></li>
							<li><label for="d850afa2-3038-437f-9ab0-095fa92cf007"
								class="Checkbox__Wrapper-sc-1j98t5d-1 eQAnah style__CustomCheckbox-mir8lt-9 gLUMWl"><input
									id="d850afa2-3038-437f-9ab0-095fa92cf007" type="checkbox"
									name="marketing" value="">마케팅 정보 수신 동의 (선택)</label></li>
						</ul>
					</div>
				</div>
			</div>
			<button
				class="SolidButton__Button-sc-1gsinzz-0 lhJdDF style__FormButton-mir8lt-7 dQYOXX fnt-p1"
				color="mainEditorP80">
				<span>가입하기</span>
			</button>
			<div class="IsSignInOrSignUp__Wrapper-sc-12js6np-1 fTouDY">
				이미 텀블벅 계정이 있으신가요?<span color="sub0180" font-weight="500"
					class="PlainNavLink__Wrapper-sc-9qhsie-0 iZDwgf IsSignInOrSignUp__StyledPlainLink-sc-12js6np-0 bKXWde"><a
					href="/login?redirection=%2F">기존 계정으로 로그인하기</a></span>
			</div>
		</form>
		
		
		<div class="style__Divider-mir8lt-2 eiCjYy">
			<span>또는</span>
		</div>
		<button class="style__KakaoButton-mir8lt-20 kNBVsr">
			<div name="kakao"
				class="Icon__SVGICON-sc-1xkf9cp-0 ccxeYs style__StyledSVGIcon-mir8lt-23 hpHClT">
				<svg width="26" height="26" viewBox="0 0 26 26" fill="none">
					<path fill-rule="evenodd" clip-rule="evenodd"
						d="M13 3.25C6.99238 3.25 2.16663 6.99718 2.16663 11.5825C2.3636 14.7381 4.33329 17.4498 7.18935 18.6332L6.15526 22.3803C6.10602 22.4789 6.15526 22.6269 6.25375 22.6757C6.35223 22.7748 6.5492 22.7748 6.64769 22.6757L11.0303 19.7672C11.6704 19.8658 12.3106 19.9151 13 19.9151C18.9583 19.9151 23.8333 16.1679 23.8333 11.5825C23.8333 6.99718 19.0075 3.25 13 3.25"
						fill="black" fill-opacity="0.9"></path></svg>
			</div>
			카카오로 가입하기
		</button>
	</div>
</body>
</html>