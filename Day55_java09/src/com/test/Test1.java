package com.test;

import java.io.IOException;
// Class Runtime�� exec(String command) �޼ҵ� Ȯ��

// cmd âó�� Ȱ���� �޸����� ������Ѻ���.
// cmd â�� notepad���� �޸������� , ������ �����


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
		

