// In this version of the Card class, a deck is an object containing
// an array of Cards, but everything is still written as a class method

public class Card
{
  int suit, rank;

  public Card () { 
    this.suit = 0;  this.rank = 0;
  }

  public Card (int suit, int rank) { 
    this.suit = suit;  this.rank = rank;
  }

  public static void printCard (Card c) {
    String[] suits = { "Clubs", "Diamonds", "Hearts", "Spades" };
    String[] ranks = { "narf", "Ace", "2", "3", "4", "5", "6",
		 "7", "8", "9", "10", "Jack", "Queen", "King" };

    System.out.println (ranks[c.rank] + " of " + suits[c.suit]);
  }

  // compareCards: returns 1 if the first card is greater
  // -1 if the seconds card is greater, and 0 if they are the same.

  public static int compareCards (Card c1, Card c2) {

    // first compare the suits

    if (c1.suit > c2.suit) return 1;
    if (c1.suit < c2.suit) return -1;

    // if the suits are the same,
    // use modulus arithmetic to rotate the ranks
    // so that the Ace is greater than the King.
    
    int rank1 = (c1.rank + 11) % 13;
    int rank2 = (c2.rank + 11) % 13;

    // compare the rotated ranks

    if (rank1 > rank2) return 1;
    if (rank1 < rank2) return -1;
    return 0;
  }

  public boolean sameCard (Card c1, Card c2) {
    return (c1.suit == c2.suit && c1.rank == c2.rank);
  }

  public static int findCard (Card[] deck, Card card) {
    for (int i = 0; i< deck.length; i++) {
      if (deck[i].equals (card)) return i;
    }
    return -1;
  }

  public static int findBisect (Card[] deck, Card card, int low, int high) {

    if (high < low) return -1;

    int mid = (high + low) / 2;
    int comp = compareCards (card, deck[mid]);

    if (comp == 0) {
      return mid;
    } else if (comp < 0) {
      // card is less than deck[mid]; search the first half
      return findBisect (deck, card, low, mid-1);
    } else {
      // card is greater; search the second half
      return findBisect (deck, card, mid+1, high);
    }
  }

  public static void shuffleDeck (Card[] deck) {
    for (int i=0; i<deck.length; i++) {
      int j = randInt (i, deck.length-1);
      swapCards (deck, i, j);
    }
  }

  public static int randInt (int low, int high) {
    while (true) {
      int x = (int)(Math.random() * (high-low+1) + low);
      if (x >= low && x <= high) return x;
    } 
  }

  public static void sortDeck (Card[] deck) {
    for (int i=0; i<deck.length; i++) {
      int j = indexLowestCard (deck, i, deck.length-1);
      swapCards (deck, i, j);
    }
  }

  public static void swapCards (Card[] deck, int i, int j) {
    Card temp = deck[i];
    deck[i] = deck[j];
    deck[j] = temp;
  }

  public static int indexLowestCard (Card[] deck, int low, int high) {
    int winner = low;
    for (int i=low+1; i<=high; i++) {
      if (compareCards (deck[i], deck[winner]) < 0) {
	winner = i;
      }
    }
    return winner;
  }

  public static Card[] subdeck (Card[] deck, int low, int high) {
    Card[] sub = new Card[high-low+1];
	
    for (int i = 0; i<sub.length; i++) {
      sub[i] = deck[low+i];
    }
    return sub;
  }

 public static void main (String[] args) {
    Deck deck = new Deck();
    //    sortDeck (deck);
    Deck.printDeck (deck);

    //    Card card1 = new Card (2, 11);
    //    Card card2 = new Card (1, 1);

    for (int i=0; i<52; i++) {
	//      System.out.println (findBisect (deck, deck[i], 0, 51));
    }

    //    Card[] hand = subdeck (deck, 4, 7);
    //    printDeck (hand);
  }
}

class Deck {
  Card[] cards;

  public Deck (int n) {
    cards = new Card[n];
  }

  public Deck () {
    cards = new Card[52];
    int index = 0;
    for (int suit = 0; suit <= 3; suit++) {
      for (int rank = 1; rank <= 13; rank++) {
        cards[index] = new Card (suit, rank);
        index++;
      }
    }
  }

  public static void printDeck (Deck deck) {
    for (int i=0; i<deck.cards.length; i++) {
      Card.printCard (deck.cards[i]);
    }
  }
}
