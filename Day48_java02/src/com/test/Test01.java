package com.test;
import java.util.Scanner;
import java.util.regex.MatchResult;
//import java.util.*; util package ��ü �� ����� �� ���� (*, 10���̻��ϰ��)
//import��°�, package, import�� �ö�� �� ����.


public class Test01 {

	// �ڹٿ��� ǥ�� ������� �����ϴ� Ŭ����
	/* ǥ�� �Է��� �� �� 3����
	 * 
	 * 1. java.io�� Ŭ������ ����ϴ� ��� - ��ӳ����� ����ó���Ҷ�
	 *    java.io.Class BufferedInputStream
	 *    
	 * 2. main() �Ű����ڷ� �Է¹޴� ��� - ��ü
	 *    main(String[] args)
	 *    
	 * 3. Scanner �� �Է¹޴� ��� - �� ó�� �Է¹�����
	 *    java.util.Class Scanner
	 * 
	 * */
	
	
	private static void Prn() {
		 int testscore = 76;
	        char grade;

	        if (testscore >= 90) {
	            grade = 'A';
	        } else if (testscore >= 80) {
	            grade = 'B';
	        } else if (testscore >= 70) {
	            grade = 'C';
	        } else if (testscore >= 60) {
	            grade = 'D';
	        } else {
	            grade = 'F';
	        }
	        System.out.println("Grade = " + grade);
	}
	
	
	private static String Prn2(int jumsu) {
		 int testscore = jumsu;
	        char grade;

	        if (testscore >= 90) {
	            grade = 'A';
	        } else if (testscore >= 80) {
	            grade = 'B';
	        } else if (testscore >= 70) {
	            grade = 'C';
	        } else if (testscore >= 60) {
	            grade = 'D';
	        } else {
	            grade = 'F';
	        }
	        return ("Grade = " + grade);
	}
	
	
	public static void main(String[] args) {
		//Prn();
		
		Scanner sc = new Scanner(System.in); //System.in = InputStream �� ��ü�� in ���� �ʵ�ȭ��
											 // ����� ���� , ǥ�� �Է���ġ 
		System.out.println("input jumsu : ");
		
	    int i = sc.nextInt();
	    String res = Prn2(i);
	    System.out.println("res = " + res);
	    /*
	    System.out.println( "i = " + i); //input �� ����?? consoleâ�� �Է��ϸ� �����

	    String str = sc.next();
	    System.out.println( "str = " + str);
	    */
	    /*
	    String input = "1 fish 2 fish red fish blue fish";
	     Scanner s = new Scanner(input);
	     s.findInLine("(\\d+) fish (\\d+) fish (\\w+) fish (\\w+)");
	     MatchResult result = s.match();
	     for (int j=1; j<=result.groupCount(); j++)
	         System.out.println(result.group(j));
	     s.close();
	     */
	}

}
