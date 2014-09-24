package hex.com.test02.reflect04;

public class demo01 {
	@SuppressWarnings("unused")
	public static void main(String[] args) throws Exception {
		  
		  // Get class object using an Employee object
		  Employee e = new Employee(10, "Name");
		  Class<?> c1 = e.getClass(); 
		  
		  // Get class object using .class to the name of type
		  Class<?> c2 = Employee.class;
		  
		  // Get class object by using static method Class.forName()
		  Class<?> c = Class.forName("hex.com.test02.reflect04.Employee");
		}
}
