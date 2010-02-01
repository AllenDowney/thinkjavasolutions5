// Fraction.java

public class Fraction
{
	// these are global final variables, used as a cheap impression of an
	// enumerated type.  Making them Strings is unorthodox, but has the
	// advantage that we can print the values easily.
	static final String AM = "AM";
	static final String PM = "PM";

	// main
	public static void main(String args[])
	{
		int hr = 6;
		int min = 12;
		int sec = 13;
		String half = AM;
		
		double frac = fractionOfDay (hr, min, sec, half);
		
		// see how easy it is to print the time of day
		System.out.print (hr + ":" + min + ":" + sec + half);
		System.out.println (" is " + frac + " of a complete day.");
	}
	
	// fractionOfDay: takes a time of day as an argument and returns a double
	// representing the fraction of the day that has elapsed.
	public static double fractionOfDay
		(int hour, int minute, int second, String halfOfDay)
	{
		int seconds = (hour * 60 + minute) * 60 + second;
		if (halfOfDay == PM) {
			seconds += 12 * 60 * 60;
		}
		return (double) seconds / (24 * 60 * 60);
	}
}


