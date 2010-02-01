// from Standish, Data Structures in Java
// adapted by Allen Downey for cs231 Fall 1998

public class PQItem {
  private int key;

  PQItem (int value) {
    key = value;
  }

  public String toString () {
    return Integer.toString(key);
  }

  public int compareTo (PQItem other) {
    int a = this.key;
    int b = other.key;

    // the book uses an alternate syntax for conditionals that
    // is harder to read
    if (a<b) return -1;
    if (a>b) return 1;
    return 0;
  }
}

  
