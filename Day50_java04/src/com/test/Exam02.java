package com.test;

import java.util.Scanner;

/*
   문제2) str을 받은 cnvr조작 해보자.
 1. 전체를 대문자로 출력 : public String toUpperCase()
 2. 전체를 소문자로 출력 : public String toLowerCase()
 3. 공백을 제거후 출력 : public String trim()
 4. 공백을 찾아 하트로 출력 : public String replace(CharSequence target,
							                  CharSequence replacement)
 5. 입력된 글자를 삭제 후 출력 : Scanner sc = new Scanner(System.in);
 						  int i = sc.nextInt();
 6. 문자열을 하나식 바이트로 변환 후 출력 : get byte public byte[] getBytes()
 7. 문자열을 공백으로 분철해서 분철된 데이터를 출력하자. : public String[] split(String regex)
 8(+). 문장안에 숫자를 넣고, 숫자만 꺼내서 합을 구하기. : public char[] toCharArray()
*/


public class Exam02 {

	public static void cnvr(String res) {
		String res01 = res.toUpperCase();
		System.out.println(res01);
		
		
		String res02 = res.toLowerCase();
		System.out.println(res02);
		
		String res03 = res.trim();
		System.out.println(res03);
		
		String res04 = res.replace(' ', '♥');
		System.out.println(res04);
		
		Scanner s = new Scanner(System.in); // 값을 받아야함
		String res05 = s.nextLine();
		System.out.println(res05);
		System.out.println(res.replace(res05," "));
		
		byte[] res06 = res.getBytes();
		System.out.println(res06);
		
		String[] res07 = res.split(" ");
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
		
		
}}

/*
String str = "The String class represents character strings.";
String str02 = new String(str);
String str03 = new String (new String("The String class represents character strings."));
String str04 = new String ("The String class represents character strings.");

System.out.println(str + "\n"+ str02 + "\n"+ str03 + "\n"+ str04);


String res = str.toUpperCase();
System.out.println(res);
System.out.println(str);
*/