**Q1) Product 전체 내용을 출력해보자. 단 \_id는 빼고출력하자.**

  
 db.Product.find({},{\_id:0});

```
> db.Product.find({},{_id:0});
{ "Name" : "notebook", "Price" : 200, "Category" : "material" }
{ "Name" : "pencil", "Price" : 80, "Category" : "material" }
{ "Name" : "salad", "Price" : 220, "Category" : "food" }
{ "Name" : "others", "Price" : 20, "Category" : "material" }
{ "Name" : "bread", "Price" : 100, "Category" : "food" }
>
```

  
**Q2) ID와 가격을 출력해보자.**

 : aggregate 는 pipeline을 가지면서 각 단계별로 진행을 마친 후 result 를 반환한다. 

_  순서 → collection > $project > $match > $group > $sort__\> $skip__\> $limit > $unwind__\> $out_

 : $project : find와 같다  

(1)

db.Product.aggregate(\[{  
                              $project:{\_id:1,Price:1}  
                              }\]);

```
> db.Product.aggregate([{$project:{_id:1,Price:1}}]);

{ "_id" : ObjectId("60c3064598e69dd9d8688089"), "Price" : 200 }
{ "_id" : ObjectId("60c3064598e69dd9d868808a"), "Price" : 80 }
{ "_id" : ObjectId("60c3064598e69dd9d868808b"), "Price" : 220 }
{ "_id" : ObjectId("60c3064598e69dd9d868808c"), "Price" : 20 }
{ "_id" : ObjectId("60c3064698e69dd9d868808d"), "Price" : 100 }
>
```

(2)  
db.Product.aggregate(\[{  
                             $project:{Price:1}  
                             }\]);

```
> db.Product.aggregate([{$project:{Price:1}}]);

{ "_id" : ObjectId("60c3064598e69dd9d8688089"), "Price" : 200 }
{ "_id" : ObjectId("60c3064598e69dd9d868808a"), "Price" : 80 }
{ "_id" : ObjectId("60c3064598e69dd9d868808b"), "Price" : 220 }
{ "_id" : ObjectId("60c3064598e69dd9d868808c"), "Price" : 20 }
{ "_id" : ObjectId("60c3064698e69dd9d868808d"), "Price" : 100 }
>
```

  
db.Product.aggregate(\[{  
                             $project:{\_id:0, Price:1}  
                             }\]);

```
> db.Product.aggregate([{$project:{_id:0, Price:1}}]);
{ "Price" : 200 }
{ "Price" : 80 }
{ "Price" : 220 }
{ "Price" : 20 }
{ "Price" : 100 }
```

  
**Q3) 이름과 가격만 출력하자.**

db.Product.aggregate(\[{  
                            $project:{Name:1,Price:1,\_id:0}  
                            }\]);

```
> db.Product.aggregate([{$project:{Name:1, Price:1,_id:0}}]);

{ "Name" : "notebook", "Price" : 200 }
{ "Name" : "pencil", "Price" : 80 }
{ "Name" : "salad", "Price" : 220 }
{ "Name" : "others", "Price" : 20 }
{ "Name" : "bread", "Price" : 100 }
```

  
**Q4) 가격과 카테고리만 출력하자. 단 가격별 오름차순으로 정렬해보자.**  
$sort: 1 은 유/무가 아닌 오름차 순 정렬  
  
db.Product.aggregate(\[  
                            {$project:{Name:1,Price:1,\_id:0}},  
                            {$sort:{Price:1}}  
                            \]);

```
> db.Product.aggregate([{$project:{Name:1, Price:1, _id:0}},{$sort:{Price:1}}]);

{ "Name" : "others", "Price" : 20 }
{ "Name" : "pencil", "Price" : 80 }
{ "Name" : "bread", "Price" : 100 }
{ "Name" : "notebook", "Price" : 200 }
{ "Name" : "salad", "Price" : 220 }
>
```

  
**Q5) 이름(목록)과 가격만 출력하되 목록을 내림차 순으로 정렬해보자.**  
  
db.Product.aggregate(\[  
                            {$project:{Name:1,Price:1,\_id:0}},  
                            {$sort:{Name:-1}}  
                             \]);

```
> db.Product.aggregate([{$project:{Name:1, Price:1, _id:0}},{$sort:{Price:-1}}]);

{ "Name" : "salad", "Price" : 220 }
{ "Name" : "notebook", "Price" : 200 }
{ "Name" : "bread", "Price" : 100 }
{ "Name" : "pencil", "Price" : 80 }
{ "Name" : "others", "Price" : 20 }
```

  
  
**Q6) $project로 가서 별칭을 주는것을 확인 한 후 아래와 같이 이름(목록)만 출력해보자.**

    : $ 를 주면 별칭이 된다.

  
db.Product.aggregate(\[  
                            {$project: {\_id:0, alias\_name : "$Name" }}  
                            \]);  
  

```
> db.Product.aggregate([{$project:{_id:0, alias_name:"$Name"}}]);

{ "alias_name" : "notebook" }
{ "alias_name" : "pencil" }
{ "alias_name" : "salad" }
{ "alias_name" : "others" }
{ "alias_name" : "bread" }
>
```

  
**Q7) Name을 목록, Price 가격, Category는 타입으로 별칭을 주자.**

  
db.Product.aggregate(\[  
                            {$project: {\_id:0, 목록:"$Name", 가격:"$Price", 타입 : "$Category" }}  
                            \]);

```
> db.Product.aggregate([{$project:{_id:0, 목록:"$Name", 가격:"$Price", 타입:"$Category"}}]);

{ "목록" : "notebook", "가격" : 200, "타입" : "material" }
{ "목록" : "pencil", "가격" : 80, "타입" : "material" }
{ "목록" : "salad", "가격" : 220, "타입" : "food" }
{ "목록" : "others", "가격" : 20, "타입" : "material" }
{ "목록" : "bread", "가격" : 100, "타입" : "food" }
```

  
**Q8) 상품의 목록을 출력하고 inc\_price라는 별칭을 주고 가격에 100을 더한 값을 출력해보자.**

    :   total(별칭): { $add: \[ "$price(1)", "$fee(2)" \] } = (1) + (2) 값 출력

  
db.Product.aggregate(\[  
                            {$project: {\_id:0, Name:1,  
                            inc\_price: {$add:\["$Price", 100 \]}}}\]);

```
> db.Product.aggregate([{$project:{_id:0, Name:1, inc_price:{$add:["$Price",100]}}}]);

{ "Name" : "notebook", "inc_price" : 300 }
{ "Name" : "pencil", "inc_price" : 180 }
{ "Name" : "salad", "inc_price" : 320 }
{ "Name" : "others", "inc_price" : 120 }
{ "Name" : "bread", "inc_price" : 200 }
>
```

  
**Q9) $max, $group**  
**     카테고리로 그룹화를 한다음 최대 가격을 출력해보자.**  
   : \_id가 고유 값 이기 때문에, \_id를 기준으로 입력 문서를 그룹화 한 후, 개별 그룹에 대해 문서를 출력한다.

  
db.Product.aggregate(\[  
                            {$group: {\_id:"$Category", max\_price : {$max: "$Price" }}}  
                             \]);  
  

```
> db.Product.aggregate([{$group:{_id:"$Category", max_price:{$max:"$Price"}}}]);

{ "_id" : "material", "max_price" : 200 }
{ "_id" : "food", "max_price" : 220 }
```

  
**Q10) $min, $group**  
**       카테고리로 그룹화를 한다음 최소 가격을 출력해보자.**

db.Product.aggregate(\[  
                            {$group: {\_id:"$Category", min\_price : {$min: "$Price" }}}  
                             \]);

```
> db.Product.aggregate([{$group:{_id:"$Category", min_price:{$min:"$Price"}}}]);

{ "_id" : "material", "min_price" : 20 }
{ "_id" : "food", "min_price" : 100 }
>
```

  
**Q11) 상품목록을 출력하고 가격의 합과 가격의 평균 및 목록의 갯수를 구한다.**

  : $sum 은 갯수를 count 하거나 value 를 더해준다.

  
db.Product.aggregate(\[  
                             $group: {\_id:"$Category", sum :{$sum: "$Price"},  
                             avg:{$avg:"$Price"},  
                             count:{$sum:1}}}  
                             \]);

```
> db.Product.aggregate([{$group:{_id:"$Category", sum:{$sum:"$Price"}, 
                         avg:{$avg:"$Price"}, count:{$sum:1}}}]);
                         
{ "_id" : "material", "sum" : 300, "avg" : 100, "count" : 3 }
{ "_id" : "food", "sum" : 320, "avg" : 160, "count" : 2 }
```

  
**Q12) 상품 목록을 출력하고 그룹화 한 다음 갯수를 구해보자.**

(1)  
db.Product.aggregate(\[  
                            {$group: {\_id:"$Category", count:{$sum:1}}}  
                             \]);

```
> db.Product.aggregate([{$group:{_id:"$Category", count:{$sum:1}}}]);

{ "_id" : "material", "count" : 3 }
{ "_id" : "food", "count" : 2 }
>
```

  
(2) 

  :  $literal : 구문 분석하지 않고 값을 반환 , 즉 그대로 이름이 지정된 필드 값 반환 

    $literal : $1 은 $1 그대로 반환한다.

  
db.Product.aggregate(\[  
{$project: {"Category":1, count:{$literal:1}}},  
{$group : {\_id: "$Category" , count:{$sum:"$count"}}}  
\]);

```
> db.Product.aggregate([{$project:{"Category":1, count:{$literal:1}}}, // conut = 1
                       {$group:{_id:"$Category", count:{$sum:"$count"}}}]);
                       
{ "_id" : "material", "count" : 3 }
{ "_id" : "food", "count" : 2 }

```

  
**Q13) Name에서 bread를 찾아서 출력하자.**

 : $match : 문서를 필터링하여 지정된 조건과 일치하는 문서만 다음 파이프 라인 단계로 전달

  
db.Product.aggregate(\[  
                            {$project:{\_id:0, Name:1}}, {$match:{Name:"bread"}}  
                             \]);

```
> db.Product.aggregate([{$project:{_id:0, Name:1}},{$match:{Name:"bread"}}]);

{ "Name" : "bread" }
>
```

  
**Q14) Category에서 food만 출력해보자.**

  
db.Product.aggregate(\[  
                             {$match:{Category:"food"}}  
                              \]);

```
> db.Product.aggregate([{$match:{Category:"food"}}]);
{ "_id" : ObjectId("60c3064598e69dd9d868808b"), "Name" : "salad", "Price" : 220, "Category" : "food" }
{ "_id" : ObjectId("60c3064698e69dd9d868808d"), "Name" : "bread", "Price" : 100, "Category" : "food" }
>
```

```
> db.Product.aggregate([{$project:{_id:0}},{$match:{Category:"food"}}]);
{ "Name" : "salad", "Price" : 220, "Category" : "food" }
{ "Name" : "bread", "Price" : 100, "Category" : "food" }
>
```

  
** Q15) Category에서 food 가격의 최대, 최소, 합, 평균 갯수를 출력해보자.**

  
db.Product.aggregate(\[  
                             {$match:{Category:"food"}},  
                             {$group: {\_id:"$Category",  
                                         max:{$max:"$Price"},  
                                         min:{$min:"$Price"},  
                                         sum :{$sum: "$Price"},  
                                         avg:{$avg:"$Price"},  
                                         count:{$sum:1}}}  
  
                               \]);

```
> db.Product.aggregate([
...                              {$match:{Category:"food"}},
...                              {$group: {_id:"$Category",
...                                          max:{$max:"$Price"},
...                                          min:{$min:"$Price"},
...                                          sum :{$sum: "$Price"},
...                                          avg:{$avg:"$Price"},
...                                          count:{$sum:1}}}
...
...                                ]);
{ "_id" : "food", "max" : 220, "min" : 100, "sum" : 320, "avg" : 160, "count" : 2 }
>
```

  
db.Product.aggregate(\[  
             {$group : {\_id:"$Category",  
                  max : {$max:"$Price"},  
                  min : {$min:"$Price"},  
                  sum : {$sum: "$Price"},  
                  avg : {$avg:"$Price"},  
                  count : {$sum:1}}},  
                 {$match:{\_id:"food"}}  
                 \]);

```
> db.Product.aggregate([
...              {$group : {_id:"$Category",
...                   max : {$max:"$Price"},
...                   min : {$min:"$Price"},
...                   sum : {$sum: "$Price"},
...                   avg : {$avg:"$Price"},
...                   count : {$sum:1}}},
...                  {$match:{_id:"food"}}
...                  ]);
{ "_id" : "food", "max" : 220, "min" : 100, "sum" : 320, "avg" : 160, "count" : 2 }
```

  
**Q16) 15번을 맵리듀스로 작성 해보자.**

function **map**(){  
             _emit_ (this.Category,{**sum**:this.Price, **min**:this.Price, **max**:this.Price, **count**:1});  
                  }

  
function **reduce**(key, values){  
                 var result = {Category : key, sum:0, min:10000, max:0, count:0}  
                 values.forEach(function(v){  
                 result.count += v.count;  
                 result.sum += v.sum;  
                 result.min = Math.min(v.min, result.min);  
                 result.max = Math.max(v.max, result.max);  
                 });  
return result;  
}

db.Product.mapReduce(map, reduce, {out:{replace : "myResult02"}});  
db.myResult02.find();

```
> function map(){
...              emit (this.Category,{sum:this.Price, min:this.Price, max:this.Price, count:1});
...                   }
> function reduce(key, values){
...                  var result = {Category : key, sum:0, min:10000, max:0, count:0}
...                  values.forEach(function(v){
...                  result.count += v.count;
...                  result.sum += v.sum;
...                  result.min = Math.min(v.min, result.min);
...                  result.max = Math.max(v.max, result.max);
...                  });
... return result;
... }
> db.Product.mapReduce(map, reduce, {out:{replace : "myResult02"}});
{ "result" : "myResult02", "ok" : 1 }

> db.myResult02.find();
{ "_id" : "material", "value" : { "Category" : "material", "sum" : 300, "min" : 20, "max" : 200, "count" : 3 } }
{ "_id" : "food", "value" : { "Category" : "food", "sum" : 320, "min" : 100, "max" : 220, "count" : 2 } }
>
```

### ** Indexes**

 : 특정 필드 또는 필드 세트값에 따라 정렬하여 저장, 인덱스의 순서를 사용하여 정렬된 결과 반환

db.Product.getIndexes();  
db.Product.aggregate(\[ {$project:{\_id:0, Name:1}}, {$match: {Name:"bread"}}\]);  
db.Product.getIndexes();

```
> db.Product.getIndexes();
[ { "v" : 2, "key" : { "_id" : 1 }, "name" : "_id_" } ]
> db.Product.aggregate([{$project:{_id:0, Name:1}}, {$match:{Name:"bread"}}]);
{ "Name" : "bread" }
> db.Product.getIndexes();
[ { "v" : 2, "key" : { "_id" : 1 }, "name" : "_id_" } ]
>
```

  
**1) 인덱스를 추가설정**

  
db.Product.ensureIndex ({Name : 1});

```
> db.Product.ensureIndex({Name:1});
{
        "createdCollectionAutomatically" : false,
        "numIndexesBefore" : 1,
        "numIndexesAfter" : 2,
        "ok" : 1
}
>
```

  
**2) 추가된 인덱스 필드의 값을 찾아서 실행 결과를 확인**  

db.Product.find({Name:"bread"}).explain();

```
> db.Product.find({Name:"bread"}).explain();
{
        "queryPlanner" : {
                "plannerVersion" : 1,
                "namespace" : "my_score.Product",
                "indexFilterSet" : false,
                "parsedQuery" : {
                        "Name" : {
                                "$eq" : "bread"
                        }
                },
                "queryHash" : "EBFEE4C5",
                "planCacheKey" : "6D446D9E",
                "winningPlan" : {
                        "stage" : "FETCH",
                        "inputStage" : {
                                "stage" : "IXSCAN",
                                "keyPattern" : {
                                        "Name" : 1
                                },
                                "indexName" : "Name_1",
                                "isMultiKey" : false,
                                "multiKeyPaths" : {
                                        "Name" : [ ]
                                },
                                "isUnique" : false,
                                "isSparse" : false,
                                "isPartial" : false,
                                "indexVersion" : 2,
                                "direction" : "forward",
                                "indexBounds" : {
                                        "Name" : [
                                                "[\"bread\", \"bread\"]"
                                        ]
                                }
                        }
                },
                "rejectedPlans" : [ ]
        },
        "serverInfo" : {
                "host" : "hyeripark",
                "port" : 27017,
                "version" : "4.4.6",
                "gitVersion" : "72e66213c2c3eab37d9358d5e78ad7f5c1d0d0d7"
        },
        "ok" : 1
}
>
```

  
**3) 인덱스 삭제**

  
db.Product.dropIndex ({Name : 1});  
db.Product.getIndexes();

```
> db.Product.dropIndex({Name:1});
{ "nIndexesWas" : 2, "ok" : 1 }
> db.Product.getIndexes();
[ { "v" : 2, "key" : { "_id" : 1 }, "name" : "_id_" } ]
```

  
**4)  이름 순으로 정렬**

  
db.Product.find().sort({Name : 1});

```
> db.Product.find().sort({Name:1});
{ "_id" : ObjectId("60c3064698e69dd9d868808d"), "Name" : "bread", "Price" : 100, "Category" : "food" }
{ "_id" : ObjectId("60c3064598e69dd9d8688089"), "Name" : "notebook", "Price" : 200, "Category" : "material" }
{ "_id" : ObjectId("60c3064598e69dd9d868808c"), "Name" : "others", "Price" : 20, "Category" : "material" }
{ "_id" : ObjectId("60c3064598e69dd9d868808a"), "Name" : "pencil", "Price" : 80, "Category" : "material" }
{ "_id" : ObjectId("60c3064598e69dd9d868808b"), "Name" : "salad", "Price" : 220, "Category" : "food" }
```

  
**5) bread 찾아서 실행 결과를 확인**

  
db.Product.find({Name:"bread"}).explain();

```
> db.Product.find({Name:"bread"}).explain();
{
        "queryPlanner" : {
                "plannerVersion" : 1,
                "namespace" : "my_score.Product",
                "indexFilterSet" : false,
                "parsedQuery" : {
                        "Name" : {
                                "$eq" : "bread"
                        }
                },
                "queryHash" : "EBFEE4C5",
                "planCacheKey" : "EBFEE4C5",
                "winningPlan" : {
                        "stage" : "COLLSCAN",
                        "filter" : {
                                "Name" : {
                                        "$eq" : "bread"
                                }
                        },
                        "direction" : "forward"
                },
                "rejectedPlans" : [ ]
        },
        "serverInfo" : {
                "host" : "hyeripark",
                "port" : 27017,
                "version" : "4.4.6",
                "gitVersion" : "72e66213c2c3eab37d9358d5e78ad7f5c1d0d0d7"
        },
        "ok" : 1
}
>
```

###   
  
  
**MongoDB 지리 인덱스 쿼리 구성**

  
**✔ 지리공간 데이터를 저장하는 방법**  

  **1\. 좌표** : 종래의 좌표를 나타내는 데이터, 주로 평면상의 점을 사용, 표현할 수 있는 도형의 점  
             {loc :\[10,20\]} 점만 사용  
  
**   2. GeoJSON** : 새로운 다양한 형태를 표현할 수 있는 데이터, 주로 지구 표면에 위도, 경도를 다루는데 사용된다.  
             {loc : {type : "Point", coordinates:\[10,20\]}}  
  

**✔ 쿼리 유형 세가지 : Geospatial Query Operators**

   **1\. 내포된 쿼리 ($geoWithin)** : 다각형 좌표, 사각좌표, 원형 좌표  
                                          (지구 표면의 원형으로 검색된 쿼리 (2d/ 2dsphere) 모두 사용)  
   **2\. 겹침 쿼리 ($geoIntersects)** : (2dsphere 사용), 점, 선, 다각형  
   **3\. 근거리 ($near) :**  (2d/ 2dsphere) 사용,  점과의 거리, 좌표와 점과의 거리  

  
**✔ 검색조건 **

  
1\. GeoJSON : 점, $geometry : (type : "Point", coordinates: \[ 40, 5 \])  
   GeoJSON : 직선 $geometry : (type : "LineString",coordinates: \[ \[ 40, 5 \], \[ 41, 6 \] \])  
   GeoJSON : 다각형 $geometry : (type : "Polygon", coordinates: \[ \[ \[ 0 , 0 \] , \[ 3 , 6 \] , \[ 6 , 1 \] , \[ 0 , 0 \] \])  
   GeoJSON : GeoJSON 집합 , $geometry:(type : "GeometryCollection", )

  
2.  좌표 : 점 \[x1, y1\]  
좌표 : 사각형 $box : \[\[ <bottom left coordinates> \], \[ <upper right coordinates> \]\]  
좌표 : 다각형 , $polygon : \[ \[ <x1> , <y1> \], \[ <x2> , <y2> \], \[ <x3> , <y3> \], ... \]  
좌표 : 원형 , $center : \[ \[ <x>, <y> \] , <radius> \]  
좌표 : 지구 표면의 원형, $centerSphere : \[ \[ <x>, <y> \], <radius> \]  
  

**\# Collection 생성 후 좌표 저장하자.**

  
db.createCollection("location");  
db.location.save({\_id:"A", position : \[0.001, -0.002\]});  
db.location.save({\_id:"B", position : \[1.0, 1.0\]});  
db.location.save({\_id:"C", position : \[0.5, 0.5\]});  
db.location.save({\_id:"D", position : \[-0.5, -0.5\]});

```
> db.createCollection("location");
{ "ok" : 1 }

> db.location.save({_id:"A", position : [0.001, -0.002]});
WriteResult({ "nMatched" : 0, "nUpserted" : 1, "nModified" : 0, "_id" : "A" })
> db.location.save({_id:"B", position : [1.0, 1.0]});
WriteResult({ "nMatched" : 0, "nUpserted" : 1, "nModified" : 0, "_id" : "B" })
> db.location.save({_id:"C", position : [0.5, 0.5]});
WriteResult({ "nMatched" : 0, "nUpserted" : 1, "nModified" : 0, "_id" : "C" })
> db.location.save({_id:"D", position : [-0.5, -0.5]});
WriteResult({ "nMatched" : 0, "nUpserted" : 1, "nModified" : 0, "_id" : "D" })

> db.location.find()
{ "_id" : "A", "position" : [ 0.001, -0.002 ] }
{ "_id" : "B", "position" : [ 1, 1 ] }
{ "_id" : "C", "position" : [ 0.5, 0.5 ] }
{ "_id" : "D", "position" : [ -0.5, -0.5 ] }
```

2dinedex 

 : 2차원 평면에 점으로 저장된 데이터에 인덱스를 사용

  
db.location.ensureIndex({position:"2d"});  
db.location.getIndexes();

```
> db.location.ensureIndex({position:"2d"});
{
        "createdCollectionAutomatically" : false,
        "numIndexesBefore" : 1,
        "numIndexesAfter" : 2,
        "ok" : 1
}
> db.location.getIndexes();
[
        {
                "v" : 2,
                "key" : {
                        "_id" : 1
                },
                "name" : "_id_"
        },
        {
                "v" : 2,
                "key" : {
                        "position" : "2d"
                },
                "name" : "position_2d"
        }
]
```

  
\# db.location.find({position : {$within:{$box: \[\[0.25,0.25\],\[1.0,1.0\]\]}}});

```
db.location.find({position : {$within:{$box: [[0.25,0.25],[1.0,1.0]]}}});
{ "_id" : "C", "position" : [ 0.5, 0.5 ] }
{ "_id" : "B", "position" : [ 1, 1 ] }
```

**Q17) 현재 나의 위치가 0.0 주변의 약국을 동그라미로 찾았더니 A,B,C,D 위치가 리턴되더라.**

**# $center :** **크기제한없음**

  
db.location.find({position : {$within:{$center:\[\[0,0\],1.42\]}}});

```
> db.location.find({position : {$within:{$center:[[0,0],1.42]}}});
{ "_id" : "D", "position" : [ -0.5, -0.5 ] }
{ "_id" : "A", "position" : [ 0.001, -0.002 ] }
{ "_id" : "C", "position" : [ 0.5, 0.5 ] }
{ "_id" : "B", "position" : [ 1, 1 ] }
>
```

  
**Q18) 현재 나의 위치가 0.0에서 0.75 사이 거리의약국을 찾고싶다.**

**# $maxDistance :** **크기제한있음**

  
db.location.find({position :{$near :\[0,0\], $maxDistance:0.75}});

```
> db.location.find({position :{$near :[0,0], $maxDistance:0.75}});
{ "_id" : "A", "position" : [ 0.001, -0.002 ] }
{ "_id" : "D", "position" : [ -0.5, -0.5 ] }
{ "_id" : "C", "position" : [ 0.5, 0.5 ] }
>

```
