-- SCOTT --
-------------------------------------------------------------------------------
1.  truncate / delete / drop ���ؼ� �����ϼ���
    DML : turncate - ���̺� ���� ��� ���ڵ带 ������ ���ÿ� �ڵ� Ŀ��
    DML : delete - ���̺� ���� ��� ���ڵ� ����
    DDL : drop - ���̺�, �÷�, �������� ����

2.  insert �� ���� �� ������ ���� ������ �߻��ߴٸ� ������ ���� �����ϼ���
  ��. 00947. 00000 -  "not enough values"
  �Է��ϴ� �÷����� ���� ������ �� ���
  INSERT INTO ���̺��(�÷���,�÷���,�÷���) VALUES(��,��)
  
  ��. ORA-00001: unique constraint (SCOTT.SYS_C007770) violated  
  ���ϼ� �������� ����
  dept 10, 20, 30, 40
  INSERT INTO dept VALUES (40,'','')
  
  ��. ORA-02291: integrity constraint (SCOTT.FK_DEPTNO) violated - parent key not found
  �θ�Ű�� ã�� �� ���� ���Ἲ �������� ����
  dept 10, 20, 30, 40
  INSERT INTO emp VALUES (50,...)
   
3. ���������� ����ؼ� ���̺� ����
  ��. deptno, dname, empno, ename, sal+nvl(comm,0) pay, grade �÷��� ���� ���ο� ���̺� ����
  ��. ���̺�� : tbl_empdeptgrade   
  CREATE TABLE tbl_empdeptgrade
  AS (
    SELECT d.deptno, dname, empno, ename, sal+nvl(comm,0) pay, grade
    FROM dept d, emp e, salgrade s
    WHERE d.deptno = e.deptno
      AND e.sal BETWEEN s.losal AND s.hisal
  );

4-1. insa ���̺��� num, name �����ͼ� tbl_score ���̺� ����
     (tbl_score ���̺��� ������ ���� �� �����ϼ��� )
     CREATE TABLE tbl_score
     AS (
        SELECT num, name
        FROM insa
     );
4-2. kor, eng, mat, tot          , avg , grade, rank �÷� �߰�
ALTER TABLE tbl_score
ADD (
      kor NUMBER(3) DEFAULT 0
    , eng NUMBER(3) DEFAULT 0
    , mat NUMBER(3) DEFAULT 0
    , tot NUMBER(3)
    , avg NUMBER(5,2)
    , grade NVARCHAR2(3)
    , rank NUMBER(3)
);
4-3. �� �л����� kor,eng,mat ���� 0~100 �����ϰ� ä���ֱ�.
UPDATE tbl_score
SET   kor = TRUNC( dbms_random.VALUE(0,101) )
    , eng = TRUNC( dbms_random.VALUE(0,101) )
    , mat = TRUNC( dbms_random.VALUE(0,101) );
COMMIT;
4-4. ����, ���, ���, ��� ����
    ����)
     ����� ��� ������ 40���̻��̰�, ��� 60 �̻��̸� "�հ�"
           ��� 60 �̻��̶� �� �����̶� 40�� �̸��̶��  "����"
           �׿ܴ� "���հ�" �̶�� ����.
UPDATE tbl_score a
SET   tot = kor + eng + mat
    , avg = ( kor + eng + mat ) / 3
    , grade = CASE
                WHEN kor >= 40 AND eng >= 40 AND mat >= 40 AND avg >= 60 THEN '�հ�'
                WHEN (kor < 40 OR eng < 40 OR mat < 40) AND avg >= 60 THEN '����'
                ELSE '���հ�'
               END
     , rank = ( SELECT COUNT(*)+1 FROM tbl_score WHERE tot > a.tot );
COMMIT;
             
5.  emp ���̺��� ������ Ȯ���ϰ�, ���������� Ȯ���ϰ�, ������ ��� ������ �߰��ϴ� INSERT ���� �ۼ��ϼ���.
   ��. ����Ȯ�� ���� 
   ��. �������� Ȯ�� ����
   ��. INSERT ���� 

6-1. emp ���̺��� ������ �����ؼ� ���ο� tbl_emp10, tbl_emp20, tbl_emp30, tbl_emp40 ���̺��� �����ϼ���. 
    CREATE TABLE tbl_emp10  AS ( SELECT * FROM emp WHERE 1=0 );
    CREATE TABLE tbl_emp20  AS ( SELECT * FROM emp WHERE 1=0 );
    CREATE TABLE tbl_emp30  AS ( SELECT * FROM emp WHERE 1=0 );
    CREATE TABLE tbl_emp40  AS ( SELECT * FROM emp WHERE 1=0 );
    
6-2. emp ���̺��� �� �μ��� �ش��ϴ� ���������  ������ ������ ���̺� INSERT �ϴ� ������ �ۼ��ϼ���.   
    INSERT ALL
        WHEN deptno = 10 THEN
            INTO tbl_emp10 VALUES ( empno, ename, job, mgr, hiredate, sal, comm, deptno )
        WHEN deptno = 20 THEN
            INTO tbl_emp20 VALUES ( empno, ename, job, mgr, hiredate, sal, comm, deptno )
        WHEN deptno = 30 THEN
            INTO tbl_emp30 VALUES ( empno, ename, job, mgr, hiredate, sal, comm, deptno )
        ELSE
            INTO tbl_emp40 VALUES ( empno, ename, job, mgr, hiredate, sal, comm, deptno )
    SELECT * FROM emp;
    
7. ������ �ִ� ���� INSERT ������  INSERT ALL �� INSERT FIRST ���� ���� �������� �����ϼ���.
INSERT ALL - ������ �����ϴ� ��� ���� �ִ´�
INSERT FIRST - ������ ���� ���� �����ϴ� ���� �ִ´�
-------------------------------------------------------------------------------
-- [ ����(MERGE) ]
    �� ������ �ǹ� : ��ġ��, �����ϴ�
    �� '������ ����' �ΰ��� ���̺��� ���Ͽ� �ϳ��� ���̺�� ��ġ�� ���� ������ �����̴�
    �� �Ϸ�(���ʸ���), �������� ���̺��� ���� ���� -> ������ ����
    ��   A                       B
      al    100(INSERT)     a2      200
      a2    200(UPDATE)     a3      200
    �� ���� ������ �ҽ��κ��� �پ��� �����͸� �����ؼ� �۾��� �����ϴ� dataware housing� �����ϸ� �����ϴ�. 
    �� �����ġ�
    MERGE [hint] INTO [schema.] {table ? view} [t_alias]
      USING {{[schema.] {table ? view}} ?
            subquery} [t_alias]
      ON (condition) [merge_update_clause] [merge_insert_clause] [error_logging_clause];
    
    ��merge_update_clause ���ġ�
       WHEN MATCHED THEN UPDATE SET {column = {expr ? DEFAULT},...}
         [where_clause] [DELETE where_clause]
    
    ��merge_insert_clause ���ġ�
       WHEN MATCHED THEN INSERT [(column,...)]
        VALUES ({expr,... ? DEFAULT}) [where_clause]
       
    ��where_clause ���ġ�
       WHERE condition
    
    ��error_logging_clause ���ġ�
       LOG ERROR [INTO [schema.] table] [(simple_expression)]
         [REJECT LIMIT {integer ? UNLIMITED}]

(�ǽ�)
CREATE TABLE tbl_emp(
    id      number          primary key, 
    name    varchar2(10)    not null,
    salary  number,
    bonus   number  default 100
);
-- Table TBL_EMP��(��) �����Ǿ����ϴ�.

insert into tbl_emp(id,name,salary) values(1001,'jijoe',150);
insert into tbl_emp(id,name,salary) values(1002,'cho',130);
insert into tbl_emp(id,name,salary) values(1003,'kim',140);
COMMIT;

SELECT *
FROM tbl_emp;

CREATE TABLE tbl_bonus(
    id number
    , bonus number default 100
);
-- Table TBL_BONUS��(��) �����Ǿ����ϴ�.

INSERT into tbl_bonus(id)
(select e.id from tbl_emp e);
COMMIT;

SELECT *
FROM tbl_bonus;

-- tbl_bonus ���̺�
id      bonus
1001	100
1002	100
1003	100
1004	50

-- tbl_emp ���̺�
id      name    salary  bonus
1001	jijoe	150	    100
1002	cho	    130	    100
1003	kim	    140	    100
      
INSERT INTO tbl_bonus VALUES( 1004, 50 );      
-- 1 �� ��(��) ���ԵǾ����ϴ�.
COMMIT;

-- ����(MERGE) tbl_emp + tbl_bonus �� ���̺� ����
MERGE INTO tbl_bonus b
USING ( SELECT id, salary FROM tbl_emp ) e
ON ( b.id = e.id )
WHEN MATCHED THEN
UPDATE SET b.bonus = b.bonus + e.salary * 0.01
WHEN NOT MATCHED THEN
INSERT ( b.id, b.bonus ) VALUES ( e.id, e.salary * 0.01 );
-- 3�� �� ��(��) ���յǾ����ϴ�.

DROP TABLE tbl_emp PURGE;
DROP TABLE tbl_bonus PURGE;

-- ���� [����]
CREATE TABLE tbl_merge1
    (
          id number primary key
        , name varchar2(20)
        , pay number
        , sudang number
    );

CREATE TABLE tbl_merge2
    (
        id number primary key
        , sudang number
    );
    
-- Table TBL_MERGE1��(��) �����Ǿ����ϴ�.
-- Table TBL_MERGE2��(��) �����Ǿ����ϴ�.

INSERT INTO tbl_merge1 ( id, name, pay, sudang ) VALUES ( 1, 'a', 100, 10 );
INSERT INTO tbl_merge1 ( id, name, pay, sudang ) VALUES ( 2, 'b', 150, 20 );
INSERT INTO tbl_merge1 ( id, name, pay, sudang ) VALUES ( 3, 'c', 130, 0 );

INSERT INTO tbl_merge2 ( id, sudang ) VALUES ( 2, 5 );
INSERT INTO tbl_merge2 ( id, sudang ) VALUES ( 3, 10 );
INSERT INTO tbl_merge2 ( id, sudang ) VALUES ( 4, 20 );

COMMIT;

SELECT *
FROM tbl_merge1;
1	a	100	10
2	b	150	20
3	c	130	0

SELECT *
FROM tbl_merge2;
2	5
3	10
4	20

-- [����] tbl_merge1�� tbl_merge2�� ���� ( id, sudang )
MERGE INTO tbl_merge2 b
USING ( SELECT id, sudang FROM tbl_merge1 ) a
ON ( a.id = b.id )
WHEN MATCHED THEN
UPDATE SET b.sudang = b.sudang + a.sudang
WHEN NOT MATCHED THEN
INSERT ( b.id, b.sudang ) VALUES ( a.id, a.sudang );

SELECT *
FROM tbl_merge2;
2	25
3	10
4	20
1	10

DROP TABLE tbl_merge1 PURGE;
DROP TABLE tbl_merge2 PURGE;
-------------------------------------------------------------------------------
 -- [ ��������(constraint) ]
 1. ���̺� �ο��� �������� Ȯ��
 SELECT *
 FROM user_constraints
 WHERE table_name = 'EMP';
        �������Ǹ�   ��������Ÿ��
SCOTT	PK_EMP	    P == PRIMARY KEY(����Ű)
SCOTT	FK_DEPTNO	R == FOREIGN KEY(�ܷ�Ű, ����Ű)

2. ��������( constraint )
    1) ���̺� ���ڵ�(��)�� �߰�, ����, ������ �� ����Ǵ� ��Ģ
    2) DATA INTERGRITY( ������ ���Ἲ ) == ������ ���� ������
    3) ���̺� ���� �����ǰ� �ִ� ��� ���̺��� ���� ������ ���ؼ��� ���ȴ�
    
    DELETE FROM dept
    WHERE deptno = 10;
    -- ORA-02292: integrity constraint (SCOTT.FK_DEPTNO) violated - child record found
    
    emp �ڽ����̺��� deptno = 10�� ��� 2�� ����( ���� )
    
3. ���������� ���� 5����
    1) PRIMARy KEY( PK ) == ������ Ű ��) deptno(PK) PK = NN + UK
    2) FOREIGN KEY( FK )
    3) UNIQUE KEY( UK )
    4) NOT NULL( NN )
    5) CHECK( CK )

4. ���������� ����ϴ� ����
    1) �������� ���� ���̺��� ������ �� �ִ�
       ������ ���������� ������ DML �����͸� ������ �� ��Ȱ���� �ʴ�
    2) �� �÷��� ���������� ������� �� �ִ�

5. DATA INTEGRITY�� 3���� ���� ( ������ ���Ἲ == ������ ���� ������, ��, ������ ������ )
    1) ��ü ���Ἲ( ENTITY I~ )
    - �����̼ǿ� ����Ǵ� Ʃ��(tuple, ��, ���ڵ�)�� ���ϼ��� �����ϱ� ���� ���������̴�
    - PK = NN + UK(���ϼ�)
      ���ڵ带 �����ϱ� ���� ������ Ű
      ��) emp ���̺��� �� ���(���ڵ�)�� ������ �� �ִ� ������ Ű, ��, PK�� �����ȣ(empno)
      7369 SMITH ��� ����
      -> 7369 ��� �߰� �Ұ�
      
    2) ���� ���Ἲ( RELATIONAL I~ )
    - �����̼�(���̺�) ���� �������� �ϰ����� �����ϱ� ���� ���������̴�
    ��) dept ���̺� - deptno( PK ) [����Ű] �����Ǵ� Ű
         emp ���̺� - deptno( FK ) [�ܷ�Ű] �����ϴ� Ű
    
    3) ������ ���Ἲ( DOMAIN I~ )
    - �Ӽ�(�÷�)���� ��� ������ ���� ������ �����ϱ� ���� ���������̴�
    ��) kor NUMBER(3)    ��� ������ ���� ����( 0<=  <=100 ) CK ���
            -999~999    
    - �Ӽ�(�÷�)�� ������ Ÿ��, ����, �⺻ Ű, ���ϼ�, null ���, ��� ���� ������ ���� �پ��� ���������� ������ �� �ִ�.

6. ���������� Ư¡
    ? DML �۾����� �߸��Ǵ� ���� �������ǿ� ���� �����Ѵ�.
    INSERT INTO emp( empno, ename ) VALUES( 7369, 'ADMIN' );
    1) ��ü���Ἲ ��Ģ�� ����
    ORA-00001: unique constraint (SCOTT.PK_EMP) violated
    7369 PK �����ȣ�� ���� ����� �����ϱ� ������
    2) �������Ἲ ��Ģ�� ����
    INSERT INTO emp( empno, ename, deptno ) VALUES( 1111, 'ADMIN', 90 );
    ORA-02291: integrity constraint (SCOTT.FK_DEPTNO) violated - parent key not found
    ? ��� ������ ������ ������ ����ȴ�.
    ���������� ����(�߰�)�ϸ� ������ ������ ����
    ? �������� disable, enable��ų �� �ִ�.
              ��Ȱ��ȭ  Ȱ��ȭ
    ? ó������� ��� ����ڿ��� �Ѱ�����.
    ? �� �÷��� ���� ���� ���������� ������ �� �ִ�.
    ? �ϳ��� �÷��Ӹ� �ƴ϶� ���� �÷��� �����Ͽ� �ϳ��� key�� �����ϴ� composit key(����Ű)�� ���� �� �ִ�. ��: PRIMARY KEY(pno, ename)
    ? ���������� ������ DB server�� ����Ѵ�.

7. ���Ἲ��������(Constraint) ����
    1) ���������� �����ϴ� 2���� ���
        ��. IN-LINE constraint ���(column level������ ��������)
        ��. OUT-OF-LINE constraint ���(Table level������ ��������)
            �� NOT NULL ���������� OUT-OF-LINE �������� ������δ� ������ �� ����
    2) �������� ���� ����
        ���̺� ������ �� �������� ����
        ���̺� ������ �� �������� ����

8. �������� �ǽ�
    1) tbl_constraint ���̺� Ȯ��
    SELECT *
    FROM tabs
    WHERE table_name LIKE '%CONSTRAINT%';
    
    2) tbl_constraint ���̺� ���� ������ �������� �߰� + �÷� ���� �Ǵ� ���̺� ���� ��� ���
    CREATE TABLE tbl_constraint
    (
          empno     NUMBER(4)
        , ename     VARCHAR2(20)
        , deptno    NUMBER(2)
        , kor       NUMBER(3)
        , email     VARCHAR2(250)
        , city      VARCHAR2(20)
    );
    -- Table TBL_CONSTRAINT��(��) �����Ǿ����ϴ�.
    
    3) ���������� �ϳ��� ���� �� ������ �ľ�
        (1) DML
        INSERT INTO tbl_constraint ( empno, ename, deptno, kor, email, city )
        VALUES ( null, null, null, null, null, null );
        -- 1 �� ��(��) ���ԵǾ����ϴ�.
        COMMIT;
       
        INSERT INTO tbl_constraint ( empno, ename, deptno, kor, email, city )
        VALUES ( 1111, 'ȫ�浿', 10, 100, 'hong@naver.com', null );
        -- 1 �� ��(��) ���ԵǾ����ϴ�.
        
        INSERT INTO tbl_constraint ( empno, ename, deptno, kor, email, city )
        VALUES ( 1111, '��ö��', 20, 90, 'park@naver.com', null );
        -- 1 �� ��(��) ���ԵǾ����ϴ�.

        SELECT *
        FROM tbl_constraint;
        --
        UPDATE tbl_constraint
        SET ename = '�����'
        WHERE empno = 1111;
        --
        DELETE tbl_constraint
        WHERE empno = 1111;
        
        -- ���������� ���ٺ��ϱ� �����ȣ 1111 ������ ������ �߰��Ǵ� ������ �߻�
        -- ����, ������ �� ����� ã�� ���� ��� ��� ����/�����Ǵ� ������ �߻�
        
     PK FK UK NN CK
    4) �������� �߰� : ���̺� ������ ��(����) + �÷� ���� ���(���)
    DROP TABLE tbl_constraint PURGE;

    CREATE TABLE tbl_constraint
    ( 
        -- PK ����) �÷��� ������Ÿ�� [CONSTRAINT PK_���̺��_�÷���] PRIMARY KEY(�÷���,...)
        -- [CONSTRAINT PK_���̺��_�÷���] �������Ǹ��� �����ϸ� �ڵ����� SYS_XXX �̸����� �ο��ȴ�
        -- ���߿� �������� ����, ��Ȱ��ȭ, Ȱ��ȭ �� �� �������Ǹ��� �˸� ���ϴ�
          empno     NUMBER(4)       NOT NULL    CONSTRAINT pk_tblconstraint_empno    PRIMARY KEY
        , ename     VARCHAR2(20)    NOT NULL
        -- dept ���̺��� deptno �÷��� �����ϴ� �ܷ�Ű(FK)�� ����
        -- FK ����) �÷��� ������Ÿ�� CONSTRAINT constraint��
        --          REFERENCES �������̺�� (�����÷���) 
        --          [ON DELETE CASCADE | ON DELETE SET NULL]
        , deptno    NUMBER(2)       NOT NULL    CONSTRAINT fk_tblconstraint_deptno REFERENCES dept( deptno )
        -- -999~999 -> 0~100 ���� ����
        -- CK ����) �÷��� ������Ÿ�� CONSTRAINT constraint�� CHECK(�÷��� ����)
        , kor       NUMBER(3)   CONSTRAINT ck_tblconstraint_kor CHECK( kor BETWEEN 0 AND 100 )
        -- ���ϼ�
        , email     VARCHAR2(250)   CONSTRAINT uk_tblconstraint_email UNIQUE
        -- ���� : ����, �λ�, ��õ
        -- CK ����) �÷��� ������Ÿ�� CONSTRAINT constraint�� CHECK(�÷��� ����)
        , city      VARCHAR2(20)    CONSTRAINT ck_tblconstraint_city CHECK( city IN ('����','�λ�','��õ') )
    );
    -- Table TBL_CONSTRAINT��(��) �����Ǿ����ϴ�.
    
    -- ORA-01400: cannot insert NULL into ("SCOTT"."TBL_CONSTRAINT"."EMPNO")
    -- NN �������� ������ INSERT X
    INSERT INTO tbl_constraint ( empno, ename, deptno, kor, email, city )
    VALUES ( null, 'KIM', 10, 90, 'kim@naver.com', '����' );
    
    -- ORA-02291: integrity constraint (SCOTT.FK_TBLCONSTRAINT_DEPTNO) violated - parent key not found
    -- FK �������� ������ INSERT X
    INSERT INTO tbl_constraint ( empno, ename, deptno, kor, email, city )
    VALUES ( 1001, 'KIM', 90, 90, 'kim@naver.com', '����' );
    
    -- ORA-02290: check constraint (SCOTT.CK_TBLCONSTRAINT_KOR) violated
    -- CK �������� ������ INSERT X
    INSERT INTO tbl_constraint ( empno, ename, deptno, kor, email, city )
    VALUES ( 1001, 'KIM', 10, 101, 'kim@naver.com', '����' );

    (1) PRIMARY KEY (PK)
        ? ���̺� ���� �⺻ Ű�� �����Ѵ�.
        ? �⺻Ű�� ���̺�� �ϳ��� �����Ѵ�.
          �׷���, �ݵ�� �ϳ��� �÷����θ� �����Ǵ� ���� �ƴϴ�.( ����Ű )
        ? ���̺��� �� ���� �����ϰ� �ĺ��ϴ� �÷� �Ǵ� �÷��� �����̴�.
          NULL ���� �Էµ� �� ����, �̹� ���̺� �����ϰ� �ִ� �����͸� �ٽ� �Է��� �� ����.
          ��, UNIQUE�� NOT NULL ���������� ������ �����̴�.
        ? [ UNIQUE INDEX ]�� �ڵ����� ����� ����. ***
          �����͸� select�� �� where���� ���� �������� INDEX�� �����Ǿ� �ִ� �÷��� ���Ǹ�
          ����Ŭ�� �ڵ����� �� INDEX�� ����Ͽ� �����͸� ������ ã�Ƴ���.
          �׷��Ƿ� �� ���� ���̺��� primary key�� �ϳ��ۿ� ������ �� ����.
          user_indexes �並 �̿��Ͽ� �ε����� Ȯ���� �� �ִ�.
        
        
        ���÷������� ���ġ�
            �÷��� ������Ÿ�� [CONSTRAINT constraint��] PRIMARY KEY(�÷���,...)
        �����̺����� ���ġ�
            �÷��� ������Ÿ��,
            �÷��� ������Ÿ��,
             ...
             [CONSTRAINT constraint��] PRIMARY KEY(�÷�1��, �÷�2��,...)
        ? constraint�� �߰��ÿ� constraint���� �����ϸ� ����Ŭ ������ �ڵ������� constraint���� �ο��Ѵ�.
        ? �Ϲ������� constraint���� '���̺��_�÷���_constraint����'ó�� ����Ѵ�.
    
    (2) FOREIGN KEY (FK)
        �� ���̺� A,B���� ���̺� B�� �⺻Ű�� ���̺�A�� �ܷ�Ű(Foreign key)�̴�.
        dept(deptno)    emp(deptno)
        �θ� (PK)          �ڽ�(FK)
        
        ? �θ�, �ڽ� ���̺��� �� ���̿� �ϰ����� �����ϱ� ���� ���������̴�.
        ? �θ� ���̺��� ������ ���ϴ� ���̰�, �ڽ� ���̺��� �����ϴ� ���̴�.
           ����Ű                          �ܷ�Ű(FK)
        ? FOREIGN KEY ���������� �����ϴ� �ڽ� ���̺��� �ϳ� �̻��� �÷��� ���� �����Ѵ�. �̶� �����Ǵ� ���̺��� �÷��� ���� ������Ÿ���� ���ƾ� �Ѵ�.(�θ� ���̺�� �ڽ� ���̺��� �����ϴ� �÷��� ���� ���ϴ� �÷��� ������ Ÿ���� ��ġ�ؾ� �Ѵ�.)
        ? �θ� ���̺��� ���� ������ �� �ڽ� ���̺�(foreign key�� �����ϴ� ���̺�)�� �����Ǿ�� �Ѵ�.
        ? FOREIGN KEY�� �θ� ���̺��� PRIMARY KEY, UNIQUE�� ������ �� �ְ�, �÷��� ���� ��ġ�ϰų� NULL ���̾�� �Ѵ�.
        ? ON DELETE CASCADE �ɼ��� �̿��ϸ� �θ� ���̺��� ���� ������ �� �̸� ������ �ڽ� ���̺��� ���� ���ÿ� ������ �� �ִ�.
        ? ON DELETE SET NULL�� �ڽ� ���̺��� �����ϴ� �θ� ���̺��� ���� �����Ǹ� �ڽ� ���̺��� ���� NULL ������ �����Ų��.
        ? ���� ���Ἲ �������ǿ��� �θ� ���̺��� ���� Ű �÷��� �������� �ʴ� ���� �ڽ� ���̺� �Է��ϸ� ������ �߻��Ѵ�.
        
        
        ���÷������� ���ġ�
                �÷��� ������Ÿ�� CONSTRAINT constraint��
            REFERENCES �������̺�� (�����÷���) 
                     [ON DELETE CASCADE | ON DELETE SET NULL]
        �����̺����� ���ġ�
                �÷��� ������Ÿ��,
                �÷��� ������Ÿ��,
                 ...
                CONSTRAINT constraint�� FOREIGN KEY(�÷�)
            REFERENCES �������̺�� (�����÷���)
                     [ON DELETE CASCADE | ON DELETE SET NULL]

    (4) CHECK (CK)
        �÷����� ��� ������ �������� ������ ������ �����ϱ� ���� ���������̴�.
        
        ? �ϳ��� �÷��� ���Ͽ� ���� ���� CHECK ���Ἲ ���������� ������ �� �ִ�.
        ? CURRVAL, NEXTVAL�� ���� ���� �÷��̳� SYSDATE, USER�� ���� �Լ��� ����� �� ����.
        ? ���� ���̺��� �÷����� �ٸ� ���� ������ �� �ִ�.
        ? �÷��� �ԷµǴ� �����͸� �˻��ؼ� ���ǿ� �´� �����͸� �Էµǵ��� �Ѵ�.
        ? ������ where���� �����ϰ� �ش� �÷��� ����Ǵ� ������ ���� ����, Ư�� ������ ���� �Ǵ� ���ڿ��Ӹ� �ƴ϶� ���� ���̺� ���� �ٸ� �÷��� ������ �� �ִ�.
        ? row(��)�� �����ؾ� �ϴ� ������ �����Ѵ�.
        ? user_constraints ���� constraint_type���� CHECK ���������̳�, NOT NULL ���������� ��� C�� ǥ�õ�����, ��ü������ Ȯ���ϱ� ���ؼ� search_condition �÷��� ������ Ȯ���� �� �ִ�.
        
        
        ���÷������� ���ġ�
                �÷��� ������Ÿ�� CONSTRAINT constraint�� CHECK(�÷��� ����)
        �����̺����� ���ġ�
                �÷��� ������Ÿ��,
                �÷��� ������Ÿ��,
                 ...
                CONSTRAINT constraint��  CHECK(�÷��� ����)

    5) �������� �߰� : ���̺� ������ ��(����) + ���̺� ���� ���(���)
    DROP TABLE tbl_constraint PURGE;

    CREATE TABLE tbl_constraint
    ( 
          empno     NUMBER(4)       NOT NULL
        , ename     VARCHAR2(20)    NOT NULL
        , deptno    NUMBER(2)       NOT NULL
        , kor       NUMBER(3)   
        , email     VARCHAR2(250)   
        , city      VARCHAR2(20)    
        
        -- �ش� ���̺� �������� �߰� -> � �÷����� PK, UK, FK �������� �÷��� �߰�
        , CONSTRAINT pk_tblconstraint_empno    PRIMARY KEY( empno )
        , CONSTRAINT fk_tblconstraint_deptno FOREIGN KEY( deptno ) REFERENCES dept( deptno )
        , CONSTRAINT ck_tblconstraint_kor CHECK( kor BETWEEN 0 AND 100 )
        , CONSTRAINT uk_tblconstraint_email UNIQUE( email )
        , CONSTRAINT ck_tblconstraint_city CHECK( city IN ('����','�λ�','��õ') )
    );
    -- Table TBL_CONSTRAINT��(��) �����Ǿ����ϴ�.
    
    ����Ű == PK = �÷�1 + �÷�2 + ...
    , CONSTRAINT pk_tblconstraint_empno    PRIMARY KEY( empno, ename )
    
    ����Ű�� �ʿ��� ����
    [ �޿� ���� ���̺� ]
    PK � �÷� ���� ? ���ڵ�(��)�� ������ �� �ִ� ������ Ű, ���ڵ� ����
    �����ȣ(PK), ������, �޿���, ���ʽ�, ...
    
    ����Ű( �����ȣ + ���޳�¥ )
    , CONSTRAINT pk_�޿��������̺�_empno    PRIMARY KEY( �����ȣ, ������ ) -> ������ȭ? ( ���� ������ )

-- �÷� ���� ���, ���̺� ���� ������� �������� + ���̺� ����
-- Table TBL_CONSTRAINT��(��) �����Ǿ����ϴ�.

-- �������� Ȯ��
SELECT *
FROM user_constraints
WHERE table_name = 'TBL_CONSTRAINT';

-- �������� �̸�, Ÿ��
SCOTT	SYS_C007099	C	TBL_CONSTRAINT	"EMPNO" IS NOT NULL
SCOTT	SYS_C007100	C	TBL_CONSTRAINT	"ENAME" IS NOT NULL
SCOTT	SYS_C007101	C	TBL_CONSTRAINT	"DEPTNO" IS NOT NULL

C - NN, CK
SCOTT	CK_TBLCONSTRAINT_KOR	C	TBL_CONSTRAINT	 kor BETWEEN 0 AND 100 
SCOTT	CK_TBLCONSTRAINT_CITY	C	TBL_CONSTRAINT	 city IN ('����','�λ�','��õ') 

P - PK
SCOTT	PK_TBLCONSTRAINT_EMPNO	P	TBL_CONSTRAINT	

U - UK
SCOTT	UK_TBLCONSTRAINT_EMAIL	U	TBL_CONSTRAINT	

R - FK
SCOTT	FK_TBLCONSTRAINT_DEPTNO	R	TBL_CONSTRAINT	

-- PK ���������� ����(����)
-- 1. ���������� ������ �� ���� ( ���� �� �ٽ� �߰� )
-- 2. ���̺��� �����ϸ� �� ���� �������ǵ� ���� / �������Ǹ� ���� ����
-- 3. PK ���������� ������ ���� �������Ǹ��� ���� �ȴ� ( 1�� �ۿ� ���� ������ )

���1)
ALTER TABLE ���̺�� 
DROP [CONSTRAINT constraint�� | PRIMARY KEY | UNIQUE(�÷���)]
[CASCADE];

CASCADE�ɼ��� �����ϴ� FOREIGN KEY�� ���� �� ����Ѵ�.
    ��.
    ALTER TABLE tbl_constraint
    DROP CONSTRAINT pk_tblconstraint_empno;
    -- Table TBL_CONSTRAINT��(��) ����Ǿ����ϴ�.
    ��.
    ALTER TABLE tbl_constraint
    DROP primary key;
    
    -- UNIQUE �������� : email ����
    ALTER TABLE tbl_constraint
    DROP UNIQUE( email );
    -- Table TBL_CONSTRAINT��(��) ����Ǿ����ϴ�.

���2) X
DROP TABLE ���̺�� CASCADE CONSTRAINTS;

���̺�� �� ���̺��� �����ϴ� foreign key�� ���ÿ� ������ �� �ִ�.

���3) X
DROP TABLESPACE ���̺����̽��� 
INCLUDING CONTENTS
CASCADE CONSTRAINTS;

 -- ������� ���̺� ���������� �߰�
    1) PK ���� ���� �߰�
    ���̺� ���� �Ŀ� constraint�� �߰��� ���̺� ������ �ؾ� �Ѵ�.
    ALTER TABLE tbl_constraint
     ADD (
        CONSTRAINT pk_tblconstraint_empno PRIMARY KEY( empno )
        , CONSTRAINT uk_tblconstraint_email UNIQUE( email )
        );
    -- Table TBL_CONSTRAINT��(��) ����Ǿ����ϴ�.
    
    -- �������� ��Ȱ��ȭ/Ȱ��ȭ
    ALTER TABLE ���̺��
    ENABLE | DISABLE CONSTRAINT �������Ǹ�
    --
    ���÷������� ���ġ�
    �÷��� ������Ÿ�� CONSTRAINT constraint��
	REFERENCES �������̺�� (�����÷���) 
             [ON DELETE CASCADE | ON DELETE SET NULL]
    
    ��. ON DELETE CASCADE : �θ� ���̺��� ���� ������ �� �̸� ������ �ڽ� ���̺��� ���� ���ÿ� ������ �� �ִ�
    ��. ON DELETE SET NULL : �ڽ� ���̺��� �����ϴ� �θ� ���̺��� ���� �����Ǹ� �ڽ� ���̺��� ���� NULL ������ �����Ų��
    
    -- �ǽ� --
    emp -> tbl_emp ����
    dept -> tbl_dept ����
    --
    SELECT *
    FROM tabs
    WHERE table_name LIKE 'TBL_%';
    --
    CREATE TABLE tbl_emp
    AS
        (
            SELECT *
            FROM emp
        );
    -- Table TBL_EMP��(��) �����Ǿ����ϴ�.
    
    CREATE TABLE tbl_dept
    AS
        (
            SELECT *
            FROM dept
        );
    -- Table TBL_DEPT��(��) �����Ǿ����ϴ�.
    
    -- NN ���������� ���簡 ������ �� �� ���������� ������� �ʴ´�
    SELECT *
    FROM user_constraints
    WHERE table_name = 'TBL_DEPT';
    -- empno �������� PK �߰�
    ALTER TABLE tbl_emp
    ADD ( CONSTRAINT pk_tblemp_empno PRIMARY KEY( empno ) );
    -- deptno �������� PK �߰�
    ALTER TABLE tbl_dept
    ADD ( CONSTRAINT pk_tblemp_deptno PRIMARY KEY( deptno ) );
    
    -- tbl_emp ���̺�
    �÷��� ������Ÿ�� CONSTRAINT constraint��
	REFERENCES �������̺�� (�����÷���) 
             [ON DELETE CASCADE | ON DELETE SET NULL]
    
    ��. ON DELETE CASCADE : �θ� ���̺��� ���� ������ �� �̸� ������ �ڽ� ���̺��� ���� ���ÿ� ������ �� �ִ�
    ��. ON DELETE SET NULL : �ڽ� ���̺��� �����ϴ� �θ� ���̺��� ���� �����Ǹ� �ڽ� ���̺��� ���� NULL ������ �����Ų��
    
    1) �׽�Ʈ ��, �� �ɼ� X
    ALTER TABLE tbl_emp
    ADD ( CONSTRAINT fk_tblemp_deptno FOREIGN KEY( deptno ) REFERENCES tbl_dept( deptno ) );
    --
    SELECT *
    FROM tbl_dept;
    --
    DELETE FROM tbl_dept
    WHERE deptno = 30;
    -- ORA-02292: integrity constraint (SCOTT.FK_TBLEMP_DEPTNO) violated - child record found
    -- ���Ἲ FK �������� ����
    -- 30�� �μ��� �����ϰ� �ִ� emp ���̺��� ������� �����ϱ� ������ ������ �� ����
    
    ALTER TABLE tbl_emp
    DROP CONSTRAINT fk_tblemp_deptno;
    -- Table TBL_EMP��(��) ����Ǿ����ϴ�.
    
    2) �׽�Ʈ ��. ON DELETE CASCADE -- dept/30 ���� -> emp/30 ��� ����
    ALTER TABLE tbl_emp
    ADD ( CONSTRAINT fk_tblemp_deptno FOREIGN KEY( deptno ) REFERENCES tbl_dept( deptno ) ON DELETE CASCADE );
    --
    SELECT *
    FROM tbl_emp;
    FROM tbl_dept;
    --
    DELETE FROM tbl_dept
    WHERE deptno = 30;
    -- 1 �� ��(��) �����Ǿ����ϴ�.
    ROLLBACK;
    
    3) �׽�Ʈ ��. ON DELETE SET NULL -- dept/30 ���� -> emp/30 deptno = null
    ALTER TABLE tbl_emp
    ADD ( CONSTRAINT fk_tblemp_deptno FOREIGN KEY( deptno ) REFERENCES tbl_dept( deptno ) ON DELETE SET NULL );
-------------------------------------------------------------------------------
-- [ ����( join ) ]
    �� ���ų� ���� �ٸ� �� �� �̻��� ���̺��� �÷��� �˻�(��ȸ) �� �� ����Ѵ�
��) deptno, dname, ename, hiredate
    deptno, dname           : dept
    deptno, ename, hiredate : emp
    
    SELECT d.deptno, dname, ename, hiredate
    FROM dept d, emp e
    WHERE d.deptno = e.deptno;
    
    -- join sql
    
    -- 1) å ���̺�
      CREATE TABLE book(
           b_id     VARCHAR2(10)    NOT NULL PRIMARY KEY   -- åID
          ,title      VARCHAR2(100) NOT NULL  -- å ����
          ,c_name  VARCHAR2(100)    NOT NULL     -- c �̸�
      --    ,  price  NUMBER(7) NOT NULL
     );
    -- Table BOOK��(��) �����Ǿ����ϴ�.
    INSERT INTO book (b_id, title, c_name) VALUES ('a-1', '�����ͺ��̽�', '����');
    INSERT INTO book (b_id, title, c_name) VALUES ('a-2', '�����ͺ��̽�', '���');
    INSERT INTO book (b_id, title, c_name) VALUES ('b-1', '�ü��', '�λ�');
    INSERT INTO book (b_id, title, c_name) VALUES ('b-2', '�ü��', '��õ');
    INSERT INTO book (b_id, title, c_name) VALUES ('c-1', '����', '���');
    INSERT INTO book (b_id, title, c_name) VALUES ('d-1', '����', '�뱸');
    INSERT INTO book (b_id, title, c_name) VALUES ('e-1', '�Ŀ�����Ʈ', '�λ�');
    INSERT INTO book (b_id, title, c_name) VALUES ('f-1', '������', '��õ');
    INSERT INTO book (b_id, title, c_name) VALUES ('f-2', '������', '����');
    
    COMMIT;
    
    SELECT *
    FROM book;

  -- 2) �ܰ� ���̺�
  CREATE TABLE danga(
      b_id  VARCHAR2(10)  NOT NULL  -- PK , FK
      ,price  NUMBER(7) NOT NULL    -- å ����
      
      ,CONSTRAINT PK_dangga_id PRIMARY KEY(b_id)
      ,CONSTRAINT FK_dangga_id FOREIGN KEY (b_id)
              REFERENCES book(b_id)
              ON DELETE CASCADE
    );
    -- Table DANGA��(��) �����Ǿ����ϴ�.
    
    INSERT INTO danga (b_id, price) VALUES ('a-1', 300);
    INSERT INTO danga (b_id, price) VALUES ('a-2', 500);
    INSERT INTO danga (b_id, price) VALUES ('b-1', 450);
    INSERT INTO danga (b_id, price) VALUES ('b-2', 440);
    INSERT INTO danga (b_id, price) VALUES ('c-1', 320);
    INSERT INTO danga (b_id, price) VALUES ('d-1', 321);
    INSERT INTO danga (b_id, price) VALUES ('e-1', 250);
    INSERT INTO danga (b_id, price) VALUES ('f-1', 510);
    INSERT INTO danga (b_id, price) VALUES ('f-2', 400);
    
    COMMIT;
    
    SELECT *
    FROM danga;

      ���ǻ� -> [ ����(��) ]-> ��(�Ϲ� �����)
           �Ǹ�             �Ǹ�
     -- 3) �� ���̺�  
     CREATE TABLE gogaek(
          g_id       NUMBER(5) NOT NULL PRIMARY KEY 
          ,g_name   VARCHAR2(20) NOT NULL
          ,g_tel      VARCHAR2(20)
    );
     
    INSERT INTO gogaek (g_id, g_name, g_tel) VALUES (1, '�츮����', '111-1111');
    INSERT INTO gogaek (g_id, g_name, g_tel) VALUES (2, '���ü���', '111-1111');
    INSERT INTO gogaek (g_id, g_name, g_tel) VALUES (3, '��������', '333-3333');
    INSERT INTO gogaek (g_id, g_name, g_tel) VALUES (4, '���Ｍ��', '444-4444');
    INSERT INTO gogaek (g_id, g_name, g_tel) VALUES (5, '��������', '555-5555');
    INSERT INTO gogaek (g_id, g_name, g_tel) VALUES (6, '��������', '666-6666');
    INSERT INTO gogaek (g_id, g_name, g_tel) VALUES (7, '���ϼ���', '777-7777');
    
    COMMIT;
    
    SELECT *
    FROM gogaek;
     
     -- 4) �Ǹ� ���̺� 
     CREATE TABLE panmai(
           id         NUMBER(5) NOT NULL PRIMARY KEY
          ,g_id       NUMBER(5) NOT NULL CONSTRAINT FK_PANMAI_GID
                         REFERENCES gogaek(g_id) ON DELETE CASCADE
          ,b_id       VARCHAR2(10)  NOT NULL CONSTRAINT FK_PANMAI_BID
                         REFERENCES book(b_id) ON DELETE CASCADE
          ,p_date     DATE DEFAULT SYSDATE
          ,p_su       NUMBER(5)  NOT NULL
    );
    
    INSERT INTO panmai (id, g_id, b_id, p_date, p_su) VALUES (1, 1, 'a-1', '2000-10-10', 10);
    INSERT INTO panmai (id, g_id, b_id, p_date, p_su) VALUES (2, 2, 'a-1', '2000-03-04', 20);
    INSERT INTO panmai (id, g_id, b_id, p_date, p_su) VALUES (3, 1, 'b-1', DEFAULT, 13);
    INSERT INTO panmai (id, g_id, b_id, p_date, p_su) VALUES (4, 4, 'c-1', '2000-07-07', 5);
    INSERT INTO panmai (id, g_id, b_id, p_date, p_su) VALUES (5, 4, 'd-1', DEFAULT, 31);
    INSERT INTO panmai (id, g_id, b_id, p_date, p_su) VALUES (6, 6, 'f-1', DEFAULT, 21);
    INSERT INTO panmai (id, g_id, b_id, p_date, p_su) VALUES (7, 7, 'a-1', DEFAULT, 26);
    INSERT INTO panmai (id, g_id, b_id, p_date, p_su) VALUES (8, 6, 'a-1', DEFAULT, 17);
    INSERT INTO panmai (id, g_id, b_id, p_date, p_su) VALUES (9, 6, 'b-1', DEFAULT, 5);
    INSERT INTO panmai (id, g_id, b_id, p_date, p_su) VALUES (10, 7, 'a-2', '2000-10-10', 15);
    
    COMMIT;
    
    SELECT *
    FROM panmai;
    
     -- 5) ���� ���̺�
     CREATE TABLE au_book(
           id   number(5)  NOT NULL PRIMARY KEY
          ,b_id VARCHAR2(10)  NOT NULL  CONSTRAINT FK_AUBOOK_BID
                REFERENCES book(b_id) ON DELETE CASCADE
          ,name VARCHAR2(20)  NOT NULL
    );
    
    INSERT INTO au_book (id, b_id, name) VALUES (1, 'a-1', '���Ȱ�');
    INSERT INTO au_book (id, b_id, name) VALUES (2, 'b-1', '�տ���');
    INSERT INTO au_book (id, b_id, name) VALUES (3, 'a-1', '�����');
    INSERT INTO au_book (id, b_id, name) VALUES (4, 'b-1', '������');
    INSERT INTO au_book (id, b_id, name) VALUES (5, 'c-1', '������');
    INSERT INTO au_book (id, b_id, name) VALUES (6, 'd-1', '���ϴ�');
    INSERT INTO au_book (id, b_id, name) VALUES (7, 'a-1', '�ɽ���');
    INSERT INTO au_book (id, b_id, name) VALUES (8, 'd-1', '��÷');
    INSERT INTO au_book (id, b_id, name) VALUES (9, 'e-1', '���ѳ�');
    INSERT INTO au_book (id, b_id, name) VALUES (10, 'f-1', '������');
    INSERT INTO au_book (id, b_id, name) VALUES (11, 'f-2', '�̿���');
    
    COMMIT;
    
    SELECT * 
    FROM au_book;
    
3. JOIN ����

? EQUI JOIN :
�� �� �̻��� ���̺� ����Ǵ� �÷����� ������ ��ġ�ϴ� ��쿡 ����ϴ� ���� �Ϲ����� join ������,
WHERE ���� '='(��ȣ)�� ����Ѵ�.
���� primary key, foreign key ���踦 �̿��Ѵ�.
����Ŭ������ NATURAL JOIN�� EQUI JOIN�� �����ϴ�.
�Ǵ� USING ���� ����Ͽ� EQUI JOIN�� ������ ����� ����Ѵ�

[����] åID, å����, ��������( c_name ), �ܰ� ���
BOOK : b_id, title, c_name
DANGA : b_id, price

1) ��ü��.�÷���
SELECT book.b_id, book.title, book.c_name, danga.price
FROM book, danga
WHERE book.b_id = danga.b_id;

2) ��Ī(alias).�÷���
SELECT b.b_id, b.title, b.c_name, d.price
FROM book b, danga d
WHERE b.b_id = d.b_id; -- ��������(EQUI JOIN)

2-2) ��Ī(alias).�÷���
SELECT b.b_id, title, c_name, price
FROM book b, danga d
WHERE b.b_id = d.b_id; -- ��������(EQUI JOIN)

3) JOIN ~ ON ����
SELECT b.b_id, b.title, b.c_name, d.price
FROM book b JOIN danga d ON b.b_id = d.b_id;

4) USING ��
SELECT b_id, title, c_name, price
FROM book JOIN danga USING( b_id );
-- USING() ���� ����� ���� ��ü��.�÷��� �Ǵ� ��Ī��.�÷����� ������� �ʴ´�

5) NATURAL JOIN ����
SELECT b_id, title, c_name, price
FROM book NATURAL JOIN danga;

[����] å�ڵ�(b_id), å��(title), ����(p_su), �ܰ�(price), ������(g_name), �Ǹűݾ�(p_su*price) ���

1)
SELECT b.b_id, b.title, p.p_su, d.price, g.g_name, p.p_su * d.price
FROM book b, panmai p, danga d, gogaek g
WHERE b.b_id = p.b_id
  AND b.b_id = d.b_id
  AND p.g_id = g.g_id;

2)
SELECT b.b_id, b.title, p.p_su, d.price, g.g_name, p.p_su * d.price
FROM book b JOIN panmai p ON b.b_id = p.b_id
            JOIN danga d ON b.b_id = d.b_id
            JOIN gogaek g ON p.g_id = g.g_id;
            
3)
SELECT b_id, title, p_su, price, g_name, p_su * price
FROM book JOIN panmai USING( b_id )
            JOIN danga USING( b_id )
            JOIN gogaek USING( g_id );
            
? NON-EQUI JOIN :
����Ǵ� �÷��� ��Ȯ�� ��ġ���� �ʴ� ��쿡 ���Ǵ� JOIN�� �����̴�.
WHERE ���� BETWEEN ... AND ... �����ڸ� ����Ѵ�.
����Ŭ������ ON ���� �̿��Ͽ� NON-EQUI JOIN�� ������ ������ �����Ѵ�.

1)
SELECT ename, sal, losal, hisal, grade
FROM emp e, salgrade s
WHERE e.sal BETWEEN s.losal AND s.hisal;

2) JOIN ~ ON ����
SELECT ename, sal, losal, hisal, grade
FROM emp e JOIN salgrade s ON e.sal BETWEEN s.losal AND s.hisal;
      
? INNER JOIN :
simple join�̶�� �ϸ�, �� �̻��� ���̺��� join condition�� �����ϴ� �ุ ��ȯ�Ѵ�.     

SELECT *      
FROM emp;
-- ������� deptno : 10(2), 20(3), 30(6),       null(1) X
SELECT *
FROM dept;
-- �μ��� deptno : 10, 20, 30,     40 X

SELECT d.deptno, ename, hiredate
FROM emp e JOIN dept d ON e.deptno = d.deptno; -- EQUI JOIN, INNER JOIN

? OUTER JOIN :
JOIN ������ �������� �ʴ� ���� ���� ���� �߰����� join�� �����̴�.
�Ϲ����� join���� ���� �� ���� �����͸� ���ϰ� ���� �� ����ϸ�, '(+)' �����ڸ� ����Ѵ�.
����Ŭ������ LEFT(RIGHT) OUTER JOIN�� OUTER JOIN�̴�.
FULL OUTER JOIN�� ���� �������� UNION�� �̿��� ����� ������ ����� ��´�.

LEFT [OUTER] JOIN        

SELECT d.deptno, ename, hiredate
FROM emp e LEFT OUTER JOIN dept d ON e.deptno = d.deptno;
-- null	KING	81/11/17

RIGHT [OUTER] JOIN

SELECT d.deptno, ename, hiredate
FROM emp e RIGHT OUTER JOIN dept d ON e.deptno = d.deptno;
-- 40	null	null

FULL [OUTER] JOIN

SELECT d.deptno, ename, hiredate
FROM emp e FULL OUTER JOIN dept d ON e.deptno = d.deptno;
-- null	KING	81/11/17
-- 40	null	null

? SELF JOIN :
�ڽ��� ���̺��� alias�� ����Ͽ� ��ġ �� ���� ���̺���ó�� JOIN�ϴ� �����̴�.
����Ŭ������ JOIN �� ON ���� �̿��Ͽ� SELF JOIN�� ������ ������ �����Ѵ�.

SELECT deptno, empno, ename, ���ӻ���� �����ȣ, �����, �μ���
FROM emp;

SELECT *
FROM dept;

SELECT a.deptno, a.empno, a.ename, b.empno, b.ename, b.deptno
FROM emp a JOIN emp b ON a.mgr = b.empno;

? CROSS JOIN :
Cartesian Product�� ������ ����� ����.
�� cartesian product�� �ſ� ���� ���� �����ϹǷ� ���� �幰�� ���ȴ�.
�� ���̺� ���� 100���� ���� ������ �ִٸ�, 10000���� cartesian product ����� �����Ǳ� �����̴�.

Cartesian Product == ��ī��Ʈ �� == ����A �� ����B�� ������

SELECT e.*, d.*
FROM emp e, dept d;
--     12  *   4  ==  48

? ANTIJOIN : 
���������� ��� �ӿ� �ش� �÷��� �������� �ʴ� ���� NOT IN�� �����

SELECT
WHERE IN ()
WHERE EXISTS ( �������� )

SELECT d.deptno, d.dname
FROM dept d
WHERE deptno NOT IN (
    SELECT deptno
    FROM emp e
    WHERE e.sal > 2800
);



? SEMIJOIN :
���������� ��� �ӿ� �ش� �÷��� �����ϴ� ���� EXISTS�� �����

SELECT
WHERE IN ()
WHERE EXISTS ( �������� )

SELECT d.deptno, d.dname
FROM dept d
WHERE EXISTS (
    SELECT *
    FROM emp e
    WHERE d.deptno = e.deptno AND e.sal > 2800
);

SELECT d.deptno, d.dname
FROM dept d
WHERE deptno IN (
    SELECT deptno
    FROM emp e
    WHERE e.sal > 2800
);

-- JOIN ON ���� == ǥ��(ANSI) ���� == ANSI JOIN
-------------------------------------------------------------------------------
[����] åID, å����, �Ǹż���, �ܰ�, ������(��), �Ǹűݾ�(�Ǹż���*�ܰ�) ���
SELECT b.b_id, title, p_su, price, g_name, p_su * price 
FROM book b, panmai p, danga d, gogaek g
WHERE b.b_id = p.b_id
  AND b.b_id = d.b_id
  AND p.g_id = g.g_id;

[����] ���ǵ� å���� ���� �� ����� �ǸŵǾ����� ��ȸ
    (    åID, å����, ���ǸűǼ�, �ܰ� �÷� ��� )

SELECT b.b_id, title, SUM( p_su ) ���ǸűǼ�, price
FROM panmai p JOIN book b ON p.b_id = b.b_id
              JOIN danga d ON b.b_id = d.b_id
GROUP BY b.b_id, title, price
ORDER BY b.b_id;

id g_id b_id p_date     p_su
1	1	a-1	00/10/10	10
2	2	a-1	00/03/04	20
3	1	b-1	23/03/27	13
4	4	c-1	00/07/07	5
5	4	d-1	23/03/27	31
6	6	f-1	23/03/27	21
7	7	a-1	23/03/27	26
8	6	a-1	23/03/27	17
9	6	b-1	23/03/27	5
10	7	a-2	00/10/10	15

[����] ���� �ǸűǼ��� ���� �� ��ȸ
- TOP-N ���
    ���� : ���ǸűǼ� DESC
    ROWNUM ���� = 1
    
SELECT ROWNUM, t.*
FROM (
SELECT b.b_id, title, SUM( p_su ) ���ǸűǼ�, price
FROM panmai p JOIN book b ON p.b_id = b.b_id
              JOIN danga d ON b.b_id = d.b_id
GROUP BY b.b_id, title, price
ORDER BY ���ǸűǼ� DESC
) t
WHERE ROWNUM = 1;

- RANK �Լ�

SELECT t.*
FROM (
SELECT b.b_id, title, SUM( p_su ) ���ǸűǼ�, price
     , RANK() OVER( ORDER BY SUM( p_su ) DESC ) �Ǹż���
FROM panmai p JOIN book b ON p.b_id = b.b_id
              JOIN danga d ON b.b_id = d.b_id
GROUP BY b.b_id, title, price
ORDER BY ���ǸűǼ� DESC
) t
WHERE t.�Ǹż��� <= 1;

[����] book ���̺��� �ǸŰ� �� ���� ���� å�� ���� ��ȸ

SELECT b.b_id, title, price
FROM book b JOIN danga d ON b.b_id = d.b_id
WHERE b.b_id NOT IN ( SELECT DISTINCT b_id FROM panmai ); -- ��Ƽ ����
              
[����] book ���̺��� �ǸŰ� �� ���� �ִ� å�� ���� ��ȸ
    ( b_id, title, price �÷� ��� )

-- �Ǹ����̺� ��ȸ
SELECT b.b_id, title, price
FROM book b JOIN danga d ON b.b_id = d.b_id
WHERE b.b_id IN ( SELECT DISTINCT b_id FROM panmai ); -- ���� ����
--
SELECT a.b_id, a.title, price
FROM book a JOIN ( SELECT DISTINCT b_id FROM panmai ) b ON a.b_id = b.b_id
            JOIN danga d ON a.b_id = d.b_id;
-------------------------------------------------------------------------------
























































