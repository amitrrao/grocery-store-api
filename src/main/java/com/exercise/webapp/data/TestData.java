package com.exercise.webapp.data;

import java.util.ArrayList;
import java.util.List;

import com.exercise.webapp.persistence.models.GroceryItem;
import com.exercise.webapp.persistence.models.InternalDetails;
import com.exercise.webapp.persistence.models.SaleItem;

/**
 * This class contains all the test data.
 * 
 * @author arao
 *
 */
public class TestData {
	
	public static List<GroceryItem> getGroceryItemTestData() {
		List<GroceryItem> items = new ArrayList<>();
		
		GroceryItem item1 = new GroceryItem();
		item1.setId(101);
		item1.setName("Idaho Potatoes");
		item1.setDescription("Fuji Apples from California");
		item1.setCategory("vegetable");
		item1.setSaleItem(new SaleItem(3.0f, .5f, item1));
		item1.setInternalDetails(new InternalDetails(1, 900, 10, item1));
		items.add(item1);
		
		GroceryItem item2 = new GroceryItem();
		item2.setId(102);
		item2.setName("Mars Chocolate");
		item2.setDescription("Mars Milk Chocolates");
		item2.setCategory("candy");
		item2.setSaleItem(new SaleItem(3.0f, .5f, item2));
		item2.setInternalDetails(new InternalDetails(20, 2000, 30, item2));
		items.add(item2);
		
		GroceryItem item3 = new GroceryItem();
		item3.setId(103);
		item3.setName("Roma Tomatoes");
		item3.setDescription("Roma Tomatoes from Mexico");
		item3.setCategory("produce");
		item3.setSaleItem(new SaleItem(1.5f, 0.0f, item3));
		item3.setInternalDetails(new InternalDetails(11, 150, 100, item3));
		items.add(item3);
		
		GroceryItem item4 = new GroceryItem();
		item4.setId(104);
		item4.setName("Almond Cookies");
		item4.setDescription("Fresh Baked Almond Cookies");
		item4.setCategory("bakery");
		item4.setSaleItem(new SaleItem(3.0f, 1.0f, item4));
		item4.setInternalDetails(new InternalDetails(12, 50, 60, item4));
		items.add(item4);
		
		GroceryItem item5 = new GroceryItem();
		item5.setId(105);
		item5.setName("Bic Pens");
		item5.setDescription("Bic Ball Point Pens");
		item5.setCategory("stationary");
		item5.setSaleItem(new SaleItem(0.5f, 0.0f, item5));
		item5.setInternalDetails(new InternalDetails(17, 15, 20, item5));
		items.add(item5);
		
		// sold today and yday, category fruits, discount > 0
		GroceryItem item6 = new GroceryItem();
		item6.setId(106);
		item6.setName("Fuji Apples");
		item6.setDescription("Fuji Apples from California");
		item6.setCategory("fruit");
		item6.setSaleItem(new SaleItem(20.0f, 5.0f, item6));
		item6.setInternalDetails(new InternalDetails(10, 900, 10, item6));
		items.add(item6);
		
		// sold today and yday, category fruits, discount > 0 #2
		GroceryItem item7 = new GroceryItem();
		item7.setId(107);
		item7.setName("Fruit 7");
		item7.setDescription("Fruit 7");
		item7.setCategory("fruit");
		item7.setSaleItem(new SaleItem(10.0f, 2.0f, item7));
		item7.setInternalDetails(new InternalDetails(10, 20, 30, item7));
		items.add(item7);
		
		// sold today and yday, category fruits, discount > 0 #3
		GroceryItem item8 = new GroceryItem();
		item8.setId(108);
		item8.setName("Fruit 8");
		item8.setDescription("Fruit 8");
		item8.setCategory("fruit");
		item8.setSaleItem(new SaleItem(6.0f, 0.5f, item8));
		item8.setInternalDetails(new InternalDetails(10, 20, 30, item8));
		items.add(item8);
		
		// sold today and yday, category fruits, discount > 0 #4
		GroceryItem item9 = new GroceryItem();
		item9.setId(109);
		item9.setName("Fruit 9");
		item9.setDescription("Fruit 9");
		item9.setCategory("fruit");
		item9.setSaleItem(new SaleItem(0.5f, 0.1f, item9));
		item9.setInternalDetails(new InternalDetails(100, 200, 30, item9));
		items.add(item9);
		
		//TODO: what if there is a tie for second spot?
		
		// Did not sell yday, category fruits, discount > 0
		GroceryItem item10 = new GroceryItem();
		item10.setId(110);
		item10.setName("Fruit 10");
		item10.setDescription("Fruit 10");
		item10.setCategory("fruit");
		item10.setSaleItem(new SaleItem(10.0f, 2.0f, item10));
		item10.setInternalDetails(new InternalDetails(10, 20, 0, item10));
		items.add(item10);
		
		// Did not sell today, category fruits, discount > 0
		GroceryItem item11 = new GroceryItem();
		item11.setId(111);
		item11.setName("Fruit 11");
		item11.setDescription("Fruit 11");
		item11.setCategory("fruit");
		item11.setSaleItem(new SaleItem(10.0f, 2.0f, item11));
		item11.setInternalDetails(new InternalDetails(10, 0, 2000, item11));
		items.add(item11);
		
		// Did not sell today or yesterday, category fruits, discount > 0
		GroceryItem item12 = new GroceryItem();
		item12.setId(112);
		item12.setName("Fruit 12");
		item12.setDescription("Fruit 12");
		item12.setCategory("fruit");
		item12.setSaleItem(new SaleItem(14.0f, 2.0f, item12));
		item12.setInternalDetails(new InternalDetails(10, 0, 0, item12));
		items.add(item12);
		
		// sold yday and today, not fruits, discount > 0
		GroceryItem item13 = new GroceryItem();
		item13.setId(113);
		item13.setName("Other 13");
		item13.setDescription("Other 13");
		item13.setCategory("other");
		item13.setSaleItem(new SaleItem(11.0f, 2.0f, item13));
		item13.setInternalDetails(new InternalDetails(10, 10, 20, item13));
		items.add(item13);
		
		// Did not sell yday, not fruits, discount > 0
		GroceryItem item14 = new GroceryItem();
		item14.setId(114);
		item14.setName("Other 14");
		item14.setDescription("Other 14");
		item14.setCategory("other");
		item14.setSaleItem(new SaleItem(0.75f, 2.0f, item14));
		item14.setInternalDetails(new InternalDetails(10, 10, 0, item14));
		items.add(item14);
		
		// Did not sell today, not fruits, discount > 0
		GroceryItem item15 = new GroceryItem();
		item15.setId(115);
		item15.setName("Other 15");
		item15.setDescription("Other 15");
		item15.setCategory("other");
		item15.setSaleItem(new SaleItem(15.0f, 2.0f, item15));
		item15.setInternalDetails(new InternalDetails(10, 0, 20, item15));
		items.add(item15);
		
		// Did not sell today or yesterday, not fruits, discount > 0
		GroceryItem item16 = new GroceryItem();
		item16.setId(116);
		item16.setName("Other 16");
		item16.setDescription("Other 16");
		item16.setCategory("other");
		item16.setSaleItem(new SaleItem(12.0f, 2.0f, item16));
		item16.setInternalDetails(new InternalDetails(10, 0, 0, item16));
		items.add(item16);
		
		// sold today and yday, category fruits, discount = 0
		GroceryItem item17 = new GroceryItem();
		item17.setId(117);
		item17.setName("Fruit 17");
		item17.setDescription("Fruit 17");
		item17.setCategory("fruit");
		item17.setSaleItem(new SaleItem(10.0f, 0.0f, item17));
		item17.setInternalDetails(new InternalDetails(10, 20, 30, item17));
		items.add(item17);
		
		// Did not sell yday, category fruits, discount = 0
		GroceryItem item18 = new GroceryItem();
		item18.setId(118);
		item18.setName("Fruit 18");
		item18.setDescription("Fruit 18");
		item18.setCategory("fruit");
		item18.setSaleItem(new SaleItem(15.0f, 0.0f, item18));
		item18.setInternalDetails(new InternalDetails(10, 20, 0, item18));
		items.add(item18);
		
		// Did not sell today, category fruits, discount = 0
		GroceryItem item19 = new GroceryItem();
		item19.setId(119);
		item19.setName("Fruit 19");
		item19.setDescription("Fruit 19");
		item19.setCategory("fruit");
		item19.setSaleItem(new SaleItem(1.25f, 0.0f, item19));
		item19.setInternalDetails(new InternalDetails(10, 0, 20, item19));
		items.add(item19);
		
		// Did not sell today or yesterday, category fruits, discount = 0
		GroceryItem item20 = new GroceryItem();
		item20.setId(120);
		item20.setName("Fruit 20");
		item20.setDescription("Fruit 20");
		item20.setCategory("fruit");
		item20.setSaleItem(new SaleItem(13.0f, 2.0f, item20));
		item20.setInternalDetails(new InternalDetails(10, 0, 0, item20));
		items.add(item20);
		
		// sold yday and today, not fruits, discount = 0
		GroceryItem item21 = new GroceryItem();
		item21.setId(121);
		item21.setName("Other 21");
		item21.setDescription("Other 21");
		item21.setCategory("other");
		item21.setSaleItem(new SaleItem(1.5f, 0.0f, item21));
		item21.setInternalDetails(new InternalDetails(10, 10, 20, item21));
		items.add(item21);
		
		// Did not sell yday, not fruits, discount = 0
		GroceryItem item22 = new GroceryItem();
		item22.setId(122);
		item22.setName("Other 22");
		item22.setDescription("Other 22");
		item22.setCategory("other");
		item22.setSaleItem(new SaleItem(2.0f, 0.0f, item22));
		item22.setInternalDetails(new InternalDetails(10, 10, 0, item22));
		items.add(item22);
		
		// Did not sell today, not fruits, discount = 0
		GroceryItem item23 = new GroceryItem();
		item23.setId(123);
		item23.setName("Other 23");
		item23.setDescription("Other 23");
		item23.setCategory("other");
		item23.setSaleItem(new SaleItem(9.0f, 0.0f, item23));
		item23.setInternalDetails(new InternalDetails(10, 0, 20, item23));
		items.add(item23);
		
		// Did not sell today or yesterday, not fruits, discount = 0
		GroceryItem item24 = new GroceryItem();
		item24.setId(124);
		item24.setName("Other 24");
		item24.setDescription("Other 24");
		item24.setCategory("other");
		item24.setSaleItem(new SaleItem(8.5f, 0.0f, item24));
		item24.setInternalDetails(new InternalDetails(10, 0, 0, item24));
		items.add(item24);
		
		return items;
		
	}
}
