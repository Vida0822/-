-- SCOTT --
-------------------------------------------------------------------------------
-- [ Ʈ���� ]
1) Ʈ���� : ��Ƽ� -> �ڵ� ->�ѱ�(�Ѿ�)
2) ��� ���̺� �̸� Ʈ���Ÿ� ����(����)�ϸ�
   � �̺�Ʈ(DML)�� �߻��ϸ� �ڵ����� ������ Ʈ���Ű� �۵��ϵ����� ��ü�� Ʈ���Ŷ�� �Ѵ�
3)  [��� ���̺�]
    A����� 22��
    
    [�԰� ���̺�]
    �԰�¥               �԰����
    2023.4.3    A�����    5��
    
    [�Ǹ� ���̺�]
    2023.4.3    A���嵵    3��
    
    ��� ���̺�
    [�԰� ���̺�] + INSERT(DML) �̺�Ʈ�� �߻��ϸ�
    �ڵ�����
    [��� ���̺�]�� ��� ������ �����ϵ��� �ϴ� Ʈ���� ����
4) �۾� ��(BEFORE)
    ��) ��/��                      �԰� X
        9 ���� 18 ���� �ٹ��ð� X   �԰� X
   �۾� ��(AFTER)
5) Ʈ���� ����ϴ� �����
    (1) BEFORE : �̺�Ʈ(DML)���� ���� Ʈ���Ű� �۵�
    (2) AFTER : �̺�Ʈ(DML)�� �۵��� �� Ʈ���Ű� �۵�
    (3) FOR EACH ROW : �� Ʈ�������� �˸�
    (4) REFERENCING : ���� ���� ���� ���� ����
    (5) :OLD
        :NEW
        empno   deptno
        7369    10(:OLD)
        �̺�Ʈ(UPDATE) 10(:OLD), 20(:NEW)�� �μ� ����
        �̺�Ʈ(INSERT) 30(:NEW)
        �̺�Ʈ(DELETE) 30(:OLD)
6) ���� ���ν����� COMMIT, ROLLBACK ó���� �ؾ� �ȴ�
   Ʈ���Ŵ� �ڵ����� COMMIT, ROLLBACK ó���� �ȴ�
7) ����
CREATE OR REPLACE TRIGGER Ʈ���Ÿ� -- up_, uf_, [ut_] ���λ�
BEFORE �Ǵ� AFTER -- DEFAULT BEFORE
Ʈ�����̺�Ʈ ON ������̺�
[FOR EACH ROW [WHEN TRIGGER ����]]
[DECLARE]
    ��������
BEGIN
EXCEPTION
END;
8) Ʈ���� Ȯ��
SELECT *
FROM user_triggers;
FROM user_constraints;
FROM user_table;

[����] ��������
ȸ���� 1�� �������� ����
1) ������(��ǥ)���̺�
   INSERT   A��, 1������, 3���׸�
2) �������̺�
   UPDATE �������ڼ� 1����
3) �����׸����̺�
   3���׸��� ��ǥ�ڼ��� 1����

��) Ʈ����� ó��
    ���� ��ü
    A 100���� ����  B 100���� ����
    -100U          +100U
9) Ʈ���� ����, ����, Ȱ��ȭ/��Ȱ��ȭ
10) �ǽ�
CREATE TABLE ��ǰ (
   ��ǰ�ڵ�        VARCHAR2(6) NOT NULL PRIMARY KEY
  ,��ǰ��           VARCHAR2(30)  NOT NULL
  ,������        VARCHAR2(30)  NOT NULL
  ,�Һ��ڰ���  NUMBER
  ,������     NUMBER DEFAULT 0
);

-- �԰� ���̺� �ۼ�
CREATE TABLE �԰� (
   �԰��ȣ      NUMBER PRIMARY KEY
  ,��ǰ�ڵ�      VARCHAR2(6) NOT NULL CONSTRAINT FK_ibgo_no
                 REFERENCES ��ǰ(��ǰ�ڵ�)
  ,�԰�����     DATE
  ,�԰����      NUMBER
  ,�԰�ܰ�      NUMBER
);

-- �Ǹ� ���̺� �ۼ�
CREATE TABLE �Ǹ� (
   �ǸŹ�ȣ      NUMBER  PRIMARY KEY
  ,��ǰ�ڵ�      VARCHAR2(6) NOT NULL CONSTRAINT FK_pan_no
                 REFERENCES ��ǰ(��ǰ�ڵ�)
  ,�Ǹ�����      DATE
  ,�Ǹż���      NUMBER
  ,�ǸŴܰ�      NUMBER
);
-- ��ǰ ���̺� ������ �Է�
INSERT INTO ��ǰ(��ǰ�ڵ�, ��ǰ��, ������, �Һ��ڰ���) VALUES
        ('AAAAAA', '��ī', '���', 100000);
INSERT INTO ��ǰ(��ǰ�ڵ�, ��ǰ��, ������, �Һ��ڰ���) VALUES
        ('BBBBBB', '��ǻ��', '����', 1500000);
INSERT INTO ��ǰ(��ǰ�ڵ�, ��ǰ��, ������, �Һ��ڰ���) VALUES
        ('CCCCCC', '�����', '���', 600000);
INSERT INTO ��ǰ(��ǰ�ڵ�, ��ǰ��, ������, �Һ��ڰ���) VALUES
        ('DDDDDD', '�ڵ���', '�ٿ�', 500000);
INSERT INTO ��ǰ(��ǰ�ڵ�, ��ǰ��, ������, �Һ��ڰ���) VALUES
         ('EEEEEE', '������', '���', 200000);
COMMIT;
SELECT * FROM ��ǰ;
AAAAAA	��ī	    ���	100000	0
BBBBBB	��ǻ��	����	1500000	0
CCCCCC	�����	���	600000	0
DDDDDD	�ڵ���	�ٿ�	500000	0
EEEEEE	������	���	200000	0
-- �԰� ���̺� ������ �Է�
INSERT INTO �԰� (�԰��ȣ, ��ǰ�ڵ�, �԰�����, �԰����, �԰�ܰ�)
              VALUES (1, 'AAAAAA', '2004-10-10', 5,   50000);
INSERT INTO �԰� (�԰��ȣ, ��ǰ�ڵ�, �԰�����, �԰����, �԰�ܰ�)
              VALUES (2, 'BBBBBB', '2004-10-10', 15, 700000);
INSERT INTO �԰� (�԰��ȣ, ��ǰ�ڵ�, �԰�����, �԰����, �԰�ܰ�)
              VALUES (3, 'AAAAAA', '2004-10-11', 15, 52000);
INSERT INTO �԰� (�԰��ȣ, ��ǰ�ڵ�, �԰�����, �԰����, �԰�ܰ�)
              VALUES (4, 'CCCCCC', '2004-10-14', 15,  250000);
INSERT INTO �԰� (�԰��ȣ, ��ǰ�ڵ�, �԰�����, �԰����, �԰�ܰ�)
              VALUES (5, 'BBBBBB', '2004-10-16', 25, 700000);
COMMIT;
ROLLBACK;
SELECT * FROM ��ǰ;
SELECT * FROM �԰�;
-- [ ù��° Ʈ���� ���� + ��� ]
��. ��� ���̺� : [�԰�] ��ǰ �԰�
��. �̺�Ʈ(DML) : INSERT
��. Ʈ���� �۵� : AFTER
-- ORA-04082: NEW or OLD references not allowed in table level triggers
CREATE OR REPLACE TRIGGER ut_insIpgo
AFTER
INSERT ON �԰�
FOR EACH ROW -- �� ���� Ʈ���� ����
--DECLARE
BEGIN
    UPDATE ��ǰ
    SET ������ = ������ + :NEW.�԰����
    WHERE ��ǰ�ڵ� = :NEW.��ǰ�ڵ�;
--EXCEPTION
END;
-- [ �ι�° Ʈ���� ���� + ��� ]
-- �԰�� ������ ������ �Ǹ� ��ǰ ���̺��� �������� ������Ű�� Ʈ���� �ۼ�
SELECT *
FROM ��ǰ;
FROM �԰�;
�԰��ȣ�� 5�� ��ǰ��	BBBBBB	04/10/16	�԰������ 25 -> 30���� �����Ǹ�	700000
BBBBBB	��ǻ��	����	1500000	�������� 40 -> 45 ������Ű�� Ʈ���� �ۼ�

��. ��� ���̺� : �԰�
��. �̺�Ʈ : UPDATE
��. AFTER Ʈ���� ����
��. FOR EACH ROW �� ���� Ʈ���� ( :OLD.�԰����(25)     :NEW.�԰����(30) )
CREATE OR REPLACE TRIGGER ut_updIpgo
AFTER
UPDATE ON �԰�
FOR EACH ROW
--DECLARE
BEGIN
    UPDATE ��ǰ
    SET ������ = ������ - :OLD.�԰���� + :NEW.�԰����
    WHERE ��ǰ�ڵ� = :NEW.��ǰ�ڵ�;
--EXCEPTION
END;
-- UPDATE �׽�Ʈ
UPDATE �԰� SET �԰���� = 30 WHERE �԰��ȣ = 5;
COMMIT;
SELECT * FROM ��ǰ;
SELECT * FROM �԰�;
-- 5   BBBBBB   04/10/16   25   700000
-- [ ����° Ʈ���� ���� + ���� ]
-- �԰� ����(���) ���� �� ��ǰ ���̺��� ��� ������ UPDATE�ϴ� Ʈ���� �ۼ�
CREATE OR REPLACE TRIGGER ut_delIpgo
AFTER
DELETE ON �԰�
FOR EACH ROW
--DECLARE
BEGIN
    UPDATE ��ǰ
    SET ������ = ������ - :OLD.�԰����
    WHERE ��ǰ�ڵ� = :OLD.��ǰ�ڵ�; -- :NEW.��ǰ�ڵ嵵 ����
--EXCEPTION
END;
--
DELETE FROM �԰� WHERE �԰��ȣ = 5;
5	BBBBBB	04/10/16	30	700000
COMMIT;
SELECT * FROM ��ǰ;
SELECT * FROM �԰�;
-- [ �׹�° Ʈ���� ���� + ���� ] BEFORE Ʈ���� ����
SELECT * FROM ��ǰ;
SELECT * FROM �Ǹ�;
-- AAAAAA 100�� �Ǹ� �Ұ� (��������)
CREATE OR REPLACE TRIGGER ut_insPan
BEFORE
INSERT ON �Ǹ�
FOR EACH ROW
DECLARE
    vqty NUMBER; -- ���� ��ǰ�� ������
BEGIN
    -- �Ǹ��ϰ��� �ϴ� ������ �ִ��� ���� üũ
    SELECT ������ INTO vqty
    FROM ��ǰ
    WHERE ��ǰ�ڵ� = :NEW.��ǰ�ڵ�;
    
    IF vqty >= :NEW.�Ǹż��� THEN -- �Ǹ� ����
        UPDATE ��ǰ
        SET ������ = ������ - :NEW.�Ǹż���
        WHERE ��ǰ�ڵ� = :NEW.��ǰ�ڵ�;
    ELSE -- �Ǹ� �Ұ�
        -- ���� �߻� ��Ű��
        RAISE_APPLICATION_ERROR(-20007, '������ �������� �Ǹ� �Ұ���'); -- -20000 ���ϰ�
    END IF;
--EXCEPTION
END;
-- �Ǹ� ���̺� ������ �Է�
INSERT INTO �Ǹ� (�ǸŹ�ȣ, ��ǰ�ڵ�, �Ǹ�����, �Ǹż���, �ǸŴܰ�) VALUES
               (1, 'AAAAAA', '2004-11-10', 100, 1000000);
INSERT INTO �Ǹ� (�ǸŹ�ȣ, ��ǰ�ڵ�, �Ǹ�����, �Ǹż���, �ǸŴܰ�) VALUES
               (1, 'AAAAAA', '2004-11-10', 7, 1000000);               
COMMIT;
SELECT * FROM ��ǰ;
SELECT * FROM �Ǹ�;
-- [ �ټ���° Ʈ���� ���� + ���� ]
--            ������  20 - 7 = 13
-- �Ǹ����̺� �Ǹż����� 7�� -> ??�� ����
CREATE OR REPLACE TRIGGER ut_updPan
BEFORE
UPDATE ON �Ǹ�
FOR EACH ROW
DECLARE
    vqty NUMBER; -- ���� ��ǰ�� ������
BEGIN
    -- �Ǹ��ϰ��� �ϴ� ������ �ִ��� ���� üũ
    SELECT ������ INTO vqty
    FROM ��ǰ
    WHERE ��ǰ�ڵ� = :NEW.��ǰ�ڵ�;
    
    IF vqty + :OLD.�Ǹż��� >= :NEW.�Ǹż��� THEN -- �Ǹ� ����
        UPDATE ��ǰ
        SET ������ = ������ + :OLD.�Ǹż��� - :NEW.�Ǹż���
        WHERE ��ǰ�ڵ� = :NEW.��ǰ�ڵ�;
    ELSE -- �Ǹ� �Ұ�
        -- ���� �߻� ��Ű��
        RAISE_APPLICATION_ERROR(-20008, '������ �������� �Ǹ� ���� �Ұ���'); -- -20000 ���ϰ�
    END IF;
--EXCEPTION
END;
--
UPDATE �Ǹ� SET �Ǹż��� = 200 WHERE �ǸŹ�ȣ = 1; -- �Ǹ� ���� �Ұ���
UPDATE �Ǹ� SET �Ǹż��� = 10 WHERE �ǸŹ�ȣ = 1;
COMMIT;
SELECT * FROM ��ǰ;
SELECT * FROM �Ǹ�;
-- [ ������° Ʈ���� ���� + ���� ]
-- �Ǹ����̺� 1�� ���(����)
CREATE OR REPLACE TRIGGER ut_delPan
AFTER
DELETE ON �Ǹ�
FOR EACH ROW
DECLARE
    vqty NUMBER; -- ���� ��ǰ�� ������
BEGIN
        UPDATE ��ǰ
        SET ������ = ������ + :OLD.�Ǹż���
        WHERE ��ǰ�ڵ� = :OLD.��ǰ�ڵ�;
--EXCEPTION
END;
--
DELETE FROM �Ǹ�
WHERE �ǸŹ�ȣ = 1;
COMMIT;
ROLLBACK;
SELECT * FROM ��ǰ;
SELECT * FROM �Ǹ�;

















