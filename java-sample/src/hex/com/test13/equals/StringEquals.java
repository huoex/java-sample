package hex.com.test13.equals;

/**
 * String与常量池
 * @author Administrator
 *
 */
public class StringEquals {
	
	public static void main(String[] args) {
		
		// "aa" 本身就是一个String对象。
		// s1分配在栈里，s1直接指向字符池里的"aa"
		String s1 ="aa";
		// s2分配在栈里，s2直接指向字符池里的"aa"
		String s2 = "aa";
		// s3指向堆里的一块内存，这个内存里的地址指向字符池里的"aa";
		String s3 = new String("aa");
		// s4指向堆里的一块内存，这个内存里的地址指向字符池里的"aa";
		String s4 = new String("aa");
		
		
		// 
		if(s1==s2){
			System.out.println("s1==s2");
		}
		if(s1.equals(s2)){
			System.out.println("s1.equals(s2)");
		}

		if(s3==s4){
			System.out.println("s3==s4");
		}
		if(s3.equals(s4)){
			System.out.println("s3.equals(s4)");
		}
	}
}
