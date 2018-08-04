package com.exercise.webapp.base;

public class TimesSold {
	
	private int today;
	private int yesterday;
	
	private TimesSold(int today, int yesterday) {
		super();
		this.today = today;
		this.yesterday = yesterday;
	}
	
	public int getToday() {
		return today;
	}
	
	public int getYesterday() {
		return yesterday;
	}
	
	public static class TimesSoldBuilder {
		private int nestedToday = 0;
		private int nestedYesterday = 0;
		
		public TimesSoldBuilder withToday(int today) {
			this.nestedToday = today;
			return this;
		}
		
		public TimesSoldBuilder withYesterday(int yesterday) {
			this.nestedYesterday = yesterday;
			return this;
		}
		
		public TimesSold build() {
			return new TimesSold(nestedToday, nestedYesterday);
		}
	}
}
