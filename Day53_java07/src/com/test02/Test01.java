package com.test02;

import java.awt.*;
public class Test01 {

public static void main(String[] args) {
	Frame f1 = new Frame();
	
	
	//f1.setSize(200,400); //pixel 단위로 사이즈 
	f1.setSize(new Dimension(400,200)); // 안나오면 NEW
	
	//f1.setBackground(Color.gray); //static 
	f1.setBackground(new Color(255,175,175));
	
	f1.setTitle("hihihihi");
	
	f1.setVisible(true); // 창 보여주는 메서드
	
	
	System.out.println(f1.getBackground());
	System.out.println(f1.getSize());
	
 }
}


