package com.test1;


public class Test02_3 {
	
	public static void Prn_int() {
		
		Integer a = 100;
		Integer b = 200;
		System.out.println(a.longValue());
		System.out.println("**************");
		
		//public static String format(String format, Object... args)
		// static 매서드 //  리턴타입  매서드
		String res = String.format(" ", "%5x %5x \t %10x \n", a,a,b );
		System.out.println(res);
		
		System.out.println("**************");
	}
	
	
	public static void Prn_float() {
		
		Double d = 98.7;
		Float f = 98.7f;
		
		
		System.out.println(d); //double -- 효율이더좋다 8byte : 소수점 아래 18 자리까지도 표현
		System.out.println(f); //float 4byte : 소수점 아래 9 자리까지만 표현
		System.out.println("**************");
		
	}

	public static void Prn_char() {
		//데이터타입 변수 = 값;
		Character ch = 'A';
		System.out.println("ch = " + ch + "code = " + (int)ch);
		System.out.printf("%5d\n", (int)ch); // (int)형변환
		
	}
			
	

	
	public static void main(String[] args) {
		Prn_int();
		Prn_float();
		Prn_char();
	}
}
