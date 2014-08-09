package hex.com.test12.cloneObject2;

class Professor implements Cloneable {
	String name;
	int age;

	Professor(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public Object clone() {
		Object o = null;
		try {
			o = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return o;
	}
}