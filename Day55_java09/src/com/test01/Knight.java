package com.test01;

// ��������� ��簡 ����ϴ� �ٸ��� ��Ÿ���� bridge�� �ڽ��� �̸��� ������ �ִ� name����
// �ѹ� �����ϸ� ���� ���ϰ� final�� ��������.
// run() �����ϴ� ���ڿ��� ����ϰ� ������ ���ؼ� �ٸ��� �ǳʰ� ����.

public class Knight extends Thread{
	private final Bridge bridge; // Bridge�� bridge�� �����ϰ�
	private final String name;
	private final String address;
	
	public Knight (Bridge bridge, String name, String address) {
		this.bridge = bridge;
		this.name = name;
		this.address = address;
	}

	@Override
	public void run() {
		
		System.out.println(name + " ��簡 �����Ѵ�. ");
		while(true) {
			bridge.across(name,address);
		}
	}
	
	
}
