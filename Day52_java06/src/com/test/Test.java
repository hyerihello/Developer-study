package com.test;
import java.io.*;

// 파일클래스가 가진 생성자와 메소드를 살펴보자. 
public class Test {
	
	// File(String pathname)
	public static void prn() {
		File f = new File("c:\\UTest");
		f.mkdir(); // File 경로가서 확인해보자.
		if(f.exists()) {
			System.out.println("이미 만들어 졌어");
		} else {
			f.mkdir();
			System.out.println("지금 만들었다.");
		}
	}
	
	// File(String parent, String child)
	public static void prn02() {
		File f = new File("c:\\Utest", "mytest");
		f.mkdir(); // File 경로가서 확인해보자.
	}
	

	
	// File(File parent, String child)
	public static void prn03() {
		File parent = new File("c:\\Utest");
		File f = new File(parent, "mytest02");
		f.mkdir(); // File 경로가서 확인해보자.
	}
	
	
	public static void main(String[] args) {
		prn03();
		System.out.println(File.pathSeparator);
		System.out.println(File.pathSeparatorChar);
		System.out.println(File.separator);
		System.out.println(File.separatorChar);
		
		String path = "c:" + File.separatorChar + "test" + File.separator + "ytest"; //운영체제 별로 디렉토리 
		System.out.println(path);
		File fi = new File(path);
		fi.mkdir();
		
	}
	}



