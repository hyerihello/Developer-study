package com.exam;

public class MyClass {
	//멤버를 클래스로 가지는 클래스
	private String name; // java lang class
	private Address m_address; // 사용자 class
	private Score m_score; // 사용자 class
	
	public MyClass() {
		this.name = null; //초기화, 안줘도 주고있다.
		this.m_address = null ;
		this.m_score = null;
	}
	
	public MyClass(String name, Address address, Score score) {
		this.name = name; //지역변수, 전역변수 구분해야되서 반드시 명시해야한다. 멤버변수 명과 지역변수 명이 동일할 때 구분하려면 반드시 this로 명시해준다.
		m_address = address;
		m_score = score;
	}

	 // // private -> getter&setter 주자
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getM_address() {
		return m_address;
	}

	public void setM_address(Address m_address) {
		this.m_address = m_address;
	}

	public Score getM_score() {
		return m_score;
	}

	public void setM_score(Score m_score) {
		this.m_score = m_score;
	}

	@Override
	public String toString() {
		//return String.format("MyClass [name=%s, m_address=%s, m_score=%s]", name, m_address, m_score);
																			//변수명을 호출할때 .toString이 쫒아온다.
		return String.format("MyClass [name=%s, m_address=%s, m_score=%s]", name, this.getM_address(), m_score);
																			// 메소드로 호출한다.
	}
	
	
}
