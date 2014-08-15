package hex.com.test15.This;
/**
 * this表示的是对当前对象的引用
 * @author Administrator
 *
 */
public class Client {  
	@SuppressWarnings("unused") 
	public static void main(String[] args) {
		// 子类实例化会把实例传到父类中
		// 因此在调用父类的构造方法时，this是子类的对象引用
        B b = new B();  
    }  
}  