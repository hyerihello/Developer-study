**1\. ChatServerThread** 

```
package com.server;
import java.io.*;
import java.util.Vector;
import com.client.Data;

public class ChatServerThread implements Runnable{


	Vector <Data> buffer; //-지만 default를 삭제하기 , 버퍼는 전체데이터 가지고있는애임
	ObjectInputStream ois;
	ObjectOutputStream oos;
	Data d;
	boolean exit;
	String name;


	public ChatServerThread(Vector <Data> buffer, ObjectInputStream ois, ObjectOutputStream oos) {
		super();
		this.buffer = buffer;
		this.ois = ois;
		this.oos = oos;}

	 public void run() {
		 while(!exit) {
			 try {
				d = (Data) ois.readObject(); //전체 데이터 객체를 리턴받는다.
				int state = d.getState(); // 상태 값을 리턴
				switch (state) {
				case Data.DISCONNECTION: // 클로즈 했다면
					name = d.getName(); // 이름을 리턴받고
					for(Data r : buffer) { // 전체목록에서 삭제
						if(r.getName().equals(name)) {
							buffer.removeElement(r);
						}
					}
					broadCasting(); //전체출력
					try {
						ois.close();
						oos.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				break;
				
				
				case Data.FIRST_CONNECTION: // 이름을 받아와서 벡터에 추가하고
					//새로 처음 접속한 이름의 목록 상자를 생성한다.
					Vector<String> userName = new Vector<>(5,1);
					d.setOos(oos);
					buffer.addElement(d);
					for(Data r : buffer) {
						userName.add(r.getName());
						}
					
					d.setUserName(userName);
					broadCasting();
					break;
					
				case Data.CHAT_MESSAGE:
					broadCasting();
					break;
					
				case Data.CHAT_WHISPER:
					broadCasting();
					break;
				default:
				}//switch
			}catch (Exception e) {
				System.err.println("IoException 이 발생하였습니다");
				exit = true;
				}//catch
			}//while
	 } //run@ annotation 지우기 
	 
	 
	 public void broadCasting() throws IOException {
		 for ( int i = 0;  i<buffer.size(); i++) {
			 ((Data) buffer.elementAt(i)).getOos().writeObject(d); //전체 클라이언트에게 데이터를 써주겠다. (뿌리겠다)
		 }//for
	}//method
	 
	 
	 public void whisper() { //클라이언트에게 데이터를 써주겠다. (리시버만 뿌려준다)
		 String receiver = d.getReceiver();
		 for ( int i = 0;  i<buffer.size(); i++) {
			 Data data = (Data) buffer.elementAt(i);
			 if (data.getName().equals(receiver)) {
				 try {
					data.getOos().writeObject(d);
				} catch (IOException e) {
					System.err.println("broadCasting method IOException이 발생하였습니다");
				} // catch
			 } // if
		 } // for
	 }//whisper
}//class


==================================================================

Start Server Service...
접속준비중
```

**2\. ChatServer (가장 먼저 실행시켜야 함)**

```
package com.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.util.Vector;
import java.net.Socket; //얘가 빠짐!!! 

//
public class ChatServer {
 Vector buffer;
 ServerSocket serverSocket;
 Socket Socket;
 ObjectInputStream ois;
 ObjectOutputStream oos;
		 
		 
public void service() {
	try {
		System.out.println("접속준비중");
		serverSocket = new ServerSocket(5555);
		
	} catch (IOException e) {
		System.err.println("서비스 준비중에 IOException이 발생했습니다");
	}
	
	while(true) {
		try {
			Socket = serverSocket.accept();
			System.out.println(Socket.getInetAddress()+ "가 접속하셨습니다");
			
			ois = new ObjectInputStream(Socket.getInputStream());
			oos = new ObjectOutputStream(Socket.getOutputStream());
			
			Thread t = new Thread(new ChatServerThread(buffer,ois,oos));
			t.start();
		}catch(IOException e) {
			System.err.println("IOException이 발생했습니다.");
			e.printStackTrace();
		}
	}//while
}//service()

public static void main(String[] args) {
		System.out.println("Start Server Service...");
		ChatServer cs = new ChatServer();
		cs.buffer = new Vector(5,1);
		cs.service();
	 
	 
 }
}
```

**3\. Data** 

```
package com.client; // 가장 중요한 class! 

import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Vector;

public class Data implements Serializable{

private String name; // Client의  username을 저장하는 변수
private String receiver; // 귓말 보내기에서 메세지를 받을 user의 name
private String message; //Client 의 messege를 저장하는 변수
private int state; // Client의 접속과 종료 상태를 저장하는 변수

// transient : 자료전달 객체이기 때문에 skip 해도 된다. Serializable 가 implements가 된 멤버변수의 경우만 해당
private transient ObjectOutputStream oos; // 생성자 값 초기화값만 됨(get을 줘도 null로 나옴)
private Vector<String> userName; // Client가 처음 접속할 때 접속되어 있는 User의 이름을 받아올 때 사용할 변수


// Client의 상태를 나타낼 때 사용 될 상수
public static final int FIRST_CONNECTION = 0; // 접속상태
public static final int DISCONNECTION =-1; // 종료상태
public static final int CHAT_MESSAGE=1; // 메시지 전달상태
public static final int CHAT_WHISPER=2; // 귓말상태

public Data() { //소스에서 제일 마지막 
	super();
	
}

public Data(String name, String message, int state, ObjectOutputStream oos) {
	this.name = name;
	this.message = message;
	this.state = state;
	this.oos = oos;
}
public Data(String name, String message, int state) {

	this(name, message, state, null);
}


public Data(String name, String receiver, String message, int state) {
	super();
	this.name = name;
	this.receiver = receiver;
	this.message = message;
	this.state = state;}

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getReceiver() {
	return receiver;
}
public void setReceiver(String receiver) {
	this.receiver = receiver;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public int getState() {
	return state;
}
public void setState(int state) {
	this.state = state;
}
public ObjectOutputStream getOos() {
	return oos;
}
public void setOos(ObjectOutputStream oos) {
	this.oos = oos;
}
public Vector<String> getUserName() {
	return this.userName;
}
public void setUserName(Vector<String> v) {
	this.userName = v;
}

}
```

**4\. ConfirmDialog : Action 에 대한 리턴 값 확인**

```
package com.client;

//GUI 제공
import java.io.*;
import java.awt.*;
import java.awt.event.*;

public class ConfirmDialog extends Dialog implements ActionListener {
	
	private Button b_ok;
	private Button b_cancel;
	private Panel p;
	private Label l;
	private ChatClient parent;
	private Frame frame;

	public ConfirmDialog(ChatClient parent, Frame frame, String title, boolean modal, String msg) {
		super(frame, title, modal);
		this.parent = parent;
		this.frame = frame;
		setLayout(new GridLayout(2, 1));
		b_ok = new Button("    OK    ");
		b_cancel = new Button("Cancel");
		p = new Panel();
		l = new Label(msg, Label.CENTER);
	}

	public void launchFrame() {
		p.add(b_ok);
		p.add(b_cancel);
		add(l);
		add(p);
		addListener();
		setSize(180, 90);
		Point p = frame.getLocation();
		setLocation(p.x + frame.getWidth() / 2 - getWidth() / 2, p.y + frame.getHeight() / 2 - getHeight() / 2);
		setVisible(true);
	}

	private void addListener() {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				dispose();
			}
		});
		b_ok.addActionListener(this);
		b_cancel.addActionListener(this);
	}

	public void actionPerformed(ActionEvent ae) {
		String command = ae.getActionCommand().trim();
		if (command.equals("OK")) {
			try {
				parent.oos.writeObject(new Data(parent.userName, "님이 접속종료하셨습니다 !!!!! ", Data.DISCONNECTION));
			} catch (IOException e1) {
				System.err.println("종료중 IOExcpetion이 발생하였습니다.");
			}
			System.exit(0);
		} else {
			dispose();
		} // else
	}// actionPerformed
}// class
```

**5.  ChatClient : Client 진입점**

```
package com.client;
//제공

import java.io.*;
import java.net.*;
import java.util.Vector;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ChatClient implements ActionListener, Runnable, ItemListener {

	private Frame frame;
	private TextArea output;
	private TextField input;
	private Button sendButton;
	private Button quitButton;
	private List userList;
	private Label userCount;

	//private final String serverName = "192.168.228.40";
	private final String serverName = "127.0.0.1";// "127.0.0.1"
	private final int PORT = 5555; // 각자 포트 다르게 주면됨
	String userName;
	ObjectInputStream ois;
	ObjectOutputStream oos;
	private Thread listener;
	private boolean flag;

	private Socket socket;
	private Data d;

	public ChatClient(String userName) { 
		this.userName = userName;

		output = new TextArea(10, 50);
		input = new TextField(50);
		sendButton = new Button("Whisper");
		quitButton = new Button("Quit");
		userList = new List(5, false);
		userCount = new Label("", Label.CENTER);

	}

	public void launchFrame() {
		frame = new Frame("Chat Room");
		ImageIcon i = new ImageIcon("images/icon.gif");
		frame.setIconImage(i.getImage());
		frame.setLayout(new BorderLayout());
		frame.add(output, BorderLayout.WEST);
		frame.add(input, BorderLayout.SOUTH);

		Panel p1 = new Panel(new BorderLayout());
		Panel p1_north = new Panel();
		p1_north.add(sendButton);
		p1_north.add(quitButton);
		p1.add("North", p1_north);
		p1.add("Center", userList);
		p1.add("South", userCount);
		frame.add(p1, BorderLayout.CENTER);
		// 챗에 메시지를 입력하고 엔터를 누르면 textArea로 표시한다.
		input.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String message = input.getText();
				copyText(message, Data.CHAT_MESSAGE);
			}
		});

		addListener(); //user_method 
		sendButton.addActionListener(this);
		quitButton.addActionListener(this);
		frame.setSize(505, 220);
		frame.setResizable(false);
		// 전체창을 띄웠을 때 가운데로감
		Dimension d = frame.getToolkit().getScreenSize(); // Dimension - 전체창 
		frame.setLocation(d.width / 2 - frame.getWidth() / 2, d.height / 2 - frame.getHeight() / 2); //가로, 세로
		frame.setVisible(true);
		start();
	}

	public void addListener() { //현재 자기객체가 추가된다, (위스퍼 밑의 창 추가)
		userList.addItemListener(this);
	}

	public void start() { //user_method - 중요!
		try {
			socket = new Socket(serverName, PORT); //클라이언트 생성
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());

			Data d = new Data(userName, "님이 접속하였습니다 !!!!! ", Data.FIRST_CONNECTION);
			oos.writeObject(d);
			System.out.println("Server에 접속!!");
		} catch (IOException e) {
			e.printStackTrace();
		}

		listener = new Thread(this); //쓰레드를 상속받지 않은이유는 자기자신이 쓰레드이기 때문이다
		listener.start(); // run()호출 

	}// end start

	public void run() { //thread 실행 - 중요!
		while (!flag) {
			try {
				d = (Data) ois.readObject();
			} catch (IOException e) {
				System.err.println("run method IOException");
				try {
					oos.close();
					ois.close();
				} catch (IOException ioe) {
					ioe.printStackTrace();
				}
				flag = true;
			} catch (ClassNotFoundException e1) {
				System.err.println("Data class NotFound");
			}
			int state = d.getState();
			String name = d.getName();
			System.out.println("name : " + name);

			switch (state) {
			case Data.FIRST_CONNECTION: // 보라색 상태값임! 4개밖에없네~~? 

//				java.util.Vector UserName = d.getUserName();
//				userList.removeAll(); // 위스퍼 밑에 userlist를 먼저 지우고! , private확인하면 userlist는 list객체라는걸 확인할 수 있어
//				for (int i = 0; i < UserName.size(); i++) {
//					userList.add(((String) (UserName.elementAt(i))).trim());
//				}
//				userCount.setText("현재 " + userList.getItemCount() + "명 접속");
//				output.append("[ " + name + " ]" + d.getMessage() + "\n");
//				break;

				
				// Vector로 Stirng 객체로 바꾸면 간촐하다. 위 주석코드와 같은경우임
				Vector<String> UserName = d.getUserName();
				userList.removeAll(); 
				
				for(String res : UserName) {
					userList.add(res.trim()); //공백제거 주는이유는 나도모르게 띄워쓰기 할까봥!
				}
				
				userCount.setText("현재 " + userList.getItemCount() + "명 접속");
				output.append("[ " + name + " ]" + d.getMessage() + "\n");
				break;
				
				
			case Data.DISCONNECTION:
				userList.remove(name);
				userCount.setText("현재 " + userList.getItemCount() + "명 접속");
				output.append("[ " + name + " ]" + d.getMessage() + "\n");
				break;

			case Data.CHAT_MESSAGE:
				output.append("[ " + name + " ]" + d.getMessage() + "\n");
				break;
			case Data.CHAT_WHISPER:
				output.append("[ " + name + " ] (귓말) " + d.getMessage() + "\n");
				break;

			default:
				System.out.println("error");

			}// switch
		} // while
		try {
			ois.close();
		} catch (IOException e) {
			System.err.println(" ChatClientThread에의 ObjectOutputStream을 Close하는 중에 IOException이 발생하였습니다.");
		} // catch
	}// run

	private void copyText(String message, int state) {
		try {
			oos.writeObject(new Data(userName, message, state));
			input.setText("");
			input.requestFocus();
		} catch (IOException e2) {
			System.err.println("대화중 IOException이 발생하였습니다 ");
		}
	}

	private void whisper(String message, String receiver, int state) {
		try {
			oos.writeObject(new Data(userName, receiver, message, state));
			input.setText("");
			input.requestFocus();
		} catch (IOException e) {
			System.err.println("귓말 보내기중 IOException이 발생하였습니다 ");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		char action = e.getActionCommand().trim().charAt(0);
		switch (action) {

		case 'W':
			String whisper_message = input.getText();
			String receiver = userList.getSelectedItem();
			whisper(whisper_message, receiver, Data.CHAT_WHISPER);
			break;
		case 'Q':
			ConfirmDialog a = new ConfirmDialog(this, frame, "창", true, "정말 닫을 까?");
			a.launchFrame();
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		String name = userList.getSelectedItem();
		input.setText("(" + name + " 에게 귓말) ");
		input.requestFocus();
	}
}
```

**6\. MainLogin : JFrame 을 이용 한 GUI 창 및 main (실행, 진입점)**

```
package com.client;
//GUI 제공
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;

public class MainLogin extends JFrame implements ActionListener {

	JLabel lb1, lb2;
	JTextField txtid;
	JPasswordField txtpwd;
	JPanel p1, p2, p3;
	JButton b1, b2;

	public MainLogin() {
		super("Java Chatting");
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();

		ImageIcon password1 = new ImageIcon("images/password.gif");
		ImageIcon id2 = new ImageIcon("images/id.gif");
		JPanel p4 = new JPanel(new BorderLayout());
		JPanel p5 = new JPanel();

		ImageIcon join = new ImageIcon("images/join.gif");
		ImageIcon exit = new ImageIcon("images/exit.gif");
		ImageIcon title = new ImageIcon("images/icon.gif");

		setIconImage(title.getImage());

		lb1 = new JLabel(id2);
		lb2 = new JLabel(password1);
		txtid = new JTextField(6);
		txtpwd = new JPasswordField(6);
		b1 = new JButton(join);
		b2 = new JButton(exit);

		Border line = BorderFactory.createRaisedBevelBorder();
		Border line2 = BorderFactory.createLineBorder(Color.gray, 1);
		ImageIcon mainicon = new ImageIcon("images/main.gif");
		JLabel jmain = new JLabel(mainicon);

		jmain.setBorder(line);
		b1.setBorder(line2);
		b2.setBorder(line2);

		p4.add(p1, BorderLayout.NORTH);
		p4.add(p2, BorderLayout.CENTER);
		p4.add(p3, BorderLayout.SOUTH);
		getContentPane().add(p4, BorderLayout.SOUTH);
		getContentPane().add(p5, BorderLayout.CENTER);
		p5.add(jmain);
		p1.add(lb1);
		p1.add(txtid);
		p2.add(lb2);
		p2.add(txtpwd);
		p3.add(b1);
		p3.add(b2);

		b1.addActionListener(this);
		b2.addActionListener(this);
		pack();
		Dimension d = getToolkit().getScreenSize();
		setLocation(d.width / 2 - getWidth() / 2, d.height / 2 - getHeight()
				/ 2);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b2) {
			System.exit(0);
		} else if (e.getSource() == b1) {
			String id = txtid.getText();
			dispose();
			ChatClient client = new ChatClient(id); // 클라이언트창!
			client.launchFrame();
		}// end else
	}

	public static void main(String args[]) {
		MainLogin ml = new MainLogin();
		ml.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});

		ml.setResizable(false);
	}
}
```
