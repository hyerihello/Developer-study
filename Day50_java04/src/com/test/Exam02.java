package com.test;

import java.util.Scanner;

/*
   ����2) str�� ���� cnvr���� �غ���.
 1. ��ü�� �빮�ڷ� ��� : public String toUpperCase()
 2. ��ü�� �ҹ��ڷ� ��� : public String toLowerCase()
 3. ������ ������ ��� : public String trim()
 4. ������ ã�� ��Ʈ�� ��� : public String replace(CharSequence target,
							                  CharSequence replacement)
 5. �Էµ� ���ڸ� ���� �� ��� : Scanner sc = new Scanner(System.in);
 						  int i = sc.nextInt();
 6. ���ڿ��� �ϳ��� ����Ʈ�� ��ȯ �� ��� : get byte public byte[] getBytes()
 7. ���ڿ��� �������� ��ö�ؼ� ��ö�� �����͸� �������. : public String[] split(String regex)
 8(+). ����ȿ� ���ڸ� �ְ�, ���ڸ� ������ ���� ���ϱ�. : public char[] toCharArray()
*/


public class Exam02 {

	public static void cnvr(String res) {
		String res01 = res.toUpperCase();
		System.out.println(res01);
		
		
		String res02 = res.toLowerCase();
		System.out.println(res02);
		
		String res03 = res.trim();
		System.out.println(res03);
		
		String res04 = res.replace(' ', '��');
		System.out.println(res04);
		
		Scanner s = new Scanner(System.in); // ���� �޾ƾ���
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