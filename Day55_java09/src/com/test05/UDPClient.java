package com.test05;

import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient { //�������ִ� ����ȣ��Ʈ�� ��Ʈ�� ����Ǹ� �ٴ´�. udpserver������ ���ư���.
	
	public static void main(String[] args) {
		System.out.println("UDPClient ��");
		DatagramSocket d_client = null;
		try {
			d_client = new DatagramSocket();
			d_client.connect(InetAddress.getByName("127.0.0.1"),8787); //������ ip�� port�� ��������� �ٰ� port ��ȣ �������
			System.out.println(d_client.isBound());
			if(d_client.isConnected()) {
				System.out.println("�����߾�");
			}else{
				System.out.println("�ƴ��ݾ�");
			}
		} catch (Exception e) {
			
		}
	}
}
