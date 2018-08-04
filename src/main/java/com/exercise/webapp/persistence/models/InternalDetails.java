package com.exercise.webapp.persistence.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class InternalDetails {

	@Id
	@GeneratedValue
	private int internalId;
	
	private int aisle;
	private int timesSoldToday;
	private int timesSoldYesterday;
	
//	@JoinColumn(name="id")
//	private GroceryItem item;

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

//	public GroceryItem getItem() {
//		return item;
//	}
//
//	public void setItem(GroceryItem item) {
//		this.item = item;
//	}

	public InternalDetails(int aisle, int timesSoldToday, int timesSoldYesterday, GroceryItem item) {
		super();
		this.aisle = aisle;
		this.timesSoldToday = timesSoldToday;
		this.timesSoldYesterday = timesSoldYesterday;
		//this.item = item;
	}
}
