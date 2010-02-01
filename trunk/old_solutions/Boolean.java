public class Boolean {

  public static void main (String[] args) {
    int number = 202;
    boolean flag1 = isHoopy (number);
    boolean flag2 = isFrabjuous (number);
    System.out.println (flag1);
    System.out.println (flag2);

    if (flag1 & flag2) {
      System.out.println ("ping!");
    }
    if (flag1 | flag2) {
      System.out.println ("pong!");
    }
  }

  public static boolean isHoopy (int x) {
    boolean hoopyFlag;
    if (x%2 == 0) {
      hoopyFlag = true;
    } else {
      hoopyFlag = false;
    }
    return hoopyFlag;
  }

  public static boolean isFrabjuous (int x) {
    boolean frabjuousFlag;
    if (x > 0) {
      frabjuousFlag = true;
    } else {
      frabjuousFlag = false;
    }
    return frabjuousFlag;
  }
}
