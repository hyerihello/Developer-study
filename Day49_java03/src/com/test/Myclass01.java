package com.test;

import java.util.Random;
// 클래스 개념 
// 1. 캡슐화클래스 구현 (생성자, setter,getter,재정의 - @Override= Object(개념이해 ex,toString))
// Object-docs에서 _toString
//   -> 참조형 .jar구현방법
// 2.상속, 3. 다형성

public class Myclass01 {

	// 오버로드 : 리턴되는 값이 같음
	// 오버라이딩 : 정의를 새로해서 값이 리턴되는 값이 같음
	
	@Override // : 오버라이드 어노테이션, 재정의되어있는것을 체크해준다. 소스시작할때 걸러준다.
			 // 경고, check,
	public String toString() {
		return "내꺼야";
	}
	
	public static void main(String[] args) {
		System.out.println(new Myclass01().toString());
		// 객체. 하면 원하던 원하지 않던 자동으로 호출 
		// 재정의를 하면 재정의한 것이오고, 아니면 object가온다.
		System.out.println(new Myclass01());
		
		Myclass01 t1 = new Myclass01();
		System.out.println(t1);
		System.out.println(t1.toString());
		
		System.out.println(new Integer("100")); // Integer class가 재정의했네 라고 생각
		System.out.println(new Integer("100").toString()); //위랑 같음
		
		System.out.println(new Random()); //random class라서 안에 값이있어야 난수발생, 재정의x
	}
}
//오마클 export : general -> acaive