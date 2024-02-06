<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/WEB-INF/inc/session_auth.jspf"%>
<%-- 
<%
   // 쿠키를 사용해서 로그인(인증) 처리할 예정
   // 로그인 성공(인증처리)하면 [auth 쿠키이름]으로 [로그인ID 쿠키값]를 저장
   String cname = "auth";
   String logonID = null;
   
   Cookies cookies = new Cookies(request);
   if(cookies.exists(cname)) {
      logonID = cookies.getValue(cname);
   }
%>
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<style>
  div{
    border: 1px solid gray;
    width:300px;
    height:100px;
    padding:20px;
  }
</style>
</head>
<body>
<h3>ex06_default_EL_JSTL.jsp</h3>
<c:choose>
   <c:when test="${ empty logonID }">
      <div id="logon">
        <form action="ex06_logon.jsp">
          아이디 : <input type="text" name="id" value="admin" /><br>
          비밀번호 : <input type="password" name="passwd" value="1234" /><br>
          <input type="submit" value="로그인" />
          <input type="button" value="회원가입" /> 
          <c:if test="${ param.logon eq 'fail' }">
             <span style="color:red; display: none;">로그인 실패했습니다.</span>          
          </c:if>
        </form>
      </div>
   </c:when>
   <c:otherwise>
      <div id="logout">
         [<%= logonID %>]님 환영합니다<br>
         <a href="ex06_logout.jsp">로그아웃</a>
      </div>
   </c:otherwise>
</c:choose>

<a href="/jspPro/cstvsboard/list.htm">게시판</a><br>
<a href="#">공지사항</a><br>

<c:if test="${ not empty logonID }">
   <a href="#">자료실</a><br>
   <a href="#">일정관리</a><br>
   
   <c:if test="${ logonID eq 'admin' }">
      <a href="#">급여관리</a><br>
      <a href="#">인사관리</a><br>
   </c:if>
</c:if>

<script>
// ex03_default.jsp?logon=fail
$(function() {
   if (${ param.logon eq 'fail' }) {
      $("#logon span")
         .fadeIn()
         .fadeOut(3000);
   }
});
</script>
</body>
</html>