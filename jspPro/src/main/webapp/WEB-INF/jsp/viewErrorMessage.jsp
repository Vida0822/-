<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>2023. 5. 22. - 오후 2:26:20</title>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
</head>
<body>
<h3>viewErrorMessage.jsp - 에러 처리하는 페이지</h3>

요청 처리 과정에서 에러가 발생했습니다<br>
빠른 시간 내에 문제를 해결하도록 하겠습니다.

<p>
    jsp 기본 내장 객체 중 : [ exception ]
    <!-- exception cannot be resolved -->
    에러 타입 : <%= exception.getClass().getName() %><br>
    에러 메시지 :<%= exception.getMessage() %><br>
</p>

</body>
</html>



