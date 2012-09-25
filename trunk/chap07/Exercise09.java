/**
 * @author Poorva Singal
 */

/* 
 * Exercise 7.9
 * 
 * a. The Captain Crunch decoder rings work by taking each letter in a string
 *     and adding 13 to it.  For example, 'a'  becomes 'n' and 'b' becomes 'o'.
 *     The letters "wrap around" at the end, so 'z' becomes 'm'.
 *     Write a method that takes a String and that returns a new String 
 *     containing the encoded version.  You should assume that the String 
 *     contains upper and lower case letters, and spaces, but no other 
 *     punctuation.  Lower case letters should be transformed into other lower 
 *     case letters; upper into upper.  You should not encode the spaces.  
 * 
 * b. Generalize the Captain Crunch method so that instead of adding 13 to the
 *     letters, it adds any given amount.  Now you should be able to encode 
 *     things by adding 13 and decode them by adding -13.  Try it.
 *
 */
public class Exercise09 {
	
	public static String encode(String s, int n) {
		String converted = "";
		n = n%26; 
		int index = 0;
		
		while(index < s.length()) {
			char curChar = s.charAt(index); 
			if ('a' <= curChar && curChar <= 'z' ) {
				int convertedChar = curChar + n;
				if (convertedChar > 'z') {
					convertedChar = (convertedChar - 'z') + 'a' - 1;
				} else if (convertedChar < 'a') {
					convertedChar = 'z' - ('a' - convertedChar) + 1;
				}
				converted = converted + (char)convertedChar;	 
			} else if ('A' <= curChar && curChar <= 'Z' ) {
				int convertedChar = curChar + n;
				if (convertedChar > 'Z') {
					convertedChar = (convertedChar - 'Z') + 'A' - 1;
				} else if (convertedChar < 'A') {
					convertedChar = 'Z' - ('A' - convertedChar) + 1;
				}
				converted = converted + (char)convertedChar;
			} else {
				converted = converted + (char)curChar;
			}		
			index = index + 1;
		}
		return converted;
	}
}
