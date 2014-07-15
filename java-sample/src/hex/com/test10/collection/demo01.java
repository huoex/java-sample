package hex.com.test10.collection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 *	遍历List的几种方法
 *<pre>
 *	1,迭代器
 *	2,for-each
 *	3,下标
 *	4,数组
 *<pre>
 *@version 1.00 
 *@author huoex
 */
public class demo01 {
	public static void main(String[] args) {
		List<String> ls = new ArrayList<String>();
		ls.add("a0");
		ls.add("a1");
		ls.add("a2");
		ls.add("a3");
		
		// 迭代器
		System.out.println("***迭代器***");
		Iterator<String> ite =ls.iterator();
		for(;ite.hasNext();){
			System.out.println(ite.next());
		}
		
		// for-each
		System.out.println("***for-each***");
		for(Object o:ls){
			System.out.println(o);
		}
		
		// 下标
		System.out.println("***下标***");
		for(int i=0;i<ls.size();i++){
			System.out.println(ls.get(i));
			
		}
		
		// 数组
		System.out.println("***数组***");
		Object o[];
		o=ls.toArray();
		for(int i=0;i<o.length;i++){
			System.out.println(o[i]);
		}
	}
}
