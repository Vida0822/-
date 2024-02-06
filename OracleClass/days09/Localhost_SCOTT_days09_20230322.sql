-- SCOTT --
-------------------------------------------------------------------------------
1. emp , salgrade ���̺��� ����ؼ� �Ʒ��� ���� ���. [JOIN] ���

-- JOIN(����) == ����
-- ���� : ���ų� �ٸ� 2�� �̻��� ���̺� ���� -> �÷� ��ȸ(�˻�)
-- ���� ���� : 8����
-- �� EQUI JOIN : ��PK - ��FK
-- �� NON EQUI JOIN : ���� X

SELECT e.ename, e.sal, s.losal || ' ~ ' || s.hisal range, s.grade
FROM emp e, salgrade s
WHERE e.sal BETWEEN s.losal AND s.hisal;
-- JOIN ~ ON ����
SELECT e.ename, e.sal, s.losal || ' ~ ' || s.hisal range, s.grade
FROM emp e JOIN salgrade s ON e.sal BETWEEN s.losal AND s.hisal;
-- CASE �Լ�
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

[����] deptno, dname, ename, hiredate, sal, grade �÷� ��ȸ

dept : [deptno(PK)], dname
emp : [deptno(FK)], ename, hiredate, sal
salgrade : grade

SELECT d.deptno, dname, ename, hiredate, sal, grade
FROM dept d, emp e, salgrade s
WHERE d.deptno = e.deptno AND e.sal BETWEEN s.losal AND s.hisal;
-- JOIN ~ ON ����
SELECT d.deptno, dname, ename, hiredate, sal, grade
FROM dept d JOIN emp e ON d.deptno = e.deptno
            JOIN salgrade s ON e.sal BETWEEN s.losal AND s.hisal;
    
1-2. ���� ������� ���(grade)�� 1����� ����� ��ȸ�ϴ� ���� �ۼ�  

SELECT empno, ename, sal, grade
FROM emp e JOIN salgrade s ON sal BETWEEN losal AND hisal
WHERE grade = 1;

���)
     EMPNO ENAME             SAL      GRADE
---------- ---------- ---------- ----------
      7369 SMITH             800          1
      7900 JAMES             950          1      
      
2. emp ���� �ְ�޿��� �޴� ����� ���� ��� ( JOIN ~ ON ���� )
  ( ���� : �Ʒ� �÷� ��� )
  
JOIN ���� : EQUI JOIN dept.deptno(PK) = emp.deptno(FK)
           INNER JOIN
-- �μ� null ��ȸ �ȵ�
SELECT dname, ename, sal+NVL(comm,0) pay
FROM dept d, emp e
WHERE d.deptno(+) = e.deptno -- RIGHT OUTER JOIN(�ܺ� ����)
    AND sal+NVL(comm,0) = ( SELECT MAX( sal+NVL(comm,0) ) FROM emp );
-- JOIN ~ ON ����
SELECT dname, ename, sal+NVL(comm,0) pay
FROM dept d RIGHT OUTER JOIN emp e ON d.deptno = e.deptno
WHERE sal+NVL(comm,0) = ( SELECT MAX( sal+NVL(comm,0) ) FROM emp );

[����] RANK()
[����] DENSE_RANK()
[����] ROW_NUMBER()

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

[����] TOP-N ���
SELECT t.*, ROWNUM ����
FROM (
        SELECT dname, ename, sal+NVL(comm,0) pay
        FROM dept d RIGHT OUTER JOIN emp e ON d.deptno = e.deptno
        ORDER BY pay DESC
    ) t
WHERE ROWNUM = 1;
    
DNAME          ENAME             PAY
-------------- ---------- ----------
ACCOUNTING     KING             5000

2-2. emp ���� �� �μ��� �ְ�޿��� �޴� ����� ���� ��� ( JOIN )

1) ��� ���� ����
SELECT d.deptno, dname, ename, sal+NVL(comm,0) pay
FROM dept d FULL JOIN emp e ON d.deptno = e.deptno
WHERE sal+NVL(comm,0) = ( -- �ش� �μ��� �ְ� �޿���
    SELECT MAX( sal+NVL(comm,0) )
    FROM emp
    WHERE deptno = d.deptno
    );

2)
-- ������)
SELECT d.deptno, dname, ename, sal+NVL(comm,0) pay
FROM emp e JOIN dept d ON e.deptno = d.deptno
WHERE sal+NVL(comm,0) IN (
        SELECT MAX( sal+NVL(comm,0) ) max_pay
        FROM emp
        GROUP BY deptno
    );
    
3) ���� �Լ�
SELECT t.*
FROM (
        SELECT d.deptno, dname, ename, sal+NVL(comm,0) pay
             , ROW_NUMBER() OVER( PARTITION BY d.deptno ORDER BY NVL( sal+NVL(comm,0), 0 ) DESC) "����"
        FROM dept d FULL JOIN emp e ON d.deptno = e.deptno
    ) t
WHERE ���� <= 1;

    DEPTNO DNAME          ENAME             PAY
---------- -------------- ---------- ----------
        10 ACCOUNTING     KING             5000
        20 RESEARCH       FORD             3000
        30 SALES          BLAKE            2850

[����] emp ���̺��� sal �� ���� 20% ������� ��ȸ
-- �� ����� 12��
-- 20% : 2.4��
SELECT t.*
FROM (
    SELECT emp.*
         , RANK() OVER( ORDER BY sal DESC ) "����"
    FROM emp
    ) t
WHERE t.���� <= ( SELECT COUNT(*) FROM emp ) * 0.2;
--
[���� �Լ�] RANK(), DENSE_RANK(), ROW_NUMBER(), TOP-N ���
- PERCENT_RANK �Լ�
    �� CUME_DIST �Լ��� ����
    �� percent ���� ��ȯ
��aggregate ���ġ�
      PERCENT_RANK(expr,...) WITHIN GROUP 
        (ORDER BY expr { [DESC ? ASC]
                         [NULLS {FIRST ? LAST}]
                       },...)
�Ǵ� 
��Analytic ���ġ�
       PERCENT_RANK() OVER ( 
                             [query_partition_clause]
                              order_by_clause
                            )

SELECT deptno, ename, sal
     , PERCENT_RANK() OVER( ORDER BY sal DESC ) "����"
FROM emp;

SELECT buseo, name, basipay
     , PERCENT_RANK() OVER( ORDER BY basicpay DESC ) "����"
FROM insa;

-- CUME_DIST
--  �� �׷� �� ������ � ���� cumulative distribution(��������)�� ����Ѵ�

-- NTILE(n) ��Ÿ�� : ��ü ������ �Ф��븦 n-Buckets�� ������ ǥ��
--  �� �м�(analytic) �Լ�
--  �� ��� ����� ����ڰ� ������ �׷� ���� ������ ����ϴ� �Լ�
�����ġ�
	NTILE ( expr )
          OVER (
	        [query_partition_clause]
	        order_by_clause
	  )

[����] emp ���̺��� �޿��� �������� ��/��/��(3�׷�)�� ����
WITH
    temp AS (
SELECT ename, sal+NVL(comm,0) pay
     , NTILE(3) OVER( ORDER BY sal+NVL(comm,0) DESC ) "�׷�"
FROM emp
    )
SELECT t.*
     , DECODE( �׷�, 1, '��', 2, '��', 3, '��' ) d
     , CASE �׷�
        WHEN 1 THEN '��'
        WHEN 2 THEN '��'
        WHEN 3 THEN '��'
       END c1
     , CASE
        WHEN �׷� = 1 THEN '��'
        WHEN �׷� = 2 THEN '��'
        WHEN �׷� = 3 THEN '��'
       END c2
FROM temp t;
-- FIRST_CALUE : ���� ����� �� �߿��� ù��° ��
-- LAST_VALUE : ���� ����� �� �߿��� ������ ��

SELECT ename, hiredate
     , FIRST_VALUE( hiredate ) OVER( ORDER BY hiredate DESC )
     , LAST_VALUE( hiredate ) OVER( ORDER BY hiredate DESC )
FROM emp;

3. emp ���� �� ����� �޿��� ��ü�޿��� �� %�� �Ǵ� �� ��ȸ.
       ( %   �Ҽ��� 3�ڸ����� �ݿø��ϼ��� )
            ������ �Ҽ��� 2�ڸ������� ���.. 7.00%,  3.50%     
WITH
    temp AS (
        SELECT ename, sal+NVL(comm,0) pay, ( SELECT SUM( sal+NVL(comm,0) ) FROM emp ) totalpay
        FROM emp
    )
SELECT t.*, TO_CHAR( ROUND( pay/totalpay*100, 2 ), '99.00' ) || '%' "����"
FROM temp t;
--
SELECT t.*, TO_CHAR( ROUND( pay/totalpay*100, 2 ), '99.00' ) || '%' "����"
FROM (
        SELECT ename, sal+NVL(comm,0) pay, ( SELECT SUM( sal+NVL(comm,0) ) FROM emp ) totalpay
        FROM emp
    ) t;

ENAME             PAY   TOTALPAY ����     
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

12�� ���� ���õǾ����ϴ�.         
        
4. emp ���� ���� ���� �Ի��� ��� �� ���� �ʰ�(�ֱ�) �Ի��� ����� ���� �ϼ� ?         

SELECT ABS( MAX( hiredate ) - MIN( hiredate ) )
FROM emp;
        
5. insa ���� ������� ������ ����ؼ� ���
  ( ������ = ���س⵵ - ����⵵          - 1( ������������ ������) )
��. ���س⵵
��. ssn -> 4�ڸ� ���ϳ⵵
��. ���� ��/�� üũ
;
SELECT t.name, t.ssn
     , �� - �� + 1 counting_age
     , �� - �� + DECODE( ��, -1, -1, 0 ) american_age
FROM (
SELECT name, ssn
     , TO_CHAR( SYSDATE, 'YYYY' ) ��
--   , TO_CHAR( TO_DATE( SUBSTR( ssn, 0, 2 ), 'RR' ), 'YYYY' ) ��
     , SUBSTR( ssn, 0, 2 ) + CASE
        WHEN SUBSTR( ssn, -7, 1 ) IN (1,2,5,6) THEN 1900
        WHEN SUBSTR( ssn, -7, 1 ) IN (3,4,7,8) THEN 2000
        WHEN SUBSTR( ssn, -7, 1 ) IN (9,0) THEN 1800
       END ��
     , SIGN( TO_CHAR( SYSDATE, 'MMDD' ) - SUBSTR( ssn, 3, 4 ) ) ��
FROM insa
    ) t;
  
6. insa ���̺��� �Ʒ��� ���� ����� ������ ..

SELECT COUNT(*) �ѻ����
     , COUNT( DECODE( MOD( SUBSTR( ssn, -7, 1 ), 2 ), 1, 'O' ) ) ���ڻ����
     , COUNT( DECODE( MOD( SUBSTR( ssn, -7, 1 ), 2 ), 0, 'O' ) ) ���ڻ����
     , TO_CHAR( SUM( DECODE( MOD( SUBSTR( ssn, -7, 1 ), 2 ), 1, basicpay + sudang ) ), 'L9,999,999,999' ) �����ѱ޿���
     , SUM( DECODE( MOD( SUBSTR( ssn, -7, 1 ), 2 ), 0, basicpay + sudang ) ) �����ѱ޿���
     , TO_CHAR( MAX( DECODE( MOD( SUBSTR( ssn, -7, 1 ), 2 ), 1, basicpay + sudang ) ), 'L9,999,999,999' ) ����MAX�޿�
     , MAX( DECODE( MOD( SUBSTR( ssn, -7, 1 ), 2 ), 0, basicpay + sudang ) ) ����MAX�޿�
FROM insa;

     [�ѻ����]      [���ڻ����]      [���ڻ����] [��������� �ѱ޿���]  [��������� �ѱ޿���] [����-max(�޿�)] [����-max(�޿�)]
---------- ---------- ---------- ---------- ---------- ---------- ----------
        60                31              29           51961200                41430400                  2650000          2550000
      
7. TOP-N ������� Ǯ�� ( ROWNUM �ǻ� �÷� ��� )
   emp ���� �ְ�޿��� �޴� ����� ���� ���  

1) ����
2) ROWNUM �ǻ��÷� - ����
3) WHERE ��ȸ

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
        
        
8.����(RANK) �Լ� ����ؼ� Ǯ�� 
   emp ���� �� �μ��� �ְ�޿��� �޴� ����� ���� ���

1) RANK �Լ�
SELECT t.*
FROM (
SELECT deptno, ename, sal+NVL(comm,0) pay
     , RANK() OVER( PARTITION BY deptno ORDER BY sal+NVL(comm,0) DESC ) deptno_rank
FROM emp
    ) t
WHERE deptno_rank = 1;

2) JOIN ���
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
   
9. emp���̺��� �� �μ��� �����, �μ��ѱ޿���, �μ������ �Ʒ��� ���� ����ϴ� ���� �ۼ�.
���)

SELECT deptno
     , COUNT(*) �μ�����
     , SUM( sal+NVL(comm,0) ) �ѱ޿���
     , TO_CHAR( ROUND( AVG( sal+NVL(comm,0) ), 2 ), '9999.00' ) ���
FROM emp
GROUP BY deptno
ORDER BY deptno;

    DEPTNO       �μ�����       �ѱ޿���            ���
---------- ----------       ----------    ----------
        10          3          8750       2916.67
        20          3          6775       2258.33
        30          6         11600       1933.33      
         
10-1.  emp ���̺��� 30���� �μ��� �ְ�, ���� SAL�� ����ϴ� ���� �ۼ�.
���)

SELECT MIN(sal), MAX(sal)
FROM emp
WHERE deptno = 30;

  MIN(SAL)   MAX(SAL)
---------- ----------
       950       2850

[����] �� �μ��� MAX(sal), MIN(sal) ��ȸ

SELECT deptno, MAX(sal), MIN(sal)
FROM emp
GROUP BY deptno
ORDER BY deptno;

10-2.  emp ���̺��� 30���� �μ��� �ְ�, ���� SAL�� �޴� ����� ���� ����ϴ� ���� �ۼ�.

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

���)
     EMPNO ENAME      HIREDATE        SAL
---------- ---------- -------- ----------
      7698 BLAKE      81/05/01       2850
      7900 JAMES      81/12/03        950      
      
11.  insa ���̺��� 
1) �ѻ����
SELECT COUNT(*)
FROM insa;

2) �μ������
SELECT buseo, COUNT(*) �μ������
FROM insa
GROUP BY buseo;

3) �μ���, ����, �����
SELECT buseo, MOD( SUBSTR( ssn, -7, 1 ), 2 ), COUNT(*)
FROM insa
GROUP BY buseo, MOD( SUBSTR( ssn, -7, 1 ), 2 )
ORDER BY buseo, MOD( SUBSTR( ssn, -7, 1 ), 2 );
--
SELECT t2.*
     , ROUND( t2.�μ������/t2.�ѻ����*100, 2 ) || '%' "��/��%"
     , ROUND( t2.���������/t2.�ѻ����*100, 2 ) || '%' "�μ�/��%"
     , ROUND( t2.���������/t2.�μ������*100, 2 ) || '%' "��/��%"
FROM (
    SELECT t.buseo "�μ���"
         , ( SELECT COUNT(*) FROM insa ) "�ѻ����"
         , ( SELECT COUNT(*) FROM insa WHERE buseo = t.buseo ) "�μ������"
         , t.gender "����", COUNT(*) "���������"
    FROM (
        SELECT buseo
             , DECODE( MOD( SUBSTR( ssn, -7, 1 ), 2 ), 1, 'M', 'F' ) gender
        FROM insa
        ) t
    GROUP BY t.buseo, t.gender
    ORDER BY t.buseo, t.gender
    ) t2;

[������]
�μ���     �ѻ���� �μ������     ����  ���������  ��/��%   �μ�/��%      ��/��%
���ߺ�       60       14         F       8       23.3%     13.3%      57.1%
���ߺ�       60       14         M       6       23.3%     10%        42.9%
��ȹ��       60       7          F       3       11.7%     5%         42.9%
��ȹ��       60       7          M       4       11.7%     6.7%       57.1%
������       60       16         F       8       26.7%     13.3%      50%
������       60       16         M       8       26.7%     13.3%      50%
�λ��       60       4          M       4       6.7%      6.7%       100%
�����       60       6          F       4       10%       6.7%       66.7%
�����       60       6          M       2       10%       3.3%       33.3%
�ѹ���       60       7          F       3       11.7%     5%         42.9%
�ѹ���       60       7          M       4       11.7%     6.7%       57.1%
ȫ����       60       6          F       3       10%       5%         50%
ȫ����       60       6          M       3       10%       5%         50%             


12. insa���̺��� �����ο����� 5�� �̻��� �μ��� ���.  

1)
SELECT t.*
FROM (
    SELECT buseo, COUNT(*) ���ڻ����
    FROM insa
    WHERE MOD( SUBSTR( ssn, -7, 1 ), 2 ) = 0
    GROUP BY buseo
    ) t
WHERE t.���ڻ���� >= 5;

2) GROUP BY ���� �������� HAVING �� ���
SELECT buseo, COUNT(*) ���ڻ����
FROM insa
WHERE MOD( SUBSTR( ssn, -7, 1 ), 2 ) = 0
GROUP BY buseo
HAVING COUNT(*) >= 5;

13. insa ���̺��� �޿�(pay= basicpay+sudang)�� ���� 15%�� �ش�Ǵ� ����� ���� ��� 

1) �޿� ����
2) �ѻ����

SELECT t.*
FROM (
SELECT buseo, name, basicpay+sudang pay
     , RANK() OVER( ORDER BY basicpay+sudang DESC ) "�޿�����"
FROM insa
    ) t
WHERE �޿����� <= ( SELECT COUNT(*) FROM insa )*0.15;

14. emp ���̺��� sal�� ��ü��������� ��� , �μ��������� ����� ����ϴ� ���� �ۼ�

SELECT deptno, ename, sal
     , RANK() OVER( ORDER BY sal DESC ) "��ü���"
     , RANK() OVER( PARTITION BY deptno ORDER BY sal DESC ) "�μ����"
     , ( SELECT COUNT(*)+1 FROM emp b WHERE b.sal > a.sal ) "��ü���"
     , ( SELECT COUNT(*)+1 FROM emp b WHERE b.sal > a.sal AND b.deptno = a.deptno ) "�μ����"
FROM emp a
ORDER BY deptno ASC;
-------------------------------------------------------------------------------
-- GROUP BY + HAVING �� --
1) �� �μ��� ����� ��ȸ
SELECT COUNT(*) "�ѻ����"
     , COUNT( DECODE( deptno, 10, 'O' ) ) "10 �����"
     , COUNT( DECODE( deptno, 20, 'O' ) ) "20 �����"
     , COUNT( DECODE( deptno, 30, 'O' ) ) "30 �����"
     , COUNT( DECODE( deptno, 40, 'O' ) ) "40 �����"
FROM emp;
2) -- �ƽ�����) "�ѻ����" ��� �Ұ� -> ROLLUP, CUBE
   -- �ƽ�����) deptno 40 - 0 -> JOIN
SELECT d.deptno, COUNT(ename) "�����"
FROM emp e FULL OUTER JOIN dept d ON e.deptno = d.deptno
GROUP BY d.deptno
ORDER BY d.deptno ASC;
3) -- LEFT OUTER JOIN
SELECT d.deptno, COUNT(ename) "�����"
FROM emp e, dept d
WHERE e.deptno = d.deptno(+)
GROUP BY d.deptno
ORDER BY d.deptno ASC;

4) 20��, 40�� �μ��� ���ܽ�Ű�� ��ȸ
    �μ� ������� 3�� �̻��� �μ������� ���

SELECT deptno, COUNT(*)
FROM emp
WHERE deptno NOT IN (20,40)
GROUP BY deptno
HAVING COUNT(*) >= 3;

5) �÷� : deptno, [dname], COUNT(*)
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
-- ���Ʒ� JOIN
SELECT DISTINCT jikwi
FROM insa









































