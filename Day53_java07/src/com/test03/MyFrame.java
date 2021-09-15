package com.test03;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

//case1 : 인터페이스를 implements 하는 이벤트 적용 방법
public class MyFrame extends Frame implements WindowListener{
	Panel p1;
	Button bt;
	

	public MyFrame() {
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
		// 1. 대상의(frame, button) add ** listener 을 찾는다. 
		// 2. () 괄호 안의 매개인자를 통해서 해당 이벤트에 맞는 메소드가 있는지 찾는다.
		// 3. 구현한다
		
		// windowClosed(WindowEvent e)
		addWindowListener(this);
		
		///프레임실행시점
		setSize(400,400);
		setVisible(true);
	}
public static void main(String[] args) {
	new MyFrame().go();

}

@Override
public void windowOpened(WindowEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void windowClosing(WindowEvent e) {
	// TODO Auto-generated method stub
	System.out.println("windowClosing");
	System.exit(0);
}

@Override
public void windowClosed(WindowEvent e) {


}

@Override
public void windowIconified(WindowEvent e) {

	
}

@Override
public void windowDeiconified(WindowEvent e) {

	
}

@Override
public void windowActivated(WindowEvent e) {

	
}

@Override
public void windowDeactivated(WindowEvent e) {

	
}}
