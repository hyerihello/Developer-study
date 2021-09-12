package com.test;

/*
 ���� 1) 
 The String class represents character strings.  �� ������ cnvr ()�޼ҵ�� �����ؼ�
 �빮���� ������ �ҹ����� ������ ����ϰ�
 �빮�ڸ� �ҹ��ڷ�, �ҹ��ڸ� �빮�ڷ� ��ȯ �� ���Ϲ޴´�.

 1. String ->  char[] �޼ҵ� ã�� 
 2. for -> character�� �޼ҵ带 �̿��ؼ� �ҹ�������, �빮������ �Ǻ��ϴ� �޼ҵ带 �̿��ؼ� ���ǹ��� ��� �� cnt �Ѵ�.
 3. character �� �빮�ڷ�, �ҹ��ڷ� �ٲ��ִ� �޼ҵ带 ã�Ƽ� ��ȯ

*/

public class Exam01 {
	// 			�� void�� ������ return �޾ƾ���
	public static String cnvr (String res) { // res = str�� �����Ѵ� 
		
		// �빮���� ������ �ҹ����� ������ ����ϱ� ���� ���ڿ�(string)�� �� ���� �迭(char)�� ��ȯ����.
		// == public char[] toCharArray() �޼��� ���
		
	    char[] ch_res = res.toCharArray(); //str�� ������ res�� ���� �迭�� ��ȯ!
	    int cnt_u = 0; // �빮�� ����
	    int cnt_l = 0; // �ҹ��� ����
	    
	    for (int i = 0; i < ch_res.length; i++) {// i�� 0�̰� �迭�� ��ȯ�� ch_res�� ���̺��� ������ i�� ���Ѵ�.
			// Character.isUpperCase() : �Է¹��� ���ڰ� �빮���� ���θ� �Ǵ��Ͽ� true,false ��ȯ
	    	if(Character.isUpperCase(ch_res[i])){
	    		ch_res[i] = Character.toLowerCase(ch_res[i]); // �Է¹��� ���� ���� �ҹ��ڷ� ��ȯ �� ����
	    		cnt_u++; // �빮�� ������ ī������ �Ѵ�.
	    	}
	    	else if(Character.isLowerCase(ch_res[i])){
	    		ch_res[i] = Character.toUpperCase(ch_res[i]);
	    		cnt_l++;
	    	}
	    }
	    System.out.println("�빮���� ���� : " + cnt_u + "�ҹ����� ���� : " + cnt_l);
	    
		return new String(ch_res); // ���ο� ���ڿ�(String) ���
		
	}
	
	public static void main(String[] args) {
		String str = "The String class represents character strings. "; // orn ������ str
		String res = cnvr(str); // cnvr �޼ҵ� �����ϴ� ������ res
		System.out.println(res);

		
	}
}

