package com.test;

// main thread�� ����Ǵ� ���� �� �� �ִ�.
// Process�� ��Ƽ�� ���α׷��̶�� �� �� �ִ�. 
// �ϳ��� ���μ����� �ڽŸ��� ���� ������ �ڿ��� �Ҵ���� ���¿��� ���������� ���� ó���ϴ� ������ ������.
// Thread�� ���μ��� ���ο� �����ϸ� ������ �ڿ��� �����ϸ鼭 ���� ó���Ѵ�.
// ex) Process�� �ڽ��� ���� ���縦 �ٹ̰� ���������� ����� �����̰� ���� �������� Thread��� �����ϸ�ȴ�.

public class Test02 {

	public static void main(String[] args) {
		System.out.println(" �̱� Thread ��");
		for (int i = 0; i <= 100; i++) {
			System.out.println(Thread.currentThread().getName()+ ":" + i);
		}
	}
}
