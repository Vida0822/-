-- SCOTT --
-------------------------------------------------------------------------------
3. �������� ����
    1) �͸� ���ν���
    DECLARE
        vdsql VARCHAR2(2000); -- ���������� ������ ����
        vdeptno emp.deptno%TYPE;
        vempno emp.empno%TYPE;
        vename emp.ename%TYPE;
        vjob emp.job%TYPE;
    BEGIN
        -- 1) �������� �ۼ�
        vdsql := 'SELECT deptno, empno, ename, job ';
        vdsql := vdsql || 'FROM emp ';
        vdsql := vdsql || 'WHERE empno = 7369 ';
        -- 2) �������� ����
        EXECUTE IMMEDIATE vdsql
            INTO vdeptno, vempno, vename, vjob;
        -- 3) ���
        DBMS_OUTPUT.PUT_LINE( vdeptno || ', ' || vempno || ', ' || vename || ', ' || vjob );
    --EXCEPTION
    END;
    
    2) ���� ���ν���
    CREATE OR REPLACE PROCEDURE up_ndsemp
    (
        pempno emp.empno%TYPE
    )
    IS
        vdsql VARCHAR2(2000); -- ���������� ������ ����
        vdeptno emp.deptno%TYPE;
        vempno emp.empno%TYPE;
        vename emp.ename%TYPE;
        vjob emp.job%TYPE;
    BEGIN
        -- 1) �������� �ۼ�
        vdsql := 'SELECT deptno, empno, ename, job ';
        vdsql := vdsql || 'FROM emp ';
        vdsql := vdsql || 'WHERE empno = :pempno ';
        -- 2) �������� ����
        EXECUTE IMMEDIATE vdsql
            INTO vdeptno, vempno, vename, vjob
            USING pempno;
        -- 3) ���
        DBMS_OUTPUT.PUT_LINE( vdeptno || ', ' || vempno || ', ' || vename || ', ' || vjob );
    --EXCEPTION
    END;
    -- Procedure UP_NDSEMP��(��) �����ϵǾ����ϴ�.
    EXEC up_ndsemp( 7499 );
    
    3) ���� ���ν��� - dept ���̺� ���ο� �μ��� �����ϴ� �������� ���
    SELECT *
    FROM dept;
    -- deptno
    SELECT MAX( deptno ) + 10
    FROM dept;
    -- SEQUENCE
    SELECT *
    FROM user_sequences;
    -- SEQ_DEPT
	CREATE SEQUENCE ��������
	[ INCREMENT BY ����]
	[ START WITH ����]
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
        vdsql VARCHAR2(2000); -- ���������� ������ ����
    BEGIN
        -- 1) �������� �ۼ�
        vdsql := 'INSERT INTO dept( deptno, dname, loc ) ';
        vdsql := vdsql || 'VALUES( seq_dept.NEXTVAL, :pdname, :ploc ) ';
        -- 2) �������� ����
        EXECUTE IMMEDIATE vdsql
            USING pdname, ploc;
        -- 3) ���
        DBMS_OUTPUT.PUT_LINE( 'INSERT ����' );
        COMMIT;
    --EXCEPTION
    END;
    -- Procedure UP_NDSEMP��(��) �����ϵǾ����ϴ�.
    EXEC up_ndsinsdept( 'QC', 'SEOUL' );

    4) ����ڰ� ���ϴ� ������ �Խ����� ������ ���� ( ���̺� ���� DDL�� ) ��������
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
        
        DBMS_OUTPUT.PUT_LINE( vdsql ); -- ���� Ȯ��( ����� )
        
        EXECUTE IMMEDIATE vdsql;
        -- USING vtablename;
    --EXCEPTION
    END;
    
    DESC tbl_nds_board;
    
    5) OPEN FOR��
        OPEN Ŀ�� + SELECT �������� ��
        FOR �ݺ���
    ���� SQL�� ���� -> �����( ���� ���� �� ) + Ŀ�� ó��
    
    CREATE OR REPLACE PROCEDURE up_ndsselemp
    (
        pdeptno dept.deptno%TYPE
    )
    IS
        vdsql VARCHAR2(2000); -- ���������� ������ ����
        vcur SYS_REFCURSOR; -- 9i => REF CURSOR
        vrow emp%ROWTYPE;
    BEGIN
        -- 1) �������� �ۼ�
        vdsql := 'SELECT * ';
        vdsql := vdsql || 'FROM emp ';
        vdsql := vdsql || 'WHERE deptno = :pdeptno ';
        -- 2) �������� ����
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
    
    6) �������� �˻� ����
 CREATE OR REPLACE PROCEDURE up_nds03
(
   psearchCondition NUMBER  -- �˻����� 1)�μ���ȣ 2) ����� 3) ��
   , psearchWord VARCHAR2    -- �˻���
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
   
--    vsql :=  vsql || ' AND ���ǽ�  ';  
--    vsql :=  vsql || ' AND ���ǽ�  ';  
--    vsql :=  vsql || ' AND ���ǽ�  ';  
--    vsql :=  vsql || ' AND ���ǽ�  ';  
--    vsql :=  vsql || ' AND ���ǽ�  ';  
    
   
   
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





