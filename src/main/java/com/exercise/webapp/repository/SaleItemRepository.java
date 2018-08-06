package com.exercise.webapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.exercise.webapp.persistence.models.SaleItem;;

public interface SaleItemRepository extends JpaRepository<SaleItem, Long>{
	
	@Query(value = "SELECT * FROM SALE_ITEM si WHERE si.price < 1", nativeQuery = true)
	public List<SaleItem> findByPrice(); //TODO: rename
}
