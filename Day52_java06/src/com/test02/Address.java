package com.test02;

import java.io.Serializable;

public class Address implements Serializable{ //�� ����ȭ�� �� �ʿ��ϴ�.


		private String name;
		private String addr;
		private String tel;
		
		public Address() {
			
		}
		
		public Address(String name, String addr, String tel) {
			this.name = name;
			this.addr = addr;
			this.tel = tel;
		}
		
		@Override
		public String toString() {
			String str = String.format("%5s %5s %5s\n", name, addr,tel);
			return str;
		}
	}
