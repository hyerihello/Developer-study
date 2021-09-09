package com.test1;

public class Test05 {
	
	public static void main (String[] args){
		
		int bitmask = 0x000F;
        int val = 0x2222;
        // prints "2"
        System.out.println(val & bitmask);
        
        System.out.println("******************");
        
        int result = 1 + 2; // result is now 3
        System.out.println(result);

        result = result - 1; // result is now 2
        System.out.println(result);

        result = result * 2; // result is now 4
        System.out.println(result);

        result = result / 2; // result is now 2
        System.out.println(result);

        result = result + 8; // result is now 10
        result = result % 7; // result is now 3
        System.out.println(result);
        
        System.out.println("******************");
        
        
       
        int i = 3;
        i++;
        System.out.println(i);    // "4"
        ++i;                     
        System.out.println(i);    // "5"
        System.out.println(++i);  // "6"
        System.out.println(i++);  // "6"
        System.out.println(i);    // "7"
        
        System.out.println("******************");
        
        
        // ★★★ boolean 구문 ★★★
        
        boolean condition = true;
        if (condition) { // begin block 1
             System.out.println("Condition is true.");
        } // end block one
        else { // begin block 2
             System.out.println("Condition is false.");
        } // end block 2
        
        System.out.println("******************");
        
        // ★★★ if 구문 ★★★
        
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
   
        System.out.println("******************");
        
        
     // ★★★ switch memo 구문 ★★★
		int month = 8;
	    String monthString;
	    switch (month) {
	        case 1:  monthString = "January";
	                 break;
	        case 2:  monthString = "February";
	                 break;
	        case 3:  monthString = "March";
	                 break;
	        case 4:  monthString = "April";
	                 break;
	        case 5:  monthString = "May";
	                 break;
	        case 6:  monthString = "June";
	                 break;
	        case 7:  monthString = "July";
	                 break;
	        case 8:  monthString = "August";
	                 break;
	        case 9:  monthString = "September";
	                 break;
	        case 10: monthString = "October";
	                 break;
	        case 11: monthString = "November";
	                 break;
	        case 12: monthString = "December";
	                 break;
	        default: monthString = "Invalid month";
	                 break;
	    }
	    System.out.println(monthString);
		}

    
}
