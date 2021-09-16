package com.test;

// 2. Thread를 상속받아 start()로 실행

public class Test03 extends Thread{

	
	public Test03(String name) {
		super(name);
	}

	@Override
	
	public void run() {
		for (int i = 0; i <=10; i++) {
			System.out.println(Thread.currentThread().getName()+ ":" + i);
		}
	
	}
	
	public static void main(String[] args) {
		Test03 t1 = new Test03("야옹이"); //Thread(String name)
		Test03 t2 = new Test03("멍멍이");
		try { // join도 해보자.
			t1.join();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		t1.start();
		t2.start();
		
	}


}
