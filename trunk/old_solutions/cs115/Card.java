public class Card
{
	public int suit, rank;

	public static final String[] suits =
		{ "Clubs", "Diamonds", "Hearts", "Spades" };
	public static final String[] ranks =
		{ "narf", "Ace", "2", "3", "4", "5", "6", "7", "8",
		  "9", "10", "Jack", "Queen", "King" };

	public Card (int suit, int rank)
	{ 
		// this is an alternate way of initializing the instance variables in a constructor
		this.suit = suit;  this.rank = rank;
	}

	public String toString ()
	{
		return ranks[rank] + " of " + suits[suit];
	}

	public static int compareCards (Card c1, Card c2)
	{
		int s1 = ((c1.rank + 11) % 13) * 13 + c1.suit;
		int s2 = ((c2.rank + 11) % 13) * 13 + c2.suit;
		if (s1 > s2) return -1;
		if (s2 > s1) return 1;
		return 0;
	}
	
	public int compare (Card c2)
	{
		return compareCards (this, c2);
	}
}
