package com.test;

//↓ public class Test01 extends object{} 랑 같다
// 모든클래스는 object의 후손상속이고 단일상속이다.
// 클래스 객체는 반환형은 없다.
// 모든클래스는 생성자 제공,
// this() super() -> 생성자 안에서만 작성이 가능하다, 무조건 첫줄에 선언되어야한다.

public class Test01 {
	private int a;
	private int b;
	
//	public Test01() { //1. super 생성자있고
//		System.out.println("a="+a + "b="+b);
//	}
//	public Test01(int a, int b) {
//		System.out.println("a="+a + "b="+b);
//	}

//	public Test01() {
//		super(); // 기본생성자를 호출,
//		System.out.println("Test01() ");
//	} //default 생성자
	
	
	// source -> GCS, GCF
	public Test01() {
		super();
		
	}

	
	public Test01(int a, int b) {
	super();
	this.a = a;
	this.b = b;
	}



	public static void main(String[] args) {
			//클래스 이름, 클래스 변수 = new 클래스이름():
		Test01 t1 = new Test01();
		System.out.println(t1.toString());
			//class : 사용자자료형 -> 정보, 주소 등 = object
		
		//System.out.println(new Test01().toString()); //동적메모리?
		Test01 t2 = new Test01(100,200);
		System.out.println(t2.toString());
		
	}

}
