public class List {
  public int value;
  public List next, prev;

  public List (int value, List next, List prev) 
    {  this.value = value;  this.next = next;  this.prev = prev;  }

  // create a new node with the given value and add it to
  // the beginning of the list.  Return a pointer to the newly
  // elongated list
  public static List insertNewFirstNode (List list, int value)
  {
    list = new List (value, list, null);
    if (list.next != null) list.next.prev = list;
    return list;
  }

  // remove the first element from the list and return a reference
  // to the newly shortened list
  public static List removeFirstNode (List list)
  {
    if (list == null) return null;
    return list.next;
  }

  // remove the given element from the list, if it is in the
  // list, and return the modified list
  public static List removeNode (List list, List node)
  {
    if (list == node) return removeFirstNode (list);

    for (List temp = list; temp != null; temp = temp.next) {
      if (temp == node) {
	if (temp.prev != null) temp.prev.next = temp.next;
	if (temp.next != null) temp.next.prev = temp.prev;
	return list;
      }
    }
    // error: the given node was not in the list
    return list;
  }

  public static void print (List head) {
    for (List list = head; list != null; list = list.next) {
      System.out.print (list.value + " ");
    }
    System.out.println ("");
  }

  public static void main (String[] args) {
    List list = null;
    list = insertNewFirstNode (list, 1);
    list = insertNewFirstNode (list, 2);
    list = insertNewFirstNode (list, 3);
    print (list);
  }
}
