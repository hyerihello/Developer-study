package com.test;
import java.io.*;
// 3. �̹��� ������ �����������.
public class Test04 {

	public static void MyWrite(File f){
	
	}
	public static void MyRead(File f) {
		
	}
	public static void prn01() {
		
			//1. �̹��� ������ ��ü�� �����Ѵ�.
			File fi = new File("apple01.jpg");
			File output = new File("apple_res.jpg");
			
			//2. �̹��� ������ ��Ʈ������ �о���δ�.
			FileInputStream fis = null;
			FileOutputStream fos = null;
			
			int ch =0;
			try {
				fis = new FileInputStream(fi); //�а�
				fos = new FileOutputStream(output);//����
				while((ch = fis.read()) != -1) {
					fos.write(ch); //3. �о���� �����͸� apple_res.jpg�� �����Ѵ�.
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
		
			//1. �̹��� ������ ��ü�� �����Ѵ�.
			File fi = new File("apple01.jpg");
			File output = new File("apple_res2.jpg");
			
			//2. �̹��� ������ ��Ʈ������ �о���δ�.

			
			int ch =0;
			try (FileInputStream fis =  new FileInputStream(fi);
				FileOutputStream fos = new FileOutputStream(output)){
				
				while((ch = fis.read()) != -1) {
					fos.write(ch); //3. �о���� �����͸� apple_res.jpg�� �����Ѵ�.
				}
			} catch(Exception ie) {
				System.out.println(ie.getMessage());

			}
		}
	
	
	public static void main(String[] args) {
		//prn01();
		prn02();
}}
