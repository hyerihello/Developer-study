 ✨ Object 재정의에 대한 개념을 이해할 수 있다.  
 ✨ 추상클래스와 인터 페이스를 상속 받아 추상 메소드를 구현할 수 있다.  
 

##   
  
 **Object class**

  
  유저가 만든 객체를 관리하기 위해 만들어진 class 이다.  
 

 **Object의 method**

    
   -  equl : 비교를 통해 boolean 값 리턴   
   -  finalize : 객체가 소멸될 때 호출 되기로 한 메서드   
      garbage collection : 사용하지 데이터를 램에서 제거할 수 있는 작업을 자동화 한 것   
                                inner로 되어있거나, 현재 객체를 소멸못하면 old로 간다.  
                                객체를 소멸하면 eden 영역으로 간다.   
    - 모든 oop구조의 최상위 클래스   
    \-  wait, notify 메서드 : 현재 실행 상태를 나타내는 구조 (\*중요)

**※ 메모리를 내리는 순서**

  
     hide (화면에서 숨겨짐) 메서드 → destroy (부모는 살아있는데 자식은 숨김, java는 없음) →    
     finalize (현재 내가 가지고 있는 객체가 닫아짐) → close (주소 소멸)   
      
   

## **Thread class**

 메모리를 할당받아 실행 중인 프로그램을 프로세스라고 한다.  
 프로세스 내의 명령어 블록으로 시작점과 종료점을 가진다.  
 실행 중에 멈출 수 있으며 동시 수행 가능하다.  
 어떠한 프로그램 내에서 특히 프로세스 내에서 실행되는 흐름의 단위이다.

즉, 내가 만든 class를 실행하고 싶다. 할 때 사용

  
thread : 다중, 단일 값을 가지고 있다.

 - class를 thread 만들면서 wait, notify를 통해 실행 상태를 확인한다.  
 - 하나의 프로그램에 여러 thread 가 존재할 수있다.  
  - web이면 was가 thread 역할을 한다.

**All Implemented Interfaces**

: Runnable

  
 - thread.runnable : 메인에서 쓰던것을 run에 쓰면된다. run매서드도 확인해보자. (\*runnable 을 이용해 상태 확인)  
  
    

##   
**io.package** 

 : class에서 할수 있는 명령을 모아 놓은집합)  
   stream(입출력 단위가 byte), Reader, Writer  
   

##   
**File class**

  - 오버로드 생성자 : path  
  - 메서드 : finalize 로 파일 닫는다  
    

[##_Image|kage@dB8HT3/btq8pjS6WMn/72FgSyo9CSj7jiIAu8Ff3k/img.png|alignCenter|data-origin-width="640" data-origin-height="80" data-ke-mobilestyle="widthOrigin"|||_##]

##   
  **BufferedInputStream class**

     : 글자를 어떤 대상에서 읽어 들이는데 byte단위로 버퍼에 넣어 읽겠다.   
    - Reads the next byte of data  
        (Output : 쓰다)  
    - close : 무조건 close 써야한다, close를 상속하기때문에 finalize가 있다.  
    - object, 파일객체, db객체  try catch final에 close 무조건 명시한다.  
      
      
   

##  **Interfaces (추상화)**

    
     : .java로 저장된다 실행단위는 .class 문법은 추상 클래스와 같다.   
       
       new 연산자 → 인터페이스 , 추상클래스 사용할 수 없다.   
                           주소 번지는 사용할 수 있다.  
   
   
 public abstract Abstract\_aa {  
      public abstract void test ();  
   }  
   
      Abstract\_aa a1 = new My(); // new Abstract\_aa() -> new My() : 가능한 case  
      public static void prn(new new Abstract\_aa(){ //재정의의 목적  
        // 재정의 코드작성  
       }){} : 위의 문법이 가능하기 떄문에 실행 가능하다.  
   

  
   호출을 해보자.  
    prn(new My());   
        
        
     ※ 특이한 class

       
      **math** - static, 생성자가 없음(생성자가 private), 후손도 없음 (final)  
      **calendar** - 스스로 초기화하는 get인스턴스를 제공했으니 따로 생성자가 필요없다.  
                  Calendar rightNow = Calendar.getInstance();  
       
     

## **추상 메소드, 인터페이스의 상속 및 메서드 구현**

**동적바인딩** 

  
   : 선조의 주소번지를 통해서 다양한 후손을 메모리에 올려 선택 적으로 사용한다.

**ex01)  추상클래스를 상속받아 추상메소드를 구현해보자.**

```
package com.test;

public abstract class Abstract_aa { // 추상class 

	public abstract void test (); // 추상 메서드
	
}
```

```
package com.test;

public class My extends Abstract_aa{ //Abstract_aa를 상속받는 My class
	
	@Override // 상속받은 후 Override(덮어쓰기) 하자
	
	public void test() {
		System.out.println("My test"); // 재정의
	}

}
```

```
package com.test;

public class Test {
	
	public static void Prn(Abstract_aa a2) { // Abstract_aa a2 = new My(); 랑 같음
		a2.test();
	}
	
public static void main(String[] args) { // 실행하는 Test class 


	// case 1
	My m1 = new My(); // My 타입의 m1(변수) 를 생성하자(new My)
	m1.test(); // My의 test메소드를 리턴한다.
	
	// case 2
	Abstract_aa a1 = new My(); // 선조의 주소번지를 받음
	a1.test(); // My는 Abstract_aa를 참조받았기 때문에 부모이름으로 My의 test 메소드를 리턴받을 수 있다.
			   // upper casting?
	
	
	//case 3
	Prn(new My());	//선조의 주소를 메소드로 받음
					// Prn(Abstract_aa a2) = Abstract_aa a2 = new My(); 랑 같기 때문에 
					// Prn(new My()) 도 리턴 받을 수 있다. 
	
	//case 4
	Prn(new Abstract_aa() { // 무조건 재정의 해야한다. (추상클래스, 인터페이스는 new연산자를 사용할 수없는데 익명으로 1번 사용할 수 있다)

		@Override
		public void test() {
			System.out.println("나 재정의야!");
			
		}
		
	});}
}
========================================================================

My test
My test
My test
나 재정의야!

```

[##_Image|kage@duFnOV/btq8s65FdM7/uH5085F3X5vZC0yNaXAt3k/img.png|alignCenter|data-origin-width="390" data-origin-height="270" data-ke-mobilestyle="widthOrigin"|||_##]

**ex02)  추상 클래스를 동적 바인딩과 정적 바인딩으로 출력해 보자.**

```
package com.test01;

public abstract class base { // 추상 class base
	public abstract void Start(); // 추상 메소드 Start, Stop
	public abstract void Stop();
	

}
```

```
package com.test01;

public class Puppy extends base { // base class 참조받는 Puppy class
	
	@Override
	public void Start() {
		System.out.println("puppy's Start()");
	}
	
	@Override
	public void Stop() {
		System.out.println("puppy 'Stop()");	
	}
	

}

==========================================================================

package com.test01;

public class Duck extends base{ // base class 참조받는 Duck class
	
	@Override
	public void Start() {
		System.out.println("Duck's Start()");
	}
	
	@Override
	public void Stop() {
		System.out.println("Duck 'Stop()");	
	}

}

=======================================================================

package com.test01;

public class Pig extends base{ // base class 참조받는 Pig class

	
	@Override
	public void Start() {
		System.out.println("pig's Start()");
	}
	
	@Override
	public void Stop() {
		System.out.println("pig 'Stop()");	
	}
	
	
}



```

```
package com.test01;

import java.util.Scanner;

// 동적바인딩

public class MTest {

	public static void main(String[] args) {
		
		System.out.println("Input no :");
		Scanner sc = new Scanner(System.in);
		int no = sc.nextInt();
		
		base b1 = null; // null이란 키워드는 객체를 null로 초기화 해주는 키워드이다.
		switch(no){ // 동적바인딩 : 다형성의 목적  1. 코드를 단촐하게한다, 2. 메모리 속도향상 , 3. 메모리 효율적으로 사용 
		
		case 1: 
			b1 = new Duck(); 
			break;
			
		case 2: 
			b1 = new Puppy();

			break;
			
		case 3: 
			b1 = new Pig();

			break;
		}
		b1.Start(); // 후손이 가지고 있는 Start()와 Stop()을 리턴한다.
		b1.Stop();
	}
}
```

```
// 정적 바인딩 

package com.test01;

import java.util.Scanner;

public class MTest2 {

	public static void main(String[] args) {
		
		System.out.println("Input no :");
		Scanner sc = new Scanner(System.in);
		int no = sc.nextInt();
		switch(no){ // 정적바인딩
		
		case 1: 
			Duck d1 = new Duck();
			d1.Start();
			d1.Stop();
			break;
			
		case 2: 
			Puppy p1 = new Puppy();
			p1.Start();
			p1.Stop();
			break;
			
		case 3: 
			Pig p2 = new Pig();
			p2.Start();
			p2.Stop();
			break;
		}
	}
}

==============================================================
Input no :
2
puppy's Start()
puppy 'Stop()

```

[##_Image|kage@tfH6b/btq8pM8DgVn/EiFAQTP5KkhxNDDiIC5Xn1/img.png|alignCenter|data-origin-width="414" data-origin-height="407" data-ke-mobilestyle="widthOrigin"|||_##]

  
    **ex03)  인터페이스를 동적 바인딩과 다운캐스팅 , get/set 구조를 확인 해 보자.**  
    

```
package com.test02;

// class interface는 implement 사용해 후손을 참조한다.

public interface base {
	void Start();
	void Stop();
	

}
```

```
package com.test02;

public class Puppy implements base { // implement로 base를 참조
	
	@Override
	public void Start() {
		System.out.println("puppy's Start()");
	}
	
	@Override
	public void Stop() {
		System.out.println("puppy 'Stop()");	
	}
	

}

======================================================================

package com.test02;

public class Duck implements base{
	
	@Override
	public void Start() {
		System.out.println("Duck's Start()");
	}
	
	@Override
	public void Stop() {
		System.out.println("Duck 'Stop()");	
	}

}

====================================================================

package com.test02;

public class Pig implements base{
// 선조의 주소번지를 통해서 재정의가 되지 않은 후손의 메소드를 제어할 경우 확인 
	
	private int a; // 멤버변수, private을 주게되면 get/set 만들어야한다. 
	// (참조받는 객체가 private로 되어있어 보이지 않기 때문에 get,set 으로 값을 전달 및 리턴 해야한다)
	
	
	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}
	
	@Override
	public void Start() {
		System.out.println("pig's Start()");
	}
	
	@Override
	public void Stop() {
		System.out.println("pig 'Stop()");	
	}
	
	
}
```

```
//실행코드
package com.test02;

public class MTest3 {

	public static void main(String[] args) {
		
		base b1 = new Pig(); // new Base() <- new Pig() 동적바인딩(선조로 후손을제어), object를 써도된다.
		b1.Start();
		b1.Stop();
		System.out.println("↑ 동적바인딩!");
		
		// down casting , 주소번지에 올라간 것만 사용할 수 있다.
	
		((Pig)b1).setA(100); 
		System.out.println(((Pig)b1).getA());
		System.out.println("↑ 다운캐스팅!");
	}

}

===================================================================

pig's Start()
pig 'Stop()
↑ 동적바인딩!
100
↑ 다운캐스팅!
```

```
package com.test02;

public class MTest04 {
	
	public void Prn(base b) { // base b = new Pig()
		b.Start();
		b.Stop();
		
	}
	public static void main(String[] args) {
		
		new MTest04().Prn(new Pig());
		
		new MTest04().Prn(new base() { // 추상클래스, 인터페이스는 new생성자 불가, 재정의 해야한다.
			@Override
			public void Start() {
				System.out.println("111111");
			
			}
			@Override
			public void Stop() {
				System.out.println("222222");
			}
		});
	}

		
	
}

=========================================================================

pig's Start()
pig 'Stop()
111111
222222
```

[##_Image|kage@bhP7Y1/btq8pi7Nz2v/ZGLK7aqU1o5oM9hESddsg0/img.png|alignCenter|data-origin-width="528" data-origin-height="391" data-ke-mobilestyle="widthOrigin"|||_##]

```
package com.test03;

import java.util.Objects;

public class Car {
	
	private String car_name; // get,set이 필요하다


	public Car(String car_name) { // source - field
		super();
		this.car_name = car_name;
	}
	
	public String getCar_name() {
		return car_name;
	}

	public void setCar_name(String car_name) {
		this.car_name = car_name;
	}
```

```
package com.test03;

public class Mtest {
	public static void main(String[] args) {
	
		Car c1 = new Car("sm5"); // 생성자 생성 sm5를가지고 super로간다
		Car c2 = new Car("sm5"); // sm5를 가지고 
		
		System.out.println("주소비교 : " + (c1 == c2)); // c1.toString() == c2.toString()
		// 주소비교했더니 다르다
		System.out.println("주소비교 : " + (c1.equals(c2))); // c1.toString() == c2.toString()
		
			if(c1.equals(c2)) { // this.객체와 넘어온객체와 비교
				System.out.println(" 차이름이 같아 ");
			}else {
				System.out.println(" 이름이 달라 ");}
}
}
==============================================================

주소비교 : false
주소비교 : true
 차이름이 같아 
```

```
package com.test03;

public class MyTest{
	public static void main(String[] args){
		
		System.out.println(args.length);
		System.out.println(args[0]);
		System.out.println(args[1]);

	}
}
==================================================================

Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 0
	at com.test03.MyTest.main(MyTest.java:7)
```

위 내용 처럼 입력값이 없을 경우 예외처리 안내문구가 뜬다.

이럴 경우에는 입력을 해줘서 값을 리턴받아야 하는데 prompt 를 이용해 입력 후 리턴 받아보자.

  ※ prompt 창 이용 방법 

  : 오른쪽 마우스 클릭 → Run As → Run Configurations  → project 와 main 경로 재 확인 → 

  → 두번째 탭의 Arguments → Variables(Program Arguments) → String Prompt → Run

[##_Image|kage@cr59bK/btq8ojeWrmA/3RDulLRTdfRWEytY1Gc3VK/img.png|alignCenter|data-origin-width="469" data-origin-height="199" data-ke-mobilestyle="widthOrigin"|input 값||_##]

[##_Image|kage@nGzwh/btq8q2JVtMI/BMriWjlDoChOLNbiKzRSxk/img.png|alignCenter|data-origin-width="699" data-origin-height="484" width="635" height="440" data-ke-mobilestyle="widthOrigin"|return 값||_##]

  
 

 [Runnable (Java Platform SE 8 )

The Runnable interface should be implemented by any class whose instances are intended to be executed by a thread. The class must define a method of no arguments called run. This interface is designed to provide a common protocol for objects that wish to e

docs.oracle.com](https://docs.oracle.com/javase/8/docs/api/java/lang/Runnable.html)

##  **Throwable Class (lang.package)**

     : jvm 프로그램 실행중단 → 내부적으로 가장먼저 생성됨  
      
    **Direct Known Subclasses (Throwable의 하위클래스)**

  
    **\-** Error, Exception **:**  객체 생성해서 실행시점으로 돌려줌  
      
    - 파이썬에서 봤던 메서드를 확인할 수있다.   
      ex) exception  (checked, unchecked)   
      
 - 자주 등장하는 **exception**

   :  ArithmeticException, IllegalArgumentException, NullPointerException, IndexOutOfBoundsException  
      Class RuntimeException (실행시에 나타나는 예외처리)  
        ex) integer -> parseInt 매서드 -> NumberFormatException

```
C:\Users\hyeri>cd c:\Test03


c:\Test03>dir/w
 C 드라이브의 볼륨에는 이름이 없습니다.
 볼륨 일련 번호: BE80-C42F

 c:\Test03 디렉터리

[.]                  [..]                 MyTest.java          새 텍스트 문서.txt
               2개 파일                 175 바이트
               2개 디렉터리  386,606,727,168 바이트 남음


c:\Test03>javac MyTest.java

c:\Test03>java MyTest
0
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 0
        at MyTest.main(MyTest.java:5)

c:\Test03>java MyTest abc def
2
abc
def



c:\Test03>javac MyTest.java

c:\Test03>java MyTest

c:\Test03>javac MyTest.java

c:\Test03>java MyTest
0
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 0
        at MyTest.main(MyTest.java:5)

c:\Test03>java MyTest abc
1
abc
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 1
        at MyTest.main(MyTest.java:6)

c:\Test03>java MyTest abc 1 1 1 1
5
abc
1

c:\Test03>
```

**예외처리(Exception)**

```
package com.test04;

public class MyException extends Exception {



	public MyException(String msg) {
		super(msg)
;	}

}
```

```
package com.test04;

public class MyEceptionTest {

public static void main(String[] args) {
	int a = 10;
	try {
	if(a>0) {
		throw new MyException("0보다 크잖아");
	}
	} catch(MyException m) { // MyException m = new MyException("0보다 크잖아");
		System.out.println(m.getMessage());
	} catch(Exception e) { // 위에 실패하면 선조 Exception 이 잡아라
		System.out.println(e.getMessage());
	} finally {
		System.out.println("예외가 나던지 말던지 반드시 처리해줘 파일클로즈, 디비클로즈, 복원파일등 하자");
	}
	}

}
=======================================================================

0보다 크잖아
예외가 나던지 말던지 반드시 처리해줘 파일클로즈, 디비클로즈, 복원파일등 하자
```

```
package com.test04;

 //throws : 예외를 위임, 메소드 뒤에 선언하는 키워드
 //throw : 예외를 실행하는 키워드,   throw new MyException();

 /* try {
  
  } catch(후손 Exception){
  
  } catch(Exception e){
  
  } finally {
  
  }
       
   */

public class Mtest {

	public static void main(String[] args) {
		// 메인 실행시 두개의 정수를 받아서 합을 구하자.
		
		int a = 0;
		
		int b = 0;
		
		try {
		a = Integer.parseInt(args[0]);
		b = Integer.parseInt(args[1]);
		}catch(NumberFormatException n) {
			System.out.println("예외났음");
		}
		System.out.println(a+b);

	}

}
```

[##_Image|kage@bluGit/btq8Hs9Ujcy/koBstMAOIja0aSGh1GPNx1/img.png|alignCenter|data-origin-width="474" data-origin-height="208" data-ke-mobilestyle="widthOrigin"|||_##]

[##_Image|kage@to0k4/btq8KblAVv0/xyUoZF656GRK5saDoYPkw0/img.png|alignCenter|data-origin-width="687" data-origin-height="604" data-ke-mobilestyle="widthOrigin"|||_##]

```
package com.test04;

public class Mtest02 {

	public static void Prn() throws Exception  {
		throw new Exception("예외야");
		
	}
	public static void Prn02() throws Exception {
		Prn();
	}
	public static void Prn03() throws Exception {
		Prn02();
	}
	
	public static void main(String[] args) {
		try {
			Prn03();
		} catch (Exception e) {
			System.out.println(e);
			System.out.println(e.getMessage());
		} 
		//main은 try/cach처리해야한다.
	}
}

====================================================

java.lang.Exception: 예외야
예외야
```

```
package com.test04;

public class Mtest03 {
	
	public static void main(String[] args) {
		for(int i =0; i < 20; i++) {
			try {
				Thread.sleep(100); 
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			} //"Thread.sleep(1000); "전체 시스템 죽였다 살렸다. -> Try /catch 주자 반드시강제로 줘야하는아이
			System.out.printf("%3c", '♥');
		}
	}
}
=============================

  ♥  ♥  ♥  ♥  ♥  ♥  ♥  ♥  ♥  ♥  ♥  ♥  ♥  ♥  ♥  ♥  ♥  ♥  ♥  ♥
  
  천천히 하트가 한개씩 뜰것이다.
```
