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
-------------------------------------------------------------------------------
1. 요구분석서(명세서) 작성
    1) 설문 작성(등록)하는 사람은 관리자만이 할 수 있다
    2) 로그인 한 고객(회원)만이 설문을 참여할 수 있다
    3) 관리자 - 설문 등록, 수정, 삭제
    4) 회원 - 설문 목록, 설문 보기, 설문 참여(투표), 투표 수정, 취소
    5) 설문을 작성할 때는
        ㄱ. 질문
        ㄴ. 설문 시작일 : 년, 월, 일
        ㄷ. 설문 종료일
        ㄹ. 항목의 개수를 선택하면
        ㅁ. 항목_
        설문 등록...
    6) 설문 목록 페이지
        ㄱ. 설문 번호
        ㄴ. 질문
        ㄷ. 작성자
        ㄹ. 시작일, 종료일
        ㅁ. 항목수
        ㅂ. 참여자수
        ㅅ. 상태( 진행중, 종료, 진행전(출력X) )
    7) 설문 보기 페이지 + 설문하기(투표하기)
        ㄱ. 총 참여자수
        ㄴ. 항목
        ㄷ. 내용
        ㄹ. 득표수
        ㅁ. %
2. 개념적 DB 모델링
    1) E : 관리자, 고객(회원)
    2) A
    3) I
    4) R
    5) 관계표현 관계 차수, 선택성(옵션)
    
3. 논리적 DB 모델링
    1) ERD     -> 매핑룰(5가지) -> 논리적 스키마
    개념적 스키마       변환        테이블 스키마, 관계 스키마
    2) 이상 현상( 삽입, 삭제, 수정 ) 제거
       함수 종속성( 속성 연관성 )   1NF
       ㄴ 완전 함수적 종속성     -> 2NF 복합키
       ㄴ 부분 함수적 종속성
       ㄴ 이행 함수적 종속성     -> 3NF
                                 BCNF
                                4NF, 5NF X
        -- 식별관계 : P(PK) - C(PK) 전이
        -- 비식별관계 : P(PK) - C(FK) 일반컬럼 전이
-------------------------------------------------------------------------------
/* 설문조사 */
CREATE TABLE SCOTT.T_POLL (
   PollSeq NUMBER(4) NOT NULL, /* 설문SEQ */
   Question Varchar(256) NOT NULL, /* 질문 */
   SDate DATE NOT NULL, /* 시작일 */
   EDAte DATE NOT NULL, /* 종료일 */
   ItemCount Number(1) DEFAULT 1 NOT NULL, /* 답변항목수 */
   PollTotal NUMBER(4), /* 총참여수 */
   RegDate Date DEFAULT sysdate NOT NULL, /* 작성일 */
   MemberSEQ NUMBER(4) /* 작성자(회원SEQ) */
);

COMMENT ON TABLE SCOTT.T_POLL IS '설문조사';

COMMENT ON COLUMN SCOTT.T_POLL.PollSeq IS '설문SEQ';

COMMENT ON COLUMN SCOTT.T_POLL.Question IS '질문';

COMMENT ON COLUMN SCOTT.T_POLL.SDate IS '시작일';

COMMENT ON COLUMN SCOTT.T_POLL.EDAte IS '종료일';

COMMENT ON COLUMN SCOTT.T_POLL.ItemCount IS '답변항목수';

COMMENT ON COLUMN SCOTT.T_POLL.PollTotal IS '총참여수';

COMMENT ON COLUMN SCOTT.T_POLL.RegDate IS '작성일';

COMMENT ON COLUMN SCOTT.T_POLL.MemberSEQ IS '작성자(회원SEQ)';

CREATE UNIQUE INDEX SCOTT.PK_T_POLL
   ON SCOTT.T_POLL (
      PollSeq ASC
   );

ALTER TABLE SCOTT.T_POLL
   ADD
      CONSTRAINT PK_T_POLL
      PRIMARY KEY (
         PollSeq
      );

/* 설문항목 */
CREATE TABLE SCOTT.T_PollSub (
   PollSubSeq NUMBER(38) NOT NULL, /* 답변항목SEQ */
   Answer Varchar2(100) NOT NULL, /* 답변항목 */
   ACount Number(4), /* 답변항목선택수 */
   PollSeq NUMBER(4) NOT NULL /* 설문SEQ */
);

COMMENT ON TABLE SCOTT.T_PollSub IS '설문항목';

COMMENT ON COLUMN SCOTT.T_PollSub.PollSubSeq IS '답변항목SEQ';

COMMENT ON COLUMN SCOTT.T_PollSub.Answer IS '답변항목';

COMMENT ON COLUMN SCOTT.T_PollSub.ACount IS '답변항목선택수';

COMMENT ON COLUMN SCOTT.T_PollSub.PollSeq IS '설문SEQ';

CREATE UNIQUE INDEX SCOTT.PK_T_PollSub
   ON SCOTT.T_PollSub (
      PollSubSeq ASC
   );

ALTER TABLE SCOTT.T_PollSub
   ADD
      CONSTRAINT PK_T_PollSub
      PRIMARY KEY (
         PollSubSeq
      );

/* 투표자 */
CREATE TABLE SCOTT.T_Voter (
   VectorSeq NUMBER NOT NULL, /* 투표SEQ */
   UserName VARCHAR2(20), /* 사용자이름 */
   RegDate DATE, /* 투표일 */
   PollSeq NUMBER(4), /* 설문SEQ */
   PollSubSeq NUMBER(38), /* 답변항목SEQ */
   MemberSeq NUMBER(4) /* 회원SEQ */
);

COMMENT ON TABLE SCOTT.T_Voter IS '투표자';

COMMENT ON COLUMN SCOTT.T_Voter.VectorSeq IS '투표SEQ';

COMMENT ON COLUMN SCOTT.T_Voter.UserName IS '사용자이름';

COMMENT ON COLUMN SCOTT.T_Voter.RegDate IS '투표일';

COMMENT ON COLUMN SCOTT.T_Voter.PollSeq IS '설문SEQ';

COMMENT ON COLUMN SCOTT.T_Voter.PollSubSeq IS '답변항목SEQ';

COMMENT ON COLUMN SCOTT.T_Voter.MemberSeq IS '회원SEQ';

CREATE UNIQUE INDEX SCOTT.PK_T_Voter
   ON SCOTT.T_Voter (
      VectorSeq ASC
   );

ALTER TABLE SCOTT.T_Voter
   ADD
      CONSTRAINT PK_T_Voter
      PRIMARY KEY (
         VectorSeq
      );

/* 회원 */
CREATE TABLE SCOTT.T_Member (
   MemberSeq NUMBER(4) NOT NULL, /* 회원SEQ */
   MemberID varchar2(20) NOT NULL, /* 회원아이디 */
   MemberPasswd varchar2(20), /* 비밀번호 */
   MemberName varchar2(20), /* 회원명 */
   MemberPhone varchar2(20), /* 휴대폰 */
   MemberAddress varchar2(100) /* 주소 */
);

COMMENT ON TABLE SCOTT.T_Member IS '회원';

COMMENT ON COLUMN SCOTT.T_Member.MemberSeq IS '회원SEQ';

COMMENT ON COLUMN SCOTT.T_Member.MemberID IS '회원아이디';

COMMENT ON COLUMN SCOTT.T_Member.MemberPasswd IS '비밀번호';

COMMENT ON COLUMN SCOTT.T_Member.MemberName IS '회원명';

COMMENT ON COLUMN SCOTT.T_Member.MemberPhone IS '휴대폰';

COMMENT ON COLUMN SCOTT.T_Member.MemberAddress IS '주소';

CREATE UNIQUE INDEX SCOTT.PK_T_Member
   ON SCOTT.T_Member (
      MemberSeq ASC
   );

ALTER TABLE SCOTT.T_Member
   ADD
      CONSTRAINT PK_T_Member
      PRIMARY KEY (
         MemberSeq
      );

ALTER TABLE SCOTT.T_POLL
   ADD
      CONSTRAINT FK_T_Member_TO_T_POLL
      FOREIGN KEY (
         MemberSEQ
      )
      REFERENCES SCOTT.T_Member (
         MemberSeq
      );

ALTER TABLE SCOTT.T_PollSub
   ADD
      CONSTRAINT FK_T_POLL_TO_T_PollSub
      FOREIGN KEY (
         PollSeq
      )
      REFERENCES SCOTT.T_POLL (
         PollSeq
      );

ALTER TABLE SCOTT.T_Voter
   ADD
      CONSTRAINT FK_T_POLL_TO_T_Voter
      FOREIGN KEY (
         PollSeq
      )
      REFERENCES SCOTT.T_POLL (
         PollSeq
      );

ALTER TABLE SCOTT.T_Voter
   ADD
      CONSTRAINT FK_T_PollSub_TO_T_Voter
      FOREIGN KEY (
         PollSubSeq
      )
      REFERENCES SCOTT.T_PollSub (
         PollSubSeq
      );

ALTER TABLE SCOTT.T_Voter
   ADD
      CONSTRAINT FK_T_Member_TO_T_Voter
      FOREIGN KEY (
         MemberSeq
      )
      REFERENCES SCOTT.T_Member (
         MemberSeq
      );
-------------------------------------------------------------------------------
1) 회원 가입/수정/탈퇴 쿼리
DESC T_MEMBER;
이름            널?       유형            
------------- -------- ------------- 
MEMBERSEQ     NOT NULL NUMBER(4)     
MEMBERID      NOT NULL VARCHAR2(20)  
MEMBERPASSWD           VARCHAR2(20)  
MEMBERNAME             VARCHAR2(20)  
MEMBERPHONE            VARCHAR2(20)  
MEMBERADDRESS          VARCHAR2(100) 

    ㄱ. T_MEMBER PK 확인
SELECT *
FROM user_constraints
WHERE table_name LIKE 'T_M%' AND constraint_type = 'P';

    ㄴ. 회원가입
    시퀀스(sequence) 자동으로 번호 발색시키는 객체 == 은행 (번호)
INSERT INTO T_MEMBER( MEMBERSEQ, MEMBERID, MEMBERPASSWD, MEMBERNAME, MEMBERPHONE, MEMBERADDRESS )
VALUES              ( 1        , 'admin' , '1234'      , '관리자'   , '010-1111-1111', '서울 강남구' );
INSERT INTO T_MEMBER( MEMBERSEQ, MEMBERID, MEMBERPASSWD, MEMBERNAME, MEMBERPHONE, MEMBERADDRESS )
VALUES              ( 2        , 'hong'  , '1234'      , '홍길동'   , '010-2222-2222', '서울 동작구' );
INSERT INTO T_MEMBER( MEMBERSEQ, MEMBERID, MEMBERPASSWD, MEMBERNAME, MEMBERPHONE, MEMBERADDRESS )
VALUES              ( 3        , 'kim'   , '1234'      , '김기수'   , '010-3333-3333', '결기도 남양주시' );

COMMIT;

    ㄷ. 회원 정보 조회
SELECT *
FROM t_member;

    ㄹ. 회원 정보 수정
    로그인 -> (홍길동) -> [내 정보] -> 내 정보 보기 -> [수정] -> [][][][][][][] -> [저장]
PL/SQL
UPDATE T_MEMBER
SET MEMBERNAME = , MEMBERPHONE = 
WHERE MEMBERSEQ = 2;

    ㅁ. 회원 탈퇴
DELETE FROM T_MEMBER
WHERE MEMBERSEQ = 2;
-------------------------------------------------------------------------------
2) 설문 작성
    ㄱ. 관리자로 로그인
    ㄴ. [설문 작성] 메뉴 선택
    ㄷ. 설문 작성 페이지로 이동
INSERT INTO T_POLL (PollSeq,Question,SDate, EDAte , ItemCount,PollTotal, RegDate, MemberSEQ )
VALUES             ( 1    ,'좋아하는 여배우?'
                          , TO_DATE( '2023-03-01 00:00:00'   ,'YYYY-MM-DD HH24:MI:SS')
                          , TO_DATE( '2023-03-15 18:00:00'   ,'YYYY-MM-DD HH24:MI:SS') 
                          , 5
                          , 0
                          , TO_DATE( '2023-02-15 00:00:00'   ,'YYYY-MM-DD HH24:MI:SS')
                          , 1
                    );

    ㄹ. 설문 항목
INSERT INTO T_PollSub (PollSubSeq          , Answer , ACount , PollSeq  ) 
VALUES                (1 ,'배슬기', 0, 1 );
INSERT INTO T_PollSub (PollSubSeq          , Answer , ACount , PollSeq  ) 
VALUES                (2 ,'김옥빈', 0, 1 );
INSERT INTO T_PollSub (PollSubSeq          , Answer , ACount , PollSeq  ) 
VALUES                (3 ,'아이유', 0, 1 );
INSERT INTO T_PollSub (PollSubSeq          , Answer , ACount , PollSeq  ) 
VALUES                (4 ,'김선아', 0, 1 );
INSERT INTO T_PollSub (PollSubSeq          , Answer , ACount , PollSeq  ) 
VALUES                (5 ,'임지연', 0, 1 );

   ㄷ. 설문 작성 페이지로 이동...
INSERT INTO T_POLL (PollSeq,Question,SDate, EDAte , ItemCount,PollTotal, RegDate, MemberSEQ )
VALUES               ( 2  ,'좋아하는 과목?'
                          , TO_DATE( '2023-03-20 00:00:00'   ,'YYYY-MM-DD HH24:MI:SS')
                          , TO_DATE( '2023-04-01 18:00:00'   ,'YYYY-MM-DD HH24:MI:SS') 
                          , 4
                          , 0
                          , TO_DATE( '2023-03-15 00:00:00'   ,'YYYY-MM-DD HH24:MI:SS')
                          , 1
                    );

    ㄹ. 설문 항목                   
INSERT INTO T_PollSub (PollSubSeq          , Answer , ACount , PollSeq  ) 
VALUES                (6 ,'자바', 0, 2 );
INSERT INTO T_PollSub (PollSubSeq          , Answer , ACount , PollSeq  ) 
VALUES                (7 ,'오라클', 0, 2 );
INSERT INTO T_PollSub (PollSubSeq          , Answer , ACount , PollSeq  ) 
VALUES                (8 ,'HTML5', 0, 2 );
INSERT INTO T_PollSub (PollSubSeq          , Answer , ACount , PollSeq  ) 
VALUES                (9 ,'JSP', 0, 2 );

COMMIT;
--
SELECT *
FROM t_poll;
--
SELECT *
FROM t_pollsub;
-------------------------------------------------------------------------------
3) 회원이 로그인했습니다
    설문 목록 페이지
    2번 설문 : 좋아하는 과목 "제목" 클릭
SELECT *
FROM t_member;
--> 3 kim 1234 김기수 (인증)
SELECT *
FROM (
SELECT pollseq 번호, question 질문, membername 작성자
     , sdate 시작일, edate 종료일, itemcount 항목수, polltotal 참여자수
     , CASE 
        WHEN TO_CHAR(SYSDATE,'YYYYMMDD') BETWEEN sdate AND edate THEN '진행 중'
        WHEN sdate > TO_CHAR(SYSDATE,'YYYYMMDD') THEN '시작 전'
        ELSE '종료'
       END 상태 -- 추출속성 -> 종료, 진행 중, 시작 전
FROM t_poll p JOIN t_member m ON m.memberseq = p.memberseq
ORDER BY 번호 DESC
) t
WHERE 상태 != '시작 전';
-------------------------------------------------------------------------------
4) 3(김기수) 로그인 상태 + 2번 설문 참여( 좋아하는 과목 ) [ 투표 페이지 ]
   업무 프로세스
   설문 목록 페이지에서 설문참여하기 위해서 2번 질문을 클릭
   [ 설문 보기 페이지 ]
   ㄱ. 2번 설문의 내용이 SELECT -> 출력
       ㄴ 설문 내용
          질문, 작성자, 작성일, 시작일, 종료일, 상태, 항목수 조회
SELECT question 질문, membername 작성자, TO_CHAR( regdate, 'YYYY-MM-DD hh:mi:ss' ) 작성일
     , TO_CHAR( sdate, 'YYYY-MM-DD' ) 시작일, TO_CHAR( edate, 'YYYY-MM-DD' ) 종료일
     , CASE 
        WHEN TO_CHAR(SYSDATE,'YYYYMMDD') BETWEEN sdate AND edate THEN '진행 중'
        WHEN sdate > TO_CHAR(SYSDATE,'YYYYMMDD') THEN '시작 전'
        ELSE '종료'
       END 상태, itemcount 항목수
FROM t_poll p JOIN t_member m ON p.memberseq = m.memberseq
WHERE pollseq = 2;
       ㄴ 설문 항목
SELECT answer
FROM t_pollsub
WHERE pollseq = 2;
   ㄴ. 총 참여자수 7명
        ㄴ 항목 [][][] 3
-- 2번 설문의 총참여자수
SELECT polltotal
FROM t_poll
WHERE pollseq = 2;
--
SELECT answer, acount
     , ( SELECT polltotal FROM t_poll WHERE pollseq = 2 ) totalcount
     --, 막대그래프
     , ROUND( acount / ( SELECT polltotal FROM t_poll WHERE pollseq = 2 ) * 100 ) || '%' 비율
FROM t_pollsub
WHERE pollseq = 2;
--------------------------------------------------------------------------------
5) [투표하기] 버튼 클릭
    - 2번 설문의 항목을 선택해야한다
    자바
    오라클(체크) --> 질문항목 PK 값인 7을 선택
    HTMS5
    JSP
SELECT *
FROM t_voter;
-- (1) t_voter
INSERT INTO t_voter( vectorseq, username, regdate, pollseq, pollsubseq, memberseq )
VALUES             ( 1        , '김기수' , SYSDATE, 2      , 7         , 3         );

COMMIT;

-- (1) -> (2)(3) 자동 진행 [트리거]
-- (2) t_poll, polltotal => 1 증가
UPDATE t_poll
SET polltotal = polltotal + 1
WHERE pollseq = 2;

-- (3) t_pollsub acount => 1 증가
UPDATE t_pollsub
SET acount = acount + 1
WHERE pollsubseq = 7;
-------------------------------------------------------------------------------
PL/SQL
    ㄴ Procedural Language extensions to SQL
    ㄴ 변수를 선언할 수 있는 기능, 제어문(흐름제어) 사용
    ㄴ 3개의 블록 구조로 된 언어
【형식】
   [ DECLARE ]
      -- 1) 선언문(declarations)
   BEGIN
      -- 2) 실행문(statements)
      /*
      DQL, DDL, DML, DCL, TCL
      insert
      select
      update
      */
   [ EXCEPTION ]
      -- 3) 예외 처리문(handlers)
   END; 
-- [ PL/SQL의 6가지 종류 ]
1) anonymous procedure 익명 프로시저
2) stored procedure 저장 프로시저 ***** 대표
3) stored function 저장 함수
4) package 패키지 DBMS_RANDOM
5) trigger 트리거

-- 예) 투표하기 INSERT
    (1) t_voter 투표자 insert
    (2) t_poll 설문   그 해당 질문의 총참여자수 1증가 update
    (3) t_pollsub 설문항목  그 해당 설문항목의 투표자수 1증가 update
    
-- 1) 익명 프로시저
DECLARE
    -- A블럭 : 변수 선언
BEGIN
    -- B블럭 : 실행하려는 여러개의 SQL문 작성
    -- (1) t_voter
    INSERT INTO t_voter( vectorseq, username, regdate, pollseq, pollsubseq, memberseq )
    VALUES             ( 2        , '관리자' , SYSDATE, 2      , 8         , 1         );
    
    -- (2) t_poll, polltotal => 1 증가
    UPDATE t_poll
    SET polltotal = polltotal + 1
    WHERE pollseq = 2;
    
    -- (3) t_pollsub acount => 1 증가
    UPDATE t_pollsub
    SET acount = acount + 1
    WHERE pollsubseq = 8;
    
    COMMIT;
-- EXCEPTION
    -- C블럭 : 예외 처리하는 블럭
    -- ROLLBACK;
END;
-- PL/SQL 프로시저가 성공적으로 완료되었습니다.

SELECT * FROM t_poll;
SELECT * FROM t_pollsub;
SELECT * FROM t_voter;

SELECT ename, sal
FROM emp
WHERE empno = 7369;
-- 예) PL/SQL 익명 프로시저 사용
DECLARE
    -- 변수 선언 블럭
    -- v 접두어 : [v]ariable 변수
    vempno  NUMBER(4) := 7369;
    vename  VARCHAR2(10);
    vsal    NUMBER(7,2);
BEGIN
    SELECT ename, sal INTO vename, vsal
    FROM emp
    WHERE empno = vempno;
    -- 출력 : DBMS_OUTPUT 패키지 함수 사용해서 출력
    DBMS_OUTPUT.PUT_LINE( vename || ' ' || vsal );
--EXCEPTION
END;
--------------------------------------------------------------------------------
[DECLARE]
    1 블럭 : 변수 선언
    vempno  NUMBER(4) := 7369;
    vename  VARCHAR2(10);
    vsal    NUMBER(7,2);
    in_stock BOOLEAN;
    -- RECORE, TABLE 데이터타입
BEGIN
    2 블럭 : SQL 작성
    PL/SQL 화면 출력 : DBMS_OUTPUT 패키지 사용
    SELECT ename, sal INTO vename, vsal
    FROM emp
    WHERE empno = vempno;
    
    INSERT INTO VALUES( vename, vsal );
[EXCEPTION]
    3 블럭 : 예외 처리
END;
익명 프로시저, 저장 프로시저, 저장 함수, 패키지, 트리거
-------------------------------------------------------------------------------
-- PL/SQL 문법 정리 : [ PL/SQL 변수의 종류 ]
    - 상수와 변수는 사용되기 전에 먼저 선언되어야 한다
    - 선언된 상수와 변수는 SQL 문에서 사용된다
    - 변수값을 지정하는 방법( 대입, 할당 )
        1) 대입연산자 :=
        2) select나 fetch에 의해서 변수값 지정
    - 상수의 선언은 변수선언 방법에 CONSTANT라는 예약어를 사용하면 된다
        예)
        변수명 CONSTANT 자료형 := 초기값;
        vpi CONSTANT NUMBER := 3.14;
    - 변수의 4가지 종류
        1) SCLAR 변수
        2) REFERENCE 변수
        3) COMPOSITE 변수
        4) BIND 변수
    - [ %TYPE 변수 ]
    【형식】 변수명 table명.column명%TYPE;
    만약 어떤 테이블의 특정 컬럼의 값을 변수에 지정해야 한다면,
    변수를 선언할 때 해당 테이블과 해당 컬럼의 데이터 타입과 크기를 그대로 참조하여 정의하여 사용할 수 있는데 이 타입을 TYPE 변수라 한다.

    이 타입에서는 테이블의 구조가 자주 변경되는 데이터베이스 환경에서 변경될 때마다 PL/SQL 블럭을 변경하지 않아도 되는 장점이 있다.
    -- 예) 사원번호 7369의 사원명, sal 출력하는 익명 프로시저 선언 + 실생
    DECLARE
        vempno emp.empno%TYPE := 7369;
        vename emp.ename%TYPE;
        vsal emp.sal%TYPE;
    BEGIN
    --EXCEPTION
    END;
    -- 예)
    DECLARE
        vname emp.ename%TYPE;
        vage NUMBER(3);
    BEGIN
        -- INTO : SELECT, FETCH 절에서 사용
        vname := '홍길동';
        vage := 20;
        
        DBMS_OUTPUT.PUT_LINE( vname || ' ' || vage );
    --EXCEPTION
    END;
    
    -- 문제) 30번 부서의 지역명을 얻어와서 10번 부서의 지역명으로 수정하는 익명 프로시저
    SELECT *
    FROM dept;
    DECLARE
        vloc dept.loc%TYPE;
    BEGIN     
        SELECT loc INTO vloc
        FROM dept
        WHERE deptno = 30;
        
        UPDATE dept
        SET loc = vloc
        WHERE deptno = 10;
        
        COMMIT;
    --EXCEPTION
        --ROLLBACK;
    END;

    -- 문제) 10번 부서원 중에 최고급여를 받는 사원의 정보를 출력하세요
        -- TOP-N 방식
         SELECT t.*
        FROM (
        SELECT *
        FROM emp
        WHERE deptno = 10
        ORDER BY sal DESC
        ) t
        WHERE ROWNUM = 1;
        -- RANK() 함수
        SELECT t.*
        FROM (
        SELECT emp.*
             , RANK() OVER( PARTITION BY deptno ORDER BY sal DESC ) 순위
        FROM emp
        WHERE deptno = 10
        ) t
        WHERE t.순위 = 1;
        -- 상관서브쿼리
        SELECT *
        FROM emp
        WHERE sal = ( SELECT MAX( sal ) max_sal FROM emp WHERE deptno = 10 ) AND deptno = 10;
    -- 익명 프로시저
    DECLARE
        vmax_sal_10 emp.sal%TYPE; -- 2450
        
        vrow emp%ROWTYPE; -- 행 전체 저장
    BEGIN
        SELECT MAX( sal ) INTO vmax_sal_10
        FROM emp
        WHERE deptno = 10;
        
        SELECT empno, ename, job, sal, hiredate, deptno
            INTO vrow.empno, vrow.ename, vrow.job, vrow.sal, vrow.hiredate, vrow.deptno
        FROM emp
        WHERE sal = vmax_sal_10 AND deptno = 10;
        
        DBMS_OUTPUT.PUT_LINE( vrow.empno );
        DBMS_OUTPUT.PUT_LINE( vrow.ename );
        DBMS_OUTPUT.PUT_LINE( vrow.job );
        DBMS_OUTPUT.PUT_LINE( vrow.sal );
        DBMS_OUTPUT.PUT_LINE( vrow.hiredate );
        DBMS_OUTPUT.PUT_LINE( vrow.deptno );
    --EXCEPTION
    END;
    
    -- 모든 사원의 empno, ename 정보를 조회
    -- ORA-01422: exact fetch returns more than requested number of rows
    -- 정확한 페치(가져오다)가 요청된 수보다 많은 행을 반환한다
    -- PL/SQL에서 여러개의 레코드를 가져와서 처리하기 위해서는 반드시 커서(cursor)를 사용해야 된다
    DECLARE
        vempno emp.empno%TYPE;
        vename emp.ename%TYPE;
    BEGIN
        SELECT empno, ename INTo vempno, vename
        FROM emp;
        -- WHERE empno = 7369;
        
        DBMS_OUTPUT.PUT_LINE( vempno || ' ' || vename );
    --EXCEPTION
    END;
    
-- PL/SQL 흐름제어(제어문)
1) IF...THEN...ELSE문
    IF (조건식) THEN
    END IF;
        
    IF (조건식) THEN
    ELSE
    END IF;
        
    IF (조건식) THEN
    ELSIF (조건식) THEN
    ELSE
    END IF;
        
    -- 문제) 변수를 하나 선언햇서 정수를 입력받아서 짝수, 홀수 출력
    DECLARE
        vnum NUMBER(3) := 0;
        vresult VARCHAR2(6) := '짝수';
    BEGIN
        vnum := :bindNumber;
        
        IF ( MOD(vnum,2) = 1 ) THEN
            vresult := '홀수';
        END IF;
        
        DBMS_OUTPUT.PUT_LINE( vresult );
    --EXCEPTION
    END;
    
    -- 문제) 국어점수를 입력받아서 수/우/미/양/가 출력
    DECLARE
        vkor NUMBER(3) := 0;
        vgrade VARCHAR2(1 CHAR) := '수';
    BEGIN
        vkor := :bindKor;
        
        IF ( vkor BETWEEN 0 AND 100 ) THEN
            IF vkor >= 90 THEN
                vgrade := '수';
            ELSIF vkor >= 80 THEN
                vgrade := '우';
            ELSIF vkor >= 70 THEN
                vgrade := '미';
            ELSIF vkor >= 60 THEN
                vgrade := '양';
            ELSE
                vgrade := '가';
            END IF;
            DBMS_OUTPUT.PUT_LINE( vgrade );
        ELSE
            DBMS_OUTPUT.PUT_LINE('국어점수 0~100점');
        END IF;
    --EXCEPTION
    END;
    --
    DECLARE
        vkor NUMBER(3) := 0;
        vgrade VARCHAR2(1 CHAR) := '수';
    BEGIN
        vkor := :bindKor;
        
        CASE TRUNC( vkor/10 )
            WHEN 10 THEN vgrade := '수';
            WHEN 9 THEN vgrade := '수';
            WHEN 8 THEN vgrade := '우';
            WHEN 7 THEN vgrade := '미';
            WHEN 6 THEN vgrade := '양';
            ELSE
                vgrade := '가';
            END CASE;
            DBMS_OUTPUT.PUT_LINE( vgrade );
    --EXCEPTION
    END;
    
2) LOOP...END LOOP(단순 반복)문
    LOOP
        -- 반복 코딩
        EXIT WHEN 조건
    END LOOP;
    
    -- 문제) 1~10 합 출력
    DECLARE
        vi NUMBER := 1;
        vsum NUMBER := 0;
    BEGIN
        LOOP
            DBMS_OUTPUT.PUT( vi );
            IF vi != 10 THEN
                DBMS_OUTPUT.PUT( '+' );
            END IF;
            -- += 복합대입연산자 X
            vsum := vsum + vi;
            EXIT WHEN vi = 10;
            -- ++ 증감연산자 X
            vi := vi + 1;
        END LOOP;
        DBMS_OUTPUT.PUT_LINE( '=' || vsum );
    --EXCEPTION
    END;
    
3) WHILE...LOOP(제한적 반복)문
    WHILE (조건식)
    LOOP
        -- 반복적으로 처리할 코딩
    END LOOP;
    
    -- 문제) 1~10 합 출력
    DECLARE
        vi NUMBER;
        vsum NUMBER := 0;
    BEGIN
        vi := 1;
        WHILE ( vi <= 10 )
        LOOP
            DBMS_OUTPUT.PUT( vi );
            IF vi != 10 THEN
                DBMS_OUTPUT.PUT( '+' );
            END IF;
            -- += 복합대입연산자 X
            vsum := vsum + vi;
            -- ++ 증감연산자 X
            vi := vi + 1;
        END LOOP;
        DBMS_OUTPUT.PUT_LINE( '=' || vsum );
    --EXCEPTION
    END;
    
4) FOR...LOOP(제한적 반복)문
    FOR 카운트변수(i) IN [REVERSE] 시작값.. 끝값
    LOOP
        -- 반복적으로 처리할 코딩
    END LOOP;
    
    -- 문제) 1~10 합 출력
    DECLARE
        vi NUMBER;
        vsum NUMBER := 0;
    BEGIN
        FOR vi IN 1.. 10
        LOOP
            DBMS_OUTPUT.PUT( vi );
            IF vi != 10 THEN
                DBMS_OUTPUT.PUT( '+' );
            END IF;
            -- += 복합대입연산자 X
            vsum := vsum + vi;
        END LOOP;
        DBMS_OUTPUT.PUT_LINE( '=' || vsum );
    --EXCEPTION
    END;
    
5) GOTO문(순차적 흐름제어)
-------------------------------------------------------------------------------
DECLARE
    vrow NUMBER(1) := 1;
    vcolumn NUMBER(1) := 1;
    vresult NUMBER(2);
BEGIN
    LOOP
        LOOP
            DBMS_OUTPUT.PUT( vrow || '*' || vcolumn );
            vresult := vrow * vcolumn;
            IF vrow != 9 THEN
                DBMS_OUTPUT.PUT( '=' || vresult || '  ' );
            ELSE
                DBMS_OUTPUT.PUT_LINE( '=' || vresult || '  ' );
            END IF;
            EXIT WHEN vrow = 9;
            vrow := vrow + 1;
        END LOOP;
        EXIT WHEN vcolumn = 9;
        vrow := 1;
        vcolumn := vcolumn + 1;
    END LOOP;   
--EXCEPTION
END;

DECLARE
    a NUMBER := 2;
    b NUMBER := 1;
BEGIN
    LOOP
        LOOP
            DBMS_OUTPUT.PUT_LINE(a||'*'||b||'='||a*b||' ');
            b := b + 1; 
            EXIT WHEN b = 10; --b가 10일될때 까지 b를 1씩 더해가는데, 그걸 ab=ab의 양식으로 출력을 해주겠다.
        END LOOP; --b가 10이 되면 반복을 중단한다.
        a := a + 1; --a를 1씩 더해가겠다 단수증가를 해준다. 2단 끝나면 -> 3단, 3-> 4단, ..., 8단 -> 9단
        b := 1; --단수증가 될때 1부터 다시 곱해줘야 하기때문에 1로 설정 
        EXIT WHEN a = 10; -- a가 10이 될때까지 이 과정을 반복하겠다.
        DBMS_OUTPUT.PUT_LINE('-----구분선입니다-----'); --단수가 바뀔때마다 그냥 보기 편하게 구분선을 추가 해줬다.
    END LOOP;
--EXCEPTION
END;

DECLARE
    vdan NUMBER := 2;
    vi NUMBER ;
    vx NUMBER;
BEGIN
    LOOP
        DBMS_OUTPUT.PUT_LINE(vdan||'단');
        vi:=1;
        LOOP
        vx:=vdan*vi;
        DBMS_OUTPUT.PUT_LINE(vdan||'*'||vi||'='||vx);
        vi:=vi+1;
        EXIT WHEN vi>9;
        END LOOP;
    vdan:=vdan+1;
    EXIT WHEN vdan>9;
    END LOOP;
    DBMS_OUTPUT.PUT_LINE('구구단 종료');
--EXCEPTION
END;




























