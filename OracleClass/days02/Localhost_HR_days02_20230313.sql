-- HR --
-- [����] hr�� �����ϰ� �ִ� ���̺� ��� ������ ��ȸ
SELECT *
FROM user_tables;

[���̺��] table == ������ �����
���̺��� ������ Ȯ���غ��� -> � �����Ͱ� ����Ǿ��ִ��� �ľ��� �� �ִ�

� ����� � ���� �ִ��� ������ ��Ÿ���� ���̺��
1. REGIONS : ��� ���̺�
    1) ����
    DESC REGIONS;
�̸�          ��?       ����           
----------- -------- ------------ 
REGION_ID   NOT NULL NUMBER             ����ID
REGION_NAME          VARCHAR2(25)       �����̸�
    2) ������ Ȯ��
    SELECT *
    FROM regions;
1	Europe
2	Americas
3	Asia
4	Middle East and Africa

2. COUNTRIES : ���� ���̺�
    1) ����
    DESC COUNTRIES;
�̸�           ��?       ����           
------------ -------- ------------ 
COUNTRY_ID   NOT NULL CHAR(2)           ����ID
COUNTRY_NAME          VARCHAR2(40)      �����̸�
REGION_ID             NUMBER            ����ID
    2) ������ Ȯ��
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

�ش� �μ��� ��� ��ġ�� �ִ��� ������ ��Ÿ���� ���̺��
3. LOCATIONS : ��ġ ���̺�
    1) ����
    DESC LOCATIONS;
�̸�             ��?       ����           
-------------- -------- ------------ 
LOCATION_ID    NOT NULL NUMBER(4)       ��ġID
STREET_ADDRESS          VARCHAR2(40)    �ּ�
POSTAL_CODE             VARCHAR2(12)    ����ȣ
CITY           NOT NULL VARCHAR2(30)    ��Ƽ
STATE_PROVINCE          VARCHAR2(25) 
COUNTRY_ID              CHAR(2)      
    2) ������ Ȯ��
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

4. DEPARTMENTS : �μ� ���̺�
    1) ����
    DESC DEPARTMENTS;
�̸�              ��?       ����           
--------------- -------- ------------ 
DEPARTMENT_ID   NOT NULL NUMBER(4)      �μ�ID
DEPARTMENT_NAME NOT NULL VARCHAR2(30)   �μ��̸�
MANAGER_ID               NUMBER(6)      �μ���ID
LOCATION_ID              NUMBER(4)      ��ġID

5. JOBS : �� ���̺�
    1) ����
    DESC JOBS;
�̸�         ��?       ����           
---------- -------- ------------ 
JOB_ID     NOT NULL VARCHAR2(10)        ��ID
JOB_TITLE  NOT NULL VARCHAR2(35)        �� ����
MIN_SALARY          NUMBER(6)           �ּ� �⺻��
MAX_SALARY          NUMBER(6)           �ִ� �⺻��

6. EMPLOYEES : ��� ���̺�
    1) ����
    DESC EMPLOYEES;
�̸�(�÷���)      ��?       ����           
               NOT NULL �� ��� X == �ʼ� �Է� �׸�
-------------- -------- ------------ 
EMPLOYEE_ID    NOT NULL NUMBER(6)       �����ȣ(ID)
���ID�� �ʼ��Է��׸��̰�, ���� 6�ڸ��̴�
FIRST_NAME              VARCHAR2(20)    f �̸�
LAST_NAME      NOT NULL VARCHAR2(25)    l �̸�
EMAIL          NOT NULL VARCHAR2(25)    �̸���
PHONE_NUMBER            VARCHAR2(20)    ����ȣ
HIRE_DATE      NOT NULL DATE            �Ի�����
JOB_ID         NOT NULL VARCHAR2(10)    ��ID
SALARY                  NUMBER(8,2)     �⺻��
COMMISSION_PCT          NUMBER(2,2)     Ŀ�̼�
MANAGER_ID              NUMBER(6)       ���ӻ��ID
DEPARTMENT_ID           NUMBER(4)       �μ�ID

����Ŭ �ڷ��� : NUMBER(����), VARCHAR2(����, ���ڿ�), DATE(��¥)

7. JOB_HISTORY : �� �����丮 ���̺�
    1) ����
    DESC JOB_HISTORY;
�̸�            ��?       ����           
------------- -------- ------------ 
EMPLOYEE_ID   NOT NULL NUMBER(6)        ���ID
START_DATE    NOT NULL DATE             ���۳�¥
END_DATE      NOT NULL DATE             ���ᳯ¥
JOB_ID        NOT NULL VARCHAR2(10)     ��ID
DEPARTMENT_ID          NUMBER(4)        �μ�ID
    2) ������ Ȯ��
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

















