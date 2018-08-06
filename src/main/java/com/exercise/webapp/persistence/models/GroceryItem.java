package com.exercise.webapp.persistence.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="GROCERY_ITEM")
public class GroceryItem {
	
	@Id
	@Column(name="GROCERY_ITEM_ID")
	private long id;
	private String name;
	private String description;
	private String category;
	
	@OneToOne(fetch = FetchType.LAZY,mappedBy="groceryItem",
			cascade = CascadeType.ALL, orphanRemoval = true)
	private SaleItem saleItem;
	@OneToOne(fetch = FetchType.LAZY,mappedBy="groceryItem", 
			cascade = CascadeType.ALL, orphanRemoval = true)
	private InternalDetails internalDetails;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	public SaleItem getSaleItem() {
		return saleItem;
	}
	public void setSaleItem(SaleItem saleItem) {
		this.saleItem = saleItem;
	}
	public InternalDetails getInternalDetails() {
		return internalDetails;
	}
	public void setInternalDetails(InternalDetails internalDetails) {
		this.internalDetails = internalDetails;
	}
	
	public GroceryItem() {
		
	}
	
	public GroceryItem(long id, String name, String description, String category, SaleItem saleItem,
			InternalDetails internalDetails) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.category = category;
		this.saleItem = saleItem;
		this.internalDetails = internalDetails;
	}
}
