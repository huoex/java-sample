package hex.com.test07.Thread.Sample02;
import java.util.concurrent.CountDownLatch;
/**
 * 统计从执行开始，到最后N个线程都执行完之后所消耗的总时间
 *
 */
public class Test {   
 
	public static void main(String[] args) {
		long startTime= System.currentTimeMillis();//开始时间
		int threadNumber = 2;   
		final CountDownLatch countDownLatch = new CountDownLatch(threadNumber);   

		new Thread(new Runnable(){
			public void run(){
				for(int i=0;i<1000;i++){
					System.out.println("A:"+i);
				}
				countDownLatch.countDown();
			}
		}).start();

		new Thread(new Runnable(){			
			public void run() {
				for(int j=0;j<1000;j++){
					System.out.println("B:"+j);		
				}
				countDownLatch.countDown();
			}
		}).start();   
		 try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   

		System.out.println("执行总时间:"+(System.currentTimeMillis()-startTime));
	}
}  