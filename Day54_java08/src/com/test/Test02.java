package com.test;

import java.util.*;
import com.exam.*;

public class Test02 {
	public static void Prn() {
		
		Set<Score> si = new HashSet<>(); //set은 중복데이터를 허용하지 않는다.
		
		si.add(new Score("홍길동", 90, 70, 60));
		si.add(new Score("홍길동1", 90, 70, 60));
		si.add(new Score("홍길동2", 90, 70, 60));
		
		
		Score score = new Score("홍길동3", 90, 70, 60);
		
		si.add(score);
		si.add(score);
		si.add(score);
		
		for(Score sm : si) {
			System.out.println(sm);
		}
	}
	
	public static void Prn02() {
		Set<String> si02 = new HashSet<>();
		si02.add("abc");
		si02.add("abc");
		si02.add(new String("abcd"));
		si02.add(new String("abcd"));
		
		for(String sm : si02) {
			System.out.println(sm);
		}
	}
	public static void main(String[] args) {
		Prn02();
	}
}
