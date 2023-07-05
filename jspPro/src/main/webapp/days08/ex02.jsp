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

<h3> ex02.jsp  </h3>


<pre>
[MVC 정리]
1. web.xml 수정 
	1) DBCP 설정 
	2) DispatcherServlet 서블릿 등록 
2. days08.mvc.controller.DispatcherServlet 생성 (서블릿)
	init() {
		commandHandler.properties 파일 ; 
		this.commandHandlerMap.put(요청url, 핸들러 인스턴스) ;
	}
	doGet(){
		/board/list.do  (요청 url) 받아와서
		ㄴ 이 key값으로 Map안에 있는(key) 의 Handler객체를 얻어옴 
		CommandHandler handler = commandHandlerMap.get(key);
		String viewPage = handler.process(); 
		// 포워딩 : viewPage
		// 원랜 리다이렉트도 여기서 처리해줘야하지만 이건 Handler process()에서 처리 
	} 
3. WEB-INF/commandHandler.properties  파일 생성 
	요청 url=Handler
4. /jspPro/board/list.do 요청 
5. 					Model(Handler)			View
	List.java -> ListHandler 				list.jsp
	Write.java -> WriteHandler 			write.jsp
	Edit.java -> EditHandler				edit.jsp
	View.java -> ViewHandler				view.jsp
	Delete.java -> DeleteHandler		delete.jsp
	
	* 지금 삭제 실패시 틀렸다고 하는거 안뜸 
</pre>


</body>
</html>