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

[js ajax]
      - 기본 개념 이해
1.ajax 에이작스, 아작스
               [A]synchronous  [J]avascript   [A]nd  [X]ML    
               비동기적인              자바스크립트
                - XML 데이터를 사용하는 [비동기]적인 자바스크립스 기술    
                ㄴ 비동기적? 
2. 페이지 로드 된 후에도  웹 서버에서 데이터를 읽어와서 사용 가능  
  	페이지를 전체 새로 고침되지 않고 웹페이지의 일부분 업데이트 가능
   페이지는 유지된 채로   백그라운드에서 웹 서버와 통신하는 기술.
   
3. 예
           - 네이버 메인 페이지 요청 후  검색부분만 업데이터 기능
             ( 환율, 날씨정보 ,   상품 다음페이지,이전페이지, 검색. ) => 지혼자 계속 바뀌고있는 (알아서 새로고침되고있는) 부분 ! 
             ex) 환율, 증시정보 부분만 불러오면 되는데 전체 페이지 새로고침하면 현제페이지의 모든 로드작업 - db연동...객체만들고...전체 출력하고..  
             (그냥 고정되어있어도 되는 db값들도 계속 새로고침해야함 )
             => 일부분의 데이터만 바꾸는 기술 : 'ajacks' > 현재 페이지는 유지된체 background해서 그 부분만 요청하고 응답받는게 '비동기적처리'라고 한다 (reload가 아니라 back해서 수정! )
           - [  회원가입 ]할 때
               이름 : 홍길동 
               생년월일 : 입력 
               주소      [우편번호 검색 버튼]  ajax         
               기타
               기타
               아이디        [    kenik      ]           [아이디중복체크 버튼]   ajax   (현재페이지 입력값 유지 한테 이 아이디값만 가져가서 아이디 중복체크함)
               기타
               기타
               기타
               기타      
               
4. ajax 장점
              - 성능 향상 :    전체 페이지 다시 요청,응답 X, 수신 데이터양 줄어든다(<-> 처리속도가 향상된다).
              - 개발 향상
              - 각각 서버로 부터 분산 처리 가능
              
5. ajax 단점
              - 클라이언트 기술( javascript 사용) 때문에 보안적인 측면이 취약하다 - js 코드는 누구나 볼 수 있으니까
              - 차별화 X
              - 브라우저 호환성 체크  
              ㄴ 프로젝트 할때 ajax 처리인지 확인 

6. js ajax 처리 방법(과정)
             ㄱ. 웹페이지에서 이벤트 발생   - 
                 예) 네이버 검색창 :   검색   key이벤트 발생.
                    
             ㄴ. 현재 페이지는 유지한 채로  -> 서버 요청
                                                        <- 응답
                                                   백그라운드  객체 , 일꾼(스레드)
                                                   
                    [  XMLHttpRequest 객체를  js로 생성 + 설정 ]
                    // 브라우저 종류 또는 버전에 따라 객체 생성이 다를 수 있다. 
                    XMLHttpRequest  객체명 =  new XMLHttpRequest();
                    // IE 6 이하
                    XMLHttpRequest  객체명 =  new ActiveXObject("Microsoft.XMLHTTP");
                    
                    예)
                     var xmlHttp ;  
                   if( window.XMLHttpReqeust ){
                      xmlHttp = new XMLHttpRequest()
                   } else{
                       xmlHttp =new ActiveXObject("Microsoft.XMLHTTP");
                   } else{
                      xmlHttp = null;
                   } 
          
                    
             ㄷ.   XMLHttpRequest 객체를 사용해서 웹서버 요청
                          파라미터 ->  DB select
                      [ 요청 설정 ]
                      - 설정함수 - 
                      open( "GET" , 요청URI ) 메서드  - 요청 필요한 설정을 하는 함수
                      open( "POST" ) 메서드  - 요청 필요한 설정을 하는 함수
                      
                      - 실제로 갖다와~ - 
                      send() 메서드 -   실제 서버에 요청하는 함수 
                      
                                            
    				  XMLHttpRequest 객체 생성   
                      - 상태값 체크 -
                      가는거 준비중인지, 갔다왔는지 , 가는중인지, 출발했는지 등 
                      => 객체.onreadystatechange 이벤트속성 : 상태가 바뀔때마다 바뀌는 속성 
                      =XMLHttpRequest 객체.onreadystatechange = function 호출하는 함수(){
                      					 서버 + 요청 + 잘 응답 ? if(readState == 4, state==200) }
                      																		ㄴ 성공적으로 갖다옴 <-> 응답데이터 발생함 --> 그거 가져와서
                      						// 받음 
                      					[ 응답 결과 ]
	                                  1. reponseText 속성 : 응답 결과 String 
	                                  2. responseXML 속성 : 응답 결과 XML 

                      1) get 방식
                      ?id=admin
                      true  비동기적 처리,    false 동기적 처리 - 이거 안씀 항상 true (ajax의 목적)
                      XMLHttpRequest 객체.open( "GET", "/test.jsp?id=admin", true )
     				XMLHttpRequest 객체.send( null );
                      
                      2) post 방식
    XMLHttpRequest 객체.open( "POST", "/test.jsp", true )
     XMLHttpRequest 객체.send( "id=admin" );                      
                      
                          
             ㄹ.  서버 요청 처리 -> 응답
             ㅁ.  콜백함수 호출 + 응답결과
                   js 웹 페이지의 일정 부분 +   DOM( 새로운 데이터가 추가, 수정 ) 처리                                
   
   7. js 실습  => ex02.jsp
   		jquery 실습 => ex02_02.jsp 
   		
   		ex03.html
   		ex03_load.html 
   		
   		ex04.jsp
   		ex04_top5.jsp
   		
   		
   		**** 프로젝트에서 본격적으로 사용할 ajax 
   		ex05_deptEmp.jsp
   		ex05_deptEmpAjaxProc.jsp 
</body>
</html>