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

<h3> ex02.jsp </h3>

<pre>
[jsp 웹 어플리케이션 4가지 영역(저장공간)]
: jsp 웹 어플리케이션에는 4가지 영역(저장공간)이 있다
==> 기억공간!!!! = 값이 유지되는 페이지 범위 

1. page scope (영역) : 하나의 페이지에서 사용되는 저장공간(기억공간) [pageContext 기본 객체]
2. request scope : 하나의 요청에서 사용되는 영역 , [request 기본객체]
3. session scope : 하나의 웹 브라우저에서 사용되는 영역 [session 기본객체] 
4. application scope  : 하나의 웹 애플리케이션에서 사용되는 영역 [application 기본 객체 ] => 서버가 죽지 않는 한 계속 살아있는 기억공간 


 ex) 
 클라이언트				웹ㅂ서버 
 전용브라우저
 [a.jsp]  - 요청 -> [a.jsp]에 해당하는 서블릿 클래스를 찾고 -> 서블릿 객체 생성 
 																				ㄴ 얜 웹 (톰캣) 컨테이너에서 생성됨 
 																				ㄴ 이 하나의 서블릿 객체 에서만 사용되는게 page scope (하나의 페이지 안에서만 생성됨)
			<-응답- 
 [b.jsp]  - 요청 -> [b.jsp]에 해당하는 서블릿 클래스 -> 서블릿 객체 생성
 																		ㄴ 또 얘안에서만 사용할 수 있는 저장공간이 따로 생김 -> 'page scope' 
 
 [c.jsp] - 요청 -> [ c 서블릿 객체 - 포워딩 -> d.jsp  ]
 			requset 					request scope : 하나의 요청에 공유되는 기억공간 => d.jsp에서 사용 가능 
 											=> request.setAttribute("list", list) => 포워딩이 되어져도 유지됨 ! 
 											
 ㄴ 근데 난 여러 페이지들을 이동하더라도 이 브라우저에서 계속 유지됐으면 좋겠는 정보가 있음 ex) 로그인 되어있다는 상태 및 정보 
 => session 기본객체 
 								
 								
 								
 => 이 기억공간에 값을 저장할 때는 setAttribute ()  ! 값을 얻어올 때는 getAttribute() 를 사용한다! 
 +) removeAttribute(name)/ getAttributeNames () ; 			
 
 => 실습 : ex02_02.jsp  / ex02_03.jsp / ex02_04.jsp 
 
 
 ex02_02.jsp 요청 (서버 4가지 영역에 이름, 나이, 주소, 연락처 각각 저장해보자! ) 
 -> a 태그 : 클릭스 ex02_03.jsp로 새로운 페이지로 요청 ! 유지되는 애들 어떤게 있을까? 주소, 연락처 
 
 실행되고 있는 떠있는 브라우저 모두 닫기를 누르고 ex02_04.jsp 를 켰을 때 유지되는 애들 어떤게 있을까? 
 => 이름, 나이, 주소 사라지고 연락처는? 
 
 
 																		
</pre>
</body>
</html>