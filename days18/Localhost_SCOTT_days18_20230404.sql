-- SCOTT --
-------------------------------------------------------------------------------
CREATE OR REPLACE TRIGGER ut_Ʈ���Ÿ�
AFTER
INSERT OR UPDATE OR DELETE ON ������̺��
--FOR EACH ROW ��Ʈ����
--DECLARE
BEGIN
    IF INSERTING THEN
    ELSIF UPDATING THEN
    ELSIF DELETING THEN
    END IF;
--EXCEPTION
END;

-- PL/SQL�� ���� ó�����
1. �̸� ���ǵ� ����ó�����

�׸�                 ���� �ڵ�   ���� 
1) NO_DATA_FOUND    ORA-01403  SQL���� ���� �˻������� �����ϴ� ����� ���� ���� ������ ��� 
2) NOT_LOGGED_ON    ORA-01012  �����ͺ��̽��� ������� ���� ���¿��� SQL�� �����Ϸ��� ��� 
3) TOO_MANY_ROWS    ORA-01422  SQL���� �������� ���� ���� ���� ��ȯ�ϴ� ���, ��Į�� ������ �����Ϸ��� �� �� �߻� 
4) VALUE_ERROR      ORA-06502  PL/SQL �� ���� ���ǵ� ������ ���̺��� ū ���� �����ϴ� ��� 
5) ZERO_DEVIDE      ORA-01476  SQL���� ���࿡�� �÷��� ���� 0���� ������ ��쿡 �߻� 
6) INVALID_CURSOR   ORA-01001  �߸� ����� Ŀ���� ���� ������ �߻��ϴ� ��� 
7) DUP_VAL_ON_INDEX ORA-00001  �̹� �ԷµǾ� �ִ� �÷� ���� �ٽ� �Է��Ϸ��� ��쿡 �߻� 

��)
CREATE OR REPLACE PROCEDURE up_emplist
(
    psal emp.sal%TYPE
)
IS
    vename emp.ename%TYPE;
    vsal emp.sal%TYPE;
BEGIN
    SELECT ename, sal INTO vename, vsal
    FROM emp
    WHERE sal = psal;
    
    DBMS_OUTPUT.PUT_LINE( vename || ' : ' || vsal );
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RAISE_APPLICATION_ERROR( -20002, '> QUERY DATA NOT FOUND.' );
    WHEN TOO_MANY_ROWS THEN
        RAISE_APPLICATION_ERROR( -20003, '> QUERY TOO MANY ROWS FOUND.' );
    WHEN OTHERS THEN
        RAISE_APPLICATION_ERROR( -20004, '> QUERY OTHERS EXCEPTION FOUND.' );
END;
-- Procedure UP_EMPLIST��(��) �����ϵǾ����ϴ�.
    ��. EXEC[UTE]
    EXEC up_emplist(800);
    EXEC up_emplist(10000); -- ORA-01403: no data found ������ ����
    EXEC up_emplist(1250); -- ORA-01422: exact fetch returns more than requested number of rows ��û ���ڵ� ������
    ��. �͸� ���ν���
    ��. �� �ٸ� ���� ���ν���

2. �̸� ���ǵ��� ���� ����ó�����

SELECT *
FROM dept;
-- ORA-00001: unique constraint (SCOTT.PK_DEPT) violated ����ũ �������� ���� => 1. �̸� ó���� ����ó����� ���
INSERT INTO dept VALUES( 40, 'QC', 'SEOUL' );
-- ORA-02291: integrity constraint (SCOTT.FK_DEPTNO) violated - parent key not found => �ܷ�Ű(FK) �������� ����
INSERT INTO emp( empno, ename, deptno ) VALUES( 9999, 'kenik', 90 );
��)
CREATE OR REPLACE PROCEDURE up_insemp
(
    pempno emp.empno%TYPE
    , pename emp.ename%TYPE
    , pdeptno emp.deptno%TYPE
)
IS
    -- ORA-02291 FK ����
    v_invalid_deptno EXCEPTION;
    PRAGMA EXCEPTION_INIT( v_invalid_deptno, -02291 );
BEGIN
    INSERT INTO emp( empno, ename, deptno )
             VALUES( pempno, pename, pdeptno );
    COMMIT;
EXCEPTION
    WHEN v_invalid_deptno THEN
        RAISE_APPLICATION_ERROR( -20999, '> QUERY DEPTNO FK NOT FOUND.' );
    WHEN OTHERS THEN
        RAISE_APPLICATION_ERROR( -20004, '> QUERY OTHERS EXCEPTION FOUND.' );
END;
-- Procedure UP_INSEMP��(��) �����ϵǾ����ϴ�.
EXEC up_insemp( 9999, 'kenik', 90 );

3. ����ڰ� ������ ����ó����� ***

��) psal �Է� A ~ B �����
    ���� �� ������ ������� 0�̶�� ���� �߻�
CREATE OR REPLACE PROCEDURE up_exception
(
    psal emp.sal%TYPE
)
IS
    vempcount NUMBER; -- �޿� ������ �ִ� ������� ������ ���� ����
    v_no_emp_exception EXCEPTION;
BEGIN
    SELECT COUNT(*) INTO vempcount
    FROM emp
    WHERE sal BETWEEN psal - 100 AND psal + 100;
    
    IF vempcount = 0 THEN
        -- ���� ���� �߻�
        -- RAISE�� ���
        RAISE v_no_emp_exception;
    ELSE
        DBMS_OUTPUT.PUT_LINE( '> ó�� ��� : ' || vempcount );
    END IF;
EXCEPTION
    WHEN v_no_emp_exception THEN
        RAISE_APPLICATION_ERROR( -20011, '> QUERY EMP COUNT = 0' );
    WHEN OTHERS THEN
        RAISE_APPLICATION_ERROR( -20004, '> QUERY OTHERS EXCEPTION FOUND.' );
END;
-- Procedure UP_EXCEPTION��(��) �����ϵǾ����ϴ�.
EXEC up_exception(900);
EXEC up_exception(6000);
EXEC up_exception(1250);

4. ���� trapping �Լ�
SQLCODE : �����ڵ带 ��ȯ�ϴ� �Լ�
SQLERRM : �����޽����� ��ȯ�ϴ� �Լ�














