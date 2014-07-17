package hex.com.test06.sort1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * c优先，其他按顺序排序
 * @author hex
 *
 */
public class demo {

	public static void main(String[] args) {

		List<String> list = new ArrayList<String>();
		
		list.add("e");
		list.add("a");
		list.add("d");
		list.add("c");
		list.add("b");
		
		Collections.sort(list, new StrComparator());
		
//		Collections.sort(list, new Comparator<String>() {
//
//			public int compare(String o1, String o2) {
//				if(o1.equalsIgnoreCase("c")){
//					return -1;
//				}else if(o2.equals("c")){
//					return 1;
//				}else{
//					return o1.compareTo(o2);
//				}
//			}
//
//		});
		
		for(String item: list){
			System.out.println(item);
		}
	}

}

class StrComparator implements Comparator<String> {

	public int compare(String o1, String o2) {
		if(o1.equalsIgnoreCase("c")){
			return -1;
		}else if(o2.equals("c")){
			return 1;
		}else{
			return o1.compareTo(o2);
		}
	}

}
