package com.test;
// �ڹٴ� ��Ű�� �ȿ� ������ ������ �����Ѵ�. ��Ű���� 2�ܰ� �̻��̾���Ѵ�. (com.test)
// src�� �ҽ��ڵ� 

public class Test01 {
// class �տ� public ���������� ����, �������� Test01�� �����̸��� ����
// ��ҹ��ڴ� ������. 
// �ڹ��� Ŭ���� ������ class
	public static void Ex01() {
	
		System.out.println("Ex01's method");
		// ����Ű syso ctrl + space 
	}

	public static void main(String[] args) {
	// ma + ctrl +space
		
	// ������ , main ����, �ʼ� main �޼��尡 �־���� 
		System.out.print("�����̶�� ~~");
		//���� ����Ű ctrl + F11 
		//���� ��ɾ� �ڿ� ; �ݵ�� ����
		// .�����ڴ� �ͼ� ������ System��� out. 
		Ex01();
		// class��.���
		System.out.println(); // java.lang ���� �ִ� ������� import ���� �ʰ� ȣ�� �� �� �ִ�.
		System.out.println();
		Myclass.Disp();
		// �� public class MyClass {
				//public static void Disp(){
		//}
		//}
	}
}
