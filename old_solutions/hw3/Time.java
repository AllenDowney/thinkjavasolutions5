
public class Time {

  public static void main (String[] args) {

    int hour = 13;
    int minute = 9;
    int second = 37;

    int secondsSinceMidnight = (hour * 60 + minute) * 60 + second;
    int totalSeconds = 24 * 60 * 60;
    int secondsUntilMidnight = totalSeconds - secondsSinceMidnight;
    int percentage = secondsSinceMidnight * 100 / totalSeconds;

    System.out.println ("Seconds since midnight = " + secondsSinceMidnight);
    System.out.println ("Seconds until midnight = " + secondsUntilMidnight);
    System.out.println ("Percentage of day elapsed = " + percentage);
  }
}
