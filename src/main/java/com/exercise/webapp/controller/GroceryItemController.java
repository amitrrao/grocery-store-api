package com.exercise.webapp.controller;

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

import com.exercise.webapp.exceptions.ItemNotFoundException;
import com.exercise.webapp.GroceryStoreApplication;
import com.exercise.webapp.base.CheckoutItem;
import com.exercise.webapp.service.GroceryItemService;

/**
 * 
 * This is a GroceryItem Controller class that maps incoming REST calls to appropriate service methods.
 * It injects singletons for the service instance and calls methods on them based on the request mapping.
 * 
 * @author arao
 */
@RestController
public class GroceryItemController implements ErrorController {
	private static final Logger logger = LoggerFactory.getLogger(GroceryItemController.class);
	private static final String INVALID_PATH = "/error";
	
	@Autowired
	private GroceryItemService groceryItemService;
	
	@RequestMapping(method=RequestMethod.GET, value="/groceryitems")
	public List<com.exercise.webapp.base.GroceryItem> getAllItems() {
		return GroceryStoreApplication.deserializeGroceryItem(groceryItemService.getAllGroceryItems());
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/groceryitems/checkout")
	public Float checkout(@RequestBody List<CheckoutItem> checkoutItems) throws ItemNotFoundException {
		return groceryItemService.checkout(checkoutItems);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/groceryitems/moveItemsToSuperSavingsAisle")
	public String moveItemsToSuperSavingsAisle() {
		return groceryItemService.moveItemsToSuperSavingsAisle();
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/groceryitems/topFruitsSalesData")
	public List<com.exercise.webapp.base.GroceryItem> getTopFruitsSalesData() {
		return (GroceryStoreApplication.deserializeGroceryItem(groceryItemService.getTopFruitsSalesData()));
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/hello")
	public String sayHi() {
		return "Hi There, Welcome to our Grocery Store!!";
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
}
