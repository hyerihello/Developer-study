##    
**기본 자료 형변환**
​
  
   1. 명시적 형변환 : 타입을 명시하는 형변환  
       ex) int a = (int) 98.9; // a = 90  
 
​
  
   2. 묵시적 형변환 : 자동으로 형변환  
      ex) double d = 90; // d=90.0  
 
​
  
                      ↗ '32768 ~ 32767'  
   byte(1) → short(2) → int(4) → long(8) → float(4) → double(8)  
                 char(2)  → '0~65535'  
                  
  
​
##   
** 자바에서 표준 입출력을 구현하는 클래스**
​
**표준 입력을 할 때 3가지**  
 
​
  
 1. java.io의 클래스를 사용하는 방법 - 상속 끝나고 파일 처리 할 때  
    java.io.Class BufferedInputStream  
  
 2. main() 매개인자로 입력받는 방법 - 전체  
    main(String\[\] args)  
       
 3. Scanner 로 입력받는 방법 - 맨 처음 입력받을때  
    java.util.Class Scanner  
     
  
​
**✔ 예제 1 (if 구문)**
​
```
package com.test;
​
 public class Test01 {
​
    private static void Prn() {
         int testscore = 76;
            char grade;
​
            if (testscore >= 90) {
                grade = 'A';
            } else if (testscore >= 80) {
                grade = 'B';
            } else if (testscore >= 70) {
                grade = 'C';
            } else if (testscore >= 60) {
                grade = 'D';
            } else {
                grade = 'F';
            }
            System.out.println("Grade = " + grade);
    }
​
=======================================================
    Grade = C
​
```
​
**✔ 예제 2 (Scanner)**
​
```
package com.test;
import java.util.Scanner;
​
//import? package, import만 올라올 수 있음.
//import java.util.*; ? util package 전체 다 사용할 수 있음 
// (*, 10개 이상일경우 사용한다.)
​
​
​
public class Test01_1 {
    private static String Prn (int jumsu) {
        int testscore = jumsu;
        char grade;
​
        if (testscore >= 90) {
            grade = 'A';
        } else if (testscore >= 80) {
            grade = 'B';
        } else if (testscore >= 70) {
            grade = 'C';
        } else if (testscore >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }
        return("Grade = " + grade);     
    }
​
public static void main(String[] args) {
​
    Scanner sc = new Scanner(System.in); 
    // System.in = InputStream 의 객체를 in 으로 필드화후 멤버로 가짐 , 표준 입력장치 
    
    System.out.println("input jumsu : ");
    int i = sc.nextInt();
    String res = Prn(i);
    System.out.println("res = " + res);
}
}
​
===========================================================
  input jumsu : 
  90
  res = Grade = A
​
```
​
**✔ 예제 3 (Scanner)**
​
```
public static void main(String[] args) {
​
  Scanner sc = new Scanner(System.in);
  int i = sc.nextInt();
  System.out.println( "i = " + i); //input 과 같은?? console창에 입력하면 출력함
  String str = sc.next();
  System.out.println( "str = " + str);
 }   
    ======================================
    
  20
  i = 20
​
  abcde
  str = abcde
​
    
```
​
**✔ 예제 4 (Scanner)**
​
```
package com.test;
​
import java.util.Scanner;
import java.util.regex.MatchResult;
​
public class Test01_1 {
    
    }
​
public static void main(String[] args) {
​
  String input = "1 fish 2 fish red fish blue fish";
  Scanner s = new Scanner(input);
  s.findInLine("(\\d+) fish (\\d+) fish (\\w+) fish (\\w+)");
  MatchResult result = s.match();
  for (int j=1; j<=result.groupCount(); j++)
    System.out.println(result.group(j));
  s.close();
    
}}
```
​
**✔ 예제 5 (Swith Case)**
​
규칙1 : int(4) + String  
규칙2 : case 뒤에는 단일 데이터형의 값
​
```
package com.test;
​
public class Test02 {
​
    public static void main(String[] args) {
        
        int month = 8;
        String monthString;
        //month는 변수, case 에서 1은 값
        
        switch (month) { //규칙1 : int(4) + String
            case 1:     // 규칙2 : case 뒤에는 단일 데이터형의 값  
                    monthString = "January";
                     break;
            case 2:  monthString = "February";
                     break;
            case 3:  monthString = "March";
                     break;
            case 4:  monthString = "April";
                     break;
            case 5:  monthString = "May";
                     break;
            case 6:  monthString = "June";
                     break;
            case 7:  monthString = "July";
                     break;
            case 8:  monthString = "August";
                     break;
            case 9:  monthString = "September";
                     break;
            case 10: monthString = "October";
                     break;
            case 11: monthString = "November";
                     break;
            case 12: monthString = "December";
                     break;
            default: monthString = "Invalid month";
                     break;
        }
        System.out.println(monthString);
    }
​
    
​
}
```
​
## **for문**
​
  : 형식 
​
    for(시작, 끝, 갭){statement(s)}
​
**✔ 예제 6 ("1~10" 을 출력하자)**
​
```
package com.test;
​
public class Test03 {
​
    public static void for_test() {
        System.out.println("case 1: 1~10 출력");
        
        for (int i =1; i <= 10; i++) {
            
            System.out.printf("%5d", i);
        }
    }
    
    public static void main(String[] args) {
    for_test();
​
}
​
=========================================================
​
case 1: 1~10 출력하자
    1    2    3    4    5    6    7    8    9   10
​
```
​
**✔ 예제 7 ("10~1" 을 출력하자)**
​
```
    public static void for_test02() {
        System.out.println("\ncase 2: 10~1 출력");
        int i = 0;
        for ( i = 10; i > 0; i--) {
            
            System.out.printf("%5d", i);
        }
        System.out.println("\n ==> i = " + i);
        
}
    public static void main(String[] args) {
        for_test02();
​
=======================================================
case 2 : 10~1 출력
   10    9    8    7    6    5    4    3    2    1
​
```
​
**✔ 예제 8 ("1~100, 2의 배수만 출력 해보자. 갯수도 출력하자")**
​
```
    public static void for_test03() {
        System.out.println("case 3: 1~100, 2의 배수만 출력 해보자. 갯수도 출력하자");
        
        int i = 0;
        int cnt = 0;
        for (i = 1; i <= 100 ;i++) {
            
            if(i % 2 == 0) {
            System.out.printf("%5d", i);
            cnt++;
        }}
        System.out.println("\n ==> cnt = " + cnt);
        }
==================================================================================
​
case 3: 1~100, 2의 배수만 출력 해보자. 갯수도 출력하자
    2    4    6    8   10   12   14   16   18   20   22   24   26   28   30   32   34   36   38   40   42   44   46   48   50   52   54   56   58   60   62   64   66   68   70   72   74   76   78   80   82   84   86   88   90   92   94   96   98  100
 ==> cnt = 50
​
​
​
```
​
**✔ 예제 9 ("중첩 for 출력")**
​
```
    public static void for_test04() {
        System.out.println("\ncase 4: 중첩 for 출력");
        
        for (int i = 1; i <= 5; i++) {
            for(int j = 1; j <= 5; j++) {
                System.out.printf("%5d", i);
        }
        
        System.out.println();
        }}
        
    public static void main(String[] args) {
        for_test04();
        
  ==================================================
  ★ i,j를 모두 출력하게 될 경우
 : 1 1 , 1 2, 1 3, 1 4, 1 5, 2 1, 2 2, 2 3, 2 4, 2 5, 3 1 … 이렇게 진행된다.
  위 루팅을 통해 i만 출력하되, i 가 5보다 작거나 같을때 
  for문을 빠져나와 아래와 같은 형식이 된다. 
  =================================================
  
    case 4: 중첩 for 출력
    1    1    1    1    1
    2    2    2    2    2
    3    3    3    3    3
    4    4    4    4    4
    5    5    5    5    5
```
​
**✔ 예제 10 ("중첩 for 출력")**
​
```
    public static void for_test05() {
        System.out.println("\ncase 5: 중첩 for 출력");
        
        for (int i =1; i <= 5 ;i++) {
            for (int j = 1; j <= 5; j++) {
                System.out.printf("%5d", j);
        }
        System.out.println();
        }}
    
    
    public static void main(String[] args) {
    for_test05();
​
  ==================================================
  ★ i,j를 모두 출력하게 될 경우
 : 1 1 , 1 2, 1 3, 1 4, 1 5, 2 1, 2 2, 2 3, 2 4, 2 5, 3 1 … 이렇게 진행된다.
  위 루팅을 통해 j만 출력하되, i 가 5보다 작거나 같을때
  for문을 빠져나와 아래와 같은 형식이 된다. 
  =================================================
​
  case 5: 중첩 for 출력
    1    2    3    4    5
    1    2    3    4    5
    1    2    3    4    5
    1    2    3    4    5
    1    2    3    4    5
​
```
​
**✔ 예제 11 ("중첩 for 출력")**
​
```
    public static void for_test06() {
        System.out.println("\ncase 6: 중첩 for 출력");
        
        for (int i =1; i <= 21; i += 5) {
            for (int j = i; j <= i + 4; j++) {
                System.out.printf("%5d", j);
            }
            System.out.println();
        }}
        
 ==================================================
  ★ i,j를 모두 출력하게 될 경우
 : case 6: 중첩 for 출력
    1 1 , 1 2 , 1 3 , 1 4,  1 5,  6 6,  6 7,  6 8,  6 9, 6 10, 11 11, 11 12, … 이렇게 진행된다.
  
  예를들어 i = 1 일때, j = 1 이되고, j가 i(1)+4 즉 5가 될 때까지 1씩더해주자.
  그 더한 j가 5가되면 첫번째 for문으로 돌아가 i에5를더하고 (그럼 6 이된다) for문을 빠져나간다. 
  단 i가 21보다 크거나 작을때 까지한다.
  
  위 값에서 j만 출력하게 되면 아래와 같은 결과가 나온다.
  =================================================
   
   case 6: 중첩 for 출력
    1    2    3    4    5
    6    7    8    9   10
   11   12   13   14   15
   16   17   18   19   20
   21   22   23   24   25
​
  
  
```
​
**✔ 예제 12 ("중첩 for 출력")**
​
```
public static void for_test07() {
    System.out.println("\ncase 7: 중첩 for 출력");
    
    for (int i =1; i <= 5; i++) {
        for (int j = i; j <= i+20; j+=5) {
            System.out.printf("%5d", j);
        }
        System.out.println();
    }
    }
        
 ==================================================
  ★ i,j를 모두 출력하게 될 경우
 : case 7: 중첩 for 출력
    1 1, 1 6, 1 11, 1 16, 1 21, 2 2, 2 7, 2 12, 2 17, 2 22 … 이렇게 진행된다.
  
  예를들어 i = 1 일때, j = 1 이되고, j가 i(1)+20 즉 21가 될 때까지 5씩 더해주자.
  그 더한 j가 21가되면 첫번째 for문으로 돌아가 i에 1를 더하고 (그럼 2 이된다) for문을 빠져나간다. 
  단 i가 5보다 크거나 작을때 까지한다.
  
  위 값에서 j만 출력하게 되면 아래와 같은 결과가 나온다.
  =================================================
   
    case 7: 중첩 for 출력
    1    6   11   16   21
    2    7   12   17   22
    3    8   13   18   23
    4    9   14   19   24
    5   10   15   20   25
```
​
**✔ 예제 13 ("중첩 for 출력")**
​
```
public static void for_test08() {
    System.out.println("\ncase 8: 중첩 for 출력");
    
    for (int i =25; i >= 21; i--) {
        for (int j = i; j >= i-20; j-=5) {
            System.out.printf("%5d", j);
        }
            System.out.println();
    }
    }
        
 ==================================================
  ★ i,j를 모두 출력하게 될 경우
 : case 8 중첩 for 출력
 
   25 25, 25 20, 25 15, 25 10, 25 5, 24 24, 24 19, 24 14, 24 9, 24 4 … 이렇게 진행된다.
  
  예를들어 i = 25 일때, j = 25 이되고, j가 i(25)-20 즉 5가 될 때까지 5씩 마이너스한다.
  그 뺀 j가 5가되면 첫번째 for문으로 돌아가 i에 1을 빼고 (그럼 24 가된다) for문을 빠져나간다. 
  단 i가 21보다 크거나 같을 때 까지한다.
  
  위 값에서 j만 출력하게 되면 아래와 같은 결과가 나온다.
  =================================================
   
   case 8: 중첩 for 출력
   25   20   15   10    5
   24   19   14    9    4
   23   18   13    8    3
   22   17   12    7    2
   21   16   11    6    1
```
​
**😎 알고가기**
​
**재대입 :** 블럭{ } 안에 k에 재 대입을하면 재대입 한 값이 리턴된다.
​
          단, int k로 선언은 불가 (이미 선언했기 때문에), k= 값으로만 가능하다.
​
```
  int a = 10;
  int k = 300;
  {
  System.out.println("a = " + a);
  
  k = 100; // 재대입 
  System.out.println("k = " + k);
  }
  System.out.println("k = " + k);
​
  =============================================
​
  a = 10
  k = 100
  k = 100
​
```
​
**✔ 예제 14 (1~100 데이터를 출력한다.)**
​
```
package com.test;
​
​
public class Test04 {
    //1. 1~100 데이터를 출력한다.
    public static void Prn() {
        
        for (int i=1; i <= 100; i++) {
            System.out.printf("%5d", i);
        }
        
    }
    
=============================================
 1    2    3    4    5    6    7    8    9   10   11   12   13   14   15   16   17   18   19   20   21   22   23   24   25   26   27   28   29   30   31   32   33   34   35   36   37   38   39   40   41   42   43   44   45   
 46   47   48   49   50   51   52   53   54  …   
```
​
**✔ 예제 14 ( 1~10, 11~10 출력한다)**
​
```
public static void Prn01() {
​
    for (int i=1; i <= 100; i++) {
        if (i % 10 == 0) {
        System.out.printf("%5d", i);
        System.out.println();
    } else {
        System.out.printf("%5d", i);
    }}}
    
    ================================================
    
    1    2    3    4    5    6    7    8    9   10
   11   12   13   14   15   16   17   18   19   20
   21   22   23   24   25   26   27   28   29   30
   31   32   33   34   35   36   37   38   39   40
   41   42   43   44   45   46   47   48   49   50
   51   52   53   54   55   56   57   58   59   60
   61   62   63   64   65   66   67   68   69   70
   71   72   73   74   75   76   77   78   79   80
   81   82   83   84   85   86   87   88   89   90
   91   92   93   94   95   96   97   98   99  100
```
​
**✔ 예제 14 ( 10의자리에 하트를 붙여라)**
​
```
    //3. 10의자리에 하트를 붙여라
public static void Prn02() {
    
    
    for (int i=1; i <= 100; i++) {
        if (i % 10 == 0) {
        System.out.printf("%5c", '♥');
        System.out.println();
    } else {
        System.out.printf("%5d", i);
    }}
}
​
===========================================
​
    1    2    3    4    5    6    7    8    9    ♥
   11   12   13   14   15   16   17   18   19    ♥
   21   22   23   24   25   26   27   28   29    ♥
   31   32   33   34   35   36   37   38   39    ♥
   41   42   43   44   45   46   47   48   49    ♥
   51   52   53   54   55   56   57   58   59    ♥
   61   62   63   64   65   66   67   68   69    ♥
   71   72   73   74   75   76   77   78   79    ♥
   81   82   83   84   85   86   87   88   89    ♥
   91   92   93   94   95   96   97   98   99    ♥
​
```
​
**✔ 예제 15 ( 2의 배수, 3의 배수 자리는 비워두자)**
​
```
    //4. 2의 배수, 3의 배수 자리는 비워두자
​
public static void Prn03() {
    
    for (int i=1; i <= 100; i++) {
        if (i % 10 == 0) {
        System.out.printf("%5c", '♥');
        System.out.println();
    } else if ((i % 2 == 0) || (i % 3 == 0)){
        System.out.printf("%5c", 32);
    } else {
        System.out.printf("%5d", i);
    }}
    }
​
    public static void main(String[] args) {
        Prn03();
        
=================================================
​
    1                   5         7              ♥
   11        13                  17        19    ♥
             23        25                  29    ♥
   31                  35        37              ♥
   41        43                  47        49    ♥
             53        55                  59    ♥
   61                  65        67              ♥
   71        73                  77        79    ♥
             83        85                  89    ♥
   91                  95        97              ♥
​
```
​
## **배열**
​
  
  자바의 배열 : 같은 데이터 타입의 값을 나열형으로 하나의 이름으로 등록해서 사용하는 것  
  
​
  
**  1. 1차원 - length**
​
  
   **\[형식\] **
​
   **직대입**
​
  
   데이터타입 변수명 \[ \] = {,,,,,}  
   데이터타입 \[ \] 변수명  = {,,,,,}  
  
​
   **동적할당**
​
  
   데이터타입 \[ \] 변수명  = new 데이터타입 \[요소의크기\];  
   데이터타입 \[ \] 변수명  = new 데이터타입 \[ \]{,,,,};  
  
​
(1) 직대입
​
```
package com.test;
​
public class Test05 {
​
    public static void disp() {
 // 데이터타입 변수명 [] = {,,,,,}
        int ar[] = {10,20,30,40,50};
​
        System.out.println(ar[0]);
        System.out.println(ar[1]);
        System.out.println(ar[2]);
        System.out.println(ar[3]);
        System.out.println(ar[4]);
        
        
        System.out.println(ar.length); // 5
        for (int i = 0; i < ar.length; i++) {
            System.out.printf("%5d", ar[i]); // 10,20,30,40,50
        }
        
        System.out.println("\n==============\n");
        
        
        System.out.println(ar.length); // 5
        for (int i = ar.length-1; i >=0; i--) { //len[4],[3],[2],[1],[0]
            System.out.printf("%5d", ar[i]); // = 50, 40, 30, 20, 10
        }
        
        
        System.out.println("\n==============\n");
        
        // 참조형, 역출력은 안된다.
        for(int res : ar){ // ar = res = {10,20,30,40,50}
            System.out.printf("%5d", res);
            
        }
    }
    
    
    public static void main(String[] args) {
        disp();
==========================================================================
​
10
20
30
40
50
​
5
   10   20   30   40   50
==============
​
5
   50   40   30   20   10
==============
​
   10   20   30   40   50
```
​
(2)
​
```
package com.test;
​
public class Test05 {
​
    public static void disp() {
​
        //데이터타입 [] 변수명  = {,,,,,}
        int [] ar = {10,20,30,40,50};
        
        System.out.println(ar[0]);
        System.out.println(ar[1]);
        System.out.println(ar[2]);
        System.out.println(ar[3]);
        System.out.println(ar[4]);
        
        
        System.out.println(ar.length);
        for (int i = 0; i < ar.length; i++) {
            System.out.printf("%5d", ar[i]);
        }
        
        System.out.println("\n==============\n");
        
        
        System.out.println(ar.length);
        for (int i = ar.length-1; i >=0; i--) {
            System.out.printf("%5d", ar[i]);
        }
        
        
        System.out.println("\n==============\n");
        
        // 참조형, 역출력은 안된다.
        for(int res : ar){
            System.out.printf("%5d", res);
            
        }
    }
    
​
    
    public static void main(String[] args) {
        disp();
    }
    
    ==============================================================
    
    10
    20
    30
    40
    50
    5
    10   20   30   40   50
    ==============
​
    5
    50   40   30   20   10
    ==============
​
    10   20   30   40   50
```
​
(2-1)
​
```
public class Test05 {
​
    public static void disp02() {
    // 데이터타입 [] 변수명  = new 데이터타입 [요소의크기];
        int [] ar = new int [5]; // 방을 5개 만든다. ar = new int[5]
        ar[0]=10;
        ar[1]=20;
        ar[2]=30;
        ar[3]=40;
        ar[4]=50;
        
        for (int res: ar) {  // ar = res
            System.out.printf("%5d", res);
        }
    }
==================================================================
​
   10   20   30   40   50
```
​
(3) 동적할당
​
```
    public static void disp03() { 
    //데이터타입 [] 변수명  = new 데이터타입 []{,,,,};
        int [] ar = new int [] {10,20,30,40,50};    
            
        for (int res: ar) {
            System.out.printf("%5d", res);
        }
    }
​
=========================================================
​
   10   20   30   40   50
```
​
```
package com.test;
import java.util.Arrays;
​
public class Test05 {
    
    public static void disp04(int[]ar02) { //ar02 =ar
        
        for (int res: ar02) {  // ar02=res
            System.out.printf("%5d", res);
        }
    }
    
    
    
    public static void main(String[] args) {
​
        int [] ar = new int [] {10,20,0,40,50};
        disp04(ar); // ar = {10,20,0,40,50}
        
        System.out.println();
        java.util.Arrays.sort(ar); //import java.util ''' 안써도됨
        disp04(ar); // ar = {0,10,20,40,50} , 정렬
        
        System.out.println();
        
        int[] ar02 = Arrays.copyOfRange(ar,3,5); // 위 import 써줘야함 
        disp04(ar02);                            
              // ar 배열 3개요소 복사(4번째요소부터 시작해서 숫자 5번째 가져옴  }
}
​
===================================================
​
   10   20    0   40   50
    0   10   20   40   50
   40   50
```
​
  
 ** 2. 다차원**  
  
​
  
   **\[형식\]**
​
   **직대입**
​
  
   데이터타입 변수명 \[ \]\[ \] = {{},,,,,}  
   데이터타입 \[ \]\[ \] 변수명  = {{},,,,,}  
   데이터타입 \[ \] 변수명 \[ \]  = {{},,,,,}
​
```
package com.test;
​
public class Test06 {
    
    
    public static void prn() {
        //2,3 을 만들자
        int[] ar[] = {{10,20,30},
                      {40,50,60}};
        
        System.out.println(ar.length); // 2 = {10,20,30}, {40,50,60}
        System.out.println(ar[0].length); // 3 = ar[0][0] ar[0][1] ar[0][2]
        System.out.println(ar[1].length); // 3 = ar[1][0] ar[1][1] ar[1][2]
        
        for(int i = 0; i<ar.length; i++) {
            for (int j = 0; j <ar[i].length; j++) {
                System.out.printf("%5d", ar[i][j]);
            }
            System.out.println();
        }
        System.out.println("====================");
        
        System.out.println();
        for(int[] res : ar) { // ar = res = {10,20,30}, {40,50,60}
            for(int result : res) {// res = 10,20,30 , 40,50,60
                System.out.printf("%5d", result);
            }
            System.out.println();
        }
    }
    
​
  ==================================================
  ★ i,j를 모두 출력하게 될 경우
 
 : 첫번째 for 문 
 
   10   20   30   40   50   60 … 이렇게 진행된다.
  
  예를들어 i = 0 일때, j = 0 이고, j가 ar[0].length 즉 3이 될 때까지 1씩 더한다. (0,1,2)
  그 더한 j가 3이되면 첫번째 for문으로 돌아가 i에 1을 더하고 for문을 빠져나간다. (0,1,2)
  단 i가 3보다 클 때 까지한다.
  
  위 값에서 ar의 인덱스값 [i][j]를 출력하게 되면 아래와 같은 결과가 나온다.
  ar[[0,1,2],[0,1,2]] = {10   20   30}  {40   50   60}
  
  ====================================================
  
2
3
3
   10   20   30
   40   50   60
====================
​
   10   20   30
   40   50   60
  =================================================
```
​
  
  **동적할당**
​
  
   "데이터타입 \[ \]\[ \]변수명  = new 데이터타입 \[요소의 열의크기\]\[ \];  
   데이터타입  변수명 \[ \]\[ \]  = new 데이터타입 \[ \]{,,,,};
​
```
    public static void ar_prn(int[][] ar) { //ar =[[],[],[],,,]
        System.out.println();
        for(int[] res : ar) { // ar = res
            for(int result : res) { // res = ar (int로 리턴될거야)
                System.out.printf("%5d", result);
            }
            System.out.println();
        }
        
    }
    
    
    public static void main(String[] args) {
​
        int[] ar[] = new int [][] {{10,20,30}, {40,50,60}}; 
                     // ar = {{10,20,30}, {40,50,60}}
        ar_prn(ar); //  10   20   30
                        40   50   60
        
        System.out.println(); 
        
        
    //가변형 : 첫번째 줄은 2칸, 두번째 줄은 3칸, 세번째줄은 5칸 ,,, 즉 정해지지 않음
        
        int[] ar02[] = new int [2][]; //두 줄은 2갠데 칸은 모름 : [0]층,[1]층 이렇게 줄거야
        ar02[0] = new int[2]; // [0]층에 2개 호수를 줘야겠다.
        ar02[0][0] = 10000; //[0]층에 첫번째 값은 10000 이고, 두번째는 값을 안줬으니 0이다.
        
        ar02[1] = new int[] {100,200,300}; // [1]층에 {100호, 200호, 300호} 줄거야
        ar_prn(ar02); // 1층은 100,200,300 값을 리턴한다.
        
        
  ======================================================================
  
  
   10   20   30
   40   50   60
​
​
  10000    0
  100  200  300
```
​
## **생성자**
​
  
\[선언방법\]
​
접근제한자\[abstract\] class user\_Name{  
        멤버 (필드, 변수, 메소드\[생성자\])  
        }
​
**1\. 클래스 이름과 동일하나 반환형은 없다.**
​
  
    ex) public class Test{}  
         public Test(){} → 괄호 안에 매개인자가 없으면 default constructor (기본 생성자)  
  
  
**2\. overload 할 수 있다. (메서드 이름이 동일할 때, 갯수 또는 데이터 타입을 다르게 줄 것)**
​
  
    public Test(){}  
    public Test(int, int){}  
    public Test(int, double){}  
  
**3\. 접근제한자를 이용하여 접근을 제한 할 수 있다.**
​
  
**4\. 객체를 생성할 때 자동으로 한번 만 호출 되어 진다. 메소드처럼 객체 주소번지로 명시 호출 할 수 없다.**
​
  
    Test t1 = new Test(); 기본생성자 → 대입  
          t1 = new Test(10,20); 매개인자 → 재 대입  
    Test t1 = new Test(10,20); → x 불가  
   
**5. 생성자는 상속되지 않는다.**
​
  
**6\. this() 형식으로 생성자 간의 내부 호출이 가능하다. = (python .self) **
​
  
 class Test{  
      private int a, b;  
      public Test(){ // a=0, b=0 값이 내포 되 있음}  
      public Test(int a, int b){  
               this.a = a;  
               this.b = b;  
                }  
       }  
       Test t1 = new Test(); 기본생성자 → 대입  
       Test t2 = new Test(10,20); 매개인자 → 재 대입
​
  
 class Test{  
      private int a, b;  
      public Test(){   
      this(10,20); // (1) 표기법 : 반드시 첫 번째에 주기! 속도가 더 빠름  
      this.a = 10; // (2) 표기법 : 차례대로 하기때문에 속도면에서 느림, 사용은 가능하다  
      this.b = 20;  
       }  
  public Test(int a, int b){  
      this.a = a;  
      this.b = b;  
      }  
  }
​
  
Test t1 = new Test();   
  : 멤버변수를 초기화 해놓고 (0으로), 현재 오브젝트 주소로 멤버변수 값을 변경 → 2개의 명령  
    내부호출할때 : 멤버변수를 초기화 해놓고 0 현재 오브젝트 주소로 멤버변수 값을 변경 - 하나의 명령  
  
  
**7. 생성자는 멤버변수를 초기화 하는 목적을 가진다.**
​
  
**8\. 모든 클래스는 반드시 생성자를 가지며 생성자를 명시하지 않을 때는** **기본 생성자가 제공되어 호출되고 **
​
**   명시하게 되면 명시된 생성자가 호출된다. **
