package com.test03;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
//case 2 : ������ �̺�Ʈ �������̽� �͸����� ������ �ϴ� ���

public class MyFrame02 extends Frame{
	Panel p1;
	Button bt;
	

	public MyFrame02() {
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
		
		///�����ӽ������
		setSize(400,400);
		setVisible(true);
	}
public static void main(String[] args) {
	new MyFrame02().go();

}}
