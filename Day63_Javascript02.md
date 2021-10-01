## **jQuery**
​
jQuery는 기능이 풍부한 JavaScript 라이브러리
​
HTML 문서 트래버설 및 조작, 이벤트 처리, 애니메이션 및 Ajax와 같은 작업을 여러 브라우저에서 쉽게 사용할 수 있는 API를 통해 훨씬 더 간단하게 수행할 수 있다.
​
### **다운로드 또는 설치 방법** 
​
**CDN 이용방법**
​
[https://jquery.com/download/](https://jquery.com/download/)
​
[##_Image|kage@RaIiX/btrd65AKBgX/1LgJcU0NjWrbF4teJQgN50/img.png|alignCenter|data-origin-width="755" data-origin-height="337" data-ke-mobilestyle="widthOrigin"|||_##][##_Image|kage@cGbcQl/btrd2wMHXtf/o4zs7vSSh59CCEGiskEAYK/img.png|alignCenter|data-origin-width="833" data-origin-height="145" data-ke-mobilestyle="widthOrigin"|||_##]
​
위의 url 접속 후 원하는 CDN 누른 후 위 코드를 복사 후 붙여넣기 하여 사용한다. (가장 상위 사용하는 것 추천)
​
---
​
-   **jQuery ready** 
​
```
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<!-- 
​
    jquery 는 javascript 이기 때문에 script 안에서 사용해야한다.
    html 은 순서대로 적용하는 파일 → 전체를 메모리에 업로드 시켜놓고 script를 실행해야 한다.
    
    1. javascript :: window.onload = function(){}
    2. jquery :: $(document).ready(function){}
    
 -->
<script type="text/javascript">
    // 1. $(document).ready(function(){});
    $(document).ready(function(){
        alert("jquery!")
    });
    
    
    // 2. jQuery(document).ready(function(){});
    jQuery(document).ready(function(){
        alert("jquery!")
    });
    
    
    // 3. jQuery(function(){});
    jQuery(function(){
        alert("jquery!")
    });
    
    
    // 4. $(function(){}); -- 가장 많이 사용됨 
    $(function(){
        alert("jquery!")
    });
    
    
</script>
</head>
<body>
<h2 id="header">What is jQuery?</h2>
<p class="content p1">jQuery is a fast, small, and feature-rich JavaScript library. It makes things like HTML document traversal and manipulation, event handling, animation, and Ajax much simpler with an easy-to-use API that works across a multitude of browsers. With a combination of versatility and extensibility, jQuery has changed the way that millions of people write JavaScript</p>
<p class="content p2">Call a local script on the server /api/getWeather with the query parameter zipcode=97201 and replace the element #weather-temp's html with the returned text.</p>
</body>
</html>
```
​
[##_Image|kage@b3si9A/btrd1fK3hiP/okQe0gh8L7FvxRWNmuKkAK/img.png|alignCenter|data-origin-width="998" data-origin-height="298" data-ke-mobilestyle="widthOrigin"|||_##]
​
```
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<!-- 
​
    jquery 는 javascript 이기 때문에 script 안에서 사용해야한다.
    html 은 순서대로 적용하는 파일 → 전체를 메모리에 업로드 시켜놓고 script를 실행해야 한다.
    
    1. javascript :: window.onload = function(){}
    2. jquery :: $(document).ready(function){}
    
 -->
<script type="text/javascript">
​
    // jquery 의 선택자 지정 
    $(function(){
        $('#header').css('color','red');
        $('.content').css('background','lightgray');
        $('.p2').css('color','green');
    });
​
​
</script>
</head>
<body>
<h2 id="header">What is jQuery?</h2>
<p class="content p1">jQuery is a fast, small, and feature-rich JavaScript library. It makes things like HTML document traversal and manipulation, event handling, animation, and Ajax much simpler with an easy-to-use API that works across a multitude of browsers. With a combination of versatility and extensibility, jQuery has changed the way that millions of people write JavaScript</p>
<p class="content p2">Call a local script on the server /api/getWeather with the query parameter zipcode=97201 and replace the element #weather-temp's html with the returned text.</p>
</body>
</html>
```
​
[##_Image|kage@vVq2j/btrea2pZZzD/94QzTN5Ux3ZhKcfQCNzozk/img.png|alignCenter|data-origin-width="1008" data-origin-height="203" data-ke-mobilestyle="widthOrigin"|||_##]
​
```
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
​
    // 메소드 중첩 또한 가능하다
    $(function(){
        $('#header').css('color','red');
        $('.content').css('background','lightgray').css('border','2px solid hotpink');
        $('.p2').css('color','green');
    });
    
    
</script>
</head>
<body>
<h2 id="header">What is jQuery?</h2>
<p class="content p1">jQuery is a fast, small, and feature-rich JavaScript library. It makes things like HTML document traversal and manipulation, event handling, animation, and Ajax much simpler with an easy-to-use API that works across a multitude of browsers. With a combination of versatility and extensibility, jQuery has changed the way that millions of people write JavaScript</p>
<p class="content p2">Call a local script on the server /api/getWeather with the query parameter zipcode=97201 and replace the element #weather-temp's html with the returned text.</p>
</body>
</html>
```
​
[##_Image|kage@IFYGT/btrd5kZieuX/dJo9HkohQxlx7irckv9Ua1/img.png|alignCenter|data-origin-width="1005" data-origin-height="195" data-ke-mobilestyle="widthOrigin"|||_##]
​
-   ****Template** 생성하기** 
​
**1\. 기본 틀 만들기** 
​
```
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
​
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
    $(function(){
        
    });
</script>
</head>
<body>
​
</body>
</html>
```
​
**2\. 전체를 copy 후 새로운 html 파일을 만들고** 
​
   **하단의 창에서 Next > 클릭 후  아래에 표시한 HTML\_Templates 클릭한다.** 
​
[##_Image|kage@sQN4v/btrd16tU3hZ/NkYRmSabWSnkHDLKzS0IB0/img.png|alignCenter|data-origin-width="537" data-origin-height="571" data-ke-mobilestyle="widthOrigin"|||_##][##_Image|kage@An21e/btrd9kxGtbq/aNKKAy0e5M4IKGkHKiJBjK/img.png|alignCenter|data-origin-width="544" data-origin-height="578" data-ke-mobilestyle="widthOrigin"|||_##]
​
**3\. New 버튼을 누른 후 하단과 같이 채워 넣는다 (pattern 에 코드 붙여넣기)**
​
[##_Image|kage@c8BZF8/btrd5jzi6bO/rRU6PQRWYfakAbmJ1WfUhk/img.png|alignCenter|data-origin-width="705" data-origin-height="586" data-ke-mobilestyle="widthOrigin"|||_##]
​
[##_Image|kage@bcTA5t/btrd03Leltd/M9G5hcNvzQkBfI32dSTZs0/img.png|alignCenter|data-origin-width="604" data-origin-height="485" data-ke-mobilestyle="widthOrigin"|혹시 위처럼 오류가 난다면 $표시 앞에 $를 한번 더 넣어주면 된다.||_##]
​
[##_Image|kage@kA2B5/btrd5j0ohwE/DF7ltaaCLRWnnOXtD3uk30/img.png|alignCenter|data-origin-width="604" data-origin-height="485" data-ke-mobilestyle="widthOrigin"|||_##]
​
**4\. OK 를 누르고 아래 나의 탬플릿이 추가된 것을 확인한다. 후에 Apply , close 클릭**
​
[##_Image|kage@KzFDv/btrd5Dc7OLP/MUYLDUX2MNfLWz3Q4I0tRk/img.png|alignCenter|data-origin-width="705" data-origin-height="586" data-ke-mobilestyle="widthOrigin"|||_##]
​
**5\. 내가 만든 템플릿이 가장 위에온 것을 확인 한 후 선택 후 Finish 한다.**
​
   **앞으로 만들어지는 모든 html은 아래와 같은 Template 이다.** 
​
[##_Image|kage@boYHsN/btrd9lXHpkg/tHEkbGzd1k2HBKZwsh8CJk/img.png|alignCenter|data-origin-width="537" data-origin-height="571" data-ke-mobilestyle="widthOrigin"|||_##][##_Image|kage@bqXTXy/btrd16tVrgY/E9TjX7Hf7H2YGO5Rdzn90k/img.png|alignCenter|data-origin-width="760" data-origin-height="370" data-ke-mobilestyle="widthOrigin"|||_##]
​
### **함수**
​
**val () :: form값 핸들링 할때 꼭 받아야함 , javascrip 의 value 와 같다**
​
**text() , html() :: form 값 아님**
​
**addClass()**
​
**setTimeout() :: 한번만 실행**
​
**setInterval() :: 지속적으로 실행**
​
**each()**
​
**append()  :: 태그에 내용을 부착**
​
**appendTo() :: 내용에 태그를 부착**
​
**before()**
​
**prepend()**
​
**after()**
​
**bind() :: 여러개의 이벤트를 한번에 묶음 , ('click', function(){}); 원리차이= click(function(){});**
​
-   **선택자 Selector**
​
```
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Jquery로 선택자 지정하는 방법</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
    $(function(){
        //1. h2, p 태그를 한꺼번에 모두 선택자로 지정, css 함수를 이용해서 글자 색을 오렌지color로 적용
        // $('태그이름, 태그이름').css('속성이름', 속성값);
        $('h2,p').css('color','orange');
        
        //2. div 태그의 후손들을 선택자로 지정, 글자색은 red
        $('div p').css('color','red');
        
        //3. div 태그의 직계자식을 선택자로 지정, 글자색은 green
        $('div>p').css('color','green');
        
        
        
        //4. p태그중 첫번째 p태그를 선택자로 지정, 배경색을 gray
        //4-1)
        //$('p:first').css('background','gray');
    
        //4-2)
        //$('p').first().css('background','gray');
        
        //4-3) eq(0) :: 0번째를 의미한다. -- 효율성이 가장 높음
        $('p:eq(0)').first().css('background','gray');
        
        
        
        //5. p태그중 마지막 p태그를 선택자로 지정, 배경색을 gray
        //5-1)
        //$('p:last').css('background','gray');
        
        //5-2)
        //$('p').last().css('background','gray');
        
        //5-3)
        $('p:eq(2)').css('background','gray');
        
        /*=== 맨 첫번째 (first) 맨 마지막(last) 만 선택지정자 가능하다 ===*/
        
        //6. class 속성에 대한 쓰임새
        $('.content').css('color','blue');
        
        //7. p태그의 class 속성값이 p2인 선택자를 지정 글자색을 magenta로 변경
        $('p.p2').css('color','magenta');
        
    });
</script>
</head>
<body>
<h2 id="header">What is jQuery?</h2>
<p class="content p1">jQuery is a fast, small, and feature-rich JavaScript library. It makes things like HTML document traversal and manipulation, event handling, animation, and Ajax much simpler with an easy-to-use API that works across a multitude of browsers. With a combination of versatility and extensibility, jQuery has changed the way that millions of people write JavaScript</p>
<p class="content p2">Call a local script on the server /api/getWeather with the query parameter zipcode=97201 and replace the element #weather-temp's html with the returned text.</p>
<div>
    <p class="content">Call a local script on the server /api/getWeather with the query parameter zipcode=97201 and replace the element #weather-temp's html with the returned text.</p>
</div>
</body>
</html>
```
​
[##_Image|kage@H1og6/btrd3b2BTDy/8YlO3aJwo0cIg4dxnFckX1/img.png|alignCenter|data-origin-width="874" data-origin-height="273" data-ke-mobilestyle="widthOrigin"|1. 화면||_##]
​
[##_Image|kage@9dNFu/btrd9kR0xOz/ZSH7tRg1cg3orhi9T5gMx0/img.png|alignCenter|data-origin-width="1001" data-origin-height="269" data-ke-mobilestyle="widthOrigin"|2. 화면||_##]
​
[##_Image|kage@DOsZV/btrd15u1Jps/dR0kJkVVykepIdDFRV4brk/img.png|alignCenter|data-origin-width="998" data-origin-height="287" data-ke-mobilestyle="widthOrigin"|3. 화면||_##]
​
[##_Image|kage@bjV4rP/btrd3b2B1hb/xFskLYPESQBjuWXRGs9Yvk/img.png|alignCenter|data-origin-width="1009" data-origin-height="248" data-ke-mobilestyle="widthOrigin"|4. 화면||_##]
​
[##_Image|kage@9QQLZ/btrd2w0fPcV/k1RXsOhS7FlJkrZvYvKMvK/img.png|alignCenter|data-origin-width="1008" data-origin-height="247" data-ke-mobilestyle="widthOrigin"|5. 화면||_##]
​
[##_Image|kage@TMTx4/btrd1f5msOa/doeZKljve005Lf5TSmCVq0/img.png|alignCenter|data-origin-width="1010" data-origin-height="241" data-ke-mobilestyle="widthOrigin"|&nbsp;6. 화면||_##]
​
[##_Image|kage@oiuNk/btrd0XcPl91/k5oaYQ32rGMLSW2otTt65k/img.png|alignCenter|data-origin-width="1007" data-origin-height="236" data-ke-mobilestyle="widthOrigin"|7. 화면||_##]
​
```
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
    $(function(){
        //1. input 태그의 속성이름 type, 속성값 text를 선택자로 지정
        // ==== jQuery :: val()함수를 사용해 form에 값을 넣음, form형식에만 적용되며 값을 받아오거나 넣을때 사용
        // ==== javascript :: value()
        
        //1-1)
        //$('input[type=text]').val("hello Jquery!");
    
        //1-2-1)
        //$('input:text').val("hello Jquery!!"); //전체 form 에 모두 입력됨
        
        //1-2-2)
        //$(':text').val("hello Jquery!!"); //전체 form 에 모두 입력됨
        
        
        
        //2. input 태그의 속성 이름이 name이고 속성값에 '한국' 이라는 값이 포함된 선택자를 지정, 배경색을 yellow
        $('input[name*=한국]').css('background','yellow');
        
        
        //3. 속성 값이 사람으로 끝나는 선택자를 지정 글자색을 red
        $('input[value$=사람]').css('color','red');
        
        //4. 속성값이 KO로 시작하는 선택자를 지정 , 글자색을 blue
        $('input[value^=KO]').css('color','blue');
        
        
    });
</script>
</head>
<body>
<h3> 폼 속성 선택자 사용법</h3>
<input type="text">
    <input name="한국" value="한국">
    <input name="한국인" value="한국인">
    <input name="한국 민" value="한국 민">
    <input name="대 한국 민" value="대 한국 민">
<br/><hr><br/>
    <input id="한국" value="한국사람">
    <input id="한국인" value="KO한국인">
    <input id="한국 민" value="한국 민">
    <input id="대 한국 민" value="대 한국 민">
</body>
</html>
```
​
[##_Image|kage@PQ8GY/btrd15V6S6U/rKkmEYZt0JMaSk8xmkiNO0/img.png|alignCenter|data-origin-width="923" data-origin-height="162" data-ke-mobilestyle="widthOrigin"|1-1 화면||_##]
​
[##_Image|kage@qezCQ/btrd1zpCrrB/NK6y9cv5Zf2Z7dPY9njWC1/img.png|alignCenter|data-origin-width="927" data-origin-height="153" data-ke-mobilestyle="widthOrigin"|1-2 화면||_##]
​
[##_Image|kage@sqOVA/btrd1xFouP6/KebCPGVx8jLGpgQApZ99hK/img.png|alignCenter|data-origin-width="915" data-origin-height="144" data-ke-mobilestyle="widthOrigin"|2. 화면||_##]
​
[##_Image|kage@tG8S2/btrd15IwVBg/DKoZCVU28GdQdNkBbl4SK0/img.png|alignCenter|data-origin-width="922" data-origin-height="153" data-ke-mobilestyle="widthOrigin"|3. 화면||_##]
​
[##_Image|kage@JHEcY/btrd14pnOwi/OvIE6oDfNtAyYy26RJaTIK/img.png|alignCenter|data-origin-width="923" data-origin-height="150" data-ke-mobilestyle="widthOrigin"|4. 화면||_##]
​
-   **addClass : class 값 지정, css와 jquery를 완벽하게 분리시킨다.**
​
```
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
    .totalColor{color:orange;}
    .divP{color:red;}
    .divDP{color:green;}
    .firstP{background-color: gray;}
    .lastP{background-color:gray;}
    .content{color:blue;}
    .pp2{color:magenta;} 
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
    $(function(){
        // 아래에서 지정된 선태자에 css속성을 추가한다 .. addClass()를 이용한다.
        // css와 jquery를 완벽하게 분리시킨다.
        
        $('h2,p').addClass('totalColor');
        $('div p').addClass('divP');
        $('div>p').addClass('divDP');
        $('p:eq(0)').addClass('firstP');
        $('p:eq(2)').addClass('lastP');
        $('.content').addClass('content');
        $('p.p2').addClass('pp2');
        
        var h2 = $('h2').html(); //innerHTML ___ JS
        alert(h2);
        
        /* 중요한 함수 :: var (), text(), html(), innerHTML(), addClass() */
    });
</script>
</head>
<body>
<h2 id="header">What is jQuery?</h2>
<p class="content p1">jQuery is a fast, small, and feature-rich JavaScript library. It makes things like HTML document traversal and manipulation, event handling, animation, and Ajax much simpler with an easy-to-use API that works across a multitude of browsers. With a combination of versatility and extensibility, jQuery has changed the way that millions of people write JavaScript</p>
<p class="content p2">Call a local script on the server /api/getWeather with the query parameter zipcode=97201 and replace the element #weather-temp's html with the returned text.</p>
<div>
    <p class="content">Call a local script on the server /api/getWeather with the query parameter zipcode=97201 and replace the element #weather-temp's html with the returned text.</p>
</div>
</body>
</html>
```
​
[##_Image|kage@xuZ60/btreh1Sjptm/yfqhkXJAenFMxrIaQGvBlk/img.png|alignCenter|data-origin-width="1012" data-origin-height="262" data-ke-mobilestyle="widthOrigin"|||_##]
​
-   **filter**
​
```
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>filter() :: 걸러내는 기능</title>
<style type="text/css">
    .css{ background: greenyellow; color: whilte;}
    .redColor{color: red;}
    .blueColor{color: blue;}
</style>
    
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
    $(function(){
        //filter 함수는 동일한 태그들이 있을 때 여러개의 태그중에서 특정 조건에 부합하는 태그들을 걸러낼 때 사용한다.
        
        //1. 중첩 :: css().css() -> css({}) -> addClass() 로 점차 효율적!
        $('h1').filter(function(index) {
            return index % 3==0 || index % 5==0;
        
        // 1-1) 
/*      }).css({
            background : 'greenyellow',
            color:'white' 
        }); 
            */
            
        // 1-2)
        }).addClass('css');
        
        
        
        //2.
        // h1 태그 중에서 짝수번째 태그만 걸러서 글자색을 red : ': even'
        // h1 태그 중에서 홀수번째 태그만 걸러서 글자색을 blue : ': odd'
        $('h1').filter(':even').addClass('redColor');
        $('h1').filter(':odd').addClass('blueColor');
        
         
    });//ready
    
</script>
</head>
<body>
    <h1>Item - 0</h1>
    <h1>Item - 1</h1>
    <h1>Item - 2</h1>
    <h1>Item - 3</h1>
    <h1>Item - 4</h1>
    <h1>Item - 5</h1>
    <h1>Item - 6</h1>
</body>
</html>
```
​
[##_Image|kage@D5cL8/btreg3JR25i/JEq9S7dTxHqBpfPkU4FYQk/img.png|alignCenter|data-origin-width="950" data-origin-height="460" data-ke-mobilestyle="widthOrigin"|||_##]
​
-   **setTimeout**
​
```
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
​
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
    $(function(){
        // 1. select 폼에서 선택한 값을 변수로 name에 할당
        /* var name = $('select>option').val();
        alert(name); */
        
        
        
/*      // 2. 일정한 시간 뒤에 코드블럭이 동작하도록 로직을 수정 === setTimeout()
        setTimeout(function () {
            // code block 3초뒤에 시작 
            var name = $('select>option:selected').val(); // 선택된 값 출력
            alert(name);
        }, 3000); //3초  */
        
        
        
        // 3. 5초뒤에 select 폼에서 선택된 연예인이 아래 Textfiled 출력되도록 로직을 완성
        setTimeout(function () {
            // code block 3초뒤에 시작 
            var name = $('select>option:selected').val(); // 선택된 값 출력
            $('input[type=text]').val(name);
        }, 5000); // 
    });
    
    
</script>
</head>
<body>
    <select>
        <option>===선택===</option>
        <option>김우빈</option>
        <option>조정석</option>
        <option>박서준</option>
        <option>정해인</option>
    </select><br/><br/>
    
    선택한 연예인은 <input type="text" name="resultView" size="16">
</body>
</html>
```
​
[##_Image|kage@evixsm/btrec3DCJgI/1a50jbLxDT6rK9qUOZA0b1/img.png|alignCenter|data-origin-width="362" data-origin-height="136" data-ke-mobilestyle="widthOrigin"|||_##]
​
[##_Image|kage@bECIUS/btreg3QBXnY/aKkcYPvKKlbeBEQFrlDpM0/img.png|alignCenter|data-origin-width="334" data-origin-height="130" data-ke-mobilestyle="widthOrigin"|||_##]
​
-   **val**
​
```
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
​
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
    $(function(){
        // 각각의 입력 폼을 선택자로 지정
        $('input[name=userName]').val('James');
        $('input[name=userAddr]').val('Texas');
    });
</script>
</head>
<body>
<form action="jq04_result.jsp" method="get"> <!-- 404뜨면 jsp 서버 만들어 줘야함! -->
    NAME <input type="text" name="userName"><br/><br/>
    ADDR <input type="text" name="userAddr"><br/><br/>
    <input type="submit" value="SendData">
</form>
</body>
</html>
```
​
```
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<strong>폼에 입력된 정보를 출력합니다</strong><br/>
UserName :: ${param.userName}<br/>
UserAddr :: ${param.userAddr}<br/>
</body>
</html>
```
​
[##_Image|kage@dWZpk5/btrd9k61ieL/eGulytzvtRzNGGegRe0djK/img.png|alignCenter|data-origin-width="368" data-origin-height="141" data-ke-mobilestyle="widthOrigin"|||_##][##_Image|kage@EPocf/btrea10nBTh/pL2eZcSoONEsgtLni5kLoK/img.png|alignCenter|data-origin-width="367" data-origin-height="86" data-ke-mobilestyle="widthOrigin"|||_##]
​
-   **each**
​
```
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
    .high_light_0{background-color: #7b14ff;}
    .high_light_1{background-color: #ad97ec;}
    .high_light_2{background-color: #b1afe7;}
    .high_light_3{background-color: #ccdfff;}
    .high_light_4{background-color: #f6e7ea;}
    .high_light_5{background-color: #ffb6c1;}
    .high_light_6{background-color: #ffe4e1;}
    .high_light_7{background-color: #ffdab9;}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
    /*
        each :: 일종의 for문과 동일한 기능
        동일한 태그가 반복적으로 나왔을 때 사용한다. 
        작동방식은 동일한 태그의 갯수만큼(h1 .. 8개)
        each() 함수가 8번 호출된다 (내부적으로)
        => 내부적으로 index 가동되어진다.
        첫번째 index는 당연히 0으로 시작
    */
    $(function(){
        $('h1').each(function(index) { // 0~7
            $(this).addClass('high_light_'+index);
        });
    });
</script>
</head>
<body>
    <h1>Item - 0</h1>
    <h1>Item - 1</h1>
    <h1>Item - 2</h1>
    <h1>Item - 3</h1>
    <h1>Item - 4</h1>
    <h1>Item - 5</h1>
    <h1>Item - 6</h1>
    <h1>Item - 7</h1>
</body>
</html>
```
​
[##_Image|kage@IiH44/btree5BbsDL/SomAJzJa8lufEizGKVK5qk/img.png|alignCenter|data-origin-width="941" data-origin-height="513" data-ke-mobilestyle="widthOrigin"|||_##]
​
-   **append**
​
```
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
    .star{border:3px solid black; width:200px; height:240px;}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
    $(function(){
        //1. 이미지들에 style을 적용한다.
        $('img').addClass('star');
        
        
        
        //2. append() 를 이용해서 3초 뒤에 맨 첫번째 이미지가 맨 뒤로 가도록 작성
        //   setTimeout():: 단 한번만 호출된다.
        setTimeout(() => { //=> arrow 함수
            //$('body').append($('img:first'));
            $('body').append($('img:eq(0)'));
        }, 3000); 
        
        
        
        //3. 계속적으로 첫번째 이미지를 뒤로 보내려면 :: setInterval()
        //   특정한 간격을 기준으로 계속 호출되는 함수
        /*
        append() :: 태그에 내용을 부착
        appendTo() :: 내용에 태그를 부착
        
        */
         setInterval(() => {
            //$('body').append($('img:eq(0)'));
            $('body').appendTo($('img:eq(0)'));
        }, 1000);
    });
</script>
</head>
<body>
<img alt="" src="../image/1.jpg">
<img alt="" src="../image/2.jpg">
<img alt="" src="../image/3.jpg">
<img alt="" src="../image/4.jpg">
</body>
</html>
```
​
[##_Image|kage@bdRH5U/btrelR2vqs6/LsIiX96WLByoqVRBoorcWk/img.png|alignCenter|data-origin-width="853" data-origin-height="255" data-ke-mobilestyle="widthOrigin"|||_##][##_Image|kage@bbTtkp/btrejVRC7bx/7dKbjPAXYUJ7dksl4Oirlk/img.png|alignCenter|data-origin-width="833" data-origin-height="253" data-ke-mobilestyle="widthOrigin"|||_##]
​
```
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
    body{
        padding:50px;
    }
    div{
        border:2px solid #bbb;
        padding:10px;
        margin:10px auto;
        background-color:#eee;
    }
    span{
        display:block;
        width:65px;
        font:bold 12px Arial;
        color:white;
        background-color: black;
        padding: 5px 10px;
    }
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
    $(function(){
        //$('div').html('<span>1. Append </spand>'); // 뿌린다 (덮어씌워짐)
        //$('div').append('<span>1. Append </spand>'); // 뒤에 붙는다
        $('div')
        .append('<span> 1. Append </spand>') // 줄바꿈이 안되고 뒤에 붙음
        .after('<span>2. after </spand>') // blocking 이됨, 줄바꿈 된 후 뒤에 붙음
        .prepend('<span>3. prepend </spand>') // 줄바꿈이 안되고 앞에 붙음
        .before('<span>4. before </spand>') // blocking 이됨, 줄바꿈 된 후 앞에 붙음
    });
</script>
</head>
<body>
    <div>
    The .append() and .appendTo() methods perform the same task. 
    The major difference is in the syntax-specifically, 
    in the placement of the content and target. 
    With .append(), the selector expression preceding the method is the container into which the content is inserted. 
    With .appendTo(), on the other hand, the content precedes the method, 
    either as a selector expression or as markup created on the fly, 
    and it is inserted into the target container.
    </div>
</body>
</html>
```
​
[##_Image|kage@beqsBM/btrehFIz9ko/fGKElEKEgvXVvxULmXaEUk/img.png|alignCenter|data-origin-width="883" data-origin-height="88" data-ke-mobilestyle="widthOrigin"|$('div').html('&lt;span&gt;1. Append &lt;/spand&gt;');||_##]
​
[##_Image|kage@PctdW/btrea1TF3dF/YYvvUhR1FK7PgiIoa6xsWk/img.png|alignCenter|data-origin-width="868" data-origin-height="114" data-ke-mobilestyle="widthOrigin"|$('div').append('&lt;span&gt;1. Append &lt;/spand&gt;');||_##]
​
[##_Image|kage@ba1tzt/btrea2rsFY5/2LNJATMk8yt8yw2ms5EdG1/img.png|alignCenter|data-origin-width="878" data-origin-height="187" data-ke-mobilestyle="widthOrigin"|append, after, prepend, before||_##][##_Image|kage@vI7GY/btred1L9kcV/q0DKWdLbzJxUYInOC3Iye1/img.png|alignCenter|data-origin-width="882" data-origin-height="238" data-ke-mobilestyle="widthOrigin"|append, after, prepend, before||_##]
​
```
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
    .star{border:2px solid black; width:200px; height:240px;}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
    $(function(){
        $('body').append('<h2>Happy Day~!!</h2>');
        $('h2').before('<font color=red>오늘은 금요일</font>');
        
        //이미지를 변수로 만들어 놓는다.
        var img1 = '<img src=../image/1.jpg>';
        var img2 = '<img src=../image/2.jpg>';
        var img3 = '<img src=../image/3.jpg>';
        
        var h1 = '<h1>싱어게인 TOP3</h1>'
        
        //1. BODY 태그에 H1 제목과 이미지 3개를 모두 부착한다 .. 열거형(, , , )
        $('body').append(h1, img1, img2, img3);
        $('img').addClass('star');
    });
</script>
</head>
<body>
​
</body>
</html>
```
​
[##_Image|kage@dAjAFQ/btrec5uKycb/BwAayfur3d7KDNGTra1Vk0/img.png|alignCenter|data-origin-width="555" data-origin-height="363" data-ke-mobilestyle="widthOrigin"|||_##]
​
-   **bind()**
​
```
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bind() :: 이벤트를 묶는기능 :: 클릭이벤트</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
    $(function(){
        
        // 1. bind() 함수
        $('h2').bind('click', function () { // 클릭이벤트 함수
            //$('h2:eq(0)').html('hello'); // 실용적이지 않음, 모든 h2를 클릭하기 위해서는!
            // click, 이벤트가 적용된 h2태그 자기자신 --> $(this)
            $(this).html('HELLO!');
        });
        
        
        
        // 2. click()
        $('h2').click(function () { // 클릭이벤트 함수
            // click, 이벤트가 적용된 h2태그 자기자신 --> $(this)
            $(this).html('HELLO!');
        });
        
        
        
        // 3. append() :: 변경하지 않고 문장 뒤에 ★ 출력
        $('h2').click(function () { // 클릭이벤트 함수
            // click, 이벤트가 적용된 h2태그 자기자신 --> $(this)
            $(this).append('★');
        });
        
        
        
​
        // 4. html() 함수를 이용해서 3번과 동일한 결과 출력 
        $('h2').click(function () { // 클릭이벤트 함수
            $(this).html(function(index,html) {
                return html+'★';
        });
​
        
        
        // 5. switch 문 이용해서 각 문장의 뒤에 출력
        $('h2').click(function () { 
            $('h2').html(function(index,html) {
                switch(index){
                case 0: return html+'★';
                case 1: return html+'●';
                case 2: return html+'♥';
            }
            });
        });
    });
</script>
</head>
<body>
    <h2>jQuery is a fast, small, and feature-rich JavaScript library.</h2>
    <h2>jQuery is a fast, small, and feature-rich JavaScript library.</h2>
    <h2>jQuery is a fast, small, and feature-rich JavaScript library.</h2>
</body>
</html>
```
​
[##_Image|kage@Ja4Yn/btrd5EEekul/jgjjEChrA11mqI9R8oUpk1/img.png|alignCenter|data-origin-width="597" data-origin-height="136" data-ke-mobilestyle="widthOrigin"|세 문장을 각각 클릭하게 되면||_##][##_Image|kage@cI8oqQ/btreia2D55l/Bcb0nmk75ppo81ndRMV7D1/img.png|alignCenter|width="641" height="154" data-origin-width="691" data-origin-height="166" data-ke-mobilestyle="widthOrigin"|2. HELLO! 가 출력된다||_##][##_Image|kage@ywANQ/btrehCkYcHO/XISaCbC0RPnCpPAOkQm0x0/img.png|alignCenter|data-origin-width="641" data-origin-height="139" data-ke-mobilestyle="widthOrigin"|3. 4 첫 문장을 두번 클릭한 상태&nbsp;||_##]
​
[##_Image|kage@lU6mh/btrd9ksqBT7/H5CFKR17DeaMkMPlzVTzz1/img.png|alignCenter|data-origin-width="669" data-origin-height="141" data-ke-mobilestyle="widthOrigin"|5. 문장 3번 클릭||_##]
