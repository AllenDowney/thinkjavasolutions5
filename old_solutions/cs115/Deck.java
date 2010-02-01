public class Deck
{
	// the Deck class contains only one instance variable, named cards
	Card[] cards;
	
	// the default constructor (no arguments) creates a populated 52-card deck
	public Deck ()
	{
		int index = 0;
		cards = new Card [52];
		for (int suit = 0; suit < 4; suit++) {
			for (int rank = 1; rank <= 13; rank++) {
				cards[index] = new Card (suit, rank);  index++;
			}
		}
	}
	// the other constructor only creates the array; it doesn't create any cards
	public Deck (int length)
	{
		cards = new Card [length];
	}
	
	public Deck subdeck (int low, int high)
	{
		Deck d = new Deck (high-low+1);
		
		// notice that to get the length of a Deck, you have to get the length of the
		// array named cards; "d.length" is illegal because d is a Deck, not an array
		for (int i = 0; i<d.cards.length; i++) {
		
			// here "d.cards" refers to the new array; "cards" by itself refers to
			// the instance variable of the current object.
			d.cards[i] = cards[low+i];
		}
		return d;
	}
	
	// Since printDeck is an object method now, I am just calling it "print".
	// I've done the same with sort and shuffle.
	public void print ()
	{
		for (int i=0; i<cards.length; i++) System.out.println (cards[i]);
	}
	
	public void swapCards (int i, int j)
	{
		Card temp = cards[i];  cards[i] = cards[j];  cards[j] = temp;
	}
	
	// randInt: returns a random integer [low, high]  (including low and  high)
	public static int randInt (int low, int high)
	{
		double x = Math.random() * (high - low + 1);
		return (int) x + low;
	}
	// find the highest card in the array, starting with the ith card
	public int findHighestCard (int i)
	{
		int index = i;
		for (i = i+1; i<cards.length; i++)
			if (Card.compareCards (cards[i], cards[index]) == -1)
				index = i;
		return index;
	}
	
	// this is the shuffle algorithm we implemented last week
	public void shuffle ()
	{
		for (int i=0; i<cards.length; i++) {
			int j = randInt (i, cards.length-1);
			swapCards (i, j);
		}
	}
	
	// this is the old version of sort we did last week
	public void sort ()
	{
		for (int i=0; i<cards.length; i++) {
			int j = findHighestCard (i);
			swapCards (i, j);
		}
	}
	
	// this method wasn't part of the assignment, but it is definitely the kind of
	// thing I would put on an exam
	public int findCard (Card card)
	{
		for (int i=0; i<cards.length; i++) {
		
			// two cards are considered to be the same if they have the same rank
			// and suit (even if they are not the same object)
			if (cards[i].rank == card.rank &&
				cards[i].suit == card.suit) return i;
		}
		return -1;
	}
	
	// concat takes two Decks and creates a new deck that contains all the cards from
	// the first deck followed by all the cards in the second deck
	public static Deck concat (Deck d1, Deck d2)
	{
		Deck result = new Deck (d1.cards.length + d2.cards.length);
		
		for (int i=0; i<d1.cards.length; i++)
			result.cards[i] = d1.cards[i];
			
		for (int i=0; i<d2.cards.length; i++)
			result.cards[i+d1.cards.length] = d2.cards[i];
		return result;
	}
	
	public static Deck merge (Deck d1, Deck d2)
	{
		// create the new deck
		Deck result = new Deck (d1.cards.length + d2.cards.length);
		
		int choice;    // records the winner (1 means d1, 2 means d2)
		int i = 0;     // traverses the first input deck
		int j = 0;     // traverses the second input deck
		
		// k traverses the new (merged) deck
		for (int k = 0; k<result.cards.length; k++) {
			choice = 1;
			
			// if d1 is empty, d2 wins; if d2 is empty, d1 wins; otherwise,
			// compare the two cards
			if (i == d1.cards.length)
				choice = 2;
			else if (j == d2.cards.length)
				choice = 1;
			else if (Card.compareCards (d1.cards[i], d2.cards[j]) == 1)
				choice = 2;
			
			// make the new deck refer to the winner card
			if (choice == 1) {
				result.cards[k] = d1.cards[i];  i++;
			} else {
				result.cards[k] = d2.cards[j];  j++;
			}			
		}
		return result;
	}
	
	// this is not really mergeSort yet, because it uses the insertion sort to
	// sort the two halves, rather than doing it recursively
	public Deck mergeSort ()
	{
		int mid = (cards.length-1) / 2;
		
		// divide the deck roughly in half
		Deck d1 = subdeck (0, mid);
		Deck d2 = subdeck (mid+1, cards.length-1);

		// sort the halves (the old sort is a modifier method, so it has no return value)
		d1.sort ();
		d2.sort ();
		
		// merge the two halves and return the result (d1 and d2 get garbage collected)
		return merge (d1, d2);
	}
	
	
	
	
	
	public static void main (String[] args)
	{
		// create a new Deck and shuffle it; notice that shuffle is a modifier method
		Deck d = new Deck ();
		d.shuffle ();
		
		// notice that mergeSort returns a new, sorted Deck; it does not modify its argument
		Deck sorted = d.mergeSort ();
		sorted.print ();
	}
}