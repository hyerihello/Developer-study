package com.test01;

//int a+b �� �����ϴ� Ŭ���� 
public class AA {

	private int a;
	private int b;
	
	public AA() {
		System.out.println("AA ������");
	}
	
	// ��ӽ� �ļ� Ŭ������ publicó�� ȣ���� �� �ִ�.
	// ���� ��Ű�� �������� Ŭ���� ������ ���ؼ� publicó�� ȣ���� �� �ִ�.
//	protected int getA() {
//		return a;
//	}
	protected int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}
	
	public int getHap() {
		return this.a + this.b;
	}

	
	
}
