package com.test02;

import java.util.Scanner;

public class MTest {

	public static void main(String[] args) {
		
		System.out.println("Input no :");
		Scanner sc = new Scanner(System.in);
		int no = sc.nextInt();
		
		base b1 = null; // null�̶� Ű����� ��ü�� null�� �ʱ�ȭ ���ִ� Ű�����̴�.
		switch(no){ // �������ε� : �������� ����  1. �ڵ带 �����ϰ��Ѵ�, 2. �޸� �ӵ���� , 3. �޸� ȿ�������� ��� 
		
		case 1: 
			b1 = new Duck();
			break;
			
		case 2: 
			b1 = new Puppy();

			break;
			
		case 3: 
			b1 = new Pig();

			break;
		}
		b1.Start();
		b1.Stop();
	}
}
