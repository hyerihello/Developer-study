**✨ VIEW의 개념을 이해하고 기술할 수 있다.**
​
**✨ PLSQL 의 문법을 이해하고 실행할 수 있다.**  
  
​
## **VIEW (뷰)**
​
  다른 테이블이나 뷰에 포함된 데이터의 맞춤 표현Tailored Presentation  
  STORED QUERY OR VIRTUAL TABLE로 간주되는 데이터베이스 객체  
  하나 또는 하나 이상의 테이블/뷰에 포함된 데이터 부분집합을 나타내는 논리적인 객체  
   → 선택적인 정보만 제공 가능  
  자체적인 데이터를 포함하지 않는다.
​
  
  ※ 베이스 테이블: 뷰를 통해 보여지는 데이터를 포함하고 있는 실제 테이블  
  
​
  
**✔ 사용 목적 및 장점**
​
  
**1\. Restricted data access **
​
  : 뷰에 접근하는 사용자는 미리 정의된 결과만 볼 수 있음   
   → 데이터 접근을 제한함으로써 중요한 데이터를 보호할 수 있다.
​
  
**2\. hide data complexity**
​
  : 여러 테이블을 조인하는 등 복잡한 sql구문을 사용하는 경우 자세한 sql구문의 내용을 숨길 수 있다.
​
  
**3\. Simplfy statement for the user**
​
  : 복잡한 sql구문을 모르는 사용자라도 select 구문만으로 결과를 조회할 수 있다.
​
  
**4\. Present the data in different perspective**
​
  : 뷰에 포함된 칼럼은 참조 대상 테이블에 영향을 주지 않고 다른 이름으로 참조 가능하다.
​
  
**5\. lsolate applcations from changes in definitions of base tables**  
  : 베이스 테이블에 포함된 여러 개의 칼럼 중 일부만 사용하도록 뷰를 생성한 경우, 뷰가 참조하지 않는 나머지 칼럼이 변경되어도 뷰를 사용하는 다른 프로그램들은 영향을 받지 않는다.
​
  
**6\. Save complex queries**
​
  : 복잡한 sql구문을 뷰 형태로 저장해서 반복적으로 사용 가능하다.
​
  
**\[생성 구문\]**
​
**  
CREATE \[OR REPLACE\] \[FORCE|NOFORCE\] VIEW view\_name\[(alias, , ,)\]**  
**AS subquery**  
**\[WITH CHECK OPTION \[CONSTRAINT constraint\_name\]\]**  
**\[WITH READ ONLY \[CONSTRAINT constraint\_name\]\]**
​
  
 **CREATE \[OR REPLACE\] :**
​
  : 지정한 뷰가 없으면 새로 생성, 동일 이름이 존재하면 수정
​
  
** FORCE**
​
  : 베이스 테이블이 존재하지 않아도 뷰 생성
​
  
** NOFORCE**
​
  : 베이스 테이블이 존재해야만이 뷰 생성 가능
​
  
** alias**
​
  : 뷰에서 사용되는 칼럼명, 생략하게 되면 subquery 가 사용한 칼럼명을 사용한다.  
    subquery에서 사용한 SELECT LIST 개수와 일치  
​
** 제약조건**  
  WITH CHECK OPTION : 뷰를 통해서 접근 가능한 데이터에 대해서만 DML 작업 허용
​
                                조건에 따라서 INSERT/UPDATE 작업제한 (DELETE는 제한 없음)  
  WITH READ ONLY : 뷰를 통해 DML 작업을 허용 안 함
​
**Q1) 계정 생성 및 권한 부여**
​
  아래 사이트를 참고하자.
​
  [https://docs.oracle.com/cd/E17781\_01/admin.112/e18585/toc.htm#XEGSG110](https://docs.oracle.com/cd/E17781_01/admin.112/e18585/toc.htm#XEGSG110)
​
[
​
Database Express Edition Getting Started Guide - Contents
​
Select Create User, and specify the necessary information. (Under System Privileges, grant ALTER SESSION, CREATE SESSION, CREATE DATABASE LINK, CREATE MATERIALIZED VIEW, CREATE PROCEDURE, CREATE PUBLIC SYNONYM, CREATE ROLE, CREATE SEQUENCE, CREATE SYNONYM,
​
docs.oracle.com
​
​
​
](https://docs.oracle.com/cd/E17781_01/admin.112/e18585/toc.htm#XEGSG110)
​
**    2Creating a Database User 메뉴 참고, **
​
```
# 1번 
SQL> create user 생성 계정이름 identified by 생성 비밀번호;
```
​
```
#2번
SQL> grant CREATE SESSION, ALTER SESSION, CREATE DATABASE LINK, -
  CREATE MATERIALIZED VIEW, CREATE PROCEDURE, CREATE PUBLIC SYNONYM, -
  CREATE ROLE, CREATE SEQUENCE, CREATE SYNONYM, CREATE TABLE, - 
  CREATE TRIGGER, CREATE TYPE, CREATE VIEW, UNLIMITED TABLESPACE -
  to 계정이름;
```
​
```
# 3번 생성나가기
SQL> exit
```
​
**Q2) SCOTT 테이블을 임포트 생성한다.**
​
```
# scott.sql 파일에서 DROP TABLE DEPT 기준, 위를 모두 삭제 한 후 사본 파일을 만든다.
# 만든 사본파일 경로를 아래와 같이 붙인다. 
# @ 경로
​
SQL> @C:\Users\hyeri\Desktop\data\myscott.sql
```
​
**Q3) VIEW 생성한다.**
​
 CREATE OR REPLACE  VIEW V\_EMP
​
 AS SELECT ENAME, DEPTNO
​
     FROM EMP
​
     WHERE DEPTNO = 30;
​
```
 CREATE OR REPLACE  VIEW V_EMP
 AS SELECT ENAME, DEPTNO
     FROM EMP
     WHERE DEPTNO = 30;
```
​
**Q4) VIEW 생성 정보 확인해보자.**  
     : USER\_ TAB\_COLS  
  
SELECT COLUMN\_NAME, DATA\_TYPE, NULLABLE  
FROM USER\_TAB\_COLS  
WHERE TABLE\_NAME = 'V\_EMP';
​
```
SELECT COLUMN_NAME, DATA_TYPE, NULLABLE
FROM USER_TAB_COLS
WHERE TABLE_NAME = 'V_EMP';
​
COLUMN_NAME                    DATA_TYPE                              N
------------------------------ -------------------------------------- -
ENAME                          VARCHAR2                               Y
DEPTNO                         NUMBER                                 Y
```
​
**Q5) 조인한 결과의 VIEW 객체를 생성해보자.**
​
  
CREATE OR REPLACE VIEW V\_EMP\_DEPT  
AS SELECT ENAME, DNAME, JOB  
FROM EMP  
LEFT JOIN DEPT USING(DEPTNO);
​
```
CREATE OR REPLACE VIEW V_EMP_DEPT
AS SELECT ENAME, DNAME, JOB
FROM EMP
LEFT JOIN DEPT USING(DEPTNO);
```
​
  
**Q6) 위 내용 확인**
​
  
SELECT \*  
FROM V\_EMP\_DEPT;
​
```
SELECT * 
FROM V_EMP_DEPT;
​
ENAME      DNAME          JOB      
---------- -------------- ---------
MILLER     ACCOUNTING     CLERK    
KING       ACCOUNTING     PRESIDENT
CLARK      ACCOUNTING     MANAGER  
FORD       RESEARCH       ANALYST  
JONES      RESEARCH       MANAGER  
SMITH      RESEARCH       CLERK    
111        SALES                   
JAMES      SALES          CLERK    
TURNER     SALES          SALESMAN 
BLAKE      SALES          MANAGER  
MARTIN     SALES          SALESMAN 
​
ENAME      DNAME          JOB      
---------- -------------- ---------
WARD       SALES          SALESMAN 
ALLEN      SALES          SALESMAN 
​
13개 행이 선택되었습니다. 
```
​
  
**Q7) ALIAS를 이용하여 테이블 칼럼에 해당하는 VIEW 객체를 생성하자.**
​
CREATE OR REPLACE VIEW V\_EMP\_DEPT02 (M\_NAME, M\_DNAME, M\_JOB)  
AS SELECT ENAME, DNAME, JOB  
FROM EMP  
LEFT JOIN DEPT USING(DEPTNO);
​
```
CREATE OR REPLACE VIEW V_EMP_DEPT02(M_NAME, M_DNAME, M_JOB)
AS SELECT ENAME, DNAME, JOB
FROM EMP
LEFT JOIN DEPT USING(DEPTNO);
​
View V_EMP_DEPT02이(가) 생성되었습니다.
```
​
**Q8) 위** **내용 확인**
​
SELECT \*  
FROM V\_EMP\_DEPT02;
​
```
SELECT * 
FROM V_EMP_DEPT02;
​
​
M_NAME     M_DNAME        M_JOB    
---------- -------------- ---------
MILLER     ACCOUNTING     CLERK    
KING       ACCOUNTING     PRESIDENT
CLARK      ACCOUNTING     MANAGER  
FORD       RESEARCH       ANALYST  
JONES      RESEARCH       MANAGER  
SMITH      RESEARCH       CLERK    
111        SALES                   
JAMES      SALES          CLERK    
TURNER     SALES          SALESMAN 
BLAKE      SALES          MANAGER  
MARTIN     SALES          SALESMAN 
​
M_NAME     M_DNAME        M_JOB    
---------- -------------- ---------
WARD       SALES          SALESMAN 
ALLEN      SALES          SALESMAN 
​
13개 행이 선택되었습니다. 
```
​
**Q9) V\_EMP** **테이블의 내용을 확인**  
​
SELECT \*  
FROM V\_EMP;
​
```
SELECT * 
FROM V_EMP;
​
ENAME      DEPTNO
---------- ------
ALLEN          30
WARD           30
MARTIN         30
BLAKE          30
TURNER         30
JAMES          30
111            30
​
7개 행이 선택되었습니다. 
```
​
  
**Q10) 베이스 테이블에 값을 추가하자**
​
INSERT INTO EMP(EMPNO, ENAME, DEPTNO) VALUES(222, 'BASETABLE',30);
​
```
INSERT INTO EMP(EMPNO, ENAME, DEPTNO) VALUES(222,'BASETABLE',30);
```
​
  
**Q11) 뷰의 객체를 확인해보자**
​
  
SELECT\*  
FROM V\_EMP; → 베이스 테이블에 추가된 데이터를 확인할 수 있다.
​
```
SELECT * 
FROM V_EMP;
​
ENAME      DEPTNO
---------- ------
ALLEN          30
WARD           30
MARTIN         30
BLAKE          30
TURNER         30
JAMES          30
111            30
BASETABLE      30
​
8개 행이 선택되었습니다. 
```
​
  
**Q12) VIEW로 추가해보자. : 실행불가**
​
  
INSERT INTO V\_EMP(EMPNO, ENAME, DEPTNO) VALUES('111',30);
​
```
INSERT INTO V_EMP(EMPNO, ENAME, DEPTNO) VALUES('111',30);
​
SQL 오류: ORA-00947: not enough values
00947. 00000 -  "not enough values"
*Cause:    
*Action:
​
# EMP TABLE PK가 있다.
```
​
  
**Q13) VIEW로 업데이트를 한 후 베이스 테이블 확인 후 출력**
​
  
UPDATE V\_EMP  
SET DEPTNO = NULL;  
  
SELECT \* FROM EMP;  
  
​
```
UPDATE V_EMP
SET DEPTNO = NULL;
​
0개 행 이(가) 업데이트되었습니다.
​
​
SELECT * FROM EMP;
​
EMPNO ENAME      JOB         MGR HIREDATE   SAL  COMM DEPTNO
----- ---------- --------- ----- -------- ----- ----- ------
 7369 SMITH      CLERK      7902 80/12/17   800           20
 7499 ALLEN      SALESMAN   7698 81/02/20  1600   300       
 7521 WARD       SALESMAN   7698 81/02/22  1250   500       
 7566 JONES      MANAGER    7839 81/04/02  2975           20
 7654 MARTIN     SALESMAN   7698 81/09/28  1250  1400       
 7698 BLAKE      MANAGER    7839 81/05/01  2850             
 7782 CLARK      MANAGER    7839 81/06/09  2450           10
 7839 KING       PRESIDENT       81/11/17  5000           10
 7844 TURNER     SALESMAN   7698 81/09/08  1500     0       
 7900 JAMES      CLERK      7698 81/12/03   950             
 7902 FORD       ANALYST    7566 81/12/03  3000           20
​
EMPNO ENAME      JOB         MGR HIREDATE   SAL  COMM DEPTNO
----- ---------- --------- ----- -------- ----- ----- ------
 7934 MILLER     CLERK      7782 82/01/23  1300           10
  111 111                                                   
  222 BASETABLE                                             
​
14개 행이 선택되었습니다.
​
​
```
​
  
□ **WITH READ ONLY**
​
  : 뷰를 통해서 접근 가능한 데이터에 대해서만DML 작업 허용
​
    조건에 따라서INSERT/UPDATE작업제한(DELETE는 제한 없음)
​
  
**Q14) WITH READ ONLY를 이용한 제약조건을 추가해보자.**
​
  
CREATE OR REPLACE VIEW V\_EMP  
AS SELECT \*  
FROM EMP  
WITH READ ONLY  
  
UPDATE V\_EMP  
SET DEPTNO = NULL;  
  
SELECT \* FROM EMP;
​
```
CREATE OR REPLACE VIEW V_EMP
AS SELECT * 
    FROM EMP
    WITH READ ONLY;
​
UPDATE V_EMP
SET DEPTNO = NULL;
​
View V_EMP이(가) 생성되었습니다.
​
​
명령의 6 행에서 시작하는 중 오류 발생 -
UPDATE V_EMP
SET DEPTNO = NULL
오류 발생 명령행: 7 열: 5
오류 보고 -
SQL 오류: ORA-42399: cannot perform a DML operation on a read-only view
42399.0000 - "cannot perform a DML operation on a read-only view"
​
# READ ONLY 이기 때문에 DML 불가
```
​
  
**Q15) 테스트 베이스 테이블 생성하자**
​
  
CREATE TABLE EMP\_TEST  
AS SELECT ENAME, SAL  
FROM EMP  
WHERE 1=0;  
  
ALTER TABLE EMP\_TEST  
ADD MARRIAGE CHAR(2);  
  
DESC EMP\_TEST  
  
INSERT INTO EMP\_TEST VALUES(1,3000, 'Y');  
INSERT INTO EMP\_TEST VALUES(2,3000, 'Y');  
INSERT INTO EMP\_TEST VALUES(3,2000, 'N');  
INSERT INTO EMP\_TEST VALUES(4,1000, 'Y');  
INSERT INTO EMP\_TEST VALUES(5,4000, 'N');  
INSERT INTO EMP\_TEST VALUES(6,6000, 'Y');
​
```
CREATE TABLE EMP_TEST
AS SELECT ENAME, SAL
FROM EMP
WHERE 1=0;
​
ALTER TABLE EMP_TEST
ADD MARRIAGE CHAR(2);
​
DESC EMP_TEST
​
INSERT INTO EMP_TEST VALUES(1,3000,'Y');
INSERT INTO EMP_TEST VALUES(2,3000,'Y');
INSERT INTO EMP_TEST VALUES(3,2000,'N');    
INSERT INTO EMP_TEST VALUES(4,1000,'Y');
INSERT INTO EMP_TEST VALUES(5,4000,'N');
INSERT INTO EMP_TEST VALUES(6,6000,'Y');
​
```
​
**Q16) 옵션을 지정한 다음 DML을 확인하자.**  
  
CREATE OR REPLACE VIEW V\_EMP  
AS SELECT \*  
FROM EMP\_TEST  
WHERE MARRIAGE = 'N'  
WITH CHECK OPTION; → WHERE문에 조건에 맞는 값을 체크해서 DML을 수행하겠다.  
INSERT INTO EMP\_TEST VALUES(7,5000, 'Y'); → 베이스 테이블은 데이터가 추가되는 것을 확인할 수 있다.
​
```
CREATE OR REPLACE VIEW V_EMP
AS SELECT *
    FROM EMP_TEST
    WHERE MARRIAGE = 'N'
    WITH CHECK OPTION;
INSERT INTO EMP_TEST VALUES(7,5000,'Y');
​
ENAME        SAL MA
---------- ----- --
6           6000 Y 
8           5000 N 
1           3000 Y 
2           3000 Y 
3           2000 N 
4           1000 Y 
5           4000 N 
6           6000 Y 
7           5000 Y 
8           5000 N 
1           3000 Y 
...
```
​
  
**Q17) ITH CHECK OPTION 있는 VIEW 테이블에 값을 추가해보자.**
​
  
INSERT INTO V\_EMP VALUES(8,5000, 'N');
​
```
INSERT INTO V_EMP VALUES(8,5000,'N');
​
1 행 이(가) 삽입되었습니다.
```
​
**Q18) USER\_VIEWS**
​
SELECT VIEW\_NAME, TEXT  
FROM USER\_VIEWS  
WHERE VIEW\_NAME = 'V\_EMP';
​
```
SELECT VIEW_NAME, TEXT
FROM USER_VIEWS
WHERE VIEW_NAME = 'V_EMP';
​
VIEW_NAME                      TEXT                                                                            
------------------------------ --------------------------------------------------------------------------------
V_EMP                          SELECT "ENAME","SAL","MARRIAGE"                                                 
                               FROM EMP_TEST                                                                   
                               WHERE MARRIAGE = 'N'                                                            
                               WITH CHECK OP
```
​
  
**Q19) 별칭에 "" 구현하자**
​
  
CREATE OR REPLACE VIEW V\_EMP\_DEPT02 ("M\_NAME", "M\_DNAME", "M\_JOB")  
AS SELECT ENAME, DNAME, JOB  
FROM EMP  
LEFT JOIN DEPT USING(DEPTNO);
​
  
SELECT M\_NAME, M\_JOB  
FROM V\_EMP\_DEPT02  
WHERE M\_JOB = 'CLERK'; -- 오류가 나면 "M\_JOB"으로 구현한다.
​
```
CREATE OR REPLACE VIEW V_EMP_DEPT02 ("M_NAME", "M_DNAME","M_JOB")
AS SELECT ENAME, DNAME, JOB
FROM EMP
LEFT JOIN DEPT USING(DEPTNO);
​
SELECT M_NAME, M_JOB
FROM V_EMP_DEPT02
WHERE M_JOB = 'CLERK';
​
​
​
​
M_NAME     M_JOB    
---------- ---------
SMITH      CLERK    
JAMES      CLERK    
MILLER     CLERK  
```
​
  
CREATE VIEW V\_EMP\_DEPT02("M\_NAME", "M\_DNAME", "M\_JOB")  
AS SELECT ENAME, DNAME, JOB  
FROM EMP  
LEFT JOIN DEPT USING(DEPTNO);
​
  
**Q20) 뷰를 삭제해보자.**
​
DROP VIEW V\_EMP\_DEPT02;
​
```
M_NAME     M_JOB    
---------- ---------
SMITH      CLERK    
JAMES      CLERK    
MILLER     CLERK    
​
View V_EMP_DEPT02이(가) 삭제되었습니다.
```
​
  
**Q21) 뷰(VIEW)를 이용해서 부서별 평균 월급보다 더 많은 받는 사원과 월급을 출력해보자.**
​
  
CREATE OR REPLACE VIEW V\_DEPT\_SALAVG("Did", "Davg")  
AS SELECT NVL(DEPTNO,10),  
ROUND(AVG(SAL),-1)  
FROM EMP  
GROUP BY DEPTNO;  
  
SELECT \* FROM V\_DEPT\_SALAVG;
​
```
CREATE OR REPLACE VIEW V_DEPT_SALAVG("Did","Davg")
AS SELECT NVL(DEPTNO,10),
        ROUND(AVG(SAL),-1)
        FROM EMP
        GROUP BY DEPTNO;
        
SELECT * FROM V_DEPT_SALAVG;
​
View V_DEPT_SALAVG이(가) 생성되었습니다.
​
​
       Did       Davg
---------- ----------
        10       1570
        20       2260
        10       2920
```
​
  
  
SELECT ENAME, SAL  
FROM EMP  
JOIN V\_DEPT\_SALAVG ON (NVL(DEPTNO,10) = "Did")  
WHERE SAL > "Davg"  
ORDER BY 2 DESC;
​
```
SELECT ENAME, SAL
FROM EMP
JOIN V_DEPT_SALAVG ON (NVL(DEPTNO,10) = "Did")
WHERE SAL > "Davg"
ORDER BY 2 DESC;
​
ENAME             SAL
---------- ----------
KING             5000
KING             5000
FORD             3000
JONES            2975
BLAKE            2850
CLARK            2450
ALLEN            1600
​
7개 행이 선택되었습니다. 
```
​
  
**Q22) 인라인 뷰(INLINE VIEW)를 사용하여 위와 같은 결과를 구현하자.**
​
SELECT ENAME, SAL  
FROM (SELECT NVL(DEPTNO,10) AS "Did",  
ROUND(AVG(SAL),-1) AS "Davg"  
FROM EMP  
GROUP BY DEPTNO) V\_DEPT\_SALAVG  
  
JOIN EMP ON (NVL(DEPTNO,10) = V\_DEPT\_SALAVG."Did")  
WHERE SAL > V\_DEPT\_SALAVG."Davg"  
ORDER BY 2 DESC;
​
```
SELECT ENAME, SAL
FROM (SELECT NVL(DEPTNO,10) AS "Did",
        ROUND(AVG(SAL),-1) AS "Davg"
        FROM EMP
        GROUP BY DEPTNO) V_DEPT_SALAVG
​
JOIN EMP ON (NVL(DEPTNO,10) = V_DEPT_SALAVG."Did")
WHERE SAL > V_DEPT_SALAVG."Davg"
ORDER BY 2 DESC;
​
​
ENAME        SAL
---------- -----
KING        5000
KING        5000
FORD        3000
JONES       2975
BLAKE       2850
CLARK       2450
ALLEN       1600
​
7개 행이 선택되었습니다. 
```
​
  
**✔ VIEW - 데이터 조회 절차**
​
뷰를 사용한 SQL 구문 해석  
 → 데이터 딕셔너리 "USER\_VIEWS"에서 뷰 정의 검색
​
 → SQL 구문을 실행한 계정이 관련된 데이터 베이스 테이블에 접근하여 SELECT 할 수 있는권한이 있는지 확인  
 → 뷰 대신 베이스 테이블을 기반으로 하는 동등한 작업으로 변환  
 → 베이스 테이블을 대상으로 데이터 조회
​
## **PL/SQL**
​
  (Procedural Language / sql /Oracle's Procedural language extension to SQL)의 약어
​
  
  오라클 DB 환경에서 실행되는 절차적인 데이터 베이스 프로그래밍 언어  
  PL/SQL에서는 프로그램 단위를BLOCK이라고 부르며 애플리케이션 로직들을 작성  
  변수 정의, 조건 처리, 반복문, Procedure Language이다.  
모듈화 \_pl/sql장점  
​
**\[형식\]  
 << label >> (optional)**  
** DECLARE -- Declarative part (optional)**  
** -- Declarations of local types, variables, & subprograms**  
  
** BEGIN -- Executable part (required)**  
** -- Statements (which can use items declared in declarative part)**  
  
** \[EXCEPTION -- Exception-handling part (optional)**  
** -- Exception handlers for exceptions (errors) raised in executable part\]**  
** END;**  
  
   ※ cmd에서 사용할 경우SET SERVEROUTPUT ON. 를 써야 한다.
​
```
SQL> set serveroutput on
SQL> BEGIN
  2  DBMS_OUTPUT.DISABLE;
  3  DBMS_OUTPUT.PUT_LINE('11111111');
  4  DBMS_OUTPUT.ENABLE;
  5  DBMS_OUTPUT.PUT_LINE('2222222');
  6  END;
  7  /
2222222
​
PL/SQL procedure successfully completed.
​
SQL> /
2222222
​
PL/SQL procedure successfully completed.
​
```
​
**Q1) 'HELLO WORLD' 출력**
​
프로시저 → 새 프로시저
​
create or replace PROCEDURE EX\_PRO AS   
BEGIN  
  DBMS\_OUTPUT.PUT\_LINE('1.HELLO WORLD.');  
END EX\_PRO;
​
[##_Image|kage@cO0nsS/btq6fT9jBZw/bnE79xiXiStxrYSZtOkjmK/img.png|alignCenter|data-origin-width="807" data-origin-height="461" data-ke-mobilestyle="widthOrigin"|||_##]
​
**Q2) '현재의 값은? 20 ' 출력**
​
create or replace PROCEDURE EX\_PRO01 AS   
    i number := 20;  
BEGIN  
DBMS\_OUTPUT.PUT\_LINE('현재의 값은? ' ||i);  
  
END EX\_PRO01;
​
[##_Image|kage@d9k8dA/btq6f9RKQpA/gZnAxUcKh1pbpelqfr44fK/img.png|alignCenter|data-origin-width="710" data-origin-height="473" data-ke-mobilestyle="widthOrigin"|||_##]
​
 → CMD 창
​
```
SQL>
declare
    i integer :=20;
begin
    DBMS_OUTPUT.PUT_line( i || '+'|| j|| '='|| (i+j));
end;
/
```
​
**Q3) ' 100 + 200 = 300 ' 출력**
​
create or replace PROCEDURE EX\_PRO02 AS  
 i integer := 100; -- i number로 해도 됨  
 j integer := 200;  
  
BEGIN  
  DBMS\_OUTPUT.PUT\_line( i || '+'|| j|| '='|| (i+j));  
END EX\_PRO02;
​
[##_Image|kage@cqMVLr/btq6iljttWK/R1SLWWnkqyhZK7BTsh09v1/img.png|alignCenter|data-origin-width="721" data-origin-height="542" data-ke-mobilestyle="widthOrigin"|||_##]
​
**Q4) IF절 사용**
​
create or replace PROCEDURE EX\_PRO03 AS   
I INT := 10;  
BEGIN  
  IF I != 20 THEN  
  DBMS\_OUTPUT.PUT\_LINE('I=' ||I);  
  END IF;  
END EX\_PRO03;
​
[##_Image|kage@sBxiR/btq6heZkDNL/xZpsJvNdyufkPkFfNDcgL0/img.png|alignCenter|data-origin-width="746" data-origin-height="570" data-ke-mobilestyle="widthOrigin"|||_##]
​
**Q5) 다중 조건문을 이용해서 각 점수의 평가를 A~F 내보자. **
​
create or replace PROCEDURE EX\_PRO04 AS   
 SCORE01 INT := 85;  
 GRADE VARCHAR2(3);  
 -- 다중 조건문을 이용해서 각 점수의 평가를 A~F 내보자.   
BEGIN  
 IF SCORE01 >= 90 THEN GRADE := 'A';  
 ELSIF SCORE01 >= 80 THEN GRADE := 'B';  
 ELSIF SCORE01 >= 70 THEN GRADE := 'C';  
 ELSIF SCORE01 >= 60 THEN GRADE := 'D';  
 ELSE GRADE := 'F';  
 END IF;  
 DBMS\_OUTPUT.PUT\_LINE('SCORE : '||SCORE01|| 'GRADE :' ||GRADE);  
END EX\_PRO04;
​
[##_Image|kage@RedMc/btq6ilRjFBg/hgXKuZyk6KZ9S8Wg8k7yjK/img.png|alignCenter|data-origin-width="739" data-origin-height="630" data-ke-mobilestyle="widthOrigin"|||_##]
