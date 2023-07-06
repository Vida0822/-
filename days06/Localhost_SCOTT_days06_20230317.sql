36	2023-03-17

1. dept 테이블에   deptno = 50,  dname = QC,  loc = SEOUL  로 새로운 부서정보 추가

DML(INSERT) + COMMIT/ROLLBACK
INSERT INTO 테이블명 [(컬럼명...)] VALUES (값...);
ROLLBACK;
COMMIT;
--
-- (1) ORA-00984: column not allowed here
-- 열은 이곳에 허락되지 않는다
INSERT INTO dept (deptno, dname, loc) VALUES ( 40, QC, SEOUL );
-- 오라클 문자 또는 날짜는 '' 붙인다
-- (2) ORA-00001: unique constraint (SCOTT.PK_DEPT) violated
-- 유일성 제약조건에 위배된다 -> deptno 부서번호가 중복되면 안된다
INSERT INTO dept (deptno, dname, loc) VALUES ( 40, 'QC', 'SEOUL' );
INSERT INTO dept (deptno, dname, loc) VALUES ( 50, 'QC', 'SEOUL' );
-- 1 행 이(가) 삽입되었습니다.
COMMIT;

1-2. dept 테이블에 QC 부서를 찾아서 부서명(dname)과 지역(loc)을 
  dname = 현재부서명에 2를 추가,  loc = POHANG 으로 수정

-- DML(UPDATE) + COMMIT
UPDATE 테이블명
SET 컬렴명 = 값, 컬럼명 = 값, ...
[WHERE] 생략하면 모든 레코드(행) 수정
--
SELECT *
FROM dept
WHERE dname = UPPER('qc');
WHERE REGEXP_LIKE( dname, 'QC' );
WHERE dname LIKE '%QC%';
--
UPDATE dept
SET dname = dname || 2, loc = 'POHANG' -- CONCAT(dname, 2)
WHERE deptno = 50;
COMMIT;

1-3. dept 테이블에서 QC2 부서를 찾아서 deptno(PK)를 사용해서 삭제

-- DML(DELETE) + COMMIT
DELETE FROM 테이블명
[WHERE] 생략하면 모든 레코드(행) 삭제
--
-- ORA-02292: integrity constraint (SCOTT.FK_DEPTNO) violated - child record found
-- 무결성 제약조건에 위배된다 -> 자식 레코드(행) 찾았다
-- 10 -> emp 10번사원 존재 -> 삭제 불가
-- 20 -> emp 20번사원 존재 -> 삭제 불가
-- 30 -> emp 30번사원 존재 -> 삭제 불가
-- 40, 50 삭제 가능
DELETE FROM dept
WHERE deptno = 50;
COMMIT;

2.  insa 테이블에서 남자는 'X', 여자는 'O' 로 성별(gender) 출력하는 쿼리 작성
    1. REPLACE() 사용해서 풀기

SELECT name, ssn
     , REPLACE( REPLACE( MOD( SUBSTR( ssn, -7, 1 ), 2 ), 1, 'X' ), 0, 'O' ) gender
FROM insa;
--
SELECT t.name, t.ssn, t.gender
     , REPLACE( REPLACE( t.gender, 1, 'X' ), 0, 'O' ) gender
FROM (
        SELECT name, ssn
             , MOD( SUBSTR( ssn, -7, 1 ), 2 ) gender
        FROM insa
    ) t;

    2. 집계(SET)연산자 사용해서 풀기

SELECT name, ssn
--   , MOD( SUBSTR( ssn, -7, 1 ), 2 ) gender
     , 'X' gender
FROM insa
WHERE MOD( SUBSTR( ssn, -7, 1 ), 2 ) = 1
-- WHERE gender = 1; -- ORA-00904: "GENDER": invalid identifier
UNION -- UNION ALL 동일한 값 (겹치는 값 없음)
SELECT name, ssn
     , 'O' gender
FROM insa
WHERE MOD( SUBSTR( ssn, -7, 1 ), 2 ) = 0;

    3. NULL 처리 함수 : NVL(), NVL2(), *** NULLIF() ***

NULLIF( e1, e2 )    e1 = e2     NULL 반환
                    e1 != e2    e1 반환
-- 예)
SELECT ename, NULLIF( ename, 'SMITH' ) -- SMITH만 null 반환
FROM emp;
--
SELECT name, ssn
--   , MOD( SUBSTR( ssn, -7, 1 ), 2 )
--   , NULLIF( MOD( SUBSTR( ssn, -7, 1 ), 2 ), 1 )
     , NVL2( NULLIF( MOD( SUBSTR( ssn, -7, 1 ), 2 ), 1 ), 'O', 'X' ) gender
FROM insa;
    
    NAME                 SSN            GENDER
    -------------------- -------------- ------
    홍길동               771212-1022432    X
    이순신               801007-1544236    X
    이순애               770922-2312547    O
    김정훈               790304-1788896    X
    한석봉               811112-1566789    X 

3.  insa 테이블에서 2000년 이후 입사자 정보 조회하는 쿼리 작성
    1. TO_CHAR() 함수 사용해서 풀기

SELECT name, ibsadate
FROM insa
WHERE TO_CHAR(ibsadate, 'YYYY') >= 2000;

    2. EXTRACT() 함수 사용해서 풀기.

SELECT name, ibsadate
FROM insa
WHERE EXTRACT( YEAR FROM ibsadate ) >= 2000;

    3. WHERE 날짜도 비교연산자 사용 가능
    
SELECT name, ibsadate
FROM insa
WHERE ibsadate >= '2000.1.1';
    
    NAME                 IBSADATE
    -------------------- --------
    이미성               00/04/07
    심심해               00/05/05
    권영미               00/06/04
    유관순               00/07/07    
    
4. 지금까지 배운 오라클 자료형을 적으세요.
   ㄱ. CHAR - 문자
   ㄴ. VARCHAR2 - 문자
   ㄷ. NUMBER - 숫자(정수, 실수)
   ㄹ. DATE - YY/MM/DD
   ㅁ. TIMESTAMP - YY/MM/DD hh:mm:ss.sss...

5. 현재 시스템의 날짜 출력하는 쿼리를 작성하세요. 
SELECT ( SYSDATE ) : 현재 시스템의 날짜 + 시간
     , ( CURRENT_DATE ) : 현재 세션(SESSION)의 날짜 + 시간
     , ( CURRENT_TIMESTAMP ) : 현재 세션의 날짜 + 시간 + 타임존 등등
FROM dual;
    
6. 시노님(synonym)에 대해서 간단히 설명하세요. 
schema.object 형식으로 계속 사용하기 번거로울 때 synonym을 생성해서 간단하게 사용할 수 있다
public synonym은 다른 계정으로 접속해도 권한만 부여되면 사용할 수 있다
--
1) 정의 : 하나의 객체에 대한 다른 이름을 정의한 것
         스키마.객체명 -> 별칭(시노님)
2) 종류 : PRIVATE, PUBLIC
3) 생성, 삭제 형식
4) 조회 : all_synonyms 모든 시노님 정보 조회
        user_synonyms 사용자가 만든 시노님 조회

7. SQL 집합 연산자의 종류와 설명을 하세요
  1) 종류
  UNION : A + B - ( A AND B )
  UNION ALL : A + B
  MINUS : A - B == A AND !B
  INRETSECT : A AND B
  
  2) 주의할 점
  두 테이블의 컬럼 수가 같고, 대응되는 컬럼끼리 데이터 타입이 동일해야 한다
  ORDER BY 절은 가장 마지막에 넣어야 된다
  출력되는 컬럼은 첫번째 SELECT절의 컬럼 이름을 따른다

8.  insa 테이블에서  주민번호를 아래와 같이 '-' 문자를 제거해서 출력

SELECT name, ssn
     , SUBSTR( ssn, 1, 6 ) || SUBSTR( ssn, -7 ) ssn
     , CONCAT( SUBSTR( ssn, 1, 6 ), SUBSTR( ssn, -7 ) ) ssn
     , REPLACE( ssn, '-', '' ) ssn_2
     , REPLACE( ssn, '-', ) ssn_2
FROM insa;
 
    NAME    SSN             SSN_2
    홍길동	770423-1022432	7704231022432
    이순신	800423-1544236	8004231544236
    이순애	770922-2312547	7709222312547      

[숫자함수]
9. ROUND() 
   1) 함수 설명 : 특정 값을 특정 위치에서 반올림하는 함수
   2) 형식 설명 : ROUND(a,b)일 때 b가 양수면 a를 소수점 b+1 자리에서 반올림하고, b가 음수면 정수 -b 자리에서 반올림한다
   3) 쿼리 설명
        SELECT    3.141592 -- 3.141592
               , ROUND(  3.141592 )     a -- b 값이 없을 때 디폴트값이 0이다 -- 3
               , ROUND(  3.141592,  0 ) b -- b == 0 이므로 소수점 1자리에서 반올림한다 -- 3
               , ROUND(  3.141592,  2 ) c -- b == 2 이므로 소수점 3자리에서 반올림한다 -- 3.14
               , ROUND(  3.141592,  -1 ) d -- b == -1 이므로 정수 1자리에서 반올림한다 -- 0
               , ROUND( 12345  , -3 )  e -- b == -1 이므로 정수 3자리에서 반올림한다 -- 12000
       FROM dual;

9-2. TRUNC()함수와 FLOOR() 함수에 대해서 설명하세요.        
TRUNC() : 특정 값을 특정 위치에서 절삭(버림)한다
          TRUNC(a,b)일 때 b가 양수면 a를 소수점 b+1 자리에서 절삭하고, b가 음수면 정수 -b 자리에서 절삭한다
FLOOR() : 특정 값을 소수점 1자리에서 절삭한다 == 정수만 출력

9-3. CEIL() 함수에 대해서 설명하세요. 
CEIL() : 특정 값을 소수점 1자리에서 절상(올림)한다

9-4. 나머지 값을 리턴하는 함수 :  (   MOD()   )
9-5. 절대값을 리턴하는 함수 :   (   ABS()   )
9-6. SING() 함수에 대해서 설명하세요.
SIGN() : 숫자값의 부호에 따라 양수면 1, 0이면 0, 음수면 -1 값을 리턴한다

10.emp 테이블에서 급여와 평균급여를 구하고
   각 사원의 급여-평균급여를 소수점 3자리에서 올림,반올림,내림해서 아래와 
   같이 조회하는 쿼리를 작성하세요.

SELECT ename, pay, avg_pay
     , CEIL( pay - avg_pay ) "차 올림"
     , ROUND( pay - avg_pay ) "차 반올림"
     , FLOOR( pay - avg_pay ) "차 내림"
FROM (
        SELECT ename, sal + NVL(comm,0) pay
             , ( SELECT ROUND( AVG( sal + NVL(comm,0) ), 2 ) FROM emp ) avg_pay
        FROM emp
     );
--
WITH
    temp AS (
                SELECT ename, sal + NVL(comm,0) pay
                --   , AVG( sal + NVL(comm,0) ) avg_pay -- ORA-00937: not a single-group group function
                --                                          단일그룹 그룹함수가 아니다
                -- 함수의 종류 2가지
                -- 1) 단일행 함수
                -- 2) 복수행 함수 (그룹함수, 집계함수)
                -- 일반컬럼과 그룹함수는 같이 사용할 수 없다
                -- 일반컬럼 + 그룹함수 같이 사용할 수 있는 경우 : group by 절을 사용하면 가능하다
                    , ( SELECT AVG( sal + NVL(comm,0) ) avg_pay FROM emp ) avg_pay
                -- ORA-00936: missing expression
                --            누락된(빠진) 표현식 -> 서브쿼리에 괄호 누락
                FROM emp
            )
SELECT t.ename, t.pay
     , ROUND( t.avg_pay, 2 ) avg_pay
     , t.pay - t.avg_pay "평균 급여와의 차액"
     -- , CEIL( t.pay - t.avg_pay, 2 ) "올림"
     , CEIL( (t.pay - t.avg_pay)*100 )/100 "올림"
     , ROUND( t.pay - t.avg_pay, 2 ) "반올림"
     , TRUNC( t.pay - t.avg_pay, 2 ) "내림"
FROM temp t;
-- ORA-00909: invalid number of arguments
--             잘못된   숫자    인자(매개변수)
--
SELECT AVG( sal + NVL(comm,0) ) avg_pay FROM emp;
-- 평균 구하기
SELECT
    SUM( sal + NVL(comm,0) ) tot_pay
  , COUNT( * ) cnt
  , SUM( sal + NVL(comm,0) )/COUNT( * ) avg_pay
  , AVG( sal + NVL(comm,0) ) avg_pay
FROM emp;
   
ENAME             PAY    AVG_PAY       차 올림      차 반올림       차 내림
---------- ---------- ---------- ---------- ---------- ----------
SMITH             800    2260.42   -1460.41   -1460.42   -1460.41
ALLEN            1900    2260.42    -360.41    -360.42    -360.41
WARD             1750    2260.42    -510.41    -510.42    -510.41
JONES            2975    2260.42     714.59     714.58     714.58
MARTIN           2650    2260.42     389.59     389.58     389.58
BLAKE            2850    2260.42     589.59     589.58     589.58
CLARK            2450    2260.42     189.59     189.58     189.58
KING             5000    2260.42    2739.59    2739.58    2739.58
TURNER           1500    2260.42    -760.41    -760.42    -760.41
JAMES             950    2260.42   -1310.41   -1310.42   -1310.41
FORD             3000    2260.42     739.59     739.58     739.58

ENAME             PAY    AVG_PAY       차 올림      차 반올림       차 내림
---------- ---------- ---------- ---------- ---------- ----------
MILLER           1300    2260.42    -960.41    -960.42    -960.41

10-2. emp 테이블에서 급여와 평균급여를 구하고
    각 사원의 급여가 평균급여 보다 많으면 "많다"
                   평균급여 보다 적으면 "적다"라고 출력
                   
SELECT ename, pay, avg_pay
     , pay - avg_pay difference
     , REPLACE( REPLACE( SIGN( pay - avg_pay ), -1, '적다' ), 1, '많다' ) message
FROM (
        SELECT ename, sal + NVL(comm, 0) pay
            , (SELECT ROUND( AVG( sal + NVL(comm, 0) ), 2 ) FROM emp) avg_pay
        FROM emp
    );
--
-- 평균급여 ( 2077.08 )
SELECT ROUND( AVG( sal ), 2 ) avg_pay
FROM emp;
-- (1) [ SET 연산자 ]
SELECT ename, sal, '많다'
FROM emp
WHERE sal > 2077.08
UNION
SELECT ename, sal, '적다'
FROM emp
WHERE sal < 2077.08
UNION
SELECT ename, sal, '같다'
FROM emp
WHERE sal = 2077.08;

-- (2)
SELECT ROUND( AVG( sal ), 2 ) avg_sal FROM emp;
--
SELECT SIGN(100), SIGN(-1000), SIGN(0)
FROM dual;
-- REPLACE() 함수 설명 -[1] -> -[X]
SELECT -1, '-1'
     , REPLACE( -1, 1, 'X' )
FROM dual;
--
SELECT t.*
     , t.sal - t.avg_sal diff
     , SIGN( t.sal - t.avg_sal ) s
     , '평균 sal보다 ' || REPLACE( REPLACE( REPLACE( SIGN( t.sal - t.avg_sal ), -1, '적다' ), 1, '많다' ), 0, '같다' ) x
--   , REPLACE( REPLACE( SIGN( t.sal - t.avg_sal ), 1, '많다' ), -1, '적다' ) x
FROM (
        SELECT empno, ename, sal, ( SELECT ROUND( AVG( sal ), 2 ) avg_sal FROM emp ) avg_sal
        FROM emp
    ) t;

11. insa 테이블에서 모든 사원들을 14명씩 팀을 만드면 총 몇 팀이 나올지를 쿼리로 작성하세요.
 ( 힌트 : 집계(그룹)함수 사용)
 
SELECT COUNT( * ) "총 사원수"
     , 14 "팀 사원수"
     , CEIL( COUNT( * )/14 ) "총 팀수" -- 절상(올림)
FROM insa;

12. emp 테이블에서 최고 급여자, 최저 급여자 정보 모두 조회
-- (1)
SELECT *
FROM emp
ORDER BY sal + NVL(comm,0) DESC;
--
SELECT MAX( sal + NVL(comm,0) ) max_pay
     , MIN( sal + NVL(comm,0) ) min_pay
FROM emp;
--
SELECT *
FROM emp
WHERE sal + NVL(comm,0) IN (
                                ( SELECT MAX( sal + NVL(comm,0) ) FROM emp )
                              , ( SELECT MIN( sal + NVL(comm,0) ) FROM emp )
                            );
--
SELECT *
FROM emp
WHERE sal + NVL(comm,0) = ( SELECT MAX( sal + NVL(comm,0) ) FROM emp )
     OR sal + NVL(comm,0) = ( SELECT MIN( sal + NVL(comm,0) ) FROM emp );

WHERE sal + NVL(comm,0) IN ( 5000, 800 );
WHERE sal + NVL(comm,0) = 5000 OR sal + NVL(comm,0) = 800;
-- 서브쿼리 적용 안한 잘못된 코딩
SELECT *
FROM emp
WHERE sal + NVL(comm,0) IN (
                                SELECT MAX( sal + NVL(comm,0) ) max_pay
                                     , MIN( sal + NVL(comm,0) ) min_pay
                                FROM emp
                            );
-- ORA-00913: too many values
-- 884행, 33열에서 오류 발생 (SELECT MAX ~)

-- (2)
SELECT *
FROM emp
WHERE sal + NVL(comm,0) = ( SELECT MAX( sal + NVL(comm,0) ) FROM emp )
UNION
SELECT *
FROM emp
WHERE sal + NVL(comm,0) = ( SELECT MIN( sal + NVL(comm,0) ) FROM emp );

-- (3)
-- ALL, ANY, SOME ( 비교연산자 )         TRUE/FALSE EXISTS, SQL연산자
-- [ emp 테이블에서 최고/최저 급여자 ]
SELECT e.*, '최고 급여자' "최고/최저 급여자"
FROM emp e
WHERE sal+NVL(comm,0) >= ALL ( SELECT sal+NVL(comm,0) pay FROM emp )
UNION
SELECT e.*, '최저 급여자'
FROM emp e
WHERE sal+NVL(comm,0) <= ALL ( SELECT sal+NVL(comm,0) pay FROM emp );

                                            PAY(sal+comm)
7369	SMITH	CLERK	7902	80/12/17	800		    20  최고급여자
7839	KING	PRESIDENT		81/11/17	5000		10  최저급여자

13. emp 테이블에서 
   comm 이 400 이하인 사원의 정보 조회
  ( comm 이 null 인 사원도 포함 )
-- (1)
SELECT ename, sal, comm
FROM emp
WHERE comm <= 400
UNION
SELECT ename, sal, comm
FROM emp
WHERE comm IS NULL;

-- (2)
SELECT ename, sal, comm
FROM emp
WHERE comm <= 400 OR comm IS NULL;

-- (3)
SELECT ename, sal, comm
FROM emp
WHERE NVL(comm,0) <= 400;

-- (4) LNNVL() 함수
WHERE LNNVL(조건식)
       true -> false
       
       null(unknow) -> true
       false -> true
--
SELECT ename, sal, comm
FROM emp
WHERE LNNVL(comm >= 400); -- comm <= 400 OR comm IS NULL;

    ENAME   SAL    COMM     COMM >= 400     LNNVL(comm >= 400)
    SMITH	800	    null        null             true
    ALLEN	1600	300
    WARD    1250    500         true             false
    JONES	2975	
    MARTIN  1250    1400
    BLAKE	2850	
    CLARK	2450	
    KING	5000	
    TURNER	1500	0
    JAMES	950	
    FORD	3000	
    MILLER	1300	
    
14. emp 테이블에서 각 부서별 급여(pay)를 가장 많이 받는 사원의 정보 출력.    
    ( 힌트 : Correlated Subquery 사용 가능, SET 연산자 사용 가능 )

SELECT *
FROM dept; -- 10, 20, 30, 40
-- 10번 부서원 중에 최고 급여자
SELECT MAX(sal + NVL(comm, 0)) FROM emp WHERE deptno = 10; -- 2450
SELECT MAX(sal + NVL(comm, 0)) FROM emp WHERE deptno = 20; -- 3000
SELECT MAX(sal + NVL(comm, 0)) FROM emp WHERE deptno = 30; -- 2850
SELECT MAX(sal + NVL(comm, 0)) FROM emp WHERE deptno = 40; -- null
-- (1) SET 연산자
-- 문제점) 10번 부서의 최고 급여액이 2000이라고 가정하면 다른 부서의 급여액이 2000인 사람도 출력된다
--         10/2000, 20/2000, 30/2000
-- 7934	MILLER	CLERK	7782	82/01/23	1300		10
UPDATE emp
SET sal = 3000
WHERE empno = 7934;
ROLLBACK;
-- 해결)
SELECT *
FROM emp
WHERE sal + NVL(comm, 0) = ( SELECT MAX(sal + NVL(comm, 0)) FROM emp WHERE deptno = 10 ) AND deptno = 10 -- 2450
UNION
SELECT *
FROM emp
WHERE sal + NVL(comm, 0) = ( SELECT MAX(sal + NVL(comm, 0)) FROM emp WHERE deptno = 20 ) AND deptno = 20 -- 3000
UNION
SELECT *
FROM emp
WHERE sal + NVL(comm, 0) = ( SELECT MAX(sal + NVL(comm, 0)) FROM emp WHERE deptno = 30 ) AND deptno = 30 -- 2850
UNION
SELECT *
FROM emp
WHERE sal + NVL(comm, 0) = ( SELECT MAX(sal + NVL(comm, 0)) FROM emp WHERE deptno = 40 ) AND deptno = 40; -- X
-- ORDER BY deptno; -- ORA-00904: "DEPTNO": invalid identifier -> SELECT절에 deptno 컬럼명 명시

-- (2) 상관 서브쿼리 ( Correlated Subquery ) main qurey와 같이 연동
SELECT *
FROM emp p
WHERE sal + NVL(comm, 0) = (
                                SELECT MAX(sal + NVL(comm, 0))
                                FROM emp c 
                                WHERE c.deptno = p.deptno
                            );
-------------------------------------------------------------------------------
-- [ 숫자 함수 ]
-------------------------------------------------------------------------------
1. POWER(a,b)
2. SQRT 제곱근
3. SIN(), COS(), TAN()
4. LOG()
   LN() 자연로그 - 밑수 e인 로그함수
   EXP() 지수함수 - 밑수 e인 지수함수

SELECT POWER(2,3), POWER(2,-3)
     , SQRT(2)
     , EXP(2)
FROM dual;
-------------------------------------------------------------------------------
1. UPPER(), LOWER(), INITCAP()
2. LENGTH()
3. CONCAT() ||
4. SUBSTR()
SELECT ename
     , UPPER( ename )
     , LOWER( ename )
     , INITCAP( ename ) -- 각 단어의 첫번째 문자는 대문자, 나머지는 소문자로 변환
     , LENGTH( ename ) -- 문자열의 길이
FROM emp;

5. INSTR( 문자열, 찾고자하는 문자열 [, 찾기 시작할 위치 [, 발생 번호] ] ) -- 문자값 중 지정된 문자값의 위치를 숫자로 리턴한다
SELECT ename
     , INSTR( ename, 'L' ) L_first
     , INSTR( ename, 'L', INSTR( ename, 'L' )+1 ) L_second
     , INSTR( ename, 'L', 1, 2 ) L_second
     , INSTR( ename, 'L', -1, 2 ) L_second_back -- ename 뒤에서부터 두 번째 오는 L의 위치를 찾겠다
FROM emp;

6. RPAD()/LPAD()
   Right + PAD, Left + PAD
   PAD = 패드, 덧 대는 것, 메워 넣는 것
【형식】
      RPAD (expr1, n [, expr2] )
SELECT ename, sal + NVL(comm,0) pay
     , RPAD( sal + NVL(comm,0), 10, '*' )
     , LPAD( sal + NVL(comm,0), 10, '*' )
FROM emp;
예) pay 100마다 * 출력 (.5 반올림)
SELECT ename, sal + NVL(comm,0) pay
     , ROUND( (sal + NVL(comm,0))/100 ) n
     , RPAD( ' ',  ROUND( (sal + NVL(comm,0))/100 )+1, '#' ) "bar"
FROM emp;

7. RTRIM()/LTRIM() : 문자값 중에서 우/좌측으로부터 특정문자와 일치하는 문자값을 제거한다
【형식】
      RTRIM(char [,set] )
-- 자바 String.trim() 앞/뒤 공백 제거하는 함수
SELECT '  admin  '
     , '{' || RTRIM( '  admin  ', ' ' ) || '}'
     , '{' || RTRIM( '  admin  ' ) || '}'
     , '{' || LTRIM( '  admin  ', ' ' ) || '}'
FROM dual;
--
SELECT RTRIM('BROWINGyxXxy','xy') "RTRIM example"
     , RTRIM('BROWINGyxXxyxxyy','xy') "RTRIM example"
FROM dual;
--
SELECT RTRIM('BROWING: ./=./=./=./=.=/.=', '/=.') "RTRIM example" 
FROM dual;

8. ASCII()
SELECT ASCII('A'), ASCII('a'), ASCII('0')
FROM dual;

9. CHR()
SELECT CHR(65)
FROM dual;

10. GREATEST()
11. LEAST()
SELECT GREATEST(1,4,3,5,2), LEAST(1,4,3,5,2)
FROM dual;
--
SELECT GREATEST('KOREA','COREA','SEOUL')
FROM dual;

12. REPLACE()

13. VSIZE() -- 지정된 문자열의 크기를 숫자값(바이트 수)으로 리턴한다
SELECT VSIZE('a'), VSIZE('한')
FROM dual;
-------------------------------------------------------------------------------
-- [ 날짜 함수 ]
-------------------------------------------------------------------------------
1. SYSDATE
SELECT SYSDATE -- '23/03/17' 현재 시스템의 날짜 + (시간 포함)
FROM dual;

2. ROUND( 날짜 )
【형식】
	ROUND( date [,format 형식] )

SELECT SYSDATE -- 23/03/17
     , ROUND( SYSDATE ) --  23/03/18 -- 날짜 형식이 없으면 가장 가까운 날을 출력한다
     , ROUND ( SYSDATE, 'DD' ) -- 23/03/18 일을 반올림할 때 정오를 넘으면 다음날 자정을 출력하고, 넘지 않으면 그 날 자정을 출력한다
     , ROUND ( SYSDATE, 'MONTH' ) -- 23/04/01 월을 반올림하는 경우는 15일 이상이면 다음달 1일을 출력하고, 넘지 않으면 현재 달 1일을 출력한다
     , ROUND ( SYSDATE, 'YEAR' ) -- 23/01/01 년을 반올림하는 경우에는 6월을 넘으면 다음해 1월 1일을 출력하고, 넘지 않으면 그 해 1월 1일을 출력한다
FROM dual;

3. TRUNC( 날짜 )
SELECT SYSDATE
     , TRUNC( SYSDATE ) -- 23/03/17 가장 근접한 날로 절삭된다
     , TRUNC ( SYSDATE, 'DD' ) -- 23/03/17 시:분:초
     , TRUNC ( SYSDATE, 'MONTH' ) -- 23/03/01
     , TRUNC ( SYSDATE, 'YEAR' ) -- 23/01/01
FROM dual;

4. MONTHS_BETWEEN() : 두 날짜 사이의 개월수
-- 각 사원들의 근무일수, 근무개월수 파악(조회)
SELECT ename, hiredate, SYSDATE
     , ROUND( MONTHS_BETWEEN( SYSDATE, hiredate ), 1 ) 근무개월수
     , CEIL( SYSDATE - hiredate ) 근무일수 -- ( 날짜 - 날짜 = 일수 )
FROM emp;

5. ADD_MONTHS() -- '3/31' 한달 전 2/28,29
SELECT SYSDATE
     , ADD_MONTHS( SYSDATE, 1 )
     , ADD_MONTHS( SYSDATE, -1 )
FROM dual;

6. LAST_DAY -- 특정 날짜가 속한 달의 가장 마지막 날짜를 리턴하는 함수
SELECT SYSDATE
     , LAST_DAY( SYSDATE ) -- 23/03/31
FROM dual;

7. NEXT_DAY -- 명시된 요일이 돌아오는 가장 최근의 날짜를 리턴하는 함수
【형식】
      NEXT_DAY(date,char)
      
SELECT SYSDATE -- 23/03/17
     , TO_CHAR( SYSDATE, 'YYYY' ) year
     , TO_CHAR( SYSDATE, 'MM' ) month
     , TO_CHAR( SYSDATE, 'DD' ) "DATE"
     , TO_CHAR( SYSDATE, 'DAY' ) day
     -- 다음 주 월요일 만나자 (약속)
     , NEXT_DAY( SYSDATE, '월요일' ) -- 23/03/20
FROM dual;
-------------------------------------------------------------------------------
날짜 + 숫자 = 날짜
날짜 - 숫자 = 날짜
날짜 + 숫자/24(시간) = 날짜
날짜 - 날짜 = 일수 ***

SELECT SYSDATE
     , SYSDATE + 3 -- 3일 뒤에 만나자
     , SYSDATE - 10
     , SYSDATE + 2/24 -- 2시간 뒤의 날짜
FROM dual;
-------------------------------------------------------------------------------
Ora_Help    function 검색한 후 datetime 종류 전까지 수업했다
-- 다음주
-- 남은 함수 설명
-- 오라클 자료형
-- 테이블 생성/수정/삭제/제약조건 + DML문





























