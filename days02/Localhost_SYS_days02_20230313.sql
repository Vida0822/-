-- SYS --
1. ���̺����̽� ���� ����
    [DDL]
	CREATE TABLESPACE <tablespace��>
	DATAFILE 'datafile ��ο� �̸�' SIZE ���� [K|M] [,file��...,,]
    [MINIMUM EXTENT ���� [K|M]]
	[BLOCKSIZE ũ�� [K|M]]
	[DEFAULT storage ��]
	[PERMANENT | TEMPORARY]
	[ONLINE | OFFLINE]
	[EXTENT_MANAGEMENT ��]
	[SEGMENT_MANAGEMENT ��]
	[LOGGING | NOLOGGING];

--------------------------------------------------------------------------------------------
����) ��� ������Ʈ ���� ��
C:\Users\dlsgu>sqlplus / as sysdba
SQL>_

[���̺����̽� ��ȸ]
SQL> SELECT tablespace_name, file_name
  2  FROM dba_data_files;

TABLESPACE_NAME     FILE_NAME
--------------------------------------------------------------------------------
1) USERS            C:\ORACLEXE\APP\ORACLE\ORADATA\XE\USERS.DBF

2) SYSAUX           C:\ORACLEXE\APP\ORACLE\ORADATA\XE\SYSAUX.DBF

3) UNDOTBS1         C:\ORACLEXE\APP\ORACLE\ORADATA\XE\UNDOTBS1.DBF

4) SYSTEM           C:\ORACLEXE\APP\ORACLE\ORADATA\XE\SYSTEM.DBF

SQL> show user
USER is "SYS"

SQL> SELECT tablespace_name, contents
  2  FROM dba_tablespaces; -- ��(view)

TABLESPACE_NAME                                              CONTENTS
------------------------------------------------------------ ------------------
SYSTEM                                                       PERMANENT
SYSAUX                                                       PERMANENT
UNDOTBS1                                                     UNDO
TEMP                                                         TEMPORARY
USERS                                                        PERMANENT

[���̺����̽� ����]
SQL> SELECT tablespace_name,status
  2  FROM dba_tablespaces;

TABLESPACE_NAME                                              STATUS
------------------------------------------------------------ ------------------
SYSTEM                                                       ONLINE
SYSAUX                                                       ONLINE
UNDOTBS1                                                     ONLINE
TEMP                                                         ONLINE
USERS                                                        ONLINE

SQL> exit
Disconnected from Oracle Database 11g Express Edition Release 11.2.0.2.0 - 64bit Production
---------------------------------------------------------------------------------------------

-- SQL Developer ��
---------------------------------------------------------------------------------------------
����) [����] ���̺����̽� ����, ������ ����, ���� ������ ��ȸ�ϴ� ������ �ۼ��ϼ���
SELECT TABLESPACE_NAME, CONTENTS, STATUS --, FILE_NAME
FROM dba_tablespaces;

����) dba_tablespaces�� ���� Ȯ��
DESC dba_tablespaces; -- ��(��ü)�� �÷� ������ ��ȸ�ϴ� ��ɾ�
DESCRIBE dba_tablespaces;
-- ��Ű��(schema) ? DBA������(sys)
DESCRIBE sys.dba_tablespaces;
-- DESC[RIBE] ��ɾ�
-- ��ü(���̺�, ��, Ÿ��, ���ν���, �Լ�, ��Ű��, �ó��)���� �÷��� ������ ��ȸ
�����ġ� 
     DESCRIBE {[schema.]object[@db_link]}



�̸�                       ��?       ����           
------------------------ -------- ------------ 
TABLESPACE_NAME          NOT NULL VARCHAR2(30) 
BLOCK_SIZE               NOT NULL NUMBER       
INITIAL_EXTENT                    NUMBER       
NEXT_EXTENT                       NUMBER       
MIN_EXTENTS              NOT NULL NUMBER       
MAX_EXTENTS                       NUMBER       
MAX_SIZE                          NUMBER       
PCT_INCREASE                      NUMBER       
MIN_EXTLEN                        NUMBER       
STATUS                            VARCHAR2(9)  
CONTENTS                          VARCHAR2(9)  
LOGGING                           VARCHAR2(9)  
FORCE_LOGGING                     VARCHAR2(3)  
EXTENT_MANAGEMENT                 VARCHAR2(10) 
ALLOCATION_TYPE                   VARCHAR2(9)  
PLUGGED_IN                        VARCHAR2(3)  
SEGMENT_SPACE_MANAGEMENT          VARCHAR2(6)  
DEF_TAB_COMPRESSION               VARCHAR2(8)  
RETENTION                         VARCHAR2(11) 
BIGFILE                           VARCHAR2(3)  
PREDICATE_EVALUATION              VARCHAR2(7)  
ENCRYPTED                         VARCHAR2(3)  
COMPRESS_FOR                      VARCHAR2(12)
---------------------------------------------------------------------------------------------

2. ����� ���� ����
    1) ��� ����� ���� ���� ��ȸ
SELECT *
FROM user_users;
FROM dba_users;
FROM all_users;

[dictionary] all_users;     all_XXX;    - ��� ����ڿ� ���� ����([USERNAME],[USER_ID],[CREATED])
[dictionary] dba_users;     dba_XXX;    - ��� ����ڿ� ���� [���] ����(��ȣ���� ����)
[dictionary] user_users;    user_XXX;   - ���� �������� user(SYS)�� access�� �� �ִ� user(SYS) ���� ��ȸ

[����] all_users, dba_users, user_users �� �����ϼ���(������)

[USERNAME]          [USER_ID]   [CREATED]
XS$NULL	            2147483638	14/05/29
APEX_040000	        47	        14/05/29
APEX_PUBLIC_USER	45	        14/05/29
FLOWS_FILES	        44	        14/05/29
HR	                43	        14/05/29
MDSYS	            42	        14/05/29
ANONYMOUS	        35	        14/05/29
XDB	                34	        14/05/29
CTXSYS	            32	        14/05/29
APPQOSSYS	        30	        14/05/29
DBSNMP	            29	        14/05/29
ORACLE_OCM	        21	        14/05/29
DIP	                14	        14/05/29
OUTLN	            9	        14/05/29
SYSTEM	            5	        14/05/29
SYS	                0	        14/05/29

    2) ����� ���� ����
        ��) SCOTT ������ �ֳ��� ? X
        ��) SCOTT ���� ����
        DBA(SYS, SYSTEM) - ����� ���� ���� + USER ���� ������ ���� ����
                                            ���� LOCKING(���) - �α��� �Ұ�
                                            ��(ROLE==���ѱ׷�) USER���� �Ҵ�
                                            ����(PRIVILEGE) USER �Ҵ�
                                            �ý��� �ڿ� ����
                                            ���̺� �����̽��� USER���� �̸� ����
                                            ���
        - DATABASE SCHEMA(��Ű��)
            - SCOTT ������ �����ϸ� �ڵ����� SCOTT�̶� ��Ű�� ����
            - ��Ű�� == �� ����ڰ� ������ �� �ִ� ��� ��ü(Object) ����
            ��) ������ ���Ի�� -> {å��, ��Ʈ��, ����, �ʱ⵵�� ���)
                                        ��Ű��.��ü��
                                        ������.å��
                                        ������.��Ʈ��
        ��) ���� ���� ���� ����
        CREATE USER ����ڸ�
        IDENTIFIED BY ��й�ȣ �Ǵ� IDENTIFIED EXTERNALLY
        [DEFAULT TABLESPACE ���̺����̽���]
        [TEMPORARY TABLESPACE ���̺����̽���]
        [PROFILE �������ϸ�]
        [QUOTA �Ҵ緮 ON ���̺����̽��� �Ǵ� UNLIMITED ON ���̺����̽���]
        [PASSWORD EXPIRE]
        [ACCOUNT LOCK �Ǵ� UNLOCK];

        ��) DDL
        CREATE USER scott -- ��ҹ��� ���� X
        IDENTIFIED BY tiger -- ��ҹ��� ���� O
        -- DEFAULT TABLESPACE   USERS
        -- TEMPORARY TABLESPAC  TEMP
        -- PROFILE              ����ڿ��� �ο��� profile
        -- QUOTA                USERS �Ҵ緮 ����
        -- PASSWORD EXPIRE      ���� ��� ���� ����
        -- ACCOUNT LOCK �Ǵ� UNLOCK
        
-- ��� ����� ���� ���� ��ȸ(Ȯ��)
SELECT *
FROM all_users;

        ��) scott �������� �α���
        ERROR:
        ORA-01045: user SCOTT lacks CREATE SESSION privilege; logon denied
                   "CREATE SESSION" ������ ��� �α��� �����ߴ�
        �α��� �� �� �ִ� ���� �ο� - CREATE SESSION ���� �ο�
        ��) ���� �ο�
        (1) �����̶�?
        �����̶� SQL ���� �����ϰų�,
        �����ͺ��̽��� �����ͺ��̽��� ��ü�� ������ �� �ִ� ������ �ǹ��Ѵ�
        (2) ���� �ο�
        - DBA - ���� �ο� -> �����(scott)
        - ��(���� Role) ���� - ���� �ο� -> �����(scott)
          A ����
          B ����
          C ����
          ���
        - CRUD �۾��� ���� O
        - ������ 2���� ����
            ��. �ý���(System) ���� : DB ��ü ����, ����, ���� ����
                ��) CREATE SESSION ����(DB ����)
            �����ġ� 
            GRANT �ý��۱��Ѹ� �Ǵ� �Ѹ� TO ����ڸ� �Ǵ� �Ѹ� �Ǵ� PUBLIC
                [WITH ADMIN OPTION];
                
            ��) ���� �ο�
            GRANT CREATE SESSION TO scott; -- xx ����� �ο�
            �� �ο�
            GRANT CONNECT, RESOURCE TO scott;
            -- Grant��(��) �����߽��ϴ�.
            
            ��) ���� ȸ��
            REVOKE CREATE SESSION FROM scott;

            ��. ��ü(Object) ���� : ��ü ����(�߰�, ����, ����, �˻�) ����
            ��. ����, �� ��ȸ
            SELECT *
            FROM dba_sys_privs;
            ��. ��(ROLE:����)
            ������
            ���Ի��        ->      ������         ->      �����
            ���Է� �ο�           ���Է� ȸ��            �����η� ȸ��
                                �����η� �ο�           ����η� �ο�
                                
            20�� ����          ���� 20�� ���� ȸ��       ������ 30�� �ο�
                              ������ 30�� ���� �ο�     ����� 50�� �ο�

            ���Է�(20�� ���� �ο�)
            �����η�(30�� ���� �ο�)
            ����η�(50�� ���� �ο�)
            
1) ��й�ȣ ����
ALTER USER scott
IDENTIFIED BY tiger;
2) scott ���� �����ϰ� ����
"user" �˻�
CREATE USER ����� ���� ����
ALTER USER  ����� ���� ����
DROP USER   ����� ���� ����

DROP USER scott [CASCADE];
-------------------------------------------------------------------------------

[����]
1. ��� ������ ��ȸ
SELECT *
FROM all_users;
2. SCOTT ������ ������ ����
DROP USER scott CASCADE;
3. ��� ������ ��ȸ(SCOTT ���� Ȯ��)
SELECT *
FROM all_users;
4. SCOTT ������ ��й�ȣ : 1234�� ���� ����
CREATE USER scott
IDENTIFIED BY 1234;
4-2. CONNECT, RESOURCE ���� �ο�
GRANT CONNECT, RESOURCE TO scott;
5. ��� ������ ��ȸ(SCOTT ���� Ȯ��)
6. SCOTT ������ ��й�ȣ�� tiger�� ����
ALTER USER scott
IDENTIFIED BY tiger;
7. ��� ������ ��ȸ
-------------------------------------------------------------------------------

1) SCOTT ���� - ���� ���̺�(table) ����  CRUD
C:\oraclexe ������ �̵� - scott.sql �˻�
C:\oraclexe\app\oracle\product\11.2.0\server\rdbms\admin

-- ������ ��� ������ Ȯ���Ϸ��� SYS��� ������ ���������� Ȯ���� �� �ִ�
-- dba_users �並 ���ؼ�
SELECT username, account_status, expiry_date
FROM dba_users;

-- hr ������ ���¸� locked -> open
-- CREATE USER
-- ALTER USER
-- DROP USER

ALTER USER hr
IDENTIFIED BY lion; -- ��й�ȣ ����

ALTER USER hr
ACCOUNT UNLOCK; -- ���� ��� ����

-- ��й�ȣ ���� + ���� ��� ����
ALTER USER hr
IDENTIFIED BY lion
ACCOUNT UNLOCK;

































