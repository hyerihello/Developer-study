package com.exam;

public class Test {

public static void main(String[] args) {
	
	MyClass m1 = new MyClass(); 
	System.out.println(m1); // 값을 주지 않았으니 null 반환
	System.out.println();
	
	
	//public MyClass(String name, Address address, Score score)
	System.out.println("==============<1. 주소를 서울시로 수정> =============");
	MyClass m2 = new MyClass("홍길동", new Address("서울시", "02-000-0000"), new Score(90,80,70));
	System.out.println(m2);
	
	
	
	/*
	//m2.getM_address(); //아래랑 같다
	Address r = m2.getM_address();
	r.setAddr("부산시");
	*/
	System.out.println("============= <2. 주소를 부산시로 수정> ============");
	m2.getM_address().setAddr("부산시");
	System.out.println(m2);
	
	
	System.out.println("============ <국어점수를 100점으로 수정> ============");
	m2.getM_score().setKor(100);
	System.out.println(m2);
	System.out.println(m2.getM_score().getKor()); //국어점수만 리턴
	}
}
