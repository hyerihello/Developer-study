package com.test;

public class Test03 {
	
	public static void Prn_int() {
		// ������ ����
		// ��������, ������ : �����ڿ��� �ʱ�ȭ�� �ڵ����� �����Ѵ�. 
		
		System.out.println(100);
		System.out.println(100+100);
		System.out.println(100-100);
		
		System.out.println();
		
		System.out.printf("%5d %5d %10d \n", 100,100,200);	// �빮�ںҰ� , Conversion = 'D'
		System.out.printf("%5o %5o %10o \n", 100,100,200);	//8����, �빮�ںҰ�
		System.out.printf("%5x %5x %10x \n", 100,100,200); //16���� ���, �빮�ںҰ�
		
	}
	
	public static void Prn_int2() {
		// ������ ����
		// ��������, ������ : �����ڿ��� �ʱ�ȭ�� �ڵ����� �����Ѵ�. 
		
		Integer a = 100;
		Integer b = 200;
		System.out.println(a.longValue());
		
		System.out.println(a+a);
		System.out.println(a-a);
		
		System.out.println();
		
		System.out.printf("%5d %5d \t %10d \n", a,a,b);	// �빮�ںҰ� , Conversion = 'D'
		System.out.printf("%5o %5o \t %10o \n", a,a,b);	//8����, �빮�ںҰ�
		System.out.printf("%5x %5x \t %10x \n", a,a,b); //16���� ���, �빮�ںҰ�
		
		
		//public static String format(String format, Object... args)
				// static �ż��� //  ����Ÿ��  �ż���
		String res = String.format(" ", "%5x %5x \t %10x \n", a,a,b );
		System.out.println(res);
		
		
	}
	public static void Prn_float() {
		
		Double d = 98.7;
		Float f = 98.7f;
		
		
		System.out.println(d); //double -- ȿ���̴����� 8byte : �Ҽ��� �Ʒ� 18 �ڸ������� ǥ��
		System.out.println(f); //float 4byte : �Ҽ��� �Ʒ� 9 �ڸ������� ǥ��
		
		String str = String.format("%10.2f %-10.2f\n", 98.7, 98.7f); // -�� ��������
		System.out.println(str);
		
	}
	
	public static void Prn_char() {
		//�ѱ��� �ִ� Ÿ�� 
		System.out.println('A');
		System.out.printf("%5c\n", 'A');
		
		//������Ÿ�� ���� = ��;
		Character ch = 'A';
		System.out.println("ch = " + ch + "code = " + (int)ch);
		System.out.printf("%5d\n", (int)ch); // (int)����ȯ
	}
	
	public static void Prn_String() {
		// 'A' - chr
		// "A" - string
		System.out.println("'�츮'���� \'��\'�ѹα�");
		String str = "�츮���� ���ѹα�";
		System.out.println(str);
	}


	public static void main(String[] args) {
		//int a;//������ ������ �� '��������'�� �ݵ�� �ʱⰪ�� �����ؾ��Ѵ�.: ������ ȣ���ϸ� ���� �����Ѵ�.
		//a = 100;
		//System.out.println(a); // ȣ��� �����߻� 

		//Prn_int();
		Prn_int2();
		Prn_float();
		Prn_char();
		//Prn_String();
	}

}
