-----------------------   
8-3. insa ���̺��� ����ó(tel)�� ���� ����� '����ó ��� �ȵ�' ����ϴ� ������ �ۼ�. 

    ��. IS [NOT] NULL SQL ������
    ��. NVL() NULL ó�� �Լ�
    
SELECT i.*, NVL(tel, '����ó ��� �ȵ�') tel
FROM insa i
WHERE tel IS NULL;

8-4. insa ���̺��� ���ߺθ� num, name, tel �÷� ����� �� ����ó(tel) ���� ����� X, O ����ϴ� ���� �ۼ�.
-- �ڹ� if~else�� / ���� ������
-- ����Ŭ PL/SQL
SELECT num, name, NVL2(tel, 'O', 'X') tel
FROM insa
WHERE buseo = '���ߺ�';
WHERE buseo LIKE '%����%';

8-5. insa ���̺��� ���ڴ� X, ���ڴ� O�� ����(gender) ����ϴ� ���� �ۼ�.

-- SUBSTR() �Լ�
-- MOD()�Լ�
-- REPLACE() �Լ�
SELECT t.name, t.ssn
      , REPLACE( REPLACE( t.gender, 1, '����'), 0, '����') gender
FROM ( -- �ζ��κ�(inline-view)
    SELECT name, ssn
          , MOD(SUBSTR(ssn, -7, 1), 2) gender -- 1(����), 0(����)
    FROM insa
) t;

--NULLIF() �Լ� + NVL2() �Լ�
SELECT name, ssn
      , NVL2( NULLIF( MOD( SUBSTR(ssn, -7, 1), 2), 1), '����', '����') gender
FROM insa;

--NULLIF() �Լ�
�����ġ�
    NULLIF(expr1, expr2)
    expr1 == expr2      NULL
    expr1 != expr2      expr1
    
-- HR ����
SELECT *
FROM tabs;
-- JOB_HISTORY ���̺� : ��(����) �����丮
-- �ش� ������ ������ �Ⱓ
SELECT *
FROM job_history
ORDER BY employee_id ASC;
-- [���] START_DATE(���������� �⵵)�� END_DATE(���������� �⵵)�� ������ NULL ���, �ٸ��� �������� ���
SELECT employee_id
      , TO_CHAR(start_date, 'YYYY') start_year
      , TO_CHAR(end_date, 'YYYY') end_year
      , NULLIF (TO_CHAR(start_date, 'YYYY'), TO_CHAR(end_date, 'YYYY'))
FROM job_history;

9. employees ���̺���  �Ʒ��� ���� ��µǵ��� ���� �ۼ��ϼ���. 
-- HR ����
SELECT *
FROM tabs;
WHERE table_name LIKE 'EMP%'

DESC employees;

SELECT first_name, last_name
      , first_name || ' ' || last_name name
      , CONCAT(CONCAT(first_name, ' '), last_name) name
FROM employees;
   
    FIRST_NAME          LAST_NAME                   NAME                                           
    -------------------- ------------------------- -----------------------------
    Samuel               McCain                    Samuel McCain                                  
    Allan                McEwen                    Allan McEwen                                   
    Irene                Mikkilineni               Irene Mikkilineni                              
    Kevin                Mourgos                   Kevin Mourgos                                  
    Julia                Nayer                     Julia Nayer   
    :

10. emp ���̺���  �Ʒ��� ���� ��ȸ ����� �������� ������ �ۼ��ϼ���.

SELECT empno, ename, sal
      , NVL(comm, 0) comm
      , sal + NVL(comm, 0) pay
FROM emp;

     EMPNO ENAME             SAL       COMM        PAY
---------- ---------- ---------- ---------- ----------
      7369 SMITH             800          0        800
      7499 ALLEN            1600        300       1900
      7521 WARD             1250        500       1750
      7566 JONES            2975          0       2975
      7654 MARTIN           1250       1400       2650
      7698 BLAKE            2850          0       2850
      7782 CLARK            2450          0       2450
      7839 KING             5000          0       5000
      7844 TURNER           1500          0       1500
      7900 JAMES             950          0        950
      7902 FORD             3000          0       3000
      7934 MILLER           1300          0       1300

	12�� ���� ���õǾ����ϴ�.  

11.   emp ���̺��� 10�� �μ��� ���� ��ȸ

SELECT *
FROM emp
WHERE deptno = 10;

11-2. emp ���̺��� 10�� �μ����� ������ ��� ������ ��ȸ(���)

SELECT *
FROM emp
WHERE deptno IN (20, 30, 40);
WHERE deptno > 10;
WHERE deptno <> 10;
WHERE deptno ^= 10;
WHERE deptno != 10;
-- 10, 20, 30, 40 - 10
SELECT deptno
FROM dept;

11-3. emp ���̺��� 10�� �Ǵ� 20�� �μ��� ������ ��ȸ

SELECT *
FROM emp
WHERE deptno IN (10, 20);
WHERE deptno <= 20;
WHERE deptno = 10 OR deptno = 20;

12. ������� king �� ����� ���� ��ȸ

SELECT *
FROM emp
WHERE REGEXP_LIKE(ename, '^king$', 'i');
WHERE ename = UPPER('king');

13. insa ���̺��� ��������� ������ �ƴ� ����� ������ ��ȸ.
-- ������ : ����, ��õ, ���
SELECT *
FROM insa
WHERE city NOT IN ('����', '��õ', '���');
-- ���� [NOT] IN (list) ������

14.  emp ���̺��� comm ��  Ȯ�ε��� ���� ����� ���� ��ȸ
 (   comm ��    null �� ����� ���� ��ȸ )
14-2. emp ���̺��� comm ��  null �� �ƴ� ����� ���� ��ȸ  

15. HR ������ ���� �ñ�� [��ݻ���]�� Ȯ���ϴ� ������ �ۼ��ϼ���.

dba_XXX
all_XXX
user_XXX

-- SYS ����
SELECT *
FROM dba_users;

dba_users ***
all_users
user_users

dba_tables
all_tables
user_tables == tabs

[����] KING ����� �μ���ȣ null�� �����ϼ���
-- ����/������ �ϱ� ���� �˻�
SELECT empno -- ������ Ű(PK)
FROM emp
WHERE ename = 'KING';

UPDATE emp
SET deptno = null
WHERE empno = 7839; -- WHERE �������� ������ ��� ���ڵ带 ����
COMMIT;

SELECT *
FROM emp;

16.  emp���̺���
   �� �μ����� �������� 1�� �����ϰ� �޿�(PAY)���� 2�� �������� �����ؼ� ��ȸ�ϴ� ������ �ۼ��ϼ���.    
   
SELECT deptno, ename, sal + NVL(comm, 0) pay
FROM emp
ORDER BY deptno ASC, pay DESC;
ORDER BY 1 ASC, 3 DESC;

17. emp ���̺��� �μ���ȣ�� 10���̰�, ���� CLERK  �� ����� ������ ��ȸ�ϴ� ���� �ۼ�.

SELECT *
FROM emp
WHERE deptno = 10 AND job = 'CLERK'

17-2. emp ���̺��� ���� CLERK �̰�, �μ���ȣ�� 10���� �ƴ� ����� ������ ��ȸ�ϴ� ���� �ۼ�.

SELECT *
FROM emp
WHERE deptno != 10 AND job = 'CLERK'

17-3.  emp ���̺��� �μ���ȣ�� 30���̰�, Ŀ�̼��� null�� ����� ������ ��ȸ�ϴ� ���� �ۼ�.
  ( ��.  deptno, ename, sal, comm,  pay �÷� ���,  pay= sal+comm )
  ( ��. comm�� null �� ���� 0���� ��ü�ؼ� ó�� )
  ( ��. pay �� ���� ������ ���� ) 

SELECT deptno, ename, sal, NVL(comm, 0) comm, sal + NVL(comm, 0) pay
FROM emp
WHERE deptno = 30 AND comm IS NULL
ORDER BY pay DESC;
  
18. Alias �� �ۼ��ϴ� 3���� ����� ��������.
   SELECT deptno, ename 
     , sal + comm   (��)  AS "PAY"
     , sal + comm   (��)  "PAY"
     , sal + comm   (��)  pay
    FROM emp;
--------------------------------------------------------------------------------
����Ŭ ������ (operator)
����Ŭ �Լ� (function)
����Ŭ �ڷ��� (data type)
-------------------------------------------------------------------------------
SQL - DQL(SELECT), DDL(CREATE, DROP, ALTER), DML(INSERT, UPDATE, DELETE), DCL(GRANT, REVOKE), TCL(COMMIT, ROLLBACK)
-------------------------------------------------------------------------------
����Ŭ ������ (operator)
-------------------------------------------------------------------------------
1. �񱳿����� : ����, ����, ��¥
    =
    != <> ^=
    > <
    >= <=
    SQL ������ : AND, SOME, ALL + ��������(subquery)

2. �������� : WHERE������ ���� ���� ������ ������ ���
    AND, OR, NOT
    
    [AND]
    TRUE NULL   NULL
    NULL FALSE  FALSE
    
    [OR]
    TRUE NULL   TRUE
    NULL FALSE  NULL
    
3. SQL������
    [NOT] IN (list)
    [NOT] BETWEEN a AND b
    [NOT] LIKE
    IS [NOT] NULL
    
    ANY, SOME, ALL,     EXISTS
    
    -- EXISTS ������
    SELECT p.ename, p.job, p.sal, p.deptno
    FROM emp p
    WHERE EXISTS ( -- ����������� �ַ� ���, TRUE/FALSE
                    SELECT 'x' 
                    FROM dept 
                    WHERE deptno = p.deptno
                    );
FALSE
SELECT 'x'
FROM dept 
WHERE deptno = 10;

SELECT *
FROM dept
WHERE deptno IS NULL;

[����] emp ���̺��� �޿��� ���� ���� �޴� ����� ������ ��ȸ
-- �񱳿����� + ALL SQL������
SELECT e.*, sal + NVL(comm, 0) pay
FROM emp e
WHERE sal + NVL(comm, 0) >=  ALL( SELECT sal + NVL(comm, 0) FROM emp ); -- ���� ���� �޴� ���
WHERE sal + NVL(comm, 0) <=  ALL( SELECT sal + NVL(comm, 0) FROM emp ); -- ���� ���� �޴� ���
--
SELECT e.*, sal + NVL(comm, 0) pay
FROM emp e
WHERE sal + NVL(comm, 0) = ( SELECT MAX(sal+NVL(comm, 0)) max_pay FROM emp );
-- ���� ���� �޴� �޿� ��ȸ
-- MAX()/MIN() �Լ�
SELECT MAX(sal) max_sal
      , MIN(sal) min_sal
      , MAX(sal+NVL(comm, 0)) max_pay
      , MIN(sal+NVL(comm, 0)) min_pay
FROM emp;

4. NULL������

5. SET(����)������
    1) ������(UNION, UNION ALL) ������
        (1) ���ߺ� ��ȸ
        SELECT name, city, buseo
        FROM insa
        WHERE buseo = '���ߺ�';
        (2) ��õ ��ȸ
        SELECT name, city, buseo
        FROM insa
        WHERE city = '��õ';        
        -- UNION (1) 14 + (2) 9 - (1)(2) 6 = 17
        -- UNION ALL (1) 14 + (2) 9 = 23
        SELECT name, city, buseo -- , ssn
        FROM insa
        WHERE buseo = '���ߺ�'
        UNION
        -- UNION ALL
        SELECT name, city, buseo
        FROM insa
        WHERE city = '��õ'
        UNION
        SELECT ename, job, job -- , deptno
        FROM emp
        WHERE deptno = 20;
        
        -- SQL ������ ���� �����ڸ� ����ϱ� ���ؼ���
        -- ���� ������ ����� �Ǵ� �� ���̺��� �÷� ���� ����, �����Ǵ� �÷����� ������ Ÿ���� �����ؾ� �Ѵ�
        -- �÷� �̸��� �޶� ��� ������, ���� ������ ����� ��µǴ� �÷��� �̸��� ù ��° SELECT ���� �÷� �̸��� ������.
        -- ORDER BY ���� ù ��°�� �� ��° SELECT ���� ���� ���� �Ĺ̿� �־�� �Ѵ�.
        
        -- ORA-01789: query block has incorrect number of result columns
        -- ������Ͽ� �߸��� ���� ��� ���� �ִ� / �÷� ���� ���ƾ��Ѵ�
        
        -- ORA-01790: expression must have same datatype as corresponding expression
        -- ������ �ش� �İ� ������ ������ ���ƾ� �Ѵ�
        
    2) ������(MINUS) ������
        SELECT name, city, buseo
        FROM insa
        WHERE buseo = '���ߺ�'
        MINUS
        SELECT name, city, buseo
        FROM insa
        WHERE city = '��õ'
        --
        SELECT name, city, buseo
        FROM insa
        WHERE buseo = '���ߺ�' AND city != '��õ';
        
    3) ������(INTERSECT) ������
        SELECT name, city, buseo
        FROM insa
        WHERE buseo = '���ߺ�'
        INTERSECT
        SELECT name, city, buseo
        FROM insa
        WHERE city = '��õ'
        --
        SELECT name, city, buseo
        FROM insa
        WHERE buseo = '���ߺ�' AND city = '��õ';

6. multiset ������
    1) MULTISET EXCEPT      : ù ��ø ���̺� �ִ� �� �߿��� ��° ��ø ���̺� �ִ� ���� ����
    2) MULTISET INTERSECT   : �� ��ø ���̺� �������� �ִ� �͸�
    3) MULTISET UNION       : �� ��ø ���̺� �ߺ����� �ʴ� ��� ��
    
7. ������ ���� ������
    PRIOR, CONNECT_BY_ROOT
    
8. ���Ῥ���� : ||
    - first_name || last_name
        �÷�     ����   �÷�
    SELECT ename || '����' -- ���ǥ���� �Ǵ� ������� ����
    FROM emp;

9. ���������
    SELECT 5+3, 5-3, 5*3, 5/3
          , MOD(5, 3) -- 5 - 3 * FLOOR(5/3)
          , REMAINDER(5, 3) -- 5 - 3 * ROUND(5/3) X
    FROM dual;
    FROM dept; -- ���ڵ� �� 4��
    FROM emp; -- ���ڵ� �� 12��

9-2. dual
    - ����Ŭ�� ��ġ�ϸ� �ڵ����� �����Ǵ� ���̺�
    - [SYS �����]�� �����ϴ� ����Ŭ�� ǥ�� ���̺�
    - �� ��(row)
    DESC dual;
    - �� ��(column)      ( DUMMY    VARCHAR2(1) ) 
    - �Ͻ����� ��������̳� ��¥ ������ ���Ͽ� �ַ� ���δ�.
    - SYS ����ڰ� ��� ����ڵ鿡�� ����� �� �ֵ��� �� ���̺� PUBLIC synonym(�ó��)�� �־���.
    
    -- scott.emp ��Ű��.���̺�� -> ����� ��Ī ������ �ο��ؼ� ������� -> �ó��(synonym)
    
    ��)
    ����Ŭ ��¥ �ڷ��� : DATE, TIMESTAMP
    SELECT SYSDATE -- 23/03/16 �Խ��� �۾���( �ۼ��� SYSDATE INSERT)
          , CURRENT_DATE -- 23/03/16
          , CURRENT_TIMESTAMP -- 23/03/16 14:38:26.000000000 ASIA/SEOUL
    FROM dual;

9-3. �ó��(synonym == ���Ǿ�)
    - �ó���� ����
    private synonym - ������(Owner)�� ���
    public synonym - ��ΰ� ���
    - �ó���� ����
    �����ġ�
	CREATE [PUBLIC] SYNONYM [schema.]synonym��
  	FOR [schema.]object��;
    -- ����Ʈ�� private �ó���̴�.
    -- PUBLIC �ó���� ��� ����ڰ� ���� ������ �ó���� �����Ѵ�.
    -- PUBLIC �ó���� ��� ����ڰ� ���� �����ϱ� ������ ���� �� ������ ���� DBA���� �� �� �ִ�.
    - PUBLIC �ó���� ���� ����
    1) SYSTEM �������� �����Ѵ�.
    2) PUBLIC �ɼ��� ����Ͽ� �ó���� �����Ѵ�.
    3) ������ �ó�Կ� ���� ��ü �����ڷ� �����Ѵ�.
    4) �ó�Կ� ������ �ο��Ѵ�.
    
    �ǽ�) scott �������̱⿡ hr���� ( select ) ���� �ο�
    GRANT SELECT ON emp TO hr;

    - �ó���� ����
    public �ó���� DBA���� ������ �� �ִ�.(public �ó�� ������ ������ DBA�� ����)
    �����ġ�
	DROP [PUBLIC] SYNONYM synonym��;
    
    SELECT *
    -- FROM user_synonyms;
    FROM all_synonyms;
    
10. ����� ������
    CREATE OPERATOR�� ����ؼ� ������ ����
    
11. floating point condition
    ( �ε� �Ҽ��� ���� )
    IS [NOT] NAN        Not A Number
    IS [NOT] INFINITE   

    SELECT -- 10/0
           -- MOD(10, 0)
           -- 'a' / 2
    FROM dual;
-------------------------------------------------------------------------------
����Ŭ �Լ� (function)
-------------------------------------------------------------------------------
1. �Լ� : ������ �������� �����ϰ� ���ְ� �������� ���� �����ϴµ� ���Ǵ� ��
2. �Լ��� ����
    1) ������ �Լ� : ���̺� ����Ǿ� �ִ� ���� ���� ������� �Լ��� �����Ͽ� �ϳ��� ����� ��ȯ�ϴ� �Լ��̴�.
        emp ���̺� ��� 12��
        ��) ���� �Լ�, ���� �Լ�, ��¥ �Լ�, ��ȯ �Լ�
        
        (1) ���� �Լ�
        -- ��. ROUND(number) Ư�� ��ġ���� �ݿø�
        �����ġ�
        ROUND ( n [,integer Ư�� ��ġ])
        
        SELECT 3.141592 PI
              , ROUND(3.141592) a -- 3
              , ROUND(3.141592, 0) b -- 3   b+1 �ڸ����� �ݿø�
              , ROUND(3.141592, 2) c -- 3.14    �Ҽ��� 3�ڸ����� �ݿø�
        FROM dual;
        
        SELECT 12345.6789
              , ROUND(12345.6789, -1) -- 12350
              , ROUND(12345.6789, -2) -- 12300
              , ROUND(12345.6789, -3) -- 12000
        FROM dual;
        
        [����] emp ���̺��� pay(sal+comm)
               �ѱ޿���(27125)
               �ѻ����(12)
               �Ҽ��� 3��° �ڸ����� �ݿø��� ��� �޿��� ����ϼ���
               -- ��� �޿� : 2260.42
               SELECT ROUND( (SELECT SUM( sal + NVL(comm, 0) ) FROM emp)/(SELECT COUNT(*) FROM emp), 2 ) avg_pay
               FROM dual;
               
        -- ��. TRUNC(a, b) Ư�� ��ġ ���� ����
        --                 b+1�ڸ����� ����
        --     FLOOR()     ������ �Ҽ��� ù��° �ڸ����� ����
        SELECT 3.141592 PI
              , TRUNC( 3.141592 ) a
              , TRUNC( 3.141592, 0) b
              , FLOOR( 3.141592 ) c
              , TRUNC( 3.141592, 2 ) d -- 2+1 �ڸ����� ����
        FROM dual;
        
        -- ��. CEIL()  �Ҽ��� ù��° �ڸ����� ����(�ø�) -> ������ ����
        SELECT 3.141592 PI
              , CEIL( 3.141592 ) a
        FROM dual;
        
        [����] ���� ������ �Ҽ��� 3��° �ڸ����� �ø��ϼ���
        SELECT CEIL( 3.141592 * 100 ) / 100
        FROM dual;
        
        �� �Խñ� �� 154��
        �� �������� ����� �Խñ� �� 15��
        �� ������ �� ?
        SELECT CEIL( 154/15 )
        FROM dual;
        
        -- ��. ABS() ���밪
        SELECT ABS(10), ABS(-10) Absolute
             , ABS(11.2), ABS(-11.2)
        FROM dual;
        
        -- ��. SIGN() ���ڰ��� ��ȣ�� ���� 1, 0, -1 ���� ����
        SELECT SIGN(0) -- 0
             , SIGN(10) -- 1
             , SIGN(100) -- 1
             , SIGN(-1) -- -1
             , SIGN(-111) -- -1
        FROM dual;
        
        [����] emp ���̺��� ��� �޿��� ���ؼ�
              �� ����� �޿��� ��� �޿����� ������ "��� �̻�" ��� / ������ "��� ����" ���
        -- NULLIF() �Լ�, SIGN() �Լ�
        SELECT ROUND( SUM( sal + NVL(comm, 0) ) / COUNT(*), 2 ) avg_pay
        FROM emp;
        
        SELECT ROUND( AVG( sal + NVL(comm, 0) ), 2 ) avg_pay
        FROM emp;
        
        SELECT ename, pay, avg_pay
             , pay - avg_pay difference
             , SIGN( pay - avg_pay ) sign
             , NVL2( NULLIF( SIGN( pay - avg_pay), -1 ),'��� �̻�', '��� ����') result
             , REPLACE( REPLACE( SIGN( pay - avg_pay ), -1, '��� ����' ), 1, '��� �̻�' ) message
--           , REPLACE( REPLACE( SIGN( pay - avg_pay ), 1, '��� �̻�' ), -1, '��� ����' ) message
        FROM (
            SELECT ename, sal + NVL(comm, 0) pay
                 , (SELECT ROUND( AVG( sal + NVL(comm, 0) ), 2 ) FROM emp) avg_pay
            FROM emp
        );
        
    2) ������ �Լ� ( �׷� �Լ� ) : ���ǿ� ���� ���� ���� �׷�ȭ�Ͽ� �׷캰�� ����� �ϳ��� ��ȯ�ϴ� �Լ��̴�.
    ��) MAX(), MIN(), SUM(), COUNT(), AVG()
    SELECT COUNT(*)
    FROM emp;
    
    �ѱ޿��� ��ȸ
    SELECT SUM( sal + NVL(comm, 0) ) total_pay
    FROM emp;







































