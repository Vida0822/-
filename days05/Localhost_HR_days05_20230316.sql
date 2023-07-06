-- HR --
-- ANY 연산자
SELECT *
FROM employees -- 107명
WHERE salary = ANY(
                        SELECT salary
                        FROM employees
                        WHERE department_id = 30
                    );
30번 부서원들의 salary
11000, 3100, 2900, 2800, 2600, 2500

-- ALL 연산자
SELECT *
FROM employees
WHERE salary >= ALL(1400, 3000);
WHERE salary >= 3000;
-------------------------------------------------------------------------------
SELECT *
FROM emp;
-- ORA-00942: table or view does not exist
-- emp 테이블의 소유주는 scott이다
-- 소유주(scott)에게 emp 테이블을 사용할 수 있는 허락(권한)을 부여 받으면 사용할 수 있다
SELECT *
FROM scott.emp;
FROM 스키마.테이블명
--
SELECT *
FROM arirang;














