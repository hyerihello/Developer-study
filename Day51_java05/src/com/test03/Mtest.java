package com.test03;

public class Mtest {
	public static void main(String[] args) {
	
		Car c1 = new Car("sm5"); // ������ ���� sm5�������� super�ΰ���
		Car c2 = new Car("sm5"); // sm5�� ������ 
		
		System.out.println("�ּҺ� : " + (c1 == c2)); // c1.toString() == c2.toString()
		// �ּҺ��ߴ��� �ٸ���
		System.out.println("�ּҺ� : " + (c1.equals(c2))); // c1.toString() == c2.toString()
		
			if(c1.equals(c2)) { // this.��ü�� �Ѿ�°�ü�� ��
				System.out.println(" ���̸��� ���� ");
			}else {
				System.out.println(" �̸��� �޶� ");}
}
}
