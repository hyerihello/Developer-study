package com.test02;

public class MTest3 {

	public static void main(String[] args) {
		
		base b1 = new Pig(); // new Base() <- new Pig() �������ε�(������ �ļ�������), object�� �ᵵ�ȴ�.
		b1.Start();
		b1.Stop();
		System.out.println("�� �������ε�!");
		
		// down casting , �ּҹ����� �ö� �͸� ����� �� �ִ�.
	
		((Pig)b1).setA(100); 
		System.out.println(((Pig)b1).getA());
		System.out.println("�� �ٿ�ĳ����!");
	}

}
