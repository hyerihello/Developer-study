package com.test03;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

//case1 : �������̽��� implements �ϴ� �̺�Ʈ ���� ���
public class MyFrame extends Frame implements WindowListener{
	Panel p1;
	Button bt;
	

	public MyFrame() {
		super("����");
		p1 = new Panel();
		bt = new Button("�ü�");
				
	}
	
	public void go(){
		///���̾ƿ�///
		setFont(new Font("����",Font.BOLD,30));
		p1.add(bt);
		add(p1);
		
		// �̺�Ʈ ���� = listener
		// 1. �����(frame, button) add ** listener �� ã�´�. 
		// 2. () ��ȣ ���� �Ű����ڸ� ���ؼ� �ش� �̺�Ʈ�� �´� �޼ҵ尡 �ִ��� ã�´�.
		// 3. �����Ѵ�
		
		// windowClosed(WindowEvent e)
		addWindowListener(this);
		
		///�����ӽ������
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
