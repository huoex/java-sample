package hex.com.test07.Thread.ReadWriteLock;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockTest {
	private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
	private SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
	private Lock readLock = readWriteLock.readLock();
	private Lock writeLock = readWriteLock.writeLock();

	public void read() {
		readLock.lock();
		try {
			System.out.println(format.format(new Date()) + "---read---");
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			readLock.unlock();
		}
	}

	public void write() {
		writeLock.lock();
		try {
			System.out.println(format.format(new Date()) + "---write---");
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			writeLock.unlock();
		}
	}

	public static class MyThread extends Thread {
		private ReadWriteLockTest readWriteLockTest;
		private String methodName;

		public MyThread(ReadWriteLockTest readWriteLockTest, String methodName) {
			super();
			this.readWriteLockTest = readWriteLockTest;
			this.methodName = methodName;
		}

		@Override
		public void run() {
			if ("read".equalsIgnoreCase(methodName))
				readWriteLockTest.read();
			else
				readWriteLockTest.write();
		}
	}

	public static void main(String[] args) {
		ReadWriteLockTest test = new ReadWriteLockTest();
		Thread t1 = new MyThread(test, "read");
		Thread t2 = new MyThread(test, "write");
//		Thread t2 = new MyThread(test, "read");
		t1.start();
		t2.start();
	}
}