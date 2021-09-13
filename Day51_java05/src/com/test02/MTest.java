package com.test02;

import java.util.Scanner;

public class MTest {

	public static void main(String[] args) {
		
		System.out.println("Input no :");
		Scanner sc = new Scanner(System.in);
		int no = sc.nextInt();
		
		base b1 = null; // null이란 키워드는 객체를 null로 초기화 해주는 키워드이다.
		switch(no){ // 동적바인딩 : 다형성의 목적  1. 코드를 단촐하게한다, 2. 메모리 속도향상 , 3. 메모리 효율적으로 사용 
		
		case 1: 
			b1 = new Duck();
			break;
			
		case 2: 
			b1 = new Puppy();

			break;
			
		case 3: 
			b1 = new Pig();

			break;
		}
		b1.Start();
		b1.Stop();
	}
}
