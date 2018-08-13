package com.exercise.webapp.base;

/**
 * This is a class representing a checkout item. It consists of a GroceryItem id and the quantity.
 * @author arao
 *
 */
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
