package hex.com.test07.Thread.Semaphore3;

import java.util.concurrent.Semaphore;

public class Main {
 
    private static class NumberThread extends Thread {
 
        private final int start;
        private final int step;
        private final int limit;
        private final Semaphore from;
        private final Semaphore to;
 
        public NumberThread(String threadName, int start, int step, int limit, Semaphore from, Semaphore to) {
            super(threadName);
            this.start = start;
            this.step = step;
            this.limit = limit;
            this.from = from;
            this.to = to;
        }
 
        public void run() {
 
            int number = start;
 
            while (number <= limit) {
                from.acquireUninterruptibly();
                System.out.println(getName() + ": " + number);
                number += step;
                to.release();
            }
        }
    }
 
    public static void main(String[] args) throws InterruptedException {
        final Semaphore oddSemaphore = new Semaphore(1);
        final Semaphore evenSemaphore = new Semaphore(0);
 
        new NumberThread("Odd  Thread", 1, 2, 100, oddSemaphore, evenSemaphore).start();
        new NumberThread("Even Thread", 2, 2, 100, evenSemaphore, oddSemaphore).start();
    }
}