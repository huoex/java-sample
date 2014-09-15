package hex.com.test07.Thread.ReentrantLock;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
	private ReentrantLock lock = new ReentrantLock();
	private SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");

	public void printA() {
		lock.lock();
		System.out.println(format.format(new Date()) + "---printA");
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void printB() {
		lock.lock();
		System.out.println(format.format(new Date()) + "---printB");
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public static class MyThread extends Thread {
		private ReentrantLockTest reentrantLockTest;
		private String methodName;

		public MyThread(ReentrantLockTest reentrantLockTest, String methodName) {
			super();
			this.reentrantLockTest = reentrantLockTest;
			this.methodName = methodName;
		}

		@Override
		public void run() {
			if ("printA".equalsIgnoreCase(methodName))
				reentrantLockTest.printA();
			else
				reentrantLockTest.printB();
		}
	}

	public static void main(String[] args) {
		ReentrantLockTest test = new ReentrantLockTest();
		MyThread t1 = new MyThread(test, "printA");
		MyThread t2 = new MyThread(test, "printB");
		t1.start();
		t2.start();
	}
}