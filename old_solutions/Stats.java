public class Stats
{
  public static void main(String args[]) {

    // note: I generally do a poor job of testing my programs
    // because I am lazy.  You should treat the following
    // as a BAD example.

    int numValues = 18;
    int[] a = randomIntArray (numValues, 0, 100);
    printArray (a);

    System.out.println ("num between 10 and 19 = " + inRange(a, 10, 19));
    System.out.println ("max = " + max (a));
    System.out.println ("find17 = " + find (a, 17));

    sortArray (a);
    printArray (a);
  }

  public static int randInt (int low, int high) {
    // the documentation of random is ambiguous; it does
    // not specify whether 1.0 is possible.  If so, then
    // this method may very rarely produce a value out
    // of range.  The while loop fixes that problem by
    // discarding anything out of range.

    while (true) {
      int x = (int)(Math.random() * (high-low+1) + low);
      if (x >= low && x <= high) return x;
    } 
  }

  public static int[] randomIntArray (int n, int low, int high) {
    int[] a = new int[n];
    for (int i = 0; i<a.length; i++) {
      a[i] = randInt (low, high);
    }
    return a;
  }

  public static void printArray (int[] a) {
    for (int i = 0; i<a.length; i++) {
      System.out.println (a[i]);
    }
  }

  // inRange: count the number of elements that are between
  // low and high, including both ends

  public static int inRange (int[] a, int low, int high) {
    int count = 0;
    for (int i=0; i<a.length; i++) {
      if (a[i] >= low && a[i] <= high) {
	count++;
      }
    }
    return count;
  }

  // max: find the largest element in the array
  public static int max (int[] a) {
    return maxInRange (a, 0, a.length-1);
  }

  // maxInRange: find the largest element in the given
  // range of indices, from low to high, including both

  public static int maxInRange (int[] a, int low, int high) {
    if (low == high) return a[low];

    int mid = (low + high) / 2;
    int max1 = maxInRange (a, low, mid);
    int max2 = maxInRange (a, mid+1, high);

    if (max1 > max2) {
      return max1;
    } else {
      return max2;
    }
  }

  // find: find the index of the first element of the array
  // that equals p, or -1 if p does not appear in the array

  public static int find (int[] a, int p) {
    return findInRange (a, p, 0, a.length-1);
  }


  // findInRange: same as find, except that it only considers
  // the range of indices from low to high, including both

  public static int findInRange (int[] a, int p, int low, int high) {

    // if there is only one element, then check if it is
    // the target.  If so, return the index.  Otherwise, return -1.
    if (low == high) {
      if (a[low] == p) {
	return low;
      } else {
	return -1;
      }
    }

    int mid = (low + high) / 2;
    int find1 = findInRange (a, p, low, mid);
    if (find1 != -1) {
      return find1;
    }
    int find2 = findInRange (a, p, mid+1, high);
    return find2;
  }

  // total: add up all the elements of the array

  public static int total (int[] a) {
    return totalWorker (a, 0, a.length-1);
  }

  // totalWorker: add up all the elements in the range from
  // low to high, including both

  public static int totalWorker (int[] a, int low, int high) {

    // if the range only contains one element, the total is
    // equal to that element
    if (low == high) return a[low];

    // otherwise, break the array into two pieces and find
    // the total in each half
    int mid = (low + high) / 2;

    // actually, this method will work with any value of
    // mid between low and high-1
    int total1 = totalWorker (a, low, mid);
    int total2 = totalWorker (a, mid+1, high);

    // on the way back from the recursion is where the actual
    // addition takes place
    return total1 + total2;
  }

  // indexOfMaxInRange: find the index of the largest element
  // in the array (considering only the elements between low
  // and high, including both

  public static int indexOfMaxInRange (int[] a, int low, int high) {
    int winner = low;
    for (int i=low+1; i<=high; i++) {
      if (a[i] > a[winner]) winner = i;
    }
    return winner;
  }

  // swapElements: exchange the ith and jth elements of the array

  public static void swapElements (int[] a, int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }

  // sortArray: sort the array by finding the largest element
  // of the remaining array one at a time

  public static void sortArray (int[] a) {
    for (int i=0; i<a.length; i++) {
      int j = indexOfMaxInRange (a, i, a.length-1);
      swapElements (a, i, j);
    }
  }
}


