package com.test01;

public class Test01 {

	
	public static void main(String[] args) {
		BB b1 = new BB();//  b1은 주소를 받는 변수 (AA를 먼저받고, 그후에 BB받음)
		// (AA BB) b1 = new (AA()→BB()) AA생성하고 BB생성하고
		// AA a1 = new BB();
		// AA a1 = new(AA()→BB())
		//BB b2 = new AA(); --> x
		 // 2개짜린데 한개짜리써서
		b1.setA(100);
		b1.setB(100);
		
		System.out.println(b1.getHap());
		System.out.println(b1.getResult());
		System.out.println(b1.getA() + " : " + b1.getB());
	}
}
