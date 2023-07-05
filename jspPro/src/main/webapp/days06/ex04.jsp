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
<h3> ex04.jsp </h3>

<pre>
[페이지 모듈화] ***** 
: 하나의 웹 사이트(애플리케이션)을 구성하는 페이지 
EX) 
- 상단 (Top) , 하단 (Bottom) -> 모든 웹 페이지의 공통적인 부분 
- 좌측, 우측 메뉴 -> 컨텐츠 별로 공통적인 부분 
-> 모듈화를 시켜서 코드의 중복 제거 : 유지보수 확장성이 쉬워진다 ! 

* 모듈화 하는법
1) include 지시자를 사용 
2) jsp: 접두사가 붙은 태그를 action 태그라고 한다 
	ㄴ jsp:include 액션 태그
ㄴ 이 두방법의 차이점을 알아야한다 ! 

=> 실습 
- 상단/하단 : 모든 웹 페이지의 공통적인 부분 
(프로젝트)
	webapp
		ㄴ layout 
			ㄴ top.jsp, bottom.jsp 
- 좌측/     : 게시판 웹 페이지의 공통적인 부분 
	days06
		ㄴ layout 
		
=> layout 폴더를 어디 만드느냐에 따라 어느만큼 공통적인 부분을 설정해주는지 알 수 있음 
	
	
	

</pre>
</body>
</html>