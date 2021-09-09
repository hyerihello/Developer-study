package com.test;

public class Test02 {
	
	public static void Prn_int() {
		// ������ ����
		// ��������, ������ : �����ڿ��� �ʱ�ȭ�� �ڵ����� �����Ѵ�. 
		
		System.out.println(100);
		System.out.println(100+100);
		System.out.println(100-100);
		
		System.out.println("**************");
		
		System.out.printf("%5d %5d %10d \n", 100,100,200);	// �빮�ںҰ� , Conversion = 'D'
		System.out.printf("%5o %5o %10o \n", 100,100,200);	//8����, �빮�ںҰ�
		System.out.printf("%5x %5x %10x \n", 100,100,200); //16���� ���, �빮�ںҰ�
		
		System.out.println("**************");
	}
	
	public static void Prn_int2() {
		// ������ ����
		// ��������, ������ : �����ڿ��� �ʱ�ȭ�� �ڵ����� �����Ѵ�. 
		
		int a = 100;
		int b = 200;
		System.out.println(a);
		System.out.println(a+a);
		System.out.println(a-a);
		
		System.out.println("**************");
		
		System.out.printf("%5d %5d \t %10d \n", a,a,b);	// �빮�ںҰ� , Conversion = 'D'
		System.out.printf("%5o %5o \t %10o \n", a,a,b);	//8����, �빮�ںҰ�
		System.out.printf("%5x %5x \t %10x \n", a,a,b); //16���� ���, �빮�ںҰ�
		
		
		//public static String format(String format, Object... args)
				// static �ż��� //  ����Ÿ��  �ż���
		String res = String.format(" ", "%5x %5x \t %10x \n", a,a,b );
		System.out.println(res);
		
		System.out.println("**************");
		
	}
	public static void Prn_float() {
		System.out.println(98.7); //double -- ȿ���̴����� 8byte : �Ҽ��� �Ʒ� 18 �ڸ������� ǥ��
		System.out.println(98.7f); //float 4byte : �Ҽ��� �Ʒ� 9 �ڸ������� ǥ��
		System.out.println("**************");
		String str = String.format("%10.2f %10.2f\n", 98.7, 98.7f);
		String str2 = String.format("%10.2f %-10.2f\n", 98.7, 98.7f); // -�� ��������
		System.out.println(str);
		System.out.println(str2);
		System.out.println("**************");
	}
	
	public static void Prn_char() {
		//�ѱ��� �ִ� Ÿ�� 
		System.out.println('A');
		System.out.printf("%5c\n", 'A');
		System.out.println("**************");
		//������Ÿ�� ���� = ��;
		char ch = 'A';
		System.out.println("ch = " + ch + "code = " + (int)ch);
		System.out.printf("%5d\n", (int)ch); // (int)����ȯ
		System.out.println("**************");
		
	}
	
	public static void Prn_String() {
		// 'A' - chr
		// "A" - string
		System.out.println("'�츮'���� \'��\'�ѹα�");
		System.out.println("**************");
		String str = "�츮���� ���ѹα�";
		System.out.println(str);
	}


	public static void main(String[] args) {
		//int a;//������ ������ �� '��������'�� �ݵ�� �ʱⰪ�� �����ؾ��Ѵ�.: ������ ȣ���ϸ� ���� �����Ѵ�.
		//a = 100;
		//System.out.println(a); // ȣ��� �����߻� 

		Prn_int();
		Prn_int2();
		Prn_float();
		Prn_char();
		Prn_String();
	}

}
