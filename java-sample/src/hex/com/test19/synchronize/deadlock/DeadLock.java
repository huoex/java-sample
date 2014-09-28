package hex.com.test19.synchronize.deadlock;

/**
 * 死锁例子
 * jps
 * jstack -l Pid
 * @author crane.ding
 * @since 2011-3-20
 */
public class DeadLock {

	public static void main(String[] args) {
		final Object obj_1 = new Object(), obj_2 = new Object();

		Thread t1 = new Thread("t1") {
			@Override
			public void run() {
				synchronized (obj_1) {
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
					}

					synchronized (obj_2) {
						System.out.println("thread t1 done.");
					}
				}
			}
		};

		Thread t2 = new Thread("t2") {
			@Override
			public void run() {
				synchronized (obj_2) {
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
					}

					synchronized (obj_1) {
						System.out.println("thread t2 done.");
					}
				}
			}
		};

		t1.start();
		t2.start();
	}

}