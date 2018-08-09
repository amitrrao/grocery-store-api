package com.exercise.webapp.base;

public class Sales {
	private float price;
	private float discount;
	
	public Sales(float price, float discount) {
		super();
		this.price = price;
		this.discount = discount;
	}
	
	public float getPrice() {
		return price;
	}
	public float getDiscount() {
		return discount;
	}
	
	public static class SalesBuilder {
		private float nestedPrice = 0;
		private float nestedDiscount = 0;
		
		public SalesBuilder withPrice(float price) {
			this.nestedPrice = price;
			return this;
		}
		
		public SalesBuilder withDiscount(float discount) {
			this.nestedDiscount = discount;
			return this;
		}
		
		public Sales build() {
			return new Sales(this.nestedPrice, this.nestedDiscount);
		}
	}
}
