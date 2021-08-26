**자바스크립트 태그**
​
**✔ 형식**
​
```
<SCRIPT LANGUAGE=“스크립트종류” SRC=파일명> 
  자바 스크립트 코드
  </SCRIPT>
​
```
​
  **LANGUAGE**
​
  : 스크립트 언어 종류를 설정. 자바 스크립트는 JavaScript를 넣고 비주얼베이직 스크립트는 VBScript를 넣으면 됨
​
  **SRC**
​
  : 경로를 포함한 파일명을 설정. “C:/Jscript/test.js”와 같은 형식으로 설정
​
```
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript" src="../js/js01.js"> -- 파일을 불러와서 실행
</script>
</head>
<body>
<script type = "text/javascript">
    document.write("First script"); -- 본문에 직접 작성
</script>
<hr>
<script type="text/javascript" src="../js/js01.js">
</script>
</body>
```
​
```
-- JS01 파일
​
document.write("First script1<br>");
document.write("First script2<br>");
document.write("First script3<br>");
document.write("First script4<br>");
​
​
```
​
[##_Image|kage@04E9x/btq6GqsPERt/nMgr93ZzmgYKdELNe78d9K/img.png|alignCenter|data-origin-width="662" data-origin-height="627" data-ke-mobilestyle="widthOrigin"|||_##]
​
**✔ 출력문 **
​
```
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<script type = "text/javascript">
var name = prompt("input name", "Dominica");
alert ("input name" + name);
document.write("입력한 이름은 " + name + "입니다.");
res = confirm("현재 페이지를 종료 할까요 ? ")
document.write(res)
</script>
</body>
</html>
```
​
[##_Image|kage@c0z11e/btq6Mz2QhJW/Aw1BosUnzF58qM5sRUp4ak/img.png|alignCenter|data-origin-width="564" data-origin-height="161" data-ke-mobilestyle="widthOrigin"|||_##]
​
[##_Image|kage@efBQWz/btq6FvHyiLO/278IfZTDfns4H4XMi2UCWK/img.png|alignCenter|data-origin-width="223" data-origin-height="166" data-ke-mobilestyle="widthOrigin"|||_##]
​
[##_Image|kage@nsl6N/btq6DSQv3bh/zRSwPTQgCXHW3O4XMRgr91/img.png|alignCenter|data-origin-width="661" data-origin-height="629" data-ke-mobilestyle="widthOrigin"|||_##]
​
**✔ 연산자**
​
 : input A =2, input B =3 했을 때
​
```
<!-- 연산자 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<script type = "text/javascript">
var a = prompt("input A");
var b = prompt("input B");
var hap = 0;
hap = eval(a) + eval(b)
document.write("<br>1 hap =" + hap +"</br>");
​
​
var a = prompt("input A");
var b = prompt("input B");
var hap = 0;
a = Number(a);
b = Number(b);
hap = a+b
document.write("<br>2 hap =" + hap +"</br>");
​
​
var res = "1+2+3"
document.write("<br>3 hap =" + eval(res) + "</br>");
​
</script>
</body>
</html>
```
​
[##_Image|kage@oVbj1/btq6Ld7lISB/2kJYZtbY5521TwQKemU94k/img.png|alignCenter|data-origin-width="667" data-origin-height="633" data-ke-mobilestyle="widthOrigin"|||_##]
​
**✔ 제어문**
​
 : 2를 입력 했을 때
​
```
<!--제어문-->
​
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<script type = "text/javascript">
​
//====== ex1) 4계절을 선택적으로 출력하자 (if) ======
    
var str = prompt("input 1~4"); 
document.write("<hr><h1> If </h1>");
​
if (str==1){
    document.write("봄");}
else if (str==2){
    document.write("여름");}
else if (str==3){
    document.write("가을");}
else{
    document.write("겨울");}
​
​
//===== ex2) 숫자를 입력해 분기를 선택적으로 출력하자 (switch) ======
    
document.write("<hr><h1> Swich </h1>");
switch(str){
case '3' : document.writeln("3사분기");break;
case '4' : document.writeln("4사분기");break;
case '1' : document.writeln("1사분기");break;
case '2' : document.writeln("2사분기");break;
}
​
//====== ex3) 1,3 홀수, 2,4는 짝수다. (switch) ======
​
document.write("<hr><h1> Swich </h1>");
switch(str){
case '3' : //str='3'
case '1' : document.write("홀수<br>");break;
case '4' : 
case '2' : document.write("짝수<br>");break;
default : document.write("다른값이야");
}
​
​
//====== ex4) 1,3 홀수, 2,4는 짝수다.(for) ======
    
var hap =0;
    document.write("<hr><h1> for </h1>");
    
    for (i =1; i<=str ;i++){
        hap += i;
    }
    document.writeln("1과 "+ str + "의 합은 " + hap + "이다<br>");
​
    
//====== ex5) (while) ======
​
    document.write("<hr><h1> while </h1>");
while (str > 0){
    document.write(" while 구문이다. <br>");
    str--;  
    }
​
​
//====== ex5) (do~ while) ======
​
document.write("<hr><h1> do while </h1>");
do{
    document.write("do ~ while 구문이다. <br>");
} while (str>0);
​
​
///res02 = a+200;
///document.write(res02);
    
</script>
​
</body>
</html>
```
​
[##_Image|kage@buNikf/btq6FuPC5pB/nSiofByhZ3KUmK7ZbK1hx1/img.png|alignCenter|data-origin-width="823" data-origin-height="808" data-ke-mobilestyle="widthOrigin"|||_##]
