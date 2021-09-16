package com.test01;

public class Bridge {
 
	// int의 범위 -2147483648 ~ 2147483648 의 범위 숫자중 2147483648 이 되면 오버플로우가 되면서 -2147483648 이된다.
	private int count;
	private String name;
	private String address;
	
	
	public synchronized void across(String name, String address) {
		//객체 필드를 사용 즉 값 전달 및 변경 - synchronized 사용
		this.count++;
		this.name = name;
		this.address = address;
		check();
		
	}

	@Override
	public synchronized String toString() {
		// 객체 필드 값 호출 - synchronized 사용
		return String.format("Bridge[도전회수 = %s, 이름=%s, 출신지=%s]", count, name, address);
	}
	
	public void check() {
		if(name.charAt(0) != address.charAt(0)) {
			System.out.println("문제발생" + toString());
		}
	}
}
