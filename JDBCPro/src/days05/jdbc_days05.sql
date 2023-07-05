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
-- Procedure UP_IDCHECK��(��) �����ϵǾ����ϴ�.
--
CREATE OR REPLACE PROCEDURE up_logon
(
    pid IN emp.empno%TYPE
    , ppassword IN emp.ename%TYPE
    , plogoncheck OUT NUMBER -- 0(����), 1(ID X), -1(PWD X)
)
IS
    vpassword emp.ename%TYPE;
BEGIN
    SELECT COUNT(*) INTO plogoncheck
    FROM emp
    WHERE empno = pid;
    
    IF plogoncheck = 1 THEN -- ID ����
        SELECT ename INTO vpassword
        FROM emp
        WHERE empno = pid;
        IF vpassword = ppassword THEN -- pwd ��ġ
            plogoncheck := 0;
        ELSE -- pwd ����ġ
            plogoncheck := -1;
        END IF;
    ELSE -- ID ���� X
        plogoncheck := 1; 
    END IF;
--EXCEPTION
END;
-- Procedure UP_LOGON��(��) �����ϵǾ����ϴ�.
--
-- SCOTT�� �����ϰ��ִ� ��� ���̺���� ��ȸ
SELECT table_name
FROM tabs
ORDER BY table_name ASC;

DESC BONUS;







