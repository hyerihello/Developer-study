package com.test03;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
//case 4. �̳�Ŭ������ ó���� �� �ִ�.
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame04 extends JFrame{
	Panel p1;
	JButton bt;
	

	public MyFrame04() {
		super("����");
		p1 = new Panel();
		bt = new JButton("�ü�");
				
	}
	
	public void go(){
		///���̾ƿ�///
		setFont(new Font("����",Font.BOLD,30));
		p1.add(bt);
		add(p1);
		addWindowListener(new MyEvent());
		
		// ��ư�� �̺�Ʈ
		bt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("��ưŬ���߾�");
				
			}
		});
		
		///�����ӽ������
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
