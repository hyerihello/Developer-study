package com.text04;

import java.util.ArrayList;
import java.util.Vector;

import com.exam.Score;

// 순서있는 목록을 관리하는 List 객체 후손을 사용해 보자.

public class Test01 {

	public static void main(String[] args) {
//		Vector v = new Vector(); // 데이터 입력시 행렬구조로 리턴해서 자료를 관리함(2차원)
//		v.add("1");
//		v.add(new String("abcd"));
//		v.add(new Double(09.7));
//		System.out.println(v);
//		System.out.println(v.get(0));
		 
		
//		Vector v = new Vector(5,4);
//		for (int i=1; i <=21; i++) {
//			v.add(i);
//		}
		
		
//		ArrayList v = new ArrayList();
//		for (int i=1; i <=21; i++) {
//			v.add(i);
//		}
		
		
		ArrayList <String> v = new ArrayList<String>();
		for (int i=1; i <=21; i++) {
			v.add(i+"");
		}
		//<E> element만 관리하는 class
		
		
//		System.out.println(v.capacity());// 기본용량
//		System.out.println(v); // Array
		
		ArrayList<Score> s = new ArrayList<Score>();
		s.add(new Score(90,80,70));
		s.add(new Score(100,80,50));
		s.add(new Score(90,70,40));
		s.add(new Score(90,90,30));
		
		System.out.println(s);
		// s의 객체의 2번째에 값을 100,100,100을 입력해보자.
		s.add(1,new Score(100,100,100));
		System.out.println(s);
		
		
//		// 순차적으로 배열??
//		for(Score res : s) {
//			System.out.println(res);
//		}
		
		// 90,90,30 객체 삭제
//		s.remove(4);
//		System.out.println(s);
		
		for(Score res : s) {
			if(res.getKor() >= 90) {
				res.setKor(0);
			}
			System.out.println(res);
		}
}}
