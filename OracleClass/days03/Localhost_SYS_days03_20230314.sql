-- SYS --
SELECT *
FROM dba_roles;

SELECT * -- SYS 계정에서만 사용 가능
FROM dba_users;

SELECT * -- username, user_id, created 3개 컬럼 정보만 조회
FROM all_users;

SELECT * -- 해당 계정의 정보
FROM user_users;

SELECT *
FROM dba_tables;

SELECT *
FROM all_tables;

SELECT *
FROM dba_sys_privs;