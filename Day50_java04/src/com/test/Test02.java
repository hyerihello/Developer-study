package com.test;

public class Test02 {

	public static void prn() {
		//String(String original)
		
		String str = "The String class represents character strings.";
		String str02 = new String(str);
		String str03 = new String (new String("The String class represents character strings."));
		String str04 = new String ("The String class represents character strings.");
		
		System.out.println(str + "\n"+ str02 + "\n"+ str03 + "\n"+ str04); // ��� ���� ����� �����´�
		
		
		String res = str.toUpperCase();
		System.out.println(res); // ������ �����ϸ� �빮�ڸ� ���������,
		System.out.println(str); // �ʱⰪ�� ������ �ʴ´�.
				
		
	}
	
	public static void prn02() {
	/* 
	 
	1. String = C
	   : ���� ���ڿ� ����
		
	2.  StringBuffer = C - append/insert,  R - toString, U - replace, setCharAt  D - delete/ deleteCharAt
	   : A thread-safe, mutable sequence of characters. ���ڿ��� �����ٰ� �����ϴ� �� ������ (��Ʈ��ũ ��� ���)
		
	3.  StringBuilder = C - append/insert,  R - toString, U - replace, setCharAt  D - delete/ deleteCharAt
	   : ������ ��κ� ���  
	*/
		
		//StringBuffer sb = new StringBuffer();
		StringBuilder sb = new StringBuilder(20);
		//sb.append("abc");
//		for (int i = 0; i<= 16; i++) { // i <= 34 �� 70���� 
//			//sb.append(i);}
//			sb.append((char)i);}
		

		for (int i = 65; i <= 80; i++) { // i = 65 �϶� 80���ϱ��� 1�����ؼ� ��������. char�ε� �����غ���.
			//sb.append(i);
			sb.append((char)i);}
		
	
		
		sb.delete(3,6); // delete(int start, int end) 
		System.out.println(sb.capacity()); //�뷮�� �⺻ 16, ���ڰ� Ŀ���� �뷮�� Ŀ���°��� Ȯ������.
		System.out.println(sb);
			
	}
	public static void main(String[] args) {


		prn02();
		
		
	}
}
