package com.test;
import java.io.*;

// ����Ŭ������ ���� �����ڿ� �޼ҵ带 ���캸��. 
public class Test {
	
	// File(String pathname)
	public static void prn() {
		File f = new File("c:\\UTest");
		f.mkdir(); // File ��ΰ��� Ȯ���غ���.
		if(f.exists()) {
			System.out.println("�̹� ����� ����");
		} else {
			f.mkdir();
			System.out.println("���� �������.");
		}
	}
	
	// File(String parent, String child)
	public static void prn02() {
		File f = new File("c:\\Utest", "mytest");
		f.mkdir(); // File ��ΰ��� Ȯ���غ���.
	}
	

	
	// File(File parent, String child)
	public static void prn03() {
		File parent = new File("c:\\Utest");
		File f = new File(parent, "mytest02");
		f.mkdir(); // File ��ΰ��� Ȯ���غ���.
	}
	
	
	public static void main(String[] args) {
		prn03();
		System.out.println(File.pathSeparator);
		System.out.println(File.pathSeparatorChar);
		System.out.println(File.separator);
		System.out.println(File.separatorChar);
		
		String path = "c:" + File.separatorChar + "test" + File.separator + "ytest"; //�ü�� ���� ���丮 
		System.out.println(path);
		File fi = new File(path);
		fi.mkdir();
		
	}
	}



