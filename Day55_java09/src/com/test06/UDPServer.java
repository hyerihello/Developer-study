package com.test06;
import java.net.*;
import java.io.*;
import java.util.*;

//UDP�� �̿��Ͽ� Client�� ������ Data(��¥)�� ����غ���.. (UDP�� ���ڽ���)

public class UDPServer {
	private UDPServer() {} // �߻� class �ȿ� �⺻ �ʱⰪ�� �ְ�; �� Ŭ�����������
	public static UDPServer getInstance() {
		return new UDPServer();
	}
	
	
	public static void main(String[] args) {
		//new UDPServer().service();
		UDPServer ser = UDPServer.getInstance();
		ser.service();
	}
	public void service() {	
		Calendar cal = Calendar.getInstance(); // �ʱⰪ�� ���� �̱��� �޼��� , �߻�Ŭ������ �����ڷ� �������� �����ϸ�, �����θ� �����ؼ� �����ϴ°� �̱���
		DatagramSocket ds = null;
		try {
			
			ds = new DatagramSocket(9999);
			
			byte [] buff = new byte[1024]; //byte�迭�� ����Ҹ� ������ 1024 or 2048
			DatagramPacket dp = new DatagramPacket(buff, buff.length); // UDP�� �����͸� ���� ��ü�� 1024ũ��� ���� (���� ���� ���������) ->datagramsorket����
			//datagrampacket : Ŭ���̾�Ʈ(datagramsocket���� ����) �� ����(datagramsocket���� ����)���� stream�� �����ٴϴ� ���! (udp��)
			
			
			// ������ �޾ƺ���
			ds.receive(dp); // dp������
			String str = new String(dp.getData()); // �ݴ�� setdata
			String s = String.format("������¥ : %1$tm %1$te,%1$tY", cal); //�������� ��Ÿ���� data ������
			System.out.println(s + " : " + str.trim());
			
					
					
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
