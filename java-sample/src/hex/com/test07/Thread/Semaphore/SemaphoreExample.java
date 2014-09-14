package hex.com.test07.Thread.Semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {

  // Shared resources to be guarded
  private static int count = 0;
  
  // Producer thread. Counts up the resource.
  private static class ProducerThread implements Runnable {

    private Semaphore s = null;
    
    ProducerThread(Semaphore s) {
      this.s = s;
    }
    
    @Override
    public void run() {
      try {
        System.out.println("Producer requesting permit");
        s.acquire();
        System.out.println("Producer gets permit");
        for ( int i = 0; i < 5; i++ ) {
          count = count + 1;
          System.out.println("Counting up");
        }
        Thread.sleep(5000);
        System.out.println("Producer releases permit");
        s.release();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    
  }
  
  // Consumer thread. Counts down the resource.
  private static class ConsumerThread implements Runnable {

    private Semaphore s = null;
    
    ConsumerThread(Semaphore s) {
      this.s = s;
    }
    
    @Override
    public void run() {
      try {
        System.out.println("Consumer requesting permit");
        s.acquire();
        System.out.println("Consumer gets permit");
        for ( int i = 0; i < 5; i++ ) {
          count = count - 1;
          System.out.println("Counting down");
        }
        System.out.println("Consumer releases permit");
        s.release();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    
  }
  
  // Main program
  public static void main(String[] args) {
    Semaphore semaphore = new Semaphore(1);
    Thread t1 = new Thread(new ProducerThread(semaphore));
    Thread t2 = new Thread(new ConsumerThread(semaphore));
    t1.start();
    t2.start();
  }
}