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
<h3>ex04_template_02.jsp</h3>


<div style="text-align: center">
<table width="600" border="1" align="center">
  <tr>
     <td colspan="3">
     		<%@ include file="/layout/top.jsp" %>
     		<!--  include 지시자 action 태그와 차이점 
			=>  실행시 얘 서블릿이 따로 만들어져서 거기로 이동하는게 아니라 
			이 자리에 해당 파일의 코딩이 그대로 복사붙이기 돼서 
			코드끼리 합쳐져서 하나의 서블릿 클래스가 생성 
			(vs action : 여러개의 서블릿 클래스가 하나의 응답 클래스를 구성 ) 
			
			=> 즉, action 태그는 서블릿끼라 합치는 느낌이라면 얘는 그 전단계인 코드를 합쳐 클래스파일로 한번에 컴파일 
			
			- include 지시자 -> 모든 페이지마다 공통적으로 사용해야하는 코드를 이 지시자로 빼는게 좋다 ex) contextPath ! 
				(이론상 ! 실제론 걍 섞어서 쓰는듯...) 
				=> 지금처럼 layout을 구현하는 파일들을 할땐 원칙적으론 action 태그를 쓰는게 맞다 
			- 
			 
 -->
 
     </td>
  </tr>
  <tr height="300">
    <td width="150" valign="top" style="background: yellow">
    	<%@ include file="/days06/layout/left.jsp" %>
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
    	    	<%@ include file="/days06/layout/right.jsp" %>
    </td>
  </tr>
  <tr>
    <td colspan="3">
    	<%@ include file="/layout/bottom.jsp" %>
    </td>
  </tr>
</table>
</div>

</body>
</html>








