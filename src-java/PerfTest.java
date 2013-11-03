public class PerfTest {

  private static Object lock = new Object();

  public static long foo(long x) {
    if (x > 0) {
      return x + 1;
    } else {
      synchronized(lock) {
        return x - 1;
      }
    }
  }

  public static long bar(long x) {
    if (x > 0) {
      return x + 1;
    } else {
      return x - 1;
    }
  }

  public static long baz(long x) {
    if (x > 0) {
      return x + 1;
    } else {
      return lockingPart(x);
    }
  }

  public static long lockingPart(long x) {
    synchronized(lock) {
      return x - 1;
    }
  }
}



