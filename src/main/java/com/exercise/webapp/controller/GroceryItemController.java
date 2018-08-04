package com.exercise.webapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.exercise.webapp.builder.GroceryItemBuilder;
import com.exercise.webapp.persistence.models.GroceryItem;
import com.exercise.webapp.service.GroceryItemService;

@RestController
public class GroceryItemController {
	private static final Logger logger = LoggerFactory.getLogger(GroceryItemController.class);
	
	@Autowired
	private GroceryItemService itemService;
	
	@RequestMapping("/groceryitems")
	public List<com.exercise.webapp.base.GroceryItem> getAllItems() {
		System.out.println("******grocery item controller getting****");
		return convert(itemService.getAllGroceryItems());
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/groceryitems")
	public void addItem(@RequestBody GroceryItem item) {
		System.out.println("******grocery item controller posting*****");
		itemService.addGroceryItem(item);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/hello")
	public String sayHi() {
		return "Hi There, Welcome to the Apple Grocery Store!!";
	}
	
	private List<com.exercise.webapp.base.GroceryItem> convert(List<GroceryItem> items) {
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
		return returnItems;
		
	}
}
