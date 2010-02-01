import java.util.*;

public class Time {
  int hour, minute;
  double second;

  public Time () {
    this.hour = 0;
    this.minute = 0;
    this.second = 0.0;
  }

  public Time (int hour, int minute, double second) {
    this.hour = hour;
    this.minute = minute;
    this.second = second;
  }

  public Time (double secs) {
    this.hour = (int) (secs / 3600.0);
    secs -= this.hour * 3600.0;
    this.minute = (int) (secs / 60.0);
    secs -= this.minute * 60;
    this.second = secs;
  }

  public static void printTime (Time t) {
    System.out.println (t.hour + ":" + t.minute + ":" + t.second);
  }

  public static double convertToSeconds (Time t) {
    int minutes = t.hour * 60 + t.minute;
    double seconds = minutes * 60 + t.second;
    return seconds;
  }

  public static double subtractTimes (Time time1, Time time2) {
    double sec1 = convertToSeconds (time1);
    double sec2 = convertToSeconds (time2);
    return sec1 - sec2;
  }

  public static boolean after (Time time1, Time time2) {
    if (time2.hour > time1.hour) return true;
    if (time2.minute > time1.minute) return true;
    if (time2.second > time1.second) return true;
    return false;
  }

  public static Time difference (Time t1, Time t2) {
    Time diff = new Time ();
    diff.hour = t1.hour - t2.hour;
    diff.minute = t1.minute - t2.minute;
    diff.second = t1.second - t2.second;

    if (diff.second < 0) {
      diff.second += 60.0;
      diff.minute -= 1;
    }
    if (diff.minute < 0) {
      diff.minute += 60;
      diff.hour -= 1;
    }
    return diff;
  }

  public static Time addTime (Time t1, Time t2) {
    double seconds = convertToSeconds (t1) + convertToSeconds (t2);
    return new Time (seconds);
  }

  public static void increment (Time t1, double secs) {
    double seconds = convertToSeconds (t1) + secs;
    t1 = new Time (seconds);
  }

  public static void main (String[] args) {

    Time t1 = new Time (11, 59, 3.14159);
    Time t2 = new Time (10, 58, 0.0);
    Time t3 = new Time (convertToSeconds (t1));
    printTime (t3);

    System.out.println (after (t2, t1));
    Time currentTime = new Time (9, 49, 30.0);
    Time breadTime = new Time (3, 35, 30.0);
    Time doneTime = addTime (currentTime, breadTime);
    printTime (doneTime);
  }
}
