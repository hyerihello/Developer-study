✨ JS의 구동원리를 구현하고 사용할 수 있다.  
✨ 배열과 함수, 폼데이터처리, 이벤트연동, 검증하는 방법등을 구현할 수 있다. 

  
  
**✔ 배열** 

  : 하나 이상의 상수를 나열해서 하나의 이름으로 등록해서 사용하는 참조형으로

    원소(요소)를 인덱스로 관리하며 0부터 시작한다.  
    lenth 속성을 가진다.  
    
**\[형식\]**  
**user\_name = new Array(요소....또는 요소의 사이즈);**

  
ex) var av = new Array (10,    20,    30,    40,   "abc");  
          av -----------> av\[0\] av\[1\] av\[2\]   av\[3\]   av\[4\]

  
join() : 배열을 하나의 문자열로 만든다.   
reverse() : 역순  
sort(): 정렬  
slice(): 배열의 일부를 선택해서 부분적인 새로운 배열을 생성한다.  
concat(): 두 개의 배열을 하나의 배열로 생성한다.    
  

  
**✔ 함수**

  : 프로그램 내에서 특정 작업을 수행을 위해 독립적으로 만들어진 하나의 단위  
   <head>~</head> 태그 사이에  funtion 으로 시작 {값}

\[형식\]  
 function user\_name(arguements, , ){  
      명령;  
       }  
user\_name(arguement\_values);

```
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
	<script type = "text/javascript">
	function call_name(name){
		document.write("안녕하세요!" + name + "<br>")
	}
	</script>
</head>
<body> 
	<script type = "text/javascript"> 
	call_name("Dominica");
	call_name("Dominico");
	</script>


</body>
</html>
```

[##_Image|kage@TgQOw/btq6RaCg9P0/S36iq9R5Q7N9fq1pcLiHj0/img.png|alignCenter|data-origin-width="674" data-origin-height="296" data-ke-mobilestyle="widthOrigin"|||_##]

https://blog.kakaocdn.net/dn/TgQOw/btq6RaCg9P0/S36iq9R5Q7N9fq1pcLiHj0/img.png


```
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>function_exam</title>
<script type = "text/javascript">

 // 함수를 이용해서 html table 태그의 속성값을 변경해보자.
 function Result(){
	 myTlb = new Array("도미니카 홈페이지","도미니꼬 홈페이지",
			 "폴리오 홈페이지", "일로 홈페이지", "루리홈페이지", "루서홈페이지",
			 "루오 홈페이지")
	myTlbColor = new Array("#DB7093", "#D8BFD8");
	 for (i =0; i<myTlb.length ; i++){
		 document.write("<tr>");
		 document.write("<td bgcolor='", myTlbColor[i% 2], "'>");
		 document.write(myTlb[i]);
		 document.write("</td>");
		 document.write("</tr>");
	 }
 }
 
</script>

</head>
<body>
<table border = "1">
	<script type = "text/javascript">
		Result();
	</script>
</table>

</body>
</html>
```

[##_Image|kage@dw966A/btq6NtisU7e/pNxG67psxyIjnZkbRzaVj1/img.png|alignCenter|data-origin-width="675" data-origin-height="358" data-ke-mobilestyle="widthOrigin"|||_##]

  
  
**✔ 내장함수  **

  
1\. eval (String) : String을 자바 스크립트 코드로 실행 eval ("100+100")  
2\. isFinite(Number) : 무한 값의 유무  
3. isNan(Number):NaN 유무  
4\. parseInt(String, 진수) : String 진수의 정수로 변환  
5\. parseFloat(String) : String 유리수로 변환  
6\. escape( ): 인코딩변환  
7\. unescape() : 디코딩변환  
8\. encodeURI(uri) : 최소한의 문자만 인코딩  
9. decodeURI(endodeURI) : 최소한의 문자만 디코딩    
  

```
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title> 내장함수 </title>
</head>
<body>
<script type="text/javascript">
var acnt = "1+3+4+5";
document.write(acnt + "=" + eval(acnt) + "입니다<br>");
document.write("한글 : escape('대한민국')" +"=" + escape('대한민국') + "입니다<br>");
document.write("unescape('%uB300%uD55C%uBBFC%uAD6D') ===> " +
		unescape('%uB300%uD55C%uBBFC%uAD6D') + "<p>");
		
document.write("unescape('%21%23%24') ===> " +
		unescape('%21%23%24') + "<p>");
</script>
</body>
</html>
```

[##_Image|kage@bY9xgU/btq6MAihkOO/b8DEPzHRcK3zu4L4sqGGF0/img.png|alignCenter|data-origin-width="672" data-origin-height="442" data-ke-mobilestyle="widthOrigin"|||_##]

  
**✔ 내장객체**

  
Date  
1\. setYear() : (1970)년도 이상의 년도를 설정  
2\. setMonth() : 0=1월  
3\. setDate() : 일을 설정한다.  
4. setDay() : 요일을 설정. (0 = 일요일)  
5\. setTime() : 1970년 1월 1일 이후 시간을 1/1000 으로 나타낸 값  
6\. setHours() : 시간  
7\. setMinutes() : 분  
8\. setSeconds() : 초   
    <-> get

  
  객체 = property + message

  인스턴스 객체 = new 를 이용한 생성된 객체

**\[형식\]**  
**function user\_name (arguements){**  
**     this.이름 = 매개변수;**  
** }**  
** 객체이름 = new user\_name(arguements);**  
 

```
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>내장객체_Date</title>
</head>
<body>
<script type="text/javascript">
var day, week;
var today = new Date();
week = new Array("일","월","화","수","목","금","토");
day = week [today.getDay()];
document.write("오늘은 :" + today.getFullYear()+"년"+
					(today.getMonth()+1) +"월"+
					today.getDate()+"일"+
					day + "요일");


document.write("<hr>");
document.write(Math.max(10,20) + "<br>");
document.write(Math.min(10,20) + "<br>");
document.write(Math.ceil(7.8) + " 올림 <br>");
document.write(Math.floor(7.8) + " 내림 <br>");
document.write(Math.abs(-7) + " 절대값 <br>");
document.write(Math.PI + " <br>");


</script>


</body>
</html>
```

[##_Image|kage@oSjWQ/btq6Ra974B8/MGO6XP3ROkOcKfdIrWuoT0/img.png|alignCenter|data-origin-width="674" data-origin-height="359" data-ke-mobilestyle="widthOrigin"|||_##]

[##_Image|kage@CWsap/btq66UlZeOn/b5CHsXHLL4EiHSdbnYvhjK/img.png|alignCenter|data-origin-width="752" data-origin-height="291" width="682" height="264" data-ke-mobilestyle="widthOrigin"|||_##]

1. for\_in : 하나 이상의 나열형 값을 가진 객체의 배열 형식을 표시할 때 사용  
2\. with : 객체에 포함된 속성이나 메소드를 여러번 사용할 때 with문으로 객체를 한 번 선언한 후

           with문 안에서 객체를 생략하고 속성이나 메소드 명만 가지고 사용한다.  
3\. typeof null   
 

```
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>객체 생성</title>
<script type="text/javascript">
	function sung(my_name, kor, eng, mat){
		this.my_name = my_name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		
		this.gettot = function(){
			tot = this.kor + this.eng + this.mat;
			return tot;
		}
		
		this.getavg = function(){
			avg = this.gettot()/3;
			return avg;
		}
	}
</script>
</head>
<body>
	
	<script type="text/javascript">
		var jumsu=[];
		jumsu[0]=new sung("도미니까",100,80,70);
		jumsu[1]=new sung("도미니꼬",90,80,100);
		jumsu[2]=new sung("도미니까01",100,80,70);
		jumsu[3]=new sung("도미니까02",90,100,70);
		
		for (i =0 ; i<jumsu.length; i++){
			document.write(jumsu[i].my_name +":"
					+ jumsu[i].gettot()+ ":"+
					 jumsu[i].getavg()+"<br>");	
		}
		
	document.write("<hr>");
		for (res in jumsu){
			document. write (jumsu[res].my_name +":"
					+ jumsu[res].gettot()+ " : "+
					jumsu[res].getavg()+"<br>");	
		}
		//document.write(typeof jumsu + "<br>");
		//document.write(typeof 111);
		
	</script>

</body>
</html>
```

[##_Image|kage@bQtprs/btq6QPrCH4q/vcBA6q8irPOUOhDMyaolP1/img.png|alignCenter|data-origin-width="673" data-origin-height="345" data-ke-mobilestyle="widthOrigin"|||_##]

###   
** JS DOM (Document object Model)**

  
    html, xml 문서에 대한 프로그래밍 인터페이스  
    객체지향 모델로써 구조화된 문서를 표현하는 형식  
    플랫폼/ 언어 중립적으로 구조화된 문서를 표현하는 w3c의 공식표준   
    [https://dom.spec.whatwg.org/](https://dom.spec.whatwg.org/)  
    [https://www.w3.org/DOM/DOMTR](https://www.w3.org/DOM/DOMTR)  
  

  
1\. document : Dom의 최고 상위객체, html문서  
2\. element : html 문서에 사용되는 모든태그, 요소  
3\. attribute : 엘리먼트가 가진 속성  
4\. node : 객체를 지칭, 요소, 속성, 텍스트등을 말한다.   
    4-1. nodeName : 노드의 이름을 리턴, 텍스트 노드 #text  
    4-2. nodeType : 노드의 유형을 정수로 리턴(1:요소, 2.속성, 3:텍스트, 8:주석)  
    4-3. childNodes : 노드의 자식노드, 노드리스트(배결)  
    4-4. firstChild : 노드의 첫번째 자식 노드를 리턴  
    4-5. lastChild : 노드의 마지막 자식 노드를 리턴  
    4-6. previousSibling : 노드의 이전 위치에 자리한 형제 노드를 리턴  
    4-7. nextSibling : 노드의 다음 위치에 자리한 형제 노드를 리턴   
    4-8. parentNode : 노드의 부모노드를 리턴 

```
<html>
	<head>
		<title>mynode_test</title>
	</head>
	<body>
		<div>문서 객체는 트리구조를 만들 수 있다.</div>
		<script type="text/javascript">
			document.write(document.firstChild.childNodes[0]);
			document.write(document.firstChild.childNodes[1]);
			 // body 객체를 출력하고 싶다.
			document.write(document.firstChild.childNodes[2] +"<br>");
			var res = document.firstChild.childNodes[2]; //[object HTMLBodyElement]
			document.write(typeof res + "<br> ->" + res.nodeName); // Node의 객채로 가져온다.
			document.write("<br> ->" + res.nodeType);
			document.write("<br> ->" + res.nodeValue);
			
			 //div 태그 가져온다.
			document.write("<br> ->" + res.childNodes[1].nodeName);
			 
			 // div안에 text 인 문서객체는 트리구조를 만들수 있다.  를 리턴해보자.
			document.write("<br> ->" + res.childNodes[1].textContent);
			document.write("<br> ->" + res.childNodes[1].innerHTML);
			document.write("<br> 여섯번째" + 
					document.firstChild.childNodes[2].childNodes[1].innerText);
			//document.write(document.firstChild.innerHTML);
			//document.write(document.firstChild.innerText);
		</script>
	</body>
</html>
```

[##_Image|kage@blO0vI/btq6RLWwohU/XJ7HgosFQpKqROu3RdEKhk/img.png|alignCenter|data-origin-width="673" data-origin-height="344" data-ke-mobilestyle="widthOrigin"|||_##]

```
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<!-- <div><p><a href = "www.naver.com"> 네이버 </a></p></div> -->
<script type="text/javascript">
 var myDiv = document.createElement("div");
 var myPtag = document.createElement("p");
 var myAtag = document.createElement("a");
 myAtag.setAttribute("href","http://www.naver.com");
 
 var txt1 = document.createTextNode("네이버");
 myAtag.appendChild(txt1);
 
 myPtag.appendChild(myAtag);
 myDiv.appendChild(myPtag);
 
 document.body.appendChild(myDiv);
</script>
</body>
</html>
```

[##_Image|kage@cDno3Q/btq6QM9rTu1/kkgq9oA3xKB8A4LaFMuzwK/img.png|alignCenter|data-origin-width="1158" data-origin-height="670" data-ke-mobilestyle="widthOrigin"|||_##]
