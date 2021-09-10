package com.test;

public class Test03 {

	public static void for_test() {
		System.out.println("case 1: 1~10 출력");
		
		for (int i =1; i <= 10; i++) {
			
			System.out.printf("%5d", i);
		}
	}
	
	
	
	public static void for_test02() {
		System.out.println("\ncase 2: 10~1 출력");
		int i = 0;
		for ( i = 10; i > 0; i--) {
			
			System.out.printf("%5d", i);
		}
		System.out.println("\n ==> i = " + i);
		
}
	
	
	
	public static void for_test03() {
		System.out.println("\ncase 3: 1~100, 2의 배수만 출력 해보자. 갯수도 출력하자");
		
		int i = 0;
		int cnt = 0;
		for (i = 1; i <= 100 ;i++) {
			
			if(i % 2 == 0) {
			System.out.printf("%5d", i);
			cnt++;
		}}
		System.out.println("\n ==> cnt = " + cnt);
		}
	
	
	
	public static void for_test04() {
		System.out.println("\ncase 4: 중첩 for 출력");
		
		for (int i = 1; i <= 5; i++) {
			for(int j = 1; j <= 5; j++) {
				System.out.printf("%5d", i);
		}
		System.out.println();
		}}
	
	
	public static void for_test05() {
		System.out.println("\ncase 5: 중첩 for 출력");
		
		for (int i =1; i <= 5 ;i++) {
			for (int j = 1; j <= 5; j++) {
				System.out.printf("%5d", j);
		}
		System.out.println();
		}}
	
	// for(시작, 끝, 갭){statement(s)}
	public static void for_test06() {
		System.out.println("\ncase 6: 중첩 for 출력");
		
		for (int i =1; i <= 21; i += 5) {
			for (int j = i; j <= i + 4; j++) {
				System.out.printf("%5d", j);
			}
			System.out.println();
		}}
	
	
	public static void for_test07() {
	System.out.println("\ncase 7: 중첩 for 출력");
	
	for (int i =1; i <= 5; i++) {
		for (int j = i; j <= i+20; j+=5) {
			System.out.printf("%5d", j);
		}
		System.out.println();
	}
	}

	
	
	public static void for_test08() {
	System.out.println("\ncase 8: 중첩 for 출력");
	
	for (int i =25; i >= 21; i--) {
		for (int j = i; j >= i-20; j-=5) {
			System.out.printf("%5d", j);
		}
			System.out.println();
	}
	} 

	
	public static void main(String[] args) {

		//for_test08();

		int a = 10;
		int k = 300;
		{
		System.out.println("a = " + a);
		k = 100; // 재대입
		System.out.println("k = " + k);
		}
		System.out.println("k = " + k);
	
	}}


