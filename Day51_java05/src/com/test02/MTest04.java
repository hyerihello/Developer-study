package com.test02;

public class MTest04 {
	
	public void Prn(base b) { // base b = new Pig()
		b.Start();
		b.Stop();
		
	}
	public static void main(String[] args) {
		
		new MTest04().Prn(new Pig());
		
		new MTest04().Prn(new base() { // �߻�Ŭ����, �������̽��� new������ �Ұ�, ������ �ؾ��Ѵ�.
			@Override
			public void Start() {
				System.out.println("111111");
			
			}
			@Override
			public void Stop() {
				System.out.println("222222");
			}
		});
	}

		
	
}
