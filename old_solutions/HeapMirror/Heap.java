import java.io.*;
import java.util.*;

public class Heap {
  public int value;
  public Heap left, right;
  public int rank;

  public static int removedValue;

  static int LEFT = 0;
  static int RIGHT = 1;

  public Heap (int value_, Heap left_, Heap right_) {
    value = value_;
    left = left_;
    right = right_;
  }

  public static Heap insert (Heap heap, int value) {
    // traverse the tree and assign ranks to everyone
    labelRank (heap);

    // then do the actual insertion
    return insertHelp (heap, value);
  }

  public static Heap insertHelp (Heap heap, int value) {

    // to add a new element to a null heap, just create a new object
    if (heap == null) {
      return new Heap (value, null, null);
    }

    // figure out which side is going to get the new object
    int choice = LEFT;
    if (heap.left == null) {
      choice = LEFT;
    } else if (heap.right == null) {
      choice = RIGHT;
    } else if (heap.left.rank > heap.right.rank) {
      choice = RIGHT;
    }

    // call insertHelp recursively on the appropriate child,
    // then check for the heap property when the child returns.
    if (choice == LEFT) {
      heap.left = insertHelp (heap.left, value);
      if (heap.value < heap.left.value) {
	swapContents (heap, heap.left);
      }
    } else {
      heap.right = insertHelp (heap.right, value);
      if (heap.value < heap.right.value) {
	swapContents (heap, heap.right);
      }
    }
    return heap;
  }

  public static void swapContents (Heap h1, Heap h2) {
    int temp = h1.value;
    h1.value = h2.value;
    h2.value = temp;
  }

  public static Heap remove (Heap heap) {
    if (heap == null) return null;

    // put the primary return value into removedValue
    removedValue = heap.value;

    // then fix the broken heap
    return reheapify (heap);
  }

  public static Heap reheapify (Heap heap) {

    // reheapify by recursively removing an element from
    // the larger of the two children
    int larger;

    // if there are no children, return an empty heap
    if (heap.left == null && heap.right == null) return null;

    // larger indicates which of the children is larger
    if (heap.left == null) {
      larger = RIGHT;
    } else {
      larger = LEFT;

      if (heap.right != null && heap.right.value > heap.left.value) {
	larger = RIGHT;
      }
    }

    // steal a value from the larger child and reheapify that child
    if (larger == LEFT) {
      heap.value = heap.left.value;
      heap.left = reheapify (heap.left);
    } else {
      heap.value = heap.right.value;
      heap.right = reheapify (heap.right);
    }
    return heap;
  }

  public static boolean isLeaf (Heap heap) {
    if (heap == null) return false;
    return heap.left == null && heap.right == null;
  }

  public static boolean isHeap (Heap heap) {
    if (heap == null) return true;

    if (heap.left != null) {
      if (heap.left.value > heap.value) return false;
      if (!isHeap (heap.left)) return false;
    }
    if (heap.right != null) {
      if (heap.right.value > heap.value) return false;
      if (!isHeap (heap.right)) return false;
    }
    return true;
  }


  // height finds the height of the given node (longest
  // distance to a leaf node)
  public static int height (Heap heap) {
    if (heap == null) return 0;
    int left = height (heap.left) + 1;
    int right = height (heap.right) + 1;
    if (left > right) return left;
    return right;
  }

  // rank is the minimum distance from a node to a leaf
  // labelRank traverses the tree and labels each node with
  // its rank.

  public static int labelRank (Heap heap) {
    if (heap == null) return 0;
    int left = labelRank (heap.left) + 1;
    int right = labelRank (heap.right) + 1;

    if (left < right) {
      heap.rank = left;
    } else {
      heap.rank = right;
    }
    return heap.rank;
  }

  public static void printHeap (Heap heap) {

    int height = height (heap);

    for (int i = 0; i<height; i++) {
      printLevel (heap, i, 0);
      System.out.println ("");
    }
  }

  public static void printLevel (Heap heap, int level, int sofar) {
    if (sofar == level) {
      if (heap == null) {
	System.out.print ("n ");
      } else {
	System.out.print (heap.value + " ");
      }

    } else if (heap != null) {
      printLevel (heap.left, level, sofar+1);
      printLevel (heap.right, level, sofar+1);
    }
  }

  public static void mirror (Heap heap) {
    if (heap == null) return;
    Heap temp = heap.left;
    heap.left = heap.right;
    heap.right = temp;
    mirror (heap.left);
    mirror (heap.right);
  }

  public static void main (String[] args) {
    Heap heap = null;

    // generate items with random keys and put them in the Heap
    for (int i = 0; i<10; i++) {
      int x = (int) (Math.random() * 100);
      heap = insert (heap, x);
      //System.out.println ("Inserting " + x);
    }

    printHeap(heap);
    mirror(heap);
    printHeap(heap);

    // remove all the items from the Heap; they should be in order
    while (heap != null) {
      heap = remove (heap);
      //System.out.println ("Removing " + removedValue);
    }
  }
}

  
