<%@page import="java.io.UnsupportedEncodingException"%>
<%@page import="java.net.URLDecoder"%>
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

<!--  얘는 수정할 값을 직접 입력을 받아야하기 때문에 html부분 없애지 않음 : 수정값 입력받는 페이지 !-->
<h3> ex02_05.jsp </h3>

<%! 
// 기존의 쿠키 value 값들을 유지하는 메서드 (선언부)
	public String getCookieValue(String cname ,HttpServletRequest request ){
	Cookie [] cookies =  request.getCookies() ; 
	// request 객체가 있어야 모든 쿠키값이 얻어온다 	-> 매개변수로 받아줘야 이 함수 안에서 써줄 수 있음
	for(Cookie c : cookies){
		String cn =  c.getName();
		if(cn.equals(cname) ){
			try{
				String cvalue = URLDecoder.decode( c.getValue(), "UTF-8");
				return cvalue; 	
			}catch(UnsupportedEncodingException e){	}
		}//if
	}// for
	return null; 
} // getCookieValue
%>


<form action="ex02_05_ok.jsp" >
	<%
		// js 쿠키 삭제 : 만료시점 과거로 설정 후 쿠키다시생성(추가) 
		// jsp 쿠키 삭제: setMaxAge(0) -> 응답하는 데이터 처리할때 즉시 쿠키 삭제  (-1 : 브라우저를 닫을 때 삭제)
		
	 String [] upCookieNames = request.getParameterValues("ckbCookie"); // 삭제할 쿠키의 이름들 	 
	 for(int i=0; i<upCookieNames.length ; i++){
		 String cname = upCookieNames[i];
		 String cvalue = getCookieValue(cname , request); // 메서드 생성 
	%>
		<li> <%= cname %> : <input type="text" name="<%= cname %>" value="<%= cvalue %>"> </li>
				<!-- url 부분에 문자열 합쳐줄 때는 "" 안에 띄어쓰기 하면 안됨  -->
	<%
	}// for
	%> 
	<input type="submit" value="쿠키수정"> 
</form>





</body>
</html>