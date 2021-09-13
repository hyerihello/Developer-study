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
