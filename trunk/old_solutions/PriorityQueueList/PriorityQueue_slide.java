public class PriorityQueue {
  private List list;

  public PriorityQueue () {  list = new List (); }

  public int size () { return list.length; }

  public void insert (PQItem newItem) {
    PQItem item;
    ListNode node;

    // traverse the list until we find the first node
    // less than the new one 
    for (node = list.head; node!=null; node=node.next) {
      item = node.item;
      if (item.compareTo (newItem) < 1) break;
    }

    // if there are no nodes less than the new one,
    // join the end of the queue.  Otherwise, cut
    // in front of the loser.

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
}
