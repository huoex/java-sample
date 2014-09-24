package hex.com.test07.Thread.jion;
class ThreadTesterA implements Runnable {
  private int i;
  public void run() {
    try {
      while (i <= 10) {
        System.out.println("ThreadTesterA = " + i + " ");
        Thread.sleep(500);
        i++;
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}