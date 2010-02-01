public class Recurse {

  public static int gcd (int m, int n)
  {
    if (n == 0) return m;
    return gcd (n, m%n);
  }

  public static int min2 (int[] array, int j, int k)
  {
    // base case is a range with a single element
    if (j == k) return array[j];

    // otherwise, split the array down the middle and find the min in
    // each half
    int mid = (j+k)/2;
    int a1 = min2 (array, j, mid);
    int a2 = min2 (array, mid+1, k);

    // return the minimum of the two results
    if (a1<a2) return a1;
    else return a2;
  }

  public static int min (int[] array)
  {
    return min2 (array, 0, array.length-1);
  }

  public static int ack (int m, int n)
  {
    if (m == 0) return n+1;
    if (n == 0) return ack (m-1, 1);
    return ack (m-1, ack(m, n-1));
  }
    
  public static void main (String[] args) {

    int m = 2312;
    int n = 17;
    System.out.println ("gcd of " + m + " and " + n + " is " + gcd (m,n));

    int[] a = new int[100];
    for (int i=0; i<a.length; i++) {
      a[i] = (i-50)*(i-50) + 200;
    }
    System.out.println (min(a));    

    for (int i = 0; i<4; i++) {
      for (int j = 0; j<9; j++) {
	System.out.print (ack(i, j) + "\t");
      }
      System.out.println();
    }
  }
}
