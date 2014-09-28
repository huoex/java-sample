package hex.com.test07.Thread.Semaphore3;
import java.util.concurrent.Semaphore;
 
public class EvenThread implements Runnable {
	
private Semaphore semaphore;
	
	public EvenThread(Semaphore semaphore){
		
		this.semaphore = semaphore;
		
	}
 
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i=0; i< 100;i++){
			
			try {
				semaphore.acquire();
				int number= 2*i+2;
				System.out.println("Even = " +  number);
				semaphore.release();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
 
	}
 
}