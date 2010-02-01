import java.awt.Point;

public class Exam {

  // minmax finds the largest and smallest elements of an
  // array.  It creates and returns a new Point object
  // that contains the largest element in x and the
  // smallest element in y

  public static Point minmax (int[] a) {
    int n = a.length;
    Point mm = new Point (a[0], a[0]);

    for (int i=1; i<n; i++) {
      if (a[i] > mm.x) mm.x = a[i];
      if (a[i] < mm.y) mm.y = a[i];
    }
    return mm;
  }

  public static int pow (int x, int n) {
    if (n==0) return 1;
    int t = pow (x, n/2);
    if (n%2 == 0) {
      return t*t;
    } else {
      return t*t*x;
    }
  }

  public static int[] make (int n) {
    int[] a = new int[n];

    for (int i=0; i<n; i++) {
      a[i] = i+1;
    }
    return a;
  }

  public static void dub (int[] jub) {
    for (int i=0; i<jub.length; i++) {
      jub[i] *= 2;
    }
  }

  public static int mus (int[] zoo) {
    int fus = 0;
    for (int i=0; i<zoo.length; i++) {
      fus = fus + zoo[i];
    }
    return fus;
  }

  public static void main (String[] args) {
    int[] bob = make (5);
    dub (bob);

    System.out.println (mus (bob));
    
    Point p = minmax (bob);
    System.out.println (p);

    System.out.println (pow(2,5));
    System.out.println (pow(6,4));
  }
}

