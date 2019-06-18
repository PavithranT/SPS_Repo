package com.demo;

import org.springframework.stereotype.Component;

@Component

public class Laptop {
	Laptop(){
		System.out.println("laptop is been called");
	}
	
	private String brand;
	private String config;
	
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getConfig() {
		return config;
	}

	public void setConfig(String config) {
		this.config = config;
	}
	
}
