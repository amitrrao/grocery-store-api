package com.exercise.webapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.exercise.webapp.base.CheckoutItem;
import com.exercise.webapp.builder.GroceryItemBuilder;
import com.exercise.webapp.persistence.models.GroceryItem;
import com.exercise.webapp.service.GroceryItemService;

@RestController
public class GroceryItemController implements ErrorController {
	private static final Logger logger = LoggerFactory.getLogger(GroceryItemController.class);
	private static final String INVALID_PATH = "/error";
	
	@Autowired
	private GroceryItemService itemService;
	
	@RequestMapping(method=RequestMethod.GET, value="/groceryitems")
	public List<com.exercise.webapp.base.GroceryItem> getAllItems() {
		return serializeGroceryItem(itemService.getAllGroceryItems());
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/groceryitems")
	public void addItem(@RequestBody GroceryItem item) {
		itemService.addGroceryItem(item);
	}
	
	// TODO: should it be a get or a post?
	@RequestMapping(method=RequestMethod.POST, value="/groceryitems/checkout")
	public Float checkout(@RequestBody List<CheckoutItem> checkoutItems) {
		return itemService.checkout(checkoutItems);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/groceryitems/moveItemsToSuperSavingsAisle")
	public String moveItemsToSuperSavingsAisle() {
		return itemService.moveItemsToSuperSavingsAisle();
	}
	

//	@RequestMapping(method=RequestMethod.GET, value="/groceryitems/topFruitsSalesData")
//	public List<com.exercise.webapp.base.GroceryItem> getTopFruitsSalesData() {
//		itemService.addGroceryItem(null);
//		return (convert(itemService.getTopFruitsSalesData()));
//	}
	
	@RequestMapping(method=RequestMethod.GET, value="/hello")
	public String sayHi() {
		return "Hi There, Welcome to the Apple Grocery Store!!";
	}
	
	@RequestMapping(value = INVALID_PATH)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public String error() {
		logger.warn("Invalid URL endpoint requested.");
        return "Sorry, this is not a valid REST endpoint.";
    }
	
	@Override
	public String getErrorPath() {
		return INVALID_PATH;
	}
	
	private List<com.exercise.webapp.base.GroceryItem> serializeGroceryItem(List<GroceryItem> items) {
		List<com.exercise.webapp.base.GroceryItem> returnItems = new ArrayList<>();
		for(GroceryItem item: items) {
		com.exercise.webapp.base.GroceryItem returnItem =
				new GroceryItemBuilder(item.getName(), 
						item.getId(), 
						item.getDescription(), 
						item.getCategory(), item.getSaleItem().getPrice(), 
						item.getSaleItem().getDiscount(), 
						item.getInternalDetails().getAisle(),
						item.getInternalDetails().getTimesSoldToday(),
						item.getInternalDetails().getTimesSoldYesterday()).build();
		returnItems.add(returnItem);
		}
		logger.info(String.format("Total number of Grocery Items: %d", items.size()));
		return returnItems;	
	}
}
