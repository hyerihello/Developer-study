package com.test04;

public class Mtest02 {

	public static void Prn() throws Exception  {
		throw new Exception("���ܾ�");
		
	}
	public static void Prn02() throws Exception {
		Prn();
	}
	public static void Prn03() throws Exception {
		Prn02();
	}
	
	public static void main(String[] args) {
		try {
			Prn03();
		} catch (Exception e) {
			System.out.println(e);
			System.out.println(e.getMessage());
		} 
		//main�� try/cachó���ؾ��Ѵ�.
	}
}
