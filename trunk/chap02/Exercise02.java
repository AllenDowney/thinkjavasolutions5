package com.greenteapress.thinkapjava.chap02;

/*
 * Exercise 2.2
 * 
 * From the current hour, minute, and second, this program calculates and prints 
 * the seconds that have passed since midnight, the seconds remaining in the day,
 * and the percentage of the day that has passed.
 * 
 */

public class Exercise02 {

	public static void main(String[] args) {
		int hour, minute, second, seconds_since_midnight, seconds_remaining, percentage_passed;
		hour = 20;
		minute = 14;
		second = 29;
		
		seconds_since_midnight = hour * 3600 + minute * 60 + second;
		System.out.print("Seconds since midnight: ");
		System.out.println(seconds_since_midnight);
		
		seconds_remaining = (24 - hour) * 3600 + (60 - minute) * 60 + (60 - second);
		System.out.print("Seconds remaining in the day: ");
		System.out.println(seconds_remaining);
		
		percentage_passed = seconds_since_midnight * 100 / (3600 * 24);
		System.out.print("Percentage of the day that has passed: ");
		System.out.println(percentage_passed);

	}
	
}
