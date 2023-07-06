-- SCOTT --
-- ���� ���� Ǯ�� --
--------------------------------------------------------------------------------
 * ��������(subquery) ?  ����(sql) �ӿ� ����
   ������ �Ǵٸ� SQL ������ nested�� ���� subquery�� �Ѵ�.
   �� SQL �� �ӿ� �� �ٸ� SQL���� �־��� �ִ� ����̴�
  * main(parent) query
    sub(child) query
    (1) main query�� sub query �� ���谡 ���� ���
    (2)              "                  �ִ� ��� - [��� ���� ����(correlated subquery)]
  * ����
    (1) �Ϲ� ��������
    (2) �ζ��� ��    - FROM �� + ��������
    (3) ��ø(NESTED) �������� - WHERE ��  + ��������
  
1. �ζ��κ�(inline view)�� ���ؼ� �����ϼ���.
   - subquery �ڿ��� �ݵ�� alias�� �ش�. ( ������ ��� )
   - FROM���� ��ġ�� subquery�� �ϳ��� ���̺�ó�� ���ȴ�.
   
2. WITH ���� ���ؼ� �����ϼ���.
    ? ���� ���Ǵ� query�� ����ϱ� ���� with ���� �̸� query block���� ������ �� ����Ѵ�.
    ? �������������� sub query�� ���� ����� ����� ���� main query�� ����Ǳ� ������ ������������ ������ ���ϵȴ�.
    ? With ���� ���� ���������� ���� ���� �����ϰ� ����� �� �ְ� �Ѵ�.
    ? WITH ���� ���� ���� sub query�� �ϳ��� main query���� ���� �� ����� ���⼺�� ���� �����ϰ� �����Ͽ� ��������ν� ������������ �߻��� �� �ִ� �������� ������ ������ �� �ִ�.
    ? ����, �ϳ��� main query�� ���ǵ� sub query�� with ���� �Բ� �����ϰ�, ������ sub query�� ���ǵ� �� sub query�� ����� �ζ��� ���� �̸��� ����ڰ� ������ �����Ѵ�. ���� ���� sub query�� ���ȴٸ� ������� �����ϸ� �ȴ�.
    ? sub query�� ������ ������, ������ ����� main query���� �ۼ��ϴµ�, �ʿ��� sub query�� �ζ��� ���� �̸����� ���ο� sub query�� �ۼ��Ͽ� ����Ѵ�. 
    �����ġ�
        WITH  query1�̸� AS (subquery1),
              query2�̸� AS (subquery2), ...
    
    ?? with�� �ӿ� �ݵ�� select ���� �־�� ��
    ?? query��� ������ ���̺���� �����ϰ� ���Ǵ� ���, ���� ������ �켱��
    ?? �ϳ��� with���� ���� ���� query block ����� �����ϴ�.
    ?? with���� �ҷ��� ����ϴ� body ���������� block���� �켱�ǹǷ� ���̺���� ����� �� ����.
    ?? with�� ���� �� �ٸ� with���� ������ �� ����.
    ?? set operator�� ����� ���������� ����� �� ����.

3. �������� ��� [Oracle �Լ�]�� ���� �����ϼ��� .
  ��. UPPER(), LOWER()
  ��. NVL(), NVL2()
  ��. TO_CHAR()
  ��. SUBSTR()
  ��. CONCAT()
  
11:02 ��������~~   
3-2. �������� ��� ����Ŭ�� ������(operator)�� ��������.  
  ��.  �񱳿�����    =   != <>  ^=  >=  <=
  ��.  ��������    AND OR NOT
  ��.  SQL ������
        [NOT] IN( list )
        [NOT] BETWEEN a AND b
        IS [NOT] NULL

4.insa ���̺��� ������� ���� �μ����� �ߺ����� �ʰ� �Ʒ��� ����
    �μ��� �������� ����( ASC )�ؼ� ����ϼ���.    
SELECT �� :    DISTINCT , ALL,  AS  ��밡��
    
SELECT DISTINCT buseo    
FROM insa
ORDER BY buseo; 
ORDER BY buseo ASC;    
ORDER BY 1 ASC;    
    
5.insa���̺��� ssn �÷��� ���ؼ� year, month, date, gender ���
-- date Ű����(�����)
-- 1) ����Ŭ ����� Ȯ�� - date ����� Ȯ��.
    -- 4) SYS ���� 
    SELECT * 
    FROM DICTIONARY
    WHERE table_name LIKE '%WORDS%';
    --  date Ű���� Ȯ��
    SELECT *
    FROM V$RESERVED_WORDS
    WHERE keyword = UPPER( 'date' );
    -- WHERE keyword = UPPER( :kw );
    ; -- ����

SELECT ssn
    , SUBSTR( ssn, 0, 2)  AS "YEAR"    --    , SUBSTR( ssn, 1, 2)
    , SUBSTR( ssn, 3, 2)  month
    -- ORA-00923: FROM keyword not found where expected
    , SUBSTR( ssn, 5, 2) "DATE"
    , SUBSTR( ssn, 8, 1) gender
FROM insa;

      SSN          YEAR MONTH DATE GENDER  
    ---------- ------ ---- ----- -----
    771212-1022432	77	12	12	1
    801007-1544236	80	10	07	1
    770922-2312547	77	09	22	2
    790304-1788896	79	03	04	1
    811112-1566789	81	11	12	1
    :
    60�� ���� ���õǾ����ϴ�. 
    
5-2. emp ���̺��� �Ի�⵵ �÷����� ��,��,�� ã�Ƽ� ���
    ��. �⵵ ã�� ���� TO_CHAR() �Լ� ���
    ��. �� ã�� ���� SUBSTR() �Լ� ���
    
    NUMBER   ����
    VARCHAR2 '����' �Ǵ� '���ڿ�' 
    DATE     '��¥'
    
SELECT ename, hiredate
    , TO_CHAR(  hiredate, 'YYYY'  )   year  --DATE -> YEAR    '1980'
    , EXTRACT(  YEAR  FROM hiredate ) year -- 1980
    , SUBSTR( hiredate, 4, 2)  month
    , TO_CHAR(  hiredate, 'MM'  ) month
    , EXTRACT(  MONTH  FROM hiredate ) month
    , SUBSTR( hiredate, -2)  "DATE"
    , TO_CHAR(  hiredate, 'dd'  )  "DATE"
    , EXTRACT(  DAY  FROM hiredate )  "DATE"
FROM emp;
    
    ENAME      HIREDATE YEAR MONTH DATE
    ---------- -------- ---- -- --
    SMITH      80/12/17 1980 12 17
    ALLEN      81/02/20 1981 02 20
    WARD       81/02/22 1981 02 22
    JONES      81/04/02 1981 04 02
    MARTIN     81/09/28 1981 09 28
    BLAKE      81/05/01 1981 05 01
    CLARK      81/06/09 1981 06 09
    KING       81/11/17 1981 11 17
    TURNER     81/09/08 1981 09 08
    JAMES      81/12/03 1981 12 03
    FORD       81/12/03 1981 12 03
    MILLER     82/01/23 1982 01 23

12�� ���� ���õǾ����ϴ�.    
    
5-3.insa ���̺��� 70���� ���ڻ���� �Ʒ��� ���� �ֹε�Ϲ�ȣ�� �����ؼ� ����ϼ���.
DESC insa;

SELECT name
--    , ssn
    , SUBSTR( ssn, 0, 8 ) || '******'  rrn
    , CONCAT( SUBSTR( ssn, 0, 8 ) ,   '******' )  rrn
FROM insa;

    NAME                 RRN           
    -------------------- --------------
    �����               721217-1******
    ���μ�               731211-1******
    ������               751010-1******
    ����               760105-1******
    ���ѱ�               760909-1******
    �ּ���               770129-1******
    ����ȯ               771115-1******
    ȫ�浿               771212-1******
    �긶��               780505-1******
    ����ö               780506-1******
    �ڹ���               780710-1******
    �̻���               781010-1******
    ������               790304-1******
    �ڼ���               790509-1******
    �̱��               790604-1******
    
    15�� ���� ���õǾ����ϴ�. 
    
    
12:03 ���� ����~~~     
6. insa ���̺��� 70��� 12���� ��� ��� �Ʒ��� ���� �ֹε�Ϲ�ȣ�� �����ؼ� ����ϼ���.

    NAME                 SSN           
    -------------------- --------------
    �����               721217-1951357
    ���μ�               731211-1214576
    ȫ�浿               771212-1022432   

SELECT name, ssn    
FROM insa
WHERE ssn LIKE '7_12%';
WHERE ssn LIKE '__12%';
WHERE ssn LIKE '7%';

WHERE SUBSTR( ssn, 1, 1) = 7  AND SUBSTR( ssn, 3, 2) = 12;    
WHERE SUBSTR( ssn, 1, 1) = '7';    

   ��. LIKE            SQL������
       (1) ���ϵ�ī��(  %  _  ��ȣ)�� ��밡���ϴ�. 
            %  :  ���� ������ �������      *
            _  : �� ���� ����     
       (2) ���ڿ��� ���� �˻�.
       (3) ���ϵ� ī�带 �Ϲݹ��� ó�� ���� ���� ��쿡��  "ESCAPE �ɼ�"�� ����Ѵ�.
   
   ��ǰ���̺�
   ��ǰ�� �÷�
   �α��ǰ��
   
   SELECT *
   FROM ��ǰ���̺�
   WHERE ��ǰ�� LIKE '%�����е�%' OR ��ǰ�� LIKE '%��������%'
   ORDER BY �ǸŰ��� DESC;  -- �������ݼ�
   ORDER BY �ǸŰ��� ASC;  -- �������ݼ�
   ORDER BY �������� DESC; -- �Ż�ǰ��
   ORDER BY �Ǹż��� DESC; -- �α��
   
   [����] insa ���̺��� ���� �达,�̾��� ����ϼ���. 
   SELECT name, ssn
   , SUBSTR( name, 0, 1)
   FROM insa
   WHERE name  LIKE '%��%';
   WHERE name  LIKE '_��%';
   WHERE name LIKE '��%' OR name LIKE '��_%'; -- ���ϵ�ī��(%,_)
   WHERE SUBSTR( name, 0, 1) IN ( '��' , '��' ) ;
   WHERE SUBSTR( name, 0, 1) = '��' OR SUBSTR( name, 0, 1) = '��';
   
   -- [LIKE  ESCAPE �ɼ� ���� ]
   SELECT *
   FROM dept; -- �μ� ���̺�
    �μ���ȣ �μ���    ������
    deptno   dname   loc
    10	ACCOUNTING	NEW YORK
    20	RESEARCH	DALLAS
    30	SALES	CHICAGO
    40	OPERATIONS	BOSTON
    
    -- ���ο� �μ��� �߰� : DML��   INSERT , UPDTE, DELETE  + COMMIT(�ϱ�)    
    -- [ INSERT  ���� ]
    INSERT INTO ���̺�� [( �÷���... )] VALUES ( ��... );
    COMMIT;
    --  ����Ŭ���� ��¥,���ڿ���  '' ���
    INSERT INTO dept ( deptno, dname, loc ) VALUES ( 50, 'QC100%T' , 'SEOUL' );
    COMMIT;
    
    -- 2:00 ���� ����~~~ 
    -- ORA-00001: unique constraint (SCOTT.PK_DEPT) violated
    --            ���ϼ� ��������(PK_DEPT)            ����ȴ�. 
    INSERT INTO dept VALUES(50,'�ѱ�_����','COREA');
    INSERT INTO dept VALUES(60,'�ѱ�_����','COREA');
    COMMIT;
    -- 1 �� ��(��) ���ԵǾ����ϴ�
    SELECT *
    FROM dept;
    
    -- [����] dept ���̺���  �μ���   '_' �ش� �μ���  ��ȸ
    SELECT *
    FROM dept
    WHERE dname LIKE  '%\_%' ESCAPE '\'  ; 
    WHERE dname LIKE  '%_%'  ;  --  _ ���ϵ�ī��( _ ) : �� ����
    
    -- [����] dept ���̺���  �μ���   '%' �ش� �μ���  ��ȸ
    SELECT *
    FROM dept
    WHERE dname LIKE  '%\%%' ESCAPE '\'  ; 
    
    -- DML (������ ���۾�� ) : INSERT ��, [UPDATE ��(����)]    + COMMIT;
    
    [����]
    UPDATE [��Ű��.]���̺��
    SET �������÷���=�����Ұ�,�������÷���=�����Ұ�...
    [WHERE ������];
    
    �ǽ�) ������( loc )   'Corea' -> 'Korea' ����
    SELECT *
    FROM dept
    WHERE loc = UPPER( 'Corea' ) ;
    -- WHERE �������� �����ϸ� ��� ���ڵ�(�� == �μ�)�� ������(loc)�� �����ȴ�.
    ROLLBACK;
    --
    UPDATE dept
    SET loc = 'KOREA'
    WHERE loc = UPPER( 'Corea' ) ;
    WHERE deptno = 60; -- ������ Ű(PK ����)�� deptno �÷����� ����ؼ� ����, ���� ���� �Ͼ��. 
    COMMIT;
    -- DML (������ ���۾�� ) : INSERT ��, UPDATE ��(����) , [DELETE ��]   + COMMIT;
    
    -- [����]
    -- WHERE �������� �����ϸ� ��� ���ڵ�(��)�� �����ȴ�. 
    DELETE FROM ���̺��
    [WHERE ������ ];
    -- 50, 60 �μ���ȣ�� ����.
    -- ORA-02292: integrity constraint (SCOTT.FK_DEPTNO) violated - child record found
    --            ���Ἲ     ��������(����Ű==����Ű)        ����     - �ڽ� ���ڵ� ã�Ҵ�.
    -- �� ? 
    -- EMP(���)���̺�  -<�Ҽ� ����>-   DEPT(�μ�)���̺� 
    SELECT *
    FROM dept;
    
    ROLLBACK;
    --  40, 50, 60 �μ��� �μ����̺��� ����
    DELETE FROM dept
    WHERE deptno >= 50;    
    WHERE deptno IN ( 40, 50, 60);
    WHERE deptno = 40 OR deptno = 50 OR deptno = 60;
    
    COMMIT;
    
    -- CRUD( CreateReadUpdateDelete )  SELECT, INSERT, UPDATE, DELETE 
    
    [����] deptno = 30 �μ��� �μ����� 'SA%LES'���� �����ϴ� ���� �ۼ�...
    UPDATE ���̺��
    SET   �������÷�=��...
    WHERE ������;
    --
    UPDATE dept
    SET   dname = 'SA%LES'
    WHERE deptno = 30;
    COMMIT;
    
    [����] deptno = 30 �μ��� �μ��� % �� �����ϴ� ���� �ۼ�.
    -- �ڹ�  String dname = "SA%LES";
    --              % ����
    --      dname =  dname.replace("%","");
    --       syso( dname );
    UPDATE dept
    -- SET   dname =  dname  % ������ ��
    SET   dname =  REPLACE(  dname , '%' , '')
    WHERE deptno = 30;
    COMMIT;
    
    [����] emp ���̺��� sal �� 10%�� comm�� �߰��ϴ� ���� ���� �ۼ��ϼ���.
    SELECT *
    FROM emp;
ROLLBACK;
    UPDATE emp
    SET   comm =   NVL(comm, 0)  +  sal * 0.1   ;  --  null ��� ���� => null ó��..
    
    
    -- 3:05 ���� ����~
       LIKE  SQL������
   ��. REGEXP_LIKE()   �Լ�
     --  ����ǥ������ ����ϴ� LIKE �Լ�
     -- [����] insa���̺��� ���� �达,�̾�  ��ȸ.
     -- [����] insa���̺��� ���� �达,�̾��� �ƴ� ��� ����  ��ȸ.
     SELECT *
     FROM insa
     WHERE  REGEXP_LIKE( name , '[����]$' )  ;
     
     WHERE  REGEXP_LIKE( name , '^[^����]' )  ;
     WHERE  NOT  REGEXP_LIKE( name , '^[����]' )  ;
     WHERE name NOT LIKE '��%' AND name NOT LIKE '��%';
     
     WHERE  NOT (  REGEXP_LIKE( name , '^[����]' )  );
     WHERE  NOT ( name LIKE '��%' OR name LIKE '��%' );
     
     WHERE REGEXP_LIKE( name , '^[����]' ) ;
     WHERE name LIKE '��%' OR name LIKE '��%';
     
     --
     SELECT name, ssn            
     FROM insa
     WHERE REGEXP_LIKE( ssn , '^7\d12' );
     WHERE REGEXP_LIKE( ssn , '^7[0-9]12' );
     --WHERE ssn LIKE '7_12%';
     
     [����] insa ���̺��� 70��� ���� ����� ��ȸ.
     -- 1) LIKE ������
     -- 2) REGEXP_LIKE() �Լ�
     
     4:05 ���� ����~
     -- �ڹ� ���� :  1/3/5/7/9 
     --            int gender = 3;
     --             gender % 2 == 1  ����.. Ȧ����� .. 
     -- ����Ŭ �������� ���ϴ� ������  %         X ����.
     --                     �Լ�   MOD( a, b )   == a % b   
     SELECT 4+5, 4-5, 4*5, 4/5 -- ���������
      --     , 4 % 5   -- ORA-00911: invalid character
            , MOD(4, 5 )
     FROM dual;
     
     
     SELECT name, ssn
     FROM insa
     WHERE REGEXP_LIKE(  ssn ,  '^7.{6}[13579]' );
     WHERE REGEXP_LIKE(  ssn ,  '^7\d{5}-[13579]' );
     
     WHERE ssn LIKE '7%' AND  MOD(  SUBSTR(ssn, 8, 1) , 2 ) = 1 ;
     WHERE ssn LIKE '7%' AND SUBSTR(ssn, 8, 1) IN ( 1,3,5,7,9 );
     
     WHERE REGEXP_LIKE(  ssn ,  '^7\d{5}-1' );
     WHERE ssn LIKE '7_____-1%';
     -- WHERE ssn LIKE '7%' AND ssn LIKE '______-1%'  --  ( % _  )���ϵ� ī�� 

    [����] emp ���̺��� �����(ename) �ӿ�  'la' ���ڿ��� �����ϴ� ��� ������ ��ȸ(���)
    --                    la   La  lA  LA
    �����ġ�
        regexp_like (search_string, pattern [,match_option])
        match_option   i(��ҹ��ڱ���X) , c(��ҹ��ڱ���O) , n , m( multi lines), x ( ���鹮�� ���� )
        
    SELECT empno, ename,    REPLACE( ename , 'LA', '<sapn style="color:red">LA</span>')
    FROM emp
    WHERE REGEXP_LIKE( ename ,  'la', 'i'  );  -- (�ϱ�)
    WHERE REGEXP_LIKE( ename ,  '[lL][aA]'  );
    WHERE REGEXP_LIKE( ename ,  UPPER('la')  );
    WHERE REGEXP_LIKE( ename , 'LA'  );
    WHERE ename LIKE '%' || UPPER('La') || '%'; --  (�ϱ�)
    WHERE ename LIKE '%LA%';
    
7. emp ���̺���
   pay(sal+comm)  1000 �̻�~ 3000 ���� �޴�  
   30�μ����� ������ ��� ����鸸 
   ename�� �������� �������� �����ؼ� ��ȸ�ϴ� ������ �ۼ��ϼ���.  
    ��. �Ϲ� ���� ���.    
    SELECT deptno, empno, ename, sal, comm, sal + NVL(comm,0) pay
    FROM emp
    WHERE ( sal + NVL(comm,0) BETWEEN 1000 AND 3000 ) AND deptno != 30
    ORDER BY ename ASC ;
    
    ��. inline view ��� 
    SELECT t.*
    FROM (     -- �ζ��κ�
                SELECT deptno, empno, ename, sal, comm, sal + NVL(comm,0) pay
                FROM emp
          ) t
    WHERE  ( t.pay BETWEEN 1000 AND 3000 )  AND t.deptno != 30
    ORDER BY t.ename ASC ;
    
    ��. with �� ���   
    WITH  
        temp AS (
                SELECT deptno, empno, ename, sal, comm, sal + NVL(comm,0) pay
                FROM emp
        )
    SELECT temp.*
    FROM  temp
    WHERE( temp.pay BETWEEN 1000 AND 3000 )  AND temp.deptno != 30
    ORDER BY temp.ename ASC ;  
    
8. emp ���̺��� ���ӻ��(mgr)�� ����  ����� ������ ��ȸ�ϴ� ���� �ۼ�.
   SELECT *
   FROM emp
   WHERE mgr IS NULL;
   -- WHERE mgr = NULL;

8-2. emp ���̺��� ���ӻ��(mgr)�� ����  ����� mgr�� 'CEO'�� ����ϴ� ���� �ۼ�.
  -- ORA-00923: FROM keyword not found where expected
  -- ORA-01722: invalid number
   -- SELECT e.* , NVL( mgr, 'CEO') 
   
   -- mgr ���� -> ���ڿ� ��ȯ
   SELECT e.* , NVL( TO_CHAR( mgr ), 'CEO') 
   FROM emp e
   WHERE e.mgr IS NULL;
   
   DESC emp;
   MGR               NUMBER(4)    










