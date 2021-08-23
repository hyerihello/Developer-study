**✨ 테이블 데이터 조작을 구현하는 명령을 수행할 수 있다.**
​
**✨ INSERT문을 이용한 테이블 새로운 행 추가  
✨ UPDATE문을 기존 데이터 수정  
✨ DELETE문을 이용한 기존 제이터 삭제  
✨ MARGE 문을 이용한 테이블 병합.**  
  
​
## **INSERT **
​
**\[형식\]**
​
**  INSERT INTO TABLE(\[칼럼명, , ,\]) → 칼럼명은 명시하지 않아도 됨  
  VALUES(값, , , );**
​
  
    - 테이블에 열 목록을 사용하지 않는 경우에는 테이블의 기존 열 순서에 따라 모두 나열해야 한다.  
    - 열 목록은 테이블의 순서와 같을 필요는 없다.  
       INSERT INTO EMP(DEPTNO, ENAME) VALUES (50, '888');  
    - VALUES절에 나열된 열의 순서와 개수는 INSERT 절에 나열된 열의 순서 및 개수와 같아야 한다..  
    - 문자 및 날짜 같은 작은따옴표로 묶는다.  
    - 숫자 값을 작은따옴표를 묶으면 암시적 변환이 발생할 수 있다.  
    - 입력할 데이터가 없을 경우 NULL로 또는 ' ' 대입한다.
​
만일 제약 조건에 DEFAULT가 있다면 DEFAULT값으로 저장된다.
​
```
CREATE TABLE TEST
AS
SELECT * FROM EMP;
```
​
  
  
**Q1)**
​
** # 특정행을 삽입해 보자.**
​
  INSERT INTO TEST (EMPNO, ENAME, HIREDATE)  
  VALUES (7233, 'PAUL', SYSDATE);
​
```
SQL> INSERT INTO TEST(EMPNO, ENAME, HIREDATE)
  2  VALUES (7233, 'PAUL', SYSDATE);
​
1 row created.
​
SQL> SELECT * FROM TEST;
​
EMPNO ENAME                JOB                  MGR HIREDATE   SAL  COMM DEPTNO
----- -------------------- ------------------ ----- -------- ----- ----- ------
 7233 PAUL                                          21/05/26
​
```
​
  
  
**Q2)**
​
** # 사원의 번호, 사용자 이름, 봉급을 입력해 보자.**
​
    (7234, USER, 3400)  
  
 INSERT INTO TEST(EMPNO, ENAME, SAL)  
 VALUES (7234, USER, 3400);
​
```
SQL> INSERT INTO TEST(EMPNO, ENAME, SAL)
  2       VALUES (7234, USER, 3400);
​
1 row created.
​
SQL> SELECT * FROM TEST;
​
EMPNO ENAME                JOB                  MGR HIREDATE   SAL  COMM DEPTNO
----- -------------------- ------------------ ----- -------- ----- ----- ------
 7234 SCOTT                                                   3400
 7902                                                         3000
 7369 SMITH                                                    800
 7499 ALLEN                                                   1600   300
 7521 WARD                                                    1250   500
 7566 JONES                                                   2975
 7654 MARTIN                                                  1250  1400
 7698 BLAKE                                                   2850
 7782 CLARK                                                   2450
 7839 KING                                                    5000
 7844 TURNER                                                  1500     0
​
EMPNO ENAME                JOB                  MGR HIREDATE   SAL  COMM DEPTNO
----- -------------------- ------------------ ----- -------- ----- ----- ------
 7900 JAMES                                                    950
 7934 MILLER                                                  1300
​
13 rows selected.
​
SQL>
```
​
  
  
**Q3)**
​
**  # 날짜 값을 입력해보자. TO\_DATE()**
​
  INSERT INTO TEST (EMPNO, ENAME, HIREDATE)  
  VALUES (7533, 'EVLIS', TO\_DATE('1997-02-05', 'YYYY-MM-DD'));  
  
  INSERT INTO TEST (EMPNO, ENAME, HIREDATE)  
  VALUES (7535, 'EVLIS02', TO\_DATE('1997/02/05', 'YYYY-MM-DD'));  
  
  INSERT INTO TEST (EMPNO, ENAME, HIREDATE)  
  VALUES (7535, 'EVLIS02', TO\_DATE('1997-02-07'));
​
```
SQL> INSERT INTO TEST(EMPNO, ENAME, HIREDATE)
  2  VALUES (7533, 'EVIS', TO_DATE('1997-02-05','YYYY-MM-DD'));
​
1 row created.
​
SQL> INSERT INTO TEST(EMPNO, ENAME, HIREDATE)
  2  VALUES (7535, 'EVLIS02', TO_DATE('1997/02/05', 'YYYY-MM-DD'));
​
1 row created.
​
SQL> INSERT INTO TEST(EMPNO, ENAME, HIREDATE)
  2  VALUES(7535, 'EVLIS02', TO_DATE('1997-02-07'));
  
1 row created.
​
 # ======= L23-25 보면 HIREDATE가 같은 양식으로 입력된다 YY/MM/DD =========
​
SQL> SELECT * FROM TEST;
​
EMPNO ENAME                JOB                  MGR HIREDATE   SAL  COMM DEPTNO
----- -------------------- ------------------ ----- -------- ----- ----- ------
 7234 SCOTT                                                   3400
 7533 EVLIS                                         97/02/05                     #
 7535 EVLIS02                                       97/02/05                     #
 7535 EVLIS02                                       97/02/07                     #
 7902                                                         3000
 7369 SMITH                                                    800
 7499 ALLEN                                                   1600   300
 7521 WARD                                                    1250   500
 7566 JONES                                                   2975
 7654 MARTIN                                                  1250  1400
 7698 BLAKE                                                   2850
​
EMPNO ENAME                JOB                  MGR HIREDATE   SAL  COMM DEPTNO
----- -------------------- ------------------ ----- -------- ----- ----- ------
 7782 CLARK                                                   2450
 7839 KING                                                    5000
 7844 TURNER                                                  1500     0
 7900 JAMES                                                    950
 7934 MILLER                                                  1300
​
16 rows selected.
​
SQL>
```
​
  
  
** Q4)**
​
   **□ INSERT 구문 SUBQUERY**
​
     : INSERT 절의 열의 수와 서브 쿼리의 열의 수가 일치해야 한다.  
       한 번에 여러 개의 행을 입력할 수 있다.
​
**  \[형식\]**
​
  
**  INSERT INTO TABLE \[ \]**  
**  SUBQUERY;**
​
**  # EMP 테이블 사원중에 A가 들어있는 사원의 정보만 NEW\_EMP로 입력하자.**
​
```
# ======= NEW_EMP ========
CREATE TABLE NEW_EMP(
ID NUMBER(4)
NAME VARCHAR2(10));
​
CREATE TABLE NEW_EMP(
ID NUMBER(4),
NAME VARCHAR2(10));
```
​
  
  INSERT INTO NEW\_EMP  
  SELECT EMPNO, ENAME  
  FROM EMP  
  WHERE ENAME LIKE '% A%';
​
```
SQL> INSERT INTO NEW_EMP
  2  SELECT EMPNO, ENAME
  3  FROM EMP
  4  WHERE ENAME LIKE '%A%';
​
6 rows created.
​
SQL> SELECT * FROM NEW_EMP;
​
   ID NAME
----- --------------------
 7499 ALLEN
 7521 WARD
 7654 MARTIN
 7698 BLAKE
 7782 CLARK
 7900 JAMES
​
6 rows selected.
​
SQL>
```
​
---
​
## **UPDATE**
​
  
  - UPDATE 문을 이용한 기존 데이터 수정  
  - UPDATE 구문을 이용해서 특정 열의 값을 변경할 수 있다.  
  - WHERE 절을 생략하면 테이블의 모든 행이 수정된다.
​
**  \[형식\]**
​
  
**  UPDATE 테이블명  
  SET COLUMN = VALUES \[, , ,\]**  
**  \[WHERE CONDITION\];**
​
  
** Q5)**
​
**  # TEST 테이블의 커미션 0을 변경하자.**
​
  UPDATE TEST  
  SET COMM=0;
​
```
SQL> UPDATE TEST
  2  SET COMM = 0;
​
16 rows updated.
​
SQL> SELECT * FROM TEST;
​
EMPNO ENAME                JOB                  MGR HIREDATE   SAL  COMM DEPTNO
----- -------------------- ------------------ ----- -------- ----- ----- ------
 7234 SCOTT                                                   3400     0
 7533 EVLIS                                         97/02/05           0
 7535 EVLIS02                                       97/02/05           0
 7535 EVLIS02                                       97/02/07           0
 7902                                                         3000     0
 7369 SMITH                                                    800     0
 7499 ALLEN                                                   1600     0
 7521 WARD                                                    1250     0
 7566 JONES                                                   2975     0
 7654 MARTIN                                                  1250     0
 7698 BLAKE                                                   2850     0
​
EMPNO ENAME                JOB                  MGR HIREDATE   SAL  COMM DEPTNO
----- -------------------- ------------------ ----- -------- ----- ----- ------
 7782 CLARK                                                   2450     0
 7839 KING                                                    5000     0
 7844 TURNER                                                  1500     0
 7900 JAMES                                                    950     0
 7934 MILLER                                                  1300     0
​
16 rows selected.
​
```
​
  
  
**Q6)**
​
**  # UPDATE 한 구문을 취소하자.**
​
 ROLLBACK;
​
```
SQL> ROLLBACK;
​
Rollback complete.
​
```
​
  
**Q7)**
​
** # TEST 테이블에서 JONES 커미션을 500이라고 변경하자.**
​
  
 UPDATE TEST  
 SET COMM = 500  
 WHERE ENAME = 'JONES';
​
```
SQL> UPDATE TEST
  2  SET COMM = 500
  3  WHERE ENAME = 'JONES';
​
1 row updated.
​
SQL> SELECT * FROM TEST;
​
EMPNO ENAME                JOB                  MGR HIREDATE   SAL  COMM DEPTNO
----- -------------------- ------------------ ----- -------- ----- ----- ------
 7234 SCOTT                                                   3400
      FORD
 7902                                                         3000
 7369 SMITH                                                    800
 7499 ALLEN                                                   1600   300
 7521 WARD                                                    1250   500
 7566 JONES                                                   2975   500 # ★ 확인
 7654 MARTIN                                                  1250  1400
 7698 BLAKE                                                   2850
 7782 CLARK                                                   2450
 7839 KING                                                    5000
​
EMPNO ENAME                JOB                  MGR HIREDATE   SAL  COMM DEPTNO
----- -------------------- ------------------ ----- -------- ----- ----- ------
 7844 TURNER                                                  1500     0
 7900 JAMES                                                    950
 7934 MILLER                                                  1300
​
14 rows selected.
```
​
  
**Q8)**
​
** # TEST 테이블에서 PAUL의 직업은 CLERK CLERK로, 봉급은 5000, 커미션은 봉급의 20%로 변경해보자.**
​
    : 봉급을 5000으로 변경했기 때문에, 실행 후 추가 커미션 계산을 해야 한다.
​
  
 UPDATE TEST  
 SET JOB = 'CLERK', SAL = 5000  
 WHERE ENAME = 'PAUL';
​
```
SQL> UPDATE TEST
  2   SET JOB = 'CLERK', SAL = 5000
  3   WHERE ENAME = 'PAUL';
​
1 row updated.
​
SQL> SELECT * FROM TEST;
​
EMPNO ENAME                JOB                  MGR HIREDATE   SAL  COMM DEPTNO
----- -------------------- ------------------ ----- -------- ----- ----- ------
 7234 SCOTT                                                   3400
      FORD
 7233 PAUL                 CLERK                    21/05/26  5000  # ★ 확인
 7902                                                         3000
 7369 SMITH                                                    800
 7499 ALLEN                                                   1600   300
 7521 WARD                                                    1250   500
 7566 JONES                                                   2975   500
 7654 MARTIN                                                  1250  1400
 7698 BLAKE                                                   2850
 7782 CLARK                                                   2450
​
EMPNO ENAME                JOB                  MGR HIREDATE   SAL  COMM DEPTNO
----- -------------------- ------------------ ----- -------- ----- ----- ------
 7839 KING                                                    5000
 7844 TURNER                                                  1500     0
 7900 JAMES                                                    950
 7934 MILLER                                                  1300
​
15 rows selected.
​
SQL>
```
​
  
 → 저장 후 추가 변경
​
  
  UPDATE TEST  
  SET COMM = SAL\*0.2  
  WHERE ENAME = 'PAUL';
​
```
SQL> UPDATE TEST
  2  SET COMM = SAL*0.2
  3  WHERE ENAME = 'PAUL';
​
1 row updated.
​
SQL> SELECT * FROM TEST;
​
EMPNO ENAME                JOB                  MGR HIREDATE   SAL  COMM DEPTNO
----- -------------------- ------------------ ----- -------- ----- ----- ------
 7234 SCOTT                                                   3400
      FORD
 7233 PAUL                 CLERK                    21/05/26  5000  1000 # ★ 확인
 7902                                                         3000
 7369 SMITH                                                    800
 7499 ALLEN                                                   1600   300
 7521 WARD                                                    1250   500
 7566 JONES                                                   2975   500
 7654 MARTIN                                                  1250  1400
 7698 BLAKE                                                   2850
 7782 CLARK                                                   2450
​
EMPNO ENAME                JOB                  MGR HIREDATE   SAL  COMM DEPTNO
----- -------------------- ------------------ ----- -------- ----- ----- ------
 7839 KING                                                    5000
 7844 TURNER                                                  1500     0
 7900 JAMES                                                    950
 7934 MILLER                                                  1300
​
15 rows selected.
​
SQL>
```
​
  
** Q9)**
​
**# 서브 쿼리를 사용해서 사원의 번호 7902 사원의 부서 번호를KING과 동일하게 변경하는 UPDATE 해보자.**
​
 UPDATE TEST01  
 SET DEPTNO = (SELECT DEPTNO  
                      FROM TEST  
                      WHERE ENAME = 'KING')  
 WHERE EMPNO = 7902;
​
```
SQL> SELECT * FROM TEST01;
​
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
​
EMPNO ENAME                JOB                  MGR HIREDATE   SAL  COMM DEPTNO
----- -------------------- ------------------ ----- -------- ----- ----- ------
 7934 MILLER               CLERK               7782 82/01/23  1300           10
​
12 rows selected.
​
SQL> UPDATE TEST01
  2  SET DEPTNO = (SELECT DEPTNO
  3                FROM TEST
  4                WHERE ENAME = 'KING')
  5  WHERE EMPNO = 7902;
​
1 row updated.
​
SQL> SELECT * FROM TEST01;
​
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
 7902 FORD                 ANALYST             7566 81/12/03  3000
​
EMPNO ENAME                JOB                  MGR HIREDATE   SAL  COMM DEPTNO
----- -------------------- ------------------ ----- -------- ----- ----- ------
 7934 MILLER               CLERK               7782 82/01/23  1300           10
​
12 rows selected.
```
​
  
**Q10)**
​
**  # 7698 사원의 직업과 부서 번호를 7499 사원의 직업과 부서번호 같도록 수정하자.**
​
UPDATE TEST01  
SET (JOB, DEPTNO) = (SELECT JOB, DEPTNO  
                             FROM TEST  
                             WHERE EMPNO = 7499)  
WHERE EMPNO = 7698;
​
```
SQL> UPDATE TEST01
  2  SET (JOB, DEPTNO) = (SELECT JOB, DEPTNO
  3                       FROM TEST
  4                       WHERE EMPNO = 7499)
  5  WHERE EMPNO = 7698;
​
1 row updated.
​
SQL> SELECT *
  2  FROM TEST01;
​
EMPNO ENAME                JOB                  MGR HIREDATE   SAL  COMM DEPTNO
----- -------------------- ------------------ ----- -------- ----- ----- ------
 7369 SMITH                CLERK               7902 80/12/17   800           20
 7499 ALLEN                SALESMAN            7698 81/02/20  1600   300     30 #★
 7521 WARD                 SALESMAN            7698 81/02/22  1250   500     30
 7566 JONES                MANAGER             7839 81/04/02  2975           20
 7654 MARTIN               SALESMAN            7698 81/09/28  1250  1400     30
 7698 BLAKE                SALESMAN            7839 81/05/01  2850           30 #★
 7782 CLARK                MANAGER             7839 81/06/09  2450           10
 7839 KING                 PRESIDENT                81/11/17  5000           10
 7844 TURNER               SALESMAN            7698 81/09/08  1500     0     30
 7900 JAMES                CLERK               7698 81/12/03   950           30
 7902 FORD                 ANALYST             7566 81/12/03  3000   500     10
​
EMPNO ENAME                JOB                  MGR HIREDATE   SAL  COMM DEPTNO
----- -------------------- ------------------ ----- -------- ----- ----- ------
 7934 MILLER               CLERK               7782 82/01/23  1300           10
 7233 PAUL                 CLERK                    21/05/26  5000  1000
 7234 SCOTT                                                   3400
```
​
---
​
##   
**DELETE**
​
  
**DELECT \[FROM\] 테이블명  
\[WHERE CONDITION\];**  
  
  
  
**Q11) TEST 전체 레코드를 삭제하자.**
​
DELETE FROM TEST;  
DELECT TEST; 
​
```
SQL> DELETE FROM TEST;
​
0 rows deleted.
```
​
  
**Q12) FORD사원을 삭제하자.**
​
DELETE FROM TEST  
WHERE ENAME = 'FORD';
​
```
SQL> DELETE FROM TEST01
  2  WHERE ENAME = 'FORD';
​
1 row deleted.
​
SQL> SELECT * FROM TEST01;
​
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
 7934 MILLER               CLERK               7782 82/01/23  1300           10
​
11 rows selected.
​
SQL>
​
```
​
  
  
**Q13) 부서번호 20번 사원을 삭제하자.**
​
  
DELETE FROM TEST  
WHERE DEPTNO = 20;
​
```
SQL> DELETE FROM TEST01
  2  WHERE DEPTNO = 20;
​
2 rows deleted.
​
SQL> SELECT * FROM TEST01;
​
EMPNO ENAME                JOB                  MGR HIREDATE   SAL  COMM DEPTNO
----- -------------------- ------------------ ----- -------- ----- ----- ------
 7499 ALLEN                SALESMAN            7698 81/02/20  1600   300     30
 7521 WARD                 SALESMAN            7698 81/02/22  1250   500     30
 7654 MARTIN               SALESMAN            7698 81/09/28  1250  1400     30
 7698 BLAKE                MANAGER             7839 81/05/01  2850           30
 7782 CLARK                MANAGER             7839 81/06/09  2450           10
 7839 KING                 PRESIDENT                81/11/17  5000           10
 7844 TURNER               SALESMAN            7698 81/09/08  1500     0     30
 7900 JAMES                CLERK               7698 81/12/03   950           30
 7934 MILLER               CLERK               7782 82/01/23  1300           10
​
9 rows selected.
```
​
**Q14) 사원의 봉급 중에 20002000 이상을 받는 사원을 삭제하자.**
​
  
DELETE FROM TEST01  
WHERE SAL >= 2000;
​
```
SQL> DELETE FROM TEST01
  2  WHERE SAL >= 2000;
​
5 rows deleted.
​
SQL> SELECT * FROM TEST01;
​
EMPNO ENAME                JOB                  MGR HIREDATE   SAL  COMM DEPTNO
----- -------------------- ------------------ ----- -------- ----- ----- ------
 7369 SMITH                CLERK               7902 80/12/17   800           20
 7499 ALLEN                SALESMAN            7698 81/02/20  1600   300     30
 7521 WARD                 SALESMAN            7698 81/02/22  1250   500     30
 7654 MARTIN               SALESMAN            7698 81/09/28  1250  1400     30
 7844 TURNER               SALESMAN            7698 81/09/08  1500     0     30
 7900 JAMES                CLERK               7698 81/12/03   950           30
 7934 MILLER               CLERK               7782 82/01/23  1300           10
​
7 rows selected.
​
SQL>
```
​
##   
  
**MERGE문**
​
  테이블의 조건에 따라 데이터를 갱신하거나 삽입하는 기능을 제공한다.  
해당 행이 존재하는 경우 UPDATE UPDATE를 수행하고 새로운 행일 경우 INSERT를 수행한다.  
  
\[형식\]
​
  
MERGE INTO 테이블명  
USING → 변경 또는 추가할 데이터의 원본을 지정하는 테이블 또는 VIEW, 서브 쿼리  
ON → MERGE 연산이 변경 또는 추가를 수행하는 조건  
WHEN MATCHED THEN  
  UPDATE SET  
WHEN NET MATCHED THEN  
  INSERT  
VALUES  
  
​
**Q15)**
​
**EMP 테이블에서 TEST01 테이블과 비교해서**
​
**동일한 사원번호의 데이터가 있으면 TEST01 테이블의 봉급, 커미션을** **EMP 테이블의 값으로 수정하고**
​
**해당 사원번호를 가진 사원이 없으면 TEST01에 EMP 테이블의 데이터를 이용해서 입력하자.**  
  
MERGE INTO TEST01 T  
USING EMP E  
ON (T.EMPNO = E.EMPNO)  
WHEN MATCHED THEN  
         UPDATE SET T.SAL = E.SAL, T.COMM = E.COMM  
WHEN NOT MATCHED THEN  
         INSERT (EMPNO, ENAME, SAL, COMM)  
VALUES (E.EMPNO, E.ENAME, E.SAL, E.COMM);
​
```
SQL> SELECT * FROM TEST01;
​
EMPNO ENAME                JOB                  MGR HIREDATE   SAL  COMM DEPTNO
----- -------------------- ------------------ ----- -------- ----- ----- ------
 7369 SMITH                CLERK               7902 80/12/17   800           20
 7499 ALLEN                SALESMAN            7698 81/02/20  1600   300     30
 7521 WARD                 SALESMAN            7698 81/02/22  1250   500     30
 7654 MARTIN               SALESMAN            7698 81/09/28  1250  1400     30
 7844 TURNER               SALESMAN            7698 81/09/08  1500     0     30
 7900 JAMES                CLERK               7698 81/12/03   950           30
 7934 MILLER               CLERK               7782 82/01/23  1300           10
​
7 rows selected.
​
#=========================================================
​
SQL> MERGE INTO TEST01 T
  2  USING EMP E
  3  ON(T.EMPNO = E.EMPNO)
  4  WHEN MATCHED THEN
  5     UPDATE SET T.SAL = E.SAL, T.COMM = E.COMM
  6  WHEN NOT MATCHED THEN
  7     INSERT (EMPNO, ENAME, SAL, COMM)
  8     VALUES(E.EMPNO, E.ENAME, E.SAL, E.COMM);
​
12 rows merged.
​
SQL> SELECT * FROM TEST01;
​
EMPNO ENAME                JOB                  MGR HIREDATE   SAL  COMM DEPTNO
----- -------------------- ------------------ ----- -------- ----- ----- ------
 7369 SMITH                CLERK               7902 80/12/17   800           20
 7499 ALLEN                SALESMAN            7698 81/02/20  1600   300     30
 7521 WARD                 SALESMAN            7698 81/02/22  1250   500     30
 7654 MARTIN               SALESMAN            7698 81/09/28  1250  1400     30
 7844 TURNER               SALESMAN            7698 81/09/08  1500     0     30
 7900 JAMES                CLERK               7698 81/12/03   950           30
 7934 MILLER               CLERK               7782 82/01/23  1300           10
 7566 JONES                                                   2975
 7698 BLAKE                                                   2850
 7782 CLARK                                                   2450
 7839 KING                                                    5000
​
EMPNO ENAME                JOB                  MGR HIREDATE   SAL  COMM DEPTNO
----- -------------------- ------------------ ----- -------- ----- ----- ------
 7902 FORD                                                    3000
​
12 rows selected.
​
SQL>
```
​
## **다중 테이블 입력**  
​
**무조건** **INSERT**
​
     : ALL 뒤에 여러 개의 INTO 절을 지정하여 무조건 다중 테이블에 데이터 삽입  
      서브 쿼리에서는 반환된 각 행에 대해 INTO 절을 한 번씩 수행한다.
​
**조건** **ALL INSERT/ 조건 INSERT**
​
    : 조건 지정, 하나의 다중 INSERT는 WHEN문을 127개 (단, ALL이 없을 경우)) 까지만 사용할 수 있다.
​
**조건** **FIRST INSERT** : 나열된 순서대로 WHEN 문을 평가 실행한다.
​
  
**피벗** **INSERT :** 비 관계형 테이블의 레코드를 관계형으로 구현할 때 사용한다.
​
**\[형식\]**
​
  
**무조건 INSERT**  
**INSERT ALL**  
**INTO 데이블명 VALUES()**  
**INTO**  
**SELECT**  
**FROM WHERE**
​
  
**Q16)**
​
**사원 테이블(EMP)에서 20번 부서 이상의 데이터를**
​
**TEST01 테이블에는 사원번호, 입사일, 봉급을 입력하고**
​
**TEST02라는, 매니저, 봉급을 입력해보자.**
​
  
INSERT ALL  
INTO TEST01 (EMPNO, HIREDATE, SAL) VALUES (EMPNO, HIREDATE, SAL)  
INTO TEST02 (EMPNO, MGR, SAL) VALUES (EMP NO, MGR, SAL)  
SELECT EMPNO, HIREDATE, SAL, MGR  
FROM EMP  
WHERE DEPTNO >20;
​
```
SQL> INSERT ALL
  2  INTO TEST01(EMPNO, HIREDATE, SAL) VALUES(EMPNO,HIREDATE,SAL)
  3  INTO TEST02(EMPNO, MGR, SAL) VALUES(EMPNO, MGR, SAL)
  4  SELECT EMPNO, HIREDATE, SAL, MGR
  5  FROM EMP
  6  WHERE DEPTNO > 20;
​
12 rows created.
​
SQL> SELECT * FROM TEST01;
​
EMPNO ENAME                JOB                  MGR HIREDATE   SAL  COMM DEPTNO
----- -------------------- ------------------ ----- -------- ----- ----- ------
 7499                                               81/02/20  1600
 7521                                               81/02/22  1250
 7654                                               81/09/28  1250
 7698                                               81/05/01  2850
 7844                                               81/09/08  1500
 7900                                               81/12/03   950
​
6 rows selected.
​
SQL> SELECT * FROM TEST02;
​
EMPNO ENAME                JOB                  MGR HIREDATE   SAL  COMM DEPTNO
----- -------------------- ------------------ ----- -------- ----- ----- ------
 7499                                          7698           1600
 7521                                          7698           1250
 7654                                          7698           1250
 7698                                          7839           2850
 7844                                          7698           1500
 7900                                          7698            950
​
6 rows selected.
​
SQL>
```
​
**😎 알아두기**
​
  
DROP TABLE TEST01  
DROP TABLE TEST02  
  
CREATE TABLE TEST01 AS  
SELECT \* FROM EMP  
WHERE 1 = 0; → 구조만 생성되고 데이터는 삽입되지 않는다.
​
```
SQL> CREATE TABLE TEST01 AS
  2  SELECT * FROM EMP
  3  WHERE 1 = 0;
​
Table created.
​
SQL> SELECT * FROM TEST01;
​
no rows selected
```
​
  
CREATE TABLE TEST02 AS  
SELECT \* FROM EMP  
WHERE 1 = 0;→ 구조만 생성되고 데이터는 삽입되지 않는다.
​
```
SQL> CREATE TABLE TEST02 AS
  2  SELECT * FROM EMP
  3  WHERE 1 = 0;
​
Table created.
​
SQL> SELECT * FROM TEST02;
​
no rows selected
​
```
​
  
  
**Q17)**
​
**사원 테이블(EMP)에서20번 부서 이상의 데이터를**
​
**TEST01 테이블에는 사원번호, 입사일, 봉급을 입력하고**
​
**TEST02라는, 매니저, 봉급을 입력해보자.**  
**단, 봉급이 2000이상이면 TEST01 나머지는 TEST02 입력하자.**  
  
​
INSERT ALL  
WHEN SAL >= 2000 THEN  
         INTO TEST01(EMPNO, HIREDATE, SAL) VALUES(EMPNO, HIREDATE, SAL)  
WHEN SAL < 2000 THEN  
         INTO TEST02(EMPNO, MGR, SAL) VALUES(EMPNO, MGR, SAL)  
SELECT EMPNO, HIREDATE, SAL, MGR  
FROM EMP  
WHERE DEPTNO >20;
​
```
SQL> INSERT ALL
  2  WHEN SAL >= 2000 THEN
  3           INTO TEST01(EMPNO, HIREDATE, SAL) VALUES(EMPNO, HIREDATE, SAL)
  4  WHEN SAL < 2000 THEN
  5           INTO TEST02(EMPNO, MGR, SAL) VALUES(EMPNO, MGR, SAL)
  6  SELECT EMPNO, HIREDATE, SAL, MGR
  7  FROM EMP
  8  WHERE DEPTNO >20;
​
6 rows created.
​
SQL> SELECT * FROM TEST01;
​
EMPNO ENAME                JOB                  MGR HIREDATE   SAL  COMM DEPTNO
----- -------------------- ------------------ ----- -------- ----- ----- ------
 7698                                               81/05/01  2850
​
SQL> SELECT * FROM TEST02;
​
EMPNO ENAME                JOB                  MGR HIREDATE   SAL  COMM DEPTNO
----- -------------------- ------------------ ----- -------- ----- ----- ------
 7499                                          7698           1600
 7521                                          7698           1250
 7654                                          7698           1250
 7844                                          7698           1500
 7900                                          7698            950
​
SQL>
```
​
**□ INSERT FIRST**
​
  
   첫 번째 WHEN 절이 참이면, 두 번째 WHEN 절이 X → 하나의 TRUE 만
​
  
**Q18) INSERT FIRST**
​
**사원 테이블(EMP)에서**
​
**TEST01테이블에는 봉급이2000이상인 사원번호,입사일,봉급을입력하고**
​
**TEST02 테이블에는 사원 이름이 A가 포함된 사원번호, 매니저, 봉급을 입력하고**
​
**TEST03 테이블에는 사원이름이 F가 포함된 사원번호, 매니저, 봉급을 입력하고 값을 입력하자.**  
​
INSERT FIRST  
WHEN SAL >= 2000 THEN  
     INTO TEST01 (EMPNO, HIREDATE, SAL) VALUES (EMPNO, HIREDATE, SAL)  
WHEN ENAME LIKE ('% A%') THEN  
     INTO TEST02 (EMPNO, MGR, SAL) VALUES (EMPNO, MGR, SAL)  
WHEN ENAME LIKE('% F%') THEN  
     INTO TEST03(EMPNO, MGR, SAL) VALUES(EMPNO, MGR, SAL)  
SELECT ENAME, EMPNO, HIREDATE, SAL, MGR  
FROM EMP;
​
```
SQL> INSERT FIRST
  2  WHEN SAL >= 2000 THEN
  3       INTO TEST01 (EMPNO, HIREDATE, SAL) VALUES (EMPNO, HIREDATE, SAL)
  4  WHEN ENAME LIKE ('%A%') THEN
  5       INTO TEST02 (EMPNO, MGR, SAL) VALUES (EMPNO, MGR, SAL)
  6  WHEN ENAME LIKE('%F%') THEN
  7       INTO TEST03(EMPNO, MGR, SAL) VALUES(EMPNO, MGR, SAL)
  8  SELECT ENAME, EMPNO, HIREDATE, SAL, MGR
  9  FROM EMP;
​
9 rows created.
​
SQL> SELECT * FROM TEST01;
​
EMPNO ENAME                JOB                  MGR HIREDATE   SAL  COMM DEPTNO
----- -------------------- ------------------ ----- -------- ----- ----- ------
 7566                                               81/04/02  2975
 7698                                               81/05/01  2850
 7782                                               81/06/09  2450
 7839                                               81/11/17  5000
 7902                                               81/12/03  3000
​
SQL> SELECT * FROM TEST02;
​
EMPNO ENAME                JOB                  MGR HIREDATE   SAL  COMM DEPTNO
----- -------------------- ------------------ ----- -------- ----- ----- ------
 7499                                          7698           1600
 7521                                          7698           1250
 7654                                          7698           1250
 7900                                          7698            950
​
SQL> SELECT * FROM TEST03;
​
no rows selected
​
```
​
 # 위 데이터를 INSERT ALL 가 비교해보자 → 중복 값 가능
​
INSERT ALL   
WHEN SAL >= 2000 THEN  
         INTO TEST01(EMPNO, HIREDATE, SAL) VALUES (EMPNO, HIREDATE, SAL)  
WHEN ENAME LIKE('% A%') THEN  
         INTO TEST02 (EMPNO, MGR, SAL) VALUES (EMPNO, MGR, SAL)  
WHEN ENAME LIKE('% F%') THEN  
         INTO TEST03 (EMPNO, MGR, SAL) VALUES (EMPNO, MGR, SAL)  
SELECT ENAME, EMPNO, HIREDATE, SAL, MGR  
FROM EMP;
​
```
SQL> INSERT ALL
  2  WHEN SAL >= 2000 THEN
  3           INTO TEST01(EMPNO, HIREDATE, SAL) VALUES (EMPNO, HIREDATE, SAL)
  4  WHEN ENAME LIKE('%A%') THEN
  5           INTO TEST02 (EMPNO, MGR, SAL) VALUES (EMPNO, MGR, SAL)
  6  WHEN ENAME LIKE('%F%') THEN
  7           INTO TEST03 (EMPNO, MGR, SAL) VALUES (EMPNO, MGR, SAL)
  8  SELECT ENAME, EMPNO, HIREDATE, SAL, MGR
  9  FROM EMP;
​
12 rows created.
​
SQL> SELECT * FROM TEST01;
​
EMPNO ENAME                JOB                  MGR HIREDATE   SAL  COMM DEPTNO
----- -------------------- ------------------ ----- -------- ----- ----- ------
 7566                                               81/04/02  2975
 7698                                               81/05/01  2850
 7782                                               81/06/09  2450
 7839                                               81/11/17  5000
 7902                                               81/12/03  3000
​
SQL> SELECT * FROM TEST02;
​
EMPNO ENAME                JOB                  MGR HIREDATE   SAL  COMM DEPTNO
----- -------------------- ------------------ ----- -------- ----- ----- ------
 7499                                          7698           1600
 7521                                          7698           1250
 7654                                          7698           1250
 7698                                          7839           2850
 7782                                          7839           2450
 7900                                          7698            950
​
6 rows selected.
​
SQL> SELECT * FROM TEST03;
​
EMPNO ENAME                JOB                  MGR HIREDATE   SAL  COMM DEPTNO
----- -------------------- ------------------ ----- -------- ----- ----- ------
 7902                                          7566           3000
​
SQL>
```
​
  
**Q19) INSERT ALL**
​
  
INSERT ALL  
INTO TEST01(EMPNO, ENAME) VALUES(EMPNO, ENAME)  
INTO TEST02(EMPNO, ENAME, SAL) VALUES(EMPNO, ENAME, SAL)  
INTO TEST03(EMPNO, ENAME, MGR) VALUES(EMPNO, ENAME, MGR)  
SELECT EMPNO, ENAME, SAL, MGR  
FROM EMP;
​
```
SQL> INSERT ALL
  2  INTO TEST01(EMPNO, ENAME) VALUES(EMPNO, ENAME)
  3  INTO TEST02(EMPNO, ENAME, SAL) VALUES(EMPNO, ENAME, SAL)
  4  INTO TEST03(EMPNO, ENAME, MGR) VALUES(EMPNO, ENAME, MGR)
  5  SELECT EMPNO, ENAME, SAL, MGR
  6  FROM EMP;
​
36 rows created.
​
SQL> SELECT * FROM TEST01;
​
EMPNO ENAME                JOB                  MGR HIREDATE   SAL  COMM DEPTNO
----- -------------------- ------------------ ----- -------- ----- ----- ------
 7369 SMITH
 7499 ALLEN
 7521 WARD
 7566 JONES
 7654 MARTIN
 7698 BLAKE
 7782 CLARK
 7839 KING
 7844 TURNER
 7900 JAMES
 7902 FORD
​
EMPNO ENAME                JOB                  MGR HIREDATE   SAL  COMM DEPTNO
----- -------------------- ------------------ ----- -------- ----- ----- ------
 7934 MILLER
​
12 rows selected.
​
SQL> SELECT * FROM TEST02;
​
EMPNO ENAME                JOB                  MGR HIREDATE   SAL  COMM DEPTNO
----- -------------------- ------------------ ----- -------- ----- ----- ------
 7369 SMITH                                                    800
 7499 ALLEN                                                   1600
 7521 WARD                                                    1250
 7566 JONES                                                   2975
 7654 MARTIN                                                  1250
 7698 BLAKE                                                   2850
 7782 CLARK                                                   2450
 7839 KING                                                    5000
 7844 TURNER                                                  1500
 7900 JAMES                                                    950
 7902 FORD                                                    3000
​
EMPNO ENAME                JOB                  MGR HIREDATE   SAL  COMM DEPTNO
----- -------------------- ------------------ ----- -------- ----- ----- ------
 7934 MILLER                                                  1300
​
12 rows selected.
​
SQL> SELECT * FROM TEST03;
​
EMPNO ENAME                JOB                  MGR HIREDATE   SAL  COMM DEPTNO
----- -------------------- ------------------ ----- -------- ----- ----- ------
 7369 SMITH                                    7902
 7499 ALLEN                                    7698
 7521 WARD                                     7698
 7566 JONES                                    7839
 7654 MARTIN                                   7698
 7698 BLAKE                                    7839
 7782 CLARK                                    7839
 7839 KING
 7844 TURNER                                   7698
 7900 JAMES                                    7698
 7902 FORD                                     7566
​
EMPNO ENAME                JOB                  MGR HIREDATE   SAL  COMM DEPTNO
----- -------------------- ------------------ ----- -------- ----- ----- ------
 7934 MILLER                                   7782
​
12 rows selected.
​
SQL>
```
