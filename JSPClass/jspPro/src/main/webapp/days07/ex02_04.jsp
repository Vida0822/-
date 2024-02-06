<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	// js 쿠키 삭제 : 만료시점 과거로 설정 후 쿠키다시생성(추가) 
	// jsp 쿠키 삭제: setMaxAge(0) -> 응답하는 데이터 처리할때 즉시 쿠키 삭제  (-1 : 브라우저를 닫을 때 삭제)
 String [] delCookieNames = request.getParameterValues("ckbCookie"); // 삭제할 쿠키의 이름들 
 
 for(int i=0; i<delCookieNames.length ; i++){ 
	 String cname = delCookieNames[i];
	 Cookie c = new Cookie(cname, ""); 
	 c.setMaxAge(0); 
	 
	 response.addCookie(c); 
 } // for
%> 

<script>
	alert("쿠키삭제완료"); 
	location.href="ex02_03.jsp"; 
	// 삭제 후 확인위해 이동 (왜 sendRedirect 안씀? 얘는 바로 응답 보내기 때문에 경고창을 띄울 방법이 없다) 
</script>