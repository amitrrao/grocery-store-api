package com.exercise.webapp.base;

public class Internal {
	
	private int aisle;
	private TimesSold timesSold;
	
	public Internal(int aisle, TimesSold timesSold) {
		super();
		this.aisle = aisle;
		this.timesSold = timesSold;
	}
	public int getAisle() {
		return aisle;
	}
	public TimesSold getTimesSold() {
		return timesSold;
	}
	
	public static class InternalBuilder {
		private int nestedAisle = 0;
		private TimesSold nestedTimesSold;
		
		public InternalBuilder withAisle(int aisleNumber) {
			this.nestedAisle = aisleNumber;
			return this;
		}
		public InternalBuilder withTimesSold(TimesSold timesSold) {
			this.nestedTimesSold = timesSold;
			return this;
		}
		public Internal build() {
			return new Internal(this.nestedAisle, this.nestedTimesSold);
		}
	}
}
