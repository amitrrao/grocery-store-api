package com.exercise.webapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.exercise.webapp.persistence.models.GroceryItem;

public interface GroceryItemRepository extends CrudRepository<GroceryItem, Long>{
	
}
