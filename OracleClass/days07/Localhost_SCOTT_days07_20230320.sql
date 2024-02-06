-- SCOTT --
1. emp ���̺��� 30�� �μ��� PAY�� ��� �� ����׷����� �Ʒ��� ���� �׸��� ���� �ۼ�
   ( �ʿ��� �κ��� ��� �м��ϼ���~    PAY�� 100 ������ # �Ѱ� , �ݿø�ó�� )

SELECT deptno, ename, sal+NVL(comm,0) pay, ROUND( (sal+NVL(comm,0))/100 ) bar_length, RPAD( ' ',  ROUND( (sal+NVL(comm,0))/100 )+1, '#' ) " "
FROM emp
WHERE deptno = 30
ORDER BY bar_length DESC;
   
[������]
DEPTNO ENAME PAY BAR_LENGTH      
---------- ---------- ---------- ----------
30	BLAKE	2850	29	 #############################
30	MARTIN	2650	27	 ###########################
30	ALLEN	1900	19	 ###################
30	WARD	1750	18	 ##################
30	TURNER	1500	15	 ###############
30	JAMES	950	    10	 ##########

1-2. insa ���̺��� �ֹε�Ϲ�ȣ�� 123456-1******  �������� ����ϼ��� . 
( LPAD, RPAD �Լ� ���  )

SELECT name, ssn, RPAD( SUBSTR( ssn, 1, 8), 14, '*' ) ssn_rpad, LPAD( '******', 14, ssn ) ssn_lpad
FROM insa;

[������]
ȫ�浿	770423-1022432	770423-1******
�̼���	800423-1544236	800423-1******
�̼���	770922-2312547	770922-2******

2. SELECT TRUNC( SYSDATE, 'YEAR' ) -- 23/01/01 : ���� ��¥ ���� �⵵ ������ �����ؼ� 1�� 1��
      , TRUNC( SYSDATE, 'MONTH' ) -- 23/03/01 : ���� ��¥ ���� �� ������ �����ؼ� 3�� 1��
      , TRUNC( SYSDATE ) -- 23/03/20 : ���� ������ ���� �����ؼ� ��¥ �״��
    FROM dual;
    ���� ������ ����� �������� . 

3. emp ���� ���PAY ���� ���ų� ū ����鸸�� �޿����� ���.

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
-- ������ �Լ��� ������ �Լ��� ���ÿ� ����� �� ����
-- ������ �Լ� -> ��������
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

[������]
NAME             SAL       COMM        PAY    AVG_PAY
---------- ---------- ---------- ---------- ----------
JONES            2975                  2975 2260.41667
MARTIN           1250       1400       2650 2260.41667
BLAKE            2850                  2850 2260.41667
CLARK            2450                  2450 2260.41667
KING             5000                  5000 2260.41667
FORD             3000                  3000 2260.41667

4. emp ���̺��� �� �μ��� �޿��� ���� ���� �޴� ����� pay�� ���

SELECT a.*, a.sal + NVL(a.comm,0) pay
FROM emp a
WHERE a.sal + NVL(a.comm,0) = (
                                    SELECT MAX( b.sal + NVL(b.comm,0) ) max_pay_dept
                                    FROM emp b
                                    WHERE b.deptno = a.deptno
                                )
ORDER BY deptno;
--
����( RANK ) �Լ� / TOP-N ���

5. �̹� ����  ���� ���� �ִ� �� ����ϼ���. 

SELECT TO_CHAR( LAST_DAY( SYSDATE ), 'DD' ) this_month_lastday
     , TO_CHAR( TRUNC( ADD_MONTHS( SYSDATE, 1 ), 'MONTH' ) - 1, 'DD' ) this_month_lastday_2
FROM dual;

6. ���� �� �������� �ް����̴�.. �� ���ΰ��� ? 

SELECT NEXT_DAY( SYSDATE, '������' ) �ް���
FROM dual;

7. emp ���̺���
   �� ������� �Ի����ڸ� �������� 10�� 5���� 20��° �Ǵ� �� ? 

SELECT hiredate, ADD_MONTHS( hiredate, 125 ) + 20 add_mont
FROM emp;

    [������]
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
        
        12�� ���� ���õǾ����ϴ�.

8.  insa ���̺���
    �����ȣ(num) ��  1002 �� ����� �ֹι�ȣ�� ��,�ϸ��� ���ó�¥�� �����ϼ���.
                              ssn = '80XXXX-1544236'                              

UPDATE insa
SET ssn = REPLACE( ssn, SUBSTR( ssn, 3, 4 ), TO_CHAR( SYSDATE, 'MMDD' ) )
WHERE num = 1002;
COMMIT;

8-2. insa ���̺��� ������ �������� ������ ���� ���θ� ����ϴ� ������ �ۼ��ϼ��� . 
     ( '������', '��������', '���� ' ó�� )
     
SELECT num, name, ssn
     , SUBSTR( ssn, 3, 4 )
     , TO_CHAR( SYSDATE, 'MMDD' )
     , SIGN( SUBSTR( ssn, 3, 4 ) - TO_CHAR( SYSDATE, 'MMDD' ) ) s
FROM insa;

9. �Լ� ����
    9-1. NULLIF() �Լ� ����
    9-2. COALESCE() �Լ� ����
    9-3. DECODE() �Լ� ����
    9-4. LAST_DAY() �Լ� ����
    9-5. ADD_MONTHS() �Լ� ����
    9-6. MONTHS_BETWEEN() �Լ� ����
    9-7. NEXT_DAY() �Լ� ����
    9-8. EXTRACT() �Լ� ����
    
     ��. ASCII() �Լ� ����
     ��. CHR() �Լ� ����
     ��. GREATEST() �Լ� ����
     ��. LEAST() �Լ� ����
     ��. UPPER() �Լ� ����
     ��. LOWER() �Լ� ����
     ��. LENGTH() �Լ� ����
     ��. SUBSTR() �Լ� ����
     ��. INSTR() �Լ� ����   

10.  emp ���̺��� ename, pay , �ִ�pay�� 5000�� 100%�� ����ؼ�
   �� ����� pay�� ��з��� ����ؼ� 10% �� ���ϳ�(*)�� ó���ؼ� ���
   ( �Ҽ��� ù ° �ڸ����� �ݿø��ؼ� ��� )

SELECT t.*
     , (t.pay*100)/t.max_pay || '%' percent
     , ROUND( (t.pay*100)/t.max_pay/10 ) star_count
     , RPAD ( ' ', ROUND( (t.pay*100)/t.max_pay/10 )+1, '*' ) " "
FROM (
SELECT ename, sal + NVL(comm,0) pay
     , ( SELECT MAX( sal + NVL(comm,0) ) max_pay FROM emp ) max_pay
FROM emp
    ) t;

[������]
ename   pay     max_pay �ۼ�Ʈ    ������
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

-- TO_CHAR ( ���� �Ǵ� ��¥ ) -> ���� ��ȯ�Լ�
-- TO_TIMESTAMP( ���� ) -> ��¥( TIMESTAMP ) ��ȯ�Լ�
-- TO_DATE( ���� ) -> ��¥( DATE ) ��ȯ�Լ�
����Ŭ ��¥ �ڷ��� : DATE, TIMESTAMP

SELECT to_timestamp('2004-8-20 1:30:00', 'YYYY-MM-DD HH:MI:SS')
FROM dual;

-- [ ��ȯ �Լ��� ���� ]
1) TO_NUMBER() : ���� -> ���ڷ� ��ȯ�ϴ� �Լ�
2) TO_CHAR( ���� ) : ���� -> ���ڷ� ��ȯ�ϴ� �Լ�
   TO_CHAR( ��¥ ) : ��¥ -> ���ڷ� ��ȯ�ϴ� �Լ�
3) TO_DATE( ���� ) : ���� -> ��¥�� ��ȯ�ϴ� �Լ�

4) CONVERT : ���ڸ� �� ���� ���� -> �ٸ� ���� �������� ��ȯ
5) HEXTORAW : 16���� ���� -> 2���� ���ڷ� ��ȯ

-- ����Ŭ ����, ��¥�� '' ���δ�
-- ����Ŭ ����(��) �ڷ��� : CHAR, VARCHAR2, NCHAR, NVARCHAR2 

-- 1) TO_NUMBER() : ���� -> ���ڷ� ��ȯ�ϴ� �Լ�
SELECT '12' "���ڿ� 12", 12 "���� 12"
     , '12' - 12 -- �ڵ����� ���� 12�� ����ȯ
     , TO_NUMBER( '12' ) - 12
     , 12 - 12
FROM dual;
     
-- 2-1) TO_CHAR( ���� ) : ���� -> ���ڷ� ��ȯ�ϴ� �Լ�
�����ġ�
      TO_CHAR( n [,'fmt' [,'nlsparam']])
--
SELECT 12345
     , TO_CHAR( 12345 ) �� -- '12345'
     , TO_CHAR( 12345, '99,999' ) �� -- , : ���ڸ����� �޸� �� ��� '12,345'
     , TO_CHAR( 12345, '99,999.00' ) �� -- . : ����� ��ġ�� �Ҽ���, 0 : ������ 0���� ǥ�� '12,345.00'
     , TO_CHAR( 12345, 'L99,999' ) �� -- L : ȭ���ȣ '��12,345'
     , TO_CHAR( 12345, 'S99,999' ) �� -- S : +/- ��ȣ '+12,345'
FROM dual;
--
SELECT ename, sal, comm
     , TO_CHAR( sal + NVL(comm,0)*12, '$99,999.99' ) ����
FROM emp
WHERE comm IS NOT NULL;

-- 2-2) TO_CHAR( ��¥ ) : ��¥ -> ���ڷ� ��ȯ�ϴ� �Լ�
�����ġ�
 	TO_CHAR( date [,'fmt' [,'nlsparam']])
--
-- [ YY�� RR�� ������ ]
-- YY : �� �ڸ��� �⵵ : ������ �ý��� ���� �⵵�� ���δ�
--      [20]65/01/02
--      [20]12/02/24
-- RR : �� �ڸ��� �⵵ : 50~99 ���� �⵵, 00~49 ���� �⵵
--      [19]65/01/02
--      [20]12/02/24

-- ��¥���� : RR/MM/DD

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
     
     , TO_CHAR( SYSDATE, 'DD' ) c -- ���� ��
     , TO_CHAR( SYSDATE, 'D' ) c -- ���� ��
     , TO_CHAR( SYSDATE, 'DDD' ) c -- ���� ��
     
     , TO_CHAR( SYSDATE, 'MMDD' ) d
     , TO_CHAR( SYSDATE, 'BC' ) e -- BC/AD
     , TO_CHAR( SYSDATE, 'Q' ) f -- �б�
     
     , TO_CHAR( SYSDATE, 'HH' ) g
     , TO_CHAR( SYSDATE, 'HH24' ) g
     , TO_CHAR( SYSDATE, 'MI' ) h
     , TO_CHAR( SYSDATE, 'SS' ) i
     , TO_CHAR( SYSDATE, 'SSSSS' ) i
     
     , TO_CHAR( SYSDATE, 'DY' ) j
     , TO_CHAR( SYSDATE, 'DAY' ) j
     
     , TO_CHAR( SYSDATE, 'WW' ) k -- ���� ��
     , TO_CHAR( SYSDATE, 'W' ) k -- ���� ��
     , TO_CHAR( SYSDATE, 'IW' ) k -- ���� ��
     -- WW�� IW�� ��������?
     
     , TO_CHAR( SYSDATE, 'DL' ) l -- 2023�� 3�� 20�� ������
     , TO_CHAR( SYSDATE, 'DS' ) l -- 2023/03/20
FROM dual;
--
SELECT ename, hiredate
     , TO_CHAR( hiredate, 'DS' )
FROM emp;
-- 'FF' �и�������
-- ORA-01821: date format not recognized
-- DATE : SYSDATE �и������� ���� �������� �ʴ´�
SELECT SYSDATE
--   , TO_CHAR( SYSDATE, 'HH24:MI:SS.FF' )
     , TO_CHAR( CURRENT_TIMESTAMP, 'HH24:MI:SS.FF3' )
     , TO_CHAR( SYSDATE, 'TS' ) -- ���� 12:54:19
FROM dual;

[����] ���� ��¥�� TO_CHAR() �Լ� �̿��ؼ� '2023�� 03�� 20�� ���� 14:03:32 (��)' �������� ���

SELECT SYSDATE
--  , TO_CHAR (SYSDATE, 'YYYY' )  '��'  To_Char (SYSDATE, 'MM' )  '��'  .... 
    , TO_CHAR (SYSDATE, 'YYYY MM DD AM HH24:MI:SS DY') --> �̷��� �ѹ��� ����ᵵ �� ���� !
--  , TO_CHAR (SYSDATE, 'YYYY�� MM�� DD�� AM HH24:MI:SS DY') 
    --> ��¥ ������ �ν��� �� ���� (date format not recognized) : '��', '��','��'������ ����� ���� 
    --> " " ��� : ����� �Բ� ����� ���ڿ� ��Ÿ�� �� ���! 
    , TO_CHAR (SYSDATE, 'YYYY"��" MM"��" DD"��" AM HH24:MI:SS DY') 
FROM dual ;

-- 3) TO_DATE : ����, ���� Ÿ���� ��¥Ÿ������ ��ȯ (������ ����) 

�����ġ�
     TO_DATE( char, ['����'] )
*Datetime Format element�� TO_CHAR(datetime)�� ������ �Ͱ� ���� 

[����] ������ : 2023.07.10 -> ���ú��� �����ϱ��� ���� �ϼ�?
��¥-��¥ = �ϼ�
ex) �ٹ��ϼ� 
SELECT  CEIL (SYSDATE - hiredate) �ٹ��ϼ� -- �ø��ϴ� ���� : ���ϵ� ���� �ٹ��ϼ��� ����
FROM emp; 

SELECT SYSDATE - '2023.07.10' 
FROM dual ; 
--ORA-01722: invalid number
�� ���� : ��¥�� �ƴ� ���ڷ� �ν� 
�� �ذ� : ���ڷ� �νĵǴ� '2023.07.10'�� ��¥�� ��ȯ => TO_DATE 
��
, CEIL (ABS (SYSDATE-TO_DATE ('2023.07.10' )   )   ) "�����ϼ�" 



[����] 4�ڸ��� ���� �������� 0010, 0040 �μ���ȣ�� ��� 
SELECT deptno 
    , TO_CHAR (deptno, '0999') 
FROM dept ;
-------------------------------------------------------------------------------
-- [ �Ϲ��Լ� ]
1) NVL
2) NVL2
3) NULLIF
4) NANVL
5) COALESCE : ����(�յ�, ����)�ϴ�
    �����س��� ���� ���������� üũ�Ͽ� NULL�� �ƴ� ���� �����ϴ� �Լ�
�����ġ�
        COALESCE(expr[,expr,...])

SELECT ename, sal + NVL(comm,0) pay
     , COALESCE( sal + comm, sal, 0) pay
FROM emp;
-- '' == NULL �� ó���Ѵ� ( ��� )
SELECT COALESCE( '', '', 'arirang', 'Kunsan' )
FROM dual;

6) DECODE
-- ���� ���� ������ �־� ���ǿ� ���� ��� �ش� ���� �����ϴ� �Լ�
-- �� ������ = �� �����ϴ�
-- PL/SQL �ȿ��� ����� ����Ŭ �Լ�
-- if(){} else if(){} ... else{}
-- �ڹٿ���
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
-- ����Ŭ DECODE ����ؼ�
DECODE( x, 11, C, 12, D, 13, E, F )
�����ġ� 
      DECODE(expr,  search1,result1
                  [,search2,result2,...] [,default] );

[����] insa ���̺��� �ֹε�Ϲ�ȣ(ssn)�� ������ "����", "����"��� ���
SELECT name, ssn
     , MOD( SUBSTR( ssn, 8, 1 ), 2 ) mod
     , DECODE( MOD( SUBSTR( ssn, 8, 1 ), 2 ), 1, '����', '����' ) gender
FROM insa;

[����] insa ���̺��� ������ �������� ������ ���� ���θ� ����ϴ� ������ �ۼ��ϼ��� . 
     ( '������', '��������', '���� ' ó�� )
     
SELECT num, name, ssn
     , SUBSTR( ssn, 3, 4 )
     , TO_CHAR( SYSDATE, 'MMDD' )
     , SIGN( SUBSTR( ssn, 3, 4 ) - TO_CHAR( SYSDATE, 'MMDD' ) ) s
     , DECODE( SIGN( SUBSTR( ssn, 3, 4 ) - TO_CHAR( SYSDATE, 'MMDD' ) ), -1, '��������', 1, '������', '����' )
FROM insa;
--
SELECT num, name, ssn
     , SIGN( TRUNC( SYSDATE ) - TO_DATE( SUBSTR( ssn, 3, 4 ), 'MMDD' ) ) s -- ����ð� ���� �۾� �ʿ���
     , DECODE( SIGN( TRUNC( SYSDATE ) - TO_DATE( SUBSTR( ssn, 3, 4 ), 'MMDD' ) ), -1, '��������', 1, '������', '����' ) result
FROM insa;
-- ( ��� ) �κи� �����ϸ� �������� ���� ��������
-- ORA-01861: literal does not match format string
SELECT 
--  TO_DATE( '2023' )
    TO_DATE( '2023', 'YYYY' ) -- 23/03/01
  , TO_DATE( '04', 'MM' ) -- 23/04/01
  , TO_DATE( '10', 'DD' ) -- 23/03/10
  , TO_DATE( '0522', 'MMDD' ) -- 23/05/22
FROM dual;

[����] emp ���̺��� �� ����� ��ȣ, �̸�, �޿�(pay) ���
    1) 10�� �μ����� �޿� 15% �λ�
    2) 20�� �μ����� �޿� 30% �λ�
    3) �� �� �μ����� �޿� 5% �λ�

SELECT deptno, empno, ename
     , COALESCE( sal+comm, sal, 0 ) pay
     , '+' || DECODE( deptno, 10, 15, 20, 30, 5 ) || '%' "%"
     , COALESCE( sal+comm, sal, 0 ) * DECODE( deptno, 10, 1.15, 20, 1.30, 1.05 ) update_pay
FROM emp
ORDER BY deptno;

7) CASE
-- DECODE �Լ��� Ȯ�� �Լ�
-- �پ��� �� �����ڸ� ����� �� �ִ�
�����ġ�
	CASE �÷���|ǥ����
        WHEN ����1 THEN ���1
        [WHEN ����2 THEN ���2
                            ......
        WHEN ����n THEN ���n
        ELSE ���4]
	END

[����] insa ���̺��� �ֹε�Ϲ�ȣ(ssn)�� ������ "����", "����"��� ���
SELECT name, ssn
     , MOD( SUBSTR( ssn, 8, 1 ), 2 ) mod
     , DECODE( MOD( SUBSTR( ssn, 8, 1 ), 2 ), 1, '����', '����' ) gender
     , CASE MOD( SUBSTR( ssn, 8, 1 ), 2 )
        WHEN 1 THEN '����'
        WHEN 0 THEN '����'
       END case_gender
FROM insa;

[����] insa ���̺��� ������ �������� ������ ���� ���θ� ����ϴ� ������ �ۼ��ϼ��� . 
     ( '������', '��������', '���� ' ó�� )
SELECT num, name, ssn
     , SUBSTR( ssn, 3, 4 )
     , SIGN( TRUNC( SYSDATE ) - TO_DATE( SUBSTR( ssn, 3, 4 ), 'MMDD' ) ) s -- ����ð� ���� �۾� �ʿ���
     , DECODE( SIGN( TRUNC( SYSDATE ) - TO_DATE( SUBSTR( ssn, 3, 4 ), 'MMDD' ) ), -1, '��������', 1, '������', '����' ) result
     , CASE SIGN( TRUNC( SYSDATE ) - TO_DATE( SUBSTR( ssn, 3, 4 ), 'MMDD' ) )
        WHEN -1 THEN '��������'
        WHEN 1 THEN '������'
        WHEN 0 THEN '����'
       END c
     , CASE -- �÷���, ǥ���� X
        WHEN TRUNC( SYSDATE ) - TO_DATE( SUBSTR( ssn, 3, 4 ), 'MMDD' ) < 0 THEN '��������'
        WHEN TRUNC( SYSDATE ) - TO_DATE( SUBSTR( ssn, 3, 4 ), 'MMDD' ) > 0 THEN '������'
        ELSE '����'
       END d
FROM insa;

[����] emp ���̺��� �� ����� ��ȣ, �̸�, �޿�(pay) ���
    1) 10�� �μ����� �޿� 15% �λ�
    2) 20�� �μ����� �޿� 30% �λ�
    3) �� �� �μ����� �޿� 5% �λ�

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

-- [ ����ǥ���� �Լ� ]
1) REGEXP_LIKE()
2) REGEXP_INSTR()
3) REGEXP_SUBSTR()
4) REGEXP_REPLACE()

-- [ �׷� �Լ� ]
-- �׷�� �ϳ��� ����� ����Ѵ�
-- �׷� �Լ��� SELECT�� �� HAVING ������ ����� �� �ִ�
-- GROUP BY ���� ����� �׷�ȭ�Ѵ�
-- HAVING ���� �׷��� �����Ѵ�.(��: WHERE ���� ��(row)�� �����Ѵ�.)

1) AVG() : ���
    �� ��� 12�� : comm�� NULL�� ����� 8��
SELECT ename, comm
FROM emp;

[����] sal ���, comm ��� ����ؼ� ���
-- comm ��� ��� (����)
SELECT AVG( sal ) sal_avg
     , AVG( comm ) comm_avg -- 550 ( 2200/4 )
     , SUM( comm ) / COUNT( * ) comm_avg -- 183.333 ( 2200/12 )
FROM emp;
2) COUNT() : NULL�� �ƴ� ���� ������ ��ȯ�ϴ� �Լ�
�����ġ�
	COUNT([* ? DISTINCT ? ALL] �÷���) [ [OVER] (analytic ��)]

SELECT COUNT( comm ) -- 4
     , COUNT( deptno ) -- 11
     , COUNT( sal ) -- 12
     , COUNT ( * ) -- NULL�� ������ ���� �� == ��� ��� ��
FROM emp;

[����] insa ���̺��� �μ��� ���� ���
SELECT COUNT( DISTINCT buseo )
FROM insa;

3) MAX()
4) MIN()
5) STDDEV() : ǥ������
6) SUM() : NULL�� ������ n�� �հ踦 �����Ѵ�
�����ġ�
	SUM ([DISTINCT ? ALL] expr)
               [OVER (analytic_clause)]

[����] emp ���̺��� ��� sal�� ��
SELECT SUM( sal ) tot_sal
     , SUM( comm ) tot_comm
FROM emp;

7) VARIANCE() : �л�

[����] emp ���̺��� �� �μ��� ������� ���(��ȸ)
1. SET ������ ( UNION, UNION ALL )
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

2. ( �ϱ� ) COUNT(), DECODE()
-- �μ��� ���� ����� ��� X
SELECT COUNT(*) "�� �����"
    , COUNT( DECODE( deptno, 10, 'O' ) ) "10�� �����"
    , COUNT( DECODE( deptno, 20, 'O' ) ) "20�� �����"
    , COUNT( DECODE( deptno, 30, 'O' ) ) "30�� �����"
    , COUNT( DECODE( deptno, 40, 'O' ) ) "40�� �����"
    , COUNT( DECODE( deptno, NULL, 'O' ) ) "NULL �����"
    , COUNT(*)-COUNT(deptno) "�μ��� NULL�� �����"
FROM emp;

3.
-- ORA-00937: not a single-group group function
-- GROUP BY�� ������ �����Լ�, �׷��Լ� ���� ����
-- ORA-00979: not a GROUP BY expression
-- GROUP BY ���� �ִ� �÷��� SELECT ���� ����� �� �ִ�
SELECT deptno, job, COUNT(*)
FROM emp
GROUP BY deptno -- �����Լ� MAX, MIN, AVG, SUM, COUNT ���
ORDER BY deptno;
-- (������) deptno = 40 �� �ƿ� ����� �ȵ�

SELECT *
FROM emp
WHERE deptno = null;









