package com.test;


public class Test01 implements Runnable{

	@Override
	
	public void run() {
		for (int i = 0; i <=10; i++) {
			System.out.println(Thread.currentThread().getName()+ ":" + i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
	
	}
	public static void main(String[] args) {
		new Test01().run(); // ���� Thread�� �ƴ�
		
		//Tread(Runnable target)
		Thread t1 = new Thread(new Test01(),"�߿���");		//Test01Ŭ������ �޼ҵ� ������ exe�Ǵ� Thread�� ����
		t1.setPriority(Thread.MAX_PRIORITY); // 10
		t1.start(); //run()ȣ��
		
		Thread t2 = new Thread(new Test01(),"�۸���");
		//t2.start(); // main Thread�� t1, t2 thread�� ���� �ߴ�. ��� ����
					
		t1.setPriority(Thread.MIN_PRIORITY); // 1
		t2.start(); // run() ȣ��
		
		
		System.out.println(Thread.currentThread().getName() + ">>>>>>>>>>>>>>>>"); // �� 3���� �����鰡 �����ֱ���, main, t1, t2
		System.out.println("�������� �켱 ������ Ȯ�� ����. ");
		
		System.out.println(t1.getPriority());
		System.out.println(t2.getPriority());
		
		System.out.println("thread�� ����  :" + t1.getState());
		
		
	}
}

 // Thread�� ���� ���� [alive / dead] 
 // alive ���´� �����尡 cpu�� �����ϰ� �ڵ带 �����ϴ� �ܰ踦 ���Ѵ�.
 // Runnable pool : ���� ���·� ���� ���ؼ� ��������� �� �ִ� ��
