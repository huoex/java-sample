package hex.com.test12.cloneSerializable;

public class Employee extends SerialCloneable{
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private double salary;
	public String getName() {
		return name;
	}
	public Employee(String name, double salary) {
		super();
		this.name = name;
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + "]";
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
}
