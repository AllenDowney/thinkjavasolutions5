// from Standish, Data Structures in Java
// adapted by Allen Downey for cs231 Fall 1998

public class PriorityQueue {
  private int count;
  private int capacity;
  private int capacityIncrement;
  private PQItem[] itemArray;

  public PriorityQueue () {
    count = 0;
    capacity = 10;
    capacityIncrement = 10;
    itemArray = new PQItem[capacity];
  }

  public int size () {
    return count;
  }

  public void insert (PQItem newItem) {

    // this is a standard technique for making an infinite
    // array.  Whenever you run out of room, you double the size!
    if (count == capacity) {
      capacity += capacityIncrement;
      capacityIncrement *= 2;
      PQItem[] tempArray = new PQItem[capacity];
      for (int i=0; i<count;i++) {
	tempArray[i] = itemArray[i];
      }
      itemArray = tempArray;
    }
    itemArray[count] = newItem;
    count++;
  }

  public PQItem remove () {
    if (count == 0) return null;

    int maxPosition = 0;
    PQItem maxItem = itemArray[0];

    // find the item with the highest key
    for (int i=1; i<count; i++) {
      if (itemArray[i].compareTo(maxItem) > 0) {
	maxPosition = i;
	maxItem = itemArray[i];
      }
    }
    // move the last item into the (soon-to-be) empty slot
    count--;
    itemArray[maxPosition] = itemArray[count];
    return maxItem;
  }

  // ***** Code above this line is the implementation of the PQ ADT
  // ***** Code below this line is client code that tests the implementation

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
