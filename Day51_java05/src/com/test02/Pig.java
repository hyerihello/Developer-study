package com.test02;

public class Pig implements base{
// ������ �ּҹ����� ���ؼ� �����ǰ� ���� ���� �ļ��� �޼ҵ带 ������ ��� Ȯ�� 
	
	private int a; // �������, private�� �ְԵǸ� get/set �������Ѵ�. 
	// (�����޴� ��ü�� private�� �Ǿ��־� ������ �ʱ� ������ get,set ���� ���� ���� �� ���� �ؾ��Ѵ�)
	
	
	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}
	
	@Override
	public void Start() {
		System.out.println("pig's Start()");
	}
	
	@Override
	public void Stop() {
		System.out.println("pig 'Stop()");	
	}
	
	
}
