package com.test;

public abstract class Test03 {

	private int a;
	protected int a1;
	public int a2;
			int a3; //default
	
			
	public void Prn() {}
	public static void Prn02(){}; // �����޼ҵ�
	
	public abstract void Prn03(); // �߻�޼ҵ� 
	// �� �����Ҽ��ְ�, �߻�޼ҵ带 �������ִ� class�� �߻�Ŭ������ �Ǿ��ϱ� ������ class�� �����ؾ��Ѵ�.
	
	public int Prn04() {
		return 0;
		
	}
	public double Prn05(int a, int b) {
		return 0;
		
	}
	public String Prn06() {
		return null;
		
	}
}

// object aid �� �̿��� Ŭ���� ���̾�׷����� ��������. 
//3ĭ���γ��� : �̸�, �ʵ�, �޼ҵ� 
// ���Ÿ�üclass - �߻�Ŭ�������� 
// c : �޼ҵ� 
// ������� : ����ƽ
// a : abstract 
// : �ڿ��� ���ϸ޼ҵ� 