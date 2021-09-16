package com.test07;

import java.io.*;
import java.net.*;

//  socket  <-> serversocket // server 소켓을만들면 tcpserver를 만들고, socket을만들면 tcp client를 만든다고한다.
// tcpclient    tcpserver // socket을 만들면 ip, port 생성된다. 생성과 동시에 client가 연결되면 accept()메서드를 를 받아 통로가 생성된다. 
// accept를 해서 통로를 이용해 만들어지는게 socket ! socket - getOutputstream(), getInputstream() : 데이터를 입출력 

// 서버에서 글자써,, 클라이언트로 보내
public class TcpServer {
public static void main(String[] args) {
	ServerSocket server = null;
	Socket service = null;
	DataOutputStream oos = null;
	OutputStream ops = null;
			
	try {
		server = new ServerSocket(9090);
		System.out.println("클라이언트의 접속을 기다린다. ");
			while(true) {
				service = server.accept();
				System.out.println("클라이언트가 접속됬어");
				ops = service.getOutputStream();
				oos = new DataOutputStream(ops);
				oos.writeUTF("Hello java.net");
			}
			
		
	}catch (Exception e) {
		System.out.println(e);
	}finally {
		try {
			oos.close();
			ops.close();
			service.close();
			server.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
	}
			
	
}
}
 