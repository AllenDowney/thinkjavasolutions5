package com.greenteapress.thinkapjava.chap04;

/*
 * Exercise 4.6
 * 
 * The method checkFermat checks to see if there is an exception to Fermat's Last Theorem using
 * conditionals.
 * 
 * Math.pow takes two integers and raises the first to the second, so Math.pow(a, n) = a^n.
 * 
 */

public class Exercise06 {
	
	public static void checkFermat(int a, int b, int c, int n) {
		if (((Math.pow(a, n) + Math.pow(b, n)) == Math.pow(c, n)) && (n != 2)) {
			System.out.println("Holy smokes, Fermat was wrong!");
		}
		else {
			System.out.println("No, that doesn't work.");
		}
	}
	
	public static void main(String[] args) {
		checkFermat(1, 2, 4, 1);
	}

}
