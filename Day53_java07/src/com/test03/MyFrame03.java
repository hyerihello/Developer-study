package com.test03;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import com.mytest.*;
//case3 : 추상클래스 익명으로 정의하는 방법, 계산기를 만들어보자.

public class MyFrame03 extends Frame{
	Frame f = new Frame("My_Frame");
	Panel p1,p2,p3,p4;
	Label lbl_a, lbl_b, lbl_r;
	TextField txt_a, txt_b, txt_result;
	CheckboxGroup cbg ;
	Checkbox b1,b2,b3,b4;
	Button bt;
	Calc my_calc;
	
	
	public MyFrame03() {
		super("내꺼");
		
		my_calc = new Calc(); // 초기화
		
		lbl_a = new Label("A :");
		lbl_b = new Label("B :");
		lbl_r = new Label("Result");
		
		p1 = new Panel();
		p2 = new Panel();
		p3 = new Panel();
		p4 = new Panel();
		
		cbg = new CheckboxGroup();
		b1 = new Checkbox("+",cbg,false);
		b2 = new Checkbox("-",cbg,false);
		b3 = new Checkbox("*",cbg,false);
		b4 = new Checkbox("/",cbg,false);
		
		txt_a = new TextField(20);
		txt_b = new TextField(20);
		txt_result = new TextField(20);
		
		bt = new Button("OK!");
		
	}
	
	public void go(){
		f.setTitle("My_Frame");
		///레이아웃///
		setFont(new Font("바탕",Font.BOLD,20));
		setLayout(new GridLayout(4,1));
		setBackground(new Color(255,175,175));
		
		add(lbl_a);
		add(lbl_b);
		////p1
		p1.add(lbl_a);
		p1.add(txt_a);
		
		////p2
		p2.add(lbl_b);
		p2.add(txt_b);
		
		/// p3
		
		p3.add(b1);
		p3.add(b2);
		p3.add(b3);
		p3.add(b4);
		p3.add(bt);
		
		///p4
		p4.add(lbl_r);
		p4.add(txt_result);
		
		//이벤트
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}});
		
	bt.addActionListener(new MyEvent());
		//프레임실행
		add(p1);
		add(p2);
		add(p3);
		add(p4);
		

		setSize(400,400);
		setVisible(true);
	}
		

	class MyEvent implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
//			System.out.println(toString());
//			System.out.println(e.getActionCommand() + ":");
//			System.out.println(e.paramString());
//			if(e.paramString().equals("OK!")){ //ok로 같다면 get Action!
//				System.out.println("클릭했어");
			
			int a = Integer.parseInt(txt_a.getText());
			int b = Integer.parseInt(txt_b.getText());
			
			my_calc.setA(a);
			my_calc.setB(b);
			
			if(b1.getState()) {
				String res = String.valueOf(my_calc.getHap());
				txt_result.setText(res);
			}
			
			if(b2.getState()) {
				String res = String.valueOf(my_calc.getSub());
				txt_result.setText(res);
			}
			
			if(b3.getState()) {
				String res = String.valueOf(my_calc.getMul());
				txt_result.setText(res);
			}
			
			if(b4.getState()) {
				my_calc.setA(b); // 나누기일때 변경해서 입력하기!
				my_calc.setB(a);
				String res = String.valueOf(my_calc.getDiv());
				txt_result.setText(res);
			}
			
			System.out.println(b1.getState());
			
			}
		}
	
	


public static void main(String[] args) {
	new MyFrame03().go();

}}
