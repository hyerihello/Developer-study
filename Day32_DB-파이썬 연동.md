## **파이썬 이용, 오라클 DB작성**

**✔ 연결 후 작성 및 실행 (기본)**

```
# -*- CODING : UTF-8 -*-

import cx_Oracle
dsn = cx_Oracle.makedsn("localhost", 1521, 'xe') # 오라클 주소 기입
db = cx_Oracle.connect('SCOTT', 'TIGER', dsn) # 오라클 접속 유저정보
cur = db.cursor() # 커서 객체 가져오기

sql_cmd = "CREATE TABLE day30 (id number, name varchar2(20))"
cur.execute(sql_cmd) # SQL문장 실행
## placeholder 를 콜론(:)을 사용한다.
sql_cmd02 = "INSERT INTO day30 VALUES (:id, :name)" #임의 변수 지정해서 사용할 수 있다. (수정, 삭제도 가능)
cur.execute(sql_cmd02, {"id" : 1, "name" : "Ruri"})
cur.execute(sql_cmd02, {"id" : 2, "name" : "Dominica"})
cur.execute(sql_cmd02, {"id" : 3, "name" : "Dominico"})
cur.execute(sql_cmd02, {"id" : 4, "name" : "Ruo"})

for row in cur.execute("SELECT * FROM day30"):
    print(row)

```

```
C:\Python\Python39\python.exe C:/Python_work/Day31(db)/com/심심한그대.py
(1, 'Ruri')
(2, 'Dominica')
(3, 'Dominico')
(4, 'Ruo')

Process finished with exit code 0
```

**✔ 함수 사용**

```
import cx_Oracle

def Create_Table():
    dsn = cx_Oracle.makedsn("localhost", 1521, 'xe')
    db = cx_Oracle.connect('mydb', 'admin1234', dsn)
    cur = db.cursor()

    sql_cmd = "CREATE TABLE Test_mydb01(id number, name varchar2(20))"
    cur.execute(sql_cmd)
    db.close()

def Select_all():
    dsn = cx_Oracle.makedsn("localhost", 1521, 'xe')
    db = cx_Oracle.connect('mydb', 'admin1234', dsn)
    cur = db.cursor()
    
    cur.execute("select * from Test_mydb01") # SQL 실행

    result = cur.fetchall() # → list형태로 데이터를 가져옴
    for row in result:
        print(str(row[0]) + "  "+ row[1]);
    cur.close()
    db.close()

def Insert_m():
    dsn = cx_Oracle.makedsn("localhost", 1521, 'xe')
    db = cx_Oracle.connect('mydb', 'admin1234', dsn)
    cur = db.cursor()
    
    cur.execute("insert into test_mydb01 values('1','python1')") # SQL 실행
    cur.execute("insert into test_mydb01 values('2','python2')")
    cur.execute("insert into test_mydb01 values('3','python3')")
    cur.execute("insert into test_mydb01 values('4','python4')")
    db.commit();
    db.close();
    
if __name__ == '__main__':
    Create_Table();
    Insert_m();
    Select_all();

```

```
1  python1
2  python2
3  python3
4  python4
1  python1
2  python2
3  python3
4  python4
1  python1
2  python2
3  python3
4  python4

Process finished with exit code 0

```

**✔ 함수 → Class 사용**

```
import cx_Oracle

class MyClass:
    def __init__(self): # 연결 (생성자)
        self.dsn = cx_Oracle.makedsn("localhost", 1521, 'xe')
        self.db = cx_Oracle.connect('mydb', 'admin1234', self.dsn)
        self.cur = self.db.cursor()

    def Insert_m(self): # 한번만 사용하고 변수로 받자
        self.cur.execute("insert into test_mydb02 values('1','python1')")
        self.cur.execute("insert into test_mydb02 values('2','python2')")
        self.cur.execute("insert into test_mydb02 values('3','python3')")
        self.cur.execute("insert into test_mydb02 values('4','python4')")
        self.db.commit();
        # self.cur.close() # 아래 소멸자 close 가 있기 때문에 닫아줌

    def Select_all(self):
        self.cur.execute("select * from Test_mydb02")
        result = self.cur.fetchall()
        for row in result:
            print(str(row[0]) + "  " + row[1]);
        self.cur.close()
        #self.db.close()

    def __del__(self): # 닫기 (소멸자)
        self.db.close()


if __name__ == '__main__':
    test = MyClass();
    test.Select_all();
    del test
```

```
1  python1
2  python2
3  python3
4  python4

Process finished with exit code 0
```
