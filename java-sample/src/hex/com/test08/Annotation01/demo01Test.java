package hex.com.test08.Annotation01;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;

public class demo01Test {

	@Test
	public void test() {
		demo01 dd = new demo01();
		dd.getClass().getDeclaredFields();
		dd.callme();
	}

	public static Object setFieldsNewInstance(Class cl, Map map)
			throws InstantiationException, IllegalAccessException

	{
		Object obj = null;
		obj = cl.newInstance();
		if (map == null)
			return obj;
		// for(Class wClazz = cl; wClazz != null; wClazz =
		// wClazz.getSuperclass())
		// setFields(obj, wClazz, map);

		return obj;
	}
}
