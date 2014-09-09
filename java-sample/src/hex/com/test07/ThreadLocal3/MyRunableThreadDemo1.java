package hex.com.test07.ThreadLocal3;

/**
 * 实现Runnable接口相对于继承Thrad类来说，有如下显著优势：
 * 适合多个相同程序代码的线程去处理同一资源的情况。
 * 可以避免由于java单继承特性带来的局限
 * 增强了程序的健壮性，代码能够被多个线程共享，代码与数据时独立的。
 *
 */
public class MyRunableThreadDemo1 {
	public static void main(String args[]) {
		MyRunableThread1 mrt = new MyRunableThread1();
		Thread t1 = new Thread(mrt);
		Thread t2 = new Thread(mrt);
		Thread t3 = new Thread(mrt);
		t1.start();
		t2.start();
		t3.start();
	}

	static class MyRunableThread1 implements Runnable {
		private int ticket = 5;

		@Override
		public void run() {
			// TODO Auto-generated method stub
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