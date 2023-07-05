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

<pre>
	[jsp 페이지 + 예외처리하는 방법 ! ]  (우선순위대로 나열)
1. try~catch~finally 문 사용 
2. 에러 처리하는 에러 페이지를 지정 
	ㄴ errorPage 속성에 에러페이지를 지정 
	ㄴ 외부에서 접근할 수 없는 폴더 : WEB-INF 폴더 (서버에서만 접근할 수 있는 페이지 만들고 싶으면 web-inf 만들기)
		: 이 안에 jsp 폴더 생성 ->  그 안에 에러 처리하는 jsp파일(페이지) 추가 
			ㄴ viewErrorMessage.jsp -> 지시자 (is)		
3.예외 타입별로 에러 페이지 지정  (NullPointException , ~~ Exception )
4. 응답상태 코드별(404,505)로 에러페이지 지정 
5. 위의 아무것도 해당되지 않으면 웹컨테이너가 제공하는 기본 에러페이지를 적용한다 
</pre>


	<%
	String name = null;
	try {
		name = request.getParameter("name");
		name = name.toUpperCase();
		// 500번 오류면 무조건 자바코딩오류 : parameter가 없어서 name에는 null이 들어가는데
		// 이걸 대문자로 바꾸려하다보니 오류발생! 
	} catch (NullPointerException e) {
		name = "홍아무개"; // 여기로 넘어와 name 값에 홍아무개 대입 => 아래 출력코딩 정상적으로 실행됨 
	} catch (Exception e) {

	}
	%>
	name 파라미터값 :
	<%=name%><br>


</body>
</html>