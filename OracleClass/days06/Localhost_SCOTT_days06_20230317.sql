36	2023-03-17

1. dept ���̺�   deptno = 50,  dname = QC,  loc = SEOUL  �� ���ο� �μ����� �߰�

DML(INSERT) + COMMIT/ROLLBACK
INSERT INTO ���̺�� [(�÷���...)] VALUES (��...);
ROLLBACK;
COMMIT;
--
-- (1) ORA-00984: column not allowed here
-- ���� �̰��� ������� �ʴ´�
INSERT INTO dept (deptno, dname, loc) VALUES ( 40, QC, SEOUL );
-- ����Ŭ ���� �Ǵ� ��¥�� '' ���δ�
-- (2) ORA-00001: unique constraint (SCOTT.PK_DEPT) violated
-- ���ϼ� �������ǿ� ����ȴ� -> deptno �μ���ȣ�� �ߺ��Ǹ� �ȵȴ�
INSERT INTO dept (deptno, dname, loc) VALUES ( 40, 'QC', 'SEOUL' );
INSERT INTO dept (deptno, dname, loc) VALUES ( 50, 'QC', 'SEOUL' );
-- 1 �� ��(��) ���ԵǾ����ϴ�.
COMMIT;

1-2. dept ���̺� QC �μ��� ã�Ƽ� �μ���(dname)�� ����(loc)�� 
  dname = ����μ��� 2�� �߰�,  loc = POHANG ���� ����

-- DML(UPDATE) + COMMIT
UPDATE ���̺��
SET �÷Ÿ� = ��, �÷��� = ��, ...
[WHERE] �����ϸ� ��� ���ڵ�(��) ����
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

1-3. dept ���̺��� QC2 �μ��� ã�Ƽ� deptno(PK)�� ����ؼ� ����

-- DML(DELETE) + COMMIT
DELETE FROM ���̺��
[WHERE] �����ϸ� ��� ���ڵ�(��) ����
--
-- ORA-02292: integrity constraint (SCOTT.FK_DEPTNO) violated - child record found
-- ���Ἲ �������ǿ� ����ȴ� -> �ڽ� ���ڵ�(��) ã�Ҵ�
-- 10 -> emp 10����� ���� -> ���� �Ұ�
-- 20 -> emp 20����� ���� -> ���� �Ұ�
-- 30 -> emp 30����� ���� -> ���� �Ұ�
-- 40, 50 ���� ����
DELETE FROM dept
WHERE deptno = 50;
COMMIT;

2.  insa ���̺��� ���ڴ� 'X', ���ڴ� 'O' �� ����(gender) ����ϴ� ���� �ۼ�
    1. REPLACE() ����ؼ� Ǯ��

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

    2. ����(SET)������ ����ؼ� Ǯ��

SELECT name, ssn
--   , MOD( SUBSTR( ssn, -7, 1 ), 2 ) gender
     , 'X' gender
FROM insa
WHERE MOD( SUBSTR( ssn, -7, 1 ), 2 ) = 1
-- WHERE gender = 1; -- ORA-00904: "GENDER": invalid identifier
UNION -- UNION ALL ������ �� (��ġ�� �� ����)
SELECT name, ssn
     , 'O' gender
FROM insa
WHERE MOD( SUBSTR( ssn, -7, 1 ), 2 ) = 0;

    3. NULL ó�� �Լ� : NVL(), NVL2(), *** NULLIF() ***

NULLIF( e1, e2 )    e1 = e2     NULL ��ȯ
                    e1 != e2    e1 ��ȯ
-- ��)
SELECT ename, NULLIF( ename, 'SMITH' ) -- SMITH�� null ��ȯ
FROM emp;
--
SELECT name, ssn
--   , MOD( SUBSTR( ssn, -7, 1 ), 2 )
--   , NULLIF( MOD( SUBSTR( ssn, -7, 1 ), 2 ), 1 )
     , NVL2( NULLIF( MOD( SUBSTR( ssn, -7, 1 ), 2 ), 1 ), 'O', 'X' ) gender
FROM insa;
    
    NAME                 SSN            GENDER
    -------------------- -------------- ------
    ȫ�浿               771212-1022432    X
    �̼���               801007-1544236    X
    �̼���               770922-2312547    O
    ������               790304-1788896    X
    �Ѽ���               811112-1566789    X 

3.  insa ���̺��� 2000�� ���� �Ի��� ���� ��ȸ�ϴ� ���� �ۼ�
    1. TO_CHAR() �Լ� ����ؼ� Ǯ��

SELECT name, ibsadate
FROM insa
WHERE TO_CHAR(ibsadate, 'YYYY') >= 2000;

    2. EXTRACT() �Լ� ����ؼ� Ǯ��.

SELECT name, ibsadate
FROM insa
WHERE EXTRACT( YEAR FROM ibsadate ) >= 2000;

    3. WHERE ��¥�� �񱳿����� ��� ����
    
SELECT name, ibsadate
FROM insa
WHERE ibsadate >= '2000.1.1';
    
    NAME                 IBSADATE
    -------------------- --------
    �̹̼�               00/04/07
    �ɽ���               00/05/05
    �ǿ���               00/06/04
    ������               00/07/07    
    
4. ���ݱ��� ��� ����Ŭ �ڷ����� ��������.
   ��. CHAR - ����
   ��. VARCHAR2 - ����
   ��. NUMBER - ����(����, �Ǽ�)
   ��. DATE - YY/MM/DD
   ��. TIMESTAMP - YY/MM/DD hh:mm:ss.sss...

5. ���� �ý����� ��¥ ����ϴ� ������ �ۼ��ϼ���. 
SELECT ( SYSDATE ) : ���� �ý����� ��¥ + �ð�
     , ( CURRENT_DATE ) : ���� ����(SESSION)�� ��¥ + �ð�
     , ( CURRENT_TIMESTAMP ) : ���� ������ ��¥ + �ð� + Ÿ���� ���
FROM dual;
    
6. �ó��(synonym)�� ���ؼ� ������ �����ϼ���. 
schema.object �������� ��� ����ϱ� ���ŷο� �� synonym�� �����ؼ� �����ϰ� ����� �� �ִ�
public synonym�� �ٸ� �������� �����ص� ���Ѹ� �ο��Ǹ� ����� �� �ִ�
--
1) ���� : �ϳ��� ��ü�� ���� �ٸ� �̸��� ������ ��
         ��Ű��.��ü�� -> ��Ī(�ó��)
2) ���� : PRIVATE, PUBLIC
3) ����, ���� ����
4) ��ȸ : all_synonyms ��� �ó�� ���� ��ȸ
        user_synonyms ����ڰ� ���� �ó�� ��ȸ

7. SQL ���� �������� ������ ������ �ϼ���
  1) ����
  UNION : A + B - ( A AND B )
  UNION ALL : A + B
  MINUS : A - B == A AND !B
  INRETSECT : A AND B
  
  2) ������ ��
  �� ���̺��� �÷� ���� ����, �����Ǵ� �÷����� ������ Ÿ���� �����ؾ� �Ѵ�
  ORDER BY ���� ���� �������� �־�� �ȴ�
  ��µǴ� �÷��� ù��° SELECT���� �÷� �̸��� ������

8.  insa ���̺���  �ֹι�ȣ�� �Ʒ��� ���� '-' ���ڸ� �����ؼ� ���

SELECT name, ssn
     , SUBSTR( ssn, 1, 6 ) || SUBSTR( ssn, -7 ) ssn
     , CONCAT( SUBSTR( ssn, 1, 6 ), SUBSTR( ssn, -7 ) ) ssn
     , REPLACE( ssn, '-', '' ) ssn_2
     , REPLACE( ssn, '-', ) ssn_2
FROM insa;
 
    NAME    SSN             SSN_2
    ȫ�浿	770423-1022432	7704231022432
    �̼���	800423-1544236	8004231544236
    �̼���	770922-2312547	7709222312547      

[�����Լ�]
9. ROUND() 
   1) �Լ� ���� : Ư�� ���� Ư�� ��ġ���� �ݿø��ϴ� �Լ�
   2) ���� ���� : ROUND(a,b)�� �� b�� ����� a�� �Ҽ��� b+1 �ڸ����� �ݿø��ϰ�, b�� ������ ���� -b �ڸ����� �ݿø��Ѵ�
   3) ���� ����
        SELECT    3.141592 -- 3.141592
               , ROUND(  3.141592 )     a -- b ���� ���� �� ����Ʈ���� 0�̴� -- 3
               , ROUND(  3.141592,  0 ) b -- b == 0 �̹Ƿ� �Ҽ��� 1�ڸ����� �ݿø��Ѵ� -- 3
               , ROUND(  3.141592,  2 ) c -- b == 2 �̹Ƿ� �Ҽ��� 3�ڸ����� �ݿø��Ѵ� -- 3.14
               , ROUND(  3.141592,  -1 ) d -- b == -1 �̹Ƿ� ���� 1�ڸ����� �ݿø��Ѵ� -- 0
               , ROUND( 12345  , -3 )  e -- b == -1 �̹Ƿ� ���� 3�ڸ����� �ݿø��Ѵ� -- 12000
       FROM dual;

9-2. TRUNC()�Լ��� FLOOR() �Լ��� ���ؼ� �����ϼ���.        
TRUNC() : Ư�� ���� Ư�� ��ġ���� ����(����)�Ѵ�
          TRUNC(a,b)�� �� b�� ����� a�� �Ҽ��� b+1 �ڸ����� �����ϰ�, b�� ������ ���� -b �ڸ����� �����Ѵ�
FLOOR() : Ư�� ���� �Ҽ��� 1�ڸ����� �����Ѵ� == ������ ���

9-3. CEIL() �Լ��� ���ؼ� �����ϼ���. 
CEIL() : Ư�� ���� �Ҽ��� 1�ڸ����� ����(�ø�)�Ѵ�

9-4. ������ ���� �����ϴ� �Լ� :  (   MOD()   )
9-5. ���밪�� �����ϴ� �Լ� :   (   ABS()   )
9-6. SING() �Լ��� ���ؼ� �����ϼ���.
SIGN() : ���ڰ��� ��ȣ�� ���� ����� 1, 0�̸� 0, ������ -1 ���� �����Ѵ�

10.emp ���̺��� �޿��� ��ձ޿��� ���ϰ�
   �� ����� �޿�-��ձ޿��� �Ҽ��� 3�ڸ����� �ø�,�ݿø�,�����ؼ� �Ʒ��� 
   ���� ��ȸ�ϴ� ������ �ۼ��ϼ���.

SELECT ename, pay, avg_pay
     , CEIL( pay - avg_pay ) "�� �ø�"
     , ROUND( pay - avg_pay ) "�� �ݿø�"
     , FLOOR( pay - avg_pay ) "�� ����"
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
                --                                          ���ϱ׷� �׷��Լ��� �ƴϴ�
                -- �Լ��� ���� 2����
                -- 1) ������ �Լ�
                -- 2) ������ �Լ� (�׷��Լ�, �����Լ�)
                -- �Ϲ��÷��� �׷��Լ��� ���� ����� �� ����
                -- �Ϲ��÷� + �׷��Լ� ���� ����� �� �ִ� ��� : group by ���� ����ϸ� �����ϴ�
                    , ( SELECT AVG( sal + NVL(comm,0) ) avg_pay FROM emp ) avg_pay
                -- ORA-00936: missing expression
                --            ������(����) ǥ���� -> ���������� ��ȣ ����
                FROM emp
            )
SELECT t.ename, t.pay
     , ROUND( t.avg_pay, 2 ) avg_pay
     , t.pay - t.avg_pay "��� �޿����� ����"
     -- , CEIL( t.pay - t.avg_pay, 2 ) "�ø�"
     , CEIL( (t.pay - t.avg_pay)*100 )/100 "�ø�"
     , ROUND( t.pay - t.avg_pay, 2 ) "�ݿø�"
     , TRUNC( t.pay - t.avg_pay, 2 ) "����"
FROM temp t;
-- ORA-00909: invalid number of arguments
--             �߸���   ����    ����(�Ű�����)
--
SELECT AVG( sal + NVL(comm,0) ) avg_pay FROM emp;
-- ��� ���ϱ�
SELECT
    SUM( sal + NVL(comm,0) ) tot_pay
  , COUNT( * ) cnt
  , SUM( sal + NVL(comm,0) )/COUNT( * ) avg_pay
  , AVG( sal + NVL(comm,0) ) avg_pay
FROM emp;
   
ENAME             PAY    AVG_PAY       �� �ø�      �� �ݿø�       �� ����
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

ENAME             PAY    AVG_PAY       �� �ø�      �� �ݿø�       �� ����
---------- ---------- ---------- ---------- ---------- ----------
MILLER           1300    2260.42    -960.41    -960.42    -960.41

10-2. emp ���̺��� �޿��� ��ձ޿��� ���ϰ�
    �� ����� �޿��� ��ձ޿� ���� ������ "����"
                   ��ձ޿� ���� ������ "����"��� ���
                   
SELECT ename, pay, avg_pay
     , pay - avg_pay difference
     , REPLACE( REPLACE( SIGN( pay - avg_pay ), -1, '����' ), 1, '����' ) message
FROM (
        SELECT ename, sal + NVL(comm, 0) pay
            , (SELECT ROUND( AVG( sal + NVL(comm, 0) ), 2 ) FROM emp) avg_pay
        FROM emp
    );
--
-- ��ձ޿� ( 2077.08 )
SELECT ROUND( AVG( sal ), 2 ) avg_pay
FROM emp;
-- (1) [ SET ������ ]
SELECT ename, sal, '����'
FROM emp
WHERE sal > 2077.08
UNION
SELECT ename, sal, '����'
FROM emp
WHERE sal < 2077.08
UNION
SELECT ename, sal, '����'
FROM emp
WHERE sal = 2077.08;

-- (2)
SELECT ROUND( AVG( sal ), 2 ) avg_sal FROM emp;
--
SELECT SIGN(100), SIGN(-1000), SIGN(0)
FROM dual;
-- REPLACE() �Լ� ���� -[1] -> -[X]
SELECT -1, '-1'
     , REPLACE( -1, 1, 'X' )
FROM dual;
--
SELECT t.*
     , t.sal - t.avg_sal diff
     , SIGN( t.sal - t.avg_sal ) s
     , '��� sal���� ' || REPLACE( REPLACE( REPLACE( SIGN( t.sal - t.avg_sal ), -1, '����' ), 1, '����' ), 0, '����' ) x
--   , REPLACE( REPLACE( SIGN( t.sal - t.avg_sal ), 1, '����' ), -1, '����' ) x
FROM (
        SELECT empno, ename, sal, ( SELECT ROUND( AVG( sal ), 2 ) avg_sal FROM emp ) avg_sal
        FROM emp
    ) t;

11. insa ���̺��� ��� ������� 14�� ���� ����� �� �� ���� �������� ������ �ۼ��ϼ���.
 ( ��Ʈ : ����(�׷�)�Լ� ���)
 
SELECT COUNT( * ) "�� �����"
     , 14 "�� �����"
     , CEIL( COUNT( * )/14 ) "�� ����" -- ����(�ø�)
FROM insa;

12. emp ���̺��� �ְ� �޿���, ���� �޿��� ���� ��� ��ȸ
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
-- �������� ���� ���� �߸��� �ڵ�
SELECT *
FROM emp
WHERE sal + NVL(comm,0) IN (
                                SELECT MAX( sal + NVL(comm,0) ) max_pay
                                     , MIN( sal + NVL(comm,0) ) min_pay
                                FROM emp
                            );
-- ORA-00913: too many values
-- 884��, 33������ ���� �߻� (SELECT MAX ~)

-- (2)
SELECT *
FROM emp
WHERE sal + NVL(comm,0) = ( SELECT MAX( sal + NVL(comm,0) ) FROM emp )
UNION
SELECT *
FROM emp
WHERE sal + NVL(comm,0) = ( SELECT MIN( sal + NVL(comm,0) ) FROM emp );

-- (3)
-- ALL, ANY, SOME ( �񱳿����� )         TRUE/FALSE EXISTS, SQL������
-- [ emp ���̺��� �ְ�/���� �޿��� ]
SELECT e.*, '�ְ� �޿���' "�ְ�/���� �޿���"
FROM emp e
WHERE sal+NVL(comm,0) >= ALL ( SELECT sal+NVL(comm,0) pay FROM emp )
UNION
SELECT e.*, '���� �޿���'
FROM emp e
WHERE sal+NVL(comm,0) <= ALL ( SELECT sal+NVL(comm,0) pay FROM emp );

                                            PAY(sal+comm)
7369	SMITH	CLERK	7902	80/12/17	800		    20  �ְ�޿���
7839	KING	PRESIDENT		81/11/17	5000		10  �����޿���

13. emp ���̺��� 
   comm �� 400 ������ ����� ���� ��ȸ
  ( comm �� null �� ����� ���� )
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

-- (4) LNNVL() �Լ�
WHERE LNNVL(���ǽ�)
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
    
14. emp ���̺��� �� �μ��� �޿�(pay)�� ���� ���� �޴� ����� ���� ���.    
    ( ��Ʈ : Correlated Subquery ��� ����, SET ������ ��� ���� )

SELECT *
FROM dept; -- 10, 20, 30, 40
-- 10�� �μ��� �߿� �ְ� �޿���
SELECT MAX(sal + NVL(comm, 0)) FROM emp WHERE deptno = 10; -- 2450
SELECT MAX(sal + NVL(comm, 0)) FROM emp WHERE deptno = 20; -- 3000
SELECT MAX(sal + NVL(comm, 0)) FROM emp WHERE deptno = 30; -- 2850
SELECT MAX(sal + NVL(comm, 0)) FROM emp WHERE deptno = 40; -- null
-- (1) SET ������
-- ������) 10�� �μ��� �ְ� �޿����� 2000�̶�� �����ϸ� �ٸ� �μ��� �޿����� 2000�� ����� ��µȴ�
--         10/2000, 20/2000, 30/2000
-- 7934	MILLER	CLERK	7782	82/01/23	1300		10
UPDATE emp
SET sal = 3000
WHERE empno = 7934;
ROLLBACK;
-- �ذ�)
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
-- ORDER BY deptno; -- ORA-00904: "DEPTNO": invalid identifier -> SELECT���� deptno �÷��� ���

-- (2) ��� �������� ( Correlated Subquery ) main qurey�� ���� ����
SELECT *
FROM emp p
WHERE sal + NVL(comm, 0) = (
                                SELECT MAX(sal + NVL(comm, 0))
                                FROM emp c 
                                WHERE c.deptno = p.deptno
                            );
-------------------------------------------------------------------------------
-- [ ���� �Լ� ]
-------------------------------------------------------------------------------
1. POWER(a,b)
2. SQRT ������
3. SIN(), COS(), TAN()
4. LOG()
   LN() �ڿ��α� - �ؼ� e�� �α��Լ�
   EXP() �����Լ� - �ؼ� e�� �����Լ�

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
     , INITCAP( ename ) -- �� �ܾ��� ù��° ���ڴ� �빮��, �������� �ҹ��ڷ� ��ȯ
     , LENGTH( ename ) -- ���ڿ��� ����
FROM emp;

5. INSTR( ���ڿ�, ã�����ϴ� ���ڿ� [, ã�� ������ ��ġ [, �߻� ��ȣ] ] ) -- ���ڰ� �� ������ ���ڰ��� ��ġ�� ���ڷ� �����Ѵ�
SELECT ename
     , INSTR( ename, 'L' ) L_first
     , INSTR( ename, 'L', INSTR( ename, 'L' )+1 ) L_second
     , INSTR( ename, 'L', 1, 2 ) L_second
     , INSTR( ename, 'L', -1, 2 ) L_second_back -- ename �ڿ������� �� ��° ���� L�� ��ġ�� ã�ڴ�
FROM emp;

6. RPAD()/LPAD()
   Right + PAD, Left + PAD
   PAD = �е�, �� ��� ��, �޿� �ִ� ��
�����ġ�
      RPAD (expr1, n [, expr2] )
SELECT ename, sal + NVL(comm,0) pay
     , RPAD( sal + NVL(comm,0), 10, '*' )
     , LPAD( sal + NVL(comm,0), 10, '*' )
FROM emp;
��) pay 100���� * ��� (.5 �ݿø�)
SELECT ename, sal + NVL(comm,0) pay
     , ROUND( (sal + NVL(comm,0))/100 ) n
     , RPAD( ' ',  ROUND( (sal + NVL(comm,0))/100 )+1, '#' ) "bar"
FROM emp;

7. RTRIM()/LTRIM() : ���ڰ� �߿��� ��/�������κ��� Ư�����ڿ� ��ġ�ϴ� ���ڰ��� �����Ѵ�
�����ġ�
      RTRIM(char [,set] )
-- �ڹ� String.trim() ��/�� ���� �����ϴ� �Լ�
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

13. VSIZE() -- ������ ���ڿ��� ũ�⸦ ���ڰ�(����Ʈ ��)���� �����Ѵ�
SELECT VSIZE('a'), VSIZE('��')
FROM dual;
-------------------------------------------------------------------------------
-- [ ��¥ �Լ� ]
-------------------------------------------------------------------------------
1. SYSDATE
SELECT SYSDATE -- '23/03/17' ���� �ý����� ��¥ + (�ð� ����)
FROM dual;

2. ROUND( ��¥ )
�����ġ�
	ROUND( date [,format ����] )

SELECT SYSDATE -- 23/03/17
     , ROUND( SYSDATE ) --  23/03/18 -- ��¥ ������ ������ ���� ����� ���� ����Ѵ�
     , ROUND ( SYSDATE, 'DD' ) -- 23/03/18 ���� �ݿø��� �� ������ ������ ������ ������ ����ϰ�, ���� ������ �� �� ������ ����Ѵ�
     , ROUND ( SYSDATE, 'MONTH' ) -- 23/04/01 ���� �ݿø��ϴ� ���� 15�� �̻��̸� ������ 1���� ����ϰ�, ���� ������ ���� �� 1���� ����Ѵ�
     , ROUND ( SYSDATE, 'YEAR' ) -- 23/01/01 ���� �ݿø��ϴ� ��쿡�� 6���� ������ ������ 1�� 1���� ����ϰ�, ���� ������ �� �� 1�� 1���� ����Ѵ�
FROM dual;

3. TRUNC( ��¥ )
SELECT SYSDATE
     , TRUNC( SYSDATE ) -- 23/03/17 ���� ������ ���� ����ȴ�
     , TRUNC ( SYSDATE, 'DD' ) -- 23/03/17 ��:��:��
     , TRUNC ( SYSDATE, 'MONTH' ) -- 23/03/01
     , TRUNC ( SYSDATE, 'YEAR' ) -- 23/01/01
FROM dual;

4. MONTHS_BETWEEN() : �� ��¥ ������ ������
-- �� ������� �ٹ��ϼ�, �ٹ������� �ľ�(��ȸ)
SELECT ename, hiredate, SYSDATE
     , ROUND( MONTHS_BETWEEN( SYSDATE, hiredate ), 1 ) �ٹ�������
     , CEIL( SYSDATE - hiredate ) �ٹ��ϼ� -- ( ��¥ - ��¥ = �ϼ� )
FROM emp;

5. ADD_MONTHS() -- '3/31' �Ѵ� �� 2/28,29
SELECT SYSDATE
     , ADD_MONTHS( SYSDATE, 1 )
     , ADD_MONTHS( SYSDATE, -1 )
FROM dual;

6. LAST_DAY -- Ư�� ��¥�� ���� ���� ���� ������ ��¥�� �����ϴ� �Լ�
SELECT SYSDATE
     , LAST_DAY( SYSDATE ) -- 23/03/31
FROM dual;

7. NEXT_DAY -- ��õ� ������ ���ƿ��� ���� �ֱ��� ��¥�� �����ϴ� �Լ�
�����ġ�
      NEXT_DAY(date,char)
      
SELECT SYSDATE -- 23/03/17
     , TO_CHAR( SYSDATE, 'YYYY' ) year
     , TO_CHAR( SYSDATE, 'MM' ) month
     , TO_CHAR( SYSDATE, 'DD' ) "DATE"
     , TO_CHAR( SYSDATE, 'DAY' ) day
     -- ���� �� ������ ������ (���)
     , NEXT_DAY( SYSDATE, '������' ) -- 23/03/20
FROM dual;
-------------------------------------------------------------------------------
��¥ + ���� = ��¥
��¥ - ���� = ��¥
��¥ + ����/24(�ð�) = ��¥
��¥ - ��¥ = �ϼ� ***

SELECT SYSDATE
     , SYSDATE + 3 -- 3�� �ڿ� ������
     , SYSDATE - 10
     , SYSDATE + 2/24 -- 2�ð� ���� ��¥
FROM dual;
-------------------------------------------------------------------------------
Ora_Help    function �˻��� �� datetime ���� ������ �����ߴ�
-- ������
-- ���� �Լ� ����
-- ����Ŭ �ڷ���
-- ���̺� ����/����/����/�������� + DML��





























