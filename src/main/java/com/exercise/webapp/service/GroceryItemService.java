package com.exercise.webapp.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.exercise.webapp.exceptions.ItemNotFoundException;
import com.exercise.webapp.base.CheckoutItem;
import com.exercise.webapp.persistence.models.GroceryItem;
import com.exercise.webapp.persistence.models.SaleItem;
import com.exercise.webapp.repository.GroceryItemRepository;
import com.exercise.webapp.repository.SaleItemRepository;

/**
 * 
 * GroceryItemService is a service class that implements basic CRUD operations on grocery items.
 * These methods are invoked from a controller.
 * Currently all the data comes from a pre-populated database with test data.
 * 
 * @author arao
 */
@Service
public class GroceryItemService {
	private static final Logger logger = LoggerFactory.getLogger(GroceryItemService.class);
	
	@Autowired
	private GroceryItemRepository groceryItemRepository;
	
	@Autowired
	private SaleItemRepository saleItemRepository;
	
	/***
	 * A method to get all grocery items.
	 * 
	 * @return A list of all GroceryItem instances.
	 */
	public List<GroceryItem> getAllGroceryItems() {
		logger.info(String.format("Getting all items from the grocery store."));
		List<GroceryItem> groceryItems = new ArrayList<>();
		groceryItemRepository.findAll()
		.forEach(groceryItems::add);

		return groceryItems;
	}
	
	/***
	 * A method to get the top two fruits based on sale data.
	 * 
	 * @return Top two fruits sold from last two days.
	 */
	public List<GroceryItem> getTopFruitsSalesData() {
		List<GroceryItem> groceryItems = groceryItemRepository.findSalesDataForFruits(new PageRequest(0, 2)); // TODO: '2' can be a parameter
		
		return groceryItems;
	}
	
	/***
	 * A method to calculate the checkout price for a given order.
	 * 
	 * @param A list of CheckoutItem instances.
	 * @return Total amount of all grocery items.
	 * @throws ItemNotFoundException - If any grocery item was not found in the database.
	 */
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
	
	/***
	 * A helper method to find all grocery items under $1.00.
	 * 
	 * @return A list of SaleItem instances which are under $1.00.
	 */
	private List<SaleItem> findSuperSaverItems() {
		List<SaleItem> superSaverSaleItems = saleItemRepository.findByPrice();
		return superSaverSaleItems;
	}
	
	/***
	 * A helper method to calculate the final cost including the discount for a given item.
	 * 
	 * @param price - The sale price for an item
	 * @param discount - The discount price for that item
	 * 
	 * @return The final cost for a given grocery item.
	 */
	private float calculateItemPrice(float price, float discount) {
		return (discount > price) ? 0 : price - discount;
	}
	
	/***
	 * A helper method to persist a given list of GroceryItem instances to the database.
	 */
	public void saveGroceryItems(List<GroceryItem> items) {
		groceryItemRepository.save(items);
	}

	/***
	 * A method to move all items under $1.00 to aisle 15, a.k.a 'SuperSavings' aisle.
	 * 
	 */
	public String moveItemsToSuperSavingsAisle() {
		List<GroceryItem> groceryItems = new ArrayList<>();
		boolean success = true;
		try {
			List<SaleItem> superSaverItems = findSuperSaverItems();
			int totalItemsMoved = 0;
			int totalItemsNotMoved = 0;
			if(superSaverItems.isEmpty()) {
				logger.info(String.format("No eligible SuperSaver items were found."));
				return "No eligible SuperSaver items were found.";
			}
			for (SaleItem superSaverItem : superSaverItems) {
				GroceryItem gi = superSaverItem.getGroceryItem();
				logger.info(String.format("Found %s on Aisle %d.", gi.getName(), gi.getInternalDetails().getAisle()));
				if (gi.getInternalDetails().getAisle() != 15) {
				gi.getInternalDetails().setAisle(15); // TODO: move 15 to static value
				groceryItems.add(gi);
				++totalItemsMoved;
				logger.info(String.format("Moved %s to Aisle 15.", gi.getName()));
				} else {
					++totalItemsNotMoved;
					logger.info(String.format("Found %s, which is already on Aisle 15. Nothing to move.", gi.getName()));
				}
			}
			if(totalItemsNotMoved == superSaverItems.size()) {
				logger.info(String.format("All eligible items are already on the SuperSavings aisle."));
				return "All eligible items are already on the SuperSavings aisle.";
			}
		
			logger.info(String.format("Total number of grocery items moved: %d", totalItemsMoved));
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
