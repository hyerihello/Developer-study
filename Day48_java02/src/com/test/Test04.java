package com.test;

// ������ for



public class Test04 {
	//1. 1~100 �����͸� ����Ѵ�.
	public static void Prn() {
		
		for (int i=1; i <= 100; i++) {
			System.out.printf("%5d", i);
		}
		
	}
	
	
	
	//2. 1~10, 11~10 ����Ѵ�.
public static void Prn01() {

	for (int i=1; i <= 100; i++) {
		if (i % 10 == 0) {
		System.out.printf("%5d", i);
		System.out.println();
	} else {
		System.out.printf("%5d", i);
	}}}
	
	
	
	//3. 10���ڸ��� ��Ʈ�� �ٿ���
public static void Prn02() {
	
	
	for (int i=1; i <= 100; i++) {
		if (i % 10 == 0) {
		System.out.printf("%5c", '��');
		System.out.println();
	} else {
		System.out.printf("%5d", i);
	}}
}
	//4. 2�� ���, 3�� ��� �ڸ��� �������

public static void Prn03() {
	
	for (int i=1; i <= 100; i++) {
		if (i % 10 == 0) {
		System.out.printf("%5c", '��');
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
