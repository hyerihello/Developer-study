package com.test03;

import java.util.Objects;

public class Car {
	
	private String car_name; // get,set이 필요하다


	public Car(String car_name) { // source - field
		super();
		this.car_name = car_name;
	}
	
	public String getCar_name() {
		return car_name;
	}

	public void setCar_name(String car_name) {
		this.car_name = car_name;
	}
/*
	@Override
	public boolean equals(Object obj) { //obj = c2;
		
		// this.car_name.equals(obj.car_name)
		// c1.car_name.equals(c2.car_name)
		
		Car other = (Car)obj;
		if(this.car_name.equals(other.getCar_name())) {
			return true;
		}
		
		return false;
	}*/

	
	//source hash 및 equals들어가서 확인하기 
	
	@Override
	public int hashCode() {
		return Objects.hash(car_name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Car other = (Car) obj;
		return Objects.equals(car_name, other.car_name);
	}


	
	
	
}
