SELECT *
FROM emp;
--
CREATE OR REPLACE PROCEDURE up_selemp
(
    pempcursor OUT SYS_REFCURSOR
    , pdeptno IN emp.deptno%TYPE
)
IS
BEGIN
    OPEN pempcursor FOR
        SELECT empno, ename, job, hiredate
        FROM emp
        WHERE deptno = pdeptno;
--EXCEPTION
END;
-- Procedure UP_SELEMP이(가) 컴파일되었습니다.