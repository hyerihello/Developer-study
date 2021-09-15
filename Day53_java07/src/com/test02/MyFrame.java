package com.test02;
import java.awt.*;
public class MyFrame extends Frame{

	Button bt;
	Button bt01;
	
	public MyFrame() { // 기본생성자
		super("재미따내꺼"); // super는 Frame, this는 Myframe
		bt = new Button("버튼");
		bt01 = new Button("버튼2222");
	}

	
	public void go(){ // 사용자 생성자, 여기다 만들자
		
		setBackground(new Color(255,175,175));
		setSize(new Dimension(400,400));
		setVisible(true);
		add(bt,BorderLayout.SOUTH); // 위치지정해주지 않으면 덮어쓴다.
		add(bt01,BorderLayout.NORTH);
		
		
		add(new Button("North"), BorderLayout.NORTH);// 한번만 쓰고버린다.
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
		System.out.println(m.getLayout()); // borderlayout 으로 배치를 하는구나라고 생각! (사이즈조절안된다)
		
	}
}
