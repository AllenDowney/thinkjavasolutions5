public class Card
{
  public int suit, rank;

  public Card () { 
    this.suit = 0;  this.rank = 0;
  }

  public Card (int suit, int rank) { 
    this.suit = suit;  this.rank = rank;
  }

  public String printCard (Card c) {
    String[] suits = { "Clubs", "Diamonds", "Hearts", "Spades" };
    String[] ranks = { "narf", "Ace", "2", "3", "4", "5", "6",
		 "7", "8", "9", "10", "Jack", "Queen", "King" };

    return ranks[c.rank] + " of " + suits[c.suit];
  }

  // compareCards

  public static int compareCards (Card c1, Card c2) {
    int s1 = ((c1.rank + 11) % 13) * 13 + c1.suit;
    int s2 = ((c2.rank + 11) % 13) * 13 + c2.suit;
    if (s1 > s2) return -1;
    if (s2 > s1) return 1;
    return 0;
  }
	
  public int compareTo (Card that) {
    if (this.suit > that.suit) return 1;
    if (this.suit < that.suit) return -1;

    int thisRank = (this.rank + 11) % 13;
    int thatRank = (that.rank + 11) % 13;

    if (thisRank > thatRank) return 1;
    if (thisRank < thatRank) return -1;
    return 0;
  }

  public boolean equals (Card that) {
    return (this.suit == that.suit && this.rank == that.rank);
  }

  public static int findCard (Card[] deck, Card card) {
    for (int i = 0; i< deck.length; i++) {
      if (deck[i].equals (card)) return i;
    }
    return -1;
  }

  public static int findBisect (Card[] deck, Card card, int low, int high) {
    System.out.println (low + ", " + high);

    if (high < low) return -1;

    int mid = (high + low) / 2;
    int comp = deck[mid].compareTo (card);

    if (comp == 0) {
      return mid;
    } else if (comp > 0) {
      return findBisect (deck, card, low, mid-1);
    } else {
      return findBisect (deck, card, mid+1, high);
    }
  }

  public static void main (String[] args) {
    Card[] deck = new Card [52];

    int index = 0;
    for (int suit = 0; suit <= 3; suit++) {
      for (int rank = 1; rank <= 13; rank++) {
	deck[index] = new Card (suit, rank);
	index++;
      }
    }

    Card card1 = new Card (1, 11);
    System.out.println (findBisect (deck, card1, 0, 51));
  }
}
