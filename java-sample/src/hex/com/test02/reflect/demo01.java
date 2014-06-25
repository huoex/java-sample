package hex.com.test02.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/*
 * 通过变量获取变量的Getter/Setter方法
 */
public class demo01 {

	public static void main(String[] args) {
		Map<String, Object> insertDataMap = new HashMap<String, Object>();
		AccountEntity entity = new AccountEntity();
		//set value
		entity.setId(001);
		entity.setFirstName("zhang");
		entity.setLastName("san");
		entity.setEmailAddress("zs@mail.com");
		
		Class<?> classType =entity.getClass();
		Field [] fieldList = classType.getDeclaredFields();
		for (Field fld : fieldList) {
//			System.out.println(fld);
			String fieldName = fld.getName();
			Method getMth = getGetter(fld, classType);
//			System.out.println(getMth);
			System.out.println();
			try {
				Object entResult = getMth.invoke(entity, new Object[] {});
				insertDataMap.put(fieldName, entResult);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			
		}
		
		System.out.println("==");
		
	}
	
	/*
	 * 通过变量获取变量的Getter
	 */
	public static Method getGetter(Field field, Class<?> classType) {

		String fieldName = field.getName();
		String stringLetter = fieldName.substring(0, 1).toUpperCase();
		StringBuilder nameBuilder = new StringBuilder("get");
		nameBuilder.append(stringLetter);
		nameBuilder.append(fieldName.substring(1));
		String getterName = nameBuilder.toString();

		Method[] methods = classType.getMethods();
		for (Method method : methods) {
			if (getterName.equals(method.getName())
					&& 0 == method.getParameterTypes().length
					&& method.getReturnType().equals(field.getType())) {
				return method;
			}
		}
		return null;
	}
	
}
