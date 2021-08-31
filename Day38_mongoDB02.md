**✨ 연산자 활용, 집계 함수**
​
**\# score 컬렉션 생성 **
​
```
> use my_score
switched to db my_score
​
​
> db.score.insert({name:"aaa", kor :90, eng:80, mat:98, test:"midterm"})
WriteResult({ "nInserted" : 1 })
> db.score.insert({name:"bbb", kor :100, eng:100, mat:76, test:"final"})
WriteResult({ "nInserted" : 1 })
> db.score.insert({name:"ccc", kor :80, eng:55, mat:67, test:"midterm"})
WriteResult({ "nInserted" : 1 })
> db.score.insert({name:"ddd", kor :70, eng:69, mat:89, test:"midterm"})
WriteResult({ "nInserted" : 1 })
> db.score.insert({name:"eee", kor :60, eng:80, mat:78, test:"final"})
WriteResult({ "nInserted" : 1 })
> db.score.insert({name:"fff", kor :100, eng:69, mat:89, test:"midterm"})
WriteResult({ "nInserted" : 1 })
> db.score.insert({name:"ggg", kor :75, eng:100, mat:100, test:"final"})
WriteResult({ "nInserted" : 1 })
​
> db.score.find()
{ "_id" : ObjectId("60c460855033a1b5fc1e5800"), "name" : "aaa", "kor" : 90, "eng" : 80, "mat" : 98, "test" : "midterm" }
{ "_id" : ObjectId("60c460855033a1b5fc1e5801"), "name" : "bbb", "kor" : 100, "eng" : 100, "mat" : 76, "test" : "final" }
{ "_id" : ObjectId("60c460855033a1b5fc1e5802"), "name" : "ccc", "kor" : 80, "eng" : 55, "mat" : 67, "test" : "midterm" }
{ "_id" : ObjectId("60c460855033a1b5fc1e5803"), "name" : "ddd", "kor" : 70, "eng" : 69, "mat" : 89, "test" : "midterm" }
{ "_id" : ObjectId("60c460855033a1b5fc1e5804"), "name" : "eee", "kor" : 60, "eng" : 80, "mat" : 78, "test" : "final" }
{ "_id" : ObjectId("60c460855033a1b5fc1e5805"), "name" : "fff", "kor" : 100, "eng" : 69, "mat" : 89, "test" : "midterm" }
{ "_id" : ObjectId("60c460875033a1b5fc1e5806"), "name" : "ggg", "kor" : 75, "eng" : 100, "mat" : 100, "test" : "final" }
>
```
​
## **집계 함수**
​
**    count()**
​
        : 컬렉션 내, 문서의 갯수를 조회
​
    **distinct()**
​
        : 지정된 key에 대한 중복 제거, 컬렉션과 키를 지정해 주어야 함.
​
    **sort()**
​
       : 정렬, -1을 하면 내림차순
​
    **limit()**
​
      : 제한하기
​
**Q1) Score의 전체 출력을 해보고 문서의 갯수를 구하자.**
​
  
db.Score.find();  
db.Score.find().count();
​
```
> db.Score.find();
{ "_id" : ObjectId("60c2c46d98e69dd9d8688082"), "name" : "aaa", "kor" : 90, "eng" : 80, "mat" : 98, "test" : "midterm" }
{ "_id" : ObjectId("60c2c46e98e69dd9d8688083"), "name" : "bbb", "kor" : 100, "eng" : 100, "mat" : 76, "test" : "final" }
{ "_id" : ObjectId("60c2c46e98e69dd9d8688084"), "name" : "ccc", "kor" : 80, "eng" : 55, "mat" : 67, "test" : "midterm" }
{ "_id" : ObjectId("60c2c46e98e69dd9d8688085"), "name" : "ddd", "kor" : 70, "eng" : 69, "mat" : 89, "test" : "midterm" }
{ "_id" : ObjectId("60c2c46e98e69dd9d8688086"), "name" : "eee", "kor" : 60, "eng" : 80, "mat" : 78, "test" : "final" }
{ "_id" : ObjectId("60c2c46e98e69dd9d8688087"), "name" : "fff", "kor" : 100, "eng" : 69, "mat" : 89, "test" : "midterm" }
{ "_id" : ObjectId("60c2c47198e69dd9d8688088"), "name" : "ggg", "kor" : 75, "eng" : 100, "mat" : 100, "test" : "final" }
​
​
> db.score.find().count();
7
​
​
```
​
  
**Q2) Score의 이름과 수학점수만 출력해보자.**
​
  
db.Score.find({},{name:1, mat:1, \_id:0});
​
```
> db.Score.find({},{name:1, mat:1, _id:0});
{ "name" : "aaa", "mat" : 98 }
{ "name" : "bbb", "mat" : 76 }
{ "name" : "ccc", "mat" : 67 }
{ "name" : "ddd", "mat" : 89 }
{ "name" : "eee", "mat" : 78 }
{ "name" : "fff", "mat" : 89 }
{ "name" : "ggg", "mat" : 100 }
>
​
```
​
  
**Q3) Score 수학점수 중 70점 이상만 출력해보자.**
​
  
db.Score.find({mat:{$gte:70}});  
db.Score.find({mat:{$gte:70}}).count();
​
```
> db.Score.find({mat:{$gte:70}},{_id:0});
{ "name" : "aaa", "kor" : 90, "eng" : 80, "mat" : 98, "test" : "midterm" }
{ "name" : "bbb", "kor" : 100, "eng" : 100, "mat" : 76, "test" : "final" }
{ "name" : "ddd", "kor" : 70, "eng" : 69, "mat" : 89, "test" : "midterm" }
{ "name" : "eee", "kor" : 60, "eng" : 80, "mat" : 78, "test" : "final" }
{ "name" : "fff", "kor" : 100, "eng" : 69, "mat" : 89, "test" : "midterm" }
{ "name" : "ggg", "kor" : 75, "eng" : 100, "mat" : 100, "test" : "final" }
> db.Score.find({mat:{$gte:70}},{_id:0}).count();
6
>
```
​
  
**Q4) Score 이름과 국어점수를 출력하되 국어점수가 80점 이상만 출력해보자.**
​
  
db.Score.find({kor:{$gte:80}},{name:1,kor:1,\_id:0});  
                   : 앞이 조건문(where),뒤가 선택문(select)
​
```
> db.Score.find({kor:{$gte:80}},{name:1, kor:1,_id:0});
{ "name" : "aaa", "kor" : 90 }
{ "name" : "bbb", "kor" : 100 }
{ "name" : "ccc", "kor" : 80 }
{ "name" : "fff", "kor" : 100 }
>
```
​
**□ Cursor 반복문 **
​
 : 몽고 디비에선 특정 조회의 결과 값으로 Cursor를 리턴한다. 
​
  하지만 var 키워드로 한 변수로 커서를 할당하지 않으면 결과 갯수만큼 반복문을 통한 결과 값을 출력한다. 
​
  
**Q4-1)  Score 이름과 국어점수를 출력하되 국어점수가 80점 이상 추출 해서 합을 구하자.**
​
       **※ 변수 선언 후 출력 해보기 **
​
           var sr = db.Score.find({kor:{$gte:80}},{name:1,kor:1,\_id:0});  
           sr; // 변수 리턴 후 소멸  
           print(sr); // DB 쿼리는 참조하고 있음  
  
          sr=null; // **null값 지정하면, null 이 된다.**  
          print(sr);  
          
​
```
> var sr =  db.Score.find({kor:{$gte:80}},{name:1, kor:1,_id:0});
> sr;
{ "name" : "aaa", "kor" : 90 }
{ "name" : "bbb", "kor" : 100 }
{ "name" : "ccc", "kor" : 80 }
{ "name" : "fff", "kor" : 100 }
> print(sr);
DBQuery: my_score.Score -> { "kor" : { "$gte" : 80 } }
​
​
> sr = null;
null
> print(sr);
[unknown type]
>
​
```
​
  
var sr = db.Score.find({kor:{$gte:80}},{name:1,kor:1,\_id:0});  
var tot = 0;  
while(sr.hasNext()){  
res = sr.next(); // 지역변수 res  
print(res.name + ":" + res.kor);  
tot += res.kor;  
print ( "tot = " + tot);  
};  
print ( "나는결과 tot = " + tot);
​
```
> var sr = db.Score.find({kor:{$gte:80}},{name:1, kor:1,_id:0});
> var tot = 0;
​
> while(sr.hasNext()){
// ↖sr.hasNext()는 다음 도큐먼트가 있는지 검사한다. 있으면 true, 없다면 false 반환
... res = sr.next();
// ↖sr.hasNext()가 true 이면 다음 도큐먼트 (sr.next())로 이동
... print (res.name + " : " + res.kor);
... tot += res.kor;
... print ("tot = " + tot);};
aaa : 90
tot = 90
bbb : 100
tot = 190
ccc : 80
tot = 270
fff : 100
tot = 370
​
> print(" 나는 결과 tot => " + tot);
 나는 결과 tot => 370
>
```
​
  
\> sr.max()  
\> sr.min()  
\> sr.toArray()  
\[ \]  
  
**Q) 4-2 forEach 확인 해보자.**
​
   : while문 대신에 forEach 로도 작성 가능하다.
​
   : db.user.find().forEach(function(myDoc){print("user : " + myDoc.name);});
​
  
var sr02 = db.Score.find({kor:{$gte:80}},{name:1,kor:1,\_id:0});  
sr02.forEach(  
function(x){  
print(x.name + " : " + x.kor);  
}  
);
​
```
// [형식]
// db.user.find().forEach(function(myDoc){print("user : " + myDoc.name);});
​
> var sr02 = db.Score.find({kor:{$gte:80}},{name:1, kor:1, _id:0});
> sr02.forEach(
... function(x){
... print(x.name + " : " + x.kor);});
aaa : 90
bbb : 100
ccc : 80
fff : 100
>
```
​
  
  
**Q5) test 의 midterm만 출력해보자.**
​
  
db.Score.find({test:{$eq:"midterm"}},{name:1,test:1,\_id:0});  
var sm = db.Score.find();  
sm.forEach(function(x){  
if(x.test == "midterm"){  
print(x.name + " : " + x.test);  
}});
​
```
> db.Score.find({test:{$eq:"midterm"}},{name:1,test:1,_id:0});
{ "name" : "aaa", "test" : "midterm" }
{ "name" : "ccc", "test" : "midterm" }
{ "name" : "ddd", "test" : "midterm" }
{ "name" : "fff", "test" : "midterm" }
​
​
> var sm = db.Score.find();
> sm.forEach(function(x){
... if(x.test == "midterm"){
... print(x.name + " : " + x.test);}});
aaa : midterm
ccc : midterm
ddd : midterm
fff : midterm
>
```
​
  
**Q6) 이름이 a로 시작되는 이름을 찾아보자.**
​
  
db.Score.find({name:/^a/});
​
```
> db.Score.find({name:/^a/});
{ "_id" : ObjectId("60c2c46d98e69dd9d8688082"), 
   "name" : "aaa", "kor" : 90, "eng" : 80, "mat" : 98, "test" : "midterm" }
```
​
  
**Q6-1)이름이 a로 시작되거나 e로 시작되는 문서를 찾아보자.**
​
  
db.Score.find({$or:\[{name:/^a/},{name:/^e/}\]});
​
```
> db.Score.find({$or:[{name:/^a/},{name:/^e/}]});
{ "_id" : ObjectId("60c2c46d98e69dd9d8688082"), 
  "name" : "aaa", "kor" : 90, "eng" : 80, "mat" : 98, "test" : "midterm" }
{ "_id" : ObjectId("60c2c46e98e69dd9d8688086"), 
  "name" : "eee", "kor" : 60, "eng" : 80, "mat" : 78, "test" : "final" }
```
​
  
**Q7) Score에서 test가 m으로 시작하는 문서의 갯수를 구하자.**
​
  
db.Score.find({test:/^m/}).count();
​
```
> db.Score.find({test:/^m/}).count();
4
```
​
  
**Q8) 이름을 출력하되 중복되지 않게 출력하자.**
​
    : distinct(필드, 쿼리)
​
db.Score.distinct("name");  
db.Score.distinct("test");
​
```
> db.Score.distinct("name");
[ "aaa", "bbb", "ccc", "ddd", "eee", "fff", "ggg" ]
​
> db.Score.distinct("test");
[ "final", "midterm" ]
>
```
​
  
  
**Q9) 영어점수가 80점 이상인 학생의 이름을 출력해보자. 단 이름은 중복되지 않게 출력해보자.**
​
  
db.Score.distinct("name",{eng:{$gte:80}});
​
```
> db.Score.distinct("name",{eng:{$gte:80}});
[ "aaa", "bbb", "eee", "ggg" ]
>
```
​
  
**Q10) next() 메소드를 사용하자 .docs**
​
  
var myCursor = db.Score.find( );  
var myDocument = myCursor.hasNext() ? myCursor.next() : null;  
if (myDocument) {  
var myName = myDocument.name;  
print (tojson(myName));  
};  
  
myCursor.hasNext()는 다음 도큐먼트가 있는지 검사한다. 있으면 true, 없다면 false 반환  
myCursor.hasNext()가 true 이면 다음 도큐먼트 (myCursor.next())로 이동하고
​
없으면 null을 변수 myDocument에 저장한다.
​
```
> var myCursor = db.Score.find( );
> var myDocument = myCursor.hasNext() ? myCursor.next() : null;
> if (myDocument) {
... var myName = myDocument.name;
... print (tojson(myName));
... };
"aaa"
>
```
​
  
  
if (myDocument) {  
var myName = myDocument.name;  
printjson(myName);  
};  
  
​
```
> if(myDocument){
... var myName = myDocument.name;
... printjson(myName);};
"aaa"
>
```
​
  
var myCursor = db.Score.find( );  
myCursor.forEach(printjson);
​
 : while 문 처럼 반복해 출력된다. 
​
```
> var myCursor = db.Score.find();
> myCursor.forEach(printjson);
{
        "_id" : ObjectId("60c2c46d98e69dd9d8688082"),
        "name" : "aaa",
        "kor" : 90,
        "eng" : 80,
        "mat" : 98,
        "test" : "midterm"
}
{
        "_id" : ObjectId("60c2c46e98e69dd9d8688083"),
        "name" : "bbb",
        "kor" : 100,
        "eng" : 100,
        "mat" : 76,
        "test" : "final"
}
{
        "_id" : ObjectId("60c2c46e98e69dd9d8688084"),
        "name" : "ccc",
        "kor" : 80,
        "eng" : 55,
        "mat" : 67,
        "test" : "midterm"
}
{
        "_id" : ObjectId("60c2c46e98e69dd9d8688085"),
        "name" : "ddd",
        "kor" : 70,
        "eng" : 69,
        "mat" : 89,
        "test" : "midterm"
}
{
        "_id" : ObjectId("60c2c46e98e69dd9d8688086"),
        "name" : "eee",
        "kor" : 60,
        "eng" : 80,
        "mat" : 78,
        "test" : "final"
}
{
        "_id" : ObjectId("60c2c46e98e69dd9d8688087"),
        "name" : "fff",
        "kor" : 100,
        "eng" : 69,
        "mat" : 89,
        "test" : "midterm"
}
{
        "_id" : ObjectId("60c2c47198e69dd9d8688088"),
        "name" : "ggg",
        "kor" : 75,
        "eng" : 100,
        "mat" : 100,
        "test" : "final"
}
>
```
​
  
var m = db.Score.find({},{name:1,\_id:0});  
m.forEach(printjson);
​
```
> var m = db.Score.find({},{name:1, _id:0});
> m.forEach(printjson);
{ "name" : "aaa" }
{ "name" : "bbb" }
{ "name" : "ccc" }
{ "name" : "ddd" }
{ "name" : "eee" }
{ "name" : "fff" }
{ "name" : "ggg" }
>
```
​
  
**Q11) test를 출력하 되 이름을 오름차순으로 정렬해보자.**
​
  
db.Score.find({},{"name":1, "test":1}).sort({"name":1});  
db.Score.find({},{"name":1, "test":1}).sort({"name":-1}); / 내림차순  
​
```
> db.Score.find({},{name:1, test:1}).sort({name:1});
{ "_id" : ObjectId("60c2c46d98e69dd9d8688082"), "name" : "aaa", "test" : "midterm" }
{ "_id" : ObjectId("60c2c46e98e69dd9d8688083"), "name" : "bbb", "test" : "final" }
{ "_id" : ObjectId("60c2c46e98e69dd9d8688084"), "name" : "ccc", "test" : "midterm" }
{ "_id" : ObjectId("60c2c46e98e69dd9d8688085"), "name" : "ddd", "test" : "midterm" }
{ "_id" : ObjectId("60c2c46e98e69dd9d8688086"), "name" : "eee", "test" : "final" }
{ "_id" : ObjectId("60c2c46e98e69dd9d8688087"), "name" : "fff", "test" : "midterm" }
{ "_id" : ObjectId("60c2c47198e69dd9d8688088"), "name" : "ggg", "test" : "final" }
​
> db.Score.find({},{name:1, test:1}).sort({name:-1});
{ "_id" : ObjectId("60c2c47198e69dd9d8688088"), "name" : "ggg", "test" : "final" }
{ "_id" : ObjectId("60c2c46e98e69dd9d8688087"), "name" : "fff", "test" : "midterm" }
{ "_id" : ObjectId("60c2c46e98e69dd9d8688086"), "name" : "eee", "test" : "final" }
{ "_id" : ObjectId("60c2c46e98e69dd9d8688085"), "name" : "ddd", "test" : "midterm" }
{ "_id" : ObjectId("60c2c46e98e69dd9d8688084"), "name" : "ccc", "test" : "midterm" }
{ "_id" : ObjectId("60c2c46e98e69dd9d8688083"), "name" : "bbb", "test" : "final" }
{ "_id" : ObjectId("60c2c46d98e69dd9d8688082"), "name" : "aaa", "test" : "midterm" }
>
```
​
**□** **최대값,최소값sort()+limit()**
​
  
**Q12) 영어 점수가 가장 높은 문서를 출력하자.**
​
  
db.Score.find({}).sort({eng:-1}).limit(1);
​
```
> db.Score.find({}).sort({eng:-1}).limit(1);
{ "_id" : ObjectId("60c2c46e98e69dd9d8688083"), 
  "name" : "bbb", "kor" : 100, "eng" : 100, "mat" : 76, "test" : "final" }
```
​
  
**Q13) 국어점수가 가장 낮은 문서를 출력하자.**
​
  
db.Score.find({}).sort({kor:1}).limit(1);
​
```
> db.Score.find({}).sort({kor:1}).limit(1);
{ "_id" : ObjectId("60c2c46e98e69dd9d8688086"), 
  "name" : "eee", "kor" : 60, "eng" : 80, "mat" : 78, "test" : "final" }
>
```
​
  
**Q14) 5개의 문서 중에서 2개를 건너띄고 3 줄만 출력 해라**
​
  
db.Score.find({}).limit(3).skip(2);
​
```
> db.Score.find({}).limit(3).skip(2);
{ "_id" : ObjectId("60c2c46e98e69dd9d8688084"), 
  "name" : "ccc", "kor" : 80, "eng" : 55, "mat" : 67, "test" : "midterm" }
{ "_id" : ObjectId("60c2c46e98e69dd9d8688085"), 
  "name" : "ddd", "kor" : 70, "eng" : 69, "mat" : 89, "test" : "midterm" }
{ "_id" : ObjectId("60c2c46e98e69dd9d8688086"), 
  "name" : "eee", "kor" : 60, "eng" : 80, "mat" : 78, "test" : "final" }
>
```
​
  
Q15) 5개의 문서 중에서 2개를 건너띄고 3줄만 출력해라, 단 수학점수를 내림차순으로 출력하자.
​
  
db.Score.find({}).limit(3).skip(2).sort({mat:-1});
​
```
> db.Score.find({}).limit(3).skip(2).sort({mat:-1});
{ "_id" : ObjectId("60c2c46e98e69dd9d8688087"), 
  "name" : "fff", "kor" : 100, "eng" : 69, "mat" : 89, "test" : "midterm" }
{ "_id" : ObjectId("60c2c46e98e69dd9d8688085"), 
  "name" : "ddd", "kor" : 70, "eng" : 69, "mat" : 89, "test" : "midterm" }
{ "_id" : ObjectId("60c2c46e98e69dd9d8688086"), 
  "name" : "eee", "kor" : 60, "eng" : 80, "mat" : 78, "test" : "final" }
>
```
​
### **SQL 과 MONGODB 비교 **
​
  
WHERE        $match  
GROUP BY    $group  
HAVING       $match  
SELECT        $project  
ORDER BY    $sort  
LIMIT          $limit  
SUM()         $sum  
COUNT()     $sum  $sortByCount  
join            $lookup  
SELECT INTO NEW\_TABLE    $out  
MERGE INTO TABLE           $merge (Available starting in MongoDB 4.2)  
UNION ALL                      $unionWith (Available starting in MongoDB 4.4)
​
###   
**몽고DB에서 집계처리하는 방법**
​
  
**1\. Aggregation 프레임워크**
​
  
   sql 사용하는 group by 절과 sum 등으로 이루어진다.  
   MongoShell에서 쿼리와 같은 방법으로 사용된다.  
일부처리 ($group 과 $sort)는 샤드에 대응하고, 각 샤드에서 처리한다.  
  
**2\. Map/Redece 기능**
​
  
   Map함수 Reduce 함수를 정의해서 집계 처리한다.  
   Aggregation 프레임워크에서 할 수 없는 복잡한 집계 작업을 수행 하는데 사용한다.  
   샤드에 대응하고 있기 때문에 분산 처리를 실시하는 것이 가능하다.  
  
**3\. 기타집계처리, 미들과의 연계 (하둡)**
​
  
   더 큰 규모로 집계 처리를 하기 때문에 다른 집계 처리 미들웨어 시스템과의 연계를 해야한다.  
   미들웨어(middleware) = 분산환경 \+ 네트워크 통신 \+ 응용프로그램과의 연계  
​
  
**Q16) 아래 데이터 입력후 확인.find()**  
  
db.Product.save({Name:"notebook", Price:200, Category : "material"});  
db.Product.save({Name:"pencil", Price:80, Category : "material"});  
db.Product.save({Name:"salad", Price:220, Category : "food"});  
db.Product.save({Name:"others", Price:20, Category : "material"});  
db.Product.save({Name:"bread", Price:100, Category : "food"});
​
```
> db.Product.find();
{ "_id" : ObjectId("60c3064598e69dd9d8688089"), "Name" : "notebook", "Price" : 200, "Category" : "material" }
{ "_id" : ObjectId("60c3064598e69dd9d868808a"), "Name" : "pencil", "Price" : 80, "Category" : "material" }
{ "_id" : ObjectId("60c3064598e69dd9d868808b"), "Name" : "salad", "Price" : 220, "Category" : "food" }
{ "_id" : ObjectId("60c3064598e69dd9d868808c"), "Name" : "others", "Price" : 20, "Category" : "material" }
{ "_id" : ObjectId("60c3064698e69dd9d868808d"), "Name" : "bread", "Price" : 100, "Category" : "food" }
```
​
  
**Q17) 맵리듀스를 활용해서 집계를 구현해 보자.**  
**컬렉션의 카테고리별로 (group by) 목록의 개수와 가격의 합을 구해보자.**  
  
  map : 특정 collection의 특정 key와 value를 map으로 하며, map의 key는 중복이 안되며 value는 list에 쌓이는 형태
​
  reduce : map의 데이터를 감소시키는 역할, 특정 값을 뽀ㅃ아내고 통계치 데이터로 사용
​
  
  <참고\>  
  db.Product.help()  
**  db.Product.mapReduce( mapFunction , reduceFunction , <optional params> )**
​
  
1\. mapFunction : emit를 매개인자로 집계할 key, value 값을 지정한다.
​
  
function **mymap** (){  
_emit_ (this.Category, {Category: this.Category, Count : 1, Amount : this.Price}  
)  
};
​
\# emit 추출하다. ( key, value) 
​
\# this.Category : key, Category 이하 : value
​
  
2\. reduceFunction : 집계를 구한다.
​
  
 function **myreduce** (key,values){  
     var **result** = {Category : key, Count:0, Amount:0}  
     values.forEach (function (v) {  
              **result.**Count += v.Count;  
              **result.**Amount += v.Amount;  
              });  
       return result;  
      };
​
\# function (변수, 변수) = myreduce( 변수, 변수)
​
  
3\. <optional params>  
db.Product.mapReduce(mymap, myreduce, {out:{replace:"myResult"}});  
db.myResult.find();  
  
​
```
> function mymap (){
... emit (this.Category, {Category: this.Category, Count : 1, Amount : this.Price}
... )
... };
​
​
>  function myreduce (key,values){
...      var result = {Category : key, Count:0, Amount:0}
...      values.forEach (function (v) {
...               result.Count += v.Count;
...               result.Amount += v.Amount;
...               });
...        return result;
...       };
​
​
> db.Product.mapReduce(mymap, myreduce, {out:{replace:"myResult"}});
{ "result" : "myResult", "ok" : 1 }
> db.myResult.find();
{ "_id" : "food", "value" : { "Category" : "food", "Count" : 2, "Amount" : 320 } }
{ "_id" : "material", "value" : { "Category" : "material", "Count" : 3, "Amount" : 300 } }
>
​
```
​
  
  
**Q18) Score 컬렉션에서 test를 그룹화해서 개수를 구하자. (mr) myResult02**  
  
  
1. 
​
_   function m\_map(){_
​
_     emit(this.test,{test:this.test, Count:1})_
​
_   };_
​
  
2. 
​
_   function m\_reduce(k,v){_
​
_        var r = {test : k, Count : 0}_
​
_        v.forEach(function(v){_
​
_        r.Count += v.Count;});_
​
_       return r};_  
  
3. 
​
  _ db.Score.mapReduce(m\_map, m\_reduce, {out: {replace:"myResult2"}});_
​
_   db.myResult2.find();_
​
  
**Q19) test 그룹화해서 국어점수 합계, 수학은 평균을 구하자. myResult03**  
  
  
1.
​
   function m\_map(){
​
        emit (this.test, {test:this.test, kor : this.kor, mat : this.mat, cnt:1})};  
  
2.  
   function m\_reduce(key, value) {  
       var result = {test: key, kor\_sum : 0, mat\_sum : 0 , cnt : 0}  
       value.forEach (function(v) {  
                                     result.kor\_sum += v.kor;  
                                     result.mat\_sum += v.mat;  
                                     result.cnt += v.cnt;})
​
       return result;  
       };  
  
   
​
   var m\_avg = function (key, m\_reduce) {
​
   m\_reduce.avg = m\_reduce.mat\_sum/m\_reduce.cnt;
​
   return m\_reduce ;};
​
3.  
   db.Score.mapReduce(m\_map, m\_reduce, {out:{replace:"myResult03"}, finalize:m\_avg});  
   db.myResult03.find();  
  
  
  
​
```
> function m_map(){
...
...         emit (this.test, {test:this.test, kor : this.kor, mat : this.mat, cnt:1})};
> function m_reduce(key, value) {
...        var result = {test: key, kor_sum : 0, mat_sum : 0 , cnt : 0}
...        value.forEach (function(v) {
...                                      result.kor_sum += v.kor;
...                                      result.mat_sum += v.mat;
...                                      result.cnt += v.cnt;})
...
...        return result;
...        };
> var m_avg = function (key, m_reduce) {
...
...    m_reduce.avg = m_reduce.mat_sum/m_reduce.cnt;
...
...    return m_reduce ;};
> db.Score.mapReduce(m_map, m_reduce, {out:{replace:"myResult03"}, finalize:m_avg});
{ "result" : "myResult03", "ok" : 1 }
>    db.myResult03.find();
{ "_id" : "final", "value" : { "test" : "final", "kor_sum" : 235, "mat_sum" : 254, "cnt" : 3, "avg" : 84.66666666666667 } }
{ "_id" : "midterm", "value" : { "test" : "midterm", "kor_sum" : 340, "mat_sum" : 343, "cnt" : 4, "avg" : 85.75 } }
```
