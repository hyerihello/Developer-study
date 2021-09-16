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
		new Test01().run(); // 아직 Thread가 아님
		
		//Tread(Runnable target)
		Thread t1 = new Thread(new Test01(),"야옹이");		//Test01클래스가 메소드 단위로 exe되는 Thread로 생성
		t1.setPriority(Thread.MAX_PRIORITY); // 10
		t1.start(); //run()호출
		
		Thread t2 = new Thread(new Test01(),"멍멍이");
		//t2.start(); // main Thread가 t1, t2 thread를 실행 했다. 라고 본다
					
		t1.setPriority(Thread.MIN_PRIORITY); // 1
		t2.start(); // run() 호출
		
		
		System.out.println(Thread.currentThread().getName() + ">>>>>>>>>>>>>>>>"); // 총 3개의 스레들가 돌고있구나, main, t1, t2
		System.out.println("스레드의 우선 순위를 확인 하자. ");
		
		System.out.println(t1.getPriority());
		System.out.println(t2.getPriority());
		
		System.out.println("thread의 상태  :" + t1.getState());
		
		
	}
}

 // Thread의 실행 상태 [alive / dead] 
 // alive 상태는 스레드가 cpu를 차지하고 코드를 수행하는 단계를 말한다.
 // Runnable pool : 실행 상태로 들어가기 위해서 스레드들이 모여 있는 곳
