package com.test;
import com.mytest.*; // 패키지이름으로 넣어준다

public class MyTest {

	public static void main(String[] args) {
		Calc c1 = new Calc(1,5);
		System.out.println(c1);
	}
}
// 전역패스, 빌드패스 설정하는것
// jar파일을 export해서 생성한 후 아래와 같이 한다.
// 전역패스 : C:\Program Files\Java\jdk1.8.0_291\jre\lib\ext
// 빌드패스 : 프로젝트 -> 빌드패스 -> 컨피규 -> user, addExternal jars