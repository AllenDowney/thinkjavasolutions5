// Represents a date using its day, month, and year
public class Date {
	
	int year, month, day;
	
	// "Empty" Constructor
	public Date() {
		
	}
	
	// Construct date object using year, month, and day
	public Date(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	public static void main(String[] args) {
		
		// Born May 5, 1926
		int birthYear = 1926;
		int birthMonth = 5;
		int birthDay = 26;
		
		// Create date object using "no parameters" constructor
		Date date1 = new Date();
		date1.year = birthYear;
		date1.month = birthMonth;
		date1.day = birthDay;
		
		// Create date object using "all parameters" constructor
		Date date2 = new Date(birthYear, birthMonth, birthDay);
	}
}
