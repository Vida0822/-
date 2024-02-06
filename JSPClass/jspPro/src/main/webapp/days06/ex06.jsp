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

<h3> ex06/jsp </h3>


<pre>
    [ JSP에서 제공하는 9가지의 기본객체와 		/	영역( scope ) -> ex02 ]
    							자료형 
    1. request *       : 요청된 정보를 담고있는 객체 
    						   HttpServletRequest 클래스명            요청 객체
                               (ServletReqeust X) 
                           
    2. response     : HttpServletResponse   		응답 객체 
    3. out              : JspWriter                    		 출력 스트림 객체
    4. pageContext * :PageContext    				JSP 페이지 대한 정보를 저장하는 객체. (페이지의 '정보'를 저장하는 객체)
    vs page           : Object          					JSP 페이지를 구현한 '자바' 클래스 인스턴스 
    																(jsp 가 클래스, 객체로 만들어질때 그 java 클래스 자체를 페이지 객체라고 함 )
    5. session  *      :  HttpSession                      http 세션 정보를  저장한다. 
    6. application  * :  [ServerContext]               웹 어플리케이션(사이트)에 대한 정보 저장.
                                                                        웹 사이트
                                                                        서버 정보 저장
                                                                        
    7. config         : Servlet[Config]                설정 정보 저장 
    8. exception    :  Throwable                       예외 처리 객체 
    
    
</pre>

</body>
</html>