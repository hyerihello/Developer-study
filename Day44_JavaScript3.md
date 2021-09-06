**JS FORM 객체**

   1. <form> 태그는 독립적으로 사용하지 않는다.  
   2. <form> 태그 안에는 여러가지 입력 양식을 사용한다.  
   3. DOM (Document Object Model)로 접근해서 제어한다.  
   4. Form 객체를 액세스하여 제어한다.   
   5. js Form 객체 속성 : html을 tree구조인 Dom의 객체로 리턴을 받고 난 다음의 Form 객체속성  
 

  
  <HTMLFormElement>  
    
  **action**

     : 태그의 action과 동일하다.  
  **elements**

     : Form 태그안에 있는 양식(이너태그)을 배열로 관리  
  **length**

     : 이너태그의 갯수를 리턴  
  **name**

     : 태그의 name과 동일하다.  
  **method**

     : 태그의 method랑 동일하다.  
 ** target**

     : 태그의 target 랑 동일하다. 

  
    
  6. 폼 태그의 객체 탐색

      ex) <form name = 'fm'><input type ='text' name ="id"/></form>  
     

     6-1. document.fm.id.value / document.fm.name  
     6-2. document.forms\[0\].elements\[0\].value  
     6-3. document.forms\['fm'\].elements\['id'\].value  
     6-4. document.forms\['fm'\]\['id'\].value    
  

** # html 파일을 이용해 객체를 알아보자**

```
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<p align = "center">
	<font size ='4' color='blue'><b>회원정보입력</b></font>
</p>
<form name="myform" method="post" action ="res.html">
	아이디 : <input type = "text" name = "id" size = 10 /> <br>
	비밀번호 : <input type = "password" name = "pw" size = 10> <br>
	이름 : <input type = "text" name ="name" size = 10> <br><br>
	
	전화번호 : <input type="text" name ="tel" size ="3" value ="02">-
			<input type="text" name ="tel2" size ="4" >-
			<input type="text" name ="tel3" size ="4" > <br><br>
	직업 : <select size = "1" name ="job">
		  <option selected = "selected"> 자산관리사</option>
		  <option>프로그래머</option>
		  <option>회사원</option>
		  <option>기타</option>
		  </select> <br><br>
		  
	성별 : <input type = "radio" name = "s" value ="Male"> 남자 &nbsp;&nbsp;
		<input type = "radio" name ="s" value = "Female" checked = "checked"> 여자 <br><br>
		
	취미 : <input type = "checkbox" name = "hobby" value = "travel">
		여행 &nbsp;&nbsp; <input type = "checkbox" name = "hobby" value = "ski">
		스키 &nbsp;&nbsp; <input type = "checkbox" name = "hobby" value = "maunting" checked = "checked">
		등산 &nbsp;&nbsp; <input type = "checkbox" name = "hobby" value = "shopping">
		쇼핑 &nbsp;&nbsp; <br><br>
		
  자기소개 : <textarea rows="10" cols="50" name ="intro">
  		자기소개 간략하게 해보자</textarea>
  		
  		<br><br>
  		<input type = "button" value = "폼의 정보" onclick = "result()" />
  		<input type = "button" value = "확인" onclick = "formview(this.form)" />
  		<input type = "submit" value = "확인02"/> 
        # submit : 현재 폼의 데이터를 무조건 action의 페이지로 전달해줘! 서버에 요청
  		<input type = "reset" value = "취소"/>
</form>
</body>
</html>
```

1) 아래와 같이 화면이 출력 된다.

[##_Image|kage@bM8yPB/btq6TzvGiTb/wNIiBEgdNWH4Xa67GWdTHK/img.png|alignCenter|data-origin-width="756" data-origin-height="760" width="691" height="695" data-ke-mobilestyle="widthOrigin"|||_##]

  2) '확인02' 를 누르면 submit 이 적용되기 때문에 form의 action 의 element 인 res.html이 출력된다.

 : 자바스크립트 목적은 다음페이지로 실행되기 전 유효성 검사를 위함이기 때문에 submit은 제거하고 진행 하겠다.

```
<form name="myform" method="post" action ="res.html">
'''
  		<input type = "submit" value = "확인02"/> 
# ★submit : 현재 폼의 데이터를 무조건 action의 페이지로 전달해줘! 서버에 요청

</form>

```

[##_Image|kage@PlGav/btq6UcG8G2V/OV8NXtOZl8e7YIEA25k2UK/img.png|alignCenter|data-origin-width="756" data-origin-height="760" width="632" height="636" data-ke-mobilestyle="widthOrigin"|||_##]

 3) javascript 기능을 이용해서 <HTMLFormElement>를 알아보자.

   '폼의정보' 를 누르면 form태그의 result 가 javascript의 function의 result로 실행된다.

```
<script type="text/javascript">
	function result(){
	# ↓ 변수 , 변수이름 = 
		var dsp_str = "[1] name :" + document.myform.name + "\n"
			dsp_str += "[2] action :" + document.myform.action +"\n"
			dsp_str += "[3] target :" + document.myform.target +"\n"
			dsp_str += "[4] method :" + document.myform.method +"\n"
			dsp_str += "[5] encoding :" + document.myform.encoding +"\n"
			dsp_str += "[6] length :" + document.myform.length
		alert ("result : " + dsp_str); # === alert 창의 result : 변수이름 실행 ====
		
	}
</script>


<form name="myform" method="post" action ="res.html">

	<input type = "button" value = "폼의 정보" onclick = "result()" />

</form>

```

[##_Image|kage@dkS31e/btq6VsbEUP7/nIZzNrOQkIhVPs9YLxNqok/img.png|alignCenter|data-origin-width="758" data-origin-height="758" width="624" height="624" data-ke-mobilestyle="widthOrigin"|||_##]

```
 document.myform.name : [object HTMLInputElement] 
                       -- 태그의 name과 동일하다
 document.myform.action : http://localhost:8787/210608-/test02/res.html
                       -- 태그의 action과 동일하다.
 document.myform.target : 없음
                       -- 태그의 target 랑 동일하다.
 document.myform.method : post
                       -- 태그의 method랑 동일하다.
 document.myform.encoding : application/x-www-form-urlencoded

 document.myform.length : 18
                       -- 이너태그의 갯수를 리턴
```

  4) '확인' 을 누르면 formview(this.form) 이 function의 myform로 실행된다.

     조건문을 이용해 null값과 cheked가 되지 않은 요소를 리턴한다. 

```
<script type="text/javascript">
 function formview(myform){
		var el_str = "";
		 for(i =0; i <myform.length ;i++ ){
			 if (myform.elements[i].value == null || !myform.elements[i].checked){
				 el_str += myform.elements[i].name +"\n";
			 }
		 }
         alert ("formview ---->" + el_str); 
</script>
</head>



<body>
'''
<form name="myform" method="post" action ="res.html">
  		<br><br>
  		<input type = "button" value = "폼의 정보" onclick = "result()" />
  		<input type = "button" value = "확인" onclick = "formview(this.form)" />
  		<!-- <input type = "submit" value = "확인02"/> 현재 폼의 데이터를 무조건 action의 페이지로 전달해줘 서버에 요청-->
  		<input type = "reset" value = "취소"/>
</form>
</body>

```

[##_Image|kage@bAD6uD/btq6SvtO52f/QNWvjn8e79zJp0tkBejxpk/img.png|alignCenter|data-origin-width="756" data-origin-height="767" width="698" height="708" data-ke-mobilestyle="widthOrigin"|||_##][##_Image|kage@kzNjI/btq6Va3LMue/l82ErdNPGX95VkeABRNZWk/img.png|alignCenter|data-origin-width="756" data-origin-height="767" width="696" height="706" data-ke-mobilestyle="widthOrigin"|||_##]

    5) '확인' 을 누르면 formview(this.form) 이 function의 myform로 실행된다.

       조건문을 이용해 hobby 중 check가 된 요소를 리턴한다.

       3개를 선택하면 3개를 리턴한다.

```
<script type="text/javascript">
 function formview(myform){
         // ******* 체크박스 버튼 **********
		 var result = []; // 빈 체크박스를 생성한다.
		 // 각각의 name으로 바로접근
		 var f = myform.hobby; // 4개의 요소가 리턴된다.
		 for(i =0; i< f.length; i++){
			 if( f[i].checked){
				 result.push(f[i].value);
			 }
		 }
         alert ("formview ---->" + result); 
</script>
</head>



<body>
'''
<form name="myform" method="post" action ="res.html">
  		<br><br>
  		<input type = "button" value = "폼의 정보" onclick = "result()" />
  		<input type = "button" value = "확인" onclick = "formview(this.form)" />
  		<!-- <input type = "submit" value = "확인02"/> 현재 폼의 데이터를 무조건 action의 페이지로 전달해줘 서버에 요청-->
  		<input type = "reset" value = "취소"/>
</form>
</body>

```

[##_Image|kage@b9MhAF/btq6RHVL34D/9wK55njqiB9chZ6zgdBBQ0/img.png|alignCenter|data-origin-width="756" data-origin-height="767" width="678" height="688" data-ke-mobilestyle="widthOrigin"|||_##]

[##_Image|kage@xyaim/btq6VEQ0Ete/fJURiFovTkabbtsJ5FE7V0/img.png|alignCenter|data-origin-width="756" data-origin-height="767" width="688" height="699" data-ke-mobilestyle="widthOrigin"|||_##]

    5-1) '확인' 을 누르면 formview(this.form) 이 function의 myform로 실행된다.

       조건문을 이용해 hobby 중 check가 된 요소를 리턴한다.

       3개를 선택하면 3개를 리턴한다. -- intro 이용!

```
<script type="text/javascript">
 function formview(myform){
         // ******* 체크박스 버튼 **********
		 var result = []; // 빈 체크박스를 생성한다.
		 // 각각의 name으로 바로접근
		 var f = myform.hobby; // 4개의 요소가 리턴된다.
		 for(i =0; i< f.length; i++){
			 if( f[i].checked){
				 result.push(f[i].value);
			 }
		 }
        //alert ("formview ---->" + result); 
		myform.intro.value = result;
         -- 12행 주석처리하고 13행을 실행하면 intro 안에 입력된다.
         
  자기소개 : <textarea rows="10" cols="50" name ="intro">
  		자기소개 간략하게 해봐</textarea>
        
</script>	
 
```

[##_Image|kage@c3APnH/btq6W2cykX9/u0RzbD6UvkAOMZYhbsXZe0/img.png|alignCenter|data-origin-width="756" data-origin-height="767" width="689" height="700" data-ke-mobilestyle="widthOrigin"|||_##]

    6) '확인' 을 누르면 formview(this.form) 이 function의 myform로 실행된다.

       조건문을 이용해 성별 중 radio 버튼중 선택된 요소를 리턴한다.

```
<script type="text/javascript">
 function formview(myform){
 
		 // ******* 라디오 버튼 **********
		 var result02 = []; // 빈 배열 객체를 생성한다.
		 // 각각의 name으로 바로접근
		 var f = myform.s; // 2개의 요소가 리턴된다.
		 for(i =0; i< f.length; i++){
			 if( f[i].checked){ //선택된 값만 저장 물론 라디오는  []가 아니어도 된다. 하나만 선택되기 때문.
				 result02.push(f[i].value);
			 }
		 }
         
		// 문자열로 출력, intro에 style 속성이 따로 있어 변경, 
        // 문자열로 병합해서 대입했기 때문에 전체가 문자열로 출력 
		myform.intro.value = "<br><font size = '7'>" + result02 + "</font>";
</script>			
 
 
  자기소개 : <textarea rows="10" cols="50" name ="intro">
  		자기소개 간략하게 해봐</textarea>
        
<body>
'''
<form name="myform" method="post" action ="res.html">
  		<br><br>
  		<input type = "button" value = "폼의 정보" onclick = "result()" />
  		<input type = "button" value = "확인" onclick = "formview(this.form)" />
  		<!-- <input type = "submit" value = "확인02"/> 현재 폼의 데이터를 무조건 action의 페이지로 전달해줘 서버에 요청-->
  		<input type = "reset" value = "취소"/>
</form>
</body>
        

 
```

[##_Image|kage@AgqG8/btq6Wv0p8LE/e6E7Sdwc6RRZTJdBX6Wj30/img.png|alignCenter|data-origin-width="756" data-origin-height="767" data-ke-mobilestyle="widthOrigin"|||_##]

**😎 전체코드**

```
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
	function result(){
		
		var dsp_str = "[1] name :" + document.myform.name + "\n"
			dsp_str += "[2] action :" + document.myform.action +"\n"
			dsp_str += "[3] target :" + document.myform.target +"\n"
			dsp_str += "[4] method :" + document.myform.method +"\n"
			dsp_str += "[5] encoding :" + document.myform.encoding +"\n"
			dsp_str += "[6] length :" + document.myform.length
		alert ("result : " + dsp_str);
		
	}
	function formview(myform){
		/*var el_str = "";
		 for(i =0; i <myform.length ;i++ ){
			 if (myform.elements[i].value == null || !myform.elements[i].checked){
				 el_str += myform.elements[i].name +"\n";
			 }
		 } */
		 
		 var result = []; // 빈 체크박스를 생성한다.
		 // 각각의 name으로 바로접근
		 var f = myform.hobby; // 4개의 요소가 리턴된다.
		 for(i =0; i< f.length; i++){
			 if( f[i].checked){
				 result.push(f[i].value);
			 }
		 }
		 
		 // ******* 라디오 버튼 **********
		 
		 var result02 = []; // 빈 배열 객체를 생성한다.
		 // 각각의 name으로 바로접근
		 var f = myform.s; // 2개의 요소가 리턴된다.
		 for(i =0; i< f.length; i++){
			 if( f[i].checked){ //선택된 값만 저장 물론 라디오는  []가 아니어도 된다. 하나만 선택되기 때문.
				 result02.push(f[i].value);
			 }
		 }
		 
		 
		//alert ("formview ---->" + el_str); 위에주석
		//alert ("formview ---->" + result); 
		// 위의것 myform.intro.value = result;
		
		//문자열로 출력, intro에 style 속성이 따로 있어 변경, 문자열로 병합해서 대입했기 때문에 전체가 문자열로 출력 
		 myform.intro.value = "<br><font size = '7'>" + result02 + "</font>";
			
		
	}

</script>
</head>
<body>
<p align = "center">
	<font size ='4' color='blue'><b>회원정보입력</b></font>
</p>
<form name="myform" method="post" action ="res.html">
	아이디 : <input type = "text" name = "id" size = 10 /> <br>
	비밀번호 : <input type = "password" name = "pw" size = 10> <br>
	이름 : <input type = "text" name ="name" size = 10> <br><br>
	
	전화번호 : <input type="text" name ="tel" size ="3" value ="02">-
			<input type="text" name ="tel2" size ="4" >-
			<input type="text" name ="tel3" size ="4" > <br><br>
	직업 : <select size = "1" name ="job">
		  <option selected = "selected"> 자산관리사</option>
		  <option>프로그래머</option>
		  <option>회사원</option>
		  <option>기타</option>
		  </select> <br><br>
		  
	성별 : <input type = "radio" name = "s" value ="Male"> 남자 &nbsp;&nbsp;
		<input type = "radio" name ="s" value = "Female" checked = "checked"> 여자 <br><br>
		
	취미 : <input type = "checkbox" name = "hobby" value = "travel">
		여행 &nbsp;&nbsp; <input type = "checkbox" name = "hobby" value = "ski">
		스키 &nbsp;&nbsp; <input type = "checkbox" name = "hobby" value = "maunting" checked = "checked">
		등산 &nbsp;&nbsp; <input type = "checkbox" name = "hobby" value = "shopping">
		쇼핑 &nbsp;&nbsp; <br><br>
		
  자기소개 : <textarea rows="10" cols="50" name ="intro">
  		자기소개 간략하게 해봐</textarea>
  		
  		<br><br>
  		<input type = "button" value = "폼의 정보" onclick = "result()" />
  		<input type = "button" value = "확인" onclick = "formview(this.form)" />
  		<!-- <input type = "submit" value = "확인02"/> 현재 폼의 데이터를 무조건 action의 페이지로 전달해줘 서버에 요청-->
  		<input type = "reset" value = "취소"/>
</form>
</body>
</html>
```
