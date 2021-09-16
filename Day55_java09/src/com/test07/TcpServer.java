package com.test07;

import java.io.*;
import java.net.*;

//  socket  <-> serversocket // server ����������� tcpserver�� �����, socket������� tcp client�� ����ٰ��Ѵ�.
// tcpclient    tcpserver // socket�� ����� ip, port �����ȴ�. ������ ���ÿ� client�� ����Ǹ� accept()�޼��带 �� �޾� ��ΰ� �����ȴ�. 
// accept�� �ؼ� ��θ� �̿��� ��������°� socket ! socket - getOutputstream(), getInputstream() : �����͸� ����� 

// �������� ���ڽ�,, Ŭ���̾�Ʈ�� ����
public class TcpServer {
public static void main(String[] args) {
	ServerSocket server = null;
	Socket service = null;
	DataOutputStream oos = null;
	OutputStream ops = null;
			
	try {
		server = new ServerSocket(9090);
		System.out.println("Ŭ���̾�Ʈ�� ������ ��ٸ���. ");
			while(true) {
				service = server.accept();
				System.out.println("Ŭ���̾�Ʈ�� ���Ӊ��");
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
 