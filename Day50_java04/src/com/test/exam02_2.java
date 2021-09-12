package com.test;

import java.util.Scanner;

public class exam02_2 {

	public static void cnvr(String res) { // void 가있으면 return 실행 불가
		String res01 = res.toUpperCase();
		System.out.println(res01);
		
		String res02 = res.toLowerCase();
		System.out.println(res02);
		
		String res03 = res.trim();
		System.out.println(res03);
		
		String res04 = res.replace(' ', '★');
		System.out.println(res04);

		Scanner s = new Scanner(System.in);
		String res05 = s.nextLine();
		System.out.println(res05);
		System.out.println(res.replace(res05," "));
		
		byte[] res06 = res.getBytes();
		System.out.println(res06);
		
		String [] res07 = res.split(" ");
		for (int i = 0; i < res07.length; i++) {
		System.out.println(res07[i]);
		}
		
		char [] res08 = res.toCharArray();
		int sum = 0;
		for (int i=0; i<res08.length; i++) {
			if(Character.isDigit(res08[i]));
			sum += Character.getNumericValue(res08[i]);
			
		}
		System.out.println(sum);
		
		
		
		
	}
public static void main(String[] args) {
	String str = "  The String class represents character strings. ";
	cnvr(str);
}
}
