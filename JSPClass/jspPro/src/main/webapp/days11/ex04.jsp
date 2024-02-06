<%@page import="java.util.Date"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>2023. 5. 30. - 오전 10:05:40</title>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script src="httpRequest.js"></script>
</head>
<body>

처음 ex04.jsp 요청한 시간 :  <%= new Date().toLocaleString() %> 
<br>
<br>
<input type="button" value="emp sal Top5"  onclick="getTop()">
<br>
<p id="demo"></p>

<script>
var timer;
function getTop(){
     
     sendRequest("ex04_top5.jsp", null, callback, "GET");
     
     timer = setTimeout(  getTop    ,  4000);  // 4초 후에 다시 getTop 호출
     
}

function callback(){
     if( httpRequest.readyState == 4 ){   // 서버 요청 완료
         if(httpRequest.status == 200){   // 응답 성공
           $("#demo").html( httpRequest.responseText );
         }else{
            alert("에이작스 실패 : " + httpRequest.status );
         }
      }
}

</script>

</body>
</html>


