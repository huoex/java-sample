package hex.com.test11.injection;

/**
 * 通过依赖注入，调用b.print方法
 * @author hex
 *
 */
public class A {
	bean b;
	public void call(){
		b.print();
	}
}
