-- HR --
-- Ctrl + F7 : Ű���� �빮�ڷ� ��ȯ

SELECT *
FROM user_users;

SELECT *
FROM user_tables;

DESC employees;

-- �ڹ� "�浿" + "ȫ" ���ڿ� ���Ῥ����, concat()
-- ORA-01722: invalid number ���ڿ� ���� X, ���� ���ڸ�
-- Ora_Help���� ����Ŭ ������ / �˻�
-- CONCAT(���ڿ�1, ���ڿ�2) : ���ڿ�1�� ���ڿ�2�� �����ϸ�, �ռ� ������ '||'�� �����մϴ�
-- ORA-00904: " ": invalid identifier(�ĺ���) ���ڿ�
-- ����Ŭ���� ���ڿ� �Ǵ� ���ڴ� ''
-- ����Ŭ������ ��¥�� ����(��)�� ''�� ����Ѵ�
SELECT first_name -- AS "fname" -- �÷����� ��Ī�� ���� <����> "��Ī��"
      , last_name -- lname -- [AS] ��Ī�� / AS, "" ���� ���� / ���� ����� �� "" ���
--    , first_name || " " || last_name
      , first_name || ' ' || last_name AS name
      , CONCAT(CONCAT(first_name, ' '), last_name) name -- NAME_1 index �ο�
FROM employees;

-- ����ڰ� ���� + �㰡 ���� ��� ���̺� ������ ��ȸ
SELECT *
FROM tabs;
FROM user_tables;




















