package com.test;

import java.util.Random;
// Ŭ���� ���� 
// 1. ĸ��ȭŬ���� ���� (������, setter,getter,������ - @Override= Object(�������� ex,toString))
// Object-docs���� _toString
//   -> ������ .jar�������
// 2.���, 3. ������

public class Myclass01 {

	// �����ε� : ���ϵǴ� ���� ����
	// �������̵� : ���Ǹ� �����ؼ� ���� ���ϵǴ� ���� ����
	
	@Override // : �������̵� ������̼�, �����ǵǾ��ִ°��� üũ���ش�. �ҽ������Ҷ� �ɷ��ش�.
			 // ���, check,
	public String toString() {
		return "������";
	}
	
	public static void main(String[] args) {
		System.out.println(new Myclass01().toString());
		// ��ü. �ϸ� ���ϴ� ������ �ʴ� �ڵ����� ȣ�� 
		// �����Ǹ� �ϸ� �������� ���̿���, �ƴϸ� object���´�.
		System.out.println(new Myclass01());
		
		Myclass01 t1 = new Myclass01();
		System.out.println(t1);
		System.out.println(t1.toString());
		
		System.out.println(new Integer("100")); // Integer class�� �������߳� ��� ����
		System.out.println(new Integer("100").toString()); //���� ����
		
		System.out.println(new Random()); //random class�� �ȿ� �����־�� �����߻�, ������x
	}
}
//����Ŭ export : general -> acaive