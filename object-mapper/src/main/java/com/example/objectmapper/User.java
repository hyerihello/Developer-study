package com.example.objectmapper;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
	
	private String name;
	private int age;
	
	@JsonProperty("phone_number")
	private String phoneNumber;
	
	// 기본생성자 
	public User(String name, int age, String phonenumber) {
		this.name = name;
		this.age = age;
		this.phoneNumber = phonenumber;
	}
	
	//디폴드생성자 추가 
	public User() {
		this.name = null;
		this.age = 0;
		this.phoneNumber = null;
	}
	
	// getter 추가 
	public String getName() {
		return name;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}

	public int getAge() {
		return age;
	}

	
	public User defaultUser() {
		return new User("default", 30, "010-111-2222");
	}
	
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", phoneNumber=" + phoneNumber + "]";
	}




}
