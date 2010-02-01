public class Ordinal
{
	// formOrdinal takes an integer as an argument and returns a String that
	// contains the ordinal representation of the number (e.g. 1st, 2nd, 13th)
	public static String formOrdinal (int n)
	{
		String suff;
		
		// add the right suffix
		switch (n%10) {
		case 1:
			suff = "st";  break;     // don't forget to
		case 2:
			suff = "nd";  break;     // put a break
		case 3:
			suff = "rd";  break;     // at the end 
		default:
			suff = "th";  break;     // of every case
		}

		// correct for the evil teens
		if (n%100 >= 11 && n%100 <= 13) suff = "th";
		
		// the String concatenation operator (+) automatically converts n to a String
		return n + suff;
	}

	// printOrdinal actually prints the string formed by formOrdinal
	public static void printOrdinal (int n)
	{
		System.out.println (formOrdinal (n));
	}
	
	public static void main(String args[])
	{
		int day = 3;
		int month = 11;

		// we can use the return value from formOrdinal as part of an expression
		System.out.print("The " + formOrdinal(day) + " day ");
		System.out.println("of the " + formOrdinal(month) + " month.");
		
		// make sure we test all the special cases!
		printOrdinal (1);
		printOrdinal (2);
		printOrdinal (12);
		printOrdinal (13);
		printOrdinal (14);
		printOrdinal (127449);
	}
}


