package com.test;
import java.util.*;

import com.exam.Score;
import com.test.*;
//Map�� �̿��غ���.

public class Test03 {
	
	public static void Prn() {
		// T(type),E(element), K(key),V(value) �ü��ִ�. <>�ȿ�
		Map<Integer, String> m1 = new HashMap<>(); // Interface Map < key, value>, key�� �ߺ��Ұ�
		m1.put(1,"1");
		m1.put(2,"2");
		m1.put(3,"3");
		
		System.out.println(m1);
		System.out.println(m1.get(1)); // value '1' ����
	}
	
	public static void Prn02() {
		
		Map<Integer,Score> si = new HashMap<>(); //set�� �ߺ������͸� ������� �ʴ´�.
		
		si.put(1,new Score("ȫ�浿", 90, 70, 60));
		si.put(2,new Score("ȫ�浿1", 90, 70, 60));
		si.put(3,new Score("ȫ�浿2", 90, 70, 60));
		
		System.out.println(((Object)si).getClass()); // class java.util.HashMap, class�� ����;�
		System.out.println(si);
		System.out.println(si.values()); //values ���� ����
		Set<Map.Entry<Integer, Score>> res = si.entrySet(); // key,value�� �����ϴ°� Map.Entry<K,V> //key���� ����;�
		System.out.println(res);
		
		System.out.println("=====================");
		for(Map.Entry<Integer, Score> r: res) {
			System.out.println(r.getKey() +":"+r.getValue()); //entry set���� ������ �޾Ƽ� key value ���� ���� ���Ϲ޴´�.
		}
	}
	
	
	public static void main(String[] args) {
		//Prn(); // ��ųʸ� {1=1, 2=2, 3=3} ����
		Prn02();
	}
}
