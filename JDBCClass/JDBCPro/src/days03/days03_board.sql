CREATE SEQUENCE seq_cstVSBoard;

SELECT *
FROM user_sequences;

CREATE TABLE cstVSBoard
(
	  seq NUMBER NOT NULL PRIMARY KEY,
	  writer VARCHAR2(20) NOT NULL,
	  pwd VARCHAR2(20) NOT NULL,
	  email VARCHAR2(100),
	  title VARCHAR2(200) NOT NULL,
	  writedate DATE DEFAULT SYSDATE,
	  readed NUMBER DEFAULT 0,
	  tag NUMBER(1) NOT NULL,
	  content NCLOB
);

SELECT *
FROM cstVSBoard;

DECLARE
    vwriter VARCHAR2(20);
    vemail VARCHAR(100);
    vtitle VARCHAR2(200);
BEGIN
    FOR i IN 1.. 150
    LOOP
    
        SELECT DBMS_RANDOM.STRING('A',5) INTO vwriter
        FROM dual;
        
        vemail := vwriter || '@ss.co.kr';
        
        vtitle := '게시글 - ' || i;

        INSERT INTO cstVSBoard ( seq, writer, pwd, email, title, tag, content )
                        VALUES ( seq_cstVSBoard.NEXTVAL, vwriter, '1234', vemail, vtitle, 0, '내용 - ' || i );
    END LOOP;
    COMMIT;
END;

DROP TABLE cstvsboard;

DESC cstvsboard;

SELECT seq, writer, email, title, readed, writedate
FROM cstvsboard
ORDER BY seq DESC;

DELETE FROM cstvsboard;

SELECT *
FROM cstvsboard
WHERE REGEXP_LIKE(content, '2', 'i');
ORDER BY seq DESC;

--------------------------------------------------------------------------------
-- 보고자하는 페이지 번호 : 1     1 ~ 10
-- 보고자하는 페이지 번호 : 2    11 ~ 20
-- 보고자하는 페이지 번호 : 3    21 ~ 30
-- 한 페이지에 출력할 게시글 개수 : 10

-- TOP-N 방식
SELECT *
FROM (
    SELECT ROWNUM no, t.*
    FROM (
        SELECT seq, writer, email, title, readed, writedate
        FROM cstvsboard
        ORDER BY seq DESC
    ) t
) m
WHERE m.no BETWEEN ? AND ?;

SELECT COUNT(*), CEIL( COUNT(*)/10 ) FROM cstvsboard;

SELECT seq, writer, email, title, readed, writedate
FROM cstvsboard
--WHERE REGEXP_LIKE(title, ?, 'i')
--WHERE REGEXP_LIKE(content, ?, 'i')
--WHERE REGEXP_LIKE(writer, ?, 'i')
WHERE REGEXP_LIKE(title, '3', 'i') OR REGEXP_LIKE(content, '3', 'i')
ORDER BY seq DESC;

SELECT *
FROM (
    SELECT ROWNUM no, t.*
    FROM (
        SELECT seq, writer, email, title, readed, writedate
        FROM cstvsboard
        WHERE REGEXP_LIKE(title, '3', 'i') OR REGEXP_LIKE(content, '3', 'i')
        ORDER BY seq DESC
    ) t
) m
WHERE m.no BETWEEN 1 AND 10;




