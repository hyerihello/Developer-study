package com.test04;

public class MyEceptionTest {

public static void main(String[] args) {
	int a = 10;
	try {
	if(a>0) {
		throw new MyException("0보다 크잖아");
	}
	} catch(MyException m) { // MyException m = new MyException("0보다 크잖아");
		System.out.println(m.getMessage());
	} catch(Exception e) { // 위에 실패하면 선조 Exception 이 잡아라
		System.out.println(e.getMessage());
	} finally {
		System.out.println("예외가 나던지 말던지 반드시 처리해줘 파일클로즈, 디비클로즈, 복원파일등 하자");
	}
	}

}
