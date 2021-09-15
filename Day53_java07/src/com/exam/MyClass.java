package com.exam;

public class MyClass {
	//����� Ŭ������ ������ Ŭ����
	private String name; // java lang class
	private Address m_address; // ����� class
	private Score m_score; // ����� class
	
	public MyClass() {
		this.name = null; //�ʱ�ȭ, ���൵ �ְ��ִ�.
		this.m_address = null ;
		this.m_score = null;
	}
	
	public MyClass(String name, Address address, Score score) {
		this.name = name; //��������, �������� �����ؾߵǼ� �ݵ�� ����ؾ��Ѵ�. ������� ��� �������� ���� ������ �� �����Ϸ��� �ݵ�� this�� ������ش�.
		m_address = address;
		m_score = score;
	}

	 // // private -> getter&setter ����
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
																			//�������� ȣ���Ҷ� .toString�� �i�ƿ´�.
		return String.format("MyClass [name=%s, m_address=%s, m_score=%s]", name, this.getM_address(), m_score);
																			// �޼ҵ�� ȣ���Ѵ�.
	}
	
	
}
