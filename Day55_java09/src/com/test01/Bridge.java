package com.test01;

public class Bridge {
 
	// int�� ���� -2147483648 ~ 2147483648 �� ���� ������ 2147483648 �� �Ǹ� �����÷ο찡 �Ǹ鼭 -2147483648 �̵ȴ�.
	private int count;
	private String name;
	private String address;
	
	
	public synchronized void across(String name, String address) {
		//��ü �ʵ带 ��� �� �� ���� �� ���� - synchronized ���
		this.count++;
		this.name = name;
		this.address = address;
		check();
		
	}

	@Override
	public synchronized String toString() {
		// ��ü �ʵ� �� ȣ�� - synchronized ���
		return String.format("Bridge[����ȸ�� = %s, �̸�=%s, �����=%s]", count, name, address);
	}
	
	public void check() {
		if(name.charAt(0) != address.charAt(0)) {
			System.out.println("�����߻�" + toString());
		}
	}
}
