package com.test;

// 연습용 for



public class Test04 {
	//1. 1~100 데이터를 출력한다.
	public static void Prn() {
		
		for (int i=1; i <= 100; i++) {
			System.out.printf("%5d", i);
		}
		
	}
	
	
	
	//2. 1~10, 11~10 출력한다.
public static void Prn01() {

	for (int i=1; i <= 100; i++) {
		if (i % 10 == 0) {
		System.out.printf("%5d", i);
		System.out.println();
	} else {
		System.out.printf("%5d", i);
	}}}
	
	
	
	//3. 10의자리에 하트를 붙여라
public static void Prn02() {
	
	
	for (int i=1; i <= 100; i++) {
		if (i % 10 == 0) {
		System.out.printf("%5c", '♥');
		System.out.println();
	} else {
		System.out.printf("%5d", i);
	}}
}
	//4. 2의 배수, 3의 배수 자리는 비워두자

public static void Prn03() {
	
	for (int i=1; i <= 100; i++) {
		if (i % 10 == 0) {
		System.out.printf("%5c", '♥');
		System.out.println();
	} else if ((i % 2 == 0) || (i % 3 == 0)){
		System.out.printf("%5c", 32);
	} else {
		System.out.printf("%5d", i);
	}}
	}

	public static void main(String[] args) {
		Prn03();

	}

}
