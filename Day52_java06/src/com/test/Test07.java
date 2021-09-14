package com.test;
import java.io.*;
// 1. 문자 단위로 파일 입출력을 하자.
public class Test07 {

	public static void MyWrite(File f) throws IOException{
		FileWriter fw = new FileWriter(f, true); // true 는 append한다.
		fw.write("abcdefg\n");
		fw.append("111111\n");
		fw.append("abcdefggggg\n");
		
		String str = String.format("%5d %5d %5d \n", 10, 20, 30);
		fw.append(str);
		
		char[] res = str.toCharArray();
		fw.write(res);
		
		char [] res02 = "abcdef 오늘은 수요일".toCharArray();
		fw.write(res02);
		
		fw.close();
		
	}
	
	
	public static void MyRead(File f) throws IOException { 
		FileReader fr = new FileReader(f);
		int ch = 0;
		
		//파일의 끝이 -1이 될때까지 글자를 하나씩 읽어서 ch로 리턴받아 출력하자.
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
