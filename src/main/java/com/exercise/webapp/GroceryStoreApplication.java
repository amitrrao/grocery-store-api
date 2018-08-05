package com.exercise.webapp;

import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import com.exercise.webapp.persistence.models.GroceryItem;
import com.exercise.webapp.persistence.models.InternalDetails;
import com.exercise.webapp.persistence.models.SaleItem;
import com.exercise.webapp.repository.GroceryItemRepository;

@SpringBootApplication
public class GroceryStoreApplication extends SpringBootServletInitializer implements CommandLineRunner {
	
	@Autowired
	private GroceryItemRepository itemRepository;

	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(GroceryStoreApplication.class);
    }
	
	public static void main(String[] args) {
		SpringApplication.run(GroceryStoreApplication.class, args);
	}
	
	//TODO: take command line arg for file location
	@Override
    public void run(String... args) throws Exception {
		JSONParser parser = new JSONParser();
		JSONArray jsonArray = (JSONArray) parser.parse(new FileReader("/Users/agoel/Documents/workspace-sts/grocery-store/src/main/java/com/exercise/webapp/data/input.json"));
		for (Object o : jsonArray) {
			itemRepository.save(serializeGroceryItem(o));
        }
    }
	
	// TODO: deserialize right?
	private GroceryItem serializeGroceryItem(Object obj) {
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
}
