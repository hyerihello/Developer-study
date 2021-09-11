package com.test01;

//int a+b 를 관리하는 클래스 
public class AA2 {

	private int a;
	private int b;
	
	public AA2() {
		System.out.println("AA 생성자");
	}

	public int getA() {
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
