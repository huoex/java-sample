package hex.com.test02.reflect01;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射
 * <pre>
 * 1，通过反射调用无参方法
 * 2，通过反射调用有参方法
 * <pre>
 * 
 * @version Ver1.00
 * @author huoex
 */
public class demo {

	public static void main(String[] args) throws InstantiationException,
			IllegalAccessException, SecurityException, NoSuchMethodException,
			IllegalArgumentException, InvocationTargetException {

		Object obj = A.class.newInstance();

		// 1，通过反射调用无参方法
		Method m1 = A.class.getDeclaredMethod("fun", new Class[] {});
		m1.invoke(obj, new Object[] {});
		// 2，通过反射调用有参方法
		Method m2 = A.class.getDeclaredMethod("fun", String.class);
		m2.invoke(obj, new String());
	}

}
