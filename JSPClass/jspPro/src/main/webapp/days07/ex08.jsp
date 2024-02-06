<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String contextPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<pre>
2023-05-24 09:00
세션 개념 복습~

어제 : 하나의 인증받은 로그인 id만들 저장
-> 근데 난 여러가지 정보를 저장하고 싶음 ex) 아이디, 권한, 주소, 비번.... 
=> 일일히 속성, 속성값으로 setAttribute(a,b) 도 가능하지만!

MemberInfo member = new MemberInfo()
=> 여러개의 정보를 저장한다면 한 객체에 묶어서 저장하고 그 객체를 session에 등록한다
session.setAttribute ("member", member) 
 
  
</pre>



</body>
</html>