package com.greenteapress.thinkapjava.chap02;

/*
 * Exercise 2.1
 * 
 * This program prints out the current date in American and European formats.
 * 
 */

public class Exercise01 {

	public static void main(String[] args) {
		String day = "Thursday";
		String month = "February";
		int year = 2010;
		int date = 11;

		System.out.println("American format:");
		System.out.println(day + ", " + month + ' ' + date + ", " + year);
		
		System.out.println("European format:");
		System.out.println(day + ' ' + date + ' ' + month + ", " + year);
		
	}
	
}
