package com.test;

import java.io.IOException;
// Class Runtime의 exec(String command) 메소드 확인

// cmd 창처럼 활용해 메모장을 실행시켜보자.
// cmd 창에 notepad쓰면 메모장실행됨 , 동일한 경우임


public class Test1 {
	
	public static void main(String[] args) {
		Runtime r = Runtime.getRuntime();
		Process pre;
		try {
			pre = r.exec("notepad.exe");
			System.out.println(pre.toString());
			System.out.println(pre.isAlive());
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
		

