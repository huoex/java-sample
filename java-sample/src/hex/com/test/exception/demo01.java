package hex.com.test.exception;

public class demo01 {
	public static void main(String[] args) {
//		testException1();
//		testException2();
//		testException3();
//		testException4();
//		testException5();
		testException6("abc");
	}
	
	/**
	 * Exception in thread "main" java.lang.ArithmeticException: / by zero
	 * 
	 */
	public static void testException1(){
		System.out.println(1/0);
	}

	/**
	 * Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 4
	 * 
	 */
	public static void testException2(){
		int[] ints = new int[] { 1, 2, 3, 4 };
		System.out.println("异常出现前");
		System.out.println(ints[4]);
		System.out.println("我还有幸执行到吗");// 发生异常以后，后面的代码不能被执行
		System.out.println("异常出现后");
	}
	

	public static void testException3() {
		int[] ints = new int[] { 1, 2, 3, 4 };
		System.out.println("异常出现前");
		try {
			System.out.println(ints[4]);
			System.out.println("我还有幸执行到吗");// 发生异常以后，后面的代码不能被执行
		} catch (IndexOutOfBoundsException e) {
			System.out.println("数组越界错误");
		}
		System.out.println("异常出现后");
	}
	
	/**
	 * 不try catch，或throws也不报错
	 * 
	 */
	public static void testException4() throws myruntimeexception{
		
	}
	
	/**
	 * 强制try catch，或throws
	 * 
	 */
	public static void testException5() throws myexception{
		
	}
	
	/**
	 * try catch，runtimeexception
	 * 
	 */
	public static void testException6(String parm1){
		if(!parm1.equals("null")){
			throw new myruntimeexception("parm is not null");
		}
	}
}
