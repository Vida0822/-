-- SCOTT --
-------------------------------------------------------------------------------
1) 요구분석 -> 요구분석서(요구명세서) 작성
2) 개념적 DB 모델링( ERD )
3) 논리적 DB 모델링
    (1) 부모 테이블과 자식 테이블 : 생성 순서, 관계의 주체
        관계형 데이터베이스( RDBMS )
        예) dept 테이블 <소속관계> emp 테이블 - 생성 순서
              부모                  자식
        예) 고객 테이블 <주문관계> 상품 테이블 - 관계의 주체
              부모                  자식
              
    (2) 기본키( Primary Key )와 외래키( Foreign Key )
        부(dept)      관계      자(emp)
        deptno(PK) 참조키       deptno(FK) 외래키
        기본적으로 부모테이블의 PK는 자식테이블의 FK로 전이되어진다
        
    (3) 식별관계와 비식별관계
        ㄱ. 비식별관계(점선) : 부모테이블의 PK가 자식테이블의 일반 컬럼으로 전이되는 것
        ㄴ. 식별관계(실선) : 부모테이블의 PK가 자식테이블의 PK로 전이되는 것
-------------------------------------------------------------------------------
3) 논리적 DB 모델링
    (1) 관계 스키마 생성( 매핑룰 )
    (2) 정규화(NF) 작업
    
    ㄱ. Mapping Rule
        - 개념적 DB 모델링에서 도출된 [개체 타입]과 [관계 타입]의 [테이블 정의]
                                                            "관계 스키마"
          즉, ERD를 이용해 관계 스키마를 생성하기 위해서 지키는 규칙을 "매핑룰"이라고 한다
        - [ 매핑룰의 5가지 규칙 ]
            1단계) 단순 엔티티   -> 테이블
            2단계) 속성         -> 컬럼
            3단계) 식별자       -> 기본키
            4단계) 관계         -> 테이블 O X
            
            ERD -> 매핑룰 -> 관계 스키마
                            관계형 모델

4 논리적 설계
4.1 매핑룰( 릴레이션 스키마 변환 규칙 )
    4.1.1 규칙1 : 모든 개체는 릴레이션(테이블)으로 변환한다
        [E] -> table
        AAA     column 변환
    4.1.2 규칙2 : 다대다(n:m) 관계는 릴레이션(테이블)으로 변환한다
        고객 n    <주문>    m 상품
                주문테이블 변환
    4.1.3 규칙3 : 일대다(1:n) 관계는 외래키로 표현한다
        부서(DEPT) 1      n 사원(EMP)
        deptno(PK)          deptno(FK)
    4.1.4 규칙4: 일대일(1:1) 관계를 외래키로 표현한다
        남자  <혼인>    여자
            혼인테이블 생성 : 남자FK, 여자FK
    4.1.5 규칙5: 다중 값 속성은 릴레이션으로 변환한다
        사원T
        A   부장  ((부하직원))
            사원-부하직원 테이블 생성
    4.1.6 기타 고려 사항
-------------------------------------------------------------------------------
eXERD 모델링 툴(도구)를 사용해서 ERD -> 매핑룰 -> [ 논리적 DB 모델링 ]
관계 스키마 생성하고 나면 많은 문제 발생
== 이상( Anomaly ) == INSERT(삽입이상), DELECT(삭제이상), UPDATE(수정이상)
이상 제거 => 정규화 작업
-- "함수적 종속성" : 속성들간에 관련성
예)
    사원번호(PK) 사원명 주소 직급 부서명
    부서번호(PK) 부서명 지역명
      X        Y
    고객ID    고객명     등급    
    PK                           
    Y는 X에 종속성이 있다
      X   ->    Y
    결정자     종속자
     PK
    
    (1) 완전 함수적 종속
        여러개의 속성이 모여서 하나의 기본키를 이룰 때( 복합키 )
        복합키 전체에 어떤 속성이 종속적일 때 "완전 함수적 종속"이라고 한다
             복합키        완전 함수적 종속   부분 함수적 종속      부분 함수적 종속
        [고객ID][이벤트ID]     당첨여부            등급                고객명
         kenik    E001          Y                vip                홍길동
        
    (2) 부분 함수적 종속
        완전 함수적 종속이 아니면 부분 함수적 종속이다
        여러개의 속성이 모여서 하나의 기본키를 이룰 때( 복합키 )
        복합키 전체에 어떤 속성이 종속적이지 않을 때 "부분 함수적 종속"이라고 한다
        
    (3) 이행 함수적 종속
        X   ->    Y     ->    Z     일 때 X -> Z 관계
        ID      고객명
        PK
--------------------------------------------------------------------------------
-- 정규화
3 기본 정규형과 정규화 과정
3.1 정규화의 개념과 종류
3.2 제1정규형
    릴레이션(테이블)에 속한 모든 속성(컬럼)의 도메인이 원자 값(atomic value)으로만 구성되어 있으면 제1정규형에 속한다
    예)
    [ 고객 + 이벤트 당첨 테이블 ]
    고객ID / 이벤트ID / 당첨여부 / 등급
    apple     E001       Y      gold
    apple     E002       N      gold
    apple     E003       N      gold
    apple     E004       Y      gold
    
    고객ID, 등급 속성에서 반복되는 속성값을 제거하는 작업 -> 제1정규화한다
    [ 고객 테이블 ]
    apple 홍길동 gold
    [ 등급 ]
    1 gold
    2 vip
    3 vvip
    
3.3 제2정규형
    릴레이션이 제1정규형에 속하고, 기본키가 아닌 모든 속성이 기본키에 완전 함수 종속되면 제2정규형에 속한다.
    부분 함수적 종속을 제거하는 작업
    복합키일 때
    
3.4 제3정규형
    릴레이션이 제2정규형에 속하고, 기본키가 아닌 모든 속성이 기본키에 이행적 함수 종속이 되지 않으면 제3정규형에 속한다.
    이행 함수적 종속 제거
    결정자 종속자
     PK
      X  -> Y
    Y속성은 X속성에 종석적이다
    예)
    [ 사원테이블 ]
    empno(PK), ename, deptno, hiredate, dname
      X  ->  Y      Y  ->  Z
    empno  deptno deptno dname
    
    [ 사원 테이블 ]
    empno(PK), ename, deptno(XXX), hiredate
    [ 부서 테이블 ]
    deptno(PK), dname
    
3.5 보이스/코드 정규형
    [ Boyce/Codd Normal Form ] == BCNF
    릴레이션의 함수 종속 관계에서 모든 결정자가 후보키이면 보이스/코드 정규형에 속한다.
    
    [ 강좌신청테이블 ]
    [고객ID] + [인터넷강좌] 담당강사번호
     apple      영어회화      P001
     banana     기초토익      P002
     apple      기초토익      PXXX
     
     (1)
    복합키( 고객ID+인터넷강좌 ) -> 담당강사번호
         [   A       B     ]        C
    담당강사번호 -> 인터넷강좌
        C      ->    B
    [ A, C ] 고객ID, 담당강사번호
    [ C -> B ] 담당강사번호(PK) -> 인터넷강좌
     
    
3.6 제4정규형과 제5정규형
-------------------------------------------------------------------------------
4) 물리적 DB 모델링
    - 논리적 DB 모델링 단계에서 얻어진 데이터베이스스키마(관계스키마, 테이블스키마)를 더 효율적으로 구현하기 위한 작업
    예) 우편번호/주소 테이블 -> 효율성 -> 회원테이블
    - DBMS(오라클)의 특성에 맞게 실제 데이터베이스 내의 개체들을 정의하는 단계
    - (중요한점) : 데이터 사용량 분석, 업무 프로세스를 분석해서 성능, 효율 향상
    - 역정규화, 인덱스
-------------------------------------------------------------------------------
[ 특수한 경우의 엔티티 모델링 ]
1) 슈퍼타입 엔티티 / 서브타입 엔티티
    (1) 슈퍼타입 : 전체를 하나의 테이블로 관리하는 것
        
    (2) 서브타입 : 정규직사원, 비정규직사원, (서브 타입의 갯수만큼) 테이블을 설계하는 방법
2) 재귀적 관계
-------------------------------------------------------------------------------
CREATE TABLE tbl_admin -- 관리자
(
    adminseq NUMBER(4) PRIMARY KEY -- 관리자코드
    , adminid VARCHAR2(20) NOT NULL -- 관리자ID
    , adminpw VARCHAR2(20) NOT NULL -- 관리자명
    , adminname VARCHAR2(20) NOT NULL -- 비밀번호
    , admintel VARCHAR2(20) -- 휴대폰
    , adminaddr VARCHAR2(100) -- 주소
);

CREATE TABLE tbl_member -- 회원
(
    memberseq NUMBER(4) PRIMARY KEY -- 회원코드
    , memberid VARCHAR2(20) NOT NULL -- 회원ID
    , memberpw VARCHAR2(20) NOT NULL -- 비밀번호
    , membername VARCHAR2(20) NOT NULL -- 회원명
    , membertel VARCHAR2(20) -- 휴대폰
    , memberaddr VARCHAR2(100) -- 주소
);

CREATE TABLE tbl_poll -- 설문조사
(
    pollseq NUMBER(4) PRIMARY KEY -- 설문코드
    , writer NVARCHAR2(50) NOT NULL -- 작성자
    , question NVARCHAR2(256) NOT NULL -- 질문
    , sdate CHAR(8) NOT NULL -- 시작일
    , edate CHAR(8) NOT NULL -- 종료일
    , itemcnt NUMBER(1) NOT NULL -- 답변 항목수
    , polltotal NUMBER(4) NOT NULL -- 총 참여자수
    , regdate DATE DEFAULT SYSDATE -- 작성일
    , adminseq REFERENCES tbl_admin(adminseq) NOT NULL -- 관리자코드(외래키)
);

CREATE TABLE tbl_pollsub -- 답변항목
(
    pollsubseq NUMBER(38) PRIMARY KEY -- 답변항목코드
    , pollseq REFERENCES tbl_poll(pollseq) NOT NULL -- 답변항목
    , answer NVARCHAR2(100) -- 답변항목선택수 / 득표수
    , acnt NUMBER(4) NOT NULL -- 설문코드(외래키)
);

CREATE TABLE tbl_voter -- 투표자
(
    voterseq NUMBER PRIMARY KEY -- 투표자코드
    , pollseq REFERENCES tbl_poll(pollseq) NOT NULL -- 투표일
    , pollsubseq REFERENCES tbl_pollsub(pollsubseq) NOT NULL -- 닉네임
    , memberseq REFERENCES tbl_member(memberseq) NOT NULL -- 설문코드(외래키)
    , username NVARCHAR2(256) DEFAULT '익명' -- 답변항목코드(외래키)
    , regdate DATE DEFAULT SYSDATE -- 회원코드(외래키)
);


INSERT INTO tbl_admin( adminseq , adminid, adminpw, adminname, admintel, adminaddr) VALUES(1001,'admin1','1234','관리자1', '010-1212-3434', '서울특별시 마포구');
INSERT INTO tbl_admin( adminseq , adminid, adminpw, adminname, admintel, adminaddr) VALUES(1002,'admin2','2345','관리자2', '010-5656-7878', '경기도 용인시');

INSERT INTO tbl_member( memberseq , memberid, memberpw, membername, membertel, memberaddr) VALUES(2001,'member1','1234','일길동', '010-1234-1234', '서울특별시 강남구');
INSERT INTO tbl_member( memberseq , memberid, memberpw, membername, membertel, memberaddr) VALUES(2002,'member2','2345','이길동', '010-2345-2345', '경기도 수원시');
INSERT INTO tbl_member( memberseq , memberid, memberpw, membername, membertel, memberaddr) VALUES(2003,'member3','3456','삼길동', null, null);
INSERT INTO tbl_member( memberseq , memberid, memberpw, membername, membertel, memberaddr) VALUES(2004,'member4','4567','사길동', null, null);
INSERT INTO tbl_member( memberseq , memberid, memberpw, membername, membertel, memberaddr) VALUES(2005,'member5','5678','오길동', null, null);

-- 설문 1
INSERT INTO tbl_poll( pollseq, writer, question, sdate, edate, itemcnt, polltotal, adminseq ) 
    VALUES( 3001, '관리자', '가장 좋아하는 여자 연예인은?', '20230301', '20230331', 5, 0, 1001 );   
-- 설문 1 항목
INSERT INTO tbl_pollsub(pollsubseq , pollseq  , answer  , acnt) 
    VALUES( 5001, 3001, '배슬기',  0);
INSERT INTO tbl_pollsub(pollsubseq , pollseq  , answer  , acnt) 
    VALUES( 5002, 3001, '김옥빈',  0 );
INSERT INTO tbl_pollsub(pollsubseq , pollseq  , answer  , acnt) 
    VALUES( 5003, 3001, '아이비',  0);
INSERT INTO tbl_pollsub(pollsubseq , pollseq  , answer  , acnt) 
    VALUES( 5004, 3001, '한효주', 0 );
INSERT INTO tbl_pollsub(pollsubseq , pollseq  , answer  , acnt) 
    VALUES( 5005, 3001, '김태희', 0 );
-- 설문 1 투표
INSERT INTO tbl_voter(voterseq  , pollseq, pollsubseq  , memberseq, username)
    VALUES( 6001, 3001, 5001, 2001, '일길동' );
INSERT INTO tbl_voter(voterseq  , pollseq, pollsubseq  , memberseq)
    VALUES( 6002, 3001, 5004, 2002 );
INSERT INTO tbl_voter(voterseq  , pollseq, pollsubseq  , memberseq, username)
    VALUES( 6003, 3001, 5004, 2003, '삼식이' );
INSERT INTO tbl_voter(voterseq  , pollseq, pollsubseq  , memberseq)
    VALUES( 6004, 3001, 5004, 2004 );
INSERT INTO tbl_voter(voterseq  , pollseq, pollsubseq  , memberseq, username)
    VALUES( 6005, 3001, 5005, 2005, '오길동' );
    
-- 설문 2   
INSERT INTO tbl_poll( pollseq, writer, question, sdate, edate, itemcnt, polltotal, adminseq ) 
    VALUES( 3002, '관리자', '가장 좋아하는 남자 연예인은?', '20230201', '20230228', 5, 0, 1001 );    
-- 설문 2 항목
INSERT INTO tbl_pollsub(pollsubseq , pollseq  , answer  , acnt) 
    VALUES( 5006, 3002, '장동건', 0);
INSERT INTO tbl_pollsub(pollsubseq , pollseq  , answer  , acnt) 
    VALUES( 5007, 3002, '김수로', 0);
INSERT INTO tbl_pollsub(pollsubseq , pollseq  , answer  , acnt) 
    VALUES( 5008, 3002, '이종혁', 0);
INSERT INTO tbl_pollsub(pollsubseq , pollseq  , answer  , acnt) 
    VALUES( 5009, 3002, '김우빈', 0);
INSERT INTO tbl_pollsub(pollsubseq , pollseq  , answer  , acnt) 
    VALUES( 5010, 3002, '이종현', 0);
-- 설문 2 투표
INSERT INTO tbl_voter(voterseq  , pollseq, pollsubseq  , memberseq, username)
    VALUES( 6006, 3002, 5007, 2001, '일길동' );
INSERT INTO tbl_voter(voterseq  , pollseq, pollsubseq  , memberseq)
    VALUES( 6007, 3002, 5008, 2002 );
INSERT INTO tbl_voter(voterseq  , pollseq, pollsubseq  , memberseq, username)
    VALUES( 6008, 3002, 5009, 2003, '삼식이' );
INSERT INTO tbl_voter(voterseq  , pollseq, pollsubseq  , memberseq)
    VALUES( 6009, 3002, 5009, 2004 );

-- 설문 3
INSERT INTO tbl_poll( pollseq, writer, question, sdate, edate, itemcnt, polltotal, adminseq ) 
    VALUES( 3003, '관리자', '강아지 vs 고양이', '20230401', '20230430', 2, 0, 1002 );
-- 설문 3 항목
INSERT INTO tbl_pollsub(pollsubseq , pollseq  , answer  , acnt) 
    VALUES( 5011, 3003, '강아지', 0);
INSERT INTO tbl_pollsub(pollsubseq , pollseq  , answer  , acnt) 
    VALUES( 5012, 3003, '고양이', 0);
-- 설문 3 투표

ROLLBACK;    
COMMIT;

-- 설문 조회수 업데이트(수정)
UPDATE tbl_poll a
SET polltotal = ( SELECT COUNT(*) FROM tbl_voter WHERE pollseq = a.pollseq );
-- 설문 투표수 업데이트(수정)
UPDATE tbl_pollsub a
SET acnt = ( SELECT COUNT(*) FROM tbl_voter WHERE pollsubseq = a.pollsubseq );

SELECT * FROM tbl_admin;
SELECT * FROM tbl_member;
SELECT * FROM tbl_poll;
SELECT * FROM tbl_pollsub;
SELECT * FROM tbl_voter;

-- 설문목록
SELECT pollseq - 3000 번호, question 질문, writer 작성자, sdate 시작일, edate 종료일, itemcnt 항목수, regdate 작성일, polltotal 참여자수,
    CASE 
        WHEN TO_CHAR(SYSDATE,'YYYYMMDD') BETWEEN sdate AND edate THEN '진행중'
        WHEN sdate > TO_CHAR(SYSDATE,'YYYYMMDD') THEN '진행예정'
        ELSE '종료'
    END 상태
FROM tbl_poll t;
-- 설문보기1(정보)
SELECT pollseq - 3000 번호, question 질문, writer 작성자, TO_CHAR(SYSDATE,'YYYY-MM-DD AM HH:MI:SS') 작성일
     , TO_DATE(sdate,'YYYYMMDD') 시작일, TO_DATE(edate,'YYYYMMDD') 종료일
     , CASE 
        WHEN TO_CHAR(SYSDATE,'YYYYMMDD') BETWEEN sdate AND edate THEN '진행중'
        WHEN sdate > TO_CHAR(SYSDATE,'YYYYMMDD') THEN '진행예정'
        ELSE '종료'
       END 상태, itemcnt 항목수, polltotal 총참여자수
FROM tbl_poll
WHERE pollseq = 3001;
-- 설문보기2(항목)
SELECT a.pollseq - 3000 게시글번호, answer 항목
    ,(SELECT COUNT(*) FROM tbl_voter WHERE pollsubseq=b.pollsubseq) 항목선택
    ,LPAD(' ',(SELECT COUNT(*) FROM tbl_voter WHERE pollsubseq=b.pollsubseq)+1,'#') 막대그래프
FROM tbl_poll a RIGHT JOIN tbl_pollsub b ON a.pollseq=b.pollseq
WHERE a.pollseq = 3001
ORDER BY a.pollseq, pollsubseq;

--
DELETE FROM tbl_voter
WHERE pollseq = 3001;
DELETE FROM tbl_pollsub
WHERE pollseq = 3001;
DELETE FROM tbl_poll
WHERE pollseq = 3001;
--
DELETE FROM tbl_member
WHERE pollseq = 3001;
DELETE FROM tbl_admin
WHERE pollseq = 3001;

DROP TABLE tbl_voter PURGE;
DROP TABLE tbl_pollsub PURGE;
DROP TABLE tbl_poll PURGE;
DROP TABLE tbl_member PURGE;
DROP TABLE tbl_admin PURGE;



















