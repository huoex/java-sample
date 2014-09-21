package hex.com.test07.Thread.jion;

/**
 * Thread的非静态方法join()让一个线程t2“加入”到
 * 另外一个线程t1的尾部。在A执行完毕之前，B不能执行
 *
 */
public class MyThread {
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new ThreadTesterA());
		Thread t2 = new Thread(new ThreadTesterB());

		System.out.println("准备执行线程");
		t1.start();
		System.out.println("已经启动线程t1");

		t1.join(); // 等待线程t1执行完时才向下执行

		t2.start();
		System.out.println("已经启动线程t2");
		t2.join(); // 等待线程t2执行完时才向下执行

		System.out.println("总线程执行结束");
	}
}