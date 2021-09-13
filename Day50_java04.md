## **Serializable **
​
자바 시스템 내부에서 사용되는 Object 또는 Data를 외부의 자바 시스템에서도 사용 가능 하도록
​
byte 형태로 데이터 변환하는 기술을 말함.
​
캐시 등에서 사용된다. 
​
## **package / class**
​
**✔ Carender(util package)**
​
 ex)  java.util package의  carender class 를 통해 class의 특징을 살펴보자.
​
아래 docs 참고
​
[https://docs.oracle.com/javase/8/docs/api/index.html](https://docs.oracle.com/javase/8/docs/api/index.html)
​
[
​
Java Platform SE 8
​
docs.oracle.com
​
​
​
](https://docs.oracle.com/javase/8/docs/api/index.html)
​
[##_Image|kage@bUp25J/btq8lYAEJOd/hfALGEkHv8Z0q0HKBhjoB1/img.png|alignCenter|data-origin-width="705" data-origin-height="341" data-ke-mobilestyle="widthOrigin"|출처&nbsp;https://docs.oracle.com/javase/8/docs/api/index.html||_##]
​
java.util 패키지 안에 Calender 를 살펴보면 java.lang의 object 가 선조이다.     
​
abstract : 추상클래스를 뜻한다.
​
구현된 모든 interface에는 Serializable (직렬화), Cloneable(복제) 가 포함되어있다.
​
GregorianCalendar : e클래스 생성 또는 calender 상속 받거나 둘 중 하나이다.
​
[##_Image|kage@5FzGY/btq8jejDdMO/cphk0q0Eea1TKX1Zwd0Q40/img.png|alignCenter|data-origin-width="668" data-origin-height="246" data-ke-mobilestyle="widthOrigin"|||_##]
​
기본생성자 () (new 생성불가)와 오버로드생성자 총 2개로 이루어져있다. 
​
※ 클래스를 확인할 때는 생성자유/무, 해당클래스가 어떤 클래스인지 확인해야한다.
​
**✔ integer class (lang package)**
​
[##_Image|kage@y3P14/btq8lwEh2sW/Oew5iDkGyBrntbTuvHeUr1/img.png|alignCenter|data-origin-width="770" data-origin-height="305" data-ke-mobilestyle="widthOrigin"|||_##]
​
Number 클래스를 참조하고 있다.
​
final : 마지막 후손 class이기 때문에 더 이상 후손은 불가능 하다.
​
  = number의 자식이기 때문에 float, Double 모두 String s 오버로드 생성자 가지고있음
​
[##_Image|kage@c07lLn/btq8hlqk3VX/KM6ltwkfc6jEtoFkdkMYk0/img.png|alignCenter|data-origin-width="833" data-origin-height="218" data-ke-mobilestyle="widthOrigin"|||_##]
​
기본 생성자는 없다. (괄호가 비어있어야 기본 생성자 이다)
​
2개의 오버르드 생성자 (int, string (문자열에 있는 정수를 int로 파싱))
​
**✔ Object class (lang package)**
​
  : 모든 class의 super class
​
[##_Image|kage@cCPd5x/btq8okitcsX/DEKilns9WvfGyAvuHvNLtK/img.png|alignCenter|data-origin-width="1105" data-origin-height="498" data-ke-mobilestyle="widthOrigin"|||_##]
​
 ex) to Stirng  →  재정의 가능  
         random  → 재정의 불가
​
```
package com.test;
​
/*      == 주소 비교 연산자 (재정의 불가)
        new Car("bm7") == new Car("bm7")
        = new Car("bm7").toString() == new Car("bm7").toString() - 재정의 가능,
         - 재정의 하지 않을 때는 주소 비교연산자이다. 
​
         */
​
public class Test01 {
    
    public static void main(String[] args) {
        
        Integer i = new Integer(100);
        System.out.println(i + ":" + i.toString());
        
        Integer i2 = new Integer("100"); // 파싱
        System.out.println(i2 + 10 + "\t" + (i2.toString() + 100)); 
        // i2 + 10 은 형변환을 일으켜 110을 리턴하고
        // (i2.toString() + 100) 은 문자열로 인식해 결합하여 100100을 리턴한다.
        
        
        Double d1 = new Double("92.9");
        System.out.println(d1 + ":" + d1.toString() + "\t" + (d1.toString()+30)); 
                // (d1.toString()+30) : 문자열, 결합된다.
        
        
        Integer i3 = 100; //Integer i3 = new Intger(100) 의 내용이 숨어있다.
        System.out.println(i3);
        
        Double d3 = 97.9;
        System.out.println(d3);
        
        
        double d4 = new Double(98.9); // 내포클래스 자동호환 
        System.out.println(d4); // 객체를 일반 자료형을 만들기 때문에 d4.으로확인하면 매서드가 나오지 않는다.
        // d3. 으로하면 매서드가 나온다.
    }
    // to.String docs보면 Overrides:
    // toString in class Object -> 재정의했다. 
}
​
===============================================================================
​
100:100
110 100100
92.9:92.9   92.930
100
97.9
98.9
​
```
​
**✔ String class (lang package)**
​
[##_Image|kage@885CQ/btq8ntmre74/xKnE5NP6JBMZLbGl94tZpK/img.png|alignCenter|data-origin-width="914" data-origin-height="282" data-ke-mobilestyle="widthOrigin"|||_##]
​
Class String  = 
​
  
 String str = "abc";  string class는 주소를 참조한다.  
 string : 모든 메소드가 변환한 것을 그대로 리턴 하는것  
 burffer,builder 은 스스로 CRUD가된다.
​
```
package com.test;
​
public class Test02 {
​
    public static void prn() {
        //String(String original)
        
        String str = "The String class represents character strings.";
        String str02 = new String(str);
        String str03 = new String (new String("The String class represents character strings."));
        String str04 = new String ("The String class represents character strings.");
        
        System.out.println(str + "\n"+ str02 + "\n"+ str03 + "\n"+ str04); // 모두 같은 결과를 가져온다
        
        
        String res = str.toUpperCase();
        System.out.println(res); // 변수를 리턴하면 대문자를 출력하지만,
        System.out.println(str); // 초기값은 변하지 않는다.
                
        
    }
    
    ======================================================
​
/*
The String class represents character strings.
The String class represents character strings.
The String class represents character strings.
The String class represents character strings.
THE STRING CLASS REPRESENTS CHARACTER STRINGS.
The String class represents character strings.
*/
```
​
**StringBuffer **
​
 : 버퍼 크기의 기본값은 16개의 문자를 저장할 수 있는 크기, 생성자를 통해 그 크기를 별도로 설정할 수도 있다.
​
```
package com.test;
​
public class Test02 {
​
    public static void prn02() {
    /* 
    
    String 클래스의 인스턴스는 한 번 생성되면 그 값을 읽기만 할 수 있고, 변경할 수는 없다.
    StringBuffer,Builder 클래스의 인스턴스는 그 값을 변경할 수도 있고, 추가할 수도 있다.
    
    1. String = C
       : 순수 문자열 관리
        
    2.  StringBuffer = C - append/insert,  R - toString, U - replace, setCharAt  D - delete/ deleteCharAt
       : A thread-safe, mutable sequence of characters. 문자열을 가져다가 조작하는 데 안전함 (네트워크 통신 사용)
        
    3.  StringBuilder = C - append/insert,  R - toString, U - replace, setCharAt  D - delete/ deleteCharAt
       : 웹에서 대부분 사용  
    */
        
        
      // ex1. 
        StringBuffer sb = new StringBuffer();
        sb.append("abc");
​
        System.out.println(sb.capacity()); //용량은 계속 16개를 리턴하는것을 확인하자. 1번 append 전.후
        System.out.println(sb);
            
    }
    public static void main(String[] args) {
​
        prn02();    
    }
}
==========================================================================
16
abc
​
```
​
```
// ex2. 
​
StringBuffer sb = new StringBuffer();
    for (int i = 0; i > 16; i++) { // i 가 16보다 크면 16을 리턴 (기본값) -> 14,15도 마찬가지
            sb.append(i);}
​
​
​
StringBuffer sb = new StringBuffer();
    for (int i = 0; i<= 16; i++) { // i 가 16보다 같거나 작으면 용량 커진다. 34를 리턴
        sb.append(i);}
        
        
StringBuffer sb = new StringBuffer();
    for (int i = 0; i<= 34; i++) { // i 가 34보다 같거나 작으면 용량 커진다. 70을 리턴
        sb.append(i);}        
        
 // 위에 'String Buffer ~ append' 는 차례로(총3가지) 블럭처리 하면서 리턴해보기
 
 
        System.out.println(sb.capacity()); //용량은 기본 16, 숫자가 커지면 용량도 커지는것을 확인하자.
        System.out.println(sb);
            
    }
    public static void main(String[] args) {
​
    prn02();
    
===========================================================
16
​
34
012345678910111213141516
​
70
012345678910111213141516171819202122232425262728293031323334
​
​
    
```
​
```
// ex3
​
StringBuffer sb = new StringBuffer();
    for (int i = 0; i<= 16; i++) { // i <= 34 는 70리턴 
            sb.append((char)i);}
​
System.out.println(sb.capacity()); 
System.out.println(sb);
 ==================================================
​
```
​
[##_Image|kage@cGZUVE/btq8mUkiHRb/ro1JIzTscW01qWyYS0FZc0/img.png|alignCenter|data-origin-width="567" data-origin-height="139" data-ke-mobilestyle="widthOrigin"|||_##]
​
```
// ex5.
​
StringBuffer sb = new StringBuffer();
​
for (int i = 65; i <= 80; i++) { // i = 65 일때 80이하까지 1씩더해서 리턴하자. char로도 리턴해보자.
    sb.append(i);
    sb.append((char)i);}
​
​
    System.out.println(sb.capacity()); //용량은 기본 16, 숫자가 커지면 용량도 커지는것을 확인하자.
    System.out.println(sb);
​
    }
    public static void main(String[] args) {
    prn02();
    }
}
============================================================
70 // -> 65가 더해진 상태에서 capacity 출력
65A66B67C68D69E70F71G72H73I74J75K76L77M78N79O80P
​
//위의 sb.append(i); 하고 다시 출력해보면 아래와 같다.
​
16 // -> 기본 capacity 출력
ABCDEFGHIJKLMNOP
​
```
​
**delete : 인덱스값을 기준으로 시작, 끝을 지정하여 삭제 할 수 있다.**
​
```
// ex6. delete 매서드를 이용해 D,E,F를 지워보자.
​
StringBuffer sb = new StringBuffer();
​
for (int i = 65; i <= 80; i++) { // i = 65 일때 80이하까지 1씩더해서 리턴하자. char로도 리턴해보자.
    sb.append(i);
    sb.append((char)i);}
​
​
    sb.delete(3,6); // delete(int start, int end) 
    System.out.println(sb.capacity()); //용량은 기본 16, 숫자가 커지면 용량도 커지는것을 확인하자.
    System.out.println(sb);
​
    }
    public static void main(String[] args) {
    prn02();
    }
}
============================================================
16
ABCGHIJKLMNOP
​
```
​
[##_Image|kage@mejgC/btq8lDKl2cG/W74DkotwHzjOpTkRz3gF91/img.png|alignCenter|data-origin-width="1071" data-origin-height="403" data-ke-mobilestyle="widthOrigin"|||_##]
​
  
**StringBuilder :** 위에 나와있는 모든 케이스를 동일하게 적용 가능하다.
​
**Builder, Buffer차이점 **
​
**:** 두 가지 클래스는 모두 쓰임과 메소드가 같다.
​
StringBuffer는 여러 곳에서 동시에 같은 문자열 , 인스턴스 접근 시에 중복 점유를 막을 수 있는 장치가 되어 있다.
​
안전함, 네트워크 처리에 용이 (동기화 처리). StringBuilder에 비해 좀 더 무거움.
​
  특별한 이유가 없다면 StringBuilder를 사용하는 것이 일반적이다.
​
```
// String Builder 도 위의 케이스 모두 적용 가능하다.
​
StringBuilder sb = new StringBuilder(20); // 용량 값을 지정해보자. 20으로
​
for (int i = 65; i <= 80; i++) { // i = 65 일때 80이하까지 1씩더해서 리턴하자. char로도 리턴해보자.
    sb.append(i);
    sb.append((char)i);}
​
​
    sb.delete(3,6); // delete(int start, int end) 
    System.out.println(sb.capacity()); //용량은 기본 16, 숫자가 커지면 용량도 커지는것을 확인하자.
    System.out.println(sb);
​
    }
    public static void main(String[] args) {
    prn02();
    }
}
============================================================
20
ABCGHIJKLMNOP
​
```
​
**ex 01) **
​
**"The String class represents character strings."  의 내용을 cnvr ()메소드로 대입해서  **
​
** 대문자의 개수와 소문자의 개수를 출력하고,  대문자를 소문자로 소문자를 대문자로 변환 후 리턴 해보자.**
​
```
package com.test;
​
/*
 문제 1) 
 The String class represents character strings.  의 내용을 cnvr ()메소드로 대입해서
 대문자의 개수와 소문자의 개수를 출력하고
 대문자를 소문자로, 소문자를 대문자로 변환 후 리턴받는다.
​
 1. String ->  char[] 메소드 찾기 
 2. for -> character의 메소드를 이용해서 소문자인지, 대문자인지 판별하는 메소드를 이용해서 조건문을 사용 후 cnt 한다.
 3. character 의 대문자로, 소문자로 바꿔주는 메소드를 찾아서 변환
​
*/
​
public class Exam01 {
    //          ↓ void가 없으니 return 받아야함
    public static String cnvr (String res) { // res = str을 참조한다 
        
        // 대문자의 갯수와 소문자의 갯수를 출력하기 위해 문자열(string)을 새 문자 배열(char)로 변환하자.
        // == public char[] toCharArray() 메서드 사용
        
        char[] ch_res = res.toCharArray(); //str을 참조한 res를 문자 배열로 변환!
        int cnt_u = 0; // 대문자 개수
        int cnt_l = 0; // 소문자 개수
        
        for (int i = 0; i < ch_res.length; i++) {// i가 0이고 배열로 변환한 ch_res의 길이보다 작을때 i를 더한다.
            // Character.isUpperCase() : 입력받은 인자가 대문자의 여부를 판단하여 true,false 반환
            if(Character.isUpperCase(ch_res[i])){
                ch_res[i] = Character.toLowerCase(ch_res[i]); // 입력받은 인자 값을 소문자로 변환 후 리턴
                cnt_u++; // 대문자 갯수에 카운팅을 한다.
            }
            else if(Character.isLowerCase(ch_res[i])){
                ch_res[i] = Character.toUpperCase(ch_res[i]);
                cnt_l++;
            }
        }
        System.out.println("대문자의 개수 : " + cnt_u + "소문자의 개수 : " + cnt_l);
        
        return new String(ch_res); // 새로운 문자열(String) 출력
        
    }
    
    public static void main(String[] args) {
        String str = "The String class represents character strings. "; // orn 변수는 str
        String res = cnvr(str); // cnvr 메소드 대입하는 변수는 res
        System.out.println(res);
​
        
    }
}
​
​
=========================================================================
​
대문자의 개수 : 2소문자의 개수 : 38
tHE sTRING CLASS REPRESENTS CHARACTER STRINGS. 
​
```
​
**ex 02)** str을 받은 cnvr조작 해보자.  
   1. 전체를 대문자로 출력 toUpperCase()  
   2. 전체를 소문자로 출력  toLowerCase()  
   3. 공백을 제거후 출력 trim()  
   4. 공백을 찾아 하트로 출력  
   5. 입력된 글자를 삭제 후 출력 = Scanner 사용  
   6. 문자열을 하나식 바이트로 변환 후 출력 get byte  
   7. 문자열을 공백으로 분철해서 분철된 데이터를 출력하자. trim()
​
   8. 문장안에 숫자를 넣고, 숫자만 꺼내서 합을 구하기.
​
```
package com.test;
​
import java.util.Scanner;
​
​
/*
   문제2) str을 받은 cnvr조작 해보자.
 1. 전체를 대문자로 출력 : public String toUpperCase()
 2. 전체를 소문자로 출력 : public String toLowerCase()
 3. 공백을 제거후 출력 : public String trim()
 4. 공백을 찾아 하트로 출력 : public String replace(CharSequence target,
                                              CharSequence replacement)
 5. 입력된 글자를 삭제 후 출력 : Scanner sc = new Scanner(System.in);
                          int i = sc.nextInt();
 6. 문자열을 하나식 바이트로 변환 후 출력 : get byte public byte[] getBytes()
 7. 문자열을 공백으로 분철해서 분철된 데이터를 출력하자. : public String[] split(String regex)
 8(+). 문장안에 숫자를 넣고, 숫자만 꺼내서 합을 구하기. : public char[] toCharArray()
*/
​
​
public class Exam02 {
​
    public static void cnvr(String res) {
        String res01 = res.toUpperCase();
        System.out.println(res01);
        
        
        String res02 = res.toLowerCase();
        System.out.println(res02);
        
        String res03 = res.trim();
        System.out.println(res03);
        
        String res04 = res.replace(' ', '♥');
        System.out.println(res04);
        
        Scanner s = new Scanner(System.in); // 값을 받아야함
        String res05 = s.nextLine();
        System.out.println(res05);
        System.out.println(res.replace(res05," "));
        
        byte[] res06 = res.getBytes();
        System.out.println(res06);
        
        String[] res07 = res.split(" ");
        for (int i = 0; i < res07.length; i++) {
        System.out.println(res07[i]);
        }
        
        
        char [] res08 = res.toCharArray();
        int sum = 0;
        for (int i=0; i<res08.length; i++) {
            if(Character.isDigit(res08[i]));
            sum += Character.getNumericValue(res08[i]);
            
        }
        System.out.println(sum);
                
        
        
        
    }
    public static void main(String[] args) {
        String str = "  The String class represents character strings. ";
        cnvr(str);
        
        
}}
```
​
[##_Image|kage@tqVsE/btq8mZ6R5oU/k9YTxpHCNPcdbph7C1Mxrk/img.png|alignCenter|data-origin-width="626" data-origin-height="373" data-ke-mobilestyle="widthOrigin"|||_##]
