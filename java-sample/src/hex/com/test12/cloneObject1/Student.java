package hex.com.test12.cloneObject1;

class Student implements Cloneable {
	String name;
	int age;

	Student(String name, int age) {
		this.name = name;
		this.age = age;
	}

	/**
	 * 重写java.lang.Object类的clone()方法是浅复制(复制基本类型)
	 */
	public Object clone() {
		Object o = null;
		try {
			o = super.clone();
		} catch (CloneNotSupportedException e) {
			System.out.println(e.toString());
		}
		return o;
	}
}