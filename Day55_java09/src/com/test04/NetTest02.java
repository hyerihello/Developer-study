package com.test04;
import java.io.IOException;
import java.net.*;
import java.io.*;

//URLConnection 을 이용하여 페이지를 리턴받자.
public class NetTest02 {
	
	
	public static void main(String[] args) {
		BufferedInputStream bis = null;
		try {
			URLConnection ucn = new URL("http://www.google.com").openConnection();
			InputStream is = ucn.getInputStream();
			
			bis = new BufferedInputStream(is);
			int res = 0;
			
			while((res = bis.read()) != -1) {
				System.out.println(res);
			}
				
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		} finally {
			try {
			bis.close();
		}catch (IOException e) {
			e.printStackTrace();
			}
		}
		
	}
}
