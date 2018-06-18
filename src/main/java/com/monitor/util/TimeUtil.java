package com.monitor.util;

public class TimeUtil {
	public static long getMilliseconds(int seconds) {
		return seconds * 1000l;
	}
	
	/*
	 * The format of the start and end time should be HHmm (in 24 hour format)
	 */
	public static long getMillisecondsBetween(int startTime, int endTime) {
		long minutes = getMinutesBetween(startTime, endTime);
		long seconds = minutes * 60;
		return seconds * 1000;
	}
	
	private static long getMinutesBetween(int startTime, int endTime) {
		Time start = getTime(startTime);
		Time end = getTime(endTime);
		long totalMinutes = 0;
		totalMinutes += Math.abs(start.hours - end.hours) * 60;
		totalMinutes += Math.abs(start.minutes - end.minutes);
		
		return totalMinutes;
	}
	
	private static Time getTime(int timeHHmm) {
		String hour = "0";
		String minute = "0";
		if (timeHHmm >= 1000 && timeHHmm < 2360) {
			// 4 digits
			hour = String.valueOf(timeHHmm).substring(0, 2);
			minute = String.valueOf(timeHHmm).substring(2);
		} else if (timeHHmm >= 100 && timeHHmm < 1000){
			// 3 digits
			hour = String.valueOf(timeHHmm).substring(0, 1);
			minute = String.valueOf(timeHHmm).substring(1);			
		} else if (timeHHmm >= 10 && timeHHmm < 100){
			// 2 digits
			minute = String.valueOf(timeHHmm);			
		} else if (timeHHmm >=0 && timeHHmm < 10){
			// 1 digit
			minute = String.valueOf(timeHHmm);
		}		
		return new Time(Integer.parseInt(hour), Integer.parseInt(minute));
	}
	
	static class Time {
		private int hours;
		private int minutes;
		public Time(int h, int m) {
			hours = h;
			minutes = m;
		}
		public int getHours() {
			return hours;
		}
		public void setHours(int hours) {
			this.hours = hours;
		}
		public int getMinutes() {
			return minutes;
		}
		public void setMinutes(int minutes) {
			this.minutes = minutes;
		}
		
		
	}
}
