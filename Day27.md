## **Transaction**

Transaction 이란 논리 작업 단위를 형성하는 DML문의 모음을 말한다.  
예를들어, 은행업무 데이터베이스에서 은행 고객이 보통 예금에서 당좌 예금으로 금액을 이체하는 경우,  
보통예금 잔액 감소,, 당좌 예금 잔액 증가 및 트랜잭션 기록이라는 세 가지 작업을 묶어서 하나의 Transaction이라 한다.

이 세 가지 작업 중 하나라도 수행되지 못하면, 나머지 작업도 최소 되어야 만 해당 계정에 정확한 잔액이 유지될 수 있다.

  
**✔ 트랜 잭션이란??**

  
하나 혹은 두 개 이상의 SQL 문들로 이루어진 작업의 논리적인 단위  
하나의 트랜잭션 안의 모든 SQL은 동일한 효과를 내며 성공하면 전부 성공하고 실패하면 전부 실패한다.  
  하나의 트랜잭션은 커밋(COMMIT)될 수도 있고 롤백(ROLLBACK) 될 수도 있다..  
 

  
**😎 알고 가기 **

  
트랜잭션은 실행 가능한 첫 번째 SQL문이 실행될 때 시작되어 다음 이벤트가 발생하면 종료된다.  
  1. COMMIT 또는 ROLLBACK 문이 실행된 경우  
  2. DCL(Data Control Language : GRANT, REVOKE) 문이  3. 사용자(Client)가 SQL\*PLUS SQL\*PLUS를 종료하는 경우  
  4. 시스템에 장애가 있거나 시스템이 고장 난 경우  
  5. DDL문 (Data Definition Language : CREATE TABLE, ALTER, DROP, RENAME)이 실행된 경우  
  

  DDL 실패 시 ORACLE은 DDL문 전 후에도 암시적 COMMIT을 실행하므로

  DDL문이 성공적으로 실행되지 않는 경우에도 서버가 실행한 커밋 때문에 이전 명령문은 롤백할 수 없다.  
 트랜잭션이 종료되면, 실행 가능한 다음 SQL문이 다음 트랜잭션을 자동으로 시작한다.

  
**✔ 명시적 TRANSACTION 제어**

  
  **COMMIT**

    : 보류 중인 모든 데이터 변경 내용을 영구히 저장하고 현재의 트랜잭션을 종료한다.  
  **SAVEPOINT NAME(별칭)**

    : 현재의 트랜잭션 내에 저장점을 표시한다.  
  **ROLLBACK**

   : 보류 중 인모든 데이터의 변경 내용을 버리고 현재의 트랜잭션을 종료한다.  
  **ROLLBACK TO SAVEPOINT NAME**

   : 현재의 트랜잭션을 지정된 저장점으로 ROLLBACK 하여 저장점 이후에 생성된 모든 변경 내용 및 저장점을 버린다.

  
**✔ 암시적 TRANSACTION 제어**

**자동** **COMMIT**

    : DDL, DCL문이 수행되는 경우, SQL\*PLUS가 정상적으로 종료되는 경우  
**자동** **ROLLBACK**

   : SQL\*PLUS가 비정상적으로 종료되는 경우 , 시스템에 장애가 있을 때  

  
**✔ SAVEPOINT **

하나의 트랜잭션 내에서 각각의 SQL문이 실행되었던 시점을 구분하는 데 사용한다.  
아주 긴 작업을 수행하다가 한 번의 실수로 모든 작업을 ROLLBACK 한다면 그동안 작업 내용까지 모두 취소가 될 경우가 발생되어 예비 책으로 사용된다.  
   트랜잭션 중간중간에 특정 시점을 표시해두면 실수한 트랜잭션만 취소할 수 있다.

  
ex)

INSERT INTO TEST002 VALUES (99, '인사과', '서울');  
SAVEPOINT A; _\-- INSERT_ _문의 실행까지 표시_  
UPDATE TEST001  
SET MGR = 7902  
WHERE EMPNO = 7934;  
ROLLBACK TO A; _\-- UPDATE 문만 실행 취소되며 INSERT__문의 트랜잭션은 유효_  
DELETE FROM EMP;  
COMMIT ; _\-- SAVEPOINT A 이후에 실행된 INSERT 와 DELETE문의 결과가 테이블에 영구 적용된다.._

```
SQL> INSERT INTO TEST002 VALUES(99, '인사과', '서울');
 1 row created.

SQL> SAVEPOINT A;
 Savepoint created.
 
 SQL> SELECT * FROM TEST002;

DEPTNO DNAME                        LOC
------ ---------------------------- --------------------------
    10 ACCOUNTING                   NEW YORK
    20 RESEARCH                     DALLAS
    30 SALES                        CHICAGO
    40 OPERATIONS                   BOSTON
    99 인사과                       서울
    
SQL> UPDATE TEST001
2 SET MGR = 7902
3 WHERE EMPNO = 7934;

1 row updated.

SQL> SELECT * FROM TEST001;

EMPNO ENAME                JOB                  MGR HIREDATE   SAL  COMM DEPTNO
----- -------------------- ------------------ ----- -------- ----- ----- ------
 7369 SMITH                CLERK               7902 80/12/17   800           20
 7499 ALLEN                SALESMAN            7698 81/02/20  1600   300     30
 7521 WARD                 SALESMAN            7698 81/02/22  1250   500     30
 7566 JONES                MANAGER             7839 81/04/02  2975           20
 7654 MARTIN               SALESMAN            7698 81/09/28  1250  1400     30
 7698 BLAKE                MANAGER             7839 81/05/01  2850           30
 7782 CLARK                MANAGER             7839 81/06/09  2450           10
 7839 KING                 PRESIDENT                81/11/17  5000           10
 7844 TURNER               SALESMAN            7698 81/09/08  1500     0     30
 7900 JAMES                CLERK               7698 81/12/03   950           30
 7902 FORD                 ANALYST             7566 81/12/03  3000           20

EMPNO ENAME                JOB                  MGR HIREDATE   SAL  COMM DEPTNO
----- -------------------- ------------------ ----- -------- ----- ----- ------
 7934 MILLER               CLERK               7902 82/01/23  1300           10

12 rows selected.

SQL> ROLLBACK TO A; -- UPDATE 문만 실행 취소되며 INSERT문의 트랜잭션은 유효

Rollback complete.

SQL> DELETE FROM TEST001;

12 rows deleted.


SQL> COMMIT; -- SAVEPOINT A 이후에 실행된 INSERT 와 DELETE문의 결과가 테이블에 영구적용된다.
```

  
**✔ 동시 제어**  

  **LOCK**

      : 동시에 수행되는 트랜잭션 간에 파괴적인 상호작용을 방지한다.  
       트랜잭션 수행기간 동안LOCK은 유지된다.

  배타적(exclusive(exclusive lock)

     : DML 문에서 수정하는 각 행에 자동으로 배타적 잠금이 수행된다.  
      트랜잭션이 종료될 때까지 다른 트랜잭션에서 해당행을 변경하지 못하도록 한다.  
이 잠금은 다른 사용자가 동시에 동일한 행을 수정하지 못하도록 하고 아직 완료되지 않은 변경 내용을

      다른 사용자가 덮어쓰지 못하도록 한다.  

  공유(SHERE LOCK)

     : DML 작업 도중 테이블 레벨에서 자동으로 수행된다.  
      공유 잠금 모드에서는 여러 트랜잭션이 동일한 자원에 대해 공유 잠금을 획득할 수 있다.  
       → DML : 테이블 공유 잠금,, 행은 배타적 잠금 수행된다.  
→ 잠금은 COMMIT, ROLLBACK 시 자동 해제된다..

  **DEADLOCK**

     : 둘 이상의 트랜잭션이 서로 상대방의 LOCK을 순환 대기하여 어떤 트랜잭션도 더 이상 진행할 수 없는 상태 말한다.

**😎 알고 가기 **

오라클이 주기적으로 자동으로 DETECT 하여 에러를 리턴한다.  
  
     1. 데드락 상태는 두 명 이상의 USER가 서로  LOCK을 걸고있는 객체에 대기하고 있을 때 발생한다.  
     2. 현재 세션에 데드락이 발생하는 경우  
        > 다른 세션이 비 호환 모드에서 자원의 락을 실행할 경우  
        > 현재 세션이 자원을 요구하는 경우  
        > 현재 세션에 비해 비 호환 모드에서 LOCK 처리된 자원을 다른 세션이 기다리는 경우  

    º 오라클 서버는 데드락 상태를 감지한 명령문을 롤백하여 데드락 상태를 자동으로 감지하고 해결한다.   
  

---

  
✨ 테이블 생성에 관한 구문을 이해하고 설정 할 수 있다.  
✨ 제약 조건의 특징 및 동작을 이해하고, 적절한 제약 조건을 테이블에 설정 할 수 있다.  
✨ VIEW, SEQUENCE, INDEX, SYNONYM 을 생성, 변경 및 삭제 할 수 있다.

**ORACLE 의 OBJECT 종류**

   : TABLE (데이터저장), INDEX (질의의 효율성), VIEW (하나 이상의 테이블 데이터집합),  
     SEQUENCE (기본 키 값을 생성), SYNONYM(객체에 다른 이름을 제공)

  
**✔ 오브젝트 관련 DDL의 명령어**

    : CREATE, ALTER, DROP, RENAME, COMMENT,  
      TRUNCATE (테이블에 저장되어있는 모든 행을 삭제할때사용)

  
**✔ TABLE (데이터 저장)** 

    : SYS 사용자는 모든 데이터 딕셔너리 테이블(사용자이름, 권한, 객체이름, 테이블 제약조건 등)을 소유한다 .

ex) 사용자가 소유한 테이블

      : SELECT CALLUMN , , FROM TABLENAME;  

   사용자가 소유한 오브젝트 이름과 종류를 확인  
      : SELECT OBJECT\_NAME, OBJECT\_TYPE  
        FROM USER\_OBJECTS;

**✔ 데이터 딕셔너리뷰**  

**USER\_ :** 사용자 소유하는 객체에 관한 정보  
**ALL\_ :** 사용자가 엑세스 할 수 있는 모든 테이블에 관한 정보  
**DBA\_:** DBA ROLE을 할당받은 사용자만 액세스가 가능하다.  
**V$ :** 데이터 베이스 서버의 성능, 메모리 및 잠금에 대한 동성 성능 뷰

  
**\[테이블 생성형식\]**

  
**CREATE TABLE \[schema.\] TABLE\_NAME → 문자시작, 1~30자, 사용자 내에 유일한 명칭, 예약어 X 대소문자구분X**  
**(COLUMN DATATYPE \[DEFAULT...\] , , )**

  
CREATE TABLE EMP\_TEST(  
EMPID NUMBER(4),  
ENAME VARCHAR2(10),  
SAL NUMBER(7) DEFAULT 100,  
HIREDATE DATE DEFAULT SYSDATE); **→** NEXTVAL, CURRVAL, 다른열의 이름은 올 수없다.  
  

**문자**

: CHAR(2000 : 고정길이), VARCHAR2(4000:가변길이), VARCHAR(2000:가변길이)  
  NCHAR(2000 : 고정길이 유니코드) : UTF8 = SIZE \* 3BYTE, AL16UTF16 = SIZE\*2BYTE  
  NCHAR2(4000:고정길이 유니코드),  
  LONG (2G : 가변길이의 문자데이터)  

**숫자**

: NUMBER(\[PREC 전체자리수, SCALE 소수이하자리)\] : 가변숫자 21BYTE 최대값  
  BINARY\_FLOAT : 32BIT 부동소수 \= 4BYTE  
  BINARY\_DOUBLE : 64BIT 부동소수 \= 8BYTE  

**날짜**

: DATE = 7BYTE = BC4712년 1월1일 부터 9999년도 12월 31일 까지  
  
**LOB**

: CLOB : LONG타입의 확장형태/ 큰 문자 데이터 저장/ 최대 4G  
  BLOB : 바이너리로 형태저장 / 이미지, 영상, 음성 / 최대 4G  
  NCLOB : NATIONAL CHARCACTER SET 로 저장/최대 4G  
  BFILE : 외부 운영체제에서 파일 시스템에 저장, 테이블의 접근가능  

  
**ANSI 타입 오라클 변화타입**

  
1\. CHARATER (N) -------------------------------> CHAR(N)  
2\. CHARACTER VARYING(N) -------------------> VARCHAR (N)  
3\. NATIONAL CHARACTER(N) -----------------> NCHR(N)  
4\. NATIONAL CHARACTER YARYING(N) ------> NVARCHAR(N)  
5\. DECIMAL -------------------------------------> NUMBER  
6\. INTEGER, INT, SAMALLINT ------------------> NUMBER (38)  
7\. FLOAT, REAL, DOUBLE ----------------------> NUMBER

  
  
**✔ 테이블 변경**

  
**새로운 컬럼 추가**

  
 ALTER TABLE table\_name ADD(  
 column datatype \[defalut expr\] , , , )  
  
**기존 컬럼의 수정** : 자리수, 컬럼에 데이터가 없을 경우 타입을 수정

  
 ALTER TABLE table\_name MODIFY(  
 column datatype \[defalut expr\] , , , )

  
**✔ 컬럼지정**  

**SET UNUESD COLUMN** : 컬럼을 삭제 할 수 있도록 표시하고 실제 테이블에서 컬럼이 제거되지 않는다.  
                                 SELECT \*, DESCRIBEE 문을 실행해도 표시되지 않는다.

ALTER TABLE table\_name  
SET UNUSED COLUMN column\_name;

  
**DROP UNUSED COLUMN** : UNUESD 로 표시된 모든 컬럼을 제거한다.  
테이블에서 UNUSED 열로 부터 디스크 공간을 회수 하려고 사용한다.  
  
ALTER TABLE table\_name  
DROP UNUSED COLUMNS ;

  
ex) ALTER TABLE BOOK SET UNUSED COLUMN (AUTHOR);  
     ALTER TABLE BOOK SET DROP UNUESD COLUMNS;

  
**✔컬럼삭제**

  
기존 컬럼의 삭제 : 반드시 테이블에 하나 이상의 열은 존재해야한다.

  
  ALTER TABLE table\_name DROP(column);  
  ALTER TABLE table\_name DROP COLUMN column;  
  
ex) ALTER TABLE BOOK DROP (AUTHOR);  
  
**TRUNCATE TABLE문** : 테이블의 모든 행을 제거한다. 저장공간 해제, 롤백할 수 없다.  
TRUNCATE TABLE table\_name;
