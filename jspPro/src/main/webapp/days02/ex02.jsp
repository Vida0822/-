<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Insert title here</title>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
</head>
<body>

<h3> ex02.jsp </h3>
<!-- // jsp -> suvlet 클래스 -> suvlet 객체 -> 응답데이터 
// 우리가 직접 survlet 클래스 만들어줄 땐 실제로 html 코딩을 하나하나 응답 데이터로 만들어주ㅝ야함 너무 지저분
=> jsp 사용하기 시작 : jsp는 내부적으로 survet 을 만드니까 우리가 직접 만들어줄 필요 없음 (지저분한 html 코딩 생략가능 ) -->

<%-- <%
	for(int i=1;~~)
 		끊는게 성능이 더 나음 (안끊고 out,print() 바로 써도 되지만! )
		=> 실제 클래스 안에선 안끊어져 있음 
%> --%>

<pre>
	<서블릿> 
	**** 여기 상대경로처럼 첨에 제대로 안하면 죽어라 안됨 

	1. 서블릿 (Servlet) 이란? 
	- 자바를 사용하는 웹 기술 중 하나 (젤 먼저 나옴)
	- jsp로 대체됬지만 로직을 처리하는 용도로 사용
		=> 로직 처리 :servlet / jsp : 화면 출력 ! 
	
	2. 서블릿 구현 방법 (과정)
	1) 서블릿도 하나의 자바 클래스 
		-> 자바 클래스 추가(선언): 이 자바 클래스는 서블릿 규약을 따라야함 
		
		'서블릿 규약' 
		ㄱ. 접근 지정자 : 무조건 public 
		ㄴ. javax.servlet.http.HttpServlet 클래스 상속 
		ㄷ. service() , get() , post() 메서드를 오버라이딩 해야함 
		
		=> 이 조건을 따르는 클래스 : 서블릿 클래스 
	
	2) 그렇게 만든 클래스 컴파일 -> ???.class 만들어짐 
	3) 이 클래스 파일은 꼭 /WEB-INF/classes 폴더 안에 넣어놔야함 
		(근데 이클립스는 여기 말고 자동으로 관리하는 곳 있음 ㅋ 우리가 관리할 필요 없음 배포할때도 상관 ㄴㄴ)
		
	4) [요청 url] -> 이 들어오면 jsp/html x 가 아닌 servlet이! 응답해야함 
		=> 어떤 서블릿 객체가 응답할도록 할지 매핑 시켜주는 작업 해야함  
	
		how 매핑 ? 
		ㄱ. web.xml 서블릿 설정 등록 
		ㄴ. 서블릿 3.0~ : @WebSerlet 어노테이션을 사용해서 등록해야함 
	
	5) 그렇게 등록하면 반드시 톰캣 서버 재시작해야한다 	
	6) 웹 브라우저 -> 요청 url -> 등록된 서블릿 응답하는지 확인 
	
		~ 실습 : 실제로 서블릿을 등록해보자 ~ 
	
	
	3. 실습 예제 
1) 서블릿 규약을 따르는 자바 클래스 서버 - days02.Now.java 
</pre>
<a href = "http://localhost:8080/jspPro/days02/now.html"> Now.java 서블릿 호출 </a><br>
<a href = "http://localhost:8080/jspPro/days02/now"> Now.java 서블릿 호출 </a><br>
<a href = "http://localhost:8080/jspPro/days02/now.ss"> Now.java 서블릿 호출 </a><br>
<!--  이 요청을 보면 등록한 servlet이 응답하도록 매핑 시키는 작업 필요~  -->


<!--  한글 깨지는 문제! 어케 해결 ? ?  -->
<!-- Now.java ???
>?? ?? ?? : 2023-19-16 04:19:46 

=> Now.java 41라인 수정
=> 서버 재시작 필수! 
-->






2) ***** <url-pattern></url-pattern> 설정방법 ** (이거 어려움 )
	[url 패턴 설정방법 (암기) ]
	
	1. 		/								: 아무것도 안쓰고 / 만 -> 이 웹 어플리케이션의 기본 서블릿으로 매핑 
											(기본 서블릿?? mvc 패턴 설명할 떄 설명하겠음 )
	2.	 	경로매핑 ( /    /* )    		:   /로 시작 + /* 로 끝! => 경로 매핑을 위해 사용됨  
											(경로매핑?? 일단 암기)
	3. 		*.확장자명 					: 확장자 매핑 
	
	4. 위의 3가지 방식 외에는 정확한 url 매핑 (진짜 처음부터 끝까지 정확히 써야함!)
		: contextPath 뒤의 모든 url이 정확해야함 
		
		* '정확한' ? 
			contextPath를 제외한 나머지 url를 정확한 url이라고 한다! 
			
<!-- 매핑 1번 ) web.xml 서블릿 설정 등록 -->
	=> web.xml ! 

<!-- 매핑 2번 ) 서블릿 3.0~ : @WebSerlet 어노테이션을 사용해서 등록해야함  -->
<a href = "<%= contextPath %>/hello"> Hello.java 서블릿 호출 </a><br>

<!-- => 단점 : 자바파일 수정하면 컴파일한거 열어서 다시 수정,배포해야한다??????  -->



</body>
</html>