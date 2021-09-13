package com.test02;

public class MTest3 {

	public static void main(String[] args) {
		
		base b1 = new Pig(); // new Base() <- new Pig() 동적바인딩(선조로 후손을제어), object를 써도된다.
		b1.Start();
		b1.Stop();
		System.out.println("↑ 동적바인딩!");
		
		// down casting , 주소번지에 올라간 것만 사용할 수 있다.
	
		((Pig)b1).setA(100); 
		System.out.println(((Pig)b1).getA());
		System.out.println("↑ 다운캐스팅!");
	}

}
