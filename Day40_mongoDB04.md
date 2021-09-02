## **지형인덱스**

**2d :** 좌표(x, y)를 가지고 평면 계산 \= 하나의 인덱스  
**2dsphere** : 지구와 같은 구 형태의 지형 기반 계산 , 좌표 쌍 또는 GeoJson (위치와 상관없이 인덱스, 복합 인덱스) 보유  

**\# geotest 사용해서 임의 좌표를 주자.**

  
use geotest  
  
var baseLng = 127.01145;  
var baseLat = 37.49101;  
  
var diffLng = 126.9988212;  
var diffLat = 37.4952724;  
  
  
var categories = \['커피', '은행', '편의점'\];  
  
for (var i = 1; i<=100; i++){  
         var myLng = baseLng + (Math.random() \* diffLng);   
         var myLat = baseLat + (Math.random() \* diffLat);  
         var myCategories = categories \[Math.floor(Math.random() \* categories.length)\];  
         db.places.save({location : \[myLng, myLat\],  
         category : myCategories});  
          }

```
> use geotest
switched to db geotest


> var baseLng = 127.01145;
> var baseLat = 37.49101;
> var diffLng = 126.9988212;
> var diffLat = 37.4952724;
> var categories = ['커피', '은행', '편의점'];
>

> for (var i = 1; i<=100; i++){
...          var myLng = baseLng + (Math.random() * diffLng); // 어디에서 어디까지 랜덤의 갯수
...          var myLat = baseLat + (Math.random() * diffLat);
...          var myCategories = categories [Math.floor(Math.random() * categories.length)]; // floor 내림
...          db.places.save({location : [myLng, myLat],
...          category : myCategories});
...           }
WriteResult({ "nInserted" : 1 })

> db.places.find()
{ "_id" : ObjectId("60c8afd66285787dbd798d2a"), "location" : [ 162.86695940959004, 56.88332669836795 ], "category" : "커피" }
{ "_id" : ObjectId("60c8afd66285787dbd798d2b"), "location" : [ 224.95730987796728, 50.14007013218702 ], "category" : "편의점" }
{ "_id" : ObjectId("60c8afd66285787dbd798d2c"), "location" : [ 154.99304567347235, 46.092820840061975 ], "category" : "은행" }
{ "_id" : ObjectId("60c8afd66285787dbd798d2d"), "location" : [ 133.41728381718875, 39.48196192554386 ], "category" : "편의점" }
{ "_id" : ObjectId("60c8afd66285787dbd798d2e"), "location" : [ 147.36829466332017, 64.77647649105594 ], "category" : "편의점" }
{ "_id" : ObjectId("60c8afd66285787dbd798d2f"), "location" : [ 249.53011952331192, 68.799039901291 ], "category" : "편의점" }
{ "_id" : ObjectId("60c8afd66285787dbd798d30"), "location" : [ 171.16699622025513, 47.519560575489386 ], "category" : "커피" }
{ "_id" : ObjectId("60c8afd66285787dbd798d31"), "location" : [ 177.702425103313, 50.602822340148066 ], "category" : "커피" }
{ "_id" : ObjectId("60c8afd66285787dbd798d32"), "location" : [ 253.022687756172, 69.65028940219193 ], "category" : "은행" }
{ "_id" : ObjectId("60c8afd66285787dbd798d33"), "location" : [ 183.3715069518895, 56.11079929641739 ], "category" : "커피" }
{ "_id" : ObjectId("60c8afd66285787dbd798d34"), "location" : [ 155.42183830924023, 63.28284519280565 ], "category" : "커피" }
{ "_id" : ObjectId("60c8afd66285787dbd798d35"), "location" : [ 228.502043581323, 73.40455187178347 ], "category" : "은행" }
{ "_id" : ObjectId("60c8afd66285787dbd798d36"), "location" : [ 208.8060104437858, 39.997311062603664 ], "category" : "은행" }
{ "_id" : ObjectId("60c8afd66285787dbd798d37"), "location" : [ 215.74799328283666, 47.0237427334247 ], "category" : "편의점" }
{ "_id" : ObjectId("60c8afd66285787dbd798d38"), "location" : [ 188.47307601407618, 42.64955932997145 ], "category" : "은행" }
{ "_id" : ObjectId("60c8afd66285787dbd798d39"), "location" : [ 127.08781707481076, 62.86039226433685 ], "category" : "편의점" }
{ "_id" : ObjectId("60c8afd66285787dbd798d3a"), "location" : [ 138.74752218255395, 39.521715761892374 ], "category" : "은행" }
{ "_id" : ObjectId("60c8afd66285787dbd798d3b"), "location" : [ 248.9392793442475, 57.92964915626163 ], "category" : "커피" }
{ "_id" : ObjectId("60c8afd66285787dbd798d3c"), "location" : [ 223.25129149313733, 40.12901927852836 ], "category" : "커피" }
{ "_id" : ObjectId("60c8afd66285787dbd798d3d"), "location" : [ 230.9556464489218, 74.22250949865939 ], "category" : "편의점" }
Type "it" for more

> db.places.find().count()
100
>
```

  
**Q1) 인덱스를 작성한다.**

     : ensureIndex → 인덱스를 추가 하겠다.

  
db.places.getIndexes() - 확인  
db.places.ensureIndex({location:"2d", category:1});

db.places.getIndexes() - 재 확인

```
> db.places.getIndexes()
[ { "v" : 2, "key" : { "_id" : 1 }, "name" : "_id_" } ]

> db.places.ensureIndex({location:"2d", category:1});
{
        "ok" : 0,
        "errmsg" : "Index build failed: 0b4b7c90-f3e5-4954-a371-6e7dbaed69b7: Collection geotest.places ( af916243-e677-49b8-a5c3-19b121766d1c ) :: caused by :: point not in interval of [ -180, 180 ] :: caused by :: { _id: ObjectId('60c8afd66285787dbd798d2b'), location: [ 224.9573098779673, 50.14007013218702 ], category: \"편의점\" }",
        "code" : 13027,
        "codeName" : "Location13027"
}
```

 **오류 발생 : 에러 메세지 확인하기**

```
"errmsg" : "Index build failed: 0b4b7c90-f3e5-4954-a371-6e7dbaed69b7: 
Collection geotest.places ( af916243-e677-49b8-a5c3-19b121766d1c ) :: 
caused by :: point not in interval of [ -180, 180 ] :: caused by :: 
{ _id: ObjectId('60c8afd66285787dbd798d2b'), 
location: [ 224.9573098779673, 50.14007013218702 ], category: \"편의점\" }"

// 오류메세지 :[-180, 180] 간격이 아닌 지점에 의해 발생
```

  
  
**Q2) \[-180, 180\] 범위를 벗어나는 문서를 삭제 후 다시 추가하자.**

 **2-1) 먼저 \[-180, 180\] 범위를 벗어나는 문서를 찾아보자.**

       : -180은 범위 속하지 않으므로 180 이상의 문서를 찾자 

  db.places.find({"location" : {$gte :180}});

```
> db.places.find({"location":{$gte:180}});
{ "_id" : ObjectId("60c8afd66285787dbd798d2b"), "location" : [ 224.95730987796728, 50.14007013218702 ], "category" : "편의점" }
{ "_id" : ObjectId("60c8afd66285787dbd798d2f"), "location" : [ 249.53011952331192, 68.799039901291 ], "category" : "편의점" }
{ "_id" : ObjectId("60c8afd66285787dbd798d32"), "location" : [ 253.022687756172, 69.65028940219193 ], "category" : "은행" }
{ "_id" : ObjectId("60c8afd66285787dbd798d33"), "location" : [ 183.3715069518895, 56.11079929641739 ], "category" : "커피" }
{ "_id" : ObjectId("60c8afd66285787dbd798d35"), "location" : [ 228.502043581323, 73.40455187178347 ], "category" : "은행" }
{ "_id" : ObjectId("60c8afd66285787dbd798d36"), "location" : [ 208.8060104437858, 39.997311062603664 ], "category" : "은행" }
{ "_id" : ObjectId("60c8afd66285787dbd798d37"), "location" : [ 215.74799328283666, 47.0237427334247 ], "category" : "편의점" }
{ "_id" : ObjectId("60c8afd66285787dbd798d38"), "location" : [ 188.47307601407618, 42.64955932997145 ], "category" : "은행" }
{ "_id" : ObjectId("60c8afd66285787dbd798d3b"), "location" : [ 248.9392793442475, 57.92964915626163 ], "category" : "커피" }
{ "_id" : ObjectId("60c8afd66285787dbd798d3c"), "location" : [ 223.25129149313733, 40.12901927852836 ], "category" : "커피" }
{ "_id" : ObjectId("60c8afd66285787dbd798d3d"), "location" : [ 230.9556464489218, 74.22250949865939 ], "category" : "편의점" }
{ "_id" : ObjectId("60c8afd66285787dbd798d3e"), "location" : [ 201.31001106076957, 62.64627922889267 ], "category" : "은행" }
{ "_id" : ObjectId("60c8afd66285787dbd798d3f"), "location" : [ 200.28746887184855, 41.485781495037095 ], "category" : "은행" }
{ "_id" : ObjectId("60c8afd66285787dbd798d42"), "location" : [ 213.75302078696893, 60.965789843929976 ], "category" : "커피" }
{ "_id" : ObjectId("60c8afd66285787dbd798d43"), "location" : [ 248.96038742526517, 67.8144240118457 ], "category" : "은행" }
{ "_id" : ObjectId("60c8afd66285787dbd798d44"), "location" : [ 252.21814751172406, 65.77911997580836 ], "category" : "커피" }
{ "_id" : ObjectId("60c8afd66285787dbd798d45"), "location" : [ 197.326230902021, 59.94267224062471 ], "category" : "편의점" }
{ "_id" : ObjectId("60c8afd66285787dbd798d46"), "location" : [ 191.93284717349925, 61.63068462733777 ], "category" : "커피" }
{ "_id" : ObjectId("60c8afd66285787dbd798d48"), "location" : [ 241.01669140204277, 70.78142546115458 ], "category" : "편의점" }
{ "_id" : ObjectId("60c8afd66285787dbd798d49"), "location" : [ 250.76182334592858, 72.0978405005371 ], "category" : "은행" }
Type "it" for more

> db.places.find({"location":{$gte:180}}).count();
61
```

 **2-2) \[180\]범위를 벗어나는 문서를 삭제하자.**

  
  db.places.deleteMany({"location": {$gte: 180}});

```
> db.places.deleteMany({"location":{$gte:180}});
{ "acknowledged" : true, "deletedCount" : 61 }
```

 **2-3) 다시 인덱스를 추가 후 확인 하자.**

  
db.places.ensureIndex({location:"2d", category:1});  
db.places.getIndexes();

```
> db.places.ensureIndex({location:"2d", category:1});
{
        "createdCollectionAutomatically" : false,
        "numIndexesBefore" : 1,
        "numIndexesAfter" : 2,
        "ok" : 1
}
> db.places.getIndexes();
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
                        "location" : "2d", 
                        "category" : 1
                },
                "name" : "location_2d_category_1"
        }
]
```

  
**Q3) 편의점을 찾아보자.**

db.places.find({category:'편의점'});  
db.places.find({category:'편의점'}).count();  
  

```
> db.places.find({category:'편의점'});
{ "_id" : ObjectId("60c8afd66285787dbd798d2d"), "location" : [ 133.41728381718875, 39.48196192554386 ], "category" : "편의점" }
{ "_id" : ObjectId("60c8afd66285787dbd798d2e"), "location" : [ 147.36829466332017, 64.77647649105594 ], "category" : "편의점" }
{ "_id" : ObjectId("60c8afd66285787dbd798d39"), "location" : [ 127.08781707481076, 62.86039226433685 ], "category" : "편의점" }
{ "_id" : ObjectId("60c8afd66285787dbd798d47"), "location" : [ 133.3290570143667, 52.094232466716754 ], "category" : "편의점" }
{ "_id" : ObjectId("60c8afd66285787dbd798d4c"), "location" : [ 131.54279095142155, 63.29511107666771 ], "category" : "편의점" }
{ "_id" : ObjectId("60c8afd66285787dbd798d54"), "location" : [ 135.14905294083408, 45.55809021337765 ], "category" : "편의점" }
{ "_id" : ObjectId("60c8afd66285787dbd798d57"), "location" : [ 157.811003283536, 44.347829904129824 ], "category" : "편의점" }
{ "_id" : ObjectId("60c8afd66285787dbd798d5b"), "location" : [ 144.04025034941506, 63.92484208356893 ], "category" : "편의점" }
{ "_id" : ObjectId("60c8afd66285787dbd798d60"), "location" : [ 165.61758455043793, 59.827339814987255 ], "category" : "편의점" }
{ "_id" : ObjectId("60c8afd66285787dbd798d61"), "location" : [ 157.52293628319262, 54.00702473784698 ], "category" : "편의점" }
{ "_id" : ObjectId("60c8afd66285787dbd798d68"), "location" : [ 141.3779552094182, 48.27048887438694 ], "category" : "편의점" }
{ "_id" : ObjectId("60c8afd66285787dbd798d69"), "location" : [ 171.40291499552532, 74.7718065583538 ], "category" : "편의점" }
{ "_id" : ObjectId("60c8afd66285787dbd798d7b"), "location" : [ 158.18118877703827, 50.901625279766144 ], "category" : "편의점" }
{ "_id" : ObjectId("60c8afd66285787dbd798d7c"), "location" : [ 169.2744414391853, 57.19524104061881 ], "category" : "편의점" }

> db.places.find({category:'편의점'}).count();
14
>
```

  
**Q4) 은행을 찾아보자.**

  
db.places.find({category:'은행'});  
db.places.find({category:'은행'}).count();

```
> db.places.find({category:'은행'});
{ "_id" : ObjectId("60c8afd66285787dbd798d2c"), "location" : [ 154.99304567347235, 46.092820840061975 ], "category" : "은행" }
{ "_id" : ObjectId("60c8afd66285787dbd798d3a"), "location" : [ 138.74752218255395, 39.521715761892374 ], "category" : "은행" }
{ "_id" : ObjectId("60c8afd66285787dbd798d41"), "location" : [ 145.81479995530472, 62.921733653988134 ], "category" : "은행" }
{ "_id" : ObjectId("60c8afd66285787dbd798d4b"), "location" : [ 165.40499506652185, 61.49508167235584 ], "category" : "은행" }
{ "_id" : ObjectId("60c8afd66285787dbd798d52"), "location" : [ 146.88837515604106, 46.43370762955308 ], "category" : "은행" }
{ "_id" : ObjectId("60c8afd66285787dbd798d53"), "location" : [ 174.83295078178557, 40.580658355442736 ], "category" : "은행" }
{ "_id" : ObjectId("60c8afd66285787dbd798d58"), "location" : [ 177.89218436778708, 62.65255363646997 ], "category" : "은행" }
{ "_id" : ObjectId("60c8afd66285787dbd798d5e"), "location" : [ 169.38783979764685, 52.97210669577137 ], "category" : "은행" }
{ "_id" : ObjectId("60c8afd66285787dbd798d5f"), "location" : [ 138.87626864847564, 38.64598542933119 ], "category" : "은행" }
{ "_id" : ObjectId("60c8afd66285787dbd798d65"), "location" : [ 144.35747967681658, 51.15572625492331 ], "category" : "은행" }
{ "_id" : ObjectId("60c8afd66285787dbd798d86"), "location" : [ 175.39911705160003, 51.5991100471397 ], "category" : "은행" }
{ "_id" : ObjectId("60c8afd66285787dbd798d8a"), "location" : [ 147.39455027402195, 42.406111800401696 ], "category" : "은행" }


> db.places.find({category:'은행'}).count();
12
>
```

  
**Q5) 커피를 찾아보자.**

  
db.places.find({category:'커피'});  
db.places.find({category:'커피'}).count();  
  

```
> db.places.find({category:'커피'});
{ "_id" : ObjectId("60c8afd66285787dbd798d2a"), "location" : [ 162.86695940959004, 56.88332669836795 ], "category" : "커피" }
{ "_id" : ObjectId("60c8afd66285787dbd798d30"), "location" : [ 171.16699622025513, 47.519560575489386 ], "category" : "커피" }
{ "_id" : ObjectId("60c8afd66285787dbd798d31"), "location" : [ 177.702425103313, 50.602822340148066 ], "category" : "커피" }
{ "_id" : ObjectId("60c8afd66285787dbd798d34"), "location" : [ 155.42183830924023, 63.28284519280565 ], "category" : "커피" }
{ "_id" : ObjectId("60c8afd66285787dbd798d40"), "location" : [ 156.75019149537798, 74.83962403343861 ], "category" : "커피" }
{ "_id" : ObjectId("60c8afd66285787dbd798d5d"), "location" : [ 179.10523344714682, 71.67982556744506 ], "category" : "커피" }
{ "_id" : ObjectId("60c8afd66285787dbd798d6e"), "location" : [ 128.52321998573385, 67.21900401704173 ], "category" : "커피" }
{ "_id" : ObjectId("60c8afd66285787dbd798d71"), "location" : [ 134.4099749312985, 45.66816530696374 ], "category" : "커피" }
{ "_id" : ObjectId("60c8afd66285787dbd798d72"), "location" : [ 179.1383369218369, 66.44877816828838 ], "category" : "커피" }
{ "_id" : ObjectId("60c8afd66285787dbd798d73"), "location" : [ 158.5049872086491, 52.82913348167578 ], "category" : "커피" }
{ "_id" : ObjectId("60c8afd66285787dbd798d7a"), "location" : [ 146.8690710192428, 67.75129670921774 ], "category" : "커피" }
{ "_id" : ObjectId("60c8afd66285787dbd798d84"), "location" : [ 169.8754248927329, 62.29427544209156 ], "category" : "커피" }
{ "_id" : ObjectId("60c8afd66285787dbd798d8b"), "location" : [ 157.52601557453298, 39.93516943291843 ], "category" : "커피" }
>
> db.places.find({category:'커피'}).count();
13
>
```

  
**Q6) ○○근처에 편의점, 은행, 커피 중 가장 가까운 10개를 찾아보자.**

  
 db.places.find({location : {$near : \[126.8988122,37.4852754\] }}).limit(10);

```
> db.places.find({location:{$near:[126.8988122,37.4852754]}}).limit(10);
{ "_id" : ObjectId("60c8afd66285787dbd798d2d"), "location" : [ 133.41728381718875, 39.48196192554386 ], "category" : "편의점" }
{ "_id" : ObjectId("60c8afd66285787dbd798d71"), "location" : [ 134.4099749312985, 45.66816530696374 ], "category" : "커피" }
{ "_id" : ObjectId("60c8afd66285787dbd798d54"), "location" : [ 135.14905294083408, 45.55809021337765 ], "category" : "편의점" }
{ "_id" : ObjectId("60c8afd66285787dbd798d3a"), "location" : [ 138.74752218255395, 39.521715761892374 ], "category" : "은행" }
{ "_id" : ObjectId("60c8afd66285787dbd798d5f"), "location" : [ 138.87626864847564, 38.64598542933119 ], "category" : "은행" }
{ "_id" : ObjectId("60c8afd66285787dbd798d47"), "location" : [ 133.3290570143667, 52.094232466716754 ], "category" : "편의점" }
{ "_id" : ObjectId("60c8afd66285787dbd798d68"), "location" : [ 141.3779552094182, 48.27048887438694 ], "category" : "편의점" }
{ "_id" : ObjectId("60c8afd66285787dbd798d8a"), "location" : [ 147.39455027402195, 42.406111800401696 ], "category" : "은행" }
{ "_id" : ObjectId("60c8afd66285787dbd798d52"), "location" : [ 146.88837515604106, 46.43370762955308 ], "category" : "은행" }
{ "_id" : ObjectId("60c8afd66285787dbd798d65"), "location" : [ 144.35747967681658, 51.15572625492331 ], "category" : "은행" }
>
```

  
  
**Q7) 문서  a 를 참고하여 a 에서 가장 가까운 5개의 편의점, 은행, 커피를 찾아보자.  
**

**   a= { "\_id" : ObjectId("60c8afd66285787dbd798d3a"),**

**        "location" : \[ 138.74752218255395, 39.521715761892374 \], "category" : "은행" }**

  
db.places.find({"location":\[138.74752218255395, 39.521715761892374\]});  
db.places.find({location : {$near:\[137,40\]}}).limit(5)

```
> db.places.find({"location":[138.74752218255395, 39.521715761892374]});
{ "_id" : ObjectId("60c8afd66285787dbd798d3a"), "location" : [ 138.74752218255395, 39.521715761892374 ], "category" : "은행" }


> db.places.find({location : {$near:[137,40]}}).limit(5)
{ "_id" : ObjectId("60c8afd66285787dbd798d3a"), "location" : [ 138.74752218255395, 39.521715761892374 ], "category" : "은행" }
{ "_id" : ObjectId("60c8afd66285787dbd798d5f"), "location" : [ 138.87626864847564, 38.64598542933119 ], "category" : "은행" }
{ "_id" : ObjectId("60c8afd66285787dbd798d2d"), "location" : [ 133.41728381718875, 39.48196192554386 ], "category" : "편의점" }
{ "_id" : ObjectId("60c8afd66285787dbd798d54"), "location" : [ 135.14905294083408, 45.55809021337765 ], "category" : "편의점" }
{ "_id" : ObjectId("60c8afd66285787dbd798d71"), "location" : [ 134.4099749312985, 45.66816530696374 ], "category" : "커피" }
>
```

  
**Q8) **○○** 근처에서 근방 0.25 거리에 있는 은행을 찾아보자.**

  
\> db.places.find({location :{$near : \[0,0.25\]}, category : '은행' });

```
> db.places.find({location :{$near : [0,0.25]},category:'은행'});
{ "_id" : ObjectId("60c8afd66285787dbd798d5f"), "location" : [ 138.87626864847564, 38.64598542933119 ], "category" : "은행" }
{ "_id" : ObjectId("60c8afd66285787dbd798d3a"), "location" : [ 138.74752218255395, 39.521715761892374 ], "category" : "은행" }
{ "_id" : ObjectId("60c8afd66285787dbd798d65"), "location" : [ 144.35747967681658, 51.15572625492331 ], "category" : "은행" }
{ "_id" : ObjectId("60c8afd66285787dbd798d8a"), "location" : [ 147.39455027402195, 42.406111800401696 ], "category" : "은행" }
{ "_id" : ObjectId("60c8afd66285787dbd798d52"), "location" : [ 146.88837515604106, 46.43370762955308 ], "category" : "은행" }
{ "_id" : ObjectId("60c8afd66285787dbd798d41"), "location" : [ 145.81479995530472, 62.921733653988134 ], "category" : "은행" }
{ "_id" : ObjectId("60c8afd66285787dbd798d2c"), "location" : [ 154.99304567347235, 46.092820840061975 ], "category" : "은행" }
{ "_id" : ObjectId("60c8afd66285787dbd798d4b"), "location" : [ 165.40499506652185, 61.49508167235584 ], "category" : "은행" }
{ "_id" : ObjectId("60c8afd66285787dbd798d5e"), "location" : [ 169.38783979764685, 52.97210669577137 ], "category" : "은행" }
{ "_id" : ObjectId("60c8afd66285787dbd798d53"), "location" : [ 174.83295078178557, 40.580658355442736 ], "category" : "은행" }
{ "_id" : ObjectId("60c8afd66285787dbd798d86"), "location" : [ 175.39911705160003, 51.5991100471397 ], "category" : "은행" }
{ "_id" : ObjectId("60c8afd66285787dbd798d58"), "location" : [ 177.89218436778708, 62.65255363646997 ], "category" : "은행" }
>
```

  
**Q9) ○○근처에서 가장 멀리있는 편의점을 3개 찾아보자.**

  
db.places.find({location : {$near : \[0,0.25\]}, category : '편의점' }).limit(3).sort({"location":-1})

```
> db.places.find({location : {$near : [0,0.25]}, category : '편의점' })
{ "_id" : ObjectId("60c8afd66285787dbd798d2d"), "location" : [ 133.41728381718875, 39.48196192554386 ], "category" : "편의점" }
{ "_id" : ObjectId("60c8afd66285787dbd798d39"), "location" : [ 127.08781707481076, 62.86039226433685 ], "category" : "편의점" }
{ "_id" : ObjectId("60c8afd66285787dbd798d54"), "location" : [ 135.14905294083408, 45.55809021337765 ], "category" : "편의점" }
{ "_id" : ObjectId("60c8afd66285787dbd798d47"), "location" : [ 133.3290570143667, 52.094232466716754 ], "category" : "편의점" }
{ "_id" : ObjectId("60c8afd66285787dbd798d4c"), "location" : [ 131.54279095142155, 63.29511107666771 ], "category" : "편의점" }
{ "_id" : ObjectId("60c8afd66285787dbd798d68"), "location" : [ 141.3779552094182, 48.27048887438694 ], "category" : "편의점" }
{ "_id" : ObjectId("60c8afd66285787dbd798d5b"), "location" : [ 144.04025034941506, 63.92484208356893 ], "category" : "편의점" }
{ "_id" : ObjectId("60c8afd66285787dbd798d2e"), "location" : [ 147.36829466332017, 64.77647649105594 ], "category" : "편의점" }
{ "_id" : ObjectId("60c8afd66285787dbd798d57"), "location" : [ 157.811003283536, 44.347829904129824 ], "category" : "편의점" }
{ "_id" : ObjectId("60c8afd66285787dbd798d7b"), "location" : [ 158.18118877703827, 50.901625279766144 ], "category" : "편의점" }
{ "_id" : ObjectId("60c8afd66285787dbd798d61"), "location" : [ 157.52293628319262, 54.00702473784698 ], "category" : "편의점" }
{ "_id" : ObjectId("60c8afd66285787dbd798d60"), "location" : [ 165.61758455043793, 59.827339814987255 ], "category" : "편의점" }
{ "_id" : ObjectId("60c8afd66285787dbd798d7c"), "location" : [ 169.2744414391853, 57.19524104061881 ], "category" : "편의점" }
{ "_id" : ObjectId("60c8afd66285787dbd798d69"), "location" : [ 171.40291499552532, 74.7718065583538 ], "category" : "편의점" }

> db.places.find({location : {$near : [0,0.25]}, category : '편의점' }).limit(3).sort({"location":-1})

{ "_id" : ObjectId("60c8afd66285787dbd798d69"), "location" : [ 171.40291499552532, 74.7718065583538 ], "category" : "편의점" }
{ "_id" : ObjectId("60c8afd66285787dbd798d7c"), "location" : [ 169.2744414391853, 57.19524104061881 ], "category" : "편의점" }
{ "_id" : ObjectId("60c8afd66285787dbd798d60"), "location" : [ 165.61758455043793, 59.827339814987255 ], "category" : "편의점" }
>
```

  
**Q10) ○○근처에서 가장 멀리있는 은행과의 가운데 있는 지점의 편의점을 찾아보자.**  
  

---

##   
**mongofiles**

일반적으로 mongodb 저장할 수 있는 문서의 크기 16MB 가 상한이다.

16MB 이상은 GridFS 사용한다.  
GridFS는  Mongodb를 분할해서 (입,출력) 하기 위한 인터페이스 이다.

명령어

 : put, get, search, delete, option (-v : 이중화,  -d : DB지정)

  
**\[형식\]**

  
**  mongofiles <options> <connection-string> <command> <filename or \_id>**

**\# mongofiles 도움말 확인**

  
C:\\Test>mongofiles --help  
  

**\# mongofile 시작 및 디렉터리 확인**

```
C:\Users\hyeri>cd\

C:\>cd test // test 폴더

C:\Test>dir/w
 C 드라이브의 볼륨에는 이름이 없습니다.
 볼륨 일련 번호: BE80-C42F

 C:\Test 디렉터리

[.]                    [..]                   1.jpg                  2.jpg
210422_hyeri.py        210422_소모임과제.py   3.jpg                  a.txt
atest.py               b.txt                  c.txt                  d.txt
data.txt               for_01.py              for_02.py              for_03.py
scott.sql              while_01.py            while_02.py
              17개 파일              27,721 바이트
               2개 디렉터리  415,039,836,160 바이트 남음
               

C:\Test>dir *.txt // txt 파일확인
 C 드라이브의 볼륨에는 이름이 없습니다.
 볼륨 일련 번호: BE80-C42F

 C:\Test 디렉터리

2021-06-15  오후 12:42                16 a.txt
2021-05-03  오후 02:26                17 b.txt
2021-06-15  오후 12:47                26 c.txt
2021-05-03  오후 02:26                 9 d.txt
2021-05-05  오후 02:19               770 data.txt
               5개 파일                 838 바이트
               0개 디렉터리  415,039,811,584 바이트 남음

C:\Test>dir *.jpg  // jpg 파일확인
 C 드라이브의 볼륨에는 이름이 없습니다.
 볼륨 일련 번호: BE80-C42F

 C:\Test 디렉터리

2021-05-17  오후 01:37             4,775 1.jpg
2021-05-17  오후 01:37             7,755 2.jpg
2021-05-17  오후 01:37             4,521 3.jpg
               3개 파일              17,051 바이트
               0개 디렉터리  415,040,487,424 바이트 남음
```

**Q1) images 데이터 베이스에 1.jpg 올리기**

  
 mongofiles -v -d images put 1.jpg

  
**   # txt, json 파일도 올리기**

```
C:\Test>mongofiles -v -d images put 1.jpg

2021-06-15T14:47:54.398+0900    using write concern: &{majority false 0}
2021-06-15T14:47:54.468+0900    will listen for SIGTERM, SIGINT, and SIGKILL
2021-06-15T14:47:55.091+0900    connected to node type: standalone
2021-06-15T14:47:55.092+0900    connected to: mongodb://localhost/
2021-06-15T14:47:55.092+0900    handling mongofiles 'put' command...
2021-06-15T14:47:55.092+0900    adding gridFile: 1.jpg
2021-06-15T14:47:55.101+0900    creating GridFS gridFile '' from local gridFile '1.jpg'
2021-06-15T14:47:55.137+0900    copied 4775 bytes to server
2021-06-15T14:47:55.137+0900    added gridFile: 1.jpg


/************************************
2021-06-15T14:47:55.101+0900    creating GridFS gridFile ''(파일명 변경) from local gridFile '1.jpg'
2021-06-15T14:47:55.137+0900    copied 4775 bytes to server
2021-06-15T14:47:55.137+0900    added gridFile: 1.jpg (위에 변경하면 이름 변경됨)
*************************************/

C:\Test>mongofiles -v -d images put 2.jpg

2021-06-15T14:53:51.216+0900    using write concern: &{majority false 0}
2021-06-15T14:53:51.281+0900    will listen for SIGTERM, SIGINT, and SIGKILL
2021-06-15T14:53:51.901+0900    connected to node type: standalone
2021-06-15T14:53:51.901+0900    connected to: mongodb://localhost/
2021-06-15T14:53:51.902+0900    handling mongofiles 'put' command...
2021-06-15T14:53:51.902+0900    adding gridFile: 2.jpg
2021-06-15T14:53:51.907+0900    creating GridFS gridFile '' from local gridFile '2.jpg'
2021-06-15T14:53:51.910+0900    copied 7755 bytes to server
2021-06-15T14:53:51.911+0900    added gridFile: 2.jpg


C:\Test>mongofiles -v -d images put 3.jpg

2021-06-15T14:53:57.692+0900    using write concern: &{majority false 0}
2021-06-15T14:53:57.750+0900    will listen for SIGTERM, SIGINT, and SIGKILL
2021-06-15T14:53:58.367+0900    connected to node type: standalone
2021-06-15T14:53:58.367+0900    connected to: mongodb://localhost/
2021-06-15T14:53:58.367+0900    handling mongofiles 'put' command...
2021-06-15T14:53:58.367+0900    adding gridFile: 3.jpg
2021-06-15T14:53:58.368+0900    creating GridFS gridFile '' from local gridFile '3.jpg'
2021-06-15T14:53:58.371+0900    copied 4521 bytes to server
2021-06-15T14:53:58.372+0900    added gridFile: 3.jpg


C:\Test>mongofiles -v -d images put a.txt

2021-06-15T14:54:57.775+0900    using write concern: &{majority false 0}
2021-06-15T14:54:57.834+0900    will listen for SIGTERM, SIGINT, and SIGKILL
2021-06-15T14:54:58.456+0900    connected to node type: standalone
2021-06-15T14:54:58.457+0900    connected to: mongodb://localhost/
2021-06-15T14:54:58.459+0900    handling mongofiles 'put' command...
2021-06-15T14:54:58.459+0900    adding gridFile: a.txt
2021-06-15T14:54:58.461+0900    creating GridFS gridFile '' from local gridFile 'a.txt'
2021-06-15T14:54:58.464+0900    copied 16 bytes to server
2021-06-15T14:54:58.464+0900    added gridFile: a.txt


C:\Test>mongofiles -v -d images put b.txt

2021-06-15T14:55:02.761+0900    using write concern: &{majority false 0}
2021-06-15T14:55:02.820+0900    will listen for SIGTERM, SIGINT, and SIGKILL
2021-06-15T14:55:03.440+0900    connected to node type: standalone
2021-06-15T14:55:03.440+0900    connected to: mongodb://localhost/
2021-06-15T14:55:03.442+0900    handling mongofiles 'put' command...
2021-06-15T14:55:03.443+0900    adding gridFile: b.txt
2021-06-15T14:55:03.444+0900    creating GridFS gridFile '' from local gridFile 'b.txt'
2021-06-15T14:55:03.448+0900    copied 17 bytes to server
2021-06-15T14:55:03.449+0900    added gridFile: b.txt


C:\Test>mongofiles -v -d images put c.txt

2021-06-15T14:55:07.317+0900    using write concern: &{majority false 0}
2021-06-15T14:55:07.377+0900    will listen for SIGTERM, SIGINT, and SIGKILL
2021-06-15T14:55:08.006+0900    connected to node type: standalone
2021-06-15T14:55:08.007+0900    connected to: mongodb://localhost/
2021-06-15T14:55:08.008+0900    handling mongofiles 'put' command...
2021-06-15T14:55:08.009+0900    adding gridFile: c.txt
2021-06-15T14:55:08.011+0900    creating GridFS gridFile '' from local gridFile 'c.txt'
2021-06-15T14:55:08.015+0900    copied 26 bytes to server
2021-06-15T14:55:08.015+0900    added gridFile: c.txt


C:\Test>mongofiles -v -d images put c.json

2021-06-15T14:57:29.703+0900    using write concern: &{majority false 0}
2021-06-15T14:57:29.762+0900    will listen for SIGTERM, SIGINT, and SIGKILL
2021-06-15T14:57:30.375+0900    connected to node type: standalone
2021-06-15T14:57:30.376+0900    connected to: mongodb://localhost/
2021-06-15T14:57:30.376+0900    handling mongofiles 'put' command...
2021-06-15T14:57:30.376+0900    adding gridFile: c.json
2021-06-15T14:57:30.377+0900    creating GridFS gridFile '' from local gridFile 'c.json'
2021-06-15T14:57:30.381+0900    copied 361 bytes to server
2021-06-15T14:57:30.381+0900    added gridFile: c.json
```

**\# 업로드 확인**

```
C:\Test>mongo // mongo로 간다.
MongoDB shell version v4.4.6
connecting to: mongodb://127.0.0.1:27017/?compressors=disabled&gssapiServiceName=mongodb
Implicit session: session { "id" : UUID("2c44f18b-c10c-491a-9853-6bb996f3e18e") }
MongoDB server version: 4.4.6
---
The server generated these startup warnings when booting:
        2021-06-10T11:12:37.324+09:00: Access control is not enabled for the database. Read and write access to data and configuration is unrestricted
        2021-06-10T11:12:37.325+09:00: This server is bound to localhost. Remote systems will be unable to connect to this server. Start the server with --bind_ip <address> to specify which IP addresses it should serve responses from, or with --bind_ip_all to bind to all interfaces. If this behavior is desired, start the server with --bind_ip 127.0.0.1 to disable this warning
---
---
> show dbs
admin     0.000GB
config    0.000GB
geotest   0.000GB
geotest1  0.000GB
images    0.000GB
imges     0.032GB
local     0.000GB
my_score  0.001GB
my_test   0.001GB
test      0.000GB

> use images // 파일 올린 images 로 간 후 
switched to db images

> show collections // collection 확인
fs.chunks // bson형태를 통해 put으로 올린 파일 내용 저장
fs.files //put 으로 올린 파일 정보 저장
```

  
  
**Q2) fs.files 에 있는 파일의 목록을 확인하고 id를 찾아서 fs.chunks에서 데이터를 확인 하자.**

db.fs.files.find()

```
> db.fs.files.find() 
{ "_id" : ObjectId("60c8406fa3377d28b3e85b89"), "length" : NumberLong(7755), "chunkSize" : 261120, "uploadDate" : ISODate("2021-06-15T05:53:51.910Z"), "filename" : "2.jpg", "metadata" : {  } }
{ "_id" : ObjectId("60c84076faf46ea165f3e5ed"), "length" : NumberLong(4521), "chunkSize" : 261120, "uploadDate" : ISODate("2021-06-15T05:53:58.371Z"), "filename" : "3.jpg", "metadata" : {  } }
{ "_id" : ObjectId("60c840b24c2456cd09d4712b"), "length" : NumberLong(16), "chunkSize" : 261120, "uploadDate" : ISODate("2021-06-15T05:54:58.464Z"), "filename" : "a.txt", "metadata" : {  } }
{ "_id" : ObjectId("60c840b7f6015d3904306ace"), "length" : NumberLong(17), "chunkSize" : 261120, "uploadDate" : ISODate("2021-06-15T05:55:03.448Z"), "filename" : "b.txt", "metadata" : {  } }
{ "_id" : ObjectId("60c840bcd78ecd7a0573249b"), "length" : NumberLong(26), "chunkSize" : 261120, "uploadDate" : ISODate("2021-06-15T05:55:08.015Z"), "filename" : "c.txt", "metadata" : {  } }
{ "_id" : ObjectId("60c8414a650d9fa926ad2f95"), "length" : NumberLong(361), "chunkSize" : 261120, "uploadDate" : ISODate("2021-06-15T05:57:30.381Z"), "filename" : "c.json", "metadata" : {  } }
{ "_id" : ObjectId("60c8c2ba346fc76dbfba1ea8"), "length" : NumberLong(4775), "chunkSize" : 261120, "uploadDate" : ISODate("2021-06-15T15:09:46.248Z"), "filename" : "1.jpg", "metadata" : {  } }
{ "_id" : ObjectId("60c8c2d3036e3c17e287fdef"), "length" : NumberLong(16), "chunkSize" : 261120, "uploadDate" : ISODate("2021-06-15T15:10:11.884Z"), "filename" : "a.txt", "metadata" : {  } }
{ "_id" : ObjectId("60c8c2de60ded74e659dd866"), "length" : NumberLong(26), "chunkSize" : 261120, "uploadDate" : ISODate("2021-06-15T15:10:22.639Z"), "filename" : "c.txt", "metadata" : {  } }
{ "_id" : ObjectId("60c8c2e5cccb8205b4233aa8"), "length" : NumberLong(361), "chunkSize" : 261120, "uploadDate" : ISODate("2021-06-15T15:10:29.792Z"), "filename" : "c.json", "metadata" : {  } }
>
```

db.fs.chunks.find()

```
// file_id 확인하자

> db.fs.chunks.find()
{ "_id" : ObjectId("60c8406fa3377d28b3e85b8a"), "files_id" : ObjectId("60c8406fa3377d28b3e85b89"), "n" : 0, "data" : BinData(0,"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") }
{ "_id" : ObjectId("60c84076faf46ea165f3e5ee"), "files_id" : ObjectId("60c84076faf46ea165f3e5ed"), "n" : 0, "data" : BinData(0,"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") }
{ "_id" : ObjectId("60c840b24c2456cd09d4712c"), "files_id" : ObjectId("60c840b24c2456cd09d4712b"), "n" : 0, "data" : BinData(0,"YWJjZGVmZw0KMTIzNDU2Nw==") }
{ "_id" : ObjectId("60c840b7f6015d3904306acf"), "files_id" : ObjectId("60c840b7f6015d3904306ace"), "n" : 0, "data" : BinData(0,"YWJjZGVmZw0KMTExMTExDQo=") }
{ "_id" : ObjectId("60c840bcd78ecd7a0573249c"), "files_id" : ObjectId("60c840bcd78ecd7a0573249b"), "n" : 0, "data" : BinData(0,"64yA7ZWc66+86rWt7Jqw66as64KY6528DQo=") }
{ "_id" : ObjectId("60c8414a650d9fa926ad2f96"), "files_id" : ObjectId("60c8414a650d9fa926ad2f95"), "n" : 0, "data" : BinData(0,"c3RyID0geyJ0aXRsZSI6IkV4YW1wbGUgU2NoZW1hIiwNCiAgICAgICAidHlwZSI6Im9iamVjdCIsDQogICAgICAgInByb3BlcnRpZXMiOnsNCiAgICAgICAgICAgImZpcnN0TmFtZSI6ew0KICAgICAgICAgICAgICAgInR5dHBlIjoic3RyaW5nIg0KICAgICAgICAgICB9LA0KICAgICAgICAgICAiYWdlIjp7DQogICAgICAgICAgICAgICAiZGVzY3JpcHRpb24iOiJBZ2UgaW4geWVhcnMiLA0KICAgICAgICAgICAgICAgInR5cGUiOiJpbnRlZ2VyIiwNCiAgICAgICAgICAgICAgICJtaW5pbXVtIjowDQogICAgICAgICAgIH0NCiAgICAgICB9LA0KICAgICAgICJyZXF1aXJlZCI6WyJmaXJzdE5hbWUiLCJsYXN0TmFtZSJdDQogICAgICAgfQ==") }
{ "_id" : ObjectId("60c8c2ba346fc76dbfba1ea9"), "files_id" : ObjectId("60c8c2ba346fc76dbfba1ea8"), "n" : 0, "data" : BinData(0,"/9j/4AAQSkZJRgABAQEASABIAAD/2wBDAAQCAwMDAgQDAwMEBAQEBQkGBQUFBQsICAYJDQsNDQ0LDAwOEBQRDg8TDwwMEhgSExUWFxcXDhEZGxkWGhQWFxb/2wBDAQQEBAUFBQoGBgoWDwwPFhYWFhYWFhYWFhYWFhYWFhYWFhYWFhYWFhYWFhYWFhYWFhYWFhYWFhYWFhYWFhYWFhb/wAARCADmAOYDASIAAhEBAxEB/8QAHQABAAAHAQEAAAAAAAAAAAAAAAEDBAUGCAkCB//EAEUQAAEDAwEEBQcICQIHAAAAAAEAAgMEBREGBxIhMQhBUWFxExQycoGRoQkiUmKCscHRFSMkJjNCkqKjFmMlQ2RzssLh/8QAGAEBAQEBAQAAAAAAAAAAAAAAAAECAwT/xAAeEQEBAAMAAgMBAAAAAAAAAAAAAQIDERIxBCFBE//aAAwDAQACEQMRAD8A3+REQEREBERAREQEREBERAREQEREBERAREQEREBERAREQEREBERAREQEREBERAREQEREBERAREQEREBERAREQEREBERAREQEREBERAREQEREBERAREQEREBERAREQEREBERAREQEREBERAREQEREBERAREQEREBERAREQEREBERAREQEREBERAREQEREBERAREQEREBERAREQERQyEEUXlz2tBLjgDiSeAVkvOtdHWgn9LarsdBu8/OrlDFj+pwQX1F8wvvSL2H2hxbWbTtOkjmKer84PujDlht/6Z+wO3EiHU1dcSOqjtM5z4F7WhBsCi1RvPT22ZRkts+l9T17uoyMgpwffIT8Fht5+UID95ll2asaQcb1befvayL8UG8CEhc9bx07NqVWwi26c0pQtPJxinqHD2mRo+CxG89L7b1XBzY9V0VA13VR2iBuPAva4oOm+8OopvDv9y5NXjb3tpuhd53tP1Lh3NtPWebj3RBqxC86q1Rd3F111Neq8u5+dXKaXP8AU4oOvt51Zpe0Z/Suo7RQgczVV8UWP6nBYdfukDsVs7i2t2naa3m82wV7Zz7o95cm3MY5286NjnHrLQSvQJAwOHgg6aX3phbBrfkQ6qq7iR1UVpqH59rmNHxWIXzp3bLqdpFs03qqvcORdTwQNPtdLn4LnySiDovoDpubIr29kN+ivWmpnHBfWUvl4B9uEuI9rQvumg9daO1rQir0nqe1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") }
{ "_id" : ObjectId("60c8c2d3036e3c17e287fdf0"), "files_id" : ObjectId("60c8c2d3036e3c17e287fdef"), "n" : 0, "data" : BinData(0,"YWJjZGVmZw0KMTIzNDU2Nw==") }
{ "_id" : ObjectId("60c8c2de60ded74e659dd867"), "files_id" : ObjectId("60c8c2de60ded74e659dd866"), "n" : 0, "data" : BinData(0,"64yA7ZWc66+86rWt7Jqw66as64KY6528DQo=") }
{ "_id" : ObjectId("60c8c2e5cccb8205b4233aa9"), "files_id" : ObjectId("60c8c2e5cccb8205b4233aa8"), "n" : 0, "data" : BinData(0,"c3RyID0geyJ0aXRsZSI6IkV4YW1wbGUgU2NoZW1hIiwNCiAgICAgICAidHlwZSI6Im9iamVjdCIsDQogICAgICAgInByb3BlcnRpZXMiOnsNCiAgICAgICAgICAgImZpcnN0TmFtZSI6ew0KICAgICAgICAgICAgICAgInR5dHBlIjoic3RyaW5nIg0KICAgICAgICAgICB9LA0KICAgICAgICAgICAiYWdlIjp7DQogICAgICAgICAgICAgICAiZGVzY3JpcHRpb24iOiJBZ2UgaW4geWVhcnMiLA0KICAgICAgICAgICAgICAgInR5cGUiOiJpbnRlZ2VyIiwNCiAgICAgICAgICAgICAgICJtaW5pbXVtIjowDQogICAgICAgICAgIH0NCiAgICAgICB9LA0KICAgICAgICJyZXF1aXJlZCI6WyJmaXJzdE5hbWUiLCJsYXN0TmFtZSJdDQogICAgICAgfQ==") }
>
```

  
\-- jpg  
db.fs.chunks.find({files\_id : ObjectId("60c8406fa3377d28b3e85b89")});  
\-- txt  
db.fs.chunks.find({files\_id : ObjectId("60c840b24c2456cd09d4712b")});  
\-- json  
db.fs.chunks.find({files\_id : ObjectId("60c8414a650d9fa926ad2f95")});

```
//c.json

> db.fs.chunks.find({files_id : ObjectId("60c8414a650d9fa926ad2f95")});
{ "_id" : ObjectId("60c8414a650d9fa926ad2f96"), "files_id" : ObjectId("60c8414a650d9fa926ad2f95"), "n" : 0, "data" : BinData(0,"c3RyID0geyJ0aXRsZSI6IkV4YW1wbGUgU2NoZW1hIiwNCiAgICAgICAidHlwZSI6Im9iamVjdCIsDQogICAgICAgInByb3BlcnRpZXMiOnsNCiAgICAgICAgICAgImZpcnN0TmFtZSI6ew0KICAgICAgICAgICAgICAgInR5dHBlIjoic3RyaW5nIg0KICAgICAgICAgICB9LA0KICAgICAgICAgICAiYWdlIjp7DQogICAgICAgICAgICAgICAiZGVzY3JpcHRpb24iOiJBZ2UgaW4geWVhcnMiLA0KICAgICAgICAgICAgICAgInR5cGUiOiJpbnRlZ2VyIiwNCiAgICAgICAgICAgICAgICJtaW5pbXVtIjowDQogICAgICAgICAgIH0NCiAgICAgICB9LA0KICAgICAgICJyZXF1aXJlZCI6WyJmaXJzdE5hbWUiLCJsYXN0TmFtZSJdDQogICAgICAgfQ==") }
```

  
** # 삭제**  
mongofiles -v -d images delete 1.jpg

  
**Q3)** **목록확인**

  
mongofiles -v -d images list

```
C:\Test>mongofiles -v -d images list
2021-06-16T15:55:54.489+0900    using write concern: &{majority false 0}
2021-06-16T15:55:54.549+0900    will listen for SIGTERM, SIGINT, and SIGKILL
2021-06-16T15:55:55.174+0900    connected to node type: standalone
2021-06-16T15:55:55.175+0900    connected to: mongodb://localhost/
2021-06-16T15:55:55.175+0900    handling mongofiles 'list' command...
2.jpg   7755
3.jpg   4521
a.txt   16
b.txt   17
c.txt   26
c.json  361
1.jpg   4775
a.txt   16
c.txt   26
c.json  361

C:\Test>
```

  
**Q4) d.mp4로 영상을 imges db에 put 한 다음 몽고 접속 후 use images로 이동해서 내용 확인**

**     : 내용은 많으니 count로 갯수만 확인하자.**  
  
  
mongofiles -v -d images put d.mp4  
  
db.fs.chunks.find().count()  
141

db.fs.chunks.stats()  
chunk\_count\_limit=0,chunk\_max=5GB,chunk\_size=10MB, - 속성으로 값 변함

```
C:\Test>mongofiles -v -d images put d.mp4

2021-06-16T15:56:51.454+0900    using write concern: &{majority false 0}
2021-06-16T15:56:51.511+0900    will listen for SIGTERM, SIGINT, and SIGKILL
2021-06-16T15:56:52.129+0900    connected to node type: standalone
2021-06-16T15:56:52.129+0900    connected to: mongodb://localhost/
2021-06-16T15:56:52.129+0900    handling mongofiles 'put' command...
2021-06-16T15:56:52.129+0900    adding gridFile: d.mp4
2021-06-16T15:56:52.130+0900    creating GridFS gridFile '' from local gridFile 'd.mp4'
2021-06-16T15:56:52.400+0900    copied 34184488 bytes to server
2021-06-16T15:56:52.400+0900    added gridFile: d.mp4


C:\Test>mongo
MongoDB shell version v4.4.6
connecting to: mongodb://127.0.0.1:27017/?compressors=disabled&gssapiServiceName=mongodb
Implicit session: session { "id" : UUID("808e9321-f6ab-41ee-9622-30a96d933d7d") }
MongoDB server version: 4.4.6
'''

---
> use images
switched to db images


> db.fs.chunks.find().count()
141


>  db.fs.chunks.stats()
{
        "ns" : "images.fs.chunks",
        "size" : 34211104,
        "count" : 141,
        "avgObjSize" : 242631,
        "storageSize" : 34402304,
        "freeStorageSize" : 49152,
        "capped" : false,
        "wiredTiger" : {
                "metadata" : {
                        "formatVersion" : 1
                },
                "creationString" : "access_pattern_hint=none,allocation_size=4KB,app_metadata=(formatVersion=1),assert=(commit_timestamp=none,durable_timestamp=none,read_timestamp=none,write_timestamp=off),block_allocation=best,block_compressor=snappy,cache_resident=false,checksum=on,colgroups=,collator=,columns=,dictionary=0,encryption=(keyid=,name=),exclusive=false,extractor=,format=btree,huffman_key=,huffman_value=,ignore_in_memory_cache_size=false,immutable=false,import=(enabled=false,file_metadata=,repair=false),internal_item_max=0,internal_key_max=0,internal_key_truncate=true,internal_page_max=4KB,key_format=q,key_gap=10,leaf_item_max=0,leaf_key_max=0,leaf_page_max=32KB,leaf_value_max=64MB,log=(enabled=true),lsm=(auto_throttle=true,bloom=true,bloom_bit_count=16,bloom_config=,bloom_hash_count=8,bloom_oldest=false,chunk_count_limit=0,chunk_max=5GB,chunk_size=10MB,merge_custom=(prefix=,start_generation=0,suffix=),merge_max=15,merge_min=0),memory_page_image_max=0,memory_page_max=10m,os_cache_dirty_max=0,os_cache_max=0,prefix_compression=false,prefix_compression_min=4,readonly=false,source=,split_deepen_min_child=0,split_deepen_per_child=0,split_pct=90,tiered=(chunk_size=1GB,tiers=),tiered_storage=(auth_token=,bucket=,local_retention=300,name=,object_target_size=10M),type=file,value_format=u,verbose=[],write_timestamp_usage=none",
                "type" : "file",
                "uri" : "statistics:table:collection-86-3696876612360350141",
                "LSM" : {
                        "bloom filter false positives" : 0,
                        "bloom filter hits" : 0,
                        "bloom filter misses" : 0,
                        "bloom filter pages evicted from cache" : 0,
                        "bloom filter pages read into cache" : 0,
                        "bloom filters in the LSM tree" : 0,
                        "chunks in the LSM tree" : 0,
                        "highest merge generation in the LSM tree" : 0,
                        "queries that could have benefited from a Bloom filter that did not exist" : 0,
                        "total size of bloom filters" : 0,
                        "sleep for LSM checkpoint throttle" : 0,
                        "sleep for LSM merge throttle" : 0
                },
                "block-manager" : {
                        "allocations requiring file extension" : 146,
                        "blocks allocated" : 162,
                        "blocks freed" : 7,
                        "checkpoint size" : 34336768,
                        "file allocation unit size" : 4096,
                        "file bytes available for reuse" : 49152,
                        "file magic number" : 120897,
                        "file major version number" : 1,
                        "file size in bytes" : 34402304,
                        "minor version number" : 0
                },
                "btree" : {
                        "btree checkpoint generation" : 4655,
                        "btree clean tree checkpoint expiration time" : 0,
                        "column-store fixed-size leaf pages" : 0,
                        "column-store internal pages" : 0,
                        "column-store variable-size RLE encoded values" : 0,
                        "column-store variable-size deleted values" : 0,
                        "column-store variable-size leaf pages" : 0,
                        "fixed-record size" : 0,
                        "maximum internal page key size" : 368,
                        "maximum internal page size" : 4096,
                        "maximum leaf page key size" : 2867,
                        "maximum leaf page size" : 32768,
                        "maximum leaf page value size" : 67108864,
                        "maximum tree depth" : 3,
                        "number of key/value pairs" : 0,
                        "overflow pages" : 0,
                        "pages rewritten by compaction" : 0,
                        "row-store empty values" : 0,
                        "row-store internal pages" : 0,
                        "row-store leaf pages" : 0
                },
                "cache" : {
                        "data source pages selected for eviction unable to be evicted" : 0,
                        "eviction walk passes of a file" : 0,
                        "bytes currently in the cache" : 36971040,
                        "bytes dirty in the cache cumulative" : 435522,
                        "bytes read into cache" : 0,
                        "bytes written from cache" : 34326570,
                        "checkpoint blocked page eviction" : 0,
                        "eviction walk target pages histogram - 0-9" : 0,
                        "eviction walk target pages histogram - 10-31" : 0,
                        "eviction walk target pages histogram - 128 and higher" : 0,
                        "eviction walk target pages histogram - 32-63" : 0,
                        "eviction walk target pages histogram - 64-128" : 0,
                        "eviction walk target pages reduced due to history store cache pressure" : 0,
                        "eviction walks abandoned" : 0,
                        "eviction walks gave up because they restarted their walk twice" : 0,
                        "eviction walks gave up because they saw too many pages and found no candidates" : 0,
                        "eviction walks gave up because they saw too many pages and found too few candidates" : 0,
                        "eviction walks reached end of tree" : 0,
                        "eviction walks restarted" : 0,
                        "eviction walks started from root of tree" : 0,
                        "eviction walks started from saved location in tree" : 0,
                        "hazard pointer blocked page eviction" : 0,
                        "history store table insert calls" : 0,
                        "history store table insert calls that returned restart" : 0,
                        "history store table out-of-order resolved updates that lose their durable timestamp" : 0,
                        "history store table out-of-order updates that were fixed up by moving existing records" : 0,
                        "history store table out-of-order updates that were fixed up during insertion" : 0,
                        "history store table reads" : 0,
                        "history store table reads missed" : 0,
                        "history store table reads requiring squashed modifies" : 0,
                        "history store table truncation by rollback to stable to remove an unstable update" : 0,
                        "history store table truncation by rollback to stable to remove an update" : 0,
                        "history store table truncation to remove an update" : 0,
                        "history store table truncation to remove range of updates due to key being removed from the data page during reconciliation" : 0,
                        "history store table truncation to remove range of updates due to non timestamped update on data page" : 0,
                        "history store table writes requiring squashed modifies" : 0,
                        "in-memory page passed criteria to be split" : 8,
                        "in-memory page splits" : 4,
                        "internal pages evicted" : 0,
                        "internal pages split during eviction" : 0,
                        "leaf pages split during eviction" : 0,
                        "modified pages evicted" : 0,
                        "overflow pages read into cache" : 0,
                        "page split during eviction deepened the tree" : 0,
                        "page written requiring history store records" : 0,
                        "pages read into cache" : 0,
                        "pages read into cache after truncate" : 1,
                        "pages read into cache after truncate in prepare state" : 0,
                        "pages requested from the cache" : 176,
                        "pages seen by eviction walk" : 0,
                        "pages written from cache" : 146,
                        "pages written requiring in-memory restoration" : 0,
                        "tracked dirty bytes in the cache" : 0,
                        "unmodified pages evicted" : 0
                },
                "cache_walk" : {
                        "Average difference between current eviction generation when the page was last considered" : 0,
                        "Average on-disk page image size seen" : 0,
                        "Average time in cache for pages that have been visited by the eviction server" : 0,
                        "Average time in cache for pages that have not been visited by the eviction server" : 0,
                        "Clean pages currently in cache" : 0,
                        "Current eviction generation" : 0,
                        "Dirty pages currently in cache" : 0,
                        "Entries in the root page" : 0,
                        "Internal pages currently in cache" : 0,
                        "Leaf pages currently in cache" : 0,
                        "Maximum difference between current eviction generation when the page was last considered" : 0,
                        "Maximum page size seen" : 0,
                        "Minimum on-disk page image size seen" : 0,
                        "Number of pages never visited by eviction server" : 0,
                        "On-disk page image sizes smaller than a single allocation unit" : 0,
                        "Pages created in memory and never written" : 0,
                        "Pages currently queued for eviction" : 0,
                        "Pages that could not be queued for eviction" : 0,
                        "Refs skipped during cache traversal" : 0,
                        "Size of the root page" : 0,
                        "Total number of pages currently in cache" : 0
                },
                "checkpoint-cleanup" : {
                        "pages added for eviction" : 0,
                        "pages removed" : 0,
                        "pages skipped during tree walk" : 0,
                        "pages visited" : 12
                },
                "compression" : {
                        "compressed page maximum internal page size prior to compression" : 4096,
                        "compressed page maximum leaf page size prior to compression " : 127796,
                        "compressed pages read" : 0,
                        "compressed pages written" : 1,
                        "page written failed to compress" : 137,
                        "page written was too small to compress" : 8
                },
                "cursor" : {
                        "bulk loaded cursor insert calls" : 0,
                        "cache cursors reuse count" : 32,
                        "close calls that result in cache" : 33,
                        "create calls" : 3,
                        "insert calls" : 142,
                        "insert key and value bytes" : 34216162,
                        "modify" : 0,
                        "modify key and value bytes affected" : 0,
                        "modify value bytes modified" : 0,
                        "next calls" : 14,
                        "operation restarted" : 0,
                        "prev calls" : 1,
                        "remove calls" : 1,
                        "remove key bytes removed" : 1,
                        "reserve calls" : 0,
                        "reset calls" : 133,
                        "search calls" : 17,
                        "search history store calls" : 0,
                        "search near calls" : 0,
                        "truncate calls" : 0,
                        "update calls" : 0,
                        "update key and value bytes" : 0,
                        "update value size change" : 0,
                        "Total number of entries skipped by cursor next calls" : 1,
                        "Total number of entries skipped by cursor prev calls" : 0,
                        "Total number of entries skipped to position the history store cursor" : 0,
                        "cursor next calls that skip due to a globally visible history store tombstone" : 0,
                        "cursor next calls that skip greater than or equal to 100 entries" : 0,
                        "cursor next calls that skip less than 100 entries" : 14,
                        "cursor prev calls that skip due to a globally visible history store tombstone" : 0,
                        "cursor prev calls that skip greater than or equal to 100 entries" : 0,
                        "cursor prev calls that skip less than 100 entries" : 1,
                        "open cursor count" : 0
                },
                "reconciliation" : {
                        "dictionary matches" : 0,
                        "internal page key bytes discarded using suffix compression" : 126,
                        "internal page multi-block writes" : 0,
                        "internal-page overflow keys" : 0,
                        "leaf page key bytes discarded using prefix compression" : 0,
                        "leaf page multi-block writes" : 5,
                        "leaf-page overflow keys" : 0,
                        "maximum blocks required for a page" : 1,
                        "overflow values written" : 0,
                        "page checksum matches" : 0,
                        "pages written including at least one prepare" : 0,
                        "pages written including at least one start timestamp" : 0,
                        "records written including a prepare" : 0,
                        "approximate byte size of timestamps in pages written" : 0,
                        "approximate byte size of transaction IDs in pages written" : 0,
                        "fast-path pages deleted" : 0,
                        "page reconciliation calls" : 20,
                        "page reconciliation calls for eviction" : 0,
                        "pages deleted" : 0,
                        "pages written including an aggregated newest start durable timestamp " : 0,
                        "pages written including an aggregated newest stop durable timestamp " : 0,
                        "pages written including an aggregated newest stop timestamp " : 0,
                        "pages written including an aggregated newest stop transaction ID" : 0,
                        "pages written including an aggregated newest transaction ID " : 0,
                        "pages written including an aggregated oldest start timestamp " : 0,
                        "pages written including an aggregated prepare" : 0,
                        "pages written including at least one start durable timestamp" : 0,
                        "pages written including at least one start transaction ID" : 0,
                        "pages written including at least one stop durable timestamp" : 0,
                        "pages written including at least one stop timestamp" : 0,
                        "pages written including at least one stop transaction ID" : 0,
                        "records written including a start durable timestamp" : 0,
                        "records written including a start timestamp" : 0,
                        "records written including a start transaction ID" : 0,
                        "records written including a stop durable timestamp" : 0,
                        "records written including a stop timestamp" : 0,
                        "records written including a stop transaction ID" : 0
                },
                "session" : {
                        "object compaction" : 0,
                        "tiered storage local retention time (secs)" : 0,
                        "tiered storage object size" : 0
                },
                "transaction" : {
                        "race to read prepared update retry" : 0,
                        "rollback to stable history store records with stop timestamps older than newer records" : 0,
                        "rollback to stable inconsistent checkpoint" : 0,
                        "rollback to stable keys removed" : 0,
                        "rollback to stable keys restored" : 0,
                        "rollback to stable restored tombstones from history store" : 0,
                        "rollback to stable restored updates from history store" : 0,
                        "rollback to stable sweeping history store keys" : 0,
                        "rollback to stable updates removed from history store" : 0,
                        "transaction checkpoints due to obsolete pages" : 0,
                        "update conflicts" : 0
                }
        },
        "nindexes" : 2,
        "indexBuilds" : [ ],
        "totalIndexSize" : 73728,
        "totalSize" : 34476032,
        "indexSizes" : {
                "_id_" : 36864,
                "files_id_1_n_1" : 36864
        },
        "scaleFactor" : 1,
        "ok" : 1
}
>
```
