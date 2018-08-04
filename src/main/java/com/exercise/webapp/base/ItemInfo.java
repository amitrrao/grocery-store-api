package com.exercise.webapp.base;

public class ItemInfo {
	private String description;
	private String category;
	
	public ItemInfo(String description, String category) {
		super();
		this.description = description;
		this.category = category;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getCategory() {
		return category;
	}
	
	public static class ItemInfoBuilder {
		
		private String nestedDesc;
		private String nestedCategory;
		
		public ItemInfoBuilder withDescription(String desc) {
			this.nestedDesc = desc;
			return this;
		}
		
		 public ItemInfoBuilder withCategory(String category) {
			 this.nestedCategory = category;
			 return this;
		 }
		 
		 public ItemInfo build() {
			 return new ItemInfo(this.nestedDesc, this.nestedCategory);
		 }
	}
	
}
