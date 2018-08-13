package com.exercise.webapp.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.exercise.webapp.persistence.models.GroceryItem;

/***
 * 
 * This is an interface representing methods for GroceryItemRepository.
 * 
 * @author arao
 *
 */
public interface GroceryItemRepository extends JpaRepository<GroceryItem, Long>{
	
	/**
	 * A method to get all grocery items in the 'fruit' category and which have been sold in the last two days.
	 * 
	 * @param pageable - Number of pages to be returned.
	 *
	 * @return - A list of GroceryItem objects.
	 */
	@Query(value = "SELECT gi FROM GroceryItem gi "
			+ "WHERE gi.saleItem.discount > 0 "
			+ "AND (gi.internalDetails.timesSoldToday + gi.internalDetails.timesSoldYesterday) > 0 "
			+ "AND gi.category = 'fruit' "
			+ "ORDER BY (gi.internalDetails.timesSoldToday + gi.internalDetails.timesSoldYesterday) DESC")
    public List<GroceryItem> findSalesDataForFruits(Pageable pageable);
}
