package hex.com.test08.Annotation;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class demo01 {
	public static void main(String[] args) {
		Field fs[] = AnnotationTest2.class.getDeclaredFields();
        Field afield[];
        int j = (afield = fs).length;
        for(int i = 0; i < j; i++)
        {
            Field f = afield[i];
            System.out.println(f);
        }
        
        Method ms[] = AnnotationTest2.class.getDeclaredMethods();
        Method amethod[];
        int x = (amethod = ms).length;
        for(int i = 0; i < x; i++)
        {
        	Method m = amethod[i];
            System.out.println(m);
				try {
					m.invoke(AnnotationTest2.class.newInstance());
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        }
	}
}
