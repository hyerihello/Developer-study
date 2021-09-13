package com.test04;

public class Mytest {
 // runas 환경설정 vari~ prompt 창 해보기
	
	public static void main(String[] args) {
		System.out.println(args.length);
		for(String res : args) {
		System.out.println(args[0]);
//		System.out.println(args[1]);
		System.out.println(res);
		}
	}

}
