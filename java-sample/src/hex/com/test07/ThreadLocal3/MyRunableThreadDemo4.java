package hex.com.test07.ThreadLocal3;

/**
 *
 *同步方法(synchronized)
 */
public class MyRunableThreadDemo4 {
	public static void main(String args[]) {
		MyRunableThread1 mrt = new MyRunableThread1();
		Thread t1 = new Thread(mrt, "t1");
		Thread t2 = new Thread(mrt, "t2");
		Thread t3 = new Thread(mrt, "t3");
		t1.start();
		t2.start();
		t3.start();
	}

	static class MyRunableThread1 implements Runnable {
		private int ticket = 200;

		@Override
		public void run() {
			for (int i = 0; i < 100; i++) {
				sale();
			}
		}

		public synchronized void sale() {
			if (ticket > 0) {
				try {
					Thread.sleep(30);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()
						+ "卖了一张票票，剩余ticket=" + --ticket);// 这里--ticket表示卖了一张票后的余票
			}
		}
	}
}