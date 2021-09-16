package com.test04;
import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;

// Class InetAddress

public class NetTest03 {

	public static void main(String[] args) {
		// static InetAddress	getAllByName(String host) - Method (생성자없네? 메서드로 가져다쓰면 되나보다~~~)
		
		try {
			InetAddress[] iar = InetAddress.getAllByName("www.naver.com"); //-main server ip
            for(InetAddress res : iar) {
            	System.out.println(res.getHostAddress());
            	System.out.println(res.getHostName());
            	
            }		
		} catch (UnknownHostException e) {
			
			e.printStackTrace();
		}
		
		
	}
}
