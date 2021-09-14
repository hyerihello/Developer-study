package com.test;
import java.io.*;
import java.security.DomainCombiner;
public class Test01 {
	
	// 파일을 만들어 보자.
	public static void disp() {
		
		File f = new File("c:\\Utest");
		File fi = new File(f, "B.txt");
		//System.out.println(fi);
		try { // 없으면 새로생성하자.
			fi.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(f.getAbsolutePath()); //절대 (full path)
		System.out.println(f.getName());
		System.out.println(f.getFreeSpace());
		System.out.println(f.getParent());
		System.out.println(f.getPath()); //상대 
		System.out.println(f.getParentFile());
		System.out.println(f.lastModified()); // 마지막 탐색시간 
	}
	
	//
	public static void disp02() {
		/* 1. Utest 디렉토리에 있는 a.txt를 c:\test로 이동
		 * 2. Utest \a.txt 삭제
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
		//지정된 디렉토리의 파일의 개수와 디렉토리 개수를 출력해보자.
		File [] file_list = file.listFiles();
		
		int file_cnt = 0;
		int dir_cnt = 0;
		
		//배열의 객체를 하나씩 풀어서 File로 리턴받아 isXX 메소드를 통해 파일과 디렉토리를 판별한다.
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
		System.out.println("전체 개수 :" + file_list.length);
		System.out.println("디렉토리 개수 :" + dir_cnt);
		System.out.println("파일의 개수 :" + file_cnt);
	}
	
public static void main(String[] args) {
	disp03();
}
}
