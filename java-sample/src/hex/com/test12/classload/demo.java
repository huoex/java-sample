package hex.com.test12.classload;

/**
 * 类加载的几种方式
 * 1，new A()
 * 2，Class.forname("package-path.class-name")
 * 3，ClassLoader loader = Thread.currentThread().getContextClassLoader();
 *    Class<?> clazz =loader.loadClass(A.class.getName());
 * @author hex
 *
 */
public class demo {
	public static void main(String[] args) {
		// 1，new A()
		System.out.println("***new init***");
		@SuppressWarnings("unused")
		A a = new A();
		
		// 2，Class.forname("package-path.class-name")
		System.out.println("***Class.forname init***");
		try {
			Class<?> clazz =Class.forName(A.class.getName());
			try {
				clazz.newInstance();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		// 3，ClassLoader loader = Thread.currentThread().getContextClassLoader();
		System.out.println("***ClassLoader init***");
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		try {
			Class<?> clazz =loader.loadClass(A.class.getName());
			try {
				clazz.newInstance();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
