package com.exercise.webapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercise.webapp.base.CheckoutItem;
import com.exercise.webapp.data.TestData;
import com.exercise.webapp.persistence.models.GroceryItem;
import com.exercise.webapp.persistence.models.InternalDetails;
import com.exercise.webapp.persistence.models.SaleItem;
import com.exercise.webapp.repository.GroceryItemRepository;

@Service
public class GroceryItemService {

	@Autowired
	private GroceryItemRepository groceryItemRepository;
	
	public List<GroceryItem> getAllGroceryItems() {
		System.out.println("**********Getting all grocery items**********");
		
		List<GroceryItem> groceryItems = new ArrayList<>();
		groceryItemRepository.findAll()
		.forEach(groceryItems::add);
		
		System.out.println("Grocery items found: ");
		for(GroceryItem gc: groceryItems) {
			System.out.println(gc.getDescription());
		}
		return groceryItems;
	}
	
	//TODO: Float v/s float
	public float checkout(List<CheckoutItem> checkoutItems) {
		float total = 0;
		for(CheckoutItem checkoutItem : checkoutItems) {
			GroceryItem groceryItem = groceryItemRepository.findOne(checkoutItem.getId());
			total += calculateItemPrice(groceryItem.getSaleItem().getPrice(), 
					groceryItem.getSaleItem().getDiscount()) * checkoutItem.getQuantity();
		}
		return total;
	}
	
	private float calculateItemPrice(float price, float discount) {
		// TODO: is it better to use Float and use sum/subtract instead of price - discount?
		return (discount > price) ? 0 : price - discount;
	}
	public void addGroceryItem(GroceryItem item) {
		List<GroceryItem> listOfItems = TestData.getGroceryItemTestData();
		groceryItemRepository.save(listOfItems);
	}
}
