import java.util.*;

public class PriorityQueue {
  private Vector vector;

  public PriorityQueue () {
    vector = new Vector ();
  }

  public int size () {
    return vector.size();
  }

  public void insert (PQItem newItem) {
    Object obj = (Object) newItem;
    vector.addElement (obj);
  }

  public PQItem remove () {
    int n = vector.size ();
    if (n == 0) return null;

    PQItem champion = (PQItem) vector.firstElement();
    PQItem challenger;

    for (int i=1; i<n; i++) {
      challenger = (PQItem) vector.elementAt(i);
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

  public static PQItem removeNthItem (PriorityQueue pq, int n) {

    // make a temporary PQ
    PriorityQueue temp = new PriorityQueue();

    // remove the first n-1 items and store them in the temp PQ
    for (int i = 0; i<n-1; i++) {
      temp.insert(pq.remove());
    }
    // get the Nth item
    PQItem ret = pq.remove();

    // put the other n-1 items back
    for (int i = 0; i<n-1; i++) {
      pq.insert(temp.remove());
    }
    return ret;
  }

  public static void main (String[] args) {

    PriorityQueue pq = new PriorityQueue ();

    // generate 100 items with random keys and put them in the PQ
    PQItem item;
    for (int i = 0; i<100; i++) {
      int x = (int) (Math.random() * 100);
      item = new PQItem (x);
      pq.insert (item);
      System.out.println ("Inserting " + item);
    }

    System.out.println (removeNthItem (pq, 102));

    // remove all the items from the PQ; they should be in order
    while (true) {
      item = pq.remove ();

      // when remove returns null, we're done
      if (item == null) break;
      System.out.println ("Removing " + item);
    }
  }
}
