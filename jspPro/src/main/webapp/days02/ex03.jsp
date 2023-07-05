<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<% String contextPath = request.getContextPath(); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Insert title here</title>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>

<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<script>
  $( function() {
    $( "#tabs" ).tabs();
  } );
</script>
  

</head>
<body>

<pre>
[서블릿 예제]
1. get, post 방식 확인 
get 방식		이름 / 나이 전달
 post 방식 	이름 / 나이 전달 

2. Info.java 서블릿 클래스 
	ㄴ url 패턴 : /days02/info.htm
	[문제] 이거 규약에 적합한 url 패턴인가? 해당한다면 규약 중 몇번에 해당? 
	=> oo 4번! 

//https://jqueryui.com/tabs/#default


form 태그의 get 방식와 post 방식을 설명해보겠다 ~ (ex03, ex03_ok, info)


</pre>

<div id="tabs">
	  <ul>
		    <li><a href="#tabs-1">get 방식 요청</a></li>
		    <li><a href="#tabs-2">post 방식 요청</a></li>
	  </ul>
	  <div id="tabs-1">
	  	<p>
	  		****
	  		(지금까지 한거 전부다 get 방식)
	  		1. 웹 브라우저 : 주소창 url 입력한 후 서버에 요청 -> 'get 방식 요청'  <br> 
			2. a href = "링크태그 - get방식 요청" <br>
			3. location.href -> get 방식 요청 <br>
			****
			
			<br>
			정수 : <input type="text" id="n" name ="n" value="10"><br>
			<a href="/jspPro/days02/ex03_ok.jsp">ex03_ok.jsp</a>
			<!--  이거 링크 클릭해도 input 값 안가져가자나 왜? form 없으니까...
				=> 이거 코딩으로 보내주겠음 
			 -->
	  	</p>
	  </div>

<script>
	// get 방식으로 파라미터 넘겨주기 
	$(function() {
/* 	$(function()) { */
		$("#tabs-1 a").on("click", function() {
			/* 이거 에러남~~ 
			let oldHref = $(this).attr("href");  // 자기자신을 뜻함 : /jspPro/days02/ex03_ok.jsp??
			let href = oldHref +"?n="+$("#n").val();  //jspPro/days02/ex03_ok.jsp??
			$(this).attr("href", newHref); 
			*/ 
			$(this).attr("href", function(i, oldHref) {
				return  oldHref +"?n="+ $("#n").val();
			})
		})
	}) // function
</script>



	  <div id="tabs-2">
	  		<p>
	  			<form>
	  				Name: <input type="text" id="name" name="name" value ="홍길동"><br>	  			
	  				Age: <input type="text" id="age" name="age" value ="20"><br>	  	
	  				
	  				<input type="radio" name="method" value="get" checked="checked"> Get 요청 		
	  				<input type="radio" name="method" value="post" checked="checked"> Post 요청 
	  				<br>
	  				<button type="button"> 전송(submit) </button>
	  				<!--  실제 서브밋 하는 버튼이 아님 (type="submit 이 아님)  -->		
	  			</form>
	  		</p>
	  </div>
</div>

<script>
	$("#tabs-2 form button").on("click", function() {
		// get , post => radio의 checked 속성값을 갖고 있는지에 따라 달라짐 
		let method = $("#tabs-2 form :radio:checked").val(); // post 
		
		$(this)
			.parent() //form 
				.attr({
						"action":"<%= contextPath %>/days02/info.htm",  
						"method":method 
					})
				.submit(); 
				// 이걸 누르면 설정해준 post방식으로 처리되기 위해 
				// doPost() 메서드를 호출하고 그 안에서 넘겨준 값들을 처리해서 넘겨준 다 
	}); 

</script>
</body>
</html>





