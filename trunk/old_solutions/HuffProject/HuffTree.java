public class HuffTree implements Comparable {
  int freq;
  char c;
  HuffTree left, right;

  public HuffTree (int freq_, char c_, HuffTree left_, HuffTree right_) {
    freq = freq_;
    c = c_;
    left = left_;
    right = right_;
  }

  public boolean isLeaf () {  return (left == null && right == null);  }

  public String toString () {  return "{" + c + "," + freq + "}";  }

  public int compareTo (Comparable other) {

    // fill this is, keeping in mind that for HuffTrees, the
    // the WINNER is the item with the lower frequency
    
    return 0;

  }

  public static int height (HuffTree tree) {
    if (tree == null) return 0;
    int left = height (tree.left) + 1;
    int right = height (tree.right) + 1;
    if (left > right) return left;
    return right;
  }

  // I have provided the following code to help you with debugging

  public void print () {

    int height = height (this);

    for (int i = 0; i<height; i++) {
      printLevel (this, i, 0);
      System.out.println ("");
    }
  }

  public static void printLevel (HuffTree tree, int level, int sofar) {
    if (sofar == level) {
      if (tree == null) {
        System.out.print ("n ");
      } else {
        System.out.print (tree + " ");
      }

    } else if (tree != null) {
      printLevel (tree.left, level, sofar+1);
      printLevel (tree.right, level, sofar+1);
    }
  }
}

  
