package com.exam;

public class Test {

public static void main(String[] args) {
	
	MyClass m1 = new MyClass(); 
	System.out.println(m1); // ���� ���� �ʾ����� null ��ȯ
	System.out.println();
	
	
	//public MyClass(String name, Address address, Score score)
	System.out.println("==============<1. �ּҸ� ����÷� ����> =============");
	MyClass m2 = new MyClass("ȫ�浿", new Address("�����", "02-000-0000"), new Score(90,80,70));
	System.out.println(m2);
	
	
	
	/*
	//m2.getM_address(); //�Ʒ��� ����
	Address r = m2.getM_address();
	r.setAddr("�λ��");
	*/
	System.out.println("============= <2. �ּҸ� �λ�÷� ����> ============");
	m2.getM_address().setAddr("�λ��");
	System.out.println(m2);
	
	
	System.out.println("============ <���������� 100������ ����> ============");
	m2.getM_score().setKor(100);
	System.out.println(m2);
	System.out.println(m2.getM_score().getKor()); //���������� ����
	}
}
