-- SCOTT --
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



















