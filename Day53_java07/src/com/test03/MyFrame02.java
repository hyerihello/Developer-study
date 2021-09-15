package com.test03;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
//case 2 : 윈도우 이벤트 인터페이스 익명으로 재정의 하는 방법

public class MyFrame02 extends Frame{
	Panel p1;
	Button bt;
	

	public MyFrame02() {
		super("내꺼");
		p1 = new Panel();
		bt = new Button("궁서");
				
	}
	
	public void go(){
		///레이아웃///
		setFont(new Font("바탕",Font.BOLD,30));
		p1.add(bt);
		add(p1);
		
		// 이벤트 구현 = listener
		addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
			System.exit(0);
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		///프레임실행시점
		setSize(400,400);
		setVisible(true);
	}
public static void main(String[] args) {
	new MyFrame02().go();

}}
