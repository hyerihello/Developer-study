package com.test1;


public class Test02_3 {
	
	public static void Prn_int() {
		
		Integer a = 100;
		Integer b = 200;
		System.out.println(a.longValue());
		System.out.println("**************");
		
		//public static String format(String format, Object... args)
		// static �ż��� //  ����Ÿ��  �ż���
		String res = String.format(" ", "%5x %5x \t %10x \n", a,a,b );
		System.out.println(res);
		
		System.out.println("**************");
	}
	
	
	public static void Prn_float() {
		
		Double d = 98.7;
		Float f = 98.7f;
		
		
		System.out.println(d); //double -- ȿ���̴����� 8byte : �Ҽ��� �Ʒ� 18 �ڸ������� ǥ��
		System.out.println(f); //float 4byte : �Ҽ��� �Ʒ� 9 �ڸ������� ǥ��
		System.out.println("**************");
		
	}

	public static void Prn_char() {
		//������Ÿ�� ���� = ��;
		Character ch = 'A';
		System.out.println("ch = " + ch + "code = " + (int)ch);
		System.out.printf("%5d\n", (int)ch); // (int)����ȯ
		
	}
			
	

	
	public static void main(String[] args) {
		Prn_int();
		Prn_float();
		Prn_char();
	}
}
