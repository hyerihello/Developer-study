package com.test;

import java.util.*;
import com.exam.*;

public class Test02 {
	public static void Prn() {
		
		Set<Score> si = new HashSet<>(); //set�� �ߺ������͸� ������� �ʴ´�.
		
		si.add(new Score("ȫ�浿", 90, 70, 60));
		si.add(new Score("ȫ�浿1", 90, 70, 60));
		si.add(new Score("ȫ�浿2", 90, 70, 60));
		
		
		Score score = new Score("ȫ�浿3", 90, 70, 60);
		
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
