package com.exercise.webapp.persistence.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="INTERNAL_DETAILS")
public class InternalDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int internalId;
	
	private int aisle;
	private int timesSoldToday;
	private int timesSoldYesterday;
	
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name = "GROCERY_ITEM_ID")
	private GroceryItem groceryItem;

	public int getInternalId() {
		return internalId;
	}

	public void setInternalId(int internalId) {
		this.internalId = internalId;
	}

	public int getAisle() {
		return aisle;
	}

	public void setAisle(int aisle) {
		this.aisle = aisle;
	}

	public int getTimesSoldToday() {
		return timesSoldToday;
	}

	public void setTimesSoldToday(int timesSoldToday) {
		this.timesSoldToday = timesSoldToday;
	}

	public int getTimesSoldYesterday() {
		return timesSoldYesterday;
	}

	public void setTimesSoldYesterday(int timesSoldYesterday) {
		this.timesSoldYesterday = timesSoldYesterday;
	}

	public GroceryItem getItem() {
		return groceryItem;
	}

	public void setItem(GroceryItem item) {
		this.groceryItem = item;
	}

	public InternalDetails() {
		
	}
	public InternalDetails(int aisle, int timesSoldToday, int timesSoldYesterday, GroceryItem item) {
		super();
		this.aisle = aisle;
		this.timesSoldToday = timesSoldToday;
		this.timesSoldYesterday = timesSoldYesterday;
		this.groceryItem = item;
	}
}
