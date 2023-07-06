-- SCOTT --
1. emp 테이블에서 30번 부서만 PAY를 계산 후 막대그래프를 아래와 같이 그리는 쿼리 작성
   ( 필요한 부분은 결과 분석하세요~    PAY가 100 단위당 # 한개 , 반올림처리 )

SELECT deptno, ename, sal+NVL(comm,0) pay, ROUND( (sal+NVL(comm,0))/100 ) bar_length, RPAD( ' ',  ROUND( (sal+NVL(comm,0))/100 )+1, '#' ) " "
FROM emp
WHERE deptno = 30
ORDER BY bar_length DESC;
   
[실행결과]
DEPTNO ENAME PAY BAR_LENGTH      
---------- ---------- ---------- ----------
30	BLAKE	2850	29	 #############################
30	MARTIN	2650	27	 ###########################
30	ALLEN	1900	19	 ###################
30	WARD	1750	18	 ##################
30	TURNER	1500	15	 ###############
30	JAMES	950	    10	 ##########

1-2. insa 테이블에서 주민등록번호를 123456-1******  형식으로 출력하세요 . 
( LPAD, RPAD 함수 사용  )

SELECT name, ssn, RPAD( SUBSTR( ssn, 1, 8), 14, '*' ) ssn_rpad, LPAD( '******', 14, ssn ) ssn_lpad
FROM insa;

[실행결과]
홍길동	770423-1022432	770423-1******
이순신	800423-1544236	800423-1******
이순애	770922-2312547	770922-2******

2. SELECT TRUNC( SYSDATE, 'YEAR' ) -- 23/01/01 : 현재 날짜 기준 년도 밑으로 절삭해서 1월 1일
      , TRUNC( SYSDATE, 'MONTH' ) -- 23/03/01 : 현재 날짜 기준 월 밑으로 절삭해서 3월 1일
      , TRUNC( SYSDATE ) -- 23/03/20 : 가장 근접한 날로 절삭해서 날짜 그대로
    FROM dual;
    위의 쿼리의 결과를 적으세요 . 

3. emp 에서 평균PAY 보다 같거나 큰 사원들만의 급여합을 출력.

SELECT t.*
FROM (
        SELECT ename name, sal, comm, sal+NVL(comm,0) pay, ROUND( (SELECT AVG( sal+NVL(comm,0) ) FROM emp), 5 ) avg_pay
        FROM emp
    ) t
WHERE pay >= avg_pay;
--
SELECT ROUND( AVG( sal + NVL(comm,0) ), 5 ) avg_pay
     , ROUND( SUM( sal + NVL(comm,0) / COUNT( * ), 5 ) avg_pay
FROM emp;
--
-- ORA-00937: not a single-group group function
-- 단일행 함수와 복수행 함수를 동시에 사용할 수 없다
-- 복수행 함수 -> 서브쿼리
WITH
 temp AS (
    SELECT ename name, sal, comm, sal+NVL(comm,0) pay
--   , ROUND( AVG( sal+NVL(comm,0) ), 5 ) avg_pay
     , ROUND( (SELECT AVG( sal+NVL(comm,0) ) FROM emp), 5 ) avg_pay
    FROM emp
        )
SELECT t.*
FROM temp t
WHERE t.pay >= t.avg_pay;

[실행결과]
NAME             SAL       COMM        PAY    AVG_PAY
---------- ---------- ---------- ---------- ----------
JONES            2975                  2975 2260.41667
MARTIN           1250       1400       2650 2260.41667
BLAKE            2850                  2850 2260.41667
CLARK            2450                  2450 2260.41667
KING             5000                  5000 2260.41667
FORD             3000                  3000 2260.41667

4. emp 테이블에서 각 부서별 급여를 가장 많이 받는 사원의 pay를 출력

SELECT a.*, a.sal + NVL(a.comm,0) pay
FROM emp a
WHERE a.sal + NVL(a.comm,0) = (
                                    SELECT MAX( b.sal + NVL(b.comm,0) ) max_pay_dept
                                    FROM emp b
                                    WHERE b.deptno = a.deptno
                                )
ORDER BY deptno;
--
순위( RANK ) 함수 / TOP-N 방식

5. 이번 달이  몇일 까지 있는 지 출력하세요. 

SELECT TO_CHAR( LAST_DAY( SYSDATE ), 'DD' ) this_month_lastday
     , TO_CHAR( TRUNC( ADD_MONTHS( SYSDATE, 1 ), 'MONTH' ) - 1, 'DD' ) this_month_lastday_2
FROM dual;

6. 다음 주 월요일은 휴강일이다.. 몇 일인가요 ? 

SELECT NEXT_DAY( SYSDATE, '월요일' ) 휴강일
FROM dual;

7. emp 테이블에서
   각 사원들의 입사일자를 기준으로 10년 5개월 20일째 되는 날 ? 

SELECT hiredate, ADD_MONTHS( hiredate, 125 ) + 20 add_mont
FROM emp;

    [실행결과]
        HIREDATE ADD_MONT
        -------- --------
        80/12/17 91/06/06
        81/02/20 91/08/12
        81/02/22 91/08/14
        81/04/02 91/09/22
        81/09/28 92/03/18
        81/05/01 91/10/21
        81/06/09 91/11/29
        81/11/17 92/05/07
        81/09/08 92/02/28
        81/12/03 92/05/23
        81/12/03 92/05/23 
        82/01/23 92/07/12
        
        12개 행이 선택되었습니다.

8.  insa 테이블에서
    사원번호(num) 가  1002 인 사원의 주민번호의 월,일만을 오늘날짜로 수정하세요.
                              ssn = '80XXXX-1544236'                              

UPDATE insa
SET ssn = REPLACE( ssn, SUBSTR( ssn, 3, 4 ), TO_CHAR( SYSDATE, 'MMDD' ) )
WHERE num = 1002;
COMMIT;

8-2. insa 테이블에서 오늘을 기준으로 생일이 지남 여부를 출력하는 쿼리를 작성하세요 . 
     ( '지났다', '안지났다', '오늘 ' 처리 )
     
SELECT num, name, ssn
     , SUBSTR( ssn, 3, 4 )
     , TO_CHAR( SYSDATE, 'MMDD' )
     , SIGN( SUBSTR( ssn, 3, 4 ) - TO_CHAR( SYSDATE, 'MMDD' ) ) s
FROM insa;

9. 함수 설명
    9-1. NULLIF() 함수 설명
    9-2. COALESCE() 함수 설명
    9-3. DECODE() 함수 설명
    9-4. LAST_DAY() 함수 설명
    9-5. ADD_MONTHS() 함수 설명
    9-6. MONTHS_BETWEEN() 함수 설명
    9-7. NEXT_DAY() 함수 설명
    9-8. EXTRACT() 함수 설명
    
     ㄱ. ASCII() 함수 설명
     ㄴ. CHR() 함수 설명
     ㄷ. GREATEST() 함수 설명
     ㄹ. LEAST() 함수 설명
     ㅁ. UPPER() 함수 설명
     ㅂ. LOWER() 함수 설명
     ㅅ. LENGTH() 함수 설명
     ㅇ. SUBSTR() 함수 설명
     ㅈ. INSTR() 함수 설명   

10.  emp 테이블의 ename, pay , 최대pay값 5000을 100%로 계산해서
   각 사원의 pay를 백분률로 계산해서 10% 당 별하나(*)로 처리해서 출력
   ( 소숫점 첫 째 자리에서 반올림해서 출력 )

SELECT t.*
     , (t.pay*100)/t.max_pay || '%' percent
     , ROUND( (t.pay*100)/t.max_pay/10 ) star_count
     , RPAD ( ' ', ROUND( (t.pay*100)/t.max_pay/10 )+1, '*' ) " "
FROM (
SELECT ename, sal + NVL(comm,0) pay
     , ( SELECT MAX( sal + NVL(comm,0) ) max_pay FROM emp ) max_pay
FROM emp
    ) t;

[실행결과]
ename   pay     max_pay 퍼센트    별갯수
SMITH	800	    5000	16%	2	 **
ALLEN	1900	5000	38%	4	 ****
WARD	1750	5000	35%	4	 ****
JONES	2975	5000	59.5%	6	 ******
MARTIN	2650	5000	53%	5	 *****
BLAKE	2850	5000	57%	6	 ******
CLARK	2450	5000	49%	5	 *****
KING	5000	5000	100%	10	 **********
TURNER	1500	5000	30%	3	 ***
JAMES	950	    5000	19%	2	 **
FORD	3000	5000	60%	6	 ******
MILLER	1300	5000	26%	3	 ***
-------------------------------------------------------------------------------
SELECT SYSDATE
     , CURRENT_DATE
     , CURRENT_TIMESTAMP
     , EXTRACT( TEAR FROM SYSDATE )
FROM dual;

-- TO_CHAR ( 숫자 또는 날짜 ) -> 문자 변환함수
-- TO_TIMESTAMP( 문자 ) -> 날짜( TIMESTAMP ) 변환함수
-- TO_DATE( 문자 ) -> 날짜( DATE ) 변환함수
오라클 날짜 자료형 : DATE, TIMESTAMP

SELECT to_timestamp('2004-8-20 1:30:00', 'YYYY-MM-DD HH:MI:SS')
FROM dual;

-- [ 변환 함수의 종류 ]
1) TO_NUMBER() : 문자 -> 숫자로 변환하는 함수
2) TO_CHAR( 숫자 ) : 숫자 -> 문자로 변환하는 함수
   TO_CHAR( 날짜 ) : 날짜 -> 문자로 변환하는 함수
3) TO_DATE( 문자 ) : 문자 -> 날짜로 변환하는 함수

4) CONVERT : 문자를 한 국가 형식 -> 다른 국가 형식으로 변환
5) HEXTORAW : 16진수 문자 -> 2진수 문자로 변환

-- 오라클 문자, 날짜는 '' 붙인다
-- 오라클 문자(열) 자료형 : CHAR, VARCHAR2, NCHAR, NVARCHAR2 

-- 1) TO_NUMBER() : 문자 -> 숫자로 변환하는 함수
SELECT '12' "문자열 12", 12 "숫자 12"
     , '12' - 12 -- 자동으로 숫자 12로 형변환
     , TO_NUMBER( '12' ) - 12
     , 12 - 12
FROM dual;
     
-- 2-1) TO_CHAR( 숫자 ) : 숫자 -> 문자로 변환하는 함수
【형식】
      TO_CHAR( n [,'fmt' [,'nlsparam']])
--
SELECT 12345
     , TO_CHAR( 12345 ) ㄱ -- '12345'
     , TO_CHAR( 12345, '99,999' ) ㄴ -- , : 세자리마다 콤마 찍어서 출력 '12,345'
     , TO_CHAR( 12345, '99,999.00' ) ㄷ -- . : 명시한 위치에 소수점, 0 : 공백을 0으로 표시 '12,345.00'
     , TO_CHAR( 12345, 'L99,999' ) ㄹ -- L : 화폐기호 '￦12,345'
     , TO_CHAR( 12345, 'S99,999' ) ㅁ -- S : +/- 부호 '+12,345'
FROM dual;
--
SELECT ename, sal, comm
     , TO_CHAR( sal + NVL(comm,0)*12, '$99,999.99' ) 연봉
FROM emp
WHERE comm IS NOT NULL;

-- 2-2) TO_CHAR( 날짜 ) : 날짜 -> 문자로 변환하는 함수
【형식】
 	TO_CHAR( date [,'fmt' [,'nlsparam']])
--
-- [ YY와 RR의 차이점 ]
-- YY : 두 자리의 년도 : 무조건 시스템 상의 년도를 붙인다
--      [20]65/01/02
--      [20]12/02/24
-- RR : 두 자리의 년도 : 50~99 지난 년도, 00~49 지금 년도
--      [19]65/01/02
--      [20]12/02/24

-- 날짜형식 : RR/MM/DD

SELECT ename, hiredate
FROM emp;
--      RR/MM/DD
SMITH	80/12/17
ALLEN	81/02/20
WARD	81/02/22
JONES	81/04/02
--
SELECT SYSDATE
     , TO_CHAR( SYSDATE, 'YYYY' ) a
     , TO_CHAR( SYSDATE, 'YY' ) a
     , TO_CHAR( SYSDATE, 'RRRR' ) a
     , TO_CHAR( SYSDATE, 'RR' ) a
     
     , TO_CHAR( SYSDATE, 'MM' ) b
     , TO_CHAR( SYSDATE, 'MONTH' ) b
     , TO_CHAR( SYSDATE, 'MON' ) b
     
     , TO_CHAR( SYSDATE, 'DD' ) c -- 달의 일
     , TO_CHAR( SYSDATE, 'D' ) c -- 주의 일
     , TO_CHAR( SYSDATE, 'DDD' ) c -- 년의 일
     
     , TO_CHAR( SYSDATE, 'MMDD' ) d
     , TO_CHAR( SYSDATE, 'BC' ) e -- BC/AD
     , TO_CHAR( SYSDATE, 'Q' ) f -- 분기
     
     , TO_CHAR( SYSDATE, 'HH' ) g
     , TO_CHAR( SYSDATE, 'HH24' ) g
     , TO_CHAR( SYSDATE, 'MI' ) h
     , TO_CHAR( SYSDATE, 'SS' ) i
     , TO_CHAR( SYSDATE, 'SSSSS' ) i
     
     , TO_CHAR( SYSDATE, 'DY' ) j
     , TO_CHAR( SYSDATE, 'DAY' ) j
     
     , TO_CHAR( SYSDATE, 'WW' ) k -- 년의 주
     , TO_CHAR( SYSDATE, 'W' ) k -- 월의 주
     , TO_CHAR( SYSDATE, 'IW' ) k -- 년의 주
     -- WW와 IW의 차이점은?
     
     , TO_CHAR( SYSDATE, 'DL' ) l -- 2023년 3월 20일 월요일
     , TO_CHAR( SYSDATE, 'DS' ) l -- 2023/03/20
FROM dual;
--
SELECT ename, hiredate
     , TO_CHAR( hiredate, 'DS' )
FROM emp;
-- 'FF' 밀리세컨드
-- ORA-01821: date format not recognized
-- DATE : SYSDATE 밀리세컨드 값이 존재하지 않는다
SELECT SYSDATE
--   , TO_CHAR( SYSDATE, 'HH24:MI:SS.FF' )
     , TO_CHAR( CURRENT_TIMESTAMP, 'HH24:MI:SS.FF3' )
     , TO_CHAR( SYSDATE, 'TS' ) -- 오후 12:54:19
FROM dual;

[문제] 오늘 날짜를 TO_CHAR() 함수 이용해서 '2023년 03월 20일 오후 14:03:32 (월)' 형식으로 출력

SELECT SYSDATE
--  , TO_CHAR (SYSDATE, 'YYYY' )  '년'  To_Char (SYSDATE, 'MM' )  '월'  .... 
    , TO_CHAR (SYSDATE, 'YYYY MM DD AM HH24:MI:SS DY') --> 이렇게 한번에 섞어써도 잘 나옴 !
--  , TO_CHAR (SYSDATE, 'YYYY년 MM월 DD일 AM HH24:MI:SS DY') 
    --> 날짜 형식을 인식할 수 없다 (date format not recognized) : '년', '월','일'때문에 생기는 문제 
    --> " " 사용 : 결과와 함께 출력할 문자열 나타낼 때 사용! 
    , TO_CHAR (SYSDATE, 'YYYY"년" MM"월" DD"일" AM HH24:MI:SS DY') 
FROM dual ;

-- 3) TO_DATE : 숫자, 문자 타입을 날짜타입으로 변환 (포멧팅 가능) 

【형식】
     TO_DATE( char, ['형식'] )
*Datetime Format element는 TO_CHAR(datetime)에 정리한 것과 동일 

[문제] 수료일 : 2023.07.10 -> 오늘부터 수료일까지 남은 일수?
날짜-날짜 = 일수
ex) 근무일수 
SELECT  CEIL (SYSDATE - hiredate) 근무일수 -- 올림하는 이유 : 당일도 남은 근무일수로 포함
FROM emp; 

SELECT SYSDATE - '2023.07.10' 
FROM dual ; 
--ORA-01722: invalid number
ㄴ 원인 : 날짜가 아닌 문자로 인식 
ㄴ 해결 : 문자로 인식되는 '2023.07.10'을 날짜로 변환 => TO_DATE 
↓
, CEIL (ABS (SYSDATE-TO_DATE ('2023.07.10' )   )   ) "남은일수" 



[문제] 4자리의 숫자 형식으로 0010, 0040 부서번호를 출력 
SELECT deptno 
    , TO_CHAR (deptno, '0999') 
FROM dept ;
-------------------------------------------------------------------------------
-- [ 일반함수 ]
1) NVL
2) NVL2
3) NULLIF
4) NANVL
5) COALESCE : 병합(합동, 연합)하다
    나열해놓은 값을 순차적으로 체크하여 NULL이 아닌 값을 리턴하는 함수
【형식】
        COALESCE(expr[,expr,...])

SELECT ename, sal + NVL(comm,0) pay
     , COALESCE( sal + comm, sal, 0) pay
FROM emp;
-- '' == NULL 로 처리한다 ( 기억 )
SELECT COALESCE( '', '', 'arirang', 'Kunsan' )
FROM dual;

6) DECODE
-- 여러 개의 조건을 주어 조건에 맞을 경우 해당 값을 리턴하는 함수
-- 비교 연산은 = 만 가능하다
-- PL/SQL 안에서 사용할 오라클 함수
-- if(){} else if(){} ... else{}
-- 자바에서
int x = 10;
if( x == 11 ){
    return C;
} else if( x == 12 ){
    return D:
} else if( x == 13 ){
    return E:
} else {
    return F:
}
-- 오라클 DECODE 사용해서
DECODE( x, 11, C, 12, D, 13, E, F )
【형식】 
      DECODE(expr,  search1,result1
                  [,search2,result2,...] [,default] );

[문제] insa 테이블에서 주민등록번호(ssn)를 가지고 "남자", "여자"라고 출력
SELECT name, ssn
     , MOD( SUBSTR( ssn, 8, 1 ), 2 ) mod
     , DECODE( MOD( SUBSTR( ssn, 8, 1 ), 2 ), 1, '남자', '여자' ) gender
FROM insa;

[문제] insa 테이블에서 오늘을 기준으로 생일이 지남 여부를 출력하는 쿼리를 작성하세요 . 
     ( '지났다', '안지났다', '오늘 ' 처리 )
     
SELECT num, name, ssn
     , SUBSTR( ssn, 3, 4 )
     , TO_CHAR( SYSDATE, 'MMDD' )
     , SIGN( SUBSTR( ssn, 3, 4 ) - TO_CHAR( SYSDATE, 'MMDD' ) ) s
     , DECODE( SIGN( SUBSTR( ssn, 3, 4 ) - TO_CHAR( SYSDATE, 'MMDD' ) ), -1, '안지났다', 1, '지났다', '오늘' )
FROM insa;
--
SELECT num, name, ssn
     , SIGN( TRUNC( SYSDATE ) - TO_DATE( SUBSTR( ssn, 3, 4 ), 'MMDD' ) ) s -- 현재시간 절삭 작업 필요함
     , DECODE( SIGN( TRUNC( SYSDATE ) - TO_DATE( SUBSTR( ssn, 3, 4 ), 'MMDD' ) ), -1, '안지났다', 1, '지났다', '오늘' ) result
FROM insa;
-- ( 기억 ) 부분만 설정하면 나머지는 오늘 기준으로
-- ORA-01861: literal does not match format string
SELECT 
--  TO_DATE( '2023' )
    TO_DATE( '2023', 'YYYY' ) -- 23/03/01
  , TO_DATE( '04', 'MM' ) -- 23/04/01
  , TO_DATE( '10', 'DD' ) -- 23/03/10
  , TO_DATE( '0522', 'MMDD' ) -- 23/05/22
FROM dual;

[문제] emp 테이블에서 각 사원의 번호, 이름, 급여(pay) 출력
    1) 10번 부서원은 급여 15% 인상
    2) 20번 부서원은 급여 30% 인상
    3) 그 외 부서원은 급여 5% 인상

SELECT deptno, empno, ename
     , COALESCE( sal+comm, sal, 0 ) pay
     , '+' || DECODE( deptno, 10, 15, 20, 30, 5 ) || '%' "%"
     , COALESCE( sal+comm, sal, 0 ) * DECODE( deptno, 10, 1.15, 20, 1.30, 1.05 ) update_pay
FROM emp
ORDER BY deptno;

7) CASE
-- DECODE 함수의 확장 함수
-- 다양한 비교 연산자를 사용할 수 있다
【형식】
	CASE 컬럼명|표현식
        WHEN 조건1 THEN 결과1
        [WHEN 조건2 THEN 결과2
                            ......
        WHEN 조건n THEN 결과n
        ELSE 결과4]
	END

[문제] insa 테이블에서 주민등록번호(ssn)를 가지고 "남자", "여자"라고 출력
SELECT name, ssn
     , MOD( SUBSTR( ssn, 8, 1 ), 2 ) mod
     , DECODE( MOD( SUBSTR( ssn, 8, 1 ), 2 ), 1, '남자', '여자' ) gender
     , CASE MOD( SUBSTR( ssn, 8, 1 ), 2 )
        WHEN 1 THEN '남자'
        WHEN 0 THEN '여자'
       END case_gender
FROM insa;

[문제] insa 테이블에서 오늘을 기준으로 생일이 지남 여부를 출력하는 쿼리를 작성하세요 . 
     ( '지났다', '안지났다', '오늘 ' 처리 )
SELECT num, name, ssn
     , SUBSTR( ssn, 3, 4 )
     , SIGN( TRUNC( SYSDATE ) - TO_DATE( SUBSTR( ssn, 3, 4 ), 'MMDD' ) ) s -- 현재시간 절삭 작업 필요함
     , DECODE( SIGN( TRUNC( SYSDATE ) - TO_DATE( SUBSTR( ssn, 3, 4 ), 'MMDD' ) ), -1, '안지났다', 1, '지났다', '오늘' ) result
     , CASE SIGN( TRUNC( SYSDATE ) - TO_DATE( SUBSTR( ssn, 3, 4 ), 'MMDD' ) )
        WHEN -1 THEN '안지났다'
        WHEN 1 THEN '지났다'
        WHEN 0 THEN '오늘'
       END c
     , CASE -- 컬러명, 표현식 X
        WHEN TRUNC( SYSDATE ) - TO_DATE( SUBSTR( ssn, 3, 4 ), 'MMDD' ) < 0 THEN '안지났다'
        WHEN TRUNC( SYSDATE ) - TO_DATE( SUBSTR( ssn, 3, 4 ), 'MMDD' ) > 0 THEN '지났다'
        ELSE '오늘'
       END d
FROM insa;

[문제] emp 테이블에서 각 사원의 번호, 이름, 급여(pay) 출력
    1) 10번 부서원은 급여 15% 인상
    2) 20번 부서원은 급여 30% 인상
    3) 그 외 부서원은 급여 5% 인상

SELECT deptno, empno, ename
     , COALESCE( sal+comm, sal, 0 ) pay
     , '+' || DECODE( deptno, 10, 15, 20, 30, 5 ) || '%' "%"
     , COALESCE( sal+comm, sal, 0 ) * DECODE( deptno, 10, 1.15, 20, 1.30, 1.05 ) d_update_pay
     , COALESCE( sal+comm, sal, 0 ) * CASE deptno
                                        WHEN 10 THEN 1.15
                                        WHEN 20 THEN 1.30
                                        ELSE 1.05
                                       END c_update_pay
     , COALESCE( sal+comm, sal, 0 ) * CASE
                                        WHEN deptno = 10 THEN 1.15
                                        WHEN deptno = 20 THEN 1.30
                                        ELSE 1.05
                                       END c_update_pay
FROM emp
ORDER BY deptno;

-- [ 정규표현식 함수 ]
1) REGEXP_LIKE()
2) REGEXP_INSTR()
3) REGEXP_SUBSTR()
4) REGEXP_REPLACE()

-- [ 그룹 함수 ]
-- 그룹당 하나의 결과를 출력한다
-- 그룹 함수는 SELECT절 및 HAVING 절에서 사용할 수 있다
-- GROUP BY 절은 행들을 그룹화한다
-- HAVING 절은 그룹을 제한한다.(비교: WHERE 절은 행(row)을 제한한다.)

1) AVG() : 평균
    총 사원 12명 : comm이 NULL인 사원이 8명
SELECT ename, comm
FROM emp;

[문제] sal 평균, comm 평균 계산해서 출력
-- comm 평균 계산 (주의)
SELECT AVG( sal ) sal_avg
     , AVG( comm ) comm_avg -- 550 ( 2200/4 )
     , SUM( comm ) / COUNT( * ) comm_avg -- 183.333 ( 2200/12 )
FROM emp;
2) COUNT() : NULL이 아닌 행의 갯수를 반환하는 함수
【형식】
	COUNT([* ? DISTINCT ? ALL] 컬럼명) [ [OVER] (analytic 절)]

SELECT COUNT( comm ) -- 4
     , COUNT( deptno ) -- 11
     , COUNT( sal ) -- 12
     , COUNT ( * ) -- NULL을 포함한 행의 수 == 모든 사원 수
FROM emp;

[문제] insa 테이블에서 부서의 수를 출력
SELECT COUNT( DISTINCT buseo )
FROM insa;

3) MAX()
4) MIN()
5) STDDEV() : 표준편차
6) SUM() : NULL을 제외한 n의 합계를 리턴한다
【형식】
	SUM ([DISTINCT ? ALL] expr)
               [OVER (analytic_clause)]

[문제] emp 테이블의 모든 sal의 합
SELECT SUM( sal ) tot_sal
     , SUM( comm ) tot_comm
FROM emp;

7) VARIANCE() : 분산

[문제] emp 테이블에서 각 부서의 사원수를 출력(조회)
1. SET 연산자 ( UNION, UNION ALL )
SELECT '10' deptno, COUNT( * )
FROM emp
WHERE deptno = 10
UNION ALL
SELECT '20', COUNT( * )
FROM emp
WHERE deptno = 20
UNION ALL
SELECT '30', COUNT( * )
FROM emp
WHERE deptno = 30
UNION ALL
SELECT '40', COUNT( * )
FROM emp
WHERE deptno = 40
UNION ALL
SELECT 'NULL', COUNT( * )
FROM emp
WHERE deptno IS NULL;

2. ( 암기 ) COUNT(), DECODE()
-- 부서가 없는 사원수 출력 X
SELECT COUNT(*) "총 사원수"
    , COUNT( DECODE( deptno, 10, 'O' ) ) "10번 사원수"
    , COUNT( DECODE( deptno, 20, 'O' ) ) "20번 사원수"
    , COUNT( DECODE( deptno, 30, 'O' ) ) "30번 사원수"
    , COUNT( DECODE( deptno, 40, 'O' ) ) "40번 사원수"
    , COUNT( DECODE( deptno, NULL, 'O' ) ) "NULL 사원수"
    , COUNT(*)-COUNT(deptno) "부서가 NULL인 사원수"
FROM emp;

3.
-- ORA-00937: not a single-group group function
-- GROUP BY절 없으면 단일함수, 그룹함수 같이 못씀
-- ORA-00979: not a GROUP BY expression
-- GROUP BY 절에 있는 컬럼만 SELECT 절에 사용할 수 있다
SELECT deptno, job, COUNT(*)
FROM emp
GROUP BY deptno -- 집계함수 MAX, MIN, AVG, SUM, COUNT 등등
ORDER BY deptno;
-- (문제점) deptno = 40 은 아예 출력이 안됨

SELECT *
FROM emp
WHERE deptno = null;









