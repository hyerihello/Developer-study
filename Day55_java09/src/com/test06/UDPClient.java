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
		// ������ ���� �����͸� ��������.
			String str = String.format("Locak time %tT", Calendar.getInstance()).trim(); //%tT" : �ð��� ����
			byte[] buff = str.getBytes();
			
			DatagramPacket dp = new DatagramPacket(buff, buff.length, InetAddress.getByName("127.0.0.1"), 9999);
			ds.send(dp);
			System.out.println("���� �޽��� Ȯ�� : " + str);
			
		} catch(Exception e) {
	
	} finally {
		
	}   // ������ ������ ���������� �׸��� Ŭ���̾�Ʈ�� ����! ������ �������־� ���ۺ��۵���~~~ �׻��̿� Ŭ���̾�Ʈ������
		// â�� �ΰ��� console Ȯ������! <������¥ : 07 5,2021 : Locak time 16:26:50 , ���� �޽��� Ȯ�� : Locak time 16:26:50>
		
}
}
