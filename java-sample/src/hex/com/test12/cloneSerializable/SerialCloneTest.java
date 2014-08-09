package hex.com.test12.cloneSerializable;

public class SerialCloneTest {

	public static void main(String[] args) {
		Employee e = new Employee("wang",30);
		// clone e
		Employee e2 = (Employee) e.Clone();
		e2.setName("zhang");
		e2.setSalary(20);
		
		System.out.println(e.toString());
		System.out.println(e2.toString());
	}
}
