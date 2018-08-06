package com.exercise.webapp.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Predicate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercise.webapp.exceptions.ItemNotFoundException;
import com.exercise.webapp.base.CheckoutItem;
import com.exercise.webapp.data.TestData;
import com.exercise.webapp.persistence.models.GroceryItem;
import com.exercise.webapp.persistence.models.SaleItem;
import com.exercise.webapp.repository.GroceryItemRepository;
import com.exercise.webapp.repository.SaleItemRepository;

@Service
public class GroceryItemService {

	private static final Logger logger = LoggerFactory.getLogger(GroceryItemService.class);
	
	@Autowired
	private GroceryItemRepository groceryItemRepository;
	
	@Autowired
	private SaleItemRepository saleItemRepository;
	
	public List<GroceryItem> getAllGroceryItems() {
		logger.info(String.format("**********Getting all items from the grocery store**********"));
		List<GroceryItem> groceryItems = new ArrayList<>();
		groceryItemRepository.findAll()
		.forEach(groceryItems::add);

		return groceryItems;
	}
	
	public List<GroceryItem> getTopFruitsSalesData() {
		System.out.println("*********getting fruits sales data********");
		
		List<GroceryItem> groceryItems = groceryItemRepository.findTest();
		
//		Predicate predicate = 
		return groceryItems;
	}
	// TODO: add comments
	
	public float checkout(List<CheckoutItem> checkoutItems) throws ItemNotFoundException {
		logger.info(String.format("Calculating the total checkout price."));
		float total = 0;
		for(CheckoutItem checkoutItem : checkoutItems) {
			GroceryItem groceryItem = groceryItemRepository.findOne(checkoutItem.getId());
			if (groceryItem == null) {
				logger.error(String.format("Item with id %s not found.", checkoutItem.getId()));
				throw new ItemNotFoundException(String.format("Item with id %s not found.", checkoutItem.getId()));
			}
			total += calculateItemPrice(groceryItem.getSaleItem().getPrice(), 
					groceryItem.getSaleItem().getDiscount()) * checkoutItem.getQuantity();
		}
		logger.info(String.format("Total checkout price for this order is: %f", total));
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

	public String moveItemsToSuperSavingsAisle() {
		List<GroceryItem> groceryItems = new ArrayList<>();
		boolean success = true;
		try {
			List<SaleItem> superSaverItems = findSuperSaverItems();
			if(superSaverItems.isEmpty()) {
				logger.info(String.format("No eligible SuperSaver items were found."));
				return "No eligible SuperSaver items were found.";
			}
			for (SaleItem superSaverItem : superSaverItems) {
				GroceryItem gi = superSaverItem.getGroceryItem();
				logger.info(String.format("Found %s on Aisle %d.", gi.getName(), gi.getInternalDetails().getAisle()));
				gi.getInternalDetails().setAisle(15); // TODO: move 15 to static value
				groceryItems.add(gi);
				logger.info(String.format("Moved %s to Aisle 15.", gi.getName()));
			}
			logger.info(String.format("Total number of grocery items moved: %d", superSaverItems.size()));
			saveGroceryItems(groceryItems);
		} catch (Exception e) {
			success = false;
			logger.error(e.getMessage());
		}
		if (success)
			return "Successfully moved all eligible items to the SuperSavings aisle.";
		return "Something went wrong while moving items to the SuperSavings aisle.";
	}
}
