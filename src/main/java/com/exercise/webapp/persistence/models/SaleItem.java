package com.exercise.webapp.persistence.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="SALE_ITEM")
public class SaleItem {

	@Id
	@GeneratedValue
	private int saleItemId;
	private Float price;
	private Float discount;
	
	@OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "GROCERY_ITEM_ID")
	private GroceryItem groceryItem;
	
	public int getSaleItemId() {
		return saleItemId;
	}

	public void setSaleItemId(int saleItemId) {
		this.saleItemId = saleItemId;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name="id")
	public GroceryItem getGroceryItem() {
		return groceryItem;
	}

	public void setGroceryItem(GroceryItem item) {
		this.groceryItem = item;
	}
	
	public Float getDiscount() {
		return discount;
	}

	public void setDiscount(Float discount) {
		this.discount = discount;
	}

	public SaleItem() {}
	public SaleItem(Float price, Float discount, GroceryItem item) {
		super();
		this.price = price;
		this.discount = discount;
		this.groceryItem = item;
	}
}
