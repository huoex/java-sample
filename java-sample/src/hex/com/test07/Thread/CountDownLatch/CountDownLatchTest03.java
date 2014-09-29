package hex.com.test07.Thread.CountDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * 让主线程等待所有子线程执行完毕
 * @author Administrator
 *
 */
public class CountDownLatchTest03 {
	public static void main(String[] args) throws InterruptedException {  
	        int threadNumber = 10;  
	        final CountDownLatch countDownLatch = new CountDownLatch(threadNumber);  
	        for (int i = 0; i < threadNumber; i++) {  
	            final int threadID = i;   
	            new Thread() {  
	                public void run() {  
	                    try {  
	                        Thread.sleep((long) (Math.random() * 10000));  
	                        System.out.println(String.format("threadID:[%s] finished!!", threadID));  
	                    } catch (InterruptedException e) {  
	                        e.printStackTrace();  
	                    } finally{
	                    	countDownLatch.countDown();  
	                    }
	                }  
	            }.start();  
	        }  
	        countDownLatch.await();  
	        System.out.println("main thread finished!!");  
	    }  
}

