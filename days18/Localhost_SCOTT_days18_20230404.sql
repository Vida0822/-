-- SCOTT --
-------------------------------------------------------------------------------
CREATE OR REPLACE TRIGGER ut_트리거명
AFTER
INSERT OR UPDATE OR DELETE ON 대상테이블명
--FOR EACH ROW 행트리거
--DECLARE
BEGIN
    IF INSERTING THEN
    ELSIF UPDATING THEN
    ELSIF DELETING THEN
    END IF;
--EXCEPTION
END;

-- PL/SQL의 에러 처리방법
1. 미리 정의된 에러처리방법

항목                 에러 코드   설명 
1) NO_DATA_FOUND    ORA-01403  SQL문에 의한 검색조건을 만족하는 결과가 전혀 없는 조건의 경우 
2) NOT_LOGGED_ON    ORA-01012  데이터베이스에 연결되지 않은 상태에서 SQL문 실행하려는 경우 
3) TOO_MANY_ROWS    ORA-01422  SQL문의 실행결과가 여러 개의 행을 반환하는 경우, 스칼라 변수에 저장하려고 할 때 발생 
4) VALUE_ERROR      ORA-06502  PL/SQL 블럭 내에 정의된 변수의 길이보다 큰 값을 저장하는 경우 
5) ZERO_DEVIDE      ORA-01476  SQL문의 실행에서 컬럼의 값을 0으로 나누는 경우에 발생 
6) INVALID_CURSOR   ORA-01001  잘못 선언된 커서에 대해 연산이 발생하는 경우 
7) DUP_VAL_ON_INDEX ORA-00001  이미 입력되어 있는 컬럼 값을 다시 입력하려는 경우에 발생 

예)
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
-- Procedure UP_EMPLIST이(가) 컴파일되었습니다.
    ㄱ. EXEC[UTE]
    EXEC up_emplist(800);
    EXEC up_emplist(10000); -- ORA-01403: no data found 데이터 없음
    EXEC up_emplist(1250); -- ORA-01422: exact fetch returns more than requested number of rows 요청 레코드 여러개
    ㄴ. 익명 프로시저
    ㄷ. 또 다른 저장 프로시저

2. 미리 정의되지 않은 에러처리방법

SELECT *
FROM dept;
-- ORA-00001: unique constraint (SCOTT.PK_DEPT) violated 유니크 제약조건 위배 => 1. 미리 처리된 예외처리방법 사용
INSERT INTO dept VALUES( 40, 'QC', 'SEOUL' );
-- ORA-02291: integrity constraint (SCOTT.FK_DEPTNO) violated - parent key not found => 외래키(FK) 제약조건 위배
INSERT INTO emp( empno, ename, deptno ) VALUES( 9999, 'kenik', 90 );
예)
CREATE OR REPLACE PROCEDURE up_insemp
(
    pempno emp.empno%TYPE
    , pename emp.ename%TYPE
    , pdeptno emp.deptno%TYPE
)
IS
    -- ORA-02291 FK 위배
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
-- Procedure UP_INSEMP이(가) 컴파일되었습니다.
EXEC up_insemp( 9999, 'kenik', 90 );

3. 사용자가 정의한 에러처리방법 ***

예) psal 입력 A ~ B 사원수
    만약 그 범위의 사원수가 0이라면 예외 발생
CREATE OR REPLACE PROCEDURE up_exception
(
    psal emp.sal%TYPE
)
IS
    vempcount NUMBER; -- 급여 범위에 있는 사원수를 저장할 변수 선언
    v_no_emp_exception EXCEPTION;
BEGIN
    SELECT COUNT(*) INTO vempcount
    FROM emp
    WHERE sal BETWEEN psal - 100 AND psal + 100;
    
    IF vempcount = 0 THEN
        -- 강제 예외 발생
        -- RAISE문 사용
        RAISE v_no_emp_exception;
    ELSE
        DBMS_OUTPUT.PUT_LINE( '> 처리 결과 : ' || vempcount );
    END IF;
EXCEPTION
    WHEN v_no_emp_exception THEN
        RAISE_APPLICATION_ERROR( -20011, '> QUERY EMP COUNT = 0' );
    WHEN OTHERS THEN
        RAISE_APPLICATION_ERROR( -20004, '> QUERY OTHERS EXCEPTION FOUND.' );
END;
-- Procedure UP_EXCEPTION이(가) 컴파일되었습니다.
EXEC up_exception(900);
EXEC up_exception(6000);
EXEC up_exception(1250);

4. 예외 trapping 함수
SQLCODE : 에러코드를 반환하는 함수
SQLERRM : 에러메시지를 반환하는 함수














