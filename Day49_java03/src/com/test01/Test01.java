package com.test01;

public class Test01 {

	
	public static void main(String[] args) {
		BB b1 = new BB();//  b1�� �ּҸ� �޴� ���� (AA�� �����ް�, ���Ŀ� BB����)
		// (AA BB) b1 = new (AA()��BB()) AA�����ϰ� BB�����ϰ�
		// AA a1 = new BB();
		// AA a1 = new(AA()��BB())
		//BB b2 = new AA(); --> x
		 // 2��¥���� �Ѱ�¥���Ἥ
		b1.setA(100);
		b1.setB(100);
		
		System.out.println(b1.getHap());
		System.out.println(b1.getResult());
		System.out.println(b1.getA() + " : " + b1.getB());
	}
}
