/**
 * 
 * @author Poorva Singal
 *
 */

/*
 * Exercise 10.12
 * 
 * A word is said to be a “doubloon” if every letter that appears in the word 
 * appears exactly twice. For example, the following are all the doubloons I
 * found in my dictionary.
 *     Abba, Anna, appall, appearer, appeases, arraigning, beriberi, bilabial,
 *     boob, Caucasus, coco, Dada, deed, Emmett, Hannah, horseshoer, intestines, 
 *     Isis, mama, Mimi, murmur, noon, Otto, papa, peep, reappear, redder, sees, 
 *     Shanghaiings, Toto
 *     
 *     Write a method called isDoubloon that returns true if the given word is 
 *     a doubloon and false otherwise.
 */
public class Exercise12 {
	
	public static boolean isDubloon(String s) {
		int[] hist = new int[26];
		
		for(int i = 0; i < s.length(); i++) {
			char curChar = s.toLowerCase().charAt(i);
			
			if ('a' <= curChar && curChar <= 'z') {
				hist[curChar-'a']++;
			}
		}
		
		for (int i = 0; i < hist.length; i++) {
			if (hist[i] != 0 && hist[i] != 2) {
				return false;
			}
		} 
		return true;
	}
}
