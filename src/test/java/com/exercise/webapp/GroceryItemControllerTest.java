package com.exercise.webapp;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.exercise.webapp.controller.GroceryItemController;
import com.exercise.webapp.data.TestData;
import com.exercise.webapp.repository.GroceryItemRepository;
import com.exercise.webapp.service.GroceryItemService;
import static org.mockito.BDDMockito.*;


@RunWith(SpringRunner.class)
@WebMvcTest(GroceryItemController.class)
@ActiveProfiles("test")
@ContextConfiguration(classes = {GroceryItemRepository.class})
public class GroceryItemControllerTest {

	private MockMvc mockMvc;

	@MockBean
	private GroceryItemService mockGroceryItemService;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Autowired
	ApplicationContext ctx;

	@Ignore
	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		CommandLineRunner runner = ctx.getBean(CommandLineRunner.class);
		runner.run ("-k", "./src/main/java/com/exercise/webapp/data/input.json");
	}

	@Ignore
	@Test
	public void getAllGroceryItems_Success() throws Exception {
		//			given(mockGroceryItemService.getAllGroceryItems())
		//			.willReturn(TestData.getGroceryItemTestData());

		mockMvc.perform(get("/groceryitems"))
		.andExpect(status().is(200));
	}

	@Ignore
	@Test
	public void testJsonController() throws Exception {
		MockHttpServletRequestBuilder builder =
				MockMvcRequestBuilders.post("/groceryitems/checkout")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.accept(MediaType.APPLICATION_JSON)
				.characterEncoding("UTF-8")
				.content(getArticleInJson(1));
		this.mockMvc.perform(builder)
		.andExpect(MockMvcResultMatchers.status()
				.isOk())
		.andExpect(MockMvcResultMatchers.content()
				.string("5.5"))
		.andDo(MockMvcResultHandlers.print());
	}

	private String getArticleInJson(long id) {
		return "[{\"id\":114, \"quantity\":2}]";
	}
}
