package com.test03;

public class Mtest {
	public static void main(String[] args) {
	
		Car c1 = new Car("sm5"); // 생성자 생성 sm5를가지고 super로간다
		Car c2 = new Car("sm5"); // sm5를 가지고 
		
		System.out.println("주소비교 : " + (c1 == c2)); // c1.toString() == c2.toString()
		// 주소비교했더니 다르다
		System.out.println("주소비교 : " + (c1.equals(c2))); // c1.toString() == c2.toString()
		
			if(c1.equals(c2)) { // this.객체와 넘어온객체와 비교
				System.out.println(" 차이름이 같아 ");
			}else {
				System.out.println(" 이름이 달라 ");}
}
}
