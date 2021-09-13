package com.test04;

public class Mtest03 {
	
	public static void main(String[] args) {
		for(int i =0; i < 20; i++) {
			try {
				Thread.sleep(100); 
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			} //"Thread.sleep(1000); "전체 시스템 죽였다 살렸다. -> Try /catch 주자 반드시강제로 줘야하는아이
			System.out.printf("%3c", '♥');
		}
	}
}
