-- HR --
-- [문제] hr이 소유하고 있는 테이블 목록 정보를 조회
SELECT *
FROM user_tables;

[테이블명] table == 데이터 저장소
테이블의 구조를 확인해보면 -> 어떤 데이터가 저장되어있는지 파악할 수 있다

어떤 대륙에 어떤 나라가 있는지 정보를 나타내는 테이블들
1. REGIONS : 대륙 테이블
    1) 구조
    DESC REGIONS;
이름          널?       유형           
----------- -------- ------------ 
REGION_ID   NOT NULL NUMBER             지역ID
REGION_NAME          VARCHAR2(25)       지역이름
    2) 데이터 확인
    SELECT *
    FROM regions;
1	Europe
2	Americas
3	Asia
4	Middle East and Africa

2. COUNTRIES : 국가 테이블
    1) 구조
    DESC COUNTRIES;
이름           널?       유형           
------------ -------- ------------ 
COUNTRY_ID   NOT NULL CHAR(2)           나라ID
COUNTRY_NAME          VARCHAR2(40)      나라이름
REGION_ID             NUMBER            지역ID
    2) 데이터 확인
    SELECT *
    FROM countries;
AR	Argentina	2
AU	Australia	3
BE	Belgium	1
BR	Brazil	2
CA	Canada	2
CH	Switzerland	1
CN	China	3
DE	Germany	1
DK	Denmark	1
EG	Egypt	4
FR	France	1
IL	Israel	4
IN	India	3
IT	Italy	1
JP	Japan	3
KW	Kuwait	4
ML	Malaysia	3
MX	Mexico	2
NG	Nigeria	4
NL	Netherlands	1
SG	Singapore	3
UK	United Kingdom	1
US	United States of America	2
ZM	Zambia	4
ZW	Zimbabwe	4

해당 부서가 어느 위치에 있는지 정보를 나타내는 테이블들
3. LOCATIONS : 위치 테이블
    1) 구조
    DESC LOCATIONS;
이름             널?       유형           
-------------- -------- ------------ 
LOCATION_ID    NOT NULL NUMBER(4)       위치ID
STREET_ADDRESS          VARCHAR2(40)    주소
POSTAL_CODE             VARCHAR2(12)    우편변호
CITY           NOT NULL VARCHAR2(30)    시티
STATE_PROVINCE          VARCHAR2(25) 
COUNTRY_ID              CHAR(2)      
    2) 데이터 확인
    SELECT *
    FROM locations;    
1000	1297 Via Cola di Rie	00989	Roma		IT
1100	93091 Calle della Testa	10934	Venice		IT
1200	2017 Shinjuku-ku	1689	Tokyo	Tokyo Prefecture	JP
1300	9450 Kamiya-cho	6823	Hiroshima		JP
1400	2014 Jabberwocky Rd	26192	Southlake	Texas	US
1500	2011 Interiors Blvd	99236	South San Francisco	California	US
1600	2007 Zagora St	50090	South Brunswick	New Jersey	US
1700	2004 Charade Rd	98199	Seattle	Washington	US
1800	147 Spadina Ave	M5V 2L7	Toronto	Ontario	CA
1900	6092 Boxwood St	YSW 9T2	Whitehorse	Yukon	CA
2000	40-5-12 Laogianggen	190518	Beijing		CN
2100	1298 Vileparle (E)	490231	Bombay	Maharashtra	IN
2200	12-98 Victoria Street	2901	Sydney	New South Wales	AU
2300	198 Clementi North	540198	Singapore		SG
2400	8204 Arthur St		London		UK
2500	Magdalen Centre, The Oxford Science Park	OX9 9ZB	Oxford	Oxford	UK
2600	9702 Chester Road	09629850293	Stretford	Manchester	UK
2700	Schwanthalerstr. 7031	80925	Munich	Bavaria	DE
2800	Rua Frei Caneca 1360 	01307-002	Sao Paulo	Sao Paulo	BR
2900	20 Rue des Corps-Saints	1730	Geneva	Geneve	CH
3000	Murtenstrasse 921	3095	Bern	BE	CH
3100	Pieter Breughelstraat 837	3029SK	Utrecht	Utrecht	NL
3200	Mariano Escobedo 9991	11932	Mexico City	Distrito Federal,	MX

4. DEPARTMENTS : 부서 테이블
    1) 구조
    DESC DEPARTMENTS;
이름              널?       유형           
--------------- -------- ------------ 
DEPARTMENT_ID   NOT NULL NUMBER(4)      부서ID
DEPARTMENT_NAME NOT NULL VARCHAR2(30)   부서이름
MANAGER_ID               NUMBER(6)      부서장ID
LOCATION_ID              NUMBER(4)      위치ID

5. JOBS : 잡 테이블
    1) 구조
    DESC JOBS;
이름         널?       유형           
---------- -------- ------------ 
JOB_ID     NOT NULL VARCHAR2(10)        잡ID
JOB_TITLE  NOT NULL VARCHAR2(35)        잡 제목
MIN_SALARY          NUMBER(6)           최소 기본급
MAX_SALARY          NUMBER(6)           최대 기본급

6. EMPLOYEES : 사원 테이블
    1) 구조
    DESC EMPLOYEES;
이름(컬럼명)      널?       유형           
               NOT NULL 널 허용 X == 필수 입력 항목
-------------- -------- ------------ 
EMPLOYEE_ID    NOT NULL NUMBER(6)       사원번호(ID)
사원ID는 필수입력항목이고, 숫자 6자리이다
FIRST_NAME              VARCHAR2(20)    f 이름
LAST_NAME      NOT NULL VARCHAR2(25)    l 이름
EMAIL          NOT NULL VARCHAR2(25)    이메일
PHONE_NUMBER            VARCHAR2(20)    폰번호
HIRE_DATE      NOT NULL DATE            입사일자
JOB_ID         NOT NULL VARCHAR2(10)    잡ID
SALARY                  NUMBER(8,2)     기본급
COMMISSION_PCT          NUMBER(2,2)     커미션
MANAGER_ID              NUMBER(6)       직속상사ID
DEPARTMENT_ID           NUMBER(4)       부서ID

오라클 자료형 : NUMBER(숫자), VARCHAR2(문자, 문자열), DATE(날짜)

7. JOB_HISTORY : 잡 히스토리 테이블
    1) 구조
    DESC JOB_HISTORY;
이름            널?       유형           
------------- -------- ------------ 
EMPLOYEE_ID   NOT NULL NUMBER(6)        사원ID
START_DATE    NOT NULL DATE             시작날짜
END_DATE      NOT NULL DATE             종료날짜
JOB_ID        NOT NULL VARCHAR2(10)     잡ID
DEPARTMENT_ID          NUMBER(4)        부서ID
    2) 데이터 확인
    SELECT *
    FROM job_history
102	01/01/13	06/07/24	IT_PROG	    60
101	97/09/21	01/10/27	AC_ACCOUNT	110
101	01/10/28	05/03/15	AC_MGR	    110
201	04/02/17	07/12/19	MK_REP	    20
114	06/03/24	07/12/31	ST_CLERK	50
122	07/01/01	07/12/31	ST_CLERK	50
200	95/09/17	01/06/17	AD_ASST	    90
176	06/03/24	06/12/31	SA_REP	    80
176	07/01/01	07/12/31	SA_MAN	    80
200	02/07/01	06/12/31	AC_ACCOUNT	90

















