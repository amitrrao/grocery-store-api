package com.exercise.webapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercise.webapp.base.CheckoutItem;
import com.exercise.webapp.data.TestData;
import com.exercise.webapp.persistence.models.GroceryItem;
import com.exercise.webapp.persistence.models.SaleItem;
import com.exercise.webapp.repository.GroceryItemRepository;
import com.exercise.webapp.repository.SaleItemRepository;

@Service
public class GroceryItemService {

	@Autowired
	private GroceryItemRepository groceryItemRepository;
	
	@Autowired
	private SaleItemRepository saleItemRepository;
	
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
	// TODO: add comments
	
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
	
	public List<SaleItem> findSuperSaverItems() {
		List<SaleItem> superSaverSaleItems = saleItemRepository.findByPrice();
		return superSaverSaleItems;
	}
	private float calculateItemPrice(float price, float discount) {
		// TODO: is it better to use Float and use sum/subtract instead of price - discount?
		return (discount > price) ? 0 : price - discount;
	}
	public void addGroceryItem(GroceryItem item) {
		List<GroceryItem> listOfItems = TestData.getGroceryItemTestData();
		saveGroceryItems(listOfItems);
	}
	
	public void saveGroceryItems(List<GroceryItem> items) {
		groceryItemRepository.save(items);
	}

	public void moveItemsToSuperSavingsAisle() {
		List<GroceryItem> groceryItems = new ArrayList<>();
		List<SaleItem> superSaverItems = findSuperSaverItems();
		for (SaleItem superSaverItem : superSaverItems) {
			GroceryItem gi = superSaverItem.getGroceryItem();
			gi.getInternalDetails().setAisle(15); // TODO: move 15 to static value
			groceryItems.add(gi);
		}
		saveGroceryItems(groceryItems);
	}
}
