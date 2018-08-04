package com.exercise.webapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercise.webapp.persistence.models.GroceryItem;
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
	
	public void addGroceryItem(GroceryItem item) {
		GroceryItem item1 = new GroceryItem();
		item1.setId(12345);
		item1.setName("Fuji Apples");
		item1.setDescription("Fuji Apples from California");
		item1.setCategory("fruit");
		item1.setSaleItem(new SaleItem(10.0f, 2.0f, item1));
		groceryItemRepository.save(item1);
	}
}
