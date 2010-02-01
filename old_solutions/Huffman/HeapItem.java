public class HeapItem implements Comparable {
  public int freq;
  public char c;

  HeapItem (int freq_, char c_) {
    freq = freq_;
    c = c_;
  }

  public String toString () {  return Integer.toString (freq);  }

  public int compareTo (Comparable other) {
    int a = this.freq;
    int b = ((HeapItem) other).freq;

    // the WINNER is the item with the lower frequency
    if (a>b) return -1;
    if (a<b) return 1;
    return 0;
  }
}

