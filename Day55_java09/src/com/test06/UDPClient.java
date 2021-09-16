package com.test06;

import java.net.*;
import java.io.*;
import java.util.*;

public class UDPClient {
	public static void main(String[] args) {
		new UDPClient().m_connect();
		
	}
	public void m_connect(){
		Calendar cal = Calendar.getInstance(); 
		DatagramSocket ds = null;
		try {
			ds = new DatagramSocket();
		// 서버에 보낼 데이터를 지정하자.
			String str = String.format("Locak time %tT", Calendar.getInstance()).trim(); //%tT" : 시간을 리턴
			byte[] buff = str.getBytes();
			
			DatagramPacket dp = new DatagramPacket(buff, buff.length, InetAddress.getByName("127.0.0.1"), 9999);
			ds.send(dp);
			System.out.println("보낸 메시지 확인 : " + str);
			
		} catch(Exception e) {
	
	} finally {
		
	}   // 무조건 서버를 먼저돌려라 그리고 클라이언트를 돌려! 서버는 가만히있어 빙글빙글돌아~~~ 그사이에 클라이언트실행해
		// 창이 두개야 console 확인하자! <받을날짜 : 07 5,2021 : Locak time 16:26:50 , 보낸 메시지 확인 : Locak time 16:26:50>
		
}
}
