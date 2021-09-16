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
			System.out.println("서버에서 보낸것 :" + str);
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
	} //  console 창이두개얌 
	 // server : 클라이언트의 접속을 기다린다. 클라이언트가 접속됬어
	 // client : 서버에서 보낸것 :Hello java.net

}
