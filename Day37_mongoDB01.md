## **몽고 DB**

**✔ 질의**

**       :** 하나의 쿼리를 명시하는 키워드, mongoDB는 6개의 질의를 가진다.

  
  **1) 키 \- 값 질의** : 특정 필드와 맵핑되는 값을 포함하는 문서 { }를 말한다.  
주 key에 대한 값을 리턴하는 경우   
  **2) 범위 :** 특정 범위에 포함되는 값을 말한다. (비교 연산자)  
  **3) 공간범위 :** 선, 원 다각형 등에 대한 공간 근사값

                   ex) a - b 사이에 건물이 몇 개있는지, 얼마 만큼 거리가 있는지 등  
  **4) 문자열 탐색 질의 :** 논리 연산자를 통해서 특정 문자열을 탐색  
  **5) 집합 질의 :** 그룹 함수를 지칭하며 count, min, max, average 등 을 이용한 결과 값  
  **6) MR** (Map Reduce Query : 파일, db → 데이터 → 분철(1) → 정렬 → 집계) :  
            java script 로 표현되는 복잡한 데이터를 데이터 페이스로 실행해 반환 하는 질의

**✔ 컬렉션 규칙 및 키에 대한 필드 명 생성조건**

   1)  $로 시작할 수 없다.  
   2)  255 이내로 작성한다.  
   3)  . 연산자를 포함 할 수 없다.  
   4)  공백이 중간에 들어갈 수 없다.  
   5)  필드 이름은 하나의 컬렉션 내에 유일한 값으로 존재한다.  
6)  전체 문서 크기가 16M 제한 적이다. (네트워크 대역 폭)  
   7)  만일 문서가 대용량 (16M 이상) GridFS api 를 사용해서 구현한다.  
        \* txt sql csv tsv xml json 

**✔ 문서에 대한 정보 (외부적인 상태)**

  
   1)  mongod.lock : 서버의 프로세스 ID 저장한다.  
   2)  .0파일(.ns) : 메타 데이터를 네임스페이스 단위로 저장한다.  
   3)  2번의 크기는 ns 18M를 넘을 수 없다.

       28999개 정도의 네임 스페이스 (하나의 데이터 페이스는 컬렉션과 색인 수를 28000개를 가진다.)  
       → nssize arg(=16)  
   4)  test.0(64M), test.1(128M) 식으로 데이터 저장소를 확보해서 데이터를 저장한다라고 간주한다면  
       파일의 용량은 2GB 까지가 최대 이다.  
   5) 몽고는 데이터 저장소 크기를 정적으로 관리한다.

    ex) 확인  
         "C:\\Program Files\\MongoDB\\Server\\4.4\\bin\\mongod.exe"  
            --config "C:\\Program Files\\MongoDB\\Server\\4.4\\bin\\mongod.cfg" --service

**✔문서에 대한 정보(내부적인 상태)**

     db.stats(1042) : 자료를 입력했을 때 몽고 드라이버가 동작된 후 데이터 상태 확인  
  
**자료를 입력 했을 때 몽고드라이버가 동작된다.**  
  1)  mongodb에 삽입되는 문서의 고유번호 ID인 \_id로 필드와 값을 생성한다.  
  2)  문서를 mongodb의 bson으로 변환한다.  
  3)  네트워크 소켓을 이용해서 데이터 베이스를 전달한다.

---

****□ **실습 1**

1.  서비스에서 mongo 서버 중단  
2.  c:\\data\\mydata 폴더를 생성  
3.  my.log, my.cfg 폴더/파일 생성  
     c:\\data\\log\\my.log  
     c:\\data\\cfg\\my.cfg  
4.  해당 로그파일 저장할 때 사용자가 지정하는 특정 위치를 사용하도록 지정. (cmd 창에 입력)  
      c:\\> echo logpath = "c:\\data\\log\\my.log" > "c:\\data\\log\\my.cfg"  
5.  db path 를 지정. 서비스에 이름 등록하자.  (윈도우 서비스에서 등록확인, cmd 입력 시 전체 그대로 입력)  
      c:\\> mongod --dbpath "c:\\data\\mydata" --logpath" c:\\data\\cfg\\my.cfg" --install --serviceName MyMongo --serviceDisplayName MyMongo  
6.  remove

     c:\\> mongod --dbpath "c:\\data\\mydata" --logpath "c:\\data\\log\\my.cfg"  
  
7.  서비스 서버 실행 및 중단

     c:\\> Net start MyMongo c:\\> Net stop MyMongo

---

****□ **실습 2**

```
// mongo 실행
C:\Users\hyeri>mongo


// 몽고폴더 확인
> show dbs
admin    0.000GB
config   0.000GB
local    0.000GB
my_test  0.000GB
test     0.000GB


// my_test 폴더를 실행해보자.
use my_test
switched to db my_test


// 폴더 도움말 확인
 db.help()
DB methods:
        db.adminCommand(nameOrDocument) - switches to 'admin' db, and runs command [just calls db.runCommand(...)]
        db.aggregate([pipeline], {options}) - performs a collectionless aggregation on this database; returns a cursor
'''        
        
// 상태확인
db.stats()
{
        "db" : "my_test" '''
        
// 컬렉션 이름 확인
 db.getCollectionNames()
[ "exam", "exam01", "exam03", "my", "nums" ]


//컬렉션 도움말 확인
db.exam.help()
DBCollection help
```

---

**\# 테이블을 생성한 후 데이터를 입력하자.**

** 오라클**

```
 CREATE TABLE MY(
    USER_ID VARCHAR2(20), AGE NUMBER, STATUS VARCHAR2(5));
    INSERT INTO MY VALUES ('AAA', 23, 'A');
```

** 몽고DB**

 1) 컬렉션(테이블) 생성

```
> db.createCollection("h2exam");
{ "ok" : 1 }
		# Collection 만 생성
```

2) 컬렉션과 컬럼 값 생성

```
> db.h1exam.insert({a : "a"}) -- h1exam 컬렉션에 a 키-값 넣기
WriteResult({ "nInserted" : 1 })

> db.h1exam.find() -- h1exam 컬렉션, 값 확인
{ "_id" : ObjectId("60c1cdd615f08de2ce5aa5e0"), "a" : "a" }
```

3) 현재 만들어진 컬렉션과 그 안의 상태 확인

```
# -- 현재 만들어진 컬렉션 확인
> db.getCollectionNames()
[ "exam", "exam01", "exam03", "h1exam", "h2exam", "my", "nums" ]


# -- h2exam 상태 확인해보자
> db.exam01.stats() 
{
        "ns" : "my_test.h2exam",
        "size" : 0,
        "count" : 0,
        "storageSize" : 4096,
        "freeStorageSize" : 0,
        "capped" : false,
        "wiredTiger" : {
                "metadata" : {
                        "formatVersion" : 1
                },
                "creationString" :

# -- 모든 컬렉션 상태 가져옴
> db.printCollectionStats() 
exam
{
        "ns" : "my_test.exam",
        "size" : 31,
        "count" : 1,
        "avgObjSize" : 31,
        "storageSize" : 20480,
        "freeStorageSize" : 0,
        "capped" : false,
        "wiredTiger" : {
                "metadata" : {
                        "formatVersion" : 1
                },
                "creationString" : "
```

**\# h3exam 테이블을 생성한 후 여러 개의 데이터를 입력하자.**

```
> db.h3exam.insert({user_id:"aaa", age:23, status:"A"})
WriteResult({ "nInserted" : 1 }) -- 1개입력

> db.h3exam.insert([{user_id:"bbb",age:40,status:"B"},
...                   {user_id:"ccc",age:30,status:"C"},
...                   {user_id:"ddd",age:30,status:"D"},
...                   {user_id:"eee",age:30,status:"E"},
...                   {user_id:"fff",age:30,status:"F"}]);
BulkWriteResult({
        "writeErrors" : [ ],
        "writeConcernErrors" : [ ],
        "nInserted" : 5,
        "nUpserted" : 0,
        "nMatched" : 0,
        "nModified" : 0,
        "nRemoved" : 0,
        "upserted" : [ ]
}) -- 여러개 입력


> db.h3exam.find() -- 컬렉션 내의 필드(키:값)확인
{ "_id" : ObjectId("60c1d4a715f08de2ce5aa5e1"), "user_id" : "aaa", "age" : 23, "status" : "A" }
{ "_id" : ObjectId("60c1d54015f08de2ce5aa5e2"), "user_id" : "bbb", "age" : 40, "status" : "B" }
{ "_id" : ObjectId("60c1d54015f08de2ce5aa5e3"), "user_id" : "ccc", "age" : 30, "status" : "C" }
{ "_id" : ObjectId("60c1d54015f08de2ce5aa5e4"), "user_id" : "ddd", "age" : 30, "status" : "D" }
{ "_id" : ObjectId("60c1d54015f08de2ce5aa5e5"), "user_id" : "eee", "age" : 30, "status" : "E" }
{ "_id" : ObjectId("60c1d54015f08de2ce5aa5e6"), "user_id" : "fff", "age" : 30, "status" : "F" }
```

**□ BSON **

    : Binary JSON(JavaScript Object Notaion)  
      JSON의 일부, MongoDB에서 JSON으로는 부족함이 있어, 데이터를 저장하기 위해 BSON을 만듬

** 데이터 타입**

**#  h4exam 테이블을 생성한 후 숫자를 입력 해 보자.**

**기본적으로 모든 숫자를 부동 소수점 값 으로 취급**

 NumberInt () : 생성자를 제공하여 32비트 정수를 명시적으로 지정

 NumberLong() : 64비트 정수를 처리하기 위해 명시적으로 지정 

```
> db.h4exam.save({num:100000})
WriteResult({ "nInserted" : 1 })

> db.h4exam.save({num:NumberInt(10000)}) -- 32bit
WriteResult({ "nInserted" : 1 })

> db.h4exam.save({num:NumberLong(10000)}) -- 64bit
WriteResult({ "nInserted" : 1 })

> db.h4exam.find()
{ "_id" : ObjectId("60c1d89d15f08de2ce5aa5e7"), "num" : 100000 }
{ "_id" : ObjectId("60c1d8bc15f08de2ce5aa5e8"), "num" : 10000 }
{ "_id" : ObjectId("60c1d8cb15f08de2ce5aa5e9"), "num" : NumberLong(10000) }
```

**\# $type 을 이용해 BSON 유형을 알아보자.**

 1) int32 자료형을 찾아라

```
> db.h4exam.find({num:{$type:16}})
{ "_id" : ObjectId("60c1d8bc15f08de2ce5aa5e8"), "num" : 10000 }

```

 2) int64 자료형을 찾아라

```
> db.h4exam.find({num:{$type:18}})
{ "_id" : ObjectId("60c1d8cb15f08de2ce5aa5e9"), "num" : NumberLong(10000) }
```

3) double 자료형을 찾아라

```
# double : 8 바이트 (64 비트 IEEE 754-2008 바이너리 부동 소수점)

> db.h4exam.save({num:98.9}) -- 실수형 데이터 추가 입력 
WriteResult({ "nInserted" : 1 })

> db.h4exam.find({num:{$type:1}})
{ "_id" : ObjectId("60c1d89d15f08de2ce5aa5e7"), "num" : 100000 }
{ "_id" : ObjectId("60c1dd5015f08de2ce5aa5ea"), "num" : 98.9 }
>
```

4) new Date() 객체를 입력

```
> db.h4exam.save({num:new Date()})
WriteResult({ "nInserted" : 1 })

> db.h4exam.save({num:new Date()+1})
WriteResult({ "nInserted" : 1 })

> new Date()
ISODate("2021-06-10T09:41:32.099Z")

> new Date()+1 -- 문자열(string)
Thu Jun 10 2021 18:41:36 GMT+09001
>

```

5) typeof 객체의 타입을 확인 후, date 객체를 찾아보자.

```
> typeof new Date()
object

> db.h4exam.find({num:{$type:9}}) -- date 타입
{ "_id" : ObjectId("60c1de3215f08de2ce5aa5eb"), "num" : ISODate("2021-06-10T09:41:06.163Z") }

> db.h4exam.find({num:{$type:3}})
> db.h4exam.find({num:{$type:2}}) -- string 타입
{ "_id" : ObjectId("60c1de4615f08de2ce5aa5ec"), "num" : "Thu Jun 10 2021 18:41:26 GMT+09001" }

```

**□ SAVE () **

   : insert, update 와 같은 뜻을 가지지만 insert, update는 특정 필드 값을 추가, 수정하는 구문이라면  
    save는 내용 전체를 덮어쓰는 기능을 가진다.  

매개변수로 \_id를 지정하지 않으면 insert와 같은 뜻을 가지게 된다.  
     매개변수로 전달되는 경우에는 있으면 덮어쓰고 없으면 새로 추가된다.

**\# 예를 들어보자**

```
# == save ==

> db.h5exam.save({item:"book", qty:40})
WriteResult({ "nInserted" : 1 }) -- insert 기능

> db.h5exam.find()
{ "_id" : ObjectId("60c1e49d15f08de2ce5aa5ed"), "item" : "book", "qty" : 40 }

> db.h5exam.save({_id:1111, item:"book", qty:40})
WriteResult({ "nMatched" : 0, "nUpserted" : 1, "nModified" : 0, "_id" : 1111 })
 -- _id 를 지정하면 같은 값이 없으면 upinsert (새로추가)
 
> db.h5exam.find()
{ "_id" : ObjectId("60c1e49d15f08de2ce5aa5ed"), "item" : "book", "qty" : 40 }
{ "_id" : 1111, "item" : "book", "qty" : 40 }

> db.h5exam.save({_id:1111, item:"book", qty:140})
WriteResult({ "nMatched" : 1, "nUpserted" : 0, "nModified" : 1 })
 -- _id 를 지정하면 같은 값이 있으면 (matched) 덮어쓰기 (modified) 

> db.h5exam.find()
{ "_id" : ObjectId("60c1e49d15f08de2ce5aa5ed"), "item" : "book", "qty" : 40 }
{ "_id" : 1111, "item" : "book", "qty" : 140 }


# == insert ==
> db.h5exam.insert({_id:1111, item:"book", qty:140}) -- 같은 값이 있으면 오류남(not insert)
WriteResult({
        "nInserted" : 0,
        "writeError" : {
                "code" : 11000,
                "errmsg" : "E11000 duplicate key error collection: my_test.h5exam index: _id_ dup key: { _id: 1111.0 }"
        }
})
> db.h5exam.find()
{ "_id" : ObjectId("60c1e49d15f08de2ce5aa5ed"), "item" : "book", "qty" : 40 }
{ "_id" : 1111, "item" : "book", "qty" : 140 }
>
```

---

**Q1) h3exam 컬렉션의 전체 내용을 확인 하자.**

      = select \* from h3exam;

```
> db.h3exam.find()
{ "_id" : ObjectId("60c1d4a715f08de2ce5aa5e1"), "user_id" : "aaa", "age" : 23, "status" : "A" }
{ "_id" : ObjectId("60c1d54015f08de2ce5aa5e2"), "user_id" : "bbb", "age" : 40, "status" : "B" }
{ "_id" : ObjectId("60c1d54015f08de2ce5aa5e3"), "user_id" : "ccc", "age" : 30, "status" : "C" }
{ "_id" : ObjectId("60c1d54015f08de2ce5aa5e4"), "user_id" : "ddd", "age" : 30, "status" : "D" }
{ "_id" : ObjectId("60c1d54015f08de2ce5aa5e5"), "user_id" : "eee", "age" : 30, "status" : "E" }
{ "_id" : ObjectId("60c1d54015f08de2ce5aa5e6"), "user_id" : "fff", "age" : 30, "status" : "F" }
```

**Q2) **h3exam**컬렉션에서 user\_id, age, status 값을 리턴받자. 단, \_id 도 제외 하고 출력하자.**

   = select user\_id, age, status from h3exam;

```
// 일반적인 select 문장에는 값을 리턴받을 {}을 주자.
// {user_id:1, age:1, status:1} 에서 "값 출력은 1, 제외는 0" 입력

// user_id, age, status 출력 ( defalt값으로 _id 도 같이 출력된다)
> db.h3exam.find({},{user_id:1, age:1, status:1});
{ "_id" : ObjectId("60c1d4a715f08de2ce5aa5e1"), "user_id" : "aaa", "age" : 23, "status" : "A" }
{ "_id" : ObjectId("60c1d54015f08de2ce5aa5e2"), "user_id" : "bbb", "age" : 40, "status" : "B" }
{ "_id" : ObjectId("60c1d54015f08de2ce5aa5e3"), "user_id" : "ccc", "age" : 30, "status" : "C" }
{ "_id" : ObjectId("60c1d54015f08de2ce5aa5e4"), "user_id" : "ddd", "age" : 30, "status" : "D" }
{ "_id" : ObjectId("60c1d54015f08de2ce5aa5e5"), "user_id" : "eee", "age" : 30, "status" : "E" }
{ "_id" : ObjectId("60c1d54015f08de2ce5aa5e6"), "user_id" : "fff", "age" : 30, "status" : "F" }


// _id 값을 제외하고 리턴하려면 _id : 0을 주자
> db.h3exam.find({},{user_id:1, age:1, status:1, _id:0});
{ "user_id" : "aaa", "age" : 23, "status" : "A" }
{ "user_id" : "bbb", "age" : 40, "status" : "B" }
{ "user_id" : "ccc", "age" : 30, "status" : "C" }
{ "user_id" : "ddd", "age" : 30, "status" : "D" }
{ "user_id" : "eee", "age" : 30, "status" : "E" }
{ "user_id" : "fff", "age" : 30, "status" : "F" }
>
```

**Q3) age, user\_id **

```
> db.h3exam.find({},{age:1, user_id:1, _id:0});
{ "user_id" : "aaa", "age" : 23 }
{ "user_id" : "bbb", "age" : 40 }
{ "user_id" : "ccc", "age" : 30 }
{ "user_id" : "ddd", "age" : 30 }
{ "user_id" : "eee", "age" : 30 }
{ "user_id" : "fff", "age" : 30 }
>
```

**Q4) status 'A'인 문서만 리턴하자.**

   = select \* from   h3exam   where status = 'A'

```
> db.h3exam.find({status:"A"})
{ "_id" : ObjectId("60c1d4a715f08de2ce5aa5e1"), "user_id" : "aaa", "age" : 23, "status" : "A" }
>
```

**Q5) status 'A' 인 문서에서 user\_id, status 만 출력하자.**

```
> db.h3exam.find({status : "A"},{user_id:1, status:1, _id:0})
{ "user_id" : "aaa", "status" : "A" }
>
```

**□ $SET**

  : 지정된 값을 가진 필드의 값을 대체한다.

**Q6) user\_id 가 fff인 status를 G로 변경해보자**

```
// updateOne 필터와 일치하는 문서를 찾고 지정된 수정사항 적용

> db.h3exam.updateOne({user_id:"fff"},{$set:{status:"G"}});
{ "acknowledged" : true, "matchedCount" : 1, "modifiedCount" : 1 }


> db.h3exam.find()
{ "_id" : ObjectId("60c1d4a715f08de2ce5aa5e1"), "user_id" : "aaa", "age" : 23, "status" : "A" }
{ "_id" : ObjectId("60c1d54015f08de2ce5aa5e2"), "user_id" : "bbb", "age" : 40, "status" : "B" }
{ "_id" : ObjectId("60c1d54015f08de2ce5aa5e3"), "user_id" : "ccc", "age" : 30, "status" : "C" }
{ "_id" : ObjectId("60c1d54015f08de2ce5aa5e4"), "user_id" : "ddd", "age" : 30, "status" : "D" }
{ "_id" : ObjectId("60c1d54015f08de2ce5aa5e5"), "user_id" : "eee", "age" : 30, "status" : "E" }
{ "_id" : ObjectId("60c1d54015f08de2ce5aa5e6"), "user_id" : "fff", "age" : 30, "status" : "G" }
```

**Q7) age 가 40 이상인 데이터의 status를 K로 변경해보자**

```
// updateMany 여러문서 업데이트
// $gte : 지정된 값보다 크거나 같은 값
// $gt : 지정된 값보다 큰 값
> db.h3exam.updateMany({age:{$gte:40}},{$set:{status:"K"}})
{ "acknowledged" : true, "matchedCount" : 1, "modifiedCount" : 1 }


> db.h3exam.find()
{ "_id" : ObjectId("60c1d4a715f08de2ce5aa5e1"), "user_id" : "aaa", "age" : 23, "status" : "A" }
{ "_id" : ObjectId("60c1d54015f08de2ce5aa5e2"), "user_id" : "bbb", "age" : 40, "status" : "K" }
{ "_id" : ObjectId("60c1d54015f08de2ce5aa5e3"), "user_id" : "ccc", "age" : 30, "status" : "C" }
{ "_id" : ObjectId("60c1d54015f08de2ce5aa5e4"), "user_id" : "ddd", "age" : 30, "status" : "D" }
{ "_id" : ObjectId("60c1d54015f08de2ce5aa5e5"), "user_id" : "eee", "age" : 30, "status" : "E" }
{ "_id" : ObjectId("60c1d54015f08de2ce5aa5e6"), "user_id" : "fff", "age" : 30, "status" : "G" }
>
```

**Q8) age가 25 초과인 데이터의 status를 C로 변경해보자**

```
//$gt 지정된 값보다 큰 값과 일치 
> db.h3exam.update({age:{$gt:25}},{$set:{status : "C"}},{multi:true});
WriteResult({ "nMatched" : 5, "nUpserted" : 0, "nModified" : 4 })

> db.h3exam.find()
{ "_id" : ObjectId("60c1d4a715f08de2ce5aa5e1"), "user_id" : "aaa", "age" : 23, "status" : "A" }
{ "_id" : ObjectId("60c1d54015f08de2ce5aa5e2"), "user_id" : "bbb", "age" : 40, "status" : "C" }
{ "_id" : ObjectId("60c1d54015f08de2ce5aa5e3"), "user_id" : "ccc", "age" : 30, "status" : "C" }
{ "_id" : ObjectId("60c1d54015f08de2ce5aa5e4"), "user_id" : "ddd", "age" : 30, "status" : "C" }
{ "_id" : ObjectId("60c1d54015f08de2ce5aa5e5"), "user_id" : "eee", "age" : 30, "status" : "C" }
{ "_id" : ObjectId("60c1d54015f08de2ce5aa5e6"), "user_id" : "fff", "age" : 30, "status" : "C" }
>
```
