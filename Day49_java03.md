## **class**
​
모든 클래스는 object의 후손 상속이고 단일 상속이다.  
클래스 객체는 반환형이 없다.  
모든클래스는 생성자 제공,  
this() super() → 생성자 안 에서만 작성이 가능하다, 무조건 첫 줄에 선언 되어야 한다.
​
```
//↓ public class Test01 extends object{} 랑 같다
public class Test01 {
    private int a;
    private int b;
    
    public Test01() { //1. super() 생성자가 내포되어있다.
        System.out.println("a="+a + "b="+b);
    }
    public Test01(int a, int b) {
        System.out.println("a=" + a + "b="+ b);
    }
    
    
 public static void main(String[] args) {
    //클래스 이름, 클래스 변수 = new 클래스이름():
        Test01 t1 = new Test01();
        System.out.println(t1.toString()); 
        //class : 사용자자료형 → 정보, 주소 등 = object
        
        //System.out.println(new Test01().toString()); //동적메모리?
        Test01 t2 = new Test01(100,200);
        System.out.println(t2.toString());
                // toString()은 주소를 말한다.
        
=================================================================
a=0 b=0
com.test.Test01@15db9742
a=100 b=200
com.test.Test01@6d06d69c
​
​
```
​
```
    public Test01() {
        super(); // 기본생성자를 호출,
        System.out.println("Test01() ");
    } //default 생성자
    
    public static void main(String[] args) {
            //클래스 이름, 클래스 변수 = new 클래스이름():
        Test01 t1 = new Test01();
        System.out.println(t1.toString());
        
    ============================================================
    
   Test01() 
   com.test.Test01@15db9742
    
```
​
위 코드는 자동 생성이 가능하다.
​
 : 오른쪽 마우스 클릭 → source → Gcf, Gcuf 등 옵션을 선택하면 된다.
​
[##_Image|kage@qbhwk/btq709DO0YI/ykxNWiIrkspssbaKsh21ek/img.png|alignCenter|data-origin-width="808" data-origin-height="803" data-ke-mobilestyle="widthOrigin"|||_##]
​
```
    // source -> GCS, GCF
    public Test01() {
        super();    
    }
​
    
    public Test01(int a, int b) {
    super();
    this.a = a;
    this.b = b;
    }
​
​
    public static void main(String[] args) {
            //클래스 이름, 클래스 변수 = new 클래스이름():
        Test01 t1 = new Test01();
        System.out.println(t1.toString());
            //class : 사용자자료형 -> 정보, 주소 등 = object
        
        //System.out.println(new Test01().toString()); //동적메모리?
        Test01 t2 = new Test01(100,200);
        System.out.println(t2.toString());
        
    }
​
}
================================================================
​
com.test.Test01@15db9742
com.test.Test01@6d06d69c
​
```
​
## **getter & setter**
​
  클래스의 멤버 변수는 은닉화 하고
​
  은닉된 멤버 변수에서 값 을 전달 및 변경하는 "setter",  
  리턴하는 구조 return\_type "getter" 를 만들어서 접근에 대한 제어를 구현한다.
​
```
package com.test;
​
​
// 클래스의 멤버변수는 은닉화 하고 은닉된 멤버변수에서 값을 전달 및 변경 setter,
// 리턴하는 구조 return_type getter 를 만들어서 접근에 대한 제어를 구현한다.
​
public class Test02 {
​
    private int a; // 같은 class 내에서는 호출 가능하다.
    
    // void setter
    public void setA(int a) {
        this.a = a;
    }
    // getter
    public int getA() {
        return a;
    }
    
​
public static void main(String[] args) {
    Test02 t1 = new Test02();
    System.out.println(t1.a); // 기본값 0 출력
    
    t1.setA(100); // 값 전달 및 변경
    System.out.println(t1.getA()); // 값 리턴 
    
    ==============================================================
    
   0
   100
​
```
​
```
자동화 source를 통해 입력 가능하다.
​
// source -> getter,setter 
    public int getA() {
    return a;
    }
​
    public void setA(int a) {
    this.a = a;
    }
​
```
​
## **@override**
​
**클래스 개념 **
​
1\. 캡슐화 클래스 구현
​
   (생성자, setter, getter, 재정의 - @Override= Object (개념이해 ex) toString))  
   Object docs에서 \_toString 확인 해보자.  
   → 참조형 .jar구현 방법
​
  
2\. 상속
​
3\. 다형성
​
```
package com.test;
​
import java.util.Random;
// 클래스 개념 
// 1. 캡슐화클래스 구현 (생성자, setter,getter,재정의 - @Override= Object(개념이해 ex,toString))
// Object-docs에서 _toString
//   -> 참조형 .jar구현방법
// 2.상속, 3. 다형성
​
public class Myclass01 {
​
    // 오버로드 : 하나의 클래스 안에서 같은 이름의 메서드를 여러개 정의하는 것을 뜻함
    // 오버라이딩 : 정의를 새로해서 값이 리턴되는 값이 같음
    
    @Override //오버라이드 어노테이션, 재정의되어있는것을 체크해준다. 소스시작할때 걸러준다.
             // 경고, check,
             
    public String toString() {
        return "내꺼야";
    }
    
    
   
    public static void main(String[] args) {
        System.out.println(new Myclass01().toString());
        // 객체에 "." 하면 원하던 원하지 않던 자동으로 호출 
        // 재정의를 하면 재정의한 것이오고, 아니면 object가온다.
        System.out.println(new Myclass01());
        
        Myclass01 t1 = new Myclass01();
        System.out.println(t1);
        System.out.println(t1.toString());
        
        System.out.println(new Integer("100")); // Integer class가 재 정의함
        System.out.println(new Integer("100").toString()); // 위랑 같음
        
        System.out.println(new Random()); // random class라서 안에 값이 있어야 난수발생, 
                                          // 재정의 불가
    }
}
============================================================================
​
내꺼야
내꺼야
내꺼야
내꺼야
100
100
java.util.Random@6d06d69c
​
```
​
**😎 알고가기 : export 를 이용한 사용자 import 연결하기 **
​
1\. import 할 파일을 .jar 파일로 export 해야한다.
​
  : 파일 오른쪽마우스 클릭 → export → Jarfile → 파일 내보낼 파일 확인 및 경로설정 → Finish 
​
[##_Image|kage@PkCb5/btq76AeZEl7/KhHJGaUm63MaOYSZdknpbk/img.png|alignCenter|data-origin-width="511" data-origin-height="543" data-ke-mobilestyle="widthOrigin"|||_##]
​
[##_Image|kage@dI5oVz/btq74nVrHfn/cd3nzXqXTzuuYoJDVxLOrK/img.png|alignCenter|data-origin-width="553" data-origin-height="695" data-ke-mobilestyle="widthOrigin"|||_##]
​
2\. 전역 패스 또는 빌드 패스를 설정해서  import 할 수 있게 하자.
​
  1) 전역패스 : C:\\Program Files\\Java\\jdk1.8.0\_291\\jre\\lib\\ext 
​
      위 경로에 .jar 파일을 저장한 후  , 아래처럼 JRE System Library 에  저장한 jar 파일 확인 한다.
​
      새로운 java 파일을 만들어  " import com.mytest. \* ; 패키지 이름으로 넣어준 후 실행한다. 
​
[##_Image|kage@bWnPcL/btq754mYjWZ/6j3gmrRzXkarE6MeAehaLK/img.png|alignCenter|data-origin-width="943" data-origin-height="882" data-ke-mobilestyle="widthOrigin"|||_##]
​
 2) 빌드패스 :  적용할 프로젝트 → 오른쪽 마우스 클릭  → build path → Configuer build path 
​
                   → Libraries 클릭 → add External jars (경로 바로가져오기) 또는 add Library (user Library) 클릭 → 
​
                   → 가져올 jar파일 선택 → Finish 
​
[##_Image|kage@bKijno/btq75DQNDLu/KVTpOvd7exlSnU2UYXFcmK/img.png|alignCenter|data-origin-width="807" data-origin-height="797" data-ke-mobilestyle="widthOrigin"|||_##]
​
동일하게 위 파일 실행하면 아래와 같이 import 하여 적용 완료
​
```
package com.test;
import com.mytest.*; // 패키지이름으로 넣어준다
​
public class MyTest {
​
    public static void main(String[] args) {
        Calc c1 = new Calc(1,5);
        System.out.println(c1);
    }
}
// 전역패스, 빌드패스 설정하는것
// jar파일을 export해서 생성한 후 아래와 같이 한다.
// 전역패스 : C:\Program Files\Java\jdk1.8.0_291\jre\lib\ext
// 빌드패스 : 프로젝트 -> 빌드패스 -> 컨피규 -> user, addExternal jars
​
===================================================================
​
반드시 처리해야할 구문
Calc [a=1, b=5, getHap()=6, getSub()=-4, getMul()=5, getDiv()=5]
​
```
​
## **abstract (추상화)**
​
```
package com.test;
​
public abstract class Test03 {
​
    private int a;
    protected int a1;
    public int a2;
            int a3; //default
    
            
    public void Prn() {}
    public static void Prn02(){}; // 정적메소드
    
    public abstract void Prn03(); // 추상메소드 
    // 는 선언만할수있고, 추상메소드를 가지고있는 class는 추상클래스가 되야하기 때문에 class를 변경해야한다.
    
    public int Prn04() {
        return 0;
        
    }
    public double Prn05(int a, int b) {
        return 0;
        
    }
    public String Prn06() {
        return null;
        
    }
}
​
// object aid 를 이용해 클래스 다이어그램으로 구현하자. 
//3칸으로나뉨 : 이름, 필드, 메소드 
// 이탤릭체class - 추상클래스구나 
// c : 메소드 
// 언더라인 : 스태틱
// a : abstract 
// : 뒤에는 리턴메소드 
```
​
## **자바의 상속**
​
1\. 자바는 클래스 간의 단일 상속을 원칙으로 한다.
​
  
2. this, super 로 후손과 선조의 주소를 참조한다.
​
  
3. this(), super()로 후손과 선조의 생성자를 호출 할 수 있다.
​
  
4. 생성자는 상속되지 않는다.
​
  
5. 접근제한자를 이용해서 선조는 후손에게 호출할 수 있는 접근을 제한 할 수 있고  
   abstract(반추상화) 키워드를 이용해서 강제적인 상속과 재정의를 할 수 있다.
​
  
6. 클래스 선언부에 final이라고 명시되면 상속할 수 없다.
​
  
7\. 객체를 후손을 통해서 생성될 때는 선조가 먼저 생성되고 후손이 나중에 생성된다.  
   (소멸은 역순으로 자동 소멸이다)  
  
8. 상속은 두 가지로 나뉜다. 
​
   클래스 간의 상속(단일), Interface(완전추상화를 하기위해 = 메뉴판, 다중)간의 상속이 있다.
​
   (Interface는 선언된 메소드만 있다.)
​
  
public class Vector<E>  
extends AbstractList<E>  
implements List<E>, RandomAccess, Cloneable, Serializable  
  
​
[##_Image|kage@cz6lUX/btq8jJjTE4T/AcPOqWxJtOKyWsPAoen8w0/img.png|alignCenter|data-origin-width="683" data-origin-height="256" data-ke-mobilestyle="widthOrigin"|||_##]
​
**😎 정리하고 가기!**
​
다중상속 - implements List, RandomAccess, Cloneable, Serializable 
​
클래스간의 상속 : extends  
인터페이스간의 상속 : extends  
클래스가 인터페이스 implement  
  
상속을 하는 이유 :  기능 추가, 기능 확장(재정의-override) 위해  
 - 선조가 가지고 있는기능 (재정의)  
 - 선조기능 : 메소드  
  
  
인터 페이스는(**상수 - field와**, **추상메소드**\-바디{ }없고 이름만 있음 기능이 없음) 로 구성됨.
​
  오버라이드의 다형성이 된다. 재정의 하지않으면 내가 추상메서드가 되고 그렇게 되면 new연산자를 통해 객체를 생성할 수 없다.  
  
  
오버로드 : 같은 클래스 내에서 기능은 하나인데  메서드의 네임 벨류 때문에 사용, 사용 방법은  데이터 갯수가 다르거나, 타입을 다르게 해서 사용한다.   
  
생성자는 무조건 존재 (디폴트, 오버르드생성자)  
this, super 키워드 사용 할 수있다.  
  
  
private 매개 변수는 상속안되고 매서드로만 받아 쓸수있다. 
​
protect 는 본인 클래스에서 상속해서 사용 가능
​
public 은 오픈해서 사용 가능
​
  
max = class.max로 호출한다.  
nonstatic 메서드는 new 연산자로 메서드를 생성한 후 가져와야 한다.  
​
long의 경우 long l = new longvalue() 로 불러와야한다.   
  
추상클래스의 추상메서드를 재정의하려면 모두 다 재정의 해야된다.
​
(강제 상속, 강제 재정의) 아니면 추상메서드가된다.   
  
후손은 바로위의 선조만 안다.  
  
자바는 추상메소드가 없어도 추상클래스가 될 수있다. 
​
```
// AA파일
​
​
package com.test01;
​
//int a+b 를 관리하는 클래스 
public class AA {
​
    private int a;
    private int b;
    
    public AA() {
        System.out.println("AA 생성자");
    }
    
    // 상속시 후손 클래스는 public처럼 호출할 수 있다.
    // 같은 패키지 내에서만 클래스 변수를 통해서 public처럼 호출할 수 있다.
//  protected int getA() {
//      return a;
//  }
    protected int getA() {
        return a;
    }
    public void setA(int a) {
        this.a = a;
    }
​
    public int getB() {
        return b;
    }
​
    public void setB(int b) {
        this.b = b;
    }
    
    public int getHap() {
        return this.a + this.b;
    }
​
```
​
```
// BB파일
​
package com.test01;
​
// a+b - d
public class BB extends AA{
    
    private int d;
    public BB() {
        System.out.println("BB");
    }
    public int getD() {
        return d;
    }
    public void setD(int d) {
        this.d = d;
    }
    
    public int getResult() {
        return getHap() - getD();
        //return (getA() + getB()) - getD();
        //return getHap() - d;
        //return getA() + getB() - this.d;
        //return this.getA() + this.getB() - this.d;
        //return super.getA() + super.getB() - this.d;
        //return super.getA() + super.getB() - this.getD();
        
        // 안되는것
        //return (a+b) - d
    }
}
​
```
​
```
package com.test01;
​
public class Test01 {
​
    
    public static void main(String[] args) {
        BB b1 = new BB();//  b1은 주소를 받는 변수 (AA를 먼저받고, 그후에 BB받음)
        // (AA BB) b1 = new (AA()→BB()) AA생성하고 BB생성하고
        // AA a1 = new BB();
        // AA a1 = new(AA()→BB())
        //BB b2 = new AA(); --> x
         // 2개짜린데 한개짜리써서
        b1.setA(100);
        b1.setB(100);
        
        System.out.println(b1.getHap());
        System.out.println(b1.getResult());
        System.out.println(b1.getA() + " : " + b1.getB());
    }
}
=============================================================
​
AA 생성자
BB
200
200
100 : 100
​
```
​
**일반 메서드, 추상메서드 구분**
​
```
package com.test04;
​
public abstract class Test {
    
    public void test(){}; // 일반
    public abstract void test02(); // body가없으면 추상메소드
    
​
}
```
​
**추상메서드**
​
```
package com.test04;
​
//상수, 추상메소드
public interface IMY {
​
    // 멤버지정
    public static final int a = 100;
    int b = 200; // = public static final int b = 200; 앞과 뒤가 같다.
    
    public abstract void prn();
    void prn02(); // = public abstract void prn02();
}
```
​
```
package com.test04;
​
public abstract class MyABS extends Number {
// abstract 는 new 연산자를 사용할 수 없다. 괄호 안의 매개인자로는 받을 수 있다.
    
    public abstract int intValue(int a);
​
    
    public static void main(String[] args) {
        //new MyABS();
    }
​
    @Override
    public int intValue() {
        // TODO Auto-generated method stub
        return 0;
    }
​
    @Override
    public long longValue() {
        // TODO Auto-generated method stub
        return 0;
    }
​
    @Override
    public float floatValue() {
        // TODO Auto-generated method stub
        return 0;
    }
​
    @Override
    public double doubleValue() {
        // TODO Auto-generated method stub
        return 0;
    }
​
}
​
```
​
```
package com.test04;
​
public class Test02 implements IMY {
​
    @Override
    public void prn() {
        // TODO Auto-generated method stub
​
    }
​
    @Override
    public void prn02() {
        // TODO Auto-generated method stub
​
    }
​
    public static void main(String[] args) {
        // TODO Auto-generated method stub
​
    }
​
}
```
​
이클립스 마켓 : object aid 를 설치한다.
​
new → other → ObjectAid UML Diagram 파일을 만들고 → 아래와 같이 파일을 실행한다.
​
[##_Image|kage@bhLoAl/btq8lYHrgfz/k9AfxkGVf2YXzgz5nthj80/img.png|alignCenter|data-origin-width="698" data-origin-height="570" data-ke-mobilestyle="widthOrigin"|||_##]
