package com.stackroute.foodapp.model;

import org.springframework.beans.factory.annotation.Autowired;

public class Hotel {
	
	public String name;
	public String location;
	
	@Autowired
	public FoodItem item;
	
	public Hotel() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public FoodItem getItem() {
		return item;
	}

	public void setItem(FoodItem item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "Hotel [name=" + name + ", location=" + location + ", item=" + item + "]";
	}
	
}
