package com.test05;

import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient { //열려져있는 로컬호스트에 포트만 연결되면 붙는다. udpserver꺼져도 돌아간다.
	
	public static void main(String[] args) {
		System.out.println("UDPClient 야");
		DatagramSocket d_client = null;
		try {
			d_client = new DatagramSocket();
			d_client.connect(InetAddress.getByName("127.0.0.1"),8787); //지정된 ip에 port만 살아있으면 붙고 port 번호 상관없음
			System.out.println(d_client.isBound());
			if(d_client.isConnected()) {
				System.out.println("연결했어");
			}else{
				System.out.println("아니잖아");
			}
		} catch (Exception e) {
			
		}
	}
}
