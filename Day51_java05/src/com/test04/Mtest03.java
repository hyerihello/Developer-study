package com.test04;

public class Mtest03 {
	
	public static void main(String[] args) {
		for(int i =0; i < 20; i++) {
			try {
				Thread.sleep(100); 
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			} //"Thread.sleep(1000); "��ü �ý��� �׿��� ��ȴ�. -> Try /catch ���� �ݵ�ð����� ����ϴ¾���
			System.out.printf("%3c", '��');
		}
	}
}
