-- SCOTT --
SELECT *
FROM dba_users;
ORA-00942: table or view does not exist
--
SELECT *
FROM all_users;
--
SELECT *
FROM user_users;
--
SELECT *
FROM all_tables;
--
SELECT *
FROM user_tables;
--
SELECT *
FROM user_sys_privs; -- 시스템 권한
--
SELECT *
FROM user_role_privs; -- 롤

-- SCOTT 계정 : Employee 테이블 조회 -> 존재 X
SELECT *
FROM user_tables;

 -- SELECT문에 사용되는 키워드
1. DISTINCT  출력할 컬럼이 중복될 때 중복되는 값 하나만 출력 
2. ALL  출력할 컬럼이 중복되더라도 중복되는 값 모두 출력(distinct 키워드를 사용하지 않으면 디폴트는 ALL임) 
3. AS  별칭으로 컬럼이름을 표기할 때 사용하며, 영문은 대문자로만 표기됨 

-- [문제] emp 테이블에 job 컬럼이 존재
--       사원들의 잡의 종류를 조회(파악)
SELECT DISTINCT job -- 중복 제거
FROM emp;

SELECT job
FROM emp;
SELECT ALL job
FROM emp;
-- 위 쿼리의 결과물에서 중복되는 잡은 제거를 하고 싶다
SELECT DISTINCT ename, job, sal -- 요소가 다 중복돼야 제거되기 때문에 요소가 하나일 때 주로 사용
FROM emp;

-- SQL 문장 작성법
 1) SQL 문장은 대소문자를 구별하지 않는다.
 2) SQL 문장 끝에는 반드시 ;을 붙인다.
 3) 절은 라인을 구분해서 코딩
 4) keyword는 대문자로 입력하도록 권장한다
 5) 다른 모든 단어 즉, table 이름, column 이름은 소문자로 입력을 권장한다.

-- ||
 SELECT ename || ' has $' || sal
 FROM emp;
 
-- 잡, 사원번호, 이름, 입사일자
SELECT empno, ename, job, hiredate
FROM emp;

-- 1. 오라클에서 null 의미 : 미확인된 값
    이진우 몸무게 얼마예요? 요즘 몰라요
                         0, 없다 X
-- 2. 오라클에서 null 처리 : 0 숫자값으로 처리 (약속)
-- 자바 : if(comm==null) comm == 0;
-- 오라클 : null 처리하는 함수
1) NVL 함수는 NULL을 0 또는 다른 값으로 변환하기 위한 함수이다.
2) 컬럼 값이 NULL이면 어떠한 연산을 수행하더라도 결과값으로 NULL을 반환한다.
3) 【형식】
	NVL(expr1,expr2)
4) null 처리하는 함수 종류
- NVL : NULL 값을 원하는 데이터 타입으로 바꾸어 주는 함수 
- NVL2 : 값이 NULL인 경우와 NULL이 아닌경우에 리턴해 주는 값을 틀리게 해주는 함수 
- NULLIF : 두 개 값을 비교하여 NULL값 또는 사용되어진 두 개 값 중 하나를 리턴해 주는 함수 
- COALESCE : 인수중에서 NULL이 아닌 첫 번째 인수를 반환해 주는 함수 
--  EMPNO, ENAME, SAL, COMM, PAY
-- (  sal + comm = pay  )
--    800 + null = null
SELECT EMPNO, ENAME, SAL, COMM
      , NVL(comm, 0) comm2
      , sal + comm pay
      , sal + NVL(comm, 0) pay2
FROM emp;

-- NVL()와 NVL2() 함수의 차이점
-- NVL2(expr1, expr2, expr3)
-- expr1이 null이면 expr3
-- expr1이 null이 아니면 expr2
SELECT comm
        , NVL(comm, 0) comm
        , NVL2(comm, comm, 0) comm
FROM emp;

-- [문제] emp 테이블에서 mgr(직속상사의 사원번호) 컬럼이 null일 경우 처리 -> 0 출력
SELECT empno, ename, mgr
      , NVL(mgr, 0) mgr
FROM emp;

-- [문제] emp 테이블에서 mgr(직속상사의 사원번호) 컬럼이 null일 경우 처리 -> 'CEO' 출력
-- ORA-01722: invalid number
SELECT empno, ename, mgr
      -- , NVL(mgr, 'CEO') mgr
      -- mgr -> 문자열 변환 -> 'CEO'
      -- 숫자 -> 문자열 변환 방법(함수)
      , TO_CHAR(mgr)
      , NVL(TO_CHAR(mgr), 'CEO') mgr
      , NVL2(TO_CHAR(mgr), TO_CHAR(mgr), 'CEO') mgr
FROM emp;
-- 오른쪽 정렬 : 숫자, 왼쪽 정렬 : 문자

-- emp 구조
DESC emp;
-- MGR  NUMBER(4)  4자리 숫자(정수)

-- emp 테이블에서  아래와 같은 조회 결과가 나오도록 쿼리를 작성하세요.
SELECT empno, ename, sal
	, NVL(comm, 0) comm
    , NVL(sal + comm, sal) pay
	, sal + NVL(comm, 0) pay
FROM emp;
-------------------------------------------------------------------------------
DDL : CREATE문
CREATE USER
CREATE ROLE
CREATE TABLESPACE
CREATE TABLE insa(
        num NUMBER(5) NOT NULL CONSTRAINT insa_pk PRIMARY KEY -- 중복이 되지 않는 고유키
       ,name VARCHAR2(20) NOT NULL
       ,ssn  VARCHAR2(14) NOT NULL
       ,ibsaDate DATE     NOT NULL
       ,city  VARCHAR2(10)
       ,tel   VARCHAR2(15)
       ,buseo VARCHAR2(15) NOT NULL
       ,jikwi VARCHAR2(15) NOT NULL
       ,basicPay NUMBER(10) NOT NULL
       ,sudang NUMBER(10) NOT NULL
);

-- DML : INSERT, UPDATE, DELETE     TURNCATE        + COMMIT, ROLLBACK
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1001, '홍길동', '771212-1022432', '1998-10-11', '서울', '011-2356-4528', '기획부', 
   '부장', 2610000, 200000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1002, '이순신', '801007-1544236', '2000-11-29', '경기', '010-4758-6532', '총무부', 
   '사원', 1320000, 200000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1003, '이순애', '770922-2312547', '1999-02-25', '인천', '010-4231-1236', '개발부', 
   '부장', 2550000, 160000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1004, '김정훈', '790304-1788896', '2000-10-01', '전북', '019-5236-4221', '영업부', 
   '대리', 1954200, 170000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1005, '한석봉', '811112-1566789', '2004-08-13', '서울', '018-5211-3542', '총무부', 
   '사원', 1420000, 160000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1006, '이기자', '780505-2978541', '2002-02-11', '인천', '010-3214-5357', '개발부', 
   '과장', 2265000, 150000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1007, '장인철', '780506-1625148', '1998-03-16', '제주', '011-2345-2525', '개발부', 
   '대리', 1250000, 150000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1008, '김영년', '821011-2362514', '2002-04-30', '서울', '016-2222-4444', '홍보부',    
'사원', 950000 , 145000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1009, '나윤균', '810810-1552147', '2003-10-10', '경기', '019-1111-2222', '인사부', 
   '사원', 840000 , 220400);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1010, '김종서', '751010-1122233', '1997-08-08', '부산', '011-3214-5555', '영업부', 
   '부장', 2540000, 130000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1011, '유관순', '801010-2987897', '2000-07-07', '서울', '010-8888-4422', '영업부', 
   '사원', 1020000, 140000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1012, '정한국', '760909-1333333', '1999-10-16', '강원', '018-2222-4242', '홍보부', 
   '사원', 880000 , 114000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1013, '조미숙', '790102-2777777', '1998-06-07', '경기', '019-6666-4444', '홍보부', 
   '대리', 1601000, 103000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1014, '황진이', '810707-2574812', '2002-02-15', '인천', '010-3214-5467', '개발부', 
   '사원', 1100000, 130000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1015, '이현숙', '800606-2954687', '1999-07-26', '경기', '016-2548-3365', '총무부', 
   '사원', 1050000, 104000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1016, '이상헌', '781010-1666678', '2001-11-29', '경기', '010-4526-1234', '개발부', 
   '과장', 2350000, 150000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1017, '엄용수', '820507-1452365', '2000-08-28', '인천', '010-3254-2542', '개발부', 
   '사원', 950000 , 210000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1018, '이성길', '801028-1849534', '2004-08-08', '전북', '018-1333-3333', '개발부', 
   '사원', 880000 , 123000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1019, '박문수', '780710-1985632', '1999-12-10', '서울', '017-4747-4848', '인사부', 
   '과장', 2300000, 165000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1020, '유영희', '800304-2741258', '2003-10-10', '전남', '011-9595-8585', '자재부', 
   '사원', 880000 , 140000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1021, '홍길남', '801010-1111111', '2001-09-07', '경기', '011-9999-7575', '개발부', 
   '사원', 875000 , 120000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1022, '이영숙', '800501-2312456', '2003-02-25', '전남', '017-5214-5282', '기획부', 
   '대리', 1960000, 180000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1023, '김인수', '731211-1214576', '1995-02-23', '서울', NULL           , '영업부', 
   '부장', 2500000, 170000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1024, '김말자', '830225-2633334', '1999-08-28', '서울', '011-5248-7789', '기획부', 
   '대리', 1900000, 170000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1025, '우재옥', '801103-1654442', '2000-10-01', '서울', '010-4563-2587', '영업부', 
   '사원', 1100000, 160000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1026, '김숙남', '810907-2015457', '2002-08-28', '경기', '010-2112-5225', '영업부', 
   '사원', 1050000, 150000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1027, '김영길', '801216-1898752', '2000-10-18', '서울', '019-8523-1478', '총무부', 
   '과장', 2340000, 170000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1028, '이남신', '810101-1010101', '2001-09-07', '제주', '016-1818-4848', '인사부', 
   '사원', 892000 , 110000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1029, '김말숙', '800301-2020202', '2000-09-08', '서울', '016-3535-3636', '총무부', 
   '사원', 920000 , 124000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1030, '정정해', '790210-2101010', '1999-10-17', '부산', '019-6564-6752', '총무부', 
   '과장', 2304000, 124000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1031, '지재환', '771115-1687988', '2001-01-21', '서울', '019-5552-7511', '기획부', 
   '부장', 2450000, 160000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1032, '심심해', '810206-2222222', '2000-05-05', '전북', '016-8888-7474', '자재부', 
   '사원', 880000 , 108000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1033, '김미나', '780505-2999999', '1998-06-07', '서울', '011-2444-4444', '영업부', 
   '사원', 1020000, 104000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1034, '이정석', '820505-1325468', '2005-09-26', '경기', '011-3697-7412', '기획부', 
   '사원', 1100000, 160000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1035, '정영희', '831010-2153252', '2002-05-16', '인천', NULL           , '개발부', 
   '사원', 1050000, 140000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1036, '이재영', '701126-2852147', '2003-08-10', '서울', '011-9999-9999', '자재부', 
   '사원', 960400 , 190000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1037, '최석규', '770129-1456987', '1998-10-15', '인천', '011-7777-7777', '홍보부', 
   '과장', 2350000, 187000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1038, '손인수', '791009-2321456', '1999-11-15', '부산', '010-6542-7412', '영업부', 
   '대리', 2000000, 150000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1039, '고순정', '800504-2000032', '2003-12-28', '경기', '010-2587-7895', '영업부', 
   '대리', 2010000, 160000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1040, '박세열', '790509-1635214', '2000-09-10', '경북', '016-4444-7777', '인사부', 
   '대리', 2100000, 130000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1041, '문길수', '721217-1951357', '2001-12-10', '충남', '016-4444-5555', '자재부', 
   '과장', 2300000, 150000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1042, '채정희', '810709-2000054', '2003-10-17', '경기', '011-5125-5511', '개발부', 
   '사원', 1020000, 200000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1043, '양미옥', '830504-2471523', '2003-09-24', '서울', '016-8548-6547', '영업부', 
   '사원', 1100000, 210000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1044, '지수환', '820305-1475286', '2004-01-21', '서울', '011-5555-7548', '영업부', 
   '사원', 1060000, 220000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1045, '홍원신', '690906-1985214', '2003-03-16', '전북', '011-7777-7777', '영업부', 
   '사원', 960000 , 152000);			
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1046, '허경운', '760105-1458752', '1999-05-04', '경남', '017-3333-3333', '총무부', 
   '부장', 2650000, 150000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1047, '산마루', '780505-1234567', '2001-07-15', '서울', '018-0505-0505', '영업부', 
   '대리', 2100000, 112000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1048, '이기상', '790604-1415141', '2001-06-07', '전남', NULL           , '개발부', 
   '대리', 2050000, 106000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1049, '이미성', '830908-2456548', '2000-04-07', '인천', '010-6654-8854', '개발부', 
   '사원', 1300000, 130000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1050, '이미인', '810403-2828287', '2003-06-07', '경기', '011-8585-5252', '홍보부', 
   '대리', 1950000, 103000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1051, '권영미', '790303-2155554', '2000-06-04', '서울', '011-5555-7548', '영업부', 
   '과장', 2260000, 104000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1052, '권옥경', '820406-2000456', '2000-10-10', '경기', '010-3644-5577', '기획부', 
   '사원', 1020000, 105000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1053, '김싱식', '800715-1313131', '1999-12-12', '전북', '011-7585-7474', '자재부', 
   '사원', 960000 , 108000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1054, '정상호', '810705-1212141', '1999-10-16', '강원', '016-1919-4242', '홍보부', 
   '사원', 980000 , 114000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1055, '정한나', '820506-2425153', '2004-06-07', '서울', '016-2424-4242', '영업부', 
   '사원', 1000000, 104000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1056, '전용재', '800605-1456987', '2004-08-13', '인천', '010-7549-8654', '영업부', 
   '대리', 1950000, 200000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1057, '이미경', '780406-2003214', '1998-02-11', '경기', '016-6542-7546', '자재부', 
   '부장', 2520000, 160000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1058, '김신제', '800709-1321456', '2003-08-08', '인천', '010-2415-5444', '기획부', 
   '대리', 1950000, 180000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1059, '임수봉', '810809-2121244', '2001-10-10', '서울', '011-4151-4154', '개발부', 
   '사원', 890000 , 102000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1060, '김신애', '810809-2111111', '2001-10-10', '서울', '011-4151-4444', '개발부', 
   '사원', 900000 , 102000);

COMMIT;
-------------------------------------------------------------------------------
SELECT *
FROM tabs;
--
SELECT *
FROM insa;
-------------------------------------------------------------------------------
-- [SELECT문의 조건절(WHERE)]
-- [문제] emp 테이블에서 모든 사원 정보 조회
-- [문제] emp 테이블에서 10번 부서원(deptno) 정보 조회
SELECT *
FROM emp
WHERE deptno = 10; -- 조건절 처리 과정
-- ORA-00936: missing expression
-- 자바 같다 ==, 다르다 !=
-- 오라클 같다 =, 다르다 != <> ^=

-- [문제] emp 테이블에서 10번 부서원을 제외한 사원 정보를 조회(출력)
SELECT *
FROM emp
WHERE deptno <> 10;
WHERE deptno != 10;
WHEWE deptno ^= 10;

-- [문제] emp 테이블에서 10번또는 20번 부서원 정보를 조회
-- 자바 if(deptno == 10 || deptno == 20)
-- 오라클 where 조건절
SELECT *
FROM emp
WHERE deptno = 10 OR deptno = 20;
WHERE deptno = 10 || deptno = 20;
-- ORA-00933: SQL command not properly ended
-- SQL 명령이 제대로 종료되지 않았다
-- 자바 논리연산자   &&  ||  !
-- 오라클 논리연산자 AND OR NOT

-- [문제] KING 사원 정보만 확인
SELECT *
FROM emp
WHERE ename = UPPER('king'); -- LOWER()
WHERE ename = 'KING';
WHERE ename = 'king'; -- 대소문자 구분 O

-- String name = "king";
-- name.toUpperCase();

-- [문제] insa 테이블에서 구조 확인
DESC insa;
CITY              VARCHAR2(10) 출생지역 컬럼

-- [문제] insa 테이블에서 사원명, 출생지역 조회
SELECT name, city
FROM insa
ORDER BY city; -- ASC
ORDER BY 2; -- 컬럼의 순번 2. city
ORDER BY city DESC;
-- 정렬       (오름차순 asc 정렬, 내림차순 desc 정렬)
-- 3 5 2 4 1   1 2 3 4 5        5 4 3 2 1

-- [문제] insa 테이블에서 사원명, 출생지역을 출력하고 출생지역이 강원인 사원 정보만 조회
SELECT name, city
FROM insa
WHERE city = '강원';

-- [문제] insa 테이블에서 출생지역이 수도권인 사원의 정보를 조회
-- 수도권 : 서울, 인천, 경기
SELECT name, city
FROM insa
-- WHERE [NOT] IN(list)
WHERE city IN('서울', '인천', '경기')
-- WHERE city = '서울' OR city = '경기' OR city = '인천'
ORDER BY city;

-- [문제] insa 테이블에서 출생지역이 수도권이 아닌 사원의 정보를 조회
-- 수도권 : 서울, 인천, 경기
SELECT name, city
FROM insa
WHERE city NOT IN('서울', '인천', '경기')
-- WHERE NOT(city = '서울' OR city = '경기' OR city = '인천')
-- WHERE city != '서울' AND city <> '경기' AND city ^= '인천'
ORDER BY city;

-- [문제] insa 테이블에서 부서명, 이름, 급여(월급) 출력
-- + 조건절 : 2000000 <= 급여 <= 2500000
-- 2차 정렬 (1차 : 부서 ASC, 2차 : 급여 DESC)
SELECT buseo, name, basicpay + sudang pay
FROM insa
-- ORA-00904: "PAY": invalid identifier
-- WHERE pay >= 2000000 AND pay <= 2500000 -- 처리 순서에 의해 pay 정의 전이라 사용 불가
WHERE basicpay + sudang >= 2000000 AND basicpay + sudang <= 2500000
ORDER BY buseo ASC , pay DESC;

-- 위의 코딩을 WITH절 사용해서 처리
WITH
    temp AS (
        SELECT buseo, name, basicpay + sudang pay
        FROM insa
    )
SELECT buseo, name, pay
FROM temp
WHERE pay >= 2000000 AND pay <= 2500000
ORDER BY buseo ASC, pay DESC;

-- 위의 쿼리를 인라인뷰(inline view)를 사용해서 처리
-- FROM절에 있는 서브쿼리를 인라인뷰라고 한다
-- SELECT temp.*
SELECT *
FROM (
    SELECT buseo, name, basicpay + sudang pay
    FROM insa
    ) temp -- 가능하면 짧게
WHERE pay >= 2000000 AND temp.pay <= 2500000
ORDER BY buseo ASC, pay DESC;

-- 위의 코딩을 SQL 연산자 between and 사용해서 수정
SELECT *
FROM (
    SELECT buseo, name, basicpay + sudang pay
    FROM insa
    ) temp -- 가능하면 짧게
-- WHERE pay >= 2000000 AND temp.pay <= 2500000
-- WHERE pay BETWEEN 2000000 AND 2500000

-- WHERE pay < 2000000 OR pay > 2500000
-- WHERE NOT(pay >= 2000000 AND temp.pay <= 2500000)
WHERE pay NOT BETWEEN 2000000 AND 2500000
ORDER BY buseo ASC, pay DESC;

-- [문제] emp 테이블에서 comm이 확인되지 않은 사원의 정보를 조회
--                     comm이 null인 사원의 정보 조회
SELECT *
FROM emp
-- WHERE NOT(comm IS NULL);
-- WHERE comm IS NOT NULL;
WHERE comm IS NULL;
-- WHERE comm = null -- 오류 X, 검색결과 X

-- [문제] emp 테이블에서 입사일자(hiredate)가 81년도인 사원의 정보를 조회
--                     80/12/17 -> 1980/12/17
--                     RR/MM/DD
--                     YY/MM/DD
-- RR 과 YY 차이점
SELECT *
FROM emp
WHERE hiredate BETWEEN '81/01/01' AND '81/12/31';
WHERE hiredate >= '81/01/01' AND hiredate <= '81/12/31';
-- HIREDATE          DATE  오라클 날짜형 타입
-- 1) 자바 '81/01/11' 날짜 컬럼에서 년도만 얻어올 수 있다면
-- 오라클 DATE 년도 방법 검색
SELECT ename, hiredate
      , TO_CHAR(hiredate, 'YEAR') a
      , TO_CHAR(hiredate, 'YY') b
      , TO_CHAR(hiredate, 'YYYY') c
      , TO_CHAR(hiredate, 'RR') d
FROM emp
WHERE TO_CHAR(hiredate, 'RR') = '81';

-- 2) 자바 '81/01/11' 앞의 년도 두자리 잘라오는 코딩 substring(0,2)
-- 오라클
SELECT ename, hiredate
    , SUBSTR(hiredate, 0, 2) h_year
    , SUBSTR(hiredate, 1, 2) h_year
    , SUBSTR(hiredate, 4, 2) h_month
    , SUBSTR(hiredate, 7) h_day
    , SUBSTR(hiredate, -2) h_day
FROM emp
WHERE SUBSTR(hiredate, 0, 2) = '81';

-- 3) LIKE
-- 4) REGEXP_LIKE


DESC emp;
DESC insa;

















