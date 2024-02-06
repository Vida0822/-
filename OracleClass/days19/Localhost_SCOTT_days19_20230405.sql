-- SCOTT --
-------------------------------------------------------------------------------
3. 동적쿼리 예제
    1) 익명 프로시저
    DECLARE
        vdsql VARCHAR2(2000); -- 동적쿼리를 저장할 변수
        vdeptno emp.deptno%TYPE;
        vempno emp.empno%TYPE;
        vename emp.ename%TYPE;
        vjob emp.job%TYPE;
    BEGIN
        -- 1) 동적쿼리 작성
        vdsql := 'SELECT deptno, empno, ename, job ';
        vdsql := vdsql || 'FROM emp ';
        vdsql := vdsql || 'WHERE empno = 7369 ';
        -- 2) 동적쿼리 실행
        EXECUTE IMMEDIATE vdsql
            INTO vdeptno, vempno, vename, vjob;
        -- 3) 출력
        DBMS_OUTPUT.PUT_LINE( vdeptno || ', ' || vempno || ', ' || vename || ', ' || vjob );
    --EXCEPTION
    END;
    
    2) 저장 프로시저
    CREATE OR REPLACE PROCEDURE up_ndsemp
    (
        pempno emp.empno%TYPE
    )
    IS
        vdsql VARCHAR2(2000); -- 동적쿼리를 저장할 변수
        vdeptno emp.deptno%TYPE;
        vempno emp.empno%TYPE;
        vename emp.ename%TYPE;
        vjob emp.job%TYPE;
    BEGIN
        -- 1) 동적쿼리 작성
        vdsql := 'SELECT deptno, empno, ename, job ';
        vdsql := vdsql || 'FROM emp ';
        vdsql := vdsql || 'WHERE empno = :pempno ';
        -- 2) 동적쿼리 실행
        EXECUTE IMMEDIATE vdsql
            INTO vdeptno, vempno, vename, vjob
            USING pempno;
        -- 3) 출력
        DBMS_OUTPUT.PUT_LINE( vdeptno || ', ' || vempno || ', ' || vename || ', ' || vjob );
    --EXCEPTION
    END;
    -- Procedure UP_NDSEMP이(가) 컴파일되었습니다.
    EXEC up_ndsemp( 7499 );
    
    3) 저장 프로시저 - dept 테이블에 새로운 부서를 저장하는 동적쿼리 사용
    SELECT *
    FROM dept;
    -- deptno
    SELECT MAX( deptno ) + 10
    FROM dept;
    -- SEQUENCE
    SELECT *
    FROM user_sequences;
    -- SEQ_DEPT
	CREATE SEQUENCE 시퀀스명
	[ INCREMENT BY 정수]
	[ START WITH 정수]
	[ MAXVALUE n ? NOMAXVALUE]
	[ MINVALUE n ? NOMINVALUE]
	[ CYCLE ? NOCYCLE]
	[ CACHE n ? NOCACHE];    
    
    CREATE SEQUENCE seq_dept
    INCREMENT BY 10
    START WITH 50
    MAXVALUE 90
    NOCYCLE
    NOCACHE;
    
    seq_dept.NEXTVAL
    seq_dept.CURRVAL

    CREATE OR REPLACE PROCEDURE up_ndsinsdept
    (
        pdname dept.dname%TYPE := NULL,
        ploc dept.loc%TYPE DEFAULT NULL
    )
    IS
        vdsql VARCHAR2(2000); -- 동적쿼리를 저장할 변수
    BEGIN
        -- 1) 동적쿼리 작성
        vdsql := 'INSERT INTO dept( deptno, dname, loc ) ';
        vdsql := vdsql || 'VALUES( seq_dept.NEXTVAL, :pdname, :ploc ) ';
        -- 2) 동적쿼리 실행
        EXECUTE IMMEDIATE vdsql
            USING pdname, ploc;
        -- 3) 출력
        DBMS_OUTPUT.PUT_LINE( 'INSERT 성공' );
        COMMIT;
    --EXCEPTION
    END;
    -- Procedure UP_NDSEMP이(가) 컴파일되었습니다.
    EXEC up_ndsinsdept( 'QC', 'SEOUL' );

    4) 사용자가 원하는 형태의 게시판을 여러개 생성 ( 테이블 생성 DDL문 ) 동적쿼리
    DECLARE
        vdsql VARCHAR2(1000);
        vtablename VARCHAR2(20);
    BEGIN
        vtablename := 'tbl_nds_board';
        vdsql := 'CREATE TABLE ' || vtablename;
        -- vdsql := ' CREATE TABLE :vtablename ';
        vdsql := vdsql || '( ';
        vdsql := vdsql || '     id number primary key ';
        vdsql := vdsql || '     , name varchar2(20) ';
        vdsql := vdsql || ') ';
        
        DBMS_OUTPUT.PUT_LINE( vdsql ); -- 쿼리 확인( 디버깅 )
        
        EXECUTE IMMEDIATE vdsql;
        -- USING vtablename;
    --EXCEPTION
    END;
    
    DESC tbl_nds_board;
    
    5) OPEN FOR문
        OPEN 커서 + SELECT 여러개의 행
        FOR 반복문
    동적 SQL을 실행 -> 결과물( 여러 개의 행 ) + 커서 처리
    
    CREATE OR REPLACE PROCEDURE up_ndsselemp
    (
        pdeptno dept.deptno%TYPE
    )
    IS
        vdsql VARCHAR2(2000); -- 동적쿼리를 저장할 변수
        vcur SYS_REFCURSOR; -- 9i => REF CURSOR
        vrow emp%ROWTYPE;
    BEGIN
        -- 1) 동적쿼리 작성
        vdsql := 'SELECT * ';
        vdsql := vdsql || 'FROM emp ';
        vdsql := vdsql || 'WHERE deptno = :pdeptno ';
        -- 2) 동적쿼리 실행
        -- EXECUTE IMMEDIATE vdsql X
        OPEN vcur FOR vdsql USING pdeptno;
        
        LOOP
            FETCH vcur INTO vrow;
            EXIT WHEN vcur%NOTFOUND;
            DBMS_OUTPUT.PUT_LINE( vrow.empno || ' ' || vrow.ename );
        END LOOP;
        CLOSE vcur;
    --EXCEPTION
    END;
    
    EXEC UP_NDSSELEMP( 30 );
    
    6) 동적쿼리 검색 예제
 CREATE OR REPLACE PROCEDURE up_nds03
(
   psearchCondition NUMBER  -- 검색조건 1)부서번호 2) 사원명 3) 잡
   , psearchWord VARCHAR2    -- 검색어
)
IS
   vsql varchar2(1000);
   vrow emp%ROWTYPE;
   vcur SYS_REFCURSOR;  -- 9i  REF CURSOR
BEGIN
   vsql := 'SELECT * ';
   vsql :=  vsql || ' FROM emp ';
   
   IF psearchCondition = 1 THEN
     vsql :=  vsql || ' WHERE deptno = :psearchWord ';  
   ELSIF psearchCondition = 2 THEN
     vsql :=  vsql || ' WHERE REGEXP_LIKE(ename, :psearchWord )  ';  
   ELSIF psearchCondition = 3 THEN
     vsql :=  vsql || ' WHERE REGEXP_LIKE(job, :psearchWord , ''i'' )  ';  
   END IF;
   
--    vsql :=  vsql || ' AND 조건식  ';  
--    vsql :=  vsql || ' AND 조건식  ';  
--    vsql :=  vsql || ' AND 조건식  ';  
--    vsql :=  vsql || ' AND 조건식  ';  
--    vsql :=  vsql || ' AND 조건식  ';  
    
   
   
   OPEN vcur FOR vsql  USING psearchWord;
   LOOP
         FETCH vcur INTO vrow;
         EXIT WHEN vcur%NOTFOUND;
         DBMS_OUTPUT.PUT_LINE( vrow.empno || ', ' || vrow.ename || ', ' || vrow.job );
  END LOOP;
  
  CLOSE vcur; 
EXCEPTION
  WHEN NO_DATA_FOUND THEN
    raise_application_error(-20002,'Data not found....');
  WHEN OTHERS THEN
    raise_application_error(-20004,'Others Error....');
END;

EXEC UP_NDS03( 1 , '30' );
EXEC UP_NDS03( 2 , 'L');
EXEC UP_NDS03( 3 , 's');





