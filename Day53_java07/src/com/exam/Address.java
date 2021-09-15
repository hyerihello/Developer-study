package com.exam;

import java.io.Serializable;
// 주소록을 객체단위로 읽고싶군!
// Serializable: 객체단위로 끊어서 보내주는 것
 
public class Address implements Serializable{ //역 직렬화가 꼭 필요하다.

		
		private String addr;
		private String tel;
		
	
		public String getAddr() {
			return addr;
		}

		public void setAddr(String addr) {
			this.addr = addr;
		}

		public String getTel() {
			return tel;
		}

		public void setTel(String tel) {
			this.tel = tel;
		}

		public Address() {
			
		}		
		public Address( String addr, String tel) {
			
			this.addr = addr;
			this.tel = tel;
		}
		
		@Override
		public String toString() {
			String str = String.format("%5s %5s \n", this.getAddr(),this.getTel());
			return str;
		}


	}
