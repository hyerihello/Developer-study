package com.test;
import java.io.*;
import java.security.DomainCombiner;
public class Test01 {
	
	// ������ ����� ����.
	public static void disp() {
		
		File f = new File("c:\\Utest");
		File fi = new File(f, "B.txt");
		//System.out.println(fi);
		try { // ������ ���λ�������.
			fi.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(f.getAbsolutePath()); //���� (full path)
		System.out.println(f.getName());
		System.out.println(f.getFreeSpace());
		System.out.println(f.getParent());
		System.out.println(f.getPath()); //��� 
		System.out.println(f.getParentFile());
		System.out.println(f.lastModified()); // ������ Ž���ð� 
	}
	
	//
	public static void disp02() {
		/* 1. Utest ���丮�� �ִ� a.txt�� c:\test�� �̵�
		 * 2. Utest \a.txt ����
		 */
		
		File fi = new File("c:\\Utest\\11_11.txt");
		try {
			fi.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		fi.renameTo(new File("c:\\Test\\11_11.txt"));
	}
	
	public static void disp03() {
		String path = "C:\\Windows\\System32";
		File file = new File(path);
		//������ ���丮�� ������ ������ ���丮 ������ ����غ���.
		File [] file_list = file.listFiles();
		
		int file_cnt = 0;
		int dir_cnt = 0;
		
		//�迭�� ��ü�� �ϳ��� Ǯ� File�� ���Ϲ޾� isXX �޼ҵ带 ���� ���ϰ� ���丮�� �Ǻ��Ѵ�.
		for (File r : file_list) {
			if(r.isDirectory()) {
				dir_cnt++;
				
				System.out.println("dir :" + r.getName());
			}
			if(r.isFile()) {
				file_cnt++;
				System.out.println("file : " + r.getName());
			}
		}
		System.out.println("��ü ���� :" + file_list.length);
		System.out.println("���丮 ���� :" + dir_cnt);
		System.out.println("������ ���� :" + file_cnt);
	}
	
public static void main(String[] args) {
	disp03();
}
}
