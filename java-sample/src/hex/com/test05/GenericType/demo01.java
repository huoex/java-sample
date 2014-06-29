package hex.com.test05.GenericType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class demo01 {
	public static void main(String[] args) {
		generateDataList();

	}

	public static List<? extends Map<String, ?>> generateDataList() {
		ArrayList<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("user01", 001);
		map.put("user02", 002);
		map.put("user03", 003);
		list.add(map);
		return list;
	}
	
	public static void tt(){
		
	}
	
}
