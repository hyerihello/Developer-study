package com.test04;

 //throws : 예외를 위임, 메소드 뒤에 선언하는 키워드
 //throw : 예외를 실행하는 키워드,   throw new MyException();

 /* try {
  
  } catch(후손 Exception){
  
  } catch(Exception e){
  
  } finally {
  
  }
       
   */

public class Mtest {

	public static void main(String[] args) {
		// 메인 실행시 두개의 정수를 받아서 합을 구하자.
		
		int a = 0;
		
		int b = 0;
		
		try {
		a = Integer.parseInt(args[0]);
		b = Integer.parseInt(args[1]);
		}catch(NumberFormatException n) {
			System.out.println("예외났음");
		}
		System.out.println(a+b);

	}

}
