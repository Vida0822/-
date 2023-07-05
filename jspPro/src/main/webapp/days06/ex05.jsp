<%@ page buffer="8kb" autoFlush="false"  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
1. jsp 요청 처리과정 
[2. 출력버퍼 ] 
[ex05.jsp]  - 요청 -> ex05_jsp.java -> 서블릿 객체 
				<- 응답 데이터 생성
					[ 출력버퍼에 담음 ] 
					=> 이 출력버퍼가 꽉 차면 클라이언트에 이걸로 응답데이터 만들어 보내고 싹 비움 !! 
					=> 그 다음에 다시 남은 코딩 실행해서 응답 데이터 만듬 (반복 )
'overflow' 
: 채워넣을건 남았고 근데 autoflush를 막아서 보내지도 못하게 해 출력버퍼이상의 데이터가 들어오는 overflow 발생 



</pre>

<%
// 	out.flush();   // 출력버퍼 비우라고 명령 
	for(int i=1; i<15 ; i++){
/* 	for(int i=1; i<1000 ; i++){ */
		if(i==10) out.clear();
	// 그 동안 응답버퍼에 저장된 데이터를 제거하라 : 15번 쌓고 보내려했떤 응답버퍼를 비우고 5개를 다시 쌓고(.java니까) 이걸로 응답 클래스 생성 
	// => 그전에 담겨져있던 데이터 없어지고 이 5개만 응답 데이터로 만들어짐 
		out.print("1234"); 
	}
%>


</body>
</html>