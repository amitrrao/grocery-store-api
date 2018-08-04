package com.exercise.webapp.builder;

import com.exercise.webapp.base.GroceryItem;

/**
 * 
 * The Builder interface that all builder type classes must implement.
 *
 * @author arao
 */

public interface Builder {
	
	public GroceryItem build();
}