<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>2023. 5. 19. - 오전 9:17:47</title>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
</head>
<body>
<h3>days05.ex01.jsp</h3>
<pre>
2023.05.19 (금)
   days05
      ㄴ board 폴더생성
      ㄴ images 폴더 추가
      ㄴ ex01.jsp      
  days05.board 패키지 추가    
  
     
</pre>

<a href="<%= contextPath %>/cstvsboard/list.htm">게시글 목록 보기</a>


<pre>
2023.05.22 (월)
<페이징 처리>
1. jdbc - boardService 확인
2. list.jsp - a 링크 모두 주석처리 => 코딩으로 만들어ㅈㄹ거임 
3. days05.bopageDTO 

<	 	[1] 2 3 4 5 6 7 8 9 10 	> 
next	 start					end   prev
=> 이런 정보들을 저장하고 있는 객체가 pageDTO ! 
=> 이걸 생성해서 list.jsp 에 돌려주면 이걸 바탕으로 페이징 동적으로 생성 



준비물 
: cstvsboard 테이블,시퀀스, 게시글 데이터들 

[테이블]

  CREATE TABLE "SCOTT"."CSTVSBOARD" 
   (   "SEQ" NUMBER NOT NULL ENABLE, 
   "WRITER" VARCHAR2(20 BYTE) NOT NULL ENABLE, 
   "PWD" VARCHAR2(20 BYTE) NOT NULL ENABLE, 
   "EMAIL" VARCHAR2(100 BYTE), 
   "TITLE" VARCHAR2(200 BYTE) NOT NULL ENABLE, 
   "WRITEDATE" DATE DEFAULT SYSDATE, 
   "READED" NUMBER DEFAULT 0, 
   "TAG" NUMBER(1,0) NOT NULL ENABLE, 
   "CONTENT" NCLOB, 
    PRIMARY KEY ("SEQ")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" 
 LOB ("CONTENT") STORE AS BASICFILE (
  TABLESPACE "USERS" ENABLE STORAGE IN ROW CHUNK 8192 RETENTION 
  NOCACHE LOGGING 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)) ;


[시퀀스]
   CREATE SEQUENCE  "SCOTT"."SEQ_CSTVSBOARD"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;


[데이터 채우기]
DECLARE
BEGIN
    FOR i IN 1..150
    LOOP
      INSERT INTO cstvsboard (seq, writer, pwd, email, title, tag, content) 
	   VALUES (SEQ_CSTVSBOARD.NEXTVAL, 'hong' || i , '1234', 'hong@n.com' , 'test - ' || i , 0 , 'test ' || i );
    END LOOP;
     
END; 



</pre>
</body>
</html>





