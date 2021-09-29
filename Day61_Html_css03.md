## **Overflow**
​
CSS 오버플로 속성은 너무 커서 영역에 맞지 않는 콘텐츠의 동작을 제어한다.
​
**Overflow 속성**
​
-   visible \- Default. The overflow is not clipped. 내용이 요소의 상자 외부로 렌더링됨
-   hidden \- Overflow가 잘리고 나머지 컨텐츠는 표시되지 않는다.
-   scroll \- Overflow가 잘리고 스크롤 막대가 추가되어 나머지 내용을 확인한다.
-   auto \- 스크롤과 유사하지만 필요한 경우에만 스크롤 막대를 추가한다.
​
```
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
    /* 공통적인 속성 */
    .box{
        /* 정사각형 */
        width:150px; 
        height:150px;
        background: #cccccc;
        /* 가로로 나란히 정렬 및 공간 주기 */
        float:left;
        margin-right: 10px;
    }
    
    /* box를 각각의 특성주기*/
    .vi{ overflow: visible;}
    .hi{ overflow: hidden;}
    .sc{ overflow: scroll;}
    .au{ overflow: auto;}
    
    div.vi>h3{color: red;} /* 직계자손 */
    .vi h3 {color:red;}/* 직계자식이 아닌 후손의 개념 , 직계와 후손 모두다 적용 */
    
</style>
</head>
​
<!-- 
    공통적인 속성 지정 :: class 사용 
    차별적인 속성 지정 :: vi, hi, sc, au 같은 선택자를 사용
-->
<body>
    <div class="box vi">
      <h3>visible</h3>
      <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean nec mollis nulla. Phasellus lacinia tempus mauris eu laoreet.</p>
    </div>
    <div class="box hi">
      <h3>hidden</h3>
      <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean nec mollis nulla. Phasellus lacinia tempus mauris eu laoreet.</p>
    </div>
    <div class="box sc">
      <h3>scroll</h3>
      <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean nec mollis nulla. Phasellus lacinia tempus mauris eu laoreet.</p>
    </div>
    <div class="box au">
      <h3>auto</h3>
      <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean nec mollis nulla. Phasellus lacinia tempus mauris eu laoreet.</p>
    </div>
    
     <div class="box vi">
      <h3>visible</h3>
      <div>
        <h3>후손입니다</h3>
      </div>
      <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean nec mollis nulla. Phasellus lacinia tempus mauris eu laoreet.</p>
    </div>
    
</body>
</html>
```
​
[##_Image|kage@F1HK5/btrdINnL4lF/AwQGLvrv5ubmuHoJS689kk/img.png|alignCenter|data-origin-width="678" data-origin-height="269" data-ke-mobilestyle="widthOrigin"|||_##]
​
-   상위 태그에 묶여있는 <div>
​
div 태그의 자식요소(a 태그)에서 float 속성 사용시 부모 요소의 범위를 벗어나게 된다.  
1. 부모 요소 범위를 크게 잡아 버린다.  
2. 이럴때 해결책은 overflow:hidden을 준다 → 부모 요소에 지정해버린다.
​
```
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
    #wrap{
        border:1px solid black;
        padding:10px;
        overflow:hidden;
    }
    #a{
        border: 1px solid red;
        margin: 0px;
        /* 
        div 태그의 자식요소(a태그)에서 float 속성 사용시
        부모요소의 범위를 벗어나게 된다.
            1. 부모 요소 범위를 크게 잡아 버린다.
            2. 이럴때 해결책은 overflow:hidden을 준다 --> 부모 요소에 지정해버린다.
        */
        float:left;
    }
    
    #b{
        border: 1px solid green;
        margin: 0px;
        float:left;
    }
</style>
</head>
<body>
<!-- 상위 태그에 묶여있는 div -->
<div id="wrap">
    <div id="a">
    hyeri
    </div>
</div>
    
<div id="b">
    Hello
</div>
​
</body>
</html>
```
​
[##_Image|kage@big3kh/btrdOxqnSsX/PuZlN0Tr1D62TzmKNKEE9k/img.png|alignCenter|data-origin-width="696" data-origin-height="65" data-ke-mobilestyle="widthOrigin"|hidden 주기 전||_##][##_Image|kage@SSAya/btrdImxlkri/OkhS5O7OzGzsKYnQfdSfO0/img.png|alignCenter|data-origin-width="693" data-origin-height="67" data-ke-mobilestyle="widthOrigin"|hidden 준 후||_##]
​
# **Box Model**
​
CSS에서 "Box Model"이라는 용어는 디자인과 레이아웃을 말할 때 사용된다.  
Box Model은 기본적으로 모든 HTML 요소를 감싸는 상자이다.
​
Margin, Border, Padding(content와 padding사이) 및 Content으로 구성된다.
​
[##_Image|kage@cOWIzs/btrdOwZrDzw/B8FnRJolxzBxQMScKbhp60/img.png|alignCenter|data-origin-width="1113" data-origin-height="410" width="726" height="268" data-ke-mobilestyle="widthOrigin"|||_##]
​
**BoxModel 구성**
​
-   **Content** \- 텍스트 및 이미지가 나타나는 상자의 내용
-   **Padding** \- Padding은 보이지 않는다.
-   **Border** \- Padding 및 Content을 순환하는 테두리
-   **Margin** \- Margin은 보이지 않는다. (BoxModel 에는 포함되지 않는다)
​
출처 : [https://www.w3schools.com/css/css\_boxmodel.asp](https://www.w3schools.com/css/css_boxmodel.asp)
​
 [CSS Box Model
​
CSS Box Model All HTML elements can be considered as boxes. The CSS Box Model In CSS, the term "box model" is used when talking about design and layout. The CSS box model is essentially a box that wraps around every HTML element. It consists of: margins, b
​
www.w3schools.com](https://www.w3schools.com/css/css_boxmodel.asp)
​
 content-box :: width, height 속성값은 content 영역을 의미한다. (기본값)  
 border-box :: width, height 속성값은 content, padding, border 가 모두 포함된 영역을 의미한다.
​
```
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
/*
     width, height 속성(property)은 요소의(content)의 사이즈를 저장하는 속성
     즉 가로, 세로 사이즈는 컨텐츠 영역을 대상으로 지정되는 속성이다.
    
     box-model은 그래서 
     content, padding, border를 이해하는 개념이다.
     
     >> box-sizing: content-box;
     box-sizing property 기본값은 "content-box"이다.
     이말은 width, height 대상 영역이 content를 의미한다.
     
     box-sizing 속성을 가지고우리는 width, height 대상영역을 변경할 수 있다.
     
     >> box-sizing: border-box;
     border-box 값으로 지정하면 대상영역이 box model이 되어서
     css layout을 지정하기 border-box가 더 직관적이다.
     
     content-box :: width, height 속성값은 content 영역을 의미한다. (기본값)
     border-box :: width, height 속성값은 content, padding, border 가 모두 포함된 영역을 의미한다.
*/
​
​
    #model1{
        background-color: lightgray;
        width: 300px;
        padding: 25px;
        border: 25px solid navy;
        margin:25px;
        /* box model은 300 + 25*2 + 25*2 = 400 크기를 가지고 있다. */
        /* box-sizing: content-box; */  
        box-sizing: border-box;
    }
    
    #model2{
        width: 300px;
        height: 100px;
        background-color: cornsilk;
        border: 5px solid navy;
        overflow: hidden;
    }
​
</style>
</head>
<body>
  <h2>Box Model 1.</h2>
  <div id="model1">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</div>
​
  <h2>Box Model 2.</h2>
  <div id="model2">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</div>
</body>
</html>
```
​
[##_Image|kage@SCdIh/btrdJ3xtw9r/o8EK87EswrL0LoUt3SjmIK/img.png|alignCenter|data-origin-width="301" data-origin-height="623" data-ke-mobilestyle="widthOrigin"|||_##]
​
```
<!DOCTYPE html>
<html lang="en">
<head>
<title>CSS Website Layout</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style type="text/css">
body{
    margin: 0;
    }
    
header{
    background-color: #F1F1F1;
    text-align: center;
    padding: 20px;
    }
    
nav{
    background-color: #333;
    overflow: hidden;
    }
​
nav>a{
    color: #f2f2f2;
    text-align: center;
    text-decoration: none;
    display: block;
    /* 
        자식 요소에 float 속성을 주게 되면 부모 영역 밖으로 넘치는 현상이 발생
        overflow: hidden을 부모 요소에 지정
    */
    float: left;
    padding: 16px 18px;
    }
    
nav>a:HOVER{color:yellow;}
​
section>article.column{
    float: left;
    width: 33.33%;
    padding: 15px;
    }
    
/* 레이아웃을 사이즈 맞게 지정할 때는 거의 들어간다고 보면 된다.*/    
*{
    box-sizing: border-box;
}
​
footer{
    background-color: #F1F1F1;
    overflow: hidden;
    text-align: center;
    padding: 30px;
    width: 33.33%;
    
    display:block;
    clear: both; /* float의 속성을 왼, 오른쪽 취소 */
    position: absolute; /* 위치 고정 */
    top:80%;  left:30%; /* 위에서 80%, 밑에서 30% 떨어져 있음 */
}
​
</style>
</head>
<body>
<header>
  <h1>Header</h1>
  <p>Resize the browser window to see the responsive effect.</p>
</header>
​
<nav>
  <a href="#">Link</a>
  <a href="#">Link</a>
  <a href="#">Link</a>
</nav>
​
<!-- 
    특징정리 
    1. section :: 내용이 서로 관계가 있을 때 사용
    2. article :: 내용이 독립적이고 스스로 설 수 있는 내용
    3. div :: 의미적으로 관계가 없을때 사용 (오직 내용만 묶음)
    
-->
​
<section class="row">
  <article class="column">
    <h2>Column</h2>
    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas sit amet pretium urna. Vivamus venenatis velit nec neque ultricies, eget elementum magna tristique. Quisque vehicula, risus eget aliquam placerat, purus leo tincidunt eros, eget luctus quam orci in velit. Praesent scelerisque tortor sed accumsan convallis.</p>
  </article>
  
  <article class="column">
    <h2>Column</h2>
    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas sit amet pretium urna. Vivamus venenatis velit nec neque ultricies, eget elementum magna tristique. Quisque vehicula, risus eget aliquam placerat, purus leo tincidunt eros, eget luctus quam orci in velit. Praesent scelerisque tortor sed accumsan convallis.</p>
  </article>
  
  <article class="column">
    <h2>Column</h2>
    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas sit amet pretium urna. Vivamus venenatis velit nec neque ultricies, eget elementum magna tristique. Quisque vehicula, risus eget aliquam placerat, purus leo tincidunt eros, eget luctus quam orci in velit. Praesent scelerisque tortor sed accumsan convallis.</p>
  </article>
 </section>  
 
  <!-- 추가하기 -->
<footer >
    <p><h2>Footer</h2></p>
</footer>
​
</body>
</html>
```
​
[##_Image|kage@y0J4j/btrdPI6tTHt/zwi4XMn5F4lbcaZgBQudw0/img.png|alignCenter|data-origin-width="925" data-origin-height="722" data-ke-mobilestyle="widthOrigin"|||_##]
​
# **Bootstrap**
​
부트스트랩은 응답성이 뛰어난 모바일 우선 웹 사이트를 개발하는 데 HTML, CSS, JavaScript 프레임워크 이다.
​
-   **GridSystem**
​
```
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  
  <!-- 기기맞춤형 화면구현 -->
  <meta name="viewport" content="width=device-width, initial-scale=1"> 
  
  <!-- link 태그 :: 외부에 있는 css 받아옴 -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  
  <!-- 
    * Bootstrap :: Front-End Framework (html, css, js)
    bootstrap 라이브러리를 인크루드 하기전에 jquery 라이브러리를 먼저 인크루드 해야한다 (순서중요) 
    bootstrap은 html, css, jquery 기반으로 작성된 프레임워크이기 때문이다.
  -->
  
  <!-- script 태그 :: javascript tag -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script> <!-- 비동기 -->
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  
​
</head>
<body>
<div class="jumbotron text-center"> <!-- 외부 css :: jquery.min.js -->
  <h1>My First Bootstrap Page</h1>
  <p>Resize this responsive page to see the effect!</p>
  <p> Customizing </p>
</div>
​
<!-- 
    Bootstrap :: GridSystem
    
    한줄은 기본적으로 12칸으로 구성되어져 있다.
    정확하게 3등분 레이아웃을 하려면 col-sm-4 를 세번씩 해서 div안에 넣어준다.
    
    디바이스크기
    xs(모바일) :: 너비 768px
    sm(테블릿) :: 768px < sm
    md(노트북) :: 992px
    lg(데스크탑) :: 1200px
​
 -->
​
<div class="container">
  <div class="row">
    <!-- 
        "col-sm-4" * 3 :: grid (12칸) 
        즉, 12칸으로 이루어 져있고 4개씩 3칸으로 나눠서 형성된 것이다.
        "col-sm-6" 으로하면 절반으로 나눠진다. 
    -->
    <div class="col-sm-3" style="background-color: Lavender;"> 
      <h3>Column 1</h3>
      <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit...</p>
      <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris...</p>
    </div>
    
    <div class="col-sm-3" style="background-color: Lavenderblush;">
      <h3>Column 2</h3>
      <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit...</p>
      <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris...</p>
    </div>
    
    <div class="col-sm-3" style="background-color: Lavender;">
      <h3>Column 3</h3>
      <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit...</p>
      <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris...</p>
    </div>
    
     <div class="col-sm-3" style="background-color: Lavenderblush;">
      <h3>Column 4</h3>
      <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit...</p>
      <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris...</p>
    </div>
    
  </div>
</div>
</body>
</html>
```
​
[##_Image|kage@s67uN/btrdPJj2TWR/wxRIsERJGwXX2x6dLKxB8K/img.png|alignCenter|data-origin-width="855" data-origin-height="494" data-ke-mobilestyle="widthOrigin"|||_##]
​
-   **container, container-fluid**
​
```
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1"> 
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script> <!-- 비동기 -->
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
​
</head>
<body>
​
 
  
<!-- 
​
  Bootstrap은 반응형으로 사용할 때 html 요소들을 둘러싸는 기본 클래스로 container를 제공한다.
  
  * container | container-fluid 
  container :: 고정폭을 지정해서 레이아웃을 만들 떄 사용된다.
  container-fluid :: 고정폭을 지정하지 않고 전체 화면을 좌우로 꽉 채워서 레이아웃을 만들때 사용된다.
  
-->
  
 
<div class="container">
    <div class="jumbotron text-center"> <!-- 외부 css :: jquery.min.js -->
      <h1>My First Bootstrap Page</h1>
      <p>Resize this responsive page to see the effect!</p>
      <p> Customizing </p>
    </div>
</div>
<div class="container-fluid">
  <div class="row">
​
    <div class="col-lg-2" style="background-color: Lavender;"> 
      <h3>Column 1</h3>
      <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit...</p>
      <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris...</p>
    </div>
    
    <div class="col-lg-5" style="background-color: Lavenderblush;">
      <h3>Column 2</h3>
      <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit...</p>
      <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris...</p>
    </div>
    
    <div class="col-lg-5" style="background-color: Lavender;">
      <h3>Column 3</h3>
      <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit...</p>
      <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris...</p>
    </div>
    
  </div>
</div>
</body>
</html>
```
​
[##_Image|kage@bZtbar/btrdNXQXYP6/mOmnkac0vHsiRDJkn4Xl80/img.png|alignCenter|data-origin-width="962" data-origin-height="534" data-ke-mobilestyle="widthOrigin"|||_##]
​
```
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1"> 
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script> <!-- 비동기 -->
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
​
</head>
<body>
​
<div class="container">
    <div class="jumbotron text-center">
      <h1>My First Bootstrap Page</h1>
      <p>Resize this responsive page to see the effect!</p>
      <p> Customizing </p>
    </div>
</div>
​
<!-- 1. grid system :: 각각 컬럼의 비중을 동일하게 3등분 -->
<div class="row">
    <div class = "col-lg-4">Bootstrap 4 is the newest version of Bootstrap, which is the most popular HTML, CSS, and JavaScript framework for developing responsive, mobile-first websites.</div>
    <div class = "col-lg-4">Bootstrap is a free front-end framework for faster and easier web development</div>
    <div class = "col-lg-4">Bootstrap includes HTML and CSS based design templates for typography, forms, buttons, tables, navigation, modals, image carousels and many other, as well as optional JavaScript plugins</div>
</div>
​
<hr>
​
<!-- 2. grid system :: 각각 컬럼의 비중을 동일하게 3등분, 이 때 가운데를 비워둔다 = offset -->
<div class="container">
    <div class="row">
    <!-- offset-lg-4 :: 이 부분을 상쇄시킴 -->
        <div class = "col-lg-4">Bootstrap 4 is the newest version of Bootstrap, which is the most popular HTML, CSS, and JavaScript framework for developing responsive, mobile-first websites.</div>
        <div class = "offset-lg-4 col-lg-4">Bootstrap includes HTML and CSS based design templates for typography, forms, buttons, tables, navigation, modals, image carousels and many other, as well as optional JavaScript plugins</div>
    </div>
</div>
​
<hr>
​
<div class="container-fluid">
    <div class="row">
        <div class = "col-lg-2">Bootstrap 4 is the newest version of Bootstrap, which is the most popular HTML, CSS, and JavaScript framework for developing responsive, mobile-first websites.</div>
        <div class = "offset-lg-6 col-lg-4">Bootstrap includes HTML and CSS based design templates for typography, forms, buttons, tables, navigation, modals, image carousels and many other, as well as optional JavaScript plugins</div>
        <div class = "col-lg-6">Bootstrap includes HTML and CSS based design templates for typography, forms, buttons, tables, navigation, modals, image carousels and many other, as well as optional JavaScript plugins</div>
    </div>
</div>
</body>
</html>
```
​
[##_Image|kage@MnAey/btrdOxkaoz1/i7DqycX4KgvHUzb5EKs690/img.png|alignCenter|data-origin-width="1030" data-origin-height="667" data-ke-mobilestyle="widthOrigin"|||_##]
