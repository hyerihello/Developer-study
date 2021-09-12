package com.test;

/*  	== 주소 비교 연산자 (재정의 불가)
		new Car("bm7") == new Car("bm7")
		= new Car("bm7").toString() == new Car("bm7").toString() - 재정의 가능,
		 - 재정의 하지 않을 때는 주소 비교연산자이다. 

		 */

public class Test01 {
	
	public static void main(String[] args) {
		
		Integer i = new Integer(100);
		System.out.println(i + ":" + i.toString());
		
		Integer i2 = new Integer("100"); // 파싱
		System.out.println(i2 + 10 + "\t" + (i2.toString() + 100)); 
		// i2 + 10 은 형변환을 일으켜 110을 리턴하고
		// (i2.toString() + 100) 은 문자열로 인식해 100100을 리턴한다.
		
		Double d1 = new Double("92.9");
		System.out.println(d1 + ":" + d1.toString() + "\t" + (d1.toString()+30)); 
				// (d1.toString()+30) : 문자열, 결합된다.
		
		
		Integer i3 = 100; //Integer i3 = new Intger(100)
		System.out.println(i3);
		
		Double d3 = 97.9;
		System.out.println(d3);
		
		
		double d4 = new Double(98.9); // 내포클래스 자동호환 
		System.out.println(d4); // 객체를 일반 자료형을 만들기 때문에 .으로확인하면 매서드가 나오지 않는다.
		
	}
// to.String docs보면 Overrides:
	// toString in class Object -> 재정의했다. 
}
