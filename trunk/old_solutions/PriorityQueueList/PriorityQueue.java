// from Standish, Data Structures in Java
// adapted by Allen Downey for cs231 Fall 1998

import java.util.*;

public class PriorityQueue {
  private List list;

  public PriorityQueue () {
    list = new List ();
  }

  public int size () {
    return list.length;
  }

  public void insert (PQItem newItem) {
    PQItem item;
    ListNode node;

    // traverse the list until we find the first node less than
    // the new one 
    for (node = list.head; node!=null; node=node.next) {
      item = node.item;
      if (item.compareTo (newItem) < 1) break;
    }

    if (node == null) {
      list.insertNewLastNode (newItem);
    } else {
      ListNode newNode = new ListNode (newItem, null);
      list.insertBefore (node, newNode);
    }
  }

  public PQItem remove () {
    ListNode first = list.head;
    if (first == null) return null;

    list.deleteFirst ();
    return first.item;
  }

  // --------------------------------------------------

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

    // remove all the items from the PQ; they should be in order
    while (true) {
      item = pq.remove ();

      // when remove returns null, we're done
      if (item == null) break;
      System.out.println ("Removing " + item);
    }
  }
}
