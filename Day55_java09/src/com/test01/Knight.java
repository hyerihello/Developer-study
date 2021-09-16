package com.test01;

// 멤버변수로 기사가 통과하는 다리를 나타내는 bridge와 자신의 이름을 가지고 있는 name변수
// 한번 지정하면 수정 못하게 final로 선언하자.
// run() 시작하는 문자열을 출력하고 루프를 통해서 다리를 건너게 하자.

public class Knight extends Thread{
	private final Bridge bridge; // Bridge를 bridge로 선언하고
	private final String name;
	private final String address;
	
	public Knight (Bridge bridge, String name, String address) {
		this.bridge = bridge;
		this.name = name;
		this.address = address;
	}

	@Override
	public void run() {
		
		System.out.println(name + " 기사가 도전한다. ");
		while(true) {
			bridge.across(name,address);
		}
	}
	
	
}
