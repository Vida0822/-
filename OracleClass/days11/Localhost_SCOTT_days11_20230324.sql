-- SCOTT --
-------------------------------------------------------------------------------
1. 오라클 각 DataType 에 대해 상세히 설명하세요

문자 : char - 고정길이, 영어 1바이트, 한글 3바이트, 최대 2000바이트
      nchar - 고정길이, 영어와 한글 모두 2바이트, 최대 2000바이트
      varchar2 - 가변길이, 영어 1바이트, 한글 3바이트, 최대 4000바이트
      nvarchar2 - 가변길이, 영어와 한글 모두 2바이트, 최대 4000바이트
      varchar - varchar2의 시노님
      long - 가변길이, 최대 2GB
숫자 : number(p,s) - p : 전체 자리수, s : 소수점 자리수
      float - number로 처리
날짜 : date - 날짜 + 시간, 고정길이 7바이트
      timestamp - 날짜 + 시간, 소수점자리 초까지
이진데이터 : raw - 가공되지 않은, 2000바이트
           longraw - 가공되지 않은, 2GB
           bfile - 외부파일 형태
LOB( Large OBject ) - blob(이진), clob(char), nclob(nchar)

2.  emp 테이블에서 [년도별] [월별] 입사사원수 출력.( PIVOT() 함수 사용 )

SELECT *
FROM (
    SELECT EXTRACT( YEAR FROM hiredate ) hire_year, EXTRACT( MONTH FROM hiredate ) hire_month
    FROM emp
    )
PIVOT( COUNT( hire_month ) FOR hire_month IN (1,2,3,4,5,6,7,8,9,10,11,12) );
--
가로출력 -> 세로출력
1) 피봇 대상 쿼리
2) IN (목록)
3) FOR 피봇컬럼
4) 집계함수(컬럼)

    [실행결과]
    1982	1	0	0	0	0	0	0	0	0	0	0	0
    1980	0	0	0	0	0	0	0	0	0	0	0	1
    1981	0	2	0	1	1	1	0	0	2	0	1	2
    
2-2.   emp 테이블에서 각 JOB별 입사년도별 1월~ 12월 입사인원수 출력.  ( PIVOT() 함수 사용 ) 

SELECT *
FROM (
    SELECT JOB, EXTRACT( YEAR FROM hiredate ) hire_year, EXTRACT( MONTH FROM hiredate ) hire_month
    FROM emp
    )
PIVOT( COUNT( hire_month ) FOR hire_month IN (1,2,3,4,5,6,7,8,9,10,11,12) )
ORDER BY job;

    [실행결과]
    ANALYST		1981	0	0	0	0	0	0	0	0	0	0	0	1
    CLERK		1980	0	0	0	0	0	0	0	0	0	0	0	1
    CLERK		1981	0	0	0	0	0	0	0	0	0	0	0	1
    CLERK		1982	1	0	0	0	0	0	0	0	0	0	0	0
    MANAGER		1981	0	0	0	1	1	1	0	0	0	0	0	0
    PRESIDENT	1981	0	0	0	0	0	0	0	0	0	0	1	0
    SALESMAN	1981	0	2	0	0	0	0	0	0       
    
3. emp테이블에서 입사일자가 오래된 순으로 3명 출력 ( TOP 3 )

SELECT ROWNUM, t.*
FROM ( SELECT * FROM emp ORDER BY hiredate ASC ) t
WHERE ROWNUM <= 3;

-- ORA-00936: missing expression : * -> emp.*
SELECT t.*
FROM (
    SELECT RANK() OVER( ORDER BY hiredate ) seq, emp.*
    FROM emp
    ) t
WHERE seq <= 3;

    [실행결과]
    1	7369	SMITH	CLERK	    7902	80/12/17	800		    20
    2	7499	ALLEN	SALESMAN	7698	81/02/20	1600	300	30
    3	7521	WARD	SALESMAN	7698	81/02/22	1250	500	30    
    
4. SMS 인증번호  임의의  6자리 숫자 출력 ( dbms_random  패키지 사용 )

SELECT TRUNC( DBMS_RANDOM.VALUE(100000,1000000) ) sms
FROM dual;

-- ORACLE DBMS_RANDOM 패키지 - 오라클 객체( 함수, 프로시저, 트리거 등등 )
SELECT dbms_random.value
     , FLOOR( dbms_random.value(100000,1000000) )
     , dbms_random.string('L',5)
FROM dual
CONNECT BY LEVEL <= 6; -- CONNECT BY 조건절
-- ( 단순 암기 )
SELECT LEVEL
FROM dual
CONNECT BY LEVEL <= 31;
-- [2023년 3월 ] 1~31일 날짜 모두 출력
SELECT TRUNC( SYSDATE, 'MM' ) + LEVEL - 1
FROM dual
CONNECT BY LEVEL <= TO_CHAR( LAST_DAY( SYSDATE ), 'DD' );
-- [ 달력 그리기 ( 팀별로 소스 분석 ) ]
SELECT 
       NVL( MIN( DECODE( TO_CHAR( dates, 'D'), 1, TO_CHAR( dates, 'DD')) ), ' ')  일
     , NVL( MIN( DECODE( TO_CHAR( dates, 'D'), 2, TO_CHAR( dates, 'DD')) ), ' ')  월
     , NVL( MIN( DECODE( TO_CHAR( dates, 'D'), 3, TO_CHAR( dates, 'DD')) ), ' ')  화
     , NVL( MIN( DECODE( TO_CHAR( dates, 'D'), 4, TO_CHAR( dates, 'DD')) ), ' ')  수
     , NVL( MIN( DECODE( TO_CHAR( dates, 'D'), 5, TO_CHAR( dates, 'DD')) ), ' ')  목
     , NVL( MIN( DECODE( TO_CHAR( dates, 'D'), 6, TO_CHAR( dates, 'DD')) ), ' ')  금
     , NVL( MIN( DECODE( TO_CHAR( dates, 'D'), 7, TO_CHAR( dates, 'DD')) ), ' ')  토
FROM (
        SELECT TO_DATE(:yyyymm , 'YYYYMM') + LEVEL - 1  dates
        FROM dual
        CONNECT BY LEVEL <= EXTRACT ( DAY FROM LAST_DAY(TO_DATE(:yyyymm , 'YYYYMM') ) )
)  t 
GROUP BY CASE 
               -- IW 가 50주 넘으면서 "일요일"
             WHEN TO_CHAR(dates, 'MM') = 1 AND  TO_CHAR(dates, 'D') = '1' AND TO_CHAR( dates, 'IW') > '50' THEN 1
             WHEN TO_CHAR(dates, 'MM') = 1 AND TO_CHAR(dates, 'D') != '1' AND TO_CHAR( dates, 'IW') > '50' THEN 0  
             WHEN TO_CHAR( dates , 'D') = 1 THEN TO_CHAR( dates , 'IW') + 1
             ELSE TO_NUMBER( TO_CHAR( dates , 'IW') )
          END   
ORDER BY   
         CASE 
             WHEN TO_CHAR(dates, 'MM') = 1 AND  TO_CHAR(dates, 'D') = '1' AND TO_CHAR( dates, 'IW') > '50' THEN 1
             WHEN TO_CHAR(dates, 'MM') = 1 AND TO_CHAR(dates, 'D') != '1' AND TO_CHAR( dates, 'IW') > '50' THEN 0  
             WHEN TO_CHAR( dates , 'D') = 1 THEN TO_CHAR( dates , 'IW') + 1
             ELSE TO_NUMBER( TO_CHAR( dates , 'IW') )
            END      ;  

4-2. 임의의 대소문자 5글자 출력( dbms_random  패키지 사용 )

SELECT DBMS_RANDOM.STRING('A',5)
FROM dual;

5. 게시글을 저장하는 테이블 생성
   ㄱ.   테이블명 : tbl_board
   ㄴ.   컬럼                     자료형  크기    널허용여부    고유키
         글번호    seq            
         작성자    writer     
         비밀번호 passwd      
         글제목    title       
         글내용    content
         작성일    regdate   
    ㄷ.  글번호, 작성자, 비밀번호, 글 제목은 필수 입력 사항으로 지정
    ㄹ.  글번호가  기본키( PK )로 지정
    ㅁ.  작성일은 현재 시스템의 날짜로 자동 설정 ( DEFAULT 기본값 )
    
    CREATE TABLE tbl_board (
          seq       NUMBER          NOT NULL    PRIMARY KEY
        , writer    VARCHAR2(20)    NOT NULL
        , passwd    VARCHAR2(15)    NOT NULL
        , title     VARCHAR2(100)   NOT NULL
        , content   CLOB
        , regdate   DATE    DEFAULT SYSDATE
    );
    -- Table TBL_BOARD이(가) 생성되었습니다.
    
5-2. 조회수    read   컬럼을 추가 ( 기본값 0 으로  설정 ) 

    ALTER TABLE tbl_board
    ADD read NUMBER DEFAULT 0;
    -- Table TBL_BOARD이(가) 변경되었습니다.

5-3. 테이블 구조 확인 

    DESC tbl_board;

5-4. CRUD  ( insert, select, update, delete ) 
   ㄱ. 임의의 게시글 5개를 추가 insert
   INSERT INTO 스키마.테이블명 ( 컬렴명,,,) VALUES ( 값...);
   
   INSERT INTO tbl_board ( seq, writer, passwd, title, content, regdate, read )
                  VALUES ( 1, '홍길동', '123$', '첫 번째 게시글', '내용 무', SYSDATE, 0 );
   -- content, regdate, read 컬럼값을 주지 않았다 ( NULL, DEFAULT )
   -- SQL 오류: ORA-00947: not enough values
   INSERT INTO tbl_board ( seq, writer, passwd, title, content, regdate, read )
                  VALUES ( 2, '박현주', '123$', '두 번째 게시글' );
   -- ORA-00001: unique constraint (SCOTT.SYS_C007056) violated
   -- 유일성 제약조건에 위배된다 seq 1 -> 2
   INSERT INTO tbl_board ( seq, writer, passwd, title )
                  VALUES ( 2, '박현주', '123$', '두 번째 게시글' ); 
   -- seq, writer, passwd, title, content, regdate, read 컬럼 순으로 값을 주었다면 생략 가능하다
   INSERT INTO tbl_board VALUES ( 3, '이태규', '123$', '세 번째 게시글', '내용 무', SYSDATE, 0 );
   
   INSERT INTO tbl_board ( writer, seq, title, passwd, content )
                  VALUES ( '박현주', 4, '네 번째 게시글', '123$', '냉묵' ); 
                  
   INSERT INTO tbl_board ( seq, writer, passwd, title, content, regdate, read )
                  VALUES ( 5, '홍길동', '123$', '다섯 번째 게시글', null, null, null );
                  
   COMMIT;
    
   ㄴ. 게시글 조회 select
   SELECT  *
   FROM tbl_board
   ORDER BY seq DESC;
   
   ㄷ. 3번 게시글의 글 제목, 내용 수정 update
    3	이태규	123$	세 번째 게시글	내용 무	23/03/24	0
    
    UPDATE tbl_board
    SET title = title || ' - 수정', content = content || ' - 수정'
    WHERE seq = 3;
    -- 1 행 이(가) 업데이트되었습니다.
   
   ㄹ. 4번 게시글 삭제 delete
   DELETE FROM tbl_board
   WHERE seq = 4;
   
   [문제] 1번 게시글의 제목, 내용, 작성일 -> 5번 게시글의 제목, 내용, 작성일로 수정
   UPDATE tbl_board
   SET title = ( SELECT title FROM tbl_board WHERE seq = 1 )
     , content = ( SELECT content FROM tbl_board WHERE seq = 1 )
     , regdate = ( SELECT regdate FROM tbl_board WHERE seq = 1 )
   WHERE seq = 5;
   --
   UPDATE tbl_board
   SET ( title, content, regdate ) = ( SELECT title, content, regdate FROM tbl_board WHERE seq = 1 )
   WHERE seq = 5;
   --
   ROLLBACK;
   
5-5. tbl_board 테이블 삭제  
    [DDL]
    CREATE TABLE
    ALTER TABLE
    DROP TABLE tbl_board PURGE; -- 완전 삭제
-------------------------------------------------------------------------------
-- 어제 복습 --
【간단한형식】
    CREATE [GLOBAL TEMPORARY] TABLE [schema.] table
      ( 
        열이름  데이터타입 [DEFAULT 표현식] [제약조건] 
       [,열이름  데이터타입 [DEFAULT 표현식] [제약조건] ] 
       [,...]  
      ); 
-- ㄱ.
    SELECT *
    FROM tabs
    WHERE table_name LIKE '%MEMBER%';
    DROP TABLE
    ALTER TABLE
    CREATE TABLE tbl_member
    (
          id    VARCHAR2(10)    NOT NULL    PRIMARY KEY
        , name  VARCHAR2(20)    NOT NULL
        , age   NUMBER(3)
        , birth DATE
    );
    -- etc, tel 컬럼 빼고 테이블 생성
    -- Table TBL_MEMBER이(가) 생성되었습니다.
    
    A) tbl_member에 새로운 etc, tel 컬럼 추가
        만들어진 테이블에 2개의 컬럼을 추가한다는 의미 -> 테이블 수정
        1) ALTER TABLE ADD 컬럼 추가
            ㄱ. 새로운 2개의 컬럼을 추가하기 전에 INSERT문으로 레코드(행)을 추가했다면
                새로 추가되는 컬럼의 값은 NULL로 채워진다.
            ㄴ. 【형식】컬럼추가
                ALTER TABLE 테이블명
                ADD (컬럼명 datatype [DEFAULT 값]
                    [,컬럼명 datatype]...);
           
            예)
            ALTER TABLE tbl_member
            ADD (
                  tel   CHAR(13)
                , etc   VARCHAR2(1000)
                );
            -- Table TBL_MEMBER이(가) 변경되었습니다.
            DESC tbl_member;
            
            ㄷ. 한 개의 컬럼을 추가할 때는 ADD tel CHAR(13) 괄호를 생략할 수 있다.
            ㄹ. 추가된 컬럼은 테이블의 마지막에 추가된다. 위치 수정 불가
    
    B) etc 컬럼의 VARCHAR(1000) 크기를 1000 -> 500 바이트 변경        
        2) ALTER TABLE MODIFY 컬럼 수정
            ㄱ. 【형식】
                ALTER TABLE 테이블명
                MODIFY (컬럼명 datatype [DEFAULT 값]
                       [,컬럼명 datatype]...);
            ㄴ. 데이터의 type, size, default 값을 변경할 수 있다
            ㄷ. 변경 대상 컬럼에 데이터가 없거나 null 값만 존재할 경우에는 size를 줄일 수 있다. (가능)
            ㄹ. 데이터 타입의 변경은 CHAR와 VARCHAR2 상호간의 변경만 가능하다.
            ㅁ. 컬럼 크기의 변경은 저장된 데이터의 크기보다 같거나 클 경우에만 가능하다.
            ㅂ. NOT NULL 컬럼인 경우에는 size의 확대만 가능하다.
            ㅅ. 컬럼의 기본값 변경은 그 이후에 삽입되는 행부터 영향을 준다.
            ㅇ. 컬럼이름의 직접적인 변경은 불가능하다.
            ㅈ. 컬럼이름의 변경은 서브쿼리를 통한 테이블 생성시 alias를 이용하여 변경이 가능하다.
            ㅊ. alter table ... modify를 이용하여 constraint를 수정할 수 없다.
                        데이터 타입 변경 가능사항      SIZE 
            NULL 컬럼     문자 ↔ 숫자 ↔ 날짜    확대, 축소가능 
            NOT NULL 컬럼 CHAR ↔ VARCHAR2       확대만 가능 
            
            예)
            ALTER TABLE tbl_member
            MODIFY ( etc VARCHAR2(500) );
            -- Table TBL_MEMBER이(가) 변경되었습니다.
            DESC tbl_member;
    
    C) etc 컬럼명을 memo 컬럼명으로 수정(변경)
        ㄱ. 조회할 때 별칭(alias) 사용
            SELECT etc AS memo
            FROM tbl_member;
        ㄴ. 컬럼명 변경
            ALTER TABLE tbl_member
            RENAME COLUMN etc TO memo;
            -- Table TBL_MEMBER이(가) 변경되었습니다.
    
    D) memo 컬럼 삭제
        3) ALTER TABLE DROP 컬럼 삭제
            ㄱ. 【형식】
                ALTER TABLE 테이블명
                DROP COLUMN 컬럼명; 
            
            ㄴ. 컬럼을 삭제하면 해당 컬럼에 저장된 데이터도 함께 삭제된다.
            ㄷ. 한번에 하나의 컬럼만 삭제할 수 있다.
            ㄹ. 삭제 후 테이블에는 적어도 하나의 컬럼은 존재해야 한다.
            ㅁ. DDL문으로 삭제된 컬러은 복구할 수 없다.
            
            예)
            ALTER TABLE tbl_member
            DROP COLUMN memo;
            -- Table TBL_MEMBER이(가) 변경되었습니다.
            
    E) 테이블명 수정 (tbl_member -> tbl_members)
        RENAME tbl_member TO tbl_members;
        -- 테이블 이름이 변경되었습니다.
        
        4) ALTER TABLE DROP 제약조건 삭제
-------------------------------------------------------------------------------

6-1. 오늘의 날짜와 요일 출력 

SELECT SYSDATE "오늘날짜", TO_CHAR( SYSDATE, 'D' ) "숫자요일", TO_CHAR( SYSDATE, 'DY' ) "한자리요일", TO_CHAR( SYSDATE, 'DAY' ) "요일"
FROM dual;

 [실행결과]
오늘날짜  숫자요일  한자리요일       요일
-------- ---        ------   ------------
22/04/15  6             금      금요일      

6-2. 이번 달의 마지막 날과 날짜만 출력 

SELECT SYSDATE "오늘날짜", LAST_DAY( SYSDATE ) "이번달마지막날짜", EXTRACT( DAY FROM LAST_DAY( SYSDATE ) ) "마지막날짜(일)"
FROM dual;

 [실행결과]
오늘날짜  이번달마지막날짜                  마지막날짜(일)
-------- -------- -- ---------------------------------
22/04/15 22/04/30 30                                30

6-3.

SELECT SYSDATE "오늘날짜", TO_CHAR( SYSDATE, 'W' ) "월의주차", TO_CHAR( SYSDATE, 'WW' ) "년의주차", TO_CHAR( SYSDATE, 'IW' ) "년의 주차"
FROM dual;

 [실행결과]
오늘날짜    월의주차 년의주차 년의 주차
--------    -       --      -- 
23/03/24      4     12       12 
-------------------------------------------------------------------------------      
-- [ 테이블 생성 ]
1) 테이블 생성을 하는 가장 단순하면서 일반적인 명령형식으로 생성
    CREATE TABLE 테이블명
    (
        컬럼명     자료형(크기) [DEFAULT 값] [제약조건]
        , 컬럼명     자료형(크기) [DEFAULT 값] [제약조건]
                            :
    );

2) 서브쿼리(subquery)를 이용한 테이블 생성 방법
    ㄱ. 이미 존재하는 테이블이 있고
    ㄴ. SELECT~ 서브쿼리를 이용해서
    ㄷ. 새로운 테이블 생성
    ㄹ. + 기존 테이블의 데이터도 자동으로 추가된다
        하지만) 제약조건은 추가되지 않는다
    ㅁ. [형식]
        CREATE TABLE 테이블명 [컬럼명...]
        AS
            서브쿼리;
    
    예) deptno, dname, empno, hiredate, pay, grade 컬럼을 가진 테이블 생성
    emp : [deptno], empno, hiredate, pay
    salgrade : grade
    dept : [deptno], dname
    이미 emp, salgrade 존재 -> 테이블 생성 ( tbl_empgrade )
    
    CREATE TABLE tbl_empgrade
    AS
        (
        SELECT d.deptno, dname, empno, hiredate, sal+NVL(comm,0) pay, grade
        FROM emp e JOIN salgrade s ON e.sal BETWEEN s.losal AND s.hisal
                   JOIN dept d ON d.deptno = e.deptno
        );
    -- Table TBL_EMPGRADE이(가) 생성되었습니다.
    
    SELECT *
    FROM tbl_empgrade;
    -- 제약조건은 복사되지 않는다
    
    DESC tbl_empgrade;
    
이름     널? 유형           
-------- -- ------------ 
DEPTNO      NUMBER(2)    dept 동일
DNAME       VARCHAR2(14) dept 동일
EMPNO       NUMBER(4)    emp 동일
HIREDATE    DATE         emp 동일
PAY         NUMBER       sal+comm 가공해서 만든 컬럼 -> 시스템이 자동으로 자료형 부여
GRADE       NUMBER       salgrade 동일

    -- 만약에 기존의 테이블을 이용해서 새로운 테이블을 생성하고자 할 때
    -- 데이터는 필요없다
    -- emp 구조 그대로 tbl_emp_copy 테이블로 복사 생성
    CREATE TABLE tbl_emp_copy
    AS
        SELECT * FROM emp
        WHERE 1 = 0; -- 데이터 복사되지 않는다
        
    SELECT *
    FROM tbl_emp_copy;
-------------------------------------------------------------------------------
-- [ 서브쿼리를 사용하는 INSERT문 ]
SELECT *
FROM tbl_emp_copy;
-- tbl_enp_copy 테이블에 emp 중 30번 부서원들을 SELECT 해서 INSERT
-- INSERT INTO 스키마, 테이블명 [( 컬럼명...)] VALUES ( 컬럼값...);
-- INSERT INTO 스키마.테이블명 ( 서브쿼리 )

INSERT INTO tbl_emp_copy
(
SELECT *
FROM emp
WHERE deptno = 30
);
-- 6개 행 이(가) 삽입되었습니다.
COMMIT;
--
DROP TABLE tbl_emp_copy PURGE;
-- Table TBL_EMP_COPY이(가) 삭제되었습니다.

-- [ MULTITABLE INSERT 문 ]
-- 다중 INSERT문 : 1개 레코드 -> INSERT -> 여러개 테이블
1) unconditional insert all
    [ 조건이 없는 다중 INSERT문 ]
    ㄴ 조건과 상관없이 기술되어진 여러개의 테이블에 데이터를 입력한다
    ? 서브쿼리로부터 한번에 하나의 행을 반환받아 각각 insert 절을 수행한다.
    ? into 절과 values 절에 기술한 컬럼의 개수와 데이터 타입은 동일해야 한다.

【형식】
	INSERT ALL | FIRST
	  [INTO 테이블1 VALUES (컬럼1,컬럼2,...)]
	  [INTO 테이블2 VALUES (컬럼1,컬럼2,...)]
	  .......
	Subquery;
    
    -- 1) INSERT INTO 테이블명 ( 컬럼명,,,) VALUES ( 컬럼값...);
    -- 2) INSERT INTO 테이블명 ( 서브쿼리 );
    
    예)
    SELECT *
    FROM emp;
    
    SELECT * FROM tbl_emp10;
    SELECT * FROM tbl_emp20;
    SELECT * FROM tbl_emp30;
    SELECT * FROM tbl_emp40;
    
    -- 서브쿼리를 사용해서 테이블 4개 생성
    CREATE TABLE tbl_emp10  AS ( SELECT * FROM emp WHERE 1=0 );
    CREATE TABLE tbl_emp20  AS ( SELECT * FROM emp WHERE 1=0 );
    CREATE TABLE tbl_emp30  AS ( SELECT * FROM emp WHERE 1=0 );
    CREATE TABLE tbl_emp40  AS ( SELECT * FROM emp WHERE 1=0 );
    
    -- unconditional insert all 문
    INSERT ALL
        INTO tbl_emp10 VALUES ( empno, ename, job, mgr, hiredate, sal, comm, deptno )
        INTO tbl_emp20 VALUES ( empno, ename, job, mgr, hiredate, sal, comm, deptno )
        INTO tbl_emp30 VALUES ( empno, ename, job, mgr, hiredate, sal, comm, deptno )
        INTO tbl_emp40 VALUES ( empno, ename, job, mgr, hiredate, sal, comm, deptno )
    SELECT * FROM emp;
    
    ROLLBACK;
    
2) conditional insert all
    [ 조건이 있는 다중 INSERT문 ]
    INSERT ALL
        WHEN deptno = 10 THEN
            INTO tbl_emp10 VALUES ( empno, ename, job, mgr, hiredate, sal, comm, deptno )
        WHEN deptno = 20 THEN
            INTO tbl_emp20 VALUES ( empno, ename, job, mgr, hiredate, sal, comm, deptno )
        WHEN deptno = 30 THEN
            INTO tbl_emp30 VALUES ( empno, ename, job, mgr, hiredate, sal, comm, deptno )
        ELSE
            INTO tbl_emp40 VALUES ( empno, ename, job, mgr, hiredate, sal, comm, deptno )
    SELECT * FROM emp;    
    
    -- 데이터 삭제
    -- DELETE FROM tbl_emp10; COMMIT;
    
    -- 테이블 안의 모든 레코드를 삭제 + 자동 커밋/롤백
    TRUNCATE TABLE tbl_emp10;
    TRUNCATE TABLE tbl_emp20;
    TRUNCATE TABLE tbl_emp30;
    TRUNCATE TABLE tbl_emp40;
    
3) conditional first insert
    [ 조건이 있는 첫번째 INSERT문 ]
    【형식】
    INSERT FIRST
    WHEN 조건절1 THEN
      INTO [테이블1] VALUES (컬럼1,컬럼2,...)
    WHEN 조건절2 THEN
      INTO [테이블2] VALUES (컬럼1,컬럼2,...)
    ........
    ELSE
      INTO [테이블3] VALUES (컬럼1,컬럼2,...)
    Sub-Query;
    
    ? conditional INSERT FIRST는 조건절을 기술하여 조건에 맞는 값들을 원하는 테이블에 삽입할 수 있다.
    ? 여러 개의 WHEN...THEN절을 사용하여 여러 조건 사용이 가능하다. 단, 첫 번째 WHEN 절에서 조건을 만족한다면, INTO 절을 수행한 후 다음의 WHEN 절들은 더 이상 수행하지 않는다.
    ? subquery로부터 한 번에 하나씩 행을 리턴 받아 when...then절에서 조건을 체크한 후 조건에 맞는 절에 기술된 테이블에 insert를 수행한다.
    ? 조건을 기술한 when 절들을 만족하는 행이 없을 경우 else절을 사용하여 into 절을 수행할 수 있다. else절이 없을 경우 리턴 딘 그행에 대해서는 아무런 작업도 발생하지 않는다.
    
    SELECT *
    FROM emp
    WHERE deptno = 10 AND job = 'CLERK'; -- MILLER
    
     INSERT ALL
        WHEN deptno = 10 THEN
            INTO tbl_emp10 VALUES ( empno, ename, job, mgr, hiredate, sal, comm, deptno )
        WHEN job = 'CLERK' THEN
            INTO tbl_emp20 VALUES ( empno, ename, job, mgr, hiredate, sal, comm, deptno )
        ELSE
            INTO tbl_emp40 VALUES ( empno, ename, job, mgr, hiredate, sal, comm, deptno )
    SELECT * FROM emp;    
    
    SELECT * FROM tbl_emp10; -- FIRST : MILLER O / ALL : MILLER O
    SELECT * FROM tbl_emp20; -- FIRST : MILLER X / ALL : MILLER O
    SELECT * FROM tbl_emp30;
    SELECT * FROM tbl_emp40;

4) pivoting insert 
    [ 피봇 ]
create table tbl_sales(
    employee_id       number(6),
    week_id           number(2),
    sales_mon         number(8,2),
    sales_tue         number(8,2),
    sales_wed         number(8,2),
    sales_thu         number(8,2),
    sales_fri         number(8,2)
);
-- Table TBL_SALES이(가) 생성되었습니다.

insert into tbl_sales values(1101,4,100,150,80,60,120);
insert into tbl_sales values(1102,5,300,300,230,120,150);
COMMIT;
--
SELECT * FROM tbl_sales;
--
SELECT * FROM tbl_sales_data
ORDER BY employee_id;
--
create table tbl_sales_data(
    employee_id        number(6),
    week_id            number(2),
    sales              number(8,2)
);
-- Table TBL_SALES_DATA이(가) 생성되었습니다.

-- UC 다중 INSERT문
insert all
    into tbl_sales_data values(employee_id, week_id, sales_mon)
    into tbl_sales_data values(employee_id, week_id, sales_tue)
    into tbl_sales_data values(employee_id, week_id, sales_wed)
    into tbl_sales_data values(employee_id, week_id, sales_thu)
    into tbl_sales_data values(employee_id, week_id, sales_fri)
    
    select employee_id, week_id, sales_mon, sales_tue, sales_wed,
           sales_thu, sales_fri
    from tbl_sales;
COMMIT;
-------------------------------------------------------------------------------
[문제] insa 테이블에서 num, name 컬럼만을 복사해서 새로운 tbl_score 테이블 생성
    ( 조건 : num <= 1005 )
-- 기존 테이블을 사용해서 테이블 생성    
CREATE TABLE tbl_score
AS
    (
        SELECT num, name
        FROM insa
        WHERE num <= 1005
    );
-- Table TBL_SCORE이(가) 생성되었습니다.
SELECT *
FROM tbl_score;
    
[문제] tbl_score 테이블에 kor, eng, mat, tot, avg, grade, rank 컬럼 추가
kor, eng, mat, tot : NUMBER(3) DEFAULT 0
avg : NUMBER(5,2)
grade : CHAR(1 CHAR)
rank : NUMBER(3)
-- 기존 테이블에 컬럼 6개 추가 ( 테이블 수정(변경) )
ALTER TABLE ADD 제약조건, 컬럼 추가
ALTER TABLE MODIFY 자료형, 크기 등등 수정
ALTER TABLE DROP 제약조건, 컬럼 삭제

ALTER TABLE tbl_score
ADD (
      kor NUMBER(3) DEFAULT 0
    , eng NUMBER(3) DEFAULT 0
    , mat NUMBER(3) DEFAULT 0
    , tot NUMBER(3)
    , avg NUMBER(5,2)
    , grade CHAR(1 CHAR) -- A B C D F
    , rank NUMBER(3)
);
-- Table TBL_SCORE이(가) 변경되었습니다.
DESC tbl_score;

[문제] tbl_score 테이블에 num( 1001~1005 ) 5명의 kor, eng, mat 점수를 임의의 값( 0~100 ) 수정
UPDATE tbl_score
SET   kor = TRUNC( dbms_random.VALUE(0,101) )
    , eng = TRUNC( dbms_random.VALUE(0,101) )
    , mat = TRUNC( dbms_random.VALUE(0,101) );
-- SET (kor, eng, mat ) = ( SELECT TRUNC( dbms_random.VALUE(0,101) ), TRUNC( dbms_random.VALUE(0,101) ), TRUNC( dbms_random.VALUE(0,101) ) FROM dual )
COMMIT;

[문제] 모든 학생들의 tot, avg 수정
UPDATE tbl_score
SET   tot = kor + eng + mat
    , avg = ( kor + eng + mat ) / 3;
COMMIT;

[문제] avg 무조건 소수점 2자리까지 출력
SELECT num, name, kor, eng, mat, tot, TO_CHAR( avg, '999.00' ) avg, grade, rank
FROM tbl_score;

[문제] grade 평균 90 이상 A, 80 이상 B, 70 이상 C, 60 이상 D, 나머지 F 수정
UPDATE tbl_score
SET grade = CASE
                WHEN 90 <= avg THEN 'A'
                WHEN 80 <= avg THEN 'B'
                WHEN 70 <= avg THEN 'C'
                WHEN 60 <= avg THEN 'D'
                ELSE 'F'
            END;
ROLLBACK;
UPDATE tbl_score
SET grade = DECODE( TRUNC( avg/10 ), 10, 'A', 9, 'A', 8, 'B', 7, 'C', 6, 'D', 'F' );
COMMIT;
SELECT *
FROM tbl_score;

[문제] tbl_score 테이블에서 rank 등수 처리 수정
UPDATE tbl_score a
SET rank = ( SELECT COUNT(*)+1 FROM tbl_score WHERE tot > a.tot );

[문제] 모든 학생들의 국어 점수
UPDATE tbl_score
SET kor = CASE
            WHEN kor + 10 > 100 THEN 100
            ELSE kor + 10
           END;
-- 문제점) 한명의 모든 학생이 kor 점수가 변경이 되면 총점, 평균, 등급, 순위 자동 변경 (트리거)

[문제] tbl_score 테이블에서 여학생만 수학 점수를 3점 증가
( 조건 : insa 테이블에 ssn 조인해서 여학생만 골라내기 )

UPDATE tbl_score
SET mat = CASE
            WHEN mat + 3 > 100 THEN 100
            ELSE mat + 3
           END
WHERE num = ANY ( -- ANY     SQL 연산자를 사용해도 된다
            SELECT num
            FROM insa
            WHERE MOD( SUBSTR( ssn, -7, 1 ), 2 ) = 0 AND num <= 1005
            );
--
WHERE num IN (
            SELECT num
            FROM insa
            WHERE MOD( SUBSTR( ssn, -7, 1 ), 2 ) = 0 AND num <= 1005
            );

-- 1003 여학생
SELECT num
FROM insa
WHERE MOD( SUBSTR( ssn, -7, 1 ), 2 ) = 0 AND num <= 1005;












      
      
      
      
      
      
      
      
      
      