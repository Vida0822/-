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
1. 파일업로드 : 클라이언트 -> 서버
    파일 다운로드 :   "     <-    "

2. 파일 업로드 
- 쇼핑사이트 : 상품등록
- 문서파일 또는 이미지 파일등을 서버에 올리는 작업(업로드)

3. 실제 파일 업로드하려면 (꼭 기억)
ㄱ. 스트림 기반의 전송방식은 method="post"로 설정 (무조건)
ㄴ. 인코딩 설정 
	 ㄴ 기본설정 : enctype ="application/x-www-form-urlencoded
	 =>  enctype="multipart/form-data"  (이거 철자 ㅈ주의 )

4.실습 
 days12 폴더 
 	ㄴ upload 폴더 추가 
 	ㄴ ex02.jsp
 	ㄴ ex02_ok.jsp 
 	
 	request 객체론 파라미터 얻어올 수 없음 - ex02_ok_02.jsp 

5. 파일 업로드 방법 (서버-파일 -> 저장)
1) sis InputStream을 사용해 개발자가 직접 전송한 스트림 속에서 파라미터값, 첨부된 파일명, 파일을 파싱하는 방법 -> x 
2) *** 외부 라이브러리 사용 *** 
ㄱ. 
http://servlets.com/
http://servlets.com/cos/
ㄴ. cos-22.05.zip 다운 
압축 풀어서 cos.jar  -> /WEB-INF/lib 에 넣기 
cos-22.05\doc 파일 참조 + 샘플 예제 
ㄷ. cos.jar 파일에서 제공하는 [MultipartRequest] 클래스 제공 + 객체 생성해서 파라미터값, 첨부파일 처리

MultipartRequest mrequest = new MultipartRequest(ㄱ,ㄴ,ㄷ,ㄹ,ㅁ) ; 
ㄱ. request 객체 
ㄴ. 서버에 저장될 위치(경로)
ㄷ. 최대 파일 크기
ㄹ. 파일의 인코딩 방식
ㅁ. 파일 중복 처리위한 인자(클래스 제공 )
	upload 폴더
		ㄴ test.html 
		ㄴ test.html 
		=> 이렇게 있는 파일에 다시 있는 파일을 넣는 상황에서 어떻게 처리할지 다룸 (뒤에 index 추가? 덮어쓰기? )

ㄹ. 실습 
	1) upload 폴더 확인 
	2) ex03.jsp
		ex03_ok.jsp

3) 서블릿 3.0 또는 3.1 이상에서 제공하는 라이브러리 사용 => 2번처럼 외부 라이브러리 따로 설정 안해줘도 된다 
(1) HttpServletRequest request의 getPart()를 이용해서 업로드된 데이터(파일) 접근할 수 있는 [Part객체] 얻어옴
(2) 서블릿이 [multipart 데이터]를 처리할 수 있도록 
	- web.xml 설정 
	- @MultipartConfig 어노테이션을 사용해설정 
	
실습 : ex04.jsp 추가 
	days12.UploadServlet.java 추가 
	web.xml -> web_days11.xml

</pre>


</body>
</html>