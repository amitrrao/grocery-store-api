package com.exercise.webapp.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.exercise.webapp.persistence.models.GroceryItem;

public interface GroceryItemRepository extends JpaRepository<GroceryItem, Long>{
	
	@Query(value = "SELECT gi FROM GroceryItem gi "
			+ "WHERE gi.saleItem.discount > 0 "
			+ "AND gi.internalDetails.timesSoldToday + gi.internalDetails.timesSoldYesterday > 0 "
			+ "AND gi.category = 'fruit' "
			+ "ORDER BY (gi.internalDetails.timesSoldToday + gi.internalDetails.timesSoldYesterday) DESC")
    public List<GroceryItem> findSalesDataForFruits(Pageable pageable); // TODO: fruit can be a param
}
