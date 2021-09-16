package com.test07;

import java.io.*;
import java.net.*;

public class TcpClient {
	public static void main(String[] args) {
		Socket client = null;
		try {
			client = new Socket("127.0.0.1",9090);
			InputStream is = client.getInputStream();
			DataInputStream dis = new DataInputStream(is);
			String str = dis.readUTF();
			System.out.println("�������� ������ :" + str);
			dis.close();
			is.close();
			
		} catch (Exception e) {
			System.err.println(e);
		}finally {
			try {
				client.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	} //  console â�̵ΰ��� 
	 // server : Ŭ���̾�Ʈ�� ������ ��ٸ���. Ŭ���̾�Ʈ�� ���Ӊ��
	 // client : �������� ������ :Hello java.net

}
