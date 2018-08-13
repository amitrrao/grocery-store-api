package com.exercise.webapp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.exercise.webapp.base.CheckoutItem;
import com.exercise.webapp.persistence.models.GroceryItem;
import com.exercise.webapp.persistence.models.InternalDetails;
import com.exercise.webapp.persistence.models.SaleItem;
import com.exercise.webapp.repository.GroceryItemRepository;
import com.exercise.webapp.repository.SaleItemRepository;
import com.exercise.webapp.service.GroceryItemService;

/**
 * Service level tests to validate methods in the GroceryItemsService class.
 * 
 * @author arao
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes =  GroceryItemService.class)
public class GroceryItemServiceTest {
	
	@MockBean
	private GroceryItemRepository mockGroceryItemRepository;
	
	@MockBean
	private SaleItemRepository mockSaleItemRepository;
	
	@Autowired
	private GroceryItemService service;
	
	@Test
	public void checkoutItems_Success() throws Exception {
		GroceryItem item1 = new GroceryItem();
		item1.setId(101);
		item1.setName("Idaho Potatoes");
		item1.setDescription("Fuji Apples from California");
		item1.setCategory("vegetable");
		item1.setSaleItem(new SaleItem(3.0f, .5f, item1));
		item1.setInternalDetails(new InternalDetails(1, 900, 10, item1));
		
		GroceryItem item2 = new GroceryItem();
		item2.setId(102);
		item2.setName("Mars Chocolate");
		item2.setDescription("Mars Milk Chocolates");
		item2.setCategory("candy");
		item2.setSaleItem(new SaleItem(3.0f, .5f, item2));
		item2.setInternalDetails(new InternalDetails(20, 2000, 30, item2));
		
		when(mockGroceryItemRepository.findOne(item1.getId())).thenReturn(item1);
		when(mockGroceryItemRepository.findOne(item2.getId())).thenReturn(item2);
		
		assertThat(service.checkout(
				Arrays.asList(new CheckoutItem(item1.getId(), 2), 
				new CheckoutItem(item2.getId(), 5)))).isEqualTo(17.5f);
	}
	
	@Test
	public void checkoutItems_SuccessNegativeDiscount() throws Exception {
		GroceryItem item1 = new GroceryItem();
		item1.setId(101);
		item1.setName("Idaho Potatoes");
		item1.setDescription("Fuji Apples from California");
		item1.setCategory("vegetable");
		item1.setSaleItem(new SaleItem(3.0f, -.5f, item1));
		item1.setInternalDetails(new InternalDetails(1, 900, 10, item1));
		
		GroceryItem item2 = new GroceryItem();
		item2.setId(102);
		item2.setName("Mars Chocolate");
		item2.setDescription("Mars Milk Chocolates");
		item2.setCategory("candy");
		item2.setSaleItem(new SaleItem(3.0f, .5f, item2));
		item2.setInternalDetails(new InternalDetails(20, 2000, 30, item2));
		
		when(mockGroceryItemRepository.findOne(item1.getId())).thenReturn(item1);
		when(mockGroceryItemRepository.findOne(item2.getId())).thenReturn(item2);
		
		assertThat(service.checkout(
				Arrays.asList(new CheckoutItem(item1.getId(), 2), 
				new CheckoutItem(item2.getId(), 5)))).isEqualTo(18.5f);
	}
	
	@Test
	public void checkoutItems_SuccessDiscountGreaterThanPrice() throws Exception {
		GroceryItem item1 = new GroceryItem();
		item1.setId(101);
		item1.setName("Idaho Potatoes");
		item1.setDescription("Fuji Apples from California");
		item1.setCategory("vegetable");
		item1.setSaleItem(new SaleItem(3.0f, -.5f, item1));
		item1.setInternalDetails(new InternalDetails(1, 900, 10, item1));
		
		GroceryItem item2 = new GroceryItem();
		item2.setId(102);
		item2.setName("Mars Chocolate");
		item2.setDescription("Mars Milk Chocolates");
		item2.setCategory("candy");
		item2.setSaleItem(new SaleItem(3.0f, 4.5f, item2));
		item2.setInternalDetails(new InternalDetails(20, 2000, 30, item2));
		
		when(mockGroceryItemRepository.findOne(item1.getId())).thenReturn(item1);
		when(mockGroceryItemRepository.findOne(item2.getId())).thenReturn(item2);
		
		assertThat(service.checkout(
				Arrays.asList(new CheckoutItem(item1.getId(), 2), 
				new CheckoutItem(item2.getId(), 5)))).isEqualTo(6f);
	}
}
