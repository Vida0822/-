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
<h3> ex04.jsp </h3>
<h3> 요청(request) 객체 사용법 </h3>

<form action="ex04_02.jsp" method="get"> 
<!-- <form action="ex04_02.jsp" method="get">  -->
   이름 : <input type="text" name="name" placeholder="이름을 입력하세요"><br>
   성별 : 
     <input type="radio" name="gender"  value="m" checked="checked"> 남자
     <input type="radio" name="gender"  value="f">여자<br>
    
   좋아하는 동물 :
      <input type="checkbox" name="pet" value="dog" checked="checked">개  
      <input type="checkbox" name="pet" value="cat">고양이  
      <input type="checkbox" name="pet" value="pig" checked> 돼지
      <br>    
   <input type="submit">
</form>

</body>
</html>