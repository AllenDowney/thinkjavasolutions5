public class Counter {
  private int value;
  private int max = 10;
  private int min = 0;

  public Counter () {
    value = 0;
  }

  public int getValue () {
    return value;
  }

  public String getValueString () {
    return Integer.toString (value);
  }

  public void setValue (int newVal) {
    value = newVal;
  }

  public void increment () {
    value++;
    if (value > max) value = max;
  }

  public void decrement () {
    value--;
    if (value < min) value = min;
  }
}
