package com.test04;

 //throws : ���ܸ� ����, �޼ҵ� �ڿ� �����ϴ� Ű����
 //throw : ���ܸ� �����ϴ� Ű����,   throw new MyException();

 /* try {
  
  } catch(�ļ� Exception){
  
  } catch(Exception e){
  
  } finally {
  
  }
       
   */

public class Mtest {

	public static void main(String[] args) {
		// ���� ����� �ΰ��� ������ �޾Ƽ� ���� ������.
		
		int a = 0;
		
		int b = 0;
		
		try {
		a = Integer.parseInt(args[0]);
		b = Integer.parseInt(args[1]);
		}catch(NumberFormatException n) {
			System.out.println("���ܳ���");
		}
		System.out.println(a+b);

	}

}
