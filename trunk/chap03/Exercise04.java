package com.greenteapress.thinkapjava.chap03;

/*
 * Exercise 3.4
 * 
 * This program encapsulates code written in Exercise 2.1.  The methods printAmerican
 * and printEuropean are invoked from main, and print the date in their respective
 * formats.  The parameters for these methods are the day, month, date, and year.
 * 
 */

public class Exercise04 {

	public static void printAmerican(String day, String month, int date, int year) {
		System.out.println(day + ", " + month + ' ' + date + ", " + year);
	}
	
	public static void printEuropean(String day, String month, int date, int year) {
		System.out.println(day + ' ' + date + ' ' + month + ", " + year);
	}
	
	public static void main(String[] args) {
		String day = "Thursday";
		String month = "February";
		int year = 2010;
		int date = 11;
		
		printAmerican(day, month, date, year);
		printEuropean(day, month, date, year);
		
	}
	
}
