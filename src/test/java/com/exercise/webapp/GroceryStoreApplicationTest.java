package com.exercise.webapp;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.exercise.webapp.controller.GroceryItemController;

/**
 * Application test to verify that controllers are getting initialized.
 * 
 * @author arao
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GroceryStoreApplicationTest {

	@Autowired
	private GroceryItemController groceryItemController;
	
	@Test
	public void contextLoads() {
		assertThat(groceryItemController).isNotNull();
	}
}
