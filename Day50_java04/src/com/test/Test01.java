package com.test;

/*  	== �ּ� �� ������ (������ �Ұ�)
		new Car("bm7") == new Car("bm7")
		= new Car("bm7").toString() == new Car("bm7").toString() - ������ ����,
		 - ������ ���� ���� ���� �ּ� �񱳿������̴�. 

		 */

public class Test01 {
	
	public static void main(String[] args) {
		
		Integer i = new Integer(100);
		System.out.println(i + ":" + i.toString());
		
		Integer i2 = new Integer("100"); // �Ľ�
		System.out.println(i2 + 10 + "\t" + (i2.toString() + 100)); 
		// i2 + 10 �� ����ȯ�� ������ 110�� �����ϰ�
		// (i2.toString() + 100) �� ���ڿ��� �ν��� 100100�� �����Ѵ�.
		
		Double d1 = new Double("92.9");
		System.out.println(d1 + ":" + d1.toString() + "\t" + (d1.toString()+30)); 
				// (d1.toString()+30) : ���ڿ�, ���յȴ�.
		
		
		Integer i3 = 100; //Integer i3 = new Intger(100)
		System.out.println(i3);
		
		Double d3 = 97.9;
		System.out.println(d3);
		
		
		double d4 = new Double(98.9); // ����Ŭ���� �ڵ�ȣȯ 
		System.out.println(d4); // ��ü�� �Ϲ� �ڷ����� ����� ������ .����Ȯ���ϸ� �ż��尡 ������ �ʴ´�.
		
	}
// to.String docs���� Overrides:
	// toString in class Object -> �������ߴ�. 
}
