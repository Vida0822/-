-- HR --
-- Ctrl + F7 : 키워드 대문자로 변환

SELECT *
FROM user_users;

SELECT *
FROM user_tables;

DESC employees;

-- 자바 "길동" + "홍" 문자열 연결연산자, concat()
-- ORA-01722: invalid number 문자열 연결 X, 오직 숫자만
-- Ora_Help에서 오라클 연산자 / 검색
-- CONCAT(문자열1, 문자열2) : 문자열1과 문자열2를 연결하며, 합성 연산자 '||'와 동일합니다
-- ORA-00904: " ": invalid identifier(식별자) 빈문자열
-- 오라클에서 문자열 또는 문자는 ''
-- 오라클에서는 날짜와 문자(열)은 ''를 사용한다
SELECT first_name -- AS "fname" -- 컬럼명의 별칭을 설정 <주의> "별칭명"
      , last_name -- lname -- [AS] 별칭명 / AS, "" 생략 가능 / 공백 출력할 때 "" 사용
--    , first_name || " " || last_name
      , first_name || ' ' || last_name AS name
      , CONCAT(CONCAT(first_name, ' '), last_name) name -- NAME_1 index 부여
FROM employees;

-- 사용자가 소유 + 허가 받은 모든 테이블 정보를 조회
SELECT *
FROM tabs;
FROM user_tables;




















