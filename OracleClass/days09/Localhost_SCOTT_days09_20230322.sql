-- SCOTT --
-------------------------------------------------------------------------------
1. emp , salgrade 테이블을 사용해서 아래와 같이 출력. [JOIN] 사용

-- JOIN(조인) == 결합
-- 정의 : 같거나 다른 2개 이상의 테이블 결합 -> 컬럼 조회(검색)
-- 조인 종류 : 8가지
-- ㄴ EQUI JOIN : 부PK - 자FK
-- ㄴ NON EQUI JOIN : 관계 X

SELECT e.ename, e.sal, s.losal || ' ~ ' || s.hisal range, s.grade
FROM emp e, salgrade s
WHERE e.sal BETWEEN s.losal AND s.hisal;
-- JOIN ~ ON 구문
SELECT e.ename, e.sal, s.losal || ' ~ ' || s.hisal range, s.grade
FROM emp e JOIN salgrade s ON e.sal BETWEEN s.losal AND s.hisal;
-- CASE 함수
SELECT ename, sal
     , CASE
        WHEN sal BETWEEN 700 AND 1200 THEN 1
        WHEN sal BETWEEN 1201 AND 1400 THEN 2
        WHEN sal BETWEEN 1401 AND 2000 THEN 3
        WHEN sal BETWEEN 2001 AND 3000 THEN 4
        WHEN sal BETWEEN 3001 AND 9999 THEN 5
       END grade
FROM emp;

    ename   sal    grade
    ---------------------
    SMITH   800       1
    ALLEN   1900   3
    WARD   1750   3
    JONES   2975   4
    MARTIN   2650   4
    BLAKE   2850   4
    CLARK   2450   4
    KING   5000   5
    TURNER   1500   3
    JAMES   950   1
    FORD   3000   4
    MILLER   1300   2

[문제] deptno, dname, ename, hiredate, sal, grade 컬럼 조회

dept : [deptno(PK)], dname
emp : [deptno(FK)], ename, hiredate, sal
salgrade : grade

SELECT d.deptno, dname, ename, hiredate, sal, grade
FROM dept d, emp e, salgrade s
WHERE d.deptno = e.deptno AND e.sal BETWEEN s.losal AND s.hisal;
-- JOIN ~ ON 구문
SELECT d.deptno, dname, ename, hiredate, sal, grade
FROM dept d JOIN emp e ON d.deptno = e.deptno
            JOIN salgrade s ON e.sal BETWEEN s.losal AND s.hisal;
    
1-2. 위의 결과에서 등급(grade)가 1등급인 사원만 조회하는 쿼리 작성  

SELECT empno, ename, sal, grade
FROM emp e JOIN salgrade s ON sal BETWEEN losal AND hisal
WHERE grade = 1;

결과)
     EMPNO ENAME             SAL      GRADE
---------- ---------- ---------- ----------
      7369 SMITH             800          1
      7900 JAMES             950          1      
      
2. emp 에서 최고급여를 받는 사원의 정보 출력 ( JOIN ~ ON 구문 )
  ( 조건 : 아래 컬럼 출력 )
  
JOIN 조건 : EQUI JOIN dept.deptno(PK) = emp.deptno(FK)
           INNER JOIN
-- 부서 null 조회 안됨
SELECT dname, ename, sal+NVL(comm,0) pay
FROM dept d, emp e
WHERE d.deptno(+) = e.deptno -- RIGHT OUTER JOIN(외부 조인)
    AND sal+NVL(comm,0) = ( SELECT MAX( sal+NVL(comm,0) ) FROM emp );
-- JOIN ~ ON 구문
SELECT dname, ename, sal+NVL(comm,0) pay
FROM dept d RIGHT OUTER JOIN emp e ON d.deptno = e.deptno
WHERE sal+NVL(comm,0) = ( SELECT MAX( sal+NVL(comm,0) ) FROM emp );

[문제] RANK()
[문제] DENSE_RANK()
[문제] ROW_NUMBER()

WITH
    temp AS (
                SELECT dname, ename, sal+NVL(comm,0) pay
                     , RANK() OVER( ORDER BY sal+NVL(comm,0) DESC ) r
                     , DENSE_RANK() OVER( ORDER BY sal+NVL(comm,0) DESC ) dr
                     , ROW_NUMBER() OVER( ORDER BY sal+NVL(comm,0) DESC ) rn
FROM dept d RIGHT OUTER JOIN emp e ON d.deptno = e.deptno
    )
SELECT t.*
FROM temp t
WHERE t.r = 1;
WHERE t.dr = 1;
WHERE t.rn = 1;

[문제] TOP-N 방식
SELECT t.*, ROWNUM 순번
FROM (
        SELECT dname, ename, sal+NVL(comm,0) pay
        FROM dept d RIGHT OUTER JOIN emp e ON d.deptno = e.deptno
        ORDER BY pay DESC
    ) t
WHERE ROWNUM = 1;
    
DNAME          ENAME             PAY
-------------- ---------- ----------
ACCOUNTING     KING             5000

2-2. emp 에서 각 부서별 최고급여를 받는 사원의 정보 출력 ( JOIN )

1) 상관 서브 쿼리
SELECT d.deptno, dname, ename, sal+NVL(comm,0) pay
FROM dept d FULL JOIN emp e ON d.deptno = e.deptno
WHERE sal+NVL(comm,0) = ( -- 해당 부서의 최고 급여액
    SELECT MAX( sal+NVL(comm,0) )
    FROM emp
    WHERE deptno = d.deptno
    );

2)
-- 문제점)
SELECT d.deptno, dname, ename, sal+NVL(comm,0) pay
FROM emp e JOIN dept d ON e.deptno = d.deptno
WHERE sal+NVL(comm,0) IN (
        SELECT MAX( sal+NVL(comm,0) ) max_pay
        FROM emp
        GROUP BY deptno
    );
    
3) 순위 함수
SELECT t.*
FROM (
        SELECT d.deptno, dname, ename, sal+NVL(comm,0) pay
             , ROW_NUMBER() OVER( PARTITION BY d.deptno ORDER BY NVL( sal+NVL(comm,0), 0 ) DESC) "순위"
        FROM dept d FULL JOIN emp e ON d.deptno = e.deptno
    ) t
WHERE 순위 <= 1;

    DEPTNO DNAME          ENAME             PAY
---------- -------------- ---------- ----------
        10 ACCOUNTING     KING             5000
        20 RESEARCH       FORD             3000
        30 SALES          BLAKE            2850

[문제] emp 테이블에서 sal 가 상위 20% 사원정보 조회
-- 총 사원수 12명
-- 20% : 2.4명
SELECT t.*
FROM (
    SELECT emp.*
         , RANK() OVER( ORDER BY sal DESC ) "순위"
    FROM emp
    ) t
WHERE t.순위 <= ( SELECT COUNT(*) FROM emp ) * 0.2;
--
[순위 함수] RANK(), DENSE_RANK(), ROW_NUMBER(), TOP-N 방식
- PERCENT_RANK 함수
    ㄴ CUME_DIST 함수와 유사
    ㄴ percent 값을 반환
【aggregate 형식】
      PERCENT_RANK(expr,...) WITHIN GROUP 
        (ORDER BY expr { [DESC ? ASC]
                         [NULLS {FIRST ? LAST}]
                       },...)
또는 
【Analytic 형식】
       PERCENT_RANK() OVER ( 
                             [query_partition_clause]
                              order_by_clause
                            )

SELECT deptno, ename, sal
     , PERCENT_RANK() OVER( ORDER BY sal DESC ) "순위"
FROM emp;

SELECT buseo, name, basipay
     , PERCENT_RANK() OVER( ORDER BY basicpay DESC ) "순위"
FROM insa;

-- CUME_DIST
--  ㄴ 그룹 값 내에서 어떤 값의 cumulative distribution(누적분포)을 계산한다

-- NTILE(n) 엔타일 : 전체 데이터 분ㅍ노를 n-Buckets로 나누어 표시
--  ㄴ 분석(analytic) 함수
--  ㄴ 출력 결과를 사용자가 지정한 그룹 수로 나누어 출력하는 함수
【형식】
	NTILE ( expr )
          OVER (
	        [query_partition_clause]
	        order_by_clause
	  )

[문제] emp 테이블에서 급여를 기준으로 상/중/하(3그룹)로 구분
WITH
    temp AS (
SELECT ename, sal+NVL(comm,0) pay
     , NTILE(3) OVER( ORDER BY sal+NVL(comm,0) DESC ) "그룹"
FROM emp
    )
SELECT t.*
     , DECODE( 그룹, 1, '상', 2, '중', 3, '하' ) d
     , CASE 그룹
        WHEN 1 THEN '상'
        WHEN 2 THEN '중'
        WHEN 3 THEN '하'
       END c1
     , CASE
        WHEN 그룹 = 1 THEN '상'
        WHEN 그룹 = 2 THEN '중'
        WHEN 그룹 = 3 THEN '하'
       END c2
FROM temp t;
-- FIRST_CALUE : 현재 행까지 값 중에서 첫번째 값
-- LAST_VALUE : 현재 행까지 값 중에서 마지막 값

SELECT ename, hiredate
     , FIRST_VALUE( hiredate ) OVER( ORDER BY hiredate DESC )
     , LAST_VALUE( hiredate ) OVER( ORDER BY hiredate DESC )
FROM emp;

3. emp 에서 각 사원의 급여가 전체급여의 몇 %가 되는 지 조회.
       ( %   소수점 3자리에서 반올림하세요 )
            무조건 소수점 2자리까지는 출력.. 7.00%,  3.50%     
WITH
    temp AS (
        SELECT ename, sal+NVL(comm,0) pay, ( SELECT SUM( sal+NVL(comm,0) ) FROM emp ) totalpay
        FROM emp
    )
SELECT t.*, TO_CHAR( ROUND( pay/totalpay*100, 2 ), '99.00' ) || '%' "비율"
FROM temp t;
--
SELECT t.*, TO_CHAR( ROUND( pay/totalpay*100, 2 ), '99.00' ) || '%' "비율"
FROM (
        SELECT ename, sal+NVL(comm,0) pay, ( SELECT SUM( sal+NVL(comm,0) ) FROM emp ) totalpay
        FROM emp
    ) t;

ENAME             PAY   TOTALPAY 비율     
---------- ---------- ---------- -------
SMITH             800      27125   2.95%
ALLEN            1900      27125   7.00%
WARD             1750      27125   6.45%
JONES            2975      27125  10.97%
MARTIN           2650      27125   9.77%
BLAKE            2850      27125  10.51%
CLARK            2450      27125   9.03%
KING             5000      27125  18.43%
TURNER           1500      27125   5.53%
JAMES             950      27125   3.50%
FORD             3000      27125  11.06%
MILLER           1300      27125   4.79%

12개 행이 선택되었습니다.         
        
4. emp 에서 가장 빨리 입사한 사원 과 가장 늦게(최근) 입사한 사원의 차이 일수 ?         

SELECT ABS( MAX( hiredate ) - MIN( hiredate ) )
FROM emp;
        
5. insa 에서 사원들의 만나이 계산해서 출력
  ( 만나이 = 올해년도 - 출생년도          - 1( 생일이지나지 않으면) )
ㄱ. 올해년도
ㄴ. ssn -> 4자리 생일년도
ㄷ. 생일 전/후 체크
;
SELECT t.name, t.ssn
     , ㄱ - ㄴ + 1 counting_age
     , ㄱ - ㄴ + DECODE( ㄷ, -1, -1, 0 ) american_age
FROM (
SELECT name, ssn
     , TO_CHAR( SYSDATE, 'YYYY' ) ㄱ
--   , TO_CHAR( TO_DATE( SUBSTR( ssn, 0, 2 ), 'RR' ), 'YYYY' ) ㄴ
     , SUBSTR( ssn, 0, 2 ) + CASE
        WHEN SUBSTR( ssn, -7, 1 ) IN (1,2,5,6) THEN 1900
        WHEN SUBSTR( ssn, -7, 1 ) IN (3,4,7,8) THEN 2000
        WHEN SUBSTR( ssn, -7, 1 ) IN (9,0) THEN 1800
       END ㄴ
     , SIGN( TO_CHAR( SYSDATE, 'MMDD' ) - SUBSTR( ssn, 3, 4 ) ) ㄷ
FROM insa
    ) t;
  
6. insa 테이블에서 아래와 같이 결과가 나오게 ..

SELECT COUNT(*) 총사원수
     , COUNT( DECODE( MOD( SUBSTR( ssn, -7, 1 ), 2 ), 1, 'O' ) ) 남자사원수
     , COUNT( DECODE( MOD( SUBSTR( ssn, -7, 1 ), 2 ), 0, 'O' ) ) 여자사원수
     , TO_CHAR( SUM( DECODE( MOD( SUBSTR( ssn, -7, 1 ), 2 ), 1, basicpay + sudang ) ), 'L9,999,999,999' ) 남자총급여합
     , SUM( DECODE( MOD( SUBSTR( ssn, -7, 1 ), 2 ), 0, basicpay + sudang ) ) 여자총급여합
     , TO_CHAR( MAX( DECODE( MOD( SUBSTR( ssn, -7, 1 ), 2 ), 1, basicpay + sudang ) ), 'L9,999,999,999' ) 남자MAX급여
     , MAX( DECODE( MOD( SUBSTR( ssn, -7, 1 ), 2 ), 0, basicpay + sudang ) ) 여자MAX급여
FROM insa;

     [총사원수]      [남자사원수]      [여자사원수] [남사원들의 총급여합]  [여사원들의 총급여합] [남자-max(급여)] [여자-max(급여)]
---------- ---------- ---------- ---------- ---------- ---------- ----------
        60                31              29           51961200                41430400                  2650000          2550000
      
7. TOP-N 방식으로 풀기 ( ROWNUM 의사 컬럼 사용 )
   emp 에서 최고급여를 받는 사원의 정보 출력  

1) 정렬
2) ROWNUM 의사컬럼 - 순위
3) WHERE 조회

SELECT ROWNUM, t.*
FROM (
SELECT deptno, ename, sal+NVL(comm,0) pay
FROM emp
ORDER BY pay DESC
    ) t
WHERE ROWNUM = 1;

    DEPTNO ENAME             PAY   PAY_RANK
---------- ---------- ---------- ----------
        10 KING             5000          1
        
        
8.순위(RANK) 함수 사용해서 풀기 
   emp 에서 각 부서별 최고급여를 받는 사원의 정보 출력

1) RANK 함수
SELECT t.*
FROM (
SELECT deptno, ename, sal+NVL(comm,0) pay
     , RANK() OVER( PARTITION BY deptno ORDER BY sal+NVL(comm,0) DESC ) deptno_rank
FROM emp
    ) t
WHERE deptno_rank = 1;

2) JOIN 사용
SELECT a.deptno, b.ename, a.max_pay, 1 deptno_rank
FROM (
    SELECT deptno, MAX( sal+NVL(comm,0) ) max_pay
    FROM emp
    GROUP BY deptno
    ) a JOIN emp b ON a.deptno = b.deptno
WHERE a.max_pay = b.sal+NVL(b.comm,0);

    DEPTNO ENAME             PAY DEPTNO_RANK
---------- ---------- ---------- -----------
        10 KING             5000           1
        20 FORD             3000           1
        30 BLAKE            2850           1
   
9. emp테이블에서 각 부서의 사원수, 부서총급여합, 부서평균을 아래와 같이 출력하는 쿼리 작성.
결과)

SELECT deptno
     , COUNT(*) 부서원수
     , SUM( sal+NVL(comm,0) ) 총급여합
     , TO_CHAR( ROUND( AVG( sal+NVL(comm,0) ), 2 ), '9999.00' ) 평균
FROM emp
GROUP BY deptno
ORDER BY deptno;

    DEPTNO       부서원수       총급여합            평균
---------- ----------       ----------    ----------
        10          3          8750       2916.67
        20          3          6775       2258.33
        30          6         11600       1933.33      
         
10-1.  emp 테이블에서 30번인 부서의 최고, 최저 SAL을 출력하는 쿼리 작성.
결과)

SELECT MIN(sal), MAX(sal)
FROM emp
WHERE deptno = 30;

  MIN(SAL)   MAX(SAL)
---------- ----------
       950       2850

[문제] 각 부서의 MAX(sal), MIN(sal) 조회

SELECT deptno, MAX(sal), MIN(sal)
FROM emp
GROUP BY deptno
ORDER BY deptno;

10-2.  emp 테이블에서 30번인 부서의 최고, 최저 SAL를 받는 사원의 정보 출력하는 쿼리 작성.

SELECT empno, ename, hiredate, sal
FROM emp
WHERE deptno = 30 AND sal = ( SELECT MAX(sal) FROM emp WHERE deptno = 30 )
UNION ALL
SELECT empno, ename, hiredate, sal
FROM emp
WHERE deptno = 30 AND sal = ( SELECT MIN(sal) FROM emp WHERE deptno = 30 );
--
SELECT empno, ename, hiredate, sal
FROM emp
WHERE deptno = 30 AND sal IN (
    ( SELECT MAX(sal) FROM emp WHERE deptno = 30 )
  , ( SELECT MIN(sal) FROM emp WHERE deptno = 30 )
);
--
SELECT empno, ename, hiredate, sal
FROM (
    SELECT MAX(sal) max_sal, MIN(sal) min_sal
    FROM emp
    WHERE deptno = 30
    ) a, emp b
WHERE b.deptno = 30 AND b.sal = a.max_sal OR b.sal = a.min_sal;

결과)
     EMPNO ENAME      HIREDATE        SAL
---------- ---------- -------- ----------
      7698 BLAKE      81/05/01       2850
      7900 JAMES      81/12/03        950      
      
11.  insa 테이블에서 
1) 총사원수
SELECT COUNT(*)
FROM insa;

2) 부서사원수
SELECT buseo, COUNT(*) 부서사원수
FROM insa
GROUP BY buseo;

3) 부서별, 성별, 사원수
SELECT buseo, MOD( SUBSTR( ssn, -7, 1 ), 2 ), COUNT(*)
FROM insa
GROUP BY buseo, MOD( SUBSTR( ssn, -7, 1 ), 2 )
ORDER BY buseo, MOD( SUBSTR( ssn, -7, 1 ), 2 );
--
SELECT t2.*
     , ROUND( t2.부서사원수/t2.총사원수*100, 2 ) || '%' "부/전%"
     , ROUND( t2.성별사원수/t2.총사원수*100, 2 ) || '%' "부성/전%"
     , ROUND( t2.성별사원수/t2.부서사원수*100, 2 ) || '%' "성/부%"
FROM (
    SELECT t.buseo "부서명"
         , ( SELECT COUNT(*) FROM insa ) "총사원수"
         , ( SELECT COUNT(*) FROM insa WHERE buseo = t.buseo ) "부서사원수"
         , t.gender "성별", COUNT(*) "성별사원수"
    FROM (
        SELECT buseo
             , DECODE( MOD( SUBSTR( ssn, -7, 1 ), 2 ), 1, 'M', 'F' ) gender
        FROM insa
        ) t
    GROUP BY t.buseo, t.gender
    ORDER BY t.buseo, t.gender
    ) t2;

[실행결과]
부서명     총사원수 부서사원수     성별  성별사원수  부/전%   부성/전%      성/부%
개발부       60       14         F       8       23.3%     13.3%      57.1%
개발부       60       14         M       6       23.3%     10%        42.9%
기획부       60       7          F       3       11.7%     5%         42.9%
기획부       60       7          M       4       11.7%     6.7%       57.1%
영업부       60       16         F       8       26.7%     13.3%      50%
영업부       60       16         M       8       26.7%     13.3%      50%
인사부       60       4          M       4       6.7%      6.7%       100%
자재부       60       6          F       4       10%       6.7%       66.7%
자재부       60       6          M       2       10%       3.3%       33.3%
총무부       60       7          F       3       11.7%     5%         42.9%
총무부       60       7          M       4       11.7%     6.7%       57.1%
홍보부       60       6          F       3       10%       5%         50%
홍보부       60       6          M       3       10%       5%         50%             


12. insa테이블에서 여자인원수가 5명 이상인 부서만 출력.  

1)
SELECT t.*
FROM (
    SELECT buseo, COUNT(*) 여자사원수
    FROM insa
    WHERE MOD( SUBSTR( ssn, -7, 1 ), 2 ) = 0
    GROUP BY buseo
    ) t
WHERE t.여자사원수 >= 5;

2) GROUP BY 절의 조건절이 HAVING 절 사용
SELECT buseo, COUNT(*) 여자사원수
FROM insa
WHERE MOD( SUBSTR( ssn, -7, 1 ), 2 ) = 0
GROUP BY buseo
HAVING COUNT(*) >= 5;

13. insa 테이블에서 급여(pay= basicpay+sudang)가 상위 15%에 해당되는 사원들 정보 출력 

1) 급여 순위
2) 총사원수

SELECT t.*
FROM (
SELECT buseo, name, basicpay+sudang pay
     , RANK() OVER( ORDER BY basicpay+sudang DESC ) "급여순위"
FROM insa
    ) t
WHERE 급여순위 <= ( SELECT COUNT(*) FROM insa )*0.15;

14. emp 테이블에서 sal의 전체사원에서의 등수 , 부서내에서의 등수를 출력하는 쿼리 작성

SELECT deptno, ename, sal
     , RANK() OVER( ORDER BY sal DESC ) "전체등수"
     , RANK() OVER( PARTITION BY deptno ORDER BY sal DESC ) "부서등수"
     , ( SELECT COUNT(*)+1 FROM emp b WHERE b.sal > a.sal ) "전체등수"
     , ( SELECT COUNT(*)+1 FROM emp b WHERE b.sal > a.sal AND b.deptno = a.deptno ) "부서등수"
FROM emp a
ORDER BY deptno ASC;
-------------------------------------------------------------------------------
-- GROUP BY + HAVING 절 --
1) 각 부서의 사원수 조회
SELECT COUNT(*) "총사원수"
     , COUNT( DECODE( deptno, 10, 'O' ) ) "10 사원수"
     , COUNT( DECODE( deptno, 20, 'O' ) ) "20 사원수"
     , COUNT( DECODE( deptno, 30, 'O' ) ) "30 사원수"
     , COUNT( DECODE( deptno, 40, 'O' ) ) "40 사원수"
FROM emp;
2) -- 아쉬운점) "총사원수" 출력 불가 -> ROLLUP, CUBE
   -- 아쉬운점) deptno 40 - 0 -> JOIN
SELECT d.deptno, COUNT(ename) "사원수"
FROM emp e FULL OUTER JOIN dept d ON e.deptno = d.deptno
GROUP BY d.deptno
ORDER BY d.deptno ASC;
3) -- LEFT OUTER JOIN
SELECT d.deptno, COUNT(ename) "사원수"
FROM emp e, dept d
WHERE e.deptno = d.deptno(+)
GROUP BY d.deptno
ORDER BY d.deptno ASC;

4) 20번, 40번 부서는 제외시키고 조회
    부서 사원수가 3명 이상인 부서정보만 출력

SELECT deptno, COUNT(*)
FROM emp
WHERE deptno NOT IN (20,40)
GROUP BY deptno
HAVING COUNT(*) >= 3;

5) 컬럼 : deptno, [dname], COUNT(*)
-- ORA-00979: not a GROUP BY expression
SELECT d.deptno, d.dname, COUNT(*)
FROM emp e JOIN dept d ON e.deptno = d.deptno
WHERE d.deptno NOT IN (20,40)
GROUP BY d.deptno, d.dname
HAVING COUNT(*) >= 3;
--
SELECT buseo, jikwi, COUNT(*)
FROM insa
GROUP BY buseo, jikwi
ORDER BY buseo, jikwi;
-- 위아래 JOIN
SELECT DISTINCT jikwi
FROM insa









































