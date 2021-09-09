package com.test1;


public class Test02_2 {
	
	public static void Prn_int() {
		
		System.out.println(100);
		System.out.println(100+100);
		System.out.println(100-100);
		
		System.out.println("**************");
		
		System.out.printf("%5d %5d %10d \n", 100,100,200);
		System.out.printf("%5o %5o %10o \n", 100,100,200);
		System.out.printf("%5x %5x %10x \n", 100,100,200);
		
		System.out.println("**************");
		
		int a = 100;
		int b = 200;
		System.out.println(a);
		System.out.println(a+a);
		System.out.println(a-a);
		
		System.out.println("**************");
		
		System.out.printf("%5d %5d %10d \n", a,a,b);
		System.out.printf("%5o %5o %10o \n", a,a,b);
		System.out.printf("%5x %5x %10x \n", a,a,b);
		
		System.out.println("**************");
	}
	
	
	public static void Prn_float() {
	
		System.out.println(98.7);
		System.out.println(98.7f);
		
		String str = String.format("%10.2f %10.2f\n", 98.7, 98.7f);
		String str2 = String.format("%10.2f %-10.2f\n", 98.7, 98.7f);
		System.out.println(str);
		System.out.println(str2);
	}

	public static void Prn_char() {
		System.out.println('A');
		System.out.printf("%5c\n", 'A');
		
		char ch = 'A';
		System.out.println("ch = " + ch + "code = " + (int)ch);
		System.out.printf("%5d\n", (int)ch);
		
	}
	
	public static void Prn_String() {
		System.out.println("\'우리\'나라 '대한'민국");
		String str = "우리나라 대한민국";
		System.out.println(str);
		
	}
		
	

	
	public static void main(String[] args) {
		Prn_int();
		Prn_float();
		Prn_char();
		Prn_String();
	}
}
