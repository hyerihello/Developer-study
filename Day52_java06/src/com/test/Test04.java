package com.test;
import java.io.*;
// 3. 이미지 파일을 입출력을하자.
public class Test04 {

	public static void MyWrite(File f){
	
	}
	public static void MyRead(File f) {
		
	}
	public static void prn01() {
		
			//1. 이미지 파일을 객체를 생성한다.
			File fi = new File("apple01.jpg");
			File output = new File("apple_res.jpg");
			
			//2. 이미지 파일을 스트림으로 읽어들인다.
			FileInputStream fis = null;
			FileOutputStream fos = null;
			
			int ch =0;
			try {
				fis = new FileInputStream(fi); //읽고
				fos = new FileOutputStream(output);//쓰고
				while((ch = fis.read()) != -1) {
					fos.write(ch); //3. 읽어들인 데이터를 apple_res.jpg로 저장한다.
				}
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch(IOException ie) {
				
			} finally {
				try {
					fos.close();
					fis.close();
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
	
	
	public static void prn02() {
		
			//1. 이미지 파일을 객체를 생성한다.
			File fi = new File("apple01.jpg");
			File output = new File("apple_res2.jpg");
			
			//2. 이미지 파일을 스트림으로 읽어들인다.

			
			int ch =0;
			try (FileInputStream fis =  new FileInputStream(fi);
				FileOutputStream fos = new FileOutputStream(output)){
				
				while((ch = fis.read()) != -1) {
					fos.write(ch); //3. 읽어들인 데이터를 apple_res.jpg로 저장한다.
				}
			} catch(Exception ie) {
				System.out.println(ie.getMessage());

			}
		}
	
	
	public static void main(String[] args) {
		//prn01();
		prn02();
}}
