-- SCOTT --
-------------------------------------------------------------------------------
-- [ 트리거 ]
1) 트리거 : 방아쇠 -> 자동 ->총구(총알)
2) 대상 테이블에 미리 트리거를 지정(설정)하면
   어떤 이벤트(DML)가 발생하면 자동으로 설정된 트리거가 작동하도록한 객체를 트리거라고 한다
3)  [재고 테이블]
    A냉장고 22개
    
    [입고 테이블]
    입고날짜               입고수량
    2023.4.3    A냉장고    5개
    
    [판매 테이블]
    2023.4.3    A냉장도    3개
    
    대상 테이블
    [입고 테이블] + INSERT(DML) 이벤트가 발생하면
    자동으로
    [재고 테이블]의 재고 수량을 수적하도록 하는 트리거 생성
4) 작업 전(BEFORE)
    예) 토/일                      입고 X
        9 이전 18 이후 근무시간 X   입고 X
   작업 후(AFTER)
5) 트리거 사용하는 예약어
    (1) BEFORE : 이벤트(DML)보다 먼저 트리거가 작동
    (2) AFTER : 이벤트(DML)가 작동한 후 트리거가 작동
    (3) FOR EACH ROW : 행 트리거임을 알림
    (4) REFERENCING : 영향 받은 행의 값을 참조
    (5) :OLD
        :NEW
        empno   deptno
        7369    10(:OLD)
        이벤트(UPDATE) 10(:OLD), 20(:NEW)번 부서 수정
        이벤트(INSERT) 30(:NEW)
        이벤트(DELETE) 30(:OLD)
6) 저장 프로시저는 COMMIT, ROLLBACK 처리를 해야 된다
   트리거는 자동으로 COMMIT, ROLLBACK 처리가 된다
7) 형식
CREATE OR REPLACE TRIGGER 트리거명 -- up_, uf_, [ut_] 접두사
BEFORE 또는 AFTER -- DEFAULT BEFORE
트리거이벤트 ON 대상테이블
[FOR EACH ROW [WHEN TRIGGER 조건]]
[DECLARE]
    변수선언
BEGIN
EXCEPTION
END;
8) 트리거 확인
SELECT *
FROM user_triggers;
FROM user_constraints;
FROM user_table;

[문제] 설문조사
회원이 1번 설문조사 참여
1) 참여자(투표)테이블
   INSERT   A고객, 1번설문, 3번항목
2) 설문테이블
   UPDATE 총참여자수 1증가
3) 설문항목테이블
   3번항목의 투표자수를 1증가

예) 트랜잭션 처리
    계좌 이체
    A 100만원 인출  B 100만원 전송
    -100U          +100U
9) 트리거 생성, 삭제, 활성화/비활성화
10) 실습
CREATE TABLE 상품 (
   상품코드        VARCHAR2(6) NOT NULL PRIMARY KEY
  ,상품명           VARCHAR2(30)  NOT NULL
  ,제조사        VARCHAR2(30)  NOT NULL
  ,소비자가격  NUMBER
  ,재고수량     NUMBER DEFAULT 0
);

-- 입고 테이블 작성
CREATE TABLE 입고 (
   입고번호      NUMBER PRIMARY KEY
  ,상품코드      VARCHAR2(6) NOT NULL CONSTRAINT FK_ibgo_no
                 REFERENCES 상품(상품코드)
  ,입고일자     DATE
  ,입고수량      NUMBER
  ,입고단가      NUMBER
);

-- 판매 테이블 작성
CREATE TABLE 판매 (
   판매번호      NUMBER  PRIMARY KEY
  ,상품코드      VARCHAR2(6) NOT NULL CONSTRAINT FK_pan_no
                 REFERENCES 상품(상품코드)
  ,판매일자      DATE
  ,판매수량      NUMBER
  ,판매단가      NUMBER
);
-- 상품 테이블에 데이터 입력
INSERT INTO 상품(상품코드, 상품명, 제조사, 소비자가격) VALUES
        ('AAAAAA', '디카', '삼싱', 100000);
INSERT INTO 상품(상품코드, 상품명, 제조사, 소비자가격) VALUES
        ('BBBBBB', '컴퓨터', '엘디', 1500000);
INSERT INTO 상품(상품코드, 상품명, 제조사, 소비자가격) VALUES
        ('CCCCCC', '모니터', '삼싱', 600000);
INSERT INTO 상품(상품코드, 상품명, 제조사, 소비자가격) VALUES
        ('DDDDDD', '핸드폰', '다우', 500000);
INSERT INTO 상품(상품코드, 상품명, 제조사, 소비자가격) VALUES
         ('EEEEEE', '프린터', '삼싱', 200000);
COMMIT;
SELECT * FROM 상품;
AAAAAA	디카	    삼싱	100000	0
BBBBBB	컴퓨터	엘디	1500000	0
CCCCCC	모니터	삼싱	600000	0
DDDDDD	핸드폰	다우	500000	0
EEEEEE	프린터	삼싱	200000	0
-- 입고 테이블에 데이터 입력
INSERT INTO 입고 (입고번호, 상품코드, 입고일자, 입고수량, 입고단가)
              VALUES (1, 'AAAAAA', '2004-10-10', 5,   50000);
INSERT INTO 입고 (입고번호, 상품코드, 입고일자, 입고수량, 입고단가)
              VALUES (2, 'BBBBBB', '2004-10-10', 15, 700000);
INSERT INTO 입고 (입고번호, 상품코드, 입고일자, 입고수량, 입고단가)
              VALUES (3, 'AAAAAA', '2004-10-11', 15, 52000);
INSERT INTO 입고 (입고번호, 상품코드, 입고일자, 입고수량, 입고단가)
              VALUES (4, 'CCCCCC', '2004-10-14', 15,  250000);
INSERT INTO 입고 (입고번호, 상품코드, 입고일자, 입고수량, 입고단가)
              VALUES (5, 'BBBBBB', '2004-10-16', 25, 700000);
COMMIT;
ROLLBACK;
SELECT * FROM 상품;
SELECT * FROM 입고;
-- [ 첫번째 트리거 생성 + 사용 ]
ㄱ. 대상 테이블 : [입고] 상품 입고
ㄴ. 이벤트(DML) : INSERT
ㄷ. 트리거 작동 : AFTER
-- ORA-04082: NEW or OLD references not allowed in table level triggers
CREATE OR REPLACE TRIGGER ut_insIpgo
AFTER
INSERT ON 입고
FOR EACH ROW -- 행 레벨 트리거 선언
--DECLARE
BEGIN
    UPDATE 상품
    SET 재고수량 = 재고수량 + :NEW.입고수량
    WHERE 상품코드 = :NEW.상품코드;
--EXCEPTION
END;
-- [ 두번째 트리거 생성 + 사용 ]
-- 입고된 수량이 수정이 되면 상품 테이블의 재고수량도 수정시키는 트리거 작성
SELECT *
FROM 상품;
FROM 입고;
입고번호가 5인 상품의	BBBBBB	04/10/16	입고수량이 25 -> 30으로 수정되면	700000
BBBBBB	컴퓨터	엘디	1500000	재고수량도 40 -> 45 수정시키는 트리거 작성

ㄱ. 대상 테이블 : 입고
ㄴ. 이벤트 : UPDATE
ㄷ. AFTER 트리거 생성
ㄹ. FOR EACH ROW 행 레벨 트리거 ( :OLD.입고수량(25)     :NEW.입고수량(30) )
CREATE OR REPLACE TRIGGER ut_updIpgo
AFTER
UPDATE ON 입고
FOR EACH ROW
--DECLARE
BEGIN
    UPDATE 상품
    SET 재고수량 = 재고수량 - :OLD.입고수량 + :NEW.입고수량
    WHERE 상품코드 = :NEW.상품코드;
--EXCEPTION
END;
-- UPDATE 테스트
UPDATE 입고 SET 입고수량 = 30 WHERE 입고번호 = 5;
COMMIT;
SELECT * FROM 상품;
SELECT * FROM 입고;
-- 5   BBBBBB   04/10/16   25   700000
-- [ 세번째 트리거 생성 + 실행 ]
-- 입고가 삭제(취소) 됐을 때 상품 테이블의 재고 수량을 UPDATE하는 트리거 작성
CREATE OR REPLACE TRIGGER ut_delIpgo
AFTER
DELETE ON 입고
FOR EACH ROW
--DECLARE
BEGIN
    UPDATE 상품
    SET 재고수량 = 재고수량 - :OLD.입고수량
    WHERE 상품코드 = :OLD.상품코드; -- :NEW.상품코드도 가능
--EXCEPTION
END;
--
DELETE FROM 입고 WHERE 입고번호 = 5;
5	BBBBBB	04/10/16	30	700000
COMMIT;
SELECT * FROM 상품;
SELECT * FROM 입고;
-- [ 네번째 트리거 생성 + 실행 ] BEFORE 트리거 선언
SELECT * FROM 상품;
SELECT * FROM 판매;
-- AAAAAA 100개 판매 불가 (수량부족)
CREATE OR REPLACE TRIGGER ut_insPan
BEFORE
INSERT ON 판매
FOR EACH ROW
DECLARE
    vqty NUMBER; -- 현재 상품의 재고수량
BEGIN
    -- 판매하고자 하는 수량이 있는지 여부 체크
    SELECT 재고수량 INTO vqty
    FROM 상품
    WHERE 상품코드 = :NEW.상품코드;
    
    IF vqty >= :NEW.판매수량 THEN -- 판매 가능
        UPDATE 상품
        SET 재고수량 = 재고수량 - :NEW.판매수량
        WHERE 상품코드 = :NEW.상품코드;
    ELSE -- 판매 불가
        -- 예외 발생 시키자
        RAISE_APPLICATION_ERROR(-20007, '재고수량 부족으로 판매 불가능'); -- -20000 이하값
    END IF;
--EXCEPTION
END;
-- 판매 테이블에 데이터 입력
INSERT INTO 판매 (판매번호, 상품코드, 판매일자, 판매수량, 판매단가) VALUES
               (1, 'AAAAAA', '2004-11-10', 100, 1000000);
INSERT INTO 판매 (판매번호, 상품코드, 판매일자, 판매수량, 판매단가) VALUES
               (1, 'AAAAAA', '2004-11-10', 7, 1000000);               
COMMIT;
SELECT * FROM 상품;
SELECT * FROM 판매;
-- [ 다섯번째 트리거 생성 + 실행 ]
--            재고수량  20 - 7 = 13
-- 판매테이블에 판매수량이 7개 -> ??개 수정
CREATE OR REPLACE TRIGGER ut_updPan
BEFORE
UPDATE ON 판매
FOR EACH ROW
DECLARE
    vqty NUMBER; -- 현재 상품의 재고수량
BEGIN
    -- 판매하고자 하는 수량이 있는지 여부 체크
    SELECT 재고수량 INTO vqty
    FROM 상품
    WHERE 상품코드 = :NEW.상품코드;
    
    IF vqty + :OLD.판매수량 >= :NEW.판매수량 THEN -- 판매 가능
        UPDATE 상품
        SET 재고수량 = 재고수량 + :OLD.판매수량 - :NEW.판매수량
        WHERE 상품코드 = :NEW.상품코드;
    ELSE -- 판매 불가
        -- 예외 발생 시키자
        RAISE_APPLICATION_ERROR(-20008, '재고수량 부족으로 판매 수정 불가능'); -- -20000 이하값
    END IF;
--EXCEPTION
END;
--
UPDATE 판매 SET 판매수량 = 200 WHERE 판매번호 = 1; -- 판매 수정 불가능
UPDATE 판매 SET 판매수량 = 10 WHERE 판매번호 = 1;
COMMIT;
SELECT * FROM 상품;
SELECT * FROM 판매;
-- [ 여섯번째 트리거 생성 + 실행 ]
-- 판매테이블 1번 취소(삭제)
CREATE OR REPLACE TRIGGER ut_delPan
AFTER
DELETE ON 판매
FOR EACH ROW
DECLARE
    vqty NUMBER; -- 현재 상품의 재고수량
BEGIN
        UPDATE 상품
        SET 재고수량 = 재고수량 + :OLD.판매수량
        WHERE 상품코드 = :OLD.상품코드;
--EXCEPTION
END;
--
DELETE FROM 판매
WHERE 판매번호 = 1;
COMMIT;
ROLLBACK;
SELECT * FROM 상품;
SELECT * FROM 판매;

















