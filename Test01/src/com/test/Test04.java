package com.test;

public class Test04 {
	
	public static void Exam() {
		// 1. ������ ������ �ϳ�(a) �����ؼ� 10�� ��������. IntegerŬ������ �޼ҵ�� �����غ���.
		Integer a = 10;
		
		
		// 2. a�� 2������ ��ȯ �� ��� : public static String toBinaryString(int a)
		String str = Integer.toBinaryString(a);
		System.out.println(str);
		
		// 3. a�� 8������ ��ȯ �� ��� : public static String toOctalString(int a)
		
		
		String str02 = Integer.toOctalString(a);
		System.out.println(str02);
		
		// 4. a�� 16������ ��ȯ �� ��� : public static String toHexString(int a)
		String str03 = Integer.toHexString(a);
		System.out.println(str03);
		
	}
	
	
		public static void Exam02() {
			System.out.println("char�� ���� : " + Character.MIN_VALUE + "~" + Character.MAX_VALUE);
			System.out.println("char�� ���� : " + (int)Character.MIN_VALUE + "~" + (int)Character.MAX_VALUE);
		
		// ���� A�� �ҹ��ڷ� �����غ���. public static char toUpperCase(char ch)
			
		char ch = Character.toLowerCase('A');
		System.out.println(ch + " : " + Character.isLowerCase(ch));		
				
		// ���� a�� �빮�ڷ� �����غ���. public static char toLowerCase(char ch)

		
		System.out.println(Character.toUpperCase('a') + " : "
				+ Character.isUpperCase(Character.toUpperCase('a')));	
		
		boolean fw = true;
		System.out.println(fw + " : " + !fw);
		
		String str = "abcdefghijklmn"; //String str = new String("abcdefghijklmn");
		System.out.println(str.toLowerCase() + " : " + str.toUpperCase());
		}
	public static void main(String[] args) {
		
		Exam02();
	}

}
