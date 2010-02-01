
public class Egg {

  public static void main (String[] args) {
    int i = 7;

    while (true) {
      if (i%2==1 && i%3==1 && i%4==1 && i%5==1 && i%6==1) {
	System.out.println (i);
	return;
      }
      i = i + 7;
    }
  }

}



