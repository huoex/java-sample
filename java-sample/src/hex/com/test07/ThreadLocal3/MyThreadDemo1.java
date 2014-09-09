package hex.com.test07.ThreadLocal3;

public class MyThreadDemo1 {
	public static void main(String args[]) {
		MyThread1 mt1 = new MyThread1();
		MyThread1 mt2 = new MyThread1();
		MyThread1 mt3 = new MyThread1();
		mt1.start();
		mt2.start();
		mt3.start();
	}

	static class MyThread1 extends Thread {
		private int ticket = 5;

		@Override
		public void run() {
			for (int i = 0; i < 100; i++)
				if (ticket > 0)// 当余票大于0则买票
				{
					// 这里--ticket表示卖了一张票后的余票
					System.out.println(Thread.currentThread().getName()
							+ "卖一张票：剩余ticket=" + --ticket); 
				}
		}
	}
}