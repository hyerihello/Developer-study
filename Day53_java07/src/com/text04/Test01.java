package com.text04;

import java.util.ArrayList;
import java.util.Vector;

import com.exam.Score;

// �����ִ� ����� �����ϴ� List ��ü �ļ��� ����� ����.

public class Test01 {

	public static void main(String[] args) {
//		Vector v = new Vector(); // ������ �Է½� ��ı����� �����ؼ� �ڷḦ ������(2����)
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
		//<E> element�� �����ϴ� class
		
		
//		System.out.println(v.capacity());// �⺻�뷮
//		System.out.println(v); // Array
		
		ArrayList<Score> s = new ArrayList<Score>();
		s.add(new Score(90,80,70));
		s.add(new Score(100,80,50));
		s.add(new Score(90,70,40));
		s.add(new Score(90,90,30));
		
		System.out.println(s);
		// s�� ��ü�� 2��°�� ���� 100,100,100�� �Է��غ���.
		s.add(1,new Score(100,100,100));
		System.out.println(s);
		
		
//		// ���������� �迭??
//		for(Score res : s) {
//			System.out.println(res);
//		}
		
		// 90,90,30 ��ü ����
//		s.remove(4);
//		System.out.println(s);
		
		for(Score res : s) {
			if(res.getKor() >= 90) {
				res.setKor(0);
			}
			System.out.println(res);
		}
}}
