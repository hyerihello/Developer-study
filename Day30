**Q1) 1에서 10까지 반복하여 TEST1 테이블에 저장하라 (FOR문 사용)**
​
CREATE TABLE TEST1(BUNHO NUMBER(3),  
                          IRUM VARCHAR2(10));  
  
​
```
CREATE TABLE TEST1(BUNHO NUMBER(3),
                          IRUM VARCHAR2(10));
​
Table created.
```
​
SET SERVEROUTPUT ON
​
  
BEGIN  
FOR I IN 1..10 LOOP  
INSERT INTO TEST1 VALUES (I,SYSDATE);  
END LOOP;  
END;  
 /
​
```
SERVEROUTPUT ON -- 1번만 사용
BEGIN
FOR I IN 1..10 LOOP -- 문법 점 두개 
    INSERT INTO TEST1 VALUES (I,SYSDATE);
END LOOP;
END;
 /
​
PL/SQL procedure successfully completed.
```
​
```
SELECT * FROM TEST1;
​
     BUNHO IRUM
---------- --------------------
         1 21/06/01
         2 21/06/01
         3 21/06/01
         4 21/06/01
         5 21/06/01
         6 21/06/01
         7 21/06/01
         8 21/06/01
         9 21/06/01
        10 21/06/01
​
10 rows selected.
```
​
  
​
**Q2) 1~50까지 출력하자 \[현재의 I 값은? ○○이다\] → FOR LOOP**
​
DECLARE -- 선언문  
I INT := 0;
​
  
BEGIN  
  FOR I IN 1..50 LOOP  
         DBMS\_OUTPUT.PUT\_LINE('현재의 I값은?' || I|| '이다');  
  END LOOP;  
END;  
/
​
```
DECLARE -- 선언문
I INT := 0;
​
​
BEGIN
  FOR I IN 1..50 LOOP
         DBMS_OUTPUT.PUT_LINE('현재의 I값은?' || I|| '이다');
  END LOOP;
END;
/
```
​
```
현재의 I값은?1이다
현재의 I값은?2이다
현재의 I값은?3이다
현재의 I값은?4이다
현재의 I값은?5이다
현재의 I값은?6이다
현재의 I값은?7이다
현재의 I값은?8이다
현재의 I값은?9이다
현재의 I값은?10이다
현재의 I값은?11이다
현재의 I값은?12이다
현재의 I값은?13이다
현재의 I값은?14이다
현재의 I값은?15이다
현재의 I값은?16이다
현재의 I값은?17이다
현재의 I값은?18이다
현재의 I값은?19이다
현재의 I값은?20이다
현재의 I값은?21이다
현재의 I값은?22이다
현재의 I값은?23이다
현재의 I값은?24이다
현재의 I값은?25이다
현재의 I값은?26이다
현재의 I값은?27이다
현재의 I값은?28이다
현재의 I값은?29이다
현재의 I값은?30이다
현재의 I값은?31이다
현재의 I값은?32이다
현재의 I값은?33이다
현재의 I값은?34이다
현재의 I값은?35이다
현재의 I값은?36이다
현재의 I값은?37이다
현재의 I값은?38이다
현재의 I값은?39이다
현재의 I값은?40이다
현재의 I값은?41이다
현재의 I값은?42이다
현재의 I값은?43이다
현재의 I값은?44이다
현재의 I값은?45이다
현재의 I값은?46이다
현재의 I값은?47이다
현재의 I값은?48이다
현재의 I값은?49이다
현재의 I값은?50이다
​
PL/SQL procedure successfully completed.
​
SQL>
```
​
**Q3) 구구단에 홀 수 단만 출력 해보자 (MOD함수)**
​
DECLARE  
   TOTAL NUMBER := 0;  
BEGIN  
   FOR I IN 2..9 LOOP  
         IF MOD(I,2) <> 0 THEN -- 홀수단  
             DBMS\_OUTPUT.PUT\_LINE(I || '단');  
             DBMS\_OUTPUT.PUT\_LINE('==============');  
             FOR J IN 1..9 LOOP  
                   TOTAL := I \* J;  
                   DBMS\_OUTPUT.PUT\_LINE(I || '\*' || J || '='|| TOTAL ||'');  
             END LOOP;  
          END IF;  
END LOOP;  
END;  
/
​
```
DECLARE
   TOTAL NUMBER := 0;
BEGIN
   FOR I IN 2..9 LOOP
         IF MOD(I,2) <> 0 THEN -- 홀수단
             DBMS_OUTPUT.PUT_LINE(I || '단');
             DBMS_OUTPUT.PUT_LINE('==============');
             FOR J IN 1..9 LOOP
                   TOTAL := I * J;
                   DBMS_OUTPUT.PUT_LINE(I || '*' || J || '='|| TOTAL ||'');
             END LOOP;
          END IF;
END LOOP;
END;
/
```
​
```
3단
==============
3*1=3
3*2=6
3*3=9
3*4=12
3*5=15
3*6=18
3*7=21
3*8=24
3*9=27
5단
==============
5*1=5
5*2=10
5*3=15
5*4=20
5*5=25
5*6=30
5*7=35
5*8=40
5*9=45
7단
==============
7*1=7
7*2=14
7*3=21
7*4=28
7*5=35
7*6=42
7*7=49
7*8=56
7*9=63
9단
==============
9*1=9
9*2=18
9*3=27
9*4=36
9*5=45
9*6=54
9*7=63
9*8=72
9*9=81
​
PL/SQL procedure successfully completed.
​
SQL>
```
​
**Q4) LOOP 무한 반복 명령 (END LOOP) - 반복 탈출 (EXIT);**
​
  
※  1~50  
DECLARE  
     I INT := 10;  
BEGIN  
     LOOP  
           DBMS\_OUTPUT.PUT\_LINE('현재 값 I 값은' || TO\_CHAR(I,'0099') || '이다'); -- I로도 해보기  
           I := I+1;  
           IF I > 50 THEN  
              EXIT;  
           END IF;  
     END LOOP;  
END;  
/
​
```
SQL> DECLARE
  2       I INT := 10;
  3  BEGIN
  4       LOOP
  5             DBMS_OUTPUT.PUT_LINE('현재 값 I 값은' || TO_CHAR(I,'0099') || '이다'); -- I로도 해보기
  6             I := I+1;
  7             IF I > 50 THEN
  8                EXIT;
  9             END IF;
 10       END LOOP;
 11  END;
 12  /
현재 값 I 값은 0010이다
현재 값 I 값은 0011이다
현재 값 I 값은 0012이다
현재 값 I 값은 0013이다
현재 값 I 값은 0014이다
현재 값 I 값은 0015이다
현재 값 I 값은 0016이다
현재 값 I 값은 0017이다
현재 값 I 값은 0018이다
현재 값 I 값은 0019이다
현재 값 I 값은 0020이다
현재 값 I 값은 0021이다
현재 값 I 값은 0022이다
현재 값 I 값은 0023이다
현재 값 I 값은 0024이다
현재 값 I 값은 0025이다
현재 값 I 값은 0026이다
현재 값 I 값은 0027이다
현재 값 I 값은 0028이다
현재 값 I 값은 0029이다
현재 값 I 값은 0030이다
현재 값 I 값은 0031이다
현재 값 I 값은 0032이다
현재 값 I 값은 0033이다
현재 값 I 값은 0034이다
현재 값 I 값은 0035이다
현재 값 I 값은 0036이다
현재 값 I 값은 0037이다
현재 값 I 값은 0038이다
현재 값 I 값은 0039이다
현재 값 I 값은 0040이다
현재 값 I 값은 0041이다
현재 값 I 값은 0042이다
현재 값 I 값은 0043이다
현재 값 I 값은 0044이다
현재 값 I 값은 0045이다
현재 값 I 값은 0046이다
현재 값 I 값은 0047이다
현재 값 I 값은 0048이다
현재 값 I 값은 0049이다
현재 값 I 값은 0050이다
​
PL/SQL procedure successfully completed.
​
SQL>
```
​
**Q5) EMP 테이블에서 부서번호 10인 사원 평균 급여를 출력하는 익명의 블록을 완성해보자.**
​
SELECT AVG(SAL)  
FROM EMP  
WHERE DEPTNO = 10  
GROUP BY DEPTNO;  
  
DECLARE  
   AVG01 NUMBER(7) := 0;  
   DEPTNO01 NUMBER(7) := 10;  
BEGIN  
   SELECT AVG(SAL) INTO AVG01 -- 변수 담기  
   FROM EMP  
   WHERE DEPTNO = DEPTNO01  
   GROUP BY DEPTNO;  
DBMS\_OUTPUT.PUT\_LINE(DEPTNO01 || '번 부서의 부서 평균 급여는 \[' || AVG01 || '\]원 입니다.');  
END;  
/
​
```
SQL> SELECT AVG(SAL)
  2      FROM EMP
  3      WHERE DEPTNO = 10
  4      GROUP BY DEPTNO;
​
  AVG(SAL)
----------
2916.66667
​
SQL>
SQL>     DECLARE
  2          AVG01 NUMBER(7) := 0;
  3          DEPTNO01 NUMBER(7) := 10;
  4      BEGIN
  5          SELECT AVG(SAL) INTO AVG01 -- 변수 담기
  6          FROM EMP
  7          WHERE DEPTNO = DEPTNO01
  8          GROUP BY DEPTNO;
  9          DBMS_OUTPUT.PUT_LINE(DEPTNO01 || '번 부서의 부서 평균 급여는 [' || AVG01 || ']원 입니다.');
 10      END;
 11  /
10번 부서의 부서 평균 급여는 [2917]원 입니다.
```
​
  
**Q6) 20번 부서에 \[5\]명에 대한 평균 급여는 \[2175\]원 이다.  익명으로 풀어보자.**  
     = EMP 테이블에서 20번 부서의 개수, 평균 급여를 구하자.  
  
SELECT COUNT(DEPTNO), AVG(SAL)  
FROM EMP  
WHERE DEPTNO = 20;
​
DECLARE  
   COUNT01 NUMBER(7) := 0;  
   DEPTNO01 NUMBER(7) := 20;  
   AVGSAL NUMBER(7) := 0;  
BEGIN  
   SELECT COUNT(DEPTNO), AVG(SAL) INTO COUNT01, AVGSAL  
   FROM EMP  
   WHERE DEPTNO = DEPTNO01  
   GROUP BY DEPTNO;  
DBMS\_OUTPUT.PUT\_LINE(DEPTNO01 || '번 부서에' ||COUNT01||'명에 대한 평균급여는' ||AVGSAL');  
END;  
/
​
```
SQL> SELECT COUNT(DEPTNO), AVG(SAL)
  2  FROM EMP
  3  WHERE DEPTNO = 20;
​
COUNT(DEPTNO)   AVG(SAL)
------------- ----------
            3    3859.79
​
SQL> DECLARE
  2  COUNT01 NUMBER(7) := 0;
  3  DEPTNO01 NUMBER(7) := 20;
  4  AVGSAL NUMBER(7) := 0;
  5  BEGIN
  6  SELECT COUNT(DEPTNO), AVG(SAL) INTO COUNT01, AVGSAL
  7  FROM EMP
  8  WHERE DEPTNO = DEPTNO01
  9  GROUP BY DEPTNO;
 10  DBMS_OUTPUT.PUT_LINE(DEPTNO01 || '번 부서에'|| COUNT01 ||'명 에 대한 평균급여는' ||AVGSAL);
 11  END;
 12  /
 
20번 부서에3명 에 대한 평균급여는3860 
PL/SQL procedure successfully completed.
​
SQL>
```
​
  
**Q7) ACCEPT 변수와 PROMPT  '출력문장' → 사용자 입력 라인 값을 읽어서 변수에 저장 %TYPE**
​
  
  
ACCEPT A  
100  
ACCEPT A PROMPT 'INPUT'  
INPUT100  
ACCEPT A PROMPT 'INPUT :'  
INPUT : A  
A  
SP2-0004: Nothing to append.  
  
​
```
SQL> ACCEPT A
100
SQL> ACCEPT A PROMPT 'INPUT'
INPUT100
SQL> ACCEPT A PROMPT 'INPUT :'
INPUT : A
SQL> A -- INPUT 을 이용해서 리턴받자
SP2-0004: Nothing to append.
SQL>
```
​
  
**#  사번을 입력해서 이름을 리턴받자**  
​
ACCEPT INPUT\_VAL PROMPT '사번 입력 :'
​
7902  
DECLARE  
   MY\_NAME EMP.ENAME%TYPE; -- MY\_NAME VARCHAR2(10);  
BEGIN  
   SELECT ENAME INTO MY\_NAME  
   FROM EMP  
   WHERE EMPNO = &INPUT\_VAL; -- INPUT\_VAL주소를 리턴, 외부참조 리턴  
DBMS\_OUTPUT.PUT\_LINE('현재의 결과는' || MY\_NAME);  
END;  
/
​
```
SQL> ACCEPT INPUT_VAL PROMPT '사번 입력 :'
사번 입력 :7902
SQL> DECLARE
  2      MY_NAME  EMP.ENAME%TYPE; -- MY_NAME VARCHAR2(10); 과 동일
  3  BEGIN
  4      SELECT ENAME INTO MY_NAME
  5      FROM EMP
  6      WHERE EMPNO = &INPUT_VAL; -- INPUT_VAL주소를 리턴, 외부참조 리턴
  7      DBMS_OUTPUT.PUT_LINE('현재의 결과는' || MY_NAME);
  8  END;
  9  /
old   6:     WHERE EMPNO = &INPUT_VAL; -- INPUT_VAL주소를 리턴, 외부참조 리턴
new   6:     WHERE EMPNO = 7902; -- INPUT_VAL주소를 리턴, 외부참조 리턴
현재의 결과는FORD
​
PL/SQL procedure successfully completed.
```
​
  
  
**Q8) 20번 부서의 인원수는 \[?\] 이고 평균급여 \[?\] 이다.  \[?등급\]이다**
​
  
_조건 : 2100 이상이면 'A'_  
_        2000 이상이면 'B'_  
_       1500 이상이면 'C'_  
_       1000 이상이면 'D'_  
_        ... F_
​
DECLARE
​
    V\_CNT NUMBER(3) :=0;
​
    V\_AVG NUMBER(7) := 0;  
    V\_DEPTNO EMP.DEPTNO%TYPE;  
    V\_GRADE VARCHAR2(3) ;  
  
BEGIN
​
   V\_DEPTNO := 20;  
   SELECT COUNT(\*), AVG(E.SAL) INTO V\_CNT, V\_AVG  
   FROM EMP E  
   WHERE DEPTNO = V\_DEPTNO  
GROUP BY E.DEPTNO;  
  
  IF V\_AVG >= 2100 THEN  V\_GRADE := 'A' ;  
  ELSIF V\_AVG >= 2000 THEN  V\_GRADE := 'B' ;  
  ELSIF V\_AVG >= 1500 THEN  V\_GRADE := 'C' ;  
  ELSIF V\_AVG >= 1000 THEN  V\_GRADE := 'D' ;  
  ELSE  V\_GRADE := 'F';  
  END IF;  
  
DBMS\_OUTPUT.PUT\_LINE(V\_DEPTNO || '의 부서 갯수(명수)는 \[' || V\_CNT ||'\] 이고
​
평균점수는 \[' ||V\_AVG|| '\] 점 \[' || V\_GRADE ||'\] 등급입니다.');  
END;  
/
​
```
SQL> DECLARE
  2   V_CNT NUMBER(3) :=0;
  3   V_AVG NUMBER(7) :=0;
  4   V_DEPTNO EMP.DEPTNO%TYPE;
  5   V_GRADE VARCHAR2(3);
  6
  7  BEGIN
  8
  9     V_DEPTNO := 20;
 10     SELECT COUNT(*), AVG(E.SAL) INTO V_CNT, V_AVG
 11     FROM EMP E
 12     WHERE DEPTNO = V_DEPTNO
 13  GROUP BY E.DEPTNO;
 14
 15    IF V_AVG >= 2100 THEN  V_GRADE := 'A' ;
 16    ELSIF V_AVG >= 2000 THEN  V_GRADE := 'B' ;
 17    ELSIF V_AVG >= 1500 THEN  V_GRADE := 'C' ;
 18    ELSIF V_AVG >= 1000 THEN  V_GRADE := 'D' ;
 19    ELSE  V_GRADE := 'F';
 20    END IF;
 21
 22  DBMS_OUTPUT.PUT_LINE(V_DEPTNO || '의 부서 갯수(명수)는 [' || V_CNT ||'] 이고
 23
 24  평균점수는 [' ||V_AVG|| '] 점 [' || V_GRADE ||'] 등급입니다.');
 25  END;
 26  /
20의 부서 갯수(명수)는 [3] 이고
​
평균점수는 [3860] 점 [A] 등급입니다.
​
PL/SQL procedure successfully completed.
```
​
---
​
## **PROCEDURE**
​
**프로시저란?**  
특정 작업을 수행 할 수 있고 이름이 있는 PL/SQL 블록으로써 매개 변수를 받을 수도 있고 반복적으로 사용할 수 있다.  
보통 연속실행 또는 구현이 복잡한 트랜잭션을 수행하는 PL/SQL 블록을 데이터 베이스에 저장하기 위해서 생성한다.
​
  
**트랜잭션**
​
  : 작업의 단위, 일련의 작업 등을 하나의 프로세서(EXE)로 취하는 것
​
  
**\[형식\]**
​
**  
CREATE PROCEDURE p\_name**  
**           IN args , → 실행 환경에서 값 을 전달  
           OUT arg → 값 을 리턴  
           IN OUT arg →  전달, 리턴 한다.**  
**is**  
**      변수선언  
begin**  
**     end p\_name;**
​
**\# 프로시저를 만들고 조회해 보자**
​
CREATE PROCEDURE update\_sal(v\_empno in number)  
is  
BEGIN  
  update emp set sal = sal + 100  
  where empno = v\_empno;  
commit;  
END update\_sal;  
  
  
EXECUTE UPDATE\_SAL(7369);  
EXEC UPDATE\_SAL(7369)로 써도 됨  
​
```
SQL> CREATE PROCEDURE update_sal(v_empno in number)
  2  is
  3  BEGIN
  4  update emp set sal = sal + 100
  5  where empno = v_empno;
  6  commit;
  7  END update_sal;
  8  /
​
Procedure created.
​
SQL> SELECT EMPNO, SAL
  2  FROM EMP
  3  WHERE EMPNO = 7369;
​
     EMPNO        SAL
---------- ----------
      7369        800
​
SQL> EXECUTE UPDATE_SAL(7369);
​
PL/SQL procedure successfully completed.
​
SQL> SELECT EMPNO, SAL
  2  FROM EMP
  3  WHERE EMPNO = 7369;
​
     EMPNO        SAL
---------- ----------
      7369        900
```
