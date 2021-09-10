package com.test;

public class Test06 {
	
	
	public static void prn() {
		//2,3 을 만들자
		int[] ar[] = {{10,20,30},
					  {40,50,60}};
		
		System.out.println(ar.length); //2
		System.out.println(ar[0].length); // ar[0][0] ar[0][1] ar[0][2]
		System.out.println(ar[1].length);
		
		for(int i = 0; i<ar.length; i++) {
			for (int j = 0; j <ar[i].length; j++) {
				System.out.printf("%5d", ar[i][j]);
			}
			System.out.println();
		}
		System.out.println("====================");
		System.out.println();
		for(int[] res : ar) {
			for(int result : res) {
				System.out.printf("%5d", result);
			}
			System.out.println();
		}
	}
	
	public static void ar_prn(int[][] ar) { //ar =[[],[],[],,,]
		System.out.println();
		for(int[] res : ar) {
			for(int result : res) {
				System.out.printf("%5d", result);
			}
			System.out.println();
		}
		
	}
	
	
	public static void main(String[] args) {
		//prn(); }
		
		int[] ar[] = new int [][] {{10,20,30}, {40,50,60}};
		ar_prn(ar);
		
		System.out.println();
		//가변형 : 첫번째 줄은 2칸, 두번째 줄은 3칸, 세번째줄은 5칸
		
		int[] ar02[] = new int [2][]; //두줄은 2갠데 칸은 모름
		ar02[0] = new int[2];
		ar02[0][0] = 10000;
		ar02[1] = new int[] {100,200,300};
		ar_prn(ar02);
		
//		//심심한그대 5,5 를 사용해서 E를 채워봐라?
//	}

}}
