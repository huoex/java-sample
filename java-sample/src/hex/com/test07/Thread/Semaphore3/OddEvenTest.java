package hex.com.test07.Thread.Semaphore3;
import java.util.concurrent.Semaphore;
 
public class OddEvenTest {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Semaphore semaphore = new Semaphore(1,true);
		
		Runnable oddThread = new OddThread(semaphore);
		Runnable evenThread = new EvenThread(semaphore);
		
		
		new Thread(oddThread).start();
		new Thread(evenThread).start();
 
	}
 
}