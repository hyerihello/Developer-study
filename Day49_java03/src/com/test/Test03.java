package com.test;

public abstract class Test03 {

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

// object aid 를 이용해 클래스 다이어그램으로 구현하자. 
//3칸으로나뉨 : 이름, 필드, 메소드 
// 이탤릭체class - 추상클래스구나 
// c : 메소드 
// 언더라인 : 스태틱
// a : abstract 
// : 뒤에는 리턴메소드 