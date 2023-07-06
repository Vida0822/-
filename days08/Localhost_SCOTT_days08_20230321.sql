-- SCOTT --
-------------------------------------------------------------------------------
1.  TO_CHAR( ,  'format') 함수에서 'format'에 사용되는 기호를 적으세요.
  ㄱ. 년도 : 'YYYY', 'YY', 'RRRR', 'RR'
  ㄴ. 월 : 'MM', 'MONTH', 'MON'
  ㄷ. 월의 일 : 'DD'
      주의 일 : 'D'
      년의 일 : 'DDD'
  ㄹ. 요일 : 'DY', 'DAY'
  ㅁ. 월의 주차 : 'W'
      년의 주차 : 'WW', 'IW'
  ㅂ. 시간/24시간 : 'HH', 'HH12', 'HH24'
  ㅅ. 분 : 'MI'
  ㅇ. 초 : 'SS'
  ㅈ. 자정에서 지난 초 : 'SSSSS'
  ㅊ. 오전/오후 : 'AM', 'PM'
  
2. 본인의 생일로부터 오늘까지 살아온 일수, 개월수, 년수를 출력하세요..

-- ORA-01722: invalid number
-- '1996.06.29'을 날짜로 형변환 필요
SELECT CEIL( SYSDATE - TO_DATE( '1996.06.29', 'YYYY.MM.DD' ) ) "일수"
     , ROUND( MONTHS_BETWEEN( SYSDATE, TO_DATE( '1996.06.29' ) ), 2 ) "개월수"
     , ROUND( MONTHS_BETWEEN( SYSDATE, TO_DATE( '1996.06.29' ) )/12, 2 ) "년수"
FROM dual;

반올림 : ROUND
절상(올림) : CEIL
절삭(내림) : TRUNC, FLOOR

3. IW와 WW 의 차이점.

IW : 월요일~일요일이 한 주차
WW : 1일~7일이 한 주차

4-1. 이번 달이 몇 일까지 있는 확인.
SELECT TO_CHAR( LAST_DAY( SYSDATE ), 'DD' ) last_day -- 문자 반환
     , EXTRACT( DAY FROM LAST_DAY( SYSDATE ) ) -- 숫자 반환
     , TO_DATE( TO_CHAR( ADD_MONTHS( SYSDATE, 1 ), 'YYYY.MM' ), 'YYYY.MM' ) - 1
FROM dual;

4-2. 오늘이 년중 몇 째 주, 월중 몇 째주인지 확인. 

SELECT TO_CHAR( SYSDATE, 'WW' ) y_week , TO_CHAR( SYSDATE, 'W' ) m_week
FROM dual;

5. emp 에서  pay 를 NVL(), NVL2(), COALESCE()함수를 사용해서 출력하세요.

SELECT sal+NVL(comm,0) n_pay, NVL2( sal+comm, sal+comm, sal ) n2_pay, COALESCE( sal+comm, sal, 0 ) c_pay
FROM emp;

5-2. emp테이블에서 mgr이 null 인 경우 -1 로 출력하는 쿼리 작성
      ㄱ. nvl()
      
      SELECT NVL( mgr, -1 )
      FROM emp;
      
      ㄴ. nvl2()
      
      SELECT NVL2( mgr, mgr, -1 )
      FROM emp;
      
      ㄷ. COALESCE()
      
      SELECT COALESCE( mgr, -1 )
      FROM emp;

6. insa 에서  이름,주민번호, 성별( 남자/여자 ) 출력 쿼리 작성-
    ㄱ. DECODE()
    
    SELECT name, ssn
         , DECODE( MOD( SUBSTR( ssn, -7, 1 ), 2 ), 1, '남자', 0, '여자' ) gender
    FROM insa;
    
    ㄴ. CASE 함수
    
        SELECT name, ssn
             , CASE MOD( SUBSTR( ssn, -7, 1 ), 2 )
                WHEN 1 THEN '남자'
                WHEN 0 THEN '여자'
               END gender
    FROM insa;

7. emp 에서 평균PAY 보다 같거나 큰 사원들만의 급여합을 출력.
  ( DECODE, CASE 사용해서 풀이 ) 
  
SELECT SUM( DECODE( SIGN( pay - avg_pay ), 1, pay, 0 ) ) sum_pay
FROM (
        SELECT ename, sal+NVL(comm,0) pay, ( SELECT AVG( sal+NVL(comm,0) ) FROM emp ) avg_pay
        FROM emp
    ) t;

SELECT SUM( CASE SIGN( pay - avg_pay ) WHEN 1 THEN pay ELSE 0 END ) sum_pay
FROM (
        SELECT ename, sal+NVL(comm,0) pay, ( SELECT AVG( sal+NVL(comm,0) ) FROM emp ) avg_pay
        FROM emp
    ) t;
--
WITH
    temp AS (
                SELECT empno, ename, sal + NVL(comm,0) pay
                FROM emp
                WHERE sal + NVL(comm,0) >= (
                                                SELECT AVG( sal + NVL(comm,0) ) avg_pay
                                                FROM emp
                                            )
            )
SELECT SUM( t.pay )
FROM temp t;
--
WITH
    temp AS (
                SELECT empno, ename, sal + NVL(comm,0) pay
                     , ( SELECT AVG( sal + NVL(comm,0) ) FROM emp ) avg_pay
                FROM emp
            )
SELECT SUM( DECODE( SIGN( t.pay - t.avg_pay ), -1, NULL, t.pay ) ) d_sum
     , SUM( CASE SIGN( t.pay - t.avg_pay )
              WHEN -1 THEN NULL
              ELSE t.pay
            END
        ) s_sum1
     , SUM( CASE 
              WHEN SIGN( t.pay - t.avg_pay ) >= 0 THEN t.pay
              ELSE NULL
            END
        ) s_sum2
FROM temp t;

[문제] insa 테이블에서 남자사원수, 여자사원수 출력

SELECT '총 사원수', COUNT(*)
FROM insa
UNION ALL
SELECT '남자 사원수', COUNT(*)
FROM insa
WHERE MOD( SUBSTR( ssn, -7, 1 ), 2 ) = 1
UNION ALL
SELECT '여자 사원수', COUNT(*)
FROM insa
WHERE MOD( SUBSTR( ssn, -7, 1 ), 2 ) = 0;
--
SELECT COUNT(*) "총 사원수"
  , COUNT( DECODE( MOD( SUBSTR( ssn, -7, 1 ), 2 ), 1, 100 ) ) "남자 사원수"
--, COUNT( DECODE( MOD( SUBSTR( ssn, -7, 1 ), 2 ), 0, 100 ) ) "여자 사원수"
  , COUNT(
        CASE MOD( SUBSTR( ssn, -7, 1 ), 2 )
            WHEN 0 THEN 'F'
            ELSE NULL
        END
    ) "여자 사원수"
FROM insa;
--
SELECT DECODE( MOD( SUBSTR( ssn, -7, 1 ), 2 ), 1, '남자', 0, '여자' ) "성별", COUNT(*)
FROM insa
GROUP BY MOD( SUBSTR( ssn, -7, 1 ), 2 );

MOD(SUBSTR(SSN,-7,1),2)   COUNT(*)
----------------------- ----------
                      1         31
                      0         29
                      
[문제] emp 테이블에서 각 부서별 사원수 조회(출력)
-- 1) UNION ALL
SELECT 10 deptno, COUNT(*)
FROM emp
WHERE deptno = 10
UNION ALL
SELECT 20, COUNT(*)
FROM emp
WHERE deptno = 20
UNION ALL
SELECT 30, COUNT(*)
FROM emp
WHERE deptno = 30
UNION ALL
SELECT 40, COUNT(*)
FROM emp
WHERE deptno = 40
UNION ALL
SELECT null, COUNT(*)
FROM emp
WHERE deptno IS NULL;
-- 2) DECODE, COUNT
SELECT COUNT( DECODE( deptno, 10, 'O' ) ) "10"
     , COUNT( DECODE( deptno, 20, 'O' ) ) "20"
     , COUNT( DECODE( deptno, 30, 'O' ) ) "30"
     , COUNT( DECODE( deptno, 40, 'O' ) ) "40"
     , COUNT( DECODE( deptno, null, 'O' ) ) "null"
FROM emp;
-- 3) GROUP BY
-- 문제점) 사원이 존재하지 않는 부서 정보는 출력(조회)되지 않는다
-- 추가) 전체 사원수 출력 : UNION ALL ( SET 연산자 )
SELECT deptno, COUNT(*)
FROM emp
GROUP BY deptno
UNION ALL
SELECT 0 deptno, COUNT(*)
FROM emp
UNION ALL
SELECT 40 deptno, COUNT(*)
FROM emp
WHERE deptno = 40
ORDER BY deptno ASC; -- ORA-00904: "DEPTNO": invalid identifier

[확인] 각 부서별 총 급여합
SELECT deptno
    , COUNT(*) "사원수"
    , SUM( sal + NVL(comm,0) ) "총급여합"
    , MAX( sal + NVL(comm,0) ) "최고급여액"
    , MIN( sal + NVL(comm,0) ) "최저급여액"
    , ROUND( AVG( sal + NVL(comm,0) ) ) "평균급여액"
FROM emp
GROUP BY deptno
ORDER BY deptno;

8. emp 에서  사원이 존재하는 부서의 부서번호만 출력

SELECT deptno, dname, loc
FROM dept;

    DEPTNO DNAME          LOC          
---------- -------------- -------------
        10 ACCOUNTING     NEW YORK     
        20 RESEARCH       DALLAS       
        30 SALES          CHICAGO      
        40 OPERATIONS     BOSTON   

SELECT *
FROM emp
ORDER BY deptno;

-- SET 연산자 ( MINUS )
SELECT deptno
FROM dept
MINUS
SELECT DISTINCT deptno
FROM emp;
--
SELECT DISTINCT( DECODE( deptno, 10, 10, 20, 20, 30, 30, 40, 40 ) )
FROM emp;
--
-- OUTER JOIN( 외부 조인) --
    SELECT d.deptno --, COUNT(e.ename) 사원수
    FROM dept d LEFT OUTER JOIN emp e ON d.deptno = e.deptno
    GROUP BY d.deptno
    HAVING COUNT(e.ename) = 0 ;

-- JOIN ( 조인 == 결합 )
[문제] emp 테이블에서 사원 정보 조회
( 부서번호, 부서명, 사원번호, 사원명, 입사일자 )

SELECT deptno, empno, ename, hiredate
FROM emp;
-- dept(부서) 테이블에 dname 컬럼으로 부서명이 존재
SELECT *
FROM dept;
-- dept 와 emp 를 결합(JOIN)해야 우리가 원하는 컬럼 정보를 조회할 수 있다
-- dept : deptno, dname
-- emp : deptno, empno, ename, hiredate

-- ORA-00918: column ambiguously defined
-- deptno 컬럽이 애매모하하게 정의(선언) 되었다.
-- dept - deptno, emp - deptno
SELECT dept.deptno, dept.dname, emp.empno, emp.ename, emp.hiredate
FROM dept, emp
WHERE dept.deptno = emp.deptno;
--
SELECT d.deptno, d.dname, e.empno, e.ename, e.hiredate
FROM dept d, emp e
WHERE d.deptno = e.deptno;
--
SELECT d.deptno, dname, empno, ename, hiredate
FROM dept d, emp e
WHERE d.deptno = e.deptno;
--
SELECT d.deptno, dname, empno, ename, hiredate
FROM dept d JOIN emp e ON d.deptno = e.deptno;

9. 아래 코딩을  DECODE()를 사용해서 표현하세요.
    ㄱ. [자바]
        if( A == B ){
           return X;
        }
    
    SELECT DECODE( 'A', 'B', 'X' )
    FROM dual;
    
    ㄴ. [자바]
        if( A==B){
           return S;
        }else if( A == C){
           return T;
        }else{
           return U;
        }
        
     SELECT DECODE( 'A', 'B', 'S', 'C', 'T', 'U' )
     FROM dual;   
    
    ㄷ.  [자바]
        if( A==B){
           return XXX;
        }else{
           return YYY;
        }
     
      SELECT DECODE( 'A', 'B', 'XXX', 'YYY' )
      FROM dual;

10. insa테이블에서 1001, 1002 사원의 주민번호의 월/일 만 오늘 날짜로 수정하는 쿼리를 작성 
SELECT *
FROM insa;

UPDATE insa
SET ssn = REPLACE( ssn, SUBSTR( ssn, 3, 4 ), TO_CHAR( SYSDATE, 'MMDD' ) )
-- SET ssn = SUBSTR( ssn, 0, 2 ) || TO_CHAR( SYSDATE, 'MMDD' ) || SUBSTR( ssn, 7 )
WHERE num IN (1001, 1002);
ROLLBACK;
COMMIT;

10-2. insa테이블에서 오늘('2023.03.21')을 기준으로 아래와 같이 출력하는 쿼리 작성.  
   ( DECODE, CASE 함수 사용 )
   
SELECT name, ssn
     , DECODE( SIGN( TRUNC( SYSDATE ) - TO_DATE( SUBSTR( ssn, 3, 4 ), 'MMDD' ) ), -1, '생일 전', 1, '생일 후', '오늘 생일' ) d_result
     , CASE SIGN( TRUNC( SYSDATE ) - TO_DATE( SUBSTR( ssn, 3, 4 ), 'MMDD' ) )
        WHEN -1 THEN '생일 전'
        WHEN 1 THEN '생일 후'
        WHEN 0 THEN '오늘 생일'
       END c_result
FROM insa;
   
결과)
장인철	780506-1625148	생일 후
김영년	821011-2362514	생일 전
나윤균	810810-1552147	생일 후
김종서	751010-1122233	오늘 생일
유관순	801010-2987897	오늘 생일
정한국	760909-1333333	생일 후

10-3. insa테이블에서 오늘('2023.03.21')기준으로 이 날이 생일인 사원수,지난 사원수, 안 지난 사원수를 출력하는 쿼리 작성. 

SELECT 
      COUNT( DECODE( SIGN( TRUNC( SYSDATE ) - TO_DATE( SUBSTR( ssn, 3, 4 ), 'MMDD' ) ), -1, 'O' ) ) "생일 전 사원수"
    , COUNT( DECODE( SIGN( TRUNC( SYSDATE ) - TO_DATE( SUBSTR( ssn, 3, 4 ), 'MMDD' ) ), 1, 'O' ) ) "생일 후 사원수"
    , COUNT( DECODE( SIGN( TRUNC( SYSDATE ) - TO_DATE( SUBSTR( ssn, 3, 4 ), 'MMDD' ) ), 0, 'O' ) ) "오늘 생일 사원수"
FROM insa;
--
SELECT COUNT( DECODE( s, 0, 'O' ) ) "오늘 생일 사원수"
     , COUNT( DECODE( s, -1, 'O' ) ) "생일 후 사원수"
     , COUNT( DECODE( s, 1, 'O' ) ) "생일 전 사원수"
FROM (
        SELECT num, name, ssn, SIGN( SUBSTR( ssn, 3, 4 ) - TO_CHAR( SYSDATE, 'MMDD' ) ) s
        FROM insa
    ) t;
--
SELECT
    CASE s
        WHEN 0 THEN '오늘 생일'
        WHEN -1 THEN '생일 후'
        WHEN 1 THEN '생일 전'
    END,
    DECODE ( s, 
FROM (
        SELECT num, name, ssn, SIGN( SUBSTR( ssn, 3, 4 ) - TO_CHAR( SYSDATE, 'MMDD' ) ) s
        FROM insa
    ) t
    GROUP BY s;

[실행결과]
  생일 전 사원수   생일 후 사원수  오늘 생일 사원수
---------- ---------- ----------
        48         12          0

11.  emp 테이블에서 10번 부서원들은  급여 15% 인상
                20번 부서원들은 급여 10% 인상
                30번 부서원들은 급여 5% 인상
                40번 부서원들은 급여 20% 인상
  하는 쿼리 작성.     

SELECT deptno, empno, ename
     , COALESCE( sal+comm, sal, 0 ) pay
     , '+' || DECODE( deptno, 10, 15, 20, 10, 30, 5, 40, 20, 0 ) || '%' "%"
     , COALESCE( sal+comm, sal, 0 ) * DECODE( deptno, 10, 1.15, 20, 1.10, 30, 1.05, 40, 1.20, 1 ) update_pay
FROM emp
ORDER BY deptno;
          
12. emp 테이블에서 각 부서의 사원수를 조회하는 쿼리
  ( 힌트 :  DECODE, COUNT 함수 사용 )

SELECT 
      COUNT( DECODE( deptno, 10, 'O' ) ) "10번 부서 사원수"
    , COUNT( DECODE( deptno, 20, 'O' ) ) "20번 부서 사원수"
    , COUNT( DECODE( deptno, 30, 'O' ) ) "30번 부서 사원수"
    , COUNT( DECODE( deptno, 40, 'O' ) ) "40번 부서 사원수"
    , COUNT( DECODE( deptno, NULL, 'O' ) ) "부서가 없는 사원수"
FROM emp;
-- [EQUI JOIN == INNER JOIN]
-- OUTER JOIN
-- 1) LEFT OUTER JOIN
-- 2) RIGHT OUTER JOIN
-- 3) FULL OUTER JOIN
SELECT d.deptno, COUNT(ename)
FROM dept d FULL OUTER JOIN emp e ON d.deptno = e.deptno
GROUP BY d.deptno
ORDER BY d.deptno ASC;

13. emp, salgrade 두 테이블을 참조해서 아래 결과 출력 쿼리 작성.

SELECT ename, sal
     , CASE
        WHEN sal BETWEEN 700 AND 1200 THEN 1
        WHEN sal BETWEEN 1201 AND 1400 THEN 2
        WHEN sal BETWEEN 1401 AND 2000 THEN 3
        WHEN sal BETWEEN 2001 AND 3000 THEN 4
        WHEN sal BETWEEN 3001 AND 9999 THEN 5
       END grade
FROM emp;
-- NON_EQUI JOIN
SELECT ename, sal
     , losal || ' ~ ' || hisal range
     , grade
FROM emp e, salgrade s
WHERE e.sal BETWEEN s.losal AND s.hisal;

ENAME   SAL     GRADE
----- ----- ---------
SMITH	800	    1
ALLEN	1900	3
WARD	1750	3
JONES	2975	4
MARTIN	2650	4
BLAKE	2850	4
CLARK	2450	4
KING	5000	5
TURNER	1500	3
JAMES	950	    1
FORD	3000	4
MILLER	1300	2

14. emp 테이블에서 급여를 가장 많이 받는 사원의 empno, ename, pay 를 출력.

SELECT empno, ename, sal + NVL(comm,0) pay
FROM emp
WHERE sal >= ALL( SELECT sal + NVL(comm,0) pay FROM emp );
WHERE sal = ( SELECT MAX( sal + NVL(comm,0) ) max_pay FROM emp );

-- RANK 순위 함수
-- TOP-N 방식

14-2. emp 테이블에서 각 부서별 급여를 가장 많이 받는 사원의 pay를 출력
 1) UNION ALL 사용해서 풀기
 2) GROUP BY  사용해서 풀기
 3) 상관 서브쿼리 사용해서 풀기

SELECT deptno, MAX( sal + NVL(comm,0) ) max_pay
FROM emp
GROUP BY deptno
ORDER BY deptno;
--
SELECT d.deptno, NVL( MAX( sal + NVL(comm,0) ), 0 ) max_pay
FROM emp e FULL OUTER JOIN dept d ON d.deptno = e.deptno
GROUP BY d.deptno
ORDER BY d.deptno;
--
SELECT deptno, ename, sal + NVL(comm,0) pay
FROM emp a
WHERE sal + NVL(comm,0) = (
                                SELECT MAX( sal + NVL(comm,0) ) deptno_max_pay
                                FROM emp b
                                WHERE b.deptno = a.deptno
                            );
-------------------------------------------------------------------------------
-- [문제] emp 테이블에서 pay를 많이 받는 3명 정보를 조회 ( TOP-N 방식 )
SELECT ROWNUM, t.*
FROM (
        SELECT empno, ename, hiredate, sal + NVL(comm,0) pay, deptno
        FROM emp
        ORDER BY pay DESC
    ) t
WHERE ROWNUM <= 1;
-- WHERE ROWNUM BETWEEN 3 AND 5; -- 중간의 순번(ROWNUM)은 가져올 수 없다

-- [ TOP-N 방식 ]
1) 최대값이나 최소값을 가진 컬럼을 질의할 때 유용하게 사용되는 분석방법
2) inline view에서 ORDER BY 절을 사용할 수 있으므로 데이터를 원하는 순서로 정렬도 가능하다.
3) ROWNUM 컬럼은 subquery에서 반환되는 각 행에 순차적인 번호를 부여하는 pseudo 컬럼이다.
4) n값은 < 또는 >=를 사용하여 정의하며, 반환될 행의 개수를 지정한다.
【형식】
	SELECT 컬럼명,..., ROWNUM
	FROM (SELECT 컬럼명,... from 테이블명
	      ORDER BY top_n_컬럼명)
        WHERE ROWNUM <= n;

-- [문제] emp 테이블에서 pay를 많이 받는 3명 정보를 조회 ( 순위(RANK) 함수 )
-- 순위(RANK) 함수
-- 1) DENSE_RANK
-- 2) PERCENT_RANK
-- 3) RANK
-- 4) FIRST / LAST
-- 5) ROW_NUMBER
분석(analytic) 함수
분할별로 정렬된 결과에 대해 순위를 부여하는 기능이다.
분할은 전체 행을 특정 컬럼을 기준으로 분리하는 기능으로 GROUP BY 절에서 그룹화하는 방법과 같은 개념이다.
【형식】
      ROW_NUMBER () 
                   OVER ([query_partition_clause] order_by_clause )

SELECT t.*
FROM (
        SELECT deptno, ename, sal + NVL(comm,0) pay
             , ROW_NUMBER() OVER( ORDER BY sal + NVL(comm,0) DESC ) 순위
        FROM emp
    ) t
WHERE 순위 BETWEEN 3 AND 5;
WHERE 순위 <= 3;

[문제] 각 부서별로 최고 급여를 받는 사원 1명을 조회
SELECT t.*
FROM (
        SELECT buseo, name, basicpay + sudang pay
             , ROW_NUMBER() OVER( PARTITION BY buseo ORDER BY basicpay + sudang DESC ) 순위
        FROM insa
    ) t
WHERE 순위 <= 3;
-------------------------------------------------------------------------------
-- DENSE_RANK
그룹 내에서 차례로 된 행의 rank를 계산하여 NUMBER 데이터타입으로 순위를 반환한다.
해당 값에 대한 우선순위를 결정(중복 순위 계산 안함) 
【Aggregate 형식】
      DENSE_RANK ( expr[,expr,...] ) WITHIN GROUP
        (ORDER BY expr [[DESC ? ASC] [NULLS {FIRST ? LAST} , expr,...] )
   

【Analytic 형식】
      DENSE_RANK ( ) OBER ([query_partion_clause] order_by_clause )

-- RANK
이 함수는 그룹 내에서 위치를 계산하여 반환한다.
해당 값에 대한 우선순위를 결정(중복 순위 계산함)

반환되는 데이터타입은 NUMBER이다.


【Aggregate 형식】
        RANK(expr[,...]) WITHIN GROUP
            (ORDER BY {expr [DESC ? ASC] [NULLS {FIRST ? LAST}]
                      } )

【Analytic 형식】
	RANK() OVER( [query_partition_clause] order_by_clause
                   ) 

-- ROW_NUMBER

-------------------------------------------------------------------------------
SELECT empno, ename, sal
     , RANK() OVER( ORDER BY sal DESC ) rank -- 중복 순위 계산 O
     , DENSE_RANK() OVER( ORDER BY sal DESC ) dense_rank -- 중복 순위 계산 X    DENSE == 밀집한
     , ROW_NUMBER() OVER( ORDER BY sal DESC ) row_number
FROM emp;

7654	MARTIN	1250	9	9	9
7521	WARD	1250	9	9	10
7900	JAMES	950	    11	10	11
-------------------------------------------------------------------------------
SELECT deptno, empno, ename, sal
     , RANK() OVER( PARTITION BY deptno ORDER BY sal DESC ) rank -- 중복 순위 계산 O
     , DENSE_RANK() OVER( PARTITION BY deptno ORDER BY sal DESC ) dense_rank -- 중복 순위 계산 X    DENSE == 밀집한
     , ROW_NUMBER() OVER( PARTITION BY deptno ORDER BY sal DESC ) row_number
FROM emp;
-------------------------------------------------------------------------------
[참고] 자바에서처럼 등수 처리
      한명 초점 -> 등수를 1등씩 증가

SELECT deptno, ename, sal
     , ( SELECT COUNT(*) FROM emp b WHERE b.sal > a.sal ) + 1 순위
FROM emp a;
-------------------------------------------------------------------------------
[문제] emp 테이블에서 sal가 상위 20% 사원 정보 조회
















