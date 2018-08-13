package com.exercise.webapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.exercise.webapp.persistence.models.SaleItem;;
/***
 * 
 * This is an interface representing methods for SaleItemRepository.
 * 
 * @author arao
 *
 */
public interface SaleItemRepository extends JpaRepository<SaleItem, Long>{
	
	/**
	 * A method to find all items whose price is < $1.00.
	 * 
	 * @return - A list of SaleItem objects.
	 */
	@Query(value = "SELECT * FROM SALE_ITEM si WHERE si.price < 1", nativeQuery = true)
	public List<SaleItem> findItemByPrice();
}
