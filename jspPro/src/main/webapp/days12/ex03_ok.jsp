<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.FileRenamePolicy"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="java.io.File"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>2023. 5. 31. - 오전 9:33:52</title>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
</head>
<body>
<h3>ex03_ok.jsp</h3>
<%
   String saveDirectory = pageContext.getServletContext().getRealPath("/days12/upload"); // 
   System.out.println("> 실제 배포 한 후  업로드 경로 :  " + saveDirectory);
   File  saveDir = new File( saveDirectory );
   
   if(  !saveDir.exists() ) 
	   saveDir.mkdirs(); // ???????????
			   
   int maxPostSize =  5* 1024 * 1024  ;  // 5MB;     기본단위 byte
   String encoding = "UTF-8";    
   FileRenamePolicy policy = new DefaultFileRenamePolicy();   // 파일명(1).   _1.
   
    MultipartRequest mrequest = new MultipartRequest( 
      request , 
      saveDirectory ,
      maxPostSize ,
      encoding , 
      policy   
      );
   // 벌써 파일은 업로드 폴더에 저장 완료된 상태이다. 
%>

<%
   String msg = mrequest.getParameter("msg"); // 폼태그 잘 전송됐는지 확인 <-> 파일 압로드 시도(요청,request) 
%>
> 전송된 메시지 : <%= msg %><br>

<h3> 업로드된 첨부파일의 정보  </h3>


<%
//파일 압로드 시도(요청,request) -> 그 요청에 업로드 하려는 파일들 담김 
Enumeration en = mrequest.getFileNames(); // MultipartRequest 에 넘어온 파일들의 이름을 출력하는 함수 -> 열거형에 담고! 
while(en.hasMoreElements()){
	String name = (String)en.nextElement(); //nextElement -> Object 타입 반환 : 형변환후 이름만 String 
	
	// getFile() 메서드
	File uploadFile = mrequest.getFile(name); // MultipartRequest의 매개변수 파일이름에 해당하는 첨부팔일을 찾아 'File' 객체로 돌려주는 함수  
	if(uploadFile != null){ // 실제로 그 이름의 파일이 존재하면  
		String fileName = uploadFile.getName();  // '첨부파일' 에 존재하는 속성 : 파일명, 파일크기 
		long fileLength = uploadFile.length();
		String originalFileName = mrequest.getOriginalFileName(name);
		String filesystemName = mrequest.getFilesystemName(name);
%>
	>첨부된 파일명 : <%=fileName  %><br>
	>첨부된 파일크기 : <%=fileLength  %><br>
	>첨부된 원래 파일명 : <%=originalFileName  %><br>
	<!-- 이렇게 정보 뽑아온걸로 그대로 db에 insert -->
<%
	}// if 
}// while

%>




</body>
</html>








