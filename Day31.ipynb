**Q1) 부서 번호 20번인 사원의 부서 번호, 이름, 봉급을 구하는 프로시저를 만들자**
​
\[워크시트\]
​
SELECT EMPNO, ENAME, SAL --INTO V\_EMPNO, V\_ENAME, V\_SAL  
FROM EMP  
WHERE DEPTNO = 20;  
  
SET SERVEROUTPUT ON
​
EXEC EMP\_EX01
​
```
SELECT EMPNO, ENAME, SAL --INTO V_EMPNO, V_ENAME, V_SAL
FROM EMP
WHERE DEPTNO = 20;
# ===== 1. 워크시트 창에 출력할 내용 생성
# ===== 2. EMP_EX01 프로시저 생성 (아래코드참고)
​
SET SERVEROUTPUT ON
EXEC EMP_EX01
# ===== 3. SET SERVEROUPTPUT ON 선언 후 EMP_EX01 프로시저 출력
```
​
\[EMP\_EX01 프로시저\]
​
```
--ex01)부서번호 20번인 사원의 부서번호, 이름, 봉급을 구하는 프로시저를 만들자
​
/*
  1. CURSOR user_name is query : 하나이상의 ROW를 담을 객체
  2. OPEN user_name 실행 코드에서 커서를 시작한다.
  3. LOOP, FETCH를 이용해서 값을 선언된 변수에 대입
  4. CLOSE user_name 으로 객체를 담는다
*/
​
CREATE OR REPLACE PROCEDURE EMP_EX01 AS 
    -- SELECT 에서 리턴받을 변수 선언
    V_EMPNO EMP.EMPNO%TYPE; 
    V_ENAME EMP.ENAME%TYPE;
    V_SAL NUMBER(7,2);
​
-- 1. CURSOR user_name is query : 하나이상의 ROW를 담을 객체
    CURSOR EMP_CURSOR IS
        SELECT EMPNO, ENAME, SAL
        FROM EMP
        WHERE DEPTNO = 20;
        
BEGIN
-- 2. OPEN user_name 실행 코드에서 커서를 시작한다.
    OPEN EMP_CURSOR;
-- 3. LOOP, FETCH를 이용해서 값을 선언된 변수에 대입
    LOOP
    FETCH EMP_CURSOR INTO V_EMPNO, V_ENAME, V_SAL;
    EXIT WHEN EMP_CURSOR%NOTFOUND OR EMP_CURSOR%ROWCOUNT > 5;
    DBMS_OUTPUT.PUT_LINE(V_EMPNO|| ' ' ||V_ENAME|| ' ' ||V_SAL);
    END LOOP;
    
-- 4. CLOSE user_name 으로 객체를 담는다
    CLOSE EMP_CURSOR;
END EMP_EX01;
```
​
\[결과\]
​
```
7369 SMITH 900
7566 JONES 2975
7902 FORD 3100
​
​
PL/SQL 프로시저가 성공적으로 완료되었습니다.
```
​
**Q2) 사원테이블에서 사원의 이름과 봉급을 출력해보자.**
​
SELECT ENAME, SAL  
FROM EMP;  
  
EXECUTE EX\_VIEW;
​
\[워크시트\]
​
```
SELECT ENAME, SAL
FROM EMP;
​
EXECUTE EX_VIEW;
```
​
\[프로시저\]
​
```
# ==== 변수를 이용해 출력
​
CREATE OR REPLACE PROCEDURE EX_VIEW AS
    V_ENAME EMP.ENAME%TYPE;
    V_SAL EMP.SAL%TYPE;
​
    CURSOR EMP_CURSOR01 IS
        SELECT ENAME, SAL
        FROM EMP;
BEGIN
  OPEN EMP_CURSOR01;
  LOOP
  FETCH EMP_CURSOR01 INTO V_ENAME, V_SAL;
  EXIT WHEN EMP_CURSOR01%NOTFOUND;
  DBMS_OUTPUT.PUT_LINE('사원이름 : '||V_ENAME||' , '|| '월급 : ' ||V_SAL);
  END LOOP;
  CLOSE EMP_CURSOR01;
END EX_VIEW;
```
​
\[결과\]
​
```
사원이름 : SMITH , 월급 : 900
사원이름 : ALLEN , 월급 : 1600
사원이름 : WARD , 월급 : 1250
사원이름 : JONES , 월급 : 2975
사원이름 : MARTIN , 월급 : 1250
사원이름 : BLAKE , 월급 : 2850
사원이름 : CLARK , 월급 : 2450
사원이름 : KING , 월급 : 5000
사원이름 : TURNER , 월급 : 1500
사원이름 : JAMES , 월급 : 1050
사원이름 : FORD , 월급 : 3100
사원이름 : MILLER , 월급 : 1300
사원이름 : 111 , 월급 : 
사원이름 : BASETABLE , 월급 : 
​
​
PL/SQL 프로시저가 성공적으로 완료되었습니다.
```
​
```
# ==  ROW TYPE 이용한 출력 
​
CREATE OR REPLACE PROCEDURE EX_VIEW AS
    RES_ROW EMP%ROWTYPE;
​
    CURSOR RES IS
        SELECT ENAME, SAL
        FROM EMP;
BEGIN
  OPEN RES;
  LOOP
  FETCH RES INTO RES_ROW.ENAME, RES_ROW.SAL;
  EXIT WHEN RES%NOTFOUND OR RES%ROWCOUNT >3; -- 3개만출력
  DBMS_OUTPUT.PUT_LINE(RES%ROWCOUNT||'사원이름 : '||RES_ROW.ENAME||' , '|| '월급 : ' ||RES_ROW.SAL);
  END LOOP;
  CLOSE RES;
END EX_VIEW;
```
​
\[결과\]
​
```
1사원이름 : SMITH , 월급 : 900
2사원이름 : ALLEN , 월급 : 1600
3사원이름 : WARD , 월급 : 1250
​
​
PL/SQL 프로시저가 성공적으로 완료되었습니다.
```
​
**Q3) 사원테이블에서 커미션이 측정된 사원의 이름과 봉급, 커미션을 출력해보자.**
​
  
EXEC EX\_VIEW01;
​
```
# ===== * 을 이용해 모든 EMP 통해 출력
​
CREATE OR REPLACE PROCEDURE EX_VIEW01 AS
 R_EMP EMP%ROWTYPE;
 CURSOR RES IS
 SELECT * --- 모든 객체수
 FROM EMP
 WHERE COMM IS NOT NULL;
 
BEGIN
 OPEN RES;
 LOOP
 FETCH RES INTO R_EMP; --- 객체 수가 맞아야함
 EXIT WHEN RES%NOTFOUND;
 DBMS_OUTPUT.PUT_LINE(R_EMP.ENAME|| ' ' || R_EMP.SAL ||' '||R_EMP.COMM);
 
 END LOOP;
 CLOSE RES;
END EX_VIEW01;
```
​
```
# 객체 일부만 지정
​
CREATE OR REPLACE PROCEDURE EX_VIEW01 AS
 R_EMP EMP%ROWTYPE;
 CURSOR RES IS
 SELECT ENAME, SAL, COMM -- 출력할 객체 3개
 FROM EMP
 WHERE COMM IS NOT NULL;
 
BEGIN
 OPEN RES;
 LOOP
 FETCH RES INTO R_EMP.ENAME, R_EMP.SAL, R_EMP.COMM; -- 출력할 객체 3개 받아주자 
 EXIT WHEN RES%NOTFOUND;
 DBMS_OUTPUT.PUT_LINE(R_EMP.ENAME|| ' ' || R_EMP.SAL ||' '||R_EMP.COMM);
 
 END LOOP;
 CLOSE RES;
END EX_VIEW01;
```
​
\[결과\]
​
```
ALLEN 1600 300
WARD 1250 500
MARTIN 1250 1400
TURNER 1500 0
​
​
PL/SQL 프로시저가 성공적으로 완료되었습니다.
```
​
**Q4) 부서번호를 커서로 전달해서 해당 사원의 번호, 이름, 봉급을 출력해보자.**  
  
​
\[워크시트\]
​
```
SELECT EMPNO, ENAME, SAL
FROM EMP
WHERE DEPTNO = 10; -- V_DEPTNO
​
SELECT EMPNO, ENAME, SAL
FROM EMP
WHERE DEPTNO = 20; -- V_DEPTNO
​
EXEC EMP_EX04;
```
​
\[프로시저\]
​
```
--ex04)부서번호를 커서로 전달해서 해당 사원의 번호, 이름, 봉급을 출력해보자.
CREATE OR REPLACE PROCEDURE EMP_EX04 AS 
 V_EMPNO EMP.EMPNO%TYPE; -- 변수선언
 V_ENAME EMP.ENAME%TYPE;
 V_SAL NUMBER(7,2);
 
 CURSOR EMP_CURSOR (V_DEPTNO NUMBER) IS
     SELECT EMPNO, ENAME, SAL
     FROM EMP
     WHERE DEPTNO = V_DEPTNO;
 
BEGIN
    OPEN EMP_CURSOR(10); -- 값을 대입해서 출력 할 수 있다.
    LOOP 
    FETCH EMP_CURSOR INTO V_EMPNO, V_ENAME, V_SAL;
    EXIT WHEN EMP_CURSOR%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE(V_EMPNO || ' ' ||V_ENAME||' '||V_SAL);
    END LOOP;
    CLOSE EMP_CURSOR;
    
    OPEN EMP_CURSOR(20);
    LOOP 
    FETCH EMP_CURSOR INTO V_EMPNO, V_ENAME, V_SAL;
    EXIT WHEN EMP_CURSOR%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE(V_EMPNO || ' ' ||V_ENAME||' '||V_SAL);
    END LOOP;
    CLOSE EMP_CURSOR;
END EMP_EX04;
```
​
\[결과\]
​
```
7782 CLARK 2450
7839 KING 5000
7934 MILLER 1300
7369 SMITH 900
7566 JONES 2975
7902 FORD 3100
​
​
PL/SQL 프로시저가 성공적으로 완료되었습니다.
```
​
**□ 명시적 커서 확인(SQL%)**
​
 1) SQL%ROWCOUNT : 해당 SQL문에 영향을 받는 행의 수  
 2) SQL%FOUND : 해당 SQL문에 영향을 받는 행의 수가 1개 이상일 경우 TRUE  
 3) SQL%NOTFOUND : 해당 SQL문에 영향을 받는 행의 수가 없는 경우 TRUE  
 4) SQL&ISOPEN : 항상FALSE, 암시적 커서가 열려있는지 유무
​
**Q5) 사원 번호를 입력 받아 해당 사원이 있다면 봉급을 1.1% 인상하자.**
​
\[워크시트\]
​
```
EXEC EMP_EX05(7369);
```
​
\[프로시저\]
​
```
--ex05) 사원 번호를 입력 받아 해당 사원이 있다면 봉급을 1.1% 인상하자.
​
create or replace PROCEDURE EMP_EX05(P_EMPNO IN EMP.EMPNO%TYPE) AS 
    V_SAL EMP.SAL%TYPE;
    V_UPDATE_ROW NUMBER; 
    
 -- 커서를 만들어서 SELECT결과를 저장한다음, 오픈하고, 코드, 클로즈 했다.    
BEGIN
  SELECT SAL INTO V_SAL
  FROM EMP
  WHERE EMPNO = P_EMPNO;
  
  --명시적 커서 확인(SQL%)
  IF SQL%FOUND THEN -- 해당 SQL문에 영향을 받는 행의 수가 1개 이상일 경우 TRUE
    DBMS_OUTPUT.PUT_LINE('검색한 데이터가 존재한다 :'||V_SAL);
    
    UPDATE EMP
    SET SAL = SAL*1.1
    WHERE EMPNO = P_EMPNO;
    
    V_UPDATE_ROW := SQL%ROWCOUNT; -- 해당 SQL문에 영향을 받는 행의 수
    DBMS_OUTPUT.PUT_LINE('급여가 인상된 사원의 수 :'||V_UPDATE_ROW);
  END IF;
END EMP_EX05;
```
​
\[결과\]
​
```
검색한 데이터가 존재한다 :3417.77
급여가 인상된 사원의 수 :1
​
​
PL/SQL 프로시저가 성공적으로 완료되었습니다.
```
​
**Q6) 사원번호를 입력해서 무슨 부서인지를 프로시저로 리턴 받아보자.**
​
\[워크시트\]
​
```
 VAR V_RES VARCHAR2(50);
 EXEC EMP_EX06(7782, :V_RES);
 PRINT V_RES;
```
​
```
--ex06) 사원번호를 입력해서 무슨 부서인지를 프로시저로 리턴받아보자.
​
CREATE OR REPLACE PROCEDURE EMP_EX06
    (P_EMPNO IN EMP.EMPNO%TYPE, V_RES OUT VARCHAR2) AS
                                -- OUT의 객체로 자동 리턴된다.
    V_DEPTNO EMP.DEPTNO%TYPE;
    
BEGIN
  SELECT DEPTNO INTO V_DEPTNO
  FROM EMP
  WHERE EMPNO = P_EMPNO;
  
  IF V_DEPTNO = 10 THEN
    V_RES := 'ACCOUNTING 부서사원이야 ';
  ELSIF V_DEPTNO = 20 THEN
    V_RES := 'RESEACH 부서야 ';
  ELSIF V_DEPTNO = 30 THEN
    V_RES := 'SALES 부서야 ';
  END IF;
  
END EMP_EX06;
```
​
\[결과\]
​
```
PL/SQL 프로시저가 성공적으로 완료되었습니다.
​
​
V_RES
--------------------------------------------------------------------------------
ACCOUNTING 부서사원이야 
```
​
**Q7) 이름을 입력하면 직업을 리턴하는 코드를 작성하자. (IN OUT 사용)**
​
\[워크시트\]
​
```
 VAR RES VARCHAR2(50);
 EXEC :RES := 'KING';
 EXEC EMP_EX07(:RES);
 PRINT RES;
```
​
\[프로시저\]
​
```
CREATE OR REPLACE PROCEDURE EMP_EX07
    (V_JOB IN OUT VARCHAR2) AS -- OUT
    V_ENAME EMP.ENAME%TYPE;
    
BEGIN
    V_ENAME := V_JOB;  -- IN
    SELECT JOB INTO V_JOB
    FROM EMP
    WHERE ENAME = V_ENAME;
END EMP_EX07;
```
​
\[결과\]
​
```
PL/SQL 프로시저가 성공적으로 완료되었습니다.
​
​
RES
--------------------------------------------------------------------------------
PRESIDENT
​
```
​
**Q8) JOB을 입력하면 같은 JOB이 같은 값 출력**
​
\[워크시트\]
​
```
VAR EX_08 REFCURSOR;
EXEC EMP_EX08('SALESMAN', :EX_08);
PRINT EX_08
​
```
​
\[프로시저\]
​
```
create or replace PROCEDURE EMP_EX08 
(P_JOB VARCHAR2, P_EMP_REFCUR IN OUT SYS_REFCURSOR) -- 커서를이용해 대입
-- ↑ IN              ↑OUT
AS 
BEGIN
  OPEN P_EMP_REFCUR FOR -- OPEN FOR = LOOP
                    SELECT EMPNO, ENAME 
                    FROM EMP 
                    WHERE JOB = P_JOB; -- 여기까지가 문장이 끝임 
END EMP_EX08;
```
​
\[결과\]
​
```
PL/SQL 프로시저가 성공적으로 완료되었습니다.
​
​
​
     EMPNO ENAME     
---------- ----------
      7499 ALLEN     
      7521 WARD      
      7654 MARTIN    
      7844 TURNER 
```
​
**Q9) 프로시저 안에 프로시저를 받고 커서로 리턴한다.**
​
\[워크시트\]
​
```
EXEC EMP_EX09;
```
​
\[프로시저\]
​
```
create or replace PROCEDURE EMP_EX09 AS
    V_EMPNO EMP.EMPNO%TYPE;
    V_ENAME EMP.ENAME%TYPE;
    V_JOB EMP.JOB%TYPE := 'SALESMAN';
    V_EMP_REFCUR SYS_REFCURSOR; -- DATATYPE
    
BEGIN
  DBMS_OUTPUT.PUT_LINE('EMPLOYEES WITH JOB' ||V_JOB);
  DBMS_OUTPUT.PUT_LINE('EMPNO ENAME');
  DBMS_OUTPUT.PUT_LINE('----  --------');
  
  EMP_EX08(V_JOB, V_EMP_REFCUR);
  -- OPEN 키워드 숨어져있음 
  LOOP
  FETCH V_EMP_REFCUR INTO V_EMPNO, V_ENAME;
  EXIT WHEN V_EMP_REFCUR%NOTFOUND;
  DBMS_OUTPUT.PUT_LINE(V_EMPNO ||'    '||V_ENAME);
  
  END LOOP;
  CLOSE V_EMP_REFCUR;
  
END EMP_EX09;
```
​
\[결과\]
​
```
EMPLOYEES WITH JOBSALESMAN
EMPNO ENAME
----  --------
7499    ALLEN
7521    WARD
7654    MARTIN
7844    TURNER
​
​
PL/SQL 프로시저가 성공적으로 완료되었습니다
```
