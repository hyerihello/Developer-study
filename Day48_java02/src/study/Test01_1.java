package study;

import java.util.Scanner;
import java.util.regex.MatchResult;

public class Test01_1 {
	private static String Prn (int jumsu) {
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
        return("Grade = " + grade);		
	}

public static void main(String[] args) {
//	Scanner sc = new Scanner(System.in); //System.in = InputStream �� ��ü�� in ���� �ʵ�ȭ��
//	 // ����� ���� , ǥ�� �Է���ġ 
//	System.out.println("input jumsu : ");
//	
//	int i = sc.nextInt();
//	String res = Prn(i);
//	System.out.println("res = " + res);
	
//	Scanner sc = new Scanner(System.in);
//	int i = sc.nextInt();
//    System.out.println( "i = " + i); //input �� ����?? consoleâ�� �Է��ϸ� �����
//    String str = sc.next();
//    System.out.println( "str = " + str);
	
	String input = "1 fish 2 fish red fish blue fish";
    Scanner s = new Scanner(input);
    s.findInLine("(\\d+) fish (\\d+) fish (\\w+) fish (\\w+)");
    MatchResult result = s.match();
    for (int j=1; j<=result.groupCount(); j++)
        System.out.println(result.group(j));
    s.close();
}
}
