package com.test02;
import java.awt.*;
public class MyFrame extends Frame{

	Button bt;
	Button bt01;
	
	public MyFrame() { // �⺻������
		super("��̵�����"); // super�� Frame, this�� Myframe
		bt = new Button("��ư");
		bt01 = new Button("��ư2222");
	}

	
	public void go(){ // ����� ������, ����� ������
		
		setBackground(new Color(255,175,175));
		setSize(new Dimension(400,400));
		setVisible(true);
		add(bt,BorderLayout.SOUTH); // ��ġ���������� ������ �����.
		add(bt01,BorderLayout.NORTH);
		
		
		add(new Button("North"), BorderLayout.NORTH);// �ѹ��� ���������.
	    add(new Button("South"), BorderLayout.SOUTH);
	    add(new Button("East"), BorderLayout.EAST);
	    add(new Button("West"), BorderLayout.WEST);

	    setLayout(new GridLayout(3, 1));
	    add(new Checkbox("one", null, true));
	    add(new Checkbox("two"));
	    add(new Checkbox("three"));
	    
	    

	}
	
	public static void main(String[] args) {
		//new MyFrame().go();
		
		MyFrame m = new MyFrame();
		m.go();
		System.out.println(m.getTitle()); // Frame(String title)
		System.out.println(m.getLayout()); // borderlayout ���� ��ġ�� �ϴ±������ ����! (�����������ȵȴ�)
		
	}
}
