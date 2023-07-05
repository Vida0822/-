<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
</head>
<body>
<h3> ex05.jsp </h3>
정수 : <input type="text" id="num" name="num"><br>

<p id="demo"></p>

<script>
$(function() {
	$(":text[name=num]")
		.css("text-align","center")
		.keyup(function() {
			if (event.which == 13) {
				$("#demo").html("");
				let n = $(this).val();
				let sum = 0;
				for (var i = 1; i <= n; i++) {
					sum += i;
					$("#demo").html(function(index,oldHtml) {
						return oldHtml + i + ( i==n ? "" : "+" );
					});
				}
				$("#demo").html(function(index,oldHtml) {
					return oldHtml + "=" + sum;
				});
				$(this).select();
			}
		});
});
</script>
</body>
</html>