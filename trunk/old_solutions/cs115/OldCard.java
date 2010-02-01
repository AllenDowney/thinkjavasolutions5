public class Card
{
	public int suit, rank;

	public static final String[] suits =
		{ "Clubs", "Diamonds", "Hearts", "Spades" };
	public static final String[] ranks =
		{ "narf", "Ace", "2", "3", "4", "5", "6", "7", "8",
		  "9", "10", "Jack", "Queen", "King" };

	public Card (int suit, int rank)
	{ this.suit = suit;  this.rank = rank; }

	public String toString ()
	{
		return ranks[rank] + " of " + suits[suit];
	}

	public static Card[] newDeck ()
	{
		Card[] cards = new Card [52];
		for (int suit = 0; suit < 4; suit++) {
			for (int rank = 1; rank <= 13; rank++) {
				int index = suit*13 + rank - 1;
				cards[index] = new Card (suit, rank);
			}
		}
		return cards;
	}
	
	public static void printDeck (Card[] cards)
	{
		for (int i=0; i<cards.length; i++) System.out.println (cards[i]);
	}
	
	public static void shuffleDeck (Card[] cards)
	{
		for (int i=0; i<cards.length; i++) {
			int j = randInt (i, cards.length);
			swapCards (cards, i, j);
		}
	}
	
	public static void swapCards (Card[] cards, int i, int j)
	{
		Card temp = cards[i];  cards[i] = cards[j];  cards[j] = temp;
	}
	
	// randInt: returns a random integer [low, high)  (including low, but not high)
	public static int randInt (int low, int high)
	{
		double x = Math.random() * (high - low);
		return (int) x + low;
	}
	
	
	public static int compare (Card c1, Card c2)
	{
		// if the ranks are the same, check the suits
		if (c1.rank == c2.rank) {
			if (c1.suit > c2.suit) return -1;
			if (c2.suit > c1.suit) return 1;
			return 0;
		}
		// if either card is an ace, it wins
		if (c1.rank == 1) return -1;
		if (c2.rank == 1) return 1;
		// higher rank wins
		if (c1.rank > c2.rank) return -1;
		if (c2.rank > c1.rank) return 1;
		// this cannot happen
		return 0;
	}

	public static int findHighestCard (Card[] x, int i)
	{
		int index = i;
		for (i = i+1; i<x.length; i++)
			if (compare (x[i], x[index]) == -1) index = i;
		return index;
	}
	
	public static void sortDeck (Card[] cards)
	{
		for (int i=0; i<cards.length; i++) {
			int j = findHighestCard (cards, i);
			swapCards (cards, i, j);
		}
	}
	
	public static void main ()
	{
		Card[] deck = newDeck ();
		shuffleDeck (deck);
		sortDeck (deck);
		printDeck (deck);
	}
}
