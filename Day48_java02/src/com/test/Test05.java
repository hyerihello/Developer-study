package com.test;

import java.util.Arrays;

// java.util.Arrays
public class Test05 {

	public static void disp() {
		// 데이터타입 변수명 [] = {,,,,,}
		//int ar[] = {10,20,30,40,50};
		
		//데이터타입 [] 변수명  = {,,,,,}
		int [] ar = {10,20,30,40,50};
		
		System.out.println(ar[0]);
		System.out.println(ar[1]);
		System.out.println(ar[2]);
		System.out.println(ar[3]);
		System.out.println(ar[4]);
		
		
		System.out.println(ar.length);
		for (int i = 0; i < ar.length; i++) {
			System.out.printf("%5d", ar[i]);
		}
		
		System.out.println("\n==============\n");
		
		
		System.out.println(ar.length);
		for (int i = ar.length-1; i >=0; i--) {
			System.out.printf("%5d", ar[i]);
		}
		
		
		System.out.println("\n==============\n");
		
		// 참조형, 역출력은 안된다.
		for(int res : ar){
			System.out.printf("%5d", res);
			
		}
	}
	

	public static void disp02() {
		// 데이터타입 [] 변수명  = new 데이터타입 [요소의크기];
		int [] ar = new int [5];
		ar[0]=10;
		ar[1]=20;
		ar[2]=30;
		ar[3]=40;
		ar[4]=50;
		
		for (int res: ar) {
			System.out.printf("%5d", res);
		}
	}
	
	public static void disp03() { 
	//데이터타입 [] 변수명  = new 데이터타입 []{,,,,};
		int [] ar = new int [] {10,20,30,40,50};	
			
		for (int res: ar) {
			System.out.printf("%5d", res);
		}
	}

	
	public static void disp04(int[]ar02) { //ar02 =ar
		
		for (int res: ar02) {
			System.out.printf("%5d", res);
		}
	}
	
	
	
	public static void main(String[] args) {
//		disp03();
//	}
		int [] ar = new int [] {10,20,0,40,50};
		disp04(ar);
		
		System.out.println();
		java.util.Arrays.sort(ar); //import java.util ''' 안써도됨
		disp04(ar);
		
		System.out.println();
		
		int[] ar02 = Arrays.copyOfRange(ar,3,5);
		disp04(ar02);
	}
}
