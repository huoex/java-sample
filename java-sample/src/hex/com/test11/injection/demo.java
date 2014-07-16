package hex.com.test11.injection;

import java.lang.reflect.Field;

/**
 * 依赖注入
 * 
 * @author hex
 * 
 */
public class demo {
	public static void main(String[] args) {
		A a = new A();
		injection(a);
		a.call();
	}

	@SuppressWarnings("rawtypes")
	public static Object injection(Object obj) {
		for (Class clazz = obj.getClass(); clazz != null; clazz = clazz
				.getSuperclass()) {
			Field fs[] = clazz.getDeclaredFields();
			Field afield[];
			int j = (afield = fs).length;
			for (int i = 0; i < j; i++) {
				Field f = afield[i];
				injection(obj, f);
			}

		}

		return obj;
	}

	public static void injection(Object obj, Field f) {
		bean o = new bean();
		fieldInjection(obj, f, o);

	}

	public static void fieldInjection(Object obj, Field field, Object arg) {
		field.setAccessible(true);
		try {
			field.set(obj, arg);
			System.out.println();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}
