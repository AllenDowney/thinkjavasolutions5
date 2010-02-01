public class Controller {

  // the controller class creates all the objects and
  // then pretty much lets them run

  public static void main (String[] args) {
    Counter c1 = new Counter ();
    CounterView cv1 = new CounterView (c1);
    Counter c2 = new Counter ();
    CounterView cv2 = new CounterView (c2);
  }
}
