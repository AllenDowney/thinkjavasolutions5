/**
 * @author Poorva Singal
 */

/*
 * 
 * Exercise 6.7
 * 
 * A dupledrome is a word that contains only double letters, like "llaammaa" 
 * or "ssaabb".  I conjecture that there are dupledromes in common English
 * use.  To test that conjecture, I would like a program that reads words
 * from the dictionary one at a time and checks them for dupledromity.
 * 
 * Write a method called isDupledrome that takes a String and returns a
 * boolean indicating whether the word is a dupledrome.  
 */
public class Exercise07 {
	
	public static boolean isDupledrome(String s) {
		int length = s.length();
		
		// can't be a dupledrome if s has odd number of letters
		if (length%2 != 0) {
			return false;
		}
		
		int index = 0;
		while (index < length) {
			if (s.charAt(index) != s.charAt(index + 1)) {
				return false;
			}
			index = index + 2;
		}
		return true;
	}

}
