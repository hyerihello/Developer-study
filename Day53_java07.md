## **User\_class**

**\[Score class\]**

```
package com.exam;

// 3과목의 총점, 평균, 학점을 구하자.
// main 에서 값을 줄거야

public class Score {

		private int kor; 
		private int eng;
		private int mat;
				
		public Score() {
			super();			
		}
		
		public Score(int kor, int eng, int mat) {
			super();
			this.kor = kor;
			this.eng = eng;
			this.mat = mat;
		}
		
		public int getKor() {
			return kor;
		}
		public void setKor(int kor) {
			this.kor = kor;
		}
		public int getEng() {
			return eng;
		}
		public void setEng(int eng) {
			this.eng = eng;
		}
		public int getMat() {
			return mat;
		}
		public void setMat(int mat) {
			this.mat = mat;
		}
		
		public int getTot() {
			int tot = 0;
			tot = this.getKor() + this.getEng() + this.getMat();
			return tot;
		}
		
		
		public double getAvg() {
			double avg =0;
			avg = this.getTot()/3.0;
			return avg;
			
		}
		//switch case : if문과 비슷하지만 좀 더 정형화된 제어문
		
		public String Getgrade() {
			String grade = null; //메서드안에 초기변수를 주면 지역변수?
			switch((int)getAvg()/10) { //98.0 --> 9.8 -> 9 / 100.0 -> 10.0 -> 10
			case 10:
			case 9 : grade = "A";
					 break;
			case 8 : grade = "B";
					 break;
			case 7 : grade = "C";
					 break;
			case 6 : grade = "D";
					 break;
		    default : 
		    		grade = "F";
			}
			return grade;
			}
		
		@Override
		public String toString() {
			String str = String.format("%5d %5d %5d %5d %3.1f %3s\n", 
					this.getKor(), this.getEng(), this.getMat(), this.getTot(),this.getAvg(),this.Getgrade());
			return str;
		}
		// 변수선언 -> 값 대입 -> 연산 -> 출력
		// 멤버변수선언 -> 생성자선언 -> getter&setter -> 연산메소드 -> 출력메소드





```

**Q1-1) 3과목의 총점, 평균, 학점을 구하자.**

```
	public static void main(String[] args) {
		Score s1 = new Score (90,80,60);
		Score s2 = new Score (100,80,60);
		Score s3 = new Score (90,80,50);
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
        
 ======================================================================
 
    90    80    60   230 76.7   C

  100    80    60   240 80.0   B

   90    80    50   220 73.3   C
```

**Q1-2) s1의 국어 점수를 100 변환 후 출력하자.**

```

// s1의 국어점수를 100 변환 후 출력하자.
// main 에서 값을 줄거야


	public static void main(String[] args) {
		Score s1 = new Score (90,80,60);
		Score s2 = new Score (100,80,60);
		Score s3 = new Score (90,80,50);
		
	
		//s1의 국어점수를 100 변환 후 출력하자.
		s1.setKor(100); // 값 전달 및 변경
		System.out.println(s1);
        
 ====================================================================
 
   100    80    60   240 80.0   B

```

**Q1-3) s3의 국어점수를 0으로 변환 후 출력하자.**

```
		
	// s3의 국어점수를 0으로 변환 후 출력하자.
		s3.setKor(0);
		System.out.println(s3);
		System.out.println(s3.getKor());
        
        
  ==================================================
  
      0    80    50   130 43.3   F

		0
```

**Q2-1) Object Array 를 이용해 객체를 출력** 

```
		
	public static void main(String[] args) {

		
		// Object Array 1
		Score[] sm = new Score[3];
		sm[0] = new Score (90,80,60);
		sm[1] = new Score (100,80,60);
		sm[2] = new Score (90,80,50);
		


		for(Score res : sm) {
			System.out.println(res);
		}
        
        
		sm[1].setKor(0);
		System.out.println(sm); // 주소번지리턴
		System.out.println(sm[1]);
	

	}
}
==========================================================================

   90    80    60   230 76.7   C

  100    80    60   240 80.0   B

   90    80    50   220 73.3   C

[Lcom.exam.Score;@1540e19d
    0    80    60   140 46.7   F

```

**Q2-2) Object Array 를 이용해 객체를 출력** 

```
  // Object Array 2
             
	Score[] sm = new Score[] {
          new Score (90,80,60),
          new Score (100,80,60),
          new Score (90,80,50)};
	
	my_print(sm);
	}
	


	public static void my_print(Score[] sm) {
		for(Score res:sm) {
			System.out.println(res);
		}
	}}
    
==========================================================

   90    80    60   230 76.7   C

  100    80    60   240 80.0   B

   90    80    50   220 73.3   C
```

**\[Address class\]**

```
package com.exam;

import java.io.Serializable;

// 주소록을 객체단위로 읽고싶군!
// Serializable: 객체단위로 끊어서 보내주는 것
 
public class Address implements Serializable{ //역 직렬화가 꼭 필요하다.

		
		private String addr;
		private String tel;
		
	
		public String getAddr() {
			return addr;
		}

		public void setAddr(String addr) {
			this.addr = addr;
		}

		public String getTel() {
			return tel;
		}

		public void setTel(String tel) {
			this.tel = tel;
		}

		public Address() {
			
		}		
		public Address( String addr, String tel) {
			
			this.addr = addr;
			this.tel = tel;
		}
		
		@Override
		public String toString() {
			String str = String.format("%5s %5s \n", this.getAddr(),this.getTel());
			return str;
		}


	}
```

**Q3) 멤버를 클래스로 가지는 클래스를 만들자** 

  **\[Score class\] , **\[Address class\] → 멤버클래스****

  ****\[MyClass\] ****→ 멤버를 클래스로 가지는 클래스********

```
package com.exam;

public class MyClass {
	//멤버를 클래스로 가지는 클래스
    
	private String name; // java lang class
	private Address m_address; // 사용자 class
	private Score m_score; // 사용자 class
	
	public MyClass() {
		this.name = null; //초기화, 안줘도 주고있다.
		this.m_address = null ;
		this.m_score = null;
	}
	
    
	public MyClass(String name, Address address, Score score) {
		this.name = name; //지역변수, 전역변수 구분해야되서 반드시 명시해야한다. 멤버변수 명과 지역변수 명이 동일할 때 구분하려면 반드시 this로 명시해준다.
		m_address = address;
		m_score = score;
	}

	// private -> getter&setter 주자
    
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getM_address() {
		return m_address;
	}

	public void setM_address(Address m_address) {
		this.m_address = m_address;
	}

	public Score getM_score() {
		return m_score;
	}

	public void setM_score(Score m_score) {
		this.m_score = m_score;
	}

	@Override
	public String toString() {
		//return String.format("MyClass [name=%s, m_address=%s, m_score=%s]", name, m_address, m_score);
																			//변수명을 호출할때 .toString이 쫒아온다.
		return String.format("MyClass [name=%s, m_address=%s, m_score=%s]", name, this.getM_address(), m_score);
																			// 메소드로 호출한다.
	}
	
	
}
```

**Q3-1) 멤버를 클래스로 가지는 클래스를 값을 입력해 실행해보자.**

```
package com.exam;

public class Test {

public static void main(String[] args) {
	
	MyClass m1 = new MyClass(); 
	System.out.println(m1); // 값을 주지 않았으니 null 반환
	System.out.println();
	
	
	//public MyClass(String name, Address address, Score score)
	System.out.println("==============<1. 주소를 서울시로 수정> =============");
	MyClass m2 = new MyClass("홍길동", new Address("서울시", "02-000-0000"), new Score(90,80,70));
	System.out.println(m2);
	
	
	
	/*
	//m2.getM_address(); //아래랑 같다
	Address r = m2.getM_address();
	r.setAddr("부산시");
	*/
	System.out.println("============= <2. 주소를 부산시로 수정> ============");
	m2.getM_address().setAddr("부산시");
	System.out.println(m2);
	
	
	System.out.println("============ <국어점수를 100점으로 수정> ============");
	m2.getM_score().setKor(100);
	System.out.println(m2);
	System.out.println(m2.getM_score().getKor()); // 국어점수만 리턴
	}
}

MyClass [name=null, m_address=null, m_score=null]

==============<1. 주소를 서울시로 수정> =============
MyClass [name=홍길동, m_address=  서울시 02-000-0000 
, m_score=   90    80    70   240 80.0   B
]
============= <2. 주소를 부산시로 수정> ============
MyClass [name=홍길동, m_address=  부산시 02-000-0000 
, m_score=   90    80    70   240 80.0   B
]
============ <국어점수를 100점으로 수정> ============
MyClass [name=홍길동, m_address=  부산시 02-000-0000 
, m_score=  100    80    70   250 83.3   B
]
100
==============================================================================
```

## **중첩 interface, class** 

```
package com.test;

interface IA{
	interface IB{
}
class CC{}
}
```

```
package com.test;
public class test{
	class n_test { }
	static class s_test{ }
	public static void main(String[] args){}


}
```

## **GUI**

**\# 첫 프레임 만들기**

```
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
```

[##_Image|kage@qYbFy/btq8ZqYyZNZ/2tHWY4wcoM9em85NlDNX11/img.png|alignCenter|data-origin-width="386" data-origin-height="193" data-ke-mobilestyle="widthOrigin"|||_##]

```
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
```

[##_Image|kage@bfP2rn/btq83jp7gyd/vaAeg7TALGAIhHtMbBbnMK/img.png|alignCenter|data-origin-width="386" data-origin-height="393" data-ke-mobilestyle="widthOrigin"|||_##]

```
package com.test02;

import java.awt.*;

public class MyFrame02 extends Frame {

	
	Panel p1,p2;
	Button bt1, bt2;
	
	public MyFrame02() {
		p1 = new Panel();
		p2 = new Panel();
		
		bt1 = new Button("111");
		bt2 = new Button("222");
		}
		
	public void go(){
	
		////////p1
	p1.add(bt1);
	////////////p2
	p2.add(bt2);
		
	//////////frame
	setLayout(new GridLayout(2,1));
	add(p1);
	add(p2);
	setSize(500,500);
	setVisible(true);
	
	}
public static void main(String[] args) {
	new MyFrame02().go();
}
}
```

[##_Image|kage@kYCdU/btq8U2KoXhG/9ZtQxQtBKstlahaFxdggyK/img.png|alignCenter|data-origin-width="486" data-origin-height="493" data-ke-mobilestyle="widthOrigin"|||_##]

\# 버튼구현

```
package com.test02; 

 import java.awt.Button;
 import java.awt.*;
 import java.util.*;
 import java.applet.Applet;

 public class Test02 extends Frame {

     protected void makebutton(String name,
                               GridBagLayout gridbag,
                               GridBagConstraints c) {
         Button button = new Button(name);
         gridbag.setConstraints(button, c);
         add(button);
     }

     public void init() {
         GridBagLayout gridbag = new GridBagLayout();
         GridBagConstraints c = new GridBagConstraints();

         setFont(new Font("SansSerif", Font.PLAIN, 14));
         setLayout(gridbag);

         c.fill = GridBagConstraints.BOTH;
         c.weightx = 1.0;
         makebutton("Button1", gridbag, c);
         makebutton("Button2", gridbag, c);
         makebutton("Button3", gridbag, c);

         c.gridwidth = GridBagConstraints.REMAINDER; //end row
         makebutton("Button4", gridbag, c);

         c.weightx = 0.0;                //reset to the default
         makebutton("Button5", gridbag, c); //another row

         c.gridwidth = GridBagConstraints.RELATIVE; //next-to-last in row
         makebutton("Button6", gridbag, c);

         c.gridwidth = GridBagConstraints.REMAINDER; //end row
         makebutton("Button7", gridbag, c);

         c.gridwidth = 1;                //reset to the default
         c.gridheight = 2;
         c.weighty = 1.0;
         makebutton("Button8", gridbag, c);

         c.weighty = 0.0;                //reset to the default
         c.gridwidth = GridBagConstraints.REMAINDER; //end row
         c.gridheight = 1;               //reset to the default
         makebutton("Button9", gridbag, c);
         makebutton("Button10", gridbag, c);

         setSize(300, 100);

         pack();
         setSize(getPreferredSize());
         setVisible(true);
     }
     
     
     public static void main(String args[]) {
         
         Test02 ex1 = new Test02();
         ex1.init();


 }}
```

[##_Image|kage@wGGkt/btq84uSgvHN/s9DM5uKKZTLFfhJ6NkSmtk/img.png|alignCenter|data-origin-width="254" data-origin-height="154" data-ke-mobilestyle="widthOrigin"|||_##]

**\# 인터페이스를 implements 이벤트 적용방법** 

```
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
```

**\# 윈도우 이벤트 인터페이스 익명으로 재정의 하는 방법**

```
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
```

**\# 추상클래스 익명으로 정의하는 방법, 계산기를 만들어보자.**

```
package com.test03;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import com.mytest.*;
// case3 : 추상클래스 익명으로 정의하는 방법, 계산기를 만들어보자.

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
```

[##_Image|kage@ecy3rS/btq83iSnmFs/06W2Di3L4mzrUCZbNVuPXk/img.png|alignCenter|data-origin-width="386" data-origin-height="393" data-ke-mobilestyle="widthOrigin"|||_##]

**\# 이너클래스로 처리할 수 있다. (swing) 이용**

```
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
```

[##_Image|kage@uVM8n/btq84gGLuWX/udoechmvsMK9Kfx1Cl9s8K/img.png|alignCenter|data-origin-width="386" data-origin-height="393" data-ke-mobilestyle="widthOrigin"|||_##]
