-- SYS --
1. 테이블스페이스 생성 형식
    [DDL]
	CREATE TABLESPACE <tablespace명>
	DATAFILE 'datafile 경로와 이름' SIZE 숫자 [K|M] [,file명...,,]
    [MINIMUM EXTENT 숫자 [K|M]]
	[BLOCKSIZE 크기 [K|M]]
	[DEFAULT storage 절]
	[PERMANENT | TEMPORARY]
	[ONLINE | OFFLINE]
	[EXTENT_MANAGEMENT 절]
	[SEGMENT_MANAGEMENT 절]
	[LOGGING | NOLOGGING];

--------------------------------------------------------------------------------------------
예제) 명령 프롬프트 실행 후
C:\Users\dlsgu>sqlplus / as sysdba
SQL>_

[테이블스페이스 조회]
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
  2  FROM dba_tablespaces; -- 뷰(view)

TABLESPACE_NAME                                              CONTENTS
------------------------------------------------------------ ------------------
SYSTEM                                                       PERMANENT
SYSAUX                                                       PERMANENT
UNDOTBS1                                                     UNDO
TEMP                                                         TEMPORARY
USERS                                                        PERMANENT

[테이블스페이스 상태]
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

-- SQL Developer 툴
---------------------------------------------------------------------------------------------
예제) [문제] 테이블스페이스 종류, 물리적 파일, 상태 정보를 조회하는 쿼리를 작성하세요
SELECT TABLESPACE_NAME, CONTENTS, STATUS --, FILE_NAME
FROM dba_tablespaces;

예제) dba_tablespaces의 구조 확인
DESC dba_tablespaces; -- 뷰(객체)의 컬럼 정보를 조회하는 명령어
DESCRIBE dba_tablespaces;
-- 스키마(schema) ? DBA계정명(sys)
DESCRIBE sys.dba_tablespaces;
-- DESC[RIBE] 명령어
-- 객체(테이블, 뷰, 타입, 프로시져, 함수, 패키지, 시노님)에서 컬럼의 정보를 조회
【형식】 
     DESCRIBE {[schema.]object[@db_link]}



이름                       널?       유형           
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

2. 사용자 계정 생성
    1) 모든 사용자 계정 정보 조회
SELECT *
FROM user_users;
FROM dba_users;
FROM all_users;

[dictionary] all_users;     all_XXX;    - 모든 사용자에 관한 정보([USERNAME],[USER_ID],[CREATED])
[dictionary] dba_users;     dba_XXX;    - 모든 사용자에 관한 [모든] 정보(암호관리 포함)
[dictionary] user_users;    user_XXX;   - 현재 접속중인 user(SYS)가 access할 수 있는 user(SYS) 정보 조회

[문제] all_users, dba_users, user_users 을 설명하세요(차이점)

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

    2) 사용자 계정 생성
        ㄱ) SCOTT 계정이 있나요 ? X
        ㄴ) SCOTT 계정 생성
        DBA(SYS, SYSTEM) - 사용자 계정 생성 + USER 접근 가능한 영역 제한
                                            계정 LOCKING(잠금) - 로그인 불가
                                            롤(ROLE==권한그룹) USER에게 할당
                                            권한(PRIVILEGE) USER 할당
                                            시스템 자원 제한
                                            테이블 스페이스를 USER에게 미리 배정
                                            등등
        - DATABASE SCHEMA(스키마)
            - SCOTT 계정을 생성하면 자동으로 SCOTT이란 스키마 생성
            - 스키마 == 그 사용자가 접근할 수 있는 모든 객체(Object) 모음
            예) 이진우 신입사원 -> {책상, 노트북, 의자, 필기도구 등등)
                                        스키마.객체명
                                        이진우.책상
                                        이진우.노트북
        ㄷ) 계정 생성 선언 형식
        CREATE USER 사용자명
        IDENTIFIED BY 비밀번호 또는 IDENTIFIED EXTERNALLY
        [DEFAULT TABLESPACE 테이블스페이스명]
        [TEMPORARY TABLESPACE 테이블스페이스명]
        [PROFILE 프로파일명]
        [QUOTA 할당량 ON 테이블스페이스명 또는 UNLIMITED ON 테이블스페이스명]
        [PASSWORD EXPIRE]
        [ACCOUNT LOCK 또는 UNLOCK];

        예) DDL
        CREATE USER scott -- 대소문자 구분 X
        IDENTIFIED BY tiger -- 대소문자 구분 O
        -- DEFAULT TABLESPACE   USERS
        -- TEMPORARY TABLESPAC  TEMP
        -- PROFILE              사용자에게 부여할 profile
        -- QUOTA                USERS 할당량 지정
        -- PASSWORD EXPIRE      계정 사용 만기 시점
        -- ACCOUNT LOCK 또는 UNLOCK
        
-- 모든 사용자 계정 정보 조회(확인)
SELECT *
FROM all_users;

        ㄹ) scott 계정으로 로그인
        ERROR:
        ORA-01045: user SCOTT lacks CREATE SESSION privilege; logon denied
                   "CREATE SESSION" 권한이 없어서 로그인 실패했다
        로그인 할 수 있는 권한 부여 - CREATE SESSION 권한 부여
        ㅁ) 권한 부여
        (1) 권한이란?
        권한이란 SQL 문을 실행하거나,
        데이터베이스나 데이터베이스의 객체에 접근할 수 있는 권한을 의미한다
        (2) 권한 부여
        - DBA - 직접 부여 -> 사용자(scott)
        - 롤(혁할 Role) 생성 - 간접 부여 -> 사용자(scott)
          A 권한
          B 권한
          C 권한
          등등
        - CRUD 작업도 권한 O
        - 권한의 2가지 종류
            ㄱ. 시스템(System) 권한 : DB 객체 생성, 수정, 삭제 권한
                예) CREATE SESSION 권한(DB 연결)
            【형식】 
            GRANT 시스템권한명 또는 롤명 TO 사용자명 또는 롤명 또는 PUBLIC
                [WITH ADMIN OPTION];
                
            예) 권한 부여
            GRANT CREATE SESSION TO scott; -- xx 재권한 부여
            롤 부여
            GRANT CONNECT, RESOURCE TO scott;
            -- Grant을(를) 성공했습니다.
            
            예) 권한 회수
            REVOKE CREATE SESSION FROM scott;

            ㄴ. 객체(Object) 권한 : 객체 조작(추가, 수정, 삭제, 검색) 권한
            ㄷ. 권한, 롤 조회
            SELECT *
            FROM dba_sys_privs;
            ㄹ. 롤(ROLE:역할)
            이진우
            신입사원        ->      영업부         ->      생산부
            신입롤 부여           신입롤 회수            영업부롤 회수
                                영업부롤 부여           생산부롤 부여
                                
            20개 권한          신입 20개 권한 회수       영업부 30개 부여
                              영업부 30개 권한 부여     생산부 50개 부여

            신입롤(20개 권한 부여)
            영업부롤(30개 권한 부여)
            생산부롤(50개 권한 부여)
            
1) 비밀번호 수정
ALTER USER scott
IDENTIFIED BY tiger;
2) scott 계정 삭제하고 생성
"user" 검색
CREATE USER 사용자 계정 생성
ALTER USER  사용자 계정 수정
DROP USER   사용자 계정 삭제

DROP USER scott [CASCADE];
-------------------------------------------------------------------------------

[문제]
1. 모든 계정을 조회
SELECT *
FROM all_users;
2. SCOTT 계정이 있으면 삭제
DROP USER scott CASCADE;
3. 모든 계정을 조회(SCOTT 삭제 확인)
SELECT *
FROM all_users;
4. SCOTT 계정을 비밀번호 : 1234로 계정 생성
CREATE USER scott
IDENTIFIED BY 1234;
4-2. CONNECT, RESOURCE 롤을 부여
GRANT CONNECT, RESOURCE TO scott;
5. 모든 계정을 조회(SCOTT 생성 확인)
6. SCOTT 계정의 비밀번호를 tiger로 수정
ALTER USER scott
IDENTIFIED BY tiger;
7. 모든 계정을 조회
-------------------------------------------------------------------------------

1) SCOTT 계정 - 샘플 테이블(table) 생성  CRUD
C:\oraclexe 폴더로 이동 - scott.sql 검색
C:\oraclexe\app\oracle\product\11.2.0\server\rdbms\admin

-- 계정의 잠김 유무를 확인하려면 SYS라는 관리자 계정에서만 확인할 수 있다
-- dba_users 뷰를 통해서
SELECT username, account_status, expiry_date
FROM dba_users;

-- hr 계정의 상태를 locked -> open
-- CREATE USER
-- ALTER USER
-- DROP USER

ALTER USER hr
IDENTIFIED BY lion; -- 비밀번호 수정

ALTER USER hr
ACCOUNT UNLOCK; -- 계정 잠김 수정

-- 비밀번호 수정 + 계정 잠김 수정
ALTER USER hr
IDENTIFIED BY lion
ACCOUNT UNLOCK;

































