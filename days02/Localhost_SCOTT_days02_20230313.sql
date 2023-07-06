-- SCOTT --
1) SCOTT ������ �����ϰ� �ִ� ���̺� ��� ��ȸ

    [DQL(Q==Query) ��ȸ : SELECT��]
    1. SELECT, ��������(subquery)�� �̿��Ͽ�
    �ϳ� �̻���  ���̺� [���̺�(table), ��ü ���̺�(object table)]
              , ��    [��(view), ��ü ��(object view), ������ ��(materialized view)]�κ���
    �����͸� �������µ� ���ȴ�.
    2. ���̺�, �䰡 �ڽ��� �����̰ų�, SELECT ������ �־�� �ȴ�.
    3. SYS -> SELECT ANY TABLE �ý��۱��� �ο� -> SCOTT
    
�����ġ�
    [subquery_factoring_clause] subquery [for_update_clause];

��subquery ���ġ�
   {query_block ?
    subquery {UNION [ALL] ? INTERSECT ? MINUS }... ? (subquery)} 
   [order_by_clause] 

��query_block ���ġ�
   SELECT [hint] [DISTINCT ? UNIQUE ? ALL] select_list
   FROM {table_reference ? join_clause ? (join_clause)},...
     [where_clause] 
     [hierarchical_query_clause] 
     [group_by_clause]
     [HAVING condition]
     [model_clause]

��subquery factoring_clause���ġ�
   WITH {query AS (subquery),...}
   
   4. SELECT������ ���Ǵ� ��(clause) [�ϱ�] + ���� ó���Ǵ� ���� [�ϱ�]
   (1) WITH��            1��
   (2) SELECT�� ***          6��
   (3) FROM�� ***        2��
   (4) WHERE��           3��
   (5) GROUP BY��        4��
   (6) HAVING��          5��
   (7) ORDER BY��            7��
   
   -> ó�� ������� �ڵ��� �ϴ� ������ ������
-------------------------------------------------------------------------------

1) SCOTT ������ �����ϰ� �ִ� ���̺� ��� ��ȸ (SELECT�� ���)
SELECT *

SELECT TABLE_NAME
FROM user_tables;

FROM user_users;
FROM ���̺� �Ǵ� ��(View);

���� scott ����ڴ� �����ϰ� �ִ� ���̺��� �������� �ʴ´�

2) user_tables�� ���� Ȯ��
DESCRIBE
DESC user_tables;

�̸�                        ��?       ����           
------------------------- -------- ------------ 
TABLE_NAME                NOT NULL VARCHAR2(30) 
TABLESPACE_NAME                    VARCHAR2(30) 
CLUSTER_NAME                       VARCHAR2(30) 
IOT_NAME                           VARCHAR2(30) 
STATUS                             VARCHAR2(8)  
PCT_FREE                           NUMBER       
PCT_USED                           NUMBER       
INI_TRANS                          NUMBER       
MAX_TRANS                          NUMBER       
INITIAL_EXTENT                     NUMBER       
NEXT_EXTENT                        NUMBER       
MIN_EXTENTS                        NUMBER       
MAX_EXTENTS                        NUMBER       
PCT_INCREASE                       NUMBER       
FREELISTS                          NUMBER       
FREELIST_GROUPS                    NUMBER       
LOGGING                            VARCHAR2(3)  
BACKED_UP                          VARCHAR2(1)  
NUM_ROWS                           NUMBER       
BLOCKS                             NUMBER       
EMPTY_BLOCKS                       NUMBER       
AVG_SPACE                          NUMBER       
CHAIN_CNT                          NUMBER       
AVG_ROW_LEN                        NUMBER       
AVG_SPACE_FREELIST_BLOCKS          NUMBER       
NUM_FREELIST_BLOCKS                NUMBER       
DEGREE                             VARCHAR2(40) 
INSTANCES                          VARCHAR2(40) 
CACHE                              VARCHAR2(20) 
TABLE_LOCK                         VARCHAR2(8)  
SAMPLE_SIZE                        NUMBER       
LAST_ANALYZED                      DATE         
PARTITIONED                        VARCHAR2(3)  
IOT_TYPE                           VARCHAR2(12) 
TEMPORARY                          VARCHAR2(1)  
SECONDARY                          VARCHAR2(1)  
NESTED                             VARCHAR2(3)  
BUFFER_POOL                        VARCHAR2(7)  
FLASH_CACHE                        VARCHAR2(7)  
CELL_FLASH_CACHE                   VARCHAR2(7)  
ROW_MOVEMENT                       VARCHAR2(8)  
GLOBAL_STATS                       VARCHAR2(3)  
USER_STATS                         VARCHAR2(3)  
DURATION                           VARCHAR2(15) 
SKIP_CORRUPT                       VARCHAR2(8)  
MONITORING                         VARCHAR2(3)  
CLUSTER_OWNER                      VARCHAR2(30) 
DEPENDENCIES                       VARCHAR2(8)  
COMPRESSION                        VARCHAR2(8)  
COMPRESS_FOR                       VARCHAR2(12) 
DROPPED                            VARCHAR2(3)  
READ_ONLY                          VARCHAR2(3)  
SEGMENT_CREATED                    VARCHAR2(3)  
RESULT_CACHE                       VARCHAR2(7) 

3) scott ����ڰ� ���� �߿� ����� ���̺��� ���� + ������ �߰�
scott.sql ������ ���÷� ã�ƿԽ��ϴ�

C:\Users\dlsgu>sqlplus sys/ss123$ as sysdba
SQL> @C:\oraclexe\app\oracle\product\11.2.0\server\rdbms\admin\scott.sql
SQL>_

-- SCOTT�� �����ϰ� �ִ� ��� ���̺� ���� ��ȸ
SELECT *
FROM user_tables;
-- DEPT, EMP. BONUS, SALGRADE 4���� ���̺� ����

-- ��� ����� ���� ��ȸ --
SELECT *
FROM dba_users; -- dba_XXX �並 ����Ϸ��� DBA(������)�� ����� �� �ִ� ���̴�
[���� �߻�]
ORA-00942: table or view does not exist         ���̺�, ��(dba_users)�� �������� �ʴ´�.
00942. 00000 -  "table or view does not exist"
*Cause:    
*Action:
130��, 6������ ���� �߻�

FROM all_users;
-- HR	43	14/05/29    ������ ����Ŭ ��ġ�� �� ���� ���� ���� O
-- The account is locked ������ ������ִ�
-- ��� ������� ������ ���� Ȯ�� (���) ��ȸ

all_users -- username, user_id, created 3�� ������ Ȯ�� ����
dba_users --                            + �� ���� ���� Ȯ�� ����
-------------------------------------------------------------------------------

-- scott.sql ��ũ��Ʈ ���� @ ����
-- emp, dept, salgrade, bonus 4�� ���̺� ����
-- 1) emp ��� ���� ���̺�
-- 2) dept �μ� ���� ���̺�
-- 3) salgrade �⺻�� + ��� ���̺�
-- 4) bonus ���ʽ� ���̺�

-- SELECT�� ���� --
(1) ��� ��� ������ ��ȸ (SELECT��)
SELECT * -- ��� �÷� ���� *
FROM emp;
-- 12���� ��� ����
empno   ename   job         mgr     hiredate    sal     comm    deptno
7369	SMITH	CLERK	    7902	80/12/17	800		        20(RESEARCH)
7499	ALLEN	SALESMAN	7698	81/02/20	1600	300	    30
7521	WARD	SALESMAN	7698	81/02/22	1250	500	    30
7566	JONES	MANAGER	    7839	81/04/02	2975		    20
7654	MARTIN	SALESMAN	7698	81/09/28	1250	1400	30
7698	BLAKE	MANAGER	    7839	81/05/01	2850		    30
7782	CLARK	MANAGER	    7839	81/06/09	2450		    10
7839	KING	PRESIDENT		    81/11/17	5000		    10
7844	TURNER	SALESMAN	7698	81/09/08	1500	0	    30
7900	JAMES	CLERK	    7698	81/12/03	950		        30
7902	FORD	ANALYST	    7566	81/12/03	3000		    20
7934	MILLER	CLERK	    7782	82/01/23	1300		    10

2) deptno == 20	RESEARCH	DALLAS
SELECT *
FROM dept;

(2) ��� ����� ����� �Ի����ڸ� ��ȸ
    -- 80(RR)/12(MM)/17(DD)
    --    ��     ��      ��
    -- ���� / ȯ�漳�� / �����ͺ��̽� / NLS Ŭ��
    -- ��¥ ���� ���� : RR/MM/DD
SELECT ename, hiredate
FROM emp;

SMITH	80/12/17
ALLEN	81/02/20
WARD	81/02/22
JONES	81/04/02
MARTIN	81/09/28
BLAKE	81/05/01
CLARK	81/06/09
KING	81/11/17
TURNER	81/09/08
JAMES	81/12/03
FORD	81/12/03
MILLER	82/01/23

(3) ��� ����� ������ ��ȸ
    (����:�����ȣ, �����, �Ի�����)
    (����:����(�޿�) = �⺻�� + Ŀ�̼�)
SELECT empno, ename, hiredate
      , sal
      , comm
      , sal + comm
FROM emp;

[������] comm�� null���� ��쿡�� sal + comm = null
        sal�� ����� �ǵ��� ����
        null ó���� ��� �ϴ°�?






























