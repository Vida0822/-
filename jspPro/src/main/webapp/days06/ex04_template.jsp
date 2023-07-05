<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>2023. 5. 22. - 오후 3:23:54</title>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
</head>
<body>
<h3>ex04)template.jsp</h3>

<div style="text-align: center">
<table width="600" border="1" align="center">
  <tr>
     <td colspan="3">
     	 <!-- action 태그 : 서버에서 서버로 이동해 버에 가서 실행되는 애! -> /jspPro 로 시작하지 않음 (어차피 같은 서버에 있으니까 서버를 찾아갈 필요 없음) -> /layout 바로 써줌 
     		 	=> 만약 top 부분에 수정사항이 생긴다면 매 페이지마다 가서 찾아 수정해 줄 필요 없이 그냥 이 모달 파일하나만 수정해ㅁ주면 딤 
     		
     			=> 다른 서블릿 ! 이 서블릿으로 이동해서 출력하고 다시 돌아오는 거임 (그 서블릿 객체가 응답) 
     			=> flush = false : 
     			=> 여기서 flush 속성 true 주면 이 top 서블릿이 내용 채우고(응답 버퍼를 채우는거임)  클라이언트에 보내버림 
     			=> 만약 채우다가 버퍼가 다 차면 autoflush 발생 
     			=> 이 페이지 하나를 구성하는데는 서블릿 5개가 같이 구성하고 있는거임 
     		 -->

<!--  <div style="border:1px solid gray; height:100px ; text-align:center">
		<h3> 홍길동 웹사이트 Top </h3>
		</div>

		<a href ="#"> 게시판 </a>
		<a href ="#"> 회원관리 </a>	  -->
       <jsp:include page="/layout/top.jsp" flush="false">
          <jsp:param value="20" name="age"/>
       </jsp:include>
     </td>
  </tr>
  
  <tr height="300">
    <td width="150" valign="top" style="background: yellow">
      <jsp:include page="/days06/layout/left.jsp"></jsp:include>
    </td>
    <td>
      <a href="ex04_memberAdd.jsp">회원 추가</a><br>
          회원 관리 Content 부분<br>
          회원 관리 Content 부분<br>
          회원 관리 Content 부분<br>
          회원 관리 Content 부분<br>
          회원 관리 Content 부분<br>
    </td>
    <td valign="top" style="background: red">
      <jsp:include page="/days06/layout/right.jsp"></jsp:include>
    </td>
  </tr>
  <tr>
    <td colspan="3">
      <jsp:include page="/layout/bottom.jsp"></jsp:include>
    </td>
  </tr>
</table>
</div>

</body>
</html>









