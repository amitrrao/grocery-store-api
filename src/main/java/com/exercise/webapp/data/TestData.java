package com.exercise.webapp.data;

import java.util.ArrayList;
import java.util.List;

import com.exercise.webapp.persistence.models.GroceryItem;
import com.exercise.webapp.persistence.models.InternalDetails;
import com.exercise.webapp.persistence.models.SaleItem;

/**
 * This class contains all the test data.
 * 
 * @author arao
 *
 */
public class TestData {
	
	public static List<GroceryItem> getGroceryItemTestData() {
		//TODO: create enum for category
		
		List<GroceryItem> items = new ArrayList<>();
		SaleItem saleItem = new SaleItem();
		InternalDetails internalDetails = new InternalDetails();
		GroceryItem item1 = new GroceryItem();
		item1.setId(101);
		item1.setName("Fuji Apples");
		item1.setDescription("Fuji Apples from California");
		item1.setCategory("produce");
		item1.setSaleItem(new SaleItem(10.0f, 2.0f, item1));
		item1.setInternalDetails(new InternalDetails(10, 20, 30, item1));
		items.add(item1);
		
		GroceryItem item2 = new GroceryItem();
		item2.setId(102);
		item2.setName("Mars Chocolate");
		item2.setDescription("Mars Milk Chocolates");
		item2.setCategory("candy");
		item2.setSaleItem(new SaleItem(3.0f, .5f, item2));
		item2.setInternalDetails(new InternalDetails(20, 200, 30, item2));
		items.add(item2);
		
		GroceryItem item3 = new GroceryItem();
		item3.setId(103);
		item3.setName("Roma Tomatoes");
		item3.setDescription("Roma Tomatoes from Mexico");
		item3.setCategory("produce");
		item3.setSaleItem(new SaleItem(1.5f, 0.0f, item3));
		item3.setInternalDetails(new InternalDetails(11, 150, 100, item3));
		items.add(item3);
		
		GroceryItem item4 = new GroceryItem();
		item4.setId(104);
		item4.setName("Almond Cookies");
		item4.setDescription("Fresh Baked Almond Cookies");
		item4.setCategory("bakery");
		item4.setSaleItem(new SaleItem(3.0f, 1.0f, item4));
		item4.setInternalDetails(new InternalDetails(12, 50, 60, item4));
		items.add(item4);
		
		GroceryItem item5 = new GroceryItem();
		item5.setId(105);
		item5.setName("Bic Pens");
		item5.setDescription("Bic Ball Point Pens");
		item5.setCategory("stationary");
		item5.setSaleItem(new SaleItem(0.5f, 0.0f, item5));
		item5.setInternalDetails(new InternalDetails(17, 15, 20, item5));
		items.add(item5);
		
		return items;
	}
}
