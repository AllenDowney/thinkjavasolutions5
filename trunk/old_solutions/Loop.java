public class Loop {

  public static void main (String[] args) {
    String fruit = "banana";
    int len = fruit.length();
    char c = fruit.charAt (len-1);
    System.out.println (c);
    // loop (10);
    check ("");

    char x = 'a';
    System.out.println (++x);


    System.out.println (itSum (2, 4));
    System.out.println (itProd (2, 4));
  }

  public static void check (String t) {
    String s = "((3 + 7) * 2)";
    int count = 0;
    int len = s.length ();
    int i = 0;
    while (i < len) {
      char c = s.charAt(i);
      System.out.println (c);
      if (c == '(') {
	count = count + 1;
      } else if (c == ')') {
	count = count - 1;
      }
      i = i + 1;
    }
    System.out.println (count);
  }

  public static void loop (int n) {
    int i = n;
    while (i > 0) {
      System.out.println (i);
      if (i%2 == 0) {
	i = i/2;
      } else {
	i = i+1;
      }
    }
  }

  public static int itSum (int m, int n) {
    int i = m;
    int total = 0;

    while (i <= n) {
      total = total + i;
      i = i + 1;
    }
    return total;
  }

  public static int itProd (int m, int n) {
    int i = m;
    int total = 1;

    while (i <= n) {
      total = total * i;
      i = i + 1;
    }
    return total;
  }
}
