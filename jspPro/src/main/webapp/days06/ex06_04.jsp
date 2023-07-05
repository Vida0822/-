<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.FileReader"%>
<%@page import="java.io.File"%>
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
<style>
  div{
     border: 1px solid gray;
     padding: 5px;
     margin-top:10px;
     max-height: 500px;
     overflow: auto;
   }
</style>
</head>
<body>

<h3> ex06_04.jsp </h3>
<%
	String path = application.getInitParameter("filePath"); 
	String realPath = application.getRealPath(path); 
	//  application.getRealPath(path) ****** : 웹이 톰캣에 배포가 됐을 때 그 배포된 실제 경로 !
	// : D:\Class\WorkSpace\JSPClass\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\jspPro\days06 
	// 엥 우린 배포한저이 없는데 ? 자동으로 배포되어짐 (이 주소로 들어가보면 우리 파일들 그대로 올라가있음 
			// -> 자동으로 배포해놓은거임)  => 이 경로에 배포되는거임 .... : 실제론 installer 톰캣에 업로드함 ('배포')		
			
	// days06 폴더안에 있는 파일 목로을 읽어와서 담아옴. 
	File dir = new File(realPath); 
	File[] listFiles = dir.listFiles(); 
%>

<!-- 이 예제는 그냥 realPath 라는 개념을 설명하기 위함 + 자바 복습  -->
<form>
	<select id="file" name="file">
		<%
			for(int i=0 ; i<listFiles.length ; i++){
				if(listFiles[i].isFile()){ // > 이렇게 하면 폴더같은거 빼고 진짜 파일만 얻어옴 
		%> 
			<option><%= listFiles[i].getName() %></option> <!--  근데 그냥 이렇게만 하면 폴더들도 얻어돔  -->
		<%		
				}// if 
			} // for 
		%>
	</select>
</form>
<%-- <%= realPath %>  --%>

<%
	String fname = request.getParameter("file") == null ?
			listFiles[0].getName() : request.getParameter("file");
	String fileName = String.format("%s\\%s" , realPath, fname); 
	String content = ""; 
	
	try(
		FileReader fr = new FileReader(fileName) ;
		BufferedReader br = new BufferedReader(fr); 
	){
		String line = null; 
		StringBuffer sb= new StringBuffer(); 
		while( (line = br.readLine()) != null){
			sb.append(line+"\r\n"); 
		}// while 
		content = sb.toString();
		content = 
				content
					.replaceAll("<", "&it;")
					.replaceAll(">", "&gt;")
					.replaceAll("\r\n", "<br>;"); 
	}
	catch(Exception e ){
		e.printStackTrace(); 
	}finally{
		
	}
%>
<div>
	<code>
		<%= content %>
	</code>
</div>

<script>
	$("#file").change(function() { // 파일 select 태그에서 선택한 옵션 변화시 서버로 해당 정보 전송 
		$(this).parent().submit(); 
	}) // change 
	
	$("#file").val(' <%= fname %> ');  
</script>

</body>
</html>