package com.stackroute.foodapp.model;

public class FoodItem {

	public String itemname;
	public String price;
	
	public FoodItem() {
		
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "FoodItem [itemname=" + itemname + ", price=" + price + "]";
	}
	
}
