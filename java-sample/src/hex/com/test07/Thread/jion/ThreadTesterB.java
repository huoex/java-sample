package hex.com.test07.Thread.jion;
class ThreadTesterB implements Runnable {
  private int i;
  public void run() {
    try {
      while (i <= 10) {
        System.out.println("ThreadTesterB = " + i + " ");
        Thread.sleep(500);
        i++;
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}