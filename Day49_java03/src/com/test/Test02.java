package com.test;


// Ŭ������ ��������� ����ȭ �ϰ� ���е� ����������� ���� ���ٶ� �� ���� setter,
// �����ϴ� ���� return_type getter �� ���� ���ٿ� ���� ��� �����Ѵ�.

public class Test02 {

	private int a; //���� class�������� ȣ�� �����ϴ�.
	
//	// void setter
//	public void setA(int a) {
//		this.a = a;
//	}
//	// getter
//	public int getA() {
//		return a;
//	}
//	
	
	// source -> getter,setter 
	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public static void main(String[] args) {
		Test02 t1 = new Test02();
		System.out.println(t1.a);
		t1.setA(100); // �� ���� �� ����
		System.out.println(t1.getA()); // �� ���� 

	}

}
