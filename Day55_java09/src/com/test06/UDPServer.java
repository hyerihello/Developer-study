package com.test06;
import java.net.*;
import java.io.*;
import java.util.*;

//UDP를 이용하여 Client가 보내는 Data(날짜)를 출력해보자.. (UDP는 각자실행)

public class UDPServer {
	private UDPServer() {} // 추상 class 안에 기본 초기값을 주고싶어서 이 클래스를만든다
	public static UDPServer getInstance() {
		return new UDPServer();
	}
	
	
	public static void main(String[] args) {
		//new UDPServer().service();
		UDPServer ser = UDPServer.getInstance();
		ser.service();
	}
	public void service() {	
		Calendar cal = Calendar.getInstance(); // 초기값을 가진 싱글톤 메서드 , 추상클래스가 생성자로 뉴연산자 사용못하면, 스스로를 생성해서 리턴하는게 싱글톤
		DatagramSocket ds = null;
		try {
			
			ds = new DatagramSocket(9999);
			
			byte [] buff = new byte[1024]; //byte계열의 저장소를 만들자 1024 or 2048
			DatagramPacket dp = new DatagramPacket(buff, buff.length); // UDP로 데이터를 받을 객체를 1024크기로 생성 (현재 서버 비생성상태) ->datagramsorket만듬
			//datagrampacket : 클라이언트(datagramsocket으로 만듬) 와 서버(datagramsocket으로 만듬)간의 stream이 지나다니는 통로! (udp만)
			
			
			// 데이터 받아보자
			ds.receive(dp); // dp를지정
			String str = new String(dp.getData()); // 반대는 setdata
			String s = String.format("받을날짜 : %1$tm %1$te,%1$tY", cal); //연월일을 나타낼때 data 서식임
			System.out.println(s + " : " + str.trim());
			
					
					
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
