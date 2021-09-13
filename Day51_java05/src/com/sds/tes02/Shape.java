package com.sds.tes02;

public abstract class Shape {

	private int length;
	private int width;
	private String colors;
	
	
	public Shape() {
		super(); // 기본생성자
		// TODO Auto-generated constructor stub
	}





	public Shape(int length, int width, String colors) { //오버르드생성자
		super();
		this.length = length;
		this.width = width;
		this.colors = colors;
	}
	


	public int getLength() {
		return length;
	}


	public void setLength(int length) {
		this.length = length;
	}


	public int getWidth() {
		return width;
	}


	public void setWidth(int width) {
		this.width = width;
	}





	public String getColors() {
		return colors;
	}





	public void setColors(String colors) {
		this.colors = colors;
	}
	
	
	public abstract double getArea(); //  추상메서드는 바디가 절대 없다
	
}
