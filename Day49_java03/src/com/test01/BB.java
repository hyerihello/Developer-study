package com.test01;

// a+b - d
public class BB extends AA{
	
	private int d;
	public BB() {
		System.out.println("BB");
	}
	public int getD() {
		return d;
	}
	public void setD(int d) {
		this.d = d;
	}
	
	public int getResult() {
		return getHap() - getD();
		//return (getA() + getB()) - getD();
		//return getHap() - d;
		//return getA() + getB() - this.d;
		//return this.getA() + this.getB() - this.d;
		//return super.getA() + super.getB() - this.d;
		//return super.getA() + super.getB() - this.getD();
		
		// 안되는것
		//return (a+b) - d
	}
}
