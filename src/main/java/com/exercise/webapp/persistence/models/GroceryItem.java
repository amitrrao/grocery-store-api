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
	
	@OneToOne(fetch = FetchType.EAGER,mappedBy="groceryItem",cascade = CascadeType.ALL)
	private SaleItem saleItem;
	
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
	
	//@OneToOne(mappedBy = "groceryItem")
	public SaleItem getSaleItem() {
		return saleItem;
	}
	public void setSaleItem(SaleItem saleItem) {
		this.saleItem = saleItem;
	}
}
