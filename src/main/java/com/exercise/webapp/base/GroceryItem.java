package com.exercise.webapp.base;

/**
 * 
 * This is a GroceryItem class that represents a generic item in a Grocery store.
 * This makes it easy to add a new type by writing a new builder.
 *
 * @author arao
 */
public class GroceryItem {
	
	private String name;
	private long id;
	private ItemInfo itemInfo;
	private Sales sales;
	private Internal internal;
	
	public GroceryItem(String name, long id, ItemInfo info, Sales sales, Internal internal) {
		this.name = name;
		this.id = id;
		this.itemInfo = info;
		this.sales = sales;
		this.internal = internal;
	}

	public String getName() {
		return name;
	}

	public long getId() {
		return id;
	}

	public ItemInfo getItemInfo() {
		return itemInfo;
	}

	public Sales getSales() {
		return sales;
	}

	public Internal getInternal() {
		return internal;
	}
	
	// TODO: rename fields?? they are very non descriptive
	
}