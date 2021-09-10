package study;

public class Test03_3 {


	public static void for_test() {
		System.out.println("case 1: 1~10 占쏙옙占쏙옙占쏙옙占�");
		
		for (int i = 1; i<=10; i++) {
			System.out.printf("%5d", i);
		}
		
	}
	
	
	public static void for_test02() {
		System.out.println("case 2 : 10~1 占쏙옙占�");
		int i =0;
		for (i = 10; i>0; i--) {
			System.out.printf("%5d", i);
		}
		
	}
	
	public static void for_test03() {
		System.out.println("case 3");
		
		int cnt =0;
		for (int i = 1; i <= 100; i++) {
			if ( i%2 ==0) {
			System.out.printf("%5d", i);
			cnt ++;
		}}
		System.out.println("\n cnt : "+ cnt);
	}
	
	
	public static void for_test04() {
		System.out.println("case : 4");
		
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <=5 ; i++) {
				System.out.printf("%5d" , i);
			}
//			System.out.println();
		}
	}
	
	
	public static void for_test05() {
		System.out.println("case : 5");
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <=5; j++) {
				System.out.printf("%5d", j);
			}
			System.out.println();
		}		
	}
	
	public static void for_test06() {
		System.out.println("case : 6");
		for (int i = 1; i <= 21; i+= 5) {
			for (int j = i; j <= i + 4; j++) {
				System.out.printf("%5d", j);
			}
			System.out.println();
		}		
	}
	
	public static void main(String[] args) {
		for_test04();

	}

}
