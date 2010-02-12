package com.greenteapress.thinkapjava.chap04;

/*
 * Exercise 4.4
 * 
 * This class prints the lyrics of the song "99 Bottles of Beer." 
 * The printLyrics method prints out one verse given the number of beer 
 * bottles left on the wall.  The printSong method recursively goes through
 * each verse of the song. 
 * 
 */

public class Exercise04 {
	
	public static void printLyrics(int number) {
		String lyric1 = " bottles of beer on the wall, ";
		String lyric2 = " bottles of beer, ya take one down, pass it around, ";	
		System.out.println(number + lyric1 + number + lyric2 + number + lyric1); 
	}
	
	public static void printSong(int number) {
		if (number == 0) {
			System.out.println("No bottles of beer on the wall, no bottles of beer, " +
					"ya can't take one down, ya can't pass it around, cause there " +
					"are no more bottles of beer on the wall!");
		}
		else {
			printLyrics(number);		
			printSong(number - 1);
		}
	}

	public static void main(String[] args) {
		printSong(99);
	}
}
