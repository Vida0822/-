-- SYS --
SELECT *
FROM scott.emp;
FROM ��Ű��.���̺��;
-- ORA-00942: table or view does not exist
    - PUBLIC �ó���� ���� ����
    1) SYSTEM �������� �����Ѵ�.
    2) PUBLIC �ɼ��� ����Ͽ� �ó���� �����Ѵ�.
    �����ġ�
	CREATE PUBLIC SYNONYM arirang
  	FOR scott.emp;
    -- SYNONYM ARIRANG��(��) �����Ǿ����ϴ�.
    SELECT *
    FROM arirang;
    3) �ó�� ����
    �����ġ�
	DROP [PUBLIC] SYNONYM synonym��;
    
    DROP PUBLIC SYNONYM arirang;
    -- SYNONYM ARIRANG��(��) �����Ǿ����ϴ�.
    