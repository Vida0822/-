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
	[화요일]
	days05.ex05.jsp
	자바빈
	쿠키,세션
	EL/JSTL 
	
	[수요일] 
	MVC 패턴 
	
	[목요일]
	필터 
	서블릿 컨텍스트리스너
	
	[금요일]
	자료실 / 방명록 / 로그인 + 답변형 게시판 등 
	 
	프로젝트 
	다음주 - 오전 1,2 시간 
	6/19 (발표)
	
	스프링(3.x, 4.x , 5.x) + mybaits
	AWS 
	[스프링부트 + JPA ]

</pre>


<pre>
[자바빈(Java Bean)과 jsp:useBean 액션태그]

1. 자바빈 (Bean) == 자바빈즈 (JavaBeans)
	1) JSP 기반 웹 어플리케이션에서 정보를 표현(정보 저장, 출력) 할 때 사용하는 객체 
	(어디서 부르냐에 따라 걍 다르게 부름 같은 기능이라도 ex) 스프링 기반 -> 스프링빈) 
	
	2) DTO , VO -> 자바빈! ('정보를 저장하는 객체)

2. 자바빈 규약 
	1) 필드는 private 필드로 선언해야한다 
	2) getter, setter 선언 
	3) 직렬화가 가능한 클래스 선언 
		
3. 자바빈은 속성(데이터), 변경 이벤트, 객체 직렬화를 위한 표준이다 

4. 실습 
	1) days07.MemberInfo.java -> 자바빈 규약을 따르는 자바빈 객체 만들기
	2) ex01_02.jsp 
 

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
</pre>
</body>
</html>