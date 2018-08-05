package com.exercise.webapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.exercise.webapp.persistence.models.GroceryItem;
import com.exercise.webapp.persistence.models.SaleItem;

public interface GroceryItemRepository extends CrudRepository<GroceryItem, Long>{
	
//	@Query(value = "SELECT * FROM GROCERY_ITEM gi JOIN gi.internalDetails ids", nativeQuery = true)
//    public List<GroceryItem> findSalesDataForFruits();
}
