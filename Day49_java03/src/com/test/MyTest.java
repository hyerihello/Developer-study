package com.test;
import com.mytest.*; // ��Ű���̸����� �־��ش�

public class MyTest {

	public static void main(String[] args) {
		Calc c1 = new Calc(1,5);
		System.out.println(c1);
	}
}
// �����н�, �����н� �����ϴ°�
// jar������ export�ؼ� ������ �� �Ʒ��� ���� �Ѵ�.
// �����н� : C:\Program Files\Java\jdk1.8.0_291\jre\lib\ext
// �����н� : ������Ʈ -> �����н� -> ���Ǳ� -> user, addExternal jars