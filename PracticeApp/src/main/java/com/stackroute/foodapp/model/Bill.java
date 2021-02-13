package com.stackroute.foodapp.model;

public class Bill {
	
	public String billno;
	public FoodItem item;
	
	public Bill() {
		
	}

	public String getBillno() {
		return billno;
	}

	public void setBillno(String billno) {
		this.billno = billno;
	}

	public FoodItem getItem() {
		return item;
	}

	public void setItem(FoodItem item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "Bill [billno=" + billno + ", item=" + item + "]";
	}
	
}
