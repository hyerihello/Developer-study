package com.test;
import java.io.*;
// 2. byte ������ ���� ������� ����.

public class Test03 {

	public static void MyWrite(File f) throws IOException{
		FileOutputStream fos = new FileOutputStream(f);
		for(int i = 65; i < 91; i++) {
			fos.write(i);
			
		}
		
		String msg = "������ �������̴�";
		fos.write(msg.getBytes());
		fos.close();
	}
	
	
	public static void MyRead(File f) throws IOException {
		FileInputStream fis = new FileInputStream(f);
		int ch =0;
		while ((ch = fis.read()) != -1) {
			System.out.printf("%c", (char)ch);
		}
				
	}
	
	public static void main(String[] args) {
		File fi = new File("test03.txt");
		try {
			//MyWrite(fi);
			MyRead(fi);
			
		}catch(IOException ie) {
			System.out.println(ie);
		}catch(Exception e) {
			
		}
	}
}
