package com.exercise.webapp.base;

/**
 * 
 * Aisle is an enum that maps an Aisle name to its integer value. 
 *
 * @author arao
 */
public enum Aisle {

	SUPER_SAVER(15);
	
	private final int value; 
	
	Aisle (int value) {
        this.value= value;
    }
	public int getValue() {
		return this.value;
	}
}
