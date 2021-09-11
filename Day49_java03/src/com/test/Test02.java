package com.test;


// 클래스의 멤버변수는 은닉화 하고 은닉된 멤버변수에서 값을 전다라 및 변경 setter,
// 리턴하는 구조 return_type getter 를 만들어서 접근에 대한 제어를 구현한다.

public class Test02 {

	private int a; //같은 class내에서는 호출 가능하다.
	
//	// void setter
//	public void setA(int a) {
//		this.a = a;
//	}
//	// getter
//	public int getA() {
//		return a;
//	}
//	
	
	// source -> getter,setter 
	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public static void main(String[] args) {
		Test02 t1 = new Test02();
		System.out.println(t1.a);
		t1.setA(100); // 값 전달 및 변경
		System.out.println(t1.getA()); // 값 리턴 

	}

}
