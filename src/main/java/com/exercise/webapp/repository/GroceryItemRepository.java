package com.exercise.webapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.exercise.webapp.persistence.models.GroceryItem;

public interface GroceryItemRepository extends JpaRepository<GroceryItem, Long>{
	
//	@Query(value = "SELECT * FROM GROCERY_ITEM gi JOIN gi.saleItem si WHERE si.discount > 0", nativeQuery = true)
//    public List<GroceryItem> findSalesDataForFruits();
	
//	@Query(value = "SELECT * FROM GROCERY_ITEM gi, SALE_ITEM si WHERE si.discount < 1", nativeQuery = true)
//    public List<GroceryItem> findSalesDataForFruits();
	
//	@Query(value = "SELECT * FROM GROCERY_ITEM gi JOIN SALE_ITEM si ON gi.GROCERY_ITEM_ID = si.GROCERY_ITEM_ID where si.discount < 1", nativeQuery = true)
//    public List<GroceryItem> findSalesDataForFruits();
	
	@Query(value = "SELECT gi FROM GroceryItem gi "
			+ "WHERE gi.saleItem.discount > 0 "
			+ "AND gi.internalDetails.timesSoldToday + gi.internalDetails.timesSoldYesterday > 0 "
			+ "ORDER BY (gi.internalDetails.timesSoldToday + gi.internalDetails.timesSoldYesterday) DESC")
    public List<GroceryItem> findSalesDataForFruits();
	
	List<GroceryItem> findTest();
}
