package com.test;
import java.util.*;

import com.exam.Score;
import com.test.*;
//Map을 이용해보자.

public class Test03 {
	
	public static void Prn() {
		// T(type),E(element), K(key),V(value) 올수있다. <>안에
		Map<Integer, String> m1 = new HashMap<>(); // Interface Map < key, value>, key는 중복불가
		m1.put(1,"1");
		m1.put(2,"2");
		m1.put(3,"3");
		
		System.out.println(m1);
		System.out.println(m1.get(1)); // value '1' 리턴
	}
	
	public static void Prn02() {
		
		Map<Integer,Score> si = new HashMap<>(); //set은 중복데이터를 허용하지 않는다.
		
		si.put(1,new Score("홍길동", 90, 70, 60));
		si.put(2,new Score("홍길동1", 90, 70, 60));
		si.put(3,new Score("홍길동2", 90, 70, 60));
		
		System.out.println(((Object)si).getClass()); // class java.util.HashMap, class를 보고싶어
		System.out.println(si);
		System.out.println(si.values()); //values 값만 리턴
		Set<Map.Entry<Integer, Score>> res = si.entrySet(); // key,value를 관리하는것 Map.Entry<K,V> //key값만 보고싶어
		System.out.println(res);
		
		System.out.println("=====================");
		for(Map.Entry<Integer, Score> r: res) {
			System.out.println(r.getKey() +":"+r.getValue()); //entry set으로 리턴을 받아서 key value 각각 값을 리턴받는다.
		}
	}
	
	
	public static void main(String[] args) {
		//Prn(); // 딕셔너리 {1=1, 2=2, 3=3} 리턴
		Prn02();
	}
}
