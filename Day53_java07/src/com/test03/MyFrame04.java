package com.test03;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
//case 4. 이너클래스로 처리할 수 있다.
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame04 extends JFrame{
	Panel p1;
	JButton bt;
	

	public MyFrame04() {
		super("내꺼");
		p1 = new Panel();
		bt = new JButton("궁서");
				
	}
	
	public void go(){
		///레이아웃///
		setFont(new Font("바탕",Font.BOLD,30));
		p1.add(bt);
		add(p1);
		addWindowListener(new MyEvent());
		
		// 버튼의 이벤트
		bt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("버튼클릭했엉");
				
			}
		});
		
		///프레임실행시점
		setSize(400,400);
		setVisible(true);
	}
	
	class MyEvent extends WindowAdapter{

		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
		
	}
public static void main(String[] args) {
	new MyFrame04().go();

}}
