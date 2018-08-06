package com.exercise.webapp;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import com.exercise.webapp.builder.GroceryItemBuilder;
import com.exercise.webapp.persistence.models.GroceryItem;
import com.exercise.webapp.persistence.models.InternalDetails;
import com.exercise.webapp.persistence.models.SaleItem;
import com.exercise.webapp.repository.GroceryItemRepository;

@SpringBootApplication
public class GroceryStoreApplication extends SpringBootServletInitializer implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(GroceryStoreApplication.class);
	@Autowired
	private GroceryItemRepository itemRepository;

	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(GroceryStoreApplication.class);
    }
	
	public static void main(String[] args) {
		SpringApplication.run(GroceryStoreApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		// TODO: remove this if condition? or find a way to not use args[0] as default because unit tests fail
		if (args.length > 0) {
			JSONParser parser = new JSONParser();
			JSONArray jsonArray = (JSONArray) parser.parse(new FileReader(args[0]));
			for (Object o : jsonArray) {
				itemRepository.save(serializeGroceryItem(o));
			}
		}
    }

	public static GroceryItem serializeGroceryItem(Object obj) {
		GroceryItem returnItem = new GroceryItem();
		JSONObject item = (JSONObject) obj;
		returnItem.setId((long) item.get("id"));
		returnItem.setName((String) item.get("name"));
		
		JSONObject itemInfo = (JSONObject) item.get("itemInfo");
		returnItem.setDescription((String) itemInfo.get("description"));
		returnItem.setCategory((String) itemInfo.get("category"));
		
		JSONObject sales = (JSONObject) item.get("sales");
		returnItem.setSaleItem(new SaleItem(
				(float) (double) sales.get("price"),
				(float) (double) sales.get("discount"),
				returnItem));
		
		JSONObject internal = (JSONObject) item.get("internal");
		JSONObject timesSold = (JSONObject) internal.get("timesSold");
		returnItem.setInternalDetails(new InternalDetails(
				(int) (long) internal.get("aisle"), 
				(int) (long) timesSold.get("today"),
				(int) (long) timesSold.get("yesterday"), 
				returnItem));
		
		return returnItem;
	}
	
	public static List<com.exercise.webapp.base.GroceryItem> deserializeGroceryItem(List<GroceryItem> items) {
		List<com.exercise.webapp.base.GroceryItem> returnItems = new ArrayList<>();
		for(GroceryItem item: items) {
		com.exercise.webapp.base.GroceryItem returnItem =
				new GroceryItemBuilder(item.getName(), 
						item.getId(), 
						item.getDescription(), 
						item.getCategory(), item.getSaleItem().getPrice(), 
						item.getSaleItem().getDiscount(), 
						item.getInternalDetails().getAisle(),
						item.getInternalDetails().getTimesSoldToday(),
						item.getInternalDetails().getTimesSoldYesterday()).build();
		returnItems.add(returnItem);
		}
		logger.info(String.format("Total number of Grocery Items: %d", items.size()));
		return returnItems;	
	}
}
