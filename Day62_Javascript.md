# **JavaScript** 
​
JavaScript는 웹의 프로그래밍 언어이다
​
-   **Basic**
​
```
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 
    자바스크립트에서 사용하는 데이터 타입
    
    number
    string
    boolean
    function
    object
    undefined
    
 -->
<title>Insert title here</title>
<script type="text/javascript">
    var variable; // 변수선언
    var stringvar = "String"; // 변수선언 및 값 할당 -> 초기화 (새로운 값 할당)
    var numbervar = 273;
    var booleanvar = true;
    var functionvar = function (){}; // {code block}; , 익명함수
    var objectvar = {}; // {key:value};, json 형식
    
    /* // 각각의 값을 출력
    alert(variable);
    alert(stringvar);
    alert(numbervar);
    alert(booleanvar);
    alert(functionvar);
    alert(objectvar); */
    
    // 각각의 타입을 출력
    
    alert(typeof variable);
    alert(typeof stringvar);
    alert(typeof numbervar);
    alert(typeof booleanvar);
    alert(typeof functionvar);
    alert(typeof objectvar);
</script>
</head>
<body>
​
</body>
</html>
```
​
-   **window.onload() 함수와 복합연산자**
​
원칙상 자바스크립트의 document.getElementById("wrap").innerHTML = list; 가
​
html 내부 id의 wrap이란 태그가 생성되기 전에 실행 되면서 에러가 발생한다.
​
따라서 자바스크립트 문서를 html 뒤로 옮겨서 작성해야한다.
​
그러나 자바스크립트 아래쪽에 놓여있으면 가독성이 떨어지기 때문에 이러한 불편함을 해결하기 위해
​
문서앞에 선언해도 상관없게 하는 함수가 window.onload이다.
​
window.onload함수를 오버라이딩(재정의) 해주면 되는데 해당 함수 내의 코드 스크립트는 웹 브라우저 내의 모든 요소가 준비가 되어야 실행 될 수 있다.
​
```
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>onload() 함수와 복합연산자</title>
<script>
    /* 
        window.onload
        ::
        html 문서에 포함된 모든 컨텐츠가 메모리에 로드된 후에 실행되는 함수
        동일한 html 문에서 오직 하나만 사용되어야 한다.
    */
​
    window.onload = function(){
    var list = ''; // 지금은 값이 없지만, 이후 동적으로 데이터가 할당 
    
    
    list += '<ul>';
    list += '<li>hello</li>';
    list += '<li>JavaScript!</li>';
    list += '</ul>';
    
    // list변수안에 축적된 모든 내용을 div에 뿌린다
    document.getElementById("wrap").innerHTML = list;
        }
</script>
</head>
<body>
<h2>======== onload ======</h2>
<div id = "wrap"></div>
</body>
</html>
```
​
[##_Image|kage@pjlBu/btrdPINA6Ti/yRgtpjKIt7lnHfHse1yP21/img.png|alignCenter|data-origin-width="431" data-origin-height="159" data-ke-mobilestyle="widthOrigin"|||_##]
​
-   **$(document).ready()**  
    : ready() 함수는 HTML 이 준비가(로딩이) 완료되면 매개 변수로 전달된 함수를 실행하라는 명령어이고   
     셀렉터를 $(document) 와 같이 기술하여 웹 페이지 전체(document)를 대상으로 하고 있다. 
​
    -  $ 는  JQuery 문법
​
```
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JQuery :: ready()</title>
<script src="//code.jquery.com/jquery-3.2.1.min.js"></script>
<script>
​
    $(document).ready(function() {
    // window.onload 와 같은 기능    , 여러번 사용 가능
    
    var list = ''; // 지금은 값이 없지만, 이후 동적으로 데이터가 할당 
    
    
    list += '<ul>';
    list += '<li>hello</li>';
    list += '<li>JavaScript!</li>';
    list += '</ul>';
    
    
    document.getElementById("wrap").innerHTML = list;
    });
    
    $(document).ready(function() {
        alert("aaa");
    });
    $(document).ready(function() {
        alert("bbb");
    });
</script>
</head>
```
​
[##_Image|kage@bmvfvD/btrdOv80dFP/iMsKE51fo6kKUTjxw4bDV0/img.png|alignCenter|data-origin-width="987" data-origin-height="205" data-ke-mobilestyle="widthOrigin"|||_##][##_Image|kage@bbUSfP/btrdTSopGAq/CamGR4iqMHGr1IoJBWIMs0/img.png|alignCenter|data-origin-width="981" data-origin-height="190" data-ke-mobilestyle="widthOrigin"|||_##]
​
-   **fuction** 
​
   - 익명함수, 선언적 함수
​
```
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 
    자바스크립트 함수 선언 방법 2가지
    
    1) 익명함수 선언방법
      :: 함수의 형태를 갖고 있지만 특정한 이름을 갖고 있지 않음
         ex) var fuc = function(){...}
    2) 선언적 함수 선언방법
      :: 특정한 이름을 갖고 있는 함수 
         ex) function fuc(){...}
    
 -->
<script type="text/javascript">
var name = "James"; // 전역변수 :: 함수 선언 외부에있다.
​
// 선언적 함수선언
function showInfo(){
    var name = "Peter"; // 지역변수 :: 함수 정의 내부에 있다.
    console.log(name); //Peter
}
​
console.log(name); // James
showInfo(); //Peter
​
function showAge(){
    // age = 90; // var를 선언하지 않으면 전역변수로 지정한다
    let age = 90; // 지역변수
    console.log(age);
    /* es6 :: let(local), const(state, 상수), Arrow Function, grave Accent */
}
showAge();
//console.log(age);
​
</script>
</head>
<body>
​
</body>
</html>
```
​
[##_Image|kage@bhis0p/btrdVjFya0o/QdySin5XINdkJhkleTYhR1/img.png|alignCenter|data-origin-width="493" data-origin-height="215" data-ke-mobilestyle="widthOrigin"|||_##]
​
```
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript"> 
    /*  선언적 함수 선언
    
        함수를 선언적 함수 선언방식으로 작성하면
        이 부분은 미리 메모리에 올라가있다
        웹 브라우저는 script 태그 안 내용을 한 줄씩 실행한다.
        이때 info()를 호출해도 실행 상 에러가 안나는 이유는
        2--> 3--> 1 번의 순서로 결과적으로 수행된다. 
    */
    
    info(); // 앞에서 선언해야함 (1)
    
    function info(){ //(2)
        alert("func info() A");
/*      alert("undefined..." +greet); //undifi      
        var greet = "Hello Hosting~!"; */
}
    
    function info(){ //(3)
        alert("func info() B"); 
}
    
    
    
    
    
    // 익명함수 선언
    // anno(); --- 에러난다
    /*
        선언적 함수와 익명함수 선언은 결과적으로
        호출 순서가 완전히 다르다.
        이것만 기억하자!
    */
    var anno = function(){
        alert("annonymous A");
    }
    
    var anno = function(){
        alert("annonymous B");
    }
    anno();
    
    
</script>
</head>
<body>
​
</body>
</html>
```
​
[##_Image|kage@cigALE/btrdTSPsuKE/N9eixYVk0K2XQd8NdeZoG0/img.png|alignCenter|data-origin-width="879" data-origin-height="191" data-ke-mobilestyle="widthOrigin"|||_##][##_Image|kage@8J23B/btrdSeyuZIf/6zeqMkKWLKf26nTsXX8Q4K/img.png|alignCenter|data-origin-width="987" data-origin-height="239" data-ke-mobilestyle="widthOrigin"|||_##]
​
-   **두 함수의 차이점**
​
   - 선언적 함수 : 호이스팅으로 인하여 some 사용 후 some 선언을 하면 에러가 나야하지만 발생하지 않는다.
​
   - 익명함수 : 글로벌 영역에 먼저 함수가 할당되지 않기 때문에 함수를 호출하면 에러가 발생한다.
​
```
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
/*
    some을 선언하지 않고 바로 사용함으로써 에러가 발생해야 하지만
    에러가 발생하지 않는다.
    
    사실상 함수 최상단으로 var some 이 부분이 끌어올려지는 호이스팅이 작동된다.
    중요한 것은 값은 호이스팅 대상이 아니라는 것이다.
 */
​
    info();
    function info(){
        alert("정의되지 않은 변수"+some); //에러나지 않고 정상적인 출력 :: HOISTING원리!
        
        var some = "HELLO FUNCTION";
        alert("정의된 변수"+some);
    }
    
        
</script>
</head>
<body>
​
</body>
</html>
```
​
[##_Image|kage@ddAqWA/btrdUnOYZGn/4yR8UFXjJKJnjbc2URoT7K/img.png|alignCenter|data-origin-width="913" data-origin-height="201" data-ke-mobilestyle="widthOrigin"|||_##][##_Image|kage@CtHA2/btrdVjevRQg/DUX27nlKjvfvvb2RTdpeuk/img.png|alignCenter|data-origin-width="951" data-origin-height="207" data-ke-mobilestyle="widthOrigin"|||_##]
​
-   **재정의**
​
```
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>선언적 함수 재정의, 익명함수 재정의</title>
<script type="text/javascript">
​
    // 선언적 함수 재정의
    function calc(x,y){ //(1)
        return x+y;
    }
    console.log(calc(5,3)); //(3)
    
    
    function calc(x,y){ //(2)
        return x*y;
    }
    console.log(calc(5,3)); //(4)
    
    
    // 익명 함수 재정의
    
    var calc = function(x,y){
        return x+y;
    }
    console.log(calc(5,3)); //8
    
    var calc = function(x,y){
        return x*y;
    }
    console.log(calc(5,3)); //15
</script>
</head>
<body>
​
</body>
</html>
```
​
[##_Image|kage@vRZDu/btrdVOk2O62/YTT3VMSe3eHFi3jlLj5Nq1/img.png|alignCenter|data-origin-width="575" data-origin-height="260" data-ke-mobilestyle="widthOrigin"|||_##]
​
### **Event** 
​
```
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
​
// 선언적 함수 선언 :: 2개의 함수를 선언한다
​
function showData(){
    
    // ==== 1. 닉네임으로 입력한 값을 받아와서 변수에 할당하는 로직을 작성
    
    
    var nickName = document.LoginFrm.nick.value;
    // ===================   ↑ (전체 form name. input name . 값을 받아오는 value)   
    //alert(nickName+" , Hello~!");
    
    
    /*
     위의 alert 영역을 주석으로 막은 후 div영역에 붉은 글씨로 출력하기 
     getElementById()... innerHTML사용하기
    */
    document.getElementById("result").innerHTML 
            = "<h2><font color=red>"+nickName+", Hello~!</font></h2>"
    
    //=== clear zone
    document.LoginFrm.nick.value= "";
    //=== cursor zone
    document.LoginFrm.hobby.focus(); //.focus :: 접근제한자
    
    
    // ====== 이런식으로 변경해도 가능하다.
    //var frm = document.loginFrm.nick;
    //document.loginfrm.nick.value = "";
    //document.loginfrm.hobby.focus();
}
​
​
function showHobby(){
    // ==== 2. document 의 getElementById() 를 사용해서 접근하기
    
    var frm = document.getElementById("hobby");
    //alert(frm.value+" 가 취미시군요!!");
    
    
    document.getElementById("result").innerHTML 
            = "<h2><font color=blue>"+frm.value+", Hello~!</font></h2>"
    
    //=== clear zone
    frm.value="";
    //=== cursor zone
    document.LoginFrm.nick.focus();
    
    }
​
​
</script>
</head>
<body>
<form name="LoginFrm">
    NickName <input type="text" name="nick">
    <input type="button" value="닉네임보기" onclick="showData()"><br/><br/>
    Hobby <input type="text" name="hobby" id="hobby">
    <input type="button" value="취미보기" onclick="showHobby()"><br/><br/>
    
</form>
<!-- alert 영역 말고 div 영역 (화면)에 출력하기 -->
<div id="result"></div>
</body>
</html>
```
​
[##_Image|kage@cAUXDA/btrdU7kR742/84mkvXU5wkVntd3RHW2kp1/img.png|alignCenter|data-origin-width="449" data-origin-height="182" data-ke-mobilestyle="widthOrigin"|||_##][##_Image|kage@mDdnj/btrdZVsCZxN/6QT3jk0RQ3kl0b4Kwj0KI1/img.png|alignCenter|data-origin-width="446" data-origin-height="196" data-ke-mobilestyle="widthOrigin"|||_##]
​
-   **condition**
​
```
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
    function checkAge(){
/*
1. 입력된 나이가 19세 이상이면 "성인입니다 사이트 입장 가능하십니다 :)" 메세지를 alert 창으로 띄우고 
2. 19세 미만이면 "성인이 아닙니다 입장 불가입니다" 메세지를 alert 창으로 띄운다
    --> 위 작업 모두 진행한 후 입력박스의 값을 초기화 시키고, 커서는 다시 재위치 시킨다.
3. 만약 입력된 값이 없으면 "값을 입력하세요" 창을 띄우고
4. 숫자 대신 문자를 입력하는 유저들을 위해 "나이는 숫자로 입력" 이라는 메세지를 띄운다.
​
*/
    var age = document.ageFrm.age; //폼까지 잡아둔다.
    if(age.value==""){
        alert("나이를 입력하세요");
    }else if(isNaN(age.value)){ //문자 입력시
        alert("나이는 반드시 숫자로 입력하세요");
    }else if(age.value>=19){ //성인이라면
        alert("성인입니다 사이트 입장 가능합니다");
    }else{
        alert("미성년자입니다. 성인만 입장 가능합니다.")
    }
    
    age.value="";
    age.focus();
}
    
</script>
</head>
<body>
<form name="ageFrm">
    AGE <input type="text" name="age">
    <!-- 
    이벤트의 근원지 button :: Source라 한다
    발생하는 이벤트는 클릭 이벤트이다.
    
    마우스이벤트, 아이템이벤트, 키이벤트, 클릭이벤트 -- 이벤트 class
    
    -->
    <input type="button" value="CheckAge" onclick="checkAge()">
</form>
</body>
</html>
```
​
[##_Image|kage@n40eD/btrdQsQ5M3o/tzJUYeyUkJsaYU9NMpSQnk/img.png|alignCenter|data-origin-width="766" data-origin-height="212" data-ke-mobilestyle="widthOrigin"|||_##][##_Image|kage@85IAQ/btrdXx4qoji/7s0gSzIh9miF919QslQHXK/img.png|alignCenter|data-origin-width="790" data-origin-height="194" data-ke-mobilestyle="widthOrigin"|||_##][##_Image|kage@dhETHG/btrdVkkdv65/tb9pFh0Jq6L5PKUYubZ8SK/img.png|alignCenter|data-origin-width="781" data-origin-height="202" data-ke-mobilestyle="widthOrigin"|||_##]
​
-   **array**
​
```
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이상형찾기</title>
<script type="text/javascript">
    function choiceBoy(){
        var nick = document.frm.nick;
        //alert(nick);
        
        var arr = document.frm.boy;
        //alert(arr.length); // 배열로 리턴된다.
        
        var str ="";
        for(var i=0; i<arr.length; i++){
            if(arr[i].checked){ //arr[i]은 form, checked = checkbox가 선택 되었다면
                //alert(arr[i].value);
                str+=arr[i].value+" "; // 여기서 복합연산자 +=를 사용해야한다. +"" 해주는 이유는 띄워쓰기
            }
            arr[i].checked = false; //이후 check 해지
        }
        if(str=="") alert("이상형 한명은 꼭 선택해 주세요 :)")
        else alert("당신의 이상형은 "+str+"입니다");
    }
</script>
</head>
<body>
<form name ="frm">
    <strong>이상형을 고르세요 (중복선택 가능)</strong><br/><br/>
    NickName <input type="text" name="nick"><hr><br/><br/>
    <input type="checkbox" name="boy" value="김우빈">김우빈<br/>
    <input type="checkbox" name="boy" value="조승우">조승우<br/>
    <input type="checkbox" name="boy" value="서강준">서강준<br/>
    <input type="checkbox" name="boy" value="이병헌">이병헌<br/>
    <input type="checkbox" name="boy" value="원빈">원빈<br/>
    <input type="button" value="choice" onclick="choiceBoy()">
</form>
</body>
</html>
```
​
[##_Image|kage@bspGMB/btrd1PdIpJ5/npkFzc38tp0yriJVkZ0qm0/img.png|alignCenter|data-origin-width="767" data-origin-height="352" data-ke-mobilestyle="widthOrigin"|||_##][##_Image|kage@qf3Jv/btrd22Q9w2F/RClgSNapRprpRyHfPr00G1/img.png|alignCenter|data-origin-width="759" data-origin-height="334" data-ke-mobilestyle="widthOrigin"|||_##]
​
-   **select , onchange**
​
```
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
    function itemchange(){
        //alert("선택되었습니다")
        
        // === 선택한 지하철 노선이 있다면 alert으로 해당 노선을 출력
        
        var subway = document.getElementById("line");
        if(subway.value != null){ //선택한 노선이 있다면
            alert(subway.value + "호선을 선택하였습니다.")
            subway.value="";
        }
        
    }
</script>
</head>
<body>
<form name="form" id="form">
    <!-- 
        id = "line"   :: getElementById("line") 을 사용할 때
        name = "line" :: Domtree 의 Hierarchy(계층구조) 를 사용할 떄
        onclick = "item()" :: 하나만 클릭해도 사용된다. 즉 ---호선---을 눌렀을때도 사용되기에 부적절함.
        onchange = "itemchange()" :: item이 변경될 때마다 이벤트를 발생시켜야한다.
        
     -->
    <!-- <select id="line" name="line" onclick="item()"> -->
    <select id="line" name="line" onchange="itemchange()">
        <option value="">----호선----</option>
        <option value="1">1</option>
        <option value="2">2</option>
        <option value="3">3</option>
        <option value="4">4</option>
        <option value="5">5</option>
        <option value="6">6</option>
        <option value="7">7</option>
        <!-- value="7" 은 서버전송 , 7은 화면 출력되는 값 -->
    </select>
​
</form>
</body>
</html>
```
​
[##_Image|kage@d8iSn1/btrd1ywwunn/y1oZhhGlZQrAqin3nTVmOK/img.png|alignCenter|data-origin-width="107" data-origin-height="167" data-ke-mobilestyle="widthOrigin"|||_##][##_Image|kage@lHfnW/btrd3b8q7z5/kfCEojh0g0Q0BIK1z4aQq1/img.png|alignCenter|data-origin-width="102" data-origin-height="170" data-ke-mobilestyle="widthOrigin"|||_##][##_Image|kage@GHOTe/btrd0XQOwCI/c557fDXrHQy5iLTwEYa6k1/img.png|alignCenter|data-origin-width="731" data-origin-height="214" data-ke-mobilestyle="widthOrigin"|||_##]
​
-   **eval : 문자열을 계산하기 위한 eval함수**
​
```
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
    document.write(50+70+'<br>'); //120
    document.write('50+70'+'<br>'); // 50+70 이렇게 나온 문자열이 계산되어야 한다.
    
    // 문자열을 계산하기 위한 eval 함수
    document.write(eval('50+70')+'<br>');  
    document.write(eval('50.6+70')+'<br>');
    
    //형변환 함수 --> parseInt(), parsefloat()
    document.write(parseFloat('50.6')+parseInt('70')+'<br>');
</script>
</head>
<body>
​
</body>
</html>
```
​
[##_Image|kage@bmPQ9s/btrd5CSi8p2/yqJq8c2wc53yauFJVpTeK1/img.png|alignCenter|data-origin-width="257" data-origin-height="128" data-ke-mobilestyle="widthOrigin"|||_##]
​
---
​
## **동기, 비동기**
​
-   **동기(synchronous : 동시에 일어남)**  
    -   요청과 결과가 한 자리에서 동시에 일어남
    -   A노드와 B노드 사이의 작업 처리 단위(transaction)를 동시에 맞춤
    -   바로 요청과 동시에 시간이 얼마가 걸리던지 요청한 자리에서 결과가 주어져야 한다
​
-   **비동기(Asynchronous : 동시에 일어나지 않음)**
    -   요청한 그 자리에서 결과가 주어지지 않음
    -   노드 사이의 작업 처리 단위를 동시에 맞추지 않아도 됨
    -   요청과 동시에 결과가 동시에 일어나지 않음
​
```
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
    var xhr;
    
    // 서버로 요청하는 로직을 이 안에 담아낸다
    function startRequest(){
        
        //1. 탁구공을 생성 XMLHttpRequest
        xhr = new XMLHttpRequest();
        // alert(xhr); // 탁구공이 잘 만들어졌는지 확인! 
        
        //2. 응답받을 함수를 일단 지정해 놓는다. 추후 나중에 callback 시키겠다.
        xhr.onreadystatechange = callback;
        
        // 아래는 지금 서버를 호출하겠다
        // xhr.onreadystatechange = callback(); 
        
        
        //3. 서버의 어떤 페이지로 요청을 보내는지 지정한다. (get, post)
        xhr.open("get","CountServlet?id=encore&&pass=playdata") // 나중에 flask에서 route로 받으면된다.
        
        //4. 실제서버로 요청이 들어감
        xhr.send(null)//객체를담지않는다 = null
    }
    
    // 서버가 응답하면 그 내용을 여기서 받아서 리턴되는 데이터의 내용을 확인한 후 적절한 곳(span)에 뿌려준다
    function callback(){
        if(xhr.readyState==4){ //readyState 값이 4위치에 온다면
            if(xhr.status==200){ // 성공했을때 200 호출됨 (값은 서버시스템이 넣어줌)
                var text = xhr.responseText; //out.print()로 보내는 내용을 받는다.
                document.getElementById("resultView").innerHTML = "<h3>"+text+"</h3>";
            }
        }
    }
    
    /*
     xhr :: 비동기 기술은 브라우저에서 별도의 루틴을 타고 비정식적인 요청을 서버에 한다. 
     비동기 기술은 100% j.s 기술이다. 이것을 담은것이 xhr 이다.
     함수 :: onreadystate - callback, readystate - (0~4로 위치를 나타낸다)탁구공이 어디에있는지 알수있음, status, 
            opens()-url 지정, send()-요청전송
            responseText, responseXml 등
     
    */
</script>
</head>
<body>
<h2>Show Count Update</h2>
<input type="button" value ="CONUT 증가시키기" onclick="startRequest()">
<p></p> <!-- 공백을 많이 줄 수 있음 -->
<span id="resultView"></span>
</body>
</html>
```
​
\# CountServlet
​
```
package servlet.ajax;
​
import java.io.IOException;
import java.io.PrintWriter;
​
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
​
​
@WebServlet("/CountServlet")
public class CountServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
   
    private int count = 0;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String id = request.getParameter("id");
        String pass=  request.getParameter("pass");
        
        out.print(id+","+pass+"<br> Count :: "+ ++count);
    }
​
}
```
​
\# EncodingServlet
​
```
package servlet.ajax;
​
import java.io.IOException;
import java.io.PrintWriter;
​
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
​
​
@WebServlet("/EncodingServlet")
public class EncodingServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
​
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        
        String nick = request.getParameter("nickname");
        
        try {
            Thread.sleep(5000);
        }catch(InterruptedException e) {
            
        }
        
        out.print(nick);//응답이 이뤄지는 지점...
    }
​
}
```
​
[##_Image|kage@coghR0/btrd3ahy0pG/ypL8tMpaWmlqpwmXD0JRT1/img.png|alignCenter|data-origin-width="299" data-origin-height="128" data-ke-mobilestyle="widthOrigin"|||_##][##_Image|kage@oabW2/btrd1zI79R8/m2fxEyLIktv82JZSesEN3k/img.png|alignCenter|data-origin-width="302" data-origin-height="181" data-ke-mobilestyle="widthOrigin"|||_##]
