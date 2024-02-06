<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>2023. 5. 25. - 오후 9:46:54</title>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
</head>
<body>

<pre>
[sql developer에 생성]

create table member 
(
  memberid varchar2(50) primary key
  , name varchar2(50) not null
  , password varchar2(10) not null
  , regdate date not null 
)

create table article
(
  article_no number primary key
  , writer_id varchar2(50) not null
  , writer_name varchar2(50) not null
  , title varchar2(255) not null
  , regdate date not null
  , moddate date not null
  , read_cnt number
)
create sequence seq_article;

create table article_content
(
  article_no number primary key
  , content clob
  , constraint fk_article_content_article_no foreign key(article_no) references article(article_no)
);

</pre>

</body>
</html>