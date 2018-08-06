package com.exercise.webapp.builder;

import com.exercise.webapp.base.GroceryItem;
import com.exercise.webapp.base.Internal;
import com.exercise.webapp.base.ItemInfo;
import com.exercise.webapp.base.Sales;
import com.exercise.webapp.base.TimesSold;

public class GroceryItemBuilder implements Builder {
	
	private String name;
	private long id;
	private String description;
	private String category;
	private float price;
	private float discount;
	private int aisle;
	private int timesSoldToday;
	private int timesSoldYesterday;
	
	public GroceryItemBuilder(
			String name, 
			long id, 
			String description, 
			String category, 
			float price, 
			float discount, 
			int aisle,
			int timesSoldToday,
			int timesSoldYesterday) {
		super();
		this.name = name;
		this.id = id;
		this.description = description;
		this.category = category;
		this.price = price;
		this.discount = discount;
		this.aisle = aisle;
		this.timesSoldToday = timesSoldToday;
		this.timesSoldYesterday = timesSoldYesterday;
	}
	
	public GroceryItem build() {
		return new GroceryItem(
				name, 
				id, 
				new ItemInfo.ItemInfoBuilder()
				.withDescription(description)
				.withCategory(category).build(), 
				new Sales.SalesBuilder()
				.withDiscount(discount)
				.withPrice(price)
				.build(), 
				new Internal.InternalBuilder()
				.withAisle(aisle)
				.withTimesSold(new TimesSold.TimesSoldBuilder()
						.withToday(timesSoldToday)
						.withYesterday(timesSoldYesterday).build())
				.build());
	}
}

