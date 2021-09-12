package com.test;

public class Test02 {

	public static void prn() {
		//String(String original)
		
		String str = "The String class represents character strings.";
		String str02 = new String(str);
		String str03 = new String (new String("The String class represents character strings."));
		String str04 = new String ("The String class represents character strings.");
		
		System.out.println(str + "\n"+ str02 + "\n"+ str03 + "\n"+ str04); // 모두 같은 결과를 가져온다
		
		
		String res = str.toUpperCase();
		System.out.println(res); // 변수를 리턴하면 대문자를 출력하지만,
		System.out.println(str); // 초기값은 변하지 않는다.
				
		
	}
	
	public static void prn02() {
	/* 
	 
	1. String = C
	   : 순수 문자열 관리
		
	2.  StringBuffer = C - append/insert,  R - toString, U - replace, setCharAt  D - delete/ deleteCharAt
	   : A thread-safe, mutable sequence of characters. 문자열을 가져다가 조작하는 데 안전함 (네트워크 통신 사용)
		
	3.  StringBuilder = C - append/insert,  R - toString, U - replace, setCharAt  D - delete/ deleteCharAt
	   : 웹에서 대부분 사용  
	*/
		
		//StringBuffer sb = new StringBuffer();
		StringBuilder sb = new StringBuilder(20);
		//sb.append("abc");
//		for (int i = 0; i<= 16; i++) { // i <= 34 는 70리턴 
//			//sb.append(i);}
//			sb.append((char)i);}
		

		for (int i = 65; i <= 80; i++) { // i = 65 일때 80이하까지 1씩더해서 리턴하자. char로도 리턴해보자.
			//sb.append(i);
			sb.append((char)i);}
		
	
		
		sb.delete(3,6); // delete(int start, int end) 
		System.out.println(sb.capacity()); //용량은 기본 16, 숫자가 커지면 용량도 커지는것을 확인하자.
		System.out.println(sb);
			
	}
	public static void main(String[] args) {


		prn02();
		
		
	}
}
