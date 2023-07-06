-- SCOTT --
-------------------------------------------------------------------------------
1. ����Ŭ �� DataType �� ���� ���� �����ϼ���

���� : char - ��������, ���� 1����Ʈ, �ѱ� 3����Ʈ, �ִ� 2000����Ʈ
      nchar - ��������, ����� �ѱ� ��� 2����Ʈ, �ִ� 2000����Ʈ
      varchar2 - ��������, ���� 1����Ʈ, �ѱ� 3����Ʈ, �ִ� 4000����Ʈ
      nvarchar2 - ��������, ����� �ѱ� ��� 2����Ʈ, �ִ� 4000����Ʈ
      varchar - varchar2�� �ó��
      long - ��������, �ִ� 2GB
���� : number(p,s) - p : ��ü �ڸ���, s : �Ҽ��� �ڸ���
      float - number�� ó��
��¥ : date - ��¥ + �ð�, �������� 7����Ʈ
      timestamp - ��¥ + �ð�, �Ҽ����ڸ� �ʱ���
���������� : raw - �������� ����, 2000����Ʈ
           longraw - �������� ����, 2GB
           bfile - �ܺ����� ����
LOB( Large OBject ) - blob(����), clob(char), nclob(nchar)

2.  emp ���̺��� [�⵵��] [����] �Ի����� ���.( PIVOT() �Լ� ��� )

SELECT *
FROM (
    SELECT EXTRACT( YEAR FROM hiredate ) hire_year, EXTRACT( MONTH FROM hiredate ) hire_month
    FROM emp
    )
PIVOT( COUNT( hire_month ) FOR hire_month IN (1,2,3,4,5,6,7,8,9,10,11,12) );
--
������� -> �������
1) �Ǻ� ��� ����
2) IN (���)
3) FOR �Ǻ��÷�
4) �����Լ�(�÷�)

    [������]
    1982	1	0	0	0	0	0	0	0	0	0	0	0
    1980	0	0	0	0	0	0	0	0	0	0	0	1
    1981	0	2	0	1	1	1	0	0	2	0	1	2
    
2-2.   emp ���̺��� �� JOB�� �Ի�⵵�� 1��~ 12�� �Ի��ο��� ���.  ( PIVOT() �Լ� ��� ) 

SELECT *
FROM (
    SELECT JOB, EXTRACT( YEAR FROM hiredate ) hire_year, EXTRACT( MONTH FROM hiredate ) hire_month
    FROM emp
    )
PIVOT( COUNT( hire_month ) FOR hire_month IN (1,2,3,4,5,6,7,8,9,10,11,12) )
ORDER BY job;

    [������]
    ANALYST		1981	0	0	0	0	0	0	0	0	0	0	0	1
    CLERK		1980	0	0	0	0	0	0	0	0	0	0	0	1
    CLERK		1981	0	0	0	0	0	0	0	0	0	0	0	1
    CLERK		1982	1	0	0	0	0	0	0	0	0	0	0	0
    MANAGER		1981	0	0	0	1	1	1	0	0	0	0	0	0
    PRESIDENT	1981	0	0	0	0	0	0	0	0	0	0	1	0
    SALESMAN	1981	0	2	0	0	0	0	0	0       
    
3. emp���̺��� �Ի����ڰ� ������ ������ 3�� ��� ( TOP 3 )

SELECT ROWNUM, t.*
FROM ( SELECT * FROM emp ORDER BY hiredate ASC ) t
WHERE ROWNUM <= 3;

-- ORA-00936: missing expression : * -> emp.*
SELECT t.*
FROM (
    SELECT RANK() OVER( ORDER BY hiredate ) seq, emp.*
    FROM emp
    ) t
WHERE seq <= 3;

    [������]
    1	7369	SMITH	CLERK	    7902	80/12/17	800		    20
    2	7499	ALLEN	SALESMAN	7698	81/02/20	1600	300	30
    3	7521	WARD	SALESMAN	7698	81/02/22	1250	500	30    
    
4. SMS ������ȣ  ������  6�ڸ� ���� ��� ( dbms_random  ��Ű�� ��� )

SELECT TRUNC( DBMS_RANDOM.VALUE(100000,1000000) ) sms
FROM dual;

-- ORACLE DBMS_RANDOM ��Ű�� - ����Ŭ ��ü( �Լ�, ���ν���, Ʈ���� ��� )
SELECT dbms_random.value
     , FLOOR( dbms_random.value(100000,1000000) )
     , dbms_random.string('L',5)
FROM dual
CONNECT BY LEVEL <= 6; -- CONNECT BY ������
-- ( �ܼ� �ϱ� )
SELECT LEVEL
FROM dual
CONNECT BY LEVEL <= 31;
-- [2023�� 3�� ] 1~31�� ��¥ ��� ���
SELECT TRUNC( SYSDATE, 'MM' ) + LEVEL - 1
FROM dual
CONNECT BY LEVEL <= TO_CHAR( LAST_DAY( SYSDATE ), 'DD' );
-- [ �޷� �׸��� ( ������ �ҽ� �м� ) ]
SELECT 
       NVL( MIN( DECODE( TO_CHAR( dates, 'D'), 1, TO_CHAR( dates, 'DD')) ), ' ')  ��
     , NVL( MIN( DECODE( TO_CHAR( dates, 'D'), 2, TO_CHAR( dates, 'DD')) ), ' ')  ��
     , NVL( MIN( DECODE( TO_CHAR( dates, 'D'), 3, TO_CHAR( dates, 'DD')) ), ' ')  ȭ
     , NVL( MIN( DECODE( TO_CHAR( dates, 'D'), 4, TO_CHAR( dates, 'DD')) ), ' ')  ��
     , NVL( MIN( DECODE( TO_CHAR( dates, 'D'), 5, TO_CHAR( dates, 'DD')) ), ' ')  ��
     , NVL( MIN( DECODE( TO_CHAR( dates, 'D'), 6, TO_CHAR( dates, 'DD')) ), ' ')  ��
     , NVL( MIN( DECODE( TO_CHAR( dates, 'D'), 7, TO_CHAR( dates, 'DD')) ), ' ')  ��
FROM (
        SELECT TO_DATE(:yyyymm , 'YYYYMM') + LEVEL - 1  dates
        FROM dual
        CONNECT BY LEVEL <= EXTRACT ( DAY FROM LAST_DAY(TO_DATE(:yyyymm , 'YYYYMM') ) )
)  t 
GROUP BY CASE 
               -- IW �� 50�� �����鼭 "�Ͽ���"
             WHEN TO_CHAR(dates, 'MM') = 1 AND  TO_CHAR(dates, 'D') = '1' AND TO_CHAR( dates, 'IW') > '50' THEN 1
             WHEN TO_CHAR(dates, 'MM') = 1 AND TO_CHAR(dates, 'D') != '1' AND TO_CHAR( dates, 'IW') > '50' THEN 0  
             WHEN TO_CHAR( dates , 'D') = 1 THEN TO_CHAR( dates , 'IW') + 1
             ELSE TO_NUMBER( TO_CHAR( dates , 'IW') )
          END   
ORDER BY   
         CASE 
             WHEN TO_CHAR(dates, 'MM') = 1 AND  TO_CHAR(dates, 'D') = '1' AND TO_CHAR( dates, 'IW') > '50' THEN 1
             WHEN TO_CHAR(dates, 'MM') = 1 AND TO_CHAR(dates, 'D') != '1' AND TO_CHAR( dates, 'IW') > '50' THEN 0  
             WHEN TO_CHAR( dates , 'D') = 1 THEN TO_CHAR( dates , 'IW') + 1
             ELSE TO_NUMBER( TO_CHAR( dates , 'IW') )
            END      ;  

4-2. ������ ��ҹ��� 5���� ���( dbms_random  ��Ű�� ��� )

SELECT DBMS_RANDOM.STRING('A',5)
FROM dual;

5. �Խñ��� �����ϴ� ���̺� ����
   ��.   ���̺�� : tbl_board
   ��.   �÷�                     �ڷ���  ũ��    ����뿩��    ����Ű
         �۹�ȣ    seq            
         �ۼ���    writer     
         ��й�ȣ passwd      
         ������    title       
         �۳���    content
         �ۼ���    regdate   
    ��.  �۹�ȣ, �ۼ���, ��й�ȣ, �� ������ �ʼ� �Է� �������� ����
    ��.  �۹�ȣ��  �⺻Ű( PK )�� ����
    ��.  �ۼ����� ���� �ý����� ��¥�� �ڵ� ���� ( DEFAULT �⺻�� )
    
    CREATE TABLE tbl_board (
          seq       NUMBER          NOT NULL    PRIMARY KEY
        , writer    VARCHAR2(20)    NOT NULL
        , passwd    VARCHAR2(15)    NOT NULL
        , title     VARCHAR2(100)   NOT NULL
        , content   CLOB
        , regdate   DATE    DEFAULT SYSDATE
    );
    -- Table TBL_BOARD��(��) �����Ǿ����ϴ�.
    
5-2. ��ȸ��    read   �÷��� �߰� ( �⺻�� 0 ����  ���� ) 

    ALTER TABLE tbl_board
    ADD read NUMBER DEFAULT 0;
    -- Table TBL_BOARD��(��) ����Ǿ����ϴ�.

5-3. ���̺� ���� Ȯ�� 

    DESC tbl_board;

5-4. CRUD  ( insert, select, update, delete ) 
   ��. ������ �Խñ� 5���� �߰� insert
   INSERT INTO ��Ű��.���̺�� ( �÷Ÿ�,,,) VALUES ( ��...);
   
   INSERT INTO tbl_board ( seq, writer, passwd, title, content, regdate, read )
                  VALUES ( 1, 'ȫ�浿', '123$', 'ù ��° �Խñ�', '���� ��', SYSDATE, 0 );
   -- content, regdate, read �÷����� ���� �ʾҴ� ( NULL, DEFAULT )
   -- SQL ����: ORA-00947: not enough values
   INSERT INTO tbl_board ( seq, writer, passwd, title, content, regdate, read )
                  VALUES ( 2, '������', '123$', '�� ��° �Խñ�' );
   -- ORA-00001: unique constraint (SCOTT.SYS_C007056) violated
   -- ���ϼ� �������ǿ� ����ȴ� seq 1 -> 2
   INSERT INTO tbl_board ( seq, writer, passwd, title )
                  VALUES ( 2, '������', '123$', '�� ��° �Խñ�' ); 
   -- seq, writer, passwd, title, content, regdate, read �÷� ������ ���� �־��ٸ� ���� �����ϴ�
   INSERT INTO tbl_board VALUES ( 3, '���±�', '123$', '�� ��° �Խñ�', '���� ��', SYSDATE, 0 );
   
   INSERT INTO tbl_board ( writer, seq, title, passwd, content )
                  VALUES ( '������', 4, '�� ��° �Խñ�', '123$', '�ù�' ); 
                  
   INSERT INTO tbl_board ( seq, writer, passwd, title, content, regdate, read )
                  VALUES ( 5, 'ȫ�浿', '123$', '�ټ� ��° �Խñ�', null, null, null );
                  
   COMMIT;
    
   ��. �Խñ� ��ȸ select
   SELECT  *
   FROM tbl_board
   ORDER BY seq DESC;
   
   ��. 3�� �Խñ��� �� ����, ���� ���� update
    3	���±�	123$	�� ��° �Խñ�	���� ��	23/03/24	0
    
    UPDATE tbl_board
    SET title = title || ' - ����', content = content || ' - ����'
    WHERE seq = 3;
    -- 1 �� ��(��) ������Ʈ�Ǿ����ϴ�.
   
   ��. 4�� �Խñ� ���� delete
   DELETE FROM tbl_board
   WHERE seq = 4;
   
   [����] 1�� �Խñ��� ����, ����, �ۼ��� -> 5�� �Խñ��� ����, ����, �ۼ��Ϸ� ����
   UPDATE tbl_board
   SET title = ( SELECT title FROM tbl_board WHERE seq = 1 )
     , content = ( SELECT content FROM tbl_board WHERE seq = 1 )
     , regdate = ( SELECT regdate FROM tbl_board WHERE seq = 1 )
   WHERE seq = 5;
   --
   UPDATE tbl_board
   SET ( title, content, regdate ) = ( SELECT title, content, regdate FROM tbl_board WHERE seq = 1 )
   WHERE seq = 5;
   --
   ROLLBACK;
   
5-5. tbl_board ���̺� ����  
    [DDL]
    CREATE TABLE
    ALTER TABLE
    DROP TABLE tbl_board PURGE; -- ���� ����
-------------------------------------------------------------------------------
-- ���� ���� --
�����������ġ�
    CREATE [GLOBAL TEMPORARY] TABLE [schema.] table
      ( 
        ���̸�  ������Ÿ�� [DEFAULT ǥ����] [��������] 
       [,���̸�  ������Ÿ�� [DEFAULT ǥ����] [��������] ] 
       [,...]  
      ); 
-- ��.
    SELECT *
    FROM tabs
    WHERE table_name LIKE '%MEMBER%';
    DROP TABLE
    ALTER TABLE
    CREATE TABLE tbl_member
    (
          id    VARCHAR2(10)    NOT NULL    PRIMARY KEY
        , name  VARCHAR2(20)    NOT NULL
        , age   NUMBER(3)
        , birth DATE
    );
    -- etc, tel �÷� ���� ���̺� ����
    -- Table TBL_MEMBER��(��) �����Ǿ����ϴ�.
    
    A) tbl_member�� ���ο� etc, tel �÷� �߰�
        ������� ���̺� 2���� �÷��� �߰��Ѵٴ� �ǹ� -> ���̺� ����
        1) ALTER TABLE ADD �÷� �߰�
            ��. ���ο� 2���� �÷��� �߰��ϱ� ���� INSERT������ ���ڵ�(��)�� �߰��ߴٸ�
                ���� �߰��Ǵ� �÷��� ���� NULL�� ä������.
            ��. �����ġ��÷��߰�
                ALTER TABLE ���̺��
                ADD (�÷��� datatype [DEFAULT ��]
                    [,�÷��� datatype]...);
           
            ��)
            ALTER TABLE tbl_member
            ADD (
                  tel   CHAR(13)
                , etc   VARCHAR2(1000)
                );
            -- Table TBL_MEMBER��(��) ����Ǿ����ϴ�.
            DESC tbl_member;
            
            ��. �� ���� �÷��� �߰��� ���� ADD tel CHAR(13) ��ȣ�� ������ �� �ִ�.
            ��. �߰��� �÷��� ���̺��� �������� �߰��ȴ�. ��ġ ���� �Ұ�
    
    B) etc �÷��� VARCHAR(1000) ũ�⸦ 1000 -> 500 ����Ʈ ����        
        2) ALTER TABLE MODIFY �÷� ����
            ��. �����ġ�
                ALTER TABLE ���̺��
                MODIFY (�÷��� datatype [DEFAULT ��]
                       [,�÷��� datatype]...);
            ��. �������� type, size, default ���� ������ �� �ִ�
            ��. ���� ��� �÷��� �����Ͱ� ���ų� null ���� ������ ��쿡�� size�� ���� �� �ִ�. (����)
            ��. ������ Ÿ���� ������ CHAR�� VARCHAR2 ��ȣ���� ���游 �����ϴ�.
            ��. �÷� ũ���� ������ ����� �������� ũ�⺸�� ���ų� Ŭ ��쿡�� �����ϴ�.
            ��. NOT NULL �÷��� ��쿡�� size�� Ȯ�븸 �����ϴ�.
            ��. �÷��� �⺻�� ������ �� ���Ŀ� ���ԵǴ� ����� ������ �ش�.
            ��. �÷��̸��� �������� ������ �Ұ����ϴ�.
            ��. �÷��̸��� ������ ���������� ���� ���̺� ������ alias�� �̿��Ͽ� ������ �����ϴ�.
            ��. alter table ... modify�� �̿��Ͽ� constraint�� ������ �� ����.
                        ������ Ÿ�� ���� ���ɻ���      SIZE 
            NULL �÷�     ���� �� ���� �� ��¥    Ȯ��, ��Ұ��� 
            NOT NULL �÷� CHAR �� VARCHAR2       Ȯ�븸 ���� 
            
            ��)
            ALTER TABLE tbl_member
            MODIFY ( etc VARCHAR2(500) );
            -- Table TBL_MEMBER��(��) ����Ǿ����ϴ�.
            DESC tbl_member;
    
    C) etc �÷����� memo �÷������� ����(����)
        ��. ��ȸ�� �� ��Ī(alias) ���
            SELECT etc AS memo
            FROM tbl_member;
        ��. �÷��� ����
            ALTER TABLE tbl_member
            RENAME COLUMN etc TO memo;
            -- Table TBL_MEMBER��(��) ����Ǿ����ϴ�.
    
    D) memo �÷� ����
        3) ALTER TABLE DROP �÷� ����
            ��. �����ġ�
                ALTER TABLE ���̺��
                DROP COLUMN �÷���; 
            
            ��. �÷��� �����ϸ� �ش� �÷��� ����� �����͵� �Բ� �����ȴ�.
            ��. �ѹ��� �ϳ��� �÷��� ������ �� �ִ�.
            ��. ���� �� ���̺��� ��� �ϳ��� �÷��� �����ؾ� �Ѵ�.
            ��. DDL������ ������ �÷��� ������ �� ����.
            
            ��)
            ALTER TABLE tbl_member
            DROP COLUMN memo;
            -- Table TBL_MEMBER��(��) ����Ǿ����ϴ�.
            
    E) ���̺�� ���� (tbl_member -> tbl_members)
        RENAME tbl_member TO tbl_members;
        -- ���̺� �̸��� ����Ǿ����ϴ�.
        
        4) ALTER TABLE DROP �������� ����
-------------------------------------------------------------------------------

6-1. ������ ��¥�� ���� ��� 

SELECT SYSDATE "���ó�¥", TO_CHAR( SYSDATE, 'D' ) "���ڿ���", TO_CHAR( SYSDATE, 'DY' ) "���ڸ�����", TO_CHAR( SYSDATE, 'DAY' ) "����"
FROM dual;

 [������]
���ó�¥  ���ڿ���  ���ڸ�����       ����
-------- ---        ------   ------------
22/04/15  6             ��      �ݿ���      

6-2. �̹� ���� ������ ���� ��¥�� ��� 

SELECT SYSDATE "���ó�¥", LAST_DAY( SYSDATE ) "�̹��޸�������¥", EXTRACT( DAY FROM LAST_DAY( SYSDATE ) ) "��������¥(��)"
FROM dual;

 [������]
���ó�¥  �̹��޸�������¥                  ��������¥(��)
-------- -------- -- ---------------------------------
22/04/15 22/04/30 30                                30

6-3.

SELECT SYSDATE "���ó�¥", TO_CHAR( SYSDATE, 'W' ) "��������", TO_CHAR( SYSDATE, 'WW' ) "��������", TO_CHAR( SYSDATE, 'IW' ) "���� ����"
FROM dual;

 [������]
���ó�¥    �������� �������� ���� ����
--------    -       --      -- 
23/03/24      4     12       12 
-------------------------------------------------------------------------------      
-- [ ���̺� ���� ]
1) ���̺� ������ �ϴ� ���� �ܼ��ϸ鼭 �Ϲ����� ����������� ����
    CREATE TABLE ���̺��
    (
        �÷���     �ڷ���(ũ��) [DEFAULT ��] [��������]
        , �÷���     �ڷ���(ũ��) [DEFAULT ��] [��������]
                            :
    );

2) ��������(subquery)�� �̿��� ���̺� ���� ���
    ��. �̹� �����ϴ� ���̺��� �ְ�
    ��. SELECT~ ���������� �̿��ؼ�
    ��. ���ο� ���̺� ����
    ��. + ���� ���̺��� �����͵� �ڵ����� �߰��ȴ�
        ������) ���������� �߰����� �ʴ´�
    ��. [����]
        CREATE TABLE ���̺�� [�÷���...]
        AS
            ��������;
    
    ��) deptno, dname, empno, hiredate, pay, grade �÷��� ���� ���̺� ����
    emp : [deptno], empno, hiredate, pay
    salgrade : grade
    dept : [deptno], dname
    �̹� emp, salgrade ���� -> ���̺� ���� ( tbl_empgrade )
    
    CREATE TABLE tbl_empgrade
    AS
        (
        SELECT d.deptno, dname, empno, hiredate, sal+NVL(comm,0) pay, grade
        FROM emp e JOIN salgrade s ON e.sal BETWEEN s.losal AND s.hisal
                   JOIN dept d ON d.deptno = e.deptno
        );
    -- Table TBL_EMPGRADE��(��) �����Ǿ����ϴ�.
    
    SELECT *
    FROM tbl_empgrade;
    -- ���������� ������� �ʴ´�
    
    DESC tbl_empgrade;
    
�̸�     ��? ����           
-------- -- ------------ 
DEPTNO      NUMBER(2)    dept ����
DNAME       VARCHAR2(14) dept ����
EMPNO       NUMBER(4)    emp ����
HIREDATE    DATE         emp ����
PAY         NUMBER       sal+comm �����ؼ� ���� �÷� -> �ý����� �ڵ����� �ڷ��� �ο�
GRADE       NUMBER       salgrade ����

    -- ���࿡ ������ ���̺��� �̿��ؼ� ���ο� ���̺��� �����ϰ��� �� ��
    -- �����ʹ� �ʿ����
    -- emp ���� �״�� tbl_emp_copy ���̺�� ���� ����
    CREATE TABLE tbl_emp_copy
    AS
        SELECT * FROM emp
        WHERE 1 = 0; -- ������ ������� �ʴ´�
        
    SELECT *
    FROM tbl_emp_copy;
-------------------------------------------------------------------------------
-- [ ���������� ����ϴ� INSERT�� ]
SELECT *
FROM tbl_emp_copy;
-- tbl_enp_copy ���̺� emp �� 30�� �μ������� SELECT �ؼ� INSERT
-- INSERT INTO ��Ű��, ���̺�� [( �÷���...)] VALUES ( �÷���...);
-- INSERT INTO ��Ű��.���̺�� ( �������� )

INSERT INTO tbl_emp_copy
(
SELECT *
FROM emp
WHERE deptno = 30
);
-- 6�� �� ��(��) ���ԵǾ����ϴ�.
COMMIT;
--
DROP TABLE tbl_emp_copy PURGE;
-- Table TBL_EMP_COPY��(��) �����Ǿ����ϴ�.

-- [ MULTITABLE INSERT �� ]
-- ���� INSERT�� : 1�� ���ڵ� -> INSERT -> ������ ���̺�
1) unconditional insert all
    [ ������ ���� ���� INSERT�� ]
    �� ���ǰ� ������� ����Ǿ��� �������� ���̺� �����͸� �Է��Ѵ�
    ? ���������κ��� �ѹ��� �ϳ��� ���� ��ȯ�޾� ���� insert ���� �����Ѵ�.
    ? into ���� values ���� ����� �÷��� ������ ������ Ÿ���� �����ؾ� �Ѵ�.

�����ġ�
	INSERT ALL | FIRST
	  [INTO ���̺�1 VALUES (�÷�1,�÷�2,...)]
	  [INTO ���̺�2 VALUES (�÷�1,�÷�2,...)]
	  .......
	Subquery;
    
    -- 1) INSERT INTO ���̺�� ( �÷���,,,) VALUES ( �÷���...);
    -- 2) INSERT INTO ���̺�� ( �������� );
    
    ��)
    SELECT *
    FROM emp;
    
    SELECT * FROM tbl_emp10;
    SELECT * FROM tbl_emp20;
    SELECT * FROM tbl_emp30;
    SELECT * FROM tbl_emp40;
    
    -- ���������� ����ؼ� ���̺� 4�� ����
    CREATE TABLE tbl_emp10  AS ( SELECT * FROM emp WHERE 1=0 );
    CREATE TABLE tbl_emp20  AS ( SELECT * FROM emp WHERE 1=0 );
    CREATE TABLE tbl_emp30  AS ( SELECT * FROM emp WHERE 1=0 );
    CREATE TABLE tbl_emp40  AS ( SELECT * FROM emp WHERE 1=0 );
    
    -- unconditional insert all ��
    INSERT ALL
        INTO tbl_emp10 VALUES ( empno, ename, job, mgr, hiredate, sal, comm, deptno )
        INTO tbl_emp20 VALUES ( empno, ename, job, mgr, hiredate, sal, comm, deptno )
        INTO tbl_emp30 VALUES ( empno, ename, job, mgr, hiredate, sal, comm, deptno )
        INTO tbl_emp40 VALUES ( empno, ename, job, mgr, hiredate, sal, comm, deptno )
    SELECT * FROM emp;
    
    ROLLBACK;
    
2) conditional insert all
    [ ������ �ִ� ���� INSERT�� ]
    INSERT ALL
        WHEN deptno = 10 THEN
            INTO tbl_emp10 VALUES ( empno, ename, job, mgr, hiredate, sal, comm, deptno )
        WHEN deptno = 20 THEN
            INTO tbl_emp20 VALUES ( empno, ename, job, mgr, hiredate, sal, comm, deptno )
        WHEN deptno = 30 THEN
            INTO tbl_emp30 VALUES ( empno, ename, job, mgr, hiredate, sal, comm, deptno )
        ELSE
            INTO tbl_emp40 VALUES ( empno, ename, job, mgr, hiredate, sal, comm, deptno )
    SELECT * FROM emp;    
    
    -- ������ ����
    -- DELETE FROM tbl_emp10; COMMIT;
    
    -- ���̺� ���� ��� ���ڵ带 ���� + �ڵ� Ŀ��/�ѹ�
    TRUNCATE TABLE tbl_emp10;
    TRUNCATE TABLE tbl_emp20;
    TRUNCATE TABLE tbl_emp30;
    TRUNCATE TABLE tbl_emp40;
    
3) conditional first insert
    [ ������ �ִ� ù��° INSERT�� ]
    �����ġ�
    INSERT FIRST
    WHEN ������1 THEN
      INTO [���̺�1] VALUES (�÷�1,�÷�2,...)
    WHEN ������2 THEN
      INTO [���̺�2] VALUES (�÷�1,�÷�2,...)
    ........
    ELSE
      INTO [���̺�3] VALUES (�÷�1,�÷�2,...)
    Sub-Query;
    
    ? conditional INSERT FIRST�� �������� ����Ͽ� ���ǿ� �´� ������ ���ϴ� ���̺� ������ �� �ִ�.
    ? ���� ���� WHEN...THEN���� ����Ͽ� ���� ���� ����� �����ϴ�. ��, ù ��° WHEN ������ ������ �����Ѵٸ�, INTO ���� ������ �� ������ WHEN ������ �� �̻� �������� �ʴ´�.
    ? subquery�κ��� �� ���� �ϳ��� ���� ���� �޾� when...then������ ������ üũ�� �� ���ǿ� �´� ���� ����� ���̺� insert�� �����Ѵ�.
    ? ������ ����� when ������ �����ϴ� ���� ���� ��� else���� ����Ͽ� into ���� ������ �� �ִ�. else���� ���� ��� ���� �� ���࿡ ���ؼ��� �ƹ��� �۾��� �߻����� �ʴ´�.
    
    SELECT *
    FROM emp
    WHERE deptno = 10 AND job = 'CLERK'; -- MILLER
    
     INSERT ALL
        WHEN deptno = 10 THEN
            INTO tbl_emp10 VALUES ( empno, ename, job, mgr, hiredate, sal, comm, deptno )
        WHEN job = 'CLERK' THEN
            INTO tbl_emp20 VALUES ( empno, ename, job, mgr, hiredate, sal, comm, deptno )
        ELSE
            INTO tbl_emp40 VALUES ( empno, ename, job, mgr, hiredate, sal, comm, deptno )
    SELECT * FROM emp;    
    
    SELECT * FROM tbl_emp10; -- FIRST : MILLER O / ALL : MILLER O
    SELECT * FROM tbl_emp20; -- FIRST : MILLER X / ALL : MILLER O
    SELECT * FROM tbl_emp30;
    SELECT * FROM tbl_emp40;

4) pivoting insert 
    [ �Ǻ� ]
create table tbl_sales(
    employee_id       number(6),
    week_id           number(2),
    sales_mon         number(8,2),
    sales_tue         number(8,2),
    sales_wed         number(8,2),
    sales_thu         number(8,2),
    sales_fri         number(8,2)
);
-- Table TBL_SALES��(��) �����Ǿ����ϴ�.

insert into tbl_sales values(1101,4,100,150,80,60,120);
insert into tbl_sales values(1102,5,300,300,230,120,150);
COMMIT;
--
SELECT * FROM tbl_sales;
--
SELECT * FROM tbl_sales_data
ORDER BY employee_id;
--
create table tbl_sales_data(
    employee_id        number(6),
    week_id            number(2),
    sales              number(8,2)
);
-- Table TBL_SALES_DATA��(��) �����Ǿ����ϴ�.

-- UC ���� INSERT��
insert all
    into tbl_sales_data values(employee_id, week_id, sales_mon)
    into tbl_sales_data values(employee_id, week_id, sales_tue)
    into tbl_sales_data values(employee_id, week_id, sales_wed)
    into tbl_sales_data values(employee_id, week_id, sales_thu)
    into tbl_sales_data values(employee_id, week_id, sales_fri)
    
    select employee_id, week_id, sales_mon, sales_tue, sales_wed,
           sales_thu, sales_fri
    from tbl_sales;
COMMIT;
-------------------------------------------------------------------------------
[����] insa ���̺��� num, name �÷����� �����ؼ� ���ο� tbl_score ���̺� ����
    ( ���� : num <= 1005 )
-- ���� ���̺��� ����ؼ� ���̺� ����    
CREATE TABLE tbl_score
AS
    (
        SELECT num, name
        FROM insa
        WHERE num <= 1005
    );
-- Table TBL_SCORE��(��) �����Ǿ����ϴ�.
SELECT *
FROM tbl_score;
    
[����] tbl_score ���̺� kor, eng, mat, tot, avg, grade, rank �÷� �߰�
kor, eng, mat, tot : NUMBER(3) DEFAULT 0
avg : NUMBER(5,2)
grade : CHAR(1 CHAR)
rank : NUMBER(3)
-- ���� ���̺� �÷� 6�� �߰� ( ���̺� ����(����) )
ALTER TABLE ADD ��������, �÷� �߰�
ALTER TABLE MODIFY �ڷ���, ũ�� ��� ����
ALTER TABLE DROP ��������, �÷� ����

ALTER TABLE tbl_score
ADD (
      kor NUMBER(3) DEFAULT 0
    , eng NUMBER(3) DEFAULT 0
    , mat NUMBER(3) DEFAULT 0
    , tot NUMBER(3)
    , avg NUMBER(5,2)
    , grade CHAR(1 CHAR) -- A B C D F
    , rank NUMBER(3)
);
-- Table TBL_SCORE��(��) ����Ǿ����ϴ�.
DESC tbl_score;

[����] tbl_score ���̺� num( 1001~1005 ) 5���� kor, eng, mat ������ ������ ��( 0~100 ) ����
UPDATE tbl_score
SET   kor = TRUNC( dbms_random.VALUE(0,101) )
    , eng = TRUNC( dbms_random.VALUE(0,101) )
    , mat = TRUNC( dbms_random.VALUE(0,101) );
-- SET (kor, eng, mat ) = ( SELECT TRUNC( dbms_random.VALUE(0,101) ), TRUNC( dbms_random.VALUE(0,101) ), TRUNC( dbms_random.VALUE(0,101) ) FROM dual )
COMMIT;

[����] ��� �л����� tot, avg ����
UPDATE tbl_score
SET   tot = kor + eng + mat
    , avg = ( kor + eng + mat ) / 3;
COMMIT;

[����] avg ������ �Ҽ��� 2�ڸ����� ���
SELECT num, name, kor, eng, mat, tot, TO_CHAR( avg, '999.00' ) avg, grade, rank
FROM tbl_score;

[����] grade ��� 90 �̻� A, 80 �̻� B, 70 �̻� C, 60 �̻� D, ������ F ����
UPDATE tbl_score
SET grade = CASE
                WHEN 90 <= avg THEN 'A'
                WHEN 80 <= avg THEN 'B'
                WHEN 70 <= avg THEN 'C'
                WHEN 60 <= avg THEN 'D'
                ELSE 'F'
            END;
ROLLBACK;
UPDATE tbl_score
SET grade = DECODE( TRUNC( avg/10 ), 10, 'A', 9, 'A', 8, 'B', 7, 'C', 6, 'D', 'F' );
COMMIT;
SELECT *
FROM tbl_score;

[����] tbl_score ���̺��� rank ��� ó�� ����
UPDATE tbl_score a
SET rank = ( SELECT COUNT(*)+1 FROM tbl_score WHERE tot > a.tot );

[����] ��� �л����� ���� ����
UPDATE tbl_score
SET kor = CASE
            WHEN kor + 10 > 100 THEN 100
            ELSE kor + 10
           END;
-- ������) �Ѹ��� ��� �л��� kor ������ ������ �Ǹ� ����, ���, ���, ���� �ڵ� ���� (Ʈ����)

[����] tbl_score ���̺��� ���л��� ���� ������ 3�� ����
( ���� : insa ���̺� ssn �����ؼ� ���л��� ��󳻱� )

UPDATE tbl_score
SET mat = CASE
            WHEN mat + 3 > 100 THEN 100
            ELSE mat + 3
           END
WHERE num = ANY ( -- ANY     SQL �����ڸ� ����ص� �ȴ�
            SELECT num
            FROM insa
            WHERE MOD( SUBSTR( ssn, -7, 1 ), 2 ) = 0 AND num <= 1005
            );
--
WHERE num IN (
            SELECT num
            FROM insa
            WHERE MOD( SUBSTR( ssn, -7, 1 ), 2 ) = 0 AND num <= 1005
            );

-- 1003 ���л�
SELECT num
FROM insa
WHERE MOD( SUBSTR( ssn, -7, 1 ), 2 ) = 0 AND num <= 1005;












      
      
      
      
      
      
      
      
      
      