package com.test;

public class Test {
	
	public static void Prn(Abstract_aa a2) { // Abstract_aa a2 = new My(); �� ����
		a2.test();
	}
	
public static void main(String[] args) { // �����ϴ� Test class 


	// case 1
	My m1 = new My(); // My Ÿ���� m1(����) �� ��������(new My)
	m1.test(); // My�� test�޼ҵ带 �����Ѵ�.
	
	// case 2
	Abstract_aa a1 = new My(); // ������ �ּҹ����� ����
	a1.test(); // My�� Abstract_aa�� �����޾ұ� ������ �θ��̸����� My�� test �޼ҵ带 ���Ϲ��� �� �ִ�.
			   // upper casting?
	
	
	//case 3
	Prn(new My());	//������ �ּҸ� �޼ҵ�� ����
					// Prn(Abstract_aa a2) = Abstract_aa a2 = new My(); �� ���� ������ 
					// Prn(new My()) �� ���� ���� �� �ִ�. 
	
	//case 4
	Prn(new Abstract_aa() { // ������ ������ �ؾ��Ѵ�. (�߻�Ŭ����, �������̽��� new�����ڸ� ����� �����µ� �͸����� 1�� ����� �� �ִ�)

		@Override
		public void test() {
			System.out.println("�� �����Ǿ�!");
			
		}
		
	});}
}
