<%@page import="java.io.DataInputStream"%>
<%@page import="java.util.Enumeration"%>
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

<h3> ex02_ok_02.jsp </h3>

<%
	Enumeration<String> en = request.getHeaderNames();
	out.println(">전송된 헤더정보 출력 <br>"); 
	while(en.hasMoreElements()){
		String key=en.nextElement();
		String value = request.getHeader(key);
		out.println(key+"/"+value); 
	} // while 
%>

<h3> 스트림 형태로 전송된 데이터 정보 출력 </h3>
<%
	ServletInputStream sis =	request.getInputStream() ; // request에 담겨져 있는 읽기 전용 스트림을 받아오는 함수 
	DataInputStream dis = new DataInputStream(sis);
	String line ="";
	while( (line = dis.readLine())!=null  ){
		out.println(new String(line.getBytes("ISO-8859-1"), "UTF-8"));
	} // while 
/* 	스트림 형태로 전송된 데이터 정보 출력
	------WebKitFormBoundaryHK8cXSjKNTnIAhIG Content-Disposition: form-data; name="name" 홍길동
	------WebKitFormBoundaryHK8cXSjKNTnIAhIG Content-Disposition: form-data; name="upload"; filename="Oracle 1일 내용정리.txt" 
	Content-Type: text/plain -- [오라클(Oracle)]-- 0. 기존 오라클 삭제 1) 주요 오라클 서비스 중지 (1) 검색 : 서비스 . (2) OracleService + [SID명] 서비스 OracleService XE 오라클 XE를 1개만 설치된다.  */
%>
</body>
</html>