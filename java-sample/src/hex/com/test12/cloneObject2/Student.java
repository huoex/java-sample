package hex.com.test12.cloneObject2;

/**
 * 引用类型多，复杂的时候这种方式不可取。
 * @author Administrator
 *
 */
class Student implements Cloneable {
	String name;// 基本数据类型
	int age;
	Professor p;// 引用类型

	Student(String name, int age, Professor p) {
		this.name = name;
		this.age = age;
		this.p = p;
	}

	public Object clone() {
		Student o = null;
		try {
			o = (Student) super.clone();
		} catch (CloneNotSupportedException e) {
			System.out.println(e.toString());
		}
		o.p = (Professor) p.clone();
		return o;
	}

	public static void main(String[] args) {
		Professor p = new Professor("wangwu", 50);
		Student s1 = new Student("zhangsan", 18, p);
		Student s2 = (Student) s1.clone();
		s2.p.name = "lisi";
		s2.p.age = 30;
		System.out.println("name=" + s1.p.name + "," + "age=" + s1.p.age);
	}

}