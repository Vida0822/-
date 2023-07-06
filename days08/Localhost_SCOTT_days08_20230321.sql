-- SCOTT --
-------------------------------------------------------------------------------
1.  TO_CHAR( ,  'format') �Լ����� 'format'�� ���Ǵ� ��ȣ�� ��������.
  ��. �⵵ : 'YYYY', 'YY', 'RRRR', 'RR'
  ��. �� : 'MM', 'MONTH', 'MON'
  ��. ���� �� : 'DD'
      ���� �� : 'D'
      ���� �� : 'DDD'
  ��. ���� : 'DY', 'DAY'
  ��. ���� ���� : 'W'
      ���� ���� : 'WW', 'IW'
  ��. �ð�/24�ð� : 'HH', 'HH12', 'HH24'
  ��. �� : 'MI'
  ��. �� : 'SS'
  ��. �������� ���� �� : 'SSSSS'
  ��. ����/���� : 'AM', 'PM'
  
2. ������ ���Ϸκ��� ���ñ��� ��ƿ� �ϼ�, ������, ����� ����ϼ���..

-- ORA-01722: invalid number
-- '1996.06.29'�� ��¥�� ����ȯ �ʿ�
SELECT CEIL( SYSDATE - TO_DATE( '1996.06.29', 'YYYY.MM.DD' ) ) "�ϼ�"
     , ROUND( MONTHS_BETWEEN( SYSDATE, TO_DATE( '1996.06.29' ) ), 2 ) "������"
     , ROUND( MONTHS_BETWEEN( SYSDATE, TO_DATE( '1996.06.29' ) )/12, 2 ) "���"
FROM dual;

�ݿø� : ROUND
����(�ø�) : CEIL
����(����) : TRUNC, FLOOR

3. IW�� WW �� ������.

IW : ������~�Ͽ����� �� ����
WW : 1��~7���� �� ����

4-1. �̹� ���� �� �ϱ��� �ִ� Ȯ��.
SELECT TO_CHAR( LAST_DAY( SYSDATE ), 'DD' ) last_day -- ���� ��ȯ
     , EXTRACT( DAY FROM LAST_DAY( SYSDATE ) ) -- ���� ��ȯ
     , TO_DATE( TO_CHAR( ADD_MONTHS( SYSDATE, 1 ), 'YYYY.MM' ), 'YYYY.MM' ) - 1
FROM dual;

4-2. ������ ���� �� ° ��, ���� �� °������ Ȯ��. 

SELECT TO_CHAR( SYSDATE, 'WW' ) y_week , TO_CHAR( SYSDATE, 'W' ) m_week
FROM dual;

5. emp ����  pay �� NVL(), NVL2(), COALESCE()�Լ��� ����ؼ� ����ϼ���.

SELECT sal+NVL(comm,0) n_pay, NVL2( sal+comm, sal+comm, sal ) n2_pay, COALESCE( sal+comm, sal, 0 ) c_pay
FROM emp;

5-2. emp���̺��� mgr�� null �� ��� -1 �� ����ϴ� ���� �ۼ�
      ��. nvl()
      
      SELECT NVL( mgr, -1 )
      FROM emp;
      
      ��. nvl2()
      
      SELECT NVL2( mgr, mgr, -1 )
      FROM emp;
      
      ��. COALESCE()
      
      SELECT COALESCE( mgr, -1 )
      FROM emp;

6. insa ����  �̸�,�ֹι�ȣ, ����( ����/���� ) ��� ���� �ۼ�-
    ��. DECODE()
    
    SELECT name, ssn
         , DECODE( MOD( SUBSTR( ssn, -7, 1 ), 2 ), 1, '����', 0, '����' ) gender
    FROM insa;
    
    ��. CASE �Լ�
    
        SELECT name, ssn
             , CASE MOD( SUBSTR( ssn, -7, 1 ), 2 )
                WHEN 1 THEN '����'
                WHEN 0 THEN '����'
               END gender
    FROM insa;

7. emp ���� ���PAY ���� ���ų� ū ����鸸�� �޿����� ���.
  ( DECODE, CASE ����ؼ� Ǯ�� ) 
  
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

[����] insa ���̺��� ���ڻ����, ���ڻ���� ���

SELECT '�� �����', COUNT(*)
FROM insa
UNION ALL
SELECT '���� �����', COUNT(*)
FROM insa
WHERE MOD( SUBSTR( ssn, -7, 1 ), 2 ) = 1
UNION ALL
SELECT '���� �����', COUNT(*)
FROM insa
WHERE MOD( SUBSTR( ssn, -7, 1 ), 2 ) = 0;
--
SELECT COUNT(*) "�� �����"
  , COUNT( DECODE( MOD( SUBSTR( ssn, -7, 1 ), 2 ), 1, 100 ) ) "���� �����"
--, COUNT( DECODE( MOD( SUBSTR( ssn, -7, 1 ), 2 ), 0, 100 ) ) "���� �����"
  , COUNT(
        CASE MOD( SUBSTR( ssn, -7, 1 ), 2 )
            WHEN 0 THEN 'F'
            ELSE NULL
        END
    ) "���� �����"
FROM insa;
--
SELECT DECODE( MOD( SUBSTR( ssn, -7, 1 ), 2 ), 1, '����', 0, '����' ) "����", COUNT(*)
FROM insa
GROUP BY MOD( SUBSTR( ssn, -7, 1 ), 2 );

MOD(SUBSTR(SSN,-7,1),2)   COUNT(*)
----------------------- ----------
                      1         31
                      0         29
                      
[����] emp ���̺��� �� �μ��� ����� ��ȸ(���)
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
-- ������) ����� �������� �ʴ� �μ� ������ ���(��ȸ)���� �ʴ´�
-- �߰�) ��ü ����� ��� : UNION ALL ( SET ������ )
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

[Ȯ��] �� �μ��� �� �޿���
SELECT deptno
    , COUNT(*) "�����"
    , SUM( sal + NVL(comm,0) ) "�ѱ޿���"
    , MAX( sal + NVL(comm,0) ) "�ְ�޿���"
    , MIN( sal + NVL(comm,0) ) "�����޿���"
    , ROUND( AVG( sal + NVL(comm,0) ) ) "��ձ޿���"
FROM emp
GROUP BY deptno
ORDER BY deptno;

8. emp ����  ����� �����ϴ� �μ��� �μ���ȣ�� ���

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

-- SET ������ ( MINUS )
SELECT deptno
FROM dept
MINUS
SELECT DISTINCT deptno
FROM emp;
--
SELECT DISTINCT( DECODE( deptno, 10, 10, 20, 20, 30, 30, 40, 40 ) )
FROM emp;
--
-- OUTER JOIN( �ܺ� ����) --
    SELECT d.deptno --, COUNT(e.ename) �����
    FROM dept d LEFT OUTER JOIN emp e ON d.deptno = e.deptno
    GROUP BY d.deptno
    HAVING COUNT(e.ename) = 0 ;

-- JOIN ( ���� == ���� )
[����] emp ���̺��� ��� ���� ��ȸ
( �μ���ȣ, �μ���, �����ȣ, �����, �Ի����� )

SELECT deptno, empno, ename, hiredate
FROM emp;
-- dept(�μ�) ���̺� dname �÷����� �μ����� ����
SELECT *
FROM dept;
-- dept �� emp �� ����(JOIN)�ؾ� �츮�� ���ϴ� �÷� ������ ��ȸ�� �� �ִ�
-- dept : deptno, dname
-- emp : deptno, empno, ename, hiredate

-- ORA-00918: column ambiguously defined
-- deptno �÷��� �ָŸ����ϰ� ����(����) �Ǿ���.
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

9. �Ʒ� �ڵ���  DECODE()�� ����ؼ� ǥ���ϼ���.
    ��. [�ڹ�]
        if( A == B ){
           return X;
        }
    
    SELECT DECODE( 'A', 'B', 'X' )
    FROM dual;
    
    ��. [�ڹ�]
        if( A==B){
           return S;
        }else if( A == C){
           return T;
        }else{
           return U;
        }
        
     SELECT DECODE( 'A', 'B', 'S', 'C', 'T', 'U' )
     FROM dual;   
    
    ��.  [�ڹ�]
        if( A==B){
           return XXX;
        }else{
           return YYY;
        }
     
      SELECT DECODE( 'A', 'B', 'XXX', 'YYY' )
      FROM dual;

10. insa���̺��� 1001, 1002 ����� �ֹι�ȣ�� ��/�� �� ���� ��¥�� �����ϴ� ������ �ۼ� 
SELECT *
FROM insa;

UPDATE insa
SET ssn = REPLACE( ssn, SUBSTR( ssn, 3, 4 ), TO_CHAR( SYSDATE, 'MMDD' ) )
-- SET ssn = SUBSTR( ssn, 0, 2 ) || TO_CHAR( SYSDATE, 'MMDD' ) || SUBSTR( ssn, 7 )
WHERE num IN (1001, 1002);
ROLLBACK;
COMMIT;

10-2. insa���̺��� ����('2023.03.21')�� �������� �Ʒ��� ���� ����ϴ� ���� �ۼ�.  
   ( DECODE, CASE �Լ� ��� )
   
SELECT name, ssn
     , DECODE( SIGN( TRUNC( SYSDATE ) - TO_DATE( SUBSTR( ssn, 3, 4 ), 'MMDD' ) ), -1, '���� ��', 1, '���� ��', '���� ����' ) d_result
     , CASE SIGN( TRUNC( SYSDATE ) - TO_DATE( SUBSTR( ssn, 3, 4 ), 'MMDD' ) )
        WHEN -1 THEN '���� ��'
        WHEN 1 THEN '���� ��'
        WHEN 0 THEN '���� ����'
       END c_result
FROM insa;
   
���)
����ö	780506-1625148	���� ��
�迵��	821011-2362514	���� ��
������	810810-1552147	���� ��
������	751010-1122233	���� ����
������	801010-2987897	���� ����
���ѱ�	760909-1333333	���� ��

10-3. insa���̺��� ����('2023.03.21')�������� �� ���� ������ �����,���� �����, �� ���� ������� ����ϴ� ���� �ۼ�. 

SELECT 
      COUNT( DECODE( SIGN( TRUNC( SYSDATE ) - TO_DATE( SUBSTR( ssn, 3, 4 ), 'MMDD' ) ), -1, 'O' ) ) "���� �� �����"
    , COUNT( DECODE( SIGN( TRUNC( SYSDATE ) - TO_DATE( SUBSTR( ssn, 3, 4 ), 'MMDD' ) ), 1, 'O' ) ) "���� �� �����"
    , COUNT( DECODE( SIGN( TRUNC( SYSDATE ) - TO_DATE( SUBSTR( ssn, 3, 4 ), 'MMDD' ) ), 0, 'O' ) ) "���� ���� �����"
FROM insa;
--
SELECT COUNT( DECODE( s, 0, 'O' ) ) "���� ���� �����"
     , COUNT( DECODE( s, -1, 'O' ) ) "���� �� �����"
     , COUNT( DECODE( s, 1, 'O' ) ) "���� �� �����"
FROM (
        SELECT num, name, ssn, SIGN( SUBSTR( ssn, 3, 4 ) - TO_CHAR( SYSDATE, 'MMDD' ) ) s
        FROM insa
    ) t;
--
SELECT
    CASE s
        WHEN 0 THEN '���� ����'
        WHEN -1 THEN '���� ��'
        WHEN 1 THEN '���� ��'
    END,
    DECODE ( s, 
FROM (
        SELECT num, name, ssn, SIGN( SUBSTR( ssn, 3, 4 ) - TO_CHAR( SYSDATE, 'MMDD' ) ) s
        FROM insa
    ) t
    GROUP BY s;

[������]
  ���� �� �����   ���� �� �����  ���� ���� �����
---------- ---------- ----------
        48         12          0

11.  emp ���̺��� 10�� �μ�������  �޿� 15% �λ�
                20�� �μ������� �޿� 10% �λ�
                30�� �μ������� �޿� 5% �λ�
                40�� �μ������� �޿� 20% �λ�
  �ϴ� ���� �ۼ�.     

SELECT deptno, empno, ename
     , COALESCE( sal+comm, sal, 0 ) pay
     , '+' || DECODE( deptno, 10, 15, 20, 10, 30, 5, 40, 20, 0 ) || '%' "%"
     , COALESCE( sal+comm, sal, 0 ) * DECODE( deptno, 10, 1.15, 20, 1.10, 30, 1.05, 40, 1.20, 1 ) update_pay
FROM emp
ORDER BY deptno;
          
12. emp ���̺��� �� �μ��� ������� ��ȸ�ϴ� ����
  ( ��Ʈ :  DECODE, COUNT �Լ� ��� )

SELECT 
      COUNT( DECODE( deptno, 10, 'O' ) ) "10�� �μ� �����"
    , COUNT( DECODE( deptno, 20, 'O' ) ) "20�� �μ� �����"
    , COUNT( DECODE( deptno, 30, 'O' ) ) "30�� �μ� �����"
    , COUNT( DECODE( deptno, 40, 'O' ) ) "40�� �μ� �����"
    , COUNT( DECODE( deptno, NULL, 'O' ) ) "�μ��� ���� �����"
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

13. emp, salgrade �� ���̺��� �����ؼ� �Ʒ� ��� ��� ���� �ۼ�.

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

14. emp ���̺��� �޿��� ���� ���� �޴� ����� empno, ename, pay �� ���.

SELECT empno, ename, sal + NVL(comm,0) pay
FROM emp
WHERE sal >= ALL( SELECT sal + NVL(comm,0) pay FROM emp );
WHERE sal = ( SELECT MAX( sal + NVL(comm,0) ) max_pay FROM emp );

-- RANK ���� �Լ�
-- TOP-N ���

14-2. emp ���̺��� �� �μ��� �޿��� ���� ���� �޴� ����� pay�� ���
 1) UNION ALL ����ؼ� Ǯ��
 2) GROUP BY  ����ؼ� Ǯ��
 3) ��� �������� ����ؼ� Ǯ��

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
-- [����] emp ���̺��� pay�� ���� �޴� 3�� ������ ��ȸ ( TOP-N ��� )
SELECT ROWNUM, t.*
FROM (
        SELECT empno, ename, hiredate, sal + NVL(comm,0) pay, deptno
        FROM emp
        ORDER BY pay DESC
    ) t
WHERE ROWNUM <= 1;
-- WHERE ROWNUM BETWEEN 3 AND 5; -- �߰��� ����(ROWNUM)�� ������ �� ����

-- [ TOP-N ��� ]
1) �ִ밪�̳� �ּҰ��� ���� �÷��� ������ �� �����ϰ� ���Ǵ� �м����
2) inline view���� ORDER BY ���� ����� �� �����Ƿ� �����͸� ���ϴ� ������ ���ĵ� �����ϴ�.
3) ROWNUM �÷��� subquery���� ��ȯ�Ǵ� �� �࿡ �������� ��ȣ�� �ο��ϴ� pseudo �÷��̴�.
4) n���� < �Ǵ� >=�� ����Ͽ� �����ϸ�, ��ȯ�� ���� ������ �����Ѵ�.
�����ġ�
	SELECT �÷���,..., ROWNUM
	FROM (SELECT �÷���,... from ���̺��
	      ORDER BY top_n_�÷���)
        WHERE ROWNUM <= n;

-- [����] emp ���̺��� pay�� ���� �޴� 3�� ������ ��ȸ ( ����(RANK) �Լ� )
-- ����(RANK) �Լ�
-- 1) DENSE_RANK
-- 2) PERCENT_RANK
-- 3) RANK
-- 4) FIRST / LAST
-- 5) ROW_NUMBER
�м�(analytic) �Լ�
���Һ��� ���ĵ� ����� ���� ������ �ο��ϴ� ����̴�.
������ ��ü ���� Ư�� �÷��� �������� �и��ϴ� ������� GROUP BY ������ �׷�ȭ�ϴ� ����� ���� �����̴�.
�����ġ�
      ROW_NUMBER () 
                   OVER ([query_partition_clause] order_by_clause )

SELECT t.*
FROM (
        SELECT deptno, ename, sal + NVL(comm,0) pay
             , ROW_NUMBER() OVER( ORDER BY sal + NVL(comm,0) DESC ) ����
        FROM emp
    ) t
WHERE ���� BETWEEN 3 AND 5;
WHERE ���� <= 3;

[����] �� �μ����� �ְ� �޿��� �޴� ��� 1���� ��ȸ
SELECT t.*
FROM (
        SELECT buseo, name, basicpay + sudang pay
             , ROW_NUMBER() OVER( PARTITION BY buseo ORDER BY basicpay + sudang DESC ) ����
        FROM insa
    ) t
WHERE ���� <= 3;
-------------------------------------------------------------------------------
-- DENSE_RANK
�׷� ������ ���ʷ� �� ���� rank�� ����Ͽ� NUMBER ������Ÿ������ ������ ��ȯ�Ѵ�.
�ش� ���� ���� �켱������ ����(�ߺ� ���� ��� ����) 
��Aggregate ���ġ�
      DENSE_RANK ( expr[,expr,...] ) WITHIN GROUP
        (ORDER BY expr [[DESC ? ASC] [NULLS {FIRST ? LAST} , expr,...] )
   

��Analytic ���ġ�
      DENSE_RANK ( ) OBER ([query_partion_clause] order_by_clause )

-- RANK
�� �Լ��� �׷� ������ ��ġ�� ����Ͽ� ��ȯ�Ѵ�.
�ش� ���� ���� �켱������ ����(�ߺ� ���� �����)

��ȯ�Ǵ� ������Ÿ���� NUMBER�̴�.


��Aggregate ���ġ�
        RANK(expr[,...]) WITHIN GROUP
            (ORDER BY {expr [DESC ? ASC] [NULLS {FIRST ? LAST}]
                      } )

��Analytic ���ġ�
	RANK() OVER( [query_partition_clause] order_by_clause
                   ) 

-- ROW_NUMBER

-------------------------------------------------------------------------------
SELECT empno, ename, sal
     , RANK() OVER( ORDER BY sal DESC ) rank -- �ߺ� ���� ��� O
     , DENSE_RANK() OVER( ORDER BY sal DESC ) dense_rank -- �ߺ� ���� ��� X    DENSE == ������
     , ROW_NUMBER() OVER( ORDER BY sal DESC ) row_number
FROM emp;

7654	MARTIN	1250	9	9	9
7521	WARD	1250	9	9	10
7900	JAMES	950	    11	10	11
-------------------------------------------------------------------------------
SELECT deptno, empno, ename, sal
     , RANK() OVER( PARTITION BY deptno ORDER BY sal DESC ) rank -- �ߺ� ���� ��� O
     , DENSE_RANK() OVER( PARTITION BY deptno ORDER BY sal DESC ) dense_rank -- �ߺ� ���� ��� X    DENSE == ������
     , ROW_NUMBER() OVER( PARTITION BY deptno ORDER BY sal DESC ) row_number
FROM emp;
-------------------------------------------------------------------------------
[����] �ڹٿ���ó�� ��� ó��
      �Ѹ� ���� -> ����� 1� ����

SELECT deptno, ename, sal
     , ( SELECT COUNT(*) FROM emp b WHERE b.sal > a.sal ) + 1 ����
FROM emp a;
-------------------------------------------------------------------------------
[����] emp ���̺��� sal�� ���� 20% ��� ���� ��ȸ
















