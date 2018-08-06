package com.exercise.webapp;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.exercise.webapp.controller.GroceryItemController;
import com.exercise.webapp.data.TestData;
import com.exercise.webapp.service.GroceryItemService;


@RunWith(SpringRunner.class)
@WebMvcTest(GroceryItemController.class)
public class GroceryItemControllerTest {

	private MockMvc mockMvc;
	
	@MockBean
	private GroceryItemService mockGroceryItemService;
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void getAllSpaces_Success() throws Exception {
//		given(mockGroceryItemService.getAllGroceryItems())
//		.willReturn(TestData.getGroceryItemTestData());

		mockMvc.perform(get("/groceryitems"))
		.andExpect(status().is(200));
	}
	
}
