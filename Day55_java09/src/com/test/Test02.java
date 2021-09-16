package com.test;

// main thread가 실행되는 것을 알 수 있다.
// Process는 액티브 프로그램이라고 할 수 있다. 
// 하나의 프로세스는 자신만의 전용 공간과 자원을 할당받은 상태에서 독점적으로 일을 처리하는 구조를 가진다.
// Thread는 프로세스 내부에 존재하며 공간과 자원을 공유하면서 일을 처리한다.
// ex) Process는 자신의 집에 서재를 꾸미고 위인전집을 사놓은 구조이고 공공 도서관은 Thread라고 생각하면된다.

public class Test02 {

	public static void main(String[] args) {
		System.out.println(" 싱글 Thread 야");
		for (int i = 0; i <= 100; i++) {
			System.out.println(Thread.currentThread().getName()+ ":" + i);
		}
	}
}
