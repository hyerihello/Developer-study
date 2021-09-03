😎 mongoDB 메뉴얼에서 import/export 관련 문서는 4.2 버전에서 확인하기

     (21.06.16 기준, 추 후 업데이트 될 수 있음)

## **mongoimport**

 : MongoDB 가져오기

   외부의 파일에서 현재 데이터베이스로 불러오는 경우 사용

## **mongoexport**

 : MongoDB 내보내기

   현재 데이터베이스를 외부파일로 내보내는 경우 사용

**\[의미\]**

  
**\- h\[--host\], u\[--username\], -p\[--password\], -d\[--db\], -c\[--collection\], -f\[--fields\], --file, --drop, --out,**

```
 // myaddr.json 으로 아래의 파일을 저장 
 
    {"address" : [
    {"name":"홍길동", "addr":"서울시 서초동"},
    {"name":"정길동", "addr":"제주시 제주동"}]}
```

**\# 먼저 Test 디렉터리 안에 문서를 확인 후 json 파일 타입 확인 해 보자.**

```
C:\Test>dir/w
 C 드라이브의 볼륨에는 이름이 없습니다.
 볼륨 일련 번호: BE80-C42F

 C:\Test 디렉터리

[.]           [..]          1.jpg         2.jpg         3.jpg
a.txt         b.txt         c.json        c.txt         d.mp4
myaddr.json
               9개 파일          34,202,093 바이트
               2개 디렉터리  409,474,809,856 바이트 남음

C:\Test>type myaddr.json
 {"address" : [
     {"name":"?띻만??, "addr":"?쒖슱???쒖큹??},
     {"name":"?뺢만??, "addr":"?쒖＜???쒖＜??}]}

C:\Test>
```

**Q1) myaddr.json을 new\_db의 test\_addr 이란 컬렉션으로 import 하자**

 mongoimport --db new\_db --collection test\_addr --file myaddr.json

```
C:\Test>mongoimport --db=new_db --collection=test_addr --file=myaddr.json
2021-06-17T18:40:42.718+0900    connected to: mongodb://localhost/
2021-06-17T18:40:42.777+0900    1 document(s) imported successfully. 0 document(s) failed to import.

> db.test_addr.find()
{ "_id" : ObjectId("60cb1791461be1c56e46ded5"), "address" : [ { "name" : "홍길동", "addr" : "서울시 서초동" }, { "name" : "정길동", "addr" : "제주시 제주동" } ] }
```

**Q2) test\_addr라는 컬렉션을 myexport.json으로 export한다.**

mongoexport --db new\_db -c test\_addr --out myexport.json

```
C:\Test>mongoexport --db new_db -c test_addr --out myexport.json
2021-06-17T22:17:10.477+0900    connected to: mongodb://localhost/
2021-06-17T22:17:10.541+0900    exported 1 records


{"_id":{"$oid":"60cb1791461be1c56e46ded5"},"address":[{"name":"홍길동","addr":"서울시 서초동"},
{"name":"정길동","addr":"제주시 제주동"}]}
```

  
**Q3) addrtest라는 컬렉션을 mycsv.csv로 export한다.**

  
mongoexport --db new-db -c test\_addr --out mycsv.csv

```
C:\Test>mongoexport --db newdb -c addrtest --out mycsv.csv
2021-06-17T22:52:06.073+0900    connected to: mongodb://localhost/
2021-06-17T22:52:06.137+0900    exported 1 record
```

  
**Q4) Score라는 컬렉션을 myScore.csv로 export한다.**

  
mongoexport -d my\_score -c Score --out myScore.csv

```
C:\Test>mongoexport -d my_score -c Score --out myScore.csv
2021-06-17T22:49:07.154+0900    connected to: mongodb://localhost/
2021-06-17T22:49:07.221+0900    exported 7 records
```

  
**Q5) Score라는 컬렉션을 myScore.tsv로 export한다.**

  
mongoexport -d my\_score -c Score --out myScore.tsv

```
C:\Test>mongoexport -d my_score -c Score --out myScore.tsv
2021-06-17T22:53:17.682+0900    connected to: mongodb://localhost/
2021-06-17T22:53:17.757+0900    exported 7 records
```

  
**Q6) myScore.csv를 newdb의 test\_myScore 라는 컬렉션으로 import한다.**

  
mongoimport --db new\_db --collection test\_myScore --file myScore.csv

```
C:\Test>mongoimport --db new_db --collection test_myScore --file myScore.csv
2021-06-17T22:54:42.490+0900    connected to: mongodb://localhost/
2021-06-17T22:54:42.559+0900    7 document(s) imported successfully. 0 document(s) failed to import.

> db.test_myScore.find()
{ "_id" : ObjectId("60c2c46e98e69dd9d8688086"), "name" : "eee", "kor" : 60, "eng" : 80, "mat" : 78, "test" : "final" }
{ "_id" : ObjectId("60c2c46e98e69dd9d8688084"), "name" : "ccc", "kor" : 80, "eng" : 55, "mat" : 67, "test" : "midterm" }
{ "_id" : ObjectId("60c2c46d98e69dd9d8688082"), "name" : "aaa", "kor" : 90, "eng" : 80, "mat" : 98, "test" : "midterm" }
{ "_id" : ObjectId("60c2c46e98e69dd9d8688083"), "name" : "bbb", "kor" : 100, "eng" : 100, "mat" : 76, "test" : "final" }
{ "_id" : ObjectId("60c2c46e98e69dd9d8688085"), "name" : "ddd", "kor" : 70, "eng" : 69, "mat" : 89, "test" : "midterm" }
{ "_id" : ObjectId("60c2c46e98e69dd9d8688087"), "name" : "fff", "kor" : 100, "eng" : 69, "mat" : 89, "test" : "midterm" }
{ "_id" : ObjectId("60c2c47198e69dd9d8688088"), "name" : "ggg", "kor" : 75, "eng" : 100, "mat" : 100, "test" : "final" }
>
```

  
**Q7) Score 라는 컬렉션을 이름, 국어 점수만 a1.txt 으로 export해보자.**

  
mongoexport --db my\_score --collection=Score --fields=Name,kor --out=/opt/backups/aa.txt

```
C:\Test>mongoexport --db my_score --collection Score --fields=Name,kor --out a1.txt
2021-06-17T22:59:52.946+0900    connected to: mongodb://localhost/
2021-06-17T22:59:53.009+0900    exported 7 records
```

  
  
**Q8) Score 컬렉션에서 국어점수가 60이상 인 문서만 b1.txt 으로 export해보자.**  
  
mongoexport --db=my\_score -c=Score -q="{\\"kor\\":{\\"$gte\\":60}}" --out b1.txt

```
C:\Test>mongoexport --db=my_score -c=Score -q="{\"kor\":{\"$gte\":60}}" --out b1.txt
2021-06-17T23:01:41.274+0900    connected to: mongodb://localhost/
2021-06-17T23:01:41.345+0900    exported 7 records
```

## **Sharding** 

  데이터를 여러 서버에 분할 하는 것을 말한다.  
  (MongoDB의 데이터 분할은 상황에 따라 각 Shard로 이동되어 Mongodb 이용자(앱, 웹)는

여러 서버를 인식하지 않고 데이터를 적재 시킨다.)  

복제는 동일한 데이터의 사본을 여러 DB에 가지고 있는 반면, Sharding은 다른 데이터를 여러서버 (DB)에 가진다.  
보통의 몽고 운영은 Sharding + ReplicaSet(복제) 구성된다.

  
** 1. shard(샤드)**

   : 실제로 데이터가 저장되어 있는 mongod 프로세스이며,

    하나의 문서는(document) 하나의 샤드에 저장되어 샤드간의 데이터 복제는 하지 않는다.  
    ReplicaSet(복제) 구성하는 것을 권장.  
  
** 2. config 서버**

    : 샤드 메타데이터를 관리하는 mongod 프로세스로 단일 장애 지점이 된다.  
    (config -> 환경설정)  
  
 **3\. mongos 서버**

   : 샤드의 라우팅 프로세스이다. 샤드와 클라이언트를 연계 시킨다.  
필요하다면 여러개의 mongos 서버를 가질 수 있다. 상태 값, 데이터는 전혀 가지고 있지 않다.  
  
 **4\. 샤드키**

   : 데이터를 분산하는 범위의 키로 복수 지정 할 수 있다.  
키에 어떤 범위의 데이터가 어떤 샤드에 저장되는 지를 MongoDB가 관리하고

데이터의 편차에 따라 자동으로 조정된다.  
  
 **5\. 청크**

   : 샤드의 덩어리를 말하며 분산 데이터의 단위이다.  
    구체적으로는 컬렉션의 연속 된 범위의 데이터의 문서를 말한다.  
    청크의 최대 크기에 도달 하면 분할 된 샤드가 가지고 있는 청크 수에 따라 필요한 경우

    다른 샤드로 데이터가 이동된다.  
    청크의 최대 크기는 변경 할 수 있다.
