<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%

	String contextPath = request.getContextPath();

%>
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

<pre>
contextPath =<%= contextPath %> 

webPro 프로젝트 자체가 웹 어플리케이션이다....??
=> 웹 상에서 실행되는 프로그램 
-> 올라가면 웹 서버에 올락 ㅏ있어야함 
-> 웹 어플리케이션을 서비스 하기 위한 서가 웹 서버 
-> 웹 서버에서 실행되어지는 프로그램 : 웹 어플리케이션 

웹 사이트 == 웹 어플리케이션 
 이 웹사이트가 어디서 돌아가? 서비스 되는 서버 웹 어플리케이션 서버 (줄여서 웹 서버)
 ㄴ 그냥서버임...was말구.. 
 
contextPath란 ? 

was(톰캣)에서 웹 어플리케이션을 구분학 위한 경로 

: '경로' ! 
어디에서?  WAS(톰캣에서)
뭐를 ? 웹상의 어플리케이션을  
무슨 경로? 구분하기 위한 !


- /jspPro == 이클립스에선 다이나믹 웹프로젝트명이 contextPath가 되어진다! 

ㄴ 이걸 왜 사용하고 뭐때문에 중요한가? 
	server.xml 156 line 
	:  <Context docBase="jspPro" path="/jspPro" reloadable="true" source="org.eclipse.jst.jee.server:jspPro"/> 

EX) 
톰캣에서 쇼핑몰 사이트 == 쇼핑몰 웹 어플리케이션 을 구동하고 있다
-> 같은 톰캣 서버에 회사 내에서 사용하는 사내 사이트 구축 !
ㄴ 사내 사이트 == 사내 웹 어플리케이션 
<-> 하나의 톰캣 서버에 한개의 웹 어플리케이션이 아닌 여러개의 웹 어플리케이션을 구분할 수 있다


ㄴ 외부에서 접근 어떻게? 
http://www.kenic.com/'프로젝트명'/ 
http://localhost/'jspPro'
=> 이렇게 구별해줘야 외부에서 접근할 때 구분해서 접근할 수  있음 

하나의 톰캣서버에 여러개의 사이트를 구동할 경우 이걸 구분해줘야 정확하게 접근할 수 있음 ! 

* 절대경로로 주면 도메인 www. 가 바뀔 수 도 있기 때문에 컨텍스트 패스부터 상대경로로 주고!
컨텍스트 패스도 바뀔 수 있기 때문에 얘도 코딩 request.getContextPath(); 이걸로 얻어와 변화해도 괜찮게 유지보수해줌 


ㄴ 무조건 jspPro 가 컨텍스트 패스? 
Module을 / 로 설정하면 기본으로된다 (default일 수도 있음)
ㄷㅌ) localhost/days03/html 

 

</pre>
</body>
</html>