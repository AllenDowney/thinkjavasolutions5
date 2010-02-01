public class HeapItem implements Comparable {
  public int value;

  HeapItem (int value_) {  value = value_;  }

  public String toString () {  return Integer.toString (value);  }

  public int compareTo (Comparable other) {
    int a = this.value;
    int b = ((HeapItem) other).value;

    // the book uses an alternate syntax for conditionals that
    // is harder to read
    if (a<b) return -1;
    if (a>b) return 1;
    return 0;
  }

  public static void main (String[] args) {
    Heap heap = null;

    // generate 100 items with random values and put them in the Heap
    for (int i = 0; i<100; i++) {
      int x = (int) (Math.random() * 100);
      HeapItem item = new HeapItem (x);
      heap = Heap.insert (heap, item);
      System.out.println ("Inserting " + x);
    }

    Heap.printHeap (heap);

    // remove all the items from the Heap; they should be in order
    while (heap != null) {
      heap = Heap.remove (heap);
      System.out.println ("Removing " + Heap.removedValue);
    }
  }
}

