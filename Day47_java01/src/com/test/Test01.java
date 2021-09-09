package com.test;
// 자바는 패키지 안에 폴더로 파일을 생성한다. 패키지가 2단계 이상이어야한다. (com.test)
// src는 소스코드 

public class Test01 {
// class 앞에 public 접근지정자 지정, 유저네임 Test01은 파일이름과 동일
// 대소문자는 가린다. 
// 자바의 클래스 단위는 class
	public static void Ex01() {
	
		System.out.println("Ex01's method");
		// 단축키 syso ctrl + space 
	}

	public static void main(String[] args) {
	// ma + ctrl +space
		
	// 진입점 , main 실행, 필수 main 메서드가 있어야함 
		System.out.print("연습이라네 ~~");
		//실행 단축키 ctrl + F11 
		//실행 명령어 뒤엔 ; 반드시 지정
		// .연산자는 귀속 연산자 System멤버 out. 
		Ex01();
		// class명.멤버
		System.out.println(); // java.lang 내에 있는 멤버들은 import 하지 않고 호출 할 수 있다.
		System.out.println();
		Myclass.Disp();
		// ▲ public class MyClass {
				//public static void Disp(){
		//}
		//}
	}
}
