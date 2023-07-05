<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<%
	// 전송된 아이디와 비밀번호를 갖고 로그인 성공, 로그인 실패 여부만 도출
	// <-> 로직처리 ('서블릿 클래스'의 주 기능) => 화면에 출력 안하고 로직만 처리하니까 
	
	// 회원테이블 아이디 _ 비밀번호 원래 db연결해서 select 해야하는데 그거 안할거임 (select x)
	String id= request.getParameter("id");
	String passwd = request.getParameter("passwd"); 
	String location ="ex07.jsp"; 
	
	if(id.equals("admin") && passwd.equals("1234")){
		// 로그인 성공  -> 성공했을때 가야할 페이지로 이동 (근데 걍 둘다 ex07.jsp로 다시 이동)
		location +="?ok"; 
	} else{
		// 로그인 실패 -> 로그인 페이지로 다시 이동  (근데 걍 둘다 ex07.jsp로 다시 이동 => 근데 페이지 구분만주는데..! 원래는 다른 페이지를 돌려줘야함 ! )
		location +="?error";  
	}
	
	response.sendRedirect(location); 
	// 서버 : "이 location 으로 다시 요청해" 
	
/* 입력받은 값을 갖고 서버에 요청하럭 감 
-> 아이디/ 비밀번호 체크해서 록인 성공여부 도출 
-> sendRedirect"너 다시 요쳥해" 
-> 클라이언트가 다시 요청함 -> 경고창 뜨는거
=>  그리고 나서 확인하면 소스코드(script 코드) 잘뜸
 */
 
 %>
 