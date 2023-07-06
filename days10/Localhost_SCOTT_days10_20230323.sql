-- SCOTT --
-------------------------------------------------------------------------------
1. emp ���̺��� job ���� ����� �� �� ��ȸ(���) �ϴ� ���� �ۼ�.

1) GROUP BY job + COUNT()
SELECT job, COUNT(*)
FROM emp
GROUP BY job;

  [������] ����
CLERK	    3
SALESMAN	4
PRESIDENT	1
MANAGER	    3
ANALYST	    1

-- [�ǹ�(PIVOT)/���ǹ�(UNPIVOT) �Լ�]
1. ����Ŭ 11g���� �����ϴ� �Լ�
2. ��� ���� ������ �Լ�
3. ����
 SELECT * 
 FROM (�ǹ� ��� ������)
 PIVOT (�׷��Լ�(�����÷�) FOR �ǹ��÷� IN(�ǹ��÷� �� AS ��Ī...))
4. 1) �ǹ� ��� ������
    SELECT job FROM emp
   2) IN (���)
   3) FOR �ǹ��÷�
   4) �׷��Լ�(�����÷�)

��) (�ϱ�)
 SELECT * 
 FROM ( SELECT job FROM emp )
 PIVOT ( COUNT(job) FOR job IN( 'CLERK', 'SALESMAN', 'PRESIDENT', 'MANAGER', 'ANALYST' ));

2)
SELECT
       COUNT( DECODE( job, 'CLERK', 1 ) ) CLERK
     , COUNT( DECODE( job, 'SALESMAN', 1 ) ) SALESMAN
     , COUNT( DECODE( job, 'PRESIDENT', 1 ) ) PRESIDENT
     , COUNT( DECODE( job, 'MANAGER', 1 ) ) MANAGER
     , COUNT( DECODE( job, 'ANALYST', 1 ) ) ANALYST
FROM emp;

  [������] ����
       CLERK   SALESMAN  PRESIDENT    MANAGER    ANALYST
---------- ---------- ---------- ---------- ----------
         3          4          1          3          1

2. emp ���̺���  [JOB����] �� ���� �Ի��� ����� ���� ��ȸ 
  ��. COUNT(), DECODE() ���

SELECT job, EXTRACT( MONTH FROM hiredate ) ��, COUNT(*) �ο���
FROM emp
GROUP BY job, EXTRACT( MONTH FROM hiredate )
ORDER BY job, EXTRACT( MONTH FROM hiredate );
--
SELECT job, COUNT(*)
     , COUNT( DECODE( EXTRACT( MONTH FROM hiredate ), 1, 'O' ) ) "1��"
     , COUNT( DECODE( EXTRACT( MONTH FROM hiredate ), 2, 'O' ) ) "2��"
     , COUNT( DECODE( EXTRACT( MONTH FROM hiredate ), 3, 'O' ) ) "3��"
     , COUNT( DECODE( EXTRACT( MONTH FROM hiredate ), 4, 'O' ) ) "4��"
     , COUNT( DECODE( EXTRACT( MONTH FROM hiredate ), 5, 'O' ) ) "5��"
     , COUNT( DECODE( EXTRACT( MONTH FROM hiredate ), 6, 'O' ) ) "6��"
     , COUNT( DECODE( EXTRACT( MONTH FROM hiredate ), 7, 'O' ) ) "7��"
     , COUNT( DECODE( EXTRACT( MONTH FROM hiredate ), 8, 'O' ) ) "8��"
     , COUNT( DECODE( EXTRACT( MONTH FROM hiredate ), 9, 'O' ) ) "9��"
     , COUNT( DECODE( EXTRACT( MONTH FROM hiredate ), 10, 'O' ) ) "10��"
     , COUNT( DECODE( EXTRACT( MONTH FROM hiredate ), 11, 'O' ) ) "11��"
     , COUNT( DECODE( EXTRACT( MONTH FROM hiredate ), 12, 'O' ) ) "12��"
FROM emp
GROUP BY job;

   1) �ǹ� ��� ������
    SELECT EXTRACT( MONTH FROM hiredate ) hire_month
    FROM emp
   2) IN (���) <- �������� ��� �Ұ�
   3) FOR �ǹ��÷�
    hire_month
   4) �׷��Լ�(�����÷�)
    COUNT( hire_month )
   
 SELECT * 
 FROM (
     SELECT job, EXTRACT( MONTH FROM hiredate ) hire_month
     FROM emp
    )
 PIVOT ( COUNT( hire_month ) FOR hire_month IN(1 "1��", 2 "2��", 3 "3��", 4 "4��", 5 "5��", 6 "6��", 7 "7��", 8 "8��", 9 "9��", 10 "10��", 11 "11��", 12 "12��"));

JOB         COUNT(*)         1��         2��         3��         4��         5��         6��         7��         8��         9��        10��        11��        12��
--------- ---------- ---------- ---------- ---------- ---------- ---------- ---------- ---------- ---------- ---------- ---------- ---------- ----------
CLERK              3          1          0          0          0          0          0          0          0          0          0          0          2
SALESMAN           4          0          2          0          0          0          0          0          0          2          0          0          0
PRESIDENT          1          0          0          0          0          0          0          0          0          0          0          1          0
MANAGER            3          0          0          0          1          1          1          0          0          0          0          0          0
ANALYST            1          0          0          0          0          0          0          0          0          0          0          0          1

  ��. GROUP BY �� ���
-- 1)
SELECT TO_NUMBER( TO_CHAR( hiredate, 'MM' ) ) ��, COUNT(*) �ο���
FROM emp
GROUP BY TO_NUMBER( TO_CHAR( hiredate, 'MM' ) )
ORDER BY TO_NUMBER( TO_CHAR( hiredate, 'MM' ) );
-- 2)
SELECT EXTRACT( MONTH FROM hiredate ) ��, COUNT(*) �ο���
FROM emp
GROUP BY EXTRACT( MONTH FROM hiredate )
ORDER BY EXTRACT( MONTH FROM hiredate );

         ��        �ο���
---------- ----------
         1          1
         2          2
         4          1
         5          1
         6          1
         9          2
        11          1
        12          3

8�� ���� ���õǾ����ϴ�. 

3. emp ���̺��� �� �μ��� �޿� ���� �޴� ��� 2�� ���
  ������)

-- TOP-N ���  
FROM emp
-- RANK �Լ�
SELECT t.*
FROM (
    SELECT empno, ename, job, mgr, hiredate, sal, comm, deptno
         , RANK() OVER( PARTITION BY deptno ORDER BY sal + NVL(comm,0) ) SEQ
    FROM emp
    ) t
WHERE seq <= 2;

       SEQ      EMPNO ENAME      JOB              MGR HIREDATE        SAL       COMM     DEPTNO
---------- ---------- ---------- --------- ---------- -------- ---------- ---------- ----------
         1       7839 KING       PRESIDENT            81/11/17       5000                    10
         2       7782 CLARK      MANAGER         7839 81/06/09       2450                    10
         1       7902 FORD       ANALYST         7566 81/12/03       3000                    20
         2       7566 JONES      MANAGER         7839 81/04/02       2975                    20
         1       7698 BLAKE      MANAGER         7839 81/05/01       2850                    30
         2       7654 MARTIN     SALESMAN        7698 81/09/28       1250       1400         30
-------------------------------------------------------------------------------
[�ǹ����� 1] emp ���̺��� ��޺� �ο���

-- ���) salgrade ���̺� - grade, losal, jisal + emp ���̺� ����
-- NON EQUI JOIN ���� BETWEEN ~ AND ������
SELECT empno, ename, sal, grade
FROM emp e JOIN salgrade s ON e.sal BETWEEN s.losal AND s.hisal;
-- �� sal ����� �ο��� ������� ��ȸ
1) GROUP BY
SELECT grade || '���', COUNT(*)
FROM (
    SELECT empno, ename, sal, grade
    FROM emp e JOIN salgrade s ON e.sal BETWEEN s.losal AND s.hisal
    ) t
GROUP BY grade
ORDER BY grade;

2) COUNT() + DECODE()
SELECT
      COUNT( DECODE( grade, 1, 'O' ) ) "1���"
    , COUNT( DECODE( grade, 2, 'O' ) ) "2���"
    , COUNT( DECODE( grade, 3, 'O' ) ) "3���"
    , COUNT( DECODE( grade, 4, 'O' ) ) "4���"
    , COUNT( DECODE( grade, 5, 'O' ) ) "5���"
FROM (
    SELECT empno, ename, sal, grade
    FROM emp e JOIN salgrade s ON e.sal BETWEEN s.losal AND s.hisal
    ) t;

3) PIVOT()
    (1) �ǹ����
    SELECT *
    FROM (
        SELECT grade
        FROM emp e JOIN salgrade s ON e.sal BETWEEN s.losal AND s.hisal
        )
    PIVOT(COUNT(grade) FOR grade IN (1,2,3,4,5));

[�ǹ����� 2]
1) GROUP BY
SELECT TO_CHAR( hiredate, 'YYYY' ) hire_year, COUNT(*)
FROM emp
GROUP BY TO_CHAR( hiredate, 'YYYY' )
ORDER BY hire_year;

2) COUNT(), DECODE()
SELECT
    COUNT( DECODE( TO_CHAR( hiredate, 'YYYY' ), 1980, 'O' ) ) "1980�� �����"
     , COUNT( DECODE( TO_CHAR( hiredate, 'YYYY' ), 1981, 'O' ) ) "1981�� �����"
     , COUNT( DECODE( TO_CHAR( hiredate, 'YYYY' ), 1982, 'O' ) ) "1982�� �����"
FROM emp;

3) PIVOT()
SELECT *
FROM (
     SELECT TO_CHAR( hiredate, 'YYYY' ) hire_year
     FROM emp
    )
PIVOT( COUNT(hire_year) FOR hire_year IN (1980,1981,1982) );
-------------------------------------------------------------------------------
-- [ ROLLUP ���� CUBE �� ]
    �� GROUP BY������ ���Ǿ� �׷캰 �Ұ踦 �߰��� �����ִ� ������ �Ѵ�
    �� ��, �߰����� ���� ������ �����ش�
��) insa ���̺��� ���ڻ����, ���ڻ������ ��ȸ + �ѻ����
SELECT DECODE( MOD( SUBSTR( ssn, -7, 1 ), 2 ), 1, '����', '����' ) gender, COUNT(*) ����� --, ( SELECT COUNT(*) FROM insa ) "�ѻ����"
FROM insa
GROUP BY MOD( SUBSTR( ssn, -7, 1 ), 2 )
UNION ALL
SELECT '��ü', COUNT(*)
FROM insa;

-- GROUP BY + ROLLUP ���
SELECT DECODE( MOD( SUBSTR( ssn, -7, 1 ), 2 ), 1, '����', 0, '����', '��ü' ) gender, COUNT(*) ����� --, ( SELECT COUNT(*) FROM insa ) "�ѻ����"
FROM insa
GROUP BY ROLLUP( MOD( SUBSTR( ssn, -7, 1 ), 2 ) );

-- ��) ROLLUP, CUBE ������ üũ
-- insa ���̺��� �μ��� 1�� �׷���, ���޺� 2�� �׷���
SELECT buseo, jikwi, COUNT(*) �����
FROM insa
GROUP BY buseo, jikwi
ORDER BY buseo, jikwi;
--
SELECT buseo, jikwi, COUNT(*) �����
FROM insa
GROUP BY buseo, jikwi
UNION ALL
SELECT buseo, '' "JIKWI", COUNT(*) �����
FROM insa
GROUP BY buseo
UNION ALL
--
SELECT '' "BUSEO", jikwi, COUNT(*) �����
FROM insa
GROUP BY jikwi
--
UNION ALL
SELECT '' "BUSEO", '' "JIKWI", COUNT(*)
FROM insa
ORDER BY buseo, jikwi;
-- GROUP BY �� ���
SELECT buseo, jikwi, COUNT(*) �����
FROM insa
--GROUP BY ROLLUP( buseo, jikwi )
GROUP BY CUBE( buseo, jikwi )
ORDER BY buseo, jikwi;

-- ����(parial) ROLLUP
SELECT buseo, jikwi, COUNT(*) �����
FROM insa
GROUP BY ROLLUP( buseo ), jikwi -- ��ü����� 60 X, ���� �κ����� O, �μ� �κ����� X
--GROUP BY buseo, ROLLUP( jikwi ) -- ��ü����� 60 X, �μ� �κ����� O, ���� �κ����� X
--GROUP BY CUBE( buseo, jikwi )
ORDER BY buseo, jikwi;
-------------------------------------------------------------------------------
-- GROUPING SETS
SELECT buseo, '', COUNT(*)
FROM insa
GROUP BY buseo
UNION ALL
SELECT '', jikwi, COUNT(*)
FROM insa
GROUP BY jikwi;

SELECT buseo, jikwi, COUNT(*)
FROM insa
GROUP BY GROUPING SETS( buseo, jikwi )
ORDER BY buseo, jikwi;
-------------------------------------------------------------------------------
-- ������ ��(����) dbms_random ��Ű�� == ���� �Լ�, ���ν��� ���

SELECT DBMS_RANDOM.VALUE
     , TRUNC( DBMS_RANDOM.VALUE(0,101) ) -- 0 <=   < 101
     , FLOOR( DBMS_RANDOM.VALUE(0,45) ) + 1 -- 0 <=   <= 45
     , DBMS_RANDOM.STRING( 'U', 5 ) �� -- �빮�� 5��
     , DBMS_RANDOM.STRING( 'L', 5 ) �� -- �ҹ��� 5��
     , DBMS_RANDOM.STRING( 'A', 5 ) �� -- ��ҹ��� 5��
     , DBMS_RANDOM.STRING( '', 5 ) �� -- ��ҹ��� + Ư������ 5��
FROM dual;

[����] SMS ������ȣ ���� 6�ڸ�
DBMS_RANDOM.VALUE �Լ��� ���

SELECT TRUNC( DBMS_RANDOM.VALUE(100000,1000000) )
FROM dual;
-------------------------------------------------------------------------------
-- [ ����Ŭ �ڷ��� ( Data Type ) ���� ]
1) CHAR
    ��) "��������" ���� ��Ʈ���� ���ȴ� <-> "��������"
        ��) �ֹε�Ϲ�ȣ ���� -> ��� ������� 14�ڸ�
    ��) ['a']['b']['c']['']['']['']['']['']
    ��) [][][] abcd ���� �߻�
    ��) DB ������ ���� 1���� 1~4����Ʈ ó��
    ��) ����
        CHAR[( SIZE[byte|char] )]
        �ִ� 2000����Ʈ ���ڸ� �����Ѵ�
        
        ��) CHAR    == CHAR(1 BYTE) == CHAR(1)
            CHAR(3) == CHAR(3 BYTE)
            CHAR(3 BYTE) -- 3����Ʈ
            CHAR(3 CHAR) -- 3����
    ��)
        CREATE TABLE tbl_char (
            -- �÷��� �ڷ���[(ũ��)]
            aa CHAR -- chAR(1) == CHAR(1 BYTE)
            , bb CHAR(3) -- CHAR(3 BYTE) ���� 3����, �ѱ� 1����
            , cc CHAR(3 CHAR)
            );
            -- Table TBL_CHAR��(��) �����Ǿ����ϴ�.
            SELECT *
            FROM tbl_char;
            --
            INSERT INTO tbl_char(aa,bb,cc) VALUES('A','ABC','abc');
            COMMIT;
            INSERT INTO tbl_char(aa,bb,cc) VALUES('��','ABC','abc');
            -- ORA-12899: value too large for column "SCOTT"."TBL_CHAR"."AA" (actual: 3, maximum: 1)
            INSERT INTO tbl_char(aa,bb,cc) VALUES('1','ȫ��','abc');
            
            INSERT INTO tbl_char(aa,bb,cc) VALUES('1','MBC','ȫ�浿');
            INSERT INTO tbl_char(aa,bb,cc) VALUES('1','MBC','abc');
            --
            SELECT VSIZE('A'), VSIZE('��')
            FROM dual;
            --
            DROP TABLE tbl_char;
            Table TBL_CHAR��(��) �����Ǿ����ϴ�.
            
2) NCHAR
U[N]ICODE + CHAR 'A' 'ȫ' 2����Ʈ
NCHAR(SIZE)
NCHAR(3) 'abc' / 'ȫ�浿' ��������, 2000����Ʈ
NCHAR(1) == NCHAR

�������� : CHAR, NCHAR
    ��) �ֹε�Ϲ�ȣ : CHAR(14 BYTE)
    ��) �ѱ� ���� 6�ڸ� : NCHAR(6)

3) NVARCHAR2(SIZE) 4000 ����Ʈ
4) VARCHAR2(SIZE [BYTE|CHAR])  4000 ����Ʈ
   
     VAR + CHAR2(SIZE) ��������
 N + VAR + CHAR2(SIZE) ��������

��) CHAR(12)             [a][b][c][][][][][][][][][]
    VARCHAR2(12 BYTE)    [a][b][c]

��) �Խñ��� ���� : CHAR / NCHAR X
                VARCHAR2 / NVARCHAR2 �������� O

5) VARCHAR == VARCHAR2�� �ó��

6) LONG - ��������, 2GB
��) �Խ��� �� ����
    content LONG

7) NUMBER[(p[,s])] ����( ����, �Ǽ� )
    p : precision ��ü �ڸ���(���е�) 1~38
    s : scale �Ҽ��� �ڸ��� -84~127
    ��) NUMBER == NUMBER( 38, 127 ) �ִ� �ڸ���
        NUMBER(3) ���� == NUM( 3, 0 )
        NUMBER(5,2) �Ǽ�
    ��)
    CREATE TABLE tbl_number(
          name NVARCHAR2(10) -- �ѱۻ�� ���� ���ڿ�
        , kor NUMBER(3) -- ���� 3�ڸ� -999~999
        , eng NUMBER(3)
        , mat NUMBER(3)
        , tot NUMBER(3) 
        , avg NUMBER(5,2)
        , r NUMBER(2) -- -99~99
    );
-- Table TBL_NUMBER��(��) �����Ǿ����ϴ�.
INSERT INTO tbl_number VALUES ( 'ȫ�浿', 90, 89, 100, null, null, null );
INSERT INTO tbl_number VALUES ( '�����', 90, 80.12, 78, null, null, null ); -- 80.12 -> 80
COMMIT;
INSERT INTO tbl_number VALUES ( 'Ź����', 90, 20, 78, null, null, null );
ROLLBACK;
SELECT *
FROM tbl_number;

-- ����, ��� ��� UPDATAE
UPDATE tbl_number
SET tot = kor + eng + mat, avg = ( kor + eng + mat )/3;
COMMIT;

-- [����] r ��� null ó�� UPDATE
SELECT tot
     , ( SELECT COUNT(*)+1 FROM tbl_number WHERE tot > t1.tot ) r
FROM tbl_number t1;

UPDATE tbl_number t1
SET r = ( SELECT COUNT(*)+1 FROM tbl_number WHERE tot > t1.tot );
COMMIT;

8) FLOAT(p) == ���������δ� NUMBER ó���ȴ�

9) DATE
    �� ��¥, �ð�
    �� ���� ���� 7 BYTE ����
    
   TIMESTAMP[(n)] == TIMESTAMP(6)
    00:00:00.000000
    
SELECT SYSDATE
FROM dual;

SELECT hitedate
     , TO_CHAR( hiredate, 'TS' )
FROM emp;

��) �Խ��� �ۼ��� : DATE O, TIMESTAMP X

10) RAW(SIZE) 2��������(0,1) 2000����Ʈ 
    LONGRAW                 2GB
    
RAW == �������� ����, ����

ȫ�浿.gif �̹������� -> TABLE ����

�Խ��� �۾��� + (÷������*3��) Ư�� ���� : ÷������ ����
                            TABLE : ����� ������ ��θ� ����
                            
11) BFILE   2�������� (0,1), �ܺ� ���� ���·� ����

12) LOB = Large OBject
    BLOB = Binary(2�� ������)
    CLOB = Char
    NCLOB = NChar

14) ROWID
    ROW(��) + ID(�����Ѱ�)
    SELECT ROWID, emp.*
    FROM emp;
-------------------------------------------------------------------------------
����Ŭ ���� : char, nchar, varchar, varchar2, nvarchar2
            long, clob, nclob
      ���� : number(p,s), float
      ��¥ : date, timestamp
      ��������Ʈ : raw/longraw, bfile, blob
      LOB : blob, clob, nclob
-------------------------------------------------------------------------------
-- [ COUNT �Լ� ]
    �� ������ ���� ���� ��ȯ�Ѵ�.
    �� COUNT(�÷���) �Լ��� NULL�� �ƴ� ���� ���� ����ϰ�
       COUNT(*) �Լ��� NULL�� ������ ���� ���� ����Ѵ�.
�����ġ�
	COUNT([* ? DISTINCT ? ALL] �÷���) [ [OVER] (analytic ��)]

SELECT COUNT( DISTINCT buseo )
FROM insa;
-- ORA-00937: not a single-group group function
-- ������ �Լ��� name basicpay�� ���� ��� X
SELECT name, basicpay
     , COUNT(*) OVER( ORDER BY basicpay ASC ) -- OVER�� ����ϸ� ������ ���� ��ȸ
FROM insa;
-- �μ��� �׷����� �� ������ ���� ��ȸ
SELECT name, basicpay, buseo
     , COUNT(*) OVER( PARTITION BY buseo ORDER BY basicpay ASC )
FROM insa;

-- SUM() : basicpay�� ������ ���� ��ȸ
SELECT name, basicpay
     , SUM(basicpay) OVER( ORDER BY basicpay ASC )
FROM insa;
-- �μ��� �׷����� �� ������ ���� ��ȸ
SELECT name, basicpay, buseo
     , SUM(basicpay) OVER( PARTITION BY buseo ORDER BY basicpay ASC )
FROM insa;

-- AVG() : basicpay�� ������ ����� ��ȸ
SELECT name, basicpay
     , AVG(basicpay) OVER( ORDER BY basicpay ASC )
FROM insa;
-- �μ��� �׷����� �� ������ ���� ��ȸ
SELECT name, basicpay, buseo
     , AVG(basicpay) OVER( PARTITION BY buseo ORDER BY basicpay ASC )
FROM insa;      
-------------------------------------------------------------------------------
���̺� ����/����/���� CRUD + ��������
*** [ DB �𵨸� ] ***
�䱸�м� -> ������ �𵨸� -> ���� �𵨸� -> ������ �𵨸�
                                        [����Ŭ] ���̺� ����
                                        MySQL
                                        
-- [ȸ������]�� �����ϴ� ���̺� ���� : ȸ�� ���̺�
�÷���(��)  �������÷���       �ڷ���        ũ��          �ʼ� �Է�
���̵�         id         VARCHAR2        10 BYTE      NOT NULL    PRIMARY KEY
�̸�          name        NVARCHAR2       10 ����       NOT NULL
����          age         NUMBER          3
��ȭ��ȣ        tel         CHAR            13          NOT NULL
����          birth       DATE
��Ÿ          etc         NVARCHAR2       200
 :                          LONG            2GB
 :                          CLOB
�繫����(����, ��)
ȸ��/�۱�/����

-- ���̺� ����
�����ġ�
CREATE TABLE ���̺��
	(�÷��� ������Ÿ�� [, �÷��� ������Ÿ��]...)
	[TABLESPACE tablespace��]
	[PCTFREE ����]
	[PCTUSED ����]
	[INITRANS ����]
	[MAXTRANS ����]
	[STORAGE storage��]
	[LOGGING ? NOLOGGING]
	[CACHE ? NOCACHE];


CREATE TABLE scott.tbl_member
(
    id VARCHAR2(10) NOT NULL PRIMARY KEY
    , name NVARCHAR2(10) NOT NULL
    , age NUMBER(3)
    , tel CHAR(13) NOT NULL
    , birth DATE
    , etc NVARCHAR2(200)
);
-- Table SCOTT.TBL_MEMBER��(��) �����Ǿ����ϴ�.

1) ������ ���̺� Ȯ��
SELECT *
FROM tabs -- user_tables
WHERE REGEXP_LIKE( table_name, 'member', 'i');
WHERE table_name LIKE '%MEMBER%';
      
2) ���̺� ����      
�����ġ�
     DROP TABLE [schema.]table [CASCADE CONSTRAINTS] [PURGE];
PURGE(����) : �������ϴ�, �����ϴ�
DROP TABLE scott.tbl_member PURGE;    
-- Table SCOTT.TBL_MAMBER��(��) �����Ǿ����ϴ�.
      
      
      
      
      
      
      
      
      
      
      
      
      
      