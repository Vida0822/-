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

<h3> ex01.jsp  </h3>

<a href ="<%=contextPath%>/board/list.do">클릭</a>

<pre>
[MVC 패턴 구현]
1. jsp 웹 어플리케이션의 '구조' 
1) 모델1 구조
	
	board/list.jsp - 요청 -> list.jsp 
										ㄴ 로직처리 + 출력 모두 여기서 처리
	
	ex) days02/test01 : 로직처리 코딩 이만큼 + 출려 코딩 이만큼 
	
2) 모델2 구조 
															/ 출력담당 
	board/list.htm ---요청 -> List.java -> list.jsp 
										ㄴ 로직만 처리 (그래서 출력기능 하나도 없고 
										오직 자바 코딩만 쓸 수있는 class파일 사용 )
										-> 포워딩
							<--응답--
	
2. 모델2 구조 기반의' MVC 패턴으로 (모델2구조 : 여러가지 있는데 그중!)
	웹 어플리케이션을 구현 
	
	M : Model
	V : View 
	C : Controller    ->  모든것을 제어, 관리 (모든 요청받고, 응답하고, 부르고...) 	[1개 or 요청별 여러개] 
	
	list.htm  -- 요청 ---> [Controller]  : 이 반환된 list를 Controller가 받아서 (request.setAttribute) ----포워딩---> [View]
															 			 		 			return list  ㄱ												ㄴ jsp (반드시는 x) => 응답데이터를 만들어서 컨트롤러한테 반환  (컨르롤러 : 클라에 반환 )
									ㄴ 이 요청에 해당되는 '담당자'를 찾음                   
									: 'Model' (; Command Handler)
									- ListHandler.java : list ListService.java 호출 -> list BoardDao.select() 호출 -> list 오라클 연동  
	=> 유지보수, 확장성이 좋다 
	
	*  컨트롤러만 Servlet이다 	! 		 
	 
3. JSP 개발자라면 반드시 습득해야할 기술 
	=> Spring(MVC) 프레임워크에서 보다 쉽게 적용할 수 있다 
	(스프링 프레임워크?    )
	
4. MVC 패턴 실습 
	=> days05
			ㄴ board 게시판
					ㄴ delete.jsp, edit.jsp, list.jsp, view.jsp, write.jsp
		 java - ~~ 
</pre>

<pre>
[위에 게시판 구현을 MVC 패턴으로 구현]

1. days08 폴더
	ㄴ board 폴더 생성 => [V]iew를 담당하는 jsp 페이지들을 넣어둔다 
	
2. DBCP 커네션 풀 사용 
 	web.xml - 복사 붙이기 => web_days07.xml  (days07까지 사용했던 xml)
 	web.xml => 오늘 mvc 패턴에 사용할 web.xml 파일
 
 3. web.xml 서블릿 등록 - MV[C] 등록 : 모든 요청은 이제 얘가 받을거기 때문에~ 
	- days08.mvc.controller 패키지 추가 
		ㄴ DispatcherSevlet.java : 일반 클래스로 추가해 web.xml 에 등록시킬 거임 
												(클래스 규약에 맞춰 써 web.xml에서 매핑)

4. *.do (htm 과 충돌 방지)
	list.do -> DispatcherServlet.java
	view.do -> DispatcherServlet.java
	edit.do -> DispatcherServlet.java
	write.do -> DispatcherServlet.java
							ㄴ 모든 요청 얘가 받아야함 

5. /WEB-INF/commandHandler.properties 
	파일 생성 
	-> list.do => ListHandler 모델 객체 만들어져야함 
	(요청 url = 명령을 실행할 로직 객체 등록파일)
	=> 요청 url 별 담당자 목록을 만들어놔야함

6. 모든 로직을 처리하는 commandHandler(Model) 객체는
	 CommandHandler라는 인터페이스 구현하도록 코딩 

	days08.mvc.command 패키지
	ㄴ CommandHandler inteface 
		
7. 게시글 목록 처리 - ListHandler(Model) 생성 
	days08.mvc.command 패키지
	ㄴ ListHandler class 
		
8. days08.mvc.domain 패키지 
	ㄴ DTO 
	
9. days08.mvc.persistence 패키지 - BoardDao, BoadDaoImp
	
10. days08.mvc.service 패키지 

11. days08.mvc.domain 패키지 
	ㄴ pageDTO
	
12. days05.board.List.java -> 복붙 => ListHandler.java 구현 (약간 수정)

13. days08>board>list.jsp 복붙 

14. DispatcherServlet.java init() 


</pre>
</body>
</html>















