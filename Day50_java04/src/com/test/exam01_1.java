package com.test;

public class exam01_1 {
	
	public static String cnvr(String res) { // res = str을 참조한다.
		
		// 대문자의 갯수와 소문자의 갯수를 출력하기 위해 문자열(string)을 새 문자 배열(char)로 변환하자.
		// == public char[] toCharArray() 메서드 사용
		
		char[] ch_res = res.toCharArray(); //str을 참조한 res를 문자 배열로 변환!
		int cnt_u = 0; // 대문자 갯수
		int cnt_l = 0; // 소문자 갯수
		
		for (int i = 0; i < ch_res.length; i++) { // i가 0이고 배열로 변환한 ch_res의 길이보다 작을때 i를 더한다.
			// Character.isUpperCase() : 입력받은 인자가 대문자의 여부를 판단하여 true,false 반환
			if(Character.isUpperCase(ch_res[i])) { 
				ch_res[i] = Character.toLowerCase(ch_res[i]); // 입력받은 인자 값을 소문자로 변환 후 리턴
				cnt_u++; // 대문자 갯수에 카운팅을 한다.
			}
			else if(Character.isLowerCase(ch_res[i])) {
				ch_res[i] = Character.toUpperCase(ch_res[i]);
				cnt_l++;
			}
	
		}
		System.out.println("대문자의 개수 : " + cnt_u + "소문자의 개수 : " + cnt_l);
		return new String(ch_res); // 새로운 문자열(String) 출력
	}
public static void main(String[] args) {
	String str = "The String class represents character strings. ";
	String res = cnvr(str);
	System.out.println(res);
}

}
