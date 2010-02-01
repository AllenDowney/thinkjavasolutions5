public class ListNode {
  public PQItem item;
  public ListNode next;

  // default constructor
  public ListNode () {
  }

  // other constructor
  public ListNode (PQItem item_, ListNode next_) {
    item = item_;
    next = next_;
  }
}
