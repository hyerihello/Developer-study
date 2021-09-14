package com.test;
import java.io.*;
import java.util.*;

public class Test08 {

	public static void main(String[] args) {
		
		File f = new File("test07.txt");
		try (Scanner sc = new Scanner(f)){
			String s1 = sc.next();
			int a1 = sc.nextInt();
			double d1 = sc.nextDouble();
			System.out.println(s1);
			System.out.println(a1);
			System.out.println(d1);
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
	}

}
