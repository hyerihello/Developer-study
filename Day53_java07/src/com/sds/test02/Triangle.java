package com.sds.test02;

public class Triangle extends Shape implements Resize {

	public Triangle() {
		// TODO Auto-generated constructor stub
	}

	public Triangle(int length, int width, String colors) {
		super(length, width, colors);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public void setResize(int size) {
		// TODO Auto-generated method stub
		setLength(this.getLength() + size) ; // set 값 전달및 변경  get값 리턴

	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return (this.getLength()*this.getWidth())/2.0; 
	}

}
