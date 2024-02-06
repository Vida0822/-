-- SCOTT --
SELECT *
FROM dba_users;
ORA-00942: table or view does not exist
--
SELECT *
FROM all_users;
--
SELECT *
FROM user_users;
--
SELECT *
FROM all_tables;
--
SELECT *
FROM user_tables;
--
SELECT *
FROM user_sys_privs; -- �ý��� ����
--
SELECT *
FROM user_role_privs; -- ��

-- SCOTT ���� : Employee ���̺� ��ȸ -> ���� X
SELECT *
FROM user_tables;

 -- SELECT���� ���Ǵ� Ű����
1. DISTINCT  ����� �÷��� �ߺ��� �� �ߺ��Ǵ� �� �ϳ��� ��� 
2. ALL  ����� �÷��� �ߺ��Ǵ��� �ߺ��Ǵ� �� ��� ���(distinct Ű���带 ������� ������ ����Ʈ�� ALL��) 
3. AS  ��Ī���� �÷��̸��� ǥ���� �� ����ϸ�, ������ �빮�ڷθ� ǥ��� 

-- [����] emp ���̺� job �÷��� ����
--       ������� ���� ������ ��ȸ(�ľ�)
SELECT DISTINCT job -- �ߺ� ����
FROM emp;

SELECT job
FROM emp;
SELECT ALL job
FROM emp;
-- �� ������ ��������� �ߺ��Ǵ� ���� ���Ÿ� �ϰ� �ʹ�
SELECT DISTINCT ename, job, sal -- ��Ұ� �� �ߺ��ž� ���ŵǱ� ������ ��Ұ� �ϳ��� �� �ַ� ���
FROM emp;

-- SQL ���� �ۼ���
 1) SQL ������ ��ҹ��ڸ� �������� �ʴ´�.
 2) SQL ���� ������ �ݵ�� ;�� ���δ�.
 3) ���� ������ �����ؼ� �ڵ�
 4) keyword�� �빮�ڷ� �Է��ϵ��� �����Ѵ�
 5) �ٸ� ��� �ܾ� ��, table �̸�, column �̸��� �ҹ��ڷ� �Է��� �����Ѵ�.

-- ||
 SELECT ename || ' has $' || sal
 FROM emp;
 
-- ��, �����ȣ, �̸�, �Ի�����
SELECT empno, ename, job, hiredate
FROM emp;

-- 1. ����Ŭ���� null �ǹ� : ��Ȯ�ε� ��
    ������ ������ �󸶿���? ���� �����
                         0, ���� X
-- 2. ����Ŭ���� null ó�� : 0 ���ڰ����� ó�� (���)
-- �ڹ� : if(comm==null) comm == 0;
-- ����Ŭ : null ó���ϴ� �Լ�
1) NVL �Լ��� NULL�� 0 �Ǵ� �ٸ� ������ ��ȯ�ϱ� ���� �Լ��̴�.
2) �÷� ���� NULL�̸� ��� ������ �����ϴ��� ��������� NULL�� ��ȯ�Ѵ�.
3) �����ġ�
	NVL(expr1,expr2)
4) null ó���ϴ� �Լ� ����
- NVL : NULL ���� ���ϴ� ������ Ÿ������ �ٲپ� �ִ� �Լ� 
- NVL2 : ���� NULL�� ���� NULL�� �ƴѰ�쿡 ������ �ִ� ���� Ʋ���� ���ִ� �Լ� 
- NULLIF : �� �� ���� ���Ͽ� NULL�� �Ǵ� ���Ǿ��� �� �� �� �� �ϳ��� ������ �ִ� �Լ� 
- COALESCE : �μ��߿��� NULL�� �ƴ� ù ��° �μ��� ��ȯ�� �ִ� �Լ� 
--  EMPNO, ENAME, SAL, COMM, PAY
-- (  sal + comm = pay  )
--    800 + null = null
SELECT EMPNO, ENAME, SAL, COMM
      , NVL(comm, 0) comm2
      , sal + comm pay
      , sal + NVL(comm, 0) pay2
FROM emp;

-- NVL()�� NVL2() �Լ��� ������
-- NVL2(expr1, expr2, expr3)
-- expr1�� null�̸� expr3
-- expr1�� null�� �ƴϸ� expr2
SELECT comm
        , NVL(comm, 0) comm
        , NVL2(comm, comm, 0) comm
FROM emp;

-- [����] emp ���̺��� mgr(���ӻ���� �����ȣ) �÷��� null�� ��� ó�� -> 0 ���
SELECT empno, ename, mgr
      , NVL(mgr, 0) mgr
FROM emp;

-- [����] emp ���̺��� mgr(���ӻ���� �����ȣ) �÷��� null�� ��� ó�� -> 'CEO' ���
-- ORA-01722: invalid number
SELECT empno, ename, mgr
      -- , NVL(mgr, 'CEO') mgr
      -- mgr -> ���ڿ� ��ȯ -> 'CEO'
      -- ���� -> ���ڿ� ��ȯ ���(�Լ�)
      , TO_CHAR(mgr)
      , NVL(TO_CHAR(mgr), 'CEO') mgr
      , NVL2(TO_CHAR(mgr), TO_CHAR(mgr), 'CEO') mgr
FROM emp;
-- ������ ���� : ����, ���� ���� : ����

-- emp ����
DESC emp;
-- MGR  NUMBER(4)  4�ڸ� ����(����)

-- emp ���̺���  �Ʒ��� ���� ��ȸ ����� �������� ������ �ۼ��ϼ���.
SELECT empno, ename, sal
	, NVL(comm, 0) comm
    , NVL(sal + comm, sal) pay
	, sal + NVL(comm, 0) pay
FROM emp;
-------------------------------------------------------------------------------
DDL : CREATE��
CREATE USER
CREATE ROLE
CREATE TABLESPACE
CREATE TABLE insa(
        num NUMBER(5) NOT NULL CONSTRAINT insa_pk PRIMARY KEY -- �ߺ��� ���� �ʴ� ����Ű
       ,name VARCHAR2(20) NOT NULL
       ,ssn  VARCHAR2(14) NOT NULL
       ,ibsaDate DATE     NOT NULL
       ,city  VARCHAR2(10)
       ,tel   VARCHAR2(15)
       ,buseo VARCHAR2(15) NOT NULL
       ,jikwi VARCHAR2(15) NOT NULL
       ,basicPay NUMBER(10) NOT NULL
       ,sudang NUMBER(10) NOT NULL
);

-- DML : INSERT, UPDATE, DELETE     TURNCATE        + COMMIT, ROLLBACK
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1001, 'ȫ�浿', '771212-1022432', '1998-10-11', '����', '011-2356-4528', '��ȹ��', 
   '����', 2610000, 200000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1002, '�̼���', '801007-1544236', '2000-11-29', '���', '010-4758-6532', '�ѹ���', 
   '���', 1320000, 200000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1003, '�̼���', '770922-2312547', '1999-02-25', '��õ', '010-4231-1236', '���ߺ�', 
   '����', 2550000, 160000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1004, '������', '790304-1788896', '2000-10-01', '����', '019-5236-4221', '������', 
   '�븮', 1954200, 170000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1005, '�Ѽ���', '811112-1566789', '2004-08-13', '����', '018-5211-3542', '�ѹ���', 
   '���', 1420000, 160000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1006, '�̱���', '780505-2978541', '2002-02-11', '��õ', '010-3214-5357', '���ߺ�', 
   '����', 2265000, 150000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1007, '����ö', '780506-1625148', '1998-03-16', '����', '011-2345-2525', '���ߺ�', 
   '�븮', 1250000, 150000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1008, '�迵��', '821011-2362514', '2002-04-30', '����', '016-2222-4444', 'ȫ����',    
'���', 950000 , 145000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1009, '������', '810810-1552147', '2003-10-10', '���', '019-1111-2222', '�λ��', 
   '���', 840000 , 220400);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1010, '������', '751010-1122233', '1997-08-08', '�λ�', '011-3214-5555', '������', 
   '����', 2540000, 130000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1011, '������', '801010-2987897', '2000-07-07', '����', '010-8888-4422', '������', 
   '���', 1020000, 140000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1012, '���ѱ�', '760909-1333333', '1999-10-16', '����', '018-2222-4242', 'ȫ����', 
   '���', 880000 , 114000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1013, '���̼�', '790102-2777777', '1998-06-07', '���', '019-6666-4444', 'ȫ����', 
   '�븮', 1601000, 103000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1014, 'Ȳ����', '810707-2574812', '2002-02-15', '��õ', '010-3214-5467', '���ߺ�', 
   '���', 1100000, 130000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1015, '������', '800606-2954687', '1999-07-26', '���', '016-2548-3365', '�ѹ���', 
   '���', 1050000, 104000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1016, '�̻���', '781010-1666678', '2001-11-29', '���', '010-4526-1234', '���ߺ�', 
   '����', 2350000, 150000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1017, '�����', '820507-1452365', '2000-08-28', '��õ', '010-3254-2542', '���ߺ�', 
   '���', 950000 , 210000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1018, '�̼���', '801028-1849534', '2004-08-08', '����', '018-1333-3333', '���ߺ�', 
   '���', 880000 , 123000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1019, '�ڹ���', '780710-1985632', '1999-12-10', '����', '017-4747-4848', '�λ��', 
   '����', 2300000, 165000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1020, '������', '800304-2741258', '2003-10-10', '����', '011-9595-8585', '�����', 
   '���', 880000 , 140000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1021, 'ȫ�泲', '801010-1111111', '2001-09-07', '���', '011-9999-7575', '���ߺ�', 
   '���', 875000 , 120000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1022, '�̿���', '800501-2312456', '2003-02-25', '����', '017-5214-5282', '��ȹ��', 
   '�븮', 1960000, 180000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1023, '���μ�', '731211-1214576', '1995-02-23', '����', NULL           , '������', 
   '����', 2500000, 170000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1024, '�踻��', '830225-2633334', '1999-08-28', '����', '011-5248-7789', '��ȹ��', 
   '�븮', 1900000, 170000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1025, '�����', '801103-1654442', '2000-10-01', '����', '010-4563-2587', '������', 
   '���', 1100000, 160000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1026, '�����', '810907-2015457', '2002-08-28', '���', '010-2112-5225', '������', 
   '���', 1050000, 150000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1027, '�迵��', '801216-1898752', '2000-10-18', '����', '019-8523-1478', '�ѹ���', 
   '����', 2340000, 170000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1028, '�̳���', '810101-1010101', '2001-09-07', '����', '016-1818-4848', '�λ��', 
   '���', 892000 , 110000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1029, '�踻��', '800301-2020202', '2000-09-08', '����', '016-3535-3636', '�ѹ���', 
   '���', 920000 , 124000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1030, '������', '790210-2101010', '1999-10-17', '�λ�', '019-6564-6752', '�ѹ���', 
   '����', 2304000, 124000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1031, '����ȯ', '771115-1687988', '2001-01-21', '����', '019-5552-7511', '��ȹ��', 
   '����', 2450000, 160000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1032, '�ɽ���', '810206-2222222', '2000-05-05', '����', '016-8888-7474', '�����', 
   '���', 880000 , 108000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1033, '��̳�', '780505-2999999', '1998-06-07', '����', '011-2444-4444', '������', 
   '���', 1020000, 104000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1034, '������', '820505-1325468', '2005-09-26', '���', '011-3697-7412', '��ȹ��', 
   '���', 1100000, 160000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1035, '������', '831010-2153252', '2002-05-16', '��õ', NULL           , '���ߺ�', 
   '���', 1050000, 140000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1036, '���翵', '701126-2852147', '2003-08-10', '����', '011-9999-9999', '�����', 
   '���', 960400 , 190000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1037, '�ּ���', '770129-1456987', '1998-10-15', '��õ', '011-7777-7777', 'ȫ����', 
   '����', 2350000, 187000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1038, '���μ�', '791009-2321456', '1999-11-15', '�λ�', '010-6542-7412', '������', 
   '�븮', 2000000, 150000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1039, '�����', '800504-2000032', '2003-12-28', '���', '010-2587-7895', '������', 
   '�븮', 2010000, 160000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1040, '�ڼ���', '790509-1635214', '2000-09-10', '���', '016-4444-7777', '�λ��', 
   '�븮', 2100000, 130000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1041, '�����', '721217-1951357', '2001-12-10', '�泲', '016-4444-5555', '�����', 
   '����', 2300000, 150000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1042, 'ä����', '810709-2000054', '2003-10-17', '���', '011-5125-5511', '���ߺ�', 
   '���', 1020000, 200000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1043, '��̿�', '830504-2471523', '2003-09-24', '����', '016-8548-6547', '������', 
   '���', 1100000, 210000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1044, '����ȯ', '820305-1475286', '2004-01-21', '����', '011-5555-7548', '������', 
   '���', 1060000, 220000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1045, 'ȫ����', '690906-1985214', '2003-03-16', '����', '011-7777-7777', '������', 
   '���', 960000 , 152000);			
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1046, '����', '760105-1458752', '1999-05-04', '�泲', '017-3333-3333', '�ѹ���', 
   '����', 2650000, 150000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1047, '�긶��', '780505-1234567', '2001-07-15', '����', '018-0505-0505', '������', 
   '�븮', 2100000, 112000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1048, '�̱��', '790604-1415141', '2001-06-07', '����', NULL           , '���ߺ�', 
   '�븮', 2050000, 106000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1049, '�̹̼�', '830908-2456548', '2000-04-07', '��õ', '010-6654-8854', '���ߺ�', 
   '���', 1300000, 130000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1050, '�̹���', '810403-2828287', '2003-06-07', '���', '011-8585-5252', 'ȫ����', 
   '�븮', 1950000, 103000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1051, '�ǿ���', '790303-2155554', '2000-06-04', '����', '011-5555-7548', '������', 
   '����', 2260000, 104000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1052, '�ǿ���', '820406-2000456', '2000-10-10', '���', '010-3644-5577', '��ȹ��', 
   '���', 1020000, 105000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1053, '��̽�', '800715-1313131', '1999-12-12', '����', '011-7585-7474', '�����', 
   '���', 960000 , 108000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1054, '����ȣ', '810705-1212141', '1999-10-16', '����', '016-1919-4242', 'ȫ����', 
   '���', 980000 , 114000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1055, '���ѳ�', '820506-2425153', '2004-06-07', '����', '016-2424-4242', '������', 
   '���', 1000000, 104000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1056, '������', '800605-1456987', '2004-08-13', '��õ', '010-7549-8654', '������', 
   '�븮', 1950000, 200000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1057, '�̹̰�', '780406-2003214', '1998-02-11', '���', '016-6542-7546', '�����', 
   '����', 2520000, 160000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1058, '�����', '800709-1321456', '2003-08-08', '��õ', '010-2415-5444', '��ȹ��', 
   '�븮', 1950000, 180000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1059, '�Ӽ���', '810809-2121244', '2001-10-10', '����', '011-4151-4154', '���ߺ�', 
   '���', 890000 , 102000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1060, '��ž�', '810809-2111111', '2001-10-10', '����', '011-4151-4444', '���ߺ�', 
   '���', 900000 , 102000);

COMMIT;
-------------------------------------------------------------------------------
SELECT *
FROM tabs;
--
SELECT *
FROM insa;
-------------------------------------------------------------------------------
-- [SELECT���� ������(WHERE)]
-- [����] emp ���̺��� ��� ��� ���� ��ȸ
-- [����] emp ���̺��� 10�� �μ���(deptno) ���� ��ȸ
SELECT *
FROM emp
WHERE deptno = 10; -- ������ ó�� ����
-- ORA-00936: missing expression
-- �ڹ� ���� ==, �ٸ��� !=
-- ����Ŭ ���� =, �ٸ��� != <> ^=

-- [����] emp ���̺��� 10�� �μ����� ������ ��� ������ ��ȸ(���)
SELECT *
FROM emp
WHERE deptno <> 10;
WHERE deptno != 10;
WHEWE deptno ^= 10;

-- [����] emp ���̺��� 10���Ǵ� 20�� �μ��� ������ ��ȸ
-- �ڹ� if(deptno == 10 || deptno == 20)
-- ����Ŭ where ������
SELECT *
FROM emp
WHERE deptno = 10 OR deptno = 20;
WHERE deptno = 10 || deptno = 20;
-- ORA-00933: SQL command not properly ended
-- SQL ����� ����� ������� �ʾҴ�
-- �ڹ� ��������   &&  ||  !
-- ����Ŭ �������� AND OR NOT

-- [����] KING ��� ������ Ȯ��
SELECT *
FROM emp
WHERE ename = UPPER('king'); -- LOWER()
WHERE ename = 'KING';
WHERE ename = 'king'; -- ��ҹ��� ���� O

-- String name = "king";
-- name.toUpperCase();

-- [����] insa ���̺��� ���� Ȯ��
DESC insa;
CITY              VARCHAR2(10) ������� �÷�

-- [����] insa ���̺��� �����, ������� ��ȸ
SELECT name, city
FROM insa
ORDER BY city; -- ASC
ORDER BY 2; -- �÷��� ���� 2. city
ORDER BY city DESC;
-- ����       (�������� asc ����, �������� desc ����)
-- 3 5 2 4 1   1 2 3 4 5        5 4 3 2 1

-- [����] insa ���̺��� �����, ��������� ����ϰ� ��������� ������ ��� ������ ��ȸ
SELECT name, city
FROM insa
WHERE city = '����';

-- [����] insa ���̺��� ��������� �������� ����� ������ ��ȸ
-- ������ : ����, ��õ, ���
SELECT name, city
FROM insa
-- WHERE [NOT] IN(list)
WHERE city IN('����', '��õ', '���')
-- WHERE city = '����' OR city = '���' OR city = '��õ'
ORDER BY city;

-- [����] insa ���̺��� ��������� �������� �ƴ� ����� ������ ��ȸ
-- ������ : ����, ��õ, ���
SELECT name, city
FROM insa
WHERE city NOT IN('����', '��õ', '���')
-- WHERE NOT(city = '����' OR city = '���' OR city = '��õ')
-- WHERE city != '����' AND city <> '���' AND city ^= '��õ'
ORDER BY city;

-- [����] insa ���̺��� �μ���, �̸�, �޿�(����) ���
-- + ������ : 2000000 <= �޿� <= 2500000
-- 2�� ���� (1�� : �μ� ASC, 2�� : �޿� DESC)
SELECT buseo, name, basicpay + sudang pay
FROM insa
-- ORA-00904: "PAY": invalid identifier
-- WHERE pay >= 2000000 AND pay <= 2500000 -- ó�� ������ ���� pay ���� ���̶� ��� �Ұ�
WHERE basicpay + sudang >= 2000000 AND basicpay + sudang <= 2500000
ORDER BY buseo ASC , pay DESC;

-- ���� �ڵ��� WITH�� ����ؼ� ó��
WITH
    temp AS (
        SELECT buseo, name, basicpay + sudang pay
        FROM insa
    )
SELECT buseo, name, pay
FROM temp
WHERE pay >= 2000000 AND pay <= 2500000
ORDER BY buseo ASC, pay DESC;

-- ���� ������ �ζ��κ�(inline view)�� ����ؼ� ó��
-- FROM���� �ִ� ���������� �ζ��κ��� �Ѵ�
-- SELECT temp.*
SELECT *
FROM (
    SELECT buseo, name, basicpay + sudang pay
    FROM insa
    ) temp -- �����ϸ� ª��
WHERE pay >= 2000000 AND temp.pay <= 2500000
ORDER BY buseo ASC, pay DESC;

-- ���� �ڵ��� SQL ������ between and ����ؼ� ����
SELECT *
FROM (
    SELECT buseo, name, basicpay + sudang pay
    FROM insa
    ) temp -- �����ϸ� ª��
-- WHERE pay >= 2000000 AND temp.pay <= 2500000
-- WHERE pay BETWEEN 2000000 AND 2500000

-- WHERE pay < 2000000 OR pay > 2500000
-- WHERE NOT(pay >= 2000000 AND temp.pay <= 2500000)
WHERE pay NOT BETWEEN 2000000 AND 2500000
ORDER BY buseo ASC, pay DESC;

-- [����] emp ���̺��� comm�� Ȯ�ε��� ���� ����� ������ ��ȸ
--                     comm�� null�� ����� ���� ��ȸ
SELECT *
FROM emp
-- WHERE NOT(comm IS NULL);
-- WHERE comm IS NOT NULL;
WHERE comm IS NULL;
-- WHERE comm = null -- ���� X, �˻���� X

-- [����] emp ���̺��� �Ի�����(hiredate)�� 81�⵵�� ����� ������ ��ȸ
--                     80/12/17 -> 1980/12/17
--                     RR/MM/DD
--                     YY/MM/DD
-- RR �� YY ������
SELECT *
FROM emp
WHERE hiredate BETWEEN '81/01/01' AND '81/12/31';
WHERE hiredate >= '81/01/01' AND hiredate <= '81/12/31';
-- HIREDATE          DATE  ����Ŭ ��¥�� Ÿ��
-- 1) �ڹ� '81/01/11' ��¥ �÷����� �⵵�� ���� �� �ִٸ�
-- ����Ŭ DATE �⵵ ��� �˻�
SELECT ename, hiredate
      , TO_CHAR(hiredate, 'YEAR') a
      , TO_CHAR(hiredate, 'YY') b
      , TO_CHAR(hiredate, 'YYYY') c
      , TO_CHAR(hiredate, 'RR') d
FROM emp
WHERE TO_CHAR(hiredate, 'RR') = '81';

-- 2) �ڹ� '81/01/11' ���� �⵵ ���ڸ� �߶���� �ڵ� substring(0,2)
-- ����Ŭ
SELECT ename, hiredate
    , SUBSTR(hiredate, 0, 2) h_year
    , SUBSTR(hiredate, 1, 2) h_year
    , SUBSTR(hiredate, 4, 2) h_month
    , SUBSTR(hiredate, 7) h_day
    , SUBSTR(hiredate, -2) h_day
FROM emp
WHERE SUBSTR(hiredate, 0, 2) = '81';

-- 3) LIKE
-- 4) REGEXP_LIKE


DESC emp;
DESC insa;

















