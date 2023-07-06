-- SCOTT --
-------------------------------------------------------------------------------
1) �䱸�м� -> �䱸�м���(�䱸����) �ۼ�
2) ������ DB �𵨸�( ERD )
3) ���� DB �𵨸�
    (1) �θ� ���̺�� �ڽ� ���̺� : ���� ����, ������ ��ü
        ������ �����ͺ��̽�( RDBMS )
        ��) dept ���̺� <�ҼӰ���> emp ���̺� - ���� ����
              �θ�                  �ڽ�
        ��) �� ���̺� <�ֹ�����> ��ǰ ���̺� - ������ ��ü
              �θ�                  �ڽ�
              
    (2) �⺻Ű( Primary Key )�� �ܷ�Ű( Foreign Key )
        ��(dept)      ����      ��(emp)
        deptno(PK) ����Ű       deptno(FK) �ܷ�Ű
        �⺻������ �θ����̺��� PK�� �ڽ����̺��� FK�� ���̵Ǿ�����
        
    (3) �ĺ������ ��ĺ�����
        ��. ��ĺ�����(����) : �θ����̺��� PK�� �ڽ����̺��� �Ϲ� �÷����� ���̵Ǵ� ��
        ��. �ĺ�����(�Ǽ�) : �θ����̺��� PK�� �ڽ����̺��� PK�� ���̵Ǵ� ��
-------------------------------------------------------------------------------
3) ���� DB �𵨸�
    (1) ���� ��Ű�� ����( ���η� )
    (2) ����ȭ(NF) �۾�
    
    ��. Mapping Rule
        - ������ DB �𵨸����� ����� [��ü Ÿ��]�� [���� Ÿ��]�� [���̺� ����]
                                                            "���� ��Ű��"
          ��, ERD�� �̿��� ���� ��Ű���� �����ϱ� ���ؼ� ��Ű�� ��Ģ�� "���η�"�̶�� �Ѵ�
        - [ ���η��� 5���� ��Ģ ]
            1�ܰ�) �ܼ� ��ƼƼ   -> ���̺�
            2�ܰ�) �Ӽ�         -> �÷�
            3�ܰ�) �ĺ���       -> �⺻Ű
            4�ܰ�) ����         -> ���̺� O X
            
            ERD -> ���η� -> ���� ��Ű��
                            ������ ��

4 ���� ����
4.1 ���η�( �����̼� ��Ű�� ��ȯ ��Ģ )
    4.1.1 ��Ģ1 : ��� ��ü�� �����̼�(���̺�)���� ��ȯ�Ѵ�
        [E] -> table
        AAA     column ��ȯ
    4.1.2 ��Ģ2 : �ٴ��(n:m) ����� �����̼�(���̺�)���� ��ȯ�Ѵ�
        �� n    <�ֹ�>    m ��ǰ
                �ֹ����̺� ��ȯ
    4.1.3 ��Ģ3 : �ϴ��(1:n) ����� �ܷ�Ű�� ǥ���Ѵ�
        �μ�(DEPT) 1      n ���(EMP)
        deptno(PK)          deptno(FK)
    4.1.4 ��Ģ4: �ϴ���(1:1) ���踦 �ܷ�Ű�� ǥ���Ѵ�
        ����  <ȥ��>    ����
            ȥ�����̺� ���� : ����FK, ����FK
    4.1.5 ��Ģ5: ���� �� �Ӽ��� �����̼����� ��ȯ�Ѵ�
        ���T
        A   ����  ((��������))
            ���-�������� ���̺� ����
    4.1.6 ��Ÿ ��� ����
-------------------------------------------------------------------------------
eXERD �𵨸� ��(����)�� ����ؼ� ERD -> ���η� -> [ ���� DB �𵨸� ]
���� ��Ű�� �����ϰ� ���� ���� ���� �߻�
== �̻�( Anomaly ) == INSERT(�����̻�), DELECT(�����̻�), UPDATE(�����̻�)
�̻� ���� => ����ȭ �۾�
-- "�Լ��� ���Ӽ�" : �Ӽ��鰣�� ���ü�
��)
    �����ȣ(PK) ����� �ּ� ���� �μ���
    �μ���ȣ(PK) �μ��� ������
      X        Y
    ��ID    ����     ���    
    PK                           
    Y�� X�� ���Ӽ��� �ִ�
      X   ->    Y
    ������     ������
     PK
    
    (1) ���� �Լ��� ����
        �������� �Ӽ��� �𿩼� �ϳ��� �⺻Ű�� �̷� ��( ����Ű )
        ����Ű ��ü�� � �Ӽ��� �������� �� "���� �Լ��� ����"�̶�� �Ѵ�
             ����Ű        ���� �Լ��� ����   �κ� �Լ��� ����      �κ� �Լ��� ����
        [��ID][�̺�ƮID]     ��÷����            ���                ����
         kenik    E001          Y                vip                ȫ�浿
        
    (2) �κ� �Լ��� ����
        ���� �Լ��� ������ �ƴϸ� �κ� �Լ��� �����̴�
        �������� �Ӽ��� �𿩼� �ϳ��� �⺻Ű�� �̷� ��( ����Ű )
        ����Ű ��ü�� � �Ӽ��� ���������� ���� �� "�κ� �Լ��� ����"�̶�� �Ѵ�
        
    (3) ���� �Լ��� ����
        X   ->    Y     ->    Z     �� �� X -> Z ����
        ID      ����
        PK
--------------------------------------------------------------------------------
-- ����ȭ
3 �⺻ �������� ����ȭ ����
3.1 ����ȭ�� ����� ����
3.2 ��1������
    �����̼�(���̺�)�� ���� ��� �Ӽ�(�÷�)�� �������� ���� ��(atomic value)���θ� �����Ǿ� ������ ��1�������� ���Ѵ�
    ��)
    [ �� + �̺�Ʈ ��÷ ���̺� ]
    ��ID / �̺�ƮID / ��÷���� / ���
    apple     E001       Y      gold
    apple     E002       N      gold
    apple     E003       N      gold
    apple     E004       Y      gold
    
    ��ID, ��� �Ӽ����� �ݺ��Ǵ� �Ӽ����� �����ϴ� �۾� -> ��1����ȭ�Ѵ�
    [ �� ���̺� ]
    apple ȫ�浿 gold
    [ ��� ]
    1 gold
    2 vip
    3 vvip
    
3.3 ��2������
    �����̼��� ��1�������� ���ϰ�, �⺻Ű�� �ƴ� ��� �Ӽ��� �⺻Ű�� ���� �Լ� ���ӵǸ� ��2�������� ���Ѵ�.
    �κ� �Լ��� ������ �����ϴ� �۾�
    ����Ű�� ��
    
3.4 ��3������
    �����̼��� ��2�������� ���ϰ�, �⺻Ű�� �ƴ� ��� �Ӽ��� �⺻Ű�� ������ �Լ� ������ ���� ������ ��3�������� ���Ѵ�.
    ���� �Լ��� ���� ����
    ������ ������
     PK
      X  -> Y
    Y�Ӽ��� X�Ӽ��� �������̴�
    ��)
    [ ������̺� ]
    empno(PK), ename, deptno, hiredate, dname
      X  ->  Y      Y  ->  Z
    empno  deptno deptno dname
    
    [ ��� ���̺� ]
    empno(PK), ename, deptno(XXX), hiredate
    [ �μ� ���̺� ]
    deptno(PK), dname
    
3.5 ���̽�/�ڵ� ������
    [ Boyce/Codd Normal Form ] == BCNF
    �����̼��� �Լ� ���� ���迡�� ��� �����ڰ� �ĺ�Ű�̸� ���̽�/�ڵ� �������� ���Ѵ�.
    
    [ ���½�û���̺� ]
    [��ID] + [���ͳݰ���] ��簭���ȣ
     apple      ����ȸȭ      P001
     banana     ��������      P002
     apple      ��������      PXXX
     
     (1)
    ����Ű( ��ID+���ͳݰ��� ) -> ��簭���ȣ
         [   A       B     ]        C
    ��簭���ȣ -> ���ͳݰ���
        C      ->    B
    [ A, C ] ��ID, ��簭���ȣ
    [ C -> B ] ��簭���ȣ(PK) -> ���ͳݰ���
     
    
3.6 ��4�������� ��5������
-------------------------------------------------------------------------------
4) ������ DB �𵨸�
    - ���� DB �𵨸� �ܰ迡�� ����� �����ͺ��̽���Ű��(���轺Ű��, ���̺�Ű��)�� �� ȿ�������� �����ϱ� ���� �۾�
    ��) �����ȣ/�ּ� ���̺� -> ȿ���� -> ȸ�����̺�
    - DBMS(����Ŭ)�� Ư���� �°� ���� �����ͺ��̽� ���� ��ü���� �����ϴ� �ܰ�
    - (�߿�����) : ������ ��뷮 �м�, ���� ���μ����� �м��ؼ� ����, ȿ�� ���
    - ������ȭ, �ε���
-------------------------------------------------------------------------------
[ Ư���� ����� ��ƼƼ �𵨸� ]
1) ����Ÿ�� ��ƼƼ / ����Ÿ�� ��ƼƼ
    (1) ����Ÿ�� : ��ü�� �ϳ��� ���̺�� �����ϴ� ��
        
    (2) ����Ÿ�� : ���������, �����������, (���� Ÿ���� ������ŭ) ���̺��� �����ϴ� ���
2) ����� ����
-------------------------------------------------------------------------------
CREATE TABLE tbl_admin -- ������
(
    adminseq NUMBER(4) PRIMARY KEY -- �������ڵ�
    , adminid VARCHAR2(20) NOT NULL -- ������ID
    , adminpw VARCHAR2(20) NOT NULL -- �����ڸ�
    , adminname VARCHAR2(20) NOT NULL -- ��й�ȣ
    , admintel VARCHAR2(20) -- �޴���
    , adminaddr VARCHAR2(100) -- �ּ�
);

CREATE TABLE tbl_member -- ȸ��
(
    memberseq NUMBER(4) PRIMARY KEY -- ȸ���ڵ�
    , memberid VARCHAR2(20) NOT NULL -- ȸ��ID
    , memberpw VARCHAR2(20) NOT NULL -- ��й�ȣ
    , membername VARCHAR2(20) NOT NULL -- ȸ����
    , membertel VARCHAR2(20) -- �޴���
    , memberaddr VARCHAR2(100) -- �ּ�
);

CREATE TABLE tbl_poll -- ��������
(
    pollseq NUMBER(4) PRIMARY KEY -- �����ڵ�
    , writer NVARCHAR2(50) NOT NULL -- �ۼ���
    , question NVARCHAR2(256) NOT NULL -- ����
    , sdate CHAR(8) NOT NULL -- ������
    , edate CHAR(8) NOT NULL -- ������
    , itemcnt NUMBER(1) NOT NULL -- �亯 �׸��
    , polltotal NUMBER(4) NOT NULL -- �� �����ڼ�
    , regdate DATE DEFAULT SYSDATE -- �ۼ���
    , adminseq REFERENCES tbl_admin(adminseq) NOT NULL -- �������ڵ�(�ܷ�Ű)
);

CREATE TABLE tbl_pollsub -- �亯�׸�
(
    pollsubseq NUMBER(38) PRIMARY KEY -- �亯�׸��ڵ�
    , pollseq REFERENCES tbl_poll(pollseq) NOT NULL -- �亯�׸�
    , answer NVARCHAR2(100) -- �亯�׸��ü� / ��ǥ��
    , acnt NUMBER(4) NOT NULL -- �����ڵ�(�ܷ�Ű)
);

CREATE TABLE tbl_voter -- ��ǥ��
(
    voterseq NUMBER PRIMARY KEY -- ��ǥ���ڵ�
    , pollseq REFERENCES tbl_poll(pollseq) NOT NULL -- ��ǥ��
    , pollsubseq REFERENCES tbl_pollsub(pollsubseq) NOT NULL -- �г���
    , memberseq REFERENCES tbl_member(memberseq) NOT NULL -- �����ڵ�(�ܷ�Ű)
    , username NVARCHAR2(256) DEFAULT '�͸�' -- �亯�׸��ڵ�(�ܷ�Ű)
    , regdate DATE DEFAULT SYSDATE -- ȸ���ڵ�(�ܷ�Ű)
);


INSERT INTO tbl_admin( adminseq , adminid, adminpw, adminname, admintel, adminaddr) VALUES(1001,'admin1','1234','������1', '010-1212-3434', '����Ư���� ������');
INSERT INTO tbl_admin( adminseq , adminid, adminpw, adminname, admintel, adminaddr) VALUES(1002,'admin2','2345','������2', '010-5656-7878', '��⵵ ���ν�');

INSERT INTO tbl_member( memberseq , memberid, memberpw, membername, membertel, memberaddr) VALUES(2001,'member1','1234','�ϱ浿', '010-1234-1234', '����Ư���� ������');
INSERT INTO tbl_member( memberseq , memberid, memberpw, membername, membertel, memberaddr) VALUES(2002,'member2','2345','�̱浿', '010-2345-2345', '��⵵ ������');
INSERT INTO tbl_member( memberseq , memberid, memberpw, membername, membertel, memberaddr) VALUES(2003,'member3','3456','��浿', null, null);
INSERT INTO tbl_member( memberseq , memberid, memberpw, membername, membertel, memberaddr) VALUES(2004,'member4','4567','��浿', null, null);
INSERT INTO tbl_member( memberseq , memberid, memberpw, membername, membertel, memberaddr) VALUES(2005,'member5','5678','���浿', null, null);

-- ���� 1
INSERT INTO tbl_poll( pollseq, writer, question, sdate, edate, itemcnt, polltotal, adminseq ) 
    VALUES( 3001, '������', '���� �����ϴ� ���� ��������?', '20230301', '20230331', 5, 0, 1001 );   
-- ���� 1 �׸�
INSERT INTO tbl_pollsub(pollsubseq , pollseq  , answer  , acnt) 
    VALUES( 5001, 3001, '�载��',  0);
INSERT INTO tbl_pollsub(pollsubseq , pollseq  , answer  , acnt) 
    VALUES( 5002, 3001, '�����',  0 );
INSERT INTO tbl_pollsub(pollsubseq , pollseq  , answer  , acnt) 
    VALUES( 5003, 3001, '���̺�',  0);
INSERT INTO tbl_pollsub(pollsubseq , pollseq  , answer  , acnt) 
    VALUES( 5004, 3001, '��ȿ��', 0 );
INSERT INTO tbl_pollsub(pollsubseq , pollseq  , answer  , acnt) 
    VALUES( 5005, 3001, '������', 0 );
-- ���� 1 ��ǥ
INSERT INTO tbl_voter(voterseq  , pollseq, pollsubseq  , memberseq, username)
    VALUES( 6001, 3001, 5001, 2001, '�ϱ浿' );
INSERT INTO tbl_voter(voterseq  , pollseq, pollsubseq  , memberseq)
    VALUES( 6002, 3001, 5004, 2002 );
INSERT INTO tbl_voter(voterseq  , pollseq, pollsubseq  , memberseq, username)
    VALUES( 6003, 3001, 5004, 2003, '�����' );
INSERT INTO tbl_voter(voterseq  , pollseq, pollsubseq  , memberseq)
    VALUES( 6004, 3001, 5004, 2004 );
INSERT INTO tbl_voter(voterseq  , pollseq, pollsubseq  , memberseq, username)
    VALUES( 6005, 3001, 5005, 2005, '���浿' );
    
-- ���� 2   
INSERT INTO tbl_poll( pollseq, writer, question, sdate, edate, itemcnt, polltotal, adminseq ) 
    VALUES( 3002, '������', '���� �����ϴ� ���� ��������?', '20230201', '20230228', 5, 0, 1001 );    
-- ���� 2 �׸�
INSERT INTO tbl_pollsub(pollsubseq , pollseq  , answer  , acnt) 
    VALUES( 5006, 3002, '�嵿��', 0);
INSERT INTO tbl_pollsub(pollsubseq , pollseq  , answer  , acnt) 
    VALUES( 5007, 3002, '�����', 0);
INSERT INTO tbl_pollsub(pollsubseq , pollseq  , answer  , acnt) 
    VALUES( 5008, 3002, '������', 0);
INSERT INTO tbl_pollsub(pollsubseq , pollseq  , answer  , acnt) 
    VALUES( 5009, 3002, '����', 0);
INSERT INTO tbl_pollsub(pollsubseq , pollseq  , answer  , acnt) 
    VALUES( 5010, 3002, '������', 0);
-- ���� 2 ��ǥ
INSERT INTO tbl_voter(voterseq  , pollseq, pollsubseq  , memberseq, username)
    VALUES( 6006, 3002, 5007, 2001, '�ϱ浿' );
INSERT INTO tbl_voter(voterseq  , pollseq, pollsubseq  , memberseq)
    VALUES( 6007, 3002, 5008, 2002 );
INSERT INTO tbl_voter(voterseq  , pollseq, pollsubseq  , memberseq, username)
    VALUES( 6008, 3002, 5009, 2003, '�����' );
INSERT INTO tbl_voter(voterseq  , pollseq, pollsubseq  , memberseq)
    VALUES( 6009, 3002, 5009, 2004 );

-- ���� 3
INSERT INTO tbl_poll( pollseq, writer, question, sdate, edate, itemcnt, polltotal, adminseq ) 
    VALUES( 3003, '������', '������ vs �����', '20230401', '20230430', 2, 0, 1002 );
-- ���� 3 �׸�
INSERT INTO tbl_pollsub(pollsubseq , pollseq  , answer  , acnt) 
    VALUES( 5011, 3003, '������', 0);
INSERT INTO tbl_pollsub(pollsubseq , pollseq  , answer  , acnt) 
    VALUES( 5012, 3003, '�����', 0);
-- ���� 3 ��ǥ

ROLLBACK;    
COMMIT;

-- ���� ��ȸ�� ������Ʈ(����)
UPDATE tbl_poll a
SET polltotal = ( SELECT COUNT(*) FROM tbl_voter WHERE pollseq = a.pollseq );
-- ���� ��ǥ�� ������Ʈ(����)
UPDATE tbl_pollsub a
SET acnt = ( SELECT COUNT(*) FROM tbl_voter WHERE pollsubseq = a.pollsubseq );

SELECT * FROM tbl_admin;
SELECT * FROM tbl_member;
SELECT * FROM tbl_poll;
SELECT * FROM tbl_pollsub;
SELECT * FROM tbl_voter;

-- �������
SELECT pollseq - 3000 ��ȣ, question ����, writer �ۼ���, sdate ������, edate ������, itemcnt �׸��, regdate �ۼ���, polltotal �����ڼ�,
    CASE 
        WHEN TO_CHAR(SYSDATE,'YYYYMMDD') BETWEEN sdate AND edate THEN '������'
        WHEN sdate > TO_CHAR(SYSDATE,'YYYYMMDD') THEN '���࿹��'
        ELSE '����'
    END ����
FROM tbl_poll t;
-- ��������1(����)
SELECT pollseq - 3000 ��ȣ, question ����, writer �ۼ���, TO_CHAR(SYSDATE,'YYYY-MM-DD AM HH:MI:SS') �ۼ���
     , TO_DATE(sdate,'YYYYMMDD') ������, TO_DATE(edate,'YYYYMMDD') ������
     , CASE 
        WHEN TO_CHAR(SYSDATE,'YYYYMMDD') BETWEEN sdate AND edate THEN '������'
        WHEN sdate > TO_CHAR(SYSDATE,'YYYYMMDD') THEN '���࿹��'
        ELSE '����'
       END ����, itemcnt �׸��, polltotal �������ڼ�
FROM tbl_poll
WHERE pollseq = 3001;
-- ��������2(�׸�)
SELECT a.pollseq - 3000 �Խñ۹�ȣ, answer �׸�
    ,(SELECT COUNT(*) FROM tbl_voter WHERE pollsubseq=b.pollsubseq) �׸���
    ,LPAD(' ',(SELECT COUNT(*) FROM tbl_voter WHERE pollsubseq=b.pollsubseq)+1,'#') ����׷���
FROM tbl_poll a RIGHT JOIN tbl_pollsub b ON a.pollseq=b.pollseq
WHERE a.pollseq = 3001
ORDER BY a.pollseq, pollsubseq;

--
DELETE FROM tbl_voter
WHERE pollseq = 3001;
DELETE FROM tbl_pollsub
WHERE pollseq = 3001;
DELETE FROM tbl_poll
WHERE pollseq = 3001;
--
DELETE FROM tbl_member
WHERE pollseq = 3001;
DELETE FROM tbl_admin
WHERE pollseq = 3001;

DROP TABLE tbl_voter PURGE;
DROP TABLE tbl_pollsub PURGE;
DROP TABLE tbl_poll PURGE;
DROP TABLE tbl_member PURGE;
DROP TABLE tbl_admin PURGE;
-------------------------------------------------------------------------------
1. �䱸�м���(����) �ۼ�
    1) ���� �ۼ�(���)�ϴ� ����� �����ڸ��� �� �� �ִ�
    2) �α��� �� ��(ȸ��)���� ������ ������ �� �ִ�
    3) ������ - ���� ���, ����, ����
    4) ȸ�� - ���� ���, ���� ����, ���� ����(��ǥ), ��ǥ ����, ���
    5) ������ �ۼ��� ����
        ��. ����
        ��. ���� ������ : ��, ��, ��
        ��. ���� ������
        ��. �׸��� ������ �����ϸ�
        ��. �׸�_
        ���� ���...
    6) ���� ��� ������
        ��. ���� ��ȣ
        ��. ����
        ��. �ۼ���
        ��. ������, ������
        ��. �׸��
        ��. �����ڼ�
        ��. ����( ������, ����, ������(���X) )
    7) ���� ���� ������ + �����ϱ�(��ǥ�ϱ�)
        ��. �� �����ڼ�
        ��. �׸�
        ��. ����
        ��. ��ǥ��
        ��. %
2. ������ DB �𵨸�
    1) E : ������, ��(ȸ��)
    2) A
    3) I
    4) R
    5) ����ǥ�� ���� ����, ���ü�(�ɼ�)
    
3. ���� DB �𵨸�
    1) ERD     -> ���η�(5����) -> ���� ��Ű��
    ������ ��Ű��       ��ȯ        ���̺� ��Ű��, ���� ��Ű��
    2) �̻� ����( ����, ����, ���� ) ����
       �Լ� ���Ӽ�( �Ӽ� ������ )   1NF
       �� ���� �Լ��� ���Ӽ�     -> 2NF ����Ű
       �� �κ� �Լ��� ���Ӽ�
       �� ���� �Լ��� ���Ӽ�     -> 3NF
                                 BCNF
                                4NF, 5NF X
        -- �ĺ����� : P(PK) - C(PK) ����
        -- ��ĺ����� : P(PK) - C(FK) �Ϲ��÷� ����
-------------------------------------------------------------------------------
/* �������� */
CREATE TABLE SCOTT.T_POLL (
   PollSeq NUMBER(4) NOT NULL, /* ����SEQ */
   Question Varchar(256) NOT NULL, /* ���� */
   SDate DATE NOT NULL, /* ������ */
   EDAte DATE NOT NULL, /* ������ */
   ItemCount Number(1) DEFAULT 1 NOT NULL, /* �亯�׸�� */
   PollTotal NUMBER(4), /* �������� */
   RegDate Date DEFAULT sysdate NOT NULL, /* �ۼ��� */
   MemberSEQ NUMBER(4) /* �ۼ���(ȸ��SEQ) */
);

COMMENT ON TABLE SCOTT.T_POLL IS '��������';

COMMENT ON COLUMN SCOTT.T_POLL.PollSeq IS '����SEQ';

COMMENT ON COLUMN SCOTT.T_POLL.Question IS '����';

COMMENT ON COLUMN SCOTT.T_POLL.SDate IS '������';

COMMENT ON COLUMN SCOTT.T_POLL.EDAte IS '������';

COMMENT ON COLUMN SCOTT.T_POLL.ItemCount IS '�亯�׸��';

COMMENT ON COLUMN SCOTT.T_POLL.PollTotal IS '��������';

COMMENT ON COLUMN SCOTT.T_POLL.RegDate IS '�ۼ���';

COMMENT ON COLUMN SCOTT.T_POLL.MemberSEQ IS '�ۼ���(ȸ��SEQ)';

CREATE UNIQUE INDEX SCOTT.PK_T_POLL
   ON SCOTT.T_POLL (
      PollSeq ASC
   );

ALTER TABLE SCOTT.T_POLL
   ADD
      CONSTRAINT PK_T_POLL
      PRIMARY KEY (
         PollSeq
      );

/* �����׸� */
CREATE TABLE SCOTT.T_PollSub (
   PollSubSeq NUMBER(38) NOT NULL, /* �亯�׸�SEQ */
   Answer Varchar2(100) NOT NULL, /* �亯�׸� */
   ACount Number(4), /* �亯�׸��ü� */
   PollSeq NUMBER(4) NOT NULL /* ����SEQ */
);

COMMENT ON TABLE SCOTT.T_PollSub IS '�����׸�';

COMMENT ON COLUMN SCOTT.T_PollSub.PollSubSeq IS '�亯�׸�SEQ';

COMMENT ON COLUMN SCOTT.T_PollSub.Answer IS '�亯�׸�';

COMMENT ON COLUMN SCOTT.T_PollSub.ACount IS '�亯�׸��ü�';

COMMENT ON COLUMN SCOTT.T_PollSub.PollSeq IS '����SEQ';

CREATE UNIQUE INDEX SCOTT.PK_T_PollSub
   ON SCOTT.T_PollSub (
      PollSubSeq ASC
   );

ALTER TABLE SCOTT.T_PollSub
   ADD
      CONSTRAINT PK_T_PollSub
      PRIMARY KEY (
         PollSubSeq
      );

/* ��ǥ�� */
CREATE TABLE SCOTT.T_Voter (
   VectorSeq NUMBER NOT NULL, /* ��ǥSEQ */
   UserName VARCHAR2(20), /* ������̸� */
   RegDate DATE, /* ��ǥ�� */
   PollSeq NUMBER(4), /* ����SEQ */
   PollSubSeq NUMBER(38), /* �亯�׸�SEQ */
   MemberSeq NUMBER(4) /* ȸ��SEQ */
);

COMMENT ON TABLE SCOTT.T_Voter IS '��ǥ��';

COMMENT ON COLUMN SCOTT.T_Voter.VectorSeq IS '��ǥSEQ';

COMMENT ON COLUMN SCOTT.T_Voter.UserName IS '������̸�';

COMMENT ON COLUMN SCOTT.T_Voter.RegDate IS '��ǥ��';

COMMENT ON COLUMN SCOTT.T_Voter.PollSeq IS '����SEQ';

COMMENT ON COLUMN SCOTT.T_Voter.PollSubSeq IS '�亯�׸�SEQ';

COMMENT ON COLUMN SCOTT.T_Voter.MemberSeq IS 'ȸ��SEQ';

CREATE UNIQUE INDEX SCOTT.PK_T_Voter
   ON SCOTT.T_Voter (
      VectorSeq ASC
   );

ALTER TABLE SCOTT.T_Voter
   ADD
      CONSTRAINT PK_T_Voter
      PRIMARY KEY (
         VectorSeq
      );

/* ȸ�� */
CREATE TABLE SCOTT.T_Member (
   MemberSeq NUMBER(4) NOT NULL, /* ȸ��SEQ */
   MemberID varchar2(20) NOT NULL, /* ȸ�����̵� */
   MemberPasswd varchar2(20), /* ��й�ȣ */
   MemberName varchar2(20), /* ȸ���� */
   MemberPhone varchar2(20), /* �޴��� */
   MemberAddress varchar2(100) /* �ּ� */
);

COMMENT ON TABLE SCOTT.T_Member IS 'ȸ��';

COMMENT ON COLUMN SCOTT.T_Member.MemberSeq IS 'ȸ��SEQ';

COMMENT ON COLUMN SCOTT.T_Member.MemberID IS 'ȸ�����̵�';

COMMENT ON COLUMN SCOTT.T_Member.MemberPasswd IS '��й�ȣ';

COMMENT ON COLUMN SCOTT.T_Member.MemberName IS 'ȸ����';

COMMENT ON COLUMN SCOTT.T_Member.MemberPhone IS '�޴���';

COMMENT ON COLUMN SCOTT.T_Member.MemberAddress IS '�ּ�';

CREATE UNIQUE INDEX SCOTT.PK_T_Member
   ON SCOTT.T_Member (
      MemberSeq ASC
   );

ALTER TABLE SCOTT.T_Member
   ADD
      CONSTRAINT PK_T_Member
      PRIMARY KEY (
         MemberSeq
      );

ALTER TABLE SCOTT.T_POLL
   ADD
      CONSTRAINT FK_T_Member_TO_T_POLL
      FOREIGN KEY (
         MemberSEQ
      )
      REFERENCES SCOTT.T_Member (
         MemberSeq
      );

ALTER TABLE SCOTT.T_PollSub
   ADD
      CONSTRAINT FK_T_POLL_TO_T_PollSub
      FOREIGN KEY (
         PollSeq
      )
      REFERENCES SCOTT.T_POLL (
         PollSeq
      );

ALTER TABLE SCOTT.T_Voter
   ADD
      CONSTRAINT FK_T_POLL_TO_T_Voter
      FOREIGN KEY (
         PollSeq
      )
      REFERENCES SCOTT.T_POLL (
         PollSeq
      );

ALTER TABLE SCOTT.T_Voter
   ADD
      CONSTRAINT FK_T_PollSub_TO_T_Voter
      FOREIGN KEY (
         PollSubSeq
      )
      REFERENCES SCOTT.T_PollSub (
         PollSubSeq
      );

ALTER TABLE SCOTT.T_Voter
   ADD
      CONSTRAINT FK_T_Member_TO_T_Voter
      FOREIGN KEY (
         MemberSeq
      )
      REFERENCES SCOTT.T_Member (
         MemberSeq
      );
-------------------------------------------------------------------------------
1) ȸ�� ����/����/Ż�� ����
DESC T_MEMBER;
�̸�            ��?       ����            
------------- -------- ------------- 
MEMBERSEQ     NOT NULL NUMBER(4)     
MEMBERID      NOT NULL VARCHAR2(20)  
MEMBERPASSWD           VARCHAR2(20)  
MEMBERNAME             VARCHAR2(20)  
MEMBERPHONE            VARCHAR2(20)  
MEMBERADDRESS          VARCHAR2(100) 

    ��. T_MEMBER PK Ȯ��
SELECT *
FROM user_constraints
WHERE table_name LIKE 'T_M%' AND constraint_type = 'P';

    ��. ȸ������
    ������(sequence) �ڵ����� ��ȣ �߻���Ű�� ��ü == ���� (��ȣ)
INSERT INTO T_MEMBER( MEMBERSEQ, MEMBERID, MEMBERPASSWD, MEMBERNAME, MEMBERPHONE, MEMBERADDRESS )
VALUES              ( 1        , 'admin' , '1234'      , '������'   , '010-1111-1111', '���� ������' );
INSERT INTO T_MEMBER( MEMBERSEQ, MEMBERID, MEMBERPASSWD, MEMBERNAME, MEMBERPHONE, MEMBERADDRESS )
VALUES              ( 2        , 'hong'  , '1234'      , 'ȫ�浿'   , '010-2222-2222', '���� ���۱�' );
INSERT INTO T_MEMBER( MEMBERSEQ, MEMBERID, MEMBERPASSWD, MEMBERNAME, MEMBERPHONE, MEMBERADDRESS )
VALUES              ( 3        , 'kim'   , '1234'      , '����'   , '010-3333-3333', '��⵵ �����ֽ�' );

COMMIT;

    ��. ȸ�� ���� ��ȸ
SELECT *
FROM t_member;

    ��. ȸ�� ���� ����
    �α��� -> (ȫ�浿) -> [�� ����] -> �� ���� ���� -> [����] -> [][][][][][][] -> [����]
PL/SQL
UPDATE T_MEMBER
SET MEMBERNAME = , MEMBERPHONE = 
WHERE MEMBERSEQ = 2;

    ��. ȸ�� Ż��
DELETE FROM T_MEMBER
WHERE MEMBERSEQ = 2;
-------------------------------------------------------------------------------
2) ���� �ۼ�
    ��. �����ڷ� �α���
    ��. [���� �ۼ�] �޴� ����
    ��. ���� �ۼ� �������� �̵�
INSERT INTO T_POLL (PollSeq,Question,SDate, EDAte , ItemCount,PollTotal, RegDate, MemberSEQ )
VALUES             ( 1    ,'�����ϴ� �����?'
                          , TO_DATE( '2023-03-01 00:00:00'   ,'YYYY-MM-DD HH24:MI:SS')
                          , TO_DATE( '2023-03-15 18:00:00'   ,'YYYY-MM-DD HH24:MI:SS') 
                          , 5
                          , 0
                          , TO_DATE( '2023-02-15 00:00:00'   ,'YYYY-MM-DD HH24:MI:SS')
                          , 1
                    );

    ��. ���� �׸�
INSERT INTO T_PollSub (PollSubSeq          , Answer , ACount , PollSeq  ) 
VALUES                (1 ,'�载��', 0, 1 );
INSERT INTO T_PollSub (PollSubSeq          , Answer , ACount , PollSeq  ) 
VALUES                (2 ,'�����', 0, 1 );
INSERT INTO T_PollSub (PollSubSeq          , Answer , ACount , PollSeq  ) 
VALUES                (3 ,'������', 0, 1 );
INSERT INTO T_PollSub (PollSubSeq          , Answer , ACount , PollSeq  ) 
VALUES                (4 ,'�輱��', 0, 1 );
INSERT INTO T_PollSub (PollSubSeq          , Answer , ACount , PollSeq  ) 
VALUES                (5 ,'������', 0, 1 );

   ��. ���� �ۼ� �������� �̵�...
INSERT INTO T_POLL (PollSeq,Question,SDate, EDAte , ItemCount,PollTotal, RegDate, MemberSEQ )
VALUES               ( 2  ,'�����ϴ� ����?'
                          , TO_DATE( '2023-03-20 00:00:00'   ,'YYYY-MM-DD HH24:MI:SS')
                          , TO_DATE( '2023-04-01 18:00:00'   ,'YYYY-MM-DD HH24:MI:SS') 
                          , 4
                          , 0
                          , TO_DATE( '2023-03-15 00:00:00'   ,'YYYY-MM-DD HH24:MI:SS')
                          , 1
                    );

    ��. ���� �׸�                   
INSERT INTO T_PollSub (PollSubSeq          , Answer , ACount , PollSeq  ) 
VALUES                (6 ,'�ڹ�', 0, 2 );
INSERT INTO T_PollSub (PollSubSeq          , Answer , ACount , PollSeq  ) 
VALUES                (7 ,'����Ŭ', 0, 2 );
INSERT INTO T_PollSub (PollSubSeq          , Answer , ACount , PollSeq  ) 
VALUES                (8 ,'HTML5', 0, 2 );
INSERT INTO T_PollSub (PollSubSeq          , Answer , ACount , PollSeq  ) 
VALUES                (9 ,'JSP', 0, 2 );

COMMIT;
--
SELECT *
FROM t_poll;
--
SELECT *
FROM t_pollsub;
-------------------------------------------------------------------------------
3) ȸ���� �α����߽��ϴ�
    ���� ��� ������
    2�� ���� : �����ϴ� ���� "����" Ŭ��
SELECT *
FROM t_member;
--> 3 kim 1234 ���� (����)
SELECT *
FROM (
SELECT pollseq ��ȣ, question ����, membername �ۼ���
     , sdate ������, edate ������, itemcount �׸��, polltotal �����ڼ�
     , CASE 
        WHEN TO_CHAR(SYSDATE,'YYYYMMDD') BETWEEN sdate AND edate THEN '���� ��'
        WHEN sdate > TO_CHAR(SYSDATE,'YYYYMMDD') THEN '���� ��'
        ELSE '����'
       END ���� -- ����Ӽ� -> ����, ���� ��, ���� ��
FROM t_poll p JOIN t_member m ON m.memberseq = p.memberseq
ORDER BY ��ȣ DESC
) t
WHERE ���� != '���� ��';
-------------------------------------------------------------------------------
4) 3(����) �α��� ���� + 2�� ���� ����( �����ϴ� ���� ) [ ��ǥ ������ ]
   ���� ���μ���
   ���� ��� ���������� ���������ϱ� ���ؼ� 2�� ������ Ŭ��
   [ ���� ���� ������ ]
   ��. 2�� ������ ������ SELECT -> ���
       �� ���� ����
          ����, �ۼ���, �ۼ���, ������, ������, ����, �׸�� ��ȸ
SELECT question ����, membername �ۼ���, TO_CHAR( regdate, 'YYYY-MM-DD hh:mi:ss' ) �ۼ���
     , TO_CHAR( sdate, 'YYYY-MM-DD' ) ������, TO_CHAR( edate, 'YYYY-MM-DD' ) ������
     , CASE 
        WHEN TO_CHAR(SYSDATE,'YYYYMMDD') BETWEEN sdate AND edate THEN '���� ��'
        WHEN sdate > TO_CHAR(SYSDATE,'YYYYMMDD') THEN '���� ��'
        ELSE '����'
       END ����, itemcount �׸��
FROM t_poll p JOIN t_member m ON p.memberseq = m.memberseq
WHERE pollseq = 2;
       �� ���� �׸�
SELECT answer
FROM t_pollsub
WHERE pollseq = 2;
   ��. �� �����ڼ� 7��
        �� �׸� [][][] 3
-- 2�� ������ �������ڼ�
SELECT polltotal
FROM t_poll
WHERE pollseq = 2;
--
SELECT answer, acount
     , ( SELECT polltotal FROM t_poll WHERE pollseq = 2 ) totalcount
     --, ����׷���
     , ROUND( acount / ( SELECT polltotal FROM t_poll WHERE pollseq = 2 ) * 100 ) || '%' ����
FROM t_pollsub
WHERE pollseq = 2;
--------------------------------------------------------------------------------
5) [��ǥ�ϱ�] ��ư Ŭ��
    - 2�� ������ �׸��� �����ؾ��Ѵ�
    �ڹ�
    ����Ŭ(üũ) --> �����׸� PK ���� 7�� ����
    HTMS5
    JSP
SELECT *
FROM t_voter;
-- (1) t_voter
INSERT INTO t_voter( vectorseq, username, regdate, pollseq, pollsubseq, memberseq )
VALUES             ( 1        , '����' , SYSDATE, 2      , 7         , 3         );

COMMIT;

-- (1) -> (2)(3) �ڵ� ���� [Ʈ����]
-- (2) t_poll, polltotal => 1 ����
UPDATE t_poll
SET polltotal = polltotal + 1
WHERE pollseq = 2;

-- (3) t_pollsub acount => 1 ����
UPDATE t_pollsub
SET acount = acount + 1
WHERE pollsubseq = 7;
-------------------------------------------------------------------------------
PL/SQL
    �� Procedural Language extensions to SQL
    �� ������ ������ �� �ִ� ���, ���(�帧����) ���
    �� 3���� ��� ������ �� ���
�����ġ�
   [ DECLARE ]
      -- 1) ����(declarations)
   BEGIN
      -- 2) ���๮(statements)
      /*
      DQL, DDL, DML, DCL, TCL
      insert
      select
      update
      */
   [ EXCEPTION ]
      -- 3) ���� ó����(handlers)
   END; 
-- [ PL/SQL�� 6���� ���� ]
1) anonymous procedure �͸� ���ν���
2) stored procedure ���� ���ν��� ***** ��ǥ
3) stored function ���� �Լ�
4) package ��Ű�� DBMS_RANDOM
5) trigger Ʈ����

-- ��) ��ǥ�ϱ� INSERT
    (1) t_voter ��ǥ�� insert
    (2) t_poll ����   �� �ش� ������ �������ڼ� 1���� update
    (3) t_pollsub �����׸�  �� �ش� �����׸��� ��ǥ�ڼ� 1���� update
    
-- 1) �͸� ���ν���
DECLARE
    -- A�� : ���� ����
BEGIN
    -- B�� : �����Ϸ��� �������� SQL�� �ۼ�
    -- (1) t_voter
    INSERT INTO t_voter( vectorseq, username, regdate, pollseq, pollsubseq, memberseq )
    VALUES             ( 2        , '������' , SYSDATE, 2      , 8         , 1         );
    
    -- (2) t_poll, polltotal => 1 ����
    UPDATE t_poll
    SET polltotal = polltotal + 1
    WHERE pollseq = 2;
    
    -- (3) t_pollsub acount => 1 ����
    UPDATE t_pollsub
    SET acount = acount + 1
    WHERE pollsubseq = 8;
    
    COMMIT;
-- EXCEPTION
    -- C�� : ���� ó���ϴ� ��
    -- ROLLBACK;
END;
-- PL/SQL ���ν����� ���������� �Ϸ�Ǿ����ϴ�.

SELECT * FROM t_poll;
SELECT * FROM t_pollsub;
SELECT * FROM t_voter;

SELECT ename, sal
FROM emp
WHERE empno = 7369;
-- ��) PL/SQL �͸� ���ν��� ���
DECLARE
    -- ���� ���� ��
    -- v ���ξ� : [v]ariable ����
    vempno  NUMBER(4) := 7369;
    vename  VARCHAR2(10);
    vsal    NUMBER(7,2);
BEGIN
    SELECT ename, sal INTO vename, vsal
    FROM emp
    WHERE empno = vempno;
    -- ��� : DBMS_OUTPUT ��Ű�� �Լ� ����ؼ� ���
    DBMS_OUTPUT.PUT_LINE( vename || ' ' || vsal );
--EXCEPTION
END;
--------------------------------------------------------------------------------
[DECLARE]
    1 �� : ���� ����
    vempno  NUMBER(4) := 7369;
    vename  VARCHAR2(10);
    vsal    NUMBER(7,2);
    in_stock BOOLEAN;
    -- RECORE, TABLE ������Ÿ��
BEGIN
    2 �� : SQL �ۼ�
    PL/SQL ȭ�� ��� : DBMS_OUTPUT ��Ű�� ���
    SELECT ename, sal INTO vename, vsal
    FROM emp
    WHERE empno = vempno;
    
    INSERT INTO VALUES( vename, vsal );
[EXCEPTION]
    3 �� : ���� ó��
END;
�͸� ���ν���, ���� ���ν���, ���� �Լ�, ��Ű��, Ʈ����
-------------------------------------------------------------------------------
-- PL/SQL ���� ���� : [ PL/SQL ������ ���� ]
    - ����� ������ ���Ǳ� ���� ���� ����Ǿ�� �Ѵ�
    - ����� ����� ������ SQL ������ ���ȴ�
    - �������� �����ϴ� ���( ����, �Ҵ� )
        1) ���Կ����� :=
        2) select�� fetch�� ���ؼ� ������ ����
    - ����� ������ �������� ����� CONSTANT��� ���� ����ϸ� �ȴ�
        ��)
        ������ CONSTANT �ڷ��� := �ʱⰪ;
        vpi CONSTANT NUMBER := 3.14;
    - ������ 4���� ����
        1) SCLAR ����
        2) REFERENCE ����
        3) COMPOSITE ����
        4) BIND ����
    - [ %TYPE ���� ]
    �����ġ� ������ table��.column��%TYPE;
    ���� � ���̺��� Ư�� �÷��� ���� ������ �����ؾ� �Ѵٸ�,
    ������ ������ �� �ش� ���̺�� �ش� �÷��� ������ Ÿ�԰� ũ�⸦ �״�� �����Ͽ� �����Ͽ� ����� �� �ִµ� �� Ÿ���� TYPE ������ �Ѵ�.

    �� Ÿ�Կ����� ���̺��� ������ ���� ����Ǵ� �����ͺ��̽� ȯ�濡�� ����� ������ PL/SQL ���� �������� �ʾƵ� �Ǵ� ������ �ִ�.
    -- ��) �����ȣ 7369�� �����, sal ����ϴ� �͸� ���ν��� ���� + �ǻ�
    DECLARE
        vempno emp.empno%TYPE := 7369;
        vename emp.ename%TYPE;
        vsal emp.sal%TYPE;
    BEGIN
    --EXCEPTION
    END;
    -- ��)
    DECLARE
        vname emp.ename%TYPE;
        vage NUMBER(3);
    BEGIN
        -- INTO : SELECT, FETCH ������ ���
        vname := 'ȫ�浿';
        vage := 20;
        
        DBMS_OUTPUT.PUT_LINE( vname || ' ' || vage );
    --EXCEPTION
    END;
    
    -- ����) 30�� �μ��� �������� ���ͼ� 10�� �μ��� ���������� �����ϴ� �͸� ���ν���
    SELECT *
    FROM dept;
    DECLARE
        vloc dept.loc%TYPE;
    BEGIN     
        SELECT loc INTO vloc
        FROM dept
        WHERE deptno = 30;
        
        UPDATE dept
        SET loc = vloc
        WHERE deptno = 10;
        
        COMMIT;
    --EXCEPTION
        --ROLLBACK;
    END;

    -- ����) 10�� �μ��� �߿� �ְ�޿��� �޴� ����� ������ ����ϼ���
        -- TOP-N ���
         SELECT t.*
        FROM (
        SELECT *
        FROM emp
        WHERE deptno = 10
        ORDER BY sal DESC
        ) t
        WHERE ROWNUM = 1;
        -- RANK() �Լ�
        SELECT t.*
        FROM (
        SELECT emp.*
             , RANK() OVER( PARTITION BY deptno ORDER BY sal DESC ) ����
        FROM emp
        WHERE deptno = 10
        ) t
        WHERE t.���� = 1;
        -- �����������
        SELECT *
        FROM emp
        WHERE sal = ( SELECT MAX( sal ) max_sal FROM emp WHERE deptno = 10 ) AND deptno = 10;
    -- �͸� ���ν���
    DECLARE
        vmax_sal_10 emp.sal%TYPE; -- 2450
        
        vrow emp%ROWTYPE; -- �� ��ü ����
    BEGIN
        SELECT MAX( sal ) INTO vmax_sal_10
        FROM emp
        WHERE deptno = 10;
        
        SELECT empno, ename, job, sal, hiredate, deptno
            INTO vrow.empno, vrow.ename, vrow.job, vrow.sal, vrow.hiredate, vrow.deptno
        FROM emp
        WHERE sal = vmax_sal_10 AND deptno = 10;
        
        DBMS_OUTPUT.PUT_LINE( vrow.empno );
        DBMS_OUTPUT.PUT_LINE( vrow.ename );
        DBMS_OUTPUT.PUT_LINE( vrow.job );
        DBMS_OUTPUT.PUT_LINE( vrow.sal );
        DBMS_OUTPUT.PUT_LINE( vrow.hiredate );
        DBMS_OUTPUT.PUT_LINE( vrow.deptno );
    --EXCEPTION
    END;
    
    -- ��� ����� empno, ename ������ ��ȸ
    -- ORA-01422: exact fetch returns more than requested number of rows
    -- ��Ȯ�� ��ġ(��������)�� ��û�� ������ ���� ���� ��ȯ�Ѵ�
    -- PL/SQL���� �������� ���ڵ带 �����ͼ� ó���ϱ� ���ؼ��� �ݵ�� Ŀ��(cursor)�� ����ؾ� �ȴ�
    DECLARE
        vempno emp.empno%TYPE;
        vename emp.ename%TYPE;
    BEGIN
        SELECT empno, ename INTo vempno, vename
        FROM emp;
        -- WHERE empno = 7369;
        
        DBMS_OUTPUT.PUT_LINE( vempno || ' ' || vename );
    --EXCEPTION
    END;
    
-- PL/SQL �帧����(���)
1) IF...THEN...ELSE��
    IF (���ǽ�) THEN
    END IF;
        
    IF (���ǽ�) THEN
    ELSE
    END IF;
        
    IF (���ǽ�) THEN
    ELSIF (���ǽ�) THEN
    ELSE
    END IF;
        
    -- ����) ������ �ϳ� �����޼� ������ �Է¹޾Ƽ� ¦��, Ȧ�� ���
    DECLARE
        vnum NUMBER(3) := 0;
        vresult VARCHAR2(6) := '¦��';
    BEGIN
        vnum := :bindNumber;
        
        IF ( MOD(vnum,2) = 1 ) THEN
            vresult := 'Ȧ��';
        END IF;
        
        DBMS_OUTPUT.PUT_LINE( vresult );
    --EXCEPTION
    END;
    
    -- ����) ���������� �Է¹޾Ƽ� ��/��/��/��/�� ���
    DECLARE
        vkor NUMBER(3) := 0;
        vgrade VARCHAR2(1 CHAR) := '��';
    BEGIN
        vkor := :bindKor;
        
        IF ( vkor BETWEEN 0 AND 100 ) THEN
            IF vkor >= 90 THEN
                vgrade := '��';
            ELSIF vkor >= 80 THEN
                vgrade := '��';
            ELSIF vkor >= 70 THEN
                vgrade := '��';
            ELSIF vkor >= 60 THEN
                vgrade := '��';
            ELSE
                vgrade := '��';
            END IF;
            DBMS_OUTPUT.PUT_LINE( vgrade );
        ELSE
            DBMS_OUTPUT.PUT_LINE('�������� 0~100��');
        END IF;
    --EXCEPTION
    END;
    --
    DECLARE
        vkor NUMBER(3) := 0;
        vgrade VARCHAR2(1 CHAR) := '��';
    BEGIN
        vkor := :bindKor;
        
        CASE TRUNC( vkor/10 )
            WHEN 10 THEN vgrade := '��';
            WHEN 9 THEN vgrade := '��';
            WHEN 8 THEN vgrade := '��';
            WHEN 7 THEN vgrade := '��';
            WHEN 6 THEN vgrade := '��';
            ELSE
                vgrade := '��';
            END CASE;
            DBMS_OUTPUT.PUT_LINE( vgrade );
    --EXCEPTION
    END;
    
2) LOOP...END LOOP(�ܼ� �ݺ�)��
    LOOP
        -- �ݺ� �ڵ�
        EXIT WHEN ����
    END LOOP;
    
    -- ����) 1~10 �� ���
    DECLARE
        vi NUMBER := 1;
        vsum NUMBER := 0;
    BEGIN
        LOOP
            DBMS_OUTPUT.PUT( vi );
            IF vi != 10 THEN
                DBMS_OUTPUT.PUT( '+' );
            END IF;
            -- += ���մ��Կ����� X
            vsum := vsum + vi;
            EXIT WHEN vi = 10;
            -- ++ ���������� X
            vi := vi + 1;
        END LOOP;
        DBMS_OUTPUT.PUT_LINE( '=' || vsum );
    --EXCEPTION
    END;
    
3) WHILE...LOOP(������ �ݺ�)��
    WHILE (���ǽ�)
    LOOP
        -- �ݺ������� ó���� �ڵ�
    END LOOP;
    
    -- ����) 1~10 �� ���
    DECLARE
        vi NUMBER;
        vsum NUMBER := 0;
    BEGIN
        vi := 1;
        WHILE ( vi <= 10 )
        LOOP
            DBMS_OUTPUT.PUT( vi );
            IF vi != 10 THEN
                DBMS_OUTPUT.PUT( '+' );
            END IF;
            -- += ���մ��Կ����� X
            vsum := vsum + vi;
            -- ++ ���������� X
            vi := vi + 1;
        END LOOP;
        DBMS_OUTPUT.PUT_LINE( '=' || vsum );
    --EXCEPTION
    END;
    
4) FOR...LOOP(������ �ݺ�)��
    FOR ī��Ʈ����(i) IN [REVERSE] ���۰�.. ����
    LOOP
        -- �ݺ������� ó���� �ڵ�
    END LOOP;
    
    -- ����) 1~10 �� ���
    DECLARE
        vi NUMBER;
        vsum NUMBER := 0;
    BEGIN
        FOR vi IN 1.. 10
        LOOP
            DBMS_OUTPUT.PUT( vi );
            IF vi != 10 THEN
                DBMS_OUTPUT.PUT( '+' );
            END IF;
            -- += ���մ��Կ����� X
            vsum := vsum + vi;
        END LOOP;
        DBMS_OUTPUT.PUT_LINE( '=' || vsum );
    --EXCEPTION
    END;
    
5) GOTO��(������ �帧����)
-------------------------------------------------------------------------------
DECLARE
    vrow NUMBER(1) := 1;
    vcolumn NUMBER(1) := 1;
    vresult NUMBER(2);
BEGIN
    LOOP
        LOOP
            DBMS_OUTPUT.PUT( vrow || '*' || vcolumn );
            vresult := vrow * vcolumn;
            IF vrow != 9 THEN
                DBMS_OUTPUT.PUT( '=' || vresult || '  ' );
            ELSE
                DBMS_OUTPUT.PUT_LINE( '=' || vresult || '  ' );
            END IF;
            EXIT WHEN vrow = 9;
            vrow := vrow + 1;
        END LOOP;
        EXIT WHEN vcolumn = 9;
        vrow := 1;
        vcolumn := vcolumn + 1;
    END LOOP;   
--EXCEPTION
END;

DECLARE
    a NUMBER := 2;
    b NUMBER := 1;
BEGIN
    LOOP
        LOOP
            DBMS_OUTPUT.PUT_LINE(a||'*'||b||'='||a*b||' ');
            b := b + 1; 
            EXIT WHEN b = 10; --b�� 10�ϵɶ� ���� b�� 1�� ���ذ��µ�, �װ� ab=ab�� ������� ����� ���ְڴ�.
        END LOOP; --b�� 10�� �Ǹ� �ݺ��� �ߴ��Ѵ�.
        a := a + 1; --a�� 1�� ���ذ��ڴ� �ܼ������� ���ش�. 2�� ������ -> 3��, 3-> 4��, ..., 8�� -> 9��
        b := 1; --�ܼ����� �ɶ� 1���� �ٽ� ������� �ϱ⶧���� 1�� ���� 
        EXIT WHEN a = 10; -- a�� 10�� �ɶ����� �� ������ �ݺ��ϰڴ�.
        DBMS_OUTPUT.PUT_LINE('-----���м��Դϴ�-----'); --�ܼ��� �ٲ𶧸��� �׳� ���� ���ϰ� ���м��� �߰� �����.
    END LOOP;
--EXCEPTION
END;

DECLARE
    vdan NUMBER := 2;
    vi NUMBER ;
    vx NUMBER;
BEGIN
    LOOP
        DBMS_OUTPUT.PUT_LINE(vdan||'��');
        vi:=1;
        LOOP
        vx:=vdan*vi;
        DBMS_OUTPUT.PUT_LINE(vdan||'*'||vi||'='||vx);
        vi:=vi+1;
        EXIT WHEN vi>9;
        END LOOP;
    vdan:=vdan+1;
    EXIT WHEN vdan>9;
    END LOOP;
    DBMS_OUTPUT.PUT_LINE('������ ����');
--EXCEPTION
END;




























