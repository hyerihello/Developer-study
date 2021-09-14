package com.test;
import java.io.*;
// 1. ���� ������ ���� ������� ����.

public class Test05 {

	public static void MyWrite(File f) throws IOException{
//		File res = f;
//		FileOutputStream fos = new FileOutputStream(res);
//		BufferedOutputStream bos = new BufferedOutputStream(fos);
		
		// �Ʒ� �ΰ��� �����ž�
		// BufferedOutputStream(OutputStream out)
		// OutputStream out = new FileOutputStream(f);
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(f));
	
		bos.write("abcdefghijk".getBytes());
		bos.close(); //�ڵ����� ���� fos
		
		//fos.close();
	}
	public static void MyRead(File f) throws IOException {
		

		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(f));
		int res = 0;
		
		while ((res = bis.read()) != -1) {
			System.out.printf("%c", res);
		}
		

		bis.close(); 

		
	}
	
	public static void main(String[] args) {
		File fi = new File("test05.txt");
		try {
			//MyWrite(fi);
			MyRead(fi);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
