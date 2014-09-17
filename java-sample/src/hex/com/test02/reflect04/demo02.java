package hex.com.test02.reflect04;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class demo02 {
	public static void main(String[] args) throws Exception {

		// Get class object by using static method Class.forName()
		Class<?> c = Class.forName("hex.com.test02.reflect04.Employee");

		// Get package name
		System.out.println("Package name: " + c.getPackage());

		// Get canonical name
		System.out.println("Canonical name: " + c.getCanonicalName());

		// Get declared methods and it parameter types
		System.out.println("---- Methods and parameters ----");
		Method[] methods = c.getDeclaredMethods();
		for (Method m : methods) {
			System.out.println("--" + m.getName() + "--");
			Class<?>[] params = m.getParameterTypes();
			for (Class<?> p : params) {
				System.out.println(p.getName());
			}
		}

		// Get class modifiers
		int modifier = c.getModifiers();
		System.out.println("---- Modifiers ----");
		System.out.println(Modifier.toString(modifier));

		// Get class declared members
		Field[] fields = c.getDeclaredFields();
		System.out.println("---- Fields, names and types ----");
		for (Field f : fields) {
			Class<?> t = f.getType();
			System.out.println(f.getName() + " " + t.getName());
		}

		// Get constructors
		Constructor<?>[] constructors = c.getDeclaredConstructors();
		System.out.println("---- Constructors ----");
		for (Constructor<?> cons : constructors) {
			System.out.println(cons.getName());
		}

		// Get Annotations
		Annotation[] annotations = c.getDeclaredAnnotations();
		System.out.println("---- Annotations ----");
		for (Annotation a : annotations) {
			System.out.println(a.toString());
		}

		// Invoke a method
		Employee e = new Employee();
		Method method = e.getClass().getMethod("setId", int.class);
		method.invoke(e, 20);
		System.out.println(e.getId());
	}
}
