package com.test05;
import java.net.*;
import java.io.*;

// DatagramSocket(int port) - port열면 Socket이된다.

public class UDPServer {
	public static void main(String[] args) {
		System.out.println("UDPServer 야");
		//1 ~ 65535 port , but  (80번대(localport) / 23, 21 /, 7000) - 8,2,7로 시작하는 포트는 지정하지 않는다
		
		
		DatagramSocket d_server = null;
		try {
			d_server = new DatagramSocket(8787); // 포트 8787을 사용하는 소켓 생성
			System.out.println(d_server.getLocalPort());
			//System.out.println(d_server.getInetAddress().getHostAddress()); //null이니까 주석처리했다가 포트실행할때
			System.out.println(d_server.getLocalAddress());
			
		} catch (SocketException e) {
			
			e.printStackTrace();
		}
	}
}
