package hex.com.test07.ThreadLocal;

public class B {
	
	String name;
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public void bcall(){
		System.out.println("bcall");
	}

	@Override
	public String toString() {
		return "B [name=" + name + "]";
	}
}
