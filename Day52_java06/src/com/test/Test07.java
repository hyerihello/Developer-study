package com.test;
import java.io.*;
// 1. ���� ������ ���� ������� ����.
public class Test07 {

	public static void MyWrite(File f) throws IOException{
		FileWriter fw = new FileWriter(f, true); // true �� append�Ѵ�.
		fw.write("abcdefg\n");
		fw.append("111111\n");
		fw.append("abcdefggggg\n");
		
		String str = String.format("%5d %5d %5d \n", 10, 20, 30);
		fw.append(str);
		
		char[] res = str.toCharArray();
		fw.write(res);
		
		char [] res02 = "abcdef ������ ������".toCharArray();
		fw.write(res02);
		
		fw.close();
		
	}
	
	
	public static void MyRead(File f) throws IOException { 
		FileReader fr = new FileReader(f);
		int ch = 0;
		
		//������ ���� -1�� �ɶ����� ���ڸ� �ϳ��� �о ch�� ���Ϲ޾� �������.
		while ((ch = fr.read()) != -1) {
			System.out.printf("%c", (char)ch);
		}
		fr.close();
	}
	
	
	public static void main(String[] args) {
		String filename = "test02.txt";
		File f = new File(filename);
		try {
			MyRead(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
