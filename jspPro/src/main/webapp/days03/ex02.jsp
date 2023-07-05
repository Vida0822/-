<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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

<%
//jsp 스크립트 요소 - 스크립트 릿, 자바코딩 
// public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response) 
// 라는 메서드의 지역변수로 선언됨 
	String name = "이혜진"; 
%>

<%= "표현식, 출력 " %>

<%! 
	// 선언문 - 변수, 메서드 등등  => 전역변수로 선언됨 
	int age = 20; 

	
	public String printMsg(String msg){
		return "안녕:"+ msg; 
	}
%>

<%= printMsg("hello") %>




</body>
</html>