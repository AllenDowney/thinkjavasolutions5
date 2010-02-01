// from Standish, Data Structures in Java
// adapted by Allen Downey for cs231 Fall 1998

import java.util.*;

public class PriorityQueue {
  private Vector vector;

  public PriorityQueue () {
    vector = new Vector ();
  }

  public int size () {
    return vector.size();
  }

  public void insert (Comparable newItem) {
    Object obj = (Object) newItem;
    vector.addElement (obj);
  }

  public Comparable remove () {
    int n = vector.size ();
    if (n == 0) return null;

    Comparable champion = (Comparable) vector.firstElement();
    Comparable challenger;

    for (int i=1; i<n; i++) {
      challenger = (Comparable) vector.elementAt(i);
      if (challenger.compareTo(champion) > 0) {
	champion = challenger;
      }
    }
    vector.removeElement ((Object) champion);
    return champion;
  }

  // ***** If the ADT concept is working, I should not have to
  // ***** modify any code below this line when I change
  // ***** from the array implementation to the Vector implementation

  public static void main (String[] args) {

    PriorityQueue pq = new PriorityQueue ();

    // generate items with random keys and put them in the PQ
    PQItem item;
    for (int i = 0; i<10; i++) {
      int x = (int) (Math.random() * 100);
      item = new PQItem (x);
      pq.insert ((Comparable) item);
      System.out.println ("Inserting " + item);
    }

    // remove all the items from the PQ; they should be in order
    while (pq.size() > 0) {
      item = (PQItem) pq.remove ();
      System.out.println ("Removing " + item);
    }
  }
}

interface Comparable {
  int compareTo (Comparable other);
  String toString();
}

class PQItem implements Comparable {
  private int key;

  PQItem (int value) {
    key = value;
  }

  public String toString () {
    return Integer.toString(key);
  }

  public int compareTo (Comparable other) {
    int a = this.key;
    int b = ((PQItem) other).key;

    // the book uses an alternate syntax for conditionals that
    // is harder to read
    if (a<b) return -1;
    if (a>b) return 1;
    return 0;
  }
}

  
