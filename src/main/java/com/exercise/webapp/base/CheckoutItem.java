package com.exercise.webapp.base;

public class CheckoutItem {
	private long id;
	private int quantity;
	
	public CheckoutItem() {
		
	}
	public CheckoutItem(long id, int quantity) {
		this.id = id;
		this.quantity = quantity;
	}
	
	public long getId() {
		return id;
	}
	
	public int getQuantity() {
		return quantity;
	}
}
