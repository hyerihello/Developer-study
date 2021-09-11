package com.test04;

public abstract class MyABS extends Number {
// abstract 는 new 연산자를 사용할 수 없다. 괄호 안의 매개인자로는 받을 수 있다.
	
	public abstract int intValue(int a);

	
	public static void main(String[] args) {
		//new MyABS();
	}

	@Override
	public int intValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long longValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float floatValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double doubleValue() {
		// TODO Auto-generated method stub
		return 0;
	}

}
