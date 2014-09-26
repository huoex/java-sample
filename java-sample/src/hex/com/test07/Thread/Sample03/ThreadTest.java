package hex.com.test07.Thread.Sample03;

import java.util.Date;

/**
 * 创建四个线程，2，3，4线程开始就wait。1运行结束就notify 线程2。 
 * 每次运行的时候判断前一次运行时间和这次运行时间的时间差。 
 * @author jolestar
 */
public class ThreadTest {

	/**
     * 
     */
	public ThreadTest() {
	}

	private static class TestThread extends Thread {
		private Thread next;
		// 前一次运行时间
		private long preRuntime = 0;

		public TestThread(String name, Thread next) {
			super(name);
			this.next = next;
		}

		public void setNext(Thread next) {
			this.next = next;
		}

		@SuppressWarnings("static-access")
		@Override
		public void run() {
			synchronized (this) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			while (true) {
				// 前一次运行是否经过了1分钟
				if ((System.currentTimeMillis() - this.preRuntime) < 60 * 1000) {
					long time = 60 * 1000 - (System.currentTimeMillis() - this.preRuntime);
					System.out.println("need to sleep:" + time);
					try {
						this.sleep(time);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				dosomething();
				synchronized (this.next) {
					this.next.notify();
				}
				synchronized (this) {
					try {
						this.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}

		public void dosomething() {
			Date date = new Date();
			preRuntime = date.getTime();
			System.out.println(this.getName() + " do some thing." + date.toString());
		}

	}

	/**
	 * @param args
	 */
	public static void main(String [] args) {
		TestThread t1 = new TestThread("1", null);
		TestThread t2 = new TestThread("2", null);
		t1.setNext(t2);

		TestThread t3 = new TestThread("3", null);
		t2.setNext(t3);

		TestThread t4 = new TestThread("4", t1);
		t3.setNext(t4);

		t1.start();
		t2.start();
		t3.start();
		t4.start();

		System.out.println("notify t1");
		synchronized (t1) {
			t1.notify();
		}

	}

}