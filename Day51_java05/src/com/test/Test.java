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
