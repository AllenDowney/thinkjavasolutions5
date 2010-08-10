/**
 * @author Poorva Singal
 */

/*
 * Exercise 6.6
 * 
 * A word is said to be "abecedarian" if the letters in the word appear in 
 * alphabetical order.  For example, the following are all 6-letter English 
 * abecedarian words.
 *     abdest, acknow, acorsy, adempt, adipsy, agnosy, befist, behint, beknow,
 *     bijoux, biopsy, cestuy, chintz, deflux, dehors, dehort, deinos, diluvy,
 *     dimpsy
 *     
 * a. Describe an algorithm for checking whether a given word (String) is
 *     abecedarian assuming that the word contains only lower-case letters.
 *     Your algorithm can be iterative or recursive.  
 * 
 * b. Implement your algorithm in a method called isAbecedarian.
 * 
 */
public class Exercise06 {
	public static boolean isAbecedarian(String s) {
		int index = 0;
		char c = 'a'; 
		while (index < s.length()) {
			if (c > s.charAt(index)) {
				return false;
			}
			c = s.charAt(index); 
			index = index + 1;
			
		}
		return true;
	}
}
