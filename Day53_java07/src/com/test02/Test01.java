package com.test02;

import java.awt.*;
public class Test01 {

public static void main(String[] args) {
	Frame f1 = new Frame();
	
	
	//f1.setSize(200,400); //pixel ������ ������ 
	f1.setSize(new Dimension(400,200)); // �ȳ����� NEW
	
	//f1.setBackground(Color.gray); //static 
	f1.setBackground(new Color(255,175,175));
	
	f1.setTitle("hihihihi");
	
	f1.setVisible(true); // â �����ִ� �޼���
	
	
	System.out.println(f1.getBackground());
	System.out.println(f1.getSize());
	
 }
}


