package hex.com.test02.reflect03;

public class A {
	private A() {
		System.out.println("A's constructor is called.");
	}

	private A(int a, int b) {
		System.out.println("a:" + a + " b:" + b);
	}
}