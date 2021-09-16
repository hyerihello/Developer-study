package com.test04;

import java.net.*;

public class NetTest01 {
	public static void main(String[] args) {
		
	
	URI u;
	try{
		u = new URI("http://www.naver.com");
		
		System.out.println(u.getScheme());
		System.out.println(u.getUserInfo());
		System.out.println(u.getHost());
		System.out.println(u.getPort());
		System.out.println(u.getPath());
		System.out.println(u.getQuery());
		System.out.println(u.getFragment());
		System.out.println(u.toString());
		System.out.println(u.toURL());
	}catch(URISyntaxException | MalformedURLException e) {
e.printStackTrace();
	}
	}
}
