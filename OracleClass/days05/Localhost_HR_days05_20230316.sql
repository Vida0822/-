-- HR --
-- ANY ������
SELECT *
FROM employees -- 107��
WHERE salary = ANY(
                        SELECT salary
                        FROM employees
                        WHERE department_id = 30
                    );
30�� �μ������� salary
11000, 3100, 2900, 2800, 2600, 2500

-- ALL ������
SELECT *
FROM employees
WHERE salary >= ALL(1400, 3000);
WHERE salary >= 3000;
-------------------------------------------------------------------------------
SELECT *
FROM emp;
-- ORA-00942: table or view does not exist
-- emp ���̺��� �����ִ� scott�̴�
-- ������(scott)���� emp ���̺��� ����� �� �ִ� ���(����)�� �ο� ������ ����� �� �ִ�
SELECT *
FROM scott.emp;
FROM ��Ű��.���̺��
--
SELECT *
FROM arirang;














