package hex.com.test02.reflect02;

import java.lang.reflect.Field;

/**
 * 反射
 * <pre>
 * 遍历类，超类的成员变量（类的属性）
 * <pre>
 * 
 * @version Ver1.00
 * @author huoex
 */

public class demo {

	public static void main(String[] args) throws ClassNotFoundException {
//		Object obj = Class.forName("hex.com.test02.reflect02.A");
		A obj = new A();
		
		for (Class<?> clazz = obj.getClass(); clazz != null; clazz = clazz
				.getSuperclass()) {
			Field fs[] = clazz.getDeclaredFields();
			Field afield[];
			int j = (afield = fs).length;
			 for(int i = 0; i < j; i++){
				 Field f = afield[i];
				 System.out.println(f);
			 }
		}
	}
}
