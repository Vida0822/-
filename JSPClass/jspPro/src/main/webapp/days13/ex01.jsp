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

<a href="/jspPro/days13/replyboard/write.do">새글쓰기</a><br>
<a href="/jspPro/days13/replyboard/list.do">목록</a><br>
<a href="/jspPro/days13/replyboard/write.do?num=2&ref=2&step=1&depth=0">답글쓰기</a><br>

<pre>
[***답변형 게시판 로직이해 ***]
(1) board 테이블 저장 
	 ㄴ 글번호(PK) 	제목 
	 	1				첫번째 게시글
		2				두번째 게시글
		3				세번째 게시글 
※		4				2번글 답글 (1)
		5				네번째 게시글 
		6				4번들 답글 
		7				2번글 답글 (2)
		8				7번글 답글
		9				5번글 답글 
			
(2) list.jsp 페이지 출력 
ORDER BY 글번호 DESC (글번호 내림차순 <-> 최신글 순서) 
ㄴ 		글번호(PK) 	제목 
		5				네번째 게시글 
		9					ㄴ 5번글 답글 
		3				세번째 게시글 
		2				두번째 게시글 
		7					ㄴ 2번글 답글 (2)
		8						ㄴ 7번글 답글 
		4					ㄴ 2번글 답글 (1)
		6						ㄴ 4번글 답글 
		1				첫번째 게시글

* point:  db에 들어가는 순서 != 화면에 출력되는 순서 


					↓
											
	(1) board 테이블 저장  	: 칼럼 3개추가 또는 칼럼 2개 추가 
									(글그룹 ref , 순번 step , 깊이 depts 칼럼필요)		 *** 			글그룹이 뭐야???????????????	 순번이 뭐야??????????????
									(글그룹+순번 칼럼 , 깊이칼럼)

	규칙1) 새글 작성 (insert) 
		글그룹(ref) 		<== 글번호랑 같도록 설정
		순번(step) 		<== 1 로 설정
		깊이(depth)  	<== 0으로 설정 		 
		 
	규칙2) 답글 작성 (insert)  
		반드시 부모글 있어야 그 게시글에 대한 답글을 작성할 수 있다 
		부모글의 글그룹(ref) 	==> 답글의 글그룹(ref)는 +0 같아야한다  
		부모글의 순번(step) 	==> 부모글의 순번(step) + 1순번으로 준다 			????????????????????????????
		부모글의 깊이(depth)   ==> 부모글의 깊이 (depth) +1 

	글번호(PK) 	제목 						ref		step		depth
	1				첫번째 게시글(새글)		1			1			0
	2				두번째 게시글(새글)		2			1			0
	3				세번째 게시글(새글)		3			1			0
	4				2-답글						2			2->3		1	
	5				4-답글						2			3->4		2	
	6				2-답글						2			2			1

	고려사항) 
		같은 ref 그룹의 부모의 순번보다 큰 순번을 가진 게시글의 순번을 1증가시키는 update를 먼저 처리한다
		
		 
	(2) list.jsp 페이지 출력 	
	ORDER BY REF DESC, STEP ASC 
	
	글번호(PK) 	제목 						ref		step		depth
	3				세번째 게시글(새글)		3			1			0
	2				두번째 게시글(새글)		2			1			0
	6				[]ㄴ 2-답글				2			2			1
	4				[]ㄴ 2-답글				2			2			1
	5				[][]ㄴ4-답글				2			3			2	
	1				첫번째 게시글(새글)		1			1			0

</pre>

<pre>
1~1000 		-> 하나의 그룹 
1001~2000 	-> 하나의 그룹

[db]
	글번호(PK) 	제목 						그룹 + 순번 		깊이 (depth)
	1				첫번째 게시글(새글)		1000				0
	2				두번째 게시글(새글)		2000				0
	3				세번째 게시글(새글)		3000				0
	4				2-답글						1998				1 
	5				4-답글						1997				2 
	6				2-답글						1999				1 
	

ORDER BY 그룹순번 desc 
[jsp]
	3				세번째 게시글(새글)		3000				0
	2				두번째 게시글(새글)		2000				0
	6				[]ㄴ2-답글				1999				1 
	4				[]ㄴ2-답글				1998				1 
	5				[][]ㄴ4-답글				1997				2 
	1				첫번째 게시글(새글)		1000				0
</pre>
</body>
</html>