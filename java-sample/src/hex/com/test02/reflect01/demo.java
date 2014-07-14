package hex.com.test02.reflect01;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class demo {

	public static void main(String[] args) throws InstantiationException,
			IllegalAccessException, SecurityException, NoSuchMethodException,
			IllegalArgumentException, InvocationTargetException {

		Object obj = A.class.newInstance();

		// call fun()
		Method m1 = A.class.getDeclaredMethod("fun", new Class[] {});
		m1.invoke(obj, new Object[] {});
		// call fun(String s)
		Method m2 = A.class.getDeclaredMethod("fun", String.class);
		m2.invoke(obj, new String());
	}

}
