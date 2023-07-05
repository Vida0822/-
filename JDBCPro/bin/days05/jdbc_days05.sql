CREATE OR REPLACE PROCEDURE up_idcheck
(
    pid IN emp.empno%TYPE
    , pidcheck OUT NUMBER
)
IS
BEGIN
    SELECT COUNT(*) INTO pidcheck
    FROM emp
    WHERE empno = pid;
--EXCEPTION
END;
-- Procedure UP_IDCHECK이(가) 컴파일되었습니다.
--
CREATE OR REPLACE PROCEDURE up_logon
(
    pid IN emp.empno%TYPE
    , ppassword IN emp.ename%TYPE
    , plogoncheck OUT NUMBER -- 0(성공), 1(ID X), -1(PWD X)
)
IS
    vpassword emp.ename%TYPE;
BEGIN
    SELECT COUNT(*) INTO plogoncheck
    FROM emp
    WHERE empno = pid;
    
    IF plogoncheck = 1 THEN -- ID 존재
        SELECT ename INTO vpassword
        FROM emp
        WHERE empno = pid;
        IF vpassword = ppassword THEN -- pwd 일치
            plogoncheck := 0;
        ELSE -- pwd 불일치
            plogoncheck := -1;
        END IF;
    ELSE -- ID 존재 X
        plogoncheck := 1; 
    END IF;
--EXCEPTION
END;
-- Procedure UP_LOGON이(가) 컴파일되었습니다.
--
-- SCOTT이 소유하고있는 모든 테이블명을 조회
SELECT table_name
FROM tabs
ORDER BY table_name ASC;

DESC BONUS;







