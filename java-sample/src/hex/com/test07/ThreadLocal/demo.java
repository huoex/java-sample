package hex.com.test07.ThreadLocal;

public class demo {

	/**
	 * @param args
	 */

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		@SuppressWarnings("rawtypes")
		ThreadLocal threadLocal = new ThreadLocal();
		A a = new A();
		B b = new B();
		b.setName("zs");
//		System.out.println(b);
		threadLocal.set(a);
		threadLocal.set(b);
		b.setName("ls");
		B bt = (B) threadLocal.get();
		System.out.println(bt);

	}

}
