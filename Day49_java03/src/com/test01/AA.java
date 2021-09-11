package com.test01;

//int a+b 를 관리하는 클래스 
public class AA {

	private int a;
	private int b;
	
	public AA() {
		System.out.println("AA 생성자");
	}
	
	// 상속시 후손 클래스는 public처럼 호출할 수 있다.
	// 같은 패키지 내에서만 클래스 변수를 통해서 public처럼 호출할 수 있다.
//	protected int getA() {
//		return a;
//	}
	protected int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}
	
	public int getHap() {
		return this.a + this.b;
	}

	
	
}
