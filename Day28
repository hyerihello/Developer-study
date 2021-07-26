**✨ 제약 조건에 대해 살펴보고 컬럼 레벨과 테이블 레벨을 통해 구현할 수 있다.**  
**✨ 제약조건을 수정하고 삭제할 수 있다.**  
**✨ 제약조건의 정보를 확인할 수 있다.**
​
## **제약 조건**
​
**NOT NULL :** 해당 컬럼에 NULL을 포함 하지 않도록 선언 (컬럼)  
**UNIQUE :** 해당 컬럼 또는 컬럼 조합 값이 유일 하도록 함 (컬럼, 테이블)  
**PRIMARY KEY :** 식별 값 (컬럼, 테이블)  
**REFERENCES TABLE(COLUMN)**
​
**  :** 해당 컬럼이 참조하고 있는 (부모) 테이블의 특정 컬럼 값 들과 일치하거나 또는 NULL이 되도록 보장한다.
​
  (컬럼, 테이블)  
**CHECK :** 해당컬럼에 특정 조건을 만족시키도록 한다. (컬럼, 테이블)  
​
  ※ PRIMARY KEY = UNIQUE + NOTNULL
​
  
  
**제약 조건 확인**
​
  : DESC USER\_CONSTRAINTS;  
  
**CONSTRAINT\_NAME** : 제약 조건 이름  
**CONSTRAINT\_TYPE** : 유형  
                               P(PRIMARY KEY), U(UNIQUE), R(REFERENCE), C(CHECK)  
​
  TABLE\_NAME
​
SEARCH\_CONDITION : CHECK 제약조건 내용  
R\_CONSTRAINT\_NAME : 참조 테이블의 PRIMARY KEY이름  
DELETE\_RULE : 참조 테이블의 PRIMARY KEY 컬럼이 삭제 될때 사용되는 규칙  
(NO ACTION, SET NULL, CASCADE 등)  
​
  
**\# EMP 테이블의 테이블 이름, 제약조건, 타입을 확인해보자****.**  
​
SELECT TABLE\_NAME, CONSTRAINT\_NAME, CONSTRAINT\_TYPE  
FROM USER\_CONSTRAINTS  
WHERE TABLE\_NAME = 'EMP';  
​
```
SQL> SELECT TABLE_NAME, CONSTRAINT_NAME, CONSTRAINT_TYPE
  2  FROM USER_CONSTRAINTS
  3  WHERE TABLE_NAME = 'EMP';
​
TABLE_NAME
------------------------------------------------------------
CONSTRAINT_NAME                                              CO
------------------------------------------------------------ --
EMP
PK_EMP                                                       P  -- PRIMARY KEY
​
EMP
FK_DEPTNO                                                    R -- REFERENCE
```
​
  
**\# DEPT 테이블의 테이블이름, 제약조건, 타입을 확인해보자****.**  
​
SELECT TABLE\_NAME, CONSTRAINT\_NAME, CONSTRAINT\_TYPE  
FROM USER\_CONSTRAINTS  
WHERE TABLE\_NAME = 'DEPT';  
​
```
SQL> SELECT TABLE_NAME, CONSTRAINT_NAME, CONSTRAINT_TYPE
  2  FROM USER_CONSTRAINTS
  3  WHERE TABLE_NAME = 'DEPT';
​
TABLE_NAME
------------------------------------------------------------
CONSTRAINT_NAME                                              CO
------------------------------------------------------------ --
DEPT
PK_DEPT                                                      P
```
​
  
  
**✔ 삭제** **RULE**  
​
ON DELETE CASCADE : 대상 데이터를 삭제하고, 해당 데이터를 참조하는 데이터도 삭제  
ON DELETE SET NULL : 대상 데이터를 삭제하고, 해당 데이터를 참조하는 데이터는 NULL로 바꿈  
ON DELETE RESTRICTED : 삭제 대상 데이터를 참조하는 데이터가 존재하면 삭제할 수 없다 (기본값)  
​
  
**✔ 수정 RULE**
​
  
ON UPDATE CASCADE : 대상 데이터를 수정하면, 해당 데이터를 참조하는 데이터도 수정  
  
  
**\[테이블생성\]**
​
  
CREATE TABLE 테이블명 (  
컬럼명 1 데이터 타입 \[제약조건\] , , ,  
​
  
**\[테이블 수정\]**
​
  
ALTER TABLE 테이블명  
ADD 컬럼명 데이터타입 \[제약조건\]  
ADD CONSTRAINT 제약조건명 제약조건(컬럼명)  
MODIFY 컬럼명 데이터타입  
DROP COLUMN 컬럼명 \[CASCADE CONSTRAINTS\]  
DROP PRIMARY KEY \[CASCADE\] | UNION(컬럼명, , ) \[CASCADE\] | CONSTRAINT 제약조건명 \[CASCADE\]  
​
  
**\[이름변경****\]**  
​
1) ALTER TABLE 기본테이블명 RENAME TO 새테이블명  
2) RENAME 기존테이블명 TO 새태이블명  
  
ALTER TABLE 테이블명 RENAME COLUMN 기본컬럼명 TO 새컬럼명  
ALTER TABLE 테이블명 RENAME CONSTRAINT 기존제약 조건명 TO 새 제약 조건명
​
  
**\[테이블복사\]**
​
  
서브쿼리를 이용한 테이블 생성 및 행 (레코드) 복사  
서브쿼리를 이용해서 복사한 경우 NOT NULL을 제외한 제약 조건은 복사안됨  
(NOT NULL 제약 조건도 SYS\_\*\*\*\*으로 복사된다.)  
​
CREATE TABLE 테이블명 \[컬럼명, , ,\] AS 서브쿼리  
CREATE TABLE 테이블명 1 AS SELECT \* FROM 테이블명 WHERE 1 = 0  
  
​
**Q1) 테이블 생성**
​
CREATE TABLE TEST(  
ID NUMBER(5),  
NAME CHAR(10),  
ADDRESS VARCHAR2(50));  
​
```
SQL> DROP TABLE TEST;
​
Table dropped.
​
SQL> CREATE TABLE TEST(
  2  ID NUMBER(5),
  3  NAME CHAR(10),
  4  ADDRESS VARCHAR2(50));
​
Table created.
​
SQL> DESC TEST;
 Name                                      Null?    Type
 ----------------------------------------- -------- ----------------------------
 ID                                                 NUMBER(5)
 NAME                                               CHAR(10)
 ADDRESS                                            VARCHAR2(50)
​
SQL>
```
​
  
**Q2) ID 컬럼을 USR 컬럼으로 변경해보자.**
​
ALTER TABLE TEST  
RENAME COLUMN ID TO USR;  
​
```
SQL> ALTER TABLE TEST
  2  RENAME COLUMN ID TO USR;
​
Table altered.
​
SQL> DESC TEST;
 Name                                      Null?    Type
 ----------------------------------------- -------- ----------------------------
 USR                                                NUMBER(5)
 NAME                                               CHAR(10)
 ADDRESS                                            VARCHAR2(50)
​
SQL>
```
​
  
**Q3) TEST 테이블의 이름을 EXAM\_TEST 네이블로 변경해보자**
​
  
1\. ALTER TABLE TEST RENAME TO EXAM\_TEST;  
2\. RENAME TO EXAM\_TEST;
​
```
SQL> ALTER TABLE TEST RENAME TO EXAM_TEST;
​
Table altered.
```
​
  
  
**Q4) EXAM\_TEST 테이블을 삭제하고 휴지통 비우자**  
​
(CREATE TABLE TEST  
AS  
SELECT \* FROM EXAM\_TEST;)  
  
DROP TABLE EXAM\_TEST;  
PURGE RECYCLEBIN;  
​
```
SQL> DROP TABLE EXAM_TEST;
​
Table dropped.
​
SQL> PURGE RECYCLEBIN;
​
Recyclebin purged.
​
SQL>
```
​
  
**※ 휴지통확인**
​
  
SELECT \* RECYCLEBIN; -- 캐시메모리 버퍼 2K, 4K 6K...  
DESC RECYCLEBIN;
​
**\*\* 휴지통 비우기**
​
  
PURGE RECYCLEBIN;  
  
  
**Q5) 휴지통에 넣지 않고 바로삭제하자**
​
  
DROP TABLE TEST01 PURGE;
​
```
SQL> DROP TABLE TEST01 PURGE;
​
Table dropped.
​
SQL>
```
​
  
  
**Q6) 다양한 제약 조건을 지정한 테이블을 만들어보자 USER1**
​
CREATE TABLE USER1(  
IDX NUMBER PRIMARY KEY,  
ID VARCHAR2(10) UNIQUE,  
NAME VARCHAR2(10) NOT NULL,  
PHONE VARCHAR2 (15),  
ADDRESS VARCHAR2 (50),  
SCORE NUMBER(6,2) CHECK (SCORE > 0 AND SCORE <= 100),  
SUBJECT\_CODE NUMBER(5),  
HIRE\_DATE DATE DEFAULT SYSDATE,  
MARRIAGE CHAR(1) DEFAULT 'N' CHECK(MARRIAGE IN ('Y','N')));  
​
```
Table dropped.
​
SQL> CREATE TABLE USER1(
  2  IDX NUMBER PRIMARY KEY, -- 중복 데이터 불가 
  3  ID VARCHAR2(10) UNIQUE, -- 유일값
  4  NAME VARCHAR2(10) NOT NULL,
  5  PHONE VARCHAR2 (15),
  6  ADDRESS VARCHAR2 (50),
  7  SCORE NUMBER(6,2) CHECK (SCORE > 0 AND SCORE <= 100),
  8  SUBJECT_CODE NUMBER(5),
  9  HIRE_DATE DATE DEFAULT SYSDATE,
 10  MARRIAGE CHAR(1) DEFAULT 'N' CHECK(MARRIAGE IN ('Y','N')));
​
Table created.
​
SQL> DESC USER1;
 Name                                      Null?    Type
 ----------------------------------------- -------- ----------------------------
 IDX                                       NOT NULL NUMBER
 ID                                                 VARCHAR2(10)
 NAME                                      NOT NULL VARCHAR2(10)
 PHONE                                              VARCHAR2(15)
 ADDRESS                                            VARCHAR2(50)
 SCORE                                              NUMBER(6,2)
 SUBJECT_CODE                                       NUMBER(5)
 HIRE_DATE                                          DATE
 MARRIAGE                                           CHAR(1)
​
SQL>
```
​
  
  
**Q7) 제약 조건 확인**
​
  
SELECT CONSTRAINT\_NAME, CONSTRAINT\_TYPE, SEARCH\_CONDITION  
FROM USER\_CONSTRAINTS  
WHERE TABLE\_NAME = 'USER1';
​
```
SQL> SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE, SEARCH_CONDITION
  2  FROM USER_CONSTRAINTS
  3  WHERE TABLE_NAME = 'USER1';
​
CONSTRAINT_NAME                                              CO
------------------------------------------------------------ --
SEARCH_CONDITION
--------------------------------------------------------------------------------
SYS_C007135                                                  C
"NAME" IS NOT NULL
​
SYS_C007136                                                  C
SCORE > 0 AND SCORE <= 100
​
SYS_C007137                                                  C
MARRIAGE IN ('Y','N')
​
​
CONSTRAINT_NAME                                              CO
------------------------------------------------------------ --
SEARCH_CONDITION
--------------------------------------------------------------------------------
SYS_C007138                                                  P
​
​
SYS_C007139                                                  U
​
​
```
​
  
  
**Q8) 값을 입력해서 제약조건 위배를 생각해 보자.**
​
  
INSERT INTO USER1 VALUES(1,'AAA','KIM','010-000-000','서울','75,100','2021-05-28');  
​
```
SQL> INSERT INTO USER1 VALUES(1,'AAA','KIM','010-000-000','서울','75,100','2021-05-28');
INSERT INTO USER1 VALUES(1,'AAA','KIM','010-000-000','서울','75,100','2021-05-28')
            *
ERROR at line 1:
ORA-00947: not enough values
```
​
  
**Q9) TEST의 USR 을 ID로 변경하자**
​
  
ALTER TABLE TEST  
RENAME COLUMN USR TO ID;
​
```
SQL> ALTER TABLE TEST
  2  RENAME COLUMN USR TO ID;
​
Table altered.
​
SQL> DESC TEST;
 Name                                      Null?    Type
 ----------------------------------------- -------- ----------------------------
 ID                                                 NUMBER(5)
 NAME                                               CHAR(10)
 ADDRESS                                            VARCHAR2(50)
​
```
​
  
  
**Q10) TEST 테이블에 ID에 제약조건PK 추가하자. T\_ID\_PK라는 이름을 지정하자**
​
  
ALTER TABLE TEST  
ADD CONSTRAINT T\_ID\_PK PRIMARY KEY (ID);  
​
```
SQL> ALTER TABLE TEST
  2  ADD CONSTRAINT T_ID_PK PRIMARY KEY (ID);
​
Table altered.
```
​
**이 후에 제약 조건 확인하기**
​
  
SELECT CONSTRAINT\_NAME, CONSTRAINT\_TYPE, SEARCH\_CONDITION  
FROM USER\_CONSTRAINTS  
WHERE TABLE\_NAME = 'TEST';
​
```
SQL> SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE, SEARCH_CONDITION
  2  FROM USER_CONSTRAINTS
  3  WHERE TABLE_NAME = 'TEST';
​
CONSTRAINT_NAME                                              CO
------------------------------------------------------------ --
SEARCH_CONDITION
--------------------------------------------------------------------------------
T_ID_PK                                                      P
```
​
  
  
**Q11) TEST의 기본키를 삭제해보자.**
​
  
ALTER TABLE TEST DROP PRIMARY KEY;
​
```
SQL> ALTER TABLE TEST DROP PRIMARY KEY;
​
Table altered.
​
```
​
  
  
**Q12) ID에다가 UNIQUE 제약을 걸자. T\_U\_ID 제약조건이름**  
​
ALTER TABLE TEST  
ADD CONSTRAINT T\_U\_ID UNIQUE(ID);  
​
```
SQL> ALTER TABLE TEST
  2  ADD CONSTRAINT T_U_ID UNIQUE(ID);
​
Table altered.
```
​
  
**Q13) NAME CHAR(10) → VARCHAR2(10)로 변경해보자**
​
  
ALTER TABLE TEST  
MODIFY NAME VARCHAR2(10);  
​
```
SQL> DESC TEST;
 Name                                      Null?    Type
 ----------------------------------------- -------- ----------------------------
 ID                                                 NUMBER(5)
 NAME                                               VARCHAR2(10)
 ADDRESS                                            VARCHAR2(50)
​
SQL>
```
​
  
**Q14) PKTABLE를 생성한 후 데이터를 입력해보자.**
​
CREATE TABLE PKTABLE(  
ID NUMBER CONSTRAINT PKTABLE\_ID\_PK PRIMARY KEY,  
NAME VARCHAR2(10));  
​
INSERT INTO PKTABLE VALUES(1,'1');  
INSERT INTO PKTABLE VALUES(2,'1');  
INSERT INTO PKTABLE VALUES(NULL,'1'); → NULL값 허용하지 않는다.  
​
```
SQL> CREATE TABLE PKTABLE(
  2  ID NUMBER CONSTRAINT PKTABLE_ID_PK PRIMARY KEY,
  3  NAME VARCHAR2(10));
​
Table created.
​
SQL> DESC PKTABLE;
 Name                                      Null?    Type
 ----------------------------------------- -------- ----------------------------
 ID                                        NOT NULL NUMBER
 NAME                                               VARCHAR2(10)
​
SQL> INSERT INTO PKTABLE VALUES(1,'1');
​
1 row created.
​
SQL> INSERT INTO PKTABLE VALUES(2,'1');
​
1 row created.
​
SQL> INSERT INTO PKTABLE VALUES(NULL,'1'); -- PRIMARY KEY 는 NULL허용안함
INSERT INTO PKTABLE VALUES(NULL,'1')
                           *
ERROR at line 1:
ORA-01400: cannot insert NULL into ("SCOTT"."PKTABLE"."ID")
​
​
SQL>
```
​
  
**Q15) PKTABLE의 제약조건을 삭제하자.**
​
  
ALTER TABLE PKTABLE  
DROP CONSTRAINT PKTABLE\_ID\_PK;  
​
```
SQL> ALTER TABLE PKTABLE
  2  DROP CONSTRAINT PKTABLE_ID_PK;
​
Table altered.
```
​
  
**Q16) PKTABLE의 제약조건을 추가해보자.**
​
  
ALTER TABLE PKTABLE  
ADD CONSTRAINT PKTABLE\_ID\_PK PRIMARY KEY(ID);  
​
```
SQL> ALTER TABLE PKTABLE
  2  ADD CONSTRAINT PKTABLE_ID_PK PRIMARY KEY(ID);
​
Table altered.
```
​
  
**Q17) UTABLE 생성 후 UNIQUE 제약조건 생성 하자.**
​
CREATE TABLE UTABLE(  
ID NUMBER CONSTRAINT U\_ID\_U UNIQUE,  
NAME VARCHAR2(10));  
  
INSERT INTO UTABLE VALUES (1,'111');  
INSERT INTO UTABLE VALUES (NULL,'111');  
INSERT INTO UTABLE VALUES (NULL,'111');  
INSERT INTO UTABLE VALUES (NULL,'111');  
  
SELECT CONSTRAINT\_NAME, CONSTRAINT\_TYPE, SEARCH\_CONDITION  
FROM USER\_CONSTRAINTS  
WHERE TABLE\_NAME = 'UTABLE';  
  
DELETE FROM UTABLE WHERE ID IS NULL;  
​
```
SQL> CREATE TABLE UTABLE(
  2  ID NUMBER CONSTRAINT U_ID_U UNIQUE,
  3  NAME VARCHAR2(10));
​
Table created.
​
SQL> INSERT INTO UTABLE VALUES (1,'111');
​
1 row created.
​
SQL> INSERT INTO UTABLE VALUES (NULL,'111');
​
1 row created.
​
SQL> INSERT INTO UTABLE VALUES (NULL,'111');
​
1 row created.
​
SQL> INSERT INTO UTABLE VALUES (NULL,'111');
​
1 row created.
​
SQL> SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE, SEARCH_CONDITION
  2  FROM USER_CONSTRAINTS
  3  WHERE TABLE_NAME = 'UTABLE';
​
CONSTRAINT_NAME                                              CO
------------------------------------------------------------ --
SEARCH_CONDITION
--------------------------------------------------------------------------------
U_ID_U                                                       U
​
​
​
SQL> DELETE FROM UTABLE WHERE ID IS NULL;
​
3 rows deleted.
​
SQL> SELECT * FROM UTABLE;
​
   ID NAME
----- --------------------
    1 111
​
SQL>
```
​
  
**Q18) UTABLE 의 제약조건 삭제하자.**
​
  
ALTER TABLE UTABLE  
DROP CONSTRAINT U\_ID\_U;
​
```
SQL> ALTER TABLE UTABLE
  2  DROP CONSTRAINT U_ID_U;
​
Table altered.
```
​
  
  
**Q19) 동일한 이름으로(U\_ID\_U) UTABLE ID와 NAME으로 테이블 레벨로 복합키를 만들자.**
​
  
ALTER TABLE UTABLE ADD CONSTRAINT U\_ID\_U UNIQUE(ID,NAME);  
INSERT INTO UTABLE VALUES (NULL,'111');  
INSERT INTO UTABLE VALUES (NULL,'111'); →  유일한 값 한번만, 중복X  
  
INSERT INTO UTABLE VALUES (22,NULL);  →  한번만  
INSERT INTO UTABLE VALUES (NULL,NULL); →  NULL은 여러번
​
```
SQL> SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE, SEARCH_CONDITION
  2  FROM USER_CONSTRAINTS
  3  WHERE TABLE_NAME = 'UTABLE';
​
CONSTRAINT_NAME                                              CO
------------------------------------------------------------ --
SEARCH_CONDITION
--------------------------------------------------------------------------------
U_ID_U                                                       U
​
​
​
SQL> INSERT INTO UTABLE VALUES (NULL,'111');
​
1 row created.
​
SQL> INSERT INTO UTABLE VALUES (NULL,'111'); -- → 유일한 값 한번만, 중복X
INSERT INTO UTABLE VALUES (NULL,'111')
*
ERROR at line 1:
ORA-00001: unique constraint (SCOTT.U_ID_U) violated
​
​
SQL> INSERT INTO UTABLE VALUES (22,NULL); →  한번만
​
1 row created.
​
SQL> INSERT INTO UTABLE VALUES (NULL,NULL); →  NULL은 여러번
​
1 row created.
​
SQL> SELECT * FROM UTABLE;
​
   ID NAME
----- --------------------
    1 111
      111
   22
​
​
SQL>
```
​
  
**Q20) 테이블 생성 후 PK 연습해보자****.**
​
  
: PK는 테이블 당 1개만 생성할 수있다.  
  UNIQUE + NOTNULL  
​
  
CREATE TABLE TABLE\_TK  
(ID CHAR(3) PRIMARY KEY,  
SNAME VARCHAR2(20));  
​
```
SQL>  CREATE TABLE TABLE_TK
  2      (ID CHAR(3) PRIMARY KEY,
  3      SNAME VARCHAR2(20));
​
Table created.
​
```
​
  
INSERT INTO TABLE\_TK VALUES('100','ORACLE');  
INSERT INTO TABLE\_TK VALUES('100','IBM'); → 참조무결성 원칙 위배로 X  
INSERT INTO TABLE\_TK VALUES(NULL,'IBM'); → PK는 NULL 허용 X  
​
```
SQL> INSERT INTO TABLE_TK VALUES('100','ORACLE');
​
1 row created.
​
SQL> INSERT INTO TABLE_TK VALUES('100','IBM'); → 참조무결성 원칙 위배로 X
INSERT INTO TABLE_TK VALUES('100','IBM')
*
ERROR at line 1:
ORA-00001: unique constraint (SCOTT.SYS_C007054) violated
​
​
SQL> INSERT INTO TABLE_TK VALUES(NULL,'IBM'); → PK는 NULL 허용 X
INSERT INTO TABLE_TK VALUES(NULL,'IBM')
                            *
ERROR at line 1:
ORA-01400: cannot insert NULL into ("SCOTT"."TABLE_TK"."ID")
```
​
  
**Q21) 테이블 생성후 PK연습해보자 : 조합 컬럼 생성**
​
  
CREATE TABLE TABLE\_PK2  
(ID CHAR(3),  
SNAME VARCHAR2(20),  
SCODE CHAR(2),  
CONSTRAINT TP2\_PK PRIMARY KEY (ID, SNAME));
​
```
SQL>  CREATE TABLE TABLE_PK2
  2      (ID CHAR(3),
  3      SNAME VARCHAR2(20),
  4      SCODE CHAR(2),
  5      CONSTRAINT TP2_PK PRIMARY KEY (ID, SNAME));
​
Table created.
```
​
  
  
INSERT INTO TABLE\_PK2 VALUES('100','ORACLE','01');  
INSERT INTO TABLE\_PK2 VALUES('200','ORACLE','01');  
INSERT INTO TABLE\_PK2 VALUES('100','ORACLE02','01'); → 모두가능  
INSERT INTO TABLE\_PK2 VALUES('100','ORACLE03','01'); → 모두가능
​
```
SQL> INSERT INTO TABLE_PK2 VALUES('100','ORACLE','01');
​
1 row created.
​
SQL> INSERT INTO TABLE_PK2 VALUES('200','ORACLE','01');
​
1 row created.
​
SQL> INSERT INTO TABLE_PK2 VALUES('100','ORACLE02','01'); → 모두가능
​
1 row created.
​
SQL> INSERT INTO TABLE_PK2 VALUES('100','ORACLE03','01'); → 모두가능
​
1 row created.
```
​
  
**Q22) 오류**  
  
CREATE TABLE TABLE\_PK3  
(ID CHAR(3), PRIMARY KEY, -- 같이 작성해야 함  
SNAME VARCHAR2(20), PRYMARY KEY, -- 같이 작성해야 함  
SCODE CHAR(2));  
​
```
SQL> CREATE TABLE TABLE_PK
  2  (ID CHAR(3), PRIMARY KEY, -- 같이 작성해야 함
  3  SNAME VARCHAR2(20), PRYMARY KEY, -- 같이 작성해야 함
  4  SCODE CHAR(2));
(ID CHAR(3), PRIMARY KEY,
                        *
ERROR at line 2:
ORA-00906: missing left parenthesis
```
​
  
  
**✔ FOREIGN KEY (외래키)**
​
: 참조 테이블의 컬럼 값과 일치 하거나 NULL 상태를 유지하도록 해야한다.
​
  
CREATE TABLE MY\_EMP  
AS  
SELECT \* FROM EMP;  
  
CREATE TABLE MY\_DEPT  
AS  
SELECT \* FROM DEPT;  
​
```
SQL> CREATE TABLE MY_EMP
  2  AS
  3  SELECT * FROM EMP;
​
Table created.
​
SQL> CREATE TABLE MY_DEPT
  2  AS
  3  SELECT * FROM DEPT;
​
Table created.
​
```
​
  
**Q23) MY\_EMP, MY\_DEPT 의 두테이블에 PK를 추가한다.**
​
  
ALTER TABLE MY\_EMP  
ADD CONSTRAINT ABC PRIMARY KEY (EMPNO);  
  
ALTER TABLE MY\_DEPT  
ADD CONSTRAINT DEF PRIMARY KEY (DEPTNO);
​
```
SQL> ALTER TABLE MY_EMP
  2  ADD CONSTRAINT ABC PRIMARY KEY (EMPNO);
​
Table altered.
​
SQL> ALTER TABLE MY_DEPT
  2  ADD CONSTRAINT DEF PRIMARY KEY(DEPTNO);
​
Table altered.
​
```
​
  
  
**제약조건 확인하기**
​
  
SELECT CONSTRAINT\_NAME, CONSTRAINT\_TYPE  
FROM USER\_CONSTRAINTS  
WHERE TABLE\_NAME = 'MY\_EMP';
​
```
SQL> SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE
  2  FROM USER_CONSTRAINTS
  3  WHERE TABLE_NAME = 'MY_EMP';
​
CONSTRAINT_NAME                                              CO
------------------------------------------------------------ --
ABC                                                          P
```
​
  
SELECT CONSTRAINT\_NAME, CONSTRAINT\_TYPE  
FROM USER\_CONSTRAINTS  
WHERE TABLE\_NAME = 'MY\_DEPT';
​
```
SQL> SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE
  2  FROM USER_CONSTRAINTS
  3  WHERE TABLE_NAME = 'MY_DEPT';
​
CONSTRAINT_NAME                                              CO
------------------------------------------------------------ --
DEF                                                          P
```
​
  
  
**✔ 컬럼 레벨 생성**
​
  : LID는 MY\_DEPT의 PRIMARY KEY 컬럼을 참조한다.
​
  
CREATE TABLE TABLE\_FK(  
ID CHAR(3),  
SNAME VARCHAR(20),  
LID NUMBER(2) REFERENCES MY\_DEPT(DEPTNO));
​
  
→ REFERENCES 참조테이블(참조컬럼)  
    참조컬럼이 무조건 PK이어야 한다.
​
```
SQL> CREATE TABLE TABLE_FK(
  2  ID CHAR(3),
  3  SNAME VARCHAR(20),
  4  LID NUMBER(2) REFERENCES MY_DEPT(DEPTNO));
​
Table created.
```
​
INSERT INTO TABLE\_FK VALUES(1,'11',10);  
INSERT INTO TABLE\_FK VALUES(1,'11',NULL);  
INSERT INTO TABLE\_FK VALUES(1,'11',50); → MY\_DEPT엔 10~40 까지만 있음, 50이 범위안에 없음  
  
​
```
SQL> INSERT INTO TABLE_FK VALUES(1,'11',10);
​
1 row created.
​
SQL> INSERT INTO TABLE_FK VALUES(1,'11',NULL);
​
1 row created.
​
SQL> INSERT INTO TABLE_FK VALUES(1,'11',50);  → MY_DEPT엔 10~40 까지만 있음, 50이 범위안에 없음
​
INSERT INTO TABLE_FK VALUES(1,'11',50)
*
ERROR at line 1:
ORA-02291: integrity constraint (SCOTT.SYS_C007060) violated - parent key not
found
```
​
  
**테이블 레벨 생성**
​
CREATE TABLE TABLE\_FK2(  
ID CHAR(3),  
SNAME VARCHAR2(20),  
LID NUMBER(2),  
CONSTRAINT T\_FK2\_LID  
FOREIGN KEY (LID) REFERENCES MY\_DEPT(DEPTNO));  
​
```
SQL> CREATE TABLE TABLE_FK2(
  2  ID CHAR(3),
  3  SNAME VARCHAR2(20),
  4  LID NUMBER(2),
  5  CONSTRAINT T_FK2_LID
  6  FOREIGN KEY (LID) REFERENCES MY_DEPT(DEPTNO));
​
Table created.
​
```
​
  
SELECT CONSTRAINT\_NAME, CONSTRAINT\_TYPE, R\_OWNER, R\_CONSTRAINT\_NAME  
FROM USER\_CONSTRAINTS  
WHERE TABLE\_NAME = 'TABLE\_FK2';
​
```
SQL> SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE, R_OWNER, R_CONSTRAINT_NAME
  2  FROM USER_CONSTRAINTS
  3  WHERE TABLE_NAME = 'TABLE_FK2';
​
CONSTRAINT_NAME                                              CO
------------------------------------------------------------ --
R_OWNER
--------------------------------------------------------------------------------
R_CONSTRAINT_NAME
------------------------------------------------------------
T_FK2_LID                                                    R
SCOTT
DEF
​
```
​
  
**Q24) TABLE\_FK2 테이블에 참조키가 없을 때 DEPTNO를 100을 입력 해놓은게 있다.  
       이후 MY\_DEPT 테이블에 참조를 하게되면 어떻게 될까****?**  
  
 
​
조건1 : T\_FK2\_LID 제약조건을 삭제한다.  
​
```
SQL> ALTER TABLE TABLE_FK2
  2  DROP CONSTRAINT T_FK2_LID;
​
Table altered.
​
SQL> DESC TABLE_FK2;
 Name                                      Null?    Type
 ----------------------------------------- -------- ----------------------------
 ID                                                 CHAR(3)
 SNAME                                              VARCHAR2(20)
 LID                                                NUMBER(2)
```
​
조건2 : INSERT INTO TABLE\_FK2 VALUES ('1', 'AAA', 10);  
          INSERT INTO TABLE\_FK2 VALUES ('2', 'AAA', 20);  
          INSERT INTO TABLE\_FK2 VALUES ('3', 'AAA', 100);
​
```
SQL> INSERT INTO TABLE_FK2 VALUES ('1','AAA',10);
​
1 row created.
​
SQL> INSERT INTO TABLE_FK2 VALUES ('2','AAA',20);
​
1 row created.
​
SQL> INSERT INTO TABLE_FK2 VALUES('3', 'AAA',100); -- LID 컬럼값이 범위보다 큼
INSERT INTO TABLE_FK2 VALUES('3', 'AAA',100)
                                        *
ERROR at line 1:
ORA-01438: value larger than specified precision allowed for this column
​
```
​
  
조건3 : MY\_DEPT 테이블이랑 참조할 수 있는 키를 추가해보자. T\_FK2\_LID
​
  
         ALTER TABLE TABLE\_FK2  
         ADD CONSTRAINT T\_FK2\_LID  
         FOREIGN KEY (LID) REFERENCES MY\_DEPT(DEPTNO);
​
```
SQL> ALTER TABLE TABLE_FK2
  2  ADD CONSTRAINT T_FK2_LID FOREIGN (LID) REFERENCES MY_DEPT(DEPTNO);
ADD CONSTRAINT T_FK2_LID FOREIGN (LID) REFERENCES MY_DEPT(DEPTNO)
                                 *
ERROR at line 2:
ORA-00902: invalid datatype
```
​
  
조건4 : 100 ROW를 삭제하고 조건 3을 해보자.  
​
```
SQL> DELETE FROM TABLE_FK2 WHERE LID = 100;
​
1 row deleted.
​
SQL>     ALTER TABLE TABLE_FK2
  2      ADD CONSTRAINT T_FK2_LID
  3      FOREIGN KEY (LID) REFERENCES MY_DEPT(DEPTNO);
​
Table altered.
```
​
  
  
**✔ 제약조건** **FOREIGN KEY** : DELETE OPTION
​
  
FOREIGN KEY 제약 조건을 생성할 때, 참조 컬럼값이 삭제되는 경우
​
FOREIGN KEY 컬럼값을 어떻게 처리할 것인지 지정가능하다.  
​
  
\[구문\]
​
  
\[CONSTRAAINT consttaint\_name\] constraint\_type ON DELETE SET NULL → 참조 값 삭제되면 NULL로만듬  
또는  
\[CONSTRAAINT consttaint\_name\] constraint\_type ON DELETE CASCADE  → 참조 값 삭제되면 같이삭제됨
​
  
CREATE TABLE MY\_DEPT02  
AS  
SELECT \* FROM DEPT;  
  
  
CREATE TABLE DEL\_EMP(  
ID NUMBER,  
MID NUMBER CONSTRAINT FKMID REFERENCES MY\_DEPT02 ON DELETE SET NULL);  
​
```
SQL>  CREATE TABLE DEL_EMP(
  2   ID NUMBER,
  3   MID NUMBER CONSTRAINT FKMID REFERENCES MY_DEPT ON DELETE SET NULL);
​
Table created.
```
​
  
INSERT INTO DEL\_EMP VALUES(1,10);  
INSERT INTO DEL\_EMP VALUES(2,20);  
​
DELETE FROM MY\_DEPT02 WHERE DEPTNO=10;
​
```
SQL> INSERT INTO DEL_EMP VALUES(1,10);
​
1 row created.
​
SQL> INSERT INTO DEL_EMP VALUES(2,20);
​
1 row created.
​
SQL> DELETE FROM MY_DEPT02 WHERE DEPTNO=10;
​
1 row deleted.
```
​
  
SELECT \* FROM DEL\_EMP; → NULL값 확인
​
```
SQL> SELECT * FROM DEL_EMP;
​
   ID   MID
----- -----
    1
    2    20
```
​
  
**  
✔ CHECK 제약조건**
​
  
CREATE TABLE TABLE\_CHECK(  
EMP\_ID CHAR(3) PRIMARY KEY,  
SAL NUMBER CHECK(SAL>0),  
MARRIAGE CHAR(1),  
CONSTRAINT CHK\_MRG CHECK(MARRIAGE IN ('Y','N')));  
​
```
SQL> CREATE TABLE TABLE_CHECK(
  2   EMP_ID CHAR(3) PRIMARY KEY,
  3   SAL NUMBER CHECK(SAL>0),
  4   MARRIAGE CHAR(1),
  5   CONSTRAINT CHK_MRG CHECK(MARRIAGE IN ('Y','N')));
```
​
  
CREATE TABLE TABLE\_CHECK02(  
HIREDATE DATE (HIREDATE < SYSDATE)); ---→ 변동값이라 X 
​
  
**✔ SEQUENCE 시퀀스** **:** 순차적으로 자동 정수값을 생성하는 객체
​
  
CREATE SEQUENCE sequence\_name  
\[INCREMENT BY N\] \[STAR WHIH N\]  
\[{MAXVALUE N : NOMAXVALUE}\], \[MINVALUE N : NOMINVALUE\]  
\[{CYCLE : NOCYCLE}\] \[CACHE N : NOCACHE\]  
  
NEXTVAL, CURRVAL
​
  
ex) CREATE SEQUENCE MY\_SEQ  
START WITH 300  
INCREMENT BY 5  
MAXVALUE 310  
NOCYCLE  
NOCACHE;  
​
```
SQL> CREATE SEQUENCE MY_SEQ
  2      START WITH 300
  3      INCREMENT BY 5
  4      MAXVALUE 310
  5      NOCYCLE
  6      NOCACHE;
​
Sequence created.
```
​
  
SELECT MY\_SEQ.NEXTVAL FROM DUAL;
​
```
SQL> SELECT MY_SEQ.NEXTVAL FROM DUAL;
​
NEXTVAL
-------
    300
​
SQL> SELECT MY_SEQ.NEXTVAL FROM DUAL;
​
NEXTVAL
-------
    305
​
SQL> SELECT MY_SEQ.NEXTVAL FROM DUAL;
​
NEXTVAL
-------
    310
```
​
  
SELECT MY\_SEQ.CURRVAL FROM DUAL; 현재값 불러옴, NEXTVAL 이후에 만 실행가능
​
```
SQL> SELECT MY_SEQ.CURRVAL FROM DUAL;
​
CURRVAL
-------
    310
```
​
  
  
ex2) CREATE SEQUENCE MY\_SEQ02  
START WITH 5  
INCREMENT BY 5  
MAXVALUE 15  
CYCLE  
NOCACHE;  
​
```
SQL> CREATE SEQUENCE MY_SEQ02
  2      START WITH 5
  3      INCREMENT BY 5
  4      MAXVALUE 15
  5      CYCLE
  6      NOCACHE;
​
Sequence created.
```
​
  
SELECT MY\_SEQ02.NEXTVAL FROM DUAL; 5  
SELECT MY\_SEQ02.NEXTVAL FROM DUAL; 10  
SELECT MY\_SEQ02.NEXTVAL FROM DUAL; 15  
SELECT MY\_SEQ02.NEXTVAL FROM DUAL; 1  
SELECT MY\_SEQ02.NEXTVAL FROM DUAL; 6  
SELECT MY\_SEQ02.NEXTVAL FROM DUAL; 11  
​
```
SQL> SELECT MY_SEQ02.NEXTVAL FROM DUAL;
​
NEXTVAL
-------
      5
​
SQL> SELECT MY_SEQ02.NEXTVAL FROM DUAL;
​
NEXTVAL
-------
     10
​
SQL> SELECT MY_SEQ02.NEXTVAL FROM DUAL;
​
NEXTVAL
-------
     15
​
SQL> SELECT MY_SEQ02.NEXTVAL FROM DUAL;
​
NEXTVAL
-------
      1
​
SQL> SELECT MY_SEQ02.NEXTVAL FROM DUAL;
​
NEXTVAL
-------
      6
​
SQL> SELECT MY_SEQ02.NEXTVAL FROM DUAL;
​
NEXTVAL
-------
     11
```
​
  
SELECT MY\_SEQ02.CURRVAL FROM DUAL; → 현재값 불러옴, NEXTVAL 이후에 만 실행가능
​
```
SQL> SELECT MY_SEQ02.CURRVAL FROM DUAL;
​
CURRVAL
-------
     11
```
