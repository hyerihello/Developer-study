package com.test;
import java.util.Scanner;
import java.util.regex.MatchResult;
//import java.util.*; util package 전체 다 사용할 수 있음 (*, 10개이상일경우)
//import라는건, package, import만 올라올 수 있음.


public class Test01 {

	// 자바에서 표준 입출력을 구현하는 클래스
	/* 표준 입력을 할 때 3가지
	 * 
	 * 1. java.io의 클래스를 사용하는 방법 - 상속끝나고 파일처리할때
	 *    java.io.Class BufferedInputStream
	 *    
	 * 2. main() 매개인자로 입력받는 방법 - 전체
	 *    main(String[] args)
	 *    
	 * 3. Scanner 로 입력받는 방법 - 맨 처음 입력받을때
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
		
		Scanner sc = new Scanner(System.in); //System.in = InputStream 의 객체를 in 으로 필드화후
											 // 멤버로 가짐 , 표준 입력장치 
		System.out.println("input jumsu : ");
		
	    int i = sc.nextInt();
	    String res = Prn2(i);
	    System.out.println("res = " + res);
	    /*
	    System.out.println( "i = " + i); //input 과 같은?? console창에 입력하면 출력함

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
