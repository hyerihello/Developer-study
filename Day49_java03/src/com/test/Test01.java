package com.test;

//�� public class Test01 extends object{} �� ����
// ���Ŭ������ object�� �ļջ���̰� ���ϻ���̴�.
// Ŭ���� ��ü�� ��ȯ���� ����.
// ���Ŭ������ ������ ����,
// this() super() -> ������ �ȿ����� �ۼ��� �����ϴ�, ������ ù�ٿ� ����Ǿ���Ѵ�.

public class Test01 {
	private int a;
	private int b;
	
//	public Test01() { //1. super �������ְ�
//		System.out.println("a="+a + "b="+b);
//	}
//	public Test01(int a, int b) {
//		System.out.println("a="+a + "b="+b);
//	}

//	public Test01() {
//		super(); // �⺻�����ڸ� ȣ��,
//		System.out.println("Test01() ");
//	} //default ������
	
	
	// source -> GCS, GCF
	public Test01() {
		super();
		
	}

	
	public Test01(int a, int b) {
	super();
	this.a = a;
	this.b = b;
	}



	public static void main(String[] args) {
			//Ŭ���� �̸�, Ŭ���� ���� = new Ŭ�����̸�():
		Test01 t1 = new Test01();
		System.out.println(t1.toString());
			//class : ������ڷ��� -> ����, �ּ� �� = object
		
		//System.out.println(new Test01().toString()); //�����޸�?
		Test01 t2 = new Test01(100,200);
		System.out.println(t2.toString());
		
	}

}
