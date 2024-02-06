<%@page import="java.util.Date"%>
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

<H3> ex02.jsp </H3>

서버요청시간 : <%= new Date().toLocaleString() %> <!--  기본생성자 -> 현재 날짜 + 시간  -->
<br>

<input type="button" value="js ajax" onclick="load('ex02_ajax_info.txt')">

<p id="demo"></p>


<script>
var httpRequest ;  // 1. XMLHttpRequest : 브라우저마다 존재
function getXMLHttpRequest(){
    if( window.ActiveXObject ){   // IE 
            try{
               return new ActiveXObject("Msxml2.XMLHTTP");   // 
            }catch(e){
               try{
                 return new ActiveXObject("Microsoft.XMLHTTP");
               }catch(e){
                  return null;
               }
            }
      }else if( window.XMLHttpRequest ){
             return new XMLHttpRequest();
      }else{
         return null;
      }
 }
 
function load(url) {
	// 1. XMLHttpRequest 객체 필요 (생성)
	httpRequest = getXMLHttpRequest(); 
	// 2. onreadystatechange 속성 =+ 콜백함수 선언 
	httpRequest.onreadystatechange = callback; // 앞에게 성공적으로 실행되면 실행되는 함수 (등록이라!!!! )
	// 3. open() : 비동기적 처리위한 설정작업
	httpRequest.open("GET", url, true); 
	// 4. send() : 실제로 일하고 오라는 메서드
	httpRequest.send();  // 변화발생 -> 등록된 콜백함수 실행 
}

function callback() {
	if(httpRequest.readyState==4){ // 요청완료 (갔다 왔다)
		if(httpRequest.status == 200){ // 요청성공 (제대로가져왔다) 
			// 이름 가져옴 
			// $("#demo").html("");  -> 초기화
			var msg = httpRequest.responseText;	 // 응답받는 데이터 (String으로)
			var names = msg.split(",");
			for (let name of names) {
				$("#demo").append($("<li></li>").text(name)); 
				// 이거 계속 눌러서 이름들 계속 가져오는데 처음에 설정한 시간은 안바뀜 !  => 비동기 잘되된거임 
			}
		}
	}// if 
}// callback 
</script>

</body>
</html>