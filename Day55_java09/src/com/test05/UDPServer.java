package com.test05;
import java.net.*;
import java.io.*;

// DatagramSocket(int port) - port���� Socket�̵ȴ�.

public class UDPServer {
	public static void main(String[] args) {
		System.out.println("UDPServer ��");
		//1 ~ 65535 port , but  (80����(localport) / 23, 21 /, 7000) - 8,2,7�� �����ϴ� ��Ʈ�� �������� �ʴ´�
		
		
		DatagramSocket d_server = null;
		try {
			d_server = new DatagramSocket(8787); // ��Ʈ 8787�� ����ϴ� ���� ����
			System.out.println(d_server.getLocalPort());
			//System.out.println(d_server.getInetAddress().getHostAddress()); //null�̴ϱ� �ּ�ó���ߴٰ� ��Ʈ�����Ҷ�
			System.out.println(d_server.getLocalAddress());
			
		} catch (SocketException e) {
			
			e.printStackTrace();
		}
	}
}
