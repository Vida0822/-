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
[필터(filter)]
1. http 요청/ 응답을 변경할 수 있는 재사용 가능한 클래스 
						필터체인	
2. 클 -> 요청 --필터--필터--필터--> 서버 
					ㄴ 특정 요청(write.do) : 반드시 로그인(인증-> 세션) 이후에만 글쓰기 가능 
					-> 확인 후 인증이 되어있으면 원래 가던데로 서버로 향함 
						근데 만약 인증을 못받았다면 로그인 페이지를 응답 
							 ㄴ 이렇게 필터링하는걸 필터 
							 
						<--필터--필터 -- 응답 데이터
							비밀암호화			비밀번호
							 xml				 html
												
3. 필터 구현하는 핵심타입(3개)
1) javax.servlet.Filter 인터페이스 구현 
	(1) init() : 필터 초기화 역할
	(2) destroy() : 웹 컨테이너에서 소멸될 때 호출되는 함수 
	(3) ***doFilter() *** 
		: 인증처리체크, 권한체크 , 필터링할 작업(코딩) , 체크된 후엔 다음자원(필터, 자원) chain
		chain.doFilter()
		 
2) ServletRequestWrapper 
3) ServletResponseWrapper 

4. 필터 클래스를 사용하려면 톰캣 lib/servlet-api.jar 파일을 추가해야하지만
   이클립스로 개발할 경우 추가할 팔요 x 
   
5. init(매개변수 FilterConfig config)     (configuration(환경 설정) -> config )
	ㄴ[ FilterConfig 객체가 가지고 있는 메서드 ]
	1. getFilterName() : <filter-name> 필터 이름 반환 
	2. getInitParameter(name) : <init-param>
	3. getInitParameterNames()
	4. getServletContext()  : ServletContext 객체 반환

6. 필터 == 클래스 	
	ㄴ 등록하는 과정 거침 
	1) web.xml 
	2) @WebFilter 어노테이션 형태 

7. 실습 
	ex04.jsp 
	ex04_ok.jsp 
			

</pre>
</body>
</html>