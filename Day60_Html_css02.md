## **Client ↔ Server (Protocol 연결 : http, jdbc, ftp)**
​
Client : 요청(서버상에 존재하는 Page, File)을 보내는 입장
​
         Page (정적인 문서(UI), 동적인 문서(program))
​
## **HTML**
​
### **Tables**
​
HTML table을 통해 데이터를 행과 열로 정렬할 수 있습니다.
​
```
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
​
</head>
<body>
<!-- align="center" :: 가운데 정렬 -->
<h2 align="center">Table Tag Test</h2>
​
<!-- table :: tr, td로 이루어진 2차원 구조 -->
<table align="center" width="40%">
​
<!-- thead, tbody, tfoot 구조로 작성 하기 -->
​
    <thead>
        <tr><!-- tr :: table row -->
            <th>NO</th><th>NAME</th><th>ADDRESS</th>
        </tr>
    </thead>
​
​
    <tbody>
        <tr><!-- td :: table 칸 -->
            <td>11</td><td>James</td><td>Texas</td>
        </tr>
        <tr>    
            <td>22</td><td>Peter</td><td>Brandon</td>
        </tr>
        <tr>
            <td>33</td><td>Gosling</td><td>LA</td>
        </tr>
        <tr>
            <td>44</td><td>Ann</td><td>PL</td>
        </tr>
    </tbody>
    
    
    <tfoot>
        <tr>
            <td>55</td><td>66</td><td>77</td>
        </tr>
    </tfoot>
    
    
</table>
</body>
</html>
```
​
[##_Image|kage@8gkny/btrd0G8LRtl/rzHT16k6H3ge0pA23XHGN1/img.png|alignCenter|data-origin-width="517" data-origin-height="217" data-ke-mobilestyle="widthOrigin"|||_##]
​
```
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
​
<!-- 
css 선택자 지정방법
    1. 열거형 ::: 모든 선택자를 모두 선택하는 방법
                , 를 구분자로 사용한다.
    2. 자식 ::: > 를 사용해서 직계자식을 구분한다.
              [  ], 공백을 사용해서 
 -->
​
<style type="text/css">
    table,tr,td{ /* 열거형 */
        border:2px solid black;
        border-collapse: collapse;
        text-align:center; /* 내용 가운데 정렬 */
    }
    tfoot{
        background-color:Dodgerblue;
    }
    thead{
        background-color:Tomato;
    }
    
    
    /* table 태그의 자식인 tbody의 자식 태그인 tr을 선택자로 지정*/
    
    /* 1 직계자식 :: table > tbody > tr but, table > tr 직계자식 안됨*/
    /* table>tbody>tr{
        background-color:Violet;
    }  */
    
    /* 2. 후손 :: 공백으로 나열 */
    /* table tbody tr{
        background-color:Violet;
    } 
     */
    
    table>tbody>tr:HOVER{
        background-color:Violet;
    }
    
</style>
</head>
​
​
<body>
<!-- align="center" :: 가운데 정렬 -->
<!-- table :: tr, td로 이루어진 2차원 구조 -->
​
<h2 align="center">Table Tag Test</h2>
<table align="center" width="40%">
​
<!-- thead, tbody, tfoot 구조로 작성 하기 -->
​
    <thead>
        <tr><!-- tr :: table row -->
            <th>NO</th><th>NAME</th><th>ADDRESS</th>
        </tr>
    </thead>
​
    <tbody>
        <tr><!-- td :: table 칸 -->
            <td>11</td><td>James</td><td>Texas</td>
        </tr>
        <tr>    
            <td>22</td><td>Peter</td><td>Brandon</td>
        </tr>
        <tr>
            <td>33</td><td>Gosling</td><td>LA</td>
        </tr>
        <tr>
            <td>44</td><td>Ann</td><td>PL</td>
        </tr>
    </tbody>
    
    <tfoot>
        <tr>
            <td>55</td><td>66</td><td>77</td>
        </tr>
    </tfoot>
    
    
</table>
</body>
</html>
```
​
[##_Image|kage@eTYmQw/btrd15fO61H/VsMOgcu53h6kHVk82RVWb0/img.png|alignCenter|data-origin-width="500" data-origin-height="247" data-ke-mobilestyle="widthOrigin"|||_##]
​
```
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
​
<!-- 
colspan :: 칸을합침
rowspan :: 행을합침
​
 -->
​
<style type="text/css">
    table,tr,td{
        border:2px solid black;
        border-collapse: collapse;
        text-align:center;
    }
​
    table>tbody>tr:HOVER{
        background-color:Violet;
    }
    tr:nth-child(even) { /* 짝수만 회색으로 변경*/
      background-color: #dddddd;
    }
    
</style>
</head>
<body>
​
<h2 align="center">Table Tag Test</h2>
<table align="center" width="40%">
    <caption>Table Information</caption><!-- 테이블 제목 -->
    <thead>
        <tr>
            <th>NO</th><th>NAME</th><th>ADDRESS</th>
        </tr>
    </thead>
​
    <tbody>
        <tr>
            <td>11</td><td>James</td><td>Texas</td>
            <!-- <td rowspan="3">11</td> :: 3행을 하나로 합쳐진다.-->
        </tr>
        <tr>    
            <td>22</td><td>Peter</td><td>Brandon</td>
        </tr>
        <tr>
            <td>33</td><td>Gosling</td><td>LA</td>
        </tr>
        <tr>
            <td>44</td><td>Ann</td><td>PL</td>
        </tr>
    </tbody>
    
    <tfoot>
        <tr>
            <td colspan="3">This is footer scope</td>
        </tr>
    </tfoot>
​
</table>
</body>
</html>
```
​
[##_Image|kage@m4Z8s/btrd0k6xGpA/VSedj9mMAzNIKHbnyYbstK/img.png|alignCenter|data-origin-width="459" data-origin-height="278" data-ke-mobilestyle="widthOrigin"|||_##]
​
### **Semantic Elements**
​
semantic element : 브라우저와 개발자 모두에게 그 의미를 명확하게 설명한다.  
  
**non-semantic** elements : <div> 및 <span> - 내용에 대해 아무 것도 알 수 없음  
**semantic** elements: <form>, <table>, and <article> - 내용을 명확하게 정의 함
​
[##_Image|kage@cCywk3/btrd0F3HhNa/TvKw4ZtpC7SHO3e6OUCXfk/img.png|alignCenter|data-origin-width="355" data-origin-height="578" data-ke-mobilestyle="widthOrigin"|||_##]
​
-   **semantic before**
​
```
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
​
<body>
<h2>Sementic Layout</h2>
<p>With CSS, you can control the color, font, the size of text, the spacing between elements, how elements are positioned and laid out, what background images or background colors are to be used, different displays for different devices and screen sizes, and much more!</p>
<p>Tip: The word cascading means that a style applied to a parent element will also apply to all children elements within the parent. So, if you set the color of the body text to "blue", all headings, paragraphs, and other text elements within the body will also get the same color (unless you specify something else)!</p>
​
<div id = "header">
    <h2>Cities</h2>
</div>
​
<div id = "section">
    <div id = "nav">
        <ul>
            <li><a href="#">London</a></li>
            <li><a href="#">Busan</a></li>
            <li><a href="#">Paris</a></li>
            <li><a href="#">Tokyo</a></li>
        </ul>
    </div>
</div>
​
​
<div id = "article">
    <h1>London</h1>
    <p>London is the capital and largest city of England and the United Kingdom.[8][9] The city stands on the River Thames in southeast England, at the head of its 50-mile (80 km) estuary leading to the North Sea. London has been a major settlement for two millennia.[10] The City of London, London's ancient core and financial centre, was founded by the Romans and originally called Londinium; with an area of just 1.12 square miles (2.9 km2) and colloquially known as the Square Mile, it retains boundaries that closely follow its medieval limits.[note 1][11][12][13][14][15] The adjacent City of Westminster has for centuries been the location of much of the national government. Thirty-one additional boroughs north and south of the river also comprise modern London. The London region is governed by the mayor of London and the London Assembly.[note 2][16][17]s</p>
    <p>London is one of the world's most important global cities.[18] It exerts considerable influence on the arts, commerce, education, entertainment, fashion, finance, healthcare, media, professional services, research and development, tourism, and transportation.[19] It is one of the largest financial centres in the world and in 2019, London had the second highest number of ultra high-net-worth individuals in Europe, after Paris.[20] And in 2020, London had the second-highest number of billionaires of any city in Europe, after Moscow.[21] London's universities form the largest concentration of higher education institutes in Europe,[22] and London is home to highly ranked institutions such as Imperial College London in natural and applied sciences, the London School of Economics in social sciences, as well as the comprehensive University College London.[23] In 2012, London became the first city to have hosted three modern Summer Olympic Games.[24][7]</p>
</div>
​
​
<div id = "footer">
    <p>This is Footer.. scope</p>
</div>
​
</body>
</html>
```
​
-   **semantic**
​
```
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
    body{
        width: 960px;
        margin: auto; /*center 정렬*/
    }
    
    aside{
        width: 33%;
        float: left;
    }
    
    section{
        width: 66%;
        float: right;
    }
    
    footer{
        clear: both; /*float 떠버린 footer를 깨끗하게 정리함 */
    } 
</style>
</head>
<body>
​
<header>
    <h1>HEADRER</h1>
</header>
​
<nav>
    <h1>NAVIGATION</h1>
</nav>
​
<div>
    <aside>
        <h1>ASIDE</h1>
        <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. 
        Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, 
        when an unknown printer took a galley of type and scrambled it to make a type 
        specimen book. It has survived not only five centuries, but also the leap into 
        electronic typesetting, remaining essentially unchanged. It was popularised 
        in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, 
        and more recently with desktop publishing software like Aldus PageMaker including 
        versions of Lorem Ipsum. Why do we use it?
        It is a long established fact that a reader will be distracted by the readable 
        content of a page when looking at its layout. The point of using Lorem Ipsum is 
        that it has a more-or-less normal distribution of letters, as opposed to using 
        'Content here, content here', making it look like readable English. Many desktop 
        publishing packages and web page editors now use Lorem Ipsum as their default 
        model text, and a search for 'lorem ipsum' will uncover many web sites still 
        in their infancy. Various versions have evolved over the years, sometimes by 
        accident, sometimes on purpose (injected humour and the like).
        </p>
    </aside>
    
    
    <section>
        <h1>SECTION</h1>
        <p>Where does it come from?
        Contrary to popular belief, Lorem Ipsum is not simply random text. 
        It has roots in a piece of classical Latin literature from 45 BC, 
        making it over 2000 years old. Richard McClintock, a Latin professor at 
        Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words,
         consectetur, from a Lorem Ipsum passage, and going through the cites of the word 
         in classical literature, discovered the undoubtable source. 
         Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of "de Finibus Bonorum et 
         Malorum" (The Extremes of Good and Evil) by Cicero, written in 45 BC. 
         This book is a treatise on the theory of ethics, very popular during the Renaissance. 
         The first line of Lorem Ipsum, "Lorem ipsum dolor sit amet..", comes from a line in section 1.10.32.
        The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested. 
        Sections 1.10.32 and 1.10.33 from "de Finibus Bonorum et Malorum" by Cicero are also reproduced in their exact original form, 
        accompanied by English versions from the 1914 translation by H. Rackham.Where does it come from?
        Contrary to popular belief, Lorem Ipsum is not simply random text. 
        It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. 
        Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, 
        looked up one of the more obscure Latin words, consectetur, 
        from a Lorem Ipsum passage, and going through the cites of the word in classical literature, 
        discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of "de Finibus Bonorum et Malorum" 
        (The Extremes of Good and Evil) by Cicero, written in 45 BC. 
        This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, "Lorem ipsum dolor sit amet..", 
        comes from a line in section 1.10.32.
        The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested. Sections 1.10.32 and 1.10.33 from 
        "de Finibus Bonorum et Malorum" by Cicero are also reproduced in their exact original form, accompanied by English versions from the 1914 translation by H. Rackham.</p>
        
        <p>Where can I get some?
        There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, 
        or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything 
        embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet. 
        It uses a dictionary of over 200 Latin words, combined with a handful of model sentence structures, to generate Lorem Ipsum which looks reasonable. 
        The generated Lorem Ipsum is therefore always free from repetition, injected humour, or non-characteristic words etc.Where can I get some?
        There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. 
        If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, 
        making this the first true generator on the Internet. It uses a dictionary of over 200 Latin words, combined with a handful of model sentence structures, to generate Lorem Ipsum which looks reasonable. 
        The generated Lorem Ipsum is therefore always free from repetition, injected humour, or non-characteristic words etc.</p>
    </section>
</div>
​
<footer>
    <h1>FOOTER 2021 08 31 WRITTEN BY HYERI...</h1>
</footer>
​
​
</body>
</html>
```
​
[##_Image|kage@cYqTIo/btrd14V0MTS/8PIoge5kECLPJD8kJONLs1/img.png|alignCenter|data-origin-width="585" data-origin-height="720" data-ke-mobilestyle="widthOrigin"|||_##]
​
### **Media**
​
```
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>placehold.it 사이트 이용하기</h1>
<img alt="" src="http://placehold.it/300x200">
<img alt="" src="http://placehold.it/250x200">
<img alt="" src="http://placehold.it/100x100">
<hr>
<h1>Audio Tag 이용하기</h1>
<audio src="media/Kalimba.mp3" controls="controls" autoplay="autoplay"></audio>
<hr>
<h1>Youtube 이용하기</h1>
<iframe width="620" height="430" src="https://www.youtube.com/embed/CuklIb9d3fI" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
​
</body>
</html>
```
​
[##_Image|kage@b8DiTI/btrd0GBwBwE/ejduCle0oiEajGNopPvrMk/img.png|alignCenter|data-origin-width="843" data-origin-height="803" data-ke-mobilestyle="widthOrigin"|||_##]
​
---
​
## **CSS**
​
CSS란 무엇입니까?  
CSS는 Cascading Style Sheets 이다.  
CSS는 HTML 요소를 화면, 용지 또는 다른 미디어에 표시하는 방법을 설명한다  
CSS는 여러 웹 페이지의 레이아웃을 동시에 제어할 수 있다.  
외부 스타일시트는 CSS 파일에 저장됩니다.
​
-   **선택자 지정**
​
<p> 태그를 선택자로 지정  
  **ID는** 한 요소에만 사용, **CLASS는** 여러요소에 중복사용가능한 스타일 정의법
​
css 에서 선택자 지정시  
 **.은 class**  , **#은 id** 로 지정한다.
​
```
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
    /*h2 태그를 선택자로 지정*/
    h2{
        color:orange;
        font-family: 궁서체;
        font-style: oblique;
        font-size:25pt;
    }
    
    /*p 태그를 선택자로 지정
    ID는 한요소에만 사용, CLASS는 여러요소에 중복사용가능한 스타일 정의법*/
    
    /* .은 class, #은 id */
    .phara{
        font-size: 25pt;
        color:purple;
        font-family: cursive;
    }
    #ptag2{
        font-size: 20pt;
        background-color: gray;     
    }
    
    
</style>
</head>
<body>
<h2>CSS3에서 선택자 지정하는 방법과 CSS 선언방법</h2>
<p class="phara">Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>
<p id = "ptag2">Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>
<p class="phara">Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>
</body>
</html>
```
​
[##_Image|kage@bcs9S6/btrd0jGGpCP/3mw46dUf80kXx2kWHoJpMK/img.png|alignCenter|data-origin-width="1035" data-origin-height="468" data-ke-mobilestyle="widthOrigin"|||_##]
​
-   **외부 모듈화** 
​
**1) link 연결법** 
​
```
/*css 파일*/
​
h2{
    color:orange;
    font-family: 궁서체;
    font-style: oblique;
    font-size:25pt;
}
​
/* .은 class, #은 id */
.phara{
    font-size: 25pt;
    color:purple;
    font-family: cursive;
}
#ptag2{
    font-size: 20pt;
    background-color: gray;     
}
```
​
```
<!-- html 파일 -->
​
<!-- 
​
    css, html 파일의 분리
    이렇게 함으로써  html 코드의 가독성을 높이고
    css 파일의 재사용성을 높일 수 있다.
    
    이번예제에서는 어떻게 html 파일에서 css파일을 연결하는 지를 잘 알아보자
​
 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/css02.css" type="text/css"> <!-- ◁ 외부모듈사용 -->
</head>
<body>
<h2>CSS3에서 선택자 지정하는 방법과 CSS 선언방법 :: 외부모듈 사용(link)1</h2>
<p class="phara">Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>
<p id = "ptag2">Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>
<p class="phara">Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>
</body>
</html>
```
​
[##_Image|kage@blXyVq/btrd1zaSRao/AqbYJtMcKr0SoBQHDIqkVk/img.png|alignCenter|data-origin-width="1037" data-origin-height="466" data-ke-mobilestyle="widthOrigin"|||_##]
​
**2) import 연결법** 
​
```
<!-- 
​
    css, html 파일의 분리
    이렇게 함으로써  html 코드의 가독성을 높이고
    css 파일의 재사용성을 높일 수 있다.
    
    이번예제에서는 어떻게 html 파일에서 css파일을 연결하는 지를 잘 알아보자
    link 연결법 아닌, import 연결법을 알아보자.
    이 2가지 방법이 어떤 차이점이 있는가 반드시 생각해보자.
 -->
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 받아온 css파일을 커스터마이징 가능 -->
<style type="text/css"> 
    @import url("css/css02.css");
    body{
        background-color:yellow;
        }
</style>
</head>
<body>
<h2>CSS3에서 선택자 지정하는 방법과 CSS 선언방법 :: 외부모듈(import) 사용 2</h2>
<p class="phara">Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>
<p id = "ptag2">Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>
<p class="phara">Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>
</body>
</html>
```
​
[##_Image|kage@c37jiy/btrd1O6KFXo/XxAYVMpzKO3vyCJLO3rXF0/img.png|alignCenter|data-origin-width="1036" data-origin-height="470" data-ke-mobilestyle="widthOrigin"|||_##]
​
-   **폼양식 활성화 속성, 속성부분의 선택자** 
​
```
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
    /* 1. 속성에 대한 선택자 지정 (오리지널)*/
    input[required=required]{  /* [속성이름 = 속성값] */
        background: red;
    }
    
    /* 2. 속성에 대한 선택자 지정 (심플)*/
    input:required {background: yellow;}
    input:disabled {background: gray;}
    
</style>
</head>
<body>
<!-- 1. 폼 양식 활성화 관련된 속성과 
     2. 태그의 속성 부분을 선택자로 지정하는 방법 -->
<h2>State Attribute</h2>
<form action="#">
    <h3>Enabled</h3>
    <input /> <!-- 입력가능 -->
    
    <h3>Enabled</h3>
    <input disabled="disabled"/> <!-- 비활성화 -->
    
    <h3>Enabled</h3>
    <input readonly="readonly" value="hyeri"/> <!-- 값 수정 불가  -->
    
    <h3>Enabled</h3>
    <input required="required" placeholder="암호를 입력하세요"/> <!-- SEND 버튼 생성시 form에 action을 줘야한다.  -->
    <input type="submit" value="SEND">
</form>
</body>
</html>
```
​
[##_Image|kage@c995W6/btrd3aIgfKG/mzkxbNnfZeaJjvmcO3hlHk/img.png|alignCenter|data-origin-width="351" data-origin-height="460" data-ke-mobilestyle="widthOrigin"|||_##]
​
-   **선택자 지정 1**
​
```
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
    
    p::selection{ /* selection :: 마우스 글 드래그 하면 효과 나타남*/
        background: black; color:red;
    }
    
</style>
</head>
<body>
​
<h1>What is Lorem Ipsum</h1>
​
<p>What is Lorem Ipsum?
   Lorem Ipsum is simply dummy text of the printing and typesetting industry. 
   Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, 
   when an unknown printer took a galley of type and scrambled it to make a type 
   specimen book. It has survived not only five centuries, but also the leap into e
   lectronic typesetting, remaining essentially unchanged. 
   It was popularised in the 1960s with the release of Letraset sheets containing 
   Lorem Ipsum passages, and more recently with desktop publishing software like 
   Aldus PageMaker including versions of Lorem Ipsum.</p>
   
   
<p>Where does it come from?
    Contrary to popular belief, Lorem Ipsum is not simply random text. 
    It has roots in a piece of classical Latin literature from 45 BC, 
    making it over 2000 years old. Richard McClintock, a Latin professor at 
    Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, 
    consectetur, from a Lorem Ipsum passage, and going through the cites of the word    
    in classical literature, discovered the undoubtable source. 
    Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of "de Finibus 
    Bonorum et Malorum" (The Extremes of Good and Evil) by Cicero, written in 45 BC. 
    This book is a treatise on the theory of ethics, very popular during the Renaissance. 
    The first line of Lorem Ipsum, "Lorem ipsum dolor sit amet..", 
    comes from a line in section 1.10.32.
    The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested. 
    Sections 1.10.32 and 1.10.33 from "de Finibus Bonorum et Malorum" 
    by Cicero are also reproduced in their exact original form, accompanied 
    by English versions from the 1914 translation by H. Rackham.</p>
    
<p>Why do we use it?
    It is a long established fact that a reader will be distracted by the readable 
    content of a page when looking at its layout. 
    The point of using Lorem Ipsum is that it has a more-or-less normal distribution 
    of letters, as opposed to using 'Content here, content here', making it look like 
    readable English. Many desktop publishing packages and web page editors now use 
    Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will 
    uncover many web sites still in their infancy. Various versions have evolved 
    over the years, sometimes by accident, sometimes on purpose 
    (injected humour and the like).</p>
    
</body>
</html>
```
​
[##_Image|kage@biuDFp/btrd3bUHL63/7nKz3xE2zK5j2UXwp7U5n0/img.png|alignCenter|data-origin-width="1031" data-origin-height="531" data-ke-mobilestyle="widthOrigin"|||_##]
​
-   **선택자 지정 2**
​
```
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
/* 오버라이딩이 되서 마지막 설정된 속성인 5번만 나온다, 하나씩 입력해서 차례로 실행해보기 */
​
    /* 1. 태그명이 input 이고 속성이름이 type인 선택자를 지정, 배경색을 #ffbb9a로 input::type적용안됨*/
    input[type]{background: #ffbb9a;}
    /*input : type{background:yellow;}*/
    
    /* 2. 속성명이 type이고 속성값이 password인 선택자를 지정, 배경색을 #bf95d4 */
    input[type=password]{background: #bf95d4;}
    
    /* 3. name이라는 속성에 대한 값 중에서 user라는 값이 "포함"되는 선택자를 지정 #f1cdbd*/
    input[name*=user]{background: #f1cdbd;}
    
    /* 4. name이라는 속성에 대한 값 중에서 Name으로 "끝나는 값"을 선택자로 지정 #e1eef9*/
    input[name$=Name]{background: #e1eef9;}
    
    /* 5. name이라는 속성에 대한 값 중에서 user로 "시작하는 값"을 선택자로 지정 #f5c4c7*/
    input[name^=user]{background: #f5c4c7;}
​
</style>
</head>
<body>
​
<h2>REGISTER MEMBER FORM</h2>
​
<form action="#" name="registerFrm">
​
<label>NAME</label>     <input type="text" name="userName"><br><br>
<label>ID</label>     <input type="text" name="userId" id="userId" disabled="disabled"><br><br><!--비활성화  -->
PASSWORD <input type="password" name="userPass"><br><br>
         <input type="file" name="userFile"><br><br>
BirthDate  <input type="date" id="birth"><br><br>
Gender    <input type="radio" name="gender" value="F">F
          <input type="radio" name="gender" value="M">M
<br><br>
Introduction<br>
<textarea rows="5" cols="50">자기소개를 간단히...</textarea> <br><br>
<b>다음 오늘 저녁메뉴를 고르세요....</b><br>
<select multiple="multiple">
    <option>김밥</option>
    <option>매운탕</option>
    <option value="CU">삼각김밥</option>
    <option>꼬마김밥</option>
</select>  
<HR><br>
<b> 다음중 당신의 집에서 기르는 애완동물을 고르세요.</b><br>
<input type="checkbox" name="pets" value="개">개
<input type="checkbox" name="pets" value="고양이">고양이
<input type="checkbox" name="pets" value="햄스터">햄스터
<input type="checkbox" name="pets" value="고슴도치">고슴도치
 <hr><br>
 <input type="submit" value="SEND">   
 <input type="reset" value="CLEAR">
 <input type="button" value="BUTTON" onclick="push()"> 
</form>
</body>
</html>
```
​
[##_Image|kage@bnlBB9/btrd0uuDUYv/XJQEAy9HVkGO3Tsh5dByLk/img.png|alignCenter|data-origin-width="820" data-origin-height="693" data-ke-mobilestyle="widthOrigin"|||_##]
​
-   **display**
​
```
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
    #box{display: none;} /* box 즉 div가 없는것 처럼 보임*/
    #box{display: block;} /* box 즉 div는 원래 blocking tag이기 때문에 변하지 않음*/
    #box{display: inline; /* box 즉 div가 inline tag 처럼 실행, 옆으로 나란히 출력*/
        background-color: yellow;
        width:60px;} /* width는 적용되지 않음 inline 기본값으로 설정되기 때문 */
    #box{display: inline-block; /**/
        background-color:green;
        width:60px; /* inline-block 은 inline 과 비슷하나 너비와 높이를 지정할 수 있다.*/
        height:30px;}  
         
</style>
</head>
<body>
<!-- span :: inline tag, 나란히 출력된다 -->
<span>Dummy</span>
<!-- div :: blocking tag, 위-아래로 출력된다. -->
<div id="box">
    <span>Lorem Ipsum is simply dummy text of the printing and typesetting industry.</span>
</div>
<span>Dummy</span>
​
</body>
</html>
```
​
[##_Image|kage@crGojA/btrd3a9kYNu/1wtThKsRI4zSyvuWAYvZf0/img.png|alignCenter|data-origin-width="536" data-origin-height="103" data-ke-mobilestyle="widthOrigin"|box 즉 div가 없는것 처럼 보임||_##][##_Image|kage@sdQtg/btrdXxFrGgJ/Nwael3rJAZtEQBMMt7qUq0/img.png|alignCenter|data-origin-width="569" data-origin-height="76" data-ke-mobilestyle="widthOrigin"|box 즉 div는 원래 blocking tag이기 때문에 변하지 않음||_##][##_Image|kage@GAx1x/btrd0vf0qej/n27zit3fJBgvospmwfCysk/img.png|alignCenter|data-origin-width="699" data-origin-height="43" data-ke-mobilestyle="widthOrigin"|box 즉 div가 inline tag 처럼 실행, 옆으로 나란히 출력||_##][##_Image|kage@bwg6v2/btrdZXcNy3Y/R9kaGUk50jTeWlt5kBczBK/img.png|alignCenter|data-origin-width="198" data-origin-height="247" data-ke-mobilestyle="widthOrigin"|inline-block 은 inline 과 비슷하나 너비와 높이를 지정할 수 있다||_##]
​
-   **border-radius**
​
```
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
    #exam1{
        border:2px solid red;
        padding: 10px;
        border-radius: 25px; 
    }
    #exam2{
        border:2px solid red;
        padding: 10px;
        border-radius: 50px 20px; 
    }
    /* border-radius : 4개 :: 좌상 우상 우하 좌하, 2개 :: 우하 좌상 */
</style>
</head>
<body>
<h2>border-radius 25px</h2>
<div id="exam1">
    <p>border-radius는 박스의 모서리를 둥글게 처리하는 기법</p>
</div>
​
<h2>border-radius 50px 20px</h2>
<div id="exam2">
    <p>border-radius는 박스의 모서리를 둥글게 처리하는 기법</p>
</div>
```
​
[##_Image|kage@Lp4FS/btrd1xEepGk/XH3aZeehaa15yUZltvFdk0/img.png|alignCenter|data-origin-width="788" data-origin-height="264" data-ke-mobilestyle="widthOrigin"|||_##]
​
-   **background-image**
​
```
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
    body{
        /* 기본값 :: repeat(연속), position(좌상단)  */
        background-image: url("img/jack.jpg");
        /* background-repeat: x;  x축 */
        /* background-repeat: y;  y축 */
        
        /* option */
        background-repeat: no-repeat;
        background-size: 20% 50%;
        /* background-position: center center; */
        background-position: 50% 80%;
        background-attachment: fixed;
    }
​
</style>
</head>
<body>
<h1>What is Lorem Ipsum</h1>
<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>
<p>Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of "de Finibus Bonorum et Malorum" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, "Lorem ipsum dolor sit amet..", comes from a line in section 1.10.32.</p>
<p>There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet. It uses a dictionary of over 200 Latin words, combined with a handful of model sentence structures, to generate Lorem Ipsum which looks reasonable. The generated Lorem Ipsum is therefore always free from repetition, injected humour, or non-characteristic words etc.</p>
<p>It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet. It uses a dictionary of over 200 Latin words, combined with a handful of model sentence structures, to generate Lorem Ipsum which looks reasonable. The generated Lorem Ipsum is therefore always free from repetition, injected humour, or non-characteristic words etc.</p>
<p>Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of "de Finibus Bonorum et Malorum" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, "Lorem ipsum dolor sit amet..", comes from a line in section 1.10.32.</p>
<p>There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet. It uses a dictionary of over 200 Latin words, combined with a handful of model sentence structures, to generate Lorem Ipsum which looks reasonable. The generated Lorem Ipsum is therefore always free from repetition, injected humour, or non-characteristic words etc.</p>
<p>It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet. It uses a dictionary of over 200 Latin words, combined with a handful of model sentence structures, to generate Lorem Ipsum which looks reasonable. The generated Lorem Ipsum is therefore always free from repetition, injected humour, or non-characteristic words etc.</p>
​
</body>
</html>
```
​
[##_Image|kage@bAQRKj/btrd3aO2s0f/dEsD9NWiEc3DdBKjOS3K9K/img.png|alignCenter|data-origin-width="916" data-origin-height="639" data-ke-mobilestyle="widthOrigin"|||_##]
