## **Java**
​
 1. 파일이름.java → javac 파일이름.java → 파일이름.class
​
     : 자바소스 .java
​
     : 자바 바이트코드 .class
​
  
 2. 자바의 실행단위는 class이다
​
  
 3. 자바의 접근제한자
​
    : 객체의 멤버들에게 접근 제한을 건다.  
    : public (모든접근) → protected(상속시만 허용) → private(현재 객체 내 허용) → default(같은 패키지안에서 공개)
​
4\. 접근제한자 사용 : 클래스명, 메소드명, 멤버 변수 앞에 선언된다. 
​
  
5\. static, abstract 등도 접근제한자와 함께 선언된다.
​
6. 기본자료형 (byte, short, int, long, float, double, char, boolean)  
   참조형 (배열, 클래스)  
 
​
### **기본자료형**
​
```
package com.test;
​
// 자바는 패키지 안에 폴더로 파일을 생성한다. 
// 패키지가 2단계 이상이어야한다. (com.test)
// src는 소스코드 
​
public class Test01 {
​
// class 앞에 public이라는 접근지정자 지정, 
// 유저네임 Test01은 파일이름과 동일
// Java는 대,소문자는 가린다. 
// 자바의 단위는 class 이다.
​
    public static void Ex01() {
    
        System.out.println("Ex01's method");
        // "System.out.println" 자동명령어 단축키 : syso ctrl + space 
    }
​
    public static void main(String[] args) {
    // "main" 자동단축기 : ma + ctrl +space
    
        // 진입점 , main 실행, 반드시 main 메서드가 있어야함 (python은 없어도됨)
        
        System.out.print("연습이라네 ~~");
        //실행 단축키 ctrl + F11 
        //실행 명령어 뒤엔 ; 반드시 지정
        
        
        // .연산자는 귀속 연산자 System 멤버는 out. 
        Ex01();
        
        // class명.멤버
        System.out.println(); // java.lang 내에 있는 멤버들은 import 하지 않고 호출 할 수 있다.
        System.out.println();
        
        
        
        
        Myclass.Disp();
        // ▲위 class안에는 아래와 같이 선언되어있다고 생각해야한다.
                // public class MyClass {
                // public static void Disp(){
        //}
        //}
    }
}
```
​
  
 
​
```
// "Myclass.Dist() 파일
​
package com.test;
​
//static-class명. 멤버 /nonstatic-class 변수 class명 = new 생성자(); class변수.멤버
public class Myclass {
    
    public static void Disp() {
        
        System.out.println("MyClass.Disp 출력하자()");  
        
    }
}
​
```
​
   ex) System.out.println("Ex01's method");  
     
       public class PrintStream {  
                public void println(String str){  
               }  
       }  
  
     ==
​
     PrintStream System.out = new PrintStream();  
     System.out.println();
​
### **int, float, char, string**
​
```
package com.test;
​
public class Test02 {
​
    // 01. 정수형 연습
    public static void Prn_int() {
        // 전역변수, 멤버면수 : 생성자에서 초기화를 자동으로 대입한다. 
        
        System.out.println(100);
        System.out.println(100+100);
        System.out.println(100-100);
        
        System.out.println("**************");
        
        
        // 포맷터엔 대문자 사용 불가 (Conversion = 'D'로 오류출력), 'printf'로 출력한다
        // 바이너리불가
        System.out.printf("%5d %5d %10d \n", 100,100,200);  // 10진수
        System.out.printf("%5o %5o %10o \n", 100,100,200);  // 8진수, 
        System.out.printf("%5x %5x %10x \n", 100,100,200); // 16진수 헥사
        
        System.out.println("**************");
    }
    
    // 02. 정수형 연습 (변수활용)
    public static void Prn_int2() {
​
        
        int a = 100;
        int b = 200;
        System.out.println(a);
        System.out.println(a+a);
        System.out.println(a-a);
        
        System.out.println("**************");
        
        System.out.printf("%5d %5d \t %10d \n", a,a,b);
        System.out.printf("%5o %5o \t %10o \n", a,a,b); 
        System.out.printf("%5x %5x \t %10x \n", a,a,b); 
        
        
        //public static String format(String format, Object... args)
                // static 매서드 //  리턴타입  매서드
        String res = String.format(" ", "%5x %5x \t %10x \n", a,a,b );
        System.out.println(res);
        
        System.out.println("**************");
        
    }
    
    
    // 03. 소수형 연습 
    public static void Prn_float() {-
        System.out.println(98.7); //double -- 8byte : 소수점 아래 18 자리까지도 표현 (효율이 더 좋다)
        System.out.println(98.7f); //float -- 4byte : 소수점 아래 9 자리까지만 표현
        System.out.println("**************");
        
        
        String str = String.format("%10.2f %10.2f\n", 98.7, 98.7f);
        String str2 = String.format("%10.2f %-10.2f\n", 98.7, 98.7f); // -는 왼쪽정렬
        System.out.println(str);
        System.out.println(str2);
        
        System.out.println("**************");
    }
    
    
     // 04. 문자형 연습
    public static void Prn_char() {
    
        //한글자 있는 타입 
        System.out.println('A');
        System.out.printf("%5c\n", 'A');
        System.out.println("**************");
        
        
        //데이터타입 변수 = 값;
        char ch = 'A';
        System.out.println("ch = " + ch + "code = " + (int)ch);
        System.out.printf("%5d\n", (int)ch); // (int)형변환
        System.out.println("**************");
        
    }
    
    
    // 05. 문자열 연습
    public static void Prn_String() {
        // 'A' - chr
        // "A" - string
        System.out.println("'우리'나라 \'대\'한민국");
        System.out.println("**************");
        String str = "우리나라 대한민국";
        System.out.println(str);
    }
​
​
    public static void main(String[] args) {
        //int a;//변수를 선언할 때 '지역변수'는 반드시 초기값을 지정해야한다.: 변수를 호출하면 값을 리턴한다.
        //a = 100;
        //System.out.println(a); // 호출시 오류발생 
​
        Prn_int();
        Prn_int2();
        Prn_float();
        Prn_char();
        Prn_String();
    }
​
}
​
​
​
​
```
​
```
100
200
0
**************
  100   100        200 
  144   144        310 
   64    64         c8 
**************
100
200
0
**************
  100   100             200 
  144   144             310 
   64    64              c8 
 
**************
98.7
98.7
**************
     98.70      98.70
​
     98.70 98.70     
​
**************
A
    A
**************
ch = Acode = 65
   65
**************
'우리'나라 '대'한민국
**************
우리나라 대한민국
​
```
​
```
package com.test1;
​
​
public class Test02_3 {
    
    public static void Prn_int() {
        
        Integer a = 100;
        Integer b = 200;
        System.out.println(a.longValue());
        System.out.println("**************");
        
        //public static String format(String format, Object... args)
        // static 매서드 //  리턴타입  매서드
        String res = String.format(" ", "%5x %5x \t %10x \n", a,a,b );
        System.out.println(res);
        
        System.out.println("**************");
    }
    
    
    public static void Prn_float() {
        
        Double d = 98.7;
        Float f = 98.7f;
        
        
        System.out.println(d); //double -- 효율이더좋다 8byte : 소수점 아래 18 자리까지도 표현
        System.out.println(f); //float 4byte : 소수점 아래 9 자리까지만 표현
        System.out.println("**************");
        
    }
​
    public static void Prn_char() {
        //데이터타입 변수 = 값;
        Character ch = 'A';
        System.out.println("ch = " + ch + "code = " + (int)ch);
        System.out.printf("%5d\n", (int)ch); // (int)형변환
        
    }
            
    
​
    
    public static void main(String[] args) {
        Prn_int();
        Prn_float();
        Prn_char();
    }
}
​
```
​
```
100
**************
 
**************
98.7
98.7
**************
ch = Acode = 65
   65
​
```
​
\>> public static final PrintStream out(상수)  
     final → 클래스 앞(상속 x), 메소드 앞(재정의 x), 변수 앞(변수를 상수로)
​
```
package com.test;
​
public class Test04 {
    
    public static void Exam() {
        // 1. 정수형 변수를 하나(a) 선언해서 10을 대입하자. Integer클래스의 메소드로 구현해보자.
        Integer a = 10;
        
        
        // 2. a를 2진수로 변환 후 출력 : public static String toBinaryString(int a)
        String str = Integer.toBinaryString(a);
        System.out.println(str);
        
        // 3. a를 8진으로 변환 후 출력 : public static String toOctalString(int a)
        
        
        String str02 = Integer.toOctalString(a);
        System.out.println(str02);
        
        // 4. a를 16진으로 변환 후 출력 : public static String toHexString(int a)
        String str03 = Integer.toHexString(a);
        System.out.println(str03);
        
    }
    
    
        public static void Exam02() {
            System.out.println("char의 범위 : " + Character.MIN_VALUE + "~" + Character.MAX_VALUE);
            System.out.println("char의 범위 : " + (int)Character.MIN_VALUE + "~" + (int)Character.MAX_VALUE);
        
        // 문자 A를 소문자로 변경해보자. public static char toUpperCase(char ch)
            
        char ch = Character.toLowerCase('A');
        System.out.println(ch + " : " + Character.isLowerCase(ch));     
                
        // 문자 a를 대문자로 변경해보자. public static char toLowerCase(char ch)
​
        
        System.out.println(Character.toUpperCase('a') + " : "
                + Character.isUpperCase(Character.toUpperCase('a')));   
        
        boolean fw = true;
        System.out.println(fw + " : " + !fw);
        
        String str = "abcdefghijklmn"; //String str = new String("abcdefghijklmn");
        System.out.println(str.toLowerCase() + " : " + str.toUpperCase());
        }
    public static void main(String[] args) {
        
        Exam02();
    }
​
}
```
