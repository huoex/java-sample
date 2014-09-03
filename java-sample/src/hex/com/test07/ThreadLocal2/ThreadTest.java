package hex.com.test07.ThreadLocal2;
class ThreadTest extends Thread {
	
	public static ThreadLocal<Integer> thLocal = new ThreadLocal<Integer>();
	public static ThreadLocal<String> thLocal2 = new ThreadLocal<String>();
	
	public Integer num;
	
	
	
	public ThreadTest(Integer num) {
		super("线程" + num);
		this.num = num;
	}

	@SuppressWarnings("unused")
	@Override
	public void run() {
		Integer n = thLocal.get();
		if(num != 20) {
			String s = thLocal2.get();
		}
			
		if(n == null) {
			thLocal.set(num);
		}
		System.out.println(thLocal.get());
	}
	
}