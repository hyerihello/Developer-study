package com.sds.tes02;

public class Rectangle extends Shape implements Resize {

	public Rectangle() {
		// TODO Auto-generated constructor stub
	}

	public Rectangle(int length, int width, String colors) {
		super(length, width, colors);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setResize(int size) {
		// TODO Auto-generated method stub
		setWidth(this.getWidth() + size);
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return (this.getLength()*this.getWidth());
	}

}
